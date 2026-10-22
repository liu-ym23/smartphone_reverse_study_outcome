package com.android.server.location.contexthub;

import android.hardware.contexthub.IEndpointCommunication;
import android.hardware.contexthub.Message;
import android.hardware.location.IContextHubTransactionCallback;
import android.hardware.location.NanoAppBinary;
import android.hardware.location.NanoAppMessage;
import android.hardware.location.NanoAppState;
import android.os.SystemClock;
import android.util.Log;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class ContextHubTransactionManager {
    protected static final int MAX_PENDING_REQUESTS = 10000;
    protected static final int NUM_TRANSACTION_RECORDS = 20;
    public static final Duration RELIABLE_MESSAGE_DUPLICATE_DETECTION_TIMEOUT = null;
    protected static final int RELIABLE_MESSAGE_MAX_NUM_RETRY = 3;
    protected static final Duration RELIABLE_MESSAGE_MIN_WAIT_TIME = null;
    protected static final Duration RELIABLE_MESSAGE_RETRY_WAIT_TIME = null;
    public static final Duration RELIABLE_MESSAGE_TIMEOUT = null;
    protected static final String TAG = "ContextHubTransactionManager";
    protected final ContextHubClientManager mClientManager;
    protected final IContextHubWrapper mContextHubProxy;
    protected final ScheduledThreadPoolExecutor mExecutor;
    protected final NanoAppStateManager mNanoAppStateManager;
    protected final AtomicInteger mNextAvailableId;
    protected final AtomicInteger mNextAvailableMessageSequenceNumber;
    protected final Object mReliableMessageLock;
    protected final Set<Long> mReliableMessageOwnerIdActiveSet;
    protected ScheduledFuture<?> mReliableMessageTransactionFuture;
    protected final Map<Integer, ContextHubServiceTransaction> mReliableMessageTransactionMap;
    protected ScheduledFuture<?> mTimeoutFuture;
    protected final Object mTransactionLock;
    protected final ArrayDeque<ContextHubServiceTransaction> mTransactionQueue;
    protected final ConcurrentLinkedEvictingDeque<TransactionRecord> mTransactionRecordDeque;
    protected final Object mTransactionRecordLock;

    interface TransactionAcceptConditions {
        boolean acceptTransaction(ContextHubServiceTransaction r1);
    }

    protected static class TransactionRecord {
        protected final long mTimestamp;
        protected final String mTransaction;

        TransactionRecord(String transaction) {
            this.mTransaction = transaction;
            this.mTimestamp = System.currentTimeMillis();
        }

        public String toString() {
            return ContextHubServiceUtil.formatDateFromTimestamp(this.mTimestamp) + " " + this.mTransaction;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-_A7-jtJBtX07WeEVw72q-7mQ3A, reason: not valid java name */
    public static /* synthetic */ boolean m5198$r8$lambda$_A7jtJBtX07WeEVw72q7mQ3A(int r0, ContextHubServiceTransaction r1) {
        return lambda$onTransactionResponse$1(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$VCtIJd9AwzrlEFOMQPzWpR6W608(ContextHubServiceTransaction r0) {
        return lambda$onQueryResponse$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$aEW6drgJ5EWH2teMhDONsGv4Eqw(ContextHubTransactionManager r0, ContextHubServiceTransaction r1) {
        r0.lambda$startNextTransaction$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$muHpBO48upzzZqSvwsT2GaQA1D0(ContextHubTransactionManager r0) {
        r0.lambda$processMessageTransactions$6();
    }

    /* JADX INFO: renamed from: $r8$lambda$tjjTCHBW_xG1agdQ2-hBcJtOquw, reason: not valid java name */
    public static /* synthetic */ void m5199$r8$lambda$tjjTCHBW_xG1agdQ2hBcJtOquw(ContextHubTransactionManager r0) {
        r0.lambda$addTransaction$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$wnSFTZC-Cn5wbUL1uekoJmeZFPI, reason: not valid java name */
    public static /* synthetic */ void m5200$r8$lambda$wnSFTZCCn5wbUL1uekoJmeZFPI(ContextHubTransactionManager r0) {
        r0.lambda$onMessageDeliveryResponse$3();
    }

    /* JADX INFO: renamed from: -$$Nest$mtoStatsTransactionResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5201$$Nest$mtoStatsTransactionResult(ContextHubTransactionManager r0, int r1) {
        return r0.toStatsTransactionResult(r1);
    }

    static {
        RELIABLE_MESSAGE_TIMEOUT = Duration.ofSeconds(1);
        RELIABLE_MESSAGE_DUPLICATE_DETECTION_TIMEOUT = RELIABLE_MESSAGE_TIMEOUT.multipliedBy(3);
        RELIABLE_MESSAGE_RETRY_WAIT_TIME = Duration.ofMillis(250);
        RELIABLE_MESSAGE_MIN_WAIT_TIME = Duration.ofNanos(1000);
    }

    ContextHubTransactionManager(IContextHubWrapper contextHubProxy, ContextHubClientManager clientManager, NanoAppStateManager nanoAppStateManager) {
        this.mTransactionQueue = new ArrayDeque();
        this.mReliableMessageTransactionMap = new HashMap();
        this.mReliableMessageOwnerIdActiveSet = new HashSet();
        this.mNextAvailableId = new AtomicInteger();
        this.mNextAvailableMessageSequenceNumber = new AtomicInteger(new Random().nextInt(1073741823));
        this.mExecutor = new ScheduledThreadPoolExecutor(2);
        this.mTimeoutFuture = null;
        this.mReliableMessageTransactionFuture = null;
        this.mTransactionRecordDeque = new ConcurrentLinkedEvictingDeque(20);
        this.mTransactionLock = new Object();
        this.mReliableMessageLock = new Object();
        this.mTransactionRecordLock = new Object();
        this.mContextHubProxy = contextHubProxy;
        this.mClientManager = clientManager;
        this.mNanoAppStateManager = nanoAppStateManager;
    }

    ContextHubServiceTransaction createLoadTransaction(final int contextHubId, final NanoAppBinary nanoAppBinary, final IContextHubTransactionCallback onCompleteCallback, final String packageName) {
        final int r2 = this.mNextAvailableId.getAndIncrement();
        final long r4 = nanoAppBinary.getNanoAppId();
        final int r3 = 0;
        return new AnonymousClass1(this, r2, r3, r4, packageName, contextHubId, nanoAppBinary, onCompleteCallback);
    }

    ContextHubServiceTransaction createUnloadTransaction(final int contextHubId, final long nanoAppId, final IContextHubTransactionCallback onCompleteCallback, final String packageName) {
        final int r2 = this.mNextAvailableId.getAndIncrement();
        final int r3 = 1;
        return new AnonymousClass2(this, r2, r3, nanoAppId, packageName, contextHubId, nanoAppId, onCompleteCallback);
    }

    ContextHubServiceTransaction createEnableTransaction(final int contextHubId, final long nanoAppId, final IContextHubTransactionCallback onCompleteCallback, final String packageName) {
        final int r2 = this.mNextAvailableId.getAndIncrement();
        final int r3 = 2;
        return new AnonymousClass3(this, r2, r3, packageName, contextHubId, nanoAppId, onCompleteCallback);
    }

    ContextHubServiceTransaction createDisableTransaction(final int contextHubId, final long nanoAppId, final IContextHubTransactionCallback onCompleteCallback, final String packageName) {
        final int r2 = this.mNextAvailableId.getAndIncrement();
        final int r3 = 3;
        return new AnonymousClass4(this, r2, r3, packageName, contextHubId, nanoAppId, onCompleteCallback);
    }

    ContextHubServiceTransaction createMessageTransaction(final short ownerId, final int contextHubId, final NanoAppMessage message, final IContextHubTransactionCallback transactionCallback, final String packageName) {
        final int r2 = this.mNextAvailableId.getAndIncrement();
        final int r5 = this.mNextAvailableMessageSequenceNumber.getAndIncrement();
        final int r3 = 5;
        return new AnonymousClass5(this, r2, r3, packageName, r5, ownerId, message, ownerId, contextHubId, transactionCallback);
    }

    ContextHubServiceTransaction createSessionMessageTransaction(final IEndpointCommunication hubInterface, final int sessionId, final Message message, final String packageName, final IContextHubTransactionCallback transactionCallback) {
        final int r2 = this.mNextAvailableId.getAndIncrement();
        final int r5 = this.mNextAvailableMessageSequenceNumber.getAndIncrement();
        final int r3 = 7;
        return new AnonymousClass6(this, r2, r3, packageName, r5, sessionId, message, hubInterface, sessionId, transactionCallback);
    }

    ContextHubServiceTransaction createQueryTransaction(final int contextHubId, final IContextHubTransactionCallback onCompleteCallback, final String packageName) {
        final int r2 = this.mNextAvailableId.getAndIncrement();
        final int r3 = 4;
        return new AnonymousClass7(this, r2, r3, packageName, contextHubId, onCompleteCallback);
    }

    void addTransaction(ContextHubServiceTransaction transaction) {
        if (transaction != null) goto L4;
        return;
    L4:
        Object r0 = this.mTransactionRecordLock;
        monitor-enter(r0);
        this.mTransactionRecordDeque.add(new TransactionRecord(transaction.toString()));     // Catch: Throwable -> L48
        monitor-exit(r0);     // Catch: Throwable -> L48
        boolean isEndpointMessage = false;
        if (transaction.getTransactionType() != 5) goto L11;
        boolean r1 = true;
    L12:
        boolean isReliableMessage = r1;
        if (transaction.getTransactionType() != 7) goto L16;
        isEndpointMessage = true;
    L16:
        if (isReliableMessage == true) goto L34;
        if (isEndpointMessage == true) goto L34;
        Object r4 = this.mTransactionLock;
        monitor-enter(r4);
    L26:
        th = move-exception;
        throw th;
    L22:
        if (this.mTransactionQueue.size() >= 10000) goto L31;
        this.mTransactionQueue.add(transaction);     // Catch: Throwable -> L26
        if (this.mTransactionQueue.size() != 1) goto L28;
        startNextTransaction();     // Catch: Throwable -> L26
    L28:
        monitor-exit(r4);     // Catch: Throwable -> L26
        return;
    L31:
        throw new IllegalStateException("Transaction queue is full (capacity = 10000)");     // Catch: Throwable -> L26
    L34:
        Object r3 = this.mReliableMessageLock;
        monitor-enter(r3);
    L42:
        th = move-exception;
        throw th;
    L37:
        if (this.mReliableMessageTransactionMap.size() >= 10000) goto L45;
        this.mReliableMessageTransactionMap.put(Integer.valueOf(transaction.getMessageSequenceNumber()), transaction);     // Catch: Throwable -> L42
        monitor-exit(r3);     // Catch: Throwable -> L42
        this.mExecutor.execute(new ContextHubTransactionManager$$ExternalSyntheticLambda4(this));
        return;
    L45:
        throw new IllegalStateException("Reliable message transaction queue is full (capacity = 10000)");     // Catch: Throwable -> L42
    L11:
        r1 = false;
    L48:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$addTransaction$0() {
        processMessageTransactions();
    }

    int numReliableMessageTransactionPending() {
        Object r0 = this.mReliableMessageLock;
        monitor-enter(r0);
        int r1 = this.mReliableMessageTransactionMap.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void onTransactionResponse(final int transactionId, boolean success) {
        TransactionAcceptConditions conditions = new ContextHubTransactionManager$$ExternalSyntheticLambda1(transactionId);
        ContextHubServiceTransaction transaction = getTransactionAndHandleNext(conditions);
        if (transaction != null) goto L6;
        Log.w(TAG, "Received unexpected transaction response");
        return;
    L6:
        monitor-enter(transaction);
        if (success == false) goto L9;
        int r2 = 0;
    L16:
        transaction.onTransactionComplete(r2);     // Catch: Throwable -> L13
        transaction.setComplete();     // Catch: Throwable -> L13
        monitor-exit(transaction);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L9:
        r2 = 5;
        goto L16
    }

    private static /* synthetic */ boolean lambda$onTransactionResponse$1(int transactionId, ContextHubServiceTransaction transaction) {
        if (transaction.getTransactionId() == transactionId) goto L6;
        Log.w(TAG, "Unexpected transaction: expected " + transactionId + ", received " + transaction.getTransactionId());
        return false;
    L6:
        return true;
    }

    void onMessageDeliveryResponse(int messageSequenceNumber, boolean success) {
        Object r1 = this.mReliableMessageLock;
        monitor-enter(r1);
        ContextHubServiceTransaction transaction = this.mReliableMessageTransactionMap.get(Integer.valueOf(messageSequenceNumber));     // Catch: Throwable -> L9
        if (transaction != null) goto L11;
        Log.w(TAG, "Could not find reliable message transaction with message sequence number = " + messageSequenceNumber);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        removeMessageTransaction(transaction);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (success == false) goto L15;
        int r2 = 0;
    L16:
        completeMessageTransaction(transaction, r2);
        this.mExecutor.execute(new ContextHubTransactionManager$$ExternalSyntheticLambda0(this));
        return;
    L15:
        r2 = 5;
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onMessageDeliveryResponse$2(int messageSequenceNumber, ContextHubServiceTransaction transaction) {
        if (transaction.getTransactionType() == 5) goto L5;
    L7:
        return false;
    L5:
        if (transaction.getMessageSequenceNumber() != messageSequenceNumber) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$onMessageDeliveryResponse$3() {
        processMessageTransactions();
    }

    void onQueryResponse(List<NanoAppState> nanoAppStateList) {
        TransactionAcceptConditions conditions = new ContextHubTransactionManager$$ExternalSyntheticLambda2();
        ContextHubServiceTransaction transaction = getTransactionAndHandleNext(conditions);
        if (transaction != null) goto L6;
        Log.w(TAG, "Received unexpected query response");
        return;
    L6:
        monitor-enter(transaction);
        transaction.onQueryResponse(0, nanoAppStateList);     // Catch: Throwable -> L11
        transaction.setComplete();     // Catch: Throwable -> L11
        monitor-exit(transaction);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$onQueryResponse$4(ContextHubServiceTransaction transaction) {
        if (transaction.getTransactionType() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    void onHubReset() {
        Object r0 = this.mReliableMessageLock;
        monitor-enter(r0);
        Iterator<Map.Entry<Integer, ContextHubServiceTransaction>> iter = this.mReliableMessageTransactionMap.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (iter.hasNext() == false) goto L11;
        removeAndCompleteMessageTransaction(iter.next().getValue(), 5, iter);     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        Object r1 = this.mTransactionLock;
        monitor-enter(r1);
        ContextHubServiceTransaction transaction = this.mTransactionQueue.peek();     // Catch: Throwable -> L18
        if (transaction != null) goto L20;
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L20:
        removeTransactionAndStartNext();     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    private ContextHubServiceTransaction getTransactionAndHandleNext(TransactionAcceptConditions conditions) {
        Object r1 = this.mTransactionLock;
        monitor-enter(r1);
        ContextHubServiceTransaction transaction = this.mTransactionQueue.peek();     // Catch: Throwable -> L10
        if (transaction == null) goto L17;
        if (conditions != null) goto L8;
    L12:
        cancelTimeoutFuture();     // Catch: Throwable -> L10
        this.mTransactionQueue.remove();     // Catch: Throwable -> L10
        if (this.mTransactionQueue.isEmpty() == true) goto L15;
        startNextTransaction();     // Catch: Throwable -> L10
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return transaction;
    L8:
        if (conditions.acceptTransaction(transaction) == true) goto L12;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeTransactionAndStartNext() {
        cancelTimeoutFuture();
        ContextHubServiceTransaction transaction = this.mTransactionQueue.remove();
        monitor-enter(transaction);
        transaction.setComplete();     // Catch: Throwable -> L10
        monitor-exit(transaction);     // Catch: Throwable -> L10
        if (this.mTransactionQueue.isEmpty() == true) goto L15;
        startNextTransaction();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void cancelTimeoutFuture() {
        if (this.mTimeoutFuture == null) goto L6;
        this.mTimeoutFuture.cancel(false);
        this.mTimeoutFuture = null;
        return;
    }

    private void startNextTransaction() {
        int result = 1;
    L3:
        if (result == 0) goto L22;
        if (this.mTransactionQueue.isEmpty() == true) goto L32;
        final ContextHubServiceTransaction transaction = this.mTransactionQueue.peek();
        int result2 = transaction.onTransact();
        if (result2 != 0) goto L14;
        Runnable onTimeoutFunc = new ContextHubTransactionManager$$ExternalSyntheticLambda3(this, transaction);
        long timeoutMs = transaction.getTimeout(TimeUnit.MILLISECONDS);
        this.mTimeoutFuture = this.mExecutor.schedule(onTimeoutFunc, timeoutMs, TimeUnit.MILLISECONDS);     // Catch: Exception -> L11
    L18:
        result = result2;
    L11:
        e = move-exception;
        Log.e(TAG, "Error when schedule a timer", e);
        goto L18
    L14:
        monitor-enter(transaction);
        transaction.onTransactionComplete(ContextHubServiceUtil.toTransactionResult(result2));     // Catch: Throwable -> L19
        transaction.setComplete();     // Catch: Throwable -> L19
        monitor-exit(transaction);     // Catch: Throwable -> L19
        this.mTransactionQueue.remove();
    L19:
        th = move-exception;
        throw th;
    L32:
        return;
    }

    private /* synthetic */ void lambda$startNextTransaction$5(ContextHubServiceTransaction transaction) {
        monitor-enter(transaction);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (transaction.isComplete() == true) goto L8;
        Log.d(TAG, transaction + " timed out");     // Catch: Throwable -> L6
        transaction.onTransactionComplete(6);     // Catch: Throwable -> L6
        transaction.setComplete();     // Catch: Throwable -> L6
    L8:
        monitor-exit(transaction);     // Catch: Throwable -> L6
        Object r0 = this.mTransactionLock;
        monitor-enter(r0);
        removeTransactionAndStartNext();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void processMessageTransactions() {
        Object r2 = this.mReliableMessageLock;
        monitor-enter(r2);
        boolean r3 = false;
        if (this.mReliableMessageTransactionFuture == null) goto L9;
        this.mReliableMessageTransactionFuture.cancel(false);     // Catch: Throwable -> L7
        this.mReliableMessageTransactionFuture = null;     // Catch: Throwable -> L7
    L9:
        long now = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L7
        long nextExecutionTime = Long.MAX_VALUE;
    L10:
        boolean continueProcessing = false;
        Iterator<Map.Entry<Integer, ContextHubServiceTransaction>> iter = this.mReliableMessageTransactionMap.entrySet().iterator();     // Catch: Throwable -> L7
    L12:
        if (iter.hasNext() == false) goto L39;
        ContextHubServiceTransaction transaction = iter.next().getValue();     // Catch: Throwable -> L7
        long ownerId = transaction.getOwnerId();     // Catch: Throwable -> L7
        int numCompletedStartCalls = transaction.getNumCompletedStartCalls();     // Catch: Throwable -> L7
        if (numCompletedStartCalls != 0) goto L18;
        if (this.mReliableMessageOwnerIdActiveSet.contains(Long.valueOf(ownerId)) == true) goto L12;
    L18:
        long nextRetryTime = transaction.getNextRetryTime();     // Catch: Throwable -> L7
        long timeoutTime = transaction.getTimeoutTime();     // Catch: Throwable -> L7
        boolean transactionHitMaxRetries = true;
        if (timeoutTime > now) goto L21;
        boolean transactionTimedOut = true;
    L23:
        if (nextRetryTime <= now) goto L25;
    L27:
        transactionHitMaxRetries = false;
    L28:
        if (transactionTimedOut == true) goto L37;
        if (transactionHitMaxRetries == true) goto L37;
        if (nextRetryTime <= now) goto L34;
        if (numCompletedStartCalls <= 0) goto L34;
    L35:
        now = now;
        nextExecutionTime = Math.min(Math.min(nextExecutionTime, transaction.getNextRetryTime()), transaction.getTimeoutTime());     // Catch: Throwable -> L7
    L38:
        now = now;
        r3 = false;
    L34:
        startMessageTransaction(transaction, now);     // Catch: Throwable -> L7
    L37:
        removeAndCompleteMessageTransaction(transaction, 6, iter);     // Catch: Throwable -> L7
        continueProcessing = true;
        goto L38
    L25:
        if (numCompletedStartCalls <= 3) goto L27;
    L21:
        transactionTimedOut = r3;
        goto L23
    L39:
        long now2 = now;
        if (continueProcessing == false) goto L42;
        now = now2;
        r3 = false;
        goto L10
    L42:
        if (nextExecutionTime >= Long.MAX_VALUE) goto L44;
        this.mReliableMessageTransactionFuture = this.mExecutor.schedule(new ContextHubTransactionManager$$ExternalSyntheticLambda5(this), Math.max(nextExecutionTime - SystemClock.elapsedRealtimeNanos(), RELIABLE_MESSAGE_MIN_WAIT_TIME.toNanos()), TimeUnit.NANOSECONDS);     // Catch: Throwable -> L7
    L44:
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$processMessageTransactions$6() {
        processMessageTransactions();
    }

    private void completeMessageTransaction(ContextHubServiceTransaction transaction, int result) {
        monitor-enter(transaction);
        transaction.onTransactionComplete(result);     // Catch: Throwable -> L7
        transaction.setComplete();     // Catch: Throwable -> L7
        monitor-exit(transaction);     // Catch: Throwable -> L7
        Log.d(TAG, "Successfully completed reliable message transaction with message sequence number = " + transaction.getMessageSequenceNumber() + " and result = " + result);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeAndCompleteMessageTransaction(ContextHubServiceTransaction transaction, int result, Iterator<Map.Entry<Integer, ContextHubServiceTransaction>> iter) {
        removeMessageTransaction(transaction, iter);
        completeMessageTransaction(transaction, result);
    }

    private void removeMessageTransaction(ContextHubServiceTransaction transaction) {
        removeMessageTransaction(transaction, null);
    }

    private void removeMessageTransaction(ContextHubServiceTransaction transaction, Iterator<Map.Entry<Integer, ContextHubServiceTransaction>> iter) {
        if (iter != null) goto L4;
        this.mReliableMessageTransactionMap.remove(Integer.valueOf(transaction.getMessageSequenceNumber()));
    L5:
        this.mReliableMessageOwnerIdActiveSet.remove(Long.valueOf(transaction.getOwnerId()));
        return;
    L4:
        iter.remove();
        goto L5
    }

    private void startMessageTransaction(ContextHubServiceTransaction transaction, long now) {
        int numCompletedStartCalls = transaction.getNumCompletedStartCalls();
        int result = transaction.onTransact();
        if (result != 0) goto L9;
        StringBuilder r3 = new StringBuilder();
        r3.append("Successfully ");
        if (numCompletedStartCalls != 0) goto L7;
        String r4 = "started";
    L8:
        r3.append(r4);
        r3.append(" reliable message transaction with message sequence number = ");
        r3.append(transaction.getMessageSequenceNumber());
        Log.d(TAG, r3.toString());
    L10:
        transaction.setNextRetryTime(RELIABLE_MESSAGE_RETRY_WAIT_TIME.toNanos() + now);
        if (transaction.getTimeoutTime() != Long.MAX_VALUE) goto L13;
        transaction.setTimeoutTime(RELIABLE_MESSAGE_TIMEOUT.toNanos() + now);
    L13:
        transaction.setNumCompletedStartCalls(numCompletedStartCalls + 1);
        this.mReliableMessageOwnerIdActiveSet.add(Long.valueOf(transaction.getOwnerId()));
        return;
    L7:
        r4 = "retried";
        goto L8
    L9:
        Log.w(TAG, "Could not start reliable message transaction with message sequence number = " + transaction.getMessageSequenceNumber() + ", result = " + result);
        goto L10
    }

    private int toStatsTransactionResult(int result) {
        switch(result) {
            case 0: goto L19;
            case 1: goto L3;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L3;
        };
    L3:
        return 1;
    L5:
        return 8;
    L7:
        return 7;
    L9:
        return 6;
    L11:
        return 5;
    L13:
        return 4;
    L15:
        return 3;
    L17:
        return 2;
    L19:
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Object r2 = this.mTransactionLock;
        monitor-enter(r2);
        Iterator<ContextHubServiceTransaction> r3 = this.mTransactionQueue.iterator();     // Catch: Throwable -> L8
    L6:
        if (r3.hasNext() == false) goto L10;
        ContextHubServiceTransaction transaction = r3.next();     // Catch: Throwable -> L8
        sb.append(i);     // Catch: Throwable -> L8
        sb.append(": ");     // Catch: Throwable -> L8
        sb.append(transaction.toString());     // Catch: Throwable -> L8
        sb.append("\n");     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L8
        Object r4 = this.mReliableMessageLock;
        monitor-enter(r4);
        Iterator<ContextHubServiceTransaction> r5 = this.mReliableMessageTransactionMap.values().iterator();     // Catch: Throwable -> L17
    L15:
        if (r5.hasNext() == false) goto L19;
        ContextHubServiceTransaction transaction2 = r5.next();     // Catch: Throwable -> L17
        sb.append(i);     // Catch: Throwable -> L17
        sb.append(": ");     // Catch: Throwable -> L17
        sb.append(transaction2.toString());     // Catch: Throwable -> L17
        sb.append("\n");     // Catch: Throwable -> L17
        i = i + 1;     // Catch: Throwable -> L17
        goto L15
    L19:
        monitor-exit(r4);     // Catch: Throwable -> L17
        Object r6 = this.mTransactionRecordLock;
        monitor-enter(r6);
        sb.append("Transaction History:\n");     // Catch: Throwable -> L26
        Iterator<TransactionRecord> iterator = this.mTransactionRecordDeque.descendingIterator();     // Catch: Throwable -> L26
    L24:
        if (iterator.hasNext() == false) goto L29;
        sb.append(iterator.next());     // Catch: Throwable -> L26
        sb.append("\n");     // Catch: Throwable -> L26
        goto L24
    L29:
        monitor-exit(r6);     // Catch: Throwable -> L26
        return sb.toString();
    L26:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        throw th;
    }
}

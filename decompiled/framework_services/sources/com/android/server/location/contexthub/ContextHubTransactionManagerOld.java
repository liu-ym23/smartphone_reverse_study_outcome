package com.android.server.location.contexthub;

import android.hardware.location.NanoAppState;
import android.os.SystemClock;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class ContextHubTransactionManagerOld extends ContextHubTransactionManager {
    public static /* synthetic */ void $r8$lambda$5NJcrXmSpvxMyCP105oMvngNPtk(ContextHubTransactionManagerOld r0) {
        r0.lambda$processMessageTransactions$3();
    }

    public static /* synthetic */ void $r8$lambda$VmZ6k_7Rl9ocAYbdwuZHgVWVeZ8(ContextHubTransactionManagerOld r0) {
        r0.lambda$addTransaction$0();
    }

    public static /* synthetic */ void $r8$lambda$_3WcriFQoTh3QJXvw1pdtXqGiFM(ContextHubTransactionManagerOld r0, ContextHubServiceTransaction r1) {
        r0.lambda$startNextTransaction$2(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$u1sfPDN-TC04HIRDjRG69yXvrSM, reason: not valid java name */
    public static /* synthetic */ void m5202$r8$lambda$u1sfPDNTC04HIRDjRG69yXvrSM(ContextHubTransactionManagerOld r0) {
        r0.lambda$onMessageDeliveryResponse$1();
    }

    ContextHubTransactionManagerOld(IContextHubWrapper contextHubProxy, ContextHubClientManager clientManager, NanoAppStateManager nanoAppStateManager) {
        super(contextHubProxy, clientManager, nanoAppStateManager);
    }

    @Override // com.android.server.location.contexthub.ContextHubTransactionManager
    synchronized void addTransaction(ContextHubServiceTransaction transaction) throws IllegalStateException {
        monitor-enter(this);
        if (transaction != null) goto L24;
        monitor-exit(this);
        return;
    L24:
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mTransactionQueue.size() >= 10000) goto L21;
        if (this.mReliableMessageTransactionMap.size() >= 10000) goto L21;
        this.mTransactionRecordDeque.add(new ContextHubTransactionManager.TransactionRecord(transaction.toString()));     // Catch: Throwable -> L13
        if (transaction.getTransactionType() != 5) goto L15;
        this.mReliableMessageTransactionMap.put(Integer.valueOf(transaction.getMessageSequenceNumber()), transaction);     // Catch: Throwable -> L13
        this.mExecutor.execute(new ContextHubTransactionManagerOld$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L13
    L18:
        monitor-exit(this);
        return;
    L15:
        this.mTransactionQueue.add(transaction);     // Catch: Throwable -> L13
        if (this.mTransactionQueue.size() != 1) goto L18;
        startNextTransaction();     // Catch: Throwable -> L13
    L21:
        throw new IllegalStateException("Transaction queue is full (capacity = 10000)");     // Catch: Throwable -> L13
    }

    private /* synthetic */ void lambda$addTransaction$0() {
        processMessageTransactions();
    }

    @Override // com.android.server.location.contexthub.ContextHubTransactionManager
    synchronized void onTransactionResponse(int transactionId, boolean success) {
        monitor-enter(this);
        ContextHubServiceTransaction transaction = this.mTransactionQueue.peek();     // Catch: Throwable -> L8
        if (transaction != null) goto L11;
        Log.w("ContextHubTransactionManager", "Received unexpected transaction response (no transaction pending)");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (transaction.getTransactionId() == transactionId) goto L16;
        Log.w("ContextHubTransactionManager", "Received unexpected transaction response (expected ID = " + transaction.getTransactionId() + ", received ID = " + transactionId + ")");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L16:
        if (success == false) goto L18;
        int r1 = 0;
    L19:
        transaction.onTransactionComplete(r1);     // Catch: Throwable -> L8
        removeTransactionAndStartNext();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L18:
        r1 = 5;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.contexthub.ContextHubTransactionManager
    synchronized void onMessageDeliveryResponse(int messageSequenceNumber, boolean success) {
        monitor-enter(this);
        ContextHubServiceTransaction transaction = this.mReliableMessageTransactionMap.get(Integer.valueOf(messageSequenceNumber));     // Catch: Throwable -> L8
        if (transaction != null) goto L11;
        Log.w("ContextHubTransactionManager", "Could not find reliable message transaction with message sequence number = " + messageSequenceNumber);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (success == false) goto L13;
        int r1 = 0;
    L14:
        completeMessageTransaction(transaction, r1);     // Catch: Throwable -> L8
        this.mExecutor.execute(new ContextHubTransactionManagerOld$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L13:
        r1 = 5;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onMessageDeliveryResponse$1() {
        processMessageTransactions();
    }

    @Override // com.android.server.location.contexthub.ContextHubTransactionManager
    synchronized void onQueryResponse(List<NanoAppState> nanoAppStateList) {
        monitor-enter(this);
        ContextHubServiceTransaction transaction = this.mTransactionQueue.peek();     // Catch: Throwable -> L8
        if (transaction != null) goto L11;
        Log.w("ContextHubTransactionManager", "Received unexpected query response (no transaction pending)");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (transaction.getTransactionType() == 4) goto L16;
        Log.w("ContextHubTransactionManager", "Received unexpected query response (expected " + transaction + ")");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L16:
        transaction.onQueryResponse(0, nanoAppStateList);     // Catch: Throwable -> L8
        removeTransactionAndStartNext();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.contexthub.ContextHubTransactionManager
    synchronized void onHubReset() {
        monitor-enter(this);
        Iterator<Map.Entry<Integer, ContextHubServiceTransaction>> iter = this.mReliableMessageTransactionMap.entrySet().iterator();     // Catch: Throwable -> L7
    L5:
        if (iter.hasNext() == false) goto L9;
        completeMessageTransaction(iter.next().getValue(), 5, iter);     // Catch: Throwable -> L7
        goto L5
    L9:
        ContextHubServiceTransaction transaction = this.mTransactionQueue.peek();     // Catch: Throwable -> L7
        if (transaction != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        removeTransactionAndStartNext();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeTransactionAndStartNext() {
        if (this.mTimeoutFuture == null) goto L5;
        this.mTimeoutFuture.cancel(false);
        this.mTimeoutFuture = null;
    L5:
        ContextHubServiceTransaction transaction = this.mTransactionQueue.remove();
        transaction.setComplete();
        if (this.mTransactionQueue.isEmpty() == true) goto L9;
        startNextTransaction();
        return;
    }

    private void startNextTransaction() {
        int result = 1;
    L3:
        if (result == 0) goto L16;
        if (this.mTransactionQueue.isEmpty() == true) goto L27;
        final ContextHubServiceTransaction transaction = this.mTransactionQueue.peek();
        result = transaction.onTransact();
        if (result == 0) goto L8;
        transaction.onTransactionComplete(ContextHubServiceUtil.toTransactionResult(result));
        this.mTransactionQueue.remove();
        goto L3
    L8:
        Runnable onTimeoutFunc = new ContextHubTransactionManagerOld$$ExternalSyntheticLambda0(this, transaction);
        long timeoutMs = transaction.getTimeout(TimeUnit.MILLISECONDS);
        this.mTimeoutFuture = this.mExecutor.schedule(onTimeoutFunc, timeoutMs, TimeUnit.MILLISECONDS);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e("ContextHubTransactionManager", "Error when schedule a timer", e);
        goto L3
    L27:
        return;
    }

    private /* synthetic */ void lambda$startNextTransaction$2(ContextHubServiceTransaction transaction) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (transaction.isComplete() == true) goto L8;
        Log.d("ContextHubTransactionManager", transaction + " timed out");     // Catch: Throwable -> L6
        transaction.onTransactionComplete(6);     // Catch: Throwable -> L6
        removeTransactionAndStartNext();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    private synchronized void processMessageTransactions() {
        monitor-enter(this);
        boolean r2 = false;
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
        r2 = false;
    L34:
        startMessageTransaction(transaction, now);     // Catch: Throwable -> L7
    L37:
        completeMessageTransaction(transaction, 6, iter);     // Catch: Throwable -> L7
        continueProcessing = true;
        goto L38
    L25:
        if (numCompletedStartCalls <= 3) goto L27;
    L21:
        transactionTimedOut = r2;
        goto L23
    L39:
        long now2 = now;
        if (continueProcessing == false) goto L42;
        now = now2;
        r2 = false;
        goto L10
    L42:
        if (nextExecutionTime >= Long.MAX_VALUE) goto L44;
        this.mReliableMessageTransactionFuture = this.mExecutor.schedule(new ContextHubTransactionManagerOld$$ExternalSyntheticLambda2(this), Math.max(nextExecutionTime - SystemClock.elapsedRealtimeNanos(), ContextHubTransactionManager.RELIABLE_MESSAGE_MIN_WAIT_TIME.toNanos()), TimeUnit.NANOSECONDS);     // Catch: Throwable -> L7
    L44:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$processMessageTransactions$3() {
        processMessageTransactions();
    }

    private void completeMessageTransaction(ContextHubServiceTransaction transaction, int result) {
        completeMessageTransaction(transaction, result, null);
    }

    private void completeMessageTransaction(ContextHubServiceTransaction transaction, int result, Iterator<Map.Entry<Integer, ContextHubServiceTransaction>> iter) {
        transaction.onTransactionComplete(result);
        if (iter != null) goto L5;
        this.mReliableMessageTransactionMap.remove(Integer.valueOf(transaction.getMessageSequenceNumber()));
    L6:
        this.mReliableMessageOwnerIdActiveSet.remove(Long.valueOf(transaction.getOwnerId()));
        Log.d("ContextHubTransactionManager", "Successfully completed reliable message transaction with message sequence number = " + transaction.getMessageSequenceNumber() + " and result = " + result);
        return;
    L5:
        iter.remove();
        goto L6
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
        Log.d("ContextHubTransactionManager", r3.toString());
    L10:
        transaction.setNextRetryTime(ContextHubTransactionManager.RELIABLE_MESSAGE_RETRY_WAIT_TIME.toNanos() + now);
        if (transaction.getTimeoutTime() != Long.MAX_VALUE) goto L13;
        transaction.setTimeoutTime(ContextHubTransactionManager.RELIABLE_MESSAGE_TIMEOUT.toNanos() + now);
    L13:
        transaction.setNumCompletedStartCalls(numCompletedStartCalls + 1);
        this.mReliableMessageOwnerIdActiveSet.add(Long.valueOf(transaction.getOwnerId()));
        return;
    L7:
        r4 = "retried";
        goto L8
    L9:
        Log.w("ContextHubTransactionManager", "Could not start reliable message transaction with message sequence number = " + transaction.getMessageSequenceNumber() + ", result = " + result);
        goto L10
    }

    @Override // com.android.server.location.contexthub.ContextHubTransactionManager
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        monitor-enter(this);
        Iterator<ContextHubServiceTransaction> r2 = this.mTransactionQueue.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        ContextHubServiceTransaction transaction = r2.next();     // Catch: Throwable -> L8
        sb.append(i);     // Catch: Throwable -> L8
        sb.append(": ");     // Catch: Throwable -> L8
        sb.append(transaction.toString());     // Catch: Throwable -> L8
        sb.append("\n");     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        Iterator<ContextHubServiceTransaction> r3 = this.mReliableMessageTransactionMap.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L14;
        ContextHubServiceTransaction transaction2 = r3.next();     // Catch: Throwable -> L8
        sb.append(i);     // Catch: Throwable -> L8
        sb.append(": ");     // Catch: Throwable -> L8
        sb.append(transaction2.toString());     // Catch: Throwable -> L8
        sb.append("\n");     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L14:
        sb.append("Transaction History:\n");     // Catch: Throwable -> L8
        Iterator<ContextHubTransactionManager.TransactionRecord> iterator = this.mTransactionRecordDeque.descendingIterator();     // Catch: Throwable -> L8
    L16:
        if (iterator.hasNext() == false) goto L19;
        sb.append(iterator.next());     // Catch: Throwable -> L8
        sb.append("\n");     // Catch: Throwable -> L8
        goto L16
    L19:
        monitor-exit(this);     // Catch: Throwable -> L8
        return sb.toString();
    L8:
        th = move-exception;
        throw th;
    }
}

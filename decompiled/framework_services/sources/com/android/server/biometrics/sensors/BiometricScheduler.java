package com.android.server.biometrics.sensors;

import android.hardware.biometrics.IBiometricService;
import android.hardware.fingerprint.FingerprintSensorPropertiesInternal;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.modules.expresslog.Counter;
import com.android.server.biometrics.sensors.fingerprint.GestureAvailabilityDispatcher;
import com.android.server.job.controllers.JobStatus;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class BiometricScheduler<T, U> {
    protected static final int LOG_NUM_RECENT_OPERATIONS = 50;
    public static final int SENSOR_TYPE_FACE = 1;
    public static final int SENSOR_TYPE_FP_OTHER = 3;
    public static final int SENSOR_TYPE_UDFPS = 2;
    public static final int SENSOR_TYPE_UNKNOWN = 0;
    private final String TAG;
    private final IBiometricService mBiometricService;
    private final ArrayDeque<CrashState> mCrashStates;
    BiometricSchedulerOperation mCurrentOperation;
    private Supplier<Integer> mCurrentUserRetriever;
    private final GestureAvailabilityDispatcher mGestureAvailabilityDispatcher;
    protected final Handler mHandler;
    private final ClientMonitorCallback mInternalCallback;
    final Deque<BiometricSchedulerOperation> mPendingOperations;
    private final List<Integer> mRecentOperations;
    private final int mRecentOperationsLimit;
    private final int mSensorType;
    private StopUserClient<U> mStopUserClient;
    private int mTotalOperationsHandled;
    private UserSwitchProvider<T, U> mUserSwitchProvider;

    /* JADX INFO: renamed from: com.android.server.biometrics.sensors.BiometricScheduler$1, reason: invalid class name */
    class AnonymousClass1 implements ClientMonitorCallback {
        final /* synthetic */ BiometricScheduler this$0;

        public static /* synthetic */ void $r8$lambda$MLgpBX_If9QLQOlZxMbMDpRhir4(AnonymousClass1 r0, BaseClientMonitor r1, boolean r2) {
            r0.lambda$onClientFinished$0(r1, r2);
        }

        AnonymousClass1(BiometricScheduler this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onClientStarted(BaseClientMonitor clientMonitor) {
            Slog.d(BiometricScheduler.m2612$$Nest$fgetTAG(this.this$0), "[Started] " + clientMonitor);
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onClientFinished(final BaseClientMonitor clientMonitor, final boolean success) {
            this.this$0.mHandler.post(new BiometricScheduler$1$$ExternalSyntheticLambda0(this, clientMonitor, success));
        }

        private /* synthetic */ void lambda$onClientFinished$0(BaseClientMonitor clientMonitor, boolean success) {
            if (this.this$0.mCurrentOperation != null) goto L7;
            Slog.e(BiometricScheduler.m2612$$Nest$fgetTAG(this.this$0), "[Finishing] " + clientMonitor + " but current operation is null, success: " + success + ", possible lifecycle bug in clientMonitor implementation?");
            return;
        L7:
            if (this.this$0.mCurrentOperation.isFor(clientMonitor) == true) goto L10;
            Slog.e(BiometricScheduler.m2612$$Nest$fgetTAG(this.this$0), "[Ignoring Finish] " + clientMonitor + " does not match current: " + this.this$0.mCurrentOperation);
            return;
        L10:
            Slog.d(BiometricScheduler.m2612$$Nest$fgetTAG(this.this$0), "[Finishing] " + clientMonitor + ", success: " + success);
            if (BiometricScheduler.m2613$$Nest$fgetmGestureAvailabilityDispatcher(this.this$0) == null) goto L14;
            BiometricScheduler.m2613$$Nest$fgetmGestureAvailabilityDispatcher(this.this$0).markSensorActive(this.this$0.mCurrentOperation.getSensorId(), false);
        L14:
            if (BiometricScheduler.m2614$$Nest$fgetmRecentOperations(this.this$0).size() < BiometricScheduler.m2615$$Nest$fgetmRecentOperationsLimit(this.this$0)) goto L16;
            BiometricScheduler.m2614$$Nest$fgetmRecentOperations(this.this$0).remove(0);
        L16:
            BiometricScheduler.m2614$$Nest$fgetmRecentOperations(this.this$0).add(Integer.valueOf(this.this$0.mCurrentOperation.getProtoEnum()));
            this.this$0.mCurrentOperation = null;
            BiometricScheduler r0 = this.this$0;
            BiometricScheduler.m2618$$Nest$fputmTotalOperationsHandled(r0, BiometricScheduler.m2616$$Nest$fgetmTotalOperationsHandled(r0) + 1);
            this.this$0.checkCurrentUserAndStartNextOperation();
        }
    }

    private static final class CrashState {
        static final int NUM_ENTRIES = 10;
        final String currentOperation;
        final List<String> pendingOperations;
        final String timestamp;

        CrashState(String timestamp, String currentOperation, List<String> pendingOperations) {
            this.timestamp = timestamp;
            this.currentOperation = currentOperation;
            this.pendingOperations = pendingOperations;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.timestamp);
            sb.append(": ");
            sb.append("Current Operation: {");
            sb.append(this.currentOperation);
            sb.append("}");
            sb.append(", Pending Operations(");
            sb.append(this.pendingOperations.size());
            sb.append(")");
            if (this.pendingOperations.isEmpty() == true) goto L5;
            sb.append(": ");
        L5:
            int i = 0;
        L7:
            if (i >= this.pendingOperations.size()) goto L13;
            sb.append(this.pendingOperations.get(i));
            if (i >= (this.pendingOperations.size() - 1)) goto L11;
            sb.append(", ");
        L11:
            i = i + 1;
            goto L7
        L13:
            return sb.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorType {
    }

    private class UserSwitchClientCallback implements ClientMonitorCallback {
        private final BaseClientMonitor mOwner;
        final /* synthetic */ BiometricScheduler this$0;

        public static /* synthetic */ void $r8$lambda$9uToF41kHgR_T4eWN0T0wXyfa5w(UserSwitchClientCallback r0, BaseClientMonitor r1, boolean r2) {
            r0.lambda$onClientFinished$0(r1, r2);
        }

        UserSwitchClientCallback(BiometricScheduler r1, BaseClientMonitor owner) {
            this.this$0 = r1;
            this.mOwner = owner;
        }

        @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
        public void onClientFinished(final BaseClientMonitor clientMonitor, final boolean success) {
            this.this$0.mHandler.post(new BiometricScheduler$UserSwitchClientCallback$$ExternalSyntheticLambda0(this, clientMonitor, success));
        }

        private /* synthetic */ void lambda$onClientFinished$0(BaseClientMonitor clientMonitor, boolean success) {
            Slog.d(BiometricScheduler.m2612$$Nest$fgetTAG(this.this$0), "[Client finished] " + clientMonitor + ", success: " + success);
            if ((clientMonitor instanceof StopUserClient) == false) goto L8;
            if (success == true) goto L6;
            Slog.w(BiometricScheduler.m2612$$Nest$fgetTAG(this.this$0), "StopUserClient failed(), is the HAL stuck? Clearing mStopUserClient");
        L6:
            BiometricScheduler.m2617$$Nest$fputmStopUserClient(this.this$0, null);
        L8:
            if (this.this$0.mCurrentOperation != null) goto L10;
        L12:
            Slog.w(BiometricScheduler.m2612$$Nest$fgetTAG(this.this$0), "operation is already null or different (reset?): " + this.this$0.mCurrentOperation);
        L13:
            this.this$0.checkCurrentUserAndStartNextOperation();
            return;
        L10:
            if (this.this$0.mCurrentOperation.isFor(this.mOwner) == false) goto L12;
            this.this$0.mCurrentOperation = null;
            goto L13
        }
    }

    public static /* synthetic */ void $r8$lambda$Y9DdgY3bpqf4NYe7BhDUYvqEfxg(BiometricScheduler r0, BiometricSchedulerOperation r1) {
        r0.lambda$startWatchdog$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$wVm11dclKtnPJYi662ThtwvPPlI(BiometricScheduler r0, long r1, Consumer r3) {
        r0.lambda$getCurrentClientIfMatches$0(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2612$$Nest$fgetTAG(BiometricScheduler r0) {
        return r0.TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGestureAvailabilityDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ GestureAvailabilityDispatcher m2613$$Nest$fgetmGestureAvailabilityDispatcher(BiometricScheduler r0) {
        return r0.mGestureAvailabilityDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecentOperations, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m2614$$Nest$fgetmRecentOperations(BiometricScheduler r0) {
        return r0.mRecentOperations;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecentOperationsLimit, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2615$$Nest$fgetmRecentOperationsLimit(BiometricScheduler r0) {
        return r0.mRecentOperationsLimit;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTotalOperationsHandled, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2616$$Nest$fgetmTotalOperationsHandled(BiometricScheduler r0) {
        return r0.mTotalOperationsHandled;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStopUserClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2617$$Nest$fputmStopUserClient(BiometricScheduler r0, StopUserClient r1) {
        r0.mStopUserClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTotalOperationsHandled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2618$$Nest$fputmTotalOperationsHandled(BiometricScheduler r0, int r1) {
        r0.mTotalOperationsHandled = r1;
    }

    public BiometricScheduler(Handler handler, int sensorType, GestureAvailabilityDispatcher gestureAvailabilityDispatcher, IBiometricService biometricService, int recentOperationsLimit) {
        this.TAG = "BiometricScheduler@" + this;
        this.mInternalCallback = new AnonymousClass1(this);
        this.mHandler = handler;
        this.mSensorType = sensorType;
        this.mGestureAvailabilityDispatcher = gestureAvailabilityDispatcher;
        this.mPendingOperations = new ArrayDeque();
        this.mBiometricService = biometricService;
        this.mCrashStates = new ArrayDeque();
        this.mRecentOperationsLimit = recentOperationsLimit;
        this.mRecentOperations = new ArrayList();
    }

    public BiometricScheduler(Handler handler, int sensorType, GestureAvailabilityDispatcher gestureAvailabilityDispatcher, IBiometricService biometricService, int recentOperationsLimit, Supplier<Integer> currentUserRetriever, UserSwitchProvider<T, U> userSwitchProvider) {
        this.TAG = "BiometricScheduler@" + this;
        this.mInternalCallback = new AnonymousClass1(this);
        this.mHandler = handler;
        this.mSensorType = sensorType;
        this.mGestureAvailabilityDispatcher = gestureAvailabilityDispatcher;
        this.mPendingOperations = new ArrayDeque();
        this.mBiometricService = biometricService;
        this.mCrashStates = new ArrayDeque();
        this.mRecentOperationsLimit = recentOperationsLimit;
        this.mRecentOperations = new ArrayList();
        this.mCurrentUserRetriever = currentUserRetriever;
        this.mUserSwitchProvider = userSwitchProvider;
    }

    public BiometricScheduler(Handler handler, int sensorType, GestureAvailabilityDispatcher gestureAvailabilityDispatcher, Supplier<Integer> currentUserRetriever, UserSwitchProvider<T, U> userSwitchProvider) {
        this(handler, sensorType, gestureAvailabilityDispatcher, IBiometricService.Stub.asInterface(ServiceManager.getService("biometric")), 50, currentUserRetriever, userSwitchProvider);
    }

    public BiometricScheduler(int sensorType, GestureAvailabilityDispatcher gestureAvailabilityDispatcher) {
        this(new Handler(Looper.getMainLooper()), sensorType, gestureAvailabilityDispatcher, IBiometricService.Stub.asInterface(ServiceManager.getService("biometric")), 50);
    }

    public static int sensorTypeFromFingerprintProperties(FingerprintSensorPropertiesInternal props) {
        if (props.isAnyUdfpsType() == false) goto L6;
        return 2;
    L6:
        return 3;
    }

    public ClientMonitorCallback getInternalCallback() {
        return this.mInternalCallback;
    }

    protected void checkCurrentUserAndStartNextOperation() {
        if (this.mCurrentOperation == null) goto L7;
        Slog.v(this.TAG, "Not idle, current operation: " + this.mCurrentOperation);
        return;
    L7:
        if (this.mPendingOperations.isEmpty() == false) goto L11;
        Slog.d(this.TAG, "No operations, returning to idle");
        return;
    L11:
        if (this.mPendingOperations.isEmpty() == true) goto L19;
        if (this.mPendingOperations.getFirst().getTargetUserId() != 10) goto L19;
        BiometricSchedulerOperation ignoredOperation = this.mPendingOperations.pollFirst();
        if (ignoredOperation == null) goto L11;
        Slog.w(this.TAG, "Ignoring operation for userId=10: " + ignoredOperation);
        ignoredOperation.abort();
    L19:
        if (this.mPendingOperations.isEmpty() == false) goto L22;
        Slog.d(this.TAG, "No operations, returning to idle");
        return;
    L22:
        int currentUserId = this.mCurrentUserRetriever.get().intValue();
        int nextUserId = this.mPendingOperations.getFirst().getTargetUserId();
        if (nextUserId != currentUserId) goto L25;
    L39:
        startNextOperationIfIdle();
        return;
    L25:
        if (this.mPendingOperations.getFirst().isStartUserOperation() == true) goto L39;
        if (currentUserId != (-10000)) goto L33;
        if (this.mUserSwitchProvider == null) goto L33;
        BaseClientMonitor startClient = this.mUserSwitchProvider.getStartUserClient(nextUserId);
        BiometricScheduler<T, U>.UserSwitchClientCallback finishedCallback = new UserSwitchClientCallback(this, startClient);
        Slog.d(this.TAG, "[Starting User] " + startClient);
        this.mCurrentOperation = new BiometricSchedulerOperation(startClient, finishedCallback, 2);
        startClient.start(finishedCallback);
        return;
    L33:
        if (this.mUserSwitchProvider != null) goto L35;
        Slog.e(this.TAG, "Cannot start next operation.");
        return;
    L35:
        if (this.mStopUserClient == null) goto L37;
        Slog.d(this.TAG, "[Waiting for StopUser] " + this.mStopUserClient);
        return;
    L37:
        this.mStopUserClient = this.mUserSwitchProvider.getStopUserClient(currentUserId);
        BiometricScheduler<T, U>.UserSwitchClientCallback finishedCallback2 = new UserSwitchClientCallback(this, this.mStopUserClient);
        Slog.d(this.TAG, "[Stopping User] current: " + currentUserId + ", next: " + nextUserId + ". " + this.mStopUserClient);
        this.mCurrentOperation = new BiometricSchedulerOperation(this.mStopUserClient, finishedCallback2, 2);
        this.mStopUserClient.start(finishedCallback2);
    }

    protected void startNextOperationIfIdle() {
        if (this.mCurrentOperation == null) goto L7;
        Slog.v(this.TAG, "Not idle, current operation: " + this.mCurrentOperation);
        return;
    L7:
        if (this.mPendingOperations.isEmpty() == false) goto L10;
        Slog.d(this.TAG, "No operations, returning to idle");
        return;
    L10:
        this.mCurrentOperation = this.mPendingOperations.poll();
        Slog.d(this.TAG, "[Polled] " + this.mCurrentOperation);
        if (this.mCurrentOperation.isMarkedCanceling() == false) goto L15;
        Slog.d(this.TAG, "[Now Cancelling] " + this.mCurrentOperation);
        this.mCurrentOperation.cancel(this.mHandler, this.mInternalCallback);
        return;
    L15:
        if (this.mCurrentOperation.isAcquisitionOperation() == false) goto L21;
        AcquisitionClient client = (AcquisitionClient) this.mCurrentOperation.getClientMonitor();
        if (client.isAlreadyCancelled() == false) goto L21;
        this.mCurrentOperation.cancel(this.mHandler, this.mInternalCallback);
        return;
    L21:
        if (this.mGestureAvailabilityDispatcher != null) goto L23;
    L25:
        int cookie = this.mCurrentOperation.isReadyToStart(this.mInternalCallback);
        Slog.d(this.TAG, "[Before Starting] " + this.mCurrentOperation + ", cookie: " + cookie);
        if (cookie == 0) goto L28;
        this.mBiometricService.onReadyForAuthentication(this.mCurrentOperation.getClientMonitor().getRequestId(), cookie);     // Catch: RemoteException -> L39
    L41:
        Slog.d(this.TAG, "Waiting for cookie before starting: " + this.mCurrentOperation);
        return;
    L39:
        e = move-exception;
        Slog.e(this.TAG, "Remote exception when contacting BiometricService", e);
        goto L41
    L28:
        if (this.mCurrentOperation.start(this.mInternalCallback) == true) goto L48;
        int pendingOperationsLength = this.mPendingOperations.size();
        BiometricSchedulerOperation lastOperation = this.mPendingOperations.peekLast();
        Slog.e(this.TAG, "[Unable To Start] " + this.mCurrentOperation + ". Last pending operation: " + lastOperation);
        int i = 0;
    L30:
        if (i >= pendingOperationsLength) goto L36;
        BiometricSchedulerOperation operation = this.mPendingOperations.pollFirst();
        if (operation == null) goto L34;
        Slog.w(this.TAG, "[Aborting Operation] " + operation);
        operation.abort();
    L35:
        i = i + 1;
        goto L30
    L34:
        Slog.e(this.TAG, "Null operation, index: " + i + ", expected length: " + pendingOperationsLength);
        goto L35
    L36:
        this.mCurrentOperation = null;
        checkCurrentUserAndStartNextOperation();
        return;
    L48:
        return;
    L23:
        if (this.mCurrentOperation.isAcquisitionOperation() == false) goto L25;
        this.mGestureAvailabilityDispatcher.markSensorActive(this.mCurrentOperation.getSensorId(), true);
        goto L25
    }

    public void startPreparedClient(int cookie) {
        if (this.mCurrentOperation != null) goto L7;
        Slog.e(this.TAG, "Current operation is null");
        return;
    L7:
        if (this.mCurrentOperation.startWithCookie(this.mInternalCallback, cookie) == false) goto L9;
        Slog.d(this.TAG, "[Started] Prepared client: " + this.mCurrentOperation);
        return;
    L9:
        Slog.e(this.TAG, "[Unable To Start] Prepared client: " + this.mCurrentOperation);
        this.mCurrentOperation = null;
        checkCurrentUserAndStartNextOperation();
    }

    public void scheduleClientMonitor(BaseClientMonitor clientMonitor) {
        scheduleClientMonitor(clientMonitor, null);
    }

    public void scheduleClientMonitor(BaseClientMonitor clientMonitor, ClientMonitorCallback clientCallback) {
        if (clientMonitor.interruptsPrecedingClients() == false) goto L11;
        Iterator<BiometricSchedulerOperation> r0 = this.mPendingOperations.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        BiometricSchedulerOperation operation = r0.next();
        if (operation.markCanceling() == false) goto L6;
        Slog.d(this.TAG, "New client, marking pending op as canceling: " + operation);
    L11:
        this.mPendingOperations.add(new BiometricSchedulerOperation(clientMonitor, clientCallback));
        Slog.d(this.TAG, "[Added] " + clientMonitor + ", new queue size: " + this.mPendingOperations.size());
        if (clientMonitor.interruptsPrecedingClients() == true) goto L14;
    L20:
        checkCurrentUserAndStartNextOperation();
        return;
    L14:
        if (this.mCurrentOperation == null) goto L20;
        if (this.mCurrentOperation.isInterruptable() == false) goto L20;
        if (this.mCurrentOperation.isStarted() == false) goto L20;
        Slog.d(this.TAG, "[Cancelling Interruptable]: " + this.mCurrentOperation);
        this.mCurrentOperation.cancel(this.mHandler, this.mInternalCallback);
    }

    public void cancelEnrollment(IBinder token, long requestId) {
        Slog.d(this.TAG, "cancelEnrollment, requestId: " + requestId);
        if (this.mCurrentOperation != null) goto L5;
    L7:
        Iterator<BiometricSchedulerOperation> r0 = this.mPendingOperations.iterator();
    L9:
        if (r0.hasNext() == false) goto L20;
        BiometricSchedulerOperation operation = r0.next();
        if (canCancelEnrollOperation(operation, token, requestId) == false) goto L9;
        Slog.d(this.TAG, "Cancelling pending enrollment op: " + operation);
        operation.markCanceling();
        goto L9
    L20:
        return;
    L5:
        if (canCancelEnrollOperation(this.mCurrentOperation, token, requestId) == false) goto L7;
        Slog.d(this.TAG, "Cancelling enrollment op: " + this.mCurrentOperation);
        this.mCurrentOperation.cancel(this.mHandler, this.mInternalCallback);
    }

    public void cancelAuthenticationOrDetection(IBinder token, long requestId) {
        Slog.d(this.TAG, "cancelAuthenticationOrDetection, requestId: " + requestId);
        if (this.mCurrentOperation != null) goto L5;
    L7:
        Iterator<BiometricSchedulerOperation> r0 = this.mPendingOperations.iterator();
    L9:
        if (r0.hasNext() == false) goto L20;
        BiometricSchedulerOperation operation = r0.next();
        if (canCancelAuthOperation(operation, token, requestId) == false) goto L9;
        Slog.d(this.TAG, "Cancelling pending auth/detect op: " + operation);
        operation.markCanceling();
        goto L9
    L20:
        return;
    L5:
        if (canCancelAuthOperation(this.mCurrentOperation, token, requestId) == false) goto L7;
        Slog.d(this.TAG, "Cancelling auth/detect op: " + this.mCurrentOperation);
        this.mCurrentOperation.cancel(this.mHandler, this.mInternalCallback);
    }

    private static boolean canCancelEnrollOperation(BiometricSchedulerOperation operation, IBinder token, long requestId) {
        if (operation.isEnrollOperation() == true) goto L5;
    L9:
        return false;
    L5:
        if (operation.isMatchingToken(token) == false) goto L9;
        if (operation.isMatchingRequestId(requestId) == false) goto L9;
        return true;
    }

    private static boolean canCancelAuthOperation(BiometricSchedulerOperation operation, IBinder token, long requestId) {
        if (operation.isAuthenticationOrDetectionOperation() == true) goto L5;
    L9:
        return false;
    L5:
        if (operation.isMatchingToken(token) == false) goto L9;
        if (operation.isMatchingRequestId(requestId) == false) goto L9;
        return true;
    }

    @Deprecated
    public BaseClientMonitor getCurrentClient() {
        if (this.mCurrentOperation != null) goto L7;
        return null;
    L7:
        return this.mCurrentOperation.getClientMonitor();
    }

    @Deprecated
    public void getCurrentClientIfMatches(final long requestId, final Consumer<BaseClientMonitor> clientMonitorConsumer) {
        this.mHandler.post(new BiometricScheduler$$ExternalSyntheticLambda1(this, requestId, clientMonitorConsumer));
    }

    private /* synthetic */ void lambda$getCurrentClientIfMatches$0(long requestId, Consumer clientMonitorConsumer) {
        if (this.mCurrentOperation != null) goto L5;
    L8:
        clientMonitorConsumer.accept(null);
        return;
    L5:
        if (this.mCurrentOperation.isMatchingRequestId(requestId) == false) goto L8;
        clientMonitorConsumer.accept(this.mCurrentOperation.getClientMonitor());
    }

    public int getCurrentPendingCount() {
        return this.mPendingOperations.size();
    }

    public void recordCrashState() {
        if (this.mCrashStates.size() < 10) goto L5;
        this.mCrashStates.removeFirst();
    L5:
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        String timestamp = dateFormat.format(new Date(System.currentTimeMillis()));
        List<String> pendingOperations = new ArrayList();
        Iterator<BiometricSchedulerOperation> r3 = this.mPendingOperations.iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        BiometricSchedulerOperation operation = r3.next();
        pendingOperations.add(operation.toString());
        goto L7
    L10:
        if (this.mCurrentOperation == null) goto L12;
        String r4 = this.mCurrentOperation.toString();
    L13:
        CrashState crashState = new CrashState(timestamp, r4, pendingOperations);
        this.mCrashStates.add(crashState);
        Slog.e(this.TAG, "Recorded crash state: " + crashState.toString());
        return;
    L12:
        r4 = null;
        goto L13
    }

    public void dump(PrintWriter pw) {
        pw.println("Dump of BiometricScheduler " + this.TAG);
        pw.println("Type: " + this.mSensorType);
        pw.println("Current operation: " + this.mCurrentOperation);
        pw.println("Pending operations: " + this.mPendingOperations.size());
        Iterator<BiometricSchedulerOperation> r0 = this.mPendingOperations.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        BiometricSchedulerOperation operation = r0.next();
        pw.println("Pending operation: " + operation);
        goto L4
    L6:
        Iterator<CrashState> r1 = this.mCrashStates.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        CrashState crashState = r1.next();
        pw.println("Crash State " + crashState);
        goto L8
    }

    public byte[] dumpProtoState(boolean clearSchedulerBuffer) {
        ProtoOutputStream proto = new ProtoOutputStream();
        if (this.mCurrentOperation == null) goto L5;
        int r1 = this.mCurrentOperation.getProtoEnum();
    L6:
        proto.write(1159641169921L, r1);
        proto.write(1120986464258L, this.mTotalOperationsHandled);
        if (this.mRecentOperations.isEmpty() == true) goto L13;
        int i = 0;
    L10:
        if (i >= this.mRecentOperations.size()) goto L14;
        proto.write(2259152797699L, this.mRecentOperations.get(i).intValue());
        i = i + 1;
    L14:
        proto.flush();
        if (clearSchedulerBuffer == false) goto L18;
        this.mRecentOperations.clear();
    L18:
        return proto.getBytes();
    L13:
        proto.write(2259152797699L, 0);
        goto L14
    L5:
        r1 = 0;
        goto L6
    }

    public void reset() {
        Slog.d(this.TAG, "Resetting scheduler");
        this.mPendingOperations.clear();
        this.mCurrentOperation = null;
    }

    private void clearScheduler() {
        if (this.mCurrentOperation != null) goto L5;
        return;
    L5:
        Iterator<BiometricSchedulerOperation> r0 = this.mPendingOperations.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        BiometricSchedulerOperation pendingOperation = r0.next();
        Slog.d(this.TAG, "[Watchdog cancelling pending] " + pendingOperation.getClientMonitor());
        pendingOperation.markCancelingForWatchdog();
        goto L7
    L9:
        Slog.d(this.TAG, "[Watchdog cancelling current] " + this.mCurrentOperation.getClientMonitor());
        this.mCurrentOperation.cancel(this.mHandler, getInternalCallback());
    }

    public void startWatchdog() {
        final BiometricSchedulerOperation operation = this.mCurrentOperation;
        if (operation != null) goto L6;
        Slog.e(this.TAG, "Current operation is null,no need to start watchdog");
        return;
    L6:
        this.mHandler.postDelayed(new BiometricScheduler$$ExternalSyntheticLambda0(this, operation), JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private /* synthetic */ void lambda$startWatchdog$1(BiometricSchedulerOperation operation) {
        if (operation == this.mCurrentOperation) goto L5;
        return;
    L5:
        if (operation.isFinished() == true) goto L9;
        Counter.logIncrement("biometric.value_scheduler_watchdog_triggered_count");
        clearScheduler();
        return;
    }

    public void onUserStopped() {
        if (this.mStopUserClient != null) goto L6;
        Slog.e(this.TAG, "Unexpected onUserStopped");
        return;
    L6:
        Slog.d(this.TAG, "[OnUserStopped]: " + this.mStopUserClient);
        this.mStopUserClient.onUserStopped();
        this.mStopUserClient = null;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public StopUserClient<?> getStopUserClient() {
        return this.mStopUserClient;
    }
}

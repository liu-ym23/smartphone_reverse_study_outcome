package com.android.server.biometrics.sensors;

import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.modules.expresslog.Counter;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BiometricSchedulerOperation {
    private static final int CANCEL_WATCHDOG_DELAY_MS = 3000;
    protected static final int STATE_FINISHED = 5;
    protected static final int STATE_STARTED = 2;
    protected static final int STATE_STARTED_CANCELING = 3;
    protected static final int STATE_WAITING_FOR_COOKIE = 4;
    protected static final int STATE_WAITING_IN_QUEUE = 0;
    protected static final int STATE_WAITING_IN_QUEUE_CANCELING = 1;
    protected static final String TAG = "BiometricSchedulerOperation";
    final Runnable mCancelWatchdog;
    private final ClientMonitorCallback mClientCallback;
    private final BaseClientMonitor mClientMonitor;
    private ClientMonitorCallback mOnStartCallback;
    private int mState;

    @Retention(RetentionPolicy.SOURCE)
    protected @interface OperationState {
    }

    /* JADX INFO: renamed from: $r8$lambda$pLN8qPDL5N-O1CjZrHzKFJ0E_uo, reason: not valid java name */
    public static /* synthetic */ void m2619$r8$lambda$pLN8qPDL5NO1CjZrHzKFJ0E_uo(BiometricSchedulerOperation r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClientMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ BaseClientMonitor m2620$$Nest$fgetmClientMonitor(BiometricSchedulerOperation r0) {
        return r0.mClientMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2621$$Nest$fputmState(BiometricSchedulerOperation r0, int r1) {
        r0.mState = r1;
    }

    BiometricSchedulerOperation(BaseClientMonitor clientMonitor, ClientMonitorCallback callback) {
        this(clientMonitor, callback, 0);
    }

    protected BiometricSchedulerOperation(BaseClientMonitor clientMonitor, ClientMonitorCallback callback, int state) {
        this.mClientMonitor = clientMonitor;
        this.mClientCallback = callback;
        this.mState = state;
        this.mCancelWatchdog = new BiometricSchedulerOperation$$ExternalSyntheticLambda0(this);
    }

    private /* synthetic */ void lambda$new$0() {
        if (isFinished() == true) goto L13;
        Slog.e(TAG, "[Watchdog Triggered]: " + this);
        this.mClientMonitor.getListener().onError(this.mClientMonitor.getSensorId(), this.mClientMonitor.getCookie(), 5, 0);     // Catch: RemoteException -> L7
    L9:
        getWrappedCallback(this.mOnStartCallback).onClientFinished(this.mClientMonitor, false);
        return;
    L8:
        Slog.e(TAG, "Remote exception when trying to send error in cancel watchdog.");
        goto L9
    }

    public int isReadyToStart(ClientMonitorCallback callback) {
        if (this.mState != 4) goto L5;
    L9:
        int cookie = this.mClientMonitor.getCookie();
        if (cookie == 0) goto L12;
        this.mState = 4;
        this.mClientMonitor.waitForCookie(getWrappedCallback(callback));
    L12:
        return cookie;
    L5:
        if (this.mState == 0) goto L9;
        return 0;
    }

    public boolean start(ClientMonitorCallback callback) {
        if (errorWhenNoneOf(IMediaProjectionManagerServiceExt.NODE_START, new int[]{0, 4, 1}) == false) goto L7;
        return hasOperationAlreadyStarted();
    L7:
        if (this.mClientMonitor.getCookie() == 0) goto L10;
        Counter.logIncrement("biometric.value_biometric_scheduler_operation_state_error_count");
        Slog.e(TAG, "operation requires cookie");
    L10:
        return doStart(callback);
    }

    public boolean startWithCookie(ClientMonitorCallback callback, int cookie) {
        if (this.mClientMonitor.getCookie() == cookie) goto L7;
        Slog.e(TAG, "Mismatched cookie for operation: " + this + ", received: " + cookie);
        return false;
    L7:
        if (errorWhenNoneOf(IMediaProjectionManagerServiceExt.NODE_START, new int[]{0, 4, 1}) == false) goto L11;
        return hasOperationAlreadyStarted();
    L11:
        return doStart(callback);
    }

    private boolean doStart(ClientMonitorCallback callback) {
        this.mOnStartCallback = callback;
        ClientMonitorCallback cb = getWrappedCallback(callback);
        if (this.mState != 1) goto L10;
        Slog.d(TAG, "Operation marked for cancellation, cancelling now: " + this);
        cb.onClientFinished(this.mClientMonitor, true);
        if ((this.mClientMonitor instanceof ErrorConsumer) == false) goto L7;
        ErrorConsumer errorConsumer = (ErrorConsumer) this.mClientMonitor;
        errorConsumer.onError(5, 0);
    L8:
        return false;
    L7:
        Slog.w(TAG, "monitor cancelled but does not implement ErrorConsumer");
        goto L8
    L10:
        if (isUnstartableHalOperation() == false) goto L13;
        Slog.v(TAG, "unable to start: " + this);
        ((HalClientMonitor) this.mClientMonitor).unableToStart();
        cb.onClientFinished(this.mClientMonitor, false);
        return false;
    L13:
        this.mState = 2;
        this.mClientMonitor.start(cb);
        Slog.v(TAG, "started: " + this);
        return true;
    }

    private boolean hasOperationAlreadyStarted() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void abort() {
        if (errorWhenNoneOf("abort", new int[]{0, 4, 1}) == false) goto L6;
        return;
    L6:
        if (isHalOperation() == false) goto L8;
        ((HalClientMonitor) this.mClientMonitor).unableToStart();
    L8:
        getWrappedCallback().onClientFinished(this.mClientMonitor, false);
        Slog.v(TAG, "Aborted: " + this);
    }

    public boolean markCanceling() {
        if (this.mState == 0) goto L5;
        return false;
    L5:
        if (isInterruptable() == false) goto L10;
        this.mState = 1;
        return true;
    L10:
        return false;
    }

    void markCancelingForWatchdog() {
        this.mState = 1;
    }

    public void cancel(Handler handler, ClientMonitorCallback callback) {
        if (errorWhenOneOf("cancel", new int[]{5}) == false) goto L5;
        return;
    L5:
        int currentState = this.mState;
        if (currentState != 3) goto L9;
        Slog.w(TAG, "Cannot cancel - already invoked for operation: " + this);
        return;
    L9:
        this.mState = 3;
        if (currentState != 0) goto L12;
    L17:
        Slog.d(TAG, "[Cancelling] Current client (without start): " + this.mClientMonitor);
        this.mClientMonitor.cancelWithoutStarting(getWrappedCallback(callback));
    L18:
        handler.postDelayed(this.mCancelWatchdog, BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);
        return;
    L12:
        if (currentState == 1) goto L17;
        if (currentState == 4) goto L17;
        Slog.d(TAG, "[Cancelling] Current client: " + this.mClientMonitor);
        this.mClientMonitor.cancel();
        goto L18
    }

    private ClientMonitorCallback getWrappedCallback() {
        return getWrappedCallback(null);
    }

    private ClientMonitorCallback getWrappedCallback(ClientMonitorCallback callback) {
        ClientMonitorCallback destroyCallback = new AnonymousClass1(this);
        return new ClientMonitorCompositeCallback(new ClientMonitorCallback[]{destroyCallback, callback, this.mClientCallback});
    }

    public int getSensorId() {
        return this.mClientMonitor.getSensorId();
    }

    public int getProtoEnum() {
        return this.mClientMonitor.getProtoEnum();
    }

    public int getTargetUserId() {
        return this.mClientMonitor.getTargetUserId();
    }

    public boolean isFor(BaseClientMonitor clientMonitor) {
        if (this.mClientMonitor != clientMonitor) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInterruptable() {
        return this.mClientMonitor.isInterruptable();
    }

    private boolean isHalOperation() {
        return this.mClientMonitor instanceof HalClientMonitor;
    }

    private boolean isUnstartableHalOperation() {
        if (isHalOperation() == false) goto L8;
        HalClientMonitor<?> client = (HalClientMonitor) this.mClientMonitor;
        if (client.getFreshDaemon() != null) goto L10;
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public boolean isEnrollOperation() {
        return this.mClientMonitor instanceof EnrollClient;
    }

    public boolean isAuthenticateOperation() {
        return this.mClientMonitor instanceof AuthenticationClient;
    }

    public boolean isAuthenticationOrDetectionOperation() {
        boolean isAuthentication = this.mClientMonitor instanceof AuthenticationConsumer;
        boolean isDetection = this.mClientMonitor instanceof DetectionConsumer;
        if (isAuthentication == true) goto L7;
        if (isDetection == true) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isStartUserOperation() {
        return this.mClientMonitor instanceof StartUserClient;
    }

    public boolean isAcquisitionOperation() {
        return this.mClientMonitor instanceof AcquisitionClient;
    }

    public boolean isMatchingRequestId(long requestId) {
        if (this.mClientMonitor.hasRequestId() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.mClientMonitor.getRequestId() == requestId) goto L8;
        return false;
    }

    public boolean isMatchingToken(IBinder token) {
        if (this.mClientMonitor.getToken() != token) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStarted() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCanceling() {
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFinished() {
        if (this.mState != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMarkedCanceling() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Deprecated
    public BaseClientMonitor getClientMonitor() {
        return this.mClientMonitor;
    }

    private boolean errorWhenOneOf(String op, int... states) {
        boolean isError = ArrayUtils.contains(states, this.mState);
        if (isError == false) goto L5;
        Counter.logIncrement("biometric.value_biometric_scheduler_operation_state_error_count");
        String err = op + ": mState must not be " + this.mState;
        Slog.e(TAG, err);
    L5:
        return isError;
    }

    private boolean errorWhenNoneOf(String op, int... states) {
        boolean isError = !ArrayUtils.contains(states, this.mState);
        if (isError == false) goto L5;
        Counter.logIncrement("biometric.value_biometric_scheduler_operation_state_error_count");
        String err = op + ": mState=" + this.mState + " must be one of " + Arrays.toString(states);
        Slog.e(TAG, err);
    L5:
        return isError;
    }

    public String toString() {
        return this.mClientMonitor + ", State: " + this.mState;
    }
}

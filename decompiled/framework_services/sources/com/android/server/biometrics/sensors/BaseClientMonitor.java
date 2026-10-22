package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.IBiometricSensorReceiver;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseClientMonitor implements IBinder.DeathRecipient {
    protected static final boolean DEBUG = true;
    private static final String TAG = "BaseClientMonitor";
    private static int sCount;
    private boolean mAlreadyDone;
    private final BiometricContext mBiometricContext;
    protected ClientMonitorCallback mCallback;
    private final Context mContext;
    private final int mCookie;
    private ClientMonitorCallbackConverter mListener;
    private final BiometricLogger mLogger;
    private final String mOwner;
    private long mRequestId;
    private final int mSensorId;
    private final int mSequentialId;
    private final int mTargetUserId;
    private IBinder mToken;

    public abstract int getProtoEnum();

    static {
        sCount = 0;
    }

    public BaseClientMonitor(Context context, IBinder token, ClientMonitorCallbackConverter listener, int userId, String owner, int cookie, int sensorId, BiometricLogger logger, BiometricContext biometricContext) {
        this.mAlreadyDone = false;
        this.mCallback = new AnonymousClass1(this);
        int r1 = sCount;
        sCount = r1 + 1;
        this.mSequentialId = r1;
        this.mContext = context;
        this.mToken = token;
        this.mRequestId = -1;
        if (listener != null) goto L5;
        ClientMonitorCallbackConverter r2 = new ClientMonitorCallbackConverter(new IBiometricSensorReceiver.Default());
    L6:
        this.mListener = r2;
        this.mTargetUserId = userId;
        this.mOwner = owner;
        this.mCookie = cookie;
        this.mSensorId = sensorId;
        this.mLogger = logger;
        this.mBiometricContext = biometricContext;
        if (token == null) goto L16;
        token.linkToDeath(this, 0);     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "caught remote exception in linkToDeath: ", e);
        return;
    L16:
        return;
    L5:
        r2 = listener;
        goto L6
    }

    public boolean interruptsPrecedingClients() {
        return false;
    }

    public void waitForCookie(ClientMonitorCallback callback) {
        this.mCallback = callback;
    }

    public void start(ClientMonitorCallback callback) {
        this.mCallback = wrapCallbackForStart(callback);
        this.mCallback.onClientStarted(this);
    }

    protected ClientMonitorCallback wrapCallbackForStart(ClientMonitorCallback callback) {
        return callback;
    }

    public void destroy() {
        this.mAlreadyDone = true;
        if (this.mToken == null) goto L12;
        this.mToken.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L6
    L8:
        this.mToken = null;
        return;
    L7:
        Slog.e(TAG, "destroy(): " + this + ":", new Exception("here"));
        goto L8
    }

    void markAlreadyDone() {
        Slog.d(TAG, "marking operation as done: " + this);
        this.mAlreadyDone = true;
    }

    public boolean isAlreadyDone() {
        return this.mAlreadyDone;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        binderDiedInternal(true);
    }

    void binderDiedInternal(boolean clearListener) {
        Slog.e(TAG, "Binder died, operation: " + this);
        if (this.mAlreadyDone == false) goto L7;
        Slog.w(TAG, "Binder died but client is finished, ignoring");
        return;
    L7:
        if (isInterruptable() == false) goto L9;
        Slog.e(TAG, "Binder died, cancelling client");
        cancel();
    L9:
        this.mToken = null;
        if (clearListener == false) goto L13;
        this.mListener = new ClientMonitorCallbackConverter(new IBiometricSensorReceiver.Default());
        return;
    }

    protected boolean isCryptoOperation() {
        return false;
    }

    protected BiometricContext getBiometricContext() {
        return this.mBiometricContext;
    }

    public BiometricLogger getLogger() {
        return this.mLogger;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final String getOwnerString() {
        return this.mOwner;
    }

    protected ClientMonitorCallbackConverter getListener() {
        return this.mListener;
    }

    public int getTargetUserId() {
        return this.mTargetUserId;
    }

    public final IBinder getToken() {
        return this.mToken;
    }

    public int getSensorId() {
        return this.mSensorId;
    }

    public int getCookie() {
        return this.mCookie;
    }

    public long getRequestId() {
        return this.mRequestId;
    }

    public boolean hasRequestId() {
        if (this.mRequestId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected final void setRequestId(long id) {
        if (id <= 0) goto L7;
        this.mRequestId = id;
        return;
    L7:
        throw new IllegalArgumentException("request id must be positive");
    }

    public ClientMonitorCallback getCallback() {
        return this.mCallback;
    }

    public String toString() {
        return "{[" + this.mSequentialId + "] " + getClass().getName() + ", sensorId=" + getSensorId() + ", proto=" + getProtoEnum() + ", owner=" + getOwnerString() + ", cookie=" + getCookie() + ", requestId=" + getRequestId() + ", userId=" + getTargetUserId() + "}";
    }

    public void cancel() {
        cancelWithoutStarting(this.mCallback);
    }

    public void cancelWithoutStarting(ClientMonitorCallback callback) {
        Slog.d(TAG, "cancelWithoutStarting: " + this);
        ClientMonitorCallbackConverter listener = getListener();     // Catch: RemoteException -> L5
        listener.onError(getSensorId(), getCookie(), 5, 0);     // Catch: RemoteException -> L5
    L7:
        callback.onClientFinished(this, true);
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Failed to invoke sendError", e);
        goto L7
    }

    public boolean isInterruptable() {
        return false;
    }
}

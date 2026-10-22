package com.android.server.appfunctions;

import android.app.appfunctions.AppFunctionException;
import android.app.appfunctions.ExecuteAppFunctionAidlRequest;
import android.app.appfunctions.IAppFunctionService;
import android.app.appfunctions.ICancellationCallback;
import android.app.appfunctions.SafeOneTimeExecuteAppFunctionCallback;
import android.content.pm.SigningInfo;
import android.os.SystemClock;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class RunAppFunctionServiceCallback implements RemoteServiceCaller.RunServiceCallCallback<IAppFunctionService> {
    private static final String TAG = null;
    private final SigningInfo mCallerSigningInfo;
    private final ICancellationCallback mCancellationCallback;
    private final ExecuteAppFunctionAidlRequest mRequestInternal;
    private final SafeOneTimeExecuteAppFunctionCallback mSafeExecuteAppFunctionCallback;

    /* JADX INFO: renamed from: -$$Nest$fgetmSafeExecuteAppFunctionCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ SafeOneTimeExecuteAppFunctionCallback m1699$$Nest$fgetmSafeExecuteAppFunctionCallback(RunAppFunctionServiceCallback r0) {
        return r0.mSafeExecuteAppFunctionCallback;
    }

    @Override // com.android.server.appfunctions.RemoteServiceCaller.RunServiceCallCallback
    public /* bridge */ /* synthetic */ void onServiceConnected(IAppFunctionService r1, RemoteServiceCaller.ServiceUsageCompleteListener r2) {
        onServiceConnected2(r1, r2);
    }

    static {
        TAG = RunAppFunctionServiceCallback.class.getSimpleName();
    }

    public RunAppFunctionServiceCallback(ExecuteAppFunctionAidlRequest requestInternal, ICancellationCallback cancellationCallback, SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback, SigningInfo callerSigningInfo) {
        this.mRequestInternal = requestInternal;
        this.mSafeExecuteAppFunctionCallback = safeExecuteAppFunctionCallback;
        this.mCancellationCallback = cancellationCallback;
        this.mCallerSigningInfo = callerSigningInfo;
    }

    /* JADX INFO: renamed from: onServiceConnected, reason: avoid collision after fix types in other method */
    public void onServiceConnected2(IAppFunctionService service, final RemoteServiceCaller.ServiceUsageCompleteListener serviceUsageCompleteListener) {
        this.mSafeExecuteAppFunctionCallback.setExecutionStartTimeAfterBindMillis(SystemClock.elapsedRealtime());     // Catch: Exception -> L8
        service.executeAppFunction(this.mRequestInternal.getClientRequest(), this.mRequestInternal.getCallingPackage(), this.mCallerSigningInfo, this.mCancellationCallback, new AnonymousClass1(this, serviceUsageCompleteListener));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Exception e = e;
    L10:
        this.mSafeExecuteAppFunctionCallback.onError(new AppFunctionException(3000, e.getMessage()));
        serviceUsageCompleteListener.onCompleted();
        return;
    L8:
        e = move-exception;
        e = e;
        goto L10
    }

    @Override // com.android.server.appfunctions.RemoteServiceCaller.RunServiceCallCallback
    public void onFailedToConnect() {
        Slog.e(TAG, "Failed to connect to service");
        this.mSafeExecuteAppFunctionCallback.onError(new AppFunctionException(3000, "Failed to connect to AppFunctionService"));
    }

    @Override // com.android.server.appfunctions.RemoteServiceCaller.RunServiceCallCallback
    public void onCancelled() {
        this.mSafeExecuteAppFunctionCallback.disable();
    }
}

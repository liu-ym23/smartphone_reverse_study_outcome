package com.android.server.appfunctions;

import android.app.appfunctions.ExecuteAppFunctionAidlRequest;
import android.app.appfunctions.ExecuteAppFunctionResponse;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Slog;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class AppFunctionsLoggerWrapper {
    static final int SUCCESS_RESPONSE_CODE = -1;
    private static final String TAG = null;
    private final AppFunctionsLoggerClock mLoggerClock;
    private final Executor mLoggingExecutor;
    private final PackageManager mPackageManager;

    interface AppFunctionsLoggerClock {
        long getCurrentTimeMillis();
    }

    /* JADX INFO: renamed from: $r8$lambda$E-GaZXKbGpv9ACEQx4jBBvQjy0M, reason: not valid java name */
    public static /* synthetic */ void m1688$r8$lambda$EGaZXKbGpv9ACEQx4jBBvQjy0M(AppFunctionsLoggerWrapper r0, int r1, ExecuteAppFunctionAidlRequest r2, int r3, int r4, long r5, long r7) {
        r0.lambda$logAppFunctionsRequestReported$0(r1, r2, r3, r4, r5, r7);
    }

    static {
        TAG = AppFunctionsLoggerWrapper.class.getSimpleName();
    }

    AppFunctionsLoggerWrapper(Context context) {
        this(context.getPackageManager(), AppFunctionExecutors.LOGGING_THREAD_EXECUTOR, new AppFunctionsLoggerWrapper$$ExternalSyntheticLambda1());
    }

    AppFunctionsLoggerWrapper(PackageManager packageManager, Executor executor, AppFunctionsLoggerClock loggerClock) {
        executor.getClass();
        this.mLoggingExecutor = executor;
        packageManager.getClass();
        this.mPackageManager = packageManager;
        this.mLoggerClock = loggerClock;
    }

    void logAppFunctionSuccess(ExecuteAppFunctionAidlRequest request, ExecuteAppFunctionResponse response, int callingUid, long executionStartTimeMillis) {
        logAppFunctionsRequestReported(request, -1, response.getResponseDataSize(), callingUid, executionStartTimeMillis);
    }

    void logAppFunctionError(ExecuteAppFunctionAidlRequest request, int errorCode, int callingUid, long executionStartTimeMillis) {
        logAppFunctionsRequestReported(request, errorCode, 0, callingUid, executionStartTimeMillis);
    }

    private void logAppFunctionsRequestReported(final ExecuteAppFunctionAidlRequest request, final int errorCode, final int responseSizeBytes, final int callingUid, long executionStartTimeMillis) {
        final long e2eRequestLatencyMillis = this.mLoggerClock.getCurrentTimeMillis() - request.getRequestTime();
        if (executionStartTimeMillis <= 0) goto L5;
        final long requestOverheadMillis = executionStartTimeMillis - request.getRequestTime();
    L6:
        this.mLoggingExecutor.execute(new AppFunctionsLoggerWrapper$$ExternalSyntheticLambda0(this, callingUid, request, errorCode, responseSizeBytes, e2eRequestLatencyMillis, requestOverheadMillis));
        return;
    L5:
        requestOverheadMillis = e2eRequestLatencyMillis;
        goto L6
    }

    private /* synthetic */ void lambda$logAppFunctionsRequestReported$0(int callingUid, ExecuteAppFunctionAidlRequest request, int errorCode, int responseSizeBytes, long e2eRequestLatencyMillis, long requestOverheadMillis) {
        AppFunctionsStatsLog.write(998, callingUid, getPackageUid(request.getClientRequest().getTargetPackageName()), errorCode, request.getClientRequest().getRequestDataSize(), responseSizeBytes, e2eRequestLatencyMillis, requestOverheadMillis);
    }

    private int getPackageUid(String packageName) {
        return this.mPackageManager.getPackageUid(packageName, 0);
    L6:
        Slog.e(TAG, "Package uid not found for " + packageName);
        return 0;
    }
}

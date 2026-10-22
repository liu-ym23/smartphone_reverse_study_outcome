package com.android.server.tracing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IMessenger;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.UserHandle;
import android.tracing.ITracingServiceProxy;
import android.tracing.TraceReportParams;
import android.util.Log;
import android.util.LruCache;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.SystemService;
import java.io.IOException;
import java.util.function.Function;

/* JADX INFO: loaded from: classes3.dex */
public class TracingServiceProxy extends SystemService {
    private static final int ENABLED = 1;
    private static final String INTENT_ACTION_NOTIFY_SESSION_STOPPED = "com.android.traceur.NOTIFY_SESSION_STOPPED";
    private static final int MAX_CACHED_REPORTER_SERVICES = 8;
    private static final int MAX_FILE_SIZE_BYTES_TO_PIPE = 1024;
    private static final String NOTIFY_SESSION_ENDED_SETTING = "should_notify_trace_session_ended";
    private static final int REPORT_BEGIN = 1;
    private static final int REPORT_BIND_PERM_INCORRECT = 3;
    private static final int REPORT_SVC_COMM_ERROR = 5;
    private static final int REPORT_SVC_HANDOFF = 2;
    private static final int REPORT_SVC_PERM_MISSING = 4;
    private static final String TAG = "TracingServiceProxy";
    private static final String TRACING_APP_ACTIVITY = "com.android.traceur.StopTraceService";
    private static final String TRACING_APP_PACKAGE_NAME = "com.android.traceur";
    public static final String TRACING_SERVICE_PROXY_BINDER_NAME = "tracing.proxy";
    private final LruCache<ComponentName, ServiceConnector<IMessenger>> mCachedReporterServices;
    private final Context mContext;
    private final PackageManager mPackageManager;
    private boolean mServicePublished;
    private final ITracingServiceProxy.Stub mTracingServiceProxy;

    public static /* synthetic */ void $r8$lambda$3Ehmr8nKnBwdDQZeDapvaoB9Qr8(TraceReportParams r0, Void r1, Throwable r2) {
        lambda$reportTrace$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$UWl-jgaRpJnu7UQT8RDs7iwsZVI, reason: not valid java name */
    public static /* synthetic */ void m8630$r8$lambda$UWljgaRpJnu7UQT8RDs7iwsZVI(TraceReportParams r0, IMessenger r1) {
        lambda$reportTrace$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8631$$Nest$fgetmContext(TracingServiceProxy r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyTraceur, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8632$$Nest$mnotifyTraceur(TracingServiceProxy r0) {
        r0.notifyTraceur();
    }

    /* JADX INFO: renamed from: -$$Nest$mreportTrace, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8633$$Nest$mreportTrace(TracingServiceProxy r0, TraceReportParams r1) {
        r0.reportTrace(r1);
    }

    public TracingServiceProxy(Context context) {
        super(context);
        this.mServicePublished = false;
        this.mTracingServiceProxy = new AnonymousClass1(this);
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mCachedReporterServices = new LruCache(8);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        if (this.mServicePublished == true) goto L6;
        publishBinderService(TRACING_SERVICE_PROXY_BINDER_NAME, this.mTracingServiceProxy);
        this.mServicePublished = true;
        return;
    }

    private void notifyTraceur() {
        Intent intent = new Intent();
        PackageInfo info = this.mPackageManager.getPackageInfo(TRACING_APP_PACKAGE_NAME, 1048576);     // Catch: PackageManager.NameNotFoundException -> L7
        intent.setClassName(info.packageName, TRACING_APP_ACTIVITY);     // Catch: PackageManager.NameNotFoundException -> L7
        intent.setAction(INTENT_ACTION_NOTIFY_SESSION_STOPPED);     // Catch: PackageManager.NameNotFoundException -> L7
        long identity = Binder.clearCallingIdentity();     // Catch: PackageManager.NameNotFoundException -> L7
        this.mContext.startForegroundServiceAsUser(intent, UserHandle.SYSTEM);     // Catch: Throwable -> L9 RuntimeException -> L11
    L5:
        Binder.restoreCallingIdentity(identity);     // Catch: PackageManager.NameNotFoundException -> L7
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Failed to notifyTraceSessionEnded", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: PackageManager.NameNotFoundException -> L7
        throw th;     // Catch: PackageManager.NameNotFoundException -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Failed to locate Traceur", e);
    }

    private void reportTrace(TraceReportParams params) {
        FrameworkStatsLog.write(FrameworkStatsLog.TRACING_SERVICE_REPORT_EVENT, 1, params.uuidLsb, params.uuidMsb);
        ComponentName component = new ComponentName(params.reporterPackageName, params.reporterClassName);
        if (hasBindServicePermission(component) == true) goto L6;
        FrameworkStatsLog.write(FrameworkStatsLog.TRACING_SERVICE_REPORT_EVENT, 3, params.uuidLsb, params.uuidMsb);
        return;
    L6:
        boolean hasDumpPermission = hasPermission(component, "android.permission.DUMP");
        boolean hasUsageStatsPermission = hasPermission(component, "android.permission.PACKAGE_USAGE_STATS");
        if (hasDumpPermission == false) goto L17;
        if (hasUsageStatsPermission == false) goto L17;
        long ident = Binder.clearCallingIdentity();
        reportTrace(getOrCreateReporterService(component), params);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L17:
        FrameworkStatsLog.write(FrameworkStatsLog.TRACING_SERVICE_REPORT_EVENT, 4, params.uuidLsb, params.uuidMsb);
    }

    private void reportTrace(ServiceConnector<IMessenger> reporterService, final TraceReportParams params) {
        reporterService.post(new TracingServiceProxy$$ExternalSyntheticLambda1(params)).whenComplete(new TracingServiceProxy$$ExternalSyntheticLambda2(params));
    }

    private static /* synthetic */ void lambda$reportTrace$0(TraceReportParams params, IMessenger messenger) throws Exception {
        if (params.usePipeForTesting == false) goto L28;
        ParcelFileDescriptor[] pipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor.AutoCloseInputStream i = new ParcelFileDescriptor.AutoCloseInputStream(params.fd);
        ParcelFileDescriptor.AutoCloseOutputStream o = new ParcelFileDescriptor.AutoCloseOutputStream(pipe[1]);     // Catch: Throwable -> L12
        byte[] array = i.readNBytes(1024);     // Catch: Throwable -> L14
        if (array.length == 1024) goto L17;
        o.write(array);     // Catch: Throwable -> L14
        o.close();     // Catch: Throwable -> L12
        i.close();
        params.fd = pipe[0];
        goto L28
    L17:
        throw new IllegalArgumentException("Trace file too large when |usePipeForTesting| is set.");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        o.close();     // Catch: Throwable -> L20
    L36:
        throw th;     // Catch: Throwable -> L12
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        i.close();     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L28:
        Message message = Message.obtain();
        message.what = 1;
        message.obj = params;
        messenger.send(message);
        FrameworkStatsLog.write(FrameworkStatsLog.TRACING_SERVICE_REPORT_EVENT, 2, params.uuidLsb, params.uuidMsb);
    }

    private static /* synthetic */ void lambda$reportTrace$1(TraceReportParams params, Void res, Throwable err) {
        if (err == null) goto L8;
        FrameworkStatsLog.write(FrameworkStatsLog.TRACING_SERVICE_REPORT_EVENT, 5, params.uuidLsb, params.uuidMsb);
        Slog.e(TAG, "Failed to report trace", err);
    L8:
        params.fd.close();     // Catch: IOException -> L6
        return;
    }

    private ServiceConnector<IMessenger> getOrCreateReporterService(ComponentName component) {
        ServiceConnector<IMessenger> connector = this.mCachedReporterServices.get(component);
        if (connector != null) goto L6;
        final Intent intent = new Intent();
        intent.setComponent(component);
        final Context r4 = this.mContext;
        final int r7 = this.mContext.getUser().getIdentifier();
        final Function r8 = new TracingServiceProxy$$ExternalSyntheticLambda0();
        final int r6 = 33;
        ServiceConnector<IMessenger> connector2 = new AnonymousClass2(this, r4, intent, r6, r7, r8);
        this.mCachedReporterServices.put(intent.getComponent(), connector2);
        return connector2;
    L6:
        return connector;
    }

    private boolean hasPermission(ComponentName componentName, String permission) throws SecurityException {
        if (this.mPackageManager.checkPermission(permission, componentName.getPackageName()) == 0) goto L6;
        Slog.e(TAG, "Trace reporting service " + componentName.toShortString() + " does not have " + permission + " permission");
        return false;
    L6:
        return true;
    }

    private boolean hasBindServicePermission(ComponentName componentName) {
        ServiceInfo info = this.mPackageManager.getServiceInfo(componentName, 0);     // Catch: PackageManager.NameNotFoundException -> L10
        if ("android.permission.BIND_TRACE_REPORT_SERVICE".equals(info.permission) == true) goto L8;
        Slog.e(TAG, "Trace reporting service " + componentName.toShortString() + " does not request android.permission.BIND_TRACE_REPORT_SERVICE permission; instead requests " + info.permission);
        return false;
    L8:
        return true;
    L11:
        Slog.e(TAG, "Trace reporting service " + componentName.toShortString() + " does not exist");
        return false;
    }
}

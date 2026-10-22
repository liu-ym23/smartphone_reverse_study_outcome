package com.android.server.print;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.printservice.recommendation.IRecommendationService;
import android.printservice.recommendation.RecommendationInfo;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class RemotePrintServiceRecommendationService {
    private static final String LOG_TAG = "RemotePrintServiceRecS";
    private final Connection mConnection;
    private final Context mContext;
    private boolean mIsBound;
    private final Object mLock;
    private IRecommendationService mService;

    private class Connection implements ServiceConnection {
        private final RemotePrintServiceRecommendationServiceCallbacks mCallbacks;
        final /* synthetic */ RemotePrintServiceRecommendationService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ RemotePrintServiceRecommendationServiceCallbacks m7937$$Nest$fgetmCallbacks(Connection r0) {
            return r0.mCallbacks;
        }

        public Connection(RemotePrintServiceRecommendationService r1, RemotePrintServiceRecommendationServiceCallbacks callbacks) {
            this.this$0 = r1;
            this.mCallbacks = callbacks;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Object r0 = RemotePrintServiceRecommendationService.m7934$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RemotePrintServiceRecommendationService.m7936$$Nest$fputmService(this.this$0, IRecommendationService.Stub.asInterface(service));     // Catch: Throwable -> L7
            RemotePrintServiceRecommendationService.m7935$$Nest$fgetmService(this.this$0).registerCallbacks(new AnonymousClass1(this));     // Catch: Throwable -> L7 RemoteException -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            e = move-exception;
            Log.e(RemotePrintServiceRecommendationService.LOG_TAG, "Could not register callbacks", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.w(RemotePrintServiceRecommendationService.LOG_TAG, "Unexpected termination of connection");
            Object r0 = RemotePrintServiceRecommendationService.m7934$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RemotePrintServiceRecommendationService.m7936$$Nest$fputmService(this.this$0, null);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public interface RemotePrintServiceRecommendationServiceCallbacks {
        void onPrintServiceRecommendationsUpdated(List<RecommendationInfo> r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7933$$Nest$fgetmIsBound(RemotePrintServiceRecommendationService r0) {
        return r0.mIsBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7934$$Nest$fgetmLock(RemotePrintServiceRecommendationService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IRecommendationService m7935$$Nest$fgetmService(RemotePrintServiceRecommendationService r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7936$$Nest$fputmService(RemotePrintServiceRecommendationService r0, IRecommendationService r1) {
        r0.mService = r1;
    }

    private Intent getServiceIntent(UserHandle userHandle) throws Exception {
        List<ResolveInfo> installedServices = this.mContext.getPackageManager().queryIntentServicesAsUser(new Intent("android.printservice.recommendation.RecommendationService"), 268435588, userHandle.getIdentifier());
        if (installedServices.size() != 1) goto L19;
        ResolveInfo installedService = installedServices.get(0);
        ComponentName serviceName = new ComponentName(installedService.serviceInfo.packageName, installedService.serviceInfo.name);
        ApplicationInfo appInfo = this.mContext.getPackageManager().getApplicationInfo(installedService.serviceInfo.packageName, 0);
        if (appInfo == null) goto L17;
        if ((1 & appInfo.flags) == 0) goto L15;
        if ("android.permission.BIND_PRINT_RECOMMENDATION_SERVICE".equals(installedService.serviceInfo.permission) == false) goto L13;
        Intent serviceIntent = new Intent();
        serviceIntent.setComponent(serviceName);
        return serviceIntent;
    L13:
        throw new Exception("Service " + serviceName.flattenToShortString() + " does not require permission android.permission.BIND_PRINT_RECOMMENDATION_SERVICE");
    L15:
        throw new Exception("Service is not part of the system");
    L17:
        throw new Exception("Cannot read appInfo for service");
    L19:
        throw new Exception(installedServices.size() + " instead of exactly one service found");
    }

    RemotePrintServiceRecommendationService(Context context, UserHandle userHandle, RemotePrintServiceRecommendationServiceCallbacks callbacks) {
        this.mLock = new Object();
        this.mContext = context;
        this.mConnection = new Connection(this, callbacks);
        Intent serviceIntent = getServiceIntent(userHandle);     // Catch: Exception -> L15
        Object r1 = this.mLock;     // Catch: Exception -> L15
        monitor-enter(r1);     // Catch: Exception -> L15
        this.mIsBound = this.mContext.bindServiceAsUser(serviceIntent, this.mConnection, AudioFormat.AAC_MAIN, userHandle);     // Catch: Throwable -> L9
        if (this.mIsBound == false) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        throw new Exception("Failed to bind to service " + serviceIntent);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.e(LOG_TAG, "Could not connect to print service recommendation service", e);
    }

    void close() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mService == null) goto L15;
        this.mService.registerCallbacks(null);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        this.mService = null;     // Catch: Throwable -> L9
        goto L15
    L11:
        e = move-exception;
        Log.e(LOG_TAG, "Could not unregister callbacks", e);     // Catch: Throwable -> L9
    L15:
        if (this.mIsBound == false) goto L17;
        this.mContext.unbindService(this.mConnection);     // Catch: Throwable -> L9
        this.mIsBound = false;     // Catch: Throwable -> L9
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    protected void finalize() throws Throwable {
        if (this.mIsBound == false) goto L5;
    L6:
        Log.w(LOG_TAG, "Service still connected on finalize()");
        close();
    L7:
        super.finalize();
        return;
    L5:
        if (this.mService == null) goto L7;
        goto L6
    }
}

package com.android.server.ondeviceintelligence;

import android.app.AppGlobals;
import android.app.ondeviceintelligence.Feature;
import android.app.ondeviceintelligence.IDownloadCallback;
import android.app.ondeviceintelligence.IFeatureCallback;
import android.app.ondeviceintelligence.IFeatureDetailsCallback;
import android.app.ondeviceintelligence.IListFeaturesCallback;
import android.app.ondeviceintelligence.IOnDeviceIntelligenceManager;
import android.app.ondeviceintelligence.IResponseCallback;
import android.app.ondeviceintelligence.IStreamingResponseCallback;
import android.app.ondeviceintelligence.ITokenInfoCallback;
import android.app.ondeviceintelligence.InferenceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.service.ondeviceintelligence.IOnDeviceIntelligenceService;
import android.service.ondeviceintelligence.IOnDeviceSandboxedInferenceService;
import android.service.ondeviceintelligence.IProcessingUpdateStatusCallback;
import android.service.ondeviceintelligence.IRemoteProcessingService;
import android.service.ondeviceintelligence.IRemoteStorageService;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import com.android.internal.R;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.infra.ServiceConnector;
import com.android.internal.os.BackgroundThread;
import com.android.server.LocalManagerRegistry;
import com.android.server.SystemService;
import com.android.server.ondeviceintelligence.callbacks.ListenableDownloadCallback;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class OnDeviceIntelligenceManagerService extends SystemService {
    private static final boolean DEFAULT_SERVICE_ENABLED = true;
    private static final String KEY_SERVICE_ENABLED = "service_enabled";
    private static final long MAX_AGE_MS = 0;
    private static final int MSG_RESET_BROADCAST_KEYS = 1;
    private static final int MSG_RESET_CONFIG_NAMESPACE = 2;
    private static final int MSG_RESET_TEMPORARY_SERVICE = 0;
    private static final String NAMESPACE_ON_DEVICE_INTELLIGENCE = "ondeviceintelligence";
    private static final String SYSTEM_PACKAGE = "android";
    private static final String TAG = null;
    private final Executor broadcastExecutor;
    private final Executor callbackExecutor;
    private String mBroadcastPackageName;
    private final Executor mConfigExecutor;
    private final Context mContext;
    private final InferenceInfoStore mInferenceInfoStore;
    volatile boolean mIsServiceEnabled;
    protected final Object mLock;
    private final Handler mMainHandler;
    private final DeviceConfig.OnPropertiesChangedListener mOnPropertiesChangedListener;
    private RemoteOnDeviceSandboxedInferenceService mRemoteInferenceService;
    private RemoteOnDeviceIntelligenceService mRemoteOnDeviceIntelligenceService;
    private String[] mTemporaryBroadcastKeys;
    private String mTemporaryConfigNamespace;
    private Handler mTemporaryHandler;
    private String[] mTemporaryServiceNames;
    private int remoteInferenceServiceUid;
    private final Executor resourceClosingExecutor;

    /* JADX INFO: renamed from: com.android.server.ondeviceintelligence.OnDeviceIntelligenceManagerService$1, reason: invalid class name */
    class AnonymousClass1 extends IOnDeviceIntelligenceManager.Stub {
        final /* synthetic */ OnDeviceIntelligenceManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$8llU7se9iVRO_76uYsDcRv-ClD0, reason: not valid java name */
        public static /* synthetic */ void m6417$r8$lambda$8llU7se9iVRO_76uYsDcRvClD0(Bundle r0, Void r1, Throwable r2) {
            lambda$requestTokenInfo$7(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$95tliv1qN9lDlB1NXBkiPjvm40I(Bundle r0) {
            lambda$processRequest$11(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$CjdcTD-vh2AUA-TL11DA9-0rl5I, reason: not valid java name */
        public static /* synthetic */ void m6418$r8$lambda$CjdcTDvh2AUATL11DA90rl5I(Bundle r0) {
            lambda$processRequestStreaming$14(r0);
        }

        public static /* synthetic */ CompletableFuture $r8$lambda$Cz9KcwphcbolKIalPJSFoOmuAJQ(AnonymousClass1 r0, int r1, Feature r2, Bundle r3, AndroidFuture r4, ITokenInfoCallback r5, IOnDeviceSandboxedInferenceService r6) {
            return r0.lambda$requestTokenInfo$6(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$GSu8EnvJALignuO5oHH8J0_SO8s(Bundle r0, Void r1, Throwable r2) {
            lambda$processRequestStreaming$13(r0, r1, r2);
        }

        public static /* synthetic */ CompletableFuture $r8$lambda$Ir5CKobz6StUI9Hw2tORJr2dRBI(AnonymousClass1 r0, int r1, Feature r2, IFeatureDetailsCallback r3, IOnDeviceIntelligenceService r4) {
            return r0.lambda$getFeatureDetails$4(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$JFmcS15ENN-3yFsgoKLxYn8eJfo, reason: not valid java name */
        public static /* synthetic */ CompletableFuture m6419$r8$lambda$JFmcS15ENN3yFsgoKLxYn8eJfo(AnonymousClass1 r0, int r1, int r2, IFeatureCallback r3, IOnDeviceIntelligenceService r4) {
            return r0.lambda$getFeature$2(r1, r2, r3, r4);
        }

        public static /* synthetic */ CompletableFuture $r8$lambda$Z6OaHzWupg2NWl7M8tYPfQirW28(AnonymousClass1 r0, int r1, IListFeaturesCallback r2, IOnDeviceIntelligenceService r3) {
            return r0.lambda$listFeatures$3(r1, r2, r3);
        }

        public static /* synthetic */ CompletableFuture $r8$lambda$_kQ3vDq61rdb1os1STZP4AIiYZ4(AnonymousClass1 r0, int r1, Feature r2, Bundle r3, int r4, AndroidFuture r5, AndroidFuture r6, IStreamingResponseCallback r7, IOnDeviceSandboxedInferenceService r8) {
            return r0.lambda$processRequestStreaming$12(r1, r2, r3, r4, r5, r6, r7, r8);
        }

        public static /* synthetic */ CompletableFuture $r8$lambda$q0ZnVkR9_931rJgdT73F384b3ic(AnonymousClass1 r0, RemoteCallback r1, IOnDeviceIntelligenceService r2) {
            return r0.lambda$getVersion$1(r1, r2);
        }

        public static /* synthetic */ CompletableFuture $r8$lambda$rBlnCkxrE6TdCFoYz2bh1NlAfX0(AnonymousClass1 r0, IDownloadCallback r1, int r2, Feature r3, AndroidFuture r4, IOnDeviceIntelligenceService r5) {
            return r0.lambda$requestFeatureDownload$5(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$u9qIHgn7NqH2a8LQ0TQnfS2r23c(Bundle r0, Void r1, Throwable r2) {
            lambda$processRequest$10(r0, r1, r2);
        }

        public static /* synthetic */ CompletableFuture $r8$lambda$xGzjzJJBUllRCKg7TRjK7Ym_goc(AnonymousClass1 r0, int r1, Feature r2, Bundle r3, int r4, AndroidFuture r5, AndroidFuture r6, IResponseCallback r7, IOnDeviceSandboxedInferenceService r8) {
            return r0.lambda$processRequest$9(r1, r2, r3, r4, r5, r6, r7, r8);
        }

        public static /* synthetic */ void $r8$lambda$ysYfaTkLVfJe9DWYBqNll4a9n6o(RemoteCallback r0, AndroidFuture r1, Bundle r2) {
            lambda$getVersion$0(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$zZ-mKFl4Sp1NoCWuZ8mW8M8Opz4, reason: not valid java name */
        public static /* synthetic */ void m6420$r8$lambda$zZmKFl4Sp1NoCWuZ8mW8M8Opz4(Bundle r0) {
            lambda$requestTokenInfo$8(r0);
        }

        AnonymousClass1(OnDeviceIntelligenceManagerService this$0) {
            this.this$0 = this$0;
        }

        public String getRemoteServicePackageName() {
            return this.this$0.getRemoteConfiguredPackageName();
        }

        public List<InferenceInfo> getLatestInferenceInfo(long startTimeEpochMillis) {
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.DUMP", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());
            return OnDeviceIntelligenceManagerService.m6408$$Nest$mgetLatestInferenceInfo(this.this$0, startTimeEpochMillis);
        }

        public void getVersion(final RemoteCallback remoteCallback) {
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal getVersion");
            remoteCallback.getClass();
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");
            remoteCallback.sendResult(null);
            return;
        L6:
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda14(this, remoteCallback));
        }

        private /* synthetic */ CompletableFuture lambda$getVersion$1(final RemoteCallback remoteCallback, IOnDeviceIntelligenceService service) throws Exception {
            final AndroidFuture future = new AndroidFuture();
            service.getVersion(new RemoteCallback(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda5(remoteCallback, future)));
            return future.orTimeout(OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0), TimeUnit.MILLISECONDS);
        }

        private static /* synthetic */ void lambda$getVersion$0(RemoteCallback remoteCallback, AndroidFuture future, Bundle result) {
            remoteCallback.sendResult(result);
            future.complete(null);
        }

        public void getFeature(final int id, final IFeatureCallback featureCallback) throws RemoteException {
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal getFeatures");
            featureCallback.getClass();
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");
            featureCallback.onFailure(100, "OnDeviceIntelligenceManagerService is unavailable", PersistableBundle.EMPTY);
            return;
        L6:
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            final int callerUid = Binder.getCallingUid();
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda4(this, callerUid, id, featureCallback));
        }

        private /* synthetic */ CompletableFuture lambda$getFeature$2(int callerUid, int id, final IFeatureCallback featureCallback, IOnDeviceIntelligenceService service) throws Exception {
            final AndroidFuture future = new AndroidFuture();
            service.getFeature(callerUid, id, new IFeatureCallbackStubC00181(this, featureCallback, future));
            return future.orTimeout(OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0), TimeUnit.MILLISECONDS);
        }

        public void listFeatures(final IListFeaturesCallback listFeaturesCallback) throws RemoteException {
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal getFeatures");
            listFeaturesCallback.getClass();
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");
            listFeaturesCallback.onFailure(100, "OnDeviceIntelligenceManagerService is unavailable", PersistableBundle.EMPTY);
            return;
        L6:
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            final int callerUid = Binder.getCallingUid();
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda3(this, callerUid, listFeaturesCallback));
        }

        private /* synthetic */ CompletableFuture lambda$listFeatures$3(int callerUid, final IListFeaturesCallback listFeaturesCallback, IOnDeviceIntelligenceService service) throws Exception {
            final AndroidFuture future = new AndroidFuture();
            service.listFeatures(callerUid, new AnonymousClass2(this, listFeaturesCallback, future));
            return future.orTimeout(OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0), TimeUnit.MILLISECONDS);
        }

        public void getFeatureDetails(final Feature feature, final IFeatureDetailsCallback featureDetailsCallback) throws RemoteException {
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal getFeatureStatus");
            feature.getClass();
            featureDetailsCallback.getClass();
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");
            featureDetailsCallback.onFailure(100, "OnDeviceIntelligenceManagerService is unavailable", PersistableBundle.EMPTY);
            return;
        L6:
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            final int callerUid = Binder.getCallingUid();
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda10(this, callerUid, feature, featureDetailsCallback));
        }

        private /* synthetic */ CompletableFuture lambda$getFeatureDetails$4(int callerUid, Feature feature, final IFeatureDetailsCallback featureDetailsCallback, IOnDeviceIntelligenceService service) throws Exception {
            final AndroidFuture future = new AndroidFuture();
            service.getFeatureDetails(callerUid, feature, new AnonymousClass3(this, future, featureDetailsCallback));
            return future.orTimeout(OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0), TimeUnit.MILLISECONDS);
        }

        public void requestFeatureDownload(final Feature feature, final AndroidFuture cancellationSignalFuture, final IDownloadCallback downloadCallback) throws RemoteException {
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal requestFeatureDownload");
            feature.getClass();
            downloadCallback.getClass();
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L5;
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");
            downloadCallback.onDownloadFailed(4, "OnDeviceIntelligenceManagerService is unavailable", PersistableBundle.EMPTY);
        L5:
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            final int callerUid = Binder.getCallingUid();
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda6(this, downloadCallback, callerUid, feature, cancellationSignalFuture));
        }

        private /* synthetic */ CompletableFuture lambda$requestFeatureDownload$5(IDownloadCallback downloadCallback, int callerUid, Feature feature, AndroidFuture cancellationSignalFuture, IOnDeviceIntelligenceService service) throws Exception {
            AndroidFuture future = new AndroidFuture();
            ListenableDownloadCallback listenableDownloadCallback = new ListenableDownloadCallback(downloadCallback, OnDeviceIntelligenceManagerService.m6397$$Nest$fgetmMainHandler(this.this$0), future, OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0));
            service.requestFeatureDownload(callerUid, feature, OnDeviceIntelligenceManagerService.m6413$$Nest$mwrapCancellationFuture(this.this$0, cancellationSignalFuture), listenableDownloadCallback);
            return future;
        }

        public void requestTokenInfo(final Feature feature, Bundle request, final AndroidFuture cancellationSignalFuture, final ITokenInfoCallback tokenInfoCallback) throws RemoteException {
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal requestTokenInfo");
            AndroidFuture<Void> result = null;
            feature.getClass();     // Catch: Throwable -> L15
            BundleUtil.sanitizeInferenceParams(request);     // Catch: Throwable -> L15
            tokenInfoCallback.getClass();     // Catch: Throwable -> L15
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());     // Catch: Throwable -> L15
            if (this.this$0.mIsServiceEnabled == false) goto L24;
        L9:
            OnDeviceIntelligenceManagerService.m6404$$Nest$mensureRemoteInferenceServiceInitialized(this.this$0);     // Catch: Throwable -> L15
            final int callerUid = Binder.getCallingUid();     // Catch: Throwable -> L15
            RemoteOnDeviceSandboxedInferenceService r0 = OnDeviceIntelligenceManagerService.m6398$$Nest$fgetmRemoteInferenceService(this.this$0);     // Catch: Throwable -> L15
            final AnonymousClass1 r3 = this;
            final Bundle request2 = request;
            result = r0.postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda11(r3, callerUid, feature, request2, cancellationSignalFuture, tokenInfoCallback));     // Catch: Throwable -> L13
            result.whenCompleteAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda12(request2), OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(r3.this$0));     // Catch: Throwable -> L13
            return;
        L13:
            th = th;
        L17:
            if (result != null) goto L19;
            OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(r3.this$0).execute(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda13(request2));
        L19:
            throw th;
        L24:
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");     // Catch: Throwable -> L7
            tokenInfoCallback.onFailure(100, "OnDeviceIntelligenceManagerService is unavailable", PersistableBundle.EMPTY);     // Catch: Throwable -> L7
        L7:
            th = th;
            r3 = this;
            request2 = request;
        L15:
            th = th;
            r3 = this;
            request2 = request;
            goto L17
        }

        private /* synthetic */ CompletableFuture lambda$requestTokenInfo$6(int callerUid, Feature feature, Bundle request, AndroidFuture cancellationSignalFuture, ITokenInfoCallback tokenInfoCallback, IOnDeviceSandboxedInferenceService service) throws Exception {
            AndroidFuture future = new AndroidFuture();
            service.requestTokenInfo(callerUid, feature, request, OnDeviceIntelligenceManagerService.m6413$$Nest$mwrapCancellationFuture(this.this$0, cancellationSignalFuture), BundleUtil.wrapWithValidation(tokenInfoCallback, future, OnDeviceIntelligenceManagerService.m6396$$Nest$fgetmInferenceInfoStore(this.this$0)));
            return future.orTimeout(OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0), TimeUnit.MILLISECONDS);
        }

        private static /* synthetic */ void lambda$requestTokenInfo$7(Bundle request, Void c, Throwable e) {
            BundleUtil.tryCloseResource(request);
        }

        private static /* synthetic */ void lambda$requestTokenInfo$8(Bundle request) {
            BundleUtil.tryCloseResource(request);
        }

        public void processRequest(final Feature feature, final Bundle request, final int requestType, final AndroidFuture cancellationSignalFuture, final AndroidFuture processingSignalFuture, IResponseCallback responseCallback) throws RemoteException {
            AndroidFuture<Void> result = null;
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal processRequest");     // Catch: Throwable -> L8
            feature.getClass();     // Catch: Throwable -> L8
            BundleUtil.sanitizeInferenceParams(request);     // Catch: Throwable -> L8
            responseCallback.getClass();     // Catch: Throwable -> L8
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());     // Catch: Throwable -> L8
            if (this.this$0.mIsServiceEnabled == false) goto L20;
            final IResponseCallback r8 = responseCallback;
        L13:
            OnDeviceIntelligenceManagerService.m6404$$Nest$mensureRemoteInferenceServiceInitialized(this.this$0);     // Catch: Throwable -> L8
            final int callerUid = Binder.getCallingUid();     // Catch: Throwable -> L8
            result = OnDeviceIntelligenceManagerService.m6398$$Nest$fgetmRemoteInferenceService(this.this$0).postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda7(this, callerUid, feature, request, requestType, cancellationSignalFuture, processingSignalFuture, r8));     // Catch: Throwable -> L8
            result.whenCompleteAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda8(request), OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0));     // Catch: Throwable -> L8
            return;
        L20:
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");     // Catch: Throwable -> L10
            r8 = responseCallback;
            r8.onFailure(15, "OnDeviceIntelligenceManagerService is unavailable", PersistableBundle.EMPTY);     // Catch: Throwable -> L8
        L10:
            th = th;
        L15:
            if (result != null) goto L17;
            OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda9(request));
        L17:
            throw th;
        L8:
            th = th;
            goto L15
        }

        private /* synthetic */ CompletableFuture lambda$processRequest$9(int callerUid, Feature feature, Bundle request, int requestType, AndroidFuture cancellationSignalFuture, AndroidFuture processingSignalFuture, IResponseCallback responseCallback, IOnDeviceSandboxedInferenceService service) throws Exception {
            AndroidFuture future = new AndroidFuture();
            service.processRequest(callerUid, feature, request, requestType, OnDeviceIntelligenceManagerService.m6413$$Nest$mwrapCancellationFuture(this.this$0, cancellationSignalFuture), OnDeviceIntelligenceManagerService.m6414$$Nest$mwrapProcessingFuture(this.this$0, processingSignalFuture), BundleUtil.wrapWithValidation(responseCallback, OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0), future, OnDeviceIntelligenceManagerService.m6396$$Nest$fgetmInferenceInfoStore(this.this$0)));
            return future.orTimeout(OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0), TimeUnit.MILLISECONDS);
        }

        private static /* synthetic */ void lambda$processRequest$10(Bundle request, Void c, Throwable e) {
            BundleUtil.tryCloseResource(request);
        }

        private static /* synthetic */ void lambda$processRequest$11(Bundle request) {
            BundleUtil.tryCloseResource(request);
        }

        public void processRequestStreaming(final Feature feature, final Bundle request, final int requestType, final AndroidFuture cancellationSignalFuture, final AndroidFuture processingSignalFuture, IStreamingResponseCallback streamingCallback) throws RemoteException {
            AndroidFuture<Void> result = null;
            Slog.i(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "OnDeviceIntelligenceManagerInternal processRequestStreaming");     // Catch: Throwable -> L8
            feature.getClass();     // Catch: Throwable -> L8
            BundleUtil.sanitizeInferenceParams(request);     // Catch: Throwable -> L8
            streamingCallback.getClass();     // Catch: Throwable -> L8
            OnDeviceIntelligenceManagerService.m6395$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG());     // Catch: Throwable -> L8
            if (this.this$0.mIsServiceEnabled == false) goto L20;
            final IStreamingResponseCallback r8 = streamingCallback;
        L13:
            OnDeviceIntelligenceManagerService.m6404$$Nest$mensureRemoteInferenceServiceInitialized(this.this$0);     // Catch: Throwable -> L8
            final int callerUid = Binder.getCallingUid();     // Catch: Throwable -> L8
            result = OnDeviceIntelligenceManagerService.m6398$$Nest$fgetmRemoteInferenceService(this.this$0).postAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda0(this, callerUid, feature, request, requestType, cancellationSignalFuture, processingSignalFuture, r8));     // Catch: Throwable -> L8
            result.whenCompleteAsync(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda1(request), OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0));     // Catch: Throwable -> L8
            return;
        L20:
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Service not available");     // Catch: Throwable -> L10
            r8 = streamingCallback;
            r8.onFailure(15, "OnDeviceIntelligenceManagerService is unavailable", PersistableBundle.EMPTY);     // Catch: Throwable -> L8
        L10:
            th = th;
        L15:
            if (result != null) goto L17;
            OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$1$$ExternalSyntheticLambda2(request));
        L17:
            throw th;
        L8:
            th = th;
            goto L15
        }

        private /* synthetic */ CompletableFuture lambda$processRequestStreaming$12(int callerUid, Feature feature, Bundle request, int requestType, AndroidFuture cancellationSignalFuture, AndroidFuture processingSignalFuture, IStreamingResponseCallback streamingCallback, IOnDeviceSandboxedInferenceService service) throws Exception {
            AndroidFuture future = new AndroidFuture();
            service.processRequestStreaming(callerUid, feature, request, requestType, OnDeviceIntelligenceManagerService.m6413$$Nest$mwrapCancellationFuture(this.this$0, cancellationSignalFuture), OnDeviceIntelligenceManagerService.m6414$$Nest$mwrapProcessingFuture(this.this$0, processingSignalFuture), BundleUtil.wrapWithValidation(streamingCallback, OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0), future, OnDeviceIntelligenceManagerService.m6396$$Nest$fgetmInferenceInfoStore(this.this$0)));
            return future.orTimeout(OnDeviceIntelligenceManagerService.m6407$$Nest$mgetIdleTimeoutMs(this.this$0), TimeUnit.MILLISECONDS);
        }

        private static /* synthetic */ void lambda$processRequestStreaming$13(Bundle request, Void c, Throwable e) {
            BundleUtil.tryCloseResource(request);
        }

        private static /* synthetic */ void lambda$processRequestStreaming$14(Bundle request) {
            BundleUtil.tryCloseResource(request);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new OnDeviceIntelligenceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    /* JADX INFO: renamed from: com.android.server.ondeviceintelligence.OnDeviceIntelligenceManagerService$3, reason: invalid class name */
    class AnonymousClass3 extends IRemoteProcessingService.Stub {
        final /* synthetic */ OnDeviceIntelligenceManagerService this$0;

        public static /* synthetic */ void $r8$lambda$0liO7zeuvjmqLhYrRWpcjULQGk8(Bundle r0, Void r1, Throwable r2) {
            lambda$updateProcessingState$1(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$Wlon6htHe7rsUEIsUO0__v3a_2c(Bundle r0, IProcessingUpdateStatusCallback r1, IOnDeviceSandboxedInferenceService r2) {
            lambda$updateProcessingState$0(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$deACNmFtzSDGGfnGERSkdQeb0UE(AnonymousClass3 r0, Bundle r1, IProcessingUpdateStatusCallback r2) {
            r0.lambda$updateProcessingState$3(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$eQBaUkDZa-_o9ghgu7AIjVy1BVk, reason: not valid java name */
        public static /* synthetic */ void m6421$r8$lambda$eQBaUkDZa_o9ghgu7AIjVy1BVk(Bundle r0) {
            lambda$updateProcessingState$2(r0);
        }

        AnonymousClass3(OnDeviceIntelligenceManagerService this$0) {
            this.this$0 = this$0;
        }

        public void updateProcessingState(final Bundle processingState, final IProcessingUpdateStatusCallback callback) {
            OnDeviceIntelligenceManagerService.m6392$$Nest$fgetcallbackExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$3$$ExternalSyntheticLambda3(this, processingState, callback));
        }

        private /* synthetic */ void lambda$updateProcessingState$3(final Bundle processingState, final IProcessingUpdateStatusCallback callback) {
            AndroidFuture<Void> result = null;
            BundleUtil.sanitizeStateParams(processingState);     // Catch: Throwable -> L5
            OnDeviceIntelligenceManagerService.m6404$$Nest$mensureRemoteInferenceServiceInitialized(this.this$0);     // Catch: Throwable -> L5
            result = OnDeviceIntelligenceManagerService.m6398$$Nest$fgetmRemoteInferenceService(this.this$0).post(new OnDeviceIntelligenceManagerService$3$$ExternalSyntheticLambda0(processingState, callback));     // Catch: Throwable -> L5
            result.whenCompleteAsync(new OnDeviceIntelligenceManagerService$3$$ExternalSyntheticLambda1(processingState), OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            if (result != null) goto L8;
            OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$3$$ExternalSyntheticLambda2(processingState));
        L8:
            throw th;
        }

        private static /* synthetic */ void lambda$updateProcessingState$0(Bundle processingState, IProcessingUpdateStatusCallback callback, IOnDeviceSandboxedInferenceService service) throws Exception {
            service.updateProcessingState(processingState, callback);
        }

        private static /* synthetic */ void lambda$updateProcessingState$1(Bundle processingState, Void c, Throwable e) {
            BundleUtil.tryCloseResource(processingState);
        }

        private static /* synthetic */ void lambda$updateProcessingState$2(Bundle processingState) {
            BundleUtil.tryCloseResource(processingState);
        }
    }

    /* JADX INFO: renamed from: com.android.server.ondeviceintelligence.OnDeviceIntelligenceManagerService$4, reason: invalid class name */
    class AnonymousClass4 implements ServiceConnector.ServiceLifecycleCallbacks<IOnDeviceSandboxedInferenceService> {
        final /* synthetic */ OnDeviceIntelligenceManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$1oY0V-GNqZERZCoWXCBKYpZPY3c, reason: not valid java name */
        public static /* synthetic */ void m6422$r8$lambda$1oY0VGNqZERZCoWXCBKYpZPY3c(AnonymousClass4 r0) {
            r0.lambda$onConnected$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$IgIPvDPwMwfz6-1XgFf_LEF4QeY, reason: not valid java name */
        public static /* synthetic */ void m6423$r8$lambda$IgIPvDPwMwfz61XgFf_LEF4QeY(AnonymousClass4 r0, IOnDeviceSandboxedInferenceService r1) {
            r0.lambda$onConnected$0(r1);
        }

        AnonymousClass4(OnDeviceIntelligenceManagerService this$0) {
            this.this$0 = this$0;
        }

        public /* bridge */ /* synthetic */ void onConnected(IInterface r1) {
            onConnected((IOnDeviceSandboxedInferenceService) r1);
        }

        public /* bridge */ /* synthetic */ void onDisconnected(IInterface r1) {
            onDisconnected((IOnDeviceSandboxedInferenceService) r1);
        }

        public void onConnected(final IOnDeviceSandboxedInferenceService service) {
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);     // Catch: RemoteException -> L4
            service.registerRemoteStorageService(OnDeviceIntelligenceManagerService.m6406$$Nest$mgetIRemoteStorageService(this.this$0), new AnonymousClass1(this));     // Catch: RemoteException -> L4
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).run(new OnDeviceIntelligenceManagerService$4$$ExternalSyntheticLambda0());     // Catch: RemoteException -> L4
            OnDeviceIntelligenceManagerService.m6391$$Nest$fgetbroadcastExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$4$$ExternalSyntheticLambda1(this, service));     // Catch: RemoteException -> L4
            OnDeviceIntelligenceManagerService.m6394$$Nest$fgetmConfigExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$4$$ExternalSyntheticLambda2(this));     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(OnDeviceIntelligenceManagerService.m6415$$Nest$sfgetTAG(), "Failed to send connected event", ex);
        }

        private /* synthetic */ void lambda$onConnected$0(IOnDeviceSandboxedInferenceService service) {
            OnDeviceIntelligenceManagerService.m6411$$Nest$mregisterModelLoadingBroadcasts(this.this$0, service);
        }

        private /* synthetic */ void lambda$onConnected$1() {
            OnDeviceIntelligenceManagerService.m6410$$Nest$mregisterDeviceConfigChangeListener(this.this$0);
        }

        public void onDisconnected(IOnDeviceSandboxedInferenceService service) {
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).run(new OnDeviceIntelligenceManagerService$4$$ExternalSyntheticLambda3());
        }

        public void onBinderDied() {
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).run(new OnDeviceIntelligenceManagerService$4$$ExternalSyntheticLambda3());
        }
    }

    /* JADX INFO: renamed from: com.android.server.ondeviceintelligence.OnDeviceIntelligenceManagerService$7, reason: invalid class name */
    class AnonymousClass7 extends IRemoteStorageService.Stub {
        final /* synthetic */ OnDeviceIntelligenceManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$5pDeWqpo4Lsm9LmrQ6P-uqQ9SOA, reason: not valid java name */
        public static /* synthetic */ void m6424$r8$lambda$5pDeWqpo4Lsm9LmrQ6PuqQ9SOA(AnonymousClass7 r0, Bundle r1, RemoteCallback r2) {
            r0.lambda$getReadOnlyFeatureFileDescriptorMap$3(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$KZMtcNPDyn_VHW6qj_D-ecc5_YU, reason: not valid java name */
        public static /* synthetic */ void m6425$r8$lambda$KZMtcNPDyn_VHW6qj_Decc5_YU(Bundle r0) {
            lambda$getReadOnlyFeatureFileDescriptorMap$2(r0);
        }

        public static /* synthetic */ void $r8$lambda$TTx_drAyL0MzZVzYdPEEAqHel2s(AnonymousClass7 r0, Feature r1, RemoteCallback r2, IOnDeviceIntelligenceService r3) {
            r0.lambda$getReadOnlyFeatureFileDescriptorMap$5(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$ltfCz1lOQqi43giohaAf_DS1Wjo(AnonymousClass7 r0, RemoteCallback r1, Bundle r2) {
            r0.lambda$getReadOnlyFeatureFileDescriptorMap$4(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$vZCj4OdfPGLT3e_6WI-9Z39n6zM, reason: not valid java name */
        public static /* synthetic */ void m6426$r8$lambda$vZCj4OdfPGLT3e_6WI9Z39n6zM(String r0, AndroidFuture r1, IOnDeviceIntelligenceService r2) {
            lambda$getReadOnlyFileDescriptor$0(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$y73YHv8oZP68DQ3WVTIOfJ3ANG8(AndroidFuture r0, ParcelFileDescriptor r1, Throwable r2) {
            lambda$getReadOnlyFileDescriptor$1(r0, r1, r2);
        }

        AnonymousClass7(OnDeviceIntelligenceManagerService this$0) {
            this.this$0 = this$0;
        }

        public void getReadOnlyFileDescriptor(final String filePath, final AndroidFuture<ParcelFileDescriptor> future) {
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            final AndroidFuture<ParcelFileDescriptor> pfdFuture = new AndroidFuture();
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).run(new OnDeviceIntelligenceManagerService$7$$ExternalSyntheticLambda1(filePath, pfdFuture));
            pfdFuture.whenCompleteAsync(new OnDeviceIntelligenceManagerService$7$$ExternalSyntheticLambda2(future), OnDeviceIntelligenceManagerService.m6392$$Nest$fgetcallbackExecutor(this.this$0));
        }

        private static /* synthetic */ void lambda$getReadOnlyFileDescriptor$0(String filePath, AndroidFuture pfdFuture, IOnDeviceIntelligenceService service) throws Exception {
            service.getReadOnlyFileDescriptor(filePath, pfdFuture);
        }

        private static /* synthetic */ void lambda$getReadOnlyFileDescriptor$1(AndroidFuture future, ParcelFileDescriptor pfd, Throwable error) {
            if (error == null) goto L6;
            future.completeExceptionally(error);     // Catch: Throwable -> L4
        L7:
            OnDeviceIntelligenceManagerService.m6416$$Nest$smtryClosePfd(pfd);
            return;
        L6:
            BundleUtil.validatePfdReadOnly(pfd);     // Catch: Throwable -> L4
            future.complete(pfd);     // Catch: Throwable -> L4
        L4:
            th = move-exception;
            OnDeviceIntelligenceManagerService.m6416$$Nest$smtryClosePfd(pfd);
            throw th;
        }

        public void getReadOnlyFeatureFileDescriptorMap(final Feature feature, final RemoteCallback remoteCallback) {
            OnDeviceIntelligenceManagerService.m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(this.this$0);
            OnDeviceIntelligenceManagerService.m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(this.this$0).run(new OnDeviceIntelligenceManagerService$7$$ExternalSyntheticLambda4(this, feature, remoteCallback));
        }

        private /* synthetic */ void lambda$getReadOnlyFeatureFileDescriptorMap$5(Feature feature, final RemoteCallback remoteCallback, IOnDeviceIntelligenceService service) throws Exception {
            service.getReadOnlyFeatureFileDescriptorMap(feature, new RemoteCallback(new OnDeviceIntelligenceManagerService$7$$ExternalSyntheticLambda0(this, remoteCallback)));
        }

        private /* synthetic */ void lambda$getReadOnlyFeatureFileDescriptorMap$4(final RemoteCallback remoteCallback, final Bundle result) {
            OnDeviceIntelligenceManagerService.m6392$$Nest$fgetcallbackExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$7$$ExternalSyntheticLambda5(this, result, remoteCallback));
        }

        private /* synthetic */ void lambda$getReadOnlyFeatureFileDescriptorMap$3(final Bundle result, RemoteCallback remoteCallback) {
            if (result == null) goto L16;
        L7:
            Iterator<String> r0 = result.keySet().iterator();     // Catch: Throwable -> L5
        L9:
            if (r0.hasNext() == false) goto L11;
            String key = r0.next();     // Catch: Throwable -> L5
            ParcelFileDescriptor pfd = (ParcelFileDescriptor) result.getParcelable(key, ParcelFileDescriptor.class);     // Catch: Throwable -> L5
            BundleUtil.validatePfdReadOnly(pfd);     // Catch: Throwable -> L5
            goto L9
        L11:
            remoteCallback.sendResult(result);     // Catch: Throwable -> L5
            OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$7$$ExternalSyntheticLambda3(result));
            return;
        L5:
            th = move-exception;
            OnDeviceIntelligenceManagerService.m6400$$Nest$fgetresourceClosingExecutor(this.this$0).execute(new OnDeviceIntelligenceManagerService$7$$ExternalSyntheticLambda3(result));
            throw th;
        L16:
            remoteCallback.sendResult(null);     // Catch: Throwable -> L5
            goto L7
        }

        private static /* synthetic */ void lambda$getReadOnlyFeatureFileDescriptorMap$2(Bundle result) {
            BundleUtil.tryCloseResource(result);
        }
    }

    public static /* synthetic */ void $r8$lambda$69aEcAvVAOkGLSfnkvDhpt8f_1s(OnDeviceIntelligenceManagerService r0, String r1) {
        r0.lambda$ensureRemoteIntelligenceServiceInitialized$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$6RgQtova1oM-pdDse_Dchtzeom4, reason: not valid java name */
    public static /* synthetic */ int m6387$r8$lambda$6RgQtova1oMpdDse_Dchtzeom4(OnDeviceIntelligenceManagerService r0) {
        return r0.getRemoteInferenceServiceUid();
    }

    public static /* synthetic */ void $r8$lambda$6wc0b2dRHvCvc_Q7LS3fkphKfWU(OnDeviceIntelligenceManagerService r0, DeviceConfig.Properties r1) {
        r0.sendUpdatedConfig(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$CyGA_I-1GwRuXFozFzFdaqRjt-0, reason: not valid java name */
    public static /* synthetic */ void m6388$r8$lambda$CyGA_I1GwRuXFozFzFdaqRjt0(OnDeviceIntelligenceManagerService r0, AndroidFuture r1, IBinder r2, Throwable r3) {
        r0.lambda$wrapProcessingFuture$5(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ErO-YOaQaf9W3CeRJ2IrwvoXDeg, reason: not valid java name */
    public static /* synthetic */ void m6389$r8$lambda$ErOYOaQaf9W3CeRJ2IrwvoXDeg(OnDeviceIntelligenceManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$onBootPhase$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Lg9P-gCdrb1hpeSIari5_t9QV1Y, reason: not valid java name */
    public static /* synthetic */ void m6390$r8$lambda$Lg9PgCdrb1hpeSIari5_t9QV1Y(OnDeviceIntelligenceManagerService r0, Bundle r1, IOnDeviceSandboxedInferenceService r2) {
        r0.lambda$sendUpdatedConfig$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$iANruR1UBxmbzcoplkJxAs6OR_A(OnDeviceIntelligenceManagerService r0, AndroidFuture r1, IBinder r2, Throwable r3) {
        r0.lambda$wrapCancellationFuture$4(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$qWFNamOCjZtux7sLH__Vr5HGTvc(OnDeviceIntelligenceManagerService r0, String r1) {
        r0.lambda$ensureRemoteInferenceServiceInitialized$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetbroadcastExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m6391$$Nest$fgetbroadcastExecutor(OnDeviceIntelligenceManagerService r0) {
        return r0.broadcastExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetcallbackExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m6392$$Nest$fgetcallbackExecutor(OnDeviceIntelligenceManagerService r0) {
        return r0.callbackExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBroadcastPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6393$$Nest$fgetmBroadcastPackageName(OnDeviceIntelligenceManagerService r0) {
        return r0.mBroadcastPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfigExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m6394$$Nest$fgetmConfigExecutor(OnDeviceIntelligenceManagerService r0) {
        return r0.mConfigExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6395$$Nest$fgetmContext(OnDeviceIntelligenceManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInferenceInfoStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ InferenceInfoStore m6396$$Nest$fgetmInferenceInfoStore(OnDeviceIntelligenceManagerService r0) {
        return r0.mInferenceInfoStore;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMainHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6397$$Nest$fgetmMainHandler(OnDeviceIntelligenceManagerService r0) {
        return r0.mMainHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteInferenceService, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteOnDeviceSandboxedInferenceService m6398$$Nest$fgetmRemoteInferenceService(OnDeviceIntelligenceManagerService r0) {
        return r0.mRemoteInferenceService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteOnDeviceIntelligenceService, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteOnDeviceIntelligenceService m6399$$Nest$fgetmRemoteOnDeviceIntelligenceService(OnDeviceIntelligenceManagerService r0) {
        return r0.mRemoteOnDeviceIntelligenceService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetresourceClosingExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m6400$$Nest$fgetresourceClosingExecutor(OnDeviceIntelligenceManagerService r0) {
        return r0.resourceClosingExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmBroadcastPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6401$$Nest$fputmBroadcastPackageName(OnDeviceIntelligenceManagerService r0, String r1) {
        r0.mBroadcastPackageName = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTemporaryBroadcastKeys, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6402$$Nest$fputmTemporaryBroadcastKeys(OnDeviceIntelligenceManagerService r0, String[] r1) {
        r0.mTemporaryBroadcastKeys = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTemporaryConfigNamespace, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6403$$Nest$fputmTemporaryConfigNamespace(OnDeviceIntelligenceManagerService r0, String r1) {
        r0.mTemporaryConfigNamespace = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mensureRemoteInferenceServiceInitialized, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6404$$Nest$mensureRemoteInferenceServiceInitialized(OnDeviceIntelligenceManagerService r0) {
        r0.ensureRemoteInferenceServiceInitialized();
    }

    /* JADX INFO: renamed from: -$$Nest$mensureRemoteIntelligenceServiceInitialized, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6405$$Nest$mensureRemoteIntelligenceServiceInitialized(OnDeviceIntelligenceManagerService r0) {
        r0.ensureRemoteIntelligenceServiceInitialized();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetIRemoteStorageService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IRemoteStorageService.Stub m6406$$Nest$mgetIRemoteStorageService(OnDeviceIntelligenceManagerService r0) {
        return r0.getIRemoteStorageService();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetIdleTimeoutMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m6407$$Nest$mgetIdleTimeoutMs(OnDeviceIntelligenceManagerService r2) {
        return r2.getIdleTimeoutMs();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetLatestInferenceInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6408$$Nest$mgetLatestInferenceInfo(OnDeviceIntelligenceManagerService r0, long r1) {
        return r0.getLatestInferenceInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRemoteProcessingService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IRemoteProcessingService.Stub m6409$$Nest$mgetRemoteProcessingService(OnDeviceIntelligenceManagerService r0) {
        return r0.getRemoteProcessingService();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterDeviceConfigChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6410$$Nest$mregisterDeviceConfigChangeListener(OnDeviceIntelligenceManagerService r0) {
        r0.registerDeviceConfigChangeListener();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterModelLoadingBroadcasts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6411$$Nest$mregisterModelLoadingBroadcasts(OnDeviceIntelligenceManagerService r0, IOnDeviceSandboxedInferenceService r1) {
        r0.registerModelLoadingBroadcasts(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetRemoteInferenceServiceUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6412$$Nest$msetRemoteInferenceServiceUid(OnDeviceIntelligenceManagerService r0, int r1) {
        r0.setRemoteInferenceServiceUid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mwrapCancellationFuture, reason: not valid java name */
    static /* bridge */ /* synthetic */ AndroidFuture m6413$$Nest$mwrapCancellationFuture(OnDeviceIntelligenceManagerService r0, AndroidFuture r1) {
        return r0.wrapCancellationFuture(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mwrapProcessingFuture, reason: not valid java name */
    static /* bridge */ /* synthetic */ AndroidFuture m6414$$Nest$mwrapProcessingFuture(OnDeviceIntelligenceManagerService r0, AndroidFuture r1) {
        return r0.wrapProcessingFuture(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6415$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smtryClosePfd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6416$$Nest$smtryClosePfd(ParcelFileDescriptor r0) {
        tryClosePfd(r0);
    }

    static {
        TAG = OnDeviceIntelligenceManagerService.class.getSimpleName();
        MAX_AGE_MS = TimeUnit.HOURS.toMillis(3);
    }

    public OnDeviceIntelligenceManagerService(Context context) {
        super(context);
        this.resourceClosingExecutor = Executors.newCachedThreadPool();
        this.callbackExecutor = Executors.newCachedThreadPool();
        this.broadcastExecutor = Executors.newCachedThreadPool();
        this.mConfigExecutor = Executors.newCachedThreadPool();
        this.mLock = new Object();
        this.remoteInferenceServiceUid = -1;
        this.mBroadcastPackageName = "android";
        this.mOnPropertiesChangedListener = new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda0(this);
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mContext = context;
        this.mTemporaryServiceNames = new String[0];
        this.mInferenceInfoStore = new InferenceInfoStore(MAX_AGE_MS);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("on_device_intelligence", getOnDeviceIntelligenceManagerService(), true);
        LocalManagerRegistry.addManager(OnDeviceIntelligenceManagerLocal.class, new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda7(this));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        DeviceConfig.addOnPropertiesChangedListener(NAMESPACE_ON_DEVICE_INTELLIGENCE, BackgroundThread.getExecutor(), new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda4(this));
        this.mIsServiceEnabled = isServiceEnabled();
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    private void onDeviceConfigChange(Set<String> keys) {
        if (keys.contains(KEY_SERVICE_ENABLED) == false) goto L6;
        this.mIsServiceEnabled = isServiceEnabled();
        return;
    }

    private boolean isServiceEnabled() {
        return DeviceConfig.getBoolean(NAMESPACE_ON_DEVICE_INTELLIGENCE, KEY_SERVICE_ENABLED, true);
    }

    private IBinder getOnDeviceIntelligenceManagerService() {
        return new AnonymousClass1(this);
    }

    private void ensureRemoteIntelligenceServiceInitialized() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteOnDeviceIntelligenceService != null) goto L9;
        final String serviceName = getServiceNames()[0];     // Catch: Throwable -> L7
        Binder.withCleanCallingIdentity(new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda6(this, serviceName));     // Catch: Throwable -> L7
        this.mRemoteOnDeviceIntelligenceService = new RemoteOnDeviceIntelligenceService(this.mContext, ComponentName.unflattenFromString(serviceName), UserHandle.SYSTEM.getIdentifier());     // Catch: Throwable -> L7
        this.mRemoteOnDeviceIntelligenceService.setServiceLifecycleCallbacks(new AnonymousClass2(this));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private /* synthetic */ void lambda$ensureRemoteIntelligenceServiceInitialized$1(String serviceName) throws Exception {
        validateServiceElevated(serviceName, false);
    }

    private IRemoteProcessingService.Stub getRemoteProcessingService() {
        return new AnonymousClass3(this);
    }

    private void ensureRemoteInferenceServiceInitialized() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteInferenceService != null) goto L9;
        final String serviceName = getServiceNames()[1];     // Catch: Throwable -> L7
        Binder.withCleanCallingIdentity(new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda5(this, serviceName));     // Catch: Throwable -> L7
        this.mRemoteInferenceService = new RemoteOnDeviceSandboxedInferenceService(this.mContext, ComponentName.unflattenFromString(serviceName), UserHandle.SYSTEM.getIdentifier());     // Catch: Throwable -> L7
        this.mRemoteInferenceService.setServiceLifecycleCallbacks(new AnonymousClass4(this));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private /* synthetic */ void lambda$ensureRemoteInferenceServiceInitialized$2(String serviceName) throws Exception {
        validateServiceElevated(serviceName, true);
    }

    private void registerModelLoadingBroadcasts(IOnDeviceSandboxedInferenceService service) {
        final String[] modelBroadcastKeys = getBroadcastKeys();     // Catch: Resources.NotFoundException -> L9
        Bundle bundle = new Bundle();
        bundle.putBoolean("register_model_update_callback", true);
        service.updateProcessingState(bundle, new AnonymousClass5(this, modelBroadcastKeys));     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to register model loading callback with status code", e);
        return;
    L10:
        Slog.d(TAG, "Skipping model broadcasts as broadcast intents configured.");
    }

    private void registerDeviceConfigChangeListener() {
        Log.d(TAG, "registerDeviceConfigChangeListener");
        String configNamespace = getConfigNamespace();
        if (configNamespace.isEmpty() == false) goto L6;
        Slog.e(TAG, "config_defaultOnDeviceIntelligenceDeviceConfigNamespace is empty");
        return;
    L6:
        DeviceConfig.addOnPropertiesChangedListener(configNamespace, this.mConfigExecutor, this.mOnPropertiesChangedListener);
    }

    private String getConfigNamespace() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mTemporaryConfigNamespace == null) goto L11;
        String r1 = this.mTemporaryConfigNamespace;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        String r2 = this.mContext.getResources().getString(R.string.config_defaultOnDeviceIntelligenceDeviceConfigNamespace);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    private void sendUpdatedConfig(DeviceConfig.Properties props) {
        Log.d(TAG, "sendUpdatedConfig");
        PersistableBundle persistableBundle = new PersistableBundle();
        Iterator r1 = props.getKeyset().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String key = (String) r1.next();
        persistableBundle.putString(key, props.getString(key, ""));
        goto L4
    L6:
        final Bundle bundle = new Bundle();
        bundle.putParcelable("device_config_update", persistableBundle);
        ensureRemoteInferenceServiceInitialized();
        this.mRemoteInferenceService.run(new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda2(this, bundle));
    }

    private /* synthetic */ void lambda$sendUpdatedConfig$3(Bundle bundle, IOnDeviceSandboxedInferenceService service) throws Exception {
        service.updateProcessingState(bundle, new AnonymousClass6(this));
    }

    private IRemoteStorageService.Stub getIRemoteStorageService() {
        return new AnonymousClass7(this);
    }

    private void validateServiceElevated(String serviceName, boolean checkIsolated) {
    L9:
        e = move-exception;
        throw new IllegalStateException("Could not fetch service info for remote services", e);
    L3:
        if (TextUtils.isEmpty(serviceName) == true) goto L19;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);     // Catch: RemoteException -> L9
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 786432, UserHandle.SYSTEM.getIdentifier());     // Catch: RemoteException -> L9
        if (serviceInfo == null) goto L17;
        if (checkIsolated == true) goto L11;
        checkServiceRequiresPermission(serviceInfo, "android.permission.BIND_ON_DEVICE_INTELLIGENCE_SERVICE");     // Catch: RemoteException -> L9
        return;
    L11:
        checkServiceRequiresPermission(serviceInfo, "android.permission.BIND_ON_DEVICE_SANDBOXED_INFERENCE_SERVICE");     // Catch: RemoteException -> L9
        if (isIsolatedService(serviceInfo) == false) goto L15;
        return;
    L15:
        throw new SecurityException("Call required an isolated service, but the configured service: " + serviceName + ", is not isolated");     // Catch: RemoteException -> L9
    L17:
        throw new IllegalStateException("Remote service is not configured to complete the request.");     // Catch: RemoteException -> L9
    L19:
        throw new IllegalStateException("Remote service is not configured to complete the request");     // Catch: RemoteException -> L9
    }

    private static void checkServiceRequiresPermission(ServiceInfo serviceInfo, String requiredPermission) {
        String permission = serviceInfo.permission;
        if (requiredPermission.equals(permission) == false) goto L6;
        return;
    L6:
        throw new SecurityException(String.format("Service %s requires %s permission. Found %s permission", new Object[]{serviceInfo.getComponentName(), requiredPermission, serviceInfo.permission}));
    }

    private static boolean isIsolatedService(ServiceInfo serviceInfo) {
        if ((serviceInfo.flags & 2) != 0) goto L5;
    L7:
        return false;
    L5:
        if ((serviceInfo.flags & 4) != 0) goto L7;
        return true;
    }

    private List<InferenceInfo> getLatestInferenceInfo(long startTimeEpochMillis) {
        return this.mInferenceInfoStore.getLatestInferenceInfo(startTimeEpochMillis);
    }

    public String getRemoteConfiguredPackageName() {
        String[] serviceNames = getServiceNames();     // Catch: Resources.NotFoundException -> L6
        ComponentName componentName = ComponentName.unflattenFromString(serviceNames[1]);     // Catch: Resources.NotFoundException -> L6
        if (componentName == null) goto L14;
        return componentName.getPackageName();
    L14:
        return null;
    L6:
        e = move-exception;
        Slog.e(TAG, "Could not find resource", e);
        return null;
    }

    protected String[] getServiceNames() throws Resources.NotFoundException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mTemporaryServiceNames != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return new String[]{this.mContext.getResources().getString(R.string.config_defaultOnDeviceIntelligenceService), this.mContext.getResources().getString(R.string.config_defaultOnDeviceSandboxedInferenceService)};
    L7:
        if (this.mTemporaryServiceNames.length != 2) goto L13;
        String[] r1 = this.mTemporaryServiceNames;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    }

    protected String[] getBroadcastKeys() throws Resources.NotFoundException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mTemporaryBroadcastKeys != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return new String[]{"android.service.ondeviceintelligence.MODEL_LOADED", "android.service.ondeviceintelligence.MODEL_UNLOADED"};
    L7:
        if (this.mTemporaryBroadcastKeys.length != 2) goto L13;
        String[] r1 = this.mTemporaryBroadcastKeys;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    }

    public void setTemporaryServices(String[] componentNames, int durationMs) {
        componentNames.getClass();
        enforceShellOnly(Binder.getCallingUid(), "setTemporaryServices");
        this.mContext.enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", TAG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTemporaryServiceNames = componentNames;     // Catch: Throwable -> L7
        if (this.mRemoteInferenceService == null) goto L10;
        this.mRemoteInferenceService.unbind();     // Catch: Throwable -> L7
        this.mRemoteInferenceService = null;     // Catch: Throwable -> L7
    L10:
        if (this.mRemoteOnDeviceIntelligenceService == null) goto L13;
        this.mRemoteOnDeviceIntelligenceService.unbind();     // Catch: Throwable -> L7
        this.mRemoteOnDeviceIntelligenceService = null;     // Catch: Throwable -> L7
    L13:
        if (durationMs == (-1)) goto L15;
        getTemporaryHandler().sendEmptyMessageDelayed(0, durationMs);     // Catch: Throwable -> L7
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setModelBroadcastKeys(String[] broadcastKeys, String receiverPackageName, int durationMs) {
        broadcastKeys.getClass();
        enforceShellOnly(Binder.getCallingUid(), "setModelBroadcastKeys");
        this.mContext.enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", TAG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTemporaryBroadcastKeys = broadcastKeys;     // Catch: Throwable -> L7
        this.mBroadcastPackageName = receiverPackageName;     // Catch: Throwable -> L7
        if (durationMs == (-1)) goto L9;
        getTemporaryHandler().sendEmptyMessageDelayed(1, durationMs);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setTemporaryDeviceConfigNamespace(String configNamespace, int durationMs) {
        configNamespace.getClass();
        enforceShellOnly(Binder.getCallingUid(), "setTemporaryDeviceConfigNamespace");
        this.mContext.enforceCallingPermission("android.permission.USE_ON_DEVICE_INTELLIGENCE", TAG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTemporaryConfigNamespace = configNamespace;     // Catch: Throwable -> L7
        if (durationMs == (-1)) goto L9;
        getTemporaryHandler().sendEmptyMessageDelayed(2, durationMs);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void resetTemporaryServices() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mTemporaryHandler == null) goto L10;
        this.mTemporaryHandler.removeMessages(0);     // Catch: Throwable -> L7
        this.mTemporaryHandler = null;     // Catch: Throwable -> L7
    L10:
        if (this.mRemoteInferenceService == null) goto L13;
        this.mRemoteInferenceService.setServiceLifecycleCallbacks(null);     // Catch: Throwable -> L7
        this.mRemoteInferenceService.unbind();     // Catch: Throwable -> L7
        this.mRemoteInferenceService = null;     // Catch: Throwable -> L7
    L13:
        if (this.mRemoteOnDeviceIntelligenceService == null) goto L15;
        this.mRemoteOnDeviceIntelligenceService.setServiceLifecycleCallbacks(null);     // Catch: Throwable -> L7
        this.mRemoteOnDeviceIntelligenceService.unbind();     // Catch: Throwable -> L7
        this.mRemoteOnDeviceIntelligenceService = null;     // Catch: Throwable -> L7
    L15:
        this.mTemporaryServiceNames = new String[0];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public static void enforceShellOnly(int callingUid, String message) {
        if (callingUid == 2000) goto L8;
        if (callingUid != 0) goto L7;
        return;
    L7:
        throw new SecurityException(message + ": Only shell user can call it");
    }

    private AndroidFuture<IBinder> wrapCancellationFuture(final AndroidFuture future) {
        if (future != null) goto L5;
        return null;
    L5:
        AndroidFuture<IBinder> cancellationFuture = new AndroidFuture();
        cancellationFuture.whenCompleteAsync(new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda3(this, future));
        return cancellationFuture;
    }

    private /* synthetic */ void lambda$wrapCancellationFuture$4(AndroidFuture future, final IBinder c, Throwable e) {
        if (e == null) goto L4;
        Log.e(TAG, "Error forwarding ICancellationSignal to manager layer", e);
        future.completeExceptionally(e);
        return;
    L4:
        future.complete(new AnonymousClass8(this, c));
    }

    private AndroidFuture<IBinder> wrapProcessingFuture(final AndroidFuture future) {
        if (future != null) goto L5;
        return null;
    L5:
        AndroidFuture<IBinder> processingSignalFuture = new AndroidFuture();
        processingSignalFuture.whenCompleteAsync(new OnDeviceIntelligenceManagerService$$ExternalSyntheticLambda1(this, future));
        return processingSignalFuture;
    }

    private /* synthetic */ void lambda$wrapProcessingFuture$5(AndroidFuture future, final IBinder c, Throwable e) {
        if (e == null) goto L4;
        future.completeExceptionally(e);
        return;
    L4:
        future.complete(new AnonymousClass9(this, c));
    }

    private static void tryClosePfd(ParcelFileDescriptor pfd) {
        if (pfd == null) goto L10;
        pfd.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Failed to close parcel file descriptor ", e);
        return;
    }

    private synchronized Handler getTemporaryHandler() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mTemporaryHandler != null) goto L8;
        final Looper r1 = Looper.getMainLooper();     // Catch: Throwable -> L6
        final Handler.Callback r2 = null;
        final boolean r3 = true;
        this.mTemporaryHandler = new AnonymousClass10(this, r1, r2, r3);     // Catch: Throwable -> L6
    L8:
        Handler r0 = this.mTemporaryHandler;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }

    private long getIdleTimeoutMs() {
        return Settings.Secure.getLongForUser(this.mContext.getContentResolver(), "on_device_intelligence_idle_timeout_ms", TimeUnit.HOURS.toMillis(1), this.mContext.getUserId());
    }

    private int getRemoteInferenceServiceUid() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.remoteInferenceServiceUid;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void setRemoteInferenceServiceUid(int remoteInferenceServiceUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.remoteInferenceServiceUid = remoteInferenceServiceUid;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}

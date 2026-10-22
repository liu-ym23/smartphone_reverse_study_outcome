package com.android.server.wearable;

import android.R;
import android.app.BroadcastOptions;
import android.app.PendingIntent;
import android.app.wearable.IWearableSensingCallback;
import android.app.wearable.IWearableSensingManager;
import android.app.wearable.WearableSensingDataRequest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.PersistableBundle;
import android.os.RemoteCallback;
import android.os.ResultReceiver;
import android.os.SharedMemory;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.android.server.utils.quota.MultiRateLimiter;
import java.io.FileDescriptor;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class WearableSensingManagerService extends AbstractMasterSystemService<WearableSensingManagerService, WearableSensingManagerPerUserService> {
    private static final boolean DEFAULT_SERVICE_ENABLED = true;
    private static final String KEY_SERVICE_ENABLED = "service_enabled";
    public static final int MAX_TEMPORARY_SERVICE_DURATION_MS = 30000;
    private static final String RATE_LIMITER_PACKAGE_NAME = "android";
    private static final String RATE_LIMITER_TAG = null;
    private static final String TAG = null;
    private final Context mContext;
    private final Set<DataRequestObserverContext> mDataRequestObserverContexts;
    private volatile MultiRateLimiter mDataRequestRateLimiter;
    volatile boolean mIsServiceEnabled;
    private final AtomicInteger mNextDataRequestObserverId;

    private static final class DataRequestObserverContext {
        final int mDataRequestObserverId;
        final PendingIntent mDataRequestPendingIntent;
        final RemoteCallback mDataRequestRemoteCallback;
        final int mDataType;
        final int mUserId;

        DataRequestObserverContext(int dataType, int userId, int dataRequestObserverId, PendingIntent dataRequestPendingIntent, RemoteCallback dataRequestRemoteCallback) {
            this.mDataType = dataType;
            this.mUserId = userId;
            this.mDataRequestObserverId = dataRequestObserverId;
            this.mDataRequestPendingIntent = dataRequestPendingIntent;
            this.mDataRequestRemoteCallback = dataRequestRemoteCallback;
        }
    }

    private final class WearableSensingManagerInternal extends IWearableSensingManager.Stub {
        final /* synthetic */ WearableSensingManagerService this$0;

        public static /* synthetic */ void $r8$lambda$0H_E_qDjsxPZmOYFc9dvk030MYo(ComponentName r0, RemoteCallback r1, WearableSensingManagerPerUserService r2) {
            lambda$startHotwordRecognition$5(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$EF-uIxqtuFTJSRw2XlHTCL6VxJk, reason: not valid java name */
        public static /* synthetic */ void m9576$r8$lambda$EFuIxqtuFTJSRw2XlHTCL6VxJk(ParcelFileDescriptor r0, IWearableSensingCallback r1, RemoteCallback r2, WearableSensingManagerPerUserService r3) {
            lambda$provideDataStream$1(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$FQPsiOmODaJwpoXqJrGspTXXVu0(PersistableBundle r0, SharedMemory r1, RemoteCallback r2, WearableSensingManagerPerUserService r3) {
            lambda$provideData$2(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$GD3SVVAzUzk7NYaRmvAnKLDJBjw(int r0, int r1, String r2, RemoteCallback r3, WearableSensingManagerPerUserService r4) {
            lambda$unregisterDataRequestObserver$4(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$StwI29O9xcoE36JIbnvRNo1wfXU(RemoteCallback r0, WearableSensingManagerPerUserService r1) {
            lambda$stopHotwordRecognition$6(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$eb20XFBZxiozdMfF0WntWX1dEzo(ParcelFileDescriptor r0, IWearableSensingCallback r1, RemoteCallback r2, WearableSensingManagerPerUserService r3) {
            lambda$provideConnection$0(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$pJOeoRaVcsR_Urr4ycisbCEvlT4(int r0, RemoteCallback r1, int r2, PendingIntent r3, RemoteCallback r4, WearableSensingManagerPerUserService r5) {
            lambda$registerDataRequestObserver$3(r0, r1, r2, r3, r4, r5);
        }

        /* synthetic */ WearableSensingManagerInternal(WearableSensingManagerService r1, WearableSensingManagerServiceIA r2) {
            this(r1);
        }

        private WearableSensingManagerInternal(WearableSensingManagerService r1) {
            this.this$0 = r1;
        }

        public int getAvailableConnectionCount() {
            WearableSensingManagerPerUserService service = validateAndGetPerUserService(null);
            if (service != null) goto L7;
            return 0;
        L7:
            return service.getAvailableConnectionCount();
        }

        public void provideConnection(final ParcelFileDescriptor wearableConnection, final IWearableSensingCallback wearableSensingCallback, final RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal provideConnection.");
            wearableConnection.getClass();
            statusCallback.getClass();
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
            return;
        L6:
            WearableSensingManagerService.m9572$$Nest$mcallPerUserServiceIfExist(this.this$0, new WearableSensingManagerService$WearableSensingManagerInternal$$ExternalSyntheticLambda1(wearableConnection, wearableSensingCallback, statusCallback), statusCallback);
        }

        private static /* synthetic */ void lambda$provideConnection$0(ParcelFileDescriptor wearableConnection, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback, WearableSensingManagerPerUserService service) {
            service.onProvideConnection(wearableConnection, wearableSensingCallback, statusCallback);
        }

        public int provideConcurrentConnection(ParcelFileDescriptor wearableConnection, PersistableBundle metadata, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal provideConcurrentConnection.");
            wearableConnection.getClass();
            metadata.getClass();
            wearableSensingCallback.getClass();
            statusCallback.getClass();
            WearableSensingManagerPerUserService service = validateAndGetPerUserService(statusCallback);
            if (service != null) goto L7;
            return -1;
        L7:
            return service.onProvideConcurrentConnection(wearableConnection, metadata, wearableSensingCallback, statusCallback);
        }

        public boolean removeConnection(int connectionId) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal removeConnection.");
            WearableSensingManagerPerUserService service = validateAndGetPerUserService(null);
            if (service != null) goto L7;
            return false;
        L7:
            return service.removeConnection(connectionId);
        }

        public void removeAllConnections() {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal removeAllConnections.");
            WearableSensingManagerPerUserService service = validateAndGetPerUserService(null);
            if (service != null) goto L5;
            return;
        L5:
            service.removeAllConnections();
        }

        public void provideReadOnlyParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, PersistableBundle metadata, RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal provideReadOnlyParcelFileDescriptor.");
            WearableSensingManagerPerUserService service = validateAndGetPerUserService(statusCallback);
            if (service != null) goto L5;
            return;
        L5:
            service.onProvideReadOnlyParcelFileDescriptor(parcelFileDescriptor, metadata, statusCallback);
        }

        public void provideDataStream(final ParcelFileDescriptor parcelFileDescriptor, final IWearableSensingCallback wearableSensingCallback, final RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal provideDataStream.");
            parcelFileDescriptor.getClass();
            statusCallback.getClass();
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
            return;
        L6:
            WearableSensingManagerService.m9572$$Nest$mcallPerUserServiceIfExist(this.this$0, new WearableSensingManagerService$WearableSensingManagerInternal$$ExternalSyntheticLambda2(parcelFileDescriptor, wearableSensingCallback, statusCallback), statusCallback);
        }

        private static /* synthetic */ void lambda$provideDataStream$1(ParcelFileDescriptor parcelFileDescriptor, IWearableSensingCallback wearableSensingCallback, RemoteCallback statusCallback, WearableSensingManagerPerUserService service) {
            service.onProvideDataStream(parcelFileDescriptor, wearableSensingCallback, statusCallback);
        }

        public void provideData(final PersistableBundle data, final SharedMemory sharedMemory, final RemoteCallback callback) {
            Slog.d(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal provideData.");
            data.getClass();
            callback.getClass();
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            WearableSensingManagerPerUserService.notifyStatusCallback(callback, 3);
            return;
        L6:
            WearableSensingManagerService.m9572$$Nest$mcallPerUserServiceIfExist(this.this$0, new WearableSensingManagerService$WearableSensingManagerInternal$$ExternalSyntheticLambda5(data, sharedMemory, callback), callback);
        }

        private static /* synthetic */ void lambda$provideData$2(PersistableBundle data, SharedMemory sharedMemory, RemoteCallback callback, WearableSensingManagerPerUserService service) {
            service.onProvidedData(data, sharedMemory, callback);
        }

        public void registerDataRequestObserver(final int dataType, final PendingIntent dataRequestPendingIntent, final RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal registerDataRequestObserver.");
            dataRequestPendingIntent.getClass();
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
            return;
        L6:
            int userId = UserHandle.getCallingUserId();
            Set r7 = WearableSensingManagerService.m9570$$Nest$fgetmDataRequestObserverContexts(this.this$0);
            monitor-enter(r7);
            DataRequestObserverContext previousObserverContext = WearableSensingManagerService.m9574$$Nest$mgetDataRequestObserverContext(this.this$0, dataType, userId, dataRequestPendingIntent);     // Catch: Throwable -> L22
            if (previousObserverContext != null) goto L26;
            RemoteCallback dataRequestCallback = WearableSensingManagerService.m9573$$Nest$mcreateDataRequestRemoteCallback(this.this$0, dataRequestPendingIntent, userId);     // Catch: Throwable -> L22
            final int dataRequestObserverId = WearableSensingManagerService.m9571$$Nest$fgetmNextDataRequestObserverId(this.this$0).getAndIncrement();     // Catch: Throwable -> L22
            WearableSensingManagerService.m9570$$Nest$fgetmDataRequestObserverContexts(this.this$0).add(new DataRequestObserverContext(dataType, userId, dataRequestObserverId, dataRequestPendingIntent, dataRequestCallback));     // Catch: Throwable -> L20
            final RemoteCallback dataRequestCallback2 = dataRequestCallback;
        L17:
            monitor-exit(r7);     // Catch: Throwable -> L20
            WearableSensingManagerService.m9572$$Nest$mcallPerUserServiceIfExist(this.this$0, new WearableSensingManagerService$WearableSensingManagerInternal$$ExternalSyntheticLambda6(dataType, dataRequestCallback2, dataRequestObserverId, dataRequestPendingIntent, statusCallback), statusCallback);
            return;
        L26:
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Received duplicate data request observer.");     // Catch: Throwable -> L12
            RemoteCallback dataRequestCallback3 = previousObserverContext.mDataRequestRemoteCallback;     // Catch: Throwable -> L12
            dataRequestObserverId = previousObserverContext.mDataRequestObserverId;     // Catch: Throwable -> L12
            dataRequestCallback2 = dataRequestCallback3;
        L12:
            th = th;
        L24:
            monitor-exit(r7);     // Catch: Throwable -> L20
            throw th;
        L20:
            th = th;
        L22:
            th = th;
            goto L24
        }

        private static /* synthetic */ void lambda$registerDataRequestObserver$3(int dataType, RemoteCallback dataRequestCallback, int dataRequestObserverId, PendingIntent dataRequestPendingIntent, RemoteCallback statusCallback, WearableSensingManagerPerUserService service) {
            service.onRegisterDataRequestObserver(dataType, dataRequestCallback, dataRequestObserverId, dataRequestPendingIntent.getCreatorPackage(), statusCallback);
        }

        public void unregisterDataRequestObserver(final int dataType, PendingIntent dataRequestPendingIntent, final RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal unregisterDataRequestObserver.");
            dataRequestPendingIntent.getClass();
            statusCallback.getClass();
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
            return;
        L6:
            int userId = UserHandle.getCallingUserId();
            Set r1 = WearableSensingManagerService.m9570$$Nest$fgetmDataRequestObserverContexts(this.this$0);
            monitor-enter(r1);
            DataRequestObserverContext previousObserverContext = WearableSensingManagerService.m9574$$Nest$mgetDataRequestObserverContext(this.this$0, dataType, userId, dataRequestPendingIntent);     // Catch: Throwable -> L13
            if (previousObserverContext != null) goto L15;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Previous observer not found, cannot unregister.");     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            WearableSensingManagerService.m9570$$Nest$fgetmDataRequestObserverContexts(this.this$0).remove(previousObserverContext);     // Catch: Throwable -> L13
            final int previousDataRequestObserverId = previousObserverContext.mDataRequestObserverId;     // Catch: Throwable -> L13
            final String pendingIntentCreatorPackage = previousObserverContext.mDataRequestPendingIntent.getCreatorPackage();     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            WearableSensingManagerService.m9572$$Nest$mcallPerUserServiceIfExist(this.this$0, new WearableSensingManagerService$WearableSensingManagerInternal$$ExternalSyntheticLambda0(dataType, previousDataRequestObserverId, pendingIntentCreatorPackage, statusCallback), statusCallback);
            return;
        L13:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$unregisterDataRequestObserver$4(int dataType, int previousDataRequestObserverId, String pendingIntentCreatorPackage, RemoteCallback statusCallback, WearableSensingManagerPerUserService service) {
            service.onUnregisterDataRequestObserver(dataType, previousDataRequestObserverId, pendingIntentCreatorPackage, statusCallback);
        }

        public void startHotwordRecognition(final ComponentName targetVisComponentName, final RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal startHotwordRecognition.");
            statusCallback.getClass();
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
            return;
        L6:
            WearableSensingManagerService.m9572$$Nest$mcallPerUserServiceIfExist(this.this$0, new WearableSensingManagerService$WearableSensingManagerInternal$$ExternalSyntheticLambda3(targetVisComponentName, statusCallback), statusCallback);
        }

        private static /* synthetic */ void lambda$startHotwordRecognition$5(ComponentName targetVisComponentName, RemoteCallback statusCallback, WearableSensingManagerPerUserService service) {
            service.onStartHotwordRecognition(targetVisComponentName, statusCallback);
        }

        public void stopHotwordRecognition(final RemoteCallback statusCallback) {
            Slog.i(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "WearableSensingManagerInternal stopHotwordRecognition.");
            statusCallback.getClass();
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L6;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
            return;
        L6:
            WearableSensingManagerService.m9572$$Nest$mcallPerUserServiceIfExist(this.this$0, new WearableSensingManagerService$WearableSensingManagerInternal$$ExternalSyntheticLambda4(statusCallback), statusCallback);
        }

        private static /* synthetic */ void lambda$stopHotwordRecognition$6(RemoteCallback statusCallback, WearableSensingManagerPerUserService service) {
            service.onStopHotwordRecognition(statusCallback);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new WearableSensingShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        private WearableSensingManagerPerUserService validateAndGetPerUserService(RemoteCallback statusCallback) {
            WearableSensingManagerService.m9569$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_WEARABLE_SENSING_SERVICE", WearableSensingManagerService.m9575$$Nest$sfgetTAG());
            if (this.this$0.mIsServiceEnabled == true) goto L8;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available.");
            if (statusCallback == null) goto L7;
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
        L7:
            return null;
        L8:
            int userId = UserHandle.getCallingUserId();
            Object r3 = WearableSensingManagerService.access$000(this.this$0);
            monitor-enter(r3);
            WearableSensingManagerPerUserService service = (WearableSensingManagerPerUserService) WearableSensingManagerService.access$100(this.this$0, userId);     // Catch: Throwable -> L18
            monitor-exit(r3);     // Catch: Throwable -> L18
            if (service != null) goto L17;
            Slog.w(WearableSensingManagerService.m9575$$Nest$sfgetTAG(), "Service not available for userId " + userId);
            if (statusCallback == null) goto L16;
            WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);
        L16:
            return null;
        L17:
            return service;
        L18:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$J08FE5kNsft-VdA0ASZk1__BW-g, reason: not valid java name */
    public static /* synthetic */ void m9567$r8$lambda$J08FE5kNsftVdA0ASZk1__BWg(WearableSensingManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$onBootPhase$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$nHVXgRQeoOfy3XNoZ7_sTh6Q-tc, reason: not valid java name */
    public static /* synthetic */ void m9568$r8$lambda$nHVXgRQeoOfy3XNoZ7_sTh6Qtc(WearableSensingManagerService r0, int r1, PendingIntent r2, Bundle r3) {
        r0.lambda$createDataRequestRemoteCallback$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9569$$Nest$fgetmContext(WearableSensingManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataRequestObserverContexts, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m9570$$Nest$fgetmDataRequestObserverContexts(WearableSensingManagerService r0) {
        return r0.mDataRequestObserverContexts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextDataRequestObserverId, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m9571$$Nest$fgetmNextDataRequestObserverId(WearableSensingManagerService r0) {
        return r0.mNextDataRequestObserverId;
    }

    /* JADX INFO: renamed from: -$$Nest$mcallPerUserServiceIfExist, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9572$$Nest$mcallPerUserServiceIfExist(WearableSensingManagerService r0, Consumer r1, RemoteCallback r2) {
        r0.callPerUserServiceIfExist(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateDataRequestRemoteCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallback m9573$$Nest$mcreateDataRequestRemoteCallback(WearableSensingManagerService r0, PendingIntent r1, int r2) {
        return r0.createDataRequestRemoteCallback(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDataRequestObserverContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ DataRequestObserverContext m9574$$Nest$mgetDataRequestObserverContext(WearableSensingManagerService r0, int r1, int r2, PendingIntent r3) {
        return r0.getDataRequestObserverContext(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9575$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ Object access$000(WearableSensingManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$100(WearableSensingManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ void onServiceRemoved(AbstractPerUserSystemService r1, int r2) {
        onServiceRemoved((WearableSensingManagerPerUserService) r1, r2);
    }

    static {
        TAG = WearableSensingManagerService.class.getSimpleName();
        RATE_LIMITER_TAG = WearableSensingManagerService.class.getSimpleName();
    }

    public WearableSensingManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_intrusionDetectionEventTransport), null, 68);
        this.mNextDataRequestObserverId = new AtomicInteger(1);
        this.mDataRequestObserverContexts = new HashSet();
        this.mContext = context;
        this.mDataRequestRateLimiter = new MultiRateLimiter.Builder(context).addRateLimit(WearableSensingDataRequest.getRateLimit(), WearableSensingDataRequest.getRateLimitWindowSize()).build();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("wearable_sensing", new WearableSensingManagerInternal(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService, com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        DeviceConfig.addOnPropertiesChangedListener("wearable_sensing", getContext().getMainExecutor(), new WearableSensingManagerService$$ExternalSyntheticLambda1(this));
        this.mIsServiceEnabled = DeviceConfig.getBoolean("wearable_sensing", KEY_SERVICE_ENABLED, true);
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    private void onDeviceConfigChange(Set<String> keys) {
        if (keys.contains(KEY_SERVICE_ENABLED) == false) goto L6;
        this.mIsServiceEnabled = DeviceConfig.getBoolean("wearable_sensing", KEY_SERVICE_ENABLED, true);
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected WearableSensingManagerPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new WearableSensingManagerPerUserService(this, this.mLock, resolvedUserId);
    }

    protected void onServiceRemoved(WearableSensingManagerPerUserService service, int userId) {
        Slog.d(TAG, "onServiceRemoved");
        service.destroyLocked();
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageRestartedLocked(int userId) {
        Slog.d(TAG, "onServicePackageRestartedLocked.");
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatedLocked(int userId) {
        Slog.d(TAG, "onServicePackageUpdatedLocked.");
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        if (Build.isDebuggable() == false) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return 30000;
    }

    public ComponentName getComponentName(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WearableSensingManagerPerUserService service = getServiceForUserLocked(userId);     // Catch: Throwable -> L9
        if (service == null) goto L12;
        ComponentName r2 = service.getComponentName();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    void provideDataStream(int userId, ParcelFileDescriptor parcelFileDescriptor, RemoteCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WearableSensingManagerPerUserService mService = getServiceForUserLocked(userId);     // Catch: Throwable -> L7
        if (mService == null) goto L9;
        mService.onProvideDataStream(parcelFileDescriptor, null, callback);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.w(TAG, "Service not available.");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void provideData(int userId, PersistableBundle data, SharedMemory sharedMemory, RemoteCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WearableSensingManagerPerUserService mService = getServiceForUserLocked(userId);     // Catch: Throwable -> L7
        if (mService == null) goto L9;
        mService.onProvidedData(data, sharedMemory, callback);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.w(TAG, "Service not available.");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void setDataRequestRateLimitWindowSize(Duration windowSize) {
        Slog.w(TAG, TextUtils.formatSimple("Setting the data request rate limit window size to %s. This also resets the current limit and should only be callable from a test.", new Object[]{windowSize}));
        this.mDataRequestRateLimiter = new MultiRateLimiter.Builder(this.mContext).addRateLimit(WearableSensingDataRequest.getRateLimit(), windowSize).build();
    }

    void resetDataRequestRateLimitWindowSize() {
        Slog.w(TAG, "Resetting the data request rate limit window size back to the default value. This also resets the current limit and should only be callable from a test.");
        this.mDataRequestRateLimiter = new MultiRateLimiter.Builder(this.mContext).addRateLimit(WearableSensingDataRequest.getRateLimit(), WearableSensingDataRequest.getRateLimitWindowSize()).build();
    }

    private DataRequestObserverContext getDataRequestObserverContext(int dataType, int userId, PendingIntent dataRequestPendingIntent) {
        Set<DataRequestObserverContext> r0 = this.mDataRequestObserverContexts;
        monitor-enter(r0);
        Iterator<DataRequestObserverContext> r1 = this.mDataRequestObserverContexts.iterator();     // Catch: Throwable -> L15
    L6:
        if (r1.hasNext() == false) goto L18;
        DataRequestObserverContext observerContext = r1.next();     // Catch: Throwable -> L15
        if (observerContext.mDataType != dataType) goto L6;
        if (observerContext.mUserId != userId) goto L6;
        if (observerContext.mDataRequestPendingIntent.equals(dataRequestPendingIntent) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return observerContext;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    private RemoteCallback createDataRequestRemoteCallback(final PendingIntent dataRequestPendingIntent, final int userId) {
        return new RemoteCallback(new WearableSensingManagerService$$ExternalSyntheticLambda0(this, userId, dataRequestPendingIntent));
    }

    private /* synthetic */ void lambda$createDataRequestRemoteCallback$1(int userId, PendingIntent dataRequestPendingIntent, Bundle bundle) {
        WearableSensingDataRequest dataRequest = (WearableSensingDataRequest) bundle.getParcelable("android.app.wearable.WearableSensingDataRequestBundleKey", WearableSensingDataRequest.class);
        if (dataRequest != null) goto L6;
        Slog.e(TAG, "Received data request callback without a request.");
        return;
    L6:
        RemoteCallback dataRequestStatusCallback = (RemoteCallback) bundle.getParcelable("android.app.wearable.WearableSensingDataRequestStatusCallbackBundleKey", RemoteCallback.class);
        if (dataRequestStatusCallback != null) goto L11;
        Slog.e(TAG, "Received data request callback without a status callback.");
        return;
    L11:
        if (dataRequest.getDataSize() <= WearableSensingDataRequest.getMaxRequestSize()) goto L15;
        Slog.w(TAG, TextUtils.formatSimple("WearableSensingDataRequest size exceeds the maximum allowed size of %s bytes. Dropping the request.", new Object[]{Integer.valueOf(WearableSensingDataRequest.getMaxRequestSize())}));
        WearableSensingManagerPerUserService.notifyStatusCallback(dataRequestStatusCallback, 3);
        return;
    L15:
        if (this.mDataRequestRateLimiter.isWithinQuota(userId, "android", RATE_LIMITER_TAG) == true) goto L18;
        Slog.w(TAG, "Data request exceeded rate limit. Dropping the request.");
        WearableSensingManagerPerUserService.notifyStatusCallback(dataRequestStatusCallback, 4);
        return;
    L18:
        Intent intent = new Intent();
        intent.putExtra("android.app.wearable.extra.WEARABLE_SENSING_DATA_REQUEST", dataRequest);
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setPendingIntentBackgroundActivityStartMode(2);
        this.mDataRequestRateLimiter.noteEvent(userId, "android", RATE_LIMITER_TAG);
        long previousCallingIdentity = Binder.clearCallingIdentity();
        dataRequestPendingIntent.send(getContext(), 0, intent, null, null, null, options.toBundle());     // Catch: Throwable -> L23 PendingIntent.CanceledException -> L25
        WearableSensingManagerPerUserService.notifyStatusCallback(dataRequestStatusCallback, 1);     // Catch: Throwable -> L23 PendingIntent.CanceledException -> L25
        Slog.i(TAG, TextUtils.formatSimple("Sending data request to %s: %s", new Object[]{dataRequestPendingIntent.getCreatorPackage(), dataRequest.toExpandedString()}));     // Catch: Throwable -> L23 PendingIntent.CanceledException -> L25
        Binder.restoreCallingIdentity(previousCallingIdentity);
    L38:
        return;
    L23:
        th = th;
    L36:
        Binder.restoreCallingIdentity(previousCallingIdentity);
        throw th;
    L30:
        String r8 = TAG;     // Catch: Throwable -> L23
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L23
        r9.append("Could not deliver pendingIntent: ");     // Catch: Throwable -> L23
        r9.append(dataRequestPendingIntent);     // Catch: Throwable -> L35
        Slog.w(r8, r9.toString());     // Catch: Throwable -> L35
        WearableSensingManagerPerUserService.notifyStatusCallback(dataRequestStatusCallback, 2);     // Catch: Throwable -> L35
        Binder.restoreCallingIdentity(previousCallingIdentity);
    L35:
        th = th;
        goto L36
    }

    private void callPerUserServiceIfExist(Consumer<WearableSensingManagerPerUserService> serviceConsumer, RemoteCallback statusCallback) {
        int userId = UserHandle.getCallingUserId();
        Object r1 = this.mLock;
        monitor-enter(r1);
        WearableSensingManagerPerUserService service = getServiceForUserLocked(userId);     // Catch: Throwable -> L9
        if (service != null) goto L13;
        Slog.w(TAG, "Service not available for userId " + userId);     // Catch: Throwable -> L9
        if (statusCallback == null) goto L11;
        WearableSensingManagerPerUserService.notifyStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L13:
        serviceConsumer.accept(service);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}

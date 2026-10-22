package com.android.server.ambientcontext;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.AppGlobals;
import android.app.BroadcastOptions;
import android.app.PendingIntent;
import android.app.ambientcontext.AmbientContextEvent;
import android.app.ambientcontext.AmbientContextEventRequest;
import android.app.ambientcontext.IAmbientContextObserver;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.service.ambientcontext.AmbientContextDetectionResult;
import android.service.ambientcontext.AmbientContextDetectionServiceStatus;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.server.infra.AbstractPerUserSystemService;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
abstract class AmbientContextManagerPerUserService extends AbstractPerUserSystemService<AmbientContextManagerPerUserService, AmbientContextManagerService> {
    private static final String TAG = null;

    static final enum ServiceType extends Enum<ServiceType> {
        private static final /* synthetic */ ServiceType[] $VALUES = null;
        public static final ServiceType DEFAULT = null;
        public static final ServiceType WEARABLE = null;

        private static /* synthetic */ ServiceType[] $values() {
            return new ServiceType[]{DEFAULT, WEARABLE};
        }

        private ServiceType(String r1, int r2) {
            super(r1, r2);
        }

        public static ServiceType valueOf(String name) {
            return (ServiceType) Enum.valueOf(ServiceType.class, name);
        }

        public static ServiceType[] values() {
            return (ServiceType[]) $VALUES.clone();
        }

        static {
            DEFAULT = new ServiceType("DEFAULT", 0);
            WEARABLE = new ServiceType("WEARABLE", 1);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ void $r8$lambda$Q1fXi1AOjdUwDAZBqospBgmQ11o(AmbientContextManagerPerUserService r0, Bundle r1) {
        r0.lambda$createDetectionResultRemoteCallback$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZNLujgEwFNbhdKMx0dK4yHaMtvQ(AmbientContextManagerPerUserService r0, RemoteCallback r1, Integer r2) {
        r0.lambda$onQueryServiceStatus$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$ZqWY5zqF0pX4oq8c_sJNpkntXpE(Consumer r0, Bundle r1) {
        lambda$getServerStatusCallback$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$aO9bcGVTbpeFQ8NV4Fq_3mncSd0(AmbientContextManagerPerUserService r0, IAmbientContextObserver r1, Integer r2) {
        r0.lambda$startDetection$1(r1, r2);
    }

    abstract void clearRemoteService();

    abstract void ensureRemoteServiceInitiated();

    abstract int getAmbientContextEventArrayExtraKeyConfig();

    abstract int getAmbientContextPackageNameExtraKeyConfig();

    abstract ComponentName getComponentName();

    abstract int getConsentComponentConfig();

    abstract String getProtectedBindPermission();

    abstract RemoteAmbientDetectionService getRemoteService();

    abstract ServiceType getServiceType();

    abstract void setComponentName(ComponentName r1);

    static {
        TAG = AmbientContextManagerPerUserService.class.getSimpleName();
    }

    AmbientContextManagerPerUserService(AmbientContextManagerService master, Object lock, int userId) {
        super(master, lock, userId);
    }

    public void onQueryServiceStatus(int[] eventTypes, String callingPackage, final RemoteCallback statusCallback) {
        Slog.d(TAG, "Query event status of " + Arrays.toString(eventTypes) + " for " + callingPackage);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        sendStatusCallback(statusCallback, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L9
        getRemoteService().queryServiceStatus(eventTypes, callingPackage, getServerStatusCallback(new AmbientContextManagerPerUserService$$ExternalSyntheticLambda1(this, statusCallback)));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private /* synthetic */ void lambda$onQueryServiceStatus$0(RemoteCallback statusCallback, Integer statusCode) {
        sendStatusCallback(statusCallback, statusCode.intValue());
    }

    public void onUnregisterObserver(String callingPackage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        stopDetection(callingPackage);     // Catch: Throwable -> L7
        ((AmbientContextManagerService) this.mMaster).clientRemoved(this.mUserId, callingPackage);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onStartConsentActivity(int[] eventTypes, String callingPackage) {
        Slog.d(TAG, "Opening consent activity of " + Arrays.toString(eventTypes) + " for " + callingPackage);
        int userId = getUserId();
        ParceledListSlice<ActivityManager.RecentTaskInfo> recentTasks = ActivityTaskManager.getService().getRecentTasks(1, 0, userId);     // Catch: RemoteException -> L38
        if (recentTasks != null) goto L6;
    L36:
        Slog.e(TAG, "Recent task list is empty!");
        return;
    L6:
        if (recentTasks.getList().isEmpty() == true) goto L36;
        ActivityManager.RecentTaskInfo task = (ActivityManager.RecentTaskInfo) recentTasks.getList().get(0);
        if (callingPackage.equals(task.topActivityInfo.packageName) == true) goto L12;
        Slog.e(TAG, "Recent task package name: " + task.topActivityInfo.packageName + " doesn't match with client package name: " + callingPackage);
        return;
    L12:
        ComponentName consentComponent = getConsentComponent();
        if (consentComponent != null) goto L16;
        Slog.e(TAG, "Consent component not found!");
        return;
    L16:
        Slog.d(TAG, "Starting consent activity for " + callingPackage);
        Intent intent = new Intent();
        long identity = Binder.clearCallingIdentity();
        Context context = getContext();     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
        String packageNameExtraKey = context.getResources().getString(getAmbientContextPackageNameExtraKeyConfig());     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
        String eventArrayExtraKey = context.getResources().getString(getAmbientContextEventArrayExtraKeyConfig());     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
        intent.setComponent(consentComponent);     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
        if (packageNameExtraKey == null) goto L24;
        intent.putExtra(packageNameExtraKey, callingPackage);     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
    L25:
        if (eventArrayExtraKey == null) goto L27;
        intent.putExtra(eventArrayExtraKey, eventTypes);     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
    L28:
        ActivityOptions options = ActivityOptions.makeBasic();     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
        options.setLaunchTaskId(task.taskId);     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
        context.startActivityAsUser(intent, options.toBundle(), context.getUser());     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
    L29:
        Binder.restoreCallingIdentity(identity);
        return;
        goto L31
    L27:
        Slog.d(TAG, "Missing eventArrayExtraKey for consent activity");     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
        goto L28
    L24:
        Slog.d(TAG, "Missing packageNameExtraKey for consent activity");     // Catch: Throwable -> L20 ActivityNotFoundException -> L22
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L31:
        Slog.e(TAG, "unable to start consent activity");     // Catch: Throwable -> L20
    L39:
        Slog.e(TAG, "Failed to query recent tasks!");
    }

    public void onRegisterObserver(AmbientContextEventRequest request, String packageName, IAmbientContextObserver observer) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == true) goto L11;
        Slog.w(TAG, "Detection service is not available at this moment.");     // Catch: Throwable -> L9
        completeRegistration(observer, 3);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        startDetection(request, packageName, observer);     // Catch: Throwable -> L9
        ((AmbientContextManagerService) this.mMaster).newClientAdded(this.mUserId, request, packageName, observer);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        Slog.d(TAG, "newServiceInfoLocked with component name: " + serviceComponent.getClassName());
        if (getComponentName() != null) goto L5;
    L20:
        Slog.d(TAG, "service name does not match this per user, returning...");
        return null;
    L5:
        if (serviceComponent.getClassName().equals(getComponentName().getClassName()) == false) goto L20;
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 0, this.mUserId);     // Catch: RemoteException -> L14
        if (serviceInfo == null) goto L17;
        String permission = serviceInfo.permission;     // Catch: RemoteException -> L14
        if (getProtectedBindPermission().equals(permission) == true) goto L17;
        throw new SecurityException(String.format("Service %s requires %s permission. Found %s permission", new Object[]{serviceInfo.getComponentName(), getProtectedBindPermission(), serviceInfo.permission}));     // Catch: RemoteException -> L14
    L17:
        return serviceInfo;
    L19:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected void dumpLocked(String prefix, PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        super.dumpLocked(prefix, pw);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        RemoteAmbientDetectionService remoteService = getRemoteService();
        if (remoteService == null) goto L15;
        remoteService.dump("", new IndentingPrintWriter(pw, "  "));
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected void stopDetection(String packageName) {
        Slog.d(TAG, "Stop detection for " + packageName);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (getComponentName() == null) goto L9;
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L7
        RemoteAmbientDetectionService remoteService = getRemoteService();     // Catch: Throwable -> L7
        remoteService.stopDetection(packageName);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    protected void destroyLocked() {
        Slog.d(TAG, "Trying to cancel the remote request. Reason: Service destroyed.");
        RemoteAmbientDetectionService remoteService = getRemoteService();
        if (remoteService == null) goto L12;
        Object r1 = this.mLock;
        monitor-enter(r1);
        remoteService.unbind();     // Catch: Throwable -> L9
        clearRemoteService();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    protected void startDetection(AmbientContextEventRequest request, String callingPackage, final IAmbientContextObserver observer) {
        Slog.d(TAG, "Requested detection of " + request.getEventTypes());
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (setUpServiceIfNeeded() == false) goto L9;
        ensureRemoteServiceInitiated();     // Catch: Throwable -> L7
        RemoteAmbientDetectionService remoteService = getRemoteService();     // Catch: Throwable -> L7
        remoteService.startDetection(request, callingPackage, createDetectionResultRemoteCallback(), getServerStatusCallback(new AmbientContextManagerPerUserService$$ExternalSyntheticLambda3(this, observer)));     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.w(TAG, "No valid component found for AmbientContextDetectionService");     // Catch: Throwable -> L7
        completeRegistration(observer, 2);     // Catch: Throwable -> L7
        goto L10
    }

    private /* synthetic */ void lambda$startDetection$1(IAmbientContextObserver observer, Integer statusCode) {
        completeRegistration(observer, statusCode.intValue());
    }

    protected void completeRegistration(IAmbientContextObserver observer, int statusCode) {
        observer.onRegistrationComplete(statusCode);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to call IAmbientContextObserver.onRegistrationComplete: " + e.getMessage());
    }

    protected void sendStatusCallback(RemoteCallback statusCallback, int statusCode) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.app.ambientcontext.AmbientContextStatusBundleKey", statusCode);
        statusCallback.sendResult(bundle);
    }

    protected void sendDetectionResultIntent(PendingIntent pendingIntent, List<AmbientContextEvent> events) {
        Intent intent = new Intent();
        intent.putExtra("android.app.ambientcontext.extra.AMBIENT_CONTEXT_EVENTS", new ArrayList(events));
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setPendingIntentBackgroundActivityLaunchAllowed(false);
        PendingIntent pendingIntent2 = pendingIntent;
        pendingIntent2.send(getContext(), 0, intent, null, null, null, options.toBundle());     // Catch: PendingIntent.CanceledException -> L7
        Slog.i(TAG, "Sending PendingIntent to " + pendingIntent2.getCreatorPackage() + ": " + events);     // Catch: PendingIntent.CanceledException -> L7
        return;
    L11:
        Slog.w(TAG, "Couldn't deliver pendingIntent:" + pendingIntent2);
        return;
    L10:
        pendingIntent2 = pendingIntent;
        goto L11
    }

    protected RemoteCallback createDetectionResultRemoteCallback() {
        return new RemoteCallback(new AmbientContextManagerPerUserService$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$createDetectionResultRemoteCallback$2(Bundle result) {
        AmbientContextDetectionResult detectionResult = (AmbientContextDetectionResult) result.get("android.app.ambientcontext.AmbientContextDetectionResultBundleKey");
        String packageName = detectionResult.getPackageName();
        IAmbientContextObserver observer = ((AmbientContextManagerService) this.mMaster).getClientRequestObserver(this.mUserId, packageName);
        if (observer != null) goto L5;
        return;
    L5:
        long token = Binder.clearCallingIdentity();
        observer.onEvents(detectionResult.getEvents());     // Catch: Throwable -> L8 RemoteException -> L10
        Slog.i(TAG, "Got detection result of " + detectionResult.getEvents() + " for " + packageName);     // Catch: Throwable -> L8 RemoteException -> L10
    L7:
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to call IAmbientContextObserver.onEvents: " + e.getMessage());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean setUpServiceIfNeeded() {
        if (getComponentName() != null) goto L18;
        ComponentName[] componentNames = updateServiceInfoListLocked();
        if (componentNames != null) goto L7;
    L15:
        Slog.d(TAG, "updateServiceInfoListLocked returned incorrect componentNames");
        return false;
    L7:
        if (componentNames.length != 2) goto L15;
        switch(getServiceType().ordinal()) {
            case 0: goto L14;
            case 1: goto L13;
            default: goto L11;
        };
    L11:
        Slog.d(TAG, "updateServiceInfoListLocked returned unknown service types.");
        return false;
    L13:
        setComponentName(componentNames[1]);
        goto L18
    L14:
        setComponentName(componentNames[0]);
    L18:
        if (getComponentName() != null) goto L28;
        return false;
    L28:
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(getComponentName(), 0, this.mUserId);     // Catch: RemoteException -> L25
        if (serviceInfo == null) goto L24;
        return true;
    L24:
        return false;
    L26:
        Slog.w(TAG, "RemoteException while setting up service");
        return false;
    }

    private RemoteCallback getServerStatusCallback(final Consumer<Integer> statusConsumer) {
        return new RemoteCallback(new AmbientContextManagerPerUserService$$ExternalSyntheticLambda2(statusConsumer));
    }

    private static /* synthetic */ void lambda$getServerStatusCallback$3(Consumer statusConsumer, Bundle result) {
        AmbientContextDetectionServiceStatus serviceStatus = (AmbientContextDetectionServiceStatus) result.get("android.app.ambientcontext.AmbientContextServiceStatusBundleKey");
        long token = Binder.clearCallingIdentity();
        int statusCode = serviceStatus.getStatusCode();     // Catch: Throwable -> L6
        statusConsumer.accept(Integer.valueOf(statusCode));     // Catch: Throwable -> L6
        Slog.i(TAG, "Got detection status of " + statusCode + " for " + serviceStatus.getPackageName());     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private ComponentName getConsentComponent() {
        Context context = getContext();
        String consentComponent = context.getResources().getString(getConsentComponentConfig());
        if (TextUtils.isEmpty(consentComponent) == false) goto L6;
        return null;
    L6:
        Slog.i(TAG, "Consent component name: " + consentComponent);
        return ComponentName.unflattenFromString(consentComponent);
    }
}

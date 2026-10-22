package com.android.server.speech;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.provider.Settings;
import android.speech.IRecognitionService;
import android.speech.IRecognitionServiceManagerCallback;
import android.util.Log;
import android.util.Slog;
import android.util.SparseIntArray;
import com.android.modules.expresslog.Counter;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class SpeechRecognitionManagerServiceImpl extends AbstractPerUserSystemService<SpeechRecognitionManagerServiceImpl, SpeechRecognitionManagerService> {
    private static final int MAX_CONCURRENT_CONNECTIONS_BY_CLIENT = 10;
    private static final String TAG = null;
    private final Object mLock;
    private final Map<Integer, Set<RemoteSpeechRecognitionService>> mRemoteServicesByUid;
    private final SparseIntArray mSessionCountByUid;

    public static /* synthetic */ void $r8$lambda$E3jFJudA_HoGmJBAqumJ_9PfZPE(SpeechRecognitionManagerServiceImpl r0, IBinder r1, int r2, RemoteSpeechRecognitionService r3) {
        r0.lambda$createSessionLocked$0(r1, r2, r3);
    }

    public static /* synthetic */ Set $r8$lambda$ENbqGOo6dOvdEapT62e6pYlaMwg(Integer r0) {
        return lambda$createService$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$FBJSlkBgJtBBMv7YKotS5EQM_7k(SpeechRecognitionManagerServiceImpl r0, IRecognitionServiceManagerCallback r1, RemoteSpeechRecognitionService r2, IBinder r3, int r4, IBinder.DeathRecipient r5, IRecognitionService r6) {
        r0.lambda$createSessionLocked$1(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ boolean $r8$lambda$Hp5JZgCIK5y4F14FVeVMGV4PSC4(ComponentName r0, RemoteSpeechRecognitionService r1) {
        return lambda$createService$2(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleClientDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8294$$Nest$mhandleClientDeath(SpeechRecognitionManagerServiceImpl r0, IBinder r1, int r2, RemoteSpeechRecognitionService r3, boolean r4) {
        r0.handleClientDeath(r1, r2, r3, r4);
    }

    static /* synthetic */ AbstractMasterSystemService access$000(SpeechRecognitionManagerServiceImpl x0) {
        return x0.mMaster;
    }

    static /* synthetic */ AbstractMasterSystemService access$100(SpeechRecognitionManagerServiceImpl x0) {
        return x0.mMaster;
    }

    static {
        TAG = SpeechRecognitionManagerServiceImpl.class.getSimpleName();
    }

    SpeechRecognitionManagerServiceImpl(SpeechRecognitionManagerService master, Object lock, int userId) {
        super(master, lock, userId);
        this.mLock = new Object();
        this.mRemoteServicesByUid = new HashMap();
        this.mSessionCountByUid = new SparseIntArray();
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        return AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);
    L6:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected boolean updateLocked(boolean disabled) {
        boolean enabledChanged = super.updateLocked(disabled);
        return enabledChanged;
    }

    void createSessionLocked(ComponentName componentName, final IBinder clientToken, boolean onDevice, final IRecognitionServiceManagerCallback callback) {
        if (((SpeechRecognitionManagerService) this.mMaster).debug == false) goto L6;
        Slog.i(TAG, String.format("#createSessionLocked, component=%s, onDevice=%s", new Object[]{componentName, Boolean.valueOf(onDevice)}));
    L6:
        if (onDevice == false) goto L8;
        ComponentName serviceComponent = getOnDeviceComponentNameLocked();
        ComponentName serviceComponent2 = serviceComponent;
    L10:
        if (onDevice == false) goto L12;
    L15:
        if (serviceComponent2 == null) goto L17;
        final int creatorCallingUid = Binder.getCallingUid();
        final RemoteSpeechRecognitionService service = createService(creatorCallingUid, serviceComponent2);
        if (service != null) goto L25;
        tryRespondWithError(callback, 10);
        return;
    L25:
        final IBinder.DeathRecipient deathRecipient = new SpeechRecognitionManagerServiceImpl$$ExternalSyntheticLambda2(this, clientToken, creatorCallingUid, service);
        clientToken.linkToDeath(deathRecipient, 0);     // Catch: RemoteException -> L29
        service.connect().thenAccept(new SpeechRecognitionManagerServiceImpl$$ExternalSyntheticLambda3(this, callback, service, clientToken, creatorCallingUid, deathRecipient));
        return;
    L30:
        handleClientDeath(clientToken, creatorCallingUid, service, true);
        return;
    L17:
        if (((SpeechRecognitionManagerService) this.mMaster).debug == false) goto L19;
        Slog.i(TAG, "Service component is undefined, responding with error.");
    L19:
        tryRespondWithError(callback, 5);
        return;
    L12:
        if (Process.isIsolated(Binder.getCallingUid()) == false) goto L15;
        Slog.w(TAG, "Isolated process can only start on device speech recognizer.");
        tryRespondWithError(callback, 5);
        return;
    L8:
        serviceComponent2 = componentName;
        goto L10
    }

    private /* synthetic */ void lambda$createSessionLocked$0(IBinder clientToken, int creatorCallingUid, RemoteSpeechRecognitionService service) {
        handleClientDeath(clientToken, creatorCallingUid, service, true);
    }

    private /* synthetic */ void lambda$createSessionLocked$1(IRecognitionServiceManagerCallback callback, final RemoteSpeechRecognitionService service, final IBinder clientToken, final int creatorCallingUid, final IBinder.DeathRecipient deathRecipient, IRecognitionService binderService) {
        if (binderService != null) goto L17;
        tryRespondWithError(callback, 5);
        return;
    L17:
        callback.onSuccess(new AnonymousClass1(this, service, clientToken, creatorCallingUid, deathRecipient));     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        RemoteException e = e;
    L12:
        Slog.e(TAG, "Error creating a speech recognition session", e);
        tryRespondWithError(callback, 5);
        return;
    L10:
        e = move-exception;
        e = e;
        goto L12
    }

    private void handleClientDeath(IBinder clientToken, int callingUid, RemoteSpeechRecognitionService service, boolean invokeCancel) {
        if (invokeCancel == false) goto L4;
        service.shutdown(clientToken);
    L4:
        Object r0 = this.mLock;
        monitor-enter(r0);
        decrementSessionCountForUidLocked(callingUid);     // Catch: Throwable -> L9
        if (service.hasActiveSessions() == true) goto L11;
        removeService(callingUid, service);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private ComponentName getOnDeviceComponentNameLocked() {
        String serviceName = getComponentNameLocked();
        if (((SpeechRecognitionManagerService) this.mMaster).debug == false) goto L5;
        Slog.i(TAG, "Resolved component name: " + serviceName);
    L5:
        if (serviceName != null) goto L12;
        if (((SpeechRecognitionManagerService) this.mMaster).verbose == false) goto L13;
        Slog.v(TAG, "ensureRemoteServiceLocked(): no service component name.");
        return null;
    L13:
        return null;
    L12:
        return ComponentName.unflattenFromString(serviceName);
    }

    private int getSessionCountByUidLocked(int uid) {
        return this.mSessionCountByUid.get(uid, 0);
    }

    private void incrementSessionCountForUidLocked(int uid) {
        this.mSessionCountByUid.put(uid, this.mSessionCountByUid.get(uid, 0) + 1);
        Log.i(TAG, "Client " + uid + " has opened " + this.mSessionCountByUid.get(uid, 0) + " sessions");
    }

    private void decrementSessionCountForUidLocked(int uid) {
        int newCount = this.mSessionCountByUid.get(uid, 1) - 1;
        if (newCount <= 0) goto L5;
        this.mSessionCountByUid.put(uid, newCount);
        return;
    L5:
        this.mSessionCountByUid.delete(uid);
    }

    private RemoteSpeechRecognitionService createService(int callingUid, final ComponentName serviceComponent) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        Set<RemoteSpeechRecognitionService> servicesForClient = this.mRemoteServicesByUid.get(Integer.valueOf(callingUid));     // Catch: Throwable -> L44
        if (servicesForClient == null) goto L15;
    L12:
        th = th;
    L46:
        monitor-exit(r1);     // Catch: Throwable -> L39
        throw th;
    L8:
        if (servicesForClient.size() < 10) goto L15;
        Slog.w(TAG, "Number of remote services exceeded for uid: " + callingUid);     // Catch: Throwable -> L12
        Counter.logIncrementWithUid("speech_recognition.value_exceed_service_connections_count", callingUid);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return null;
    L15:
        if (getSessionCountByUidLocked(callingUid) != 10) goto L17;
        Slog.w(TAG, "Number of sessions exceeded for uid: " + callingUid);     // Catch: Throwable -> L12
        Counter.logIncrementWithUid("speech_recognition.value_exceed_session_count", callingUid);     // Catch: Throwable -> L12
    L17:
        if (servicesForClient == null) goto L26;
        Optional<RemoteSpeechRecognitionService> existingService = servicesForClient.stream().filter(new SpeechRecognitionManagerServiceImpl$$ExternalSyntheticLambda0(serviceComponent)).findFirst();     // Catch: Throwable -> L12
        if (existingService.isPresent() == false) goto L26;
        if (((SpeechRecognitionManagerService) this.mMaster).debug == false) goto L23;
        Slog.i(TAG, "Reused existing connection to " + serviceComponent);     // Catch: Throwable -> L12
    L23:
        incrementSessionCountForUidLocked(callingUid);     // Catch: Throwable -> L12
        RemoteSpeechRecognitionService r2 = existingService.get();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return r2;
    L26:
        if (serviceComponent != null) goto L28;
    L31:
        if (serviceComponent != null) goto L33;
        boolean isPrivileged = false;
    L34:
        RemoteSpeechRecognitionService service = new RemoteSpeechRecognitionService(getContext(), serviceComponent, getUserId(), callingUid, isPrivileged);     // Catch: Throwable -> L39
        Set<RemoteSpeechRecognitionService> valuesByCaller = this.mRemoteServicesByUid.computeIfAbsent(Integer.valueOf(callingUid), new SpeechRecognitionManagerServiceImpl$$ExternalSyntheticLambda1());     // Catch: Throwable -> L39
        valuesByCaller.add(service);     // Catch: Throwable -> L39
        if (((SpeechRecognitionManagerService) this.mMaster).debug == false) goto L41;
        Slog.i(TAG, "Creating a new connection to " + serviceComponent);     // Catch: Throwable -> L39
    L41:
        incrementSessionCountForUidLocked(callingUid);     // Catch: Throwable -> L39
        monitor-exit(r1);     // Catch: Throwable -> L39
        return service;
    L33:
        boolean isPrivileged2 = checkPrivilege(serviceComponent);     // Catch: Throwable -> L44
        isPrivileged = isPrivileged2;
        goto L34
    L28:
        if (componentMapsToRecognitionService(serviceComponent) == true) goto L31;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return null;
    L39:
        th = th;
    L44:
        th = th;
        goto L46
    }

    private static /* synthetic */ boolean lambda$createService$2(ComponentName serviceComponent, RemoteSpeechRecognitionService service) {
        return service.getServiceComponentName().equals(serviceComponent);
    }

    private static /* synthetic */ Set lambda$createService$3(Integer key) {
        return new HashSet();
    }

    private boolean checkPrivilege(ComponentName serviceComponent) {
        ComponentName defaultComponent = getDefaultRecognitionServiceComponent();
        ComponentName onDeviceComponent = getOnDeviceComponentNameLocked();
        boolean preinstalled = isPreinstalledApp(serviceComponent);
        if (serviceComponent.equals(defaultComponent) == false) goto L5;
    L9:
        return true;
    L5:
        if (serviceComponent.equals(onDeviceComponent) == true) goto L9;
        if (preinstalled == true) goto L9;
        return false;
    }

    private boolean isPreinstalledApp(ComponentName serviceComponent) {
        PackageManager pm = getContext().getPackageManager();
        if (pm != null) goto L12;
        return false;
    L12:
        ApplicationInfo info = pm.getApplicationInfoAsUser(serviceComponent.getPackageName(), 1048576, getUserId());     // Catch: PackageManager.NameNotFoundException -> L10
        if ((info.flags & 1) != 0) goto L9;
        return false;
    L9:
        return true;
    L11:
        return false;
    }

    private ComponentName getDefaultRecognitionServiceComponent() {
        String componentName = Settings.Secure.getStringForUser(getContext().getContentResolver(), "voice_recognition_service", getUserId());
        if (componentName != null) goto L7;
        return null;
    L7:
        return ComponentName.unflattenFromString(componentName);
    }

    private boolean componentMapsToRecognitionService(ComponentName serviceComponent) {
        long identityToken = Binder.clearCallingIdentity();
        List<ResolveInfo> resolveInfos = getContext().getPackageManager().queryIntentServicesAsUser(new Intent("android.speech.RecognitionService"), 0, getUserId());     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identityToken);
        if (resolveInfos != null) goto L7;
        return false;
    L7:
        Iterator<ResolveInfo> r3 = resolveInfos.iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        ResolveInfo ri = r3.next();
        if (ri.serviceInfo == null) goto L9;
        if (serviceComponent.equals(ri.serviceInfo.getComponentName()) == false) goto L9;
        return true;
    L17:
        Slog.w(TAG, "serviceComponent is not RecognitionService: " + serviceComponent);
        return false;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    }

    private void removeService(int callingUid, RemoteSpeechRecognitionService service) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Set<RemoteSpeechRecognitionService> valuesByCaller = this.mRemoteServicesByUid.get(Integer.valueOf(callingUid));     // Catch: Throwable -> L7
        if (valuesByCaller == null) goto L9;
        valuesByCaller.remove(service);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void tryRespondWithError(IRecognitionServiceManagerCallback callback, int errorCode) {
        callback.onError(errorCode);     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.w(TAG, "Failed to respond with error");
    }
}

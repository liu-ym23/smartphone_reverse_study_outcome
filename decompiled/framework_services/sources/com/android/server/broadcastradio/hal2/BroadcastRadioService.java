package com.android.server.broadcastradio.hal2;

import android.hardware.broadcastradio.V2_0.IBroadcastRadio;
import android.hardware.radio.IAnnouncementListener;
import android.hardware.radio.ICloseHandle;
import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.RadioManager;
import android.hidl.manager.V1_0.IServiceManager;
import android.hidl.manager.V1_0.IServiceNotification;
import android.os.IHwBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.utils.Slogf;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public final class BroadcastRadioService {
    private static final String TAG = "BcRadio2Srv";
    private final IHwBinder.DeathRecipient mDeathRecipient;
    private final Object mLock;
    private final Map<Integer, RadioModule> mModules;
    private int mNextModuleId;
    private final IServiceNotification.Stub mServiceListener;
    private final Map<String, Integer> mServiceNameToModuleIdMap;
    private final RadioServiceUserController mUserController;

    /* JADX INFO: renamed from: $r8$lambda$-l3hOz6dkY4lb_QynZ2RVzaV-0s, reason: not valid java name */
    public static /* synthetic */ RadioManager.ModuleProperties m2819$r8$lambda$l3hOz6dkY4lb_QynZ2RVzaV0s(RadioModule r0) {
        return lambda$listModules$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ IHwBinder.DeathRecipient m2820$$Nest$fgetmDeathRecipient(BroadcastRadioService r0) {
        return r0.mDeathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2821$$Nest$fgetmLock(BroadcastRadioService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModules, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m2822$$Nest$fgetmModules(BroadcastRadioService r0) {
        return r0.mModules;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextModuleId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2823$$Nest$fgetmNextModuleId(BroadcastRadioService r0) {
        return r0.mNextModuleId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceNameToModuleIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m2824$$Nest$fgetmServiceNameToModuleIdMap(BroadcastRadioService r0) {
        return r0.mServiceNameToModuleIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserController, reason: not valid java name */
    static /* bridge */ /* synthetic */ RadioServiceUserController m2825$$Nest$fgetmUserController(BroadcastRadioService r0) {
        return r0.mUserController;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNextModuleId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2826$$Nest$fputmNextModuleId(BroadcastRadioService r0, int r1) {
        r0.mNextModuleId = r1;
    }

    public BroadcastRadioService(int nextModuleId, RadioServiceUserController userController) {
        this.mLock = new Object();
        this.mServiceNameToModuleIdMap = new ArrayMap();
        this.mModules = new ArrayMap();
        this.mServiceListener = new AnonymousClass1(this);
        this.mDeathRecipient = new AnonymousClass2(this);
        this.mNextModuleId = nextModuleId;
        userController.getClass();
        this.mUserController = userController;
        IServiceManager manager = IServiceManager.getService();     // Catch: RemoteException -> L7
        if (manager != null) goto L9;
        Slogf.e(TAG, "failed to get HIDL Service Manager");     // Catch: RemoteException -> L7
        return;
    L9:
        manager.registerForNotifications(IBroadcastRadio.kInterfaceName, "", this.mServiceListener);     // Catch: RemoteException -> L7
        return;
    L7:
        ex = move-exception;
        Slogf.e(TAG, "failed to register for service notifications: ", ex);
    }

    BroadcastRadioService(int nextModuleId, IServiceManager manager, RadioServiceUserController userController) {
        this.mLock = new Object();
        this.mServiceNameToModuleIdMap = new ArrayMap();
        this.mModules = new ArrayMap();
        this.mServiceListener = new AnonymousClass1(this);
        this.mDeathRecipient = new AnonymousClass2(this);
        this.mNextModuleId = nextModuleId;
        userController.getClass();
        this.mUserController = userController;
        manager.getClass();
        manager.registerForNotifications(IBroadcastRadio.kInterfaceName, "", this.mServiceListener);     // Catch: RemoteException -> L5
        return;
    L5:
        ex = move-exception;
        Slogf.e(TAG, "Failed to register for service notifications: ", ex);
    }

    public Collection<RadioManager.ModuleProperties> listModules() {
        Slogf.v(TAG, "List HIDL 2.0 modules");
        Object r0 = this.mLock;
        monitor-enter(r0);
        Collection<RadioManager.ModuleProperties> r1 = (Collection) this.mModules.values().stream().map(new BroadcastRadioService$$ExternalSyntheticLambda0()).collect(Collectors.toList());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ RadioManager.ModuleProperties lambda$listModules$0(RadioModule module) {
        return module.getProperties();
    }

    public boolean hasModule(int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mModules.containsKey(Integer.valueOf(id));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasAnyModules() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mModules.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public ITuner openSession(int moduleId, RadioManager.BandConfig legacyConfig, boolean withAudio, ITunerCallback callback) throws RemoteException {
        Slogf.v(TAG, "Open HIDL 2.0 session with module id " + moduleId);
        if (this.mUserController.isCurrentOrSystemUser() == false) goto L23;
        callback.getClass();
        if (withAudio == false) goto L22;
        Object r0 = this.mLock;
        monitor-enter(r0);
        RadioModule module = this.mModules.get(Integer.valueOf(moduleId));     // Catch: Throwable -> L15
        if (module == null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L15
        TunerSession tunerSession = module.openSession(callback);
        if (legacyConfig == null) goto L14;
        tunerSession.setConfiguration(legacyConfig);
    L14:
        return tunerSession;
    L18:
        throw new IllegalArgumentException("Invalid module ID");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L22:
        throw new IllegalArgumentException("Non-audio sessions not supported with HAL 2.0");
    L23:
        Slogf.e(TAG, "Cannot open tuner on HAL 2.0 client for non-current user");
        throw new IllegalStateException("Cannot open session for non-current user");
    }

    public ICloseHandle addAnnouncementListener(int[] enabledTypes, IAnnouncementListener listener) {
        Slogf.v(TAG, "Add announcementListener");
        AnnouncementAggregator aggregator = new AnnouncementAggregator(listener, this.mLock);
        boolean anySupported = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
        Iterator<RadioModule> r3 = this.mModules.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L15;
        RadioModule module = r3.next();     // Catch: Throwable -> L10
        aggregator.watchModule(module, enabledTypes);     // Catch: Throwable -> L10 UnsupportedOperationException -> L12
        anySupported = true;
        goto L6
    L12:
        ex = move-exception;
        Slogf.v(TAG, "Announcements not supported for this module", ex);     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r2);     // Catch: Throwable -> L10
        if (anySupported == true) goto L18;
        Slogf.i(TAG, "There are no HAL modules that support announcements");
    L18:
        return aggregator;
    L10:
        th = move-exception;
        throw th;
    }

    public void dumpInfo(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.printf("Next module id available: %d\n", new Object[]{Integer.valueOf(this.mNextModuleId)});     // Catch: Throwable -> L8
        pw.printf("ServiceName to module id map:\n", new Object[0]);     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        Iterator<Map.Entry<String, Integer>> r1 = this.mServiceNameToModuleIdMap.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, Integer> entry = r1.next();     // Catch: Throwable -> L8
        pw.printf("Service name: %s, module id: %d\n", new Object[]{entry.getKey(), entry.getValue()});     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.decreaseIndent();     // Catch: Throwable -> L8
        pw.printf("Radio modules:\n", new Object[0]);     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        Iterator<Map.Entry<Integer, RadioModule>> r2 = this.mModules.entrySet().iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<Integer, RadioModule> moduleEntry = r2.next();     // Catch: Throwable -> L8
        pw.printf("Module id=%d:\n", new Object[]{moduleEntry.getKey()});     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        moduleEntry.getValue().dumpInfo(pw);     // Catch: Throwable -> L8
        pw.decreaseIndent();     // Catch: Throwable -> L8
        goto L12
    L14:
        pw.decreaseIndent();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}

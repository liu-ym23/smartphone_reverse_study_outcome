package com.android.server.broadcastradio.aidl;

import android.hardware.broadcastradio.IBroadcastRadio;
import android.hardware.radio.IAnnouncementListener;
import android.hardware.radio.ICloseHandle;
import android.hardware.radio.ITuner;
import android.hardware.radio.ITunerCallback;
import android.hardware.radio.RadioManager;
import android.os.IBinder;
import android.os.IServiceCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.SparseArray;
import com.android.server.broadcastradio.RadioServiceUserController;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class BroadcastRadioServiceImpl {
    private static final boolean DEBUG = false;
    private static final String TAG = "BcRadioAidlSrv";
    private final Object mLock;
    private final SparseArray<RadioModule> mModules;
    private int mNextModuleId;
    private final IServiceCallback.Stub mServiceListener;
    private final Map<String, Integer> mServiceNameToModuleIdMap;
    private final RadioServiceUserController mUserController;

    private final class BroadcastRadioDeathRecipient implements IBinder.DeathRecipient {
        private final int mModuleId;
        final /* synthetic */ BroadcastRadioServiceImpl this$0;

        BroadcastRadioDeathRecipient(BroadcastRadioServiceImpl r1, int moduleId) {
            this.this$0 = r1;
            this.mModuleId = moduleId;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slogf.i(BroadcastRadioServiceImpl.TAG, "ServiceDied for module id %d", new Object[]{Integer.valueOf(this.mModuleId)});
            Object r0 = BroadcastRadioServiceImpl.m2798$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            RadioModule prevModule = (RadioModule) BroadcastRadioServiceImpl.m2799$$Nest$fgetmModules(this.this$0).removeReturnOld(this.mModuleId);     // Catch: Throwable -> L7
            if (prevModule == null) goto L9;
            prevModule.closeSessions(0);     // Catch: Throwable -> L7
        L9:
            Iterator r2 = BroadcastRadioServiceImpl.m2801$$Nest$fgetmServiceNameToModuleIdMap(this.this$0).entrySet().iterator();     // Catch: Throwable -> L7
        L11:
            if (r2.hasNext() == false) goto L16;
            Map.Entry<String, Integer> entry = (Map.Entry) r2.next();     // Catch: Throwable -> L7
            if (entry.getValue().intValue() != this.mModuleId) goto L11;
            Slogf.w(BroadcastRadioServiceImpl.TAG, "Service %s died, removed RadioModule with ID %d", new Object[]{entry.getKey(), Integer.valueOf(this.mModuleId)});     // Catch: Throwable -> L7
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2798$$Nest$fgetmLock(BroadcastRadioServiceImpl r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModules, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m2799$$Nest$fgetmModules(BroadcastRadioServiceImpl r0) {
        return r0.mModules;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextModuleId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2800$$Nest$fgetmNextModuleId(BroadcastRadioServiceImpl r0) {
        return r0.mNextModuleId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceNameToModuleIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m2801$$Nest$fgetmServiceNameToModuleIdMap(BroadcastRadioServiceImpl r0) {
        return r0.mServiceNameToModuleIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserController, reason: not valid java name */
    static /* bridge */ /* synthetic */ RadioServiceUserController m2802$$Nest$fgetmUserController(BroadcastRadioServiceImpl r0) {
        return r0.mUserController;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNextModuleId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2803$$Nest$fputmNextModuleId(BroadcastRadioServiceImpl r0, int r1) {
        r0.mNextModuleId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2804$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public BroadcastRadioServiceImpl(List<String> serviceNameList, RadioServiceUserController userController) {
        this.mLock = new Object();
        this.mServiceNameToModuleIdMap = new ArrayMap();
        this.mModules = new SparseArray();
        this.mServiceListener = new AnonymousClass1(this);
        this.mNextModuleId = 0;
        userController.getClass();
        this.mUserController = userController;
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "Initializing BroadcastRadioServiceImpl %s", new Object[]{IBroadcastRadio.DESCRIPTOR});
    L5:
        int i = 0;
    L7:
        if (i >= serviceNameList.size()) goto L14;
        ServiceManager.registerForNotifications(serviceNameList.get(i), this.mServiceListener);     // Catch: RemoteException -> L10
    L12:
        i = i + 1;
    L10:
        ex = move-exception;
        Slogf.e(TAG, ex, "failed to register for service notifications for service %s", new Object[]{serviceNameList.get(i)});
        goto L12
    }

    public List<RadioManager.ModuleProperties> listModules() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<RadioManager.ModuleProperties> moduleList = new ArrayList(this.mModules.size());     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mModules.size()) goto L11;
        moduleList.add(this.mModules.valueAt(i).getProperties());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return moduleList;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean hasModule(int id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mModules.contains(id);     // Catch: Throwable -> L7
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
        if (this.mModules.size() == 0) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public ITuner openSession(int moduleId, RadioManager.BandConfig legacyConfig, boolean withAudio, ITunerCallback callback) throws RemoteException {
        if (DEBUG == false) goto L6;
        Slogf.d(TAG, "Open AIDL radio session");
    L6:
        if (this.mUserController.isCurrentOrSystemUser() == false) goto L29;
        callback.getClass();
        if (withAudio == false) goto L28;
        Object r0 = this.mLock;
        monitor-enter(r0);
        RadioModule radioModule = this.mModules.get(moduleId);     // Catch: Throwable -> L17
        if (radioModule != null) goto L19;
        Slogf.e(TAG, "Invalid module ID %d", new Object[]{Integer.valueOf(moduleId)});     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L17
        TunerSession tunerSession = radioModule.openSession(callback);
        if (tunerSession == null) goto L24;
        if (legacyConfig == null) goto L24;
        tunerSession.setConfiguration(legacyConfig);
    L24:
        return tunerSession;
    L17:
        th = move-exception;
        throw th;
    L28:
        throw new IllegalArgumentException("Non-audio sessions not supported with AIDL HAL");
    L29:
        Slogf.e(TAG, "Cannot open tuner on AIDL HAL client for non-current user");
        throw new IllegalStateException("Cannot open session for non-current user");
    }

    public ICloseHandle addAnnouncementListener(int[] enabledTypes, IAnnouncementListener listener) {
        if (DEBUG == false) goto L5;
        Slogf.d(TAG, "Add AnnouncementListener with enable types %s", new Object[]{Arrays.toString(enabledTypes)});
    L5:
        AnnouncementAggregator aggregator = new AnnouncementAggregator(listener, this.mLock);
        boolean anySupported = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
        int i = 0;
    L26:
    L12:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mModules.size()) goto L18;
        aggregator.watchModule(this.mModules.valueAt(i), enabledTypes);     // Catch: Throwable -> L12 UnsupportedOperationException -> L14
        anySupported = true;
    L16:
        i = i + 1;     // Catch: Throwable -> L12
        goto L26
    L14:
        ex = move-exception;
        Slogf.w(TAG, ex, "Announcements not supported for this module", new Object[0]);     // Catch: Throwable -> L12
        goto L16
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L12
        if (anySupported == true) goto L21;
        Slogf.w(TAG, "There are no HAL modules that support announcements");
    L21:
        return aggregator;
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
        pw.printf("Radio modules [%d]:\n", new Object[]{Integer.valueOf(this.mModules.size())});     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        int i = 0;
    L12:
        if (i >= this.mModules.size()) goto L14;
        pw.printf("Module id=%d:\n", new Object[]{Integer.valueOf(this.mModules.keyAt(i))});     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        this.mModules.valueAt(i).dumpInfo(pw);     // Catch: Throwable -> L8
        pw.decreaseIndent();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
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

package com.android.server.am;

import android.os.IBinder;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.ServiceThread;

/* JADX INFO: loaded from: classes.dex */
public class ProcessStateController {
    public static String TAG;
    private final GlobalState mGlobalState;
    private final OomAdjuster mOomAdjuster;

    public static class Builder {
        private final ActiveUids mActiveUids;
        private final ActivityManagerService mAms;
        private CachedAppOptimizer mCachedAppOptimizer;
        private ServiceThread mHandlerThread;
        private OomAdjuster.Injector mOomAdjInjector;
        private final ProcessList mProcessList;
        private boolean mUseOomAdjusterModernImpl;

        public Builder(ActivityManagerService ams, ProcessList processList, ActiveUids activeUids) {
            this.mHandlerThread = null;
            this.mCachedAppOptimizer = null;
            this.mOomAdjInjector = null;
            this.mUseOomAdjusterModernImpl = false;
            this.mAms = ams;
            this.mProcessList = processList;
            this.mActiveUids = activeUids;
        }

        public ProcessStateController build() {
            if (this.mHandlerThread != null) goto L6;
            this.mHandlerThread = OomAdjuster.createAdjusterThread();
        L6:
            if (this.mCachedAppOptimizer != null) goto L9;
            this.mCachedAppOptimizer = new CachedAppOptimizer(this.mAms);
        L9:
            if (this.mOomAdjInjector != null) goto L12;
            this.mOomAdjInjector = new OomAdjuster.Injector();
        L12:
            return new ProcessStateController(this.mAms, this.mProcessList, this.mActiveUids, this.mHandlerThread, this.mCachedAppOptimizer, this.mOomAdjInjector, this.mUseOomAdjusterModernImpl, null);
        }

        public Builder setHandlerThread(ServiceThread handlerThread) {
            this.mHandlerThread = handlerThread;
            return this;
        }

        public Builder setCachedAppOptimizer(CachedAppOptimizer cachedAppOptimizer) {
            this.mCachedAppOptimizer = cachedAppOptimizer;
            return this;
        }

        public Builder setOomAdjusterInjector(OomAdjuster.Injector injector) {
            this.mOomAdjInjector = injector;
            return this;
        }

        public Builder useModernOomAdjuster(boolean use) {
            this.mUseOomAdjusterModernImpl = use;
            return this;
        }
    }

    private static class GlobalState implements OomAdjuster.GlobalState {
        public final SparseArray<ProcessRecord> backupTargets;
        public boolean isAwake;
        public boolean isLastMemoryLevelNormal;

        /* synthetic */ GlobalState(ProcessStateControllerIA r1) {
            this();
        }

        private GlobalState() {
            this.isAwake = true;
            this.backupTargets = new SparseArray();
            this.isLastMemoryLevelNormal = true;
        }

        @Override // com.android.server.am.OomAdjuster.GlobalState
        public boolean isAwake() {
            return this.isAwake;
        }

        @Override // com.android.server.am.OomAdjuster.GlobalState
        public ProcessRecord getBackupTarget(int userId) {
            return this.backupTargets.get(userId);
        }

        @Override // com.android.server.am.OomAdjuster.GlobalState
        public boolean isLastMemoryLevelNormal() {
            return this.isLastMemoryLevelNormal;
        }
    }

    /* synthetic */ ProcessStateController(ActivityManagerService r1, ProcessList r2, ActiveUids r3, ServiceThread r4, CachedAppOptimizer r5, OomAdjuster.Injector r6, boolean r7, ProcessStateControllerIA r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    static {
        TAG = "ProcessStateController";
    }

    private ProcessStateController(ActivityManagerService ams, ProcessList processList, ActiveUids activeUids, ServiceThread handlerThread, CachedAppOptimizer cachedAppOptimizer, OomAdjuster.Injector oomAdjInjector, boolean useOomAdjusterModernImpl) {
        this.mGlobalState = new GlobalState(null);
        if (useOomAdjusterModernImpl == false) goto L5;
        OomAdjuster r2 = new OomAdjusterModernImpl(ams, processList, activeUids, handlerThread, this.mGlobalState, cachedAppOptimizer, oomAdjInjector);
    L6:
        this.mOomAdjuster = r2;
        return;
    L5:
        r2 = new OomAdjuster(ams, processList, activeUids, handlerThread, this.mGlobalState, cachedAppOptimizer, oomAdjInjector);
        goto L6
    }

    public OomAdjuster getOomAdjuster() {
        return this.mOomAdjuster;
    }

    public void enqueueUpdateTarget(ProcessRecord proc) {
        this.mOomAdjuster.enqueueOomAdjTargetLocked(proc);
    }

    public void removeUpdateTarget(ProcessRecord proc, boolean procDied) {
        this.mOomAdjuster.removeOomAdjTargetLocked(proc, procDied);
    }

    public boolean runUpdate(ProcessRecord proc, int oomAdjReason) {
        return this.mOomAdjuster.updateOomAdjLocked(proc, oomAdjReason);
    }

    public void runPendingUpdate(int oomAdjReason) {
        this.mOomAdjuster.updateOomAdjPendingTargetsLocked(oomAdjReason);
    }

    public void runFullUpdate(int oomAdjReason) {
        this.mOomAdjuster.updateOomAdjLocked(oomAdjReason);
    }

    public void runFollowUpUpdate() {
        this.mOomAdjuster.updateOomAdjFollowUpTargetsLocked();
    }

    public void setTopProcessState(int procState) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setUseTopSchedGroupForTopProcess(boolean useTopSchedGroup) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setTopApp(ProcessRecord proc) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setHomeProcess(ProcessRecord proc) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setHeavyWeightProcess(ProcessRecord proc) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setVisibleDozeUiProcess(ProcessRecord proc) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setPreviousProcess(ProcessRecord proc) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setWakefulness(int wakefulness) {
        GlobalState r0 = this.mGlobalState;
        boolean r1 = true;
        if (wakefulness == 1) goto L6;
        r1 = false;
    L6:
        r0.isAwake = r1;
        this.mOomAdjuster.onWakefulnessChanged(wakefulness);
    }

    public void setBackupTarget(ProcessRecord proc, int userId) {
        this.mGlobalState.backupTargets.put(userId, proc);
    }

    public void stopBackupTarget(int userId) {
        this.mGlobalState.backupTargets.delete(userId);
    }

    public void setIsLastMemoryLevelNormal(boolean isMemoryNormal) {
        this.mGlobalState.isLastMemoryLevelNormal = isMemoryNormal;
    }

    public void setUidTempAllowlistStateLSP(int uid, boolean allowList) {
        this.mOomAdjuster.setUidTempAllowlistStateLSP(uid, allowList);
    }

    public void setMaxAdj(ProcessRecord proc, int adj) {
        proc.mState.setMaxAdj(adj);
    }

    public void setAttachingProcessStatesLSP(ProcessRecord proc) {
        this.mOomAdjuster.setAttachingProcessStatesLSP(proc);
    }

    public void setPendingFinishAttach(ProcessRecord proc, boolean pendingFinishAttach) {
        proc.setPendingFinishAttach(pendingFinishAttach);
    }

    public void setActiveInstrumentation(ProcessRecord proc, ActiveInstrumentation activeInstrumentation) {
        proc.setActiveInstrumentation(activeInstrumentation);
    }

    public boolean setHasTopUi(ProcessRecord proc, boolean hasTopUi) {
        if (proc.mState.hasTopUi() != hasTopUi) goto L7;
        return false;
    L7:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L9;
        Slog.d(TAG, "Setting hasTopUi=" + hasTopUi + " for pid=" + proc.getPid());
    L9:
        proc.mState.setHasTopUi(hasTopUi);
        return true;
    }

    public boolean setHasOverlayUi(ProcessRecord proc, boolean hasOverlayUi) {
        if (proc.mState.hasOverlayUi() != hasOverlayUi) goto L6;
        return false;
    L6:
        proc.mState.setHasOverlayUi(hasOverlayUi);
        return true;
    }

    public boolean setRunningRemoteAnimation(ProcessRecord proc, boolean runningRemoteAnimation) {
        if (proc.mState.isRunningRemoteAnimation() != runningRemoteAnimation) goto L7;
        return false;
    L7:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L9;
        Slog.i(TAG, "Setting runningRemoteAnimation=" + runningRemoteAnimation + " for pid=" + proc.getPid());
    L9:
        proc.mState.setRunningRemoteAnimation(runningRemoteAnimation);
        return true;
    }

    public void setForcingToImportant(ProcessRecord proc, Object forcingToImportant) {
        if (proc.mState.getForcingToImportant() != forcingToImportant) goto L5;
        return;
    L5:
        proc.mState.setForcingToImportant(forcingToImportant);
    }

    public void setHasShownUi(ProcessRecord proc, boolean hasShownUi) {
        if (proc.mState.hasShownUi() != hasShownUi) goto L5;
        return;
    L5:
        proc.mState.setHasShownUi(hasShownUi);
    }

    public void setHasActivity(ProcessRecord proc, boolean hasActivity) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setHasVisibleActivity(ProcessRecord proc, boolean hasVisibleActivity) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setActivityStateFlags(ProcessRecord proc, int flags) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean addPublishedProvider(ProcessRecord proc, String name, ContentProviderRecord cpr) {
        ProcessProviderRecord providers = proc.mProviders;
        if (providers.hasProvider(name) == false) goto L6;
        return false;
    L6:
        providers.installProvider(name, cpr);
        return true;
    }

    public void removePublishedProvider(ProcessRecord proc, String name) {
        ProcessProviderRecord providers = proc.mProviders;
        providers.removeProvider(name);
    }

    public void addExternalProviderClient(ContentProviderRecord cpr, IBinder externalProcessToken, int callingUid, String callingTag) {
        cpr.addExternalProcessHandleLocked(externalProcessToken, callingUid, callingTag);
    }

    public boolean removeExternalProviderClient(ContentProviderRecord cpr, IBinder externalProcessToken) {
        return cpr.removeExternalProcessHandleLocked(externalProcessToken);
    }

    public void setLastProviderTime(ProcessRecord proc, long uptimeMs) {
        proc.mProviders.setLastProviderTime(uptimeMs);
    }

    public void addProviderConnection(ProcessRecord client, ContentProviderConnection cpc) {
        client.mProviders.addProviderConnection(cpc);
    }

    public void removeProviderConnection(ProcessRecord client, ContentProviderConnection cpc) {
        client.mProviders.removeProviderConnection(cpc);
    }

    public boolean startService(ProcessServiceRecord psr, ServiceRecord sr) {
        return psr.startService(sr);
    }

    public boolean stopService(ProcessServiceRecord psr, ServiceRecord sr) {
        return psr.stopService(sr);
    }

    public void stopAllServices(ProcessServiceRecord psr) {
        psr.stopAllServices();
    }

    public void startExecutingService(ProcessServiceRecord psr, ServiceRecord sr) {
        psr.startExecutingService(sr);
    }

    public void stopExecutingService(ProcessServiceRecord psr, ServiceRecord sr) {
        psr.stopExecutingService(sr);
    }

    public void stopAllExecutingServices(ProcessServiceRecord psr) {
        psr.stopAllExecutingServices();
    }

    public void addConnection(ProcessServiceRecord psr, ConnectionRecord cr) {
        psr.addConnection(cr);
    }

    public void removeConnection(ProcessServiceRecord psr, ConnectionRecord cr) {
        psr.removeConnection(cr);
    }

    public void removeAllConnections(ProcessServiceRecord psr) {
        psr.removeAllConnections();
        psr.removeAllSdkSandboxConnections();
    }

    public void setExecServicesFg(ProcessServiceRecord psr, boolean execServicesFg) {
        psr.setExecServicesFg(execServicesFg);
    }

    public void setHasForegroundServices(ProcessServiceRecord psr, boolean hasForegroundServices, int fgServiceTypes, boolean hasTypeNoneFgs) {
        psr.setHasForegroundServices(hasForegroundServices, fgServiceTypes, hasTypeNoneFgs);
    }

    public void setHasClientActivities(ProcessServiceRecord psr, boolean hasClientActivities) {
        psr.setHasClientActivities(hasClientActivities);
    }

    public void setTreatLikeActivity(ProcessServiceRecord psr, boolean treatLikeActivity) {
        psr.setTreatLikeActivity(treatLikeActivity);
    }

    public void setHasAboveClient(ProcessServiceRecord psr, boolean hasAboveClient) {
        psr.setHasAboveClient(hasAboveClient);
    }

    public void updateHasAboveClientLocked(ProcessServiceRecord psr) {
        psr.updateHasAboveClientLocked();
    }

    public void onCleanupApplicationRecord(ProcessServiceRecord psr) {
        psr.onCleanupApplicationRecordLocked();
    }

    public void setHostProcess(ServiceRecord sr, ProcessRecord host) {
        sr.app = host;
    }

    public void setIsForegroundService(ServiceRecord sr, boolean isFgs) {
        sr.isForeground = isFgs;
    }

    public void setForegroundServiceType(ServiceRecord sr, int fgsType) {
        sr.foregroundServiceType = fgsType;
    }

    public void setShortFgsInfo(ServiceRecord sr, long uptimeNow) {
        sr.setShortFgsInfo(uptimeNow);
    }

    public void clearShortFgsInfo(ServiceRecord sr) {
        sr.clearShortFgsInfo();
    }

    public void setServiceLastActivityTime(ServiceRecord sr, long lastActivityUpdateMs) {
        sr.lastActivity = lastActivityUpdateMs;
    }

    public void setStartRequested(ServiceRecord sr, boolean startRequested) {
        sr.startRequested = startRequested;
    }

    public void setLastTopAlmostPerceptibleBindRequest(ServiceRecord sr, long lastTopAlmostPerceptibleBindRequestUptimeMs) {
        sr.lastTopAlmostPerceptibleBindRequestUptimeMs = lastTopAlmostPerceptibleBindRequestUptimeMs;
    }

    public void updateHasTopStartedAlmostPerceptibleServices(ProcessServiceRecord psr) {
        psr.updateHasTopStartedAlmostPerceptibleServices();
    }

    public void setBroadcastSchedGroup(ProcessRecord proc, int schedGroup) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean incrementCurReceivers(ProcessRecord app) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean decrementCurReceivers(ProcessRecord app) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

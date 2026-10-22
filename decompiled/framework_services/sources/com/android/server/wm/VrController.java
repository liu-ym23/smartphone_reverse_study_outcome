package com.android.server.wm;

import android.content.ComponentName;
import android.os.Process;
import android.service.vr.IPersistentVrStateCallbacks;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import com.android.server.LocalServices;
import com.android.server.am.ActivityManagerService;
import com.android.server.vr.VrManagerInternal;

/* JADX INFO: loaded from: classes3.dex */
final class VrController {
    private static final int FLAG_NON_VR_MODE = 0;
    private static final int FLAG_PERSISTENT_VR_MODE = 2;
    private static final int FLAG_VR_MODE = 1;
    private static int[] ORIG_ENUMS = null;
    private static int[] PROTO_ENUMS = null;
    private static final String TAG = "VrController";
    private final Object mGlobalAmLock;
    private final IPersistentVrStateCallbacks mPersistentVrModeListener;
    private int mVrRenderThreadTid;
    VrManagerInternal mVrService;
    private volatile int mVrState;

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalAmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10371$$Nest$fgetmGlobalAmLock(VrController r0) {
        return r0.mGlobalAmLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVrState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10372$$Nest$fgetmVrState(VrController r0) {
        return r0.mVrState;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVrState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10373$$Nest$fputmVrState(VrController r0, int r1) {
        r0.mVrState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$msetPersistentVrRenderThreadLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10374$$Nest$msetPersistentVrRenderThreadLocked(VrController r0, int r1, boolean r2) {
        return r0.setPersistentVrRenderThreadLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetVrRenderThreadLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10375$$Nest$msetVrRenderThreadLocked(VrController r0, int r1, int r2, boolean r3) {
        return r0.setVrRenderThreadLocked(r1, r2, r3);
    }

    static {
        ORIG_ENUMS = new int[]{0, 1, 2};
        PROTO_ENUMS = new int[]{0, 1, 2};
    }

    public VrController(Object globalAmLock) {
        this.mVrState = 0;
        this.mVrRenderThreadTid = 0;
        this.mPersistentVrModeListener = new AnonymousClass1(this);
        this.mGlobalAmLock = globalAmLock;
    }

    public void onSystemReady() {
        VrManagerInternal vrManagerInternal = (VrManagerInternal) LocalServices.getService(VrManagerInternal.class);
        if (vrManagerInternal == null) goto L6;
        this.mVrService = vrManagerInternal;
        vrManagerInternal.addPersistentVrModeStateListener(this.mPersistentVrModeListener);
        return;
    }

    boolean isInterestingToSchedGroup() {
        if ((this.mVrState & 3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void onTopProcChangedLocked(WindowProcessController proc) {
        int curSchedGroup = proc.getCurrentSchedulingGroup();
        if (curSchedGroup != 3) goto L6;
        setVrRenderThreadLocked(proc.mVrThreadTid, curSchedGroup, true);
        return;
    L6:
        if (proc.mVrThreadTid != this.mVrRenderThreadTid) goto L10;
        clearVrRenderThreadLocked(true);
        return;
    }

    public boolean onVrModeChanged(ActivityRecord record) {
        VrManagerInternal vrService = this.mVrService;
        boolean vrMode = false;
        if (vrService != null) goto L5;
        return false;
    L5:
        int processId = -1;
        Object r4 = this.mGlobalAmLock;
        monitor-enter(r4);
    L31:
        th = th;
    L23:
        monitor-exit(r4);     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L23
    L24:
        throw th;
    L8:
        if (record.requestedVrComponent == null) goto L10;
        vrMode = true;
    L10:
        ComponentName requestedPackage = record.requestedVrComponent;     // Catch: Throwable -> L22
        int userId = record.mUserId;     // Catch: Throwable -> L22
        ComponentName callingPackage = record.info.getComponentName();     // Catch: Throwable -> L22
        boolean changed = changeVrModeLocked(vrMode, record.app);     // Catch: Throwable -> L22
    L15:
        th = th;
        goto L23
    L12:
        if (record.app == null) goto L25;
        processId = record.app.getPid();     // Catch: Throwable -> L15
    L25:
        monitor-exit(r4);     // Catch: Throwable -> L20
        int processId2 = processId;
        vrService.setVrMode(vrMode, requestedPackage, userId, processId2, callingPackage);
        return changed;
    L20:
        th = th;
        goto L23
    }

    public void setVrThreadLocked(int tid, int pid, WindowProcessController proc) {
        if (hasPersistentVrFlagSet() == false) goto L6;
        Slog.w(TAG, "VR thread cannot be set in persistent VR mode!");
        return;
    L6:
        if (proc != null) goto L9;
        Slog.w(TAG, "Persistent VR thread not set, calling process doesn't exist!");
        return;
    L9:
        if (tid == 0) goto L11;
        enforceThreadInProcess(tid, pid);
    L11:
        int r2 = 0;
        if (inVrMode() == true) goto L14;
        Slog.w(TAG, "VR thread cannot be set when not in VR mode!");
    L15:
        if (tid <= 0) goto L17;
        r2 = tid;
    L17:
        proc.mVrThreadTid = r2;
        return;
    L14:
        setVrRenderThreadLocked(tid, proc.getCurrentSchedulingGroup(), false);
        goto L15
    }

    public void setPersistentVrThreadLocked(int tid, int pid, WindowProcessController proc) {
        if (hasPersistentVrFlagSet() == true) goto L6;
        Slog.w(TAG, "Persistent VR thread may only be set in persistent VR mode!");
        return;
    L6:
        if (proc != null) goto L9;
        Slog.w(TAG, "Persistent VR thread not set, calling process doesn't exist!");
        return;
    L9:
        if (tid == 0) goto L11;
        enforceThreadInProcess(tid, pid);
    L11:
        setPersistentVrRenderThreadLocked(tid, false);
    }

    public boolean shouldDisableNonVrUiLocked() {
        if (this.mVrState == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean changeVrModeLocked(boolean vrMode, WindowProcessController proc) {
        int oldVrState = this.mVrState;
        boolean changed = true;
        if (vrMode == false) goto L5;
        this.mVrState |= 1;
    L7:
        if (oldVrState != this.mVrState) goto L10;
        changed = false;
    L10:
        if (changed == false) goto L16;
        if (proc != null) goto L13;
        clearVrRenderThreadLocked(false);
        goto L16
    L13:
        if (proc.mVrThreadTid <= 0) goto L16;
        setVrRenderThreadLocked(proc.mVrThreadTid, proc.getCurrentSchedulingGroup(), false);
    L16:
        return changed;
    L5:
        this.mVrState &= -2;
        goto L7
    }

    private int updateVrRenderThreadLocked(int newTid, boolean suppressLogs) {
        if (this.mVrRenderThreadTid != newTid) goto L7;
        return this.mVrRenderThreadTid;
    L7:
        if (this.mVrRenderThreadTid <= 0) goto L9;
        ActivityManagerService.scheduleAsRegularPriority(this.mVrRenderThreadTid, suppressLogs);
        this.mVrRenderThreadTid = 0;
    L9:
        if (newTid <= 0) goto L12;
        this.mVrRenderThreadTid = newTid;
        ActivityManagerService.scheduleAsFifoPriority(this.mVrRenderThreadTid, suppressLogs);
    L12:
        return this.mVrRenderThreadTid;
    }

    private int setPersistentVrRenderThreadLocked(int newTid, boolean suppressLogs) {
        if (hasPersistentVrFlagSet() == true) goto L9;
        if (suppressLogs == true) goto L7;
        Slog.w(TAG, "Failed to set persistent VR thread, system not in persistent VR mode.");
    L7:
        return this.mVrRenderThreadTid;
    L9:
        return updateVrRenderThreadLocked(newTid, suppressLogs);
    }

    private int setVrRenderThreadLocked(int newTid, int schedGroup, boolean suppressLogs) {
        boolean inVr = inVrMode();
        boolean inPersistentVr = hasPersistentVrFlagSet();
        if (inVr == false) goto L10;
        if (inPersistentVr == true) goto L10;
        if (schedGroup != 3) goto L10;
        return updateVrRenderThreadLocked(newTid, suppressLogs);
    L10:
        if (suppressLogs == true) goto L18;
        String reason = "caller is not the current top application.";
        if (inVr == true) goto L14;
        reason = "system not in VR mode.";
    L16:
        Slog.w(TAG, "Failed to set VR thread, " + reason);
        goto L18
    L14:
        if (inPersistentVr == false) goto L16;
        reason = "system in persistent VR mode.";
    L18:
        return this.mVrRenderThreadTid;
    }

    private void clearVrRenderThreadLocked(boolean suppressLogs) {
        updateVrRenderThreadLocked(0, suppressLogs);
    }

    private void enforceThreadInProcess(int tid, int pid) {
        if (Process.isThreadInProcess(pid, tid) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("VR thread does not belong to process");
    }

    private boolean inVrMode() {
        if ((this.mVrState & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean hasPersistentVrFlagSet() {
        if ((this.mVrState & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return String.format("[VrState=0x%x,VrRenderThreadTid=%d]", new Object[]{Integer.valueOf(this.mVrState), Integer.valueOf(this.mVrRenderThreadTid)});
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        ProtoUtils.writeBitWiseFlagsToProtoEnum(proto, 2259152797697L, this.mVrState, ORIG_ENUMS, PROTO_ENUMS);
        proto.write(1120986464258L, this.mVrRenderThreadTid);
        proto.end(token);
    }
}

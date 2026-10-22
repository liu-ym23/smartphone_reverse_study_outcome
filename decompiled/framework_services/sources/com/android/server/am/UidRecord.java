package com.android.server.am;

import android.app.ActivityManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.util.proto.ProtoUtils;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class UidRecord {
    static final int CHANGE_ACTIVE = 4;
    static final int CHANGE_CACHED = 8;
    static final int CHANGE_CAPABILITY = 32;
    static final int CHANGE_GONE = 1;
    static final int CHANGE_IDLE = 2;
    static final int CHANGE_PROCADJ = 64;
    static final int CHANGE_PROCSTATE = Integer.MIN_VALUE;
    static final int CHANGE_UNCACHED = 16;
    private static int[] ORIG_ENUMS;
    private static int[] PROTO_ENUMS;
    long curProcStateSeq;
    volatile boolean hasInternetPermission;
    long lastNetworkUpdatedProcStateSeq;
    private int mCurAdj;
    private boolean mCurAllowList;
    private int mCurCapability;
    int mCurProcState;
    private boolean mEphemeral;
    private boolean mForegroundServices;
    private boolean mIdle;
    private long mLastBackgroundTime;
    private long mLastIdleTimeIfStillIdle;
    private int mLastReportedChange;
    private int mNumProcs;
    private boolean mProcAdjChanged;
    private final ActivityManagerGlobalLock mProcLock;
    private ArraySet<ProcessRecord> mProcRecords;
    private long mRealLastIdleTime;
    private final ActivityManagerService mService;
    private int mSetAdj;
    private boolean mSetAllowList;
    private int mSetCapability;
    private boolean mSetIdle;
    private int mSetProcState;
    private UidRecordSmtBase mSmtEx;
    private final int mUid;
    private boolean mUidIsFrozen;
    final Object networkStateLock;
    final UidObserverController.ChangeRecord pendingChange;
    ArraySet<ProcessRecord> procRecords;
    volatile long procStateSeqWaitingForNetwork;

    static {
        ORIG_ENUMS = new int[]{1, 2, 4, 8, 16, 32, Integer.MIN_VALUE};
        PROTO_ENUMS = new int[]{0, 1, 2, 3, 4, 5, 6};
    }

    public UidRecord(int uid, ActivityManagerService service) {
        this.mSetProcState = 20;
        this.mProcRecords = new ArraySet();
        this.networkStateLock = new Object();
        this.pendingChange = new UidObserverController.ChangeRecord();
        this.mSmtEx = new UidRecordSmtBase();
        this.procRecords = new ArraySet();
        this.mUid = uid;
        this.mService = service;
        if (service == null) goto L5;
        ActivityManagerGlobalLock r0 = service.mProcLock;
    L6:
        this.mProcLock = r0;
        this.mIdle = true;
        reset();
        return;
    L5:
        r0 = null;
        goto L6
    }

    int getUid() {
        return this.mUid;
    }

    int getCurProcState() {
        return this.mCurProcState;
    }

    void setCurProcState(int curProcState) {
        this.mCurProcState = curProcState;
    }

    int getSetProcState() {
        return this.mSetProcState;
    }

    void setSetProcState(int setProcState) {
        this.mSetProcState = setProcState;
    }

    void noteProcAdjChanged() {
        this.mProcAdjChanged = true;
    }

    void clearProcAdjChanged() {
        this.mProcAdjChanged = false;
    }

    boolean getProcAdjChanged() {
        return this.mProcAdjChanged;
    }

    int getMinProcAdj() {
        int minAdj = 1001;
        int i = this.mProcRecords.size() - 1;
    L3:
        if (i < 0) goto L9;
        int adj = this.mProcRecords.valueAt(i).getSetAdj();
        if (adj >= minAdj) goto L7;
        minAdj = adj;
    L7:
        i = i - 1;
        goto L3
    L9:
        return minAdj;
    }

    int getCurCapability() {
        return this.mCurCapability;
    }

    void setCurCapability(int curCapability) {
        this.mCurCapability = curCapability;
    }

    int getSetCapability() {
        return this.mSetCapability;
    }

    void setSetCapability(int setCapability) {
        this.mSetCapability = setCapability;
    }

    long getLastBackgroundTime() {
        return this.mLastBackgroundTime;
    }

    void setLastBackgroundTime(long lastBackgroundTime) {
        this.mLastBackgroundTime = lastBackgroundTime;
    }

    long getLastIdleTimeIfStillIdle() {
        return this.mLastIdleTimeIfStillIdle;
    }

    long getRealLastIdleTime() {
        return this.mRealLastIdleTime;
    }

    void setLastIdleTime(long lastIdleTime) {
        this.mLastIdleTimeIfStillIdle = lastIdleTime;
        if (lastIdleTime <= 0) goto L6;
        this.mRealLastIdleTime = lastIdleTime;
        return;
    }

    boolean isEphemeral() {
        return this.mEphemeral;
    }

    void setEphemeral(boolean ephemeral) {
        this.mEphemeral = ephemeral;
    }

    boolean hasForegroundServices() {
        return this.mForegroundServices;
    }

    void setForegroundServices(boolean foregroundServices) {
        this.mForegroundServices = foregroundServices;
    }

    boolean isCurAllowListed() {
        return this.mCurAllowList;
    }

    void setCurAllowListed(boolean curAllowList) {
        this.mCurAllowList = curAllowList;
    }

    boolean isSetAllowListed() {
        return this.mSetAllowList;
    }

    void setSetAllowListed(boolean setAllowlist) {
        this.mSetAllowList = setAllowlist;
    }

    boolean isIdle() {
        return this.mIdle;
    }

    void setIdle(boolean idle) {
        this.mIdle = idle;
    }

    boolean isSetIdle() {
        return this.mSetIdle;
    }

    void setSetIdle(boolean setIdle) {
        this.mSetIdle = setIdle;
    }

    int getNumOfProcs() {
        return this.mProcRecords.size();
    }

    void forEachProcess(Consumer<ProcessRecord> callback) {
        int i = this.mProcRecords.size() - 1;
    L3:
        if (i < 0) goto L6;
        callback.accept(this.mProcRecords.valueAt(i));
        i = i - 1;
        goto L3
    }

    ProcessRecord getProcessRecordByIndex(int idx) {
        return this.mProcRecords.valueAt(idx);
    }

    ProcessRecord getProcessInPackage(String packageName) {
        int i = this.mProcRecords.size() - 1;
    L3:
        if (i < 0) goto L10;
        ProcessRecord app = this.mProcRecords.valueAt(i);
        if (app == null) goto L9;
        if (TextUtils.equals(app.info.packageName, packageName) == false) goto L9;
        return app;
    L9:
        i = i - 1;
        goto L3
    L10:
        return null;
    }

    public boolean areAllProcessesFrozen(ProcessRecord excluding) {
        int i = this.mProcRecords.size() - 1;
    L3:
        if (i < 0) goto L12;
        ProcessRecord app = this.mProcRecords.valueAt(i);
        ProcessCachedOptimizerRecord opt = app.mOptRecord;
        if (excluding == app) goto L10;
        if (opt.isFrozen() == true) goto L10;
        return false;
    L10:
        i = i - 1;
        goto L3
    L12:
        return true;
    }

    public boolean areAllProcessesFrozen() {
        return areAllProcessesFrozen(null);
    }

    public void setFrozen(boolean frozen) {
        this.mUidIsFrozen = frozen;
    }

    public boolean isFrozen() {
        return this.mUidIsFrozen;
    }

    void addProcess(ProcessRecord app) {
        this.mProcRecords.add(app);
    }

    void removeProcess(ProcessRecord app) {
        this.mProcRecords.remove(app);
    }

    void setLastReportedChange(int lastReportedChange) {
        this.mLastReportedChange = lastReportedChange;
    }

    void reset() {
        setCurProcState(19);
        this.mForegroundServices = false;
        this.mCurCapability = 0;
        this.mSmtEx.reset();
    }

    public void updateHasInternetPermission() {
        if (ActivityManager.checkUidPermission("android.permission.INTERNET", this.mUid) != 0) goto L5;
        boolean r0 = true;
    L6:
        this.hasInternetPermission = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.mUid);
        proto.write(1159641169922L, ProcessList.makeProcStateProtoEnum(this.mCurProcState));
        proto.write(1133871366147L, this.mEphemeral);
        proto.write(1133871366148L, this.mForegroundServices);
        proto.write(1133871366149L, this.mCurAllowList);
        ProtoUtils.toDuration(proto, 1146756268038L, this.mLastBackgroundTime, SystemClock.elapsedRealtime());
        proto.write(1133871366151L, this.mIdle);
        if (this.mLastReportedChange == 0) goto L5;
        ProtoUtils.writeBitWiseFlagsToProtoEnum(proto, 2259152797704L, this.mLastReportedChange, ORIG_ENUMS, PROTO_ENUMS);
    L5:
        proto.write(1120986464265L, this.mNumProcs);
        long seqToken = proto.start(1146756268042L);
        proto.write(1112396529665L, this.curProcStateSeq);
        proto.write(1112396529666L, this.lastNetworkUpdatedProcStateSeq);
        proto.end(seqToken);
        proto.end(token);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("UidRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        UserHandle.formatUid(sb, this.mUid);
        sb.append(' ');
        sb.append(ProcessList.makeProcStateString(this.mCurProcState));
        if (this.mEphemeral == false) goto L6;
        sb.append(" ephemeral");
    L6:
        if (this.mForegroundServices == false) goto L9;
        sb.append(" fgServices");
    L9:
        if (this.mCurAllowList == false) goto L12;
        sb.append(" allowlist");
    L12:
        if (this.mLastBackgroundTime <= 0) goto L15;
        sb.append(" bg:");
        TimeUtils.formatDuration(SystemClock.elapsedRealtime() - this.mLastBackgroundTime, sb);
    L15:
        if (this.mIdle == false) goto L18;
        sb.append(" idle");
    L18:
        if (this.mLastReportedChange == 0) goto L52;
        sb.append(" change:");
        boolean printed = false;
        if ((this.mLastReportedChange & 1) == 0) goto L23;
        printed = true;
        sb.append("gone");
    L23:
        if ((this.mLastReportedChange & 2) == 0) goto L28;
        if (printed == false) goto L26;
        sb.append("|");
    L26:
        printed = true;
        sb.append("idle");
    L28:
        if ((this.mLastReportedChange & 4) == 0) goto L33;
        if (printed == false) goto L31;
        sb.append("|");
    L31:
        printed = true;
        sb.append(DomainVerificationPersistence.TAG_ACTIVE);
    L33:
        if ((this.mLastReportedChange & 8) == 0) goto L38;
        if (printed == false) goto L36;
        sb.append("|");
    L36:
        printed = true;
        sb.append("cached");
    L38:
        if ((this.mLastReportedChange & 16) == 0) goto L43;
        if (printed == false) goto L41;
        sb.append("|");
    L41:
        sb.append("uncached");
    L43:
        if ((this.mLastReportedChange & Integer.MIN_VALUE) == 0) goto L48;
        if (printed == false) goto L46;
        sb.append("|");
    L46:
        sb.append("procstate");
    L48:
        if ((this.mLastReportedChange & 64) == 0) goto L52;
        if (printed == false) goto L51;
        sb.append("|");
    L51:
        sb.append("procadj");
    L52:
        sb.append(" procs:");
        sb.append(this.mNumProcs);
        sb.append(" seq(");
        sb.append(this.curProcStateSeq);
        sb.append(",");
        sb.append(this.lastNetworkUpdatedProcStateSeq);
        sb.append(")}");
        sb.append(" caps=");
        ActivityManager.printCapabilitiesSummary(sb, this.mCurCapability);
        return sb.toString();
    }

    public UidRecordSmtBase getSmtEx() {
        return this.mSmtEx;
    }

    public ArraySet<ProcessRecord> getProcRecords() {
        return this.mProcRecords;
    }
}

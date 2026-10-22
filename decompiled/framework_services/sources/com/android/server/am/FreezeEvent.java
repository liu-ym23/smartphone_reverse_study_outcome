package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public class FreezeEvent {
    public long batchFreezeId;
    public long batchUnfreezeId;
    public long duration;
    public long freezeId;
    public int freezeLevel;
    public IApplicationFreezer.FreezeReason freezeReason;
    public String freezeReasonL2;
    public int pid;
    public long procCreateTime;
    public long procDiedTime;
    public String processName;
    public long startTime;
    public int uid;
    public long unfreezeId;
    public IApplicationFreezer.UnfreezeReason unfreezeReason;
    public String unfreezeReasonL2;

    FreezeEvent() {
        this.processName = "";
        this.freezeReason = IApplicationFreezer.FreezeReason.NONE;
        this.unfreezeReason = IApplicationFreezer.UnfreezeReason.NONE;
        this.freezeReasonL2 = "";
        this.unfreezeReasonL2 = "";
        this.freezeLevel = 0;
        this.batchFreezeId = 0;
        this.batchUnfreezeId = 0;
        this.startTime = 0;
        this.duration = 0;
        this.procCreateTime = 0;
        this.procDiedTime = 0;
        this.uid = 0;
        this.pid = 0;
    }

    public FreezeEvent setStartTime(long time) {
        this.startTime = time;
        return this;
    }

    public FreezeEvent setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public FreezeEvent setProcessName(String name) {
        this.processName = name;
        return this;
    }

    public FreezeEvent setFreezeReason(IApplicationFreezer.FreezeReason reason) {
        this.freezeReason = reason;
        return this;
    }

    public FreezeEvent setUnfreezeReason(IApplicationFreezer.UnfreezeReason reason) {
        this.unfreezeReason = reason;
        return this;
    }

    public FreezeEvent setUid(int uid) {
        this.uid = uid;
        return this;
    }

    public FreezeEvent setPid(int pid) {
        this.pid = pid;
        return this;
    }

    public FreezeEvent setFreezeId(long id) {
        this.freezeId = id;
        return this;
    }

    public FreezeEvent setUnfreezeId(long id) {
        this.unfreezeId = id;
        return this;
    }

    public FreezeEvent setFreezeReasonL2(String reason) {
        this.freezeReasonL2 = reason;
        return this;
    }

    public FreezeEvent setUnfreezeReasonL2(String reason) {
        this.unfreezeReasonL2 = reason;
        return this;
    }

    public FreezeEvent setProcCreateTime(long time) {
        this.procCreateTime = time;
        return this;
    }

    public FreezeEvent setProcDiedTime(long time) {
        this.procDiedTime = time;
        return this;
    }

    public FreezeEvent setBatchFreezeId(long seq) {
        this.batchFreezeId = seq;
        return this;
    }

    public FreezeEvent setBatchUnfreezeId(long id) {
        this.batchUnfreezeId = id;
        return this;
    }

    public FreezeEvent setFreezeLevel(int level) {
        this.freezeLevel = level;
        return this;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getUid() {
        return this.uid;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        if (this.processName != null) goto L6;
        return "";
    L6:
        return this.processName;
    }

    public IApplicationFreezer.FreezeReason getFreezeReason() {
        return this.freezeReason;
    }

    public String getFreezeReasonL2() {
        if (this.freezeReasonL2 != null) goto L6;
        return "";
    L6:
        return this.freezeReasonL2;
    }

    public long getFreezeId() {
        return this.freezeId;
    }

    public long getUnfreezeId() {
        return this.unfreezeId;
    }

    public long getBatchFreezeId() {
        return this.batchFreezeId;
    }

    public int getFreezeLevel() {
        return this.freezeLevel;
    }

    public IApplicationFreezer.UnfreezeReason getUnfreezeReason() {
        return this.unfreezeReason;
    }

    public String getUnfreezeReasonL2() {
        if (this.unfreezeReasonL2 != null) goto L6;
        return "";
    L6:
        return this.unfreezeReasonL2;
    }

    public long getBatchUnfreezeId() {
        return this.batchUnfreezeId;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getProcCreateTime() {
        return this.procCreateTime;
    }

    public long getProcDiedTime() {
        return this.procDiedTime;
    }

    public String toString() {
        return "FreezeEvent{startTime=" + this.startTime + ", duration=" + this.duration + ", processName='" + this.processName + "', freezeReason=" + this.freezeReason + ", unfreezeReason=" + this.unfreezeReason + ", uid=" + this.uid + ", pid=" + this.pid + ", freezeReasonL2='" + this.freezeReasonL2 + "', unfreezeReasonL2='" + this.unfreezeReasonL2 + "', freezeId=" + this.freezeId + ", unfreezeId=" + this.unfreezeId + ", procCreateTime=" + this.procCreateTime + ", procDiedTime=" + this.procDiedTime + ", batchFreezeId=" + this.batchFreezeId + ", batchUnfreezeId=" + this.batchUnfreezeId + ", freezeLevel=" + this.freezeLevel + '}';
    }
}

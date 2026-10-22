package com.bytedance.sysoptimizer;

/* JADX INFO: loaded from: classes.dex */
public class StackLeakItem {
    private int leakCount;
    private String soBuildId;
    private long soEndAddr;
    private String soPath;
    private long soStartAddr;
    private long startRoutine;
    private long startRoutineOffset;

    public StackLeakItem(int r10, long r11, long r12, long r13, String r14, String r15) {
        this.leakCount = r10;
        this.startRoutine = r11;
        this.soStartAddr = r12;
        this.soEndAddr = r13;
        this.soPath = r14;
        this.soBuildId = r15;
        this.startRoutineOffset = r11 - r12;
    }

    public String getBuildId() {
        return this.soBuildId;
    }

    public int getLeakCount() {
        return this.leakCount;
    }

    public String getLeakItem() {
        return "[" + this.leakCount + "] stacks leaked: " + Long.toHexString(this.startRoutineOffset) + " " + Long.toHexString(this.soStartAddr) + "-" + Long.toHexString(this.soEndAddr) + " r-xp " + getSoName() + " (" + this.soBuildId + ")";
    }

    public long getOffset() {
        return this.startRoutineOffset;
    }

    public String getSoName() {
        String r10 = this.soPath;
        if (r10 == null) goto L9;
        int r11 = r10.lastIndexOf(47);
        if (r11 < 0) goto L9;
        if (r11 >= (this.soPath.length() - 1)) goto L9;
        return this.soPath.substring(r11 + 1);
    L9:
        return "UNKNOWN";
    }
}

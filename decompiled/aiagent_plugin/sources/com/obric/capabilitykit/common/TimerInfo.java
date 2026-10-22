package com.obric.capabilitykit.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class TimerInfo {
    private final boolean deleteAfterUse;
    private final long id;
    private final String label;
    private final long remainingTime;
    private final int state;
    private final long totalLength;

    public TimerInfo() {
        this(0, 0, 0, 0, null, false, 63, null);
    }

    public TimerInfo(long r2, int r4, long r5, long r7, String r9, boolean r10) {
        d.h.b.o.e(r9, "label");
        this.id = r2;
        this.state = r4;
        this.totalLength = r5;
        this.remainingTime = r7;
        this.label = r9;
        this.deleteAfterUse = r10;
    }

    public /* synthetic */ TimerInfo(long r11, int r13, long r14, long r16, String r18, boolean r19, int r20, d.h.b.h r21) {
        if ((r20 & 1) == 0) goto L5;
        long r0 = -1;
    L6:
        boolean r3 = false;
        if ((r20 & 2) == 0) goto L9;
        int r2 = 0;
    L10:
        long r5 = 0;
        if ((r20 & 4) == 0) goto L13;
        long r7 = 0;
    L15:
        if ((r20 & 8) != 0) goto L19;
        r5 = r16;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r4 = "";
    L23:
        if ((r20 & 32) != 0) goto L26;
        r3 = r19;
    L26:
        this(r0, r2, r7, r5, r4, r3);
        return;
    L21:
        r4 = r18;
        goto L23
    L13:
        r7 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L10
    L5:
        r0 = r11;
        goto L6
    }

    public static /* synthetic */ TimerInfo copy$default(TimerInfo r10, long r11, int r13, long r14, long r16, String r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r1 = r10.id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r3 = r10.state;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r4 = r10.totalLength;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r6 = r10.remainingTime;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r8 = r10.label;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r9 = r10.deleteAfterUse;
    L27:
        return r10.copy(r1, r3, r4, r6, r8, r9);
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final int component2() {
        return this.state;
    }

    public final long component3() {
        return this.totalLength;
    }

    public final long component4() {
        return this.remainingTime;
    }

    public final String component5() {
        return this.label;
    }

    public final boolean component6() {
        return this.deleteAfterUse;
    }

    public final TimerInfo copy(long r12, int r14, long r15, long r17, String r19, boolean r20) {
        d.h.b.o.e(r19, "label");
        return new TimerInfo(r12, r14, r15, r17, r19, r20);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TimerInfo.class) == true) goto L8;
        return false;
    L8:
        TimerInfo r10 = (TimerInfo) ZeusTransformUtils.preCheckCast(r9, TimerInfo.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.state == r10.state) goto L15;
        return false;
    L15:
        if (this.totalLength == r10.totalLength) goto L18;
        return false;
    L18:
        if (this.remainingTime == r10.remainingTime) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.label, r10.label) == true) goto L24;
        return false;
    L24:
        if (this.deleteAfterUse == r10.deleteAfterUse) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean getDeleteAfterUse() {
        return this.deleteAfterUse;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getRemainingTime() {
        return this.remainingTime;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTotalLength() {
        return this.totalLength;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r0 = ((((((((Long.hashCode(this.id) * 31) + Integer.hashCode(this.state)) * 31) + Long.hashCode(this.totalLength)) * 31) + Long.hashCode(this.remainingTime)) * 31) + this.label.hashCode()) * 31;
        boolean r3 = this.deleteAfterUse;
        ?? r4 = r3;
        if (r3 == false) goto L6;
        r4 = 1;
    L6:
        return r0 + r4;
    }

    public String toString() {
        return "TimerInfo id: " + this.id + ", state: " + this.state + ", totalLenght: " + this.totalLength + ", remainingTime: " + this.remainingTime + ", label: " + this.label + ", deleteAfterUse: " + this.deleteAfterUse;
    }
}

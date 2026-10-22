package com.obric.autogui.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Step.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Step {
    private final String description;
    private final long gmtCreated;
    private final long gmtModified;
    private final int id;
    private final long intervalMillis;
    private final String shareDetails;
    private final int taskId;
    private final int type;

    public static /* synthetic */ Step copy$default(Step r12, int r13, long r14, long r16, int r18, String r19, int r20, long r21, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        int r2 = r12.id;
    L7:
        if ((r24 & 2) == 0) goto L9;
        long r3 = r12.gmtCreated;
    L11:
        if ((r24 & 4) == 0) goto L13;
        long r5 = r12.gmtModified;
    L15:
        if ((r24 & 8) == 0) goto L17;
        int r7 = r12.taskId;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r8 = r12.description;
    L23:
        if ((r24 & 32) == 0) goto L25;
        int r9 = r12.type;
    L27:
        if ((r24 & 64) == 0) goto L29;
        long r10 = r12.intervalMillis;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r1 = r12.shareDetails;
    L35:
        return r12.copy(r2, r3, r5, r7, r8, r9, r10, r1);
    L33:
        r1 = r23;
        goto L35
    L29:
        r10 = r21;
        goto L31
    L25:
        r9 = r20;
        goto L27
    L21:
        r8 = r19;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.gmtCreated;
    }

    public final long component3() {
        return this.gmtModified;
    }

    public final int component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.description;
    }

    public final int component6() {
        return this.type;
    }

    public final long component7() {
        return this.intervalMillis;
    }

    public final String component8() {
        return this.shareDetails;
    }

    public final Step copy(int r14, long r15, long r17, int r19, String r20, int r21, long r22, String r24) {
        o.e(r20, "description");
        o.e(r24, "shareDetails");
        return new Step(r14, r15, r17, r19, r20, r21, r22, r24);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Step.class) == true) goto L8;
        return false;
    L8:
        Step r10 = (Step) ZeusTransformUtils.preCheckCast(r9, Step.class, "com.obric.aiagent.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.gmtCreated == r10.gmtCreated) goto L15;
        return false;
    L15:
        if (this.gmtModified == r10.gmtModified) goto L18;
        return false;
    L18:
        if (this.taskId == r10.taskId) goto L21;
        return false;
    L21:
        if (o.a(this.description, r10.description) == true) goto L24;
        return false;
    L24:
        if (this.type == r10.type) goto L27;
        return false;
    L27:
        if (this.intervalMillis == r10.intervalMillis) goto L30;
        return false;
    L30:
        if (o.a(this.shareDetails, r10.shareDetails) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + Long.hashCode(this.gmtCreated)) * 31) + Long.hashCode(this.gmtModified)) * 31) + Integer.hashCode(this.taskId)) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.intervalMillis)) * 31) + this.shareDetails.hashCode();
    }

    public String toString() {
        return "Step(id=" + this.id + ", gmtCreated=" + this.gmtCreated + ", gmtModified=" + this.gmtModified + ", taskId=" + this.taskId + ", description=" + this.description + ", type=" + this.type + ", intervalMillis=" + this.intervalMillis + ", shareDetails=" + this.shareDetails + ')';
    }

    public Step(int r2, long r3, long r5, int r7, String r8, int r9, long r10, String r12) {
        o.e(r8, "description");
        o.e(r12, "shareDetails");
        this.id = r2;
        this.gmtCreated = r3;
        this.gmtModified = r5;
        this.taskId = r7;
        this.description = r8;
        this.type = r9;
        this.intervalMillis = r10;
        this.shareDetails = r12;
    }

    public final int getId() {
        return this.id;
    }

    public final long getGmtCreated() {
        return this.gmtCreated;
    }

    public /* synthetic */ Step(int r16, long r17, long r19, int r21, String r22, int r23, long r24, String r26, int r27, h r28) {
        if ((r27 & 1) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r27 & 2) == 0) goto L9;
        long r5 = System.currentTimeMillis();
    L11:
        if ((r27 & 4) == 0) goto L13;
        long r7 = System.currentTimeMillis();
    L15:
        if ((r27 & 32) == 0) goto L17;
        int r11 = 0;
    L19:
        if ((r27 & 64) == 0) goto L21;
        long r12 = 0;
    L23:
        if ((r27 & 128) == 0) goto L25;
        String r14 = "";
    L26:
        this(r4, r5, r7, r21, r22, r11, r12, r14);
        return;
    L25:
        r14 = r26;
        goto L26
    L21:
        r12 = r24;
        goto L23
    L17:
        r11 = r23;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public final long getGmtModified() {
        return this.gmtModified;
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getType() {
        return this.type;
    }

    public final long getIntervalMillis() {
        return this.intervalMillis;
    }

    public final String getShareDetails() {
        return this.shareDetails;
    }
}

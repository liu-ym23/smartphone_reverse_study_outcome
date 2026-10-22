package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CCTouchEvent {
    private final int action;
    private final long eventTimeNanos;
    private final int majorAxisSize;
    private final int pointerId;
    private final int pressure;
    private final int toolType;
    private final int x;
    private final int y;

    public static /* synthetic */ CCTouchEvent copy$default(CCTouchEvent r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, long r19, int r21, Object r22) {
        if ((r21 & 1) == 0) goto L5;
        int r2 = r11.pointerId;
    L7:
        if ((r21 & 2) == 0) goto L9;
        int r3 = r11.toolType;
    L11:
        if ((r21 & 4) == 0) goto L13;
        int r4 = r11.action;
    L15:
        if ((r21 & 8) == 0) goto L17;
        int r5 = r11.x;
    L19:
        if ((r21 & 16) == 0) goto L21;
        int r6 = r11.y;
    L23:
        if ((r21 & 32) == 0) goto L25;
        int r7 = r11.pressure;
    L27:
        if ((r21 & 64) == 0) goto L29;
        int r8 = r11.majorAxisSize;
    L31:
        if ((r21 & 128) == 0) goto L33;
        long r9 = r11.eventTimeNanos;
    L35:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9);
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final int component1() {
        return this.pointerId;
    }

    public final int component2() {
        return this.toolType;
    }

    public final int component3() {
        return this.action;
    }

    public final int component4() {
        return this.x;
    }

    public final int component5() {
        return this.y;
    }

    public final int component6() {
        return this.pressure;
    }

    public final int component7() {
        return this.majorAxisSize;
    }

    public final long component8() {
        return this.eventTimeNanos;
    }

    public final CCTouchEvent copy(int r12, int r13, int r14, int r15, int r16, int r17, int r18, long r19) {
        return new CCTouchEvent(r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, CCTouchEvent.class) == true) goto L8;
        return false;
    L8:
        CCTouchEvent r8 = (CCTouchEvent) ZeusTransformUtils.preCheckCast(r7, CCTouchEvent.class, "com.obric.aiagent.plugin");
        if (this.pointerId == r8.pointerId) goto L12;
        return false;
    L12:
        if (this.toolType == r8.toolType) goto L15;
        return false;
    L15:
        if (this.action == r8.action) goto L18;
        return false;
    L18:
        if (this.x == r8.x) goto L21;
        return false;
    L21:
        if (this.y == r8.y) goto L24;
        return false;
    L24:
        if (this.pressure == r8.pressure) goto L27;
        return false;
    L27:
        if (this.majorAxisSize == r8.majorAxisSize) goto L30;
        return false;
    L30:
        if (this.eventTimeNanos == r8.eventTimeNanos) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.pointerId) * 31) + Integer.hashCode(this.toolType)) * 31) + Integer.hashCode(this.action)) * 31) + Integer.hashCode(this.x)) * 31) + Integer.hashCode(this.y)) * 31) + Integer.hashCode(this.pressure)) * 31) + Integer.hashCode(this.majorAxisSize)) * 31) + Long.hashCode(this.eventTimeNanos);
    }

    public String toString() {
        return "CCTouchEvent(pointerId=" + this.pointerId + ", toolType=" + this.toolType + ", action=" + this.action + ", x=" + this.x + ", y=" + this.y + ", pressure=" + this.pressure + ", majorAxisSize=" + this.majorAxisSize + ", eventTimeNanos=" + this.eventTimeNanos + ')';
    }

    public CCTouchEvent(int r1, int r2, int r3, int r4, int r5, int r6, int r7, long r8) {
        this.pointerId = r1;
        this.toolType = r2;
        this.action = r3;
        this.x = r4;
        this.y = r5;
        this.pressure = r6;
        this.majorAxisSize = r7;
        this.eventTimeNanos = r8;
    }

    public final int getPointerId() {
        return this.pointerId;
    }

    public final int getToolType() {
        return this.toolType;
    }

    public final int getAction() {
        return this.action;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final int getPressure() {
        return this.pressure;
    }

    public final int getMajorAxisSize() {
        return this.majorAxisSize;
    }

    public final long getEventTimeNanos() {
        return this.eventTimeNanos;
    }
}

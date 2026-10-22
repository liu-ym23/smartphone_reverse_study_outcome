package com.obric.autogui.common.api.platform.screen.capture;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IScreenOperationApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OTouchInfo {
    private final float x;
    private final float y;

    public static /* synthetic */ OTouchInfo copy$default(OTouchInfo r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.x;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.y;
    L9:
        return r0.copy(r1, r2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final OTouchInfo copy(float r1, float r2) {
        return new OTouchInfo(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OTouchInfo.class) == true) goto L8;
        return false;
    L8:
        OTouchInfo r6 = (OTouchInfo) ZeusTransformUtils.preCheckCast(r5, OTouchInfo.class, "com.obric.aiagent.plugin");
        if (Float.compare(this.x, r6.x) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.y, r6.y) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public String toString() {
        return "OTouchInfo(x=" + this.x + ", y=" + this.y + ')';
    }

    public OTouchInfo(float r1, float r2) {
        this.x = r1;
        this.y = r2;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }
}

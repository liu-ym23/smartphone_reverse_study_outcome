package com.obric.autogui.common.api.space;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: RobotsPolicyState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RobotsPolicyState {
    private final RobotsScreenshotBlockReason hint;
    private final boolean screenshotForbidden;

    public static /* synthetic */ RobotsPolicyState copy$default(RobotsPolicyState r0, boolean r1, RobotsScreenshotBlockReason r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.screenshotForbidden;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hint;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.screenshotForbidden;
    }

    public final RobotsScreenshotBlockReason component2() {
        return this.hint;
    }

    public final RobotsPolicyState copy(boolean r1, RobotsScreenshotBlockReason r2) {
        o.e(r2, "hint");
        return new RobotsPolicyState(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RobotsPolicyState.class) == true) goto L8;
        return false;
    L8:
        RobotsPolicyState r6 = (RobotsPolicyState) ZeusTransformUtils.preCheckCast(r5, RobotsPolicyState.class, "com.obric.aiagent.plugin");
        if (this.screenshotForbidden == r6.screenshotForbidden) goto L12;
        return false;
    L12:
        if (this.hint == r6.hint) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.screenshotForbidden) * 31) + this.hint.hashCode();
    }

    public String toString() {
        return "RobotsPolicyState(screenshotForbidden=" + this.screenshotForbidden + ", hint=" + this.hint + ')';
    }

    public RobotsPolicyState(boolean r2, RobotsScreenshotBlockReason r3) {
        o.e(r3, "hint");
        this.screenshotForbidden = r2;
        this.hint = r3;
    }

    public final boolean getScreenshotForbidden() {
        return this.screenshotForbidden;
    }

    public final RobotsScreenshotBlockReason getHint() {
        return this.hint;
    }
}

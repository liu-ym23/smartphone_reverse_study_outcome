package com.obric.autogui.common.api.platform.computercontrol;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComputerControlModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CCApplicationAccessResult {
    private final int rawValue;
    private final CCApplicationAccessState state;

    public static /* synthetic */ CCApplicationAccessResult copy$default(CCApplicationAccessResult r0, CCApplicationAccessState r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.rawValue;
    L9:
        return r0.copy(r1, r2);
    }

    public final CCApplicationAccessState component1() {
        return this.state;
    }

    public final int component2() {
        return this.rawValue;
    }

    public final CCApplicationAccessResult copy(CCApplicationAccessState r1, int r2) {
        o.e(r1, "state");
        return new CCApplicationAccessResult(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CCApplicationAccessResult.class) == true) goto L8;
        return false;
    L8:
        CCApplicationAccessResult r6 = (CCApplicationAccessResult) ZeusTransformUtils.preCheckCast(r5, CCApplicationAccessResult.class, "com.obric.aiagent.plugin");
        if (this.state == r6.state) goto L12;
        return false;
    L12:
        if (this.rawValue == r6.rawValue) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.state.hashCode() * 31) + Integer.hashCode(this.rawValue);
    }

    public String toString() {
        return "CCApplicationAccessResult(state=" + this.state + ", rawValue=" + this.rawValue + ')';
    }

    public CCApplicationAccessResult(CCApplicationAccessState r2, int r3) {
        o.e(r2, "state");
        this.state = r2;
        this.rawValue = r3;
    }

    public final CCApplicationAccessState getState() {
        return this.state;
    }

    public final int getRawValue() {
        return this.rawValue;
    }
}

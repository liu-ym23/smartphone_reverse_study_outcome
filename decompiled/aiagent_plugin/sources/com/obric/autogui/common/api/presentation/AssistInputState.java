package com.obric.autogui.common.api.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IAutoActionGlobalUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistInputState {
    private final Integer height;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public AssistInputState() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AssistInputState copy$default(AssistInputState r0, boolean r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.height;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final Integer component2() {
        return this.height;
    }

    public final AssistInputState copy(boolean r1, Integer r2) {
        return new AssistInputState(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AssistInputState.class) == true) goto L8;
        return false;
    L8:
        AssistInputState r6 = (AssistInputState) ZeusTransformUtils.preCheckCast(r5, AssistInputState.class, "com.obric.aiagent.plugin");
        if (this.visible == r6.visible) goto L12;
        return false;
    L12:
        if (o.a(this.height, r6.height) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.visible) * 31;
        Integer r1 = this.height;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AssistInputState(visible=" + this.visible + ", height=" + this.height + ')';
    }

    public AssistInputState(boolean r1, Integer r2) {
        this.visible = r1;
        this.height = r2;
    }

    public /* synthetic */ AssistInputState(boolean r1, Integer r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final Integer getHeight() {
        return this.height;
    }
}

package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28349a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f28349a == r6.f28349a) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return Integer.hashCode(this.f28349a);
    }

    public String toString() {
        return "ActionEffectRequestError(code=" + this.f28349a + ')';
    }

    public h(int r1) {
        this.f28349a = r1;
    }

    public final int a() {
        return this.f28349a;
    }
}

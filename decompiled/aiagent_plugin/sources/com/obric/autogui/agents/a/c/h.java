package com.obric.autogui.agents.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectExecutionResultEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.operator.g.c f26346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f26348c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f26346a == r6.f26346a) goto L12;
        return false;
    L12:
        if (this.f26347b == r6.f26347b) goto L15;
        return false;
    L15:
        if (this.f26348c == r6.f26348c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f26346a.hashCode() * 31) + Integer.hashCode(this.f26347b)) * 31) + Boolean.hashCode(this.f26348c);
    }

    public String toString() {
        return "ActionEffectExecutionResultFacts(executionPhase=" + this.f26346a + ", statusCode=" + this.f26347b + ", hasError=" + this.f26348c + ')';
    }

    public h(com.obric.autogui.operator.g.c r2, int r3, boolean r4) {
        o.e(r2, "executionPhase");
        this.f26346a = r2;
        this.f26347b = r3;
        this.f26348c = r4;
    }

    public final com.obric.autogui.operator.g.c a() {
        return this.f26346a;
    }

    public final int b() {
        return this.f26347b;
    }

    public final boolean c() {
        return this.f26348c;
    }
}

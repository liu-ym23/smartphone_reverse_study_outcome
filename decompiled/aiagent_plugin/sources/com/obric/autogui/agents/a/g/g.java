package com.obric.autogui.agents.a.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectPipelineModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.operator.g.c f26485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f26487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.operator.g.e f26488d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
        return false;
    L8:
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f26485a == r6.f26485a) goto L12;
        return false;
    L12:
        if (this.f26486b == r6.f26486b) goto L15;
        return false;
    L15:
        if (this.f26487c == r6.f26487c) goto L18;
        return false;
    L18:
        if (this.f26488d == r6.f26488d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f26485a.hashCode() * 31) + Integer.hashCode(this.f26486b)) * 31) + Boolean.hashCode(this.f26487c)) * 31) + this.f26488d.hashCode();
    }

    public String toString() {
        return "ActionEffectOriginalResultFacts(executionPhase=" + this.f26485a + ", statusCode=" + this.f26486b + ", hasError=" + this.f26487c + ", strategy=" + this.f26488d + ')';
    }

    public g(com.obric.autogui.operator.g.c r2, int r3, boolean r4, com.obric.autogui.operator.g.e r5) {
        o.e(r2, "executionPhase");
        o.e(r5, "strategy");
        this.f26485a = r2;
        this.f26486b = r3;
        this.f26487c = r4;
        this.f26488d = r5;
    }

    public final com.obric.autogui.operator.g.c a() {
        return this.f26485a;
    }

    public final int b() {
        return this.f26486b;
    }

    public final boolean c() {
        return this.f26487c;
    }

    public final com.obric.autogui.operator.g.e d() {
        return this.f26488d;
    }

    public final boolean e() {
        if (this.f26487c == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f26486b < 0) goto L8;
        return false;
    }

    public final boolean f() {
        if (this.f26485a != com.obric.autogui.operator.g.c.f29925d) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g() {
        if (f() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f26487c == true) goto L11;
        if (this.f26486b < 0) goto L11;
        if (this.f26488d != com.obric.autogui.operator.g.e.f29929b) goto L11;
        return true;
    }
}

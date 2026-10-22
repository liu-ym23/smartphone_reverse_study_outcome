package com.obric.autogui.agents.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectAttemptModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f26263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.n.a.e f26264b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
        if (this.f26263a == r6.f26263a) goto L12;
        return false;
    L12:
        if (o.a(this.f26264b, r6.f26264b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f26263a) * 31;
        com.obric.autogui.agents.a.n.a.e r1 = this.f26264b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionEffectInputTargetEvidence(viewTreeAvailable=" + this.f26263a + ", target=" + this.f26264b + ')';
    }

    public h(boolean r1, com.obric.autogui.agents.a.n.a.e r2) {
        this.f26263a = r1;
        this.f26264b = r2;
    }

    public final boolean a() {
        return this.f26263a;
    }

    public final com.obric.autogui.agents.a.n.a.e b() {
        return this.f26264b;
    }
}

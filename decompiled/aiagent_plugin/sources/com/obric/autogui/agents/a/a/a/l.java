package com.obric.autogui.agents.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectActionEvidence.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.operator.a.b.e.a f26190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.n.a.f f26191b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (this.f26190a == r6.f26190a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26191b, r6.f26191b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        com.obric.autogui.operator.a.b.e.a r0 = this.f26190a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        com.obric.autogui.agents.a.n.a.f r4 = this.f26191b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SwipeActionEffectEvidence(direction=" + this.f26190a + ", scrollTargetBefore=" + this.f26191b + ')';
    }

    public final com.obric.autogui.operator.a.b.e.a a() {
        return this.f26190a;
    }

    public final com.obric.autogui.agents.a.n.a.f b() {
        return this.f26191b;
    }

    public l(com.obric.autogui.operator.a.b.e.a r2, com.obric.autogui.agents.a.n.a.f r3) {
        super(null);
        this.f26190a = r2;
        this.f26191b = r3;
    }
}

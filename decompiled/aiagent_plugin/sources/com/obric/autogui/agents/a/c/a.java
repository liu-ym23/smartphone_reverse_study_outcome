package com.obric.autogui.agents.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.a.a.b f26287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.c f26288b;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26287a, r6.f26287a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26288b, r6.f26288b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        com.obric.autogui.agents.vlm.models.a.a.b r0 = this.f26287a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        com.obric.autogui.agents.a.l.c r4 = this.f26288b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectEvaluationRoundSeed(seed=" + this.f26287a + ", snapshotSeed=" + this.f26288b + ')';
    }

    public a(com.obric.autogui.agents.vlm.models.a.a.b r1, com.obric.autogui.agents.a.l.c r2) {
        this.f26287a = r1;
        this.f26288b = r2;
    }

    public /* synthetic */ a(com.obric.autogui.agents.vlm.models.a.a.b r2, com.obric.autogui.agents.a.l.c r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final com.obric.autogui.agents.vlm.models.a.a.b a() {
        return this.f26287a;
    }

    public final com.obric.autogui.agents.a.l.c b() {
        return this.f26288b;
    }
}

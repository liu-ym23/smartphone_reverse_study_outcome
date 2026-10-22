package com.obric.autogui.agents.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectActionEvidence.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.d.e f26179a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26179a, r6.f26179a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        com.obric.autogui.agents.a.d.e r0 = this.f26179a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ClickActionEffectEvidence(imageTarget=" + this.f26179a + ')';
    }

    public final com.obric.autogui.agents.a.d.e a() {
        return this.f26179a;
    }

    public f(com.obric.autogui.agents.a.d.e r2) {
        super(null);
        this.f26179a = r2;
    }
}

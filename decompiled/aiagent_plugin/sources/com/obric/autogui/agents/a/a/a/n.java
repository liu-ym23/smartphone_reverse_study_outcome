package com.obric.autogui.agents.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectActionEvidence.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.a.a.h f26203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.c f26204d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26201a, r6.f26201a) == true) goto L12;
        return false;
    L12:
        if (this.f26202b == r6.f26202b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f26203c, r6.f26203c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f26204d, r6.f26204d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.f26201a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Boolean.hashCode(this.f26202b)) * 31;
        com.obric.autogui.agents.a.a.h r4 = this.f26203c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        com.obric.autogui.agents.a.l.c r7 = this.f26204d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TypeActionEffectEvidence(expectedText=" + this.f26201a + ", isReplaceText=" + this.f26202b + ", inputTargetEvidence=" + this.f26203c + ", inputTextResultSnapshot=" + this.f26204d + ')';
    }

    public final String a() {
        return this.f26201a;
    }

    public final boolean b() {
        return this.f26202b;
    }

    public final com.obric.autogui.agents.a.a.h c() {
        return this.f26203c;
    }

    public final com.obric.autogui.agents.a.l.c d() {
        return this.f26204d;
    }

    public n(String r2, boolean r3, com.obric.autogui.agents.a.a.h r4, com.obric.autogui.agents.a.l.c r5) {
        super(null);
        this.f26201a = r2;
        this.f26202b = r3;
        this.f26203c = r4;
        this.f26204d = r5;
    }
}

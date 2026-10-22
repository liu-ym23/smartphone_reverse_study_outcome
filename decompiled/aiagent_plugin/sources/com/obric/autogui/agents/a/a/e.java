package com.obric.autogui.agents.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectAttemptModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.k f26247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f26248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26249c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (this.f26247a == r6.f26247a) goto L12;
        return false;
    L12:
        if (this.f26248b == r6.f26248b) goto L15;
        return false;
    L15:
        if (o.a(this.f26249c, r6.f26249c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f26247a.hashCode() * 31) + this.f26248b.hashCode()) * 31) + this.f26249c.hashCode();
    }

    public String toString() {
        return "ActionEffectDirectResult(status=" + this.f26247a + ", reason=" + this.f26248b + ", evidence=" + this.f26249c + ')';
    }

    public e(com.obric.autogui.agents.a.f.k r2, d r3, String r4) {
        o.e(r2, "status");
        o.e(r3, "reason");
        o.e(r4, "evidence");
        this.f26247a = r2;
        this.f26248b = r3;
        this.f26249c = r4;
    }

    public final com.obric.autogui.agents.a.f.k a() {
        return this.f26247a;
    }

    public final d b() {
        return this.f26248b;
    }

    public final com.obric.autogui.agents.a.f.i c() {
        com.obric.autogui.agents.a.f.k r2 = this.f26247a;
        com.obric.autogui.agents.a.f.c r3 = null;
        return new com.obric.autogui.agents.a.f.i(r2, r2, r3, this.f26249c, p.b(), 0, null, null, null, 448, null);
    }
}

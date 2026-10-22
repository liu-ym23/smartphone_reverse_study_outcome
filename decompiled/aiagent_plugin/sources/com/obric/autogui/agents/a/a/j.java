package com.obric.autogui.agents.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectPreActionObservation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.c f26269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26270b;

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, j.class) == true) goto L8;
        return false;
    L8:
        j r8 = (j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26269a, r8.f26269a) == true) goto L12;
        return false;
    L12:
        if (this.f26270b == r8.f26270b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f26269a.hashCode() * 31) + Long.hashCode(this.f26270b);
    }

    public String toString() {
        return "ActionEffectPreActionObservation(baseline=" + this.f26269a + ", observedAtMs=" + this.f26270b + ')';
    }

    public j(com.obric.autogui.agents.a.l.c r2, long r3) {
        o.e(r2, "baseline");
        this.f26269a = r2;
        this.f26270b = r3;
    }

    public final com.obric.autogui.agents.a.l.c a() {
        return this.f26269a;
    }

    public final long b() {
        return this.f26270b;
    }
}

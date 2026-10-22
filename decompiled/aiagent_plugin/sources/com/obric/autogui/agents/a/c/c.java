package com.obric.autogui.agents.a.c;

import com.obric.autogui.agents.a.m.o;
import com.obric.autogui.agents.a.m.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectEvaluator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.a f26289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.a f26291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.autogui.agents.vlm.models.a.a.b f26292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.c f26293e;
    private final boolean f;
    private final t g;
    private final o h;
    private final int i;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f26289a, r6.f26289a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f26290b, r6.f26290b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f26291c, r6.f26291c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f26292d, r6.f26292d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f26293e, r6.f26293e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f26289a.hashCode() * 31) + this.f26290b.hashCode()) * 31) + this.f26291c.hashCode()) * 31;
        com.obric.autogui.agents.vlm.models.a.a.b r1 = this.f26292d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        com.obric.autogui.agents.a.l.c r5 = this.f26293e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((((r4 + r2) * 31) + Boolean.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + Integer.hashCode(this.i);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ActionEffectEvaluationSnapshotRequest(logContext=" + this.f26289a + ", captureStage=" + this.f26290b + ", requirements=" + this.f26291c + ", seed=" + this.f26292d + ", snapshotSeed=" + this.f26293e + ", allowLiveFallback=" + this.f + ", timingRecorder=" + this.g + ", timingPurpose=" + this.h + ", round=" + this.i + ')';
    }

    public c(com.obric.autogui.agents.a.a r2, String r3, com.obric.autogui.agents.a.l.a r4, com.obric.autogui.agents.vlm.models.a.a.b r5, com.obric.autogui.agents.a.l.c r6, boolean r7, t r8, o r9, int r10) {
        d.h.b.o.e(r2, "logContext");
        d.h.b.o.e(r3, "captureStage");
        d.h.b.o.e(r4, "requirements");
        d.h.b.o.e(r8, "timingRecorder");
        d.h.b.o.e(r9, "timingPurpose");
        this.f26289a = r2;
        this.f26290b = r3;
        this.f26291c = r4;
        this.f26292d = r5;
        this.f26293e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public final com.obric.autogui.agents.a.a a() {
        return this.f26289a;
    }

    public final String b() {
        return this.f26290b;
    }

    public final com.obric.autogui.agents.a.l.a c() {
        return this.f26291c;
    }

    public final com.obric.autogui.agents.vlm.models.a.a.b d() {
        return this.f26292d;
    }

    public final com.obric.autogui.agents.a.l.c e() {
        return this.f26293e;
    }

    public final boolean f() {
        return this.f;
    }

    public final t g() {
        return this.g;
    }

    public final o h() {
        return this.h;
    }

    public final int i() {
        return this.i;
    }
}

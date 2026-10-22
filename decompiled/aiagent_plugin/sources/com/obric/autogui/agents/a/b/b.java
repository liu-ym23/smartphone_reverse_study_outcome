package com.obric.autogui.agents.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectDetector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.a.f f26271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.agents.a.l.c f26272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.c f26273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f26275e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f26271a, r6.f26271a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f26272b, r6.f26272b) == true) goto L15;
        return false;
    L15:
        if (this.f26273c == r6.f26273c) goto L18;
        return false;
    L18:
        if (this.f26274d == r6.f26274d) goto L21;
        return false;
    L21:
        if (this.f26275e == r6.f26275e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f26271a.hashCode() * 31) + this.f26272b.hashCode()) * 31) + this.f26273c.hashCode()) * 31) + Integer.hashCode(this.f26274d)) * 31) + Integer.hashCode(this.f26275e);
    }

    public String toString() {
        return "ActionEffectDetectorContext(input=" + this.f26271a + ", current=" + this.f26272b + ", detectorType=" + this.f26273c + ", round=" + this.f26274d + ", maxDetectCount=" + this.f26275e + ')';
    }

    public b(com.obric.autogui.agents.a.a.f r2, com.obric.autogui.agents.a.l.c r3, com.obric.autogui.agents.a.f.c r4, int r5, int r6) {
        o.e(r2, "input");
        o.e(r3, "current");
        o.e(r4, "detectorType");
        this.f26271a = r2;
        this.f26272b = r3;
        this.f26273c = r4;
        this.f26274d = r5;
        this.f26275e = r6;
    }

    public final com.obric.autogui.agents.a.a.f a() {
        return this.f26271a;
    }

    public final com.obric.autogui.agents.a.l.c b() {
        return this.f26272b;
    }

    public final com.obric.autogui.agents.a.f.c c() {
        return this.f26273c;
    }

    public final int d() {
        return this.f26274d;
    }

    public final int e() {
        return this.f26275e;
    }
}

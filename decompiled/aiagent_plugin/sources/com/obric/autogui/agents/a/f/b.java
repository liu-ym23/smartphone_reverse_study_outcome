package com.obric.autogui.agents.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ActionEffectDetectionModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f26397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f26398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f26400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f26401e;

    public static /* synthetic */ b a(b r3, c r4, k r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f26397a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f26398b;
    L8:
        k r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f26399c;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.f26400d;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.f26401e;
    L17:
        c r12 = r4;
        return r3.a(r12, r11, r0, r1, r8);
    }

    public final b a(c r7, k r8, String r9, String r10, String r11) {
        o.e(r7, "detector");
        o.e(r8, "status");
        o.e(r9, "evidence");
        o.e(r11, "logDetails");
        return new b(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f26397a == r6.f26397a) goto L12;
        return false;
    L12:
        if (this.f26398b == r6.f26398b) goto L15;
        return false;
    L15:
        if (o.a(this.f26399c, r6.f26399c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f26400d, r6.f26400d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f26401e, r6.f26401e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f26397a.hashCode() * 31) + this.f26398b.hashCode()) * 31) + this.f26399c.hashCode()) * 31;
        String r1 = this.f26400d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.f26401e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionEffectDetectorResult(detector=" + this.f26397a + ", status=" + this.f26398b + ", evidence=" + this.f26399c + ", systemHint=" + this.f26400d + ", logDetails=" + this.f26401e + ')';
    }

    public b(c r2, k r3, String r4, String r5, String r6) {
        o.e(r2, "detector");
        o.e(r3, "status");
        o.e(r4, "evidence");
        o.e(r6, "logDetails");
        this.f26397a = r2;
        this.f26398b = r3;
        this.f26399c = r4;
        this.f26400d = r5;
        this.f26401e = r6;
    }

    public /* synthetic */ b(c r7, k r8, String r9, String r10, String r11, int r12, d.h.b.h r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L8;
        r11 = "";
    L8:
        this(r7, r8, r9, r4, r11);
    }

    public final c a() {
        return this.f26397a;
    }

    public final k b() {
        return this.f26398b;
    }

    public final String c() {
        return this.f26399c;
    }

    public final String d() {
        return this.f26400d;
    }

    public final String e() {
        return this.f26401e;
    }
}

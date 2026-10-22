package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f26667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r f26668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<i> f26669e;
    private final List<e> f;

    public static /* synthetic */ g a(g r10, long r11, long r13, s r15, r r16, List r17, List r18, int r19, Object r20) {
        List<i> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List<e> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        if ((r19 & 1) == 0) goto L5;
        long r3 = r10.f26665a;
    L7:
        if ((r19 & 2) == 0) goto L9;
        long r5 = r10.f26666b;
    L11:
        if ((r19 & 4) == 0) goto L13;
        s r7 = r10.f26667c;
    L15:
        if ((r19 & 8) == 0) goto L17;
        r r8 = r10.f26668d;
    L19:
        if ((r19 & 16) == 0) goto L22;
        r1 = r10.f26669e;
    L22:
        if ((r19 & 32) == 0) goto L25;
        r2 = r10.f;
    L25:
        return r10.a(r3, r5, r7, r8, r1, r2);
    L17:
        r8 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public final g a(long r12, long r14, s r16, r r17, List<i> r18, List<e> r19) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "finishReason");
        d.h.b.o.e(r9, "rounds");
        d.h.b.o.e(r10, "detectors");
        return new g(r12, r14, r16, r17, r9, r10);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, g.class) == true) goto L8;
        return false;
    L8:
        g r10 = (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
        if (this.f26665a == r10.f26665a) goto L12;
        return false;
    L12:
        if (this.f26666b == r10.f26666b) goto L15;
        return false;
    L15:
        if (this.f26667c == r10.f26667c) goto L18;
        return false;
    L18:
        if (this.f26668d == r10.f26668d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f26669e, r10.f26669e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.f26665a) * 31) + Long.hashCode(this.f26666b)) * 31) + this.f26667c.hashCode()) * 31;
        r r1 = this.f26668d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.f26669e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionEffectEvaluationTiming(totalElapsedMs=" + this.f26665a + ", controlElapsedMs=" + this.f26666b + ", finishReason=" + this.f26667c + ", cancellationReason=" + this.f26668d + ", rounds=" + this.f26669e + ", detectors=" + this.f + ')';
    }

    public g(long r3, long r5, s r7, r r8, List<i> r9, List<e> r10) {
        List<i> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<e> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "finishReason");
        d.h.b.o.e(r11, "rounds");
        d.h.b.o.e(r12, "detectors");
        this.f26665a = r3;
        this.f26666b = r5;
        this.f26667c = r7;
        this.f26668d = r8;
        this.f26669e = r11;
        this.f = r12;
    }

    public final long a() {
        return this.f26665a;
    }

    public final long b() {
        return this.f26666b;
    }

    public final s c() {
        return this.f26667c;
    }

    public final r d() {
        return this.f26668d;
    }

    public final List<i> e() {
        return this.f26669e;
    }

    public final List<e> f() {
        return this.f;
    }
}

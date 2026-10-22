package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f26698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f26699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f26700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f26701e;
    private final long f;
    private final s g;
    private final boolean h;
    private final List<m> i;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, p.class) == true) goto L8;
        return false;
    L8:
        p r10 = (p) ZeusTransformUtils.preCheckCast(r9, p.class, "com.obric.aiagent.plugin");
        if (this.f26697a == r10.f26697a) goto L12;
        return false;
    L12:
        if (this.f26698b == r10.f26698b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f26699c, r10.f26699c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f26700d, r10.f26700d) == true) goto L21;
        return false;
    L21:
        if (this.f26701e == r10.f26701e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.f26697a) * 31) + this.f26698b.hashCode()) * 31) + this.f26699c.hashCode()) * 31;
        Integer r1 = this.f26700d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((r0 + r2) * 31) + Long.hashCode(this.f26701e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionEffectSnapshotTiming(sequence=" + this.f26697a + ", purpose=" + this.f26698b + ", stage=" + this.f26699c + ", round=" + this.f26700d + ", totalElapsedMs=" + this.f26701e + ", waitElapsedMs=" + this.f + ", finishReason=" + this.g + ", secureShortCircuited=" + this.h + ", capabilities=" + this.i + ')';
    }

    public p(long r3, o r5, String r6, Integer r7, long r8, long r10, s r12, boolean r13, List<m> r14) {
        List<m> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "purpose");
        d.h.b.o.e(r6, "stage");
        d.h.b.o.e(r12, "finishReason");
        d.h.b.o.e(r15, "capabilities");
        this.f26697a = r3;
        this.f26698b = r5;
        this.f26699c = r6;
        this.f26700d = r7;
        this.f26701e = r8;
        this.f = r10;
        this.g = r12;
        this.h = r13;
        this.i = r15;
    }

    public final long a() {
        return this.f26697a;
    }

    public final o b() {
        return this.f26698b;
    }

    public final long c() {
        return this.f26701e;
    }

    public final long d() {
        return this.f;
    }

    public final List<m> e() {
        return this.i;
    }
}

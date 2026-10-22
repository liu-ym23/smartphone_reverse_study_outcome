package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f26671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f26673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f26674e;
    private final long f;
    private final long g;
    private final s h;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.aiagent.plugin");
        if (this.f26670a == r10.f26670a) goto L12;
        return false;
    L12:
        if (this.f26671b == r10.f26671b) goto L15;
        return false;
    L15:
        if (this.f26672c == r10.f26672c) goto L18;
        return false;
    L18:
        if (this.f26673d == r10.f26673d) goto L21;
        return false;
    L21:
        if (this.f26674e == r10.f26674e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.f26670a) * 31) + Integer.hashCode(this.f26671b)) * 31) + Long.hashCode(this.f26672c)) * 31) + Long.hashCode(this.f26673d)) * 31) + Long.hashCode(this.f26674e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ActionEffectRoundTiming(sequence=" + this.f26670a + ", round=" + this.f26671b + ", totalElapsedMs=" + this.f26672c + ", delayElapsedMs=" + this.f26673d + ", snapshotElapsedMs=" + this.f26674e + ", detectorBatchElapsedMs=" + this.f + ", aggregationElapsedMs=" + this.g + ", finishReason=" + this.h + ')';
    }

    public i(long r2, int r4, long r5, long r7, long r9, long r11, long r13, s r15) {
        d.h.b.o.e(r15, "finishReason");
        this.f26670a = r2;
        this.f26671b = r4;
        this.f26672c = r5;
        this.f26673d = r7;
        this.f26674e = r9;
        this.f = r11;
        this.g = r13;
        this.h = r15;
    }

    public final long a() {
        return this.f26670a;
    }

    public final int b() {
        return this.f26671b;
    }

    public final long c() {
        return this.f26672c;
    }

    public final long d() {
        return this.f26673d;
    }

    public final long e() {
        return this.f26674e;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final s h() {
        return this.h;
    }
}

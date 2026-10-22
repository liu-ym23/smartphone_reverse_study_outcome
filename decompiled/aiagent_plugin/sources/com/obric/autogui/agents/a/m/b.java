package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f26653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s f26655d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (this.f26652a == r10.f26652a) goto L12;
        return false;
    L12:
        if (this.f26653b == r10.f26653b) goto L15;
        return false;
    L15:
        if (this.f26654c == r10.f26654c) goto L18;
        return false;
    L18:
        if (this.f26655d == r10.f26655d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f26652a) * 31) + this.f26653b.hashCode()) * 31) + Long.hashCode(this.f26654c)) * 31) + this.f26655d.hashCode();
    }

    public String toString() {
        return "ActionEffectBlockingStageTiming(sequence=" + this.f26652a + ", phase=" + this.f26653b + ", elapsedMs=" + this.f26654c + ", finishReason=" + this.f26655d + ')';
    }

    public b(long r2, a r4, long r5, s r7) {
        d.h.b.o.e(r4, "phase");
        d.h.b.o.e(r7, "finishReason");
        this.f26652a = r2;
        this.f26653b = r4;
        this.f26654c = r5;
        this.f26655d = r7;
    }

    public final long a() {
        return this.f26652a;
    }

    public final a b() {
        return this.f26653b;
    }

    public final long c() {
        return this.f26654c;
    }
}

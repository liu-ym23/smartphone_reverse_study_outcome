package com.obric.autogui.agents.a.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectTimingModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f26687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f26688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f26689d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L8;
        return false;
    L8:
        m r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        if (this.f26686a == r10.f26686a) goto L12;
        return false;
    L12:
        if (this.f26687b == r10.f26687b) goto L15;
        return false;
    L15:
        if (this.f26688c == r10.f26688c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f26689d, r10.f26689d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((Long.hashCode(this.f26686a) * 31) + this.f26687b.hashCode()) * 31) + this.f26688c.hashCode()) * 31;
        Long r2 = this.f26689d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionEffectSnapshotCapabilityTiming(sequence=" + this.f26686a + ", capability=" + this.f26687b + ", state=" + this.f26688c + ", elapsedMs=" + this.f26689d + ')';
    }

    public m(long r3, k r5, l r6, Long r7) {
        d.h.b.o.e(r5, "capability");
        d.h.b.o.e(r6, "state");
        this.f26686a = r3;
        this.f26687b = r5;
        this.f26688c = r6;
        this.f26689d = r7;
        boolean r2 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L23;
        if (r6 != l.f26681a) goto L13;
    L16:
        if (r7 != null) goto L18;
    L17:
        r2 = true;
    L18:
        if (r2 == false) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("Non-executed capability timings must not fabricate elapsedMs".toString());
    L13:
        if (r6 == l.f26682b) goto L16;
        if (r6 != l.f26683c) goto L17;
    L23:
        throw new IllegalArgumentException("Snapshot capability elapsedMs must be null or non-negative".toString());
    L5:
        if (r7.longValue() >= 0) goto L8;
        r4 = false;
        goto L9
    }

    public final long a() {
        return this.f26686a;
    }

    public final k b() {
        return this.f26687b;
    }

    public final l c() {
        return this.f26688c;
    }

    public final Long d() {
        return this.f26689d;
    }
}

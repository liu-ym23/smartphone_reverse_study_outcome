package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f28148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f28151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f28152e;
    private final int f;
    private final boolean g;
    private final boolean h;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (this.f28148a == r6.f28148a) goto L12;
        return false;
    L12:
        if (o.a(this.f28149b, r6.f28149b) == true) goto L15;
        return false;
    L15:
        if (this.f28150c == r6.f28150c) goto L18;
        return false;
    L18:
        if (this.f28151d == r6.f28151d) goto L21;
        return false;
    L21:
        if (this.f28152e == r6.f28152e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = this.f28148a.hashCode() * 31;
        String r1 = this.f28149b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((r0 + r2) * 31) + Integer.hashCode(this.f28150c)) * 31) + Integer.hashCode(this.f28151d)) * 31) + Integer.hashCode(this.f28152e)) * 31) + Integer.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DataFeedbackUploadDrainSummary(trigger=" + this.f28148a + ", taskId=" + this.f28149b + ", totalCandidates=" + this.f28150c + ", uploadedCount=" + this.f28151d + ", failedCount=" + this.f28152e + ", skippedCount=" + this.f + ", stoppedByOmniRunning=" + this.g + ", stoppedByUploadBlocked=" + this.h + ')';
    }

    public d(l r2, String r3, int r4, int r5, int r6, int r7, boolean r8, boolean r9) {
        o.e(r2, "trigger");
        this.f28148a = r2;
        this.f28149b = r3;
        this.f28150c = r4;
        this.f28151d = r5;
        this.f28152e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public final l a() {
        return this.f28148a;
    }

    public final String b() {
        return this.f28149b;
    }

    public final int c() {
        return this.f28150c;
    }

    public final int d() {
        return this.f28151d;
    }

    public final int e() {
        return this.f28152e;
    }

    public final int f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }
}

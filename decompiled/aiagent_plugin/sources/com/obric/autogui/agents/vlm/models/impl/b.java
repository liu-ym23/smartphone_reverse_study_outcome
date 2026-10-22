package com.obric.autogui.agents.vlm.models.impl;

import android.content.ComponentName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PreExecScreenEvidenceCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.agents.a.d.c f27594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f27595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f27596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f27597d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f27594a, r10.f27594a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f27595b, r10.f27595b) == true) goto L15;
        return false;
    L15:
        if (this.f27596c == r10.f27596c) goto L18;
        return false;
    L18:
        if (this.f27597d == r10.f27597d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        com.obric.autogui.agents.a.d.c r0 = this.f27594a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ComponentName r4 = this.f27595b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + Long.hashCode(this.f27596c)) * 31) + Long.hashCode(this.f27597d);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PreExecScreenEvidenceCache(imageFingerprint=" + this.f27594a + ", topComponent=" + this.f27595b + ", capturedAt=" + this.f27596c + ", expireMs=" + this.f27597d + ')';
    }

    public b(com.obric.autogui.agents.a.d.c r1, ComponentName r2, long r3, long r5) {
        this.f27594a = r1;
        this.f27595b = r2;
        this.f27596c = r3;
        this.f27597d = r5;
    }

    public final com.obric.autogui.agents.a.d.c a() {
        return this.f27594a;
    }

    public final ComponentName b() {
        return this.f27595b;
    }

    public final boolean a(long r5) {
        long r0 = this.f27597d;
        long r6 = r5 - this.f27596c;
        if (0 <= r6) goto L5;
        return false;
    L5:
        if (r6 > r0) goto L9;
        return true;
    L9:
        return false;
    }
}

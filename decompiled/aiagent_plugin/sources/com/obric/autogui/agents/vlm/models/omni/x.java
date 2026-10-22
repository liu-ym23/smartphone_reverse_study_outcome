package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OmniSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f28889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f28890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f28891d;

    public static /* synthetic */ x a(x r3, String r4, Long r5, long r6, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f28888a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f28889b;
    L8:
        Long r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f28890c;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.f28891d;
    L14:
        String r7 = r4;
        return r3.a(r7, r11, r0, r8);
    }

    public final x a(String r7, Long r8, long r9, Long r11) {
        d.h.b.o.e(r7, "screenshotStepId");
        return new x(r7, r8, r9, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, x.class) == true) goto L8;
        return false;
    L8:
        x r10 = (x) ZeusTransformUtils.preCheckCast(r9, x.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f28888a, r10.f28888a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28889b, r10.f28889b) == true) goto L15;
        return false;
    L15:
        if (this.f28890c == r10.f28890c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f28891d, r10.f28891d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f28888a.hashCode() * 31;
        Long r1 = this.f28889b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Long.hashCode(this.f28890c)) * 31;
        Long r5 = this.f28891d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PostActionBlockingTiming(screenshotStepId=" + this.f28888a + ", modelViewTreeWaitElapsedMs=" + this.f28889b + ", modelScreenshotObserverElapsedMs=" + this.f28890c + ", whiteScreenNotifyWaitElapsedMs=" + this.f28891d + ')';
    }

    public x(String r2, Long r3, long r4, Long r6) {
        d.h.b.o.e(r2, "screenshotStepId");
        this.f28888a = r2;
        this.f28889b = r3;
        this.f28890c = r4;
        this.f28891d = r6;
    }

    public /* synthetic */ x(String r7, Long r8, long r9, Long r11, int r12, d.h.b.h r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r11);
    }

    public final String a() {
        return this.f28888a;
    }

    public final Long b() {
        return this.f28889b;
    }

    public final long c() {
        return this.f28890c;
    }

    public final Long d() {
        return this.f28891d;
    }
}

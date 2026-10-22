package com.obric.autogui.agents.vlm.models.omni.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DataFeedbackUploadModels.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f28143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f28145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f28146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f28147e;
    private final Boolean f;

    public static /* synthetic */ c a(c r4, l r5, String r6, Integer r7, e r8, j r9, Boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.f28143a;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.f28144b;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.f28145c;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.f28146d;
    L14:
        e r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.f28147e;
    L17:
        j r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.f;
    L20:
        l r14 = r5;
        return r4.a(r14, r13, r0, r1, r2, r10);
    }

    public final c a(l r8, String r9, Integer r10, e r11, j r12, Boolean r13) {
        o.e(r8, "trigger");
        return new c(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f28143a == r6.f28143a) goto L12;
        return false;
    L12:
        if (o.a(this.f28144b, r6.f28144b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f28145c, r6.f28145c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f28146d, r6.f28146d) == true) goto L21;
        return false;
    L21:
        if (this.f28147e == r6.f28147e) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.f28143a.hashCode() * 31;
        String r1 = this.f28144b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.f28145c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        e r8 = this.f28146d;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        j r11 = this.f28147e;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Boolean r14 = this.f;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "DataFeedbackUploadDrainRequest(trigger=" + this.f28143a + ", taskId=" + this.f28144b + ", dataCount=" + this.f28145c + ", feedbackInfo=" + this.f28146d + ", source=" + this.f28147e + ", isFinish=" + this.f + ')';
    }

    public c(l r2, String r3, Integer r4, e r5, j r6, Boolean r7) {
        o.e(r2, "trigger");
        this.f28143a = r2;
        this.f28144b = r3;
        this.f28145c = r4;
        this.f28146d = r5;
        this.f28147e = r6;
        this.f = r7;
    }

    public /* synthetic */ c(l r7, String r8, Integer r9, e r10, j r11, Boolean r12, int r13, d.h.b.h r14) {
        Boolean r1 = null;
        if ((r13 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        Integer r2 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        e r3 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        j r4 = null;
    L19:
        if ((r13 & 32) != 0) goto L22;
        r1 = r12;
    L22:
        this(r7, r0, r2, r3, r4, r1);
        return;
    L17:
        r4 = r11;
        goto L19
    L13:
        r3 = r10;
        goto L15
    L9:
        r2 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }

    public final l a() {
        return this.f28143a;
    }

    public final String b() {
        return this.f28144b;
    }

    public final e c() {
        return this.f28146d;
    }

    public final j d() {
        return this.f28147e;
    }

    public final Boolean e() {
        return this.f;
    }

    public final boolean f() {
        if (this.f28143a != l.f28188a) goto L5;
    L10:
        return true;
    L5:
        if (this.f28143a == l.f28189b) goto L10;
        if (this.f28143a == l.f28190c) goto L10;
        return false;
    }

    public final j g() {
        j r0 = this.f28147e;
        if (r0 != null) goto L14;
        e r1 = this.f28146d;
        if (r1 == null) goto L7;
        j r2 = r1.c();
    L8:
        if (r2 == null) goto L10;
        return r2;
    L10:
        if (this.f28143a != l.f28191d) goto L13;
        return j.f28178a;
    L13:
        return j.f28179b;
    L7:
        r2 = null;
        goto L8
    L14:
        return r0;
    }

    public final int h() {
        Integer r1 = this.f28145c;
        if (r1 != null) goto L5;
        return 0;
    L5:
        return d.l.n.c(r1.intValue(), 0);
    }
}

package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionEffectEvaluationBatch.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f28337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f28338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.autogui.agents.a.f.g f28339e;

    public static /* synthetic */ e a(e r3, int r4, int r5, String r6, boolean r7, com.obric.autogui.agents.a.f.g r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f28335a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f28336b;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f28337c;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.f28338d;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.f28339e;
    L17:
        int r12 = r4;
        return r3.a(r12, r11, r0, r1, r8);
    }

    public final e a(int r7, int r8, String r9, boolean r10, com.obric.autogui.agents.a.f.g r11) {
        d.h.b.o.e(r9, "stepId");
        d.h.b.o.e(r11, "evaluation");
        return new e(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (this.f28335a == r6.f28335a) goto L12;
        return false;
    L12:
        if (this.f28336b == r6.f28336b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f28337c, r6.f28337c) == true) goto L18;
        return false;
    L18:
        if (this.f28338d == r6.f28338d) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f28339e, r6.f28339e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f28335a) * 31) + Integer.hashCode(this.f28336b)) * 31) + this.f28337c.hashCode()) * 31) + Boolean.hashCode(this.f28338d)) * 31) + this.f28339e.hashCode();
    }

    public String toString() {
        return "ActionEffectEvaluationEntry(actionIndex=" + this.f28335a + ", actionCount=" + this.f28336b + ", stepId=" + this.f28337c + ", completed=" + this.f28338d + ", evaluation=" + this.f28339e + ')';
    }

    public e(int r2, int r3, String r4, boolean r5, com.obric.autogui.agents.a.f.g r6) {
        d.h.b.o.e(r4, "stepId");
        d.h.b.o.e(r6, "evaluation");
        this.f28335a = r2;
        this.f28336b = r3;
        this.f28337c = r4;
        this.f28338d = r5;
        this.f28339e = r6;
    }

    public final int a() {
        return this.f28335a;
    }

    public final int b() {
        return this.f28336b;
    }

    public final String c() {
        return this.f28337c;
    }

    public final boolean d() {
        return this.f28338d;
    }

    public final com.obric.autogui.agents.a.f.g e() {
        return this.f28339e;
    }
}

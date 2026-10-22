package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailShortInstructViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23326e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23322a, r6.f23322a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23323b, r6.f23323b) == true) goto L15;
        return false;
    L15:
        if (this.f23324c == r6.f23324c) goto L18;
        return false;
    L18:
        if (this.f23325d == r6.f23325d) goto L21;
        return false;
    L21:
        if (this.f23326e == r6.f23326e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.f23322a.hashCode() * 31;
        String r1 = this.f23323b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + Boolean.hashCode(this.f23324c)) * 31) + Boolean.hashCode(this.f23325d)) * 31) + Integer.hashCode(this.f23326e);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DetailInstructItemModelV2(enterFrom=" + this.f23322a + ", shortcutInstruct=" + this.f23323b + ", enable=" + this.f23324c + ", isShowTitle=" + this.f23325d + ", shortcutInstructCount=" + this.f23326e + ')';
    }

    public j(String r2, String r3, boolean r4, boolean r5, int r6) {
        d.h.b.o.e(r2, "enterFrom");
        this.f23322a = r2;
        this.f23323b = r3;
        this.f23324c = r4;
        this.f23325d = r5;
        this.f23326e = r6;
    }

    public /* synthetic */ j(String r7, String r8, boolean r9, boolean r10, int r11, int r12, d.h.b.h r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = "";
    L5:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        boolean r3 = false;
    L10:
        if ((r12 & 8) == 0) goto L12;
        r10 = true;
    L12:
        boolean r4 = r10;
        if ((r12 & 16) == 0) goto L15;
        int r5 = 0;
    L16:
        this(r7, r2, r3, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L8:
        r3 = r9;
        goto L10
    }

    public final String a() {
        return this.f23322a;
    }

    public final void a(String r1) {
        this.f23323b = r1;
    }

    public final String b() {
        return this.f23323b;
    }

    public final void a(boolean r1) {
        this.f23324c = r1;
    }

    public final boolean c() {
        return this.f23324c;
    }
}

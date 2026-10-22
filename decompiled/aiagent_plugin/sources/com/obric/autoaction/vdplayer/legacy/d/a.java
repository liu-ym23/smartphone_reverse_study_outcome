package com.obric.autoaction.vdplayer.legacy.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f25859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f25861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f25862d;

    public static /* synthetic */ a a(a r0, b r1, boolean r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.f25859a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.f25860b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.f25861c;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.f25862d;
    L15:
        return r0.a(r1, r2, r3, r4);
    }

    public final a a(b r1, boolean r2, boolean r3, String r4) {
        d.h.b.o.e(r1, "type");
        return new a(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f25859a == r6.f25859a) goto L12;
        return false;
    L12:
        if (this.f25860b == r6.f25860b) goto L15;
        return false;
    L15:
        if (this.f25861c == r6.f25861c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f25862d, r6.f25862d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f25859a.hashCode() * 31) + Boolean.hashCode(this.f25860b)) * 31) + Boolean.hashCode(this.f25861c)) * 31;
        String r2 = this.f25862d;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "ActionButtonState(type=" + this.f25859a + ", isEnabled=" + this.f25860b + ", isProminent=" + this.f25861c + ", text=" + this.f25862d + ')';
    }

    public a(b r2, boolean r3, boolean r4, String r5) {
        d.h.b.o.e(r2, "type");
        this.f25859a = r2;
        this.f25860b = r3;
        this.f25861c = r4;
        this.f25862d = r5;
    }

    public /* synthetic */ a(b r1, boolean r2, boolean r3, String r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        this(r1, r2, r3, r4);
    }

    public final b getType() {
        return this.f25859a;
    }

    public final boolean a() {
        return this.f25860b;
    }

    public final boolean b() {
        return this.f25861c;
    }

    public final String c() {
        return this.f25862d;
    }
}

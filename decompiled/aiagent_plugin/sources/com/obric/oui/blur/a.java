package com.obric.oui.blur;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: BlurConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f34061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f34063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f34065e;

    public a() {
        this(0.0f, 0, 0.0f, 0, 0.0f, 31, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(Float.valueOf(this.f34061a), Float.valueOf(r6.f34061a)) == true) goto L12;
        return false;
    L12:
        if (this.f34062b == r6.f34062b) goto L15;
        return false;
    L15:
        if (o.a(Float.valueOf(this.f34063c), Float.valueOf(r6.f34063c)) == true) goto L18;
        return false;
    L18:
        if (this.f34064d == r6.f34064d) goto L21;
        return false;
    L21:
        if (o.a(Float.valueOf(this.f34065e), Float.valueOf(r6.f34065e)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Float.hashCode(this.f34061a) * 31) + Integer.hashCode(this.f34062b)) * 31) + Float.hashCode(this.f34063c)) * 31) + Integer.hashCode(this.f34064d)) * 31) + Float.hashCode(this.f34065e);
    }

    public String toString() {
        return "BlurConfig(blurRadius=" + this.f34061a + ", direction=" + this.f34062b + ", alpha=" + this.f34063c + ", curveType=" + this.f34064d + ", endPoint=" + this.f34065e + ')';
    }

    public a(float r1, int r2, float r3, int r4, float r5) {
        this.f34061a = r1;
        this.f34062b = r2;
        this.f34063c = r3;
        this.f34064d = r4;
        this.f34065e = r5;
    }

    public /* synthetic */ a(float r4, int r5, float r6, int r7, float r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = 0.0f;
    L5:
        int r0 = 0;
        if ((r9 & 2) == 0) goto L8;
        int r11 = 0;
    L9:
        float r1 = 1.0f;
        if ((r9 & 4) == 0) goto L12;
        float r2 = 1.0f;
    L14:
        if ((r9 & 8) != 0) goto L18;
        r0 = r7;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r1 = r8;
    L21:
        this(r4, r11, r2, r0, r1);
        return;
    L12:
        r2 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L9
    }

    public final float a() {
        return this.f34061a;
    }

    public final void a(float r1) {
        this.f34061a = r1;
    }

    public final void a(int r1) {
        this.f34062b = r1;
    }

    public final int b() {
        return this.f34062b;
    }

    public final float c() {
        return this.f34063c;
    }

    public final int d() {
        return this.f34064d;
    }

    public final float e() {
        return this.f34065e;
    }

    public final b f() {
        return new b(this.f34061a, this.f34062b, this.f34063c, this.f34064d, this.f34065e);
    }
}

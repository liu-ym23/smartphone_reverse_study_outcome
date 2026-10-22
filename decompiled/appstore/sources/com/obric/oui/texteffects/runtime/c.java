package com.obric.oui.texteffects.runtime;

import java.util.Map;
import kotlin.collections.k0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import od.j;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f17333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f17334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f17335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f17336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f17337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j.b f17338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f17339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final od.d f17340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final od.d f17341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final od.d f17342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f17343n;

    public c(String r10, String r11, String r12, long r13, float r14, float r15, float r16, float r17, j.b r18, float r19, od.d r110, od.d r111, od.d r112, Map r20) {
        q.g(r10, "stageId");
        q.g(r11, "layerId");
        q.g(r20, "properties");
        this.f17330a = r10;
        this.f17331b = r11;
        this.f17332c = r12;
        this.f17333d = r13;
        this.f17334e = r14;
        this.f17335f = r15;
        this.f17336g = r16;
        this.f17337h = r17;
        this.f17338i = r18;
        this.f17339j = r19;
        this.f17340k = r110;
        this.f17341l = r111;
        this.f17342m = r112;
        this.f17343n = r20;
    }

    public final float a(float r10) {
        if (Float.isNaN(this.f17334e) == false) goto L6;
        return r10;
    L6:
        return this.f17334e;
    }

    public final float b() {
        return this.f17334e;
    }

    public final String c() {
        return this.f17332c;
    }

    public final od.d d() {
        return this.f17340k;
    }

    public final String e() {
        return this.f17331b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (q.b(this.f17330a, r11.f17330a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f17331b, r11.f17331b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f17332c, r11.f17332c) == true) goto L18;
        return false;
    L18:
        if (this.f17333d == r11.f17333d) goto L21;
        return false;
    L21:
        if (q.b(Float.valueOf(this.f17334e), Float.valueOf(r11.f17334e)) == true) goto L24;
        return false;
    L24:
        if (q.b(Float.valueOf(this.f17335f), Float.valueOf(r11.f17335f)) == true) goto L27;
        return false;
    L27:
        if (q.b(Float.valueOf(this.f17336g), Float.valueOf(r11.f17336g)) == true) goto L30;
        return false;
    L30:
        if (q.b(Float.valueOf(this.f17337h), Float.valueOf(r11.f17337h)) == true) goto L33;
        return false;
    L33:
        if (q.b(this.f17338i, r11.f17338i) == true) goto L36;
        return false;
    L36:
        if (q.b(Float.valueOf(this.f17339j), Float.valueOf(r11.f17339j)) == true) goto L39;
        return false;
    L39:
        if (q.b(this.f17340k, r11.f17340k) == true) goto L42;
        return false;
    L42:
        if (q.b(this.f17341l, r11.f17341l) == true) goto L45;
        return false;
    L45:
        if (q.b(this.f17342m, r11.f17342m) == true) goto L48;
        return false;
    L48:
        if (q.b(this.f17343n, r11.f17343n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final j.b f() {
        return this.f17338i;
    }

    public final String g() {
        return this.f17330a;
    }

    public final od.d h() {
        return this.f17341l;
    }

    public int hashCode() {
        int r10 = ((this.f17330a.hashCode() * 31) + this.f17331b.hashCode()) * 31;
        String r11 = this.f17332c;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (((((((((((r10 + r13) * 31) + Long.hashCode(this.f17333d)) * 31) + Float.hashCode(this.f17334e)) * 31) + Float.hashCode(this.f17335f)) * 31) + Float.hashCode(this.f17336g)) * 31) + Float.hashCode(this.f17337h)) * 31;
        j.b r15 = this.f17338i;
        if (r15 != null) goto L9;
        int r16 = 0;
    L10:
        int r17 = (((r14 + r16) * 31) + Float.hashCode(this.f17339j)) * 31;
        od.d r18 = this.f17340k;
        if (r18 != null) goto L13;
        int r19 = 0;
    L14:
        int r20 = (r17 + r19) * 31;
        od.d r21 = this.f17341l;
        if (r21 != null) goto L17;
        int r22 = 0;
    L18:
        int r23 = (r20 + r22) * 31;
        od.d r24 = this.f17342m;
        if (r24 == null) goto L23;
        r12 = r24.hashCode();
    L23:
        return ((r23 + r12) * 31) + this.f17343n.hashCode();
    L17:
        r22 = r21.hashCode();
        goto L18
    L13:
        r19 = r18.hashCode();
        goto L14
    L9:
        r16 = r15.hashCode();
        goto L10
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final od.d i() {
        return this.f17342m;
    }

    public final float j(float r10) {
        if (Float.isNaN(this.f17335f) == false) goto L6;
        return r10;
    L6:
        return this.f17335f;
    }

    public final Float k() {
        if (Float.isNaN(this.f17336g) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(this.f17336g);
    }

    public final float l(float r10) {
        if (Float.isNaN(this.f17337h) == false) goto L6;
        return r10;
    L6:
        return this.f17337h;
    }

    public final Float m() {
        if (Float.isNaN(this.f17339j) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(this.f17339j);
    }

    public String toString() {
        return "LayerFrame(stageId=" + this.f17330a + ", layerId=" + this.f17331b + ", bindingKey=" + this.f17332c + ", stagePlayTimeMs=" + this.f17333d + ", alpha=" + this.f17334e + ", gradientAlpha=" + this.f17335f + ", scanProgress=" + this.f17336g + ", tracking=" + this.f17337h + ", scanSelector=" + this.f17338i + ", visibility=" + this.f17339j + ", blurRadius=" + this.f17340k + ", translationX=" + this.f17341l + ", translationY=" + this.f17342m + ", properties=" + this.f17343n + ')';
    }

    public /* synthetic */ c(String r20, String r21, String r22, long r23, float r25, float r26, float r27, float r28, j.b r29, float r30, od.d r31, od.d r32, od.d r33, Map r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 16) == 0) goto L5;
        float r10 = Float.NaN;
    L7:
        if ((r35 & 32) == 0) goto L9;
        float r11 = Float.NaN;
    L11:
        if ((r35 & 64) == 0) goto L13;
        float r12 = Float.NaN;
    L15:
        if ((r35 & 128) == 0) goto L17;
        float r13 = Float.NaN;
    L19:
        if ((r35 & 256) == 0) goto L21;
        j.b r14 = null;
    L23:
        if ((r35 & 512) == 0) goto L25;
        float r15 = Float.NaN;
    L27:
        if ((r35 & 1024) == 0) goto L29;
        od.d r16 = null;
    L31:
        if ((r35 & 2048) == 0) goto L33;
        od.d r17 = null;
    L35:
        if ((r35 & 4096) == 0) goto L37;
        od.d r18 = null;
    L39:
        if ((r35 & 8192) == 0) goto L41;
        Map r19 = k0.h();
    L42:
        this(r20, r21, r22, r23, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L41:
        r19 = r34;
        goto L42
    L37:
        r18 = r33;
        goto L39
    L33:
        r17 = r32;
        goto L35
    L29:
        r16 = r31;
        goto L31
    L25:
        r15 = r30;
        goto L27
    L21:
        r14 = r29;
        goto L23
    L17:
        r13 = r28;
        goto L19
    L13:
        r12 = r27;
        goto L15
    L9:
        r11 = r26;
        goto L11
    L5:
        r10 = r25;
        goto L7
    }
}

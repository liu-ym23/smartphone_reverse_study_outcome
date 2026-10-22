package com.obric.oui.texteffects.runtime;

import com.obric.oui.texteffects.a.g;
import com.obric.oui.texteffects.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: TextEffectFrame.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f36458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f36459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f36460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f36461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f36462e;
    private final float f;
    private final float g;
    private final float h;
    private final m.b i;
    private final float j;
    private final g k;
    private final g l;
    private final g m;
    private final Map<com.obric.oui.texteffects.a.e, g> n;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
        return false;
    L8:
        c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36458a, r10.f36458a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36459b, r10.f36459b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f36460c, r10.f36460c) == true) goto L18;
        return false;
    L18:
        if (this.f36461d == r10.f36461d) goto L21;
        return false;
    L21:
        if (o.a(Float.valueOf(this.f36462e), Float.valueOf(r10.f36462e)) == true) goto L24;
        return false;
    L24:
        if (o.a(Float.valueOf(this.f), Float.valueOf(r10.f)) == true) goto L27;
        return false;
    L27:
        if (o.a(Float.valueOf(this.g), Float.valueOf(r10.g)) == true) goto L30;
        return false;
    L30:
        if (o.a(Float.valueOf(this.h), Float.valueOf(r10.h)) == true) goto L33;
        return false;
    L33:
        if (o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (o.a(Float.valueOf(this.j), Float.valueOf(r10.j)) == true) goto L39;
        return false;
    L39:
        if (o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (o.a(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (o.a(this.n, r10.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f36458a.hashCode() * 31) + this.f36459b.hashCode()) * 31;
        String r1 = this.f36460c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((((r0 + r3) * 31) + Long.hashCode(this.f36461d)) * 31) + Float.hashCode(this.f36462e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + Float.hashCode(this.h)) * 31;
        m.b r5 = this.i;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Float.hashCode(this.j)) * 31;
        g r8 = this.k;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        g r11 = this.l;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        g r14 = this.m;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((r13 + r2) * 31) + this.n.hashCode();
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
        StringBuilder r0 = new StringBuilder();
        r0.append("LayerFrame(stageId=").append(this.f36458a).append(", layerId=").append(this.f36459b).append(", bindingKey=").append(this.f36460c).append(", stagePlayTimeMs=").append(this.f36461d).append(", alpha=").append(this.f36462e).append(", gradientAlpha=").append(this.f).append(", scanProgress=").append(this.g).append(", tracking=").append(this.h).append(", scanSelector=").append(this.i).append(", visibility=").append(this.j).append(", blurRadius=").append(this.k).append(", translationX=");
        r0.append(this.l).append(", translationY=").append(this.m).append(", properties=").append(this.n).append(')');
        return r0.toString();
    }

    public c(String r7, String r8, String r9, long r10, float r12, float r13, float r14, float r15, m.b r16, float r17, g r18, g r19, g r20, Map<com.obric.oui.texteffects.a.e, ? extends g> r21) {
        Map<com.obric.oui.texteffects.a.e, g> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        o.e(r7, "stageId");
        o.e(r8, "layerId");
        o.e(r3, "properties");
        this.f36458a = r7;
        this.f36459b = r8;
        this.f36460c = r9;
        this.f36461d = r10;
        this.f36462e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r3;
    }

    public final String a() {
        return this.f36458a;
    }

    public final String b() {
        return this.f36459b;
    }

    public final String c() {
        return this.f36460c;
    }

    public final float d() {
        return this.f36462e;
    }

    public final m.b e() {
        return this.i;
    }

    public final g f() {
        return this.k;
    }

    public final g g() {
        return this.l;
    }

    public final g h() {
        return this.m;
    }

    public /* synthetic */ c(String r21, String r22, String r23, long r24, float r26, float r27, float r28, float r29, m.b r30, float r31, g r32, g r33, g r34, Map r35, int r36, h r37) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r35, Map.class, "com.obric.aiagent.plugin");
        if ((r36 & 16) == 0) goto L5;
        float r10 = Float.NaN;
    L7:
        if ((r36 & 32) == 0) goto L9;
        float r11 = Float.NaN;
    L11:
        if ((r36 & 64) == 0) goto L13;
        float r12 = Float.NaN;
    L15:
        if ((r36 & 128) == 0) goto L17;
        float r13 = Float.NaN;
    L19:
        if ((r36 & 256) == 0) goto L21;
        m.b r14 = null;
    L23:
        if ((r36 & 512) == 0) goto L25;
        float r15 = Float.NaN;
    L27:
        if ((r36 & 1024) == 0) goto L29;
        g r16 = null;
    L31:
        if ((r36 & 2048) == 0) goto L33;
        g r17 = null;
    L35:
        if ((r36 & 4096) == 0) goto L37;
        g r18 = null;
    L39:
        if ((r36 & 8192) == 0) goto L41;
        r1 = ao.b();
    L41:
        this(r21, r22, r23, r24, r10, r11, r12, r13, r14, r15, r16, r17, r18, r1);
        return;
    L37:
        r18 = r34;
        goto L39
    L33:
        r17 = r33;
        goto L35
    L29:
        r16 = r32;
        goto L31
    L25:
        r15 = r31;
        goto L27
    L21:
        r14 = r30;
        goto L23
    L17:
        r13 = r29;
        goto L19
    L13:
        r12 = r28;
        goto L15
    L9:
        r11 = r27;
        goto L11
    L5:
        r10 = r26;
        goto L7
    }

    public final float a(float r2) {
        if (Float.isNaN(this.f36462e) == false) goto L6;
        return r2;
    L6:
        return this.f36462e;
    }

    public final float b(float r2) {
        if (Float.isNaN(this.f) == false) goto L6;
        return r2;
    L6:
        return this.f;
    }

    public final Float i() {
        if (Float.isNaN(this.g) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(this.g);
    }

    public final float c(float r2) {
        if (Float.isNaN(this.h) == false) goto L6;
        return r2;
    L6:
        return this.h;
    }

    public final Float j() {
        if (Float.isNaN(this.j) == false) goto L6;
        return null;
    L6:
        return Float.valueOf(this.j);
    }
}

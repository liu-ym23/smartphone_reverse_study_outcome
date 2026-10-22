package com.obric.oui.common.style;

import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f34539a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f34540b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f34542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f34543e;
    private float f;
    private float g;
    private Paint h;
    private float i;

    /* JADX INFO: compiled from: Shadow.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final j a(com.obric.oui.shadow.a r11) {
            o.e(r11, "config");
            j r10 = new j(r11.d(), r11.c(), r11.a(), r11.b(), r11.e(), null, 0.0f, 96, null);
            if (r10.b() <= 0.0f) goto L5;
            r10.f().setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r10.b(), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.aiagent.plugin"));
        L6:
            return r10;
        L5:
            r10.f().setMaskFilter(null);
            goto L6
        }

        public final j a(com.obric.oui.shadow.a r2, float r3) {
            o.e(r2, "config");
            return a(r2.f(), r3);
        }

        public final j a(com.obric.oui.shadow.b r11, float r12) {
            o.e(r11, "config");
            j r10 = new j(r11.d(), com.obric.oui.common.util.g.a(r11.c(), r12), com.obric.oui.common.util.g.a(r11.a(), r12), com.obric.oui.common.util.g.a(r11.b(), r12), com.obric.oui.common.util.g.a(r11.e(), r12), null, 0.0f, 96, null);
            if (r10.b() <= 0.0f) goto L5;
            r10.f().setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(r10.b(), BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.aiagent.plugin"));
        L6:
            return r10;
        L5:
            r10.f().setMaskFilter(null);
            goto L6
        }

        public final List<j> a(float r3, float r4, float r5, List<j> r6, List<j> r7) {
            List<j> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
            List<j> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            if (r5 != r4) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return r8;
        L9:
            return a((r3 - r4) / (r5 - r4), r8, r9);
        L5:
            r0 = false;
            goto L6
        }

        public final List<j> a(float r18, List<j> r19, List<j> r20) {
            List<j> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
            List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
            if (Float.isInfinite(r18) == false) goto L5;
        L7:
            boolean r3 = false;
        L9:
            if (r3 == false) goto L11;
            float r4 = r18;
        L12:
            float r5 = n.a(r4, 0.0f, 1.0f);
            if (r0 == null) goto L27;
            if (r2 != null) goto L16;
            return r0;
        L16:
            if (r0.size() != r2.size()) goto L29;
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
            Iterator r6 = r1.iterator();
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            ArrayList r8 = new ArrayList(Math.min(p.a(r1, 10), p.a((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"), 10)));
        L19:
            if (r6.hasNext() == false) goto L24;
            if (r7.hasNext() == false) goto L24;
            Object r9 = r6.next();
            j r10 = (j) ZeusTransformUtils.preCheckCast(r7.next(), j.class, "com.obric.aiagent.plugin");
            j r11 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
            r8.add(new j(com.obric.oui.d.b.a(r5, r11.a(), r10.a()), com.obric.oui.d.b.b(r11.b(), r10.b(), r5), com.obric.oui.d.b.b(r11.c(), r10.c(), r5), com.obric.oui.d.b.b(r11.d(), r10.d(), r5), com.obric.oui.d.b.b(r11.e(), r10.e(), r5), null, 0.0f, 96, null));
        L24:
            return (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        L29:
            return r0;
        L27:
            return r0;
        L11:
            r4 = 0.0f;
            goto L12
        L5:
            if (Float.isNaN(r18) == true) goto L7;
            r3 = true;
            goto L9
        }
    }

    public static final j b(com.obric.oui.shadow.a r1) {
        return f34539a.a(r1);
    }

    public static final j b(com.obric.oui.shadow.b r1, float r2) {
        return f34539a.a(r1, r2);
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.f34541c) * 31) + Float.hashCode(this.f34542d)) * 31) + Float.hashCode(this.f34543e)) * 31) + Float.hashCode(this.f)) * 31) + Float.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + Float.hashCode(this.i);
    }

    public String toString() {
        return "Shadow(color=" + this.f34541c + ", radius=" + this.f34542d + ", offsetX=" + this.f34543e + ", offsetY=" + this.f + ", spread=" + this.g + ", paint=" + this.h + ", cornerRadius=" + this.i + ')';
    }

    public j(int r2, float r3, float r4, float r5, float r6, Paint r7, float r8) {
        o.e(r7, "paint");
        this.f34541c = r2;
        this.f34542d = r3;
        this.f34543e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
    }

    public final int a() {
        return this.f34541c;
    }

    public final void a(int r1) {
        this.f34541c = r1;
    }

    public final void a(float r1) {
        this.f34542d = r1;
    }

    public final float b() {
        return this.f34542d;
    }

    public final void b(float r1) {
        this.f34543e = r1;
    }

    public final float c() {
        return this.f34543e;
    }

    public final void c(float r1) {
        this.f = r1;
    }

    public final float d() {
        return this.f;
    }

    public final void d(float r1) {
        this.g = r1;
    }

    public final float e() {
        return this.g;
    }

    public /* synthetic */ j(int r11, float r12, float r13, float r14, float r15, Paint r16, float r17, int r18, d.h.b.h r19) {
        if ((r18 & 32) == 0) goto L5;
        Paint r8 = new Paint(1);
    L7:
        if ((r18 & 64) == 0) goto L9;
        float r9 = 0.0f;
    L10:
        this(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    public final Paint f() {
        return this.h;
    }

    public final float g() {
        return this.i;
    }

    public final boolean h() {
        if (this.f34543e != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return true;
    L8:
        if (this.f != 0.0f) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return true;
    L13:
        if (this.f34542d != 0.0f) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
        return true;
    L18:
        if (this.g != 0.0f) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        return true;
    L24:
        return false;
    L20:
        r4 = false;
        goto L21
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final void a(com.obric.oui.shadow.a r2) {
        o.e(r2, "config");
        a(r2.f());
    }

    public final void a(com.obric.oui.shadow.b r3) {
        o.e(r3, "config");
        this.f34541c = r3.d();
        this.f34543e = r3.a();
        this.f = r3.b();
        this.g = r3.e();
        if (this.f34542d != r3.c()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        float r4 = r3.c();
        this.f34542d = r4;
        if (r4 <= 0.0f) goto L10;
        this.h.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(this.f34542d, BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        this.h.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void a(com.obric.oui.shadow.b r3, float r4) {
        o.e(r3, "config");
        this.f34541c = r3.d();
        this.f34543e = com.obric.oui.common.util.g.a(r3.a(), r4);
        this.f = com.obric.oui.common.util.g.a(r3.b(), r4);
        this.g = r3.e();
        if (this.f34542d != (r3.c() * r4)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        float r5 = r3.c() * r4;
        this.f34542d = r5;
        if (r5 <= 0.0f) goto L10;
        this.h.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(this.f34542d, BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        this.h.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void update(j r3) {
        if (r3 == null) goto L12;
        this.f34541c = r3.f34541c;
        this.f34543e = r3.f34543e;
        this.f = r3.f;
        this.g = r3.g;
        float r0 = this.f34542d;
        float r4 = r3.f34542d;
        if (r0 != r4) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L14;
        this.f34542d = r4;
        if (r4 <= 0.0f) goto L11;
        this.h.setMaskFilter((MaskFilter) ZeusTransformUtils.preCheckCast(new BlurMaskFilter(this.f34542d, BlurMaskFilter.Blur.NORMAL), MaskFilter.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        this.h.setMaskFilter(null);
        return;
    L14:
        return;
    L6:
        r1 = false;
        goto L7
    L12:
        i();
    }

    public final void i() {
        this.f34541c = 0;
        this.f34542d = 0.0f;
        this.f34543e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.i = 0.0f;
        this.h.setMaskFilter(null);
    }

    static {
        f34539a = new a(null);
        f34540b = new j(0, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 96, null);
    }

    public final j j() {
        int r1 = this.f34541c;
        float r2 = this.f34542d;
        float r3 = this.f34543e;
        float r4 = this.f;
        float r5 = this.g;
        Paint r6 = new Paint(this.h);
        r6.set(f());
        x r0 = x.f38692a;
        return new j(r1, r2, r3, r4, r5, r6, this.i);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.common.style.Shadow");
        j r4 = (j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin");
        if (this.f34541c == ((j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin")).f34541c) goto L16;
        return false;
    L16:
        if (this.f34542d != ((j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin")).f34542d) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == true) goto L22;
        return false;
    L22:
        if (this.f34543e != ((j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin")).f34543e) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == true) goto L28;
        return false;
    L28:
        if (this.f != ((j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin")).f) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == true) goto L34;
        return false;
    L34:
        if (this.g != ((j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin")).g) goto L36;
        boolean r9 = true;
    L37:
        if (r9 == true) goto L40;
        return false;
    L40:
        if (o.a(this.h, ((j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin")).h) == true) goto L43;
        return false;
    L43:
        if (this.i != ((j) ZeusTransformUtils.preCheckCast(r7, j.class, "com.obric.aiagent.plugin")).i) goto L45;
        boolean r10 = true;
    L46:
        if (r10 == true) goto L48;
        return false;
    L48:
        return true;
    L45:
        r10 = false;
        goto L46
    L36:
        r9 = false;
        goto L37
    L30:
        r8 = false;
        goto L31
    L24:
        r6 = false;
        goto L25
    L18:
        r5 = false;
        goto L19
    L8:
        r3 = r7.getClass();
        goto L10
    }
}

package com.obric.oui.common.style;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class Shadow {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f13060h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Shadow f13061i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f13066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f13067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f13068g;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Shadow a(com.obric.oui.shadow.a r11) {
            q.g(r11, "config");
            Paint r10 = null;
            float r12 = 0.0f;
            Shadow r13 = new Shadow(r11.c(), r11.b(), r11.e(), r11.f(), r11.d(), r10, r12, 96, null);
            if (r13.i() <= 0.0f) goto L5;
            r13.h().setMaskFilter(new BlurMaskFilter(r13.i(), BlurMaskFilter.Blur.NORMAL));
        L6:
            return r13;
        L5:
            r13.h().setMaskFilter(null);
            goto L6
        }

        public final Shadow b(com.obric.oui.shadow.a r10, float r11) {
            q.g(r10, "config");
            return c(r10.h(), r11);
        }

        public final Shadow c(com.obric.oui.shadow.b r11, float r12) {
            q.g(r11, "config");
            Paint r10 = null;
            float r13 = 0.0f;
            Shadow r14 = new Shadow(r11.f(), tc.f.j(r11.e(), r12), tc.f.j(r11.i(), r12), tc.f.j(r11.j(), r12), tc.f.j(r11.h(), r12), r10, r13, 96, null);
            if (r14.i() <= 0.0f) goto L5;
            r14.h().setMaskFilter(new BlurMaskFilter(r14.i(), BlurMaskFilter.Blur.NORMAL));
        L6:
            return r14;
        L5:
            r14.h().setMaskFilter(null);
            goto L6
        }

        public final List d(float r10, float r11, float r12, List r13, List r14) {
            if (r12 != r11) goto L6;
            return r13;
        L6:
            return e((r10 - r11) / (r12 - r11), r13, r14);
        }

        public final List e(float r17, List r18, List r19) {
            if (Float.isInfinite(r17) == false) goto L5;
        L7:
            float r10 = 0.0f;
        L8:
            float r11 = bg.h.j(r10, 0.0f, 1.0f);
            if (r18 == null) goto L23;
            if (r19 != null) goto L12;
            return r18;
        L12:
            if (r18.size() != r19.size()) goto L25;
            Iterator r12 = r18.iterator();
            Iterator r13 = r19.iterator();
            ArrayList r14 = new ArrayList(Math.min(u.r(r18, 10), u.r(r19, 10)));
        L15:
            if (r12.hasNext() == false) goto L20;
            if (r13.hasNext() == false) goto L20;
            Object r15 = r12.next();
            Shadow r16 = (Shadow) r13.next();
            Shadow r20 = (Shadow) r15;
            r14.add(new Shadow(td.b.a(r11, r20.d(), r16.d()), td.b.c(r20.i(), r16.i(), r11), td.b.c(r20.f(), r16.f(), r11), td.b.c(r20.g(), r16.g(), r11), td.b.c(r20.j(), r16.j(), r11), null, 0.0f, 96, null));
        L20:
            return r14;
        L25:
            return r18;
        L23:
            return r18;
        L5:
            if (Float.isNaN(r17) == true) goto L7;
            r10 = r17;
            goto L8
        }

        public a() {
        }
    }

    static {
        f13060h = new a(null);
        int r10 = 0;
        float r11 = 0.0f;
        float r12 = 0.0f;
        float r13 = 0.0f;
        float r14 = 0.0f;
        Paint r15 = null;
        float r16 = 0.0f;
        f13061i = new Shadow(r10, r11, r12, r13, r14, r15, r16, 96, null);
    }

    public Shadow(int r10, float r11, float r12, float r13, float r14, Paint r15, float r16) {
        q.g(r15, "paint");
        this.f13062a = r10;
        this.f13063b = r11;
        this.f13064c = r12;
        this.f13065d = r13;
        this.f13066e = r14;
        this.f13067f = r15;
        this.f13068g = r16;
    }

    public static final Shadow b(com.obric.oui.shadow.a r10) {
        return f13060h.a(r10);
    }

    public static final Shadow c(com.obric.oui.shadow.b r10, float r11) {
        return f13060h.c(r10, r11);
    }

    public final Shadow a() {
        int r10 = this.f13062a;
        float r11 = this.f13063b;
        float r12 = this.f13064c;
        float r13 = this.f13065d;
        float r14 = this.f13066e;
        Paint r15 = new Paint(this.f13067f);
        r15.set(h());
        Unit r16 = Unit.f21064a;
        return new Shadow(r10, r11, r12, r13, r14, r15, this.f13068g);
    }

    public final int d() {
        return this.f13062a;
    }

    public final float e() {
        return this.f13068g;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L5;
        return true;
    L5:
        if (r10 != null) goto L7;
        Class<?> r11 = null;
    L9:
        if (q.b(Shadow.class, r11) == true) goto L11;
        return false;
    L11:
        if (r10 == null) goto L31;
        Shadow r12 = (Shadow) r10;
        if (this.f13062a == r12.f13062a) goto L16;
        return false;
    L16:
        if (this.f13063b == r12.f13063b) goto L18;
    L29:
        return false;
    L18:
        if (this.f13064c != r12.f13064c) goto L29;
        if (this.f13065d != r12.f13065d) goto L29;
        if (this.f13066e != r12.f13066e) goto L29;
        if (q.b(this.f13067f, r12.f13067f) == true) goto L27;
        return false;
    L27:
        if (this.f13068g != r12.f13068g) goto L29;
        return true;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.Shadow");
    L7:
        r11 = r10.getClass();
        goto L9
    }

    public final float f() {
        return this.f13064c;
    }

    public final float g() {
        return this.f13065d;
    }

    public final Paint h() {
        return this.f13067f;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.f13062a) * 31) + Float.hashCode(this.f13063b)) * 31) + Float.hashCode(this.f13064c)) * 31) + Float.hashCode(this.f13065d)) * 31) + Float.hashCode(this.f13066e)) * 31) + this.f13067f.hashCode()) * 31) + Float.hashCode(this.f13068g);
    }

    public final float i() {
        return this.f13063b;
    }

    public final float j() {
        return this.f13066e;
    }

    public final void k() {
        this.f13062a = 0;
        this.f13063b = 0.0f;
        this.f13064c = 0.0f;
        this.f13065d = 0.0f;
        this.f13066e = 0.0f;
        this.f13068g = 0.0f;
        this.f13067f.setMaskFilter(null);
    }

    public final void l(int r10) {
        this.f13062a = r10;
    }

    public final void m(float r10) {
        this.f13064c = r10;
    }

    public final void n(float r10) {
        this.f13065d = r10;
    }

    public final void o(float r10) {
        this.f13063b = r10;
    }

    public final void p(float r10) {
        this.f13066e = r10;
    }

    public final void q(Shadow r10) {
        if (r10 == null) goto L10;
        this.f13062a = r10.f13062a;
        this.f13064c = r10.f13064c;
        this.f13065d = r10.f13065d;
        this.f13066e = r10.f13066e;
        float r11 = this.f13063b;
        float r12 = r10.f13063b;
        if (r11 == r12) goto L14;
        this.f13063b = r12;
        if (r12 <= 0.0f) goto L9;
        this.f13067f.setMaskFilter(new BlurMaskFilter(this.f13063b, BlurMaskFilter.Blur.NORMAL));
        return;
    L9:
        this.f13067f.setMaskFilter(null);
        return;
    L14:
        return;
    L10:
        k();
    }

    public final void r(com.obric.oui.shadow.a r10) {
        q.g(r10, "config");
        s(r10.h());
    }

    public final void s(com.obric.oui.shadow.b r10) {
        q.g(r10, "config");
        this.f13062a = r10.f();
        this.f13064c = r10.i();
        this.f13065d = r10.j();
        this.f13066e = r10.h();
        if (this.f13063b == r10.e()) goto L11;
        float r11 = r10.e();
        this.f13063b = r11;
        if (r11 <= 0.0f) goto L8;
        this.f13067f.setMaskFilter(new BlurMaskFilter(this.f13063b, BlurMaskFilter.Blur.NORMAL));
        return;
    L8:
        this.f13067f.setMaskFilter(null);
        return;
    }

    public final void t(com.obric.oui.shadow.b r10, float r11) {
        q.g(r10, "config");
        this.f13062a = r10.f();
        this.f13064c = tc.f.j(r10.i(), r11);
        this.f13065d = tc.f.j(r10.j(), r11);
        this.f13066e = r10.h();
        if (this.f13063b == (r10.e() * r11)) goto L11;
        float r12 = r10.e() * r11;
        this.f13063b = r12;
        if (r12 <= 0.0f) goto L8;
        this.f13067f.setMaskFilter(new BlurMaskFilter(this.f13063b, BlurMaskFilter.Blur.NORMAL));
        return;
    L8:
        this.f13067f.setMaskFilter(null);
        return;
    }

    public String toString() {
        return "Shadow(color=" + this.f13062a + ", radius=" + this.f13063b + ", offsetX=" + this.f13064c + ", offsetY=" + this.f13065d + ", spread=" + this.f13066e + ", paint=" + this.f13067f + ", cornerRadius=" + this.f13068g + ')';
    }

    public final boolean u() {
        if (this.f13064c == 0.0f) goto L5;
    L11:
        return true;
    L5:
        if (this.f13065d != 0.0f) goto L11;
        if (this.f13063b != 0.0f) goto L11;
        if (this.f13066e != 0.0f) goto L11;
        return false;
    }

    public /* synthetic */ Shadow(int r11, float r12, float r13, float r14, float r15, Paint r16, float r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        Paint r10 = new Paint(1);
    L7:
        if ((r18 & 64) == 0) goto L9;
        float r20 = 0.0f;
    L10:
        this(r11, r12, r13, r14, r15, r10, r20);
        return;
    L9:
        r20 = r17;
        goto L10
    L5:
        r10 = r16;
        goto L7
    }
}

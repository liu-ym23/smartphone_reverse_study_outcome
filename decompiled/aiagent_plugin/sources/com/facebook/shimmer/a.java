package com.facebook.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Shimmer.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float[] f11958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int[] f11959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final RectF f11960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f11961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f11962e;
    int f;
    int g;
    int h;
    int i;
    float j;
    float k;
    float l;
    float m;
    float n;
    boolean o;
    boolean p;
    boolean q;
    int r;
    int s;
    long t;
    long u;

    /* JADX INFO: renamed from: com.facebook.shimmer.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Shimmer.java */
    public static class C0264a extends b<C0264a> {
        public C0264a a() {
            return this;
        }

        @Override // com.facebook.shimmer.a.b
        public /* synthetic */ b b() {
            return a();
        }

        public C0264a() {
            this.f11963a.q = true;
        }
    }

    /* JADX INFO: compiled from: Shimmer.java */
    public static abstract class b<T extends b<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f11963a;

        public abstract T b();

        public b() {
            this.f11963a = new a();
        }

        T a(TypedArray r6) {
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_clip_to_children, "styleable", "ShimmerFrameLayout_shimmer_clip_to_children")) == false) goto L6;
            a(r6.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_clip_to_children, "styleable", "ShimmerFrameLayout_shimmer_clip_to_children"), this.f11963a.o));
        L6:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_auto_start, "styleable", "ShimmerFrameLayout_shimmer_auto_start")) == false) goto L9;
            b(r6.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_auto_start, "styleable", "ShimmerFrameLayout_shimmer_auto_start"), this.f11963a.p));
        L9:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_base_alpha, "styleable", "ShimmerFrameLayout_shimmer_base_alpha")) == false) goto L12;
            f(r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_base_alpha, "styleable", "ShimmerFrameLayout_shimmer_base_alpha"), 0.3f));
        L12:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha, "styleable", "ShimmerFrameLayout_shimmer_highlight_alpha")) == false) goto L15;
            g(r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha, "styleable", "ShimmerFrameLayout_shimmer_highlight_alpha"), 1.0f));
        L15:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_duration, "styleable", "ShimmerFrameLayout_shimmer_duration")) == false) goto L18;
            b(r6.getInt(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_duration, "styleable", "ShimmerFrameLayout_shimmer_duration"), (int) this.f11963a.t));
        L18:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_repeat_count, "styleable", "ShimmerFrameLayout_shimmer_repeat_count")) == false) goto L21;
            e(r6.getInt(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_repeat_count, "styleable", "ShimmerFrameLayout_shimmer_repeat_count"), this.f11963a.r));
        L21:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_repeat_delay, "styleable", "ShimmerFrameLayout_shimmer_repeat_delay")) == false) goto L24;
            a(r6.getInt(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_repeat_delay, "styleable", "ShimmerFrameLayout_shimmer_repeat_delay"), (int) this.f11963a.u));
        L24:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_repeat_mode, "styleable", "ShimmerFrameLayout_shimmer_repeat_mode")) == false) goto L27;
            f(r6.getInt(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_repeat_mode, "styleable", "ShimmerFrameLayout_shimmer_repeat_mode"), this.f11963a.s));
        L27:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_direction, "styleable", "ShimmerFrameLayout_shimmer_direction")) == false) goto L39;
            int r0 = r6.getInt(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_direction, "styleable", "ShimmerFrameLayout_shimmer_direction"), this.f11963a.f11961d);
            if (r0 != 1) goto L31;
            a(1);
            goto L39
        L31:
            if (r0 != 2) goto L33;
            a(2);
            goto L39
        L33:
            if (r0 == 3) goto L35;
            a(0);
            goto L39
        L35:
            a(3);
        L39:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_shape, "styleable", "ShimmerFrameLayout_shimmer_shape")) == false) goto L45;
            if (r6.getInt(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_shape, "styleable", "ShimmerFrameLayout_shimmer_shape"), this.f11963a.g) == 1) goto L43;
            b(0);
            goto L45
        L43:
            b(1);
        L45:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_dropoff, "styleable", "ShimmerFrameLayout_shimmer_dropoff")) == false) goto L48;
            d(r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_dropoff, "styleable", "ShimmerFrameLayout_shimmer_dropoff"), this.f11963a.m));
        L48:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_fixed_width, "styleable", "ShimmerFrameLayout_shimmer_fixed_width")) == false) goto L51;
            c(r6.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_fixed_width, "styleable", "ShimmerFrameLayout_shimmer_fixed_width"), this.f11963a.h));
        L51:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_fixed_height, "styleable", "ShimmerFrameLayout_shimmer_fixed_height")) == false) goto L54;
            d(r6.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_fixed_height, "styleable", "ShimmerFrameLayout_shimmer_fixed_height"), this.f11963a.i));
        L54:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_intensity, "styleable", "ShimmerFrameLayout_shimmer_intensity")) == false) goto L57;
            c(r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_intensity, "styleable", "ShimmerFrameLayout_shimmer_intensity"), this.f11963a.l));
        L57:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_width_ratio, "styleable", "ShimmerFrameLayout_shimmer_width_ratio")) == false) goto L60;
            a(r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_width_ratio, "styleable", "ShimmerFrameLayout_shimmer_width_ratio"), this.f11963a.j));
        L60:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_height_ratio, "styleable", "ShimmerFrameLayout_shimmer_height_ratio")) == false) goto L63;
            b(r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_height_ratio, "styleable", "ShimmerFrameLayout_shimmer_height_ratio"), this.f11963a.k));
        L63:
            if (r6.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_tilt, "styleable", "ShimmerFrameLayout_shimmer_tilt")) == false) goto L66;
            e(r6.getFloat(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_tilt, "styleable", "ShimmerFrameLayout_shimmer_tilt"), this.f11963a.n));
        L66:
            return (T) b();
        }

        public T a(int r2) {
            this.f11963a.f11961d = r2;
            return (T) b();
        }

        public T b(int r2) {
            this.f11963a.g = r2;
            return (T) b();
        }

        public T c(int r3) {
            if (r3 < 0) goto L6;
            this.f11963a.h = r3;
            return (T) b();
        L6:
            throw new IllegalArgumentException("Given invalid width: " + r3);
        }

        public T d(int r3) {
            if (r3 < 0) goto L6;
            this.f11963a.i = r3;
            return (T) b();
        L6:
            throw new IllegalArgumentException("Given invalid height: " + r3);
        }

        public T a(float r3) {
            if (r3 < 0.0f) goto L7;
            this.f11963a.j = r3;
            return (T) b();
        L7:
            throw new IllegalArgumentException("Given invalid width ratio: " + r3);
        }

        public T b(float r3) {
            if (r3 < 0.0f) goto L7;
            this.f11963a.k = r3;
            return (T) b();
        L7:
            throw new IllegalArgumentException("Given invalid height ratio: " + r3);
        }

        public T c(float r3) {
            if (r3 < 0.0f) goto L7;
            this.f11963a.l = r3;
            return (T) b();
        L7:
            throw new IllegalArgumentException("Given invalid intensity value: " + r3);
        }

        public T d(float r3) {
            if (r3 < 0.0f) goto L7;
            this.f11963a.m = r3;
            return (T) b();
        L7:
            throw new IllegalArgumentException("Given invalid dropoff value: " + r3);
        }

        public T e(float r2) {
            this.f11963a.n = r2;
            return (T) b();
        }

        public T f(float r4) {
            int r5 = (int) (a(0.0f, 1.0f, r4) * 255.0f);
            a r0 = this.f11963a;
            r0.f = (r5 << 24) | (r0.f & 16777215);
            return (T) b();
        }

        public T g(float r4) {
            int r5 = (int) (a(0.0f, 1.0f, r4) * 255.0f);
            a r0 = this.f11963a;
            r0.f11962e = (r5 << 24) | (r0.f11962e & 16777215);
            return (T) b();
        }

        public T a(boolean r2) {
            this.f11963a.o = r2;
            return (T) b();
        }

        public T b(boolean r2) {
            this.f11963a.p = r2;
            return (T) b();
        }

        public T e(int r2) {
            this.f11963a.r = r2;
            return (T) b();
        }

        public T f(int r2) {
            this.f11963a.s = r2;
            return (T) b();
        }

        public T a(long r3) {
            if (r3 < 0) goto L7;
            this.f11963a.u = r3;
            return (T) b();
        L7:
            throw new IllegalArgumentException("Given a negative repeat delay: " + r3);
        }

        public T b(long r3) {
            if (r3 < 0) goto L7;
            this.f11963a.t = r3;
            return (T) b();
        L7:
            throw new IllegalArgumentException("Given a negative duration: " + r3);
        }

        public a c() {
            this.f11963a.a();
            this.f11963a.b();
            return this.f11963a;
        }

        private static float a(float r0, float r1, float r2) {
            return Math.min(r1, Math.max(r0, r2));
        }
    }

    /* JADX INFO: compiled from: Shimmer.java */
    public static class c extends b<c> {
        public c a() {
            return this;
        }

        @Override // com.facebook.shimmer.a.b
        /* synthetic */ b a(TypedArray r1) {
            return b(r1);
        }

        @Override // com.facebook.shimmer.a.b
        public /* synthetic */ b b() {
            return a();
        }

        public c() {
            this.f11963a.q = false;
        }

        public c g(int r2) {
            this.f11963a.f11962e = r2;
            return a();
        }

        public c h(int r4) {
            a r0 = this.f11963a;
            int r5 = r4 & 16777215;
            r0.f = r5 | (this.f11963a.f & (-16777216));
            return a();
        }

        c b(TypedArray r4) {
            super.a(r4);
            if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_base_color, "styleable", "ShimmerFrameLayout_shimmer_base_color")) == false) goto L6;
            h(r4.getColor(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_base_color, "styleable", "ShimmerFrameLayout_shimmer_base_color"), this.f11963a.f));
        L6:
            if (r4.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_highlight_color, "styleable", "ShimmerFrameLayout_shimmer_highlight_color")) == false) goto L9;
            g(r4.getColor(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_highlight_color, "styleable", "ShimmerFrameLayout_shimmer_highlight_color"), this.f11963a.f11962e));
        L9:
            return a();
        }
    }

    a() {
        this.f11958a = new float[4];
        this.f11959b = new int[4];
        this.f11960c = new RectF();
        this.f11961d = 0;
        this.f11962e = -1;
        this.f = 1291845631;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 1.0f;
        this.k = 1.0f;
        this.l = 0.0f;
        this.m = 0.5f;
        this.n = 20.0f;
        this.o = true;
        this.p = true;
        this.q = true;
        this.r = -1;
        this.s = 1;
        this.t = 1000;
    }

    int a(int r2) {
        int r0 = this.h;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return Math.round(this.j * r2);
    }

    int b(int r2) {
        int r0 = this.i;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        return Math.round(this.k * r2);
    }

    void a() {
        if (this.g == 1) goto L5;
        int[] r0 = this.f11959b;
        int r5 = this.f;
        r0[0] = r5;
        int r6 = this.f11962e;
        r0[1] = r6;
        r0[2] = r6;
        r0[3] = r5;
        return;
    L5:
        int[] r1 = this.f11959b;
        int r7 = this.f11962e;
        r1[0] = r7;
        r1[1] = r7;
        int r8 = this.f;
        r1[2] = r8;
        r1[3] = r8;
    }

    void b() {
        if (this.g == 1) goto L5;
        this.f11958a[0] = Math.max(((1.0f - this.l) - this.m) / 2.0f, 0.0f);
        this.f11958a[1] = Math.max(((1.0f - this.l) - 0.001f) / 2.0f, 0.0f);
        this.f11958a[2] = Math.min(((this.l + 1.0f) + 0.001f) / 2.0f, 1.0f);
        this.f11958a[3] = Math.min(((this.l + 1.0f) + this.m) / 2.0f, 1.0f);
        return;
    L5:
        float[] r0 = this.f11958a;
        r0[0] = 0.0f;
        r0[1] = Math.min(this.l, 1.0f);
        this.f11958a[2] = Math.min(this.l + this.m, 1.0f);
        this.f11958a[3] = 1.0f;
    }
}

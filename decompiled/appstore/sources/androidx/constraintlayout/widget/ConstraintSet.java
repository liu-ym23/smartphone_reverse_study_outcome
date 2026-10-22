package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f2263h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static SparseIntArray f2264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static SparseIntArray f2265j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap f2270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap f2272g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2273a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2274b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f2275c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f2276d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f2277e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f2278f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap f2279g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C0011a f2280h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintSet$a$a, reason: collision with other inner class name */
        public static class C0011a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f2281a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f2282b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f2283c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f2284d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f2285e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f2286f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f2287g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f2288h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f2289i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f2290j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f2291k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f2292l;

            public C0011a() {
                this.f2281a = new int[10];
                this.f2282b = new int[10];
                this.f2283c = 0;
                this.f2284d = new int[10];
                this.f2285e = new float[10];
                this.f2286f = 0;
                this.f2287g = new int[5];
                this.f2288h = new String[5];
                this.f2289i = 0;
                this.f2290j = new int[4];
                this.f2291k = new boolean[4];
                this.f2292l = 0;
            }

            public void a(int r10, float r11) {
                int r12 = this.f2286f;
                int[] r13 = this.f2284d;
                if (r12 < r13.length) goto L5;
                this.f2284d = Arrays.copyOf(r13, r13.length * 2);
                float[] r14 = this.f2285e;
                this.f2285e = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f2284d;
                int r16 = this.f2286f;
                r15[r16] = r10;
                float[] r17 = this.f2285e;
                this.f2286f = r16 + 1;
                r17[r16] = r11;
            }

            public void b(int r10, int r11) {
                int r12 = this.f2283c;
                int[] r13 = this.f2281a;
                if (r12 < r13.length) goto L5;
                this.f2281a = Arrays.copyOf(r13, r13.length * 2);
                int[] r14 = this.f2282b;
                this.f2282b = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f2281a;
                int r16 = this.f2283c;
                r15[r16] = r10;
                int[] r17 = this.f2282b;
                this.f2283c = r16 + 1;
                r17[r16] = r11;
            }

            public void c(int r10, String r11) {
                int r12 = this.f2289i;
                int[] r13 = this.f2287g;
                if (r12 < r13.length) goto L5;
                this.f2287g = Arrays.copyOf(r13, r13.length * 2);
                String[] r14 = this.f2288h;
                this.f2288h = (String[]) Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f2287g;
                int r16 = this.f2289i;
                r15[r16] = r10;
                String[] r17 = this.f2288h;
                this.f2289i = r16 + 1;
                r17[r16] = r11;
            }

            public void d(int r10, boolean r11) {
                int r12 = this.f2292l;
                int[] r13 = this.f2290j;
                if (r12 < r13.length) goto L5;
                this.f2290j = Arrays.copyOf(r13, r13.length * 2);
                boolean[] r14 = this.f2291k;
                this.f2291k = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f2290j;
                int r16 = this.f2292l;
                r15[r16] = r10;
                boolean[] r17 = this.f2291k;
                this.f2292l = r16 + 1;
                r17[r16] = r11;
            }

            public void e(a r10) {
                int r11 = 0;
                int r12 = 0;
            L4:
                if (r12 >= this.f2283c) goto L6;
                ConstraintSet.c(r10, this.f2281a[r12], this.f2282b[r12]);
                r12 = r12 + 1;
                goto L4
            L6:
                int r13 = 0;
            L8:
                if (r13 >= this.f2286f) goto L10;
                ConstraintSet.d(r10, this.f2284d[r13], this.f2285e[r13]);
                r13 = r13 + 1;
                goto L8
            L10:
                int r14 = 0;
            L12:
                if (r14 >= this.f2289i) goto L15;
                ConstraintSet.e(r10, this.f2287g[r14], this.f2288h[r14]);
                r14 = r14 + 1;
            L15:
                if (r11 >= this.f2292l) goto L17;
                ConstraintSet.f(r10, this.f2290j[r11], this.f2291k[r11]);
                r11 = r11 + 1;
                goto L15
            }
        }

        public a() {
            this.f2275c = new d();
            this.f2276d = new c();
            this.f2277e = new b();
            this.f2278f = new e();
            this.f2279g = new HashMap();
        }

        public static /* synthetic */ void a(a r10, int r11, ConstraintLayout.LayoutParams r12) {
            r10.g(r11, r12);
        }

        public static /* synthetic */ void b(a r10, ConstraintHelper r11, int r12, Constraints.LayoutParams r13) {
            r10.i(r11, r12, r13);
        }

        public static /* synthetic */ void c(a r10, int r11, Constraints.LayoutParams r12) {
            r10.h(r11, r12);
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return f();
        }

        public void d(a r10) {
            C0011a r11 = this.f2280h;
            if (r11 == null) goto L6;
            r11.e(r10);
            return;
        }

        public void e(ConstraintLayout.LayoutParams r10) {
            b r11 = this.f2277e;
            r10.f2195e = r11.f2313j;
            r10.f2197f = r11.f2315k;
            r10.f2199g = r11.f2317l;
            r10.f2201h = r11.f2319m;
            r10.f2203i = r11.f2321n;
            r10.f2205j = r11.f2323o;
            r10.f2207k = r11.f2325p;
            r10.f2209l = r11.f2327q;
            r10.f2211m = r11.f2329r;
            r10.f2213n = r11.f2330s;
            r10.f2215o = r11.f2331t;
            r10.f2223s = r11.f2332u;
            r10.f2225t = r11.f2333v;
            r10.f2227u = r11.f2334w;
            r10.f2229v = r11.f2335x;
            ((ViewGroup.MarginLayoutParams) r10).leftMargin = r11.H;
            ((ViewGroup.MarginLayoutParams) r10).rightMargin = r11.I;
            ((ViewGroup.MarginLayoutParams) r10).topMargin = r11.f2294J;
            ((ViewGroup.MarginLayoutParams) r10).bottomMargin = r11.K;
            r10.A = r11.T;
            r10.B = r11.S;
            r10.f2233x = r11.P;
            r10.f2235z = r11.R;
            r10.G = r11.f2336y;
            r10.H = r11.f2337z;
            r10.f2217p = r11.B;
            r10.f2219q = r11.C;
            r10.f2221r = r11.D;
            r10.I = r11.A;
            r10.X = r11.E;
            r10.Y = r11.F;
            r10.M = r11.V;
            r10.L = r11.W;
            r10.O = r11.Y;
            r10.N = r11.X;
            r10.f2188a0 = r11.f2322n0;
            r10.f2190b0 = r11.f2324o0;
            r10.P = r11.Z;
            r10.Q = r11.f2296a0;
            r10.T = r11.f2298b0;
            r10.U = r11.f2300c0;
            r10.R = r11.f2302d0;
            r10.S = r11.f2304e0;
            r10.V = r11.f2306f0;
            r10.W = r11.f2308g0;
            r10.Z = r11.G;
            r10.f2191c = r11.f2309h;
            r10.f2187a = r11.f2305f;
            r10.f2189b = r11.f2307g;
            ((ViewGroup.MarginLayoutParams) r10).width = r11.f2301d;
            ((ViewGroup.MarginLayoutParams) r10).height = r11.f2303e;
            String r12 = r11.f2320m0;
            if (r12 == null) goto L5;
            r10.f2192c0 = r12;
        L5:
            r10.f2194d0 = r11.f2328q0;
            r10.setMarginStart(r11.M);
            r10.setMarginEnd(this.f2277e.L);
            r10.c();
        }

        public a f() {
            a r10 = new a();
            r10.f2277e.a(this.f2277e);
            r10.f2276d.a(this.f2276d);
            r10.f2275c.a(this.f2275c);
            r10.f2278f.a(this.f2278f);
            r10.f2273a = this.f2273a;
            r10.f2280h = this.f2280h;
            return r10;
        }

        public final void g(int r10, ConstraintLayout.LayoutParams r11) {
            this.f2273a = r10;
            b r12 = this.f2277e;
            r12.f2313j = r11.f2195e;
            r12.f2315k = r11.f2197f;
            r12.f2317l = r11.f2199g;
            r12.f2319m = r11.f2201h;
            r12.f2321n = r11.f2203i;
            r12.f2323o = r11.f2205j;
            r12.f2325p = r11.f2207k;
            r12.f2327q = r11.f2209l;
            r12.f2329r = r11.f2211m;
            r12.f2330s = r11.f2213n;
            r12.f2331t = r11.f2215o;
            r12.f2332u = r11.f2223s;
            r12.f2333v = r11.f2225t;
            r12.f2334w = r11.f2227u;
            r12.f2335x = r11.f2229v;
            r12.f2336y = r11.G;
            r12.f2337z = r11.H;
            r12.A = r11.I;
            r12.B = r11.f2217p;
            r12.C = r11.f2219q;
            r12.D = r11.f2221r;
            r12.E = r11.X;
            r12.F = r11.Y;
            r12.G = r11.Z;
            r12.f2309h = r11.f2191c;
            r12.f2305f = r11.f2187a;
            r12.f2307g = r11.f2189b;
            r12.f2301d = ((ViewGroup.MarginLayoutParams) r11).width;
            r12.f2303e = ((ViewGroup.MarginLayoutParams) r11).height;
            r12.H = ((ViewGroup.MarginLayoutParams) r11).leftMargin;
            r12.I = ((ViewGroup.MarginLayoutParams) r11).rightMargin;
            r12.f2294J = ((ViewGroup.MarginLayoutParams) r11).topMargin;
            r12.K = ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
            r12.N = r11.D;
            r12.V = r11.M;
            r12.W = r11.L;
            r12.Y = r11.O;
            r12.X = r11.N;
            r12.f2322n0 = r11.f2188a0;
            r12.f2324o0 = r11.f2190b0;
            r12.Z = r11.P;
            r12.f2296a0 = r11.Q;
            r12.f2298b0 = r11.T;
            r12.f2300c0 = r11.U;
            r12.f2302d0 = r11.R;
            r12.f2304e0 = r11.S;
            r12.f2306f0 = r11.V;
            r12.f2308g0 = r11.W;
            r12.f2320m0 = r11.f2192c0;
            r12.P = r11.f2233x;
            r12.R = r11.f2235z;
            r12.O = r11.f2231w;
            r12.Q = r11.f2234y;
            r12.T = r11.A;
            r12.S = r11.B;
            r12.U = r11.C;
            r12.f2328q0 = r11.f2194d0;
            r12.L = r11.getMarginEnd();
            b r13 = this.f2277e;
            r13.M = r11.getMarginStart();
        }

        public final void h(int r10, Constraints.LayoutParams r11) {
            g(r10, r11);
            d r12 = this.f2275c;
            r12.f2356d = r11.f2374x0;
            e r13 = this.f2278f;
            r13.f2360b = r11.A0;
            r13.f2361c = r11.B0;
            r13.f2362d = r11.C0;
            r13.f2363e = r11.D0;
            r13.f2364f = r11.E0;
            r13.f2365g = r11.F0;
            r13.f2366h = r11.G0;
            r13.f2368j = r11.H0;
            r13.f2369k = r11.I0;
            r13.f2370l = r11.J0;
            r13.f2372n = r11.f2376z0;
            r13.f2371m = r11.f2375y0;
        }

        public final void i(ConstraintHelper r10, int r11, Constraints.LayoutParams r12) {
            h(r11, r12);
            if ((r10 instanceof Barrier) == false) goto L6;
            b r13 = this.f2277e;
            r13.f2314j0 = 1;
            Barrier r14 = (Barrier) r10;
            r13.f2310h0 = r14.getType();
            b r15 = this.f2277e;
            r15.f2316k0 = r14.getReferencedIds();
            b r16 = this.f2277e;
            r16.f2312i0 = r14.getMargin();
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static SparseIntArray f2293r0;
        public String A;
        public int B;
        public int C;
        public float D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f2294J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2295a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f2296a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2297b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f2298b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2299c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f2300c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2301d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f2302d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2303e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f2304e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2305f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f2306f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2307g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f2308g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f2309h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f2310h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f2311i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f2312i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2313j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f2314j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f2315k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f2316k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f2317l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f2318l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2319m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f2320m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2321n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f2322n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f2323o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f2324o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f2325p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f2326p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f2327q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f2328q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f2329r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f2330s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f2331t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f2332u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f2333v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f2334w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f2335x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f2336y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f2337z;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f2293r0 = r10;
            r10.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f2293r0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f2293r0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f2293r0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            f2293r0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            f2293r0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f2293r0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f2293r0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f2293r0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f2293r0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            f2293r0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            f2293r0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            f2293r0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            f2293r0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            f2293r0.append(R$styleable.Layout_guidelineUseRtl, 90);
            f2293r0.append(R$styleable.Layout_android_orientation, 26);
            f2293r0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            f2293r0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            f2293r0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f2293r0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f2293r0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            f2293r0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            f2293r0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            f2293r0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            f2293r0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            f2293r0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            f2293r0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            f2293r0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            f2293r0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f2293r0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f2293r0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            f2293r0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            f2293r0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            f2293r0.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            f2293r0.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            f2293r0.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            f2293r0.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            f2293r0.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            f2293r0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            f2293r0.append(R$styleable.Layout_android_layout_marginRight, 27);
            f2293r0.append(R$styleable.Layout_android_layout_marginStart, 30);
            f2293r0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            f2293r0.append(R$styleable.Layout_android_layout_marginTop, 33);
            f2293r0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            f2293r0.append(R$styleable.Layout_android_layout_width, 22);
            f2293r0.append(R$styleable.Layout_android_layout_height, 21);
            f2293r0.append(R$styleable.Layout_layout_constraintWidth, 41);
            f2293r0.append(R$styleable.Layout_layout_constraintHeight, 42);
            f2293r0.append(R$styleable.Layout_layout_constrainedWidth, 41);
            f2293r0.append(R$styleable.Layout_layout_constrainedHeight, 42);
            f2293r0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            f2293r0.append(R$styleable.Layout_layout_constraintCircle, 61);
            f2293r0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            f2293r0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            f2293r0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            f2293r0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            f2293r0.append(R$styleable.Layout_chainUseRtl, 71);
            f2293r0.append(R$styleable.Layout_barrierDirection, 72);
            f2293r0.append(R$styleable.Layout_barrierMargin, 73);
            f2293r0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            f2293r0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public b() {
            this.f2295a = false;
            this.f2297b = false;
            this.f2299c = false;
            this.f2305f = -1;
            this.f2307g = -1;
            this.f2309h = -1.0f;
            this.f2311i = true;
            this.f2313j = -1;
            this.f2315k = -1;
            this.f2317l = -1;
            this.f2319m = -1;
            this.f2321n = -1;
            this.f2323o = -1;
            this.f2325p = -1;
            this.f2327q = -1;
            this.f2329r = -1;
            this.f2330s = -1;
            this.f2331t = -1;
            this.f2332u = -1;
            this.f2333v = -1;
            this.f2334w = -1;
            this.f2335x = -1;
            this.f2336y = 0.5f;
            this.f2337z = 0.5f;
            this.A = null;
            this.B = -1;
            this.C = 0;
            this.D = 0.0f;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = 0;
            this.I = 0;
            this.f2294J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = Integer.MIN_VALUE;
            this.P = Integer.MIN_VALUE;
            this.Q = Integer.MIN_VALUE;
            this.R = Integer.MIN_VALUE;
            this.S = Integer.MIN_VALUE;
            this.T = Integer.MIN_VALUE;
            this.U = Integer.MIN_VALUE;
            this.V = -1.0f;
            this.W = -1.0f;
            this.X = 0;
            this.Y = 0;
            this.Z = 0;
            this.f2296a0 = 0;
            this.f2298b0 = 0;
            this.f2300c0 = 0;
            this.f2302d0 = 0;
            this.f2304e0 = 0;
            this.f2306f0 = 1.0f;
            this.f2308g0 = 1.0f;
            this.f2310h0 = -1;
            this.f2312i0 = 0;
            this.f2314j0 = -1;
            this.f2322n0 = false;
            this.f2324o0 = false;
            this.f2326p0 = true;
            this.f2328q0 = 0;
        }

        public void a(b r10) {
            this.f2295a = r10.f2295a;
            this.f2301d = r10.f2301d;
            this.f2297b = r10.f2297b;
            this.f2303e = r10.f2303e;
            this.f2305f = r10.f2305f;
            this.f2307g = r10.f2307g;
            this.f2309h = r10.f2309h;
            this.f2311i = r10.f2311i;
            this.f2313j = r10.f2313j;
            this.f2315k = r10.f2315k;
            this.f2317l = r10.f2317l;
            this.f2319m = r10.f2319m;
            this.f2321n = r10.f2321n;
            this.f2323o = r10.f2323o;
            this.f2325p = r10.f2325p;
            this.f2327q = r10.f2327q;
            this.f2329r = r10.f2329r;
            this.f2330s = r10.f2330s;
            this.f2331t = r10.f2331t;
            this.f2332u = r10.f2332u;
            this.f2333v = r10.f2333v;
            this.f2334w = r10.f2334w;
            this.f2335x = r10.f2335x;
            this.f2336y = r10.f2336y;
            this.f2337z = r10.f2337z;
            this.A = r10.A;
            this.B = r10.B;
            this.C = r10.C;
            this.D = r10.D;
            this.E = r10.E;
            this.F = r10.F;
            this.G = r10.G;
            this.H = r10.H;
            this.I = r10.I;
            this.f2294J = r10.f2294J;
            this.K = r10.K;
            this.L = r10.L;
            this.M = r10.M;
            this.N = r10.N;
            this.O = r10.O;
            this.P = r10.P;
            this.Q = r10.Q;
            this.R = r10.R;
            this.S = r10.S;
            this.T = r10.T;
            this.U = r10.U;
            this.V = r10.V;
            this.W = r10.W;
            this.X = r10.X;
            this.Y = r10.Y;
            this.Z = r10.Z;
            this.f2296a0 = r10.f2296a0;
            this.f2298b0 = r10.f2298b0;
            this.f2300c0 = r10.f2300c0;
            this.f2302d0 = r10.f2302d0;
            this.f2304e0 = r10.f2304e0;
            this.f2306f0 = r10.f2306f0;
            this.f2308g0 = r10.f2308g0;
            this.f2310h0 = r10.f2310h0;
            this.f2312i0 = r10.f2312i0;
            this.f2314j0 = r10.f2314j0;
            this.f2320m0 = r10.f2320m0;
            int[] r11 = r10.f2316k0;
            if (r11 != null) goto L5;
        L7:
            this.f2316k0 = null;
        L8:
            this.f2318l0 = r10.f2318l0;
            this.f2322n0 = r10.f2322n0;
            this.f2324o0 = r10.f2324o0;
            this.f2326p0 = r10.f2326p0;
            this.f2328q0 = r10.f2328q0;
            return;
        L5:
            if (r10.f2318l0 != null) goto L7;
            this.f2316k0 = Arrays.copyOf(r11, r11.length);
            goto L8
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Layout);
            this.f2297b = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L79;
            int r15 = r12.getIndex(r14);
            int r16 = f2293r0.get(r15);
            switch(r16) {
                case 1: goto L77;
                case 2: goto L76;
                case 3: goto L75;
                case 4: goto L74;
                case 5: goto L73;
                case 6: goto L72;
                case 7: goto L71;
                case 8: goto L70;
                case 9: goto L69;
                case 10: goto L68;
                case 11: goto L67;
                case 12: goto L66;
                case 13: goto L65;
                case 14: goto L64;
                case 15: goto L63;
                case 16: goto L62;
                case 17: goto L61;
                case 18: goto L60;
                case 19: goto L59;
                case 20: goto L58;
                case 21: goto L57;
                case 22: goto L56;
                case 23: goto L55;
                case 24: goto L54;
                case 25: goto L53;
                case 26: goto L52;
                case 27: goto L51;
                case 28: goto L50;
                case 29: goto L49;
                case 30: goto L48;
                case 31: goto L47;
                case 32: goto L46;
                case 33: goto L45;
                case 34: goto L44;
                case 35: goto L43;
                case 36: goto L42;
                case 37: goto L41;
                case 38: goto L40;
                case 39: goto L39;
                case 40: goto L38;
                case 41: goto L37;
                case 42: goto L36;
                default: goto L6;
            };
        L6:
            switch(r16) {
                case 61: goto L35;
                case 62: goto L34;
                case 63: goto L33;
                default: goto L8;
            };
        L33:
            this.D = r12.getFloat(r15, this.D);
        L78:
            r14 = r14 + 1;
            goto L3
        L34:
            this.C = r12.getDimensionPixelSize(r15, this.C);
            goto L78
        L35:
            this.B = ConstraintSet.a(r12, r15, this.B);
            goto L78
        L8:
            switch(r16) {
                case 69: goto L32;
                case 70: goto L31;
                case 71: goto L30;
                case 72: goto L29;
                case 73: goto L28;
                case 74: goto L27;
                case 75: goto L26;
                case 76: goto L25;
                case 77: goto L24;
                case 78: goto L23;
                case 79: goto L22;
                case 80: goto L21;
                case 81: goto L20;
                case 82: goto L19;
                case 83: goto L18;
                case 84: goto L17;
                case 85: goto L16;
                case 86: goto L15;
                case 87: goto L14;
                case 88: goto L13;
                case 89: goto L12;
                case 90: goto L11;
                case 91: goto L10;
                default: goto L9;
            };
        L9:
            Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r15) + "   " + f2293r0.get(r15));
            goto L78
        L10:
            Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r15) + "   " + f2293r0.get(r15));
            goto L78
        L11:
            this.f2311i = r12.getBoolean(r15, this.f2311i);
            goto L78
        L12:
            this.f2320m0 = r12.getString(r15);
            goto L78
        L13:
            this.f2324o0 = r12.getBoolean(r15, this.f2324o0);
            goto L78
        L14:
            this.f2322n0 = r12.getBoolean(r15, this.f2322n0);
            goto L78
        L15:
            this.f2302d0 = r12.getDimensionPixelSize(r15, this.f2302d0);
            goto L78
        L16:
            this.f2304e0 = r12.getDimensionPixelSize(r15, this.f2304e0);
            goto L78
        L17:
            this.f2298b0 = r12.getDimensionPixelSize(r15, this.f2298b0);
            goto L78
        L18:
            this.f2300c0 = r12.getDimensionPixelSize(r15, this.f2300c0);
            goto L78
        L19:
            this.f2296a0 = r12.getInt(r15, this.f2296a0);
            goto L78
        L20:
            this.Z = r12.getInt(r15, this.Z);
            goto L78
        L21:
            this.N = r12.getDimensionPixelSize(r15, this.N);
            goto L78
        L22:
            this.U = r12.getDimensionPixelSize(r15, this.U);
            goto L78
        L23:
            this.f2331t = ConstraintSet.a(r12, r15, this.f2331t);
            goto L78
        L24:
            this.f2330s = ConstraintSet.a(r12, r15, this.f2330s);
            goto L78
        L25:
            this.f2328q0 = r12.getInt(r15, this.f2328q0);
            goto L78
        L26:
            this.f2326p0 = r12.getBoolean(r15, this.f2326p0);
            goto L78
        L27:
            this.f2318l0 = r12.getString(r15);
            goto L78
        L28:
            this.f2312i0 = r12.getDimensionPixelSize(r15, this.f2312i0);
            goto L78
        L29:
            this.f2310h0 = r12.getInt(r15, this.f2310h0);
            goto L78
        L30:
            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
            goto L78
        L31:
            this.f2308g0 = r12.getFloat(r15, 1.0f);
            goto L78
        L32:
            this.f2306f0 = r12.getFloat(r15, 1.0f);
            goto L78
        L36:
            ConstraintSet.L(this, r12, r15, 1);
            goto L78
        L37:
            ConstraintSet.L(this, r12, r15, 0);
            goto L78
        L38:
            this.Y = r12.getInt(r15, this.Y);
            goto L78
        L39:
            this.X = r12.getInt(r15, this.X);
            goto L78
        L40:
            this.V = r12.getFloat(r15, this.V);
            goto L78
        L41:
            this.W = r12.getFloat(r15, this.W);
            goto L78
        L42:
            this.f2337z = r12.getFloat(r15, this.f2337z);
            goto L78
        L43:
            this.f2321n = ConstraintSet.a(r12, r15, this.f2321n);
            goto L78
        L44:
            this.f2323o = ConstraintSet.a(r12, r15, this.f2323o);
            goto L78
        L45:
            this.f2294J = r12.getDimensionPixelSize(r15, this.f2294J);
            goto L78
        L46:
            this.f2333v = ConstraintSet.a(r12, r15, this.f2333v);
            goto L78
        L47:
            this.f2332u = ConstraintSet.a(r12, r15, this.f2332u);
            goto L78
        L48:
            this.M = r12.getDimensionPixelSize(r15, this.M);
            goto L78
        L49:
            this.f2319m = ConstraintSet.a(r12, r15, this.f2319m);
            goto L78
        L50:
            this.f2317l = ConstraintSet.a(r12, r15, this.f2317l);
            goto L78
        L51:
            this.I = r12.getDimensionPixelSize(r15, this.I);
            goto L78
        L52:
            this.G = r12.getInt(r15, this.G);
            goto L78
        L53:
            this.f2315k = ConstraintSet.a(r12, r15, this.f2315k);
            goto L78
        L54:
            this.f2313j = ConstraintSet.a(r12, r15, this.f2313j);
            goto L78
        L55:
            this.H = r12.getDimensionPixelSize(r15, this.H);
            goto L78
        L56:
            this.f2301d = r12.getLayoutDimension(r15, this.f2301d);
            goto L78
        L57:
            this.f2303e = r12.getLayoutDimension(r15, this.f2303e);
            goto L78
        L58:
            this.f2336y = r12.getFloat(r15, this.f2336y);
            goto L78
        L59:
            this.f2309h = r12.getFloat(r15, this.f2309h);
            goto L78
        L60:
            this.f2307g = r12.getDimensionPixelOffset(r15, this.f2307g);
            goto L78
        L61:
            this.f2305f = r12.getDimensionPixelOffset(r15, this.f2305f);
            goto L78
        L62:
            this.P = r12.getDimensionPixelSize(r15, this.P);
            goto L78
        L63:
            this.T = r12.getDimensionPixelSize(r15, this.T);
            goto L78
        L64:
            this.Q = r12.getDimensionPixelSize(r15, this.Q);
            goto L78
        L65:
            this.O = r12.getDimensionPixelSize(r15, this.O);
            goto L78
        L66:
            this.S = r12.getDimensionPixelSize(r15, this.S);
            goto L78
        L67:
            this.R = r12.getDimensionPixelSize(r15, this.R);
            goto L78
        L68:
            this.f2334w = ConstraintSet.a(r12, r15, this.f2334w);
            goto L78
        L69:
            this.f2335x = ConstraintSet.a(r12, r15, this.f2335x);
            goto L78
        L70:
            this.L = r12.getDimensionPixelSize(r15, this.L);
            goto L78
        L71:
            this.F = r12.getDimensionPixelOffset(r15, this.F);
            goto L78
        L72:
            this.E = r12.getDimensionPixelOffset(r15, this.E);
            goto L78
        L73:
            this.A = r12.getString(r15);
            goto L78
        L74:
            this.f2325p = ConstraintSet.a(r12, r15, this.f2325p);
            goto L78
        L75:
            this.f2327q = ConstraintSet.a(r12, r15, this.f2327q);
            goto L78
        L76:
            this.K = r12.getDimensionPixelSize(r15, this.K);
            goto L78
        L77:
            this.f2329r = ConstraintSet.a(r12, r15, this.f2329r);
            goto L78
        L79:
            r12.recycle();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f2338o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f2342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f2345g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2346h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f2347i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f2348j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f2349k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f2350l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f2351m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f2352n;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f2338o = r10;
            r10.append(R$styleable.Motion_motionPathRotate, 1);
            f2338o.append(R$styleable.Motion_pathMotionArc, 2);
            f2338o.append(R$styleable.Motion_transitionEasing, 3);
            f2338o.append(R$styleable.Motion_drawPath, 4);
            f2338o.append(R$styleable.Motion_animateRelativeTo, 5);
            f2338o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            f2338o.append(R$styleable.Motion_motionStagger, 7);
            f2338o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            f2338o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            f2338o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public c() {
            this.f2339a = false;
            this.f2340b = -1;
            this.f2341c = 0;
            this.f2342d = null;
            this.f2343e = -1;
            this.f2344f = 0;
            this.f2345g = Float.NaN;
            this.f2346h = -1;
            this.f2347i = Float.NaN;
            this.f2348j = Float.NaN;
            this.f2349k = -1;
            this.f2350l = null;
            this.f2351m = -3;
            this.f2352n = -1;
        }

        public void a(c r10) {
            this.f2339a = r10.f2339a;
            this.f2340b = r10.f2340b;
            this.f2342d = r10.f2342d;
            this.f2343e = r10.f2343e;
            this.f2344f = r10.f2344f;
            this.f2347i = r10.f2347i;
            this.f2345g = r10.f2345g;
            this.f2346h = r10.f2346h;
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Motion);
            this.f2339a = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L31;
            int r15 = r12.getIndex(r14);
            switch(f2338o.get(r15)) {
                case 1: goto L29;
                case 2: goto L28;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L7;
                default: goto L30;
            };
        L7:
            int r16 = r12.peekValue(r15).type;
            if (r16 != 1) goto L12;
            int r17 = r12.getResourceId(r15, -1);
            this.f2352n = r17;
            if (r17 == (-1)) goto L30;
            this.f2351m = -2;
            goto L30
        L12:
            if (r16 != 3) goto L17;
            String r18 = r12.getString(r15);
            this.f2350l = r18;
            if (r18.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L16;
            this.f2352n = r12.getResourceId(r15, -1);
            this.f2351m = -2;
            goto L30
        L16:
            this.f2351m = -1;
            goto L30
        L17:
            this.f2351m = r12.getInteger(r15, this.f2352n);
            goto L30
        L18:
            this.f2348j = r12.getFloat(r15, this.f2348j);
            goto L30
        L19:
            this.f2349k = r12.getInteger(r15, this.f2349k);
            goto L30
        L20:
            this.f2345g = r12.getFloat(r15, this.f2345g);
            goto L30
        L21:
            this.f2341c = r12.getInteger(r15, this.f2341c);
            goto L30
        L22:
            this.f2340b = ConstraintSet.a(r12, r15, this.f2340b);
            goto L30
        L23:
            this.f2344f = r12.getInt(r15, 0);
            goto L30
        L28:
            this.f2343e = r12.getInt(r15, this.f2343e);
            goto L30
        L29:
            this.f2347i = r12.getFloat(r15, this.f2347i);
            goto L30
        L25:
            if (r12.peekValue(r15).type != 3) goto L27;
            this.f2342d = r12.getString(r15);
            goto L30
        L27:
            this.f2342d = p001j.c.f20781c[r12.getInteger(r15, 0)];
        L30:
            r14 = r14 + 1;
            goto L3
        L31:
            r12.recycle();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f2357e;

        public d() {
            this.f2353a = false;
            this.f2354b = 0;
            this.f2355c = 0;
            this.f2356d = 1.0f;
            this.f2357e = Float.NaN;
        }

        public void a(d r10) {
            this.f2353a = r10.f2353a;
            this.f2354b = r10.f2354b;
            this.f2356d = r10.f2356d;
            this.f2357e = r10.f2357e;
            this.f2355c = r10.f2355c;
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.PropertySet);
            this.f2353a = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L17;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.PropertySet_android_alpha) goto L8;
            this.f2356d = r12.getFloat(r15, this.f2356d);
        L16:
            r14 = r14 + 1;
            goto L3
        L8:
            if (r15 != R$styleable.PropertySet_android_visibility) goto L11;
            this.f2354b = r12.getInt(r15, this.f2354b);
            this.f2354b = ConstraintSet.b()[this.f2354b];
            goto L16
        L11:
            if (r15 != R$styleable.PropertySet_visibilityMode) goto L14;
            this.f2355c = r12.getInt(r15, this.f2355c);
            goto L16
        L14:
            if (r15 != R$styleable.PropertySet_motionProgress) goto L16;
            this.f2357e = r12.getFloat(r15, this.f2357e);
            goto L16
        L17:
            r12.recycle();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f2358o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2361c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2362d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f2363e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f2364f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f2365g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f2366h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2367i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f2368j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f2369k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f2370l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f2371m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f2372n;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f2358o = r10;
            r10.append(R$styleable.Transform_android_rotation, 1);
            f2358o.append(R$styleable.Transform_android_rotationX, 2);
            f2358o.append(R$styleable.Transform_android_rotationY, 3);
            f2358o.append(R$styleable.Transform_android_scaleX, 4);
            f2358o.append(R$styleable.Transform_android_scaleY, 5);
            f2358o.append(R$styleable.Transform_android_transformPivotX, 6);
            f2358o.append(R$styleable.Transform_android_transformPivotY, 7);
            f2358o.append(R$styleable.Transform_android_translationX, 8);
            f2358o.append(R$styleable.Transform_android_translationY, 9);
            f2358o.append(R$styleable.Transform_android_translationZ, 10);
            f2358o.append(R$styleable.Transform_android_elevation, 11);
            f2358o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public e() {
            this.f2359a = false;
            this.f2360b = 0.0f;
            this.f2361c = 0.0f;
            this.f2362d = 0.0f;
            this.f2363e = 1.0f;
            this.f2364f = 1.0f;
            this.f2365g = Float.NaN;
            this.f2366h = Float.NaN;
            this.f2367i = -1;
            this.f2368j = 0.0f;
            this.f2369k = 0.0f;
            this.f2370l = 0.0f;
            this.f2371m = false;
            this.f2372n = 0.0f;
        }

        public void a(e r10) {
            this.f2359a = r10.f2359a;
            this.f2360b = r10.f2360b;
            this.f2361c = r10.f2361c;
            this.f2362d = r10.f2362d;
            this.f2363e = r10.f2363e;
            this.f2364f = r10.f2364f;
            this.f2365g = r10.f2365g;
            this.f2366h = r10.f2366h;
            this.f2367i = r10.f2367i;
            this.f2368j = r10.f2368j;
            this.f2369k = r10.f2369k;
            this.f2370l = r10.f2370l;
            this.f2371m = r10.f2371m;
            this.f2372n = r10.f2372n;
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Transform);
            this.f2359a = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L20;
            int r15 = r12.getIndex(r14);
            switch(f2358o.get(r15)) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L19;
            };
        L7:
            this.f2367i = ConstraintSet.a(r12, r15, this.f2367i);
            goto L19
        L8:
            this.f2371m = true;
            this.f2372n = r12.getDimension(r15, this.f2372n);
            goto L19
        L9:
            this.f2370l = r12.getDimension(r15, this.f2370l);
            goto L19
        L10:
            this.f2369k = r12.getDimension(r15, this.f2369k);
            goto L19
        L11:
            this.f2368j = r12.getDimension(r15, this.f2368j);
            goto L19
        L12:
            this.f2366h = r12.getDimension(r15, this.f2366h);
            goto L19
        L13:
            this.f2365g = r12.getDimension(r15, this.f2365g);
            goto L19
        L14:
            this.f2364f = r12.getFloat(r15, this.f2364f);
            goto L19
        L15:
            this.f2363e = r12.getFloat(r15, this.f2363e);
            goto L19
        L16:
            this.f2362d = r12.getFloat(r15, this.f2362d);
            goto L19
        L17:
            this.f2361c = r12.getFloat(r15, this.f2361c);
            goto L19
        L18:
            this.f2360b = r12.getFloat(r15, this.f2360b);
        L19:
            r14 = r14 + 1;
            goto L3
        L20:
            r12.recycle();
        }
    }

    static {
        f2263h = new int[]{0, 4, 8};
        f2264i = new SparseIntArray();
        f2265j = new SparseIntArray();
        f2264i.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f2264i.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f2264i.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f2264i.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f2264i.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f2264i.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f2264i.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f2264i.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f2264i.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f2264i.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f2264i.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f2264i.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f2264i.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f2264i.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f2264i.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f2264i.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f2264i.append(R$styleable.Constraint_guidelineUseRtl, 99);
        f2264i.append(R$styleable.Constraint_android_orientation, 27);
        f2264i.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f2264i.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f2264i.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f2264i.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f2264i.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f2264i.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f2264i.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f2264i.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f2264i.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f2264i.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f2264i.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f2264i.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f2264i.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f2264i.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f2264i.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f2264i.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f2264i.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f2264i.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f2264i.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f2264i.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f2264i.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f2264i.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f2264i.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f2264i.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f2264i.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f2264i.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f2264i.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f2264i.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f2264i.append(R$styleable.Constraint_android_layout_width, 23);
        f2264i.append(R$styleable.Constraint_android_layout_height, 21);
        f2264i.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f2264i.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f2264i.append(R$styleable.Constraint_android_visibility, 22);
        f2264i.append(R$styleable.Constraint_android_alpha, 43);
        f2264i.append(R$styleable.Constraint_android_elevation, 44);
        f2264i.append(R$styleable.Constraint_android_rotationX, 45);
        f2264i.append(R$styleable.Constraint_android_rotationY, 46);
        f2264i.append(R$styleable.Constraint_android_rotation, 60);
        f2264i.append(R$styleable.Constraint_android_scaleX, 47);
        f2264i.append(R$styleable.Constraint_android_scaleY, 48);
        f2264i.append(R$styleable.Constraint_android_transformPivotX, 49);
        f2264i.append(R$styleable.Constraint_android_transformPivotY, 50);
        f2264i.append(R$styleable.Constraint_android_translationX, 51);
        f2264i.append(R$styleable.Constraint_android_translationY, 52);
        f2264i.append(R$styleable.Constraint_android_translationZ, 53);
        f2264i.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f2264i.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f2264i.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f2264i.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f2264i.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f2264i.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f2264i.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f2264i.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f2264i.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f2264i.append(R$styleable.Constraint_animateRelativeTo, 64);
        f2264i.append(R$styleable.Constraint_transitionEasing, 65);
        f2264i.append(R$styleable.Constraint_drawPath, 66);
        f2264i.append(R$styleable.Constraint_transitionPathRotate, 67);
        f2264i.append(R$styleable.Constraint_motionStagger, 79);
        f2264i.append(R$styleable.Constraint_android_id, 38);
        f2264i.append(R$styleable.Constraint_motionProgress, 68);
        f2264i.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f2264i.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f2264i.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f2264i.append(R$styleable.Constraint_chainUseRtl, 71);
        f2264i.append(R$styleable.Constraint_barrierDirection, 72);
        f2264i.append(R$styleable.Constraint_barrierMargin, 73);
        f2264i.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f2264i.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f2264i.append(R$styleable.Constraint_pathMotionArc, 76);
        f2264i.append(R$styleable.Constraint_layout_constraintTag, 77);
        f2264i.append(R$styleable.Constraint_visibilityMode, 78);
        f2264i.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f2264i.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f2264i.append(R$styleable.Constraint_polarRelativeTo, 82);
        f2264i.append(R$styleable.Constraint_transformPivotTarget, 83);
        f2264i.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f2264i.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f2264i.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray r10 = f2265j;
        int r11 = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        r10.append(r11, 6);
        f2265j.append(r11, 7);
        f2265j.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f2265j.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f2265j.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f2265j.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f2265j.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f2265j.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f2265j.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f2265j.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f2265j.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f2265j.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f2265j.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f2265j.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f2265j.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f2265j.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f2265j.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f2265j.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f2265j.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f2265j.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f2265j.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f2265j.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f2265j.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f2265j.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f2265j.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f2265j.append(R$styleable.ConstraintOverride_drawPath, 66);
        f2265j.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f2265j.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f2265j.append(R$styleable.ConstraintOverride_android_id, 38);
        f2265j.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f2265j.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f2265j.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f2265j.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f2265j.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f2265j.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f2265j.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f2265j.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f2265j.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f2265j.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f2265j.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f2265j.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f2265j.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f2265j.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f2265j.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f2265j.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f2265j.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f2265j.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public ConstraintSet() {
        this.f2268c = "";
        this.f2269d = 0;
        this.f2270e = new HashMap();
        this.f2271f = true;
        this.f2272g = new HashMap();
    }

    public static int K(TypedArray r10, int r11, int r12) {
        int r13 = r10.getResourceId(r11, r12);
        if (r13 == (-1)) goto L5;
        return r13;
    L5:
        return r10.getInt(r11, -1);
    }

    public static void L(Object r10, TypedArray r11, int r12, int r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r14 = r11.peekValue(r12).type;
        if (r14 == 3) goto L38;
        int r15 = 0;
        if (r14 == 5) goto L18;
        int r16 = r11.getInt(r12, 0);
        if (r16 != (-4)) goto L11;
        boolean r17 = true;
        r15 = -2;
    L20:
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r10;
        if (r13 != 0) goto L24;
        ((ViewGroup.MarginLayoutParams) r18).width = r15;
        r18.f2188a0 = r17;
        return;
    L24:
        ((ViewGroup.MarginLayoutParams) r18).height = r15;
        r18.f2190b0 = r17;
        return;
    L26:
        if ((r10 instanceof b) == false) goto L32;
        b r19 = (b) r10;
        if (r13 != 0) goto L30;
        r19.f2301d = r15;
        r19.f2322n0 = r17;
        return;
    L30:
        r19.f2303e = r15;
        r19.f2324o0 = r17;
        return;
    L32:
        if ((r10 instanceof a.C0011a) == false) goto L44;
        a.C0011a r20 = (a.C0011a) r10;
        if (r13 != 0) goto L36;
        r20.b(23, r15);
        r20.d(80, r17);
        return;
    L36:
        r20.b(21, r15);
        r20.d(81, r17);
        return;
    L44:
        return;
    L11:
        if (r16 == (-3)) goto L15;
        if (r16 != (-2)) goto L14;
    L16:
        r15 = r16;
        r17 = false;
        goto L20
    L14:
        if (r16 == (-1)) goto L16;
    L15:
        r17 = false;
        goto L20
    L18:
        r16 = r11.getDimensionPixelSize(r12, 0);
        goto L16
    L38:
        M(r10, r11.getString(r12), r13);
    }

    public static void M(Object r10, String r11, int r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r13 = r11.indexOf(61);
        int r14 = r11.length();
        if (r13 > 0) goto L7;
        return;
    L7:
        if (r13 >= (r14 - 1)) goto L72;
        String r15 = r11.substring(0, r13);
        String r16 = r11.substring(r13 + 1);
        if (r16.length() <= 0) goto L73;
        String r17 = r15.trim();
        String r18 = r16.trim();
        if ("ratio".equalsIgnoreCase(r17) == false) goto L69;
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r10;
        if (r12 != 0) goto L17;
        ((ViewGroup.MarginLayoutParams) r19).width = 0;
    L18:
        N(r19, r18);
        return;
    L17:
        ((ViewGroup.MarginLayoutParams) r19).height = 0;
        goto L18
    L20:
        if ((r10 instanceof b) == false) goto L23;
        ((b) r10).A = r18;
        return;
    L23:
        if ((r10 instanceof a.C0011a) == false) goto L76;
        ((a.C0011a) r10).c(5, r18);
        return;
    L76:
        return;
    L69:
        if ("weight".equalsIgnoreCase(r17) == false) goto L47;
        float r20 = Float.parseFloat(r18);     // Catch: NumberFormatException -> L67
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r10;     // Catch: NumberFormatException -> L67
        if (r12 != 0) goto L32;
        ((ViewGroup.MarginLayoutParams) r21).width = 0;     // Catch: NumberFormatException -> L67
        r21.L = r20;     // Catch: NumberFormatException -> L67
    L68:
        return;
    L32:
        ((ViewGroup.MarginLayoutParams) r21).height = 0;     // Catch: NumberFormatException -> L67
        r21.M = r20;     // Catch: NumberFormatException -> L67
        goto L68
    L34:
        if ((r10 instanceof b) == false) goto L40;
        b r22 = (b) r10;     // Catch: NumberFormatException -> L67
        if (r12 != 0) goto L38;
        r22.f2301d = 0;     // Catch: NumberFormatException -> L67
        r22.W = r20;     // Catch: NumberFormatException -> L67
        goto L68
    L38:
        r22.f2303e = 0;     // Catch: NumberFormatException -> L67
        r22.V = r20;     // Catch: NumberFormatException -> L67
        goto L68
    L40:
        if ((r10 instanceof a.C0011a) == false) goto L68;
        a.C0011a r23 = (a.C0011a) r10;     // Catch: NumberFormatException -> L67
        if (r12 != 0) goto L44;
        r23.b(23, 0);     // Catch: NumberFormatException -> L67
        r23.a(39, r20);     // Catch: NumberFormatException -> L67
        goto L68
    L44:
        r23.b(21, 0);     // Catch: NumberFormatException -> L67
        r23.a(40, r20);     // Catch: NumberFormatException -> L67
        goto L68
    L47:
        if ("parent".equalsIgnoreCase(r17) == false) goto L78;
        float r24 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r18)));     // Catch: NumberFormatException -> L67
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L55;
        ConstraintLayout.LayoutParams r25 = (ConstraintLayout.LayoutParams) r10;     // Catch: NumberFormatException -> L67
        if (r12 != 0) goto L53;
        ((ViewGroup.MarginLayoutParams) r25).width = 0;     // Catch: NumberFormatException -> L67
        r25.V = r24;     // Catch: NumberFormatException -> L67
        r25.P = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L53:
        ((ViewGroup.MarginLayoutParams) r25).height = 0;     // Catch: NumberFormatException -> L67
        r25.W = r24;     // Catch: NumberFormatException -> L67
        r25.Q = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L55:
        if ((r10 instanceof b) == false) goto L61;
        b r26 = (b) r10;     // Catch: NumberFormatException -> L67
        if (r12 != 0) goto L59;
        r26.f2301d = 0;     // Catch: NumberFormatException -> L67
        r26.f2306f0 = r24;     // Catch: NumberFormatException -> L67
        r26.Z = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L59:
        r26.f2303e = 0;     // Catch: NumberFormatException -> L67
        r26.f2308g0 = r24;     // Catch: NumberFormatException -> L67
        r26.f2296a0 = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L61:
        if ((r10 instanceof a.C0011a) == false) goto L68;
        a.C0011a r27 = (a.C0011a) r10;     // Catch: NumberFormatException -> L67
        if (r12 != 0) goto L65;
        r27.b(23, 0);     // Catch: NumberFormatException -> L67
        r27.b(54, 2);     // Catch: NumberFormatException -> L67
        goto L68
    L65:
        r27.b(21, 0);     // Catch: NumberFormatException -> L67
        r27.b(55, 2);     // Catch: NumberFormatException -> L67
        goto L68
    L78:
        return;
    L79:
        return;
    L73:
        return;
    }

    public static void N(ConstraintLayout.LayoutParams r10, String r11) {
        float r12 = Float.NaN;
        int r13 = -1;
        if (r11 == null) goto L34;
        int r14 = r11.length();
        int r15 = r11.indexOf(44);
        int r16 = 0;
        if (r15 > 0) goto L7;
    L15:
        int r17 = r11.indexOf(58);
        if (r17 >= 0) goto L18;
    L31:
        String r18 = r11.substring(r16);
        if (r18.length() <= 0) goto L34;
        r12 = Float.parseFloat(r18);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r17 >= (r14 - 1)) goto L31;
        String r19 = r11.substring(r16, r17);
        String r20 = r11.substring(r17 + 1);
        if (r19.length() <= 0) goto L34;
        if (r20.length() <= 0) goto L34;
        float r21 = Float.parseFloat(r19);     // Catch: NumberFormatException -> L36
        float r22 = Float.parseFloat(r20);     // Catch: NumberFormatException -> L36
        if (r21 <= 0.0f) goto L37;
        if (r22 <= 0.0f) goto L37;
        if (r13 != 1) goto L29;
        r12 = Math.abs(r22 / r21);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        r12 = Math.abs(r21 / r22);     // Catch: NumberFormatException -> L36
        goto L37
    L7:
        if (r15 >= (r14 - 1)) goto L15;
        String r23 = r11.substring(0, r15);
        if (r23.equalsIgnoreCase("W") == false) goto L12;
        r13 = 0;
    L14:
        r16 = r15 + 1;
        goto L15
    L12:
        if (r23.equalsIgnoreCase("H") == false) goto L14;
        r13 = 1;
    L34:
        r10.I = r11;
        r10.f2186J = r12;
        r10.K = r13;
    }

    public static void P(Context r11, a r12, TypedArray r13) {
        int r14 = r13.getIndexCount();
        a.C0011a r10 = new a.C0011a();
        r12.f2280h = r10;
        r12.f2276d.f2339a = false;
        r12.f2277e.f2297b = false;
        r12.f2275c.f2353a = false;
        r12.f2278f.f2359a = false;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L109;
        int r16 = r13.getIndex(r15);
        switch(f2265j.get(r16)) {
            case 2: goto L107;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L106;
            case 6: goto L105;
            case 7: goto L104;
            case 8: goto L103;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L102;
            case 12: goto L101;
            case 13: goto L100;
            case 14: goto L99;
            case 15: goto L98;
            case 16: goto L97;
            case 17: goto L96;
            case 18: goto L95;
            case 19: goto L94;
            case 20: goto L93;
            case 21: goto L92;
            case 22: goto L91;
            case 23: goto L90;
            case 24: goto L89;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L88;
            case 28: goto L87;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L86;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L85;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L84;
            case 38: goto L83;
            case 39: goto L82;
            case 40: goto L81;
            case 41: goto L80;
            case 42: goto L79;
            case 43: goto L78;
            case 44: goto L77;
            case 45: goto L76;
            case 46: goto L75;
            case 47: goto L74;
            case 48: goto L73;
            case 49: goto L72;
            case 50: goto L71;
            case 51: goto L70;
            case 52: goto L69;
            case 53: goto L68;
            case 54: goto L67;
            case 55: goto L66;
            case 56: goto L65;
            case 57: goto L64;
            case 58: goto L63;
            case 59: goto L62;
            case 60: goto L61;
            case 61: goto L6;
            case 62: goto L60;
            case 63: goto L59;
            case 64: goto L58;
            case 65: goto L55;
            case 66: goto L53;
            case 67: goto L52;
            case 68: goto L51;
            case 69: goto L50;
            case 70: goto L49;
            case 71: goto L48;
            case 72: goto L47;
            case 73: goto L46;
            case 74: goto L45;
            case 75: goto L44;
            case 76: goto L43;
            case 77: goto L42;
            case 78: goto L41;
            case 79: goto L40;
            case 80: goto L39;
            case 81: goto L38;
            case 82: goto L37;
            case 83: goto L36;
            case 84: goto L35;
            case 85: goto L34;
            case 86: goto L23;
            case 87: goto L22;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            case 98: goto L9;
            case 99: goto L7;
            default: goto L6;
        };
    L6:
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r16) + "   " + f2264i.get(r16));
    L108:
        r15 = r15 + 1;
        goto L3
    L7:
        r10.d(99, r13.getBoolean(r16, r12.f2277e.f2311i));
        goto L108
    L17:
        r10.b(97, r13.getInt(r16, r12.f2277e.f2328q0));
        goto L108
    L18:
        L(r10, r13, r16, 1);
        goto L108
    L19:
        L(r10, r13, r16, 0);
        goto L108
    L20:
        r10.b(94, r13.getDimensionPixelSize(r16, r12.f2277e.U));
        goto L108
    L21:
        r10.b(93, r13.getDimensionPixelSize(r16, r12.f2277e.N));
        goto L108
    L22:
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r16) + "   " + f2264i.get(r16));
        goto L108
    L23:
        int r17 = r13.peekValue(r16).type;
        if (r17 != 1) goto L28;
        r12.f2276d.f2352n = r13.getResourceId(r16, -1);
        r10.b(89, r12.f2276d.f2352n);
        c r18 = r12.f2276d;
        if (r18.f2352n == (-1)) goto L108;
        r18.f2351m = -2;
        r10.b(88, -2);
        goto L108
    L28:
        if (r17 != 3) goto L33;
        r12.f2276d.f2350l = r13.getString(r16);
        r10.c(90, r12.f2276d.f2350l);
        if (r12.f2276d.f2350l.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L32;
        r12.f2276d.f2352n = r13.getResourceId(r16, -1);
        r10.b(89, r12.f2276d.f2352n);
        r12.f2276d.f2351m = -2;
        r10.b(88, -2);
        goto L108
    L32:
        r12.f2276d.f2351m = -1;
        r10.b(88, -1);
        goto L108
    L33:
        c r19 = r12.f2276d;
        r19.f2351m = r13.getInteger(r16, r19.f2352n);
        r10.b(88, r12.f2276d.f2351m);
        goto L108
    L34:
        r10.a(85, r13.getFloat(r16, r12.f2276d.f2348j));
        goto L108
    L35:
        r10.b(84, r13.getInteger(r16, r12.f2276d.f2349k));
        goto L108
    L36:
        r10.b(83, K(r13, r16, r12.f2278f.f2367i));
        goto L108
    L37:
        r10.b(82, r13.getInteger(r16, r12.f2276d.f2341c));
        goto L108
    L38:
        r10.d(81, r13.getBoolean(r16, r12.f2277e.f2324o0));
        goto L108
    L39:
        r10.d(80, r13.getBoolean(r16, r12.f2277e.f2322n0));
        goto L108
    L40:
        r10.a(79, r13.getFloat(r16, r12.f2276d.f2345g));
        goto L108
    L41:
        r10.b(78, r13.getInt(r16, r12.f2275c.f2355c));
        goto L108
    L42:
        r10.c(77, r13.getString(r16));
        goto L108
    L43:
        r10.b(76, r13.getInt(r16, r12.f2276d.f2343e));
        goto L108
    L44:
        r10.d(75, r13.getBoolean(r16, r12.f2277e.f2326p0));
        goto L108
    L45:
        r10.c(74, r13.getString(r16));
        goto L108
    L46:
        r10.b(73, r13.getDimensionPixelSize(r16, r12.f2277e.f2312i0));
        goto L108
    L47:
        r10.b(72, r13.getInt(r16, r12.f2277e.f2310h0));
        goto L108
    L48:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L108
    L49:
        r10.a(70, r13.getFloat(r16, 1.0f));
        goto L108
    L50:
        r10.a(69, r13.getFloat(r16, 1.0f));
        goto L108
    L51:
        r10.a(68, r13.getFloat(r16, r12.f2275c.f2357e));
        goto L108
    L52:
        r10.a(67, r13.getFloat(r16, r12.f2276d.f2347i));
        goto L108
    L53:
        r10.b(66, r13.getInt(r16, 0));
        goto L108
    L58:
        r10.b(64, K(r13, r16, r12.f2276d.f2340b));
        goto L108
    L59:
        r10.a(63, r13.getFloat(r16, r12.f2277e.D));
        goto L108
    L60:
        r10.b(62, r13.getDimensionPixelSize(r16, r12.f2277e.C));
        goto L108
    L61:
        r10.a(60, r13.getFloat(r16, r12.f2278f.f2360b));
        goto L108
    L62:
        r10.b(59, r13.getDimensionPixelSize(r16, r12.f2277e.f2304e0));
        goto L108
    L63:
        r10.b(58, r13.getDimensionPixelSize(r16, r12.f2277e.f2302d0));
        goto L108
    L64:
        r10.b(57, r13.getDimensionPixelSize(r16, r12.f2277e.f2300c0));
        goto L108
    L65:
        r10.b(56, r13.getDimensionPixelSize(r16, r12.f2277e.f2298b0));
        goto L108
    L66:
        r10.b(55, r13.getInt(r16, r12.f2277e.f2296a0));
        goto L108
    L67:
        r10.b(54, r13.getInt(r16, r12.f2277e.Z));
        goto L108
    L68:
        r10.a(53, r13.getDimension(r16, r12.f2278f.f2370l));
        goto L108
    L69:
        r10.a(52, r13.getDimension(r16, r12.f2278f.f2369k));
        goto L108
    L70:
        r10.a(51, r13.getDimension(r16, r12.f2278f.f2368j));
        goto L108
    L71:
        r10.a(50, r13.getDimension(r16, r12.f2278f.f2366h));
        goto L108
    L72:
        r10.a(49, r13.getDimension(r16, r12.f2278f.f2365g));
        goto L108
    L73:
        r10.a(48, r13.getFloat(r16, r12.f2278f.f2364f));
        goto L108
    L74:
        r10.a(47, r13.getFloat(r16, r12.f2278f.f2363e));
        goto L108
    L75:
        r10.a(46, r13.getFloat(r16, r12.f2278f.f2362d));
        goto L108
    L76:
        r10.a(45, r13.getFloat(r16, r12.f2278f.f2361c));
        goto L108
    L77:
        r10.d(44, true);
        r10.a(44, r13.getDimension(r16, r12.f2278f.f2372n));
        goto L108
    L78:
        r10.a(43, r13.getFloat(r16, r12.f2275c.f2356d));
        goto L108
    L79:
        r10.b(42, r13.getInt(r16, r12.f2277e.Y));
        goto L108
    L80:
        r10.b(41, r13.getInt(r16, r12.f2277e.X));
        goto L108
    L81:
        r10.a(40, r13.getFloat(r16, r12.f2277e.V));
        goto L108
    L82:
        r10.a(39, r13.getFloat(r16, r12.f2277e.W));
        goto L108
    L83:
        int r20 = r13.getResourceId(r16, r12.f2273a);
        r12.f2273a = r20;
        r10.b(38, r20);
        goto L108
    L84:
        r10.a(37, r13.getFloat(r16, r12.f2277e.f2337z));
        goto L108
    L85:
        r10.b(34, r13.getDimensionPixelSize(r16, r12.f2277e.f2294J));
        goto L108
    L86:
        r10.b(31, r13.getDimensionPixelSize(r16, r12.f2277e.M));
        goto L108
    L87:
        r10.b(28, r13.getDimensionPixelSize(r16, r12.f2277e.I));
        goto L108
    L88:
        r10.b(27, r13.getInt(r16, r12.f2277e.G));
        goto L108
    L89:
        r10.b(24, r13.getDimensionPixelSize(r16, r12.f2277e.H));
        goto L108
    L90:
        r10.b(23, r13.getLayoutDimension(r16, r12.f2277e.f2301d));
        goto L108
    L91:
        r10.b(22, f2263h[r13.getInt(r16, r12.f2275c.f2354b)]);
        goto L108
    L92:
        r10.b(21, r13.getLayoutDimension(r16, r12.f2277e.f2303e));
        goto L108
    L93:
        r10.a(20, r13.getFloat(r16, r12.f2277e.f2336y));
        goto L108
    L94:
        r10.a(19, r13.getFloat(r16, r12.f2277e.f2309h));
        goto L108
    L95:
        r10.b(18, r13.getDimensionPixelOffset(r16, r12.f2277e.f2307g));
        goto L108
    L96:
        r10.b(17, r13.getDimensionPixelOffset(r16, r12.f2277e.f2305f));
        goto L108
    L97:
        r10.b(16, r13.getDimensionPixelSize(r16, r12.f2277e.P));
        goto L108
    L98:
        r10.b(15, r13.getDimensionPixelSize(r16, r12.f2277e.T));
        goto L108
    L99:
        r10.b(14, r13.getDimensionPixelSize(r16, r12.f2277e.Q));
        goto L108
    L100:
        r10.b(13, r13.getDimensionPixelSize(r16, r12.f2277e.O));
        goto L108
    L101:
        r10.b(12, r13.getDimensionPixelSize(r16, r12.f2277e.S));
        goto L108
    L102:
        r10.b(11, r13.getDimensionPixelSize(r16, r12.f2277e.R));
        goto L108
    L103:
        r10.b(8, r13.getDimensionPixelSize(r16, r12.f2277e.L));
        goto L108
    L104:
        r10.b(7, r13.getDimensionPixelOffset(r16, r12.f2277e.F));
        goto L108
    L105:
        r10.b(6, r13.getDimensionPixelOffset(r16, r12.f2277e.E));
        goto L108
    L106:
        r10.c(5, r13.getString(r16));
        goto L108
    L107:
        r10.b(2, r13.getDimensionPixelSize(r16, r12.f2277e.K));
        goto L108
    L9:
        if (MotionLayout.E0 == false) goto L14;
        int r21 = r13.getResourceId(r16, r12.f2273a);
        r12.f2273a = r21;
        if (r21 != (-1)) goto L108;
        r12.f2274b = r13.getString(r16);
        goto L108
    L14:
        if (r13.peekValue(r16).type != 3) goto L16;
        r12.f2274b = r13.getString(r16);
        goto L108
    L16:
        r12.f2273a = r13.getResourceId(r16, r12.f2273a);
        goto L108
    L55:
        if (r13.peekValue(r16).type != 3) goto L57;
        r10.c(65, r13.getString(r16));
        goto L108
    L57:
        r10.c(65, p001j.c.f20781c[r13.getInteger(r16, 0)]);
        goto L108
    }

    public static void S(a r10, int r11, float r12) {
        if (r11 != 19) goto L5;
        r10.f2277e.f2309h = r12;
        return;
    L5:
        if (r11 != 20) goto L7;
        r10.f2277e.f2336y = r12;
        return;
    L7:
        if (r11 != 37) goto L9;
        r10.f2277e.f2337z = r12;
        return;
    L9:
        if (r11 != 60) goto L11;
        r10.f2278f.f2360b = r12;
        return;
    L11:
        if (r11 != 63) goto L13;
        r10.f2277e.D = r12;
        return;
    L13:
        if (r11 != 79) goto L15;
        r10.f2276d.f2345g = r12;
        return;
    L15:
        if (r11 != 85) goto L17;
        r10.f2276d.f2348j = r12;
        return;
    L17:
        if (r11 != 87) goto L19;
        return;
    L19:
        if (r11 != 39) goto L21;
        r10.f2277e.W = r12;
        return;
    L21:
        if (r11 == 40) goto L40;
        switch(r11) {
            case 43: goto L39;
            case 44: goto L38;
            case 45: goto L37;
            case 46: goto L36;
            case 47: goto L35;
            case 48: goto L34;
            case 49: goto L33;
            case 50: goto L32;
            case 51: goto L31;
            case 52: goto L30;
            case 53: goto L29;
            default: goto L23;
        };
    L23:
        switch(r11) {
            case 67: goto L28;
            case 68: goto L27;
            case 69: goto L26;
            case 70: goto L25;
            default: goto L24;
        };
    L24:
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L25:
        r10.f2277e.f2308g0 = r12;
        return;
    L26:
        r10.f2277e.f2306f0 = r12;
        return;
    L27:
        r10.f2275c.f2357e = r12;
        return;
    L28:
        r10.f2276d.f2347i = r12;
        return;
    L29:
        r10.f2278f.f2370l = r12;
        return;
    L30:
        r10.f2278f.f2369k = r12;
        return;
    L31:
        r10.f2278f.f2368j = r12;
        return;
    L32:
        r10.f2278f.f2366h = r12;
        return;
    L33:
        r10.f2278f.f2365g = r12;
        return;
    L34:
        r10.f2278f.f2364f = r12;
        return;
    L35:
        r10.f2278f.f2363e = r12;
        return;
    L36:
        r10.f2278f.f2362d = r12;
        return;
    L37:
        r10.f2278f.f2361c = r12;
        return;
    L38:
        e r13 = r10.f2278f;
        r13.f2372n = r12;
        r13.f2371m = true;
        return;
    L39:
        r10.f2275c.f2356d = r12;
        return;
    L40:
        r10.f2277e.V = r12;
    }

    public static void T(a r10, int r11, int r12) {
        if (r11 != 6) goto L5;
        r10.f2277e.E = r12;
        return;
    L5:
        if (r11 != 7) goto L7;
        r10.f2277e.F = r12;
        return;
    L7:
        if (r11 != 8) goto L9;
        r10.f2277e.L = r12;
        return;
    L9:
        if (r11 != 27) goto L11;
        r10.f2277e.G = r12;
        return;
    L11:
        if (r11 != 28) goto L13;
        r10.f2277e.I = r12;
        return;
    L13:
        if (r11 != 41) goto L15;
        r10.f2277e.X = r12;
        return;
    L15:
        if (r11 != 42) goto L17;
        r10.f2277e.Y = r12;
        return;
    L17:
        if (r11 != 61) goto L19;
        r10.f2277e.B = r12;
        return;
    L19:
        if (r11 != 62) goto L21;
        r10.f2277e.C = r12;
        return;
    L21:
        if (r11 != 72) goto L23;
        r10.f2277e.f2310h0 = r12;
        return;
    L23:
        if (r11 == 73) goto L64;
        switch(r11) {
            case 2: goto L63;
            case 11: goto L62;
            case 12: goto L61;
            case 13: goto L60;
            case 14: goto L59;
            case 15: goto L58;
            case 16: goto L57;
            case 17: goto L56;
            case 18: goto L55;
            case 31: goto L54;
            case 34: goto L53;
            case 38: goto L52;
            case 64: goto L51;
            case 66: goto L50;
            case 76: goto L49;
            case 78: goto L48;
            case 93: goto L47;
            case 94: goto L46;
            case 97: goto L45;
            default: goto L25;
        };
    L25:
        switch(r11) {
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            default: goto L26;
        };
    L26:
        switch(r11) {
            case 54: goto L40;
            case 55: goto L39;
            case 56: goto L38;
            case 57: goto L37;
            case 58: goto L36;
            case 59: goto L35;
            default: goto L27;
        };
    L27:
        switch(r11) {
            case 82: goto L34;
            case 83: goto L33;
            case 84: goto L32;
            default: goto L28;
        };
    L28:
        switch(r11) {
            case 87: goto L76;
            case 88: goto L31;
            case 89: goto L30;
            default: goto L29;
        };
    L29:
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L30:
        r10.f2276d.f2352n = r12;
        return;
    L31:
        r10.f2276d.f2351m = r12;
        return;
    L76:
        return;
    L32:
        r10.f2276d.f2349k = r12;
        return;
    L33:
        r10.f2278f.f2367i = r12;
        return;
    L34:
        r10.f2276d.f2341c = r12;
        return;
    L35:
        r10.f2277e.f2304e0 = r12;
        return;
    L36:
        r10.f2277e.f2302d0 = r12;
        return;
    L37:
        r10.f2277e.f2300c0 = r12;
        return;
    L38:
        r10.f2277e.f2298b0 = r12;
        return;
    L39:
        r10.f2277e.f2296a0 = r12;
        return;
    L40:
        r10.f2277e.Z = r12;
        return;
    L41:
        r10.f2277e.H = r12;
        return;
    L42:
        r10.f2277e.f2301d = r12;
        return;
    L43:
        r10.f2275c.f2354b = r12;
        return;
    L44:
        r10.f2277e.f2303e = r12;
        return;
    L45:
        r10.f2277e.f2328q0 = r12;
        return;
    L46:
        r10.f2277e.U = r12;
        return;
    L47:
        r10.f2277e.N = r12;
        return;
    L48:
        r10.f2275c.f2355c = r12;
        return;
    L49:
        r10.f2276d.f2343e = r12;
        return;
    L50:
        r10.f2276d.f2344f = r12;
        return;
    L51:
        r10.f2276d.f2340b = r12;
        return;
    L52:
        r10.f2273a = r12;
        return;
    L53:
        r10.f2277e.f2294J = r12;
        return;
    L54:
        r10.f2277e.M = r12;
        return;
    L55:
        r10.f2277e.f2307g = r12;
        return;
    L56:
        r10.f2277e.f2305f = r12;
        return;
    L57:
        r10.f2277e.P = r12;
        return;
    L58:
        r10.f2277e.T = r12;
        return;
    L59:
        r10.f2277e.Q = r12;
        return;
    L60:
        r10.f2277e.O = r12;
        return;
    L61:
        r10.f2277e.S = r12;
        return;
    L62:
        r10.f2277e.R = r12;
        return;
    L63:
        r10.f2277e.K = r12;
        return;
    L64:
        r10.f2277e.f2312i0 = r12;
    }

    public static void U(a r10, int r11, String r12) {
        if (r11 != 5) goto L5;
        r10.f2277e.A = r12;
        return;
    L5:
        if (r11 != 65) goto L7;
        r10.f2276d.f2342d = r12;
        return;
    L7:
        if (r11 != 74) goto L9;
        b r13 = r10.f2277e;
        r13.f2318l0 = r12;
        r13.f2316k0 = null;
        return;
    L9:
        if (r11 != 77) goto L11;
        r10.f2277e.f2320m0 = r12;
        return;
    L11:
        if (r11 != 87) goto L13;
        return;
    L13:
        if (r11 == 90) goto L15;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L15:
        r10.f2276d.f2350l = r12;
    }

    public static void V(a r10, int r11, boolean r12) {
        if (r11 != 44) goto L5;
        r10.f2278f.f2371m = r12;
        return;
    L5:
        if (r11 != 75) goto L7;
        r10.f2277e.f2326p0 = r12;
        return;
    L7:
        if (r11 != 87) goto L9;
        return;
    L9:
        if (r11 != 80) goto L11;
        r10.f2277e.f2322n0 = r12;
        return;
    L11:
        if (r11 == 81) goto L13;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L13:
        r10.f2277e.f2324o0 = r12;
    }

    public static /* synthetic */ int a(TypedArray r10, int r11, int r12) {
        return K(r10, r11, r12);
    }

    public static /* synthetic */ int[] b() {
        return f2263h;
    }

    public static /* synthetic */ void c(a r10, int r11, int r12) {
        T(r10, r11, r12);
    }

    public static /* synthetic */ void d(a r10, int r11, float r12) {
        S(r10, r11, r12);
    }

    public static /* synthetic */ void e(a r10, int r11, String r12) {
        U(r10, r11, r12);
    }

    public static /* synthetic */ void f(a r10, int r11, boolean r12) {
        V(r10, r11, r12);
    }

    public static a m(Context r10, XmlPullParser r11) {
        AttributeSet r12 = Xml.asAttributeSet(r11);
        a r13 = new a();
        TypedArray r14 = r10.obtainStyledAttributes(r12, R$styleable.ConstraintOverride);
        P(r10, r13, r14);
        r14.recycle();
        return r13;
    }

    public final a A(int r10) {
        if (this.f2272g.containsKey(Integer.valueOf(r10)) == true) goto L6;
        this.f2272g.put(Integer.valueOf(r10), new a());
    L6:
        return (a) this.f2272g.get(Integer.valueOf(r10));
    }

    public a B(int r10) {
        if (this.f2272g.containsKey(Integer.valueOf(r10)) == true) goto L5;
        return null;
    L5:
        return (a) this.f2272g.get(Integer.valueOf(r10));
    }

    public int C(int r10) {
        return A(r10).f2277e.f2303e;
    }

    public int[] D() {
        int r10 = 0;
        Integer[] r11 = (Integer[]) this.f2272g.keySet().toArray(new Integer[0]);
        int r12 = r11.length;
        int[] r13 = new int[r12];
    L3:
        if (r10 >= r12) goto L5;
        r13[r10] = r11[r10].intValue();
        r10 = r10 + 1;
        goto L3
    L5:
        return r13;
    }

    public a E(int r10) {
        return A(r10);
    }

    public int F(int r10) {
        return A(r10).f2275c.f2354b;
    }

    public int G(int r10) {
        return A(r10).f2275c.f2355c;
    }

    public int H(int r10) {
        return A(r10).f2277e.f2301d;
    }

    public void I(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L5:
        if (r13 == 1) goto L32;
        if (r13 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L19:
        r13 = r12.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L8:
        if (r13 != 2) goto L19;
        String r14 = r12.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        a r15 = z(r10, Xml.asAttributeSet(r12), false);     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r14.equalsIgnoreCase("Guideline") == false) goto L17;
        r15.f2277e.f2295a = true;     // Catch: IOException -> L13 XmlPullParserException -> L15
    L17:
        this.f2272g.put(Integer.valueOf(r15.f2273a), r15);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L19
    L32:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public void J(Context r10, XmlPullParser r11) {
        int r12 = r11.getEventType();     // Catch: IOException -> L16 XmlPullParserException -> L18
        a r13 = null;
    L4:
        if (r12 == 1) goto L125;
        if (r12 == 0) goto L96;
        byte r14 = -1;
        if (r12 == 2) goto L36;
        if (r12 != 3) goto L97;
        String r15 = r11.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L16 XmlPullParserException -> L18
        switch(r15.hashCode()) {
            case -2075718416: goto L27;
            case -190376483: goto L24;
            case 426575017: goto L21;
            case 2146106725: goto L14;
            default: goto L29;
        };     // Catch: IOException -> L16 XmlPullParserException -> L18
    L29:
        if (r14 == 0) goto L35;
        if (r14 == 1) goto L34;
        if (r14 == 2) goto L34;
        if (r14 != 3) goto L97;
    L34:
        this.f2272g.put(Integer.valueOf(r13.f2273a), r13);     // Catch: IOException -> L16 XmlPullParserException -> L18
        r13 = null;
        goto L97
    L35:
        return;
    L14:
        if (r15.equals("constraintset") == false) goto L29;
        r14 = 0;
        goto L29
    L21:
        if (r15.equals("constraintoverride") == false) goto L29;
        r14 = 2;
        goto L29
    L24:
        if (r15.equals("constraint") == false) goto L29;
        r14 = 1;
        goto L29
    L27:
        if (r15.equals("guideline") == false) goto L29;
        r14 = 3;
    L97:
        r12 = r11.next();     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L4
    L36:
        String r16 = r11.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
        switch(r16.hashCode()) {
            case -2025855158: goto L67;
            case -1984451626: goto L64;
            case -1962203927: goto L61;
            case -1269513683: goto L58;
            case -1238332596: goto L55;
            case -71750448: goto L52;
            case 366511058: goto L49;
            case 1331510167: goto L46;
            case 1791837707: goto L43;
            case 1803088381: goto L40;
            default: goto L70;
        };     // Catch: IOException -> L16 XmlPullParserException -> L18
    L70:
        switch(r14) {
            case 0: goto L95;
            case 1: goto L94;
            case 2: goto L93;
            case 3: goto L92;
            case 4: goto L88;
            case 5: goto L84;
            case 6: goto L80;
            case 7: goto L76;
            case 8: goto L72;
            case 9: goto L72;
            default: goto L97;
        };
    L72:
        if (r13 == null) goto L75;
        ConstraintAttribute.h(r10, r11, r13.f2279g);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L75:
        throw new RuntimeException("XML parser error must be within a Constraint " + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L76:
        if (r13 == null) goto L79;
        r13.f2276d.b(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L79:
        throw new RuntimeException("XML parser error must be within a Constraint " + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L80:
        if (r13 == null) goto L83;
        r13.f2277e.b(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L83:
        throw new RuntimeException("XML parser error must be within a Constraint " + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L84:
        if (r13 == null) goto L87;
        r13.f2278f.b(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L87:
        throw new RuntimeException("XML parser error must be within a Constraint " + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L88:
        if (r13 == null) goto L91;
        r13.f2275c.b(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L91:
        throw new RuntimeException("XML parser error must be within a Constraint " + r11.getLineNumber());     // Catch: IOException -> L16 XmlPullParserException -> L18
    L92:
        r13 = z(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L16 XmlPullParserException -> L18
        r13.f2277e.f2314j0 = 1;     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L93:
        r13 = z(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L16 XmlPullParserException -> L18
        b r17 = r13.f2277e;     // Catch: IOException -> L16 XmlPullParserException -> L18
        r17.f2295a = true;     // Catch: IOException -> L16 XmlPullParserException -> L18
        r17.f2297b = true;     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L94:
        r13 = z(r10, Xml.asAttributeSet(r11), true);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L95:
        r13 = z(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L40:
        if (r16.equals("Constraint") == false) goto L70;
        r14 = 0;
        goto L70
    L43:
        if (r16.equals("CustomAttribute") == false) goto L70;
        r14 = 8;
        goto L70
    L46:
        if (r16.equals("Barrier") == false) goto L70;
        r14 = 3;
        goto L70
    L49:
        if (r16.equals("CustomMethod") == false) goto L70;
        r14 = 9;
        goto L70
    L52:
        if (r16.equals("Guideline") == false) goto L70;
        r14 = 2;
        goto L70
    L55:
        if (r16.equals("Transform") == false) goto L70;
        r14 = 5;
        goto L70
    L58:
        if (r16.equals("PropertySet") == false) goto L70;
        r14 = 4;
        goto L70
    L61:
        if (r16.equals("ConstraintOverride") == false) goto L70;
        r14 = 1;
        goto L70
    L64:
        if (r16.equals("Motion") == false) goto L70;
        r14 = 7;
        goto L70
    L67:
        if (r16.equals("Layout") == false) goto L70;
        r14 = 6;
        goto L70
    L96:
        r11.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L97
    L125:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public final void O(Context r10, a r11, TypedArray r12, boolean r13) {
        if (r13 == false) goto L5;
        P(r10, r11, r12);
        return;
    L5:
        int r14 = r12.getIndexCount();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L125;
        int r16 = r12.getIndex(r15);
        if (r16 == R$styleable.Constraint_android_id) goto L15;
        if (R$styleable.Constraint_android_layout_marginStart == r16) goto L15;
        if (R$styleable.Constraint_android_layout_marginEnd == r16) goto L15;
        r11.f2276d.f2339a = true;
        r11.f2277e.f2297b = true;
        r11.f2275c.f2353a = true;
        r11.f2278f.f2359a = true;
    L15:
        switch(f2264i.get(r16)) {
            case 1: goto L123;
            case 2: goto L122;
            case 3: goto L121;
            case 4: goto L120;
            case 5: goto L119;
            case 6: goto L118;
            case 7: goto L117;
            case 8: goto L116;
            case 9: goto L115;
            case 10: goto L114;
            case 11: goto L113;
            case 12: goto L112;
            case 13: goto L111;
            case 14: goto L110;
            case 15: goto L109;
            case 16: goto L108;
            case 17: goto L107;
            case 18: goto L106;
            case 19: goto L105;
            case 20: goto L104;
            case 21: goto L103;
            case 22: goto L102;
            case 23: goto L101;
            case 24: goto L100;
            case 25: goto L99;
            case 26: goto L98;
            case 27: goto L97;
            case 28: goto L96;
            case 29: goto L95;
            case 30: goto L94;
            case 31: goto L93;
            case 32: goto L92;
            case 33: goto L91;
            case 34: goto L90;
            case 35: goto L89;
            case 36: goto L88;
            case 37: goto L87;
            case 38: goto L86;
            case 39: goto L85;
            case 40: goto L84;
            case 41: goto L83;
            case 42: goto L82;
            case 43: goto L81;
            case 44: goto L80;
            case 45: goto L79;
            case 46: goto L78;
            case 47: goto L77;
            case 48: goto L76;
            case 49: goto L75;
            case 50: goto L74;
            case 51: goto L73;
            case 52: goto L72;
            case 53: goto L71;
            case 54: goto L70;
            case 55: goto L69;
            case 56: goto L68;
            case 57: goto L67;
            case 58: goto L66;
            case 59: goto L65;
            case 60: goto L64;
            case 61: goto L63;
            case 62: goto L62;
            case 63: goto L61;
            case 64: goto L60;
            case 65: goto L57;
            case 66: goto L55;
            case 67: goto L54;
            case 68: goto L53;
            case 69: goto L52;
            case 70: goto L51;
            case 71: goto L50;
            case 72: goto L49;
            case 73: goto L48;
            case 74: goto L47;
            case 75: goto L46;
            case 76: goto L45;
            case 77: goto L44;
            case 78: goto L43;
            case 79: goto L42;
            case 80: goto L41;
            case 81: goto L40;
            case 82: goto L39;
            case 83: goto L38;
            case 84: goto L37;
            case 85: goto L36;
            case 86: goto L25;
            case 87: goto L24;
            case 88: goto L16;
            case 89: goto L16;
            case 90: goto L16;
            case 91: goto L23;
            case 92: goto L22;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            default: goto L16;
        };
    L16:
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r16) + "   " + f2264i.get(r16));
    L124:
        r15 = r15 + 1;
        goto L6
    L17:
        b r17 = r11.f2277e;
        r17.f2328q0 = r12.getInt(r16, r17.f2328q0);
        goto L124
    L18:
        L(r11.f2277e, r12, r16, 1);
        goto L124
    L19:
        L(r11.f2277e, r12, r16, 0);
        goto L124
    L20:
        b r18 = r11.f2277e;
        r18.U = r12.getDimensionPixelSize(r16, r18.U);
        goto L124
    L21:
        b r19 = r11.f2277e;
        r19.N = r12.getDimensionPixelSize(r16, r19.N);
        goto L124
    L22:
        b r20 = r11.f2277e;
        r20.f2331t = K(r12, r16, r20.f2331t);
        goto L124
    L23:
        b r21 = r11.f2277e;
        r21.f2330s = K(r12, r16, r21.f2330s);
        goto L124
    L24:
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r16) + "   " + f2264i.get(r16));
        goto L124
    L25:
        int r22 = r12.peekValue(r16).type;
        if (r22 != 1) goto L30;
        r11.f2276d.f2352n = r12.getResourceId(r16, -1);
        c r23 = r11.f2276d;
        if (r23.f2352n == (-1)) goto L124;
        r23.f2351m = -2;
        goto L124
    L30:
        if (r22 != 3) goto L35;
        r11.f2276d.f2350l = r12.getString(r16);
        if (r11.f2276d.f2350l.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L34;
        r11.f2276d.f2352n = r12.getResourceId(r16, -1);
        r11.f2276d.f2351m = -2;
        goto L124
    L34:
        r11.f2276d.f2351m = -1;
        goto L124
    L35:
        c r24 = r11.f2276d;
        r24.f2351m = r12.getInteger(r16, r24.f2352n);
        goto L124
    L36:
        c r25 = r11.f2276d;
        r25.f2348j = r12.getFloat(r16, r25.f2348j);
        goto L124
    L37:
        c r26 = r11.f2276d;
        r26.f2349k = r12.getInteger(r16, r26.f2349k);
        goto L124
    L38:
        e r27 = r11.f2278f;
        r27.f2367i = K(r12, r16, r27.f2367i);
        goto L124
    L39:
        c r28 = r11.f2276d;
        r28.f2341c = r12.getInteger(r16, r28.f2341c);
        goto L124
    L40:
        b r29 = r11.f2277e;
        r29.f2324o0 = r12.getBoolean(r16, r29.f2324o0);
        goto L124
    L41:
        b r30 = r11.f2277e;
        r30.f2322n0 = r12.getBoolean(r16, r30.f2322n0);
        goto L124
    L42:
        c r31 = r11.f2276d;
        r31.f2345g = r12.getFloat(r16, r31.f2345g);
        goto L124
    L43:
        d r32 = r11.f2275c;
        r32.f2355c = r12.getInt(r16, r32.f2355c);
        goto L124
    L44:
        r11.f2277e.f2320m0 = r12.getString(r16);
        goto L124
    L45:
        c r33 = r11.f2276d;
        r33.f2343e = r12.getInt(r16, r33.f2343e);
        goto L124
    L46:
        b r34 = r11.f2277e;
        r34.f2326p0 = r12.getBoolean(r16, r34.f2326p0);
        goto L124
    L47:
        r11.f2277e.f2318l0 = r12.getString(r16);
        goto L124
    L48:
        b r35 = r11.f2277e;
        r35.f2312i0 = r12.getDimensionPixelSize(r16, r35.f2312i0);
        goto L124
    L49:
        b r36 = r11.f2277e;
        r36.f2310h0 = r12.getInt(r16, r36.f2310h0);
        goto L124
    L50:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L124
    L51:
        r11.f2277e.f2308g0 = r12.getFloat(r16, 1.0f);
        goto L124
    L52:
        r11.f2277e.f2306f0 = r12.getFloat(r16, 1.0f);
        goto L124
    L53:
        d r37 = r11.f2275c;
        r37.f2357e = r12.getFloat(r16, r37.f2357e);
        goto L124
    L54:
        c r38 = r11.f2276d;
        r38.f2347i = r12.getFloat(r16, r38.f2347i);
        goto L124
    L55:
        r11.f2276d.f2344f = r12.getInt(r16, 0);
        goto L124
    L60:
        c r39 = r11.f2276d;
        r39.f2340b = K(r12, r16, r39.f2340b);
        goto L124
    L61:
        b r40 = r11.f2277e;
        r40.D = r12.getFloat(r16, r40.D);
        goto L124
    L62:
        b r41 = r11.f2277e;
        r41.C = r12.getDimensionPixelSize(r16, r41.C);
        goto L124
    L63:
        b r42 = r11.f2277e;
        r42.B = K(r12, r16, r42.B);
        goto L124
    L64:
        e r43 = r11.f2278f;
        r43.f2360b = r12.getFloat(r16, r43.f2360b);
        goto L124
    L65:
        b r44 = r11.f2277e;
        r44.f2304e0 = r12.getDimensionPixelSize(r16, r44.f2304e0);
        goto L124
    L66:
        b r45 = r11.f2277e;
        r45.f2302d0 = r12.getDimensionPixelSize(r16, r45.f2302d0);
        goto L124
    L67:
        b r46 = r11.f2277e;
        r46.f2300c0 = r12.getDimensionPixelSize(r16, r46.f2300c0);
        goto L124
    L68:
        b r47 = r11.f2277e;
        r47.f2298b0 = r12.getDimensionPixelSize(r16, r47.f2298b0);
        goto L124
    L69:
        b r48 = r11.f2277e;
        r48.f2296a0 = r12.getInt(r16, r48.f2296a0);
        goto L124
    L70:
        b r49 = r11.f2277e;
        r49.Z = r12.getInt(r16, r49.Z);
        goto L124
    L71:
        e r50 = r11.f2278f;
        r50.f2370l = r12.getDimension(r16, r50.f2370l);
        goto L124
    L72:
        e r51 = r11.f2278f;
        r51.f2369k = r12.getDimension(r16, r51.f2369k);
        goto L124
    L73:
        e r52 = r11.f2278f;
        r52.f2368j = r12.getDimension(r16, r52.f2368j);
        goto L124
    L74:
        e r53 = r11.f2278f;
        r53.f2366h = r12.getDimension(r16, r53.f2366h);
        goto L124
    L75:
        e r54 = r11.f2278f;
        r54.f2365g = r12.getDimension(r16, r54.f2365g);
        goto L124
    L76:
        e r55 = r11.f2278f;
        r55.f2364f = r12.getFloat(r16, r55.f2364f);
        goto L124
    L77:
        e r56 = r11.f2278f;
        r56.f2363e = r12.getFloat(r16, r56.f2363e);
        goto L124
    L78:
        e r57 = r11.f2278f;
        r57.f2362d = r12.getFloat(r16, r57.f2362d);
        goto L124
    L79:
        e r58 = r11.f2278f;
        r58.f2361c = r12.getFloat(r16, r58.f2361c);
        goto L124
    L80:
        e r59 = r11.f2278f;
        r59.f2371m = true;
        r59.f2372n = r12.getDimension(r16, r59.f2372n);
        goto L124
    L81:
        d r60 = r11.f2275c;
        r60.f2356d = r12.getFloat(r16, r60.f2356d);
        goto L124
    L82:
        b r61 = r11.f2277e;
        r61.Y = r12.getInt(r16, r61.Y);
        goto L124
    L83:
        b r62 = r11.f2277e;
        r62.X = r12.getInt(r16, r62.X);
        goto L124
    L84:
        b r63 = r11.f2277e;
        r63.V = r12.getFloat(r16, r63.V);
        goto L124
    L85:
        b r64 = r11.f2277e;
        r64.W = r12.getFloat(r16, r64.W);
        goto L124
    L86:
        r11.f2273a = r12.getResourceId(r16, r11.f2273a);
        goto L124
    L87:
        b r65 = r11.f2277e;
        r65.f2337z = r12.getFloat(r16, r65.f2337z);
        goto L124
    L88:
        b r66 = r11.f2277e;
        r66.f2321n = K(r12, r16, r66.f2321n);
        goto L124
    L89:
        b r67 = r11.f2277e;
        r67.f2323o = K(r12, r16, r67.f2323o);
        goto L124
    L90:
        b r68 = r11.f2277e;
        r68.f2294J = r12.getDimensionPixelSize(r16, r68.f2294J);
        goto L124
    L91:
        b r69 = r11.f2277e;
        r69.f2333v = K(r12, r16, r69.f2333v);
        goto L124
    L92:
        b r70 = r11.f2277e;
        r70.f2332u = K(r12, r16, r70.f2332u);
        goto L124
    L93:
        b r71 = r11.f2277e;
        r71.M = r12.getDimensionPixelSize(r16, r71.M);
        goto L124
    L94:
        b r72 = r11.f2277e;
        r72.f2319m = K(r12, r16, r72.f2319m);
        goto L124
    L95:
        b r73 = r11.f2277e;
        r73.f2317l = K(r12, r16, r73.f2317l);
        goto L124
    L96:
        b r74 = r11.f2277e;
        r74.I = r12.getDimensionPixelSize(r16, r74.I);
        goto L124
    L97:
        b r75 = r11.f2277e;
        r75.G = r12.getInt(r16, r75.G);
        goto L124
    L98:
        b r76 = r11.f2277e;
        r76.f2315k = K(r12, r16, r76.f2315k);
        goto L124
    L99:
        b r77 = r11.f2277e;
        r77.f2313j = K(r12, r16, r77.f2313j);
        goto L124
    L100:
        b r78 = r11.f2277e;
        r78.H = r12.getDimensionPixelSize(r16, r78.H);
        goto L124
    L101:
        b r79 = r11.f2277e;
        r79.f2301d = r12.getLayoutDimension(r16, r79.f2301d);
        goto L124
    L102:
        d r80 = r11.f2275c;
        r80.f2354b = r12.getInt(r16, r80.f2354b);
        d r81 = r11.f2275c;
        r81.f2354b = f2263h[r81.f2354b];
        goto L124
    L103:
        b r82 = r11.f2277e;
        r82.f2303e = r12.getLayoutDimension(r16, r82.f2303e);
        goto L124
    L104:
        b r83 = r11.f2277e;
        r83.f2336y = r12.getFloat(r16, r83.f2336y);
        goto L124
    L105:
        b r84 = r11.f2277e;
        r84.f2309h = r12.getFloat(r16, r84.f2309h);
        goto L124
    L106:
        b r85 = r11.f2277e;
        r85.f2307g = r12.getDimensionPixelOffset(r16, r85.f2307g);
        goto L124
    L107:
        b r86 = r11.f2277e;
        r86.f2305f = r12.getDimensionPixelOffset(r16, r86.f2305f);
        goto L124
    L108:
        b r87 = r11.f2277e;
        r87.P = r12.getDimensionPixelSize(r16, r87.P);
        goto L124
    L109:
        b r88 = r11.f2277e;
        r88.T = r12.getDimensionPixelSize(r16, r88.T);
        goto L124
    L110:
        b r89 = r11.f2277e;
        r89.Q = r12.getDimensionPixelSize(r16, r89.Q);
        goto L124
    L111:
        b r90 = r11.f2277e;
        r90.O = r12.getDimensionPixelSize(r16, r90.O);
        goto L124
    L112:
        b r91 = r11.f2277e;
        r91.S = r12.getDimensionPixelSize(r16, r91.S);
        goto L124
    L113:
        b r92 = r11.f2277e;
        r92.R = r12.getDimensionPixelSize(r16, r92.R);
        goto L124
    L114:
        b r93 = r11.f2277e;
        r93.f2334w = K(r12, r16, r93.f2334w);
        goto L124
    L115:
        b r94 = r11.f2277e;
        r94.f2335x = K(r12, r16, r94.f2335x);
        goto L124
    L116:
        b r95 = r11.f2277e;
        r95.L = r12.getDimensionPixelSize(r16, r95.L);
        goto L124
    L117:
        b r96 = r11.f2277e;
        r96.F = r12.getDimensionPixelOffset(r16, r96.F);
        goto L124
    L118:
        b r97 = r11.f2277e;
        r97.E = r12.getDimensionPixelOffset(r16, r97.E);
        goto L124
    L119:
        r11.f2277e.A = r12.getString(r16);
        goto L124
    L120:
        b r98 = r11.f2277e;
        r98.f2325p = K(r12, r16, r98.f2325p);
        goto L124
    L121:
        b r99 = r11.f2277e;
        r99.f2327q = K(r12, r16, r99.f2327q);
        goto L124
    L122:
        b r100 = r11.f2277e;
        r100.K = r12.getDimensionPixelSize(r16, r100.K);
        goto L124
    L123:
        b r101 = r11.f2277e;
        r101.f2329r = K(r12, r16, r101.f2329r);
        goto L124
    L57:
        if (r12.peekValue(r16).type != 3) goto L59;
        r11.f2276d.f2342d = r12.getString(r16);
        goto L124
    L59:
        r11.f2276d.f2342d = p001j.c.f20781c[r12.getInteger(r16, 0)];
        goto L124
    L125:
        b r102 = r11.f2277e;
        if (r102.f2318l0 == null) goto L230;
        r102.f2316k0 = null;
        return;
    }

    public void Q(ConstraintLayout r11) {
        int r10 = r11.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L39;
        View r13 = r11.getChildAt(r12);
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.f2271f == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.f2272g.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.f2272g.put(Integer.valueOf(r15), new a());
    L14:
        a r16 = (a) this.f2272g.get(Integer.valueOf(r15));
        if (r16 == null) goto L38;
        if (r16.f2277e.f2297b == true) goto L25;
        a.a(r16, r15, r14);
        if ((r13 instanceof ConstraintHelper) == false) goto L24;
        r16.f2277e.f2316k0 = ((ConstraintHelper) r13).getReferencedIds();
        if ((r13 instanceof Barrier) == false) goto L24;
        Barrier r17 = (Barrier) r13;
        r16.f2277e.f2326p0 = r17.getAllowsGoneWidget();
        r16.f2277e.f2310h0 = r17.getType();
        r16.f2277e.f2312i0 = r17.getMargin();
    L24:
        r16.f2277e.f2297b = true;
    L25:
        d r18 = r16.f2275c;
        if (r18.f2353a == true) goto L28;
        r18.f2354b = r13.getVisibility();
        r16.f2275c.f2356d = r13.getAlpha();
        r16.f2275c.f2353a = true;
    L28:
        e r19 = r16.f2278f;
        if (r19.f2359a == true) goto L38;
        r19.f2359a = true;
        r19.f2360b = r13.getRotation();
        r16.f2278f.f2361c = r13.getRotationX();
        r16.f2278f.f2362d = r13.getRotationY();
        r16.f2278f.f2363e = r13.getScaleX();
        r16.f2278f.f2364f = r13.getScaleY();
        float r20 = r13.getPivotX();
        float r21 = r13.getPivotY();
        if (r20 == 0.0d) goto L33;
    L34:
        e r22 = r16.f2278f;
        r22.f2365g = r20;
        r22.f2366h = r21;
    L35:
        r16.f2278f.f2368j = r13.getTranslationX();
        r16.f2278f.f2369k = r13.getTranslationY();
        r16.f2278f.f2370l = r13.getTranslationZ();
        e r23 = r16.f2278f;
        if (r23.f2371m == false) goto L38;
        r23.f2372n = r13.getElevation();
        goto L38
    L33:
        if (r21 == 0.0d) goto L35;
    L38:
        r12 = r12 + 1;
        goto L3
    }

    public void R(ConstraintSet r10) {
        Iterator r11 = r10.f2272g.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L29;
        Integer r12 = (Integer) r11.next();
        r12.intValue();
        a r13 = (a) r10.f2272g.get(r12);
        if (this.f2272g.containsKey(r12) == true) goto L8;
        this.f2272g.put(r12, new a());
    L8:
        a r14 = (a) this.f2272g.get(r12);
        if (r14 == null) goto L4;
        b r15 = r14.f2277e;
        if (r15.f2297b == true) goto L14;
        r15.a(r13.f2277e);
    L14:
        d r16 = r14.f2275c;
        if (r16.f2353a == true) goto L17;
        r16.a(r13.f2275c);
    L17:
        e r17 = r14.f2278f;
        if (r17.f2359a == true) goto L20;
        r17.a(r13.f2278f);
    L20:
        c r18 = r14.f2276d;
        if (r18.f2339a == true) goto L23;
        r18.a(r13.f2276d);
    L23:
        Iterator r19 = r13.f2279g.keySet().iterator();
    L25:
        if (r19.hasNext() == false) goto L4;
        String r20 = (String) r19.next();
        if (r14.f2279g.containsKey(r20) == true) goto L25;
        r14.f2279g.put(r20, (ConstraintAttribute) r13.f2279g.get(r20));
        goto L25
    }

    public void W(int r10, int r11) {
        A(r10).f2277e.E = r11;
    }

    public void X(int r10, int r11) {
        A(r10).f2277e.F = r11;
    }

    public void Y(boolean r10) {
        this.f2271f = r10;
    }

    public void Z(int r10, int r11) {
        A(r10).f2277e.f2307g = r11;
        A(r10).f2277e.f2305f = -1;
        A(r10).f2277e.f2309h = -1.0f;
    }

    public void a0(int r10, float r11) {
        A(r10).f2277e.f2336y = r11;
    }

    public void b0(int r10, int r11, int r12) {
        a r13 = A(r10);
        switch(r11) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r13.f2277e.L = r12;
        return;
    L7:
        r13.f2277e.M = r12;
        return;
    L8:
        r13.f2277e.N = r12;
        return;
    L9:
        r13.f2277e.K = r12;
        return;
    L10:
        r13.f2277e.f2294J = r12;
        return;
    L11:
        r13.f2277e.I = r12;
        return;
    L12:
        r13.f2277e.H = r12;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void c0(boolean r10) {
        this.f2266a = r10;
    }

    public void d0(int r10, float r11) {
        A(r10).f2277e.f2337z = r11;
    }

    public final String e0(int r10) {
        switch(r10) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "undefined";
    L5:
        return "end";
    L7:
        return "start";
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return "left";
    }

    public void g(ConstraintLayout r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L21;
        View r13 = r10.getChildAt(r12);
        int r14 = r13.getId();
        if (this.f2272g.containsKey(Integer.valueOf(r14)) == true) goto L8;
        Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(r13));
    L20:
        r12 = r12 + 1;
        goto L3
    L8:
        if (this.f2271f == false) goto L15;
        if (r14 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.f2272g.containsKey(Integer.valueOf(r14)) == false) goto L20;
        a r15 = (a) this.f2272g.get(Integer.valueOf(r14));
        if (r15 == null) goto L20;
        ConstraintAttribute.i(r13, r15.f2279g);
        goto L20
    }

    public void h(ConstraintSet r10) {
        Iterator r11 = r10.f2272g.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        a r12 = (a) r11.next();
        if (r12.f2280h == null) goto L4;
        if (r12.f2274b != null) goto L9;
        a r13 = B(r12.f2273a);
        r12.f2280h.e(r13);
        goto L4
    L9:
        Iterator r14 = this.f2272g.keySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L4;
        a r15 = B(((Integer) r14.next()).intValue());
        String r16 = r15.f2277e.f2320m0;
        if (r16 == null) goto L11;
        if (r12.f2274b.matches(r16) == false) goto L11;
        r12.f2280h.e(r15);
        r15.f2279g.putAll((HashMap) r12.f2279g.clone());
        goto L11
    }

    public void i(ConstraintLayout r10) {
        k(r10, true);
        r10.setConstraintSet(null);
        r10.requestLayout();
    }

    public void j(ConstraintHelper r10, ConstraintWidget r11, ConstraintLayout.LayoutParams r12, SparseArray r13) {
        int r14 = r10.getId();
        if (this.f2272g.containsKey(Integer.valueOf(r14)) == false) goto L10;
        a r15 = (a) this.f2272g.get(Integer.valueOf(r14));
        if (r15 != null) goto L7;
        return;
    L7:
        if ((r11 instanceof k.a) == false) goto L12;
        r10.l(r15, (k.a) r11, r12, r13);
        return;
    L12:
        return;
    }

    public void k(ConstraintLayout r12, boolean r13) {
        int r10 = r12.getChildCount();
        HashSet r11 = new HashSet(this.f2272g.keySet());
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r10) goto L55;
        View r16 = r12.getChildAt(r15);
        int r17 = r16.getId();
        if (this.f2272g.containsKey(Integer.valueOf(r17)) == true) goto L9;
        Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(r16));
    L54:
        r15 = r15 + 1;
        goto L4
    L9:
        if (this.f2271f == false) goto L14;
        if (r17 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r17 == (-1)) goto L54;
        if (this.f2272g.containsKey(Integer.valueOf(r17)) == false) goto L53;
        r11.remove(Integer.valueOf(r17));
        a r18 = (a) this.f2272g.get(Integer.valueOf(r17));
        if (r18 == null) goto L54;
        if ((r16 instanceof Barrier) == false) goto L29;
        r18.f2277e.f2314j0 = 1;
        Barrier r19 = (Barrier) r16;
        r19.setId(r17);
        r19.setType(r18.f2277e.f2310h0);
        r19.setMargin(r18.f2277e.f2312i0);
        r19.setAllowsGoneWidget(r18.f2277e.f2326p0);
        b r20 = r18.f2277e;
        int[] r21 = r20.f2316k0;
        if (r21 == null) goto L26;
        r19.setReferencedIds(r21);
        goto L29
    L26:
        String r22 = r20.f2318l0;
        if (r22 == null) goto L29;
        r20.f2316k0 = y(r19, r22);
        r19.setReferencedIds(r18.f2277e.f2316k0);
    L29:
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r16.getLayoutParams();
        r23.c();
        r18.e(r23);
        if (r13 == false) goto L32;
        ConstraintAttribute.i(r16, r18.f2279g);
    L32:
        r16.setLayoutParams(r23);
        d r24 = r18.f2275c;
        if (r24.f2355c != 0) goto L35;
        r16.setVisibility(r24.f2354b);
    L35:
        r16.setAlpha(r18.f2275c.f2356d);
        r16.setRotation(r18.f2278f.f2360b);
        r16.setRotationX(r18.f2278f.f2361c);
        r16.setRotationY(r18.f2278f.f2362d);
        r16.setScaleX(r18.f2278f.f2363e);
        r16.setScaleY(r18.f2278f.f2364f);
        e r25 = r18.f2278f;
        if (r25.f2367i == (-1)) goto L45;
        View r26 = ((View) r16.getParent()).findViewById(r18.f2278f.f2367i);
        if (r26 == null) goto L50;
        float r27 = (r26.getTop() + r26.getBottom()) / 2.0f;
        float r28 = (r26.getLeft() + r26.getRight()) / 2.0f;
        if ((r16.getRight() - r16.getLeft()) <= 0) goto L50;
        if ((r16.getBottom() - r16.getTop()) <= 0) goto L50;
        float r29 = r28 - r16.getLeft();
        float r30 = r27 - r16.getTop();
        r16.setPivotX(r29);
        r16.setPivotY(r30);
    L50:
        r16.setTranslationX(r18.f2278f.f2368j);
        r16.setTranslationY(r18.f2278f.f2369k);
        r16.setTranslationZ(r18.f2278f.f2370l);
        e r31 = r18.f2278f;
        if (r31.f2371m == false) goto L54;
        r16.setElevation(r31.f2372n);
        goto L54
    L45:
        if (Float.isNaN(r25.f2365g) == true) goto L48;
        r16.setPivotX(r18.f2278f.f2365g);
    L48:
        if (Float.isNaN(r18.f2278f.f2366h) == true) goto L50;
        r16.setPivotY(r18.f2278f.f2366h);
        goto L50
    L53:
        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + r17);
        goto L54
    L55:
        Iterator r110 = r11.iterator();
    L57:
        if (r110.hasNext() == false) goto L73;
        Integer r32 = (Integer) r110.next();
        a r33 = (a) this.f2272g.get(r32);
        if (r33 == null) goto L57;
        if (r33.f2277e.f2314j0 != 1) goto L71;
        Barrier r34 = new Barrier(r12.getContext());
        r34.setId(r32.intValue());
        b r35 = r33.f2277e;
        int[] r36 = r35.f2316k0;
        if (r36 == null) goto L66;
        r34.setReferencedIds(r36);
    L69:
        r34.setType(r33.f2277e.f2310h0);
        r34.setMargin(r33.f2277e.f2312i0);
        ConstraintLayout.LayoutParams r37 = r12.generateDefaultLayoutParams();
        r34.s();
        r33.e(r37);
        r12.addView(r34, r37);
        goto L71
    L66:
        String r38 = r35.f2318l0;
        if (r38 == null) goto L69;
        r35.f2316k0 = y(r34, r38);
        r34.setReferencedIds(r33.f2277e.f2316k0);
    L71:
        if (r33.f2277e.f2295a == false) goto L57;
        View r39 = new Guideline(r12.getContext());
        r39.setId(r32.intValue());
        ConstraintLayout.LayoutParams r40 = r12.generateDefaultLayoutParams();
        r33.e(r40);
        r12.addView(r39, r40);
    L73:
        if (r14 >= r10) goto L78;
        View r111 = r12.getChildAt(r14);
        if ((r111 instanceof ConstraintHelper) == false) goto L77;
        ((ConstraintHelper) r111).f(r12);
    L77:
        r14 = r14 + 1;
        goto L73
    }

    public void l(int r10, ConstraintLayout.LayoutParams r11) {
        if (this.f2272g.containsKey(Integer.valueOf(r10)) == false) goto L8;
        a r12 = (a) this.f2272g.get(Integer.valueOf(r10));
        if (r12 == null) goto L9;
        r12.e(r11);
        return;
    L9:
        return;
    }

    public void n(int r10) {
        this.f2272g.remove(Integer.valueOf(r10));
    }

    public void o(int r10, int r11) {
        if (this.f2272g.containsKey(Integer.valueOf(r10)) == false) goto L20;
        a r12 = (a) this.f2272g.get(Integer.valueOf(r10));
        if (r12 != null) goto L8;
        return;
    L8:
        switch(r11) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        b r13 = r12.f2277e;
        r13.D = -1.0f;
        r13.C = -1;
        r13.B = -1;
        return;
    L12:
        b r14 = r12.f2277e;
        r14.f2334w = -1;
        r14.f2335x = -1;
        r14.L = 0;
        r14.S = Integer.MIN_VALUE;
        return;
    L13:
        b r15 = r12.f2277e;
        r15.f2332u = -1;
        r15.f2333v = -1;
        r15.M = 0;
        r15.T = Integer.MIN_VALUE;
        return;
    L14:
        b r16 = r12.f2277e;
        r16.f2329r = -1;
        r16.f2330s = -1;
        r16.f2331t = -1;
        r16.N = 0;
        r16.U = Integer.MIN_VALUE;
        return;
    L15:
        b r17 = r12.f2277e;
        r17.f2325p = -1;
        r17.f2327q = -1;
        r17.K = 0;
        r17.R = Integer.MIN_VALUE;
        return;
    L16:
        b r18 = r12.f2277e;
        r18.f2323o = -1;
        r18.f2321n = -1;
        r18.f2294J = 0;
        r18.P = Integer.MIN_VALUE;
        return;
    L17:
        b r19 = r12.f2277e;
        r19.f2319m = -1;
        r19.f2317l = -1;
        r19.I = -1;
        r19.Q = Integer.MIN_VALUE;
        return;
    L18:
        b r20 = r12.f2277e;
        r20.f2315k = -1;
        r20.f2313j = -1;
        r20.H = -1;
        r20.O = Integer.MIN_VALUE;
        return;
    L10:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void p(Context r10, int r11) {
        q((ConstraintLayout) LayoutInflater.from(r10).inflate(r11, null));
    }

    public void q(ConstraintLayout r11) {
        int r10 = r11.getChildCount();
        this.f2272g.clear();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L29;
        View r13 = r11.getChildAt(r12);
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.f2271f == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.f2272g.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.f2272g.put(Integer.valueOf(r15), new a());
    L14:
        a r16 = (a) this.f2272g.get(Integer.valueOf(r15));
        if (r16 == null) goto L28;
        r16.f2279g = ConstraintAttribute.a(this.f2270e, r13);
        a.a(r16, r15, r14);
        r16.f2275c.f2354b = r13.getVisibility();
        r16.f2275c.f2356d = r13.getAlpha();
        r16.f2278f.f2360b = r13.getRotation();
        r16.f2278f.f2361c = r13.getRotationX();
        r16.f2278f.f2362d = r13.getRotationY();
        r16.f2278f.f2363e = r13.getScaleX();
        r16.f2278f.f2364f = r13.getScaleY();
        float r17 = r13.getPivotX();
        float r18 = r13.getPivotY();
        if (r17 == 0.0d) goto L20;
    L21:
        e r19 = r16.f2278f;
        r19.f2365g = r17;
        r19.f2366h = r18;
    L22:
        r16.f2278f.f2368j = r13.getTranslationX();
        r16.f2278f.f2369k = r13.getTranslationY();
        r16.f2278f.f2370l = r13.getTranslationZ();
        e r20 = r16.f2278f;
        if (r20.f2371m == false) goto L26;
        r20.f2372n = r13.getElevation();
    L26:
        if ((r13 instanceof Barrier) == false) goto L28;
        Barrier r21 = (Barrier) r13;
        r16.f2277e.f2326p0 = r21.getAllowsGoneWidget();
        r16.f2277e.f2316k0 = r21.getReferencedIds();
        r16.f2277e.f2310h0 = r21.getType();
        r16.f2277e.f2312i0 = r21.getMargin();
        goto L28
    L20:
        if (r18 == 0.0d) goto L22;
    L28:
        r12 = r12 + 1;
        goto L3
    }

    public void r(ConstraintSet r10) {
        this.f2272g.clear();
        Iterator r11 = r10.f2272g.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Integer r12 = (Integer) r11.next();
        a r13 = (a) r10.f2272g.get(r12);
        if (r13 == null) goto L4;
        this.f2272g.put(r12, r13.f());
        goto L4
    }

    public void s(Constraints r10) {
        int r11 = r10.getChildCount();
        this.f2272g.clear();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L22;
        View r13 = r10.getChildAt(r12);
        Constraints.LayoutParams r14 = (Constraints.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.f2271f == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.f2272g.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.f2272g.put(Integer.valueOf(r15), new a());
    L14:
        a r16 = (a) this.f2272g.get(Integer.valueOf(r15));
        if (r16 == null) goto L21;
        if ((r13 instanceof ConstraintHelper) == false) goto L20;
        a.b(r16, (ConstraintHelper) r13, r15, r14);
    L20:
        a.c(r16, r15, r14);
    L21:
        r12 = r12 + 1;
        goto L3
    }

    public void t(int r10, int r11, int r12, int r13) {
        if (this.f2272g.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.f2272g.put(Integer.valueOf(r10), new a());
    L5:
        a r14 = (a) this.f2272g.get(Integer.valueOf(r10));
        if (r14 != null) goto L9;
        return;
    L9:
        switch(r11) {
            case 1: goto L51;
            case 2: goto L45;
            case 3: goto L39;
            case 4: goto L33;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        b r15 = r14.f2277e;
        r15.f2335x = r12;
        r15.f2334w = -1;
        return;
    L14:
        if (r13 != 6) goto L17;
        b r16 = r14.f2277e;
        r16.f2334w = r12;
        r16.f2335x = -1;
        return;
    L17:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L18:
        if (r13 != 6) goto L20;
        b r17 = r14.f2277e;
        r17.f2333v = r12;
        r17.f2332u = -1;
        return;
    L20:
        if (r13 != 7) goto L23;
        b r18 = r14.f2277e;
        r18.f2332u = r12;
        r18.f2333v = -1;
        return;
    L23:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L33:
        if (r13 != 4) goto L35;
        b r19 = r14.f2277e;
        r19.f2327q = r12;
        r19.f2325p = -1;
        r19.f2329r = -1;
        r19.f2330s = -1;
        r19.f2331t = -1;
        return;
    L35:
        if (r13 != 3) goto L38;
        b r20 = r14.f2277e;
        r20.f2325p = r12;
        r20.f2327q = -1;
        r20.f2329r = -1;
        r20.f2330s = -1;
        r20.f2331t = -1;
        return;
    L38:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L39:
        if (r13 != 3) goto L41;
        b r21 = r14.f2277e;
        r21.f2321n = r12;
        r21.f2323o = -1;
        r21.f2329r = -1;
        r21.f2330s = -1;
        r21.f2331t = -1;
        return;
    L41:
        if (r13 != 4) goto L44;
        b r22 = r14.f2277e;
        r22.f2323o = r12;
        r22.f2321n = -1;
        r22.f2329r = -1;
        r22.f2330s = -1;
        r22.f2331t = -1;
        return;
    L44:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L45:
        if (r13 != 1) goto L47;
        b r23 = r14.f2277e;
        r23.f2317l = r12;
        r23.f2319m = -1;
        return;
    L47:
        if (r13 != 2) goto L50;
        b r24 = r14.f2277e;
        r24.f2319m = r12;
        r24.f2317l = -1;
        return;
    L50:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L51:
        if (r13 != 1) goto L53;
        b r25 = r14.f2277e;
        r25.f2313j = r12;
        r25.f2315k = -1;
        return;
    L53:
        if (r13 != 2) goto L57;
        b r26 = r14.f2277e;
        r26.f2315k = r12;
        r26.f2313j = -1;
        return;
    L57:
        throw new IllegalArgumentException("left to " + e0(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(e0(r11) + " to " + e0(r13) + " unknown");
    L25:
        if (r13 != 5) goto L27;
        b r27 = r14.f2277e;
        r27.f2329r = r12;
        r27.f2327q = -1;
        r27.f2325p = -1;
        r27.f2321n = -1;
        r27.f2323o = -1;
        return;
    L27:
        if (r13 != 3) goto L29;
        b r28 = r14.f2277e;
        r28.f2330s = r12;
        r28.f2327q = -1;
        r28.f2325p = -1;
        r28.f2321n = -1;
        r28.f2323o = -1;
        return;
    L29:
        if (r13 != 4) goto L32;
        b r29 = r14.f2277e;
        r29.f2331t = r12;
        r29.f2327q = -1;
        r29.f2325p = -1;
        r29.f2321n = -1;
        r29.f2323o = -1;
        return;
    L32:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    }

    public void u(int r10, int r11, int r12, int r13, int r14) {
        if (this.f2272g.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.f2272g.put(Integer.valueOf(r10), new a());
    L5:
        a r15 = (a) this.f2272g.get(Integer.valueOf(r10));
        if (r15 != null) goto L9;
        return;
    L9:
        switch(r11) {
            case 1: goto L56;
            case 2: goto L49;
            case 3: goto L42;
            case 4: goto L35;
            case 5: goto L27;
            case 6: goto L19;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        b r16 = r15.f2277e;
        r16.f2335x = r12;
        r16.f2334w = -1;
    L16:
        r15.f2277e.L = r14;
        return;
    L14:
        if (r13 != 6) goto L18;
        b r17 = r15.f2277e;
        r17.f2334w = r12;
        r17.f2335x = -1;
        goto L16
    L18:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L19:
        if (r13 != 6) goto L21;
        b r18 = r15.f2277e;
        r18.f2333v = r12;
        r18.f2332u = -1;
    L23:
        r15.f2277e.M = r14;
        return;
    L21:
        if (r13 != 7) goto L25;
        b r19 = r15.f2277e;
        r19.f2332u = r12;
        r19.f2333v = -1;
        goto L23
    L25:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L35:
        if (r13 != 4) goto L37;
        b r20 = r15.f2277e;
        r20.f2327q = r12;
        r20.f2325p = -1;
        r20.f2329r = -1;
        r20.f2330s = -1;
        r20.f2331t = -1;
    L39:
        r15.f2277e.K = r14;
        return;
    L37:
        if (r13 != 3) goto L41;
        b r21 = r15.f2277e;
        r21.f2325p = r12;
        r21.f2327q = -1;
        r21.f2329r = -1;
        r21.f2330s = -1;
        r21.f2331t = -1;
        goto L39
    L41:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L42:
        if (r13 != 3) goto L44;
        b r22 = r15.f2277e;
        r22.f2321n = r12;
        r22.f2323o = -1;
        r22.f2329r = -1;
        r22.f2330s = -1;
        r22.f2331t = -1;
    L46:
        r15.f2277e.f2294J = r14;
        return;
    L44:
        if (r13 != 4) goto L48;
        b r23 = r15.f2277e;
        r23.f2323o = r12;
        r23.f2321n = -1;
        r23.f2329r = -1;
        r23.f2330s = -1;
        r23.f2331t = -1;
        goto L46
    L48:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L49:
        if (r13 != 1) goto L51;
        b r24 = r15.f2277e;
        r24.f2317l = r12;
        r24.f2319m = -1;
    L53:
        r15.f2277e.I = r14;
        return;
    L51:
        if (r13 != 2) goto L55;
        b r25 = r15.f2277e;
        r25.f2319m = r12;
        r25.f2317l = -1;
        goto L53
    L55:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    L56:
        if (r13 != 1) goto L58;
        b r26 = r15.f2277e;
        r26.f2313j = r12;
        r26.f2315k = -1;
    L60:
        r15.f2277e.H = r14;
        return;
    L58:
        if (r13 != 2) goto L63;
        b r27 = r15.f2277e;
        r27.f2315k = r12;
        r27.f2313j = -1;
        goto L60
    L63:
        throw new IllegalArgumentException("Left to " + e0(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(e0(r11) + " to " + e0(r13) + " unknown");
    L27:
        if (r13 != 5) goto L29;
        b r28 = r15.f2277e;
        r28.f2329r = r12;
        r28.f2327q = -1;
        r28.f2325p = -1;
        r28.f2321n = -1;
        r28.f2323o = -1;
        return;
    L29:
        if (r13 != 3) goto L31;
        b r29 = r15.f2277e;
        r29.f2330s = r12;
        r29.f2327q = -1;
        r29.f2325p = -1;
        r29.f2321n = -1;
        r29.f2323o = -1;
        return;
    L31:
        if (r13 != 4) goto L34;
        b r30 = r15.f2277e;
        r30.f2331t = r12;
        r30.f2327q = -1;
        r30.f2325p = -1;
        r30.f2321n = -1;
        r30.f2323o = -1;
        return;
    L34:
        throw new IllegalArgumentException("right to " + e0(r13) + " undefined");
    }

    public void v(int r10, int r11, int r12, float r13) {
        b r14 = A(r10).f2277e;
        r14.B = r11;
        r14.C = r12;
        r14.D = r13;
    }

    public void w(int r10, int r11) {
        A(r10).f2277e.f2303e = r11;
    }

    public void x(int r10, int r11) {
        A(r10).f2277e.f2301d = r11;
    }

    public final int[] y(View r10, String r11) {
        String[] r12 = r11.split(",");
        Context r13 = r10.getContext();
        int[] r14 = new int[r12.length];
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r15 >= r12.length) goto L23;
        String r17 = r12[r15].trim();
        int r18 = R$id.class.getField(r17).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r18 != 0) goto L11;
        r18 = r13.getResources().getIdentifier(r17, "id", r13.getPackageName());
    L11:
        if (r18 != 0) goto L21;
        if (r10.isInEditMode() == false) goto L21;
        if ((r10.getParent() instanceof ConstraintLayout) == false) goto L21;
        Object r19 = ((ConstraintLayout) r10.getParent()).getDesignInformation(0, r17);
        if (r19 == null) goto L21;
        if ((r19 instanceof Integer) == false) goto L21;
        r18 = ((Integer) r19).intValue();
    L21:
        r14[r16] = r18;
        r15 = r15 + 1;
        r16 = r16 + 1;
    L8:
        r18 = 0;
        goto L9
    L23:
        if (r16 != r12.length) goto L25;
        return r14;
    L25:
        return Arrays.copyOf(r14, r16);
    }

    public final a z(Context r10, AttributeSet r11, boolean r12) {
        a r13 = new a();
        if (r12 == false) goto L5;
        int[] r14 = R$styleable.ConstraintOverride;
    L6:
        TypedArray r15 = r10.obtainStyledAttributes(r11, r14);
        O(r10, r13, r15, r12);
        r15.recycle();
        return r13;
    L5:
        r14 = R$styleable.Constraint;
        goto L6
    }
}

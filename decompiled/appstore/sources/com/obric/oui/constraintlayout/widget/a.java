package com.obric.oui.constraintlayout.widget;

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
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f14161i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static SparseIntArray f14162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static SparseIntArray f14163k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f14165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f14166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String[] f14167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f14169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap f14171h;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.a$a, reason: collision with other inner class name */
    public static class C0195a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f14173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f14174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f14175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f14176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f14177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap f14178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C0196a f14179h;

        /* JADX INFO: renamed from: com.obric.oui.constraintlayout.widget.a$a$a, reason: collision with other inner class name */
        public static class C0196a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f14180a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f14181b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f14182c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f14183d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f14184e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f14185f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f14186g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f14187h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f14188i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f14189j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f14190k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f14191l;

            public C0196a() {
                this.f14180a = new int[10];
                this.f14181b = new int[10];
                this.f14182c = 0;
                this.f14183d = new int[10];
                this.f14184e = new float[10];
                this.f14185f = 0;
                this.f14186g = new int[5];
                this.f14187h = new String[5];
                this.f14188i = 0;
                this.f14189j = new int[4];
                this.f14190k = new boolean[4];
                this.f14191l = 0;
            }

            public void a(int r10, float r11) {
                int r12 = this.f14185f;
                int[] r13 = this.f14183d;
                if (r12 < r13.length) goto L5;
                this.f14183d = Arrays.copyOf(r13, r13.length * 2);
                float[] r14 = this.f14184e;
                this.f14184e = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f14183d;
                int r16 = this.f14185f;
                r15[r16] = r10;
                float[] r17 = this.f14184e;
                this.f14185f = r16 + 1;
                r17[r16] = r11;
            }

            public void b(int r10, int r11) {
                int r12 = this.f14182c;
                int[] r13 = this.f14180a;
                if (r12 < r13.length) goto L5;
                this.f14180a = Arrays.copyOf(r13, r13.length * 2);
                int[] r14 = this.f14181b;
                this.f14181b = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f14180a;
                int r16 = this.f14182c;
                r15[r16] = r10;
                int[] r17 = this.f14181b;
                this.f14182c = r16 + 1;
                r17[r16] = r11;
            }

            public void c(int r10, String r11) {
                int r12 = this.f14188i;
                int[] r13 = this.f14186g;
                if (r12 < r13.length) goto L5;
                this.f14186g = Arrays.copyOf(r13, r13.length * 2);
                String[] r14 = this.f14187h;
                this.f14187h = (String[]) Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f14186g;
                int r16 = this.f14188i;
                r15[r16] = r10;
                String[] r17 = this.f14187h;
                this.f14188i = r16 + 1;
                r17[r16] = r11;
            }

            public void d(int r10, boolean r11) {
                int r12 = this.f14191l;
                int[] r13 = this.f14189j;
                if (r12 < r13.length) goto L5;
                this.f14189j = Arrays.copyOf(r13, r13.length * 2);
                boolean[] r14 = this.f14190k;
                this.f14190k = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.f14189j;
                int r16 = this.f14191l;
                r15[r16] = r10;
                boolean[] r17 = this.f14190k;
                this.f14191l = r16 + 1;
                r17[r16] = r11;
            }

            public void e(C0195a r10) {
                int r11 = 0;
                int r12 = 0;
            L4:
                if (r12 >= this.f14182c) goto L6;
                a.c(r10, this.f14180a[r12], this.f14181b[r12]);
                r12 = r12 + 1;
                goto L4
            L6:
                int r13 = 0;
            L8:
                if (r13 >= this.f14185f) goto L10;
                a.d(r10, this.f14183d[r13], this.f14184e[r13]);
                r13 = r13 + 1;
                goto L8
            L10:
                int r14 = 0;
            L12:
                if (r14 >= this.f14188i) goto L15;
                a.e(r10, this.f14186g[r14], this.f14187h[r14]);
                r14 = r14 + 1;
            L15:
                if (r11 >= this.f14191l) goto L17;
                a.f(r10, this.f14189j[r11], this.f14190k[r11]);
                r11 = r11 + 1;
                goto L15
            }
        }

        public C0195a() {
            this.f14174c = new d();
            this.f14175d = new c();
            this.f14176e = new b();
            this.f14177f = new e();
            this.f14178g = new HashMap();
        }

        public static /* synthetic */ void a(C0195a r10, int r11, ConstraintLayout.LayoutParams r12) {
            r10.g(r11, r12);
        }

        public static /* synthetic */ void b(C0195a r10, ConstraintHelper r11, int r12, Constraints.LayoutParams r13) {
            r10.i(r11, r12, r13);
        }

        public static /* synthetic */ void c(C0195a r10, int r11, Constraints.LayoutParams r12) {
            r10.h(r11, r12);
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return f();
        }

        public void d(C0195a r10) {
            C0196a r11 = this.f14179h;
            if (r11 == null) goto L6;
            r11.e(r10);
            return;
        }

        public void e(ConstraintLayout.LayoutParams r10) {
            b r11 = this.f14176e;
            r10.f14094e = r11.f14212j;
            r10.f14096f = r11.f14214k;
            r10.f14098g = r11.f14216l;
            r10.f14100h = r11.f14218m;
            r10.f14102i = r11.f14220n;
            r10.f14104j = r11.f14222o;
            r10.f14106k = r11.f14224p;
            r10.f14108l = r11.f14226q;
            r10.f14110m = r11.f14228r;
            r10.f14112n = r11.f14229s;
            r10.f14114o = r11.f14230t;
            r10.f14122s = r11.f14231u;
            r10.f14124t = r11.f14232v;
            r10.f14126u = r11.f14233w;
            r10.f14128v = r11.f14234x;
            ((ViewGroup.MarginLayoutParams) r10).leftMargin = r11.H;
            ((ViewGroup.MarginLayoutParams) r10).rightMargin = r11.I;
            ((ViewGroup.MarginLayoutParams) r10).topMargin = r11.f14193J;
            ((ViewGroup.MarginLayoutParams) r10).bottomMargin = r11.K;
            r10.A = r11.T;
            r10.B = r11.S;
            r10.f14132x = r11.P;
            r10.f14134z = r11.R;
            r10.G = r11.f14235y;
            r10.H = r11.f14236z;
            r10.f14116p = r11.B;
            r10.f14118q = r11.C;
            r10.f14120r = r11.D;
            r10.I = r11.A;
            r10.X = r11.E;
            r10.Y = r11.F;
            r10.M = r11.V;
            r10.L = r11.W;
            r10.O = r11.Y;
            r10.N = r11.X;
            r10.f14087a0 = r11.f14221n0;
            r10.f14089b0 = r11.f14223o0;
            r10.P = r11.Z;
            r10.Q = r11.f14195a0;
            r10.T = r11.f14197b0;
            r10.U = r11.f14199c0;
            r10.R = r11.f14201d0;
            r10.S = r11.f14203e0;
            r10.V = r11.f14205f0;
            r10.W = r11.f14207g0;
            r10.Z = r11.G;
            r10.f14090c = r11.f14208h;
            r10.f14086a = r11.f14204f;
            r10.f14088b = r11.f14206g;
            ((ViewGroup.MarginLayoutParams) r10).width = r11.f14200d;
            ((ViewGroup.MarginLayoutParams) r10).height = r11.f14202e;
            String r12 = r11.f14219m0;
            if (r12 == null) goto L5;
            r10.f14091c0 = r12;
        L5:
            r10.f14093d0 = r11.f14227q0;
            r10.setMarginStart(r11.M);
            r10.setMarginEnd(this.f14176e.L);
            r10.c();
        }

        public C0195a f() {
            C0195a r10 = new C0195a();
            r10.f14176e.a(this.f14176e);
            r10.f14175d.a(this.f14175d);
            r10.f14174c.a(this.f14174c);
            r10.f14177f.a(this.f14177f);
            r10.f14172a = this.f14172a;
            r10.f14179h = this.f14179h;
            return r10;
        }

        public final void g(int r10, ConstraintLayout.LayoutParams r11) {
            this.f14172a = r10;
            b r12 = this.f14176e;
            r12.f14212j = r11.f14094e;
            r12.f14214k = r11.f14096f;
            r12.f14216l = r11.f14098g;
            r12.f14218m = r11.f14100h;
            r12.f14220n = r11.f14102i;
            r12.f14222o = r11.f14104j;
            r12.f14224p = r11.f14106k;
            r12.f14226q = r11.f14108l;
            r12.f14228r = r11.f14110m;
            r12.f14229s = r11.f14112n;
            r12.f14230t = r11.f14114o;
            r12.f14231u = r11.f14122s;
            r12.f14232v = r11.f14124t;
            r12.f14233w = r11.f14126u;
            r12.f14234x = r11.f14128v;
            r12.f14235y = r11.G;
            r12.f14236z = r11.H;
            r12.A = r11.I;
            r12.B = r11.f14116p;
            r12.C = r11.f14118q;
            r12.D = r11.f14120r;
            r12.E = r11.X;
            r12.F = r11.Y;
            r12.G = r11.Z;
            r12.f14208h = r11.f14090c;
            r12.f14204f = r11.f14086a;
            r12.f14206g = r11.f14088b;
            r12.f14200d = ((ViewGroup.MarginLayoutParams) r11).width;
            r12.f14202e = ((ViewGroup.MarginLayoutParams) r11).height;
            r12.H = ((ViewGroup.MarginLayoutParams) r11).leftMargin;
            r12.I = ((ViewGroup.MarginLayoutParams) r11).rightMargin;
            r12.f14193J = ((ViewGroup.MarginLayoutParams) r11).topMargin;
            r12.K = ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
            r12.N = r11.D;
            r12.V = r11.M;
            r12.W = r11.L;
            r12.Y = r11.O;
            r12.X = r11.N;
            r12.f14221n0 = r11.f14087a0;
            r12.f14223o0 = r11.f14089b0;
            r12.Z = r11.P;
            r12.f14195a0 = r11.Q;
            r12.f14197b0 = r11.T;
            r12.f14199c0 = r11.U;
            r12.f14201d0 = r11.R;
            r12.f14203e0 = r11.S;
            r12.f14205f0 = r11.V;
            r12.f14207g0 = r11.W;
            r12.f14219m0 = r11.f14091c0;
            r12.P = r11.f14132x;
            r12.R = r11.f14134z;
            r12.O = r11.f14130w;
            r12.Q = r11.f14133y;
            r12.T = r11.A;
            r12.S = r11.B;
            r12.U = r11.C;
            r12.f14227q0 = r11.f14093d0;
            r12.L = r11.getMarginEnd();
            b r13 = this.f14176e;
            r13.M = r11.getMarginStart();
        }

        public final void h(int r10, Constraints.LayoutParams r11) {
            g(r10, r11);
            d r12 = this.f14174c;
            r12.f14255d = r11.f14146x0;
            e r13 = this.f14177f;
            r13.f14259b = r11.A0;
            r13.f14260c = r11.B0;
            r13.f14261d = r11.C0;
            r13.f14262e = r11.D0;
            r13.f14263f = r11.E0;
            r13.f14264g = r11.F0;
            r13.f14265h = r11.G0;
            r13.f14267j = r11.H0;
            r13.f14268k = r11.I0;
            r13.f14269l = r11.J0;
            r13.f14271n = r11.f14148z0;
            r13.f14270m = r11.f14147y0;
        }

        public final void i(ConstraintHelper r10, int r11, Constraints.LayoutParams r12) {
            h(r11, r12);
            if ((r10 instanceof Barrier) == false) goto L6;
            b r13 = this.f14176e;
            r13.f14213j0 = 1;
            Barrier r14 = (Barrier) r10;
            r13.f14209h0 = r14.getType();
            b r15 = this.f14176e;
            r15.f14215k0 = r14.getReferencedIds();
            b r16 = this.f14176e;
            r16.f14211i0 = r14.getMargin();
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static SparseIntArray f14192r0;
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
        public int f14193J;
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
        public boolean f14194a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f14195a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14196b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f14197b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14198c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f14199c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14200d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f14201d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14202e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f14203e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14204f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f14205f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14206g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f14207g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f14208h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f14209h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f14210i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f14211i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f14212j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f14213j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f14214k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f14215k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f14216l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f14217l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f14218m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f14219m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f14220n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f14221n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f14222o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f14223o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f14224p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f14225p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f14226q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f14227q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f14228r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f14229s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f14230t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f14231u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f14232v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f14233w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f14234x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f14235y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f14236z;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f14192r0 = r10;
            r10.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f14192r0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f14192r0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f14192r0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            f14192r0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            f14192r0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f14192r0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f14192r0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f14192r0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f14192r0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            f14192r0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            f14192r0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            f14192r0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            f14192r0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            SparseIntArray r11 = f14192r0;
            int r12 = R$styleable.Layout_guidelineUseRtl;
            r11.append(r12, 90);
            f14192r0.append(R$styleable.Layout_android_orientation, 26);
            f14192r0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            f14192r0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            f14192r0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f14192r0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f14192r0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            f14192r0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            f14192r0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            f14192r0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            f14192r0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            f14192r0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            f14192r0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            f14192r0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            f14192r0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f14192r0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f14192r0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            f14192r0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            f14192r0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            f14192r0.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            f14192r0.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            f14192r0.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            f14192r0.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            f14192r0.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            f14192r0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            f14192r0.append(R$styleable.Layout_android_layout_marginRight, 27);
            f14192r0.append(R$styleable.Layout_android_layout_marginStart, 30);
            f14192r0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            f14192r0.append(R$styleable.Layout_android_layout_marginTop, 33);
            f14192r0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            f14192r0.append(R$styleable.Layout_android_layout_width, 22);
            f14192r0.append(R$styleable.Layout_android_layout_height, 21);
            SparseIntArray r13 = f14192r0;
            int r14 = R$styleable.Layout_layout_constraintWidth;
            r13.append(r14, 41);
            SparseIntArray r15 = f14192r0;
            int r16 = R$styleable.Layout_layout_constraintHeight;
            r15.append(r16, 42);
            f14192r0.append(R$styleable.Layout_layout_constrainedWidth, 87);
            f14192r0.append(R$styleable.Layout_layout_constrainedHeight, 88);
            f14192r0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            f14192r0.append(R$styleable.Layout_layout_constraintCircle, 61);
            f14192r0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            f14192r0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            f14192r0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            f14192r0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            f14192r0.append(R$styleable.Layout_chainUseRtl, 71);
            f14192r0.append(R$styleable.Layout_barrierDirection, 72);
            f14192r0.append(R$styleable.Layout_barrierMargin, 73);
            f14192r0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            f14192r0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
            SparseIntArray r17 = f14192r0;
            int r18 = R$styleable.Layout_layout_constraintWidth_max;
            r17.append(r18, 84);
            f14192r0.append(R$styleable.Layout_layout_constraintWidth_min, 86);
            f14192r0.append(r18, 83);
            f14192r0.append(R$styleable.Layout_layout_constraintHeight_min, 85);
            f14192r0.append(r14, 87);
            f14192r0.append(r16, 88);
            f14192r0.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
            f14192r0.append(r12, 90);
        }

        public b() {
            this.f14194a = false;
            this.f14196b = false;
            this.f14198c = false;
            this.f14204f = -1;
            this.f14206g = -1;
            this.f14208h = -1.0f;
            this.f14210i = true;
            this.f14212j = -1;
            this.f14214k = -1;
            this.f14216l = -1;
            this.f14218m = -1;
            this.f14220n = -1;
            this.f14222o = -1;
            this.f14224p = -1;
            this.f14226q = -1;
            this.f14228r = -1;
            this.f14229s = -1;
            this.f14230t = -1;
            this.f14231u = -1;
            this.f14232v = -1;
            this.f14233w = -1;
            this.f14234x = -1;
            this.f14235y = 0.5f;
            this.f14236z = 0.5f;
            this.A = null;
            this.B = -1;
            this.C = 0;
            this.D = 0.0f;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = 0;
            this.I = 0;
            this.f14193J = 0;
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
            this.f14195a0 = 0;
            this.f14197b0 = 0;
            this.f14199c0 = 0;
            this.f14201d0 = 0;
            this.f14203e0 = 0;
            this.f14205f0 = 1.0f;
            this.f14207g0 = 1.0f;
            this.f14209h0 = -1;
            this.f14211i0 = 0;
            this.f14213j0 = -1;
            this.f14221n0 = false;
            this.f14223o0 = false;
            this.f14225p0 = true;
            this.f14227q0 = 0;
        }

        public void a(b r10) {
            this.f14194a = r10.f14194a;
            this.f14200d = r10.f14200d;
            this.f14196b = r10.f14196b;
            this.f14202e = r10.f14202e;
            this.f14204f = r10.f14204f;
            this.f14206g = r10.f14206g;
            this.f14208h = r10.f14208h;
            this.f14210i = r10.f14210i;
            this.f14212j = r10.f14212j;
            this.f14214k = r10.f14214k;
            this.f14216l = r10.f14216l;
            this.f14218m = r10.f14218m;
            this.f14220n = r10.f14220n;
            this.f14222o = r10.f14222o;
            this.f14224p = r10.f14224p;
            this.f14226q = r10.f14226q;
            this.f14228r = r10.f14228r;
            this.f14229s = r10.f14229s;
            this.f14230t = r10.f14230t;
            this.f14231u = r10.f14231u;
            this.f14232v = r10.f14232v;
            this.f14233w = r10.f14233w;
            this.f14234x = r10.f14234x;
            this.f14235y = r10.f14235y;
            this.f14236z = r10.f14236z;
            this.A = r10.A;
            this.B = r10.B;
            this.C = r10.C;
            this.D = r10.D;
            this.E = r10.E;
            this.F = r10.F;
            this.G = r10.G;
            this.H = r10.H;
            this.I = r10.I;
            this.f14193J = r10.f14193J;
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
            this.f14195a0 = r10.f14195a0;
            this.f14197b0 = r10.f14197b0;
            this.f14199c0 = r10.f14199c0;
            this.f14201d0 = r10.f14201d0;
            this.f14203e0 = r10.f14203e0;
            this.f14205f0 = r10.f14205f0;
            this.f14207g0 = r10.f14207g0;
            this.f14209h0 = r10.f14209h0;
            this.f14211i0 = r10.f14211i0;
            this.f14213j0 = r10.f14213j0;
            this.f14219m0 = r10.f14219m0;
            int[] r11 = r10.f14215k0;
            if (r11 != null) goto L5;
        L7:
            this.f14215k0 = null;
        L8:
            this.f14217l0 = r10.f14217l0;
            this.f14221n0 = r10.f14221n0;
            this.f14223o0 = r10.f14223o0;
            this.f14225p0 = r10.f14225p0;
            this.f14227q0 = r10.f14227q0;
            return;
        L5:
            if (r10.f14217l0 != null) goto L7;
            this.f14215k0 = Arrays.copyOf(r11, r11.length);
            goto L8
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Layout);
            this.f14196b = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L79;
            int r15 = r12.getIndex(r14);
            int r16 = f14192r0.get(r15);
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
            this.B = a.a(r12, r15, this.B);
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
            Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r15) + "   " + f14192r0.get(r15));
            goto L78
        L10:
            Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r15) + "   " + f14192r0.get(r15));
            goto L78
        L11:
            this.f14210i = r12.getBoolean(r15, this.f14210i);
            goto L78
        L12:
            this.f14219m0 = r12.getString(r15);
            goto L78
        L13:
            this.f14223o0 = r12.getBoolean(r15, this.f14223o0);
            goto L78
        L14:
            this.f14221n0 = r12.getBoolean(r15, this.f14221n0);
            goto L78
        L15:
            this.f14201d0 = r12.getDimensionPixelSize(r15, this.f14201d0);
            goto L78
        L16:
            this.f14203e0 = r12.getDimensionPixelSize(r15, this.f14203e0);
            goto L78
        L17:
            this.f14197b0 = r12.getDimensionPixelSize(r15, this.f14197b0);
            goto L78
        L18:
            this.f14199c0 = r12.getDimensionPixelSize(r15, this.f14199c0);
            goto L78
        L19:
            this.f14195a0 = r12.getInt(r15, this.f14195a0);
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
            this.f14230t = a.a(r12, r15, this.f14230t);
            goto L78
        L24:
            this.f14229s = a.a(r12, r15, this.f14229s);
            goto L78
        L25:
            this.f14227q0 = r12.getInt(r15, this.f14227q0);
            goto L78
        L26:
            this.f14225p0 = r12.getBoolean(r15, this.f14225p0);
            goto L78
        L27:
            this.f14217l0 = r12.getString(r15);
            goto L78
        L28:
            this.f14211i0 = r12.getDimensionPixelSize(r15, this.f14211i0);
            goto L78
        L29:
            this.f14209h0 = r12.getInt(r15, this.f14209h0);
            goto L78
        L30:
            Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
            goto L78
        L31:
            this.f14207g0 = r12.getFloat(r15, 1.0f);
            goto L78
        L32:
            this.f14205f0 = r12.getFloat(r15, 1.0f);
            goto L78
        L36:
            a.E(this, r12, r15, 1);
            goto L78
        L37:
            a.E(this, r12, r15, 0);
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
            this.f14236z = r12.getFloat(r15, this.f14236z);
            goto L78
        L43:
            this.f14220n = a.a(r12, r15, this.f14220n);
            goto L78
        L44:
            this.f14222o = a.a(r12, r15, this.f14222o);
            goto L78
        L45:
            this.f14193J = r12.getDimensionPixelSize(r15, this.f14193J);
            goto L78
        L46:
            this.f14232v = a.a(r12, r15, this.f14232v);
            goto L78
        L47:
            this.f14231u = a.a(r12, r15, this.f14231u);
            goto L78
        L48:
            this.M = r12.getDimensionPixelSize(r15, this.M);
            goto L78
        L49:
            this.f14218m = a.a(r12, r15, this.f14218m);
            goto L78
        L50:
            this.f14216l = a.a(r12, r15, this.f14216l);
            goto L78
        L51:
            this.I = r12.getDimensionPixelSize(r15, this.I);
            goto L78
        L52:
            this.G = r12.getInt(r15, this.G);
            goto L78
        L53:
            this.f14214k = a.a(r12, r15, this.f14214k);
            goto L78
        L54:
            this.f14212j = a.a(r12, r15, this.f14212j);
            goto L78
        L55:
            this.H = r12.getDimensionPixelSize(r15, this.H);
            goto L78
        L56:
            this.f14200d = r12.getLayoutDimension(r15, this.f14200d);
            goto L78
        L57:
            this.f14202e = r12.getLayoutDimension(r15, this.f14202e);
            goto L78
        L58:
            this.f14235y = r12.getFloat(r15, this.f14235y);
            goto L78
        L59:
            this.f14208h = r12.getFloat(r15, this.f14208h);
            goto L78
        L60:
            this.f14206g = r12.getDimensionPixelOffset(r15, this.f14206g);
            goto L78
        L61:
            this.f14204f = r12.getDimensionPixelOffset(r15, this.f14204f);
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
            this.f14233w = a.a(r12, r15, this.f14233w);
            goto L78
        L69:
            this.f14234x = a.a(r12, r15, this.f14234x);
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
            this.f14224p = a.a(r12, r15, this.f14224p);
            goto L78
        L75:
            this.f14226q = a.a(r12, r15, this.f14226q);
            goto L78
        L76:
            this.K = r12.getDimensionPixelSize(r15, this.K);
            goto L78
        L77:
            this.f14228r = a.a(r12, r15, this.f14228r);
            goto L78
        L79:
            r12.recycle();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f14237o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14240c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f14241d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14242e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f14243f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f14244g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14245h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f14246i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f14247j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f14248k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f14249l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f14250m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f14251n;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f14237o = r10;
            r10.append(R$styleable.Motion_motionPathRotate, 1);
            f14237o.append(R$styleable.Motion_pathMotionArc, 2);
            f14237o.append(R$styleable.Motion_transitionEasing, 3);
            f14237o.append(R$styleable.Motion_drawPath, 4);
            f14237o.append(R$styleable.Motion_animateRelativeTo, 5);
            f14237o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            f14237o.append(R$styleable.Motion_motionStagger, 7);
            f14237o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            f14237o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            f14237o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public c() {
            this.f14238a = false;
            this.f14239b = -1;
            this.f14240c = 0;
            this.f14241d = null;
            this.f14242e = -1;
            this.f14243f = 0;
            this.f14244g = Float.NaN;
            this.f14245h = -1;
            this.f14246i = Float.NaN;
            this.f14247j = Float.NaN;
            this.f14248k = -1;
            this.f14249l = null;
            this.f14250m = -3;
            this.f14251n = -1;
        }

        public void a(c r10) {
            this.f14238a = r10.f14238a;
            this.f14239b = r10.f14239b;
            this.f14241d = r10.f14241d;
            this.f14242e = r10.f14242e;
            this.f14243f = r10.f14243f;
            this.f14246i = r10.f14246i;
            this.f14244g = r10.f14244g;
            this.f14245h = r10.f14245h;
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Motion);
            this.f14238a = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L31;
            int r15 = r12.getIndex(r14);
            switch(f14237o.get(r15)) {
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
            this.f14251n = r17;
            if (r17 == (-1)) goto L30;
            this.f14250m = -2;
            goto L30
        L12:
            if (r16 != 3) goto L17;
            String r18 = r12.getString(r15);
            this.f14249l = r18;
            if (r18.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L16;
            this.f14251n = r12.getResourceId(r15, -1);
            this.f14250m = -2;
            goto L30
        L16:
            this.f14250m = -1;
            goto L30
        L17:
            this.f14250m = r12.getInteger(r15, this.f14251n);
            goto L30
        L18:
            this.f14247j = r12.getFloat(r15, this.f14247j);
            goto L30
        L19:
            this.f14248k = r12.getInteger(r15, this.f14248k);
            goto L30
        L20:
            this.f14244g = r12.getFloat(r15, this.f14244g);
            goto L30
        L21:
            this.f14240c = r12.getInteger(r15, this.f14240c);
            goto L30
        L22:
            this.f14239b = a.a(r12, r15, this.f14239b);
            goto L30
        L23:
            this.f14243f = r12.getInt(r15, 0);
            goto L30
        L28:
            this.f14242e = r12.getInt(r15, this.f14242e);
            goto L30
        L29:
            this.f14246i = r12.getFloat(r15, this.f14246i);
            goto L30
        L25:
            if (r12.peekValue(r15).type != 3) goto L27;
            this.f14241d = r12.getString(r15);
            goto L30
        L27:
            this.f14241d = vc.c.f25151c[r12.getInteger(r15, 0)];
        L30:
            r14 = r14 + 1;
            goto L3
        L31:
            r12.recycle();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f14255d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f14256e;

        public d() {
            this.f14252a = false;
            this.f14253b = 0;
            this.f14254c = 0;
            this.f14255d = 1.0f;
            this.f14256e = Float.NaN;
        }

        public void a(d r10) {
            this.f14252a = r10.f14252a;
            this.f14253b = r10.f14253b;
            this.f14255d = r10.f14255d;
            this.f14256e = r10.f14256e;
            this.f14254c = r10.f14254c;
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.PropertySet);
            this.f14252a = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L17;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.PropertySet_android_alpha) goto L8;
            this.f14255d = r12.getFloat(r15, this.f14255d);
        L16:
            r14 = r14 + 1;
            goto L3
        L8:
            if (r15 != R$styleable.PropertySet_android_visibility) goto L11;
            this.f14253b = r12.getInt(r15, this.f14253b);
            this.f14253b = a.b()[this.f14253b];
            goto L16
        L11:
            if (r15 != R$styleable.PropertySet_visibilityMode) goto L14;
            this.f14254c = r12.getInt(r15, this.f14254c);
            goto L16
        L14:
            if (r15 != R$styleable.PropertySet_motionProgress) goto L16;
            this.f14256e = r12.getFloat(r15, this.f14256e);
            goto L16
        L17:
            r12.recycle();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f14257o;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f14259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f14260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f14261d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f14262e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f14263f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f14264g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f14265h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14266i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f14267j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f14268k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f14269l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f14270m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f14271n;

        static {
            SparseIntArray r10 = new SparseIntArray();
            f14257o = r10;
            r10.append(R$styleable.Transform_android_rotation, 1);
            f14257o.append(R$styleable.Transform_android_rotationX, 2);
            f14257o.append(R$styleable.Transform_android_rotationY, 3);
            f14257o.append(R$styleable.Transform_android_scaleX, 4);
            f14257o.append(R$styleable.Transform_android_scaleY, 5);
            f14257o.append(R$styleable.Transform_android_transformPivotX, 6);
            f14257o.append(R$styleable.Transform_android_transformPivotY, 7);
            f14257o.append(R$styleable.Transform_android_translationX, 8);
            f14257o.append(R$styleable.Transform_android_translationY, 9);
            f14257o.append(R$styleable.Transform_android_translationZ, 10);
            f14257o.append(R$styleable.Transform_android_elevation, 11);
            f14257o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public e() {
            this.f14258a = false;
            this.f14259b = 0.0f;
            this.f14260c = 0.0f;
            this.f14261d = 0.0f;
            this.f14262e = 1.0f;
            this.f14263f = 1.0f;
            this.f14264g = Float.NaN;
            this.f14265h = Float.NaN;
            this.f14266i = -1;
            this.f14267j = 0.0f;
            this.f14268k = 0.0f;
            this.f14269l = 0.0f;
            this.f14270m = false;
            this.f14271n = 0.0f;
        }

        public void a(e r10) {
            this.f14258a = r10.f14258a;
            this.f14259b = r10.f14259b;
            this.f14260c = r10.f14260c;
            this.f14261d = r10.f14261d;
            this.f14262e = r10.f14262e;
            this.f14263f = r10.f14263f;
            this.f14264g = r10.f14264g;
            this.f14265h = r10.f14265h;
            this.f14266i = r10.f14266i;
            this.f14267j = r10.f14267j;
            this.f14268k = r10.f14268k;
            this.f14269l = r10.f14269l;
            this.f14270m = r10.f14270m;
            this.f14271n = r10.f14271n;
        }

        public void b(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Transform);
            this.f14258a = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L20;
            int r15 = r12.getIndex(r14);
            switch(f14257o.get(r15)) {
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
            this.f14266i = a.a(r12, r15, this.f14266i);
            goto L19
        L8:
            this.f14270m = true;
            this.f14271n = r12.getDimension(r15, this.f14271n);
            goto L19
        L9:
            this.f14269l = r12.getDimension(r15, this.f14269l);
            goto L19
        L10:
            this.f14268k = r12.getDimension(r15, this.f14268k);
            goto L19
        L11:
            this.f14267j = r12.getDimension(r15, this.f14267j);
            goto L19
        L12:
            this.f14265h = r12.getDimension(r15, this.f14265h);
            goto L19
        L13:
            this.f14264g = r12.getDimension(r15, this.f14264g);
            goto L19
        L14:
            this.f14263f = r12.getFloat(r15, this.f14263f);
            goto L19
        L15:
            this.f14262e = r12.getFloat(r15, this.f14262e);
            goto L19
        L16:
            this.f14261d = r12.getFloat(r15, this.f14261d);
            goto L19
        L17:
            this.f14260c = r12.getFloat(r15, this.f14260c);
            goto L19
        L18:
            this.f14259b = r12.getFloat(r15, this.f14259b);
        L19:
            r14 = r14 + 1;
            goto L3
        L20:
            r12.recycle();
        }
    }

    static {
        f14161i = new int[]{0, 4, 8};
        f14162j = new SparseIntArray();
        f14163k = new SparseIntArray();
        f14162j.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f14162j.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f14162j.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f14162j.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f14162j.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f14162j.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f14162j.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f14162j.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f14162j.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f14162j.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f14162j.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f14162j.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f14162j.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f14162j.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f14162j.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f14162j.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f14162j.append(R$styleable.Constraint_guidelineUseRtl, 99);
        f14162j.append(R$styleable.Constraint_android_orientation, 27);
        f14162j.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f14162j.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f14162j.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f14162j.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f14162j.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f14162j.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f14162j.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f14162j.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f14162j.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f14162j.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f14162j.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f14162j.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f14162j.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f14162j.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f14162j.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f14162j.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f14162j.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f14162j.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f14162j.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f14162j.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f14162j.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f14162j.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f14162j.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f14162j.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f14162j.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f14162j.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f14162j.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f14162j.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f14162j.append(R$styleable.Constraint_android_layout_width, 23);
        f14162j.append(R$styleable.Constraint_android_layout_height, 21);
        f14162j.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f14162j.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f14162j.append(R$styleable.Constraint_android_visibility, 22);
        f14162j.append(R$styleable.Constraint_android_alpha, 43);
        f14162j.append(R$styleable.Constraint_android_elevation, 44);
        f14162j.append(R$styleable.Constraint_android_rotationX, 45);
        f14162j.append(R$styleable.Constraint_android_rotationY, 46);
        f14162j.append(R$styleable.Constraint_android_rotation, 60);
        f14162j.append(R$styleable.Constraint_android_scaleX, 47);
        f14162j.append(R$styleable.Constraint_android_scaleY, 48);
        f14162j.append(R$styleable.Constraint_android_transformPivotX, 49);
        f14162j.append(R$styleable.Constraint_android_transformPivotY, 50);
        f14162j.append(R$styleable.Constraint_android_translationX, 51);
        f14162j.append(R$styleable.Constraint_android_translationY, 52);
        f14162j.append(R$styleable.Constraint_android_translationZ, 53);
        f14162j.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f14162j.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f14162j.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f14162j.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f14162j.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f14162j.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f14162j.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f14162j.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f14162j.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f14162j.append(R$styleable.Constraint_animateRelativeTo, 64);
        f14162j.append(R$styleable.Constraint_transitionEasing, 65);
        f14162j.append(R$styleable.Constraint_drawPath, 66);
        f14162j.append(R$styleable.Constraint_transitionPathRotate, 67);
        f14162j.append(R$styleable.Constraint_motionStagger, 79);
        f14162j.append(R$styleable.Constraint_android_id, 38);
        f14162j.append(R$styleable.Constraint_motionProgress, 68);
        f14162j.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f14162j.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f14162j.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f14162j.append(R$styleable.Constraint_chainUseRtl, 71);
        f14162j.append(R$styleable.Constraint_barrierDirection, 72);
        f14162j.append(R$styleable.Constraint_barrierMargin, 73);
        f14162j.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f14162j.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f14162j.append(R$styleable.Constraint_pathMotionArc, 76);
        f14162j.append(R$styleable.Constraint_layout_constraintTag, 77);
        f14162j.append(R$styleable.Constraint_visibilityMode, 78);
        f14162j.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f14162j.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f14162j.append(R$styleable.Constraint_polarRelativeTo, 82);
        f14162j.append(R$styleable.Constraint_transformPivotTarget, 83);
        f14162j.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f14162j.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f14162j.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray r10 = f14163k;
        int r11 = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        r10.append(r11, 6);
        f14163k.append(r11, 7);
        f14163k.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f14163k.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f14163k.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f14163k.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f14163k.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f14163k.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f14163k.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f14163k.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f14163k.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f14163k.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f14163k.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f14163k.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f14163k.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f14163k.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f14163k.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f14163k.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f14163k.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f14163k.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f14163k.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f14163k.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f14163k.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f14163k.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f14163k.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f14163k.append(R$styleable.ConstraintOverride_drawPath, 66);
        f14163k.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f14163k.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f14163k.append(R$styleable.ConstraintOverride_android_id, 38);
        f14163k.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f14163k.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f14163k.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f14163k.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f14163k.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f14163k.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f14163k.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f14163k.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f14163k.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f14163k.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f14163k.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f14163k.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f14163k.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f14163k.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f14163k.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f14163k.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f14163k.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f14163k.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public a() {
        this.f14166c = "";
        this.f14167d = new String[0];
        this.f14168e = 0;
        this.f14169f = new HashMap();
        this.f14170g = true;
        this.f14171h = new HashMap();
    }

    public static int D(TypedArray r10, int r11, int r12) {
        int r13 = r10.getResourceId(r11, r12);
        if (r13 == (-1)) goto L5;
        return r13;
    L5:
        return r10.getInt(r11, -1);
    }

    public static void E(Object r10, TypedArray r11, int r12, int r13) {
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
        r18.f14087a0 = r17;
        return;
    L24:
        ((ViewGroup.MarginLayoutParams) r18).height = r15;
        r18.f14089b0 = r17;
        return;
    L26:
        if ((r10 instanceof b) == false) goto L32;
        b r19 = (b) r10;
        if (r13 != 0) goto L30;
        r19.f14200d = r15;
        r19.f14221n0 = r17;
        return;
    L30:
        r19.f14202e = r15;
        r19.f14223o0 = r17;
        return;
    L32:
        if ((r10 instanceof C0195a.C0196a) == false) goto L44;
        C0195a.C0196a r20 = (C0195a.C0196a) r10;
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
        F(r10, r11.getString(r12), r13);
    }

    public static void F(Object r10, String r11, int r12) {
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
        G(r19, r18);
        return;
    L17:
        ((ViewGroup.MarginLayoutParams) r19).height = 0;
        goto L18
    L20:
        if ((r10 instanceof b) == false) goto L23;
        ((b) r10).A = r18;
        return;
    L23:
        if ((r10 instanceof C0195a.C0196a) == false) goto L76;
        ((C0195a.C0196a) r10).c(5, r18);
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
        r22.f14200d = 0;     // Catch: NumberFormatException -> L67
        r22.W = r20;     // Catch: NumberFormatException -> L67
        goto L68
    L38:
        r22.f14202e = 0;     // Catch: NumberFormatException -> L67
        r22.V = r20;     // Catch: NumberFormatException -> L67
        goto L68
    L40:
        if ((r10 instanceof C0195a.C0196a) == false) goto L68;
        C0195a.C0196a r23 = (C0195a.C0196a) r10;     // Catch: NumberFormatException -> L67
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
        r26.f14200d = 0;     // Catch: NumberFormatException -> L67
        r26.f14205f0 = r24;     // Catch: NumberFormatException -> L67
        r26.Z = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L59:
        r26.f14202e = 0;     // Catch: NumberFormatException -> L67
        r26.f14207g0 = r24;     // Catch: NumberFormatException -> L67
        r26.f14195a0 = 2;     // Catch: NumberFormatException -> L67
        goto L68
    L61:
        if ((r10 instanceof C0195a.C0196a) == false) goto L68;
        C0195a.C0196a r27 = (C0195a.C0196a) r10;     // Catch: NumberFormatException -> L67
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

    public static void G(ConstraintLayout.LayoutParams r10, String r11) {
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
        r10.f14085J = r12;
        r10.K = r13;
    }

    public static void I(C0195a r12, TypedArray r13) {
        int r10 = r13.getIndexCount();
        C0195a.C0196a r11 = new C0195a.C0196a();
        r12.f14179h = r11;
        r12.f14175d.f14238a = false;
        r12.f14176e.f14196b = false;
        r12.f14174c.f14252a = false;
        r12.f14177f.f14258a = false;
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L109;
        int r15 = r13.getIndex(r14);
        switch(f14163k.get(r15)) {
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
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r15) + "   " + f14162j.get(r15));
    L108:
        r14 = r14 + 1;
        goto L3
    L7:
        r11.d(99, r13.getBoolean(r15, r12.f14176e.f14210i));
        goto L108
    L17:
        r11.b(97, r13.getInt(r15, r12.f14176e.f14227q0));
        goto L108
    L18:
        E(r11, r13, r15, 1);
        goto L108
    L19:
        E(r11, r13, r15, 0);
        goto L108
    L20:
        r11.b(94, r13.getDimensionPixelSize(r15, r12.f14176e.U));
        goto L108
    L21:
        r11.b(93, r13.getDimensionPixelSize(r15, r12.f14176e.N));
        goto L108
    L22:
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r15) + "   " + f14162j.get(r15));
        goto L108
    L23:
        int r16 = r13.peekValue(r15).type;
        if (r16 != 1) goto L28;
        r12.f14175d.f14251n = r13.getResourceId(r15, -1);
        r11.b(89, r12.f14175d.f14251n);
        c r17 = r12.f14175d;
        if (r17.f14251n == (-1)) goto L108;
        r17.f14250m = -2;
        r11.b(88, -2);
        goto L108
    L28:
        if (r16 != 3) goto L33;
        r12.f14175d.f14249l = r13.getString(r15);
        r11.c(90, r12.f14175d.f14249l);
        if (r12.f14175d.f14249l.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L32;
        r12.f14175d.f14251n = r13.getResourceId(r15, -1);
        r11.b(89, r12.f14175d.f14251n);
        r12.f14175d.f14250m = -2;
        r11.b(88, -2);
        goto L108
    L32:
        r12.f14175d.f14250m = -1;
        r11.b(88, -1);
        goto L108
    L33:
        c r18 = r12.f14175d;
        r18.f14250m = r13.getInteger(r15, r18.f14251n);
        r11.b(88, r12.f14175d.f14250m);
        goto L108
    L34:
        r11.a(85, r13.getFloat(r15, r12.f14175d.f14247j));
        goto L108
    L35:
        r11.b(84, r13.getInteger(r15, r12.f14175d.f14248k));
        goto L108
    L36:
        r11.b(83, D(r13, r15, r12.f14177f.f14266i));
        goto L108
    L37:
        r11.b(82, r13.getInteger(r15, r12.f14175d.f14240c));
        goto L108
    L38:
        r11.d(81, r13.getBoolean(r15, r12.f14176e.f14223o0));
        goto L108
    L39:
        r11.d(80, r13.getBoolean(r15, r12.f14176e.f14221n0));
        goto L108
    L40:
        r11.a(79, r13.getFloat(r15, r12.f14175d.f14244g));
        goto L108
    L41:
        r11.b(78, r13.getInt(r15, r12.f14174c.f14254c));
        goto L108
    L42:
        r11.c(77, r13.getString(r15));
        goto L108
    L43:
        r11.b(76, r13.getInt(r15, r12.f14175d.f14242e));
        goto L108
    L44:
        r11.d(75, r13.getBoolean(r15, r12.f14176e.f14225p0));
        goto L108
    L45:
        r11.c(74, r13.getString(r15));
        goto L108
    L46:
        r11.b(73, r13.getDimensionPixelSize(r15, r12.f14176e.f14211i0));
        goto L108
    L47:
        r11.b(72, r13.getInt(r15, r12.f14176e.f14209h0));
        goto L108
    L48:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L108
    L49:
        r11.a(70, r13.getFloat(r15, 1.0f));
        goto L108
    L50:
        r11.a(69, r13.getFloat(r15, 1.0f));
        goto L108
    L51:
        r11.a(68, r13.getFloat(r15, r12.f14174c.f14256e));
        goto L108
    L52:
        r11.a(67, r13.getFloat(r15, r12.f14175d.f14246i));
        goto L108
    L53:
        r11.b(66, r13.getInt(r15, 0));
        goto L108
    L58:
        r11.b(64, D(r13, r15, r12.f14175d.f14239b));
        goto L108
    L59:
        r11.a(63, r13.getFloat(r15, r12.f14176e.D));
        goto L108
    L60:
        r11.b(62, r13.getDimensionPixelSize(r15, r12.f14176e.C));
        goto L108
    L61:
        r11.a(60, r13.getFloat(r15, r12.f14177f.f14259b));
        goto L108
    L62:
        r11.b(59, r13.getDimensionPixelSize(r15, r12.f14176e.f14203e0));
        goto L108
    L63:
        r11.b(58, r13.getDimensionPixelSize(r15, r12.f14176e.f14201d0));
        goto L108
    L64:
        r11.b(57, r13.getDimensionPixelSize(r15, r12.f14176e.f14199c0));
        goto L108
    L65:
        r11.b(56, r13.getDimensionPixelSize(r15, r12.f14176e.f14197b0));
        goto L108
    L66:
        r11.b(55, r13.getInt(r15, r12.f14176e.f14195a0));
        goto L108
    L67:
        r11.b(54, r13.getInt(r15, r12.f14176e.Z));
        goto L108
    L68:
        r11.a(53, r13.getDimension(r15, r12.f14177f.f14269l));
        goto L108
    L69:
        r11.a(52, r13.getDimension(r15, r12.f14177f.f14268k));
        goto L108
    L70:
        r11.a(51, r13.getDimension(r15, r12.f14177f.f14267j));
        goto L108
    L71:
        r11.a(50, r13.getDimension(r15, r12.f14177f.f14265h));
        goto L108
    L72:
        r11.a(49, r13.getDimension(r15, r12.f14177f.f14264g));
        goto L108
    L73:
        r11.a(48, r13.getFloat(r15, r12.f14177f.f14263f));
        goto L108
    L74:
        r11.a(47, r13.getFloat(r15, r12.f14177f.f14262e));
        goto L108
    L75:
        r11.a(46, r13.getFloat(r15, r12.f14177f.f14261d));
        goto L108
    L76:
        r11.a(45, r13.getFloat(r15, r12.f14177f.f14260c));
        goto L108
    L77:
        r11.d(44, true);
        r11.a(44, r13.getDimension(r15, r12.f14177f.f14271n));
        goto L108
    L78:
        r11.a(43, r13.getFloat(r15, r12.f14174c.f14255d));
        goto L108
    L79:
        r11.b(42, r13.getInt(r15, r12.f14176e.Y));
        goto L108
    L80:
        r11.b(41, r13.getInt(r15, r12.f14176e.X));
        goto L108
    L81:
        r11.a(40, r13.getFloat(r15, r12.f14176e.V));
        goto L108
    L82:
        r11.a(39, r13.getFloat(r15, r12.f14176e.W));
        goto L108
    L83:
        int r19 = r13.getResourceId(r15, r12.f14172a);
        r12.f14172a = r19;
        r11.b(38, r19);
        goto L108
    L84:
        r11.a(37, r13.getFloat(r15, r12.f14176e.f14236z));
        goto L108
    L85:
        r11.b(34, r13.getDimensionPixelSize(r15, r12.f14176e.f14193J));
        goto L108
    L86:
        r11.b(31, r13.getDimensionPixelSize(r15, r12.f14176e.M));
        goto L108
    L87:
        r11.b(28, r13.getDimensionPixelSize(r15, r12.f14176e.I));
        goto L108
    L88:
        r11.b(27, r13.getInt(r15, r12.f14176e.G));
        goto L108
    L89:
        r11.b(24, r13.getDimensionPixelSize(r15, r12.f14176e.H));
        goto L108
    L90:
        r11.b(23, r13.getLayoutDimension(r15, r12.f14176e.f14200d));
        goto L108
    L91:
        r11.b(22, f14161i[r13.getInt(r15, r12.f14174c.f14253b)]);
        goto L108
    L92:
        r11.b(21, r13.getLayoutDimension(r15, r12.f14176e.f14202e));
        goto L108
    L93:
        r11.a(20, r13.getFloat(r15, r12.f14176e.f14235y));
        goto L108
    L94:
        r11.a(19, r13.getFloat(r15, r12.f14176e.f14208h));
        goto L108
    L95:
        r11.b(18, r13.getDimensionPixelOffset(r15, r12.f14176e.f14206g));
        goto L108
    L96:
        r11.b(17, r13.getDimensionPixelOffset(r15, r12.f14176e.f14204f));
        goto L108
    L97:
        r11.b(16, r13.getDimensionPixelSize(r15, r12.f14176e.P));
        goto L108
    L98:
        r11.b(15, r13.getDimensionPixelSize(r15, r12.f14176e.T));
        goto L108
    L99:
        r11.b(14, r13.getDimensionPixelSize(r15, r12.f14176e.Q));
        goto L108
    L100:
        r11.b(13, r13.getDimensionPixelSize(r15, r12.f14176e.O));
        goto L108
    L101:
        r11.b(12, r13.getDimensionPixelSize(r15, r12.f14176e.S));
        goto L108
    L102:
        r11.b(11, r13.getDimensionPixelSize(r15, r12.f14176e.R));
        goto L108
    L103:
        r11.b(8, r13.getDimensionPixelSize(r15, r12.f14176e.L));
        goto L108
    L104:
        r11.b(7, r13.getDimensionPixelOffset(r15, r12.f14176e.F));
        goto L108
    L105:
        r11.b(6, r13.getDimensionPixelOffset(r15, r12.f14176e.E));
        goto L108
    L106:
        r11.c(5, r13.getString(r15));
        goto L108
    L107:
        r11.b(2, r13.getDimensionPixelSize(r15, r12.f14176e.K));
        goto L108
    L9:
        if (MotionLayout.f13558d1 == false) goto L14;
        int r20 = r13.getResourceId(r15, r12.f14172a);
        r12.f14172a = r20;
        if (r20 != (-1)) goto L108;
        r12.f14173b = r13.getString(r15);
        goto L108
    L14:
        if (r13.peekValue(r15).type != 3) goto L16;
        r12.f14173b = r13.getString(r15);
        goto L108
    L16:
        r12.f14172a = r13.getResourceId(r15, r12.f14172a);
        goto L108
    L55:
        if (r13.peekValue(r15).type != 3) goto L57;
        r11.c(65, r13.getString(r15));
        goto L108
    L57:
        r11.c(65, vc.c.f25151c[r13.getInteger(r15, 0)]);
        goto L108
    }

    public static void L(C0195a r10, int r11, float r12) {
        if (r11 != 19) goto L5;
        r10.f14176e.f14208h = r12;
        return;
    L5:
        if (r11 != 20) goto L7;
        r10.f14176e.f14235y = r12;
        return;
    L7:
        if (r11 != 37) goto L9;
        r10.f14176e.f14236z = r12;
        return;
    L9:
        if (r11 != 60) goto L11;
        r10.f14177f.f14259b = r12;
        return;
    L11:
        if (r11 != 63) goto L13;
        r10.f14176e.D = r12;
        return;
    L13:
        if (r11 != 79) goto L15;
        r10.f14175d.f14244g = r12;
        return;
    L15:
        if (r11 != 85) goto L17;
        r10.f14175d.f14247j = r12;
        return;
    L17:
        if (r11 != 87) goto L19;
        return;
    L19:
        if (r11 != 39) goto L21;
        r10.f14176e.W = r12;
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
        r10.f14176e.f14207g0 = r12;
        return;
    L26:
        r10.f14176e.f14205f0 = r12;
        return;
    L27:
        r10.f14174c.f14256e = r12;
        return;
    L28:
        r10.f14175d.f14246i = r12;
        return;
    L29:
        r10.f14177f.f14269l = r12;
        return;
    L30:
        r10.f14177f.f14268k = r12;
        return;
    L31:
        r10.f14177f.f14267j = r12;
        return;
    L32:
        r10.f14177f.f14265h = r12;
        return;
    L33:
        r10.f14177f.f14264g = r12;
        return;
    L34:
        r10.f14177f.f14263f = r12;
        return;
    L35:
        r10.f14177f.f14262e = r12;
        return;
    L36:
        r10.f14177f.f14261d = r12;
        return;
    L37:
        r10.f14177f.f14260c = r12;
        return;
    L38:
        e r13 = r10.f14177f;
        r13.f14271n = r12;
        r13.f14270m = true;
        return;
    L39:
        r10.f14174c.f14255d = r12;
        return;
    L40:
        r10.f14176e.V = r12;
    }

    public static void M(C0195a r10, int r11, int r12) {
        if (r11 != 6) goto L5;
        r10.f14176e.E = r12;
        return;
    L5:
        if (r11 != 7) goto L7;
        r10.f14176e.F = r12;
        return;
    L7:
        if (r11 != 8) goto L9;
        r10.f14176e.L = r12;
        return;
    L9:
        if (r11 != 27) goto L11;
        r10.f14176e.G = r12;
        return;
    L11:
        if (r11 != 28) goto L13;
        r10.f14176e.I = r12;
        return;
    L13:
        if (r11 != 41) goto L15;
        r10.f14176e.X = r12;
        return;
    L15:
        if (r11 != 42) goto L17;
        r10.f14176e.Y = r12;
        return;
    L17:
        if (r11 != 61) goto L19;
        r10.f14176e.B = r12;
        return;
    L19:
        if (r11 != 62) goto L21;
        r10.f14176e.C = r12;
        return;
    L21:
        if (r11 != 72) goto L23;
        r10.f14176e.f14209h0 = r12;
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
        r10.f14175d.f14251n = r12;
        return;
    L31:
        r10.f14175d.f14250m = r12;
        return;
    L76:
        return;
    L32:
        r10.f14175d.f14248k = r12;
        return;
    L33:
        r10.f14177f.f14266i = r12;
        return;
    L34:
        r10.f14175d.f14240c = r12;
        return;
    L35:
        r10.f14176e.f14203e0 = r12;
        return;
    L36:
        r10.f14176e.f14201d0 = r12;
        return;
    L37:
        r10.f14176e.f14199c0 = r12;
        return;
    L38:
        r10.f14176e.f14197b0 = r12;
        return;
    L39:
        r10.f14176e.f14195a0 = r12;
        return;
    L40:
        r10.f14176e.Z = r12;
        return;
    L41:
        r10.f14176e.H = r12;
        return;
    L42:
        r10.f14176e.f14200d = r12;
        return;
    L43:
        r10.f14174c.f14253b = r12;
        return;
    L44:
        r10.f14176e.f14202e = r12;
        return;
    L45:
        r10.f14176e.f14227q0 = r12;
        return;
    L46:
        r10.f14176e.U = r12;
        return;
    L47:
        r10.f14176e.N = r12;
        return;
    L48:
        r10.f14174c.f14254c = r12;
        return;
    L49:
        r10.f14175d.f14242e = r12;
        return;
    L50:
        r10.f14175d.f14243f = r12;
        return;
    L51:
        r10.f14175d.f14239b = r12;
        return;
    L52:
        r10.f14172a = r12;
        return;
    L53:
        r10.f14176e.f14193J = r12;
        return;
    L54:
        r10.f14176e.M = r12;
        return;
    L55:
        r10.f14176e.f14206g = r12;
        return;
    L56:
        r10.f14176e.f14204f = r12;
        return;
    L57:
        r10.f14176e.P = r12;
        return;
    L58:
        r10.f14176e.T = r12;
        return;
    L59:
        r10.f14176e.Q = r12;
        return;
    L60:
        r10.f14176e.O = r12;
        return;
    L61:
        r10.f14176e.S = r12;
        return;
    L62:
        r10.f14176e.R = r12;
        return;
    L63:
        r10.f14176e.K = r12;
        return;
    L64:
        r10.f14176e.f14211i0 = r12;
    }

    public static void N(C0195a r10, int r11, String r12) {
        if (r11 != 5) goto L5;
        r10.f14176e.A = r12;
        return;
    L5:
        if (r11 != 65) goto L7;
        r10.f14175d.f14241d = r12;
        return;
    L7:
        if (r11 != 74) goto L9;
        b r13 = r10.f14176e;
        r13.f14217l0 = r12;
        r13.f14215k0 = null;
        return;
    L9:
        if (r11 != 77) goto L11;
        r10.f14176e.f14219m0 = r12;
        return;
    L11:
        if (r11 != 87) goto L13;
        return;
    L13:
        if (r11 == 90) goto L15;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L15:
        r10.f14175d.f14249l = r12;
    }

    public static void O(C0195a r10, int r11, boolean r12) {
        if (r11 != 44) goto L5;
        r10.f14177f.f14270m = r12;
        return;
    L5:
        if (r11 != 75) goto L7;
        r10.f14176e.f14225p0 = r12;
        return;
    L7:
        if (r11 != 87) goto L9;
        return;
    L9:
        if (r11 != 80) goto L11;
        r10.f14176e.f14221n0 = r12;
        return;
    L11:
        if (r11 == 81) goto L13;
        Log.w("ConstraintSet", "Unknown attribute 0x");
        return;
    L13:
        r10.f14176e.f14223o0 = r12;
    }

    public static /* synthetic */ int a(TypedArray r10, int r11, int r12) {
        return D(r10, r11, r12);
    }

    public static /* synthetic */ int[] b() {
        return f14161i;
    }

    public static /* synthetic */ void c(C0195a r10, int r11, int r12) {
        M(r10, r11, r12);
    }

    public static /* synthetic */ void d(C0195a r10, int r11, float r12) {
        L(r10, r11, r12);
    }

    public static /* synthetic */ void e(C0195a r10, int r11, String r12) {
        N(r10, r11, r12);
    }

    public static /* synthetic */ void f(C0195a r10, int r11, boolean r12) {
        O(r10, r11, r12);
    }

    public static C0195a m(Context r10, XmlPullParser r11) {
        AttributeSet r12 = Xml.asAttributeSet(r11);
        C0195a r13 = new C0195a();
        TypedArray r14 = r10.obtainStyledAttributes(r12, R$styleable.ConstraintOverride);
        I(r13, r14);
        r14.recycle();
        return r13;
    }

    public int A(int r10) {
        return t(r10).f14176e.f14200d;
    }

    public void B(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L12 XmlPullParserException -> L14
    L5:
        if (r13 == 1) goto L29;
        if (r13 != 2) goto L17;
        String r14 = r12.getName();     // Catch: IOException -> L12 XmlPullParserException -> L14
        C0195a r15 = s(r10, Xml.asAttributeSet(r12), false);     // Catch: IOException -> L12 XmlPullParserException -> L14
        if (r14.equalsIgnoreCase("Guideline") == false) goto L16;
        r15.f14176e.f14194a = true;     // Catch: IOException -> L12 XmlPullParserException -> L14
    L16:
        this.f14171h.put(Integer.valueOf(r15.f14172a), r15);     // Catch: IOException -> L12 XmlPullParserException -> L14
    L17:
        r13 = r12.next();     // Catch: IOException -> L12 XmlPullParserException -> L14
    L29:
        return;
    L12:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing resource: " + r11, e);
        return;
    L14:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing resource: " + r11, e);
    }

    public void C(Context r12, XmlPullParser r13) {
        int r10 = r13.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
        C0195a r11 = null;
    L5:
        if (r10 == 1) goto L126;
        if (r10 == 0) goto L97;
        byte r14 = -1;
        if (r10 == 2) goto L37;
        if (r10 != 3) goto L98;
        String r15 = r13.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L17 XmlPullParserException -> L19
        switch(r15.hashCode()) {
            case -2075718416: goto L28;
            case -190376483: goto L25;
            case 426575017: goto L22;
            case 2146106725: goto L15;
            default: goto L30;
        };     // Catch: IOException -> L17 XmlPullParserException -> L19
    L30:
        if (r14 == 0) goto L36;
        if (r14 == 1) goto L35;
        if (r14 == 2) goto L35;
        if (r14 != 3) goto L98;
    L35:
        this.f14171h.put(Integer.valueOf(r11.f14172a), r11);     // Catch: IOException -> L17 XmlPullParserException -> L19
        r11 = null;
        goto L98
    L36:
        return;
    L15:
        if (r15.equals("constraintset") == false) goto L30;
        r14 = 0;
        goto L30
    L22:
        if (r15.equals("constraintoverride") == false) goto L30;
        r14 = 2;
        goto L30
    L25:
        if (r15.equals("constraint") == false) goto L30;
        r14 = 1;
        goto L30
    L28:
        if (r15.equals("guideline") == false) goto L30;
        r14 = 3;
    L98:
        r10 = r13.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L5
    L37:
        String r16 = r13.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        switch(r16.hashCode()) {
            case -2025855158: goto L68;
            case -1984451626: goto L65;
            case -1962203927: goto L62;
            case -1269513683: goto L59;
            case -1238332596: goto L56;
            case -71750448: goto L53;
            case 366511058: goto L50;
            case 1331510167: goto L47;
            case 1791837707: goto L44;
            case 1803088381: goto L41;
            default: goto L71;
        };     // Catch: IOException -> L17 XmlPullParserException -> L19
    L71:
        switch(r14) {
            case 0: goto L96;
            case 1: goto L95;
            case 2: goto L94;
            case 3: goto L93;
            case 4: goto L89;
            case 5: goto L85;
            case 6: goto L81;
            case 7: goto L77;
            case 8: goto L73;
            case 9: goto L73;
            default: goto L98;
        };
    L73:
        if (r11 == null) goto L76;
        ConstraintAttribute.i(r12, r13, r11.f14178g);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L76:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L77:
        if (r11 == null) goto L80;
        r11.f14175d.b(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L80:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L81:
        if (r11 == null) goto L84;
        r11.f14176e.b(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L84:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L85:
        if (r11 == null) goto L88;
        r11.f14177f.b(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L88:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L89:
        if (r11 == null) goto L92;
        r11.f14174c.b(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L92:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L93:
        r11 = s(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        r11.f14176e.f14213j0 = 1;     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L94:
        r11 = s(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        b r17 = r11.f14176e;     // Catch: IOException -> L17 XmlPullParserException -> L19
        r17.f14194a = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
        r17.f14196b = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L95:
        r11 = s(r12, Xml.asAttributeSet(r13), true);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L96:
        r11 = s(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L41:
        if (r16.equals("Constraint") == false) goto L71;
        r14 = 0;
        goto L71
    L44:
        if (r16.equals("CustomAttribute") == false) goto L71;
        r14 = 8;
        goto L71
    L47:
        if (r16.equals("Barrier") == false) goto L71;
        r14 = 3;
        goto L71
    L50:
        if (r16.equals("CustomMethod") == false) goto L71;
        r14 = 9;
        goto L71
    L53:
        if (r16.equals("Guideline") == false) goto L71;
        r14 = 2;
        goto L71
    L56:
        if (r16.equals("Transform") == false) goto L71;
        r14 = 5;
        goto L71
    L59:
        if (r16.equals("PropertySet") == false) goto L71;
        r14 = 4;
        goto L71
    L62:
        if (r16.equals("ConstraintOverride") == false) goto L71;
        r14 = 1;
        goto L71
    L65:
        if (r16.equals("Motion") == false) goto L71;
        r14 = 7;
        goto L71
    L68:
        if (r16.equals("Layout") == false) goto L71;
        r14 = 6;
        goto L71
    L97:
        r13.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L126:
        return;
    L17:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing XML resource", e);
        return;
    L19:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing XML resource", e);
    }

    public final void H(C0195a r10, TypedArray r11, boolean r12) {
        if (r12 == false) goto L5;
        I(r10, r11);
        return;
    L5:
        int r13 = r11.getIndexCount();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L125;
        int r15 = r11.getIndex(r14);
        if (r15 == R$styleable.Constraint_android_id) goto L15;
        if (R$styleable.Constraint_android_layout_marginStart == r15) goto L15;
        if (R$styleable.Constraint_android_layout_marginEnd == r15) goto L15;
        r10.f14175d.f14238a = true;
        r10.f14176e.f14196b = true;
        r10.f14174c.f14252a = true;
        r10.f14177f.f14258a = true;
    L15:
        switch(f14162j.get(r15)) {
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
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r15) + "   " + f14162j.get(r15));
    L124:
        r14 = r14 + 1;
        goto L6
    L17:
        b r16 = r10.f14176e;
        r16.f14227q0 = r11.getInt(r15, r16.f14227q0);
        goto L124
    L18:
        E(r10.f14176e, r11, r15, 1);
        goto L124
    L19:
        E(r10.f14176e, r11, r15, 0);
        goto L124
    L20:
        b r17 = r10.f14176e;
        r17.U = r11.getDimensionPixelSize(r15, r17.U);
        goto L124
    L21:
        b r18 = r10.f14176e;
        r18.N = r11.getDimensionPixelSize(r15, r18.N);
        goto L124
    L22:
        b r19 = r10.f14176e;
        r19.f14230t = D(r11, r15, r19.f14230t);
        goto L124
    L23:
        b r20 = r10.f14176e;
        r20.f14229s = D(r11, r15, r20.f14229s);
        goto L124
    L24:
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r15) + "   " + f14162j.get(r15));
        goto L124
    L25:
        int r21 = r11.peekValue(r15).type;
        if (r21 != 1) goto L30;
        r10.f14175d.f14251n = r11.getResourceId(r15, -1);
        c r22 = r10.f14175d;
        if (r22.f14251n == (-1)) goto L124;
        r22.f14250m = -2;
        goto L124
    L30:
        if (r21 != 3) goto L35;
        r10.f14175d.f14249l = r11.getString(r15);
        if (r10.f14175d.f14249l.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L34;
        r10.f14175d.f14251n = r11.getResourceId(r15, -1);
        r10.f14175d.f14250m = -2;
        goto L124
    L34:
        r10.f14175d.f14250m = -1;
        goto L124
    L35:
        c r23 = r10.f14175d;
        r23.f14250m = r11.getInteger(r15, r23.f14251n);
        goto L124
    L36:
        c r24 = r10.f14175d;
        r24.f14247j = r11.getFloat(r15, r24.f14247j);
        goto L124
    L37:
        c r25 = r10.f14175d;
        r25.f14248k = r11.getInteger(r15, r25.f14248k);
        goto L124
    L38:
        e r26 = r10.f14177f;
        r26.f14266i = D(r11, r15, r26.f14266i);
        goto L124
    L39:
        c r27 = r10.f14175d;
        r27.f14240c = r11.getInteger(r15, r27.f14240c);
        goto L124
    L40:
        b r28 = r10.f14176e;
        r28.f14223o0 = r11.getBoolean(r15, r28.f14223o0);
        goto L124
    L41:
        b r29 = r10.f14176e;
        r29.f14221n0 = r11.getBoolean(r15, r29.f14221n0);
        goto L124
    L42:
        c r30 = r10.f14175d;
        r30.f14244g = r11.getFloat(r15, r30.f14244g);
        goto L124
    L43:
        d r31 = r10.f14174c;
        r31.f14254c = r11.getInt(r15, r31.f14254c);
        goto L124
    L44:
        r10.f14176e.f14219m0 = r11.getString(r15);
        goto L124
    L45:
        c r32 = r10.f14175d;
        r32.f14242e = r11.getInt(r15, r32.f14242e);
        goto L124
    L46:
        b r33 = r10.f14176e;
        r33.f14225p0 = r11.getBoolean(r15, r33.f14225p0);
        goto L124
    L47:
        r10.f14176e.f14217l0 = r11.getString(r15);
        goto L124
    L48:
        b r34 = r10.f14176e;
        r34.f14211i0 = r11.getDimensionPixelSize(r15, r34.f14211i0);
        goto L124
    L49:
        b r35 = r10.f14176e;
        r35.f14209h0 = r11.getInt(r15, r35.f14209h0);
        goto L124
    L50:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L124
    L51:
        r10.f14176e.f14207g0 = r11.getFloat(r15, 1.0f);
        goto L124
    L52:
        r10.f14176e.f14205f0 = r11.getFloat(r15, 1.0f);
        goto L124
    L53:
        d r36 = r10.f14174c;
        r36.f14256e = r11.getFloat(r15, r36.f14256e);
        goto L124
    L54:
        c r37 = r10.f14175d;
        r37.f14246i = r11.getFloat(r15, r37.f14246i);
        goto L124
    L55:
        r10.f14175d.f14243f = r11.getInt(r15, 0);
        goto L124
    L60:
        c r38 = r10.f14175d;
        r38.f14239b = D(r11, r15, r38.f14239b);
        goto L124
    L61:
        b r39 = r10.f14176e;
        r39.D = r11.getFloat(r15, r39.D);
        goto L124
    L62:
        b r40 = r10.f14176e;
        r40.C = r11.getDimensionPixelSize(r15, r40.C);
        goto L124
    L63:
        b r41 = r10.f14176e;
        r41.B = D(r11, r15, r41.B);
        goto L124
    L64:
        e r42 = r10.f14177f;
        r42.f14259b = r11.getFloat(r15, r42.f14259b);
        goto L124
    L65:
        b r43 = r10.f14176e;
        r43.f14203e0 = r11.getDimensionPixelSize(r15, r43.f14203e0);
        goto L124
    L66:
        b r44 = r10.f14176e;
        r44.f14201d0 = r11.getDimensionPixelSize(r15, r44.f14201d0);
        goto L124
    L67:
        b r45 = r10.f14176e;
        r45.f14199c0 = r11.getDimensionPixelSize(r15, r45.f14199c0);
        goto L124
    L68:
        b r46 = r10.f14176e;
        r46.f14197b0 = r11.getDimensionPixelSize(r15, r46.f14197b0);
        goto L124
    L69:
        b r47 = r10.f14176e;
        r47.f14195a0 = r11.getInt(r15, r47.f14195a0);
        goto L124
    L70:
        b r48 = r10.f14176e;
        r48.Z = r11.getInt(r15, r48.Z);
        goto L124
    L71:
        e r49 = r10.f14177f;
        r49.f14269l = r11.getDimension(r15, r49.f14269l);
        goto L124
    L72:
        e r50 = r10.f14177f;
        r50.f14268k = r11.getDimension(r15, r50.f14268k);
        goto L124
    L73:
        e r51 = r10.f14177f;
        r51.f14267j = r11.getDimension(r15, r51.f14267j);
        goto L124
    L74:
        e r52 = r10.f14177f;
        r52.f14265h = r11.getDimension(r15, r52.f14265h);
        goto L124
    L75:
        e r53 = r10.f14177f;
        r53.f14264g = r11.getDimension(r15, r53.f14264g);
        goto L124
    L76:
        e r54 = r10.f14177f;
        r54.f14263f = r11.getFloat(r15, r54.f14263f);
        goto L124
    L77:
        e r55 = r10.f14177f;
        r55.f14262e = r11.getFloat(r15, r55.f14262e);
        goto L124
    L78:
        e r56 = r10.f14177f;
        r56.f14261d = r11.getFloat(r15, r56.f14261d);
        goto L124
    L79:
        e r57 = r10.f14177f;
        r57.f14260c = r11.getFloat(r15, r57.f14260c);
        goto L124
    L80:
        e r58 = r10.f14177f;
        r58.f14270m = true;
        r58.f14271n = r11.getDimension(r15, r58.f14271n);
        goto L124
    L81:
        d r59 = r10.f14174c;
        r59.f14255d = r11.getFloat(r15, r59.f14255d);
        goto L124
    L82:
        b r60 = r10.f14176e;
        r60.Y = r11.getInt(r15, r60.Y);
        goto L124
    L83:
        b r61 = r10.f14176e;
        r61.X = r11.getInt(r15, r61.X);
        goto L124
    L84:
        b r62 = r10.f14176e;
        r62.V = r11.getFloat(r15, r62.V);
        goto L124
    L85:
        b r63 = r10.f14176e;
        r63.W = r11.getFloat(r15, r63.W);
        goto L124
    L86:
        r10.f14172a = r11.getResourceId(r15, r10.f14172a);
        goto L124
    L87:
        b r64 = r10.f14176e;
        r64.f14236z = r11.getFloat(r15, r64.f14236z);
        goto L124
    L88:
        b r65 = r10.f14176e;
        r65.f14220n = D(r11, r15, r65.f14220n);
        goto L124
    L89:
        b r66 = r10.f14176e;
        r66.f14222o = D(r11, r15, r66.f14222o);
        goto L124
    L90:
        b r67 = r10.f14176e;
        r67.f14193J = r11.getDimensionPixelSize(r15, r67.f14193J);
        goto L124
    L91:
        b r68 = r10.f14176e;
        r68.f14232v = D(r11, r15, r68.f14232v);
        goto L124
    L92:
        b r69 = r10.f14176e;
        r69.f14231u = D(r11, r15, r69.f14231u);
        goto L124
    L93:
        b r70 = r10.f14176e;
        r70.M = r11.getDimensionPixelSize(r15, r70.M);
        goto L124
    L94:
        b r71 = r10.f14176e;
        r71.f14218m = D(r11, r15, r71.f14218m);
        goto L124
    L95:
        b r72 = r10.f14176e;
        r72.f14216l = D(r11, r15, r72.f14216l);
        goto L124
    L96:
        b r73 = r10.f14176e;
        r73.I = r11.getDimensionPixelSize(r15, r73.I);
        goto L124
    L97:
        b r74 = r10.f14176e;
        r74.G = r11.getInt(r15, r74.G);
        goto L124
    L98:
        b r75 = r10.f14176e;
        r75.f14214k = D(r11, r15, r75.f14214k);
        goto L124
    L99:
        b r76 = r10.f14176e;
        r76.f14212j = D(r11, r15, r76.f14212j);
        goto L124
    L100:
        b r77 = r10.f14176e;
        r77.H = r11.getDimensionPixelSize(r15, r77.H);
        goto L124
    L101:
        b r78 = r10.f14176e;
        r78.f14200d = r11.getLayoutDimension(r15, r78.f14200d);
        goto L124
    L102:
        d r79 = r10.f14174c;
        r79.f14253b = r11.getInt(r15, r79.f14253b);
        d r80 = r10.f14174c;
        r80.f14253b = f14161i[r80.f14253b];
        goto L124
    L103:
        b r81 = r10.f14176e;
        r81.f14202e = r11.getLayoutDimension(r15, r81.f14202e);
        goto L124
    L104:
        b r82 = r10.f14176e;
        r82.f14235y = r11.getFloat(r15, r82.f14235y);
        goto L124
    L105:
        b r83 = r10.f14176e;
        r83.f14208h = r11.getFloat(r15, r83.f14208h);
        goto L124
    L106:
        b r84 = r10.f14176e;
        r84.f14206g = r11.getDimensionPixelOffset(r15, r84.f14206g);
        goto L124
    L107:
        b r85 = r10.f14176e;
        r85.f14204f = r11.getDimensionPixelOffset(r15, r85.f14204f);
        goto L124
    L108:
        b r86 = r10.f14176e;
        r86.P = r11.getDimensionPixelSize(r15, r86.P);
        goto L124
    L109:
        b r87 = r10.f14176e;
        r87.T = r11.getDimensionPixelSize(r15, r87.T);
        goto L124
    L110:
        b r88 = r10.f14176e;
        r88.Q = r11.getDimensionPixelSize(r15, r88.Q);
        goto L124
    L111:
        b r89 = r10.f14176e;
        r89.O = r11.getDimensionPixelSize(r15, r89.O);
        goto L124
    L112:
        b r90 = r10.f14176e;
        r90.S = r11.getDimensionPixelSize(r15, r90.S);
        goto L124
    L113:
        b r91 = r10.f14176e;
        r91.R = r11.getDimensionPixelSize(r15, r91.R);
        goto L124
    L114:
        b r92 = r10.f14176e;
        r92.f14233w = D(r11, r15, r92.f14233w);
        goto L124
    L115:
        b r93 = r10.f14176e;
        r93.f14234x = D(r11, r15, r93.f14234x);
        goto L124
    L116:
        b r94 = r10.f14176e;
        r94.L = r11.getDimensionPixelSize(r15, r94.L);
        goto L124
    L117:
        b r95 = r10.f14176e;
        r95.F = r11.getDimensionPixelOffset(r15, r95.F);
        goto L124
    L118:
        b r96 = r10.f14176e;
        r96.E = r11.getDimensionPixelOffset(r15, r96.E);
        goto L124
    L119:
        r10.f14176e.A = r11.getString(r15);
        goto L124
    L120:
        b r97 = r10.f14176e;
        r97.f14224p = D(r11, r15, r97.f14224p);
        goto L124
    L121:
        b r98 = r10.f14176e;
        r98.f14226q = D(r11, r15, r98.f14226q);
        goto L124
    L122:
        b r99 = r10.f14176e;
        r99.K = r11.getDimensionPixelSize(r15, r99.K);
        goto L124
    L123:
        b r100 = r10.f14176e;
        r100.f14228r = D(r11, r15, r100.f14228r);
        goto L124
    L57:
        if (r11.peekValue(r15).type != 3) goto L59;
        r10.f14175d.f14241d = r11.getString(r15);
        goto L124
    L59:
        r10.f14175d.f14241d = vc.c.f25151c[r11.getInteger(r15, 0)];
        goto L124
    L125:
        b r101 = r10.f14176e;
        if (r101.f14217l0 == null) goto L230;
        r101.f14215k0 = null;
        return;
    }

    public void J(ConstraintLayout r11) {
        int r10 = r11.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L39;
        View r13 = r11.getChildAt(r12);
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.f14170g == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.f14171h.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.f14171h.put(Integer.valueOf(r15), new C0195a());
    L14:
        C0195a r16 = (C0195a) this.f14171h.get(Integer.valueOf(r15));
        if (r16 == null) goto L38;
        if (r16.f14176e.f14196b == true) goto L25;
        C0195a.a(r16, r15, r14);
        if ((r13 instanceof ConstraintHelper) == false) goto L24;
        r16.f14176e.f14215k0 = ((ConstraintHelper) r13).getReferencedIds();
        if ((r13 instanceof Barrier) == false) goto L24;
        Barrier r17 = (Barrier) r13;
        r16.f14176e.f14225p0 = r17.getAllowsGoneWidget();
        r16.f14176e.f14209h0 = r17.getType();
        r16.f14176e.f14211i0 = r17.getMargin();
    L24:
        r16.f14176e.f14196b = true;
    L25:
        d r18 = r16.f14174c;
        if (r18.f14252a == true) goto L28;
        r18.f14253b = r13.getVisibility();
        r16.f14174c.f14255d = r13.getAlpha();
        r16.f14174c.f14252a = true;
    L28:
        e r19 = r16.f14177f;
        if (r19.f14258a == true) goto L38;
        r19.f14258a = true;
        r19.f14259b = r13.getRotation();
        r16.f14177f.f14260c = r13.getRotationX();
        r16.f14177f.f14261d = r13.getRotationY();
        r16.f14177f.f14262e = r13.getScaleX();
        r16.f14177f.f14263f = r13.getScaleY();
        float r20 = r13.getPivotX();
        float r21 = r13.getPivotY();
        if (r20 == 0.0d) goto L33;
    L34:
        e r22 = r16.f14177f;
        r22.f14264g = r20;
        r22.f14265h = r21;
    L35:
        r16.f14177f.f14267j = r13.getTranslationX();
        r16.f14177f.f14268k = r13.getTranslationY();
        r16.f14177f.f14269l = r13.getTranslationZ();
        e r23 = r16.f14177f;
        if (r23.f14270m == false) goto L38;
        r23.f14271n = r13.getElevation();
        goto L38
    L33:
        if (r21 == 0.0d) goto L35;
    L38:
        r12 = r12 + 1;
        goto L3
    }

    public void K(a r10) {
        Iterator r11 = r10.f14171h.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L29;
        Integer r12 = (Integer) r11.next();
        r12.intValue();
        C0195a r13 = (C0195a) r10.f14171h.get(r12);
        if (this.f14171h.containsKey(r12) == true) goto L8;
        this.f14171h.put(r12, new C0195a());
    L8:
        C0195a r14 = (C0195a) this.f14171h.get(r12);
        if (r14 == null) goto L4;
        b r15 = r14.f14176e;
        if (r15.f14196b == true) goto L14;
        r15.a(r13.f14176e);
    L14:
        d r16 = r14.f14174c;
        if (r16.f14252a == true) goto L17;
        r16.a(r13.f14174c);
    L17:
        e r17 = r14.f14177f;
        if (r17.f14258a == true) goto L20;
        r17.a(r13.f14177f);
    L20:
        c r18 = r14.f14175d;
        if (r18.f14238a == true) goto L23;
        r18.a(r13.f14175d);
    L23:
        Iterator r19 = r13.f14178g.keySet().iterator();
    L25:
        if (r19.hasNext() == false) goto L4;
        String r20 = (String) r19.next();
        if (r14.f14178g.containsKey(r20) == true) goto L25;
        r14.f14178g.put(r20, (ConstraintAttribute) r13.f14178g.get(r20));
        goto L25
    }

    public void P(boolean r10) {
        this.f14170g = r10;
    }

    public void Q(int r10, int r11) {
        t(r10).f14176e.f14206g = r11;
        t(r10).f14176e.f14204f = -1;
        t(r10).f14176e.f14208h = -1.0f;
    }

    public void R(String r10) {
        this.f14167d = r10.split(",");
        int r11 = 0;
    L3:
        String[] r12 = this.f14167d;
        if (r11 >= r12.length) goto L6;
        r12[r11] = r12[r11].trim();
        r11 = r11 + 1;
        goto L3
    }

    public void S(boolean r10) {
        this.f14164a = r10;
    }

    public void g(ConstraintLayout r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L21;
        View r13 = r10.getChildAt(r12);
        int r14 = r13.getId();
        if (this.f14171h.containsKey(Integer.valueOf(r14)) == true) goto L8;
        Log.w("ConstraintSet", "id unknown " + com.obric.oui.constraintlayout.motion.widget.a.d(r13));
    L20:
        r12 = r12 + 1;
        goto L3
    L8:
        if (this.f14170g == false) goto L15;
        if (r14 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.f14171h.containsKey(Integer.valueOf(r14)) == false) goto L20;
        C0195a r15 = (C0195a) this.f14171h.get(Integer.valueOf(r14));
        if (r15 == null) goto L20;
        ConstraintAttribute.j(r13, r15.f14178g);
        goto L20
    }

    public void h(a r10) {
        Iterator r11 = r10.f14171h.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L20;
        C0195a r12 = (C0195a) r11.next();
        if (r12.f14179h == null) goto L4;
        if (r12.f14173b == null) goto L10;
        Iterator r13 = this.f14171h.keySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L4;
        C0195a r14 = u(((Integer) r13.next()).intValue());
        String r15 = r14.f14176e.f14219m0;
        if (r15 == null) goto L13;
        if (r12.f14173b.matches(r15) == false) goto L13;
        r12.f14179h.e(r14);
        HashMap r16 = (HashMap) r12.f14178g.clone();
        r14.f14178g.putAll(r16);
        goto L13
    L10:
        C0195a r17 = u(r12.f14172a);
        r12.f14179h.e(r17);
        goto L4
    }

    public void i(ConstraintLayout r10) {
        k(r10, true);
        r10.setConstraintSet(null);
        r10.requestLayout();
    }

    public void j(ConstraintHelper r10, ConstraintWidget r11, ConstraintLayout.LayoutParams r12, SparseArray r13) {
        int r14 = r10.getId();
        if (this.f14171h.containsKey(Integer.valueOf(r14)) == false) goto L10;
        C0195a r15 = (C0195a) this.f14171h.get(Integer.valueOf(r14));
        if (r15 != null) goto L7;
        return;
    L7:
        if ((r11 instanceof wc.a) == false) goto L12;
        r10.l(r15, (wc.a) r11, r12, r13);
        return;
    L12:
        return;
    }

    public void k(ConstraintLayout r12, boolean r13) {
        int r10 = r12.getChildCount();
        HashSet r11 = new HashSet(this.f14171h.keySet());
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r10) goto L55;
        View r16 = r12.getChildAt(r15);
        int r17 = r16.getId();
        if (this.f14171h.containsKey(Integer.valueOf(r17)) == true) goto L9;
        Log.w("ConstraintSet", "id unknown " + com.obric.oui.constraintlayout.motion.widget.a.d(r16));
    L54:
        r15 = r15 + 1;
        goto L4
    L9:
        if (this.f14170g == false) goto L14;
        if (r17 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r17 == (-1)) goto L54;
        if (this.f14171h.containsKey(Integer.valueOf(r17)) == false) goto L53;
        r11.remove(Integer.valueOf(r17));
        C0195a r18 = (C0195a) this.f14171h.get(Integer.valueOf(r17));
        if (r18 == null) goto L54;
        if ((r16 instanceof Barrier) == false) goto L29;
        r18.f14176e.f14213j0 = 1;
        Barrier r19 = (Barrier) r16;
        r19.setId(r17);
        r19.setType(r18.f14176e.f14209h0);
        r19.setMargin(r18.f14176e.f14211i0);
        r19.setAllowsGoneWidget(r18.f14176e.f14225p0);
        b r20 = r18.f14176e;
        int[] r21 = r20.f14215k0;
        if (r21 == null) goto L26;
        r19.setReferencedIds(r21);
        goto L29
    L26:
        String r22 = r20.f14217l0;
        if (r22 == null) goto L29;
        r20.f14215k0 = r(r19, r22);
        r19.setReferencedIds(r18.f14176e.f14215k0);
    L29:
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r16.getLayoutParams();
        r23.c();
        r18.e(r23);
        if (r13 == false) goto L32;
        ConstraintAttribute.j(r16, r18.f14178g);
    L32:
        r16.setLayoutParams(r23);
        d r24 = r18.f14174c;
        if (r24.f14254c != 0) goto L35;
        r16.setVisibility(r24.f14253b);
    L35:
        r16.setAlpha(r18.f14174c.f14255d);
        r16.setRotation(r18.f14177f.f14259b);
        r16.setRotationX(r18.f14177f.f14260c);
        r16.setRotationY(r18.f14177f.f14261d);
        r16.setScaleX(r18.f14177f.f14262e);
        r16.setScaleY(r18.f14177f.f14263f);
        e r25 = r18.f14177f;
        if (r25.f14266i == (-1)) goto L45;
        View r26 = ((View) r16.getParent()).findViewById(r18.f14177f.f14266i);
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
        r16.setTranslationX(r18.f14177f.f14267j);
        r16.setTranslationY(r18.f14177f.f14268k);
        r16.setTranslationZ(r18.f14177f.f14269l);
        e r31 = r18.f14177f;
        if (r31.f14270m == false) goto L54;
        r16.setElevation(r31.f14271n);
        goto L54
    L45:
        if (Float.isNaN(r25.f14264g) == true) goto L48;
        r16.setPivotX(r18.f14177f.f14264g);
    L48:
        if (Float.isNaN(r18.f14177f.f14265h) == true) goto L50;
        r16.setPivotY(r18.f14177f.f14265h);
        goto L50
    L53:
        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + r17);
        goto L54
    L55:
        Iterator r110 = r11.iterator();
    L57:
        if (r110.hasNext() == false) goto L73;
        Integer r32 = (Integer) r110.next();
        C0195a r33 = (C0195a) this.f14171h.get(r32);
        if (r33 == null) goto L57;
        if (r33.f14176e.f14213j0 != 1) goto L71;
        Barrier r34 = new Barrier(r12.getContext());
        r34.setId(r32.intValue());
        b r35 = r33.f14176e;
        int[] r36 = r35.f14215k0;
        if (r36 == null) goto L66;
        r34.setReferencedIds(r36);
    L69:
        r34.setType(r33.f14176e.f14209h0);
        r34.setMargin(r33.f14176e.f14211i0);
        ConstraintLayout.LayoutParams r37 = r12.f();
        r34.s();
        r33.e(r37);
        r12.addView(r34, r37);
        goto L71
    L66:
        String r38 = r35.f14217l0;
        if (r38 == null) goto L69;
        r35.f14215k0 = r(r34, r38);
        r34.setReferencedIds(r33.f14176e.f14215k0);
    L71:
        if (r33.f14176e.f14194a == false) goto L57;
        View r39 = new Guideline(r12.getContext());
        r39.setId(r32.intValue());
        ConstraintLayout.LayoutParams r40 = r12.f();
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
        if (this.f14171h.containsKey(Integer.valueOf(r10)) == false) goto L8;
        C0195a r12 = (C0195a) this.f14171h.get(Integer.valueOf(r10));
        if (r12 == null) goto L9;
        r12.e(r11);
        return;
    L9:
        return;
    }

    public void n(Context r10, int r11) {
        o((ConstraintLayout) LayoutInflater.from(r10).inflate(r11, null));
    }

    public void o(ConstraintLayout r11) {
        int r10 = r11.getChildCount();
        this.f14171h.clear();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L29;
        View r13 = r11.getChildAt(r12);
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.f14170g == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.f14171h.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.f14171h.put(Integer.valueOf(r15), new C0195a());
    L14:
        C0195a r16 = (C0195a) this.f14171h.get(Integer.valueOf(r15));
        if (r16 == null) goto L28;
        r16.f14178g = ConstraintAttribute.b(this.f14169f, r13);
        C0195a.a(r16, r15, r14);
        r16.f14174c.f14253b = r13.getVisibility();
        r16.f14174c.f14255d = r13.getAlpha();
        r16.f14177f.f14259b = r13.getRotation();
        r16.f14177f.f14260c = r13.getRotationX();
        r16.f14177f.f14261d = r13.getRotationY();
        r16.f14177f.f14262e = r13.getScaleX();
        r16.f14177f.f14263f = r13.getScaleY();
        float r17 = r13.getPivotX();
        float r18 = r13.getPivotY();
        if (r17 == 0.0d) goto L20;
    L21:
        e r19 = r16.f14177f;
        r19.f14264g = r17;
        r19.f14265h = r18;
    L22:
        r16.f14177f.f14267j = r13.getTranslationX();
        r16.f14177f.f14268k = r13.getTranslationY();
        r16.f14177f.f14269l = r13.getTranslationZ();
        e r20 = r16.f14177f;
        if (r20.f14270m == false) goto L26;
        r20.f14271n = r13.getElevation();
    L26:
        if ((r13 instanceof Barrier) == false) goto L28;
        Barrier r21 = (Barrier) r13;
        r16.f14176e.f14225p0 = r21.getAllowsGoneWidget();
        r16.f14176e.f14215k0 = r21.getReferencedIds();
        r16.f14176e.f14209h0 = r21.getType();
        r16.f14176e.f14211i0 = r21.getMargin();
        goto L28
    L20:
        if (r18 == 0.0d) goto L22;
    L28:
        r12 = r12 + 1;
        goto L3
    }

    public void p(a r10) {
        this.f14171h.clear();
        Iterator r11 = r10.f14171h.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Integer r12 = (Integer) r11.next();
        C0195a r13 = (C0195a) r10.f14171h.get(r12);
        if (r13 == null) goto L4;
        this.f14171h.put(r12, r13.f());
        goto L4
    }

    public void q(Constraints r10) {
        int r11 = r10.getChildCount();
        this.f14171h.clear();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L22;
        View r13 = r10.getChildAt(r12);
        Constraints.LayoutParams r14 = (Constraints.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.f14170g == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.f14171h.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.f14171h.put(Integer.valueOf(r15), new C0195a());
    L14:
        C0195a r16 = (C0195a) this.f14171h.get(Integer.valueOf(r15));
        if (r16 == null) goto L21;
        if ((r13 instanceof ConstraintHelper) == false) goto L20;
        C0195a.b(r16, (ConstraintHelper) r13, r15, r14);
    L20:
        C0195a.c(r16, r15, r14);
    L21:
        r12 = r12 + 1;
        goto L3
    }

    public final int[] r(View r10, String r11) {
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
        Object r19 = ((ConstraintLayout) r10.getParent()).h(0, r17);
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

    public final C0195a s(Context r10, AttributeSet r11, boolean r12) {
        C0195a r13 = new C0195a();
        if (r12 == false) goto L5;
        int[] r14 = R$styleable.ConstraintOverride;
    L6:
        TypedArray r15 = r10.obtainStyledAttributes(r11, r14);
        H(r13, r15, r12);
        r15.recycle();
        return r13;
    L5:
        r14 = R$styleable.Constraint;
        goto L6
    }

    public final C0195a t(int r10) {
        if (this.f14171h.containsKey(Integer.valueOf(r10)) == true) goto L6;
        this.f14171h.put(Integer.valueOf(r10), new C0195a());
    L6:
        return (C0195a) this.f14171h.get(Integer.valueOf(r10));
    }

    public C0195a u(int r10) {
        if (this.f14171h.containsKey(Integer.valueOf(r10)) == true) goto L5;
        return null;
    L5:
        return (C0195a) this.f14171h.get(Integer.valueOf(r10));
    }

    public int v(int r10) {
        return t(r10).f14176e.f14202e;
    }

    public int[] w() {
        int r10 = 0;
        Integer[] r11 = (Integer[]) this.f14171h.keySet().toArray(new Integer[0]);
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

    public C0195a x(int r10) {
        return t(r10);
    }

    public int y(int r10) {
        return t(r10).f14174c.f14253b;
    }

    public int z(int r10) {
        return t(r10).f14174c.f14254c;
    }
}

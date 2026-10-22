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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import m0.C4890c;
import o0.C4994b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f12710i = {0, 4, 8};

    /* renamed from: j, reason: collision with root package name */
    public static SparseIntArray f12711j = new SparseIntArray();

    /* renamed from: k, reason: collision with root package name */
    public static SparseIntArray f12712k = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    public boolean f12713a;

    /* renamed from: b, reason: collision with root package name */
    public String f12714b;

    /* renamed from: c, reason: collision with root package name */
    public String f12715c = "";

    /* renamed from: d, reason: collision with root package name */
    public String[] f12716d = new String[0];

    /* renamed from: e, reason: collision with root package name */
    public int f12717e = 0;

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f12718f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    public boolean f12719g = true;

    /* renamed from: h, reason: collision with root package name */
    public HashMap<Integer, a> f12720h = new HashMap<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f12721a;

        /* renamed from: b, reason: collision with root package name */
        public String f12722b;

        /* renamed from: c, reason: collision with root package name */
        public final d f12723c = new d();

        /* renamed from: d, reason: collision with root package name */
        public final C0154c f12724d = new C0154c();

        /* renamed from: e, reason: collision with root package name */
        public final b f12725e = new b();

        /* renamed from: f, reason: collision with root package name */
        public final e f12726f = new e();

        /* renamed from: g, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f12727g = new HashMap<>();

        /* renamed from: h, reason: collision with root package name */
        public C0153a f12728h;

        /* renamed from: androidx.constraintlayout.widget.c$a$a, reason: collision with other inner class name */
        public static class C0153a {

            /* renamed from: a, reason: collision with root package name */
            public int[] f12729a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            public int[] f12730b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            public int f12731c = 0;

            /* renamed from: d, reason: collision with root package name */
            public int[] f12732d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            public float[] f12733e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            public int f12734f = 0;

            /* renamed from: g, reason: collision with root package name */
            public int[] f12735g = new int[5];

            /* renamed from: h, reason: collision with root package name */
            public String[] f12736h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            public int f12737i = 0;

            /* renamed from: j, reason: collision with root package name */
            public int[] f12738j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            public boolean[] f12739k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            public int f12740l = 0;

            public void a(int i10, float f10) {
                int i11 = this.f12734f;
                int[] iArr = this.f12732d;
                if (i11 >= iArr.length) {
                    this.f12732d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f12733e;
                    this.f12733e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f12732d;
                int i12 = this.f12734f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f12733e;
                this.f12734f = i12 + 1;
                fArr2[i12] = f10;
            }

            public void b(int i10, int i11) {
                int i12 = this.f12731c;
                int[] iArr = this.f12729a;
                if (i12 >= iArr.length) {
                    this.f12729a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f12730b;
                    this.f12730b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f12729a;
                int i13 = this.f12731c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f12730b;
                this.f12731c = i13 + 1;
                iArr4[i13] = i11;
            }

            public void c(int i10, String str) {
                int i11 = this.f12737i;
                int[] iArr = this.f12735g;
                if (i11 >= iArr.length) {
                    this.f12735g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f12736h;
                    this.f12736h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f12735g;
                int i12 = this.f12737i;
                iArr2[i12] = i10;
                String[] strArr2 = this.f12736h;
                this.f12737i = i12 + 1;
                strArr2[i12] = str;
            }

            public void d(int i10, boolean z10) {
                int i11 = this.f12740l;
                int[] iArr = this.f12738j;
                if (i11 >= iArr.length) {
                    this.f12738j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f12739k;
                    this.f12739k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f12738j;
                int i12 = this.f12740l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f12739k;
                this.f12740l = i12 + 1;
                zArr2[i12] = z10;
            }

            public void e(a aVar) {
                for (int i10 = 0; i10 < this.f12731c; i10++) {
                    c.U(aVar, this.f12729a[i10], this.f12730b[i10]);
                }
                for (int i11 = 0; i11 < this.f12734f; i11++) {
                    c.T(aVar, this.f12732d[i11], this.f12733e[i11]);
                }
                for (int i12 = 0; i12 < this.f12737i; i12++) {
                    c.V(aVar, this.f12735g[i12], this.f12736h[i12]);
                }
                for (int i13 = 0; i13 < this.f12740l; i13++) {
                    c.W(aVar, this.f12738j[i13], this.f12739k[i13]);
                }
            }
        }

        public void d(a aVar) {
            C0153a c0153a = this.f12728h;
            if (c0153a != null) {
                c0153a.e(aVar);
            }
        }

        public void e(ConstraintLayout.b bVar) {
            b bVar2 = this.f12725e;
            bVar.f12634e = bVar2.f12786j;
            bVar.f12636f = bVar2.f12788k;
            bVar.f12638g = bVar2.f12790l;
            bVar.f12640h = bVar2.f12792m;
            bVar.f12642i = bVar2.f12794n;
            bVar.f12644j = bVar2.f12796o;
            bVar.f12646k = bVar2.f12798p;
            bVar.f12648l = bVar2.f12800q;
            bVar.f12650m = bVar2.f12802r;
            bVar.f12652n = bVar2.f12803s;
            bVar.f12654o = bVar2.f12804t;
            bVar.f12662s = bVar2.f12805u;
            bVar.f12664t = bVar2.f12806v;
            bVar.f12666u = bVar2.f12807w;
            bVar.f12668v = bVar2.f12808x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.f12749H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.f12750I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.f12751J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.f12752K;
            bVar.f12600A = bVar2.f12761T;
            bVar.f12601B = bVar2.f12760S;
            bVar.f12672x = bVar2.f12757P;
            bVar.f12674z = bVar2.f12759R;
            bVar.f12606G = bVar2.f12809y;
            bVar.f12607H = bVar2.f12810z;
            bVar.f12656p = bVar2.f12743B;
            bVar.f12658q = bVar2.f12744C;
            bVar.f12660r = bVar2.f12745D;
            bVar.f12608I = bVar2.f12742A;
            bVar.f12623X = bVar2.f12746E;
            bVar.f12624Y = bVar2.f12747F;
            bVar.f12612M = bVar2.f12763V;
            bVar.f12611L = bVar2.f12764W;
            bVar.f12614O = bVar2.f12766Y;
            bVar.f12613N = bVar2.f12765X;
            bVar.f12627a0 = bVar2.f12795n0;
            bVar.f12629b0 = bVar2.f12797o0;
            bVar.f12615P = bVar2.f12767Z;
            bVar.f12616Q = bVar2.f12769a0;
            bVar.f12619T = bVar2.f12771b0;
            bVar.f12620U = bVar2.f12773c0;
            bVar.f12617R = bVar2.f12775d0;
            bVar.f12618S = bVar2.f12777e0;
            bVar.f12621V = bVar2.f12779f0;
            bVar.f12622W = bVar2.f12781g0;
            bVar.f12625Z = bVar2.f12748G;
            bVar.f12630c = bVar2.f12782h;
            bVar.f12626a = bVar2.f12778f;
            bVar.f12628b = bVar2.f12780g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f12774d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f12776e;
            String str = bVar2.f12793m0;
            if (str != null) {
                bVar.f12631c0 = str;
            }
            bVar.f12633d0 = bVar2.f12801q0;
            bVar.setMarginStart(bVar2.f12754M);
            bVar.setMarginEnd(this.f12725e.f12753L);
            bVar.b();
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f12725e.a(this.f12725e);
            aVar.f12724d.a(this.f12724d);
            aVar.f12723c.a(this.f12723c);
            aVar.f12726f.a(this.f12726f);
            aVar.f12721a = this.f12721a;
            aVar.f12728h = this.f12728h;
            return aVar;
        }

        public final void g(int i10, ConstraintLayout.b bVar) {
            this.f12721a = i10;
            b bVar2 = this.f12725e;
            bVar2.f12786j = bVar.f12634e;
            bVar2.f12788k = bVar.f12636f;
            bVar2.f12790l = bVar.f12638g;
            bVar2.f12792m = bVar.f12640h;
            bVar2.f12794n = bVar.f12642i;
            bVar2.f12796o = bVar.f12644j;
            bVar2.f12798p = bVar.f12646k;
            bVar2.f12800q = bVar.f12648l;
            bVar2.f12802r = bVar.f12650m;
            bVar2.f12803s = bVar.f12652n;
            bVar2.f12804t = bVar.f12654o;
            bVar2.f12805u = bVar.f12662s;
            bVar2.f12806v = bVar.f12664t;
            bVar2.f12807w = bVar.f12666u;
            bVar2.f12808x = bVar.f12668v;
            bVar2.f12809y = bVar.f12606G;
            bVar2.f12810z = bVar.f12607H;
            bVar2.f12742A = bVar.f12608I;
            bVar2.f12743B = bVar.f12656p;
            bVar2.f12744C = bVar.f12658q;
            bVar2.f12745D = bVar.f12660r;
            bVar2.f12746E = bVar.f12623X;
            bVar2.f12747F = bVar.f12624Y;
            bVar2.f12748G = bVar.f12625Z;
            bVar2.f12782h = bVar.f12630c;
            bVar2.f12778f = bVar.f12626a;
            bVar2.f12780g = bVar.f12628b;
            bVar2.f12774d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f12776e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.f12749H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.f12750I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.f12751J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.f12752K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.f12755N = bVar.f12603D;
            bVar2.f12763V = bVar.f12612M;
            bVar2.f12764W = bVar.f12611L;
            bVar2.f12766Y = bVar.f12614O;
            bVar2.f12765X = bVar.f12613N;
            bVar2.f12795n0 = bVar.f12627a0;
            bVar2.f12797o0 = bVar.f12629b0;
            bVar2.f12767Z = bVar.f12615P;
            bVar2.f12769a0 = bVar.f12616Q;
            bVar2.f12771b0 = bVar.f12619T;
            bVar2.f12773c0 = bVar.f12620U;
            bVar2.f12775d0 = bVar.f12617R;
            bVar2.f12777e0 = bVar.f12618S;
            bVar2.f12779f0 = bVar.f12621V;
            bVar2.f12781g0 = bVar.f12622W;
            bVar2.f12793m0 = bVar.f12631c0;
            bVar2.f12757P = bVar.f12672x;
            bVar2.f12759R = bVar.f12674z;
            bVar2.f12756O = bVar.f12670w;
            bVar2.f12758Q = bVar.f12673y;
            bVar2.f12761T = bVar.f12600A;
            bVar2.f12760S = bVar.f12601B;
            bVar2.f12762U = bVar.f12602C;
            bVar2.f12801q0 = bVar.f12633d0;
            bVar2.f12753L = bVar.getMarginEnd();
            this.f12725e.f12754M = bVar.getMarginStart();
        }

        public final void h(int i10, d.a aVar) {
            g(i10, aVar);
            this.f12723c.f12829d = aVar.f12857x0;
            e eVar = this.f12726f;
            eVar.f12833b = aVar.f12847A0;
            eVar.f12834c = aVar.f12848B0;
            eVar.f12835d = aVar.f12849C0;
            eVar.f12836e = aVar.f12850D0;
            eVar.f12837f = aVar.f12851E0;
            eVar.f12838g = aVar.f12852F0;
            eVar.f12839h = aVar.f12853G0;
            eVar.f12841j = aVar.f12854H0;
            eVar.f12842k = aVar.f12855I0;
            eVar.f12843l = aVar.f12856J0;
            eVar.f12845n = aVar.f12859z0;
            eVar.f12844m = aVar.f12858y0;
        }

        public final void i(androidx.constraintlayout.widget.a aVar, int i10, d.a aVar2) {
            h(i10, aVar2);
            if (aVar instanceof Barrier) {
                b bVar = this.f12725e;
                bVar.f12787j0 = 1;
                Barrier barrier = (Barrier) aVar;
                bVar.f12783h0 = barrier.getType();
                this.f12725e.f12789k0 = barrier.getReferencedIds();
                this.f12725e.f12785i0 = barrier.getMargin();
            }
        }
    }

    public static class b {

        /* renamed from: r0, reason: collision with root package name */
        public static SparseIntArray f12741r0;

        /* renamed from: d, reason: collision with root package name */
        public int f12774d;

        /* renamed from: e, reason: collision with root package name */
        public int f12776e;

        /* renamed from: k0, reason: collision with root package name */
        public int[] f12789k0;

        /* renamed from: l0, reason: collision with root package name */
        public String f12791l0;

        /* renamed from: m0, reason: collision with root package name */
        public String f12793m0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f12768a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12770b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f12772c = false;

        /* renamed from: f, reason: collision with root package name */
        public int f12778f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f12780g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f12782h = -1.0f;

        /* renamed from: i, reason: collision with root package name */
        public boolean f12784i = true;

        /* renamed from: j, reason: collision with root package name */
        public int f12786j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f12788k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f12790l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f12792m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f12794n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f12796o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f12798p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f12800q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f12802r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f12803s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f12804t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f12805u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f12806v = -1;

        /* renamed from: w, reason: collision with root package name */
        public int f12807w = -1;

        /* renamed from: x, reason: collision with root package name */
        public int f12808x = -1;

        /* renamed from: y, reason: collision with root package name */
        public float f12809y = 0.5f;

        /* renamed from: z, reason: collision with root package name */
        public float f12810z = 0.5f;

        /* renamed from: A, reason: collision with root package name */
        public String f12742A = null;

        /* renamed from: B, reason: collision with root package name */
        public int f12743B = -1;

        /* renamed from: C, reason: collision with root package name */
        public int f12744C = 0;

        /* renamed from: D, reason: collision with root package name */
        public float f12745D = 0.0f;

        /* renamed from: E, reason: collision with root package name */
        public int f12746E = -1;

        /* renamed from: F, reason: collision with root package name */
        public int f12747F = -1;

        /* renamed from: G, reason: collision with root package name */
        public int f12748G = -1;

        /* renamed from: H, reason: collision with root package name */
        public int f12749H = 0;

        /* renamed from: I, reason: collision with root package name */
        public int f12750I = 0;

        /* renamed from: J, reason: collision with root package name */
        public int f12751J = 0;

        /* renamed from: K, reason: collision with root package name */
        public int f12752K = 0;

        /* renamed from: L, reason: collision with root package name */
        public int f12753L = 0;

        /* renamed from: M, reason: collision with root package name */
        public int f12754M = 0;

        /* renamed from: N, reason: collision with root package name */
        public int f12755N = 0;

        /* renamed from: O, reason: collision with root package name */
        public int f12756O = Integer.MIN_VALUE;

        /* renamed from: P, reason: collision with root package name */
        public int f12757P = Integer.MIN_VALUE;

        /* renamed from: Q, reason: collision with root package name */
        public int f12758Q = Integer.MIN_VALUE;

        /* renamed from: R, reason: collision with root package name */
        public int f12759R = Integer.MIN_VALUE;

        /* renamed from: S, reason: collision with root package name */
        public int f12760S = Integer.MIN_VALUE;

        /* renamed from: T, reason: collision with root package name */
        public int f12761T = Integer.MIN_VALUE;

        /* renamed from: U, reason: collision with root package name */
        public int f12762U = Integer.MIN_VALUE;

        /* renamed from: V, reason: collision with root package name */
        public float f12763V = -1.0f;

        /* renamed from: W, reason: collision with root package name */
        public float f12764W = -1.0f;

        /* renamed from: X, reason: collision with root package name */
        public int f12765X = 0;

        /* renamed from: Y, reason: collision with root package name */
        public int f12766Y = 0;

        /* renamed from: Z, reason: collision with root package name */
        public int f12767Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f12769a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        public int f12771b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        public int f12773c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f12775d0 = 0;

        /* renamed from: e0, reason: collision with root package name */
        public int f12777e0 = 0;

        /* renamed from: f0, reason: collision with root package name */
        public float f12779f0 = 1.0f;

        /* renamed from: g0, reason: collision with root package name */
        public float f12781g0 = 1.0f;

        /* renamed from: h0, reason: collision with root package name */
        public int f12783h0 = -1;

        /* renamed from: i0, reason: collision with root package name */
        public int f12785i0 = 0;

        /* renamed from: j0, reason: collision with root package name */
        public int f12787j0 = -1;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f12795n0 = false;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f12797o0 = false;

        /* renamed from: p0, reason: collision with root package name */
        public boolean f12799p0 = true;

        /* renamed from: q0, reason: collision with root package name */
        public int f12801q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12741r0 = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f12741r0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f12741r0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f12741r0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            f12741r0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            f12741r0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f12741r0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f12741r0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f12741r0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f12741r0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            f12741r0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            f12741r0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            f12741r0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            f12741r0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            SparseIntArray sparseIntArray2 = f12741r0;
            int i10 = R$styleable.Layout_guidelineUseRtl;
            sparseIntArray2.append(i10, 90);
            f12741r0.append(R$styleable.Layout_android_orientation, 26);
            f12741r0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            f12741r0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            f12741r0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f12741r0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f12741r0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            f12741r0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            f12741r0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            f12741r0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            f12741r0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            f12741r0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            f12741r0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            f12741r0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            f12741r0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f12741r0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f12741r0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            f12741r0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            f12741r0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            f12741r0.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            f12741r0.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            f12741r0.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            f12741r0.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            f12741r0.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            f12741r0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            f12741r0.append(R$styleable.Layout_android_layout_marginRight, 27);
            f12741r0.append(R$styleable.Layout_android_layout_marginStart, 30);
            f12741r0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            f12741r0.append(R$styleable.Layout_android_layout_marginTop, 33);
            f12741r0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            f12741r0.append(R$styleable.Layout_android_layout_width, 22);
            f12741r0.append(R$styleable.Layout_android_layout_height, 21);
            SparseIntArray sparseIntArray3 = f12741r0;
            int i11 = R$styleable.Layout_layout_constraintWidth;
            sparseIntArray3.append(i11, 41);
            SparseIntArray sparseIntArray4 = f12741r0;
            int i12 = R$styleable.Layout_layout_constraintHeight;
            sparseIntArray4.append(i12, 42);
            f12741r0.append(R$styleable.Layout_layout_constrainedWidth, 87);
            f12741r0.append(R$styleable.Layout_layout_constrainedHeight, 88);
            f12741r0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            f12741r0.append(R$styleable.Layout_layout_constraintCircle, 61);
            f12741r0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            f12741r0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            f12741r0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            f12741r0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            f12741r0.append(R$styleable.Layout_chainUseRtl, 71);
            f12741r0.append(R$styleable.Layout_barrierDirection, 72);
            f12741r0.append(R$styleable.Layout_barrierMargin, 73);
            f12741r0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            f12741r0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
            SparseIntArray sparseIntArray5 = f12741r0;
            int i13 = R$styleable.Layout_layout_constraintWidth_max;
            sparseIntArray5.append(i13, 84);
            f12741r0.append(R$styleable.Layout_layout_constraintWidth_min, 86);
            f12741r0.append(i13, 83);
            f12741r0.append(R$styleable.Layout_layout_constraintHeight_min, 85);
            f12741r0.append(i11, 87);
            f12741r0.append(i12, 88);
            f12741r0.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
            f12741r0.append(i10, 90);
        }

        public void a(b bVar) {
            this.f12768a = bVar.f12768a;
            this.f12774d = bVar.f12774d;
            this.f12770b = bVar.f12770b;
            this.f12776e = bVar.f12776e;
            this.f12778f = bVar.f12778f;
            this.f12780g = bVar.f12780g;
            this.f12782h = bVar.f12782h;
            this.f12784i = bVar.f12784i;
            this.f12786j = bVar.f12786j;
            this.f12788k = bVar.f12788k;
            this.f12790l = bVar.f12790l;
            this.f12792m = bVar.f12792m;
            this.f12794n = bVar.f12794n;
            this.f12796o = bVar.f12796o;
            this.f12798p = bVar.f12798p;
            this.f12800q = bVar.f12800q;
            this.f12802r = bVar.f12802r;
            this.f12803s = bVar.f12803s;
            this.f12804t = bVar.f12804t;
            this.f12805u = bVar.f12805u;
            this.f12806v = bVar.f12806v;
            this.f12807w = bVar.f12807w;
            this.f12808x = bVar.f12808x;
            this.f12809y = bVar.f12809y;
            this.f12810z = bVar.f12810z;
            this.f12742A = bVar.f12742A;
            this.f12743B = bVar.f12743B;
            this.f12744C = bVar.f12744C;
            this.f12745D = bVar.f12745D;
            this.f12746E = bVar.f12746E;
            this.f12747F = bVar.f12747F;
            this.f12748G = bVar.f12748G;
            this.f12749H = bVar.f12749H;
            this.f12750I = bVar.f12750I;
            this.f12751J = bVar.f12751J;
            this.f12752K = bVar.f12752K;
            this.f12753L = bVar.f12753L;
            this.f12754M = bVar.f12754M;
            this.f12755N = bVar.f12755N;
            this.f12756O = bVar.f12756O;
            this.f12757P = bVar.f12757P;
            this.f12758Q = bVar.f12758Q;
            this.f12759R = bVar.f12759R;
            this.f12760S = bVar.f12760S;
            this.f12761T = bVar.f12761T;
            this.f12762U = bVar.f12762U;
            this.f12763V = bVar.f12763V;
            this.f12764W = bVar.f12764W;
            this.f12765X = bVar.f12765X;
            this.f12766Y = bVar.f12766Y;
            this.f12767Z = bVar.f12767Z;
            this.f12769a0 = bVar.f12769a0;
            this.f12771b0 = bVar.f12771b0;
            this.f12773c0 = bVar.f12773c0;
            this.f12775d0 = bVar.f12775d0;
            this.f12777e0 = bVar.f12777e0;
            this.f12779f0 = bVar.f12779f0;
            this.f12781g0 = bVar.f12781g0;
            this.f12783h0 = bVar.f12783h0;
            this.f12785i0 = bVar.f12785i0;
            this.f12787j0 = bVar.f12787j0;
            this.f12793m0 = bVar.f12793m0;
            int[] iArr = bVar.f12789k0;
            if (iArr == null || bVar.f12791l0 != null) {
                this.f12789k0 = null;
            } else {
                this.f12789k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f12791l0 = bVar.f12791l0;
            this.f12795n0 = bVar.f12795n0;
            this.f12797o0 = bVar.f12797o0;
            this.f12799p0 = bVar.f12799p0;
            this.f12801q0 = bVar.f12801q0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.f12770b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = f12741r0.get(index);
                switch (i11) {
                    case 1:
                        this.f12802r = c.L(typedArrayObtainStyledAttributes, index, this.f12802r);
                        break;
                    case 2:
                        this.f12752K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12752K);
                        break;
                    case 3:
                        this.f12800q = c.L(typedArrayObtainStyledAttributes, index, this.f12800q);
                        break;
                    case 4:
                        this.f12798p = c.L(typedArrayObtainStyledAttributes, index, this.f12798p);
                        break;
                    case 5:
                        this.f12742A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f12746E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12746E);
                        break;
                    case 7:
                        this.f12747F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12747F);
                        break;
                    case 8:
                        this.f12753L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12753L);
                        break;
                    case 9:
                        this.f12808x = c.L(typedArrayObtainStyledAttributes, index, this.f12808x);
                        break;
                    case 10:
                        this.f12807w = c.L(typedArrayObtainStyledAttributes, index, this.f12807w);
                        break;
                    case 11:
                        this.f12759R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12759R);
                        break;
                    case 12:
                        this.f12760S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12760S);
                        break;
                    case 13:
                        this.f12756O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12756O);
                        break;
                    case 14:
                        this.f12758Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12758Q);
                        break;
                    case 15:
                        this.f12761T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12761T);
                        break;
                    case 16:
                        this.f12757P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12757P);
                        break;
                    case 17:
                        this.f12778f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12778f);
                        break;
                    case 18:
                        this.f12780g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f12780g);
                        break;
                    case 19:
                        this.f12782h = typedArrayObtainStyledAttributes.getFloat(index, this.f12782h);
                        break;
                    case 20:
                        this.f12809y = typedArrayObtainStyledAttributes.getFloat(index, this.f12809y);
                        break;
                    case 21:
                        this.f12776e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f12776e);
                        break;
                    case 22:
                        this.f12774d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f12774d);
                        break;
                    case 23:
                        this.f12749H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12749H);
                        break;
                    case 24:
                        this.f12786j = c.L(typedArrayObtainStyledAttributes, index, this.f12786j);
                        break;
                    case 25:
                        this.f12788k = c.L(typedArrayObtainStyledAttributes, index, this.f12788k);
                        break;
                    case 26:
                        this.f12748G = typedArrayObtainStyledAttributes.getInt(index, this.f12748G);
                        break;
                    case 27:
                        this.f12750I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12750I);
                        break;
                    case 28:
                        this.f12790l = c.L(typedArrayObtainStyledAttributes, index, this.f12790l);
                        break;
                    case 29:
                        this.f12792m = c.L(typedArrayObtainStyledAttributes, index, this.f12792m);
                        break;
                    case 30:
                        this.f12754M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12754M);
                        break;
                    case 31:
                        this.f12805u = c.L(typedArrayObtainStyledAttributes, index, this.f12805u);
                        break;
                    case 32:
                        this.f12806v = c.L(typedArrayObtainStyledAttributes, index, this.f12806v);
                        break;
                    case 33:
                        this.f12751J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12751J);
                        break;
                    case 34:
                        this.f12796o = c.L(typedArrayObtainStyledAttributes, index, this.f12796o);
                        break;
                    case 35:
                        this.f12794n = c.L(typedArrayObtainStyledAttributes, index, this.f12794n);
                        break;
                    case 36:
                        this.f12810z = typedArrayObtainStyledAttributes.getFloat(index, this.f12810z);
                        break;
                    case 37:
                        this.f12764W = typedArrayObtainStyledAttributes.getFloat(index, this.f12764W);
                        break;
                    case 38:
                        this.f12763V = typedArrayObtainStyledAttributes.getFloat(index, this.f12763V);
                        break;
                    case 39:
                        this.f12765X = typedArrayObtainStyledAttributes.getInt(index, this.f12765X);
                        break;
                    case 40:
                        this.f12766Y = typedArrayObtainStyledAttributes.getInt(index, this.f12766Y);
                        break;
                    case 41:
                        c.M(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        c.M(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.f12743B = c.L(typedArrayObtainStyledAttributes, index, this.f12743B);
                                break;
                            case 62:
                                this.f12744C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12744C);
                                break;
                            case 63:
                                this.f12745D = typedArrayObtainStyledAttributes.getFloat(index, this.f12745D);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f12779f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f12781g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f12783h0 = typedArrayObtainStyledAttributes.getInt(index, this.f12783h0);
                                        break;
                                    case 73:
                                        this.f12785i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12785i0);
                                        break;
                                    case 74:
                                        this.f12791l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f12799p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f12799p0);
                                        break;
                                    case 76:
                                        this.f12801q0 = typedArrayObtainStyledAttributes.getInt(index, this.f12801q0);
                                        break;
                                    case 77:
                                        this.f12803s = c.L(typedArrayObtainStyledAttributes, index, this.f12803s);
                                        break;
                                    case 78:
                                        this.f12804t = c.L(typedArrayObtainStyledAttributes, index, this.f12804t);
                                        break;
                                    case 79:
                                        this.f12762U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12762U);
                                        break;
                                    case 80:
                                        this.f12755N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12755N);
                                        break;
                                    case 81:
                                        this.f12767Z = typedArrayObtainStyledAttributes.getInt(index, this.f12767Z);
                                        break;
                                    case 82:
                                        this.f12769a0 = typedArrayObtainStyledAttributes.getInt(index, this.f12769a0);
                                        break;
                                    case 83:
                                        this.f12773c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12773c0);
                                        break;
                                    case 84:
                                        this.f12771b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12771b0);
                                        break;
                                    case 85:
                                        this.f12777e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12777e0);
                                        break;
                                    case 86:
                                        this.f12775d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f12775d0);
                                        break;
                                    case 87:
                                        this.f12795n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f12795n0);
                                        break;
                                    case 88:
                                        this.f12797o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f12797o0);
                                        break;
                                    case 89:
                                        this.f12793m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f12784i = typedArrayObtainStyledAttributes.getBoolean(index, this.f12784i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12741r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f12741r0.get(index));
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.c$c, reason: collision with other inner class name */
    public static class C0154c {

        /* renamed from: o, reason: collision with root package name */
        public static SparseIntArray f12811o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f12812a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f12813b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f12814c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f12815d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f12816e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f12817f = 0;

        /* renamed from: g, reason: collision with root package name */
        public float f12818g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public int f12819h = -1;

        /* renamed from: i, reason: collision with root package name */
        public float f12820i = Float.NaN;

        /* renamed from: j, reason: collision with root package name */
        public float f12821j = Float.NaN;

        /* renamed from: k, reason: collision with root package name */
        public int f12822k = -1;

        /* renamed from: l, reason: collision with root package name */
        public String f12823l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f12824m = -3;

        /* renamed from: n, reason: collision with root package name */
        public int f12825n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12811o = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            f12811o.append(R$styleable.Motion_pathMotionArc, 2);
            f12811o.append(R$styleable.Motion_transitionEasing, 3);
            f12811o.append(R$styleable.Motion_drawPath, 4);
            f12811o.append(R$styleable.Motion_animateRelativeTo, 5);
            f12811o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            f12811o.append(R$styleable.Motion_motionStagger, 7);
            f12811o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            f12811o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            f12811o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(C0154c c0154c) {
            this.f12812a = c0154c.f12812a;
            this.f12813b = c0154c.f12813b;
            this.f12815d = c0154c.f12815d;
            this.f12816e = c0154c.f12816e;
            this.f12817f = c0154c.f12817f;
            this.f12820i = c0154c.f12820i;
            this.f12818g = c0154c.f12818g;
            this.f12819h = c0154c.f12819h;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.f12812a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f12811o.get(index)) {
                    case 1:
                        this.f12820i = typedArrayObtainStyledAttributes.getFloat(index, this.f12820i);
                        break;
                    case 2:
                        this.f12816e = typedArrayObtainStyledAttributes.getInt(index, this.f12816e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f12815d = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f12815d = C4890c.f37052c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f12817f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f12813b = c.L(typedArrayObtainStyledAttributes, index, this.f12813b);
                        break;
                    case 6:
                        this.f12814c = typedArrayObtainStyledAttributes.getInteger(index, this.f12814c);
                        break;
                    case 7:
                        this.f12818g = typedArrayObtainStyledAttributes.getFloat(index, this.f12818g);
                        break;
                    case 8:
                        this.f12822k = typedArrayObtainStyledAttributes.getInteger(index, this.f12822k);
                        break;
                    case 9:
                        this.f12821j = typedArrayObtainStyledAttributes.getFloat(index, this.f12821j);
                        break;
                    case 10:
                        int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f12825n = resourceId;
                            if (resourceId != -1) {
                                this.f12824m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i11 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f12823l = string;
                            if (string.indexOf("/") > 0) {
                                this.f12825n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f12824m = -2;
                                break;
                            } else {
                                this.f12824m = -1;
                                break;
                            }
                        } else {
                            this.f12824m = typedArrayObtainStyledAttributes.getInteger(index, this.f12825n);
                            break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f12826a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f12827b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f12828c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f12829d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f12830e = Float.NaN;

        public void a(d dVar) {
            this.f12826a = dVar.f12826a;
            this.f12827b = dVar.f12827b;
            this.f12829d = dVar.f12829d;
            this.f12830e = dVar.f12830e;
            this.f12828c = dVar.f12828c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.f12826a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.f12829d = typedArrayObtainStyledAttributes.getFloat(index, this.f12829d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    this.f12827b = typedArrayObtainStyledAttributes.getInt(index, this.f12827b);
                    this.f12827b = c.f12710i[this.f12827b];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.f12828c = typedArrayObtainStyledAttributes.getInt(index, this.f12828c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.f12830e = typedArrayObtainStyledAttributes.getFloat(index, this.f12830e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* renamed from: o, reason: collision with root package name */
        public static SparseIntArray f12831o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f12832a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f12833b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f12834c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f12835d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f12836e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f12837f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f12838g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f12839h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public int f12840i = -1;

        /* renamed from: j, reason: collision with root package name */
        public float f12841j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f12842k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f12843l = 0.0f;

        /* renamed from: m, reason: collision with root package name */
        public boolean f12844m = false;

        /* renamed from: n, reason: collision with root package name */
        public float f12845n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f12831o = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            f12831o.append(R$styleable.Transform_android_rotationX, 2);
            f12831o.append(R$styleable.Transform_android_rotationY, 3);
            f12831o.append(R$styleable.Transform_android_scaleX, 4);
            f12831o.append(R$styleable.Transform_android_scaleY, 5);
            f12831o.append(R$styleable.Transform_android_transformPivotX, 6);
            f12831o.append(R$styleable.Transform_android_transformPivotY, 7);
            f12831o.append(R$styleable.Transform_android_translationX, 8);
            f12831o.append(R$styleable.Transform_android_translationY, 9);
            f12831o.append(R$styleable.Transform_android_translationZ, 10);
            f12831o.append(R$styleable.Transform_android_elevation, 11);
            f12831o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public void a(e eVar) {
            this.f12832a = eVar.f12832a;
            this.f12833b = eVar.f12833b;
            this.f12834c = eVar.f12834c;
            this.f12835d = eVar.f12835d;
            this.f12836e = eVar.f12836e;
            this.f12837f = eVar.f12837f;
            this.f12838g = eVar.f12838g;
            this.f12839h = eVar.f12839h;
            this.f12840i = eVar.f12840i;
            this.f12841j = eVar.f12841j;
            this.f12842k = eVar.f12842k;
            this.f12843l = eVar.f12843l;
            this.f12844m = eVar.f12844m;
            this.f12845n = eVar.f12845n;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.f12832a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f12831o.get(index)) {
                    case 1:
                        this.f12833b = typedArrayObtainStyledAttributes.getFloat(index, this.f12833b);
                        break;
                    case 2:
                        this.f12834c = typedArrayObtainStyledAttributes.getFloat(index, this.f12834c);
                        break;
                    case 3:
                        this.f12835d = typedArrayObtainStyledAttributes.getFloat(index, this.f12835d);
                        break;
                    case 4:
                        this.f12836e = typedArrayObtainStyledAttributes.getFloat(index, this.f12836e);
                        break;
                    case 5:
                        this.f12837f = typedArrayObtainStyledAttributes.getFloat(index, this.f12837f);
                        break;
                    case 6:
                        this.f12838g = typedArrayObtainStyledAttributes.getDimension(index, this.f12838g);
                        break;
                    case 7:
                        this.f12839h = typedArrayObtainStyledAttributes.getDimension(index, this.f12839h);
                        break;
                    case 8:
                        this.f12841j = typedArrayObtainStyledAttributes.getDimension(index, this.f12841j);
                        break;
                    case 9:
                        this.f12842k = typedArrayObtainStyledAttributes.getDimension(index, this.f12842k);
                        break;
                    case 10:
                        this.f12843l = typedArrayObtainStyledAttributes.getDimension(index, this.f12843l);
                        break;
                    case 11:
                        this.f12844m = true;
                        this.f12845n = typedArrayObtainStyledAttributes.getDimension(index, this.f12845n);
                        break;
                    case 12:
                        this.f12840i = c.L(typedArrayObtainStyledAttributes, index, this.f12840i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        f12711j.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f12711j.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f12711j.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f12711j.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f12711j.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f12711j.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f12711j.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f12711j.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f12711j.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f12711j.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        f12711j.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        f12711j.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        f12711j.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        f12711j.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        f12711j.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        f12711j.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        f12711j.append(R$styleable.Constraint_guidelineUseRtl, 99);
        f12711j.append(R$styleable.Constraint_android_orientation, 27);
        f12711j.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f12711j.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f12711j.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f12711j.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f12711j.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        f12711j.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        f12711j.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        f12711j.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        f12711j.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        f12711j.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        f12711j.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        f12711j.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f12711j.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f12711j.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f12711j.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f12711j.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        f12711j.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        f12711j.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        f12711j.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        f12711j.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        f12711j.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        f12711j.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        f12711j.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        f12711j.append(R$styleable.Constraint_android_layout_marginRight, 28);
        f12711j.append(R$styleable.Constraint_android_layout_marginStart, 31);
        f12711j.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        f12711j.append(R$styleable.Constraint_android_layout_marginTop, 34);
        f12711j.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        f12711j.append(R$styleable.Constraint_android_layout_width, 23);
        f12711j.append(R$styleable.Constraint_android_layout_height, 21);
        f12711j.append(R$styleable.Constraint_layout_constraintWidth, 95);
        f12711j.append(R$styleable.Constraint_layout_constraintHeight, 96);
        f12711j.append(R$styleable.Constraint_android_visibility, 22);
        f12711j.append(R$styleable.Constraint_android_alpha, 43);
        f12711j.append(R$styleable.Constraint_android_elevation, 44);
        f12711j.append(R$styleable.Constraint_android_rotationX, 45);
        f12711j.append(R$styleable.Constraint_android_rotationY, 46);
        f12711j.append(R$styleable.Constraint_android_rotation, 60);
        f12711j.append(R$styleable.Constraint_android_scaleX, 47);
        f12711j.append(R$styleable.Constraint_android_scaleY, 48);
        f12711j.append(R$styleable.Constraint_android_transformPivotX, 49);
        f12711j.append(R$styleable.Constraint_android_transformPivotY, 50);
        f12711j.append(R$styleable.Constraint_android_translationX, 51);
        f12711j.append(R$styleable.Constraint_android_translationY, 52);
        f12711j.append(R$styleable.Constraint_android_translationZ, 53);
        f12711j.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        f12711j.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        f12711j.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        f12711j.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        f12711j.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        f12711j.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        f12711j.append(R$styleable.Constraint_layout_constraintCircle, 61);
        f12711j.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        f12711j.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        f12711j.append(R$styleable.Constraint_animateRelativeTo, 64);
        f12711j.append(R$styleable.Constraint_transitionEasing, 65);
        f12711j.append(R$styleable.Constraint_drawPath, 66);
        f12711j.append(R$styleable.Constraint_transitionPathRotate, 67);
        f12711j.append(R$styleable.Constraint_motionStagger, 79);
        f12711j.append(R$styleable.Constraint_android_id, 38);
        f12711j.append(R$styleable.Constraint_motionProgress, 68);
        f12711j.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        f12711j.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        f12711j.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        f12711j.append(R$styleable.Constraint_chainUseRtl, 71);
        f12711j.append(R$styleable.Constraint_barrierDirection, 72);
        f12711j.append(R$styleable.Constraint_barrierMargin, 73);
        f12711j.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        f12711j.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f12711j.append(R$styleable.Constraint_pathMotionArc, 76);
        f12711j.append(R$styleable.Constraint_layout_constraintTag, 77);
        f12711j.append(R$styleable.Constraint_visibilityMode, 78);
        f12711j.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        f12711j.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        f12711j.append(R$styleable.Constraint_polarRelativeTo, 82);
        f12711j.append(R$styleable.Constraint_transformPivotTarget, 83);
        f12711j.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        f12711j.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        f12711j.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = f12712k;
        int i10 = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i10, 6);
        f12712k.append(i10, 7);
        f12712k.append(R$styleable.ConstraintOverride_android_orientation, 27);
        f12712k.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        f12712k.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        f12712k.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        f12712k.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        f12712k.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        f12712k.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        f12712k.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        f12712k.append(R$styleable.ConstraintOverride_android_visibility, 22);
        f12712k.append(R$styleable.ConstraintOverride_android_alpha, 43);
        f12712k.append(R$styleable.ConstraintOverride_android_elevation, 44);
        f12712k.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        f12712k.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        f12712k.append(R$styleable.ConstraintOverride_android_rotation, 60);
        f12712k.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        f12712k.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        f12712k.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        f12712k.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        f12712k.append(R$styleable.ConstraintOverride_android_translationX, 51);
        f12712k.append(R$styleable.ConstraintOverride_android_translationY, 52);
        f12712k.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        f12712k.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        f12712k.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        f12712k.append(R$styleable.ConstraintOverride_drawPath, 66);
        f12712k.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        f12712k.append(R$styleable.ConstraintOverride_motionStagger, 79);
        f12712k.append(R$styleable.ConstraintOverride_android_id, 38);
        f12712k.append(R$styleable.ConstraintOverride_motionTarget, 98);
        f12712k.append(R$styleable.ConstraintOverride_motionProgress, 68);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        f12712k.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        f12712k.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        f12712k.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        f12712k.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        f12712k.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f12712k.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        f12712k.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        f12712k.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        f12712k.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        f12712k.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        f12712k.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        f12712k.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        f12712k.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        f12712k.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        f12712k.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        f12712k.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static int L(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void M(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
        /*
            if (r4 != 0) goto L4
            goto L71
        L4:
            android.util.TypedValue r0 = r5.peekValue(r6)
            int r0 = r0.type
            r1 = 3
            if (r0 == r1) goto L72
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L2b
            int r5 = r5.getInt(r6, r2)
            r6 = -4
            r0 = -2
            if (r5 == r6) goto L27
            r6 = -3
            if (r5 == r6) goto L21
            if (r5 == r0) goto L23
            r6 = -1
            if (r5 == r6) goto L23
        L21:
            r5 = r2
            goto L30
        L23:
            r3 = r2
            r2 = r5
            r5 = r3
            goto L30
        L27:
            r2 = 1
            r5 = r2
            r2 = r0
            goto L30
        L2b:
            int r5 = r5.getDimensionPixelSize(r6, r2)
            goto L23
        L30:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.ConstraintLayout.b
            if (r6 == 0) goto L42
            androidx.constraintlayout.widget.ConstraintLayout$b r4 = (androidx.constraintlayout.widget.ConstraintLayout.b) r4
            if (r7 != 0) goto L3d
            r4.width = r2
            r4.f12627a0 = r5
            return
        L3d:
            r4.height = r2
            r4.f12629b0 = r5
            return
        L42:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.c.b
            if (r6 == 0) goto L54
            androidx.constraintlayout.widget.c$b r4 = (androidx.constraintlayout.widget.c.b) r4
            if (r7 != 0) goto L4f
            r4.f12774d = r2
            r4.f12795n0 = r5
            return
        L4f:
            r4.f12776e = r2
            r4.f12797o0 = r5
            return
        L54:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.c.a.C0153a
            if (r6 == 0) goto L71
            androidx.constraintlayout.widget.c$a$a r4 = (androidx.constraintlayout.widget.c.a.C0153a) r4
            if (r7 != 0) goto L67
            r6 = 23
            r4.b(r6, r2)
            r6 = 80
            r4.d(r6, r5)
            return
        L67:
            r6 = 21
            r4.b(r6, r2)
            r6 = 81
            r4.d(r6, r5)
        L71:
            return
        L72:
            java.lang.String r5 = r5.getString(r6)
            N(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.M(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void N(Object obj, String str, int i10) throws NumberFormatException {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(61);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i10 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    O(bVar, strTrim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).f12742A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0153a) {
                        ((a.C0153a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f10 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.f12611L = f10;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.f12612M = f10;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar3 = (b) obj;
                        if (i10 == 0) {
                            bVar3.f12774d = 0;
                            bVar3.f12764W = f10;
                            return;
                        } else {
                            bVar3.f12776e = 0;
                            bVar3.f12763V = f10;
                            return;
                        }
                    }
                    if (obj instanceof a.C0153a) {
                        a.C0153a c0153a = (a.C0153a) obj;
                        if (i10 == 0) {
                            c0153a.b(23, 0);
                            c0153a.a(39, f10);
                            return;
                        } else {
                            c0153a.b(21, 0);
                            c0153a.a(40, f10);
                            return;
                        }
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(strTrim)) {
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                        if (i10 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.f12621V = fMax;
                            bVar4.f12615P = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.f12622W = fMax;
                            bVar4.f12616Q = 2;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar5 = (b) obj;
                        if (i10 == 0) {
                            bVar5.f12774d = 0;
                            bVar5.f12779f0 = fMax;
                            bVar5.f12767Z = 2;
                            return;
                        } else {
                            bVar5.f12776e = 0;
                            bVar5.f12781g0 = fMax;
                            bVar5.f12769a0 = 2;
                            return;
                        }
                    }
                    if (obj instanceof a.C0153a) {
                        a.C0153a c0153a2 = (a.C0153a) obj;
                        if (i10 == 0) {
                            c0153a2.b(23, 0);
                            c0153a2.b(54, 2);
                        } else {
                            c0153a2.b(21, 0);
                            c0153a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void O(ConstraintLayout.b bVar, String str) {
        float fAbs = Float.NaN;
        int i10 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i11 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i10 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i10 = 1;
                }
                i11 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i11);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i11, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f10 = Float.parseFloat(strSubstring3);
                        float f11 = Float.parseFloat(strSubstring4);
                        if (f10 > 0.0f && f11 > 0.0f) {
                            fAbs = i10 == 1 ? Math.abs(f11 / f10) : Math.abs(f10 / f11);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.f12608I = str;
        bVar.f12609J = fAbs;
        bVar.f12610K = i10;
    }

    public static void Q(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0153a c0153a = new a.C0153a();
        aVar.f12728h = c0153a;
        aVar.f12724d.f12812a = false;
        aVar.f12725e.f12770b = false;
        aVar.f12723c.f12826a = false;
        aVar.f12726f.f12832a = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            switch (f12712k.get(index)) {
                case 2:
                    c0153a.b(2, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12752K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f12711j.get(index));
                    break;
                case 5:
                    c0153a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0153a.b(6, typedArray.getDimensionPixelOffset(index, aVar.f12725e.f12746E));
                    break;
                case 7:
                    c0153a.b(7, typedArray.getDimensionPixelOffset(index, aVar.f12725e.f12747F));
                    break;
                case 8:
                    c0153a.b(8, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12753L));
                    break;
                case 11:
                    c0153a.b(11, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12759R));
                    break;
                case 12:
                    c0153a.b(12, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12760S));
                    break;
                case 13:
                    c0153a.b(13, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12756O));
                    break;
                case 14:
                    c0153a.b(14, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12758Q));
                    break;
                case 15:
                    c0153a.b(15, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12761T));
                    break;
                case 16:
                    c0153a.b(16, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12757P));
                    break;
                case 17:
                    c0153a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f12725e.f12778f));
                    break;
                case 18:
                    c0153a.b(18, typedArray.getDimensionPixelOffset(index, aVar.f12725e.f12780g));
                    break;
                case 19:
                    c0153a.a(19, typedArray.getFloat(index, aVar.f12725e.f12782h));
                    break;
                case 20:
                    c0153a.a(20, typedArray.getFloat(index, aVar.f12725e.f12809y));
                    break;
                case 21:
                    c0153a.b(21, typedArray.getLayoutDimension(index, aVar.f12725e.f12776e));
                    break;
                case 22:
                    c0153a.b(22, f12710i[typedArray.getInt(index, aVar.f12723c.f12827b)]);
                    break;
                case 23:
                    c0153a.b(23, typedArray.getLayoutDimension(index, aVar.f12725e.f12774d));
                    break;
                case 24:
                    c0153a.b(24, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12749H));
                    break;
                case 27:
                    c0153a.b(27, typedArray.getInt(index, aVar.f12725e.f12748G));
                    break;
                case 28:
                    c0153a.b(28, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12750I));
                    break;
                case 31:
                    c0153a.b(31, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12754M));
                    break;
                case 34:
                    c0153a.b(34, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12751J));
                    break;
                case 37:
                    c0153a.a(37, typedArray.getFloat(index, aVar.f12725e.f12810z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.f12721a);
                    aVar.f12721a = resourceId;
                    c0153a.b(38, resourceId);
                    break;
                case 39:
                    c0153a.a(39, typedArray.getFloat(index, aVar.f12725e.f12764W));
                    break;
                case 40:
                    c0153a.a(40, typedArray.getFloat(index, aVar.f12725e.f12763V));
                    break;
                case 41:
                    c0153a.b(41, typedArray.getInt(index, aVar.f12725e.f12765X));
                    break;
                case 42:
                    c0153a.b(42, typedArray.getInt(index, aVar.f12725e.f12766Y));
                    break;
                case 43:
                    c0153a.a(43, typedArray.getFloat(index, aVar.f12723c.f12829d));
                    break;
                case 44:
                    c0153a.d(44, true);
                    c0153a.a(44, typedArray.getDimension(index, aVar.f12726f.f12845n));
                    break;
                case 45:
                    c0153a.a(45, typedArray.getFloat(index, aVar.f12726f.f12834c));
                    break;
                case 46:
                    c0153a.a(46, typedArray.getFloat(index, aVar.f12726f.f12835d));
                    break;
                case 47:
                    c0153a.a(47, typedArray.getFloat(index, aVar.f12726f.f12836e));
                    break;
                case 48:
                    c0153a.a(48, typedArray.getFloat(index, aVar.f12726f.f12837f));
                    break;
                case 49:
                    c0153a.a(49, typedArray.getDimension(index, aVar.f12726f.f12838g));
                    break;
                case 50:
                    c0153a.a(50, typedArray.getDimension(index, aVar.f12726f.f12839h));
                    break;
                case 51:
                    c0153a.a(51, typedArray.getDimension(index, aVar.f12726f.f12841j));
                    break;
                case 52:
                    c0153a.a(52, typedArray.getDimension(index, aVar.f12726f.f12842k));
                    break;
                case 53:
                    c0153a.a(53, typedArray.getDimension(index, aVar.f12726f.f12843l));
                    break;
                case 54:
                    c0153a.b(54, typedArray.getInt(index, aVar.f12725e.f12767Z));
                    break;
                case 55:
                    c0153a.b(55, typedArray.getInt(index, aVar.f12725e.f12769a0));
                    break;
                case 56:
                    c0153a.b(56, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12771b0));
                    break;
                case 57:
                    c0153a.b(57, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12773c0));
                    break;
                case 58:
                    c0153a.b(58, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12775d0));
                    break;
                case 59:
                    c0153a.b(59, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12777e0));
                    break;
                case 60:
                    c0153a.a(60, typedArray.getFloat(index, aVar.f12726f.f12833b));
                    break;
                case 62:
                    c0153a.b(62, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12744C));
                    break;
                case 63:
                    c0153a.a(63, typedArray.getFloat(index, aVar.f12725e.f12745D));
                    break;
                case 64:
                    c0153a.b(64, L(typedArray, index, aVar.f12724d.f12813b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        c0153a.c(65, typedArray.getString(index));
                        break;
                    } else {
                        c0153a.c(65, C4890c.f37052c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    c0153a.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c0153a.a(67, typedArray.getFloat(index, aVar.f12724d.f12820i));
                    break;
                case 68:
                    c0153a.a(68, typedArray.getFloat(index, aVar.f12723c.f12830e));
                    break;
                case 69:
                    c0153a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0153a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0153a.b(72, typedArray.getInt(index, aVar.f12725e.f12783h0));
                    break;
                case 73:
                    c0153a.b(73, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12785i0));
                    break;
                case 74:
                    c0153a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0153a.d(75, typedArray.getBoolean(index, aVar.f12725e.f12799p0));
                    break;
                case 76:
                    c0153a.b(76, typedArray.getInt(index, aVar.f12724d.f12816e));
                    break;
                case 77:
                    c0153a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0153a.b(78, typedArray.getInt(index, aVar.f12723c.f12828c));
                    break;
                case 79:
                    c0153a.a(79, typedArray.getFloat(index, aVar.f12724d.f12818g));
                    break;
                case 80:
                    c0153a.d(80, typedArray.getBoolean(index, aVar.f12725e.f12795n0));
                    break;
                case 81:
                    c0153a.d(81, typedArray.getBoolean(index, aVar.f12725e.f12797o0));
                    break;
                case 82:
                    c0153a.b(82, typedArray.getInteger(index, aVar.f12724d.f12814c));
                    break;
                case 83:
                    c0153a.b(83, L(typedArray, index, aVar.f12726f.f12840i));
                    break;
                case 84:
                    c0153a.b(84, typedArray.getInteger(index, aVar.f12724d.f12822k));
                    break;
                case 85:
                    c0153a.a(85, typedArray.getFloat(index, aVar.f12724d.f12821j));
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f12724d.f12825n = typedArray.getResourceId(index, -1);
                        c0153a.b(89, aVar.f12724d.f12825n);
                        C0154c c0154c = aVar.f12724d;
                        if (c0154c.f12825n != -1) {
                            c0154c.f12824m = -2;
                            c0153a.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i11 == 3) {
                        aVar.f12724d.f12823l = typedArray.getString(index);
                        c0153a.c(90, aVar.f12724d.f12823l);
                        if (aVar.f12724d.f12823l.indexOf("/") > 0) {
                            aVar.f12724d.f12825n = typedArray.getResourceId(index, -1);
                            c0153a.b(89, aVar.f12724d.f12825n);
                            aVar.f12724d.f12824m = -2;
                            c0153a.b(88, -2);
                            break;
                        } else {
                            aVar.f12724d.f12824m = -1;
                            c0153a.b(88, -1);
                            break;
                        }
                    } else {
                        C0154c c0154c2 = aVar.f12724d;
                        c0154c2.f12824m = typedArray.getInteger(index, c0154c2.f12825n);
                        c0153a.b(88, aVar.f12724d.f12824m);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12711j.get(index));
                    break;
                case 93:
                    c0153a.b(93, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12755N));
                    break;
                case 94:
                    c0153a.b(94, typedArray.getDimensionPixelSize(index, aVar.f12725e.f12762U));
                    break;
                case 95:
                    M(c0153a, typedArray, index, 0);
                    break;
                case 96:
                    M(c0153a, typedArray, index, 1);
                    break;
                case 97:
                    c0153a.b(97, typedArray.getInt(index, aVar.f12725e.f12801q0));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f12721a);
                        aVar.f12721a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f12722b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f12722b = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f12721a = typedArray.getResourceId(index, aVar.f12721a);
                        break;
                    }
                case 99:
                    c0153a.d(99, typedArray.getBoolean(index, aVar.f12725e.f12784i));
                    break;
            }
        }
    }

    public static void T(a aVar, int i10, float f10) {
        if (i10 == 19) {
            aVar.f12725e.f12782h = f10;
            return;
        }
        if (i10 == 20) {
            aVar.f12725e.f12809y = f10;
            return;
        }
        if (i10 == 37) {
            aVar.f12725e.f12810z = f10;
            return;
        }
        if (i10 == 60) {
            aVar.f12726f.f12833b = f10;
            return;
        }
        if (i10 == 63) {
            aVar.f12725e.f12745D = f10;
            return;
        }
        if (i10 == 79) {
            aVar.f12724d.f12818g = f10;
            return;
        }
        if (i10 == 85) {
            aVar.f12724d.f12821j = f10;
            return;
        }
        if (i10 != 87) {
            if (i10 == 39) {
                aVar.f12725e.f12764W = f10;
                return;
            }
            if (i10 == 40) {
                aVar.f12725e.f12763V = f10;
                return;
            }
            switch (i10) {
                case 43:
                    aVar.f12723c.f12829d = f10;
                    break;
                case 44:
                    e eVar = aVar.f12726f;
                    eVar.f12845n = f10;
                    eVar.f12844m = true;
                    break;
                case 45:
                    aVar.f12726f.f12834c = f10;
                    break;
                case 46:
                    aVar.f12726f.f12835d = f10;
                    break;
                case 47:
                    aVar.f12726f.f12836e = f10;
                    break;
                case 48:
                    aVar.f12726f.f12837f = f10;
                    break;
                case 49:
                    aVar.f12726f.f12838g = f10;
                    break;
                case 50:
                    aVar.f12726f.f12839h = f10;
                    break;
                case 51:
                    aVar.f12726f.f12841j = f10;
                    break;
                case 52:
                    aVar.f12726f.f12842k = f10;
                    break;
                case 53:
                    aVar.f12726f.f12843l = f10;
                    break;
                default:
                    switch (i10) {
                        case 67:
                            aVar.f12724d.f12820i = f10;
                            break;
                        case 68:
                            aVar.f12723c.f12830e = f10;
                            break;
                        case 69:
                            aVar.f12725e.f12779f0 = f10;
                            break;
                        case 70:
                            aVar.f12725e.f12781g0 = f10;
                            break;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            break;
                    }
            }
        }
    }

    public static void U(a aVar, int i10, int i11) {
        if (i10 == 6) {
            aVar.f12725e.f12746E = i11;
            return;
        }
        if (i10 == 7) {
            aVar.f12725e.f12747F = i11;
            return;
        }
        if (i10 == 8) {
            aVar.f12725e.f12753L = i11;
            return;
        }
        if (i10 == 27) {
            aVar.f12725e.f12748G = i11;
            return;
        }
        if (i10 == 28) {
            aVar.f12725e.f12750I = i11;
            return;
        }
        if (i10 == 41) {
            aVar.f12725e.f12765X = i11;
            return;
        }
        if (i10 == 42) {
            aVar.f12725e.f12766Y = i11;
            return;
        }
        if (i10 == 61) {
            aVar.f12725e.f12743B = i11;
            return;
        }
        if (i10 == 62) {
            aVar.f12725e.f12744C = i11;
            return;
        }
        if (i10 == 72) {
            aVar.f12725e.f12783h0 = i11;
            return;
        }
        if (i10 == 73) {
            aVar.f12725e.f12785i0 = i11;
            return;
        }
        switch (i10) {
            case 2:
                aVar.f12725e.f12752K = i11;
                break;
            case 11:
                aVar.f12725e.f12759R = i11;
                break;
            case 12:
                aVar.f12725e.f12760S = i11;
                break;
            case 13:
                aVar.f12725e.f12756O = i11;
                break;
            case 14:
                aVar.f12725e.f12758Q = i11;
                break;
            case 15:
                aVar.f12725e.f12761T = i11;
                break;
            case 16:
                aVar.f12725e.f12757P = i11;
                break;
            case 17:
                aVar.f12725e.f12778f = i11;
                break;
            case 18:
                aVar.f12725e.f12780g = i11;
                break;
            case 31:
                aVar.f12725e.f12754M = i11;
                break;
            case 34:
                aVar.f12725e.f12751J = i11;
                break;
            case 38:
                aVar.f12721a = i11;
                break;
            case 64:
                aVar.f12724d.f12813b = i11;
                break;
            case 66:
                aVar.f12724d.f12817f = i11;
                break;
            case 76:
                aVar.f12724d.f12816e = i11;
                break;
            case 78:
                aVar.f12723c.f12828c = i11;
                break;
            case 93:
                aVar.f12725e.f12755N = i11;
                break;
            case 94:
                aVar.f12725e.f12762U = i11;
                break;
            case 97:
                aVar.f12725e.f12801q0 = i11;
                break;
            default:
                switch (i10) {
                    case 21:
                        aVar.f12725e.f12776e = i11;
                        break;
                    case 22:
                        aVar.f12723c.f12827b = i11;
                        break;
                    case 23:
                        aVar.f12725e.f12774d = i11;
                        break;
                    case 24:
                        aVar.f12725e.f12749H = i11;
                        break;
                    default:
                        switch (i10) {
                            case 54:
                                aVar.f12725e.f12767Z = i11;
                                break;
                            case 55:
                                aVar.f12725e.f12769a0 = i11;
                                break;
                            case 56:
                                aVar.f12725e.f12771b0 = i11;
                                break;
                            case 57:
                                aVar.f12725e.f12773c0 = i11;
                                break;
                            case 58:
                                aVar.f12725e.f12775d0 = i11;
                                break;
                            case 59:
                                aVar.f12725e.f12777e0 = i11;
                                break;
                            default:
                                switch (i10) {
                                    case 82:
                                        aVar.f12724d.f12814c = i11;
                                        break;
                                    case 83:
                                        aVar.f12726f.f12840i = i11;
                                        break;
                                    case 84:
                                        aVar.f12724d.f12822k = i11;
                                        break;
                                    default:
                                        switch (i10) {
                                            case 87:
                                                break;
                                            case 88:
                                                aVar.f12724d.f12824m = i11;
                                                break;
                                            case 89:
                                                aVar.f12724d.f12825n = i11;
                                                break;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                break;
                                        }
                                }
                        }
                }
        }
    }

    public static void V(a aVar, int i10, String str) {
        if (i10 == 5) {
            aVar.f12725e.f12742A = str;
            return;
        }
        if (i10 == 65) {
            aVar.f12724d.f12815d = str;
            return;
        }
        if (i10 == 74) {
            b bVar = aVar.f12725e;
            bVar.f12791l0 = str;
            bVar.f12789k0 = null;
        } else if (i10 == 77) {
            aVar.f12725e.f12793m0 = str;
        } else if (i10 != 87) {
            if (i10 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f12724d.f12823l = str;
            }
        }
    }

    public static void W(a aVar, int i10, boolean z10) {
        if (i10 == 44) {
            aVar.f12726f.f12844m = z10;
            return;
        }
        if (i10 == 75) {
            aVar.f12725e.f12799p0 = z10;
            return;
        }
        if (i10 != 87) {
            if (i10 == 80) {
                aVar.f12725e.f12795n0 = z10;
            } else if (i10 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.f12725e.f12797o0 = z10;
            }
        }
    }

    public static a m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R$styleable.ConstraintOverride);
        Q(aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public final a A(Context context, AttributeSet attributeSet, boolean z10) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        P(aVar, typedArrayObtainStyledAttributes, z10);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public final a B(int i10) {
        if (!this.f12720h.containsKey(Integer.valueOf(i10))) {
            this.f12720h.put(Integer.valueOf(i10), new a());
        }
        return this.f12720h.get(Integer.valueOf(i10));
    }

    public a C(int i10) {
        if (this.f12720h.containsKey(Integer.valueOf(i10))) {
            return this.f12720h.get(Integer.valueOf(i10));
        }
        return null;
    }

    public int D(int i10) {
        return B(i10).f12725e.f12776e;
    }

    public int[] E() {
        Integer[] numArr = (Integer[]) this.f12720h.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public a F(int i10) {
        return B(i10);
    }

    public int G(int i10) {
        return B(i10).f12723c.f12827b;
    }

    public int H(int i10) {
        return B(i10).f12723c.f12828c;
    }

    public int I(int i10) {
        return B(i10).f12725e.f12774d;
    }

    public void J(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    a aVarA = A(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarA.f12725e.f12768a = true;
                    }
                    this.f12720h.put(Integer.valueOf(aVarA.f12721a), aVarA);
                }
            }
        } catch (IOException e10) {
            Log.e("ConstraintSet", "Error parsing resource: " + i10, e10);
        } catch (XmlPullParserException e11) {
            Log.e("ConstraintSet", "Error parsing resource: " + i10, e11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x01d2, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void K(android.content.Context r12, org.xmlpull.v1.XmlPullParser r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.K(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void P(a aVar, TypedArray typedArray, boolean z10) {
        if (z10) {
            Q(aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index != R$styleable.Constraint_android_id && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                aVar.f12724d.f12812a = true;
                aVar.f12725e.f12770b = true;
                aVar.f12723c.f12826a = true;
                aVar.f12726f.f12832a = true;
            }
            switch (f12711j.get(index)) {
                case 1:
                    b bVar = aVar.f12725e;
                    bVar.f12802r = L(typedArray, index, bVar.f12802r);
                    break;
                case 2:
                    b bVar2 = aVar.f12725e;
                    bVar2.f12752K = typedArray.getDimensionPixelSize(index, bVar2.f12752K);
                    break;
                case 3:
                    b bVar3 = aVar.f12725e;
                    bVar3.f12800q = L(typedArray, index, bVar3.f12800q);
                    break;
                case 4:
                    b bVar4 = aVar.f12725e;
                    bVar4.f12798p = L(typedArray, index, bVar4.f12798p);
                    break;
                case 5:
                    aVar.f12725e.f12742A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f12725e;
                    bVar5.f12746E = typedArray.getDimensionPixelOffset(index, bVar5.f12746E);
                    break;
                case 7:
                    b bVar6 = aVar.f12725e;
                    bVar6.f12747F = typedArray.getDimensionPixelOffset(index, bVar6.f12747F);
                    break;
                case 8:
                    b bVar7 = aVar.f12725e;
                    bVar7.f12753L = typedArray.getDimensionPixelSize(index, bVar7.f12753L);
                    break;
                case 9:
                    b bVar8 = aVar.f12725e;
                    bVar8.f12808x = L(typedArray, index, bVar8.f12808x);
                    break;
                case 10:
                    b bVar9 = aVar.f12725e;
                    bVar9.f12807w = L(typedArray, index, bVar9.f12807w);
                    break;
                case 11:
                    b bVar10 = aVar.f12725e;
                    bVar10.f12759R = typedArray.getDimensionPixelSize(index, bVar10.f12759R);
                    break;
                case 12:
                    b bVar11 = aVar.f12725e;
                    bVar11.f12760S = typedArray.getDimensionPixelSize(index, bVar11.f12760S);
                    break;
                case 13:
                    b bVar12 = aVar.f12725e;
                    bVar12.f12756O = typedArray.getDimensionPixelSize(index, bVar12.f12756O);
                    break;
                case 14:
                    b bVar13 = aVar.f12725e;
                    bVar13.f12758Q = typedArray.getDimensionPixelSize(index, bVar13.f12758Q);
                    break;
                case 15:
                    b bVar14 = aVar.f12725e;
                    bVar14.f12761T = typedArray.getDimensionPixelSize(index, bVar14.f12761T);
                    break;
                case 16:
                    b bVar15 = aVar.f12725e;
                    bVar15.f12757P = typedArray.getDimensionPixelSize(index, bVar15.f12757P);
                    break;
                case 17:
                    b bVar16 = aVar.f12725e;
                    bVar16.f12778f = typedArray.getDimensionPixelOffset(index, bVar16.f12778f);
                    break;
                case 18:
                    b bVar17 = aVar.f12725e;
                    bVar17.f12780g = typedArray.getDimensionPixelOffset(index, bVar17.f12780g);
                    break;
                case 19:
                    b bVar18 = aVar.f12725e;
                    bVar18.f12782h = typedArray.getFloat(index, bVar18.f12782h);
                    break;
                case 20:
                    b bVar19 = aVar.f12725e;
                    bVar19.f12809y = typedArray.getFloat(index, bVar19.f12809y);
                    break;
                case 21:
                    b bVar20 = aVar.f12725e;
                    bVar20.f12776e = typedArray.getLayoutDimension(index, bVar20.f12776e);
                    break;
                case 22:
                    d dVar = aVar.f12723c;
                    dVar.f12827b = typedArray.getInt(index, dVar.f12827b);
                    d dVar2 = aVar.f12723c;
                    dVar2.f12827b = f12710i[dVar2.f12827b];
                    break;
                case 23:
                    b bVar21 = aVar.f12725e;
                    bVar21.f12774d = typedArray.getLayoutDimension(index, bVar21.f12774d);
                    break;
                case 24:
                    b bVar22 = aVar.f12725e;
                    bVar22.f12749H = typedArray.getDimensionPixelSize(index, bVar22.f12749H);
                    break;
                case 25:
                    b bVar23 = aVar.f12725e;
                    bVar23.f12786j = L(typedArray, index, bVar23.f12786j);
                    break;
                case 26:
                    b bVar24 = aVar.f12725e;
                    bVar24.f12788k = L(typedArray, index, bVar24.f12788k);
                    break;
                case 27:
                    b bVar25 = aVar.f12725e;
                    bVar25.f12748G = typedArray.getInt(index, bVar25.f12748G);
                    break;
                case 28:
                    b bVar26 = aVar.f12725e;
                    bVar26.f12750I = typedArray.getDimensionPixelSize(index, bVar26.f12750I);
                    break;
                case 29:
                    b bVar27 = aVar.f12725e;
                    bVar27.f12790l = L(typedArray, index, bVar27.f12790l);
                    break;
                case 30:
                    b bVar28 = aVar.f12725e;
                    bVar28.f12792m = L(typedArray, index, bVar28.f12792m);
                    break;
                case 31:
                    b bVar29 = aVar.f12725e;
                    bVar29.f12754M = typedArray.getDimensionPixelSize(index, bVar29.f12754M);
                    break;
                case 32:
                    b bVar30 = aVar.f12725e;
                    bVar30.f12805u = L(typedArray, index, bVar30.f12805u);
                    break;
                case 33:
                    b bVar31 = aVar.f12725e;
                    bVar31.f12806v = L(typedArray, index, bVar31.f12806v);
                    break;
                case 34:
                    b bVar32 = aVar.f12725e;
                    bVar32.f12751J = typedArray.getDimensionPixelSize(index, bVar32.f12751J);
                    break;
                case 35:
                    b bVar33 = aVar.f12725e;
                    bVar33.f12796o = L(typedArray, index, bVar33.f12796o);
                    break;
                case 36:
                    b bVar34 = aVar.f12725e;
                    bVar34.f12794n = L(typedArray, index, bVar34.f12794n);
                    break;
                case 37:
                    b bVar35 = aVar.f12725e;
                    bVar35.f12810z = typedArray.getFloat(index, bVar35.f12810z);
                    break;
                case 38:
                    aVar.f12721a = typedArray.getResourceId(index, aVar.f12721a);
                    break;
                case 39:
                    b bVar36 = aVar.f12725e;
                    bVar36.f12764W = typedArray.getFloat(index, bVar36.f12764W);
                    break;
                case 40:
                    b bVar37 = aVar.f12725e;
                    bVar37.f12763V = typedArray.getFloat(index, bVar37.f12763V);
                    break;
                case 41:
                    b bVar38 = aVar.f12725e;
                    bVar38.f12765X = typedArray.getInt(index, bVar38.f12765X);
                    break;
                case 42:
                    b bVar39 = aVar.f12725e;
                    bVar39.f12766Y = typedArray.getInt(index, bVar39.f12766Y);
                    break;
                case 43:
                    d dVar3 = aVar.f12723c;
                    dVar3.f12829d = typedArray.getFloat(index, dVar3.f12829d);
                    break;
                case 44:
                    e eVar = aVar.f12726f;
                    eVar.f12844m = true;
                    eVar.f12845n = typedArray.getDimension(index, eVar.f12845n);
                    break;
                case 45:
                    e eVar2 = aVar.f12726f;
                    eVar2.f12834c = typedArray.getFloat(index, eVar2.f12834c);
                    break;
                case 46:
                    e eVar3 = aVar.f12726f;
                    eVar3.f12835d = typedArray.getFloat(index, eVar3.f12835d);
                    break;
                case 47:
                    e eVar4 = aVar.f12726f;
                    eVar4.f12836e = typedArray.getFloat(index, eVar4.f12836e);
                    break;
                case 48:
                    e eVar5 = aVar.f12726f;
                    eVar5.f12837f = typedArray.getFloat(index, eVar5.f12837f);
                    break;
                case 49:
                    e eVar6 = aVar.f12726f;
                    eVar6.f12838g = typedArray.getDimension(index, eVar6.f12838g);
                    break;
                case 50:
                    e eVar7 = aVar.f12726f;
                    eVar7.f12839h = typedArray.getDimension(index, eVar7.f12839h);
                    break;
                case 51:
                    e eVar8 = aVar.f12726f;
                    eVar8.f12841j = typedArray.getDimension(index, eVar8.f12841j);
                    break;
                case 52:
                    e eVar9 = aVar.f12726f;
                    eVar9.f12842k = typedArray.getDimension(index, eVar9.f12842k);
                    break;
                case 53:
                    e eVar10 = aVar.f12726f;
                    eVar10.f12843l = typedArray.getDimension(index, eVar10.f12843l);
                    break;
                case 54:
                    b bVar40 = aVar.f12725e;
                    bVar40.f12767Z = typedArray.getInt(index, bVar40.f12767Z);
                    break;
                case 55:
                    b bVar41 = aVar.f12725e;
                    bVar41.f12769a0 = typedArray.getInt(index, bVar41.f12769a0);
                    break;
                case 56:
                    b bVar42 = aVar.f12725e;
                    bVar42.f12771b0 = typedArray.getDimensionPixelSize(index, bVar42.f12771b0);
                    break;
                case 57:
                    b bVar43 = aVar.f12725e;
                    bVar43.f12773c0 = typedArray.getDimensionPixelSize(index, bVar43.f12773c0);
                    break;
                case 58:
                    b bVar44 = aVar.f12725e;
                    bVar44.f12775d0 = typedArray.getDimensionPixelSize(index, bVar44.f12775d0);
                    break;
                case 59:
                    b bVar45 = aVar.f12725e;
                    bVar45.f12777e0 = typedArray.getDimensionPixelSize(index, bVar45.f12777e0);
                    break;
                case 60:
                    e eVar11 = aVar.f12726f;
                    eVar11.f12833b = typedArray.getFloat(index, eVar11.f12833b);
                    break;
                case 61:
                    b bVar46 = aVar.f12725e;
                    bVar46.f12743B = L(typedArray, index, bVar46.f12743B);
                    break;
                case 62:
                    b bVar47 = aVar.f12725e;
                    bVar47.f12744C = typedArray.getDimensionPixelSize(index, bVar47.f12744C);
                    break;
                case 63:
                    b bVar48 = aVar.f12725e;
                    bVar48.f12745D = typedArray.getFloat(index, bVar48.f12745D);
                    break;
                case 64:
                    C0154c c0154c = aVar.f12724d;
                    c0154c.f12813b = L(typedArray, index, c0154c.f12813b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f12724d.f12815d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f12724d.f12815d = C4890c.f37052c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f12724d.f12817f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    C0154c c0154c2 = aVar.f12724d;
                    c0154c2.f12820i = typedArray.getFloat(index, c0154c2.f12820i);
                    break;
                case 68:
                    d dVar4 = aVar.f12723c;
                    dVar4.f12830e = typedArray.getFloat(index, dVar4.f12830e);
                    break;
                case 69:
                    aVar.f12725e.f12779f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f12725e.f12781g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f12725e;
                    bVar49.f12783h0 = typedArray.getInt(index, bVar49.f12783h0);
                    break;
                case 73:
                    b bVar50 = aVar.f12725e;
                    bVar50.f12785i0 = typedArray.getDimensionPixelSize(index, bVar50.f12785i0);
                    break;
                case 74:
                    aVar.f12725e.f12791l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f12725e;
                    bVar51.f12799p0 = typedArray.getBoolean(index, bVar51.f12799p0);
                    break;
                case 76:
                    C0154c c0154c3 = aVar.f12724d;
                    c0154c3.f12816e = typedArray.getInt(index, c0154c3.f12816e);
                    break;
                case 77:
                    aVar.f12725e.f12793m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f12723c;
                    dVar5.f12828c = typedArray.getInt(index, dVar5.f12828c);
                    break;
                case 79:
                    C0154c c0154c4 = aVar.f12724d;
                    c0154c4.f12818g = typedArray.getFloat(index, c0154c4.f12818g);
                    break;
                case 80:
                    b bVar52 = aVar.f12725e;
                    bVar52.f12795n0 = typedArray.getBoolean(index, bVar52.f12795n0);
                    break;
                case 81:
                    b bVar53 = aVar.f12725e;
                    bVar53.f12797o0 = typedArray.getBoolean(index, bVar53.f12797o0);
                    break;
                case 82:
                    C0154c c0154c5 = aVar.f12724d;
                    c0154c5.f12814c = typedArray.getInteger(index, c0154c5.f12814c);
                    break;
                case 83:
                    e eVar12 = aVar.f12726f;
                    eVar12.f12840i = L(typedArray, index, eVar12.f12840i);
                    break;
                case 84:
                    C0154c c0154c6 = aVar.f12724d;
                    c0154c6.f12822k = typedArray.getInteger(index, c0154c6.f12822k);
                    break;
                case 85:
                    C0154c c0154c7 = aVar.f12724d;
                    c0154c7.f12821j = typedArray.getFloat(index, c0154c7.f12821j);
                    break;
                case 86:
                    int i11 = typedArray.peekValue(index).type;
                    if (i11 == 1) {
                        aVar.f12724d.f12825n = typedArray.getResourceId(index, -1);
                        C0154c c0154c8 = aVar.f12724d;
                        if (c0154c8.f12825n != -1) {
                            c0154c8.f12824m = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i11 == 3) {
                        aVar.f12724d.f12823l = typedArray.getString(index);
                        if (aVar.f12724d.f12823l.indexOf("/") > 0) {
                            aVar.f12724d.f12825n = typedArray.getResourceId(index, -1);
                            aVar.f12724d.f12824m = -2;
                            break;
                        } else {
                            aVar.f12724d.f12824m = -1;
                            break;
                        }
                    } else {
                        C0154c c0154c9 = aVar.f12724d;
                        c0154c9.f12824m = typedArray.getInteger(index, c0154c9.f12825n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f12711j.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f12711j.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f12725e;
                    bVar54.f12803s = L(typedArray, index, bVar54.f12803s);
                    break;
                case 92:
                    b bVar55 = aVar.f12725e;
                    bVar55.f12804t = L(typedArray, index, bVar55.f12804t);
                    break;
                case 93:
                    b bVar56 = aVar.f12725e;
                    bVar56.f12755N = typedArray.getDimensionPixelSize(index, bVar56.f12755N);
                    break;
                case 94:
                    b bVar57 = aVar.f12725e;
                    bVar57.f12762U = typedArray.getDimensionPixelSize(index, bVar57.f12762U);
                    break;
                case 95:
                    M(aVar.f12725e, typedArray, index, 0);
                    break;
                case 96:
                    M(aVar.f12725e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f12725e;
                    bVar58.f12801q0 = typedArray.getInt(index, bVar58.f12801q0);
                    break;
            }
        }
        b bVar59 = aVar.f12725e;
        if (bVar59.f12791l0 != null) {
            bVar59.f12789k0 = null;
        }
    }

    public void R(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f12719g && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f12720h.containsKey(Integer.valueOf(id))) {
                this.f12720h.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f12720h.get(Integer.valueOf(id));
            if (aVar != null) {
                if (!aVar.f12725e.f12770b) {
                    aVar.g(id, bVar);
                    if (childAt instanceof androidx.constraintlayout.widget.a) {
                        aVar.f12725e.f12789k0 = ((androidx.constraintlayout.widget.a) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f12725e.f12799p0 = barrier.getAllowsGoneWidget();
                            aVar.f12725e.f12783h0 = barrier.getType();
                            aVar.f12725e.f12785i0 = barrier.getMargin();
                        }
                    }
                    aVar.f12725e.f12770b = true;
                }
                d dVar = aVar.f12723c;
                if (!dVar.f12826a) {
                    dVar.f12827b = childAt.getVisibility();
                    aVar.f12723c.f12829d = childAt.getAlpha();
                    aVar.f12723c.f12826a = true;
                }
                e eVar = aVar.f12726f;
                if (!eVar.f12832a) {
                    eVar.f12832a = true;
                    eVar.f12833b = childAt.getRotation();
                    aVar.f12726f.f12834c = childAt.getRotationX();
                    aVar.f12726f.f12835d = childAt.getRotationY();
                    aVar.f12726f.f12836e = childAt.getScaleX();
                    aVar.f12726f.f12837f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f12726f;
                        eVar2.f12838g = pivotX;
                        eVar2.f12839h = pivotY;
                    }
                    aVar.f12726f.f12841j = childAt.getTranslationX();
                    aVar.f12726f.f12842k = childAt.getTranslationY();
                    aVar.f12726f.f12843l = childAt.getTranslationZ();
                    e eVar3 = aVar.f12726f;
                    if (eVar3.f12844m) {
                        eVar3.f12845n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void S(c cVar) {
        for (Integer num : cVar.f12720h.keySet()) {
            num.intValue();
            a aVar = cVar.f12720h.get(num);
            if (!this.f12720h.containsKey(num)) {
                this.f12720h.put(num, new a());
            }
            a aVar2 = this.f12720h.get(num);
            if (aVar2 != null) {
                b bVar = aVar2.f12725e;
                if (!bVar.f12770b) {
                    bVar.a(aVar.f12725e);
                }
                d dVar = aVar2.f12723c;
                if (!dVar.f12826a) {
                    dVar.a(aVar.f12723c);
                }
                e eVar = aVar2.f12726f;
                if (!eVar.f12832a) {
                    eVar.a(aVar.f12726f);
                }
                C0154c c0154c = aVar2.f12724d;
                if (!c0154c.f12812a) {
                    c0154c.a(aVar.f12724d);
                }
                for (String str : aVar.f12727g.keySet()) {
                    if (!aVar2.f12727g.containsKey(str)) {
                        aVar2.f12727g.put(str, aVar.f12727g.get(str));
                    }
                }
            }
        }
    }

    public void X(boolean z10) {
        this.f12719g = z10;
    }

    public void Y(int i10, int i11, int i12) {
        a aVarB = B(i10);
        switch (i11) {
            case 1:
                aVarB.f12725e.f12749H = i12;
                return;
            case 2:
                aVarB.f12725e.f12750I = i12;
                return;
            case 3:
                aVarB.f12725e.f12751J = i12;
                return;
            case 4:
                aVarB.f12725e.f12752K = i12;
                return;
            case 5:
                aVarB.f12725e.f12755N = i12;
                return;
            case 6:
                aVarB.f12725e.f12754M = i12;
                return;
            case 7:
                aVarB.f12725e.f12753L = i12;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void Z(String str) {
        this.f12716d = str.split(Const.STR_MART_COMMA);
        int i10 = 0;
        while (true) {
            String[] strArr = this.f12716d;
            if (i10 >= strArr.length) {
                return;
            }
            strArr[i10] = strArr[i10].trim();
            i10++;
        }
    }

    public void a0(boolean z10) {
        this.f12713a = z10;
    }

    public void b0(int i10, int i11) {
        B(i10).f12723c.f12827b = i11;
    }

    public final String c0(int i10) {
        switch (i10) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return com.stepos.ailauncher.container.wallpaper.a.PHASE_END;
            default:
                return "undefined";
        }
    }

    public void g(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (!this.f12720h.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f12719g && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f12720h.containsKey(Integer.valueOf(id)) && (aVar = this.f12720h.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.j(childAt, aVar.f12727g);
                }
            }
        }
    }

    public void h(c cVar) {
        for (a aVar : cVar.f12720h.values()) {
            if (aVar.f12728h != null) {
                if (aVar.f12722b == null) {
                    aVar.f12728h.e(C(aVar.f12721a));
                } else {
                    Iterator<Integer> it = this.f12720h.keySet().iterator();
                    while (it.hasNext()) {
                        a aVarC = C(it.next().intValue());
                        String str = aVarC.f12725e.f12793m0;
                        if (str != null && aVar.f12722b.matches(str)) {
                            aVar.f12728h.e(aVarC);
                            aVarC.f12727g.putAll((HashMap) aVar.f12727g.clone());
                        }
                    }
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void j(androidx.constraintlayout.widget.a aVar, ConstraintWidget constraintWidget, ConstraintLayout.b bVar, SparseArray<ConstraintWidget> sparseArray) {
        a aVar2;
        int id = aVar.getId();
        if (this.f12720h.containsKey(Integer.valueOf(id)) && (aVar2 = this.f12720h.get(Integer.valueOf(id))) != null && (constraintWidget instanceof C4994b)) {
            aVar.p(aVar2, (C4994b) constraintWidget, bVar, sparseArray);
        }
    }

    public void k(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f12720h.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (!this.f12720h.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.d(childAt));
            } else {
                if (this.f12719g && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f12720h.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f12720h.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f12725e.f12787j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(aVar.f12725e.f12783h0);
                                barrier.setMargin(aVar.f12725e.f12785i0);
                                barrier.setAllowsGoneWidget(aVar.f12725e.f12799p0);
                                b bVar = aVar.f12725e;
                                int[] iArr = bVar.f12789k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f12791l0;
                                    if (str != null) {
                                        bVar.f12789k0 = x(barrier, str);
                                        barrier.setReferencedIds(aVar.f12725e.f12789k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.b();
                            aVar.e(bVar2);
                            if (z10) {
                                ConstraintAttribute.j(childAt, aVar.f12727g);
                            }
                            childAt.setLayoutParams(bVar2);
                            d dVar = aVar.f12723c;
                            if (dVar.f12828c == 0) {
                                childAt.setVisibility(dVar.f12827b);
                            }
                            childAt.setAlpha(aVar.f12723c.f12829d);
                            childAt.setRotation(aVar.f12726f.f12833b);
                            childAt.setRotationX(aVar.f12726f.f12834c);
                            childAt.setRotationY(aVar.f12726f.f12835d);
                            childAt.setScaleX(aVar.f12726f.f12836e);
                            childAt.setScaleY(aVar.f12726f.f12837f);
                            e eVar = aVar.f12726f;
                            if (eVar.f12840i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f12726f.f12840i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f12838g)) {
                                    childAt.setPivotX(aVar.f12726f.f12838g);
                                }
                                if (!Float.isNaN(aVar.f12726f.f12839h)) {
                                    childAt.setPivotY(aVar.f12726f.f12839h);
                                }
                            }
                            childAt.setTranslationX(aVar.f12726f.f12841j);
                            childAt.setTranslationY(aVar.f12726f.f12842k);
                            childAt.setTranslationZ(aVar.f12726f.f12843l);
                            e eVar2 = aVar.f12726f;
                            if (eVar2.f12844m) {
                                childAt.setElevation(eVar2.f12845n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f12720h.get(num);
            if (aVar2 != null) {
                if (aVar2.f12725e.f12787j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar3 = aVar2.f12725e;
                    int[] iArr2 = bVar3.f12789k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f12791l0;
                        if (str2 != null) {
                            bVar3.f12789k0 = x(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f12725e.f12789k0);
                        }
                    }
                    barrier2.setType(aVar2.f12725e.f12783h0);
                    barrier2.setMargin(aVar2.f12725e.f12785i0);
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.w();
                    aVar2.e(bVarGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, bVarGenerateDefaultLayoutParams);
                }
                if (aVar2.f12725e.f12768a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.e(bVarGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, bVarGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof androidx.constraintlayout.widget.a) {
                ((androidx.constraintlayout.widget.a) childAt2).j(constraintLayout);
            }
        }
    }

    public void l(int i10, ConstraintLayout.b bVar) {
        a aVar;
        if (!this.f12720h.containsKey(Integer.valueOf(i10)) || (aVar = this.f12720h.get(Integer.valueOf(i10))) == null) {
            return;
        }
        aVar.e(bVar);
    }

    public void n(int i10, int i11) {
        a aVar;
        if (!this.f12720h.containsKey(Integer.valueOf(i10)) || (aVar = this.f12720h.get(Integer.valueOf(i10))) == null) {
            return;
        }
        switch (i11) {
            case 1:
                b bVar = aVar.f12725e;
                bVar.f12788k = -1;
                bVar.f12786j = -1;
                bVar.f12749H = -1;
                bVar.f12756O = Integer.MIN_VALUE;
                return;
            case 2:
                b bVar2 = aVar.f12725e;
                bVar2.f12792m = -1;
                bVar2.f12790l = -1;
                bVar2.f12750I = -1;
                bVar2.f12758Q = Integer.MIN_VALUE;
                return;
            case 3:
                b bVar3 = aVar.f12725e;
                bVar3.f12796o = -1;
                bVar3.f12794n = -1;
                bVar3.f12751J = 0;
                bVar3.f12757P = Integer.MIN_VALUE;
                return;
            case 4:
                b bVar4 = aVar.f12725e;
                bVar4.f12798p = -1;
                bVar4.f12800q = -1;
                bVar4.f12752K = 0;
                bVar4.f12759R = Integer.MIN_VALUE;
                return;
            case 5:
                b bVar5 = aVar.f12725e;
                bVar5.f12802r = -1;
                bVar5.f12803s = -1;
                bVar5.f12804t = -1;
                bVar5.f12755N = 0;
                bVar5.f12762U = Integer.MIN_VALUE;
                return;
            case 6:
                b bVar6 = aVar.f12725e;
                bVar6.f12805u = -1;
                bVar6.f12806v = -1;
                bVar6.f12754M = 0;
                bVar6.f12761T = Integer.MIN_VALUE;
                return;
            case 7:
                b bVar7 = aVar.f12725e;
                bVar7.f12807w = -1;
                bVar7.f12808x = -1;
                bVar7.f12753L = 0;
                bVar7.f12760S = Integer.MIN_VALUE;
                return;
            case 8:
                b bVar8 = aVar.f12725e;
                bVar8.f12745D = -1.0f;
                bVar8.f12744C = -1;
                bVar8.f12743B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void o(Context context, int i10) {
        p((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void p(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f12720h.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f12719g && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f12720h.containsKey(Integer.valueOf(id))) {
                this.f12720h.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f12720h.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f12727g = ConstraintAttribute.b(this.f12718f, childAt);
                aVar.g(id, bVar);
                aVar.f12723c.f12827b = childAt.getVisibility();
                aVar.f12723c.f12829d = childAt.getAlpha();
                aVar.f12726f.f12833b = childAt.getRotation();
                aVar.f12726f.f12834c = childAt.getRotationX();
                aVar.f12726f.f12835d = childAt.getRotationY();
                aVar.f12726f.f12836e = childAt.getScaleX();
                aVar.f12726f.f12837f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f12726f;
                    eVar.f12838g = pivotX;
                    eVar.f12839h = pivotY;
                }
                aVar.f12726f.f12841j = childAt.getTranslationX();
                aVar.f12726f.f12842k = childAt.getTranslationY();
                aVar.f12726f.f12843l = childAt.getTranslationZ();
                e eVar2 = aVar.f12726f;
                if (eVar2.f12844m) {
                    eVar2.f12845n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f12725e.f12799p0 = barrier.getAllowsGoneWidget();
                    aVar.f12725e.f12789k0 = barrier.getReferencedIds();
                    aVar.f12725e.f12783h0 = barrier.getType();
                    aVar.f12725e.f12785i0 = barrier.getMargin();
                }
            }
        }
    }

    public void q(c cVar) {
        this.f12720h.clear();
        for (Integer num : cVar.f12720h.keySet()) {
            a aVar = cVar.f12720h.get(num);
            if (aVar != null) {
                this.f12720h.put(num, aVar.clone());
            }
        }
    }

    public void r(androidx.constraintlayout.widget.d dVar) {
        int childCount = dVar.getChildCount();
        this.f12720h.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = dVar.getChildAt(i10);
            d.a aVar = (d.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f12719g && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f12720h.containsKey(Integer.valueOf(id))) {
                this.f12720h.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.f12720h.get(Integer.valueOf(id));
            if (aVar2 != null) {
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    aVar2.i((androidx.constraintlayout.widget.a) childAt, id, aVar);
                }
                aVar2.h(id, aVar);
            }
        }
    }

    public void s(int i10, int i11, int i12, int i13) {
        if (!this.f12720h.containsKey(Integer.valueOf(i10))) {
            this.f12720h.put(Integer.valueOf(i10), new a());
        }
        a aVar = this.f12720h.get(Integer.valueOf(i10));
        if (aVar == null) {
            return;
        }
        switch (i11) {
            case 1:
                if (i13 == 1) {
                    b bVar = aVar.f12725e;
                    bVar.f12786j = i12;
                    bVar.f12788k = -1;
                    return;
                } else if (i13 == 2) {
                    b bVar2 = aVar.f12725e;
                    bVar2.f12788k = i12;
                    bVar2.f12786j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + c0(i13) + " undefined");
                }
            case 2:
                if (i13 == 1) {
                    b bVar3 = aVar.f12725e;
                    bVar3.f12790l = i12;
                    bVar3.f12792m = -1;
                    return;
                } else if (i13 == 2) {
                    b bVar4 = aVar.f12725e;
                    bVar4.f12792m = i12;
                    bVar4.f12790l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                }
            case 3:
                if (i13 == 3) {
                    b bVar5 = aVar.f12725e;
                    bVar5.f12794n = i12;
                    bVar5.f12796o = -1;
                    bVar5.f12802r = -1;
                    bVar5.f12803s = -1;
                    bVar5.f12804t = -1;
                    return;
                }
                if (i13 != 4) {
                    throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                }
                b bVar6 = aVar.f12725e;
                bVar6.f12796o = i12;
                bVar6.f12794n = -1;
                bVar6.f12802r = -1;
                bVar6.f12803s = -1;
                bVar6.f12804t = -1;
                return;
            case 4:
                if (i13 == 4) {
                    b bVar7 = aVar.f12725e;
                    bVar7.f12800q = i12;
                    bVar7.f12798p = -1;
                    bVar7.f12802r = -1;
                    bVar7.f12803s = -1;
                    bVar7.f12804t = -1;
                    return;
                }
                if (i13 != 3) {
                    throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                }
                b bVar8 = aVar.f12725e;
                bVar8.f12798p = i12;
                bVar8.f12800q = -1;
                bVar8.f12802r = -1;
                bVar8.f12803s = -1;
                bVar8.f12804t = -1;
                return;
            case 5:
                if (i13 == 5) {
                    b bVar9 = aVar.f12725e;
                    bVar9.f12802r = i12;
                    bVar9.f12800q = -1;
                    bVar9.f12798p = -1;
                    bVar9.f12794n = -1;
                    bVar9.f12796o = -1;
                    return;
                }
                if (i13 == 3) {
                    b bVar10 = aVar.f12725e;
                    bVar10.f12803s = i12;
                    bVar10.f12800q = -1;
                    bVar10.f12798p = -1;
                    bVar10.f12794n = -1;
                    bVar10.f12796o = -1;
                    return;
                }
                if (i13 != 4) {
                    throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                }
                b bVar11 = aVar.f12725e;
                bVar11.f12804t = i12;
                bVar11.f12800q = -1;
                bVar11.f12798p = -1;
                bVar11.f12794n = -1;
                bVar11.f12796o = -1;
                return;
            case 6:
                if (i13 == 6) {
                    b bVar12 = aVar.f12725e;
                    bVar12.f12806v = i12;
                    bVar12.f12805u = -1;
                    return;
                } else if (i13 == 7) {
                    b bVar13 = aVar.f12725e;
                    bVar13.f12805u = i12;
                    bVar13.f12806v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                }
            case 7:
                if (i13 == 7) {
                    b bVar14 = aVar.f12725e;
                    bVar14.f12808x = i12;
                    bVar14.f12807w = -1;
                    return;
                } else if (i13 == 6) {
                    b bVar15 = aVar.f12725e;
                    bVar15.f12807w = i12;
                    bVar15.f12808x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                }
            default:
                throw new IllegalArgumentException(c0(i11) + " to " + c0(i13) + " unknown");
        }
    }

    public void t(int i10, int i11, int i12, int i13, int i14) {
        if (!this.f12720h.containsKey(Integer.valueOf(i10))) {
            this.f12720h.put(Integer.valueOf(i10), new a());
        }
        a aVar = this.f12720h.get(Integer.valueOf(i10));
        if (aVar == null) {
            return;
        }
        switch (i11) {
            case 1:
                if (i13 == 1) {
                    b bVar = aVar.f12725e;
                    bVar.f12786j = i12;
                    bVar.f12788k = -1;
                } else {
                    if (i13 != 2) {
                        throw new IllegalArgumentException("Left to " + c0(i13) + " undefined");
                    }
                    b bVar2 = aVar.f12725e;
                    bVar2.f12788k = i12;
                    bVar2.f12786j = -1;
                }
                aVar.f12725e.f12749H = i14;
                return;
            case 2:
                if (i13 == 1) {
                    b bVar3 = aVar.f12725e;
                    bVar3.f12790l = i12;
                    bVar3.f12792m = -1;
                } else {
                    if (i13 != 2) {
                        throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                    }
                    b bVar4 = aVar.f12725e;
                    bVar4.f12792m = i12;
                    bVar4.f12790l = -1;
                }
                aVar.f12725e.f12750I = i14;
                return;
            case 3:
                if (i13 == 3) {
                    b bVar5 = aVar.f12725e;
                    bVar5.f12794n = i12;
                    bVar5.f12796o = -1;
                    bVar5.f12802r = -1;
                    bVar5.f12803s = -1;
                    bVar5.f12804t = -1;
                } else {
                    if (i13 != 4) {
                        throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                    }
                    b bVar6 = aVar.f12725e;
                    bVar6.f12796o = i12;
                    bVar6.f12794n = -1;
                    bVar6.f12802r = -1;
                    bVar6.f12803s = -1;
                    bVar6.f12804t = -1;
                }
                aVar.f12725e.f12751J = i14;
                return;
            case 4:
                if (i13 == 4) {
                    b bVar7 = aVar.f12725e;
                    bVar7.f12800q = i12;
                    bVar7.f12798p = -1;
                    bVar7.f12802r = -1;
                    bVar7.f12803s = -1;
                    bVar7.f12804t = -1;
                } else {
                    if (i13 != 3) {
                        throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                    }
                    b bVar8 = aVar.f12725e;
                    bVar8.f12798p = i12;
                    bVar8.f12800q = -1;
                    bVar8.f12802r = -1;
                    bVar8.f12803s = -1;
                    bVar8.f12804t = -1;
                }
                aVar.f12725e.f12752K = i14;
                return;
            case 5:
                if (i13 == 5) {
                    b bVar9 = aVar.f12725e;
                    bVar9.f12802r = i12;
                    bVar9.f12800q = -1;
                    bVar9.f12798p = -1;
                    bVar9.f12794n = -1;
                    bVar9.f12796o = -1;
                    return;
                }
                if (i13 == 3) {
                    b bVar10 = aVar.f12725e;
                    bVar10.f12803s = i12;
                    bVar10.f12800q = -1;
                    bVar10.f12798p = -1;
                    bVar10.f12794n = -1;
                    bVar10.f12796o = -1;
                    return;
                }
                if (i13 != 4) {
                    throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                }
                b bVar11 = aVar.f12725e;
                bVar11.f12804t = i12;
                bVar11.f12800q = -1;
                bVar11.f12798p = -1;
                bVar11.f12794n = -1;
                bVar11.f12796o = -1;
                return;
            case 6:
                if (i13 == 6) {
                    b bVar12 = aVar.f12725e;
                    bVar12.f12806v = i12;
                    bVar12.f12805u = -1;
                } else {
                    if (i13 != 7) {
                        throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                    }
                    b bVar13 = aVar.f12725e;
                    bVar13.f12805u = i12;
                    bVar13.f12806v = -1;
                }
                aVar.f12725e.f12754M = i14;
                return;
            case 7:
                if (i13 == 7) {
                    b bVar14 = aVar.f12725e;
                    bVar14.f12808x = i12;
                    bVar14.f12807w = -1;
                } else {
                    if (i13 != 6) {
                        throw new IllegalArgumentException("right to " + c0(i13) + " undefined");
                    }
                    b bVar15 = aVar.f12725e;
                    bVar15.f12807w = i12;
                    bVar15.f12808x = -1;
                }
                aVar.f12725e.f12753L = i14;
                return;
            default:
                throw new IllegalArgumentException(c0(i11) + " to " + c0(i13) + " unknown");
        }
    }

    public void u(int i10, int i11, int i12, float f10) {
        b bVar = B(i10).f12725e;
        bVar.f12743B = i11;
        bVar.f12744C = i12;
        bVar.f12745D = f10;
    }

    public void v(int i10, int i11) {
        B(i10).f12725e.f12776e = i11;
    }

    public void w(int i10, int i11) {
        B(i10).f12725e.f12774d = i11;
    }

    public final int[] x(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(Const.STR_MART_COMMA);
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < strArrSplit.length) {
            String strTrim = strArrSplit[i10].trim();
            try {
                iIntValue = R$id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i11] = iIntValue;
            i10++;
            i11++;
        }
        return i11 != strArrSplit.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public final void y(int i10, int i11, int i12, int i13, int[] iArr, float[] fArr, int i14, int i15, int i16) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            B(iArr[0]).f12725e.f12764W = fArr[0];
        }
        B(iArr[0]).f12725e.f12765X = i14;
        t(iArr[0], i15, i10, i11, -1);
        for (int i17 = 1; i17 < iArr.length; i17++) {
            int i18 = i17 - 1;
            t(iArr[i17], i15, iArr[i18], i16, -1);
            t(iArr[i18], i16, iArr[i17], i15, -1);
            if (fArr != null) {
                B(iArr[i17]).f12725e.f12764W = fArr[i17];
            }
        }
        t(iArr[iArr.length - 1], i16, i12, i13, -1);
    }

    public void z(int i10, int i11, int i12, int i13, int[] iArr, float[] fArr, int i14) {
        y(i10, i11, i12, i13, iArr, fArr, i14, 6, 7);
    }
}

package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.e;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.minor.Minor;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.libpag.BuildConfig;
import org.xmlpull.v1.XmlPullParserException;
import t.C1102b;

/* loaded from: classes.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f8928f = {0, 4, 8};

    /* renamed from: g, reason: collision with root package name */
    private static SparseIntArray f8929g = new SparseIntArray();

    /* renamed from: h, reason: collision with root package name */
    private static SparseIntArray f8930h = new SparseIntArray();

    /* renamed from: a, reason: collision with root package name */
    public String f8931a = BuildConfig.FLAVOR;

    /* renamed from: b, reason: collision with root package name */
    public int f8932b = 0;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, androidx.constraintlayout.widget.a> f8933c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f8934d = true;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, a> f8935e = new HashMap<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f8936a;

        /* renamed from: b, reason: collision with root package name */
        String f8937b;

        /* renamed from: c, reason: collision with root package name */
        public final C0113d f8938c = new C0113d();

        /* renamed from: d, reason: collision with root package name */
        public final c f8939d = new c();

        /* renamed from: e, reason: collision with root package name */
        public final b f8940e = new b();

        /* renamed from: f, reason: collision with root package name */
        public final e f8941f = new e();

        /* renamed from: g, reason: collision with root package name */
        public HashMap<String, androidx.constraintlayout.widget.a> f8942g = new HashMap<>();

        /* renamed from: h, reason: collision with root package name */
        C0112a f8943h;

        /* renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        static class C0112a {

            /* renamed from: a, reason: collision with root package name */
            int[] f8944a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            int[] f8945b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            int f8946c = 0;

            /* renamed from: d, reason: collision with root package name */
            int[] f8947d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            float[] f8948e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            int f8949f = 0;

            /* renamed from: g, reason: collision with root package name */
            int[] f8950g = new int[5];

            /* renamed from: h, reason: collision with root package name */
            String[] f8951h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            int f8952i = 0;

            /* renamed from: j, reason: collision with root package name */
            int[] f8953j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            boolean[] f8954k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            int f8955l = 0;

            C0112a() {
            }

            void a(int i5, float f5) {
                int i6 = this.f8949f;
                int[] iArr = this.f8947d;
                if (i6 >= iArr.length) {
                    this.f8947d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f8948e;
                    this.f8948e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f8947d;
                int i7 = this.f8949f;
                iArr2[i7] = i5;
                float[] fArr2 = this.f8948e;
                this.f8949f = i7 + 1;
                fArr2[i7] = f5;
            }

            void b(int i5, int i6) {
                int i7 = this.f8946c;
                int[] iArr = this.f8944a;
                if (i7 >= iArr.length) {
                    this.f8944a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f8945b;
                    this.f8945b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f8944a;
                int i8 = this.f8946c;
                iArr3[i8] = i5;
                int[] iArr4 = this.f8945b;
                this.f8946c = i8 + 1;
                iArr4[i8] = i6;
            }

            void c(int i5, String str) {
                int i6 = this.f8952i;
                int[] iArr = this.f8950g;
                if (i6 >= iArr.length) {
                    this.f8950g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f8951h;
                    this.f8951h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f8950g;
                int i7 = this.f8952i;
                iArr2[i7] = i5;
                String[] strArr2 = this.f8951h;
                this.f8952i = i7 + 1;
                strArr2[i7] = str;
            }

            void d(int i5, boolean z5) {
                int i6 = this.f8955l;
                int[] iArr = this.f8953j;
                if (i6 >= iArr.length) {
                    this.f8953j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f8954k;
                    this.f8954k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f8953j;
                int i7 = this.f8955l;
                iArr2[i7] = i5;
                boolean[] zArr2 = this.f8954k;
                this.f8955l = i7 + 1;
                zArr2[i7] = z5;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i5, ConstraintLayout.b bVar) {
            this.f8936a = i5;
            b bVar2 = this.f8940e;
            bVar2.f9001j = bVar.f8834e;
            bVar2.f9003k = bVar.f8836f;
            bVar2.f9005l = bVar.f8838g;
            bVar2.f9007m = bVar.f8840h;
            bVar2.f9009n = bVar.f8842i;
            bVar2.f9011o = bVar.f8844j;
            bVar2.f9013p = bVar.f8846k;
            bVar2.f9015q = bVar.f8848l;
            bVar2.f9017r = bVar.f8850m;
            bVar2.f9018s = bVar.f8852n;
            bVar2.f9019t = bVar.f8854o;
            bVar2.f9020u = bVar.f8862s;
            bVar2.f9021v = bVar.f8864t;
            bVar2.f9022w = bVar.f8866u;
            bVar2.f9023x = bVar.f8868v;
            bVar2.f9024y = bVar.f8806G;
            bVar2.f9025z = bVar.f8807H;
            bVar2.f8957A = bVar.f8808I;
            bVar2.f8958B = bVar.f8856p;
            bVar2.f8959C = bVar.f8858q;
            bVar2.f8960D = bVar.f8860r;
            bVar2.f8961E = bVar.f8823X;
            bVar2.f8962F = bVar.f8824Y;
            bVar2.f8963G = bVar.f8825Z;
            bVar2.f8997h = bVar.f8830c;
            bVar2.f8993f = bVar.f8826a;
            bVar2.f8995g = bVar.f8828b;
            bVar2.f8989d = ((ViewGroup.MarginLayoutParams) bVar).width;
            bVar2.f8991e = ((ViewGroup.MarginLayoutParams) bVar).height;
            bVar2.f8964H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            bVar2.f8965I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            bVar2.f8966J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            bVar2.f8967K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            bVar2.f8970N = bVar.f8803D;
            bVar2.f8978V = bVar.f8812M;
            bVar2.f8979W = bVar.f8811L;
            bVar2.f8981Y = bVar.f8814O;
            bVar2.f8980X = bVar.f8813N;
            bVar2.f9010n0 = bVar.f8827a0;
            bVar2.f9012o0 = bVar.f8829b0;
            bVar2.f8982Z = bVar.f8815P;
            bVar2.f8984a0 = bVar.f8816Q;
            bVar2.f8986b0 = bVar.f8819T;
            bVar2.f8988c0 = bVar.f8820U;
            bVar2.f8990d0 = bVar.f8817R;
            bVar2.f8992e0 = bVar.f8818S;
            bVar2.f8994f0 = bVar.f8821V;
            bVar2.f8996g0 = bVar.f8822W;
            bVar2.f9008m0 = bVar.f8831c0;
            bVar2.f8972P = bVar.f8872x;
            bVar2.f8974R = bVar.f8874z;
            bVar2.f8971O = bVar.f8870w;
            bVar2.f8973Q = bVar.f8873y;
            bVar2.f8976T = bVar.f8800A;
            bVar2.f8975S = bVar.f8801B;
            bVar2.f8977U = bVar.f8802C;
            bVar2.f9016q0 = bVar.f8833d0;
            bVar2.f8968L = bVar.getMarginEnd();
            this.f8940e.f8969M = bVar.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i5, e.a aVar) {
            f(i5, aVar);
            this.f8938c.f9044d = aVar.f9072x0;
            e eVar = this.f8941f;
            eVar.f9048b = aVar.f9062A0;
            eVar.f9049c = aVar.f9063B0;
            eVar.f9050d = aVar.f9064C0;
            eVar.f9051e = aVar.f9065D0;
            eVar.f9052f = aVar.f9066E0;
            eVar.f9053g = aVar.f9067F0;
            eVar.f9054h = aVar.f9068G0;
            eVar.f9056j = aVar.f9069H0;
            eVar.f9057k = aVar.f9070I0;
            eVar.f9058l = aVar.f9071J0;
            eVar.f9060n = aVar.f9074z0;
            eVar.f9059m = aVar.f9073y0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(androidx.constraintlayout.widget.b bVar, int i5, e.a aVar) {
            g(i5, aVar);
            if (bVar instanceof Barrier) {
                b bVar2 = this.f8940e;
                bVar2.f9002j0 = 1;
                Barrier barrier = (Barrier) bVar;
                bVar2.f8998h0 = barrier.getType();
                this.f8940e.f9004k0 = barrier.getReferencedIds();
                this.f8940e.f9000i0 = barrier.getMargin();
            }
        }

        public void d(ConstraintLayout.b bVar) {
            b bVar2 = this.f8940e;
            bVar.f8834e = bVar2.f9001j;
            bVar.f8836f = bVar2.f9003k;
            bVar.f8838g = bVar2.f9005l;
            bVar.f8840h = bVar2.f9007m;
            bVar.f8842i = bVar2.f9009n;
            bVar.f8844j = bVar2.f9011o;
            bVar.f8846k = bVar2.f9013p;
            bVar.f8848l = bVar2.f9015q;
            bVar.f8850m = bVar2.f9017r;
            bVar.f8852n = bVar2.f9018s;
            bVar.f8854o = bVar2.f9019t;
            bVar.f8862s = bVar2.f9020u;
            bVar.f8864t = bVar2.f9021v;
            bVar.f8866u = bVar2.f9022w;
            bVar.f8868v = bVar2.f9023x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = bVar2.f8964H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = bVar2.f8965I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = bVar2.f8966J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = bVar2.f8967K;
            bVar.f8800A = bVar2.f8976T;
            bVar.f8801B = bVar2.f8975S;
            bVar.f8872x = bVar2.f8972P;
            bVar.f8874z = bVar2.f8974R;
            bVar.f8806G = bVar2.f9024y;
            bVar.f8807H = bVar2.f9025z;
            bVar.f8856p = bVar2.f8958B;
            bVar.f8858q = bVar2.f8959C;
            bVar.f8860r = bVar2.f8960D;
            bVar.f8808I = bVar2.f8957A;
            bVar.f8823X = bVar2.f8961E;
            bVar.f8824Y = bVar2.f8962F;
            bVar.f8812M = bVar2.f8978V;
            bVar.f8811L = bVar2.f8979W;
            bVar.f8814O = bVar2.f8981Y;
            bVar.f8813N = bVar2.f8980X;
            bVar.f8827a0 = bVar2.f9010n0;
            bVar.f8829b0 = bVar2.f9012o0;
            bVar.f8815P = bVar2.f8982Z;
            bVar.f8816Q = bVar2.f8984a0;
            bVar.f8819T = bVar2.f8986b0;
            bVar.f8820U = bVar2.f8988c0;
            bVar.f8817R = bVar2.f8990d0;
            bVar.f8818S = bVar2.f8992e0;
            bVar.f8821V = bVar2.f8994f0;
            bVar.f8822W = bVar2.f8996g0;
            bVar.f8825Z = bVar2.f8963G;
            bVar.f8830c = bVar2.f8997h;
            bVar.f8826a = bVar2.f8993f;
            bVar.f8828b = bVar2.f8995g;
            ((ViewGroup.MarginLayoutParams) bVar).width = bVar2.f8989d;
            ((ViewGroup.MarginLayoutParams) bVar).height = bVar2.f8991e;
            String str = bVar2.f9008m0;
            if (str != null) {
                bVar.f8831c0 = str;
            }
            bVar.f8833d0 = bVar2.f9016q0;
            bVar.setMarginStart(bVar2.f8969M);
            bVar.setMarginEnd(this.f8940e.f8968L);
            bVar.a();
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f8940e.a(this.f8940e);
            aVar.f8939d.a(this.f8939d);
            aVar.f8938c.a(this.f8938c);
            aVar.f8941f.a(this.f8941f);
            aVar.f8936a = this.f8936a;
            aVar.f8943h = this.f8943h;
            return aVar;
        }
    }

    public static class b {

        /* renamed from: r0, reason: collision with root package name */
        private static SparseIntArray f8956r0;

        /* renamed from: d, reason: collision with root package name */
        public int f8989d;

        /* renamed from: e, reason: collision with root package name */
        public int f8991e;

        /* renamed from: k0, reason: collision with root package name */
        public int[] f9004k0;

        /* renamed from: l0, reason: collision with root package name */
        public String f9006l0;

        /* renamed from: m0, reason: collision with root package name */
        public String f9008m0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f8983a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8985b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f8987c = false;

        /* renamed from: f, reason: collision with root package name */
        public int f8993f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f8995g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f8997h = -1.0f;

        /* renamed from: i, reason: collision with root package name */
        public boolean f8999i = true;

        /* renamed from: j, reason: collision with root package name */
        public int f9001j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f9003k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f9005l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f9007m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f9009n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f9011o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f9013p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f9015q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f9017r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f9018s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f9019t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f9020u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f9021v = -1;

        /* renamed from: w, reason: collision with root package name */
        public int f9022w = -1;

        /* renamed from: x, reason: collision with root package name */
        public int f9023x = -1;

        /* renamed from: y, reason: collision with root package name */
        public float f9024y = 0.5f;

        /* renamed from: z, reason: collision with root package name */
        public float f9025z = 0.5f;

        /* renamed from: A, reason: collision with root package name */
        public String f8957A = null;

        /* renamed from: B, reason: collision with root package name */
        public int f8958B = -1;

        /* renamed from: C, reason: collision with root package name */
        public int f8959C = 0;

        /* renamed from: D, reason: collision with root package name */
        public float f8960D = 0.0f;

        /* renamed from: E, reason: collision with root package name */
        public int f8961E = -1;

        /* renamed from: F, reason: collision with root package name */
        public int f8962F = -1;

        /* renamed from: G, reason: collision with root package name */
        public int f8963G = -1;

        /* renamed from: H, reason: collision with root package name */
        public int f8964H = 0;

        /* renamed from: I, reason: collision with root package name */
        public int f8965I = 0;

        /* renamed from: J, reason: collision with root package name */
        public int f8966J = 0;

        /* renamed from: K, reason: collision with root package name */
        public int f8967K = 0;

        /* renamed from: L, reason: collision with root package name */
        public int f8968L = 0;

        /* renamed from: M, reason: collision with root package name */
        public int f8969M = 0;

        /* renamed from: N, reason: collision with root package name */
        public int f8970N = 0;

        /* renamed from: O, reason: collision with root package name */
        public int f8971O = Integer.MIN_VALUE;

        /* renamed from: P, reason: collision with root package name */
        public int f8972P = Integer.MIN_VALUE;

        /* renamed from: Q, reason: collision with root package name */
        public int f8973Q = Integer.MIN_VALUE;

        /* renamed from: R, reason: collision with root package name */
        public int f8974R = Integer.MIN_VALUE;

        /* renamed from: S, reason: collision with root package name */
        public int f8975S = Integer.MIN_VALUE;

        /* renamed from: T, reason: collision with root package name */
        public int f8976T = Integer.MIN_VALUE;

        /* renamed from: U, reason: collision with root package name */
        public int f8977U = Integer.MIN_VALUE;

        /* renamed from: V, reason: collision with root package name */
        public float f8978V = -1.0f;

        /* renamed from: W, reason: collision with root package name */
        public float f8979W = -1.0f;

        /* renamed from: X, reason: collision with root package name */
        public int f8980X = 0;

        /* renamed from: Y, reason: collision with root package name */
        public int f8981Y = 0;

        /* renamed from: Z, reason: collision with root package name */
        public int f8982Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f8984a0 = 0;

        /* renamed from: b0, reason: collision with root package name */
        public int f8986b0 = 0;

        /* renamed from: c0, reason: collision with root package name */
        public int f8988c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f8990d0 = 0;

        /* renamed from: e0, reason: collision with root package name */
        public int f8992e0 = 0;

        /* renamed from: f0, reason: collision with root package name */
        public float f8994f0 = 1.0f;

        /* renamed from: g0, reason: collision with root package name */
        public float f8996g0 = 1.0f;

        /* renamed from: h0, reason: collision with root package name */
        public int f8998h0 = -1;

        /* renamed from: i0, reason: collision with root package name */
        public int f9000i0 = 0;

        /* renamed from: j0, reason: collision with root package name */
        public int f9002j0 = -1;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f9010n0 = false;

        /* renamed from: o0, reason: collision with root package name */
        public boolean f9012o0 = false;

        /* renamed from: p0, reason: collision with root package name */
        public boolean f9014p0 = true;

        /* renamed from: q0, reason: collision with root package name */
        public int f9016q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8956r0 = sparseIntArray;
            sparseIntArray.append(i.j6, 24);
            f8956r0.append(i.k6, 25);
            f8956r0.append(i.m6, 28);
            f8956r0.append(i.n6, 29);
            f8956r0.append(i.s6, 35);
            f8956r0.append(i.r6, 34);
            f8956r0.append(i.T5, 4);
            f8956r0.append(i.S5, 3);
            f8956r0.append(i.Q5, 1);
            f8956r0.append(i.y6, 6);
            f8956r0.append(i.z6, 7);
            f8956r0.append(i.a6, 17);
            f8956r0.append(i.b6, 18);
            f8956r0.append(i.c6, 19);
            f8956r0.append(i.M5, 90);
            f8956r0.append(i.y5, 26);
            f8956r0.append(i.o6, 31);
            f8956r0.append(i.p6, 32);
            f8956r0.append(i.Z5, 10);
            f8956r0.append(i.Y5, 9);
            f8956r0.append(i.C6, 13);
            f8956r0.append(i.F6, 16);
            f8956r0.append(i.D6, 14);
            f8956r0.append(i.A6, 11);
            f8956r0.append(i.E6, 15);
            f8956r0.append(i.B6, 12);
            f8956r0.append(i.v6, 38);
            f8956r0.append(i.h6, 37);
            f8956r0.append(i.g6, 39);
            f8956r0.append(i.u6, 40);
            f8956r0.append(i.f6, 20);
            f8956r0.append(i.t6, 36);
            f8956r0.append(i.X5, 5);
            f8956r0.append(i.i6, 91);
            f8956r0.append(i.q6, 91);
            f8956r0.append(i.l6, 91);
            f8956r0.append(i.R5, 91);
            f8956r0.append(i.P5, 91);
            f8956r0.append(i.B5, 23);
            f8956r0.append(i.D5, 27);
            f8956r0.append(i.F5, 30);
            f8956r0.append(i.G5, 8);
            f8956r0.append(i.C5, 33);
            f8956r0.append(i.E5, 2);
            f8956r0.append(i.z5, 22);
            f8956r0.append(i.A5, 21);
            f8956r0.append(i.w6, 41);
            f8956r0.append(i.d6, 42);
            f8956r0.append(i.O5, 41);
            f8956r0.append(i.N5, 42);
            f8956r0.append(i.G6, 76);
            f8956r0.append(i.U5, 61);
            f8956r0.append(i.W5, 62);
            f8956r0.append(i.V5, 63);
            f8956r0.append(i.x6, 69);
            f8956r0.append(i.e6, 70);
            f8956r0.append(i.K5, 71);
            f8956r0.append(i.I5, 72);
            f8956r0.append(i.J5, 73);
            f8956r0.append(i.L5, 74);
            f8956r0.append(i.H5, 75);
        }

        public void a(b bVar) {
            this.f8983a = bVar.f8983a;
            this.f8989d = bVar.f8989d;
            this.f8985b = bVar.f8985b;
            this.f8991e = bVar.f8991e;
            this.f8993f = bVar.f8993f;
            this.f8995g = bVar.f8995g;
            this.f8997h = bVar.f8997h;
            this.f8999i = bVar.f8999i;
            this.f9001j = bVar.f9001j;
            this.f9003k = bVar.f9003k;
            this.f9005l = bVar.f9005l;
            this.f9007m = bVar.f9007m;
            this.f9009n = bVar.f9009n;
            this.f9011o = bVar.f9011o;
            this.f9013p = bVar.f9013p;
            this.f9015q = bVar.f9015q;
            this.f9017r = bVar.f9017r;
            this.f9018s = bVar.f9018s;
            this.f9019t = bVar.f9019t;
            this.f9020u = bVar.f9020u;
            this.f9021v = bVar.f9021v;
            this.f9022w = bVar.f9022w;
            this.f9023x = bVar.f9023x;
            this.f9024y = bVar.f9024y;
            this.f9025z = bVar.f9025z;
            this.f8957A = bVar.f8957A;
            this.f8958B = bVar.f8958B;
            this.f8959C = bVar.f8959C;
            this.f8960D = bVar.f8960D;
            this.f8961E = bVar.f8961E;
            this.f8962F = bVar.f8962F;
            this.f8963G = bVar.f8963G;
            this.f8964H = bVar.f8964H;
            this.f8965I = bVar.f8965I;
            this.f8966J = bVar.f8966J;
            this.f8967K = bVar.f8967K;
            this.f8968L = bVar.f8968L;
            this.f8969M = bVar.f8969M;
            this.f8970N = bVar.f8970N;
            this.f8971O = bVar.f8971O;
            this.f8972P = bVar.f8972P;
            this.f8973Q = bVar.f8973Q;
            this.f8974R = bVar.f8974R;
            this.f8975S = bVar.f8975S;
            this.f8976T = bVar.f8976T;
            this.f8977U = bVar.f8977U;
            this.f8978V = bVar.f8978V;
            this.f8979W = bVar.f8979W;
            this.f8980X = bVar.f8980X;
            this.f8981Y = bVar.f8981Y;
            this.f8982Z = bVar.f8982Z;
            this.f8984a0 = bVar.f8984a0;
            this.f8986b0 = bVar.f8986b0;
            this.f8988c0 = bVar.f8988c0;
            this.f8990d0 = bVar.f8990d0;
            this.f8992e0 = bVar.f8992e0;
            this.f8994f0 = bVar.f8994f0;
            this.f8996g0 = bVar.f8996g0;
            this.f8998h0 = bVar.f8998h0;
            this.f9000i0 = bVar.f9000i0;
            this.f9002j0 = bVar.f9002j0;
            this.f9008m0 = bVar.f9008m0;
            int[] iArr = bVar.f9004k0;
            if (iArr == null || bVar.f9006l0 != null) {
                this.f9004k0 = null;
            } else {
                this.f9004k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f9006l0 = bVar.f9006l0;
            this.f9010n0 = bVar.f9010n0;
            this.f9012o0 = bVar.f9012o0;
            this.f9014p0 = bVar.f9014p0;
            this.f9016q0 = bVar.f9016q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.x5);
            this.f8985b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                int i6 = f8956r0.get(index);
                switch (i6) {
                    case 1:
                        this.f9017r = d.u(typedArrayObtainStyledAttributes, index, this.f9017r);
                        break;
                    case 2:
                        this.f8967K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8967K);
                        break;
                    case 3:
                        this.f9015q = d.u(typedArrayObtainStyledAttributes, index, this.f9015q);
                        break;
                    case 4:
                        this.f9013p = d.u(typedArrayObtainStyledAttributes, index, this.f9013p);
                        break;
                    case 5:
                        this.f8957A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.f8961E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8961E);
                        break;
                    case 7:
                        this.f8962F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8962F);
                        break;
                    case 8:
                        this.f8968L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8968L);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                        this.f9023x = d.u(typedArrayObtainStyledAttributes, index, this.f9023x);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                        this.f9022w = d.u(typedArrayObtainStyledAttributes, index, this.f9022w);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                        this.f8974R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8974R);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                        this.f8975S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8975S);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                        this.f8971O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8971O);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                        this.f8973Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8973Q);
                        break;
                    case 15:
                        this.f8976T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8976T);
                        break;
                    case 16:
                        this.f8972P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8972P);
                        break;
                    case 17:
                        this.f8993f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8993f);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                        this.f8995g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f8995g);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                        this.f8997h = typedArrayObtainStyledAttributes.getFloat(index, this.f8997h);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                        this.f9024y = typedArrayObtainStyledAttributes.getFloat(index, this.f9024y);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                        this.f8991e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f8991e);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                        this.f8989d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f8989d);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                        this.f8964H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8964H);
                        break;
                    case 24:
                        this.f9001j = d.u(typedArrayObtainStyledAttributes, index, this.f9001j);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                        this.f9003k = d.u(typedArrayObtainStyledAttributes, index, this.f9003k);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                        this.f8963G = typedArrayObtainStyledAttributes.getInt(index, this.f8963G);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                        this.f8965I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8965I);
                        break;
                    case 28:
                        this.f9005l = d.u(typedArrayObtainStyledAttributes, index, this.f9005l);
                        break;
                    case 29:
                        this.f9007m = d.u(typedArrayObtainStyledAttributes, index, this.f9007m);
                        break;
                    case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                        this.f8969M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8969M);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                        this.f9020u = d.u(typedArrayObtainStyledAttributes, index, this.f9020u);
                        break;
                    case 32:
                        this.f9021v = d.u(typedArrayObtainStyledAttributes, index, this.f9021v);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                        this.f8966J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8966J);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                        this.f9011o = d.u(typedArrayObtainStyledAttributes, index, this.f9011o);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                        this.f9009n = d.u(typedArrayObtainStyledAttributes, index, this.f9009n);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                        this.f9025z = typedArrayObtainStyledAttributes.getFloat(index, this.f9025z);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                        this.f8979W = typedArrayObtainStyledAttributes.getFloat(index, this.f8979W);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                        this.f8978V = typedArrayObtainStyledAttributes.getFloat(index, this.f8978V);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                        this.f8980X = typedArrayObtainStyledAttributes.getInt(index, this.f8980X);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                        this.f8981Y = typedArrayObtainStyledAttributes.getInt(index, this.f8981Y);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                        d.v(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                        d.v(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i6) {
                            case 61:
                                this.f8958B = d.u(typedArrayObtainStyledAttributes, index, this.f8958B);
                                break;
                            case 62:
                                this.f8959C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8959C);
                                break;
                            case 63:
                                this.f8960D = typedArrayObtainStyledAttributes.getFloat(index, this.f8960D);
                                break;
                            default:
                                switch (i6) {
                                    case 69:
                                        this.f8994f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f8996g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f8998h0 = typedArrayObtainStyledAttributes.getInt(index, this.f8998h0);
                                        break;
                                    case 73:
                                        this.f9000i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f9000i0);
                                        break;
                                    case 74:
                                        this.f9006l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f9014p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f9014p0);
                                        break;
                                    case 76:
                                        this.f9016q0 = typedArrayObtainStyledAttributes.getInt(index, this.f9016q0);
                                        break;
                                    case 77:
                                        this.f9018s = d.u(typedArrayObtainStyledAttributes, index, this.f9018s);
                                        break;
                                    case 78:
                                        this.f9019t = d.u(typedArrayObtainStyledAttributes, index, this.f9019t);
                                        break;
                                    case 79:
                                        this.f8977U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8977U);
                                        break;
                                    case 80:
                                        this.f8970N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8970N);
                                        break;
                                    case 81:
                                        this.f8982Z = typedArrayObtainStyledAttributes.getInt(index, this.f8982Z);
                                        break;
                                    case 82:
                                        this.f8984a0 = typedArrayObtainStyledAttributes.getInt(index, this.f8984a0);
                                        break;
                                    case 83:
                                        this.f8988c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8988c0);
                                        break;
                                    case 84:
                                        this.f8986b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8986b0);
                                        break;
                                    case 85:
                                        this.f8992e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8992e0);
                                        break;
                                    case 86:
                                        this.f8990d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f8990d0);
                                        break;
                                    case 87:
                                        this.f9010n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f9010n0);
                                        break;
                                    case 88:
                                        this.f9012o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f9012o0);
                                        break;
                                    case 89:
                                        this.f9008m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f8999i = typedArrayObtainStyledAttributes.getBoolean(index, this.f8999i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f8956r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f8956r0.get(index));
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class c {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f9026o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f9027a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f9028b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f9029c = 0;

        /* renamed from: d, reason: collision with root package name */
        public String f9030d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f9031e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f9032f = 0;

        /* renamed from: g, reason: collision with root package name */
        public float f9033g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public int f9034h = -1;

        /* renamed from: i, reason: collision with root package name */
        public float f9035i = Float.NaN;

        /* renamed from: j, reason: collision with root package name */
        public float f9036j = Float.NaN;

        /* renamed from: k, reason: collision with root package name */
        public int f9037k = -1;

        /* renamed from: l, reason: collision with root package name */
        public String f9038l = null;

        /* renamed from: m, reason: collision with root package name */
        public int f9039m = -3;

        /* renamed from: n, reason: collision with root package name */
        public int f9040n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f9026o = sparseIntArray;
            sparseIntArray.append(i.S6, 1);
            f9026o.append(i.U6, 2);
            f9026o.append(i.Y6, 3);
            f9026o.append(i.R6, 4);
            f9026o.append(i.Q6, 5);
            f9026o.append(i.P6, 6);
            f9026o.append(i.T6, 7);
            f9026o.append(i.X6, 8);
            f9026o.append(i.W6, 9);
            f9026o.append(i.V6, 10);
        }

        public void a(c cVar) {
            this.f9027a = cVar.f9027a;
            this.f9028b = cVar.f9028b;
            this.f9030d = cVar.f9030d;
            this.f9031e = cVar.f9031e;
            this.f9032f = cVar.f9032f;
            this.f9035i = cVar.f9035i;
            this.f9033g = cVar.f9033g;
            this.f9034h = cVar.f9034h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.O6);
            this.f9027a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                switch (f9026o.get(index)) {
                    case 1:
                        this.f9035i = typedArrayObtainStyledAttributes.getFloat(index, this.f9035i);
                        break;
                    case 2:
                        this.f9031e = typedArrayObtainStyledAttributes.getInt(index, this.f9031e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f9030d = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f9030d = C1102b.f22291c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f9032f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f9028b = d.u(typedArrayObtainStyledAttributes, index, this.f9028b);
                        break;
                    case 6:
                        this.f9029c = typedArrayObtainStyledAttributes.getInteger(index, this.f9029c);
                        break;
                    case 7:
                        this.f9033g = typedArrayObtainStyledAttributes.getFloat(index, this.f9033g);
                        break;
                    case 8:
                        this.f9037k = typedArrayObtainStyledAttributes.getInteger(index, this.f9037k);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                        this.f9036j = typedArrayObtainStyledAttributes.getFloat(index, this.f9036j);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                        int i6 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i6 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f9040n = resourceId;
                            if (resourceId != -1) {
                                this.f9039m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i6 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f9038l = string;
                            if (string.indexOf("/") > 0) {
                                this.f9040n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f9039m = -2;
                                break;
                            } else {
                                this.f9039m = -1;
                                break;
                            }
                        } else {
                            this.f9039m = typedArrayObtainStyledAttributes.getInteger(index, this.f9040n);
                            break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    public static class C0113d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9041a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f9042b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f9043c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f9044d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f9045e = Float.NaN;

        public void a(C0113d c0113d) {
            this.f9041a = c0113d.f9041a;
            this.f9042b = c0113d.f9042b;
            this.f9044d = c0113d.f9044d;
            this.f9045e = c0113d.f9045e;
            this.f9043c = c0113d.f9043c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.l7);
            this.f9041a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.n7) {
                    this.f9044d = typedArrayObtainStyledAttributes.getFloat(index, this.f9044d);
                } else if (index == i.m7) {
                    this.f9042b = typedArrayObtainStyledAttributes.getInt(index, this.f9042b);
                    this.f9042b = d.f8928f[this.f9042b];
                } else if (index == i.p7) {
                    this.f9043c = typedArrayObtainStyledAttributes.getInt(index, this.f9043c);
                } else if (index == i.o7) {
                    this.f9045e = typedArrayObtainStyledAttributes.getFloat(index, this.f9045e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {

        /* renamed from: o, reason: collision with root package name */
        private static SparseIntArray f9046o;

        /* renamed from: a, reason: collision with root package name */
        public boolean f9047a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f9048b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f9049c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f9050d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f9051e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f9052f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f9053g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f9054h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public int f9055i = -1;

        /* renamed from: j, reason: collision with root package name */
        public float f9056j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f9057k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f9058l = 0.0f;

        /* renamed from: m, reason: collision with root package name */
        public boolean f9059m = false;

        /* renamed from: n, reason: collision with root package name */
        public float f9060n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f9046o = sparseIntArray;
            sparseIntArray.append(i.K7, 1);
            f9046o.append(i.L7, 2);
            f9046o.append(i.M7, 3);
            f9046o.append(i.I7, 4);
            f9046o.append(i.J7, 5);
            f9046o.append(i.E7, 6);
            f9046o.append(i.F7, 7);
            f9046o.append(i.G7, 8);
            f9046o.append(i.H7, 9);
            f9046o.append(i.N7, 10);
            f9046o.append(i.O7, 11);
            f9046o.append(i.P7, 12);
        }

        public void a(e eVar) {
            this.f9047a = eVar.f9047a;
            this.f9048b = eVar.f9048b;
            this.f9049c = eVar.f9049c;
            this.f9050d = eVar.f9050d;
            this.f9051e = eVar.f9051e;
            this.f9052f = eVar.f9052f;
            this.f9053g = eVar.f9053g;
            this.f9054h = eVar.f9054h;
            this.f9055i = eVar.f9055i;
            this.f9056j = eVar.f9056j;
            this.f9057k = eVar.f9057k;
            this.f9058l = eVar.f9058l;
            this.f9059m = eVar.f9059m;
            this.f9060n = eVar.f9060n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.D7);
            this.f9047a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                switch (f9046o.get(index)) {
                    case 1:
                        this.f9048b = typedArrayObtainStyledAttributes.getFloat(index, this.f9048b);
                        break;
                    case 2:
                        this.f9049c = typedArrayObtainStyledAttributes.getFloat(index, this.f9049c);
                        break;
                    case 3:
                        this.f9050d = typedArrayObtainStyledAttributes.getFloat(index, this.f9050d);
                        break;
                    case 4:
                        this.f9051e = typedArrayObtainStyledAttributes.getFloat(index, this.f9051e);
                        break;
                    case 5:
                        this.f9052f = typedArrayObtainStyledAttributes.getFloat(index, this.f9052f);
                        break;
                    case 6:
                        this.f9053g = typedArrayObtainStyledAttributes.getDimension(index, this.f9053g);
                        break;
                    case 7:
                        this.f9054h = typedArrayObtainStyledAttributes.getDimension(index, this.f9054h);
                        break;
                    case 8:
                        this.f9056j = typedArrayObtainStyledAttributes.getDimension(index, this.f9056j);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                        this.f9057k = typedArrayObtainStyledAttributes.getDimension(index, this.f9057k);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                        this.f9058l = typedArrayObtainStyledAttributes.getDimension(index, this.f9058l);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                        this.f9059m = true;
                        this.f9060n = typedArrayObtainStyledAttributes.getDimension(index, this.f9060n);
                        break;
                    case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                        this.f9055i = d.u(typedArrayObtainStyledAttributes, index, this.f9055i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        f8929g.append(i.f9079A0, 25);
        f8929g.append(i.f9085B0, 26);
        f8929g.append(i.f9097D0, 29);
        f8929g.append(i.f9103E0, 30);
        f8929g.append(i.f9139K0, 36);
        f8929g.append(i.f9133J0, 35);
        f8929g.append(i.f9282h0, 4);
        f8929g.append(i.f9276g0, 3);
        f8929g.append(i.f9249c0, 1);
        f8929g.append(i.f9263e0, 91);
        f8929g.append(i.f9256d0, 92);
        f8929g.append(i.f9193T0, 6);
        f8929g.append(i.f9199U0, 7);
        f8929g.append(i.f9324o0, 17);
        f8929g.append(i.f9330p0, 18);
        f8929g.append(i.f9336q0, 19);
        f8929g.append(i.f9222Y, 99);
        f8929g.append(i.f9359u, 27);
        f8929g.append(i.f9109F0, 32);
        f8929g.append(i.f9115G0, 33);
        f8929g.append(i.f9318n0, 10);
        f8929g.append(i.f9312m0, 9);
        f8929g.append(i.f9217X0, 13);
        f8929g.append(i.f9236a1, 16);
        f8929g.append(i.f9223Y0, 14);
        f8929g.append(i.f9205V0, 11);
        f8929g.append(i.f9229Z0, 15);
        f8929g.append(i.f9211W0, 12);
        f8929g.append(i.f9157N0, 40);
        f8929g.append(i.f9384y0, 39);
        f8929g.append(i.f9378x0, 41);
        f8929g.append(i.f9151M0, 42);
        f8929g.append(i.f9372w0, 20);
        f8929g.append(i.f9145L0, 37);
        f8929g.append(i.f9306l0, 5);
        f8929g.append(i.f9390z0, 87);
        f8929g.append(i.f9127I0, 87);
        f8929g.append(i.f9091C0, 87);
        f8929g.append(i.f9270f0, 87);
        f8929g.append(i.f9242b0, 87);
        f8929g.append(i.f9389z, 24);
        f8929g.append(i.f9084B, 28);
        f8929g.append(i.f9156N, 31);
        f8929g.append(i.f9162O, 8);
        f8929g.append(i.f9078A, 34);
        f8929g.append(i.f9090C, 2);
        f8929g.append(i.f9377x, 23);
        f8929g.append(i.f9383y, 21);
        f8929g.append(i.f9163O0, 95);
        f8929g.append(i.f9342r0, 96);
        f8929g.append(i.f9371w, 22);
        f8929g.append(i.f9096D, 43);
        f8929g.append(i.f9174Q, 44);
        f8929g.append(i.f9144L, 45);
        f8929g.append(i.f9150M, 46);
        f8929g.append(i.f9138K, 60);
        f8929g.append(i.f9126I, 47);
        f8929g.append(i.f9132J, 48);
        f8929g.append(i.f9102E, 49);
        f8929g.append(i.f9108F, 50);
        f8929g.append(i.f9114G, 51);
        f8929g.append(i.f9120H, 52);
        f8929g.append(i.f9168P, 53);
        f8929g.append(i.f9169P0, 54);
        f8929g.append(i.f9348s0, 55);
        f8929g.append(i.f9175Q0, 56);
        f8929g.append(i.f9354t0, 57);
        f8929g.append(i.f9181R0, 58);
        f8929g.append(i.f9360u0, 59);
        f8929g.append(i.f9288i0, 61);
        f8929g.append(i.f9300k0, 62);
        f8929g.append(i.f9294j0, 63);
        f8929g.append(i.f9180R, 64);
        f8929g.append(i.f9301k1, 65);
        f8929g.append(i.f9216X, 66);
        f8929g.append(i.f9307l1, 67);
        f8929g.append(i.f9257d1, 79);
        f8929g.append(i.f9365v, 38);
        f8929g.append(i.f9250c1, 68);
        f8929g.append(i.f9187S0, 69);
        f8929g.append(i.f9366v0, 70);
        f8929g.append(i.f9243b1, 97);
        f8929g.append(i.f9204V, 71);
        f8929g.append(i.f9192T, 72);
        f8929g.append(i.f9198U, 73);
        f8929g.append(i.f9210W, 74);
        f8929g.append(i.f9186S, 75);
        f8929g.append(i.f9264e1, 76);
        f8929g.append(i.f9121H0, 77);
        f8929g.append(i.f9313m1, 78);
        f8929g.append(i.f9235a0, 80);
        f8929g.append(i.f9228Z, 81);
        f8929g.append(i.f9271f1, 82);
        f8929g.append(i.f9295j1, 83);
        f8929g.append(i.f9289i1, 84);
        f8929g.append(i.f9283h1, 85);
        f8929g.append(i.f9277g1, 86);
        SparseIntArray sparseIntArray = f8930h;
        int i5 = i.f9340q4;
        sparseIntArray.append(i5, 6);
        f8930h.append(i5, 7);
        f8930h.append(i.f9309l3, 27);
        f8930h.append(i.f9358t4, 13);
        f8930h.append(i.f9376w4, 16);
        f8930h.append(i.f9364u4, 14);
        f8930h.append(i.f9346r4, 11);
        f8930h.append(i.f9370v4, 15);
        f8930h.append(i.f9352s4, 12);
        f8930h.append(i.f9304k4, 40);
        f8930h.append(i.f9260d4, 39);
        f8930h.append(i.f9253c4, 41);
        f8930h.append(i.f9298j4, 42);
        f8930h.append(i.f9246b4, 20);
        f8930h.append(i.f9292i4, 37);
        f8930h.append(i.f9208V3, 5);
        f8930h.append(i.f9267e4, 87);
        f8930h.append(i.f9286h4, 87);
        f8930h.append(i.f9274f4, 87);
        f8930h.append(i.f9190S3, 87);
        f8930h.append(i.f9184R3, 87);
        f8930h.append(i.f9339q3, 24);
        f8930h.append(i.f9351s3, 28);
        f8930h.append(i.f9106E3, 31);
        f8930h.append(i.f9112F3, 8);
        f8930h.append(i.f9345r3, 34);
        f8930h.append(i.f9357t3, 2);
        f8930h.append(i.f9327o3, 23);
        f8930h.append(i.f9333p3, 21);
        f8930h.append(i.f9310l4, 95);
        f8930h.append(i.f9214W3, 96);
        f8930h.append(i.f9321n3, 22);
        f8930h.append(i.f9363u3, 43);
        f8930h.append(i.f9124H3, 44);
        f8930h.append(i.f9094C3, 45);
        f8930h.append(i.f9100D3, 46);
        f8930h.append(i.f9088B3, 60);
        f8930h.append(i.f9393z3, 47);
        f8930h.append(i.f9082A3, 48);
        f8930h.append(i.f9369v3, 49);
        f8930h.append(i.f9375w3, 50);
        f8930h.append(i.f9381x3, 51);
        f8930h.append(i.f9387y3, 52);
        f8930h.append(i.f9118G3, 53);
        f8930h.append(i.f9316m4, 54);
        f8930h.append(i.f9220X3, 55);
        f8930h.append(i.f9322n4, 56);
        f8930h.append(i.f9226Y3, 57);
        f8930h.append(i.f9328o4, 58);
        f8930h.append(i.f9232Z3, 59);
        f8930h.append(i.f9202U3, 62);
        f8930h.append(i.f9196T3, 63);
        f8930h.append(i.f9130I3, 64);
        f8930h.append(i.f9125H4, 65);
        f8930h.append(i.f9166O3, 66);
        f8930h.append(i.f9131I4, 67);
        f8930h.append(i.f9394z4, 79);
        f8930h.append(i.f9315m3, 38);
        f8930h.append(i.f9083A4, 98);
        f8930h.append(i.f9388y4, 68);
        f8930h.append(i.f9334p4, 69);
        f8930h.append(i.f9239a4, 70);
        f8930h.append(i.f9154M3, 71);
        f8930h.append(i.f9142K3, 72);
        f8930h.append(i.f9148L3, 73);
        f8930h.append(i.f9160N3, 74);
        f8930h.append(i.f9136J3, 75);
        f8930h.append(i.f9089B4, 76);
        f8930h.append(i.f9280g4, 77);
        f8930h.append(i.f9137J4, 78);
        f8930h.append(i.f9178Q3, 80);
        f8930h.append(i.f9172P3, 81);
        f8930h.append(i.f9095C4, 82);
        f8930h.append(i.f9119G4, 83);
        f8930h.append(i.f9113F4, 84);
        f8930h.append(i.f9107E4, 85);
        f8930h.append(i.f9101D4, 86);
        f8930h.append(i.f9382x4, 97);
    }

    private String C(int i5) {
        switch (i5) {
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
                return "end";
            default:
                return "undefined";
        }
    }

    private int[] n(View view, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        Object objG;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < strArrSplit.length) {
            String strTrim = strArrSplit[i5].trim();
            try {
                iIntValue = h.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, Minor.COLUMN_ID, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objG = ((ConstraintLayout) view.getParent()).g(0, strTrim)) != null && (objG instanceof Integer)) {
                iIntValue = ((Integer) objG).intValue();
            }
            iArr[i6] = iIntValue;
            i5++;
            i6++;
        }
        return i6 != strArrSplit.length ? Arrays.copyOf(iArr, i6) : iArr;
    }

    private void o(int i5, int i6, int i7, int i8, int[] iArr, float[] fArr, int i9, int i10, int i11) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            r(iArr[0]).f8940e.f8979W = fArr[0];
        }
        r(iArr[0]).f8940e.f8980X = i9;
        j(iArr[0], i10, i5, i6, -1);
        for (int i12 = 1; i12 < iArr.length; i12++) {
            int i13 = i12 - 1;
            j(iArr[i12], i10, iArr[i13], i11, -1);
            j(iArr[i13], i11, iArr[i12], i10, -1);
            if (fArr != null) {
                r(iArr[i12]).f8940e.f8979W = fArr[i12];
            }
        }
        j(iArr[iArr.length - 1], i11, i7, i8, -1);
    }

    private a q(Context context, AttributeSet attributeSet, boolean z5) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z5 ? i.f9303k3 : i.f9353t);
        y(context, aVar, typedArrayObtainStyledAttributes, z5);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private a r(int i5) {
        if (!this.f8935e.containsKey(Integer.valueOf(i5))) {
            this.f8935e.put(Integer.valueOf(i5), new a());
        }
        return this.f8935e.get(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int u(TypedArray typedArray, int i5, int i6) {
        int resourceId = typedArray.getResourceId(i5, i6);
        return resourceId == -1 ? typedArray.getInt(i5, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static void v(java.lang.Object r4, android.content.res.TypedArray r5, int r6, int r7) {
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
            r4.f8827a0 = r5
            return
        L3d:
            r4.height = r2
            r4.f8829b0 = r5
            return
        L42:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.b
            if (r6 == 0) goto L54
            androidx.constraintlayout.widget.d$b r4 = (androidx.constraintlayout.widget.d.b) r4
            if (r7 != 0) goto L4f
            r4.f8989d = r2
            r4.f9010n0 = r5
            return
        L4f:
            r4.f8991e = r2
            r4.f9012o0 = r5
            return
        L54:
            boolean r6 = r4 instanceof androidx.constraintlayout.widget.d.a.C0112a
            if (r6 == 0) goto L71
            androidx.constraintlayout.widget.d$a$a r4 = (androidx.constraintlayout.widget.d.a.C0112a) r4
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
            w(r4, r5, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.v(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    static void w(Object obj, String str, int i5) throws NumberFormatException {
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
                    if (i5 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    x(bVar, strTrim2);
                    return;
                }
                if (obj instanceof b) {
                    ((b) obj).f8957A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0112a) {
                        ((a.C0112a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f5 = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i5 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.f8811L = f5;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.f8812M = f5;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar3 = (b) obj;
                        if (i5 == 0) {
                            bVar3.f8989d = 0;
                            bVar3.f8979W = f5;
                            return;
                        } else {
                            bVar3.f8991e = 0;
                            bVar3.f8978V = f5;
                            return;
                        }
                    }
                    if (obj instanceof a.C0112a) {
                        a.C0112a c0112a = (a.C0112a) obj;
                        if (i5 == 0) {
                            c0112a.b(23, 0);
                            c0112a.a(39, f5);
                            return;
                        } else {
                            c0112a.b(21, 0);
                            c0112a.a(40, f5);
                            return;
                        }
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(strTrim)) {
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) obj;
                        if (i5 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.f8821V = fMax;
                            bVar4.f8815P = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.f8822W = fMax;
                            bVar4.f8816Q = 2;
                            return;
                        }
                    }
                    if (obj instanceof b) {
                        b bVar5 = (b) obj;
                        if (i5 == 0) {
                            bVar5.f8989d = 0;
                            bVar5.f8994f0 = fMax;
                            bVar5.f8982Z = 2;
                            return;
                        } else {
                            bVar5.f8991e = 0;
                            bVar5.f8996g0 = fMax;
                            bVar5.f8984a0 = 2;
                            return;
                        }
                    }
                    if (obj instanceof a.C0112a) {
                        a.C0112a c0112a2 = (a.C0112a) obj;
                        if (i5 == 0) {
                            c0112a2.b(23, 0);
                            c0112a2.b(54, 2);
                        } else {
                            c0112a2.b(21, 0);
                            c0112a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    static void x(ConstraintLayout.b bVar, String str) {
        float fAbs = Float.NaN;
        int i5 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i6 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    i5 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i5 = 1;
                }
                i6 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i6);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i6, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f5 = Float.parseFloat(strSubstring3);
                        float f6 = Float.parseFloat(strSubstring4);
                        if (f5 > 0.0f && f6 > 0.0f) {
                            fAbs = i5 == 1 ? Math.abs(f6 / f5) : Math.abs(f5 / f6);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.f8808I = str;
        bVar.f8809J = fAbs;
        bVar.f8810K = i5;
    }

    private void y(Context context, a aVar, TypedArray typedArray, boolean z5) {
        if (z5) {
            z(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArray.getIndex(i5);
            if (index != i.f9365v && i.f9156N != index && i.f9162O != index) {
                aVar.f8939d.f9027a = true;
                aVar.f8940e.f8985b = true;
                aVar.f8938c.f9041a = true;
                aVar.f8941f.f9047a = true;
            }
            switch (f8929g.get(index)) {
                case 1:
                    b bVar = aVar.f8940e;
                    bVar.f9017r = u(typedArray, index, bVar.f9017r);
                    break;
                case 2:
                    b bVar2 = aVar.f8940e;
                    bVar2.f8967K = typedArray.getDimensionPixelSize(index, bVar2.f8967K);
                    break;
                case 3:
                    b bVar3 = aVar.f8940e;
                    bVar3.f9015q = u(typedArray, index, bVar3.f9015q);
                    break;
                case 4:
                    b bVar4 = aVar.f8940e;
                    bVar4.f9013p = u(typedArray, index, bVar4.f9013p);
                    break;
                case 5:
                    aVar.f8940e.f8957A = typedArray.getString(index);
                    break;
                case 6:
                    b bVar5 = aVar.f8940e;
                    bVar5.f8961E = typedArray.getDimensionPixelOffset(index, bVar5.f8961E);
                    break;
                case 7:
                    b bVar6 = aVar.f8940e;
                    bVar6.f8962F = typedArray.getDimensionPixelOffset(index, bVar6.f8962F);
                    break;
                case 8:
                    b bVar7 = aVar.f8940e;
                    bVar7.f8968L = typedArray.getDimensionPixelSize(index, bVar7.f8968L);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                    b bVar8 = aVar.f8940e;
                    bVar8.f9023x = u(typedArray, index, bVar8.f9023x);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                    b bVar9 = aVar.f8940e;
                    bVar9.f9022w = u(typedArray, index, bVar9.f9022w);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    b bVar10 = aVar.f8940e;
                    bVar10.f8974R = typedArray.getDimensionPixelSize(index, bVar10.f8974R);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    b bVar11 = aVar.f8940e;
                    bVar11.f8975S = typedArray.getDimensionPixelSize(index, bVar11.f8975S);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    b bVar12 = aVar.f8940e;
                    bVar12.f8971O = typedArray.getDimensionPixelSize(index, bVar12.f8971O);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    b bVar13 = aVar.f8940e;
                    bVar13.f8973Q = typedArray.getDimensionPixelSize(index, bVar13.f8973Q);
                    break;
                case 15:
                    b bVar14 = aVar.f8940e;
                    bVar14.f8976T = typedArray.getDimensionPixelSize(index, bVar14.f8976T);
                    break;
                case 16:
                    b bVar15 = aVar.f8940e;
                    bVar15.f8972P = typedArray.getDimensionPixelSize(index, bVar15.f8972P);
                    break;
                case 17:
                    b bVar16 = aVar.f8940e;
                    bVar16.f8993f = typedArray.getDimensionPixelOffset(index, bVar16.f8993f);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                    b bVar17 = aVar.f8940e;
                    bVar17.f8995g = typedArray.getDimensionPixelOffset(index, bVar17.f8995g);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                    b bVar18 = aVar.f8940e;
                    bVar18.f8997h = typedArray.getFloat(index, bVar18.f8997h);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                    b bVar19 = aVar.f8940e;
                    bVar19.f9024y = typedArray.getFloat(index, bVar19.f9024y);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                    b bVar20 = aVar.f8940e;
                    bVar20.f8991e = typedArray.getLayoutDimension(index, bVar20.f8991e);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                    C0113d c0113d = aVar.f8938c;
                    c0113d.f9042b = typedArray.getInt(index, c0113d.f9042b);
                    C0113d c0113d2 = aVar.f8938c;
                    c0113d2.f9042b = f8928f[c0113d2.f9042b];
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                    b bVar21 = aVar.f8940e;
                    bVar21.f8989d = typedArray.getLayoutDimension(index, bVar21.f8989d);
                    break;
                case 24:
                    b bVar22 = aVar.f8940e;
                    bVar22.f8964H = typedArray.getDimensionPixelSize(index, bVar22.f8964H);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                    b bVar23 = aVar.f8940e;
                    bVar23.f9001j = u(typedArray, index, bVar23.f9001j);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                    b bVar24 = aVar.f8940e;
                    bVar24.f9003k = u(typedArray, index, bVar24.f9003k);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                    b bVar25 = aVar.f8940e;
                    bVar25.f8963G = typedArray.getInt(index, bVar25.f8963G);
                    break;
                case 28:
                    b bVar26 = aVar.f8940e;
                    bVar26.f8965I = typedArray.getDimensionPixelSize(index, bVar26.f8965I);
                    break;
                case 29:
                    b bVar27 = aVar.f8940e;
                    bVar27.f9005l = u(typedArray, index, bVar27.f9005l);
                    break;
                case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                    b bVar28 = aVar.f8940e;
                    bVar28.f9007m = u(typedArray, index, bVar28.f9007m);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                    b bVar29 = aVar.f8940e;
                    bVar29.f8969M = typedArray.getDimensionPixelSize(index, bVar29.f8969M);
                    break;
                case 32:
                    b bVar30 = aVar.f8940e;
                    bVar30.f9020u = u(typedArray, index, bVar30.f9020u);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                    b bVar31 = aVar.f8940e;
                    bVar31.f9021v = u(typedArray, index, bVar31.f9021v);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                    b bVar32 = aVar.f8940e;
                    bVar32.f8966J = typedArray.getDimensionPixelSize(index, bVar32.f8966J);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                    b bVar33 = aVar.f8940e;
                    bVar33.f9011o = u(typedArray, index, bVar33.f9011o);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                    b bVar34 = aVar.f8940e;
                    bVar34.f9009n = u(typedArray, index, bVar34.f9009n);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                    b bVar35 = aVar.f8940e;
                    bVar35.f9025z = typedArray.getFloat(index, bVar35.f9025z);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                    aVar.f8936a = typedArray.getResourceId(index, aVar.f8936a);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                    b bVar36 = aVar.f8940e;
                    bVar36.f8979W = typedArray.getFloat(index, bVar36.f8979W);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                    b bVar37 = aVar.f8940e;
                    bVar37.f8978V = typedArray.getFloat(index, bVar37.f8978V);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                    b bVar38 = aVar.f8940e;
                    bVar38.f8980X = typedArray.getInt(index, bVar38.f8980X);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                    b bVar39 = aVar.f8940e;
                    bVar39.f8981Y = typedArray.getInt(index, bVar39.f8981Y);
                    break;
                case 43:
                    C0113d c0113d3 = aVar.f8938c;
                    c0113d3.f9044d = typedArray.getFloat(index, c0113d3.f9044d);
                    break;
                case 44:
                    e eVar = aVar.f8941f;
                    eVar.f9059m = true;
                    eVar.f9060n = typedArray.getDimension(index, eVar.f9060n);
                    break;
                case 45:
                    e eVar2 = aVar.f8941f;
                    eVar2.f9049c = typedArray.getFloat(index, eVar2.f9049c);
                    break;
                case 46:
                    e eVar3 = aVar.f8941f;
                    eVar3.f9050d = typedArray.getFloat(index, eVar3.f9050d);
                    break;
                case 47:
                    e eVar4 = aVar.f8941f;
                    eVar4.f9051e = typedArray.getFloat(index, eVar4.f9051e);
                    break;
                case 48:
                    e eVar5 = aVar.f8941f;
                    eVar5.f9052f = typedArray.getFloat(index, eVar5.f9052f);
                    break;
                case 49:
                    e eVar6 = aVar.f8941f;
                    eVar6.f9053g = typedArray.getDimension(index, eVar6.f9053g);
                    break;
                case 50:
                    e eVar7 = aVar.f8941f;
                    eVar7.f9054h = typedArray.getDimension(index, eVar7.f9054h);
                    break;
                case 51:
                    e eVar8 = aVar.f8941f;
                    eVar8.f9056j = typedArray.getDimension(index, eVar8.f9056j);
                    break;
                case 52:
                    e eVar9 = aVar.f8941f;
                    eVar9.f9057k = typedArray.getDimension(index, eVar9.f9057k);
                    break;
                case 53:
                    e eVar10 = aVar.f8941f;
                    eVar10.f9058l = typedArray.getDimension(index, eVar10.f9058l);
                    break;
                case 54:
                    b bVar40 = aVar.f8940e;
                    bVar40.f8982Z = typedArray.getInt(index, bVar40.f8982Z);
                    break;
                case 55:
                    b bVar41 = aVar.f8940e;
                    bVar41.f8984a0 = typedArray.getInt(index, bVar41.f8984a0);
                    break;
                case 56:
                    b bVar42 = aVar.f8940e;
                    bVar42.f8986b0 = typedArray.getDimensionPixelSize(index, bVar42.f8986b0);
                    break;
                case 57:
                    b bVar43 = aVar.f8940e;
                    bVar43.f8988c0 = typedArray.getDimensionPixelSize(index, bVar43.f8988c0);
                    break;
                case 58:
                    b bVar44 = aVar.f8940e;
                    bVar44.f8990d0 = typedArray.getDimensionPixelSize(index, bVar44.f8990d0);
                    break;
                case 59:
                    b bVar45 = aVar.f8940e;
                    bVar45.f8992e0 = typedArray.getDimensionPixelSize(index, bVar45.f8992e0);
                    break;
                case 60:
                    e eVar11 = aVar.f8941f;
                    eVar11.f9048b = typedArray.getFloat(index, eVar11.f9048b);
                    break;
                case 61:
                    b bVar46 = aVar.f8940e;
                    bVar46.f8958B = u(typedArray, index, bVar46.f8958B);
                    break;
                case 62:
                    b bVar47 = aVar.f8940e;
                    bVar47.f8959C = typedArray.getDimensionPixelSize(index, bVar47.f8959C);
                    break;
                case 63:
                    b bVar48 = aVar.f8940e;
                    bVar48.f8960D = typedArray.getFloat(index, bVar48.f8960D);
                    break;
                case 64:
                    c cVar = aVar.f8939d;
                    cVar.f9028b = u(typedArray, index, cVar.f9028b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f8939d.f9030d = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f8939d.f9030d = C1102b.f22291c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f8939d.f9032f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f8939d;
                    cVar2.f9035i = typedArray.getFloat(index, cVar2.f9035i);
                    break;
                case 68:
                    C0113d c0113d4 = aVar.f8938c;
                    c0113d4.f9045e = typedArray.getFloat(index, c0113d4.f9045e);
                    break;
                case 69:
                    aVar.f8940e.f8994f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f8940e.f8996g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    b bVar49 = aVar.f8940e;
                    bVar49.f8998h0 = typedArray.getInt(index, bVar49.f8998h0);
                    break;
                case 73:
                    b bVar50 = aVar.f8940e;
                    bVar50.f9000i0 = typedArray.getDimensionPixelSize(index, bVar50.f9000i0);
                    break;
                case 74:
                    aVar.f8940e.f9006l0 = typedArray.getString(index);
                    break;
                case 75:
                    b bVar51 = aVar.f8940e;
                    bVar51.f9014p0 = typedArray.getBoolean(index, bVar51.f9014p0);
                    break;
                case 76:
                    c cVar3 = aVar.f8939d;
                    cVar3.f9031e = typedArray.getInt(index, cVar3.f9031e);
                    break;
                case 77:
                    aVar.f8940e.f9008m0 = typedArray.getString(index);
                    break;
                case 78:
                    C0113d c0113d5 = aVar.f8938c;
                    c0113d5.f9043c = typedArray.getInt(index, c0113d5.f9043c);
                    break;
                case 79:
                    c cVar4 = aVar.f8939d;
                    cVar4.f9033g = typedArray.getFloat(index, cVar4.f9033g);
                    break;
                case 80:
                    b bVar52 = aVar.f8940e;
                    bVar52.f9010n0 = typedArray.getBoolean(index, bVar52.f9010n0);
                    break;
                case 81:
                    b bVar53 = aVar.f8940e;
                    bVar53.f9012o0 = typedArray.getBoolean(index, bVar53.f9012o0);
                    break;
                case 82:
                    c cVar5 = aVar.f8939d;
                    cVar5.f9029c = typedArray.getInteger(index, cVar5.f9029c);
                    break;
                case 83:
                    e eVar12 = aVar.f8941f;
                    eVar12.f9055i = u(typedArray, index, eVar12.f9055i);
                    break;
                case 84:
                    c cVar6 = aVar.f8939d;
                    cVar6.f9037k = typedArray.getInteger(index, cVar6.f9037k);
                    break;
                case 85:
                    c cVar7 = aVar.f8939d;
                    cVar7.f9036j = typedArray.getFloat(index, cVar7.f9036j);
                    break;
                case 86:
                    int i6 = typedArray.peekValue(index).type;
                    if (i6 == 1) {
                        aVar.f8939d.f9040n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.f8939d;
                        if (cVar8.f9040n != -1) {
                            cVar8.f9039m = -2;
                            break;
                        } else {
                            break;
                        }
                    } else if (i6 == 3) {
                        aVar.f8939d.f9038l = typedArray.getString(index);
                        if (aVar.f8939d.f9038l.indexOf("/") > 0) {
                            aVar.f8939d.f9040n = typedArray.getResourceId(index, -1);
                            aVar.f8939d.f9039m = -2;
                            break;
                        } else {
                            aVar.f8939d.f9039m = -1;
                            break;
                        }
                    } else {
                        c cVar9 = aVar.f8939d;
                        cVar9.f9039m = typedArray.getInteger(index, cVar9.f9040n);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f8929g.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f8929g.get(index));
                    break;
                case 91:
                    b bVar54 = aVar.f8940e;
                    bVar54.f9018s = u(typedArray, index, bVar54.f9018s);
                    break;
                case 92:
                    b bVar55 = aVar.f8940e;
                    bVar55.f9019t = u(typedArray, index, bVar55.f9019t);
                    break;
                case 93:
                    b bVar56 = aVar.f8940e;
                    bVar56.f8970N = typedArray.getDimensionPixelSize(index, bVar56.f8970N);
                    break;
                case 94:
                    b bVar57 = aVar.f8940e;
                    bVar57.f8977U = typedArray.getDimensionPixelSize(index, bVar57.f8977U);
                    break;
                case 95:
                    v(aVar.f8940e, typedArray, index, 0);
                    break;
                case 96:
                    v(aVar.f8940e, typedArray, index, 1);
                    break;
                case 97:
                    b bVar58 = aVar.f8940e;
                    bVar58.f9016q0 = typedArray.getInt(index, bVar58.f9016q0);
                    break;
            }
        }
        b bVar59 = aVar.f8940e;
        if (bVar59.f9006l0 != null) {
            bVar59.f9004k0 = null;
        }
    }

    private static void z(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0112a c0112a = new a.C0112a();
        aVar.f8943h = c0112a;
        aVar.f8939d.f9027a = false;
        aVar.f8940e.f8985b = false;
        aVar.f8938c.f9041a = false;
        aVar.f8941f.f9047a = false;
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArray.getIndex(i5);
            switch (f8930h.get(index)) {
                case 2:
                    c0112a.b(2, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8967K));
                    break;
                case 3:
                case 4:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_LINK /* 10 */:
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                case 29:
                case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                case 32:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_HIGHLIGHT_TEXT /* 33 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f8929g.get(index));
                    break;
                case 5:
                    c0112a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0112a.b(6, typedArray.getDimensionPixelOffset(index, aVar.f8940e.f8961E));
                    break;
                case 7:
                    c0112a.b(7, typedArray.getDimensionPixelOffset(index, aVar.f8940e.f8962F));
                    break;
                case 8:
                    c0112a.b(8, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8968L));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT /* 11 */:
                    c0112a.b(11, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8974R));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER /* 12 */:
                    c0112a.b(12, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8975S));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_POINT_WITH_ARROW /* 13 */:
                    c0112a.b(13, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8971O));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                    c0112a.b(14, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8973Q));
                    break;
                case 15:
                    c0112a.b(15, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8976T));
                    break;
                case 16:
                    c0112a.b(16, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8972P));
                    break;
                case 17:
                    c0112a.b(17, typedArray.getDimensionPixelOffset(index, aVar.f8940e.f8993f));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE /* 18 */:
                    c0112a.b(18, typedArray.getDimensionPixelOffset(index, aVar.f8940e.f8995g));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG /* 19 */:
                    c0112a.a(19, typedArray.getFloat(index, aVar.f8940e.f8997h));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                    c0112a.a(20, typedArray.getFloat(index, aVar.f8940e.f9024y));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                    c0112a.b(21, typedArray.getLayoutDimension(index, aVar.f8940e.f8991e));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                    c0112a.b(22, f8928f[typedArray.getInt(index, aVar.f8938c.f9042b)]);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                    c0112a.b(23, typedArray.getLayoutDimension(index, aVar.f8940e.f8989d));
                    break;
                case 24:
                    c0112a.b(24, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8964H));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                    c0112a.b(27, typedArray.getInt(index, aVar.f8940e.f8963G));
                    break;
                case 28:
                    c0112a.b(28, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8965I));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                    c0112a.b(31, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8969M));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                    c0112a.b(34, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8966J));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                    c0112a.a(37, typedArray.getFloat(index, aVar.f8940e.f9025z));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                    int resourceId = typedArray.getResourceId(index, aVar.f8936a);
                    aVar.f8936a = resourceId;
                    c0112a.b(38, resourceId);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE_TITLE /* 39 */:
                    c0112a.a(39, typedArray.getFloat(index, aVar.f8940e.f8979W));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_NORMAL /* 40 */:
                    c0112a.a(40, typedArray.getFloat(index, aVar.f8940e.f8978V));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_OPERATION /* 41 */:
                    c0112a.b(41, typedArray.getInt(index, aVar.f8940e.f8980X));
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_SEARCH_WITH_SUMMARY /* 42 */:
                    c0112a.b(42, typedArray.getInt(index, aVar.f8940e.f8981Y));
                    break;
                case 43:
                    c0112a.a(43, typedArray.getFloat(index, aVar.f8938c.f9044d));
                    break;
                case 44:
                    c0112a.d(44, true);
                    c0112a.a(44, typedArray.getDimension(index, aVar.f8941f.f9060n));
                    break;
                case 45:
                    c0112a.a(45, typedArray.getFloat(index, aVar.f8941f.f9049c));
                    break;
                case 46:
                    c0112a.a(46, typedArray.getFloat(index, aVar.f8941f.f9050d));
                    break;
                case 47:
                    c0112a.a(47, typedArray.getFloat(index, aVar.f8941f.f9051e));
                    break;
                case 48:
                    c0112a.a(48, typedArray.getFloat(index, aVar.f8941f.f9052f));
                    break;
                case 49:
                    c0112a.a(49, typedArray.getDimension(index, aVar.f8941f.f9053g));
                    break;
                case 50:
                    c0112a.a(50, typedArray.getDimension(index, aVar.f8941f.f9054h));
                    break;
                case 51:
                    c0112a.a(51, typedArray.getDimension(index, aVar.f8941f.f9056j));
                    break;
                case 52:
                    c0112a.a(52, typedArray.getDimension(index, aVar.f8941f.f9057k));
                    break;
                case 53:
                    c0112a.a(53, typedArray.getDimension(index, aVar.f8941f.f9058l));
                    break;
                case 54:
                    c0112a.b(54, typedArray.getInt(index, aVar.f8940e.f8982Z));
                    break;
                case 55:
                    c0112a.b(55, typedArray.getInt(index, aVar.f8940e.f8984a0));
                    break;
                case 56:
                    c0112a.b(56, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8986b0));
                    break;
                case 57:
                    c0112a.b(57, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8988c0));
                    break;
                case 58:
                    c0112a.b(58, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8990d0));
                    break;
                case 59:
                    c0112a.b(59, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8992e0));
                    break;
                case 60:
                    c0112a.a(60, typedArray.getFloat(index, aVar.f8941f.f9048b));
                    break;
                case 62:
                    c0112a.b(62, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8959C));
                    break;
                case 63:
                    c0112a.a(63, typedArray.getFloat(index, aVar.f8940e.f8960D));
                    break;
                case 64:
                    c0112a.b(64, u(typedArray, index, aVar.f8939d.f9028b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        c0112a.c(65, typedArray.getString(index));
                        break;
                    } else {
                        c0112a.c(65, C1102b.f22291c[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    c0112a.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c0112a.a(67, typedArray.getFloat(index, aVar.f8939d.f9035i));
                    break;
                case 68:
                    c0112a.a(68, typedArray.getFloat(index, aVar.f8938c.f9045e));
                    break;
                case 69:
                    c0112a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0112a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0112a.b(72, typedArray.getInt(index, aVar.f8940e.f8998h0));
                    break;
                case 73:
                    c0112a.b(73, typedArray.getDimensionPixelSize(index, aVar.f8940e.f9000i0));
                    break;
                case 74:
                    c0112a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0112a.d(75, typedArray.getBoolean(index, aVar.f8940e.f9014p0));
                    break;
                case 76:
                    c0112a.b(76, typedArray.getInt(index, aVar.f8939d.f9031e));
                    break;
                case 77:
                    c0112a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0112a.b(78, typedArray.getInt(index, aVar.f8938c.f9043c));
                    break;
                case 79:
                    c0112a.a(79, typedArray.getFloat(index, aVar.f8939d.f9033g));
                    break;
                case 80:
                    c0112a.d(80, typedArray.getBoolean(index, aVar.f8940e.f9010n0));
                    break;
                case 81:
                    c0112a.d(81, typedArray.getBoolean(index, aVar.f8940e.f9012o0));
                    break;
                case 82:
                    c0112a.b(82, typedArray.getInteger(index, aVar.f8939d.f9029c));
                    break;
                case 83:
                    c0112a.b(83, u(typedArray, index, aVar.f8941f.f9055i));
                    break;
                case 84:
                    c0112a.b(84, typedArray.getInteger(index, aVar.f8939d.f9037k));
                    break;
                case 85:
                    c0112a.a(85, typedArray.getFloat(index, aVar.f8939d.f9036j));
                    break;
                case 86:
                    int i6 = typedArray.peekValue(index).type;
                    if (i6 == 1) {
                        aVar.f8939d.f9040n = typedArray.getResourceId(index, -1);
                        c0112a.b(89, aVar.f8939d.f9040n);
                        c cVar = aVar.f8939d;
                        if (cVar.f9040n != -1) {
                            cVar.f9039m = -2;
                            c0112a.b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i6 == 3) {
                        aVar.f8939d.f9038l = typedArray.getString(index);
                        c0112a.c(90, aVar.f8939d.f9038l);
                        if (aVar.f8939d.f9038l.indexOf("/") > 0) {
                            aVar.f8939d.f9040n = typedArray.getResourceId(index, -1);
                            c0112a.b(89, aVar.f8939d.f9040n);
                            aVar.f8939d.f9039m = -2;
                            c0112a.b(88, -2);
                            break;
                        } else {
                            aVar.f8939d.f9039m = -1;
                            c0112a.b(88, -1);
                            break;
                        }
                    } else {
                        c cVar2 = aVar.f8939d;
                        cVar2.f9039m = typedArray.getInteger(index, cVar2.f9040n);
                        c0112a.b(88, aVar.f8939d.f9039m);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f8929g.get(index));
                    break;
                case 93:
                    c0112a.b(93, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8970N));
                    break;
                case 94:
                    c0112a.b(94, typedArray.getDimensionPixelSize(index, aVar.f8940e.f8977U));
                    break;
                case 95:
                    v(c0112a, typedArray, index, 0);
                    break;
                case 96:
                    v(c0112a, typedArray, index, 1);
                    break;
                case 97:
                    c0112a.b(97, typedArray.getInt(index, aVar.f8940e.f9016q0));
                    break;
                case 98:
                    if (androidx.constraintlayout.motion.widget.j.f8691x0) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.f8936a);
                        aVar.f8936a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.f8937b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.f8937b = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f8936a = typedArray.getResourceId(index, aVar.f8936a);
                        break;
                    }
                case 99:
                    c0112a.d(99, typedArray.getBoolean(index, aVar.f8940e.f8999i));
                    break;
            }
        }
    }

    public void A(int i5, int i6, int i7) {
        a aVarR = r(i5);
        switch (i6) {
            case 1:
                aVarR.f8940e.f8964H = i7;
                return;
            case 2:
                aVarR.f8940e.f8965I = i7;
                return;
            case 3:
                aVarR.f8940e.f8966J = i7;
                return;
            case 4:
                aVarR.f8940e.f8967K = i7;
                return;
            case 5:
                aVarR.f8940e.f8970N = i7;
                return;
            case 6:
                aVarR.f8940e.f8969M = i7;
                return;
            case 7:
                aVarR.f8940e.f8968L = i7;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void B(int i5, int i6) {
        r(i5).f8938c.f9042b = i6;
    }

    public void c(ConstraintLayout constraintLayout) {
        d(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    void d(ConstraintLayout constraintLayout, boolean z5) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f8935e.keySet());
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
            int id = childAt.getId();
            if (!this.f8935e.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.b(childAt));
            } else {
                if (this.f8934d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f8935e.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f8935e.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f8940e.f9002j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(aVar.f8940e.f8998h0);
                                barrier.setMargin(aVar.f8940e.f9000i0);
                                barrier.setAllowsGoneWidget(aVar.f8940e.f9014p0);
                                b bVar = aVar.f8940e;
                                int[] iArr = bVar.f9004k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f9006l0;
                                    if (str != null) {
                                        bVar.f9004k0 = n(barrier, str);
                                        barrier.setReferencedIds(aVar.f8940e.f9004k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.a();
                            aVar.d(bVar2);
                            if (z5) {
                                androidx.constraintlayout.widget.a.e(childAt, aVar.f8942g);
                            }
                            childAt.setLayoutParams(bVar2);
                            C0113d c0113d = aVar.f8938c;
                            if (c0113d.f9043c == 0) {
                                childAt.setVisibility(c0113d.f9042b);
                            }
                            childAt.setAlpha(aVar.f8938c.f9044d);
                            childAt.setRotation(aVar.f8941f.f9048b);
                            childAt.setRotationX(aVar.f8941f.f9049c);
                            childAt.setRotationY(aVar.f8941f.f9050d);
                            childAt.setScaleX(aVar.f8941f.f9051e);
                            childAt.setScaleY(aVar.f8941f.f9052f);
                            e eVar = aVar.f8941f;
                            if (eVar.f9055i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f8941f.f9055i) != null) {
                                    float top = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f9053g)) {
                                    childAt.setPivotX(aVar.f8941f.f9053g);
                                }
                                if (!Float.isNaN(aVar.f8941f.f9054h)) {
                                    childAt.setPivotY(aVar.f8941f.f9054h);
                                }
                            }
                            childAt.setTranslationX(aVar.f8941f.f9056j);
                            childAt.setTranslationY(aVar.f8941f.f9057k);
                            childAt.setTranslationZ(aVar.f8941f.f9058l);
                            e eVar2 = aVar.f8941f;
                            if (eVar2.f9059m) {
                                childAt.setElevation(eVar2.f9060n);
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
            a aVar2 = this.f8935e.get(num);
            if (aVar2 != null) {
                if (aVar2.f8940e.f9002j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar3 = aVar2.f8940e;
                    int[] iArr2 = bVar3.f9004k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f9006l0;
                        if (str2 != null) {
                            bVar3.f9004k0 = n(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f8940e.f9004k0);
                        }
                    }
                    barrier2.setType(aVar2.f8940e.f8998h0);
                    barrier2.setMargin(aVar2.f8940e.f9000i0);
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.s();
                    aVar2.d(bVarGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, bVarGenerateDefaultLayoutParams);
                }
                if (aVar2.f8940e.f8983a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.d(bVarGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, bVarGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = constraintLayout.getChildAt(i6);
            if (childAt2 instanceof androidx.constraintlayout.widget.b) {
                ((androidx.constraintlayout.widget.b) childAt2).i(constraintLayout);
            }
        }
    }

    public void e(int i5, int i6) {
        a aVar;
        if (!this.f8935e.containsKey(Integer.valueOf(i5)) || (aVar = this.f8935e.get(Integer.valueOf(i5))) == null) {
            return;
        }
        switch (i6) {
            case 1:
                b bVar = aVar.f8940e;
                bVar.f9003k = -1;
                bVar.f9001j = -1;
                bVar.f8964H = -1;
                bVar.f8971O = Integer.MIN_VALUE;
                return;
            case 2:
                b bVar2 = aVar.f8940e;
                bVar2.f9007m = -1;
                bVar2.f9005l = -1;
                bVar2.f8965I = -1;
                bVar2.f8973Q = Integer.MIN_VALUE;
                return;
            case 3:
                b bVar3 = aVar.f8940e;
                bVar3.f9011o = -1;
                bVar3.f9009n = -1;
                bVar3.f8966J = 0;
                bVar3.f8972P = Integer.MIN_VALUE;
                return;
            case 4:
                b bVar4 = aVar.f8940e;
                bVar4.f9013p = -1;
                bVar4.f9015q = -1;
                bVar4.f8967K = 0;
                bVar4.f8974R = Integer.MIN_VALUE;
                return;
            case 5:
                b bVar5 = aVar.f8940e;
                bVar5.f9017r = -1;
                bVar5.f9018s = -1;
                bVar5.f9019t = -1;
                bVar5.f8970N = 0;
                bVar5.f8977U = Integer.MIN_VALUE;
                return;
            case 6:
                b bVar6 = aVar.f8940e;
                bVar6.f9020u = -1;
                bVar6.f9021v = -1;
                bVar6.f8969M = 0;
                bVar6.f8976T = Integer.MIN_VALUE;
                return;
            case 7:
                b bVar7 = aVar.f8940e;
                bVar7.f9022w = -1;
                bVar7.f9023x = -1;
                bVar7.f8968L = 0;
                bVar7.f8975S = Integer.MIN_VALUE;
                return;
            case 8:
                b bVar8 = aVar.f8940e;
                bVar8.f8960D = -1.0f;
                bVar8.f8959C = -1;
                bVar8.f8958B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void f(Context context, int i5) {
        g((ConstraintLayout) LayoutInflater.from(context).inflate(i5, (ViewGroup) null));
    }

    public void g(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f8935e.clear();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = constraintLayout.getChildAt(i5);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f8934d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f8935e.containsKey(Integer.valueOf(id))) {
                this.f8935e.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f8935e.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.f8942g = androidx.constraintlayout.widget.a.a(this.f8933c, childAt);
                aVar.f(id, bVar);
                aVar.f8938c.f9042b = childAt.getVisibility();
                aVar.f8938c.f9044d = childAt.getAlpha();
                aVar.f8941f.f9048b = childAt.getRotation();
                aVar.f8941f.f9049c = childAt.getRotationX();
                aVar.f8941f.f9050d = childAt.getRotationY();
                aVar.f8941f.f9051e = childAt.getScaleX();
                aVar.f8941f.f9052f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f8941f;
                    eVar.f9053g = pivotX;
                    eVar.f9054h = pivotY;
                }
                aVar.f8941f.f9056j = childAt.getTranslationX();
                aVar.f8941f.f9057k = childAt.getTranslationY();
                aVar.f8941f.f9058l = childAt.getTranslationZ();
                e eVar2 = aVar.f8941f;
                if (eVar2.f9059m) {
                    eVar2.f9060n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f8940e.f9014p0 = barrier.getAllowsGoneWidget();
                    aVar.f8940e.f9004k0 = barrier.getReferencedIds();
                    aVar.f8940e.f8998h0 = barrier.getType();
                    aVar.f8940e.f9000i0 = barrier.getMargin();
                }
            }
        }
    }

    public void h(androidx.constraintlayout.widget.e eVar) {
        int childCount = eVar.getChildCount();
        this.f8935e.clear();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = eVar.getChildAt(i5);
            e.a aVar = (e.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f8934d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f8935e.containsKey(Integer.valueOf(id))) {
                this.f8935e.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.f8935e.get(Integer.valueOf(id));
            if (aVar2 != null) {
                if (childAt instanceof androidx.constraintlayout.widget.b) {
                    aVar2.h((androidx.constraintlayout.widget.b) childAt, id, aVar);
                }
                aVar2.g(id, aVar);
            }
        }
    }

    public void i(int i5, int i6, int i7, int i8) {
        if (!this.f8935e.containsKey(Integer.valueOf(i5))) {
            this.f8935e.put(Integer.valueOf(i5), new a());
        }
        a aVar = this.f8935e.get(Integer.valueOf(i5));
        if (aVar == null) {
            return;
        }
        switch (i6) {
            case 1:
                if (i8 == 1) {
                    b bVar = aVar.f8940e;
                    bVar.f9001j = i7;
                    bVar.f9003k = -1;
                    return;
                } else if (i8 == 2) {
                    b bVar2 = aVar.f8940e;
                    bVar2.f9003k = i7;
                    bVar2.f9001j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + C(i8) + " undefined");
                }
            case 2:
                if (i8 == 1) {
                    b bVar3 = aVar.f8940e;
                    bVar3.f9005l = i7;
                    bVar3.f9007m = -1;
                    return;
                } else if (i8 == 2) {
                    b bVar4 = aVar.f8940e;
                    bVar4.f9007m = i7;
                    bVar4.f9005l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                }
            case 3:
                if (i8 == 3) {
                    b bVar5 = aVar.f8940e;
                    bVar5.f9009n = i7;
                    bVar5.f9011o = -1;
                    bVar5.f9017r = -1;
                    bVar5.f9018s = -1;
                    bVar5.f9019t = -1;
                    return;
                }
                if (i8 != 4) {
                    throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                }
                b bVar6 = aVar.f8940e;
                bVar6.f9011o = i7;
                bVar6.f9009n = -1;
                bVar6.f9017r = -1;
                bVar6.f9018s = -1;
                bVar6.f9019t = -1;
                return;
            case 4:
                if (i8 == 4) {
                    b bVar7 = aVar.f8940e;
                    bVar7.f9015q = i7;
                    bVar7.f9013p = -1;
                    bVar7.f9017r = -1;
                    bVar7.f9018s = -1;
                    bVar7.f9019t = -1;
                    return;
                }
                if (i8 != 3) {
                    throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                }
                b bVar8 = aVar.f8940e;
                bVar8.f9013p = i7;
                bVar8.f9015q = -1;
                bVar8.f9017r = -1;
                bVar8.f9018s = -1;
                bVar8.f9019t = -1;
                return;
            case 5:
                if (i8 == 5) {
                    b bVar9 = aVar.f8940e;
                    bVar9.f9017r = i7;
                    bVar9.f9015q = -1;
                    bVar9.f9013p = -1;
                    bVar9.f9009n = -1;
                    bVar9.f9011o = -1;
                    return;
                }
                if (i8 == 3) {
                    b bVar10 = aVar.f8940e;
                    bVar10.f9018s = i7;
                    bVar10.f9015q = -1;
                    bVar10.f9013p = -1;
                    bVar10.f9009n = -1;
                    bVar10.f9011o = -1;
                    return;
                }
                if (i8 != 4) {
                    throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                }
                b bVar11 = aVar.f8940e;
                bVar11.f9019t = i7;
                bVar11.f9015q = -1;
                bVar11.f9013p = -1;
                bVar11.f9009n = -1;
                bVar11.f9011o = -1;
                return;
            case 6:
                if (i8 == 6) {
                    b bVar12 = aVar.f8940e;
                    bVar12.f9021v = i7;
                    bVar12.f9020u = -1;
                    return;
                } else if (i8 == 7) {
                    b bVar13 = aVar.f8940e;
                    bVar13.f9020u = i7;
                    bVar13.f9021v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                }
            case 7:
                if (i8 == 7) {
                    b bVar14 = aVar.f8940e;
                    bVar14.f9023x = i7;
                    bVar14.f9022w = -1;
                    return;
                } else if (i8 == 6) {
                    b bVar15 = aVar.f8940e;
                    bVar15.f9022w = i7;
                    bVar15.f9023x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                }
            default:
                throw new IllegalArgumentException(C(i6) + " to " + C(i8) + " unknown");
        }
    }

    public void j(int i5, int i6, int i7, int i8, int i9) {
        if (!this.f8935e.containsKey(Integer.valueOf(i5))) {
            this.f8935e.put(Integer.valueOf(i5), new a());
        }
        a aVar = this.f8935e.get(Integer.valueOf(i5));
        if (aVar == null) {
            return;
        }
        switch (i6) {
            case 1:
                if (i8 == 1) {
                    b bVar = aVar.f8940e;
                    bVar.f9001j = i7;
                    bVar.f9003k = -1;
                } else {
                    if (i8 != 2) {
                        throw new IllegalArgumentException("Left to " + C(i8) + " undefined");
                    }
                    b bVar2 = aVar.f8940e;
                    bVar2.f9003k = i7;
                    bVar2.f9001j = -1;
                }
                aVar.f8940e.f8964H = i9;
                return;
            case 2:
                if (i8 == 1) {
                    b bVar3 = aVar.f8940e;
                    bVar3.f9005l = i7;
                    bVar3.f9007m = -1;
                } else {
                    if (i8 != 2) {
                        throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                    }
                    b bVar4 = aVar.f8940e;
                    bVar4.f9007m = i7;
                    bVar4.f9005l = -1;
                }
                aVar.f8940e.f8965I = i9;
                return;
            case 3:
                if (i8 == 3) {
                    b bVar5 = aVar.f8940e;
                    bVar5.f9009n = i7;
                    bVar5.f9011o = -1;
                    bVar5.f9017r = -1;
                    bVar5.f9018s = -1;
                    bVar5.f9019t = -1;
                } else {
                    if (i8 != 4) {
                        throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                    }
                    b bVar6 = aVar.f8940e;
                    bVar6.f9011o = i7;
                    bVar6.f9009n = -1;
                    bVar6.f9017r = -1;
                    bVar6.f9018s = -1;
                    bVar6.f9019t = -1;
                }
                aVar.f8940e.f8966J = i9;
                return;
            case 4:
                if (i8 == 4) {
                    b bVar7 = aVar.f8940e;
                    bVar7.f9015q = i7;
                    bVar7.f9013p = -1;
                    bVar7.f9017r = -1;
                    bVar7.f9018s = -1;
                    bVar7.f9019t = -1;
                } else {
                    if (i8 != 3) {
                        throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                    }
                    b bVar8 = aVar.f8940e;
                    bVar8.f9013p = i7;
                    bVar8.f9015q = -1;
                    bVar8.f9017r = -1;
                    bVar8.f9018s = -1;
                    bVar8.f9019t = -1;
                }
                aVar.f8940e.f8967K = i9;
                return;
            case 5:
                if (i8 == 5) {
                    b bVar9 = aVar.f8940e;
                    bVar9.f9017r = i7;
                    bVar9.f9015q = -1;
                    bVar9.f9013p = -1;
                    bVar9.f9009n = -1;
                    bVar9.f9011o = -1;
                    return;
                }
                if (i8 == 3) {
                    b bVar10 = aVar.f8940e;
                    bVar10.f9018s = i7;
                    bVar10.f9015q = -1;
                    bVar10.f9013p = -1;
                    bVar10.f9009n = -1;
                    bVar10.f9011o = -1;
                    return;
                }
                if (i8 != 4) {
                    throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                }
                b bVar11 = aVar.f8940e;
                bVar11.f9019t = i7;
                bVar11.f9015q = -1;
                bVar11.f9013p = -1;
                bVar11.f9009n = -1;
                bVar11.f9011o = -1;
                return;
            case 6:
                if (i8 == 6) {
                    b bVar12 = aVar.f8940e;
                    bVar12.f9021v = i7;
                    bVar12.f9020u = -1;
                } else {
                    if (i8 != 7) {
                        throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                    }
                    b bVar13 = aVar.f8940e;
                    bVar13.f9020u = i7;
                    bVar13.f9021v = -1;
                }
                aVar.f8940e.f8969M = i9;
                return;
            case 7:
                if (i8 == 7) {
                    b bVar14 = aVar.f8940e;
                    bVar14.f9023x = i7;
                    bVar14.f9022w = -1;
                } else {
                    if (i8 != 6) {
                        throw new IllegalArgumentException("right to " + C(i8) + " undefined");
                    }
                    b bVar15 = aVar.f8940e;
                    bVar15.f9022w = i7;
                    bVar15.f9023x = -1;
                }
                aVar.f8940e.f8968L = i9;
                return;
            default:
                throw new IllegalArgumentException(C(i6) + " to " + C(i8) + " unknown");
        }
    }

    public void k(int i5, int i6, int i7, float f5) {
        b bVar = r(i5).f8940e;
        bVar.f8958B = i6;
        bVar.f8959C = i7;
        bVar.f8960D = f5;
    }

    public void l(int i5, int i6) {
        r(i5).f8940e.f8991e = i6;
    }

    public void m(int i5, int i6) {
        r(i5).f8940e.f8989d = i6;
    }

    public void p(int i5, int i6, int i7, int i8, int[] iArr, float[] fArr, int i9) {
        o(i5, i6, i7, i8, iArr, fArr, i9, 6, 7);
    }

    public void s(Context context, int i5) {
        XmlResourceParser xml = context.getResources().getXml(i5);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarQ = q(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarQ.f8940e.f8983a = true;
                    }
                    this.f8935e.put(Integer.valueOf(aVarQ.f8936a), aVarQ);
                }
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        } catch (XmlPullParserException e7) {
            e7.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x01c8, code lost:
    
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
    public void t(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.t(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}

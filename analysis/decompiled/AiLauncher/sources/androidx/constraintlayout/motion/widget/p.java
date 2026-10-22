package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.c;
import java.util.Arrays;
import java.util.LinkedHashMap;
import m0.C4890c;

/* loaded from: classes.dex */
public class p implements Comparable<p> {

    /* renamed from: t, reason: collision with root package name */
    public static String[] f12412t = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a, reason: collision with root package name */
    public C4890c f12413a;

    /* renamed from: c, reason: collision with root package name */
    public float f12415c;

    /* renamed from: d, reason: collision with root package name */
    public float f12416d;

    /* renamed from: e, reason: collision with root package name */
    public float f12417e;

    /* renamed from: f, reason: collision with root package name */
    public float f12418f;

    /* renamed from: g, reason: collision with root package name */
    public float f12419g;

    /* renamed from: h, reason: collision with root package name */
    public float f12420h;

    /* renamed from: k, reason: collision with root package name */
    public int f12423k;

    /* renamed from: l, reason: collision with root package name */
    public int f12424l;

    /* renamed from: m, reason: collision with root package name */
    public float f12425m;

    /* renamed from: n, reason: collision with root package name */
    public m f12426n;

    /* renamed from: o, reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f12427o;

    /* renamed from: p, reason: collision with root package name */
    public int f12428p;

    /* renamed from: q, reason: collision with root package name */
    public int f12429q;

    /* renamed from: r, reason: collision with root package name */
    public double[] f12430r;

    /* renamed from: s, reason: collision with root package name */
    public double[] f12431s;

    /* renamed from: b, reason: collision with root package name */
    public int f12414b = 0;

    /* renamed from: i, reason: collision with root package name */
    public float f12421i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f12422j = Float.NaN;

    public p() {
        int i10 = d.f12237f;
        this.f12423k = i10;
        this.f12424l = i10;
        this.f12425m = Float.NaN;
        this.f12426n = null;
        this.f12427o = new LinkedHashMap<>();
        this.f12428p = 0;
        this.f12430r = new double[18];
        this.f12431s = new double[18];
    }

    public void a(c.a aVar) {
        this.f12413a = C4890c.c(aVar.f12724d.f12815d);
        c.C0154c c0154c = aVar.f12724d;
        this.f12423k = c0154c.f12816e;
        this.f12424l = c0154c.f12813b;
        this.f12421i = c0154c.f12820i;
        this.f12414b = c0154c.f12817f;
        this.f12429q = c0154c.f12814c;
        this.f12422j = aVar.f12723c.f12830e;
        this.f12425m = aVar.f12725e.f12745D;
        for (String str : aVar.f12727g.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f12727g.get(str);
            if (constraintAttribute != null && constraintAttribute.g()) {
                this.f12427o.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        return Float.compare(this.f12416d, pVar.f12416d);
    }

    public final boolean c(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    public void e(p pVar, boolean[] zArr, String[] strArr, boolean z10) {
        boolean zC = c(this.f12417e, pVar.f12417e);
        boolean zC2 = c(this.f12418f, pVar.f12418f);
        zArr[0] = zArr[0] | c(this.f12416d, pVar.f12416d);
        boolean z11 = zC | zC2 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | c(this.f12419g, pVar.f12419g);
        zArr[4] = c(this.f12420h, pVar.f12420h) | zArr[4];
    }

    public void i(double[] dArr, int[] iArr) {
        float[] fArr = {this.f12416d, this.f12417e, this.f12418f, this.f12419g, this.f12420h, this.f12421i};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = fArr[r0];
                i10++;
            }
        }
    }

    public void j(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f12417e;
        float fCos = this.f12418f;
        float f11 = this.f12419g;
        float f12 = this.f12420h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        m mVar = this.f12426n;
        if (mVar != null) {
            float[] fArr2 = new float[2];
            mVar.i(d10, fArr2, new float[2]);
            float f14 = fArr2[0];
            float f15 = fArr2[1];
            double d11 = f10;
            double d12 = fCos;
            float fSin = (float) ((f14 + (Math.sin(d12) * d11)) - (f11 / 2.0f));
            fCos = (float) ((f15 - (d11 * Math.cos(d12))) - (f12 / 2.0f));
            f10 = fSin;
        }
        fArr[i10] = f10 + (f11 / 2.0f) + 0.0f;
        fArr[i10 + 1] = fCos + (f12 / 2.0f) + 0.0f;
    }

    public void k(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float fSin = this.f12417e;
        float fCos = this.f12418f;
        float f11 = this.f12419g;
        float f12 = this.f12420h;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f17 = (float) dArr[i10];
            float f18 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                fSin = f17;
                f13 = f18;
            } else if (i11 == 2) {
                fCos = f17;
                f15 = f18;
            } else if (i11 == 3) {
                f11 = f17;
                f14 = f18;
            } else if (i11 == 4) {
                f12 = f17;
                f16 = f18;
            }
        }
        float f19 = (f14 / 2.0f) + f13;
        float fCos2 = (f16 / 2.0f) + f15;
        m mVar = this.f12426n;
        if (mVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            mVar.i(d10, fArr3, fArr4);
            float f20 = fArr3[0];
            float f21 = fArr3[1];
            float f22 = fArr4[0];
            float f23 = fArr4[1];
            double d11 = f20;
            f10 = 2.0f;
            double d12 = fSin;
            double d13 = fCos;
            fSin = (float) ((d11 + (Math.sin(d13) * d12)) - (f11 / 2.0f));
            fCos = (float) ((f21 - (Math.cos(d13) * d12)) - (f12 / 2.0f));
            double d14 = f22;
            double d15 = f13;
            double d16 = f15;
            float fSin2 = (float) (d14 + (Math.sin(d13) * d15) + (Math.cos(d13) * d16));
            fCos2 = (float) ((f23 - (d15 * Math.cos(d13))) + (Math.sin(d13) * d16));
            f19 = fSin2;
        } else {
            f10 = 2.0f;
        }
        fArr[0] = fSin + (f11 / f10) + 0.0f;
        fArr[1] = fCos + (f12 / f10) + 0.0f;
        fArr2[0] = f19;
        fArr2[1] = fCos2;
    }

    public int l(String str, double[] dArr, int i10) {
        ConstraintAttribute constraintAttribute = this.f12427o.get(str);
        int i11 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.h() == 1) {
            dArr[i10] = constraintAttribute.e();
            return 1;
        }
        int iH = constraintAttribute.h();
        constraintAttribute.f(new float[iH]);
        while (i11 < iH) {
            dArr[i10] = r1[i11];
            i11++;
            i10++;
        }
        return iH;
    }

    public int m(String str) {
        ConstraintAttribute constraintAttribute = this.f12427o.get(str);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.h();
    }

    public void n(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f12417e;
        float fCos = this.f12418f;
        float f11 = this.f12419g;
        float f12 = this.f12420h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        m mVar = this.f12426n;
        if (mVar != null) {
            float fJ = mVar.j();
            float fK = this.f12426n.k();
            double d10 = f10;
            double d11 = fCos;
            float fSin = (float) ((fJ + (Math.sin(d11) * d10)) - (f11 / 2.0f));
            fCos = (float) ((fK - (d10 * Math.cos(d11))) - (f12 / 2.0f));
            f10 = fSin;
        }
        float f14 = f11 + f10;
        float f15 = f12 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i10] = f10 + 0.0f;
        fArr[i10 + 1] = fCos + 0.0f;
        fArr[i10 + 2] = f14 + 0.0f;
        fArr[i10 + 3] = fCos + 0.0f;
        fArr[i10 + 4] = f14 + 0.0f;
        fArr[i10 + 5] = f15 + 0.0f;
        fArr[i10 + 6] = f10 + 0.0f;
        fArr[i10 + 7] = f15 + 0.0f;
    }

    public boolean o(String str) {
        return this.f12427o.containsKey(str);
    }

    public void p(h hVar, p pVar, p pVar2) {
        float f10 = hVar.f12238a / 100.0f;
        this.f12415c = f10;
        this.f12414b = hVar.f12286j;
        float f11 = Float.isNaN(hVar.f12287k) ? f10 : hVar.f12287k;
        float f12 = Float.isNaN(hVar.f12288l) ? f10 : hVar.f12288l;
        float f13 = pVar2.f12419g;
        float f14 = pVar.f12419g;
        float f15 = f13 - f14;
        float f16 = pVar2.f12420h;
        float f17 = pVar.f12420h;
        float f18 = f16 - f17;
        this.f12416d = this.f12415c;
        float f19 = (f14 / 2.0f) + pVar.f12417e;
        float f20 = pVar.f12418f + (f17 / 2.0f);
        float f21 = f10;
        float f22 = pVar2.f12417e + (f13 / 2.0f);
        float f23 = pVar2.f12418f + (f16 / 2.0f);
        if (f19 > f22) {
            f19 = f22;
            f22 = f19;
        }
        if (f20 <= f23) {
            f20 = f23;
            f23 = f20;
        }
        float f24 = f22 - f19;
        float f25 = f20 - f23;
        float f26 = (f15 * f11) / 2.0f;
        this.f12417e = (int) ((r13 + (f24 * f21)) - f26);
        float f27 = (f18 * f12) / 2.0f;
        this.f12418f = (int) ((r14 + (f25 * f21)) - f27);
        this.f12419g = (int) (f14 + r9);
        this.f12420h = (int) (f17 + r12);
        float f28 = Float.isNaN(hVar.f12289m) ? f21 : hVar.f12289m;
        float f29 = Float.isNaN(hVar.f12292p) ? 0.0f : hVar.f12292p;
        if (!Float.isNaN(hVar.f12290n)) {
            f21 = hVar.f12290n;
        }
        float f30 = Float.isNaN(hVar.f12291o) ? 0.0f : hVar.f12291o;
        this.f12428p = 0;
        this.f12417e = (int) (((pVar.f12417e + (f28 * f24)) + (f30 * f25)) - f26);
        this.f12418f = (int) (((pVar.f12418f + (f24 * f29)) + (f25 * f21)) - f27);
        this.f12413a = C4890c.c(hVar.f12284h);
        this.f12423k = hVar.f12285i;
    }

    public void q(h hVar, p pVar, p pVar2) {
        float f10 = hVar.f12238a / 100.0f;
        this.f12415c = f10;
        this.f12414b = hVar.f12286j;
        float f11 = Float.isNaN(hVar.f12287k) ? f10 : hVar.f12287k;
        float f12 = Float.isNaN(hVar.f12288l) ? f10 : hVar.f12288l;
        float f13 = pVar2.f12419g;
        float f14 = pVar.f12419g;
        float f15 = pVar2.f12420h;
        float f16 = pVar.f12420h;
        this.f12416d = this.f12415c;
        float f17 = pVar.f12417e;
        float f18 = pVar.f12418f;
        float f19 = f10;
        float f20 = (pVar2.f12417e + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f21 = (pVar2.f12418f + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f22 = ((f13 - f14) * f11) / 2.0f;
        this.f12417e = (int) ((f17 + (f20 * f19)) - f22);
        float f23 = ((f15 - f16) * f12) / 2.0f;
        this.f12418f = (int) ((f18 + (f21 * f19)) - f23);
        this.f12419g = (int) (f14 + r9);
        this.f12420h = (int) (f16 + r12);
        float f24 = Float.isNaN(hVar.f12289m) ? f19 : hVar.f12289m;
        float f25 = Float.isNaN(hVar.f12292p) ? 0.0f : hVar.f12292p;
        if (!Float.isNaN(hVar.f12290n)) {
            f19 = hVar.f12290n;
        }
        float f26 = Float.isNaN(hVar.f12291o) ? 0.0f : hVar.f12291o;
        this.f12428p = 0;
        this.f12417e = (int) (((pVar.f12417e + (f24 * f20)) + (f26 * f21)) - f22);
        this.f12418f = (int) (((pVar.f12418f + (f20 * f25)) + (f21 * f19)) - f23);
        this.f12413a = C4890c.c(hVar.f12284h);
        this.f12423k = hVar.f12285i;
    }

    public void r(h hVar, p pVar, p pVar2) {
        float f10 = hVar.f12238a / 100.0f;
        this.f12415c = f10;
        this.f12414b = hVar.f12286j;
        float f11 = Float.isNaN(hVar.f12287k) ? f10 : hVar.f12287k;
        float f12 = Float.isNaN(hVar.f12288l) ? f10 : hVar.f12288l;
        float f13 = pVar2.f12419g - pVar.f12419g;
        float f14 = pVar2.f12420h - pVar.f12420h;
        this.f12416d = this.f12415c;
        if (!Float.isNaN(hVar.f12289m)) {
            f10 = hVar.f12289m;
        }
        float f15 = pVar.f12417e;
        float f16 = pVar.f12419g;
        float f17 = pVar.f12418f;
        float f18 = pVar.f12420h;
        float f19 = f10;
        float f20 = (pVar2.f12417e + (pVar2.f12419g / 2.0f)) - ((f16 / 2.0f) + f15);
        float f21 = (pVar2.f12418f + (pVar2.f12420h / 2.0f)) - ((f18 / 2.0f) + f17);
        float f22 = f20 * f19;
        float f23 = (f13 * f11) / 2.0f;
        this.f12417e = (int) ((f15 + f22) - f23);
        float f24 = f21 * f19;
        float f25 = (f14 * f12) / 2.0f;
        this.f12418f = (int) ((f17 + f24) - f25);
        this.f12419g = (int) (f16 + r7);
        this.f12420h = (int) (f18 + r8);
        float f26 = Float.isNaN(hVar.f12290n) ? 0.0f : hVar.f12290n;
        this.f12428p = 1;
        float f27 = (int) ((pVar.f12417e + f22) - f23);
        float f28 = (int) ((pVar.f12418f + f24) - f25);
        this.f12417e = f27 + ((-f21) * f26);
        this.f12418f = f28 + (f20 * f26);
        this.f12424l = this.f12424l;
        this.f12413a = C4890c.c(hVar.f12284h);
        this.f12423k = hVar.f12285i;
    }

    public void s(int i10, int i11, h hVar, p pVar, p pVar2) {
        float fMin;
        float f10;
        float f11 = hVar.f12238a / 100.0f;
        this.f12415c = f11;
        this.f12414b = hVar.f12286j;
        this.f12428p = hVar.f12293q;
        float f12 = Float.isNaN(hVar.f12287k) ? f11 : hVar.f12287k;
        float f13 = Float.isNaN(hVar.f12288l) ? f11 : hVar.f12288l;
        float f14 = pVar2.f12419g;
        float f15 = pVar.f12419g;
        float f16 = pVar2.f12420h;
        float f17 = pVar.f12420h;
        this.f12416d = this.f12415c;
        this.f12419g = (int) (f15 + ((f14 - f15) * f12));
        this.f12420h = (int) (f17 + ((f16 - f17) * f13));
        if (hVar.f12293q != 2) {
            float f18 = Float.isNaN(hVar.f12289m) ? f11 : hVar.f12289m;
            float f19 = pVar2.f12417e;
            float f20 = pVar.f12417e;
            this.f12417e = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(hVar.f12290n)) {
                f11 = hVar.f12290n;
            }
            float f21 = pVar2.f12418f;
            float f22 = pVar.f12418f;
            this.f12418f = (f11 * (f21 - f22)) + f22;
        } else {
            if (Float.isNaN(hVar.f12289m)) {
                float f23 = pVar2.f12417e;
                float f24 = pVar.f12417e;
                fMin = ((f23 - f24) * f11) + f24;
            } else {
                fMin = Math.min(f13, f12) * hVar.f12289m;
            }
            this.f12417e = fMin;
            if (Float.isNaN(hVar.f12290n)) {
                float f25 = pVar2.f12418f;
                float f26 = pVar.f12418f;
                f10 = (f11 * (f25 - f26)) + f26;
            } else {
                f10 = hVar.f12290n;
            }
            this.f12418f = f10;
        }
        this.f12424l = pVar.f12424l;
        this.f12413a = C4890c.c(hVar.f12284h);
        this.f12423k = hVar.f12285i;
    }

    public void t(int i10, int i11, h hVar, p pVar, p pVar2) {
        float f10 = hVar.f12238a / 100.0f;
        this.f12415c = f10;
        this.f12414b = hVar.f12286j;
        float f11 = Float.isNaN(hVar.f12287k) ? f10 : hVar.f12287k;
        float f12 = Float.isNaN(hVar.f12288l) ? f10 : hVar.f12288l;
        float f13 = pVar2.f12419g;
        float f14 = pVar.f12419g;
        float f15 = pVar2.f12420h;
        float f16 = pVar.f12420h;
        this.f12416d = this.f12415c;
        float f17 = pVar.f12417e;
        float f18 = pVar.f12418f;
        float f19 = pVar2.f12417e + (f13 / 2.0f);
        float f20 = pVar2.f12418f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f12417e = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f12;
        this.f12418f = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f));
        this.f12419g = (int) (f14 + f21);
        this.f12420h = (int) (f16 + f22);
        this.f12428p = 2;
        if (!Float.isNaN(hVar.f12289m)) {
            this.f12417e = (int) (hVar.f12289m * (i10 - ((int) this.f12419g)));
        }
        if (!Float.isNaN(hVar.f12290n)) {
            this.f12418f = (int) (hVar.f12290n * (i11 - ((int) this.f12420h)));
        }
        this.f12424l = this.f12424l;
        this.f12413a = C4890c.c(hVar.f12284h);
        this.f12423k = hVar.f12285i;
    }

    public void u(float f10, float f11, float f12, float f13) {
        this.f12417e = f10;
        this.f12418f = f11;
        this.f12419g = f12;
        this.f12420h = f13;
    }

    public void v(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w(float f10, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f11;
        float f12 = this.f12417e;
        float f13 = this.f12418f;
        float f14 = this.f12419g;
        float f15 = this.f12420h;
        if (iArr.length != 0 && this.f12430r.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.f12430r = new double[i10];
            this.f12431s = new double[i10];
        }
        Arrays.fill(this.f12430r, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            double[] dArr4 = this.f12430r;
            int i12 = iArr[i11];
            dArr4[i12] = dArr[i11];
            this.f12431s[i12] = dArr2[i11];
        }
        float f16 = Float.NaN;
        int i13 = 0;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        while (true) {
            double[] dArr5 = this.f12430r;
            if (i13 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i13]) && (dArr3 == null || dArr3[i13] == 0.0d)) {
                f11 = f16;
            } else {
                double d10 = dArr3 != null ? dArr3[i13] : 0.0d;
                if (!Double.isNaN(this.f12430r[i13])) {
                    d10 = this.f12430r[i13] + d10;
                }
                f11 = f16;
                float f21 = (float) d10;
                float f22 = (float) this.f12431s[i13];
                if (i13 == 1) {
                    f16 = f11;
                    f12 = f21;
                    f17 = f22;
                } else if (i13 == 2) {
                    f16 = f11;
                    f13 = f21;
                    f18 = f22;
                } else if (i13 == 3) {
                    f16 = f11;
                    f14 = f21;
                    f19 = f22;
                } else if (i13 == 4) {
                    f16 = f11;
                    f15 = f21;
                    f20 = f22;
                } else if (i13 == 5) {
                    f16 = f21;
                }
                i13++;
            }
            f16 = f11;
            i13++;
        }
        float f23 = f16;
        m mVar = this.f12426n;
        if (mVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            mVar.i(f10, fArr, fArr2);
            float f24 = fArr[0];
            float f25 = fArr[1];
            float f26 = fArr2[0];
            float f27 = fArr2[1];
            double d11 = f12;
            double d12 = f13;
            float fSin = (float) ((f24 + (Math.sin(d12) * d11)) - (f14 / 2.0f));
            float fCos = (float) ((f25 - (Math.cos(d12) * d11)) - (f15 / 2.0f));
            double d13 = f26;
            double d14 = f17;
            double dSin = d13 + (Math.sin(d12) * d14);
            double dCos = Math.cos(d12) * d11;
            double d15 = f18;
            float f28 = (float) (dSin + (dCos * d15));
            float fCos2 = (float) ((f27 - (d14 * Math.cos(d12))) + (Math.sin(d12) * d11 * d15));
            if (dArr2.length >= 2) {
                dArr2[0] = f28;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f23)) {
                view.setRotation((float) (f23 + Math.toDegrees(Math.atan2(fCos2, f28))));
            }
            f12 = fSin;
            f13 = fCos;
        } else if (!Float.isNaN(f23)) {
            view.setRotation(f23 + ((float) Math.toDegrees(Math.atan2(f18 + (f20 / 2.0f), f17 + (f19 / 2.0f)))) + 0.0f);
        }
        if (view instanceof c) {
            ((c) view).a(f12, f13, f14 + f12, f15 + f13);
            return;
        }
        float f29 = f12 + 0.5f;
        int i14 = (int) f29;
        float f30 = f13 + 0.5f;
        int i15 = (int) f30;
        int i16 = (int) (f29 + f14);
        int i17 = (int) (f30 + f15);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (i18 != view.getMeasuredWidth() || i19 != view.getMeasuredHeight() || z10) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view.layout(i14, i15, i16, i17);
    }

    public void x(m mVar, p pVar) {
        double d10 = ((this.f12417e + (this.f12419g / 2.0f)) - pVar.f12417e) - (pVar.f12419g / 2.0f);
        double d11 = ((this.f12418f + (this.f12420h / 2.0f)) - pVar.f12418f) - (pVar.f12420h / 2.0f);
        this.f12426n = mVar;
        this.f12417e = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.f12425m)) {
            this.f12418f = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f12418f = (float) Math.toRadians(this.f12425m);
        }
    }

    public p(int i10, int i11, h hVar, p pVar, p pVar2) {
        int i12 = d.f12237f;
        this.f12423k = i12;
        this.f12424l = i12;
        this.f12425m = Float.NaN;
        this.f12426n = null;
        this.f12427o = new LinkedHashMap<>();
        this.f12428p = 0;
        this.f12430r = new double[18];
        this.f12431s = new double[18];
        if (pVar.f12424l != d.f12237f) {
            s(i10, i11, hVar, pVar, pVar2);
            return;
        }
        int i13 = hVar.f12293q;
        if (i13 == 1) {
            r(hVar, pVar, pVar2);
            return;
        }
        if (i13 == 2) {
            t(i10, i11, hVar, pVar, pVar2);
        } else if (i13 != 3) {
            q(hVar, pVar, pVar2);
        } else {
            p(hVar, pVar, pVar2);
        }
    }
}

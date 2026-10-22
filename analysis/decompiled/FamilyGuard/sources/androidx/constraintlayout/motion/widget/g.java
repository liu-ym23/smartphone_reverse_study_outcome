package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import t.AbstractC1101a;
import t.C1102b;
import t.C1103c;
import x.AbstractC1274b;
import x.AbstractC1275c;
import x.AbstractC1276d;
import x.C1273a;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    boolean f8662a;

    /* renamed from: b, reason: collision with root package name */
    private k f8663b;

    /* renamed from: c, reason: collision with root package name */
    private k f8664c;

    /* renamed from: d, reason: collision with root package name */
    private f f8665d;

    /* renamed from: e, reason: collision with root package name */
    private f f8666e;

    /* renamed from: f, reason: collision with root package name */
    private AbstractC1101a[] f8667f;

    /* renamed from: g, reason: collision with root package name */
    private AbstractC1101a f8668g;

    /* renamed from: h, reason: collision with root package name */
    float f8669h;

    /* renamed from: i, reason: collision with root package name */
    float f8670i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f8671j;

    /* renamed from: k, reason: collision with root package name */
    private double[] f8672k;

    /* renamed from: l, reason: collision with root package name */
    private double[] f8673l;

    /* renamed from: m, reason: collision with root package name */
    private String[] f8674m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f8675n;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList<k> f8676o;

    /* renamed from: p, reason: collision with root package name */
    private HashMap<String, AbstractC1276d> f8677p;

    /* renamed from: q, reason: collision with root package name */
    private HashMap<String, AbstractC1275c> f8678q;

    /* renamed from: r, reason: collision with root package name */
    private HashMap<String, AbstractC1274b> f8679r;

    /* renamed from: s, reason: collision with root package name */
    private e[] f8680s;

    /* renamed from: t, reason: collision with root package name */
    private int f8681t;

    /* renamed from: u, reason: collision with root package name */
    private View f8682u;

    /* renamed from: v, reason: collision with root package name */
    private int f8683v;

    /* renamed from: w, reason: collision with root package name */
    private float f8684w;

    /* renamed from: x, reason: collision with root package name */
    private Interpolator f8685x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f8686y;

    private float a(float f5, float[] fArr) {
        float f6 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f7 = this.f8670i;
            if (f7 != 1.0d) {
                float f8 = this.f8669h;
                if (f5 < f8) {
                    f5 = 0.0f;
                }
                if (f5 > f8 && f5 < 1.0d) {
                    f5 = Math.min((f5 - f8) * f7, 1.0f);
                }
            }
        }
        C1102b c1102b = this.f8663b.f8754a;
        ArrayList<k> arrayList = this.f8676o;
        int size = arrayList.size();
        float f9 = Float.NaN;
        int i5 = 0;
        while (i5 < size) {
            k kVar = arrayList.get(i5);
            i5++;
            k kVar2 = kVar;
            C1102b c1102b2 = kVar2.f8754a;
            if (c1102b2 != null) {
                float f10 = kVar2.f8756c;
                if (f10 < f5) {
                    c1102b = c1102b2;
                    f6 = f10;
                } else if (Float.isNaN(f9)) {
                    f9 = kVar2.f8756c;
                }
            }
        }
        if (c1102b == null) {
            return f5;
        }
        float f11 = (Float.isNaN(f9) ? 1.0f : f9) - f6;
        double d6 = (f5 - f6) / f11;
        float fA = (((float) c1102b.a(d6)) * f11) + f6;
        if (fArr != null) {
            fArr[0] = (float) c1102b.b(d6);
        }
        return fA;
    }

    public void b(double d6, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f8667f[0].b(d6, dArr);
        this.f8667f[0].d(d6, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f8663b.d(d6, this.f8671j, dArr, fArr, dArr2, fArr2);
    }

    boolean c(View view, float f5, long j5, C1103c c1103c) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        AbstractC1276d.a aVar;
        boolean zC;
        View view2;
        View view3;
        float f6;
        float f7;
        double d6;
        View view4 = view;
        float fA = a(f5, null);
        int i5 = this.f8683v;
        if (i5 != d.f8659a) {
            float f8 = 1.0f / i5;
            float fFloor = ((float) Math.floor(fA / f8)) * f8;
            float f9 = (fA % f8) / f8;
            if (!Float.isNaN(this.f8684w)) {
                f9 = (f9 + this.f8684w) % 1.0f;
            }
            Interpolator interpolator = this.f8685x;
            fA = ((interpolator != null ? interpolator.getInterpolation(f9) : ((double) f9) > 0.5d ? 1.0f : 0.0f) * f8) + fFloor;
        }
        HashMap<String, AbstractC1275c> map = this.f8678q;
        if (map != null) {
            Iterator<AbstractC1275c> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().b(view4, fA);
            }
        }
        HashMap<String, AbstractC1276d> map2 = this.f8677p;
        if (map2 != null) {
            AbstractC1276d.a aVar2 = null;
            boolean zB = false;
            for (AbstractC1276d abstractC1276d : map2.values()) {
                if (abstractC1276d instanceof AbstractC1276d.a) {
                    aVar2 = (AbstractC1276d.a) abstractC1276d;
                } else {
                    zB |= abstractC1276d.b(view4, fA, j5, c1103c);
                    view4 = view;
                }
            }
            zC = zB;
            aVar = aVar2;
        } else {
            aVar = null;
            zC = false;
        }
        AbstractC1101a[] abstractC1101aArr = this.f8667f;
        if (abstractC1101aArr != null) {
            double d7 = fA;
            abstractC1101aArr[0].b(d7, this.f8672k);
            this.f8667f[0].d(d7, this.f8673l);
            if (this.f8686y) {
                view3 = view;
                f6 = 1.0f;
                f7 = 0.0f;
                d6 = d7;
            } else {
                float f10 = fA;
                f6 = 1.0f;
                d6 = d7;
                f7 = 0.0f;
                this.f8663b.e(f10, view, this.f8671j, this.f8672k, this.f8673l, null, this.f8662a);
                fA = f10;
                view3 = view;
                this.f8662a = false;
            }
            if (this.f8681t != d.f8659a) {
                if (this.f8682u == null) {
                    this.f8682u = ((View) view3.getParent()).findViewById(this.f8681t);
                }
                if (this.f8682u != null) {
                    float top = (r1.getTop() + this.f8682u.getBottom()) / 2.0f;
                    float left = (this.f8682u.getLeft() + this.f8682u.getRight()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(left - view3.getLeft());
                        view3.setPivotY(top - view3.getTop());
                    }
                }
            }
            HashMap<String, AbstractC1275c> map3 = this.f8678q;
            if (map3 != null) {
                for (AbstractC1275c abstractC1275c : map3.values()) {
                    if (abstractC1275c instanceof AbstractC1275c.a) {
                        double[] dArr = this.f8673l;
                        if (dArr.length > 1) {
                            ((AbstractC1275c.a) abstractC1275c).c(view3, fA, dArr[0], dArr[1]);
                        }
                    }
                    view3 = view;
                }
            }
            if (aVar != null) {
                double[] dArr2 = this.f8673l;
                view2 = view;
                float f11 = fA;
                fA = f11;
                zC |= aVar.c(view2, c1103c, f11, j5, dArr2[0], dArr2[1]);
            } else {
                view2 = view;
            }
            int i6 = 1;
            while (true) {
                AbstractC1101a[] abstractC1101aArr2 = this.f8667f;
                if (i6 >= abstractC1101aArr2.length) {
                    break;
                }
                abstractC1101aArr2[i6].c(d6, this.f8675n);
                C1273a.b(this.f8663b.f8768o.get(this.f8674m[i6 - 1]), view2, this.f8675n);
                i6++;
            }
            f fVar = this.f8665d;
            if (fVar.f8660a == 0) {
                if (fA <= f7) {
                    view2.setVisibility(fVar.f8661b);
                } else if (fA >= f6) {
                    view2.setVisibility(this.f8666e.f8661b);
                } else if (this.f8666e.f8661b != fVar.f8661b) {
                    view2.setVisibility(0);
                }
            }
            if (this.f8680s != null) {
                int i7 = 0;
                while (true) {
                    e[] eVarArr = this.f8680s;
                    if (i7 >= eVarArr.length) {
                        break;
                    }
                    eVarArr[i7].a(fA, view2);
                    i7++;
                }
            }
        } else {
            view2 = view;
            k kVar = this.f8663b;
            float f12 = kVar.f8758e;
            k kVar2 = this.f8664c;
            float f13 = f12 + ((kVar2.f8758e - f12) * fA);
            float f14 = kVar.f8759f;
            float f15 = f14 + ((kVar2.f8759f - f14) * fA);
            float f16 = kVar.f8760g;
            float f17 = kVar2.f8760g;
            float f18 = kVar.f8761h;
            float f19 = kVar2.f8761h;
            float f20 = f13 + 0.5f;
            int i8 = (int) f20;
            float f21 = f15 + 0.5f;
            int i9 = (int) f21;
            int i10 = (int) (f20 + ((f17 - f16) * fA) + f16);
            int i11 = (int) (f21 + ((f19 - f18) * fA) + f18);
            int i12 = i10 - i8;
            int i13 = i11 - i9;
            if (f17 != f16 || f19 != f18 || this.f8662a) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
                this.f8662a = false;
            }
            view2.layout(i8, i9, i10, i11);
        }
        HashMap<String, AbstractC1274b> map4 = this.f8679r;
        if (map4 != null) {
            for (AbstractC1274b abstractC1274b : map4.values()) {
                if (abstractC1274b instanceof AbstractC1274b.a) {
                    double[] dArr3 = this.f8673l;
                    ((AbstractC1274b.a) abstractC1274b).c(view2, fA, dArr3[0], dArr3[1]);
                } else {
                    abstractC1274b.b(view2, fA);
                }
            }
        }
        return zC;
    }

    public String toString() {
        return " start: x: " + this.f8663b.f8758e + " y: " + this.f8663b.f8759f + " end: x: " + this.f8664c.f8758e + " y: " + this.f8664c.f8759f;
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import m0.AbstractC4889b;
import m0.C4890c;
import m0.C4891d;
import q0.AbstractC5139c;
import q0.AbstractC5140d;
import q0.AbstractC5142f;
import q0.C5137a;
import q0.C5141e;

/* loaded from: classes.dex */
public class m {

    /* renamed from: B, reason: collision with root package name */
    public HashMap<String, AbstractC5142f> f12370B;

    /* renamed from: C, reason: collision with root package name */
    public HashMap<String, AbstractC5140d> f12371C;

    /* renamed from: D, reason: collision with root package name */
    public HashMap<String, AbstractC5139c> f12372D;

    /* renamed from: E, reason: collision with root package name */
    public k[] f12373E;

    /* renamed from: F, reason: collision with root package name */
    public int f12374F;

    /* renamed from: G, reason: collision with root package name */
    public int f12375G;

    /* renamed from: H, reason: collision with root package name */
    public View f12376H;

    /* renamed from: I, reason: collision with root package name */
    public int f12377I;

    /* renamed from: J, reason: collision with root package name */
    public float f12378J;

    /* renamed from: K, reason: collision with root package name */
    public Interpolator f12379K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f12380L;

    /* renamed from: b, reason: collision with root package name */
    public View f12382b;

    /* renamed from: c, reason: collision with root package name */
    public int f12383c;

    /* renamed from: e, reason: collision with root package name */
    public String f12385e;

    /* renamed from: k, reason: collision with root package name */
    public AbstractC4889b[] f12391k;

    /* renamed from: l, reason: collision with root package name */
    public AbstractC4889b f12392l;

    /* renamed from: p, reason: collision with root package name */
    public float f12396p;

    /* renamed from: q, reason: collision with root package name */
    public float f12397q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f12398r;

    /* renamed from: s, reason: collision with root package name */
    public double[] f12399s;

    /* renamed from: t, reason: collision with root package name */
    public double[] f12400t;

    /* renamed from: u, reason: collision with root package name */
    public String[] f12401u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f12402v;

    /* renamed from: a, reason: collision with root package name */
    public Rect f12381a = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public boolean f12384d = false;

    /* renamed from: f, reason: collision with root package name */
    public int f12386f = -1;

    /* renamed from: g, reason: collision with root package name */
    public p f12387g = new p();

    /* renamed from: h, reason: collision with root package name */
    public p f12388h = new p();

    /* renamed from: i, reason: collision with root package name */
    public l f12389i = new l();

    /* renamed from: j, reason: collision with root package name */
    public l f12390j = new l();

    /* renamed from: m, reason: collision with root package name */
    public float f12393m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f12394n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f12395o = 1.0f;

    /* renamed from: w, reason: collision with root package name */
    public int f12403w = 4;

    /* renamed from: x, reason: collision with root package name */
    public float[] f12404x = new float[4];

    /* renamed from: y, reason: collision with root package name */
    public ArrayList<p> f12405y = new ArrayList<>();

    /* renamed from: z, reason: collision with root package name */
    public float[] f12406z = new float[1];

    /* renamed from: A, reason: collision with root package name */
    public ArrayList<d> f12369A = new ArrayList<>();

    public class a implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C4890c f12407a;

        public a(C4890c c4890c) {
            this.f12407a = c4890c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            return (float) this.f12407a.a(f10);
        }
    }

    public m(View view) {
        int i10 = d.f12237f;
        this.f12374F = i10;
        this.f12375G = i10;
        this.f12376H = null;
        this.f12377I = i10;
        this.f12378J = Float.NaN;
        this.f12379K = null;
        this.f12380L = false;
        E(view);
    }

    public static Interpolator p(Context context, int i10, String str, int i11) {
        if (i10 == -2) {
            return AnimationUtils.loadInterpolator(context, i11);
        }
        if (i10 == -1) {
            return new a(C4890c.c(str));
        }
        if (i10 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i10 == 1) {
            return new AccelerateInterpolator();
        }
        if (i10 == 2) {
            return new DecelerateInterpolator();
        }
        if (i10 == 4) {
            return new BounceInterpolator();
        }
        if (i10 != 5) {
            return null;
        }
        return new OvershootInterpolator();
    }

    public void A(int i10) {
        this.f12374F = i10;
    }

    public void B(View view) {
        p pVar = this.f12387g;
        pVar.f12415c = 0.0f;
        pVar.f12416d = 0.0f;
        pVar.u(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f12389i.n(view);
    }

    public void C(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        m mVar;
        Rect rect2;
        int i12 = cVar.f12717e;
        if (i12 != 0) {
            mVar = this;
            rect2 = rect;
            mVar.x(rect2, this.f12381a, i12, i10, i11);
        } else {
            mVar = this;
            rect2 = rect;
        }
        p pVar = mVar.f12387g;
        pVar.f12415c = 0.0f;
        pVar.f12416d = 0.0f;
        mVar.v(pVar);
        mVar.f12387g.u(rect2.left, rect2.top, rect2.width(), rect2.height());
        c.a aVarF = cVar.F(mVar.f12383c);
        mVar.f12387g.a(aVarF);
        mVar.f12393m = aVarF.f12724d.f12818g;
        mVar.f12389i.m(rect2, cVar, i12, mVar.f12383c);
        mVar.f12375G = aVarF.f12726f.f12840i;
        c.C0154c c0154c = aVarF.f12724d;
        mVar.f12377I = c0154c.f12822k;
        mVar.f12378J = c0154c.f12821j;
        Context context = mVar.f12382b.getContext();
        c.C0154c c0154c2 = aVarF.f12724d;
        mVar.f12379K = p(context, c0154c2.f12824m, c0154c2.f12823l, c0154c2.f12825n);
    }

    public void D(C5141e c5141e, View view, int i10, int i11, int i12) {
        p pVar = this.f12387g;
        pVar.f12415c = 0.0f;
        pVar.f12416d = 0.0f;
        Rect rect = new Rect();
        if (i10 == 1) {
            int i13 = c5141e.f38484b + c5141e.f38486d;
            rect.left = ((c5141e.f38485c + c5141e.f38487e) - c5141e.b()) / 2;
            rect.top = i11 - ((i13 + c5141e.a()) / 2);
            rect.right = rect.left + c5141e.b();
            rect.bottom = rect.top + c5141e.a();
        } else if (i10 == 2) {
            int i14 = c5141e.f38484b + c5141e.f38486d;
            rect.left = i12 - (((c5141e.f38485c + c5141e.f38487e) + c5141e.b()) / 2);
            rect.top = (i14 - c5141e.a()) / 2;
            rect.right = rect.left + c5141e.b();
            rect.bottom = rect.top + c5141e.a();
        }
        this.f12387g.u(rect.left, rect.top, rect.width(), rect.height());
        this.f12389i.l(rect, view, i10, c5141e.f38483a);
    }

    public void E(View view) {
        this.f12382b = view;
        this.f12383c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            this.f12385e = ((ConstraintLayout.b) layoutParams).a();
        }
    }

    public void F(int i10, int i11, float f10, long j10) {
        ArrayList arrayList;
        String[] strArr;
        p[] pVarArr;
        ConstraintAttribute constraintAttribute;
        AbstractC5142f abstractC5142fH;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        AbstractC5140d abstractC5140dF;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i12 = this.f12374F;
        if (i12 != d.f12237f) {
            this.f12387g.f12423k = i12;
        }
        this.f12389i.j(this.f12390j, hashSet2);
        ArrayList<d> arrayList2 = this.f12369A;
        if (arrayList2 != null) {
            Iterator<d> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof h) {
                    h hVar = (h) next;
                    t(new p(i10, i11, hVar, this.f12387g, this.f12388h));
                    int i13 = hVar.f12297g;
                    if (i13 != d.f12237f) {
                        this.f12386f = i13;
                    }
                } else if (next instanceof f) {
                    next.d(hashSet3);
                } else if (next instanceof j) {
                    next.d(hashSet);
                } else if (next instanceof k) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((k) next);
                } else {
                    next.g(map);
                    next.d(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        int i14 = 0;
        if (arrayList != null) {
            this.f12373E = (k[]) arrayList.toArray(new k[0]);
        }
        boolean z10 = true;
        if (!hashSet2.isEmpty()) {
            this.f12371C = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(Const.STR_MART_COMMA)[1];
                    Iterator<d> it3 = this.f12369A.iterator();
                    while (it3.hasNext()) {
                        d next3 = it3.next();
                        HashMap<String, ConstraintAttribute> map2 = next3.f12242e;
                        if (map2 != null && (constraintAttribute3 = map2.get(str)) != null) {
                            sparseArray.append(next3.f12238a, constraintAttribute3);
                        }
                    }
                    abstractC5140dF = AbstractC5140d.e(next2, sparseArray);
                } else {
                    abstractC5140dF = AbstractC5140d.f(next2);
                }
                if (abstractC5140dF != null) {
                    abstractC5140dF.c(next2);
                    this.f12371C.put(next2, abstractC5140dF);
                }
            }
            ArrayList<d> arrayList3 = this.f12369A;
            if (arrayList3 != null) {
                Iterator<d> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    d next4 = it4.next();
                    if (next4 instanceof e) {
                        next4.a(this.f12371C);
                    }
                }
            }
            this.f12389i.a(this.f12371C, 0);
            this.f12390j.a(this.f12371C, 100);
            for (String str2 : this.f12371C.keySet()) {
                int iIntValue = (!map.containsKey(str2) || (num = map.get(str2)) == null) ? 0 : num.intValue();
                AbstractC5140d abstractC5140d = this.f12371C.get(str2);
                if (abstractC5140d != null) {
                    abstractC5140d.d(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.f12370B == null) {
                this.f12370B = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.f12370B.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(Const.STR_MART_COMMA)[1];
                        Iterator<d> it6 = this.f12369A.iterator();
                        while (it6.hasNext()) {
                            d next6 = it6.next();
                            HashMap<String, ConstraintAttribute> map3 = next6.f12242e;
                            if (map3 != null && (constraintAttribute2 = map3.get(str3)) != null) {
                                sparseArray2.append(next6.f12238a, constraintAttribute2);
                            }
                        }
                        abstractC5142fH = AbstractC5142f.g(next5, sparseArray2);
                    } else {
                        abstractC5142fH = AbstractC5142f.h(next5, j10);
                    }
                    if (abstractC5142fH != null) {
                        abstractC5142fH.d(next5);
                        this.f12370B.put(next5, abstractC5142fH);
                    }
                }
            }
            ArrayList<d> arrayList4 = this.f12369A;
            if (arrayList4 != null) {
                Iterator<d> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    d next7 = it7.next();
                    if (next7 instanceof j) {
                        ((j) next7).Q(this.f12370B);
                    }
                }
            }
            for (String str4 : this.f12370B.keySet()) {
                this.f12370B.get(str4).e(map.containsKey(str4) ? map.get(str4).intValue() : 0);
            }
        }
        int size = this.f12405y.size();
        int i15 = size + 2;
        p[] pVarArr2 = new p[i15];
        pVarArr2[0] = this.f12387g;
        pVarArr2[size + 1] = this.f12388h;
        if (this.f12405y.size() > 0 && this.f12386f == -1) {
            this.f12386f = 0;
        }
        Iterator<p> it8 = this.f12405y.iterator();
        int i16 = 1;
        while (it8.hasNext()) {
            pVarArr2[i16] = it8.next();
            i16++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.f12388h.f12427o.keySet()) {
            if (this.f12387g.f12427o.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.f12401u = strArr2;
        this.f12402v = new int[strArr2.length];
        int i17 = 0;
        while (true) {
            strArr = this.f12401u;
            if (i17 >= strArr.length) {
                break;
            }
            String str6 = strArr[i17];
            this.f12402v[i17] = 0;
            int i18 = 0;
            while (true) {
                if (i18 >= i15) {
                    break;
                }
                if (pVarArr2[i18].f12427o.containsKey(str6) && (constraintAttribute = pVarArr2[i18].f12427o.get(str6)) != null) {
                    int[] iArr = this.f12402v;
                    iArr[i17] = iArr[i17] + constraintAttribute.h();
                    break;
                }
                i18++;
            }
            i17++;
        }
        boolean z11 = pVarArr2[0].f12423k != d.f12237f;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i19 = 1; i19 < i15; i19++) {
            pVarArr2[i19].e(pVarArr2[i19 - 1], zArr, this.f12401u, z11);
        }
        int i20 = 0;
        for (int i21 = 1; i21 < length; i21++) {
            if (zArr[i21]) {
                i20++;
            }
        }
        this.f12398r = new int[i20];
        int i22 = 2;
        int iMax = Math.max(2, i20);
        this.f12399s = new double[iMax];
        this.f12400t = new double[iMax];
        int i23 = 0;
        for (int i24 = 1; i24 < length; i24++) {
            if (zArr[i24]) {
                this.f12398r[i23] = i24;
                i23++;
            }
        }
        int[] iArr2 = {i15, this.f12398r.length};
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i15];
        for (int i25 = 0; i25 < i15; i25++) {
            pVarArr2[i25].i(dArr[i25], this.f12398r);
            dArr2[i25] = pVarArr2[i25].f12415c;
        }
        int i26 = 0;
        while (true) {
            int[] iArr3 = this.f12398r;
            if (i26 >= iArr3.length) {
                break;
            }
            if (iArr3[i26] < p.f12412t.length) {
                String str7 = p.f12412t[this.f12398r[i26]] + " [";
                for (int i27 = 0; i27 < i15; i27++) {
                    str7 = str7 + dArr[i27][i26];
                }
            }
            i26++;
        }
        this.f12391k = new AbstractC4889b[this.f12401u.length + 1];
        int i28 = 0;
        while (true) {
            String[] strArr3 = this.f12401u;
            if (i28 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i28];
            int i29 = i14;
            int i30 = i29;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i29 < i15) {
                boolean z12 = z10;
                if (pVarArr2[i29].o(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i15];
                        int[] iArr4 = new int[i22];
                        iArr4[z12 ? 1 : 0] = pVarArr2[i29].m(str8);
                        iArr4[i14] = i15;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    }
                    p pVar = pVarArr2[i29];
                    pVarArr = pVarArr2;
                    dArr3[i30] = pVar.f12415c;
                    pVar.l(str8, dArr4[i30], 0);
                    i30++;
                } else {
                    pVarArr = pVarArr2;
                }
                i29++;
                z10 = z12 ? 1 : 0;
                pVarArr2 = pVarArr;
                i22 = 2;
                i14 = 0;
            }
            i28++;
            this.f12391k[i28] = AbstractC4889b.a(this.f12386f, Arrays.copyOf(dArr3, i30), (double[][]) Arrays.copyOf(dArr4, i30));
            z10 = z10;
            pVarArr2 = pVarArr2;
            i22 = 2;
            i14 = 0;
        }
        p[] pVarArr3 = pVarArr2;
        boolean z13 = z10;
        this.f12391k[0] = AbstractC4889b.a(this.f12386f, dArr2, dArr);
        if (pVarArr3[0].f12423k != d.f12237f) {
            int[] iArr5 = new int[i15];
            double[] dArr5 = new double[i15];
            int[] iArr6 = new int[2];
            iArr6[z13 ? 1 : 0] = 2;
            iArr6[0] = i15;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i31 = 0; i31 < i15; i31++) {
                iArr5[i31] = pVarArr3[i31].f12423k;
                dArr5[i31] = r7.f12415c;
                double[] dArr7 = dArr6[i31];
                dArr7[0] = r7.f12417e;
                dArr7[z13 ? 1 : 0] = r7.f12418f;
            }
            this.f12392l = AbstractC4889b.b(iArr5, dArr5, dArr6);
        }
        this.f12372D = new HashMap<>();
        if (this.f12369A != null) {
            Iterator<String> it9 = hashSet3.iterator();
            float fR = Float.NaN;
            while (it9.hasNext()) {
                String next8 = it9.next();
                AbstractC5139c abstractC5139cH = AbstractC5139c.h(next8);
                if (abstractC5139cH != null) {
                    if (abstractC5139cH.g() && Float.isNaN(fR)) {
                        fR = r();
                    }
                    abstractC5139cH.e(next8);
                    this.f12372D.put(next8, abstractC5139cH);
                }
            }
            Iterator<d> it10 = this.f12369A.iterator();
            while (it10.hasNext()) {
                d next9 = it10.next();
                if (next9 instanceof f) {
                    ((f) next9).U(this.f12372D);
                }
            }
            Iterator<AbstractC5139c> it11 = this.f12372D.values().iterator();
            while (it11.hasNext()) {
                it11.next().f(fR);
            }
        }
    }

    public void G(m mVar) {
        this.f12387g.x(mVar, mVar.f12387g);
        this.f12388h.x(mVar, mVar.f12388h);
    }

    public void a(d dVar) {
        this.f12369A.add(dVar);
    }

    public void b(ArrayList<d> arrayList) {
        this.f12369A.addAll(arrayList);
    }

    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrG = this.f12391k[0].g();
        if (iArr != null) {
            Iterator<p> it = this.f12405y.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                iArr[i10] = it.next().f12428p;
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < dArrG.length; i12++) {
            this.f12391k[0].d(dArrG[i12], this.f12399s);
            this.f12387g.j(dArrG[i12], this.f12398r, this.f12399s, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    public void d(float[] fArr, int i10) {
        int i11 = i10;
        float f10 = 1.0f;
        float f11 = 1.0f / (i11 - 1);
        HashMap<String, AbstractC5140d> map = this.f12371C;
        AbstractC5140d abstractC5140d = map == null ? null : map.get("translationX");
        HashMap<String, AbstractC5140d> map2 = this.f12371C;
        AbstractC5140d abstractC5140d2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, AbstractC5139c> map3 = this.f12372D;
        AbstractC5139c abstractC5139c = map3 == null ? null : map3.get("translationX");
        HashMap<String, AbstractC5139c> map4 = this.f12372D;
        AbstractC5139c abstractC5139c2 = map4 != null ? map4.get("translationY") : null;
        int i12 = 0;
        while (i12 < i11) {
            float fMin = i12 * f11;
            float f12 = this.f12395o;
            float f13 = 0.0f;
            if (f12 != f10) {
                float f14 = this.f12394n;
                if (fMin < f14) {
                    fMin = 0.0f;
                }
                if (fMin > f14 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f14) * f12, f10);
                }
            }
            double dA = fMin;
            C4890c c4890c = this.f12387g.f12413a;
            Iterator<p> it = this.f12405y.iterator();
            float f15 = Float.NaN;
            while (it.hasNext()) {
                p next = it.next();
                C4890c c4890c2 = next.f12413a;
                if (c4890c2 != null) {
                    float f16 = next.f12415c;
                    if (f16 < fMin) {
                        f13 = f16;
                        c4890c = c4890c2;
                    } else if (Float.isNaN(f15)) {
                        f15 = next.f12415c;
                    }
                }
            }
            if (c4890c != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                dA = (((float) c4890c.a((fMin - f13) / r16)) * (f15 - f13)) + f13;
            }
            this.f12391k[0].d(dA, this.f12399s);
            AbstractC4889b abstractC4889b = this.f12392l;
            if (abstractC4889b != null) {
                double[] dArr = this.f12399s;
                if (dArr.length > 0) {
                    abstractC4889b.d(dA, dArr);
                }
            }
            int i13 = i12 * 2;
            this.f12387g.j(dA, this.f12398r, this.f12399s, fArr, i13);
            if (abstractC5139c != null) {
                fArr[i13] = fArr[i13] + abstractC5139c.a(fMin);
            } else if (abstractC5140d != null) {
                fArr[i13] = fArr[i13] + abstractC5140d.a(fMin);
            }
            if (abstractC5139c2 != null) {
                int i14 = i13 + 1;
                fArr[i14] = fArr[i14] + abstractC5139c2.a(fMin);
            } else if (abstractC5140d2 != null) {
                int i15 = i13 + 1;
                fArr[i15] = fArr[i15] + abstractC5140d2.a(fMin);
            }
            i12++;
            i11 = i10;
            f10 = 1.0f;
        }
    }

    public void e(float f10, float[] fArr, int i10) {
        this.f12391k[0].d(g(f10, null), this.f12399s);
        this.f12387g.n(this.f12398r, this.f12399s, fArr, i10);
    }

    public void f(boolean z10) {
        if (!"button".equals(androidx.constraintlayout.motion.widget.a.d(this.f12382b)) || this.f12373E == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            k[] kVarArr = this.f12373E;
            if (i10 >= kVarArr.length) {
                return;
            }
            kVarArr[i10].u(z10 ? -100.0f : 100.0f, this.f12382b);
            i10++;
        }
    }

    public final float g(float f10, float[] fArr) {
        float f11 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f12 = this.f12395o;
            if (f12 != 1.0d) {
                float f13 = this.f12394n;
                if (f10 < f13) {
                    f10 = 0.0f;
                }
                if (f10 > f13 && f10 < 1.0d) {
                    f10 = Math.min((f10 - f13) * f12, 1.0f);
                }
            }
        }
        C4890c c4890c = this.f12387g.f12413a;
        Iterator<p> it = this.f12405y.iterator();
        float f14 = Float.NaN;
        while (it.hasNext()) {
            p next = it.next();
            C4890c c4890c2 = next.f12413a;
            if (c4890c2 != null) {
                float f15 = next.f12415c;
                if (f15 < f10) {
                    c4890c = c4890c2;
                    f11 = f15;
                } else if (Float.isNaN(f14)) {
                    f14 = next.f12415c;
                }
            }
        }
        if (c4890c == null) {
            return f10;
        }
        float f16 = (Float.isNaN(f14) ? 1.0f : f14) - f11;
        double d10 = (f10 - f11) / f16;
        float fA = (((float) c4890c.a(d10)) * f16) + f11;
        if (fArr != null) {
            fArr[0] = (float) c4890c.b(d10);
        }
        return fA;
    }

    public int h() {
        return this.f12387g.f12424l;
    }

    public void i(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f12391k[0].d(d10, dArr);
        this.f12391k[0].f(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f12387g.k(d10, this.f12398r, dArr, fArr, dArr2, fArr2);
    }

    public float j() {
        return this.f12396p;
    }

    public float k() {
        return this.f12397q;
    }

    public void l(float f10, float f11, float f12, float[] fArr) {
        double[] dArr;
        float fG = g(f10, this.f12406z);
        AbstractC4889b[] abstractC4889bArr = this.f12391k;
        int i10 = 0;
        if (abstractC4889bArr == null) {
            p pVar = this.f12388h;
            float f13 = pVar.f12417e;
            p pVar2 = this.f12387g;
            float f14 = f13 - pVar2.f12417e;
            float f15 = pVar.f12418f - pVar2.f12418f;
            float f16 = (pVar.f12419g - pVar2.f12419g) + f14;
            float f17 = (pVar.f12420h - pVar2.f12420h) + f15;
            fArr[0] = (f14 * (1.0f - f11)) + (f16 * f11);
            fArr[1] = (f15 * (1.0f - f12)) + (f17 * f12);
            return;
        }
        double d10 = fG;
        abstractC4889bArr[0].f(d10, this.f12400t);
        this.f12391k[0].d(d10, this.f12399s);
        float f18 = this.f12406z[0];
        while (true) {
            dArr = this.f12400t;
            if (i10 >= dArr.length) {
                break;
            }
            dArr[i10] = dArr[i10] * f18;
            i10++;
        }
        AbstractC4889b abstractC4889b = this.f12392l;
        if (abstractC4889b == null) {
            this.f12387g.v(f11, f12, fArr, this.f12398r, dArr, this.f12399s);
            return;
        }
        double[] dArr2 = this.f12399s;
        if (dArr2.length > 0) {
            abstractC4889b.d(d10, dArr2);
            this.f12392l.f(d10, this.f12400t);
            this.f12387g.v(f11, f12, fArr, this.f12398r, this.f12400t, this.f12399s);
        }
    }

    public int m() {
        int iMax = this.f12387g.f12414b;
        Iterator<p> it = this.f12405y.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f12414b);
        }
        return Math.max(iMax, this.f12388h.f12414b);
    }

    public float n() {
        return this.f12388h.f12417e;
    }

    public float o() {
        return this.f12388h.f12418f;
    }

    public p q(int i10) {
        return this.f12405y.get(i10);
    }

    public final float r() {
        float[] fArr = new float[2];
        float f10 = 1.0f / 99;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        float fHypot = 0.0f;
        while (i10 < 100) {
            float f11 = i10 * f10;
            double dA = f11;
            C4890c c4890c = this.f12387g.f12413a;
            Iterator<p> it = this.f12405y.iterator();
            float f12 = Float.NaN;
            float f13 = 0.0f;
            while (it.hasNext()) {
                p next = it.next();
                C4890c c4890c2 = next.f12413a;
                if (c4890c2 != null) {
                    float f14 = next.f12415c;
                    if (f14 < f11) {
                        c4890c = c4890c2;
                        f13 = f14;
                    } else if (Float.isNaN(f12)) {
                        f12 = next.f12415c;
                    }
                }
            }
            if (c4890c != null) {
                if (Float.isNaN(f12)) {
                    f12 = 1.0f;
                }
                dA = (((float) c4890c.a((f11 - f13) / r17)) * (f12 - f13)) + f13;
            }
            double d12 = dA;
            this.f12391k[0].d(d12, this.f12399s);
            int i11 = i10;
            this.f12387g.j(d12, this.f12398r, this.f12399s, fArr, 0);
            if (i11 > 0) {
                fHypot += (float) Math.hypot(d11 - fArr[1], d10 - fArr[0]);
            }
            d10 = fArr[0];
            d11 = fArr[1];
            i10 = i11 + 1;
        }
        return fHypot;
    }

    public View s() {
        return this.f12382b;
    }

    public final void t(p pVar) {
        if (Collections.binarySearch(this.f12405y, pVar) == 0) {
            Log.e("MotionController", " KeyPath position \"" + pVar.f12416d + "\" outside of range");
        }
        this.f12405y.add((-r0) - 1, pVar);
    }

    public String toString() {
        return " start: x: " + this.f12387g.f12417e + " y: " + this.f12387g.f12418f + " end: x: " + this.f12388h.f12417e + " y: " + this.f12388h.f12418f;
    }

    public boolean u(View view, float f10, long j10, C4891d c4891d) {
        AbstractC5142f.d dVar;
        boolean zJ;
        View view2;
        View view3;
        float f11;
        float f12;
        double d10;
        View view4 = view;
        float fG = g(f10, null);
        int i10 = this.f12377I;
        if (i10 != d.f12237f) {
            float f13 = 1.0f / i10;
            float fFloor = ((float) Math.floor(fG / f13)) * f13;
            float f14 = (fG % f13) / f13;
            if (!Float.isNaN(this.f12378J)) {
                f14 = (f14 + this.f12378J) % 1.0f;
            }
            Interpolator interpolator = this.f12379K;
            fG = ((interpolator != null ? interpolator.getInterpolation(f14) : ((double) f14) > 0.5d ? 1.0f : 0.0f) * f13) + fFloor;
        }
        HashMap<String, AbstractC5140d> map = this.f12371C;
        if (map != null) {
            Iterator<AbstractC5140d> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().g(view4, fG);
            }
        }
        HashMap<String, AbstractC5142f> map2 = this.f12370B;
        if (map2 != null) {
            AbstractC5142f.d dVar2 = null;
            boolean zI = false;
            for (AbstractC5142f abstractC5142f : map2.values()) {
                if (abstractC5142f instanceof AbstractC5142f.d) {
                    dVar2 = (AbstractC5142f.d) abstractC5142f;
                } else {
                    zI |= abstractC5142f.i(view4, fG, j10, c4891d);
                    view4 = view;
                }
            }
            zJ = zI;
            dVar = dVar2;
        } else {
            dVar = null;
            zJ = false;
        }
        AbstractC4889b[] abstractC4889bArr = this.f12391k;
        if (abstractC4889bArr != null) {
            double d11 = fG;
            abstractC4889bArr[0].d(d11, this.f12399s);
            this.f12391k[0].f(d11, this.f12400t);
            AbstractC4889b abstractC4889b = this.f12392l;
            if (abstractC4889b != null) {
                double[] dArr = this.f12399s;
                if (dArr.length > 0) {
                    abstractC4889b.d(d11, dArr);
                    this.f12392l.f(d11, this.f12400t);
                }
            }
            if (this.f12380L) {
                view3 = view;
                f11 = 1.0f;
                f12 = 0.0f;
                d10 = d11;
            } else {
                float f15 = fG;
                f11 = 1.0f;
                d10 = d11;
                f12 = 0.0f;
                this.f12387g.w(f15, view, this.f12398r, this.f12399s, this.f12400t, null, this.f12384d);
                fG = f15;
                view3 = view;
                this.f12384d = false;
            }
            if (this.f12375G != d.f12237f) {
                if (this.f12376H == null) {
                    this.f12376H = ((View) view3.getParent()).findViewById(this.f12375G);
                }
                if (this.f12376H != null) {
                    float top = (r1.getTop() + this.f12376H.getBottom()) / 2.0f;
                    float left = (this.f12376H.getLeft() + this.f12376H.getRight()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(left - view3.getLeft());
                        view3.setPivotY(top - view3.getTop());
                    }
                }
            }
            HashMap<String, AbstractC5140d> map3 = this.f12371C;
            if (map3 != null) {
                for (AbstractC5140d abstractC5140d : map3.values()) {
                    if (abstractC5140d instanceof AbstractC5140d.C0501d) {
                        double[] dArr2 = this.f12400t;
                        if (dArr2.length > 1) {
                            ((AbstractC5140d.C0501d) abstractC5140d).h(view3, fG, dArr2[0], dArr2[1]);
                        }
                    }
                    view3 = view;
                }
            }
            if (dVar != null) {
                double[] dArr3 = this.f12400t;
                view2 = view;
                float f16 = fG;
                fG = f16;
                zJ |= dVar.j(view2, c4891d, f16, j10, dArr3[0], dArr3[1]);
            } else {
                view2 = view;
            }
            int i11 = 1;
            while (true) {
                AbstractC4889b[] abstractC4889bArr2 = this.f12391k;
                if (i11 >= abstractC4889bArr2.length) {
                    break;
                }
                abstractC4889bArr2[i11].e(d10, this.f12404x);
                C5137a.b(this.f12387g.f12427o.get(this.f12401u[i11 - 1]), view2, this.f12404x);
                i11++;
            }
            l lVar = this.f12389i;
            if (lVar.f12344b == 0) {
                if (fG <= f12) {
                    view2.setVisibility(lVar.f12345c);
                } else if (fG >= f11) {
                    view2.setVisibility(this.f12390j.f12345c);
                } else if (this.f12390j.f12345c != lVar.f12345c) {
                    view2.setVisibility(0);
                }
            }
            if (this.f12373E != null) {
                int i12 = 0;
                while (true) {
                    k[] kVarArr = this.f12373E;
                    if (i12 >= kVarArr.length) {
                        break;
                    }
                    kVarArr[i12].u(fG, view2);
                    i12++;
                }
            }
        } else {
            view2 = view;
            p pVar = this.f12387g;
            float f17 = pVar.f12417e;
            p pVar2 = this.f12388h;
            float f18 = f17 + ((pVar2.f12417e - f17) * fG);
            float f19 = pVar.f12418f;
            float f20 = f19 + ((pVar2.f12418f - f19) * fG);
            float f21 = pVar.f12419g;
            float f22 = pVar2.f12419g;
            float f23 = pVar.f12420h;
            float f24 = pVar2.f12420h;
            float f25 = f18 + 0.5f;
            int i13 = (int) f25;
            float f26 = f20 + 0.5f;
            int i14 = (int) f26;
            int i15 = (int) (f25 + ((f22 - f21) * fG) + f21);
            int i16 = (int) (f26 + ((f24 - f23) * fG) + f23);
            int i17 = i15 - i13;
            int i18 = i16 - i14;
            if (f22 != f21 || f24 != f23 || this.f12384d) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
                this.f12384d = false;
            }
            view2.layout(i13, i14, i15, i16);
        }
        HashMap<String, AbstractC5139c> map4 = this.f12372D;
        if (map4 != null) {
            for (AbstractC5139c abstractC5139c : map4.values()) {
                if (abstractC5139c instanceof AbstractC5139c.d) {
                    double[] dArr4 = this.f12400t;
                    ((AbstractC5139c.d) abstractC5139c).j(view2, fG, dArr4[0], dArr4[1]);
                } else {
                    abstractC5139c.i(view2, fG);
                }
            }
        }
        return zJ;
    }

    public final void v(p pVar) {
        pVar.u((int) this.f12382b.getX(), (int) this.f12382b.getY(), this.f12382b.getWidth(), this.f12382b.getHeight());
    }

    public void w() {
        this.f12384d = true;
    }

    public void x(Rect rect, Rect rect2, int i10, int i11, int i12) {
        if (i10 == 1) {
            int i13 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i12 - ((i13 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i10 == 2) {
            int i14 = rect.left + rect.right;
            rect2.left = i11 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i14 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i10 == 3) {
            int i15 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i15 / 2);
            rect2.top = i12 - ((i15 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
            return;
        }
        if (i10 != 4) {
            return;
        }
        int i16 = rect.left + rect.right;
        rect2.left = i11 - (((rect.bottom + rect.top) + rect.width()) / 2);
        rect2.top = (i16 - rect.height()) / 2;
        rect2.right = rect2.left + rect.width();
        rect2.bottom = rect2.top + rect.height();
    }

    public void y(View view) {
        p pVar = this.f12387g;
        pVar.f12415c = 0.0f;
        pVar.f12416d = 0.0f;
        this.f12380L = true;
        pVar.u(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f12388h.u(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f12389i.n(view);
        this.f12390j.n(view);
    }

    public void z(Rect rect, androidx.constraintlayout.widget.c cVar, int i10, int i11) {
        m mVar;
        int i12 = cVar.f12717e;
        if (i12 != 0) {
            mVar = this;
            mVar.x(rect, this.f12381a, i12, i10, i11);
            rect = mVar.f12381a;
        } else {
            mVar = this;
        }
        p pVar = mVar.f12388h;
        pVar.f12415c = 1.0f;
        pVar.f12416d = 1.0f;
        mVar.v(pVar);
        mVar.f12388h.u(rect.left, rect.top, rect.width(), rect.height());
        mVar.f12388h.a(cVar.F(mVar.f12383c));
        mVar.f12390j.m(rect, cVar, i12, mVar.f12383c);
    }
}

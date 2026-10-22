package N3;

import K.J;
import K.S;
import K.r;
import W.m;
import W.n;
import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import com.google.android.material.appbar.l;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1497a;

    /* renamed from: b, reason: collision with root package name */
    public final View f1498b;

    /* renamed from: c, reason: collision with root package name */
    public final c f1499c;

    /* renamed from: e, reason: collision with root package name */
    public OverScroller f1501e;

    /* renamed from: f, reason: collision with root package name */
    public int f1502f;

    /* renamed from: g, reason: collision with root package name */
    public int f1503g;

    /* renamed from: h, reason: collision with root package name */
    public int f1504h;

    /* renamed from: i, reason: collision with root package name */
    public int f1505i;

    /* renamed from: q, reason: collision with root package name */
    public m f1513q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1514r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f1515s;

    /* renamed from: t, reason: collision with root package name */
    public int f1516t;

    /* renamed from: v, reason: collision with root package name */
    public float f1518v;

    /* renamed from: y, reason: collision with root package name */
    public r f1521y;

    /* renamed from: d, reason: collision with root package name */
    public float f1500d = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1506j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1507k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1508l = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1509m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1510n = true;

    /* renamed from: o, reason: collision with root package name */
    public float f1511o = 0.99f;

    /* renamed from: p, reason: collision with root package name */
    public float f1512p = 228.0f;

    /* renamed from: u, reason: collision with root package name */
    public int f1517u = 0;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f1519w = new int[2];

    /* renamed from: x, reason: collision with root package name */
    public final int[] f1520x = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public boolean f1522z = false;

    /* renamed from: A, reason: collision with root package name */
    public float f1494A = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: B, reason: collision with root package name */
    public float f1495B = Property.DEFAULT_FLOAT_VALUE;

    /* renamed from: C, reason: collision with root package name */
    public int f1496C = 0;

    public d(Context context, View view, OverScroller overScroller, int i4) {
        this.f1497a = context;
        this.f1498b = view;
        this.f1516t = i4;
        if (overScroller == null) {
            this.f1501e = new OverScroller(context);
        } else {
            this.f1501e = overScroller;
        }
        this.f1499c = new c(this);
        this.f1514r = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public static void a(d dVar, float f4, boolean z4) {
        if (dVar.f1506j) {
            if (Math.abs(f4) < dVar.f1514r) {
                Log.w("SpringAnimationHelper", "velocity minus minVelocity:" + dVar.f1514r);
            } else {
                m mVarI = dVar.i(z4);
                mVarI.f1962a = f4 * dVar.f1500d;
                mVarI.i();
            }
        }
    }

    public final boolean b() {
        View view = this.f1498b;
        if (view.getTranslationY() != Property.DEFAULT_FLOAT_VALUE) {
            return false;
        }
        int[] iArr = this.f1519w;
        iArr[1] = 0;
        int[] iArr2 = this.f1520x;
        iArr2[1] = 0;
        g().e(0, 0, 0, -1, iArr, 0, iArr2);
        boolean z4 = iArr2[1] != 0;
        if (z4) {
            iArr[1] = 0;
            iArr2[1] = 0;
            g().c(0, 1, iArr2, iArr, 0);
        }
        return view.canScrollVertically(-1) || z4;
    }

    public final boolean c() {
        int[] iArr = this.f1519w;
        iArr[1] = 0;
        int[] iArr2 = this.f1520x;
        iArr2[1] = 0;
        g().c(0, 1, iArr2, iArr, 0);
        boolean z4 = iArr2[1] != 0;
        if (z4) {
            iArr[1] = 0;
            iArr2[1] = 0;
            g().e(0, 0, 0, -1, iArr, 0, iArr2);
        }
        return this.f1498b.canScrollVertically(1) || z4;
    }

    public final void d(float f4, float f5) {
        ArrayList arrayList = this.f1515s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a) this.f1515s.get(size)).a(f5);
            }
        }
    }

    public final void e() {
        ArrayList arrayList = this.f1515s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a) this.f1515s.get(size)).b(this.f1517u);
            }
        }
    }

    public final void f(int i4, int i5) {
        if (this.f1506j) {
            if (Math.abs(i4) >= this.f1514r || Math.abs(i5) >= this.f1514r) {
                if (i5 >= 0 || this.f1507k) {
                    if (i5 <= 0 || this.f1508l) {
                        if (i4 >= 0 || this.f1509m) {
                            if (i4 <= 0 || this.f1510n) {
                                m mVar = this.f1513q;
                                if (mVar != null && mVar.f1967f) {
                                    Log.w("SpringAnimationHelper", "animation already running....");
                                    return;
                                }
                                c cVar = this.f1499c;
                                if (cVar != null) {
                                    cVar.f1491a = i4;
                                    cVar.f1492b = i5;
                                    d dVar = cVar.f1493c;
                                    dVar.f1501e.fling(0, 0, i4, i5, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                    dVar.f1498b.removeCallbacks(cVar);
                                    dVar.f1498b.postOnAnimation(cVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final r g() {
        if (this.f1521y == null) {
            View view = this.f1498b;
            r rVar = new r(view);
            this.f1521y = rVar;
            if (rVar.f1002d) {
                WeakHashMap weakHashMap = S.f939a;
                J.z(view);
            }
            rVar.f1002d = true;
        }
        return this.f1521y;
    }

    public final int h() {
        View view;
        if (this.f1496C == 0 && (view = this.f1498b) != null) {
            this.f1496C = (int) ((this.f1516t == 1 ? view.getHeight() : view.getWidth()) / this.f1497a.getResources().getDisplayMetrics().density);
        }
        return this.f1496C;
    }

    public final m i(boolean z4) {
        n nVar = new n(Property.DEFAULT_FLOAT_VALUE);
        nVar.a(this.f1511o);
        nVar.b(this.f1512p);
        m mVar = new m(this.f1498b, z4 ? m.f1955q : m.f1954p);
        mVar.f1974m = nVar;
        this.f1513q = mVar;
        mVar.b(new b(this, z4));
        this.f1513q.a(new l(2, this));
        this.f1517u = 2;
        e();
        return this.f1513q;
    }

    public final boolean j() {
        int i4 = this.f1517u;
        return i4 == 1 || i4 == 2;
    }

    public final void k() {
        c cVar = this.f1499c;
        if (cVar != null) {
            cVar.a();
        }
        m mVar = this.f1513q;
        if (mVar != null && mVar.f1967f) {
            mVar.c();
        }
        g().h(this.f1516t == 1 ? 2 : 1, 0);
        this.f1522z = true;
    }

    public final void l() {
        g().i(0);
        this.f1522z = false;
        View view = this.f1498b;
        if (view.getTranslationY() != Property.DEFAULT_FLOAT_VALUE) {
            i(true).i();
        } else if (view.getTranslationX() != Property.DEFAULT_FLOAT_VALUE) {
            i(false).i();
        } else if (view.getTranslationY() == Property.DEFAULT_FLOAT_VALUE || view.getTranslationX() == Property.DEFAULT_FLOAT_VALUE) {
            this.f1517u = 0;
        }
        this.f1503g = 0;
        this.f1504h = 0;
    }

    public final float m(float f4, boolean z4) {
        float f5;
        Context context = this.f1497a;
        float f6 = f4 / context.getResources().getDisplayMetrics().density;
        float f7 = Property.DEFAULT_FLOAT_VALUE;
        if (z4 || this.f1517u != 1) {
            float fAbs = Math.abs(this.f1495B / context.getResources().getDisplayMetrics().density);
            float fH = h();
            if (fAbs < Property.DEFAULT_FLOAT_VALUE || fH <= Property.DEFAULT_FLOAT_VALUE) {
                f5 = 0.0f;
            } else {
                float fMin = Math.min(fAbs, fH - 1.0E-5f);
                f5 = ((fH * fMin) / (fH - fMin)) / 1.0f;
            }
            this.f1494A = Math.signum(-this.f1495B) * f5;
        }
        float f8 = this.f1494A + f6;
        this.f1494A = f8;
        float fAbs2 = Math.abs(f8);
        float fH2 = h();
        if (!((fAbs2 < Property.DEFAULT_FLOAT_VALUE) | (fH2 <= Property.DEFAULT_FLOAT_VALUE))) {
            f7 = (1.0f - (1.0f / (((fAbs2 / fH2) * 1.0f) + 1.0f))) * fH2;
        }
        float fApplyDimension = TypedValue.applyDimension(1, Math.signum(f8) * (-f7), context.getResources().getDisplayMetrics());
        this.f1495B = fApplyDimension;
        return fApplyDimension;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.d.n(android.view.MotionEvent):boolean");
    }

    public final void o(MotionEvent motionEvent, int i4) {
        this.f1503g = (int) motionEvent.getRawX(i4);
        this.f1504h = (int) motionEvent.getRawY(i4);
    }

    public final void p(float f4) {
        View view = this.f1498b;
        view.setTranslationX(f4);
        if (f4 != Property.DEFAULT_FLOAT_VALUE && this.f1518v == Property.DEFAULT_FLOAT_VALUE) {
            this.f1517u = 1;
            e();
        }
        if (f4 != Property.DEFAULT_FLOAT_VALUE || this.f1518v != Property.DEFAULT_FLOAT_VALUE) {
            d(f4, view.getTranslationY());
        }
        this.f1518v = f4;
    }
}

package ie;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import h1.f;
import h1.g;
import java.util.ArrayList;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;
import v0.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9597a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f9598b;

    /* renamed from: c, reason: collision with root package name */
    public final a f9599c;

    /* renamed from: e, reason: collision with root package name */
    public OverScroller f9601e;

    /* renamed from: f, reason: collision with root package name */
    public int f9602f;

    /* renamed from: g, reason: collision with root package name */
    public int f9603g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f9604i;

    /* renamed from: q, reason: collision with root package name */
    public f f9612q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f9613s;

    /* renamed from: t, reason: collision with root package name */
    public int f9614t;

    /* renamed from: v, reason: collision with root package name */
    public float f9616v;

    /* renamed from: y, reason: collision with root package name */
    public n f9619y;

    /* renamed from: d, reason: collision with root package name */
    public float f9600d = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9605j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9606k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9607l = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9608m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9609n = true;

    /* renamed from: o, reason: collision with root package name */
    public float f9610o = 0.99f;

    /* renamed from: p, reason: collision with root package name */
    public float f9611p = 228.0f;

    /* renamed from: u, reason: collision with root package name */
    public int f9615u = 0;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f9617w = new int[2];

    /* renamed from: x, reason: collision with root package name */
    public final int[] f9618x = new int[2];
    public boolean z = false;
    public float A = 0.0f;
    public float B = 0.0f;
    public int C = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f9620a;

        /* renamed from: b, reason: collision with root package name */
        public int f9621b;

        public a() {
            d.this.f9601e = new OverScroller(d.this.f9597a);
        }

        public final void a() {
            d dVar = d.this;
            if (dVar.f9601e.isFinished()) {
                return;
            }
            dVar.f9601e.abortAnimation();
        }

        @Override // java.lang.Runnable
        public final void run() {
            d dVar = d.this;
            ViewGroup viewGroup = dVar.f9598b;
            if (!dVar.f9601e.computeScrollOffset() || dVar.f9601e.isFinished()) {
                return;
            }
            boolean zB = dVar.b();
            boolean zC = dVar.c();
            dVar.f9601e.getCurrVelocity();
            int i10 = this.f9621b;
            if ((i10 < 0 && !zB) || (i10 > 0 && !zC)) {
                boolean z = dVar.f9601e.getStartY() > dVar.f9601e.getCurrY();
                float currVelocity = dVar.f9601e.getCurrVelocity();
                if (!z) {
                    currVelocity = -currVelocity;
                }
                d.a(dVar, currVelocity, true);
                a();
                return;
            }
            if ((this.f9620a >= 0 || viewGroup.canScrollHorizontally(-1)) && (this.f9620a <= 0 || viewGroup.canScrollHorizontally(1))) {
                ViewGroup viewGroup2 = dVar.f9598b;
                viewGroup2.removeCallbacks(this);
                viewGroup2.postOnAnimation(this);
            } else {
                boolean z3 = dVar.f9601e.getStartX() > dVar.f9601e.getCurrX();
                float currVelocity2 = dVar.f9601e.getCurrVelocity();
                if (!z3) {
                    currVelocity2 = -currVelocity2;
                }
                d.a(dVar, currVelocity2, false);
                a();
            }
        }
    }

    public d(Context context, ViewGroup viewGroup, OverScroller overScroller, int i10) {
        this.f9597a = context;
        this.f9598b = viewGroup;
        this.f9614t = i10;
        if (overScroller == null) {
            this.f9601e = new OverScroller(context);
        } else {
            this.f9601e = overScroller;
        }
        this.f9599c = new a();
        this.r = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public static void a(d dVar, float f8, boolean z) {
        if (dVar.f9605j) {
            if (Math.abs(f8) < dVar.r) {
                Log.w("SpringAnimationHelper", "velocity minus minVelocity:" + dVar.r);
            } else {
                f fVarI = dVar.i(z);
                fVarI.f9227a = f8 * dVar.f9600d;
                fVarI.h();
            }
        }
    }

    public final boolean b() {
        ViewGroup viewGroup = this.f9598b;
        if (viewGroup.getTranslationY() == 0.0f) {
            int[] iArr = this.f9617w;
            iArr[1] = 0;
            int[] iArr2 = this.f9618x;
            iArr2[1] = 0;
            g().d(0, 0, 0, -1, iArr, 0, iArr2);
            boolean z = iArr2[1] != 0;
            if (z) {
                iArr[1] = 0;
                iArr2[1] = 0;
                g().c(0, 1, iArr2, iArr, 0);
            }
            if (viewGroup.canScrollVertically(-1) || z) {
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        int[] iArr = this.f9617w;
        iArr[1] = 0;
        int[] iArr2 = this.f9618x;
        iArr2[1] = 0;
        g().c(0, 1, iArr2, iArr, 0);
        boolean z = iArr2[1] != 0;
        if (z) {
            iArr[1] = 0;
            iArr2[1] = 0;
            g().d(0, 0, 0, -1, iArr, 0, iArr2);
        }
        return this.f9598b.canScrollVertically(1) || z;
    }

    public final void d(float f8, float f9) {
        ArrayList arrayList = this.f9613s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((ie.a) this.f9613s.get(size)).a(f9);
            }
        }
    }

    public final void e() {
        ArrayList arrayList = this.f9613s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((ie.a) this.f9613s.get(size)).b(this.f9615u);
            }
        }
    }

    public final void f(int i10, int i11) {
        if (this.f9605j) {
            if (Math.abs(i10) >= this.r || Math.abs(i11) >= this.r) {
                if (i11 >= 0 || this.f9606k) {
                    if (i11 <= 0 || this.f9607l) {
                        if (i10 >= 0 || this.f9608m) {
                            if (i10 <= 0 || this.f9609n) {
                                f fVar = this.f9612q;
                                if (fVar != null && fVar.f9232f) {
                                    Log.w("SpringAnimationHelper", "animation already running....");
                                    return;
                                }
                                a aVar = this.f9599c;
                                if (aVar != null) {
                                    d dVar = d.this;
                                    aVar.f9620a = i10;
                                    aVar.f9621b = i11;
                                    dVar.f9601e.fling(0, 0, i10, i11, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                    ViewGroup viewGroup = dVar.f9598b;
                                    viewGroup.removeCallbacks(aVar);
                                    viewGroup.postOnAnimation(aVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final n g() {
        if (this.f9619y == null) {
            ViewGroup viewGroup = this.f9598b;
            n nVar = new n(viewGroup);
            this.f9619y = nVar;
            if (nVar.f13328d) {
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                e0.d.m(viewGroup);
            }
            nVar.f13328d = true;
        }
        return this.f9619y;
    }

    public final int h() {
        if (this.C == 0) {
            int i10 = this.f9614t;
            ViewGroup viewGroup = this.f9598b;
            this.C = (int) ((i10 == 1 ? viewGroup.getHeight() : viewGroup.getWidth()) / this.f9597a.getResources().getDisplayMetrics().density);
        }
        return this.C;
    }

    public final f i(boolean z) {
        g gVar = new g(0.0f);
        gVar.a(this.f9610o);
        gVar.b(this.f9611p);
        f fVar = new f(this.f9598b, z ? h1.d.f9221m : h1.d.f9220l);
        fVar.f9241t = gVar;
        this.f9612q = fVar;
        fVar.b(new b(this, z));
        this.f9612q.a(new c(this));
        this.f9615u = 2;
        e();
        return this.f9612q;
    }

    public final boolean j() {
        int i10 = this.f9615u;
        return i10 == 1 || i10 == 2;
    }

    public final void k() {
        a aVar = this.f9599c;
        if (aVar != null) {
            aVar.a();
        }
        f fVar = this.f9612q;
        if (fVar != null && fVar.f9232f) {
            fVar.f();
        }
        g().g(this.f9614t == 1 ? 2 : 1, 0);
        this.z = true;
    }

    public final void l() {
        g().h(0);
        this.z = false;
        ViewGroup viewGroup = this.f9598b;
        if (viewGroup.getTranslationY() != 0.0f) {
            i(true).h();
        } else if (viewGroup.getTranslationX() != 0.0f) {
            i(false).h();
        } else if (viewGroup.getTranslationY() == 0.0f || viewGroup.getTranslationX() == 0.0f) {
            this.f9615u = 0;
        }
        this.f9603g = 0;
        this.h = 0;
    }

    public final float m(float f8, boolean z) {
        float f9;
        Context context = this.f9597a;
        float f10 = f8 / context.getResources().getDisplayMetrics().density;
        if (z || this.f9615u != 1) {
            float fAbs = Math.abs(this.B / context.getResources().getDisplayMetrics().density);
            float fH = h();
            if (fAbs < 0.0f || fH <= 0.0f) {
                f9 = 0.0f;
            } else {
                float fMin = Math.min(fAbs, fH - 1.0E-5f);
                f9 = ((fH * fMin) / (fH - fMin)) / 1.0f;
            }
            this.A = Math.signum(-this.B) * f9;
        }
        float f11 = this.A + f10;
        this.A = f11;
        float fAbs2 = Math.abs(f11);
        float fH2 = h();
        float fApplyDimension = TypedValue.applyDimension(1, Math.signum(f11) * (-((((fAbs2 > 0.0f ? 1 : (fAbs2 == 0.0f ? 0 : -1)) < 0) || (fH2 <= 0.0f)) ? 0.0f : (1.0f - (1.0f / (((fAbs2 / fH2) * 1.0f) + 1.0f))) * fH2)), context.getResources().getDisplayMetrics());
        this.B = fApplyDimension;
        return fApplyDimension;
    }

    public final boolean n(MotionEvent motionEvent) {
        if (motionEvent != null && this.f9605j) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 5) {
                                this.f9602f = motionEvent.getPointerId(actionIndex);
                                k();
                                o(motionEvent, actionIndex);
                                return false;
                            }
                            if (actionMasked == 6) {
                                int actionIndex2 = motionEvent.getActionIndex();
                                if (motionEvent.getPointerId(actionIndex2) == this.f9602f) {
                                    int i10 = actionIndex2 != 0 ? 0 : 1;
                                    this.f9602f = motionEvent.getPointerId(i10);
                                    this.f9603g = (int) motionEvent.getRawX(i10);
                                    this.h = (int) motionEvent.getRawY(i10);
                                    return false;
                                }
                            }
                        }
                    } else {
                        if (this.f9603g == 0 && this.h == 0) {
                            o(motionEvent, actionIndex);
                            return false;
                        }
                        boolean z = this.f9605j;
                        ViewGroup viewGroup = this.f9598b;
                        if (z) {
                            f fVar = this.f9612q;
                            if (fVar != null && fVar.f9232f) {
                                fVar.f();
                            }
                            a aVar = this.f9599c;
                            if (aVar != null) {
                                aVar.a();
                            }
                            int iFindPointerIndex = motionEvent.findPointerIndex(this.f9602f);
                            if (iFindPointerIndex < 0) {
                                Log.w("SpringAnimationHelper", "Error processing scroll, pointer index for id " + this.f9602f + " not found. Did any MotionEvent get skipped?");
                                this.f9602f = motionEvent.getPointerId(0);
                                this.h = (int) motionEvent.getRawY();
                                this.f9603g = (int) motionEvent.getRawX();
                                iFindPointerIndex = 0;
                            }
                            if (this.f9604i == 0) {
                                DisplayMetrics displayMetrics = this.f9597a.getResources().getDisplayMetrics();
                                Pair pair = new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
                                int i11 = this.f9614t;
                                if (i11 == 1) {
                                    this.f9604i = ((Integer) pair.second).intValue();
                                } else if (i11 == 0) {
                                    this.f9604i = ((Integer) pair.first).intValue();
                                }
                            }
                            if (!this.z) {
                                g().g(this.f9614t != 1 ? 1 : 2, 0);
                            }
                            int rawY = this.h - ((int) motionEvent.getRawY(iFindPointerIndex));
                            int rawX = this.f9603g - ((int) motionEvent.getRawX(iFindPointerIndex));
                            int i12 = this.f9614t;
                            if (i12 == 1) {
                                if (rawY != 0) {
                                    boolean z3 = rawY < 0;
                                    if ((!z3 || this.f9606k) && (z3 || this.f9607l)) {
                                        float translationY = viewGroup.getTranslationY();
                                        boolean z10 = (z3 && translationY < 0.0f) || (!z3 && translationY > 0.0f);
                                        float fM = m(rawY, z10);
                                        if (z3) {
                                            boolean zB = b();
                                            if (zB && !z10) {
                                                this.B = 0.0f;
                                                this.A = 0.0f;
                                            }
                                            if (zB || z10) {
                                                fM = Math.min(0.0f, fM);
                                            }
                                        } else {
                                            boolean zC = c();
                                            if (zC && !z10) {
                                                this.B = 0.0f;
                                                this.A = 0.0f;
                                            }
                                            if (zC || z10) {
                                                fM = Math.max(0.0f, fM);
                                            }
                                        }
                                        viewGroup.setTranslationY(fM);
                                        if (Float.compare(fM, 0.0f) != 0 && Float.compare(this.f9616v, 0.0f) == 0) {
                                            this.f9615u = 1;
                                            e();
                                        }
                                        if (Float.compare(fM, 0.0f) != 0 || Float.compare(this.f9616v, 0.0f) != 0) {
                                            d(viewGroup.getTranslationX(), fM);
                                        }
                                        this.f9616v = fM;
                                    }
                                }
                            } else if (i12 == 0) {
                                char c9 = rawX < 0 ? (char) 65535 : (char) 1;
                                boolean zCanScrollHorizontally = viewGroup.canScrollHorizontally(-1);
                                boolean zCanScrollHorizontally2 = viewGroup.canScrollHorizontally(1);
                                float translationX = viewGroup.getTranslationX();
                                boolean z11 = (c9 == 1 && translationX > 0.0f) || (c9 == 65535 && translationX < 0.0f);
                                float fM2 = m(rawX, z11);
                                if (z11) {
                                    p(c9 == 1 ? Math.max(0.0f, fM2) : Math.min(0.0f, fM2));
                                } else if (c9 == 65535 && !zCanScrollHorizontally && this.f9608m) {
                                    p(fM2);
                                } else if (c9 == 1 && !zCanScrollHorizontally2 && this.f9609n) {
                                    p(fM2);
                                } else {
                                    this.B = 0.0f;
                                    this.A = 0.0f;
                                }
                            }
                            o(motionEvent, iFindPointerIndex);
                        }
                        if (viewGroup.getTranslationX() != 0.0f || viewGroup.getTranslationY() != 0.0f) {
                            return true;
                        }
                    }
                }
                l();
                return false;
            }
            this.f9602f = motionEvent.getPointerId(0);
            k();
            o(motionEvent, 0);
        }
        return false;
    }

    public final void o(MotionEvent motionEvent, int i10) {
        this.f9603g = (int) motionEvent.getRawX(i10);
        this.h = (int) motionEvent.getRawY(i10);
    }

    public final void p(float f8) {
        ViewGroup viewGroup = this.f9598b;
        viewGroup.setTranslationX(f8);
        if (f8 != 0.0f && this.f9616v == 0.0f) {
            this.f9615u = 1;
            e();
        }
        if (f8 != 0.0f || this.f9616v != 0.0f) {
            d(f8, viewGroup.getTranslationY());
        }
        this.f9616v = f8;
    }
}

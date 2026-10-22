package Xa;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1546a;
    public final ViewGroup b;
    public final d c;
    public OverScroller e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: q, reason: collision with root package name */
    public SpringAnimation f1548q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1549r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f1550s;

    /* renamed from: t, reason: collision with root package name */
    public int f1551t;

    /* renamed from: v, reason: collision with root package name */
    public float f1552v;
    public NestedScrollingChildHelper y;
    public float d = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1547j = true;
    public boolean k = true;
    public boolean l = true;
    public boolean m = true;
    public boolean n = true;
    public float o = 0.99f;
    public float p = 228.0f;
    public int u = 0;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f1553w = new int[2];

    /* renamed from: x, reason: collision with root package name */
    public final int[] f1554x = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public boolean f1555z = false;

    /* renamed from: A, reason: collision with root package name */
    public float f1543A = 0.0f;

    /* renamed from: B, reason: collision with root package name */
    public float f1544B = 0.0f;

    /* renamed from: C, reason: collision with root package name */
    public int f1545C = 0;

    public e(Context context, ViewGroup viewGroup, OverScroller overScroller, int i) {
        this.f1546a = context;
        this.b = viewGroup;
        this.f1551t = i;
        if (overScroller == null) {
            this.e = new OverScroller(context);
        } else {
            this.e = overScroller;
        }
        this.c = new d(this);
        this.f1549r = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public static void a(e eVar, float f, boolean z10) {
        if (eVar.f1547j) {
            if (Math.abs(f) >= eVar.f1549r) {
                eVar.i(z10).setStartVelocity(f * eVar.d).start();
                return;
            }
            Log.w("SpringAnimationHelper", "velocity minus minVelocity:" + eVar.f1549r);
        }
    }

    public final boolean b() {
        ViewGroup viewGroup = this.b;
        if (viewGroup.getTranslationY() == 0.0f) {
            int[] iArr = this.f1553w;
            iArr[1] = 0;
            int[] iArr2 = this.f1554x;
            iArr2[1] = 0;
            g().dispatchNestedScroll(0, 0, 0, -1, iArr, 0, iArr2);
            boolean z10 = iArr2[1] != 0;
            if (z10) {
                iArr[1] = 0;
                iArr2[1] = 0;
                g().dispatchNestedPreScroll(0, 1, iArr2, iArr, 0);
            }
            if (viewGroup.canScrollVertically(-1) || z10) {
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        int[] iArr = this.f1553w;
        iArr[1] = 0;
        int[] iArr2 = this.f1554x;
        iArr2[1] = 0;
        g().dispatchNestedPreScroll(0, 1, iArr2, iArr, 0);
        boolean z10 = iArr2[1] != 0;
        if (z10) {
            iArr[1] = 0;
            iArr2[1] = 0;
            g().dispatchNestedScroll(0, 0, 0, -1, iArr, 0, iArr2);
        }
        return this.b.canScrollVertically(1) || z10;
    }

    public final void d(float f, float f7) {
        ArrayList arrayList = this.f1550s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a) this.f1550s.get(size)).a(f7);
            }
        }
    }

    public final void e() {
        ArrayList arrayList = this.f1550s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a) this.f1550s.get(size)).b(this.u);
            }
        }
    }

    public final void f(int i, int i6) {
        if (this.f1547j) {
            if (Math.abs(i) >= this.f1549r || Math.abs(i6) >= this.f1549r) {
                if (i6 >= 0 || this.k) {
                    if (i6 <= 0 || this.l) {
                        if (i >= 0 || this.m) {
                            if (i <= 0 || this.n) {
                                SpringAnimation springAnimation = this.f1548q;
                                if (springAnimation != null && springAnimation.isRunning()) {
                                    Log.w("SpringAnimationHelper", "animation already running....");
                                    return;
                                }
                                d dVar = this.c;
                                if (dVar != null) {
                                    e eVar = dVar.c;
                                    dVar.f1542a = i;
                                    dVar.b = i6;
                                    eVar.e.fling(0, 0, i, i6, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                                    ViewGroup viewGroup = eVar.b;
                                    viewGroup.removeCallbacks(dVar);
                                    viewGroup.postOnAnimation(dVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final NestedScrollingChildHelper g() {
        if (this.y == null) {
            NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this.b);
            this.y = nestedScrollingChildHelper;
            nestedScrollingChildHelper.setNestedScrollingEnabled(true);
        }
        return this.y;
    }

    public final int h() {
        if (this.f1545C == 0) {
            int i = this.f1551t;
            ViewGroup viewGroup = this.b;
            this.f1545C = (int) ((i == 1 ? viewGroup.getHeight() : viewGroup.getWidth()) / this.f1546a.getResources().getDisplayMetrics().density);
        }
        return this.f1545C;
    }

    public final SpringAnimation i(boolean z10) {
        SpringAnimation spring = new SpringAnimation(this.b, z10 ? DynamicAnimation.TRANSLATION_Y : DynamicAnimation.TRANSLATION_X).setSpring(new SpringForce(0.0f).setDampingRatio(this.o).setStiffness(this.p));
        this.f1548q = spring;
        spring.addUpdateListener(new b(this, z10));
        this.f1548q.addEndListener(new c(this));
        this.u = 2;
        e();
        return this.f1548q;
    }

    public final boolean j() {
        int i = this.u;
        return i == 1 || i == 2;
    }

    public final void k() {
        d dVar = this.c;
        if (dVar != null) {
            dVar.a();
        }
        SpringAnimation springAnimation = this.f1548q;
        if (springAnimation != null && springAnimation.isRunning()) {
            this.f1548q.cancel();
        }
        g().startNestedScroll(this.f1551t == 1 ? 2 : 1, 0);
        this.f1555z = true;
    }

    public final void l() {
        g().stopNestedScroll(0);
        this.f1555z = false;
        ViewGroup viewGroup = this.b;
        if (viewGroup.getTranslationY() != 0.0f) {
            i(true).start();
        } else if (viewGroup.getTranslationX() != 0.0f) {
            i(false).start();
        } else if (viewGroup.getTranslationY() == 0.0f || viewGroup.getTranslationX() == 0.0f) {
            this.u = 0;
        }
        this.g = 0;
        this.h = 0;
    }

    public final float m(float f, boolean z10) {
        float f7;
        Context context = this.f1546a;
        float f9 = f / context.getResources().getDisplayMetrics().density;
        if (z10 || this.u != 1) {
            float fAbs = Math.abs(this.f1544B / context.getResources().getDisplayMetrics().density);
            float fH = h();
            if (fAbs < 0.0f || fH <= 0.0f) {
                f7 = 0.0f;
            } else {
                float fMin = Math.min(fAbs, fH - 1.0E-5f);
                f7 = ((fH * fMin) / (fH - fMin)) / 1.0f;
            }
            this.f1543A = Math.signum(-this.f1544B) * f7;
        }
        float f10 = this.f1543A + f9;
        this.f1543A = f10;
        float fAbs2 = Math.abs(f10);
        float fH2 = h();
        float fApplyDimension = TypedValue.applyDimension(1, Math.signum(f10) * (-((((fAbs2 > 0.0f ? 1 : (fAbs2 == 0.0f ? 0 : -1)) < 0) || (fH2 <= 0.0f)) ? 0.0f : (1.0f - (1.0f / (((fAbs2 / fH2) * 1.0f) + 1.0f))) * fH2)), context.getResources().getDisplayMetrics());
        this.f1544B = fApplyDimension;
        return fApplyDimension;
    }

    public final boolean n(MotionEvent motionEvent) {
        if (motionEvent != null && this.f1547j) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 5) {
                                this.f = motionEvent.getPointerId(actionIndex);
                                k();
                                o(motionEvent, actionIndex);
                                return false;
                            }
                            if (actionMasked == 6) {
                                int actionIndex2 = motionEvent.getActionIndex();
                                if (motionEvent.getPointerId(actionIndex2) == this.f) {
                                    int i = actionIndex2 != 0 ? 0 : 1;
                                    this.f = motionEvent.getPointerId(i);
                                    this.g = (int) motionEvent.getRawX(i);
                                    this.h = (int) motionEvent.getRawY(i);
                                    return false;
                                }
                            }
                        }
                    } else {
                        if (this.g == 0 && this.h == 0) {
                            o(motionEvent, actionIndex);
                            return false;
                        }
                        boolean z10 = this.f1547j;
                        ViewGroup viewGroup = this.b;
                        if (z10) {
                            SpringAnimation springAnimation = this.f1548q;
                            if (springAnimation != null && springAnimation.isRunning()) {
                                this.f1548q.cancel();
                            }
                            d dVar = this.c;
                            if (dVar != null) {
                                dVar.a();
                            }
                            int iFindPointerIndex = motionEvent.findPointerIndex(this.f);
                            if (iFindPointerIndex < 0) {
                                Log.w("SpringAnimationHelper", "Error processing scroll, pointer index for id " + this.f + " not found. Did any MotionEvent get skipped?");
                                this.f = motionEvent.getPointerId(0);
                                this.h = (int) motionEvent.getRawY();
                                this.g = (int) motionEvent.getRawX();
                                iFindPointerIndex = 0;
                            }
                            if (this.i == 0) {
                                DisplayMetrics displayMetrics = this.f1546a.getResources().getDisplayMetrics();
                                Pair pair = new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
                                int i6 = this.f1551t;
                                if (i6 == 1) {
                                    this.i = ((Integer) pair.second).intValue();
                                } else if (i6 == 0) {
                                    this.i = ((Integer) pair.first).intValue();
                                }
                            }
                            if (!this.f1555z) {
                                g().startNestedScroll(this.f1551t != 1 ? 1 : 2, 0);
                            }
                            int rawY = this.h - ((int) motionEvent.getRawY(iFindPointerIndex));
                            int rawX = this.g - ((int) motionEvent.getRawX(iFindPointerIndex));
                            int i10 = this.f1551t;
                            if (i10 == 1) {
                                if (rawY != 0) {
                                    boolean z11 = rawY < 0;
                                    if ((!z11 || this.k) && (z11 || this.l)) {
                                        float translationY = viewGroup.getTranslationY();
                                        boolean z12 = (z11 && translationY < 0.0f) || (!z11 && translationY > 0.0f);
                                        float fM = m(rawY, z12);
                                        if (z11) {
                                            boolean zB = b();
                                            if (zB && !z12) {
                                                this.f1544B = 0.0f;
                                                this.f1543A = 0.0f;
                                            }
                                            if (zB || z12) {
                                                fM = Math.min(0.0f, fM);
                                            }
                                        } else {
                                            boolean zC = c();
                                            if (zC && !z12) {
                                                this.f1544B = 0.0f;
                                                this.f1543A = 0.0f;
                                            }
                                            if (zC || z12) {
                                                fM = Math.max(0.0f, fM);
                                            }
                                        }
                                        viewGroup.setTranslationY(fM);
                                        if (Float.compare(fM, 0.0f) != 0 && Float.compare(this.f1552v, 0.0f) == 0) {
                                            this.u = 1;
                                            e();
                                        }
                                        if (Float.compare(fM, 0.0f) != 0 || Float.compare(this.f1552v, 0.0f) != 0) {
                                            d(viewGroup.getTranslationX(), fM);
                                        }
                                        this.f1552v = fM;
                                    }
                                }
                            } else if (i10 == 0) {
                                char c = rawX < 0 ? (char) 65535 : (char) 1;
                                boolean zCanScrollHorizontally = viewGroup.canScrollHorizontally(-1);
                                boolean zCanScrollHorizontally2 = viewGroup.canScrollHorizontally(1);
                                float translationX = viewGroup.getTranslationX();
                                boolean z13 = (c == 1 && translationX > 0.0f) || (c == 65535 && translationX < 0.0f);
                                float fM2 = m(rawX, z13);
                                if (z13) {
                                    p(c == 1 ? Math.max(0.0f, fM2) : Math.min(0.0f, fM2));
                                } else if (c == 65535 && !zCanScrollHorizontally && this.m) {
                                    p(fM2);
                                } else if (c == 1 && !zCanScrollHorizontally2 && this.n) {
                                    p(fM2);
                                } else {
                                    this.f1544B = 0.0f;
                                    this.f1543A = 0.0f;
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
            this.f = motionEvent.getPointerId(0);
            k();
            o(motionEvent, 0);
        }
        return false;
    }

    public final void o(MotionEvent motionEvent, int i) {
        this.g = (int) motionEvent.getRawX(i);
        this.h = (int) motionEvent.getRawY(i);
    }

    public final void p(float f) {
        ViewGroup viewGroup = this.b;
        viewGroup.setTranslationX(f);
        if (f != 0.0f && this.f1552v == 0.0f) {
            this.u = 1;
            e();
        }
        if (f != 0.0f || this.f1552v != 0.0f) {
            d(f, viewGroup.getTranslationY());
        }
        this.f1552v = f;
    }
}

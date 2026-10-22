package ve;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import com.google.android.material.appbar.k;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n3.k0;
import n3.p;
import z3.g;
import z3.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14923a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewGroup f14924b;

    /* renamed from: c, reason: collision with root package name */
    public final c f14925c;

    /* renamed from: e, reason: collision with root package name */
    public final OverScroller f14927e;

    /* renamed from: f, reason: collision with root package name */
    public int f14928f;

    /* renamed from: g, reason: collision with root package name */
    public int f14929g;

    /* renamed from: h, reason: collision with root package name */
    public int f14930h;
    public int i;

    /* renamed from: q, reason: collision with root package name */
    public g f14938q;

    /* renamed from: r, reason: collision with root package name */
    public final int f14939r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f14940s;

    /* renamed from: t, reason: collision with root package name */
    public int f14941t;

    /* renamed from: v, reason: collision with root package name */
    public float f14943v;

    /* renamed from: y, reason: collision with root package name */
    public p f14946y;

    /* renamed from: d, reason: collision with root package name */
    public float f14926d = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14931j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14932k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14933l = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14934m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14935n = true;

    /* renamed from: o, reason: collision with root package name */
    public float f14936o = 0.99f;

    /* renamed from: p, reason: collision with root package name */
    public float f14937p = 228.0f;

    /* renamed from: u, reason: collision with root package name */
    public int f14942u = 0;

    /* renamed from: w, reason: collision with root package name */
    public final int[] f14944w = new int[2];

    /* renamed from: x, reason: collision with root package name */
    public final int[] f14945x = new int[2];

    /* renamed from: z, reason: collision with root package name */
    public boolean f14947z = false;
    public float A = 0.0f;
    public float B = 0.0f;
    public int C = 0;

    public d(Context context, ViewGroup viewGroup, OverScroller overScroller, int i) {
        this.f14923a = context;
        this.f14924b = viewGroup;
        this.f14941t = i;
        if (overScroller == null) {
            this.f14927e = new OverScroller(context);
        } else {
            this.f14927e = overScroller;
        }
        c cVar = new c();
        cVar.f14922g = this;
        this.f14927e = new OverScroller(context);
        VarHandle.storeStoreFence();
        this.f14925c = cVar;
        this.f14939r = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public static void a(d dVar, float f5, boolean z10) {
        if (dVar.f14931j) {
            if (Math.abs(f5) < dVar.f14939r) {
                Log.w("SpringAnimationHelper", "velocity minus minVelocity:" + dVar.f14939r);
            } else {
                g gVarI = dVar.i(z10);
                gVarI.f16360a = f5 * dVar.f14926d;
                gVarI.g();
            }
        }
    }

    public final boolean b() {
        ViewGroup viewGroup = this.f14924b;
        if (viewGroup.getTranslationY() == 0.0f) {
            int[] iArr = this.f14944w;
            iArr[1] = 0;
            int[] iArr2 = this.f14945x;
            iArr2[1] = 0;
            g().d(0, 0, 0, -1, iArr, 0, iArr2);
            boolean z10 = iArr2[1] != 0;
            if (z10) {
                iArr[1] = 0;
                iArr2[1] = 0;
                g().c(0, 1, iArr2, iArr, 0);
            }
            if (viewGroup.canScrollVertically(-1) || z10) {
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        int[] iArr = this.f14944w;
        iArr[1] = 0;
        int[] iArr2 = this.f14945x;
        iArr2[1] = 0;
        g().c(0, 1, iArr2, iArr, 0);
        boolean z10 = iArr2[1] != 0;
        if (z10) {
            iArr[1] = 0;
            iArr2[1] = 0;
            g().d(0, 0, 0, -1, iArr, 0, iArr2);
        }
        return this.f14924b.canScrollVertically(1) || z10;
    }

    public final void d(float f5, float f10) {
        ArrayList arrayList = this.f14940s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a) this.f14940s.get(size)).a(f10);
            }
        }
    }

    public final void e() {
        ArrayList arrayList = this.f14940s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a) this.f14940s.get(size)).b(this.f14942u);
            }
        }
    }

    public final void f(int i, int i3) {
        if (this.f14931j) {
            if (Math.abs(i) >= this.f14939r || Math.abs(i3) >= this.f14939r) {
                if (i3 >= 0 || this.f14932k) {
                    if (i3 <= 0 || this.f14933l) {
                        if (i >= 0 || this.f14934m) {
                            if (i <= 0 || this.f14935n) {
                                g gVar = this.f14938q;
                                if (gVar != null && gVar.f16365f) {
                                    Log.w("SpringAnimationHelper", "animation already running....");
                                    return;
                                }
                                c cVar = this.f14925c;
                                if (cVar != null) {
                                    d dVar = cVar.f14922g;
                                    cVar.f14920c = i;
                                    cVar.f14921f = i3;
                                    dVar.f14927e.fling(0, 0, i, i3, Integer.MIN_VALUE, Reader.READ_DONE, Integer.MIN_VALUE, Reader.READ_DONE);
                                    ViewGroup viewGroup = dVar.f14924b;
                                    viewGroup.removeCallbacks(cVar);
                                    viewGroup.postOnAnimation(cVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final p g() {
        if (this.f14946y == null) {
            ViewGroup viewGroup = this.f14924b;
            p pVar = new p(viewGroup);
            this.f14946y = pVar;
            if (pVar.f8743d) {
                WeakHashMap weakHashMap = k0.f8724a;
                viewGroup.stopNestedScroll();
            }
            pVar.f8743d = true;
        }
        return this.f14946y;
    }

    public final int h() {
        if (this.C == 0) {
            int i = this.f14941t;
            ViewGroup viewGroup = this.f14924b;
            this.C = (int) ((i == 1 ? viewGroup.getHeight() : viewGroup.getWidth()) / this.f14923a.getResources().getDisplayMetrics().density);
        }
        return this.C;
    }

    public final g i(boolean z10) {
        h hVar = new h(0.0f);
        hVar.a(this.f14936o);
        hVar.b(this.f14937p);
        g gVar = new g(this.f14924b, z10 ? g.f16353o : g.f16352n);
        gVar.f16369k = hVar;
        this.f14938q = gVar;
        b bVar = new b();
        bVar.f14919b = this;
        bVar.f14918a = z10;
        VarHandle.storeStoreFence();
        gVar.a(bVar);
        g gVar2 = this.f14938q;
        k kVar = new k(1);
        kVar.f2374b = this;
        VarHandle.storeStoreFence();
        ArrayList arrayList = gVar2.i;
        if (!arrayList.contains(kVar)) {
            arrayList.add(kVar);
        }
        this.f14942u = 2;
        e();
        return this.f14938q;
    }

    public final boolean j() {
        int i = this.f14942u;
        return i == 1 || i == 2;
    }

    public final void k() {
        c cVar = this.f14925c;
        if (cVar != null) {
            cVar.a();
        }
        g gVar = this.f14938q;
        if (gVar != null && gVar.f16365f) {
            gVar.b();
        }
        g().g(this.f14941t == 1 ? 2 : 1, 0);
        this.f14947z = true;
    }

    public final void l() {
        g().h(0);
        this.f14947z = false;
        ViewGroup viewGroup = this.f14924b;
        if (viewGroup.getTranslationY() != 0.0f) {
            i(true).g();
        } else if (viewGroup.getTranslationX() != 0.0f) {
            i(false).g();
        } else if (viewGroup.getTranslationY() == 0.0f || viewGroup.getTranslationX() == 0.0f) {
            this.f14942u = 0;
        }
        this.f14929g = 0;
        this.f14930h = 0;
    }

    public final float m(float f5, boolean z10) {
        float f10;
        Context context = this.f14923a;
        float f11 = f5 / context.getResources().getDisplayMetrics().density;
        if (z10 || this.f14942u != 1) {
            float fAbs = Math.abs(this.B / context.getResources().getDisplayMetrics().density);
            float fH = h();
            if (fAbs < 0.0f || fH <= 0.0f) {
                f10 = 0.0f;
            } else {
                float fMin = Math.min(fAbs, fH - 1.0E-5f);
                f10 = ((fH * fMin) / (fH - fMin)) / 1.0f;
            }
            this.A = Math.signum(-this.B) * f10;
        }
        float f12 = this.A + f11;
        this.A = f12;
        float fAbs2 = Math.abs(f12);
        float fH2 = h();
        float fApplyDimension = TypedValue.applyDimension(1, Math.signum(f12) * (-((((fAbs2 > 0.0f ? 1 : (fAbs2 == 0.0f ? 0 : -1)) < 0) || (fH2 <= 0.0f)) ? 0.0f : (1.0f - (1.0f / (((fAbs2 / fH2) * 1.0f) + 1.0f))) * fH2)), context.getResources().getDisplayMetrics());
        this.B = fApplyDimension;
        return fApplyDimension;
    }

    public final boolean n(MotionEvent motionEvent) {
        if (motionEvent != null && this.f14931j) {
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 5) {
                                this.f14928f = motionEvent.getPointerId(actionIndex);
                                k();
                                o(motionEvent, actionIndex);
                                return false;
                            }
                            if (actionMasked == 6) {
                                int actionIndex2 = motionEvent.getActionIndex();
                                if (motionEvent.getPointerId(actionIndex2) == this.f14928f) {
                                    int i = actionIndex2 != 0 ? 0 : 1;
                                    this.f14928f = motionEvent.getPointerId(i);
                                    this.f14929g = (int) motionEvent.getRawX(i);
                                    this.f14930h = (int) motionEvent.getRawY(i);
                                    return false;
                                }
                            }
                        }
                    } else {
                        if (this.f14929g == 0 && this.f14930h == 0) {
                            o(motionEvent, actionIndex);
                            return false;
                        }
                        boolean z10 = this.f14931j;
                        ViewGroup viewGroup = this.f14924b;
                        if (z10) {
                            g gVar = this.f14938q;
                            if (gVar != null && gVar.f16365f) {
                                gVar.b();
                            }
                            c cVar = this.f14925c;
                            if (cVar != null) {
                                cVar.a();
                            }
                            int iFindPointerIndex = motionEvent.findPointerIndex(this.f14928f);
                            if (iFindPointerIndex < 0) {
                                Log.w("SpringAnimationHelper", "Error processing scroll, pointer index for id " + this.f14928f + " not found. Did any MotionEvent get skipped?");
                                this.f14928f = motionEvent.getPointerId(0);
                                this.f14930h = (int) motionEvent.getRawY();
                                this.f14929g = (int) motionEvent.getRawX();
                                iFindPointerIndex = 0;
                            }
                            if (this.i == 0) {
                                DisplayMetrics displayMetrics = this.f14923a.getResources().getDisplayMetrics();
                                Pair pair = new Pair(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
                                int i3 = this.f14941t;
                                if (i3 == 1) {
                                    this.i = ((Integer) pair.second).intValue();
                                } else if (i3 == 0) {
                                    this.i = ((Integer) pair.first).intValue();
                                }
                            }
                            if (!this.f14947z) {
                                g().g(this.f14941t != 1 ? 1 : 2, 0);
                            }
                            int rawY = this.f14930h - ((int) motionEvent.getRawY(iFindPointerIndex));
                            int rawX = this.f14929g - ((int) motionEvent.getRawX(iFindPointerIndex));
                            int i10 = this.f14941t;
                            if (i10 == 1) {
                                if (rawY != 0) {
                                    boolean z11 = rawY < 0;
                                    if ((!z11 || this.f14932k) && (z11 || this.f14933l)) {
                                        float translationY = viewGroup.getTranslationY();
                                        boolean z12 = (z11 && translationY < 0.0f) || (!z11 && translationY > 0.0f);
                                        float fM = m(rawY, z12);
                                        if (z11) {
                                            boolean zB = b();
                                            if (zB && !z12) {
                                                this.B = 0.0f;
                                                this.A = 0.0f;
                                            }
                                            if (zB || z12) {
                                                fM = Math.min(0.0f, fM);
                                            }
                                        } else {
                                            boolean zC = c();
                                            if (zC && !z12) {
                                                this.B = 0.0f;
                                                this.A = 0.0f;
                                            }
                                            if (zC || z12) {
                                                fM = Math.max(0.0f, fM);
                                            }
                                        }
                                        viewGroup.setTranslationY(fM);
                                        if (Float.compare(fM, 0.0f) != 0 && Float.compare(this.f14943v, 0.0f) == 0) {
                                            this.f14942u = 1;
                                            e();
                                        }
                                        if (Float.compare(fM, 0.0f) != 0 || Float.compare(this.f14943v, 0.0f) != 0) {
                                            d(viewGroup.getTranslationX(), fM);
                                        }
                                        this.f14943v = fM;
                                    }
                                }
                            } else if (i10 == 0) {
                                char c9 = rawX < 0 ? (char) 65535 : (char) 1;
                                boolean zCanScrollHorizontally = viewGroup.canScrollHorizontally(-1);
                                boolean zCanScrollHorizontally2 = viewGroup.canScrollHorizontally(1);
                                float translationX = viewGroup.getTranslationX();
                                boolean z13 = (c9 == 1 && translationX > 0.0f) || (c9 == 65535 && translationX < 0.0f);
                                float fM2 = m(rawX, z13);
                                if (z13) {
                                    p(c9 == 1 ? Math.max(0.0f, fM2) : Math.min(0.0f, fM2));
                                } else if (c9 == 65535 && !zCanScrollHorizontally && this.f14934m) {
                                    p(fM2);
                                } else if (c9 == 1 && !zCanScrollHorizontally2 && this.f14935n) {
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
            this.f14928f = motionEvent.getPointerId(0);
            k();
            o(motionEvent, 0);
        }
        return false;
    }

    public final void o(MotionEvent motionEvent, int i) {
        this.f14929g = (int) motionEvent.getRawX(i);
        this.f14930h = (int) motionEvent.getRawY(i);
    }

    public final void p(float f5) {
        ViewGroup viewGroup = this.f14924b;
        viewGroup.setTranslationX(f5);
        if (f5 != 0.0f && this.f14943v == 0.0f) {
            this.f14942u = 1;
            e();
        }
        if (f5 != 0.0f || this.f14943v != 0.0f) {
            d(f5, viewGroup.getTranslationY());
        }
        this.f14943v = f5;
    }
}

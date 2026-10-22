package r2;

import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.x;
import com.stepos.agentsafetycenter.R;
import h0.l0;
import java.lang.invoke.VarHandle;
import kc.w;
import m8.j0;
import n3.j1;
import n3.m1;
import n3.r;
import n3.s;
import s1.v0;
import u1.g0;
import u1.n1;
import u1.o1;
import u1.p1;
import v1.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h extends ViewGroup implements r, k0.k, o1, s {
    public l0 A;
    public boolean B;
    public g0 C;

    /* renamed from: c, reason: collision with root package name */
    public n1.d f10387c;

    /* renamed from: f, reason: collision with root package name */
    public View f10388f;

    /* renamed from: g, reason: collision with root package name */
    public n1 f10389g;

    /* renamed from: h, reason: collision with root package name */
    public xb.a f10390h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public xb.a f10391j;

    /* renamed from: k, reason: collision with root package name */
    public xb.a f10392k;

    /* renamed from: l, reason: collision with root package name */
    public w0.m f10393l;

    /* renamed from: m, reason: collision with root package name */
    public xb.l f10394m;

    /* renamed from: n, reason: collision with root package name */
    public o2.c f10395n;

    /* renamed from: o, reason: collision with root package name */
    public xb.l f10396o;

    /* renamed from: p, reason: collision with root package name */
    public x f10397p;

    /* renamed from: q, reason: collision with root package name */
    public t4.f f10398q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f10399r;

    /* renamed from: s, reason: collision with root package name */
    public long f10400s;

    /* renamed from: t, reason: collision with root package name */
    public m1 f10401t;

    /* renamed from: u, reason: collision with root package name */
    public g f10402u;

    /* renamed from: v, reason: collision with root package name */
    public g f10403v;

    /* renamed from: w, reason: collision with root package name */
    public xb.l f10404w;

    /* renamed from: x, reason: collision with root package name */
    public int[] f10405x;

    /* renamed from: y, reason: collision with root package name */
    public int f10406y;

    /* renamed from: z, reason: collision with root package name */
    public int f10407z;

    public static final int d(q qVar, int i, int i3, int i10) {
        return (i10 >= 0 || i == i3) ? View.MeasureSpec.makeMeasureSpec(p5.f.q(i10, i, i3), 1073741824) : (i10 != -2 || i3 == Integer.MAX_VALUE) ? (i10 != -1 || i3 == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    public static f3.b e(f3.b bVar, int i, int i3, int i10, int i11) {
        int i12 = bVar.f3900a - i;
        if (i12 < 0) {
            i12 = 0;
        }
        int i13 = bVar.f3901b - i3;
        if (i13 < 0) {
            i13 = 0;
        }
        int i14 = bVar.f3902c - i10;
        if (i14 < 0) {
            i14 = 0;
        }
        int i15 = bVar.f3903d - i11;
        return f3.b.a(i12, i13, i14, i15 >= 0 ? i15 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p1 getSnapshotObserver() {
        if (!isAttachedToWindow()) {
            r1.a.b("Expected AndroidViewHolder to be attached when observing reads.");
        }
        return ((t) this.f10389g).getSnapshotObserver();
    }

    @Override // k0.k
    public final void a() {
        this.f10392k.invoke();
    }

    @Override // k0.k
    public final void b() {
        this.f10391j.invoke();
        removeAllViewsInLayout();
    }

    public final m1 f(m1 m1Var) {
        j1 j1Var = m1Var.f8737a;
        f3.b bVarI = j1Var.i(-1);
        f3.b bVar = f3.b.f3899e;
        if (!bVarI.equals(bVar) || !j1Var.j(-9).equals(bVar) || j1Var.h() != null) {
            u1.s sVar = this.C.H.f13743c;
            if (sVar.R.f15126r) {
                long jH = td.h.H(sVar.D(0L));
                int i = (int) (jH >> 32);
                if (i < 0) {
                    i = 0;
                }
                int i3 = (int) (jH & 4294967295L);
                if (i3 < 0) {
                    i3 = 0;
                }
                long jL = v0.i(sVar).l();
                int i10 = (int) (jL >> 32);
                int i11 = (int) (jL & 4294967295L);
                long j10 = sVar.f11279g;
                long jH2 = td.h.H(sVar.D((Float.floatToRawIntBits((int) (j10 >> 32)) << 32) | (Float.floatToRawIntBits((int) (j10 & 4294967295L)) & 4294967295L)));
                int i12 = i10 - ((int) (jH2 >> 32));
                if (i12 < 0) {
                    i12 = 0;
                }
                int i13 = i11 - ((int) (4294967295L & jH2));
                int i14 = i13 >= 0 ? i13 : 0;
                if (i != 0 || i3 != 0 || i12 != 0 || i14 != 0) {
                    return m1Var.f8737a.r(i, i3, i12, i14);
                }
            }
        }
        return m1Var;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean gatherTransparentRegion(Region region) {
        int[] iArr = this.f10405x;
        if (region == null) {
            return true;
        }
        getLocationInWindow(iArr);
        int i = iArr[0];
        region.op(i, iArr[1], getWidth() + i, getHeight() + iArr[1], Region.Op.DIFFERENCE);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return getClass().getName();
    }

    public final o2.c getDensity() {
        return this.f10395n;
    }

    public final View getInteropView() {
        return this.f10388f;
    }

    public final g0 getLayoutNode() {
        return this.C;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.f10388f.getLayoutParams();
        return layoutParams == null ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public final x getLifecycleOwner() {
        return this.f10397p;
    }

    public final w0.m getModifier() {
        return this.f10393l;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        l0 l0Var = this.A;
        return l0Var.f5053b | l0Var.f5052a;
    }

    public final xb.l getOnDensityChanged$ui_release() {
        return this.f10396o;
    }

    public final xb.l getOnModifierChanged$ui_release() {
        return this.f10394m;
    }

    public final xb.l getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.f10404w;
    }

    public final xb.a getRelease() {
        return this.f10392k;
    }

    public final xb.a getReset() {
        return this.f10391j;
    }

    public final t4.f getSavedStateRegistryOwner() {
        return this.f10398q;
    }

    public final xb.a getUpdate() {
        return this.f10390h;
    }

    public final View getView() {
        return this.f10388f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        if (!this.B) {
            this.C.A();
            return null;
        }
        View view = this.f10388f;
        g gVar = this.f10403v;
        a4.t tVar = new a4.t(21);
        tVar.f200f = gVar;
        VarHandle.storeStoreFence();
        view.postOnAnimation(tVar);
        return null;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f10388f.isNestedScrollingEnabled();
    }

    @Override // n3.q
    public final void j(int i, View view) {
        l0 l0Var = this.A;
        if (i == 1) {
            l0Var.f5053b = 0;
        } else {
            l0Var.f5052a = 0;
        }
    }

    @Override // n3.r
    public final void k(View view, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        if (this.f10388f.isNestedScrollingEnabled()) {
            n1.d dVar = this.f10387c;
            float f5 = i;
            float f10 = -1;
            long jFloatToRawIntBits = (Float.floatToRawIntBits(f5 * f10) << 32) | (Float.floatToRawIntBits(i3 * f10) & 4294967295L);
            long jFloatToRawIntBits2 = (Float.floatToRawIntBits(i10 * f10) << 32) | (Float.floatToRawIntBits(i11 * f10) & 4294967295L);
            int i13 = i12 == 0 ? 1 : 2;
            n1.g gVar = dVar.f8626a;
            n1.g gVar2 = null;
            if (gVar != null && gVar.f15126r) {
                gVar2 = (n1.g) u1.f.j(gVar);
            }
            n1.g gVar3 = gVar2;
            long jD0 = gVar3 != null ? gVar3.d0(i13, jFloatToRawIntBits, jFloatToRawIntBits2) : 0L;
            iArr[0] = v1.g0.m(Float.intBitsToFloat((int) (jD0 >> 32)));
            iArr[1] = v1.g0.m(Float.intBitsToFloat((int) (jD0 & 4294967295L)));
        }
    }

    @Override // n3.q
    public final void l(View view, int i, int i3, int i10, int i11, int i12) {
        if (this.f10388f.isNestedScrollingEnabled()) {
            n1.d dVar = this.f10387c;
            float f5 = i;
            float f10 = -1;
            long jFloatToRawIntBits = (Float.floatToRawIntBits(f5 * f10) << 32) | (Float.floatToRawIntBits(i3 * f10) & 4294967295L);
            long jFloatToRawIntBits2 = (Float.floatToRawIntBits(i10 * f10) << 32) | (Float.floatToRawIntBits(i11 * f10) & 4294967295L);
            int i13 = i12 == 0 ? 1 : 2;
            n1.g gVar = dVar.f8626a;
            n1.g gVar2 = null;
            if (gVar != null && gVar.f15126r) {
                gVar2 = (n1.g) u1.f.j(gVar);
            }
            n1.g gVar3 = gVar2;
            if (gVar3 != null) {
                gVar3.d0(i13, jFloatToRawIntBits, jFloatToRawIntBits2);
            }
        }
    }

    @Override // n3.q
    public final boolean m(View view, View view2, int i, int i3) {
        return ((i & 2) == 0 && (i & 1) == 0) ? false : true;
    }

    @Override // n3.q
    public final void n(View view, View view2, int i, int i3) {
        l0 l0Var = this.A;
        if (i3 == 1) {
            l0Var.f5053b = i;
        } else {
            l0Var.f5052a = i;
        }
    }

    @Override // u1.o1
    public final boolean o() {
        return isAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10402u.invoke();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        if (!this.B) {
            this.C.A();
            return;
        }
        View view3 = this.f10388f;
        g gVar = this.f10403v;
        a4.t tVar = new a4.t(21);
        tVar.f200f = gVar;
        VarHandle.storeStoreFence();
        view3.postOnAnimation(tVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDetachedFromWindow() {
        /*
            r22 = this;
            r0 = r22
            super.onDetachedFromWindow()
            u1.p1 r1 = r0.getSnapshotObserver()
            u0.t r1 = r1.f13895a
            java.lang.Object r2 = r1.f13706g
            monitor-enter(r2)
            m0.e r1 = r1.f13705f     // Catch: java.lang.Throwable -> L96
            int r3 = r1.f8160g     // Catch: java.lang.Throwable -> L96
            r5 = 0
            r6 = 0
        L14:
            java.lang.Object[] r7 = r1.f8158c
            if (r5 >= r3) goto L9c
            r7 = r7[r5]     // Catch: java.lang.Throwable -> L96
            u0.s r7 = (u0.s) r7     // Catch: java.lang.Throwable -> L96
            p.f0 r8 = r7.f13694f     // Catch: java.lang.Throwable -> L96
            java.lang.Object r8 = r8.k(r0)     // Catch: java.lang.Throwable -> L96
            p.z r8 = (p.z) r8     // Catch: java.lang.Throwable -> L96
            if (r8 != 0) goto L29
        L26:
            r16 = r5
            goto L80
        L29:
            java.lang.Object[] r9 = r8.f9651b     // Catch: java.lang.Throwable -> L96
            int[] r10 = r8.f9652c     // Catch: java.lang.Throwable -> L96
            long[] r8 = r8.f9650a     // Catch: java.lang.Throwable -> L96
            int r11 = r8.length     // Catch: java.lang.Throwable -> L96
            int r11 = r11 + (-2)
            if (r11 < 0) goto L26
            r12 = 0
        L35:
            r13 = r8[r12]     // Catch: java.lang.Throwable -> L96
            r16 = r5
            long r4 = ~r13     // Catch: java.lang.Throwable -> L96
            r17 = 7
            long r4 = r4 << r17
            long r4 = r4 & r13
            r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r4 = r4 & r17
            int r4 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r4 == 0) goto L79
            int r4 = r12 - r11
            int r4 = ~r4     // Catch: java.lang.Throwable -> L96
            int r4 = r4 >>> 31
            r5 = 8
            int r4 = 8 - r4
            r15 = 0
        L54:
            if (r15 >= r4) goto L77
            r18 = 255(0xff, double:1.26E-321)
            long r18 = r13 & r18
            r20 = 128(0x80, double:6.3E-322)
            int r18 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r18 >= 0) goto L6e
            int r18 = r12 << 3
            int r18 = r18 + r15
            r19 = r5
            r5 = r9[r18]     // Catch: java.lang.Throwable -> L96
            r18 = r10[r18]     // Catch: java.lang.Throwable -> L96
            r7.d(r0, r5)     // Catch: java.lang.Throwable -> L96
            goto L70
        L6e:
            r19 = r5
        L70:
            long r13 = r13 >> r19
            int r15 = r15 + 1
            r5 = r19
            goto L54
        L77:
            if (r4 != r5) goto L80
        L79:
            if (r12 == r11) goto L80
            int r12 = r12 + 1
            r5 = r16
            goto L35
        L80:
            p.f0 r4 = r7.f13694f     // Catch: java.lang.Throwable -> L96
            boolean r4 = r4.j()     // Catch: java.lang.Throwable -> L96
            if (r4 != 0) goto L8b
            int r6 = r6 + 1
            goto L98
        L8b:
            if (r6 <= 0) goto L98
            java.lang.Object[] r4 = r1.f8158c     // Catch: java.lang.Throwable -> L96
            int r5 = r16 - r6
            r7 = r4[r16]     // Catch: java.lang.Throwable -> L96
            r4[r5] = r7     // Catch: java.lang.Throwable -> L96
            goto L98
        L96:
            r0 = move-exception
            goto La6
        L98:
            int r5 = r16 + 1
            goto L14
        L9c:
            int r0 = r3 - r6
            r4 = 0
            java.util.Arrays.fill(r7, r0, r3, r4)     // Catch: java.lang.Throwable -> L96
            r1.f8160g = r0     // Catch: java.lang.Throwable -> L96
            monitor-exit(r2)
            return
        La6:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.h.onDetachedFromWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        this.f10388f.layout(0, 0, i10 - i, i11 - i3);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        View view = this.f10388f;
        if (view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i3));
            return;
        }
        if (view.getVisibility() == 8) {
            setMeasuredDimension(0, 0);
            return;
        }
        view.measure(i, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        this.f10406y = i;
        this.f10407z = i3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f10, boolean z10) {
        if (!this.f10388f.isNestedScrollingEnabled()) {
            return false;
        }
        w.u(this.f10387c.c(), null, null, new e(z10, this, h5.t.f(f5 * (-1.0f), f10 * (-1.0f)), null), 3);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f10) {
        if (!this.f10388f.isNestedScrollingEnabled()) {
            return false;
        }
        w.u(this.f10387c.c(), null, null, new j0(this, h5.t.f(f5 * (-1.0f), f10 * (-1.0f)), null, 2), 3);
        return false;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    @Override // n3.s
    public final m1 p(View view, m1 m1Var) {
        this.f10401t = new m1(m1Var);
        return f(m1Var);
    }

    @Override // n3.q
    public final void q(View view, int i, int i3, int[] iArr, int i10) {
        if (this.f10388f.isNestedScrollingEnabled()) {
            n1.d dVar = this.f10387c;
            float f5 = i;
            float f10 = -1;
            long jFloatToRawIntBits = (Float.floatToRawIntBits(f5 * f10) << 32) | (Float.floatToRawIntBits(i3 * f10) & 4294967295L);
            int i11 = i10 == 0 ? 1 : 2;
            n1.g gVar = dVar.f8626a;
            n1.g gVar2 = null;
            if (gVar != null && gVar.f15126r) {
                gVar2 = (n1.g) u1.f.j(gVar);
            }
            long jF = gVar2 != null ? gVar2.F(i11, jFloatToRawIntBits) : 0L;
            iArr[0] = v1.g0.m(Float.intBitsToFloat((int) (jF >> 32)));
            iArr[1] = v1.g0.m(Float.intBitsToFloat((int) (jF & 4294967295L)));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        xb.l lVar = this.f10404w;
        if (lVar != null) {
            lVar.invoke(Boolean.valueOf(z10));
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public final void setDensity(o2.c cVar) {
        if (cVar != this.f10395n) {
            this.f10395n = cVar;
            xb.l lVar = this.f10396o;
            if (lVar != null) {
                lVar.invoke(cVar);
            }
        }
    }

    public final void setLifecycleOwner(x xVar) {
        if (xVar != this.f10397p) {
            this.f10397p = xVar;
            setTag(R.id.view_tree_lifecycle_owner, xVar);
        }
    }

    public final void setModifier(w0.m mVar) {
        if (mVar != this.f10393l) {
            this.f10393l = mVar;
            xb.l lVar = this.f10394m;
            if (lVar != null) {
                lVar.invoke(mVar);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(xb.l lVar) {
        this.f10396o = lVar;
    }

    public final void setOnModifierChanged$ui_release(xb.l lVar) {
        this.f10394m = lVar;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(xb.l lVar) {
        this.f10404w = lVar;
    }

    public final void setRelease(xb.a aVar) {
        this.f10392k = aVar;
    }

    public final void setReset(xb.a aVar) {
        this.f10391j = aVar;
    }

    public final void setSavedStateRegistryOwner(t4.f fVar) {
        if (fVar != this.f10398q) {
            this.f10398q = fVar;
            setTag(R.id.view_tree_saved_state_registry_owner, fVar);
        }
    }

    public final void setUpdate(xb.a aVar) {
        this.f10390h = aVar;
        this.i = true;
        this.f10402u.invoke();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }
}

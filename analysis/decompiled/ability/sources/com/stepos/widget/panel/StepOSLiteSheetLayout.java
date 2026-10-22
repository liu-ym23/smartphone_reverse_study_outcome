package com.stepos.widget.panel;

import G6.b;
import G6.d;
import U7.a;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.R;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010.R\"\u00107\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010+\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u0010.R\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010+\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010.R\"\u0010?\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010+\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010.R\"\u0010C\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010+\u001a\u0004\bA\u0010\u000b\"\u0004\bB\u0010.R\u0014\u0010G\u001a\u00020D8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0016¨\u0006J"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getNestedScrollAxes", "()I", "LG6/b;", "a", "LG6/b;", "getController", "()LG6/b;", "controller", "", "b", "Z", "getDraggable", "()Z", "setDraggable", "(Z)V", "draggable", "c", "getCanDismiss", "setCanDismiss", "canDismiss", "", "d", "F", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "cornerRadius", "e", "getGlassEnabled", "setGlassEnabled", "glassEnabled", "f", "I", "getGlassAppearance", "setGlassAppearance", "(I)V", "glassAppearance", "g", "getSafeTop", "setSafeTop", "safeTop", "h", "getSafeStart", "setSafeStart", "safeStart", "i", "getSafeEnd", "setSafeEnd", "safeEnd", "j", "getImeBottom", "setImeBottom", "imeBottom", "k", "getNavigationBottom", "setNavigationBottom", "navigationBottom", "Lcom/stepos/widget/panel/StepOSLiteSheetSurface;", "getSurface", "()Lcom/stepos/widget/panel/StepOSLiteSheetSurface;", "surface", "getAcceptsDrag", "acceptsDrag", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class StepOSLiteSheetLayout extends FrameLayout implements NestedScrollingParent3 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b controller;

    /* renamed from: b, reason: from kotlin metadata */
    public boolean draggable;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean canDismiss;

    /* renamed from: d, reason: from kotlin metadata */
    public float cornerRadius;

    /* renamed from: e, reason: from kotlin metadata */
    public boolean glassEnabled;

    /* renamed from: f, reason: from kotlin metadata */
    public int glassAppearance;

    /* renamed from: g, reason: from kotlin metadata */
    public int safeTop;

    /* renamed from: h, reason: from kotlin metadata */
    public int safeStart;

    /* renamed from: i, reason: from kotlin metadata */
    public int safeEnd;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public int imeBottom;

    /* renamed from: k, reason: from kotlin metadata */
    public int navigationBottom;
    public final float l;
    public final float m;
    public final float n;
    public final ViewConfiguration o;
    public final NestedScrollingParentHelper p;

    /* renamed from: q, reason: collision with root package name */
    public d f4143q;

    /* renamed from: r, reason: collision with root package name */
    public VelocityTracker f4144r;

    /* renamed from: s, reason: collision with root package name */
    public int f4145s;

    /* renamed from: t, reason: collision with root package name */
    public float f4146t;
    public float u;

    /* renamed from: v, reason: collision with root package name */
    public float f4147v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4148w;

    /* renamed from: x, reason: collision with root package name */
    public View f4149x;
    public View y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f4150z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLiteSheetLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        k.f(context, "context");
        this.controller = new b();
        this.draggable = true;
        this.canDismiss = true;
        this.cornerRadius = getResources().getDimension(R.dimen.stepos_lite_sheet_corner_radius);
        this.glassEnabled = true;
        float dimension = getResources().getDimension(R.dimen.stepos_lite_sheet_outer_margin);
        this.l = dimension;
        float fraction = getResources().getFraction(R.fraction.stepos_lite_sheet_half_ratio, 1, 1);
        this.m = fraction;
        float fraction2 = getResources().getFraction(R.fraction.stepos_lite_sheet_expanded_top_ratio, 1, 1);
        this.n = fraction2;
        this.o = ViewConfiguration.get(context);
        this.p = new NestedScrollingParentHelper(this);
        this.f4143q = new d(0.0f, 0.0f, 0.0f, dimension, fraction, fraction2);
        this.f4145s = -1;
    }

    public static View a(View view, float f, float f7) {
        View viewA;
        if (view.getVisibility() != 0 || f < 0.0f || f7 < 0.0f || f >= view.getWidth() || f7 >= view.getHeight()) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (-1 < childCount) {
                    View childAt = viewGroup.getChildAt(childCount);
                    k.c(childAt);
                    viewA = a(childAt, (viewGroup.getScrollX() + f) - childAt.getX(), (viewGroup.getScrollY() + f7) - childAt.getY());
                }
            } while (viewA == null);
            return viewA;
        }
        return view;
    }

    private final boolean getAcceptsDrag() {
        return this.draggable && this.controller.c != 2;
    }

    private final StepOSLiteSheetSurface getSurface() {
        View childAt = getChildAt(1);
        k.d(childAt, "null cannot be cast to non-null type com.stepos.widget.panel.StepOSLiteSheetSurface");
        return (StepOSLiteSheetSurface) childAt;
    }

    public final void b() {
        VelocityTracker velocityTracker = this.f4144r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f4144r = null;
        this.f4145s = -1;
    }

    public final boolean getCanDismiss() {
        return this.canDismiss;
    }

    public final b getController() {
        return this.controller;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final boolean getDraggable() {
        return this.draggable;
    }

    public final int getGlassAppearance() {
        return this.glassAppearance;
    }

    public final boolean getGlassEnabled() {
        return this.glassEnabled;
    }

    public final int getImeBottom() {
        return this.imeBottom;
    }

    public final int getNavigationBottom() {
        return this.navigationBottom;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.p.getNestedScrollAxes();
    }

    public final int getSafeEnd() {
        return this.safeEnd;
    }

    public final int getSafeStart() {
        return this.safeStart;
    }

    public final int getSafeTop() {
        return this.safeTop;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        b();
        this.y = null;
        this.f4149x = null;
        this.controller.g.cancel();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a4  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.panel.StepOSLiteSheetLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        if (getChildCount() < 2) {
            return;
        }
        getChildAt(0).layout(0, 0, getWidth(), getHeight());
        int i12 = this.safeStart;
        d dVar = this.f4143q;
        b bVar = this.controller;
        float f = bVar.f678a;
        int iU = a.U(AbstractC1451a.t(f, 0.0f, 1.0f) * dVar.c) + i12;
        int iU2 = a.U(this.f4143q.a(bVar.f678a));
        getSurface().layout(iU, iU2, getSurface().getMeasuredWidth() + iU, getSurface().getMeasuredHeight() + iU2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        int i10;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i6);
        setMeasuredDimension(size, size2);
        if (getChildCount() < 2) {
            return;
        }
        float f = this.safeTop;
        float f7 = this.imeBottom;
        b bVar = this.controller;
        bVar.getClass();
        this.f4143q = new d(size2, f, f7, this.l, this.m, this.n);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
        int iU = a.U(AbstractC1451a.t(bVar.f678a, 0.0f, 1.0f) * this.f4143q.c);
        int i11 = ((size - this.safeStart) - this.safeEnd) - (iU * 2);
        if (i11 < 0) {
            i11 = 0;
        }
        d dVar = this.f4143q;
        float f9 = bVar.f678a;
        float fB = dVar.d;
        float f10 = dVar.b;
        if (f9 <= 1.0f) {
            fB = B7.a.b(fB, f10, f9, f10);
        }
        int iU2 = a.U(fB);
        if (iU2 < 0) {
            iU2 = 0;
        }
        if (this.imeBottom > 0 || (i10 = this.navigationBottom - iU) < 0) {
            i10 = 0;
        }
        if (getSurface().getPaddingBottom() != i10) {
            getSurface().setPaddingRelative(0, 0, 0, i10);
        }
        getSurface().measure(View.MeasureSpec.makeMeasureSpec(i11, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(iU2, BasicMeasure.EXACTLY));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View target, float f, float f7, boolean z10) {
        k.f(target, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View target, float f, float f7) {
        k.f(target, "target");
        boolean z10 = false;
        if (getAcceptsDrag() && target == this.y) {
            b bVar = this.controller;
            if (bVar.d == 1) {
                if (bVar.f678a > 0.0f || (f7 < 0.0f && !target.canScrollVertically(-1))) {
                    z10 = true;
                }
                bVar.c(-f7, this.o.getScaledMinimumFlingVelocity(), this.canDismiss);
                this.f4150z = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    @Override // androidx.core.view.NestedScrollingParent2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onNestedPreScroll(android.view.View r2, int r3, int r4, int[] r5, int r6) {
        /*
            r1 = this;
            java.lang.String r3 = "target"
            kotlin.jvm.internal.k.f(r2, r3)
            java.lang.String r3 = "consumed"
            kotlin.jvm.internal.k.f(r5, r3)
            boolean r3 = r1.getAcceptsDrag()
            if (r3 == 0) goto L43
            android.view.View r3 = r1.y
            if (r2 != r3) goto L43
            if (r6 == 0) goto L17
            goto L43
        L17:
            G6.b r3 = r1.controller
            if (r4 <= 0) goto L25
            float r6 = r3.f678a
            r3.getClass()
            r0 = 0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 > 0) goto L2e
        L25:
            if (r4 >= 0) goto L43
            r6 = -1
            boolean r2 = r2.canScrollVertically(r6)
            if (r2 != 0) goto L43
        L2e:
            r2 = 1
            r6 = r5[r2]
            float r4 = (float) r4
            float r4 = -r4
            G6.d r0 = r1.f4143q
            boolean r1 = r1.canDismiss
            float r1 = r3.b(r4, r0, r1)
            float r1 = -r1
            int r1 = U7.a.U(r1)
            int r1 = r1 + r6
            r5[r2] = r1
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.panel.StepOSLiteSheetLayout.onNestedPreScroll(android.view.View, int, int, int[], int):void");
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View target, int i, int i6, int i10, int i11, int i12, int[] consumed) {
        k.f(target, "target");
        k.f(consumed, "consumed");
        if (getAcceptsDrag() && target == this.y && i12 == 0 && i11 < 0) {
            consumed[1] = a.U(-this.controller.b(-i11, this.f4143q, this.canDismiss)) + consumed[1];
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View child, View target, int i, int i6) {
        k.f(child, "child");
        k.f(target, "target");
        this.p.onNestedScrollAccepted(child, target, i, i6);
        this.y = target;
        this.f4150z = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View child, View target, int i, int i6) {
        k.f(child, "child");
        k.f(target, "target");
        return getAcceptsDrag() && i6 == 0 && (i & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View target, int i) {
        k.f(target, "target");
        this.p.onStopNestedScroll(target, i);
        if (target == this.y && i == 0) {
            this.y = null;
            if (!getAcceptsDrag() || this.f4150z) {
                return;
            }
            this.controller.c(0.0f, this.o.getScaledMinimumFlingVelocity(), this.canDismiss);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        k.f(event, "event");
        if (!getAcceptsDrag() || this.f4149x == null) {
            this.f4148w = false;
            b();
            return super.onTouchEvent(event);
        }
        VelocityTracker velocityTracker = this.f4144r;
        if (velocityTracker != null) {
            velocityTracker.addMovement(event);
        }
        int actionMasked = event.getActionMasked();
        ViewConfiguration viewConfiguration = this.o;
        b bVar = this.controller;
        if (actionMasked == 1) {
            VelocityTracker velocityTracker2 = this.f4144r;
            if (velocityTracker2 != null) {
                velocityTracker2.computeCurrentVelocity(1000, viewConfiguration.getScaledMaximumFlingVelocity());
            }
            if (this.f4148w) {
                VelocityTracker velocityTracker3 = this.f4144r;
                bVar.c(velocityTracker3 != null ? velocityTracker3.getYVelocity(this.f4145s) : 0.0f, viewConfiguration.getScaledMinimumFlingVelocity(), this.canDismiss);
            }
            this.f4148w = false;
            b();
            return true;
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = event.findPointerIndex(this.f4145s);
            if (iFindPointerIndex < 0) {
                return false;
            }
            float y = event.getY(iFindPointerIndex);
            if (!this.f4148w && Math.abs(y - this.u) > viewConfiguration.getScaledTouchSlop()) {
                this.f4148w = true;
                bVar.a();
            }
            if (this.f4148w) {
                bVar.b(y - this.f4147v, this.f4143q, this.canDismiss);
            }
            this.f4147v = y;
            return true;
        }
        if (actionMasked == 3) {
            if (this.f4148w) {
                bVar.d(bVar.b);
            }
            this.f4148w = false;
            b();
            return true;
        }
        if (actionMasked == 6 && event.getPointerId(event.getActionIndex()) == this.f4145s) {
            int i = event.getActionIndex() == 0 ? 1 : 0;
            this.f4145s = event.getPointerId(i);
            float y9 = event.getY(i);
            this.f4147v = y9;
            this.u = y9;
            this.f4146t = event.getX(i);
            VelocityTracker velocityTracker4 = this.f4144r;
            if (velocityTracker4 != null) {
                velocityTracker4.clear();
            }
        }
        return true;
    }

    public final void setCanDismiss(boolean z10) {
        this.canDismiss = z10;
    }

    public final void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    public final void setDraggable(boolean z10) {
        this.draggable = z10;
    }

    public final void setGlassAppearance(int i) {
        this.glassAppearance = i;
    }

    public final void setGlassEnabled(boolean z10) {
        this.glassEnabled = z10;
    }

    public final void setImeBottom(int i) {
        this.imeBottom = i;
    }

    public final void setNavigationBottom(int i) {
        this.navigationBottom = i;
    }

    public final void setSafeEnd(int i) {
        this.safeEnd = i;
    }

    public final void setSafeStart(int i) {
        this.safeStart = i;
    }

    public final void setSafeTop(int i) {
        this.safeTop = i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View child, View target, int i) {
        k.f(child, "child");
        k.f(target, "target");
        return onStartNestedScroll(child, target, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View target, int i, int i6, int i10, int i11) {
        k.f(target, "target");
        onNestedScroll(target, i, i6, i10, i11, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View target, int i, int i6, int i10, int i11, int i12) {
        k.f(target, "target");
        onNestedScroll(target, i, i6, i10, i11, i12, new int[2]);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View child, View target, int i) {
        k.f(child, "child");
        k.f(target, "target");
        onNestedScrollAccepted(child, target, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View target) {
        k.f(target, "target");
        onStopNestedScroll(target, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View target, int i, int i6, int[] consumed) {
        k.f(target, "target");
        k.f(consumed, "consumed");
        onNestedPreScroll(target, i, i6, consumed, 0);
    }
}

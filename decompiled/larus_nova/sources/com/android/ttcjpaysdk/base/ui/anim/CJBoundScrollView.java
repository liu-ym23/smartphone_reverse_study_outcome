package com.android.ttcjpaysdk.base.ui.anim;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/anim/CJBoundScrollView;", "Landroidx/core/widget/NestedScrollView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canPullDown", "", "canPullUp", "isPulling", "lastY", "", "mBounceFactor", "maxPullDistance", "springAnimationY", "Landroidx/dynamicanimation/animation/SpringAnimation;", "getSpringAnimationY", "()Landroidx/dynamicanimation/animation/SpringAnimation;", "springAnimationY$delegate", "Lkotlin/Lazy;", "fling", "", "velocityY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "setBounceFactor", "factor", "setMaxPullDistance", "distance", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJBoundScrollView extends NestedScrollView {
    private boolean canPullDown;
    private boolean canPullUp;
    private boolean isPulling;
    private float lastY;
    private float mBounceFactor;
    private float maxPullDistance;
    private final Lazy springAnimationY$delegate;

    public CJBoundScrollView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJBoundScrollView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final SpringAnimation getSpringAnimationY() {
        return (SpringAnimation) this.springAnimationY$delegate.getValue();
    }

    public static final /* synthetic */ SpringAnimation access$getSpringAnimationY(CJBoundScrollView r100) {
        return r100.getSpringAnimationY();
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(final int r100) {
        super.fling(r100);
        post(new AnonymousClass1(r100, this));
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 != 0) goto L5;
        this.lastY = r100.getY();
        this.isPulling = false;
    L24:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 2) goto L24;
        float r103 = r100.getY() - this.lastY;
        if (r103 <= 0.0f) goto L14;
        if (this.canPullDown == false) goto L14;
        if (getScrollY() != 0) goto L14;
    L19:
        r102 = true;
    L20:
        if (r102 == false) goto L24;
        return true;
    L14:
        if (r103 >= 0.0f) goto L20;
        if (this.canPullUp == false) goto L20;
        if ((getScrollY() + getHeight()) < computeVerticalScrollRange()) goto L20;
        goto L19
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 == 0) goto L46;
        boolean r103 = true;
        if (r101 == 1) goto L39;
        if (r101 != 2) goto L9;
        float r104 = r100.getY() - this.lastY;
        this.lastY = r100.getY();
        if (r104 <= 0.0f) goto L18;
        if (this.canPullDown == false) goto L18;
        if (getScrollY() != 0) goto L18;
    L23:
        boolean r105 = true;
    L25:
        if (r105 == false) goto L32;
        if (this.isPulling == true) goto L29;
        this.isPulling = true;
        getSpringAnimationY().cancel();
    L29:
        float r106 = r104 * this.mBounceFactor;
        float r107 = getTranslationY() + r106;
        float r108 = this.maxPullDistance;
        setTranslationY(RangesKt.coerceIn(r107, -r108, r108));
        return true;
    L32:
        if (this.isPulling == false) goto L48;
        this.isPulling = false;
        if (getTranslationY() != 0.0f) goto L36;
        r102 = true;
    L36:
        if (r102 == true) goto L48;
        getSpringAnimationY().start();
    L48:
        return super.onTouchEvent(r100);
    L18:
        if (r104 < 0.0f) goto L20;
    L24:
        r105 = false;
        goto L25
    L20:
        if (this.canPullUp == false) goto L24;
        if ((getScrollY() + getHeight()) < computeVerticalScrollRange()) goto L24;
    L9:
        if (r101 != 3) goto L48;
    L39:
        if (this.isPulling == false) goto L41;
    L45:
        this.isPulling = false;
        getSpringAnimationY().start();
        goto L48
    L41:
        if (getTranslationY() == 0.0f) goto L44;
        r103 = false;
    L44:
        if (r103 == true) goto L48;
    L46:
        this.lastY = r100.getY();
        this.isPulling = false;
        goto L48
    }

    public final void setBounceFactor(float r100) {
        this.mBounceFactor = r100;
    }

    public final void setMaxPullDistance(float r100) {
        this.maxPullDistance = r100;
    }

    public CJBoundScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.mBounceFactor = 0.6f;
        this.maxPullDistance = 300.0f;
        this.canPullUp = true;
        this.canPullDown = true;
        this.springAnimationY$delegate = LazyKt.lazy(new CJBoundScrollView$springAnimationY$2(this));
    }

    public /* synthetic */ CJBoundScrollView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}

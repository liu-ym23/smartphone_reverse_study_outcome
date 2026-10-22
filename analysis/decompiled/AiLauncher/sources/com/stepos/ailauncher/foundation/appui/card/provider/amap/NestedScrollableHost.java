package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "e", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "orientation", "", "delta", Const.INTENT_KEY_APIKEY, "(IF)Z", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/MotionEvent;)V", "touchSlop", "I", "initialX", "F", "initialY", "Landroidx/viewpager2/widget/ViewPager2;", "getChildPager", "()Landroidx/viewpager2/widget/ViewPager2;", "childPager", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NestedScrollableHost extends FrameLayout {
    private float initialX;
    private float initialY;
    private final int touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private final ViewPager2 getChildPager() {
        View childAt = getChildCount() > 0 ? getChildAt(0) : null;
        if (childAt instanceof ViewPager2) {
            return (ViewPager2) childAt;
        }
        return null;
    }

    public final boolean a(int orientation, float delta) {
        View childAt;
        ViewPager2 childPager = getChildPager();
        if (childPager == null || (childAt = childPager.getChildAt(0)) == null) {
            return false;
        }
        int i10 = -((int) Math.signum(delta));
        return orientation == 0 ? childAt.canScrollHorizontally(i10) : childAt.canScrollVertically(i10);
    }

    public final void b(MotionEvent e10) {
        ViewPager2 childPager = getChildPager();
        if (childPager == null) {
            return;
        }
        int orientation = childPager.getOrientation();
        int actionMasked = e10.getActionMasked();
        if (actionMasked == 0) {
            this.initialX = e10.getX();
            this.initialY = e10.getY();
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (!a(orientation, -1.0f) && !a(orientation, 1.0f)) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                    return;
                }
                float x10 = e10.getX() - this.initialX;
                float y10 = e10.getY() - this.initialY;
                boolean z10 = orientation == 0;
                float fAbs = Math.abs(x10) * (z10 ? 1.0f : 0.5f);
                float fAbs2 = Math.abs(y10) * (z10 ? 0.5f : 1.0f);
                int i10 = this.touchSlop;
                if (fAbs > i10 || fAbs2 > i10) {
                    if (z10 == (fAbs2 > fAbs)) {
                        ViewParent parent3 = getParent();
                        if (parent3 != null) {
                            parent3.requestDisallowInterceptTouchEvent(false);
                            return;
                        }
                        return;
                    }
                    if (!z10) {
                        x10 = y10;
                    }
                    ViewParent parent4 = getParent();
                    if (parent4 != null) {
                        parent4.requestDisallowInterceptTouchEvent(a(orientation, x10));
                        return;
                    }
                    return;
                }
                return;
            }
            if (actionMasked != 3) {
                return;
            }
        }
        ViewParent parent5 = getParent();
        if (parent5 != null) {
            parent5.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        b(e10);
        return super.onInterceptTouchEvent(e10);
    }
}

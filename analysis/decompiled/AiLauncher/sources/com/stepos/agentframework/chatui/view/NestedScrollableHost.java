package com.stepos.agentframework.chatui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00101\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/stepos/agentframework/chatui/view/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "direction", "", "canScrollHorizontally", "(I)Z", "Landroid/view/MotionEvent;", "event", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", Const.INTENT_KEY_APIKEY, "()Z", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "disallow", "LY8/t;", "c", "(Landroidx/viewpager2/widget/ViewPager2;Z)V", Const.INTENT_KEY_UMID, "(Landroid/view/MotionEvent;)V", "Landroid/view/View;", "child", "orientation", "", "delta", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;IF)Z", "touchSlop", "I", "initialX", "F", "initialY", "allowHorizontalParentHandoffAtBoundary", "Z", "getAllowHorizontalParentHandoffAtBoundary", "setAllowHorizontalParentHandoffAtBoundary", "(Z)V", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "getChildView", "()Landroid/view/View;", "childView", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NestedScrollableHost extends FrameLayout {
    private boolean allowHorizontalParentHandoffAtBoundary;
    private float initialX;
    private float initialY;
    private final int touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private final View getChildView() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x000d, code lost:
    
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r2 = this;
            android.view.ViewParent r2 = r2.getParent()
            boolean r0 = r2 instanceof android.view.View
            r1 = 0
            if (r0 == 0) goto Lc
            android.view.View r2 = (android.view.View) r2
            goto Ld
        Lc:
            r2 = r1
        Ld:
            if (r2 == 0) goto L1e
            boolean r0 = r2 instanceof androidx.viewpager2.widget.ViewPager2
            if (r0 != 0) goto L1e
            android.view.ViewParent r2 = r2.getParent()
            boolean r0 = r2 instanceof android.view.View
            if (r0 == 0) goto Lc
            android.view.View r2 = (android.view.View) r2
            goto Ld
        L1e:
            boolean r0 = r2 instanceof androidx.viewpager2.widget.ViewPager2
            if (r0 == 0) goto L25
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
            return r2
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.NestedScrollableHost.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    public final boolean a() {
        return this.allowHorizontalParentHandoffAtBoundary || O.INSTANCE.a(this);
    }

    public final boolean b(View child, int orientation, float delta) {
        if (delta == 0.0f) {
            return false;
        }
        int i10 = (int) (-Math.signum(delta));
        return orientation == 0 ? child.canScrollHorizontally(i10) : child.canScrollVertically(i10);
    }

    public final void c(ViewPager2 viewPager, boolean disallow) {
        getParent().requestDisallowInterceptTouchEvent(disallow);
        View childAt = viewPager.getChildAt(0);
        RecyclerView recyclerView = childAt instanceof RecyclerView ? (RecyclerView) childAt : null;
        if (recyclerView != null) {
            recyclerView.requestDisallowInterceptTouchEvent(disallow);
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        View childView = getChildView();
        if (childView != null) {
            return childView.canScrollHorizontally(direction);
        }
        return false;
    }

    public final void d(MotionEvent event) {
        View childView;
        ViewPager2 parentViewPager = getParentViewPager();
        if (parentViewPager == null || (childView = getChildView()) == null) {
            return;
        }
        int orientation = parentViewPager.getOrientation();
        boolean z10 = true;
        if (event.getActionMasked() == 0) {
            this.initialX = event.getX();
            this.initialY = event.getY();
            c(parentViewPager, true);
            return;
        }
        if (event.getActionMasked() != 2) {
            return;
        }
        float x10 = event.getX() - this.initialX;
        float y10 = event.getY() - this.initialY;
        boolean z11 = orientation == 0;
        float fAbs = Math.abs(x10) * (z11 ? 0.5f : 1.0f);
        float fAbs2 = Math.abs(y10) * (z11 ? 1.0f : 0.5f);
        int i10 = this.touchSlop;
        if (fAbs > i10 || fAbs2 > i10) {
            if (z11 == (fAbs2 > fAbs)) {
                c(parentViewPager, false);
                return;
            }
            if (z11 && !canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                c(parentViewPager, false);
                return;
            }
            if (!z11) {
                x10 = y10;
            }
            if (!b(childView, orientation, x10) && a()) {
                z10 = false;
            }
            c(parentViewPager, z10);
        }
    }

    public final boolean getAllowHorizontalParentHandoffAtBoundary() {
        return this.allowHorizontalParentHandoffAtBoundary;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        d(event);
        return super.onInterceptTouchEvent(event);
    }

    public final void setAllowHorizontalParentHandoffAtBoundary(boolean z10) {
        this.allowHorizontalParentHandoffAtBoundary = z10;
    }
}

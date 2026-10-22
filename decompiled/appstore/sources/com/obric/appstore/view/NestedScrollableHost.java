package com.obric.appstore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/obric/appstore/view/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "e", "", "handleInterceptTouchEvent", "(Landroid/view/MotionEvent;)V", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "orientation", "", "delta", "a", "(IF)Z", "I", "touchSlop", "b", "F", "initialX", "c", "initialY", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "parentViewPager", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "child", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NestedScrollableHost extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11119c;

    public NestedScrollableHost(@NotNull Context r10) {
        q.g(r10, "context");
        super(r10);
        this.f11117a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private final View getChild() {
        if (getChildCount() > 0) goto L7;
        return null;
    L7:
        return getChildAt(0);
    }

    private final ViewPager2 getParentViewPager() {
        Object r10 = getParent();
        if ((r10 instanceof View) == false) goto L5;
        View r11 = (View) r10;
    L6:
        if (r11 == null) goto L13;
        if ((r11 instanceof ViewPager2) == true) goto L13;
        Object r12 = r11.getParent();
        if ((r12 instanceof View) == false) goto L5;
        r11 = (View) r12;
        goto L6
    L5:
        r11 = null;
    L13:
        if ((r11 instanceof ViewPager2) == true) goto L15;
        return null;
    L15:
        return (ViewPager2) r11;
    L16:
        r11 = null;
        goto L6
    }

    private final void handleInterceptTouchEvent(MotionEvent r10) {
        ViewPager2 r11 = getParentViewPager();
        if (r11 == null) goto L34;
        int r12 = r11.getOrientation();
        if (r10.getAction() != 0) goto L8;
        this.f11118b = r10.getX();
        this.f11119c = r10.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L8:
        if (r10.getAction() != 2) goto L36;
        float r13 = r10.getX() - this.f11118b;
        float r14 = r10.getY() - this.f11119c;
        if (r12 != 0) goto L12;
        boolean r15 = true;
    L13:
        float r16 = Math.abs(r13);
        float r17 = Math.abs(r14);
        int r18 = this.f11117a;
        if (r16 > r18) goto L18;
        if (r17 > r18) goto L18;
        return;
    L18:
        if (r15 == false) goto L27;
        if (r16 > (r17 * 1.5f)) goto L22;
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L22:
        if (a(r12, r13) == false) goto L24;
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L24:
        getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L27:
        if (r17 > (r16 * 1.5f)) goto L29;
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L29:
        if (a(r12, r14) == false) goto L31;
        getParent().requestDisallowInterceptTouchEvent(true);
        return;
    L31:
        getParent().requestDisallowInterceptTouchEvent(false);
        return;
    L12:
        r15 = false;
        goto L13
    L36:
        return;
    }

    public final boolean a(int r10, float r11) {
        int r12 = -((int) Math.signum(r11));
        if (r10 != 0) goto L5;
        View r13 = getChild();
        if (r13 != null) goto L14;
        return false;
    L14:
        return r13.canScrollHorizontally(r12);
    L5:
        if (r10 != 1) goto L10;
        View r14 = getChild();
        if (r14 != null) goto L16;
        return false;
    L16:
        return r14.canScrollVertically(r12);
    L10:
        throw new IllegalArgumentException();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        q.g(r10, "e");
        boolean r11 = super.dispatchTouchEvent(r10);
        handleInterceptTouchEvent(r10);
        return r11;
    }

    public NestedScrollableHost(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f11117a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}

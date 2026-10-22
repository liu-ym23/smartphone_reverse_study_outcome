package androidx.core.widget;

import K.C0074f;
import K.InterfaceC0085q;
import K.InterfaceC0087t;
import K.J;
import K.S;
import K.r;
import a.C0152a;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.stepos.alphame.utils.Property;
import d.C0527a;
import java.util.WeakHashMap;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0087t, InterfaceC0085q {

    /* renamed from: C, reason: collision with root package name */
    public static final float f3324C = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: D, reason: collision with root package name */
    public static final g f3325D = new g();

    /* renamed from: E, reason: collision with root package name */
    public static final int[] f3326E = {R.attr.fillViewport};

    /* renamed from: A, reason: collision with root package name */
    public i f3327A;

    /* renamed from: B, reason: collision with root package name */
    public final C0074f f3328B;

    /* renamed from: a, reason: collision with root package name */
    public final float f3329a;

    /* renamed from: b, reason: collision with root package name */
    public long f3330b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f3331c;

    /* renamed from: d, reason: collision with root package name */
    public final OverScroller f3332d;

    /* renamed from: e, reason: collision with root package name */
    public final EdgeEffect f3333e;

    /* renamed from: f, reason: collision with root package name */
    public final EdgeEffect f3334f;

    /* renamed from: g, reason: collision with root package name */
    public int f3335g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3336h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3337i;

    /* renamed from: j, reason: collision with root package name */
    public View f3338j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3339k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f3340l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3341m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3342n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3343o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3344p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3345q;

    /* renamed from: r, reason: collision with root package name */
    public int f3346r;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f3347s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f3348t;

    /* renamed from: u, reason: collision with root package name */
    public int f3349u;

    /* renamed from: v, reason: collision with root package name */
    public int f3350v;

    /* renamed from: w, reason: collision with root package name */
    public SavedState f3351w;

    /* renamed from: x, reason: collision with root package name */
    public final C0152a f3352x;

    /* renamed from: y, reason: collision with root package name */
    public final r f3353y;

    /* renamed from: z, reason: collision with root package name */
    public float f3354z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new j();

        /* renamed from: a, reason: collision with root package name */
        public int f3355a;

        public final String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return AbstractC0831a.d(sb, this.f3355a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3355a);
        }
    }

    public NestedScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.stepos.alphame.R.attr.nestedScrollViewStyle);
    }

    public static boolean h(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && h((View) parent, view2);
    }

    public final boolean a(int i4) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i4);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !j(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i4 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i4 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i4 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            t(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f3331c;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            t(b(rect), 0, 1, true);
            viewFindNextFocus.requestFocus(i4);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && (!j(viewFindFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public final int b(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        int i6 = rect.bottom;
        if (i6 > i5 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i5, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        }
        if (rect.top >= scrollY || i6 >= i5) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i5 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public final boolean c(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return this.f3353y.c(i4, i5, iArr, null, i6);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // K.InterfaceC0086s
    public final void d(View view, View view2, int i4, int i5) {
        C0152a c0152a = this.f3352x;
        if (i5 == 1) {
            c0152a.f2262b = i4;
        } else {
            c0152a.f2261a = i4;
        }
        w(2, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || e(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return this.f3353y.a(f4, f5, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f4, float f5) {
        return this.f3353y.b(f4, f5);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return this.f3353y.c(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.f3353y.e(i4, i5, i6, i7, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f3333e;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (h.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (h.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.f3334f;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (h.a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (h.a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, Property.DEFAULT_FLOAT_VALUE);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    public final boolean e(KeyEvent keyEvent) {
        this.f3331c.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    return keyEvent.isAltPressed() ? g(33) : a(33);
                }
                if (keyCode == 20) {
                    return keyEvent.isAltPressed() ? g(130) : a(130);
                }
                if (keyCode == 62) {
                    o(keyEvent.isShiftPressed() ? 33 : 130);
                    return false;
                }
                if (keyCode == 92) {
                    return g(33);
                }
                if (keyCode == 93) {
                    return g(130);
                }
                if (keyCode == 122) {
                    o(33);
                    return false;
                }
                if (keyCode != 123) {
                    return false;
                }
                o(130);
                return false;
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
        return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
    }

    public void f(int i4) {
        if (getChildCount() > 0) {
            this.f3332d.fling(getScrollX(), getScrollY(), 0, i4, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            w(2, 1);
            this.f3350v = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public final boolean g(int i4) {
        int childCount;
        boolean z4 = i4 == 130;
        int height = getHeight();
        Rect rect = this.f3331c;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return s(i4, rect.top, rect.bottom);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0152a c0152a = this.f3352x;
        return c0152a.f2262b | c0152a.f2261a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @VisibleForTesting
    public float getVerticalScrollFactorCompat() {
        if (this.f3354z == Property.DEFAULT_FLOAT_VALUE) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f3354z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f3354z;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f3353y.g(0);
    }

    @Override // K.InterfaceC0086s
    public final void i(View view, int i4, int i5, int[] iArr, int i6) {
        c(i4, i5, iArr, null, i6);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f3353y.f1002d;
    }

    public final boolean j(View view, int i4, int i5) {
        Rect rect = this.f3331c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i4 >= getScrollY() && rect.top - i4 <= getScrollY() + i5;
    }

    public final void k(int i4, int i5, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f3353y.d(scrollY2, i4 - scrollY2, i5, iArr);
    }

    public final void l(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3346r) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.f3335g = (int) motionEvent.getY(i4);
            this.f3346r = motionEvent.getPointerId(i4);
            VelocityTracker velocityTracker = this.f3340l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean m(int i4, int i5, int i6, int i7) {
        boolean z4;
        boolean z5;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i8 = i6 + i4;
        if (i5 <= 0 && i5 >= 0) {
            z4 = false;
        } else {
            i5 = 0;
            z4 = true;
        }
        if (i8 > i7) {
            z5 = true;
        } else if (i8 < 0) {
            i7 = 0;
            z5 = true;
        } else {
            i7 = i8;
            z5 = false;
        }
        if (z5 && !this.f3353y.g(1)) {
            this.f3332d.springBack(i5, i7, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i5, i7);
        return z4 || z5;
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // K.InterfaceC0086s
    public final void n(int i4, View view) {
        C0152a c0152a = this.f3352x;
        if (i4 == 1) {
            c0152a.f2262b = 0;
        } else {
            c0152a.f2261a = 0;
        }
        y(i4);
    }

    public final void o(int i4) {
        boolean z4 = i4 == 130;
        int height = getHeight();
        Rect rect = this.f3331c;
        if (z4) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i5 = rect.top;
        int i6 = height + i5;
        rect.bottom = i6;
        s(i4, i5, i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3337i = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d6  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r28) {
        /*
            Method dump skipped, instructions count: 841
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0117  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int measuredHeight;
        super.onLayout(z4, i4, i5, i6, i7);
        int i8 = 0;
        this.f3336h = false;
        View view = this.f3338j;
        if (view != null && h(view, this)) {
            View view2 = this.f3338j;
            Rect rect = this.f3331c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iB = b(rect);
            if (iB != 0) {
                scrollBy(0, iB);
            }
        }
        this.f3338j = null;
        if (!this.f3337i) {
            if (this.f3351w != null) {
                scrollTo(getScrollX(), this.f3351w.f3355a);
                this.f3351w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i8 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i8 != scrollY) {
                scrollTo(getScrollX(), i8);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3337i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f3341m && View.MeasureSpec.getMode(i5) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i4, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(Property.DEFAULT_FLOAT_VALUE, f5, true);
        f((int) f5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        return this.f3353y.b(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        c(i4, i5, iArr, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        k(i7, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        d(view, view2, i4, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i4, int i5, boolean z4, boolean z5) {
        super.scrollTo(i4, i5);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (i4 == 2) {
            i4 = 130;
        } else if (i4 == 1) {
            i4 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i4) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i4);
        if (viewFindNextFocus == null || (!j(viewFindNextFocus, 0, getHeight()))) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i4, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3351w = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3355a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        i iVar = this.f3327A;
        if (iVar != null) {
            iVar.k(this);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !j(viewFindFocus, 0, i7)) {
            return;
        }
        Rect rect = this.f3331c;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iB = b(rect);
        if (iB != 0) {
            if (this.f3342n) {
                v(0, iB, false);
            } else {
                scrollBy(0, iB);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        return r(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        n(0, view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.f3340l == null) {
            this.f3340l = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3349u = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f4 = this.f3349u;
        float f5 = Property.DEFAULT_FLOAT_VALUE;
        motionEventObtain.offsetLocation(Property.DEFAULT_FLOAT_VALUE, f4);
        if (actionMasked != 0) {
            EdgeEffect edgeEffect = this.f3334f;
            EdgeEffect edgeEffect2 = this.f3333e;
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f3340l;
                velocityTracker.computeCurrentVelocity(1000, this.f3345q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f3346r);
                if (Math.abs(yVelocity) >= this.f3344p) {
                    if (d.b(edgeEffect2) != Property.DEFAULT_FLOAT_VALUE) {
                        if (u(edgeEffect2, yVelocity)) {
                            edgeEffect2.onAbsorb(yVelocity);
                        } else {
                            f(-yVelocity);
                        }
                    } else if (d.b(edgeEffect) != Property.DEFAULT_FLOAT_VALUE) {
                        int i4 = -yVelocity;
                        if (u(edgeEffect, i4)) {
                            edgeEffect.onAbsorb(i4);
                        } else {
                            f(i4);
                        }
                    } else {
                        int i5 = -yVelocity;
                        float f6 = i5;
                        if (!this.f3353y.b(Property.DEFAULT_FLOAT_VALUE, f6)) {
                            dispatchNestedFling(Property.DEFAULT_FLOAT_VALUE, f6, true);
                            f(i5);
                        }
                    }
                } else if (this.f3332d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f3346r = -1;
                this.f3339k = false;
                VelocityTracker velocityTracker2 = this.f3340l;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f3340l = null;
                }
                y(0);
                this.f3333e.onRelease();
                this.f3334f.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3346r);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f3346r + " in onTouchEvent");
                } else {
                    int y4 = (int) motionEvent.getY(iFindPointerIndex);
                    int i6 = this.f3335g - y4;
                    float x4 = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i6 / getHeight();
                    if (d.b(edgeEffect2) != Property.DEFAULT_FLOAT_VALUE) {
                        float f7 = -d.c(edgeEffect2, -height, x4);
                        if (d.b(edgeEffect2) == Property.DEFAULT_FLOAT_VALUE) {
                            edgeEffect2.onRelease();
                        }
                        f5 = f7;
                    } else if (d.b(edgeEffect) != Property.DEFAULT_FLOAT_VALUE) {
                        float fC = d.c(edgeEffect, height, 1.0f - x4);
                        if (d.b(edgeEffect) == Property.DEFAULT_FLOAT_VALUE) {
                            edgeEffect.onRelease();
                        }
                        f5 = fC;
                    }
                    int iRound = Math.round(f5 * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    int i7 = i6 - iRound;
                    if (!this.f3339k && Math.abs(i7) > this.f3343o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f3339k = true;
                        i7 = i7 > 0 ? i7 - this.f3343o : i7 + this.f3343o;
                    }
                    if (this.f3339k) {
                        int iT = t(i7, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f3335g = y4 - iT;
                        this.f3349u += iT;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f3339k && getChildCount() > 0 && this.f3332d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                this.f3346r = -1;
                this.f3339k = false;
                VelocityTracker velocityTracker3 = this.f3340l;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f3340l = null;
                }
                y(0);
                this.f3333e.onRelease();
                this.f3334f.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f3335g = (int) motionEvent.getY(actionIndex);
                this.f3346r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                l(motionEvent);
                this.f3335g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f3346r));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f3339k && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f3332d.isFinished()) {
                this.f3332d.abortAnimation();
                y(1);
            }
            int y5 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.f3335g = y5;
            this.f3346r = pointerId;
            w(2, 0);
        }
        VelocityTracker velocityTracker4 = this.f3340l;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    @Override // K.InterfaceC0087t
    public final void p(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        k(i7, i8, iArr);
    }

    @Override // K.InterfaceC0086s
    public final void q(View view, int i4, int i5, int i6, int i7, int i8) {
        k(i7, i8, null);
    }

    @Override // K.InterfaceC0086s
    public final boolean r(View view, View view2, int i4, int i5) {
        return (i4 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f3336h) {
            this.f3338j = view2;
        } else {
            Rect rect = this.f3331c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iB = b(rect);
            if (iB != 0) {
                scrollBy(0, iB);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iB = b(rect);
        boolean z5 = iB != 0;
        if (z5) {
            if (z4) {
                scrollBy(0, iB);
            } else {
                v(0, iB, false);
            }
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        VelocityTracker velocityTracker;
        if (z4 && (velocityTracker = this.f3340l) != null) {
            velocityTracker.recycle();
            this.f3340l = null;
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f3336h = true;
        super.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(int r18, int r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            int r4 = r17.getHeight()
            int r5 = r17.getScrollY()
            int r4 = r4 + r5
            r6 = 33
            if (r1 != r6) goto L17
            r6 = 1
            goto L18
        L17:
            r6 = 0
        L18:
            r9 = 2
            java.util.ArrayList r9 = r0.getFocusables(r9)
            int r10 = r9.size()
            r11 = 0
            r12 = 0
            r13 = 0
        L24:
            if (r12 >= r10) goto L6c
            java.lang.Object r14 = r9.get(r12)
            android.view.View r14 = (android.view.View) r14
            int r15 = r14.getTop()
            int r7 = r14.getBottom()
            if (r2 >= r7) goto L69
            if (r15 >= r3) goto L69
            if (r2 >= r15) goto L3f
            if (r7 >= r3) goto L3f
            r16 = 1
            goto L41
        L3f:
            r16 = 0
        L41:
            if (r11 != 0) goto L47
            r11 = r14
            r13 = r16
            goto L69
        L47:
            if (r6 == 0) goto L4f
            int r8 = r11.getTop()
            if (r15 < r8) goto L57
        L4f:
            if (r6 != 0) goto L59
            int r8 = r11.getBottom()
            if (r7 <= r8) goto L59
        L57:
            r7 = 1
            goto L5a
        L59:
            r7 = 0
        L5a:
            if (r13 == 0) goto L61
            if (r16 == 0) goto L69
            if (r7 == 0) goto L69
            goto L68
        L61:
            if (r16 == 0) goto L66
            r11 = r14
            r13 = 1
            goto L69
        L66:
            if (r7 == 0) goto L69
        L68:
            r11 = r14
        L69:
            int r12 = r12 + 1
            goto L24
        L6c:
            if (r11 != 0) goto L6f
            r11 = r0
        L6f:
            if (r2 < r5) goto L75
            if (r3 > r4) goto L75
            r7 = 0
            goto L82
        L75:
            if (r6 == 0) goto L7b
            int r2 = r2 - r5
        L78:
            r3 = 0
            r4 = 1
            goto L7e
        L7b:
            int r2 = r3 - r4
            goto L78
        L7e:
            r0.t(r2, r3, r4, r4)
            r7 = r4
        L82:
            android.view.View r0 = r17.findFocus()
            if (r11 == r0) goto L8b
            r11.requestFocus(r1)
        L8b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.s(int, int, int):boolean");
    }

    @Override // android.view.View
    public final void scrollTo(int i4, int i5) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i4 < 0) {
                i4 = 0;
            } else if (width + i4 > width2) {
                i4 = width2 - width;
            }
            if (height >= height2 || i5 < 0) {
                i5 = 0;
            } else if (height + i5 > height2) {
                i5 = height2 - height;
            }
            if (i4 == getScrollX() && i5 == getScrollY()) {
                return;
            }
            super.scrollTo(i4, i5);
        }
    }

    public void setFillViewport(boolean z4) {
        if (z4 != this.f3341m) {
            this.f3341m = z4;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        r rVar = this.f3353y;
        if (rVar.f1002d) {
            WeakHashMap weakHashMap = S.f939a;
            J.z(rVar.f1001c);
        }
        rVar.f1002d = z4;
    }

    public void setOnScrollChangeListener(@Nullable i iVar) {
        this.f3327A = iVar;
    }

    public void setSmoothScrollingEnabled(boolean z4) {
        this.f3342n = z4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i4) {
        return this.f3353y.h(i4, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        y(0);
    }

    public final int t(int i4, int i5, int i6, boolean z4) {
        int i7;
        int i8;
        VelocityTracker velocityTracker;
        if (i6 == 1) {
            w(2, i6);
        }
        boolean zC = this.f3353y.c(0, i4, this.f3348t, this.f3347s, i6);
        int[] iArr = this.f3348t;
        int[] iArr2 = this.f3347s;
        if (zC) {
            i7 = i4 - iArr[1];
            i8 = iArr2[1];
        } else {
            i7 = i4;
            i8 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z5 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z4;
        boolean z6 = m(i7, 0, scrollY, scrollRange) && !this.f3353y.g(i6);
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        this.f3353y.e(0, scrollY2, 0, i7 - scrollY2, this.f3347s, i6, iArr);
        int i9 = i8 + iArr2[1];
        int i10 = i7 - iArr[1];
        int i11 = scrollY + i10;
        EdgeEffect edgeEffect = this.f3334f;
        EdgeEffect edgeEffect2 = this.f3333e;
        if (i11 < 0) {
            if (z5) {
                d.c(edgeEffect2, (-i10) / getHeight(), i5 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i11 > scrollRange && z5) {
            d.c(edgeEffect, i10 / getHeight(), 1.0f - (i5 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (!edgeEffect2.isFinished() || !edgeEffect.isFinished()) {
            postInvalidateOnAnimation();
        } else if (z6 && i6 == 0 && (velocityTracker = this.f3340l) != null) {
            velocityTracker.clear();
        }
        if (i6 == 1) {
            y(i6);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i9;
    }

    public final boolean u(EdgeEffect edgeEffect, int i4) {
        if (i4 > 0) {
            return true;
        }
        float fB = d.b(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i4) * 0.35f;
        float f4 = this.f3329a * 0.015f;
        double dLog = Math.log(fAbs / f4);
        double d4 = f3324C;
        return ((float) (Math.exp((d4 / (d4 - 1.0d)) * dLog) * ((double) f4))) < fB;
    }

    public final void v(int i4, int i5, boolean z4) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3330b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f3332d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i5 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z4) {
                w(2, 1);
            } else {
                y(1);
            }
            this.f3350v = getScrollY();
            postInvalidateOnAnimation();
        } else {
            if (!this.f3332d.isFinished()) {
                this.f3332d.abortAnimation();
                y(1);
            }
            scrollBy(i4, i5);
        }
        this.f3330b = AnimationUtils.currentAnimationTimeMillis();
    }

    public final boolean w(int i4, int i5) {
        return this.f3353y.h(2, i5);
    }

    public final boolean x(MotionEvent motionEvent) {
        boolean z4;
        EdgeEffect edgeEffect = this.f3333e;
        if (d.b(edgeEffect) != Property.DEFAULT_FLOAT_VALUE) {
            d.c(edgeEffect, Property.DEFAULT_FLOAT_VALUE, motionEvent.getX() / getWidth());
            z4 = true;
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect2 = this.f3334f;
        if (d.b(edgeEffect2) == Property.DEFAULT_FLOAT_VALUE) {
            return z4;
        }
        d.c(edgeEffect2, Property.DEFAULT_FLOAT_VALUE, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void y(int i4) {
        this.f3353y.i(i4);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3331c = new Rect();
        this.f3336h = true;
        this.f3337i = false;
        this.f3338j = null;
        this.f3339k = false;
        this.f3342n = true;
        this.f3346r = -1;
        this.f3347s = new int[2];
        this.f3348t = new int[2];
        this.f3328B = new C0074f(getContext(), new C0527a(20, this));
        this.f3333e = d.a(context, attributeSet);
        this.f3334f = d.a(context, attributeSet);
        this.f3329a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f3332d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3343o = viewConfiguration.getScaledTouchSlop();
        this.f3344p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3345q = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3326E, i4, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f3352x = new C0152a();
        this.f3353y = new r(this);
        setNestedScrollingEnabled(true);
        S.h(this, f3325D);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4) {
        if (getChildCount() <= 0) {
            super.addView(view, i4);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i4, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}

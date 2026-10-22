package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17490k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17491l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ValueAnimator f17492m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SavedState f17493n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WeakReference f17494o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f17495p;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        public Behavior() {
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r10) {
            return super.h((OUnitedTitleBar) r10);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(View r10) {
            return super.n((OUnitedTitleBar) r10);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r10) {
            return super.o((OUnitedTitleBar) r10);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r10, View r11) {
            super.q(r10, (OUnitedTitleBar) r11);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
            return super.r(r10, (OUnitedTitleBar) r11, r12);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r10, View r11, int r12, int r13, int r14, int r15) {
            return super.s(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int[] r15, int r16) {
            super.t(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int r15, int r16, int r17) {
            super.u(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16, r17);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r10, View r11, Parcelable r12) {
            super.v(r10, (OUnitedTitleBar) r11, r12);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r10, View r11) {
            return super.w(r10, (OUnitedTitleBar) r11);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14, int r15) {
            return super.x(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13) {
            super.y(r10, (OUnitedTitleBar) r11, r12, r13);
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12, int r13, int r14) {
            return super.B(r10, (OUnitedTitleBar) r11, r12, r13, r14);
        }

        public Behavior(Context r10, AttributeSet r11) {
            super(r10, r11);
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f17497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Interpolator f17498c;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f17496a = 1;
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.AppBarLayout_Layout);
            this.f17496a = r12.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            e(0);
            int r13 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (r12.hasValue(r13) == false) goto L5;
            this.f17498c = AnimationUtils.loadInterpolator(r10, r12.getResourceId(r13, 0));
        L5:
            r12.recycle();
        }

        public final e a(int r10) {
            if (r10 == 1) goto L7;
            return null;
        L7:
            return new f();
        }

        public e b() {
            return this.f17497b;
        }

        public int c() {
            return this.f17496a;
        }

        public Interpolator d() {
            return this.f17498c;
        }

        public void e(int r10) {
            this.f17497b = a(r10);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f17496a = 1;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean firstVisibleChildAtMinimumHeight;
        int firstVisibleChildIndex;
        float firstVisibleChildPercentageShown;
        boolean fullyExpanded;
        boolean fullyScrolled;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(@NonNull Parcel r10, ClassLoader r11) {
            super(r10, r11);
            boolean r12 = false;
            if (r10.readByte() == 0) goto L5;
            boolean r13 = true;
        L6:
            this.fullyScrolled = r13;
            if (r10.readByte() == 0) goto L9;
            boolean r14 = true;
        L10:
            this.fullyExpanded = r14;
            this.firstVisibleChildIndex = r10.readInt();
            this.firstVisibleChildPercentageShown = r10.readFloat();
            if (r10.readByte() == 0) goto L13;
            r12 = true;
        L13:
            this.firstVisibleChildAtMinimumHeight = r12;
            return;
        L9:
            r14 = false;
            goto L10
        L5:
            r13 = false;
            goto L6
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeByte(this.fullyScrolled ? 1 : 0);
            r10.writeByte(this.fullyExpanded ? 1 : 0);
            r10.writeInt(this.firstVisibleChildIndex);
            r10.writeFloat(this.firstVisibleChildPercentageShown);
            r10.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f17499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OUnitedTitleBar f17500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseBehavior f17501c;

        public a(BaseBehavior r10, CoordinatorLayout r11, OUnitedTitleBar r12) {
            this.f17501c = r10;
            this.f17499a = r11;
            this.f17500b = r12;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            this.f17501c.setHeaderTopBottomOffset(this.f17499a, this.f17500b, ((Integer) r10.getAnimatedValue()).intValue());
        }
    }

    public class b extends androidx.core.view.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseBehavior f17502a;

        public b(BaseBehavior r10) {
            this.f17502a = r10;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            r11.r0(BaseBehavior.b(this.f17502a));
            r11.V(ScrollView.class.getName());
        }
    }

    public class c implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f17503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OUnitedTitleBar f17504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f17505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f17506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseBehavior f17507e;

        public c(BaseBehavior r10, CoordinatorLayout r11, OUnitedTitleBar r12, View r13, int r14) {
            this.f17507e = r10;
            this.f17503a = r11;
            this.f17504b = r12;
            this.f17505c = r13;
            this.f17506d = r14;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(View r10, AccessibilityViewCommand.a r11) {
            this.f17507e.t(this.f17503a, this.f17504b, this.f17505c, 0, this.f17506d, new int[]{0, 0}, 1);
            return true;
        }
    }

    public class d implements AccessibilityViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OUnitedTitleBar f17508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f17509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BaseBehavior f17510c;

        public d(BaseBehavior r10, OUnitedTitleBar r11, boolean r12) {
            this.f17510c = r10;
            this.f17508a = r11;
            this.f17509b = r12;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(View r10, AccessibilityViewCommand.a r11) {
            this.f17508a.setExpanded(this.f17509b);
            return true;
        }
    }

    public static abstract class e {
        public e() {
        }

        public abstract void a(OUnitedTitleBar r10, View r11, float r12);
    }

    public static class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f17511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f17512b;

        public f() {
            this.f17511a = new Rect();
            this.f17512b = new Rect();
        }

        public static void b(Rect r10, OUnitedTitleBar r11, View r12) {
            r12.getDrawingRect(r10);
            r11.offsetDescendantRectToMyCoords(r12, r10);
            r10.offset(0, -r11.getTopInset());
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior.e
        public void a(OUnitedTitleBar r10, View r11, float r12) {
            b(this.f17511a, r10, r11);
            float r13 = this.f17511a.top - Math.abs(r12);
            if (r13 > 0.0f) goto L9;
            float r14 = 1.0f - p.a.a(Math.abs(r13 / this.f17511a.height()), 0.0f, 1.0f);
            float r15 = (-r13) - ((this.f17511a.height() * 0.3f) * (1.0f - (r14 * r14)));
            r11.setTranslationY(r15);
            r11.getDrawingRect(this.f17512b);
            this.f17512b.offset(0, (int) (-r15));
            if (r15 < this.f17512b.height()) goto L7;
            r11.setVisibility(4);
        L8:
            ViewCompat.w0(r11, this.f17512b);
            return;
        L7:
            r11.setVisibility(0);
            goto L8
        L9:
            ViewCompat.w0(r11, null);
            r11.setTranslationY(0.0f);
            r11.setVisibility(0);
        }
    }

    public BaseBehavior() {
    }

    public static /* synthetic */ boolean b(BaseBehavior r10) {
        return r10.f17495p;
    }

    public static boolean checkFlag(int r10, int r11) {
        if ((r10 & r11) != r11) goto L5;
        return true;
    L5:
        return false;
    }

    private void e(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, float r13) {
        int r14 = Math.abs(getTopBottomOffsetForScrollingSibling() - r12);
        float r15 = Math.abs(r13);
        if (r15 <= 0.0f) goto L5;
        int r16 = Math.round((r14 / r15) * 1000.0f) * 3;
    L6:
        f(r10, r11, r12, r16);
        return;
    L5:
        r16 = (int) (((r14 / r11.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    public static View k(OUnitedTitleBar r10, int r11) {
        int r12 = Math.abs(r11);
        int r13 = r10.getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L10;
        View r15 = r10.getChildAt(r14);
        if (r12 < r15.getTop()) goto L9;
        if (r12 > r15.getBottom()) goto L9;
        return r15;
    L9:
        r14 = r14 + 1;
        goto L3
    L10:
        return null;
    }

    public SavedState A(Parcelable r10, OUnitedTitleBar r11) {
        int r12 = getTopAndBottomOffset();
        int r13 = r11.getChildCount();
        boolean r14 = false;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L26;
        View r16 = r11.getChildAt(r15);
        int r17 = r16.getBottom() + r12;
        if ((r16.getTop() + r12) > 0) goto L25;
        if (r17 < 0) goto L25;
        if (r10 != null) goto L10;
        r10 = AbsSavedState.EMPTY_STATE;
    L10:
        SavedState r18 = new SavedState(r10);
        if (r12 != 0) goto L13;
        boolean r19 = true;
    L14:
        r18.fullyExpanded = r19;
        if (r19 == false) goto L17;
    L19:
        boolean r20 = false;
    L20:
        r18.fullyScrolled = r20;
        r18.firstVisibleChildIndex = r15;
        if (r17 != (ViewCompat.B(r16) + r11.getTopInset())) goto L23;
        r14 = true;
    L23:
        r18.firstVisibleChildAtMinimumHeight = r14;
        r18.firstVisibleChildPercentageShown = r17 / r16.getHeight();
        return r18;
    L17:
        if ((-r12) < r11.getTotalScrollRange()) goto L19;
        r20 = true;
        goto L20
    L13:
        r19 = false;
    L25:
        r15 = r15 + 1;
        goto L3
    L26:
        return null;
    }

    public int B(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, int r14) {
        int r15 = getTopBottomOffsetForScrollingSibling();
        int r16 = 0;
        if (r13 == 0) goto L30;
        if (r15 < r13) goto L30;
        if (r15 > r14) goto L30;
        int r17 = p.a.b(r12, r13, r14);
        if (r15 != r17) goto L9;
    L31:
        E(r10, r11);
        return r16;
    L9:
        if (r11.m() == false) goto L11;
        int r18 = p(r11, r17);
    L12:
        boolean r19 = setTopAndBottomOffset(r18);
        int r110 = r15 - r17;
        this.f17490k = r17 - r18;
        int r111 = 1;
        if (r19 == true) goto L15;
    L22:
        if (r19 == false) goto L24;
    L26:
        r11.i(getTopAndBottomOffset());
        if (r17 >= r15) goto L29;
        r111 = -1;
    L29:
        F(r10, r11, r17, r111, false);
        r16 = r110;
        goto L31
    L24:
        if (r11.m() == false) goto L26;
        r10.dispatchDependentViewsChanged(r11);
    L15:
        if (r16 >= r11.getChildCount()) goto L22;
        LayoutParams r20 = (LayoutParams) r11.getChildAt(r16).getLayoutParams();
        e r21 = r20.b();
        if (r21 == null) goto L21;
        if ((r20.c() & 1) == 0) goto L21;
        r21.a(r11, r11.getChildAt(r16), getTopAndBottomOffset());
    L21:
        r16 = r16 + 1;
        goto L15
    L11:
        r18 = r17;
    L30:
        this.f17490k = 0;
        goto L31
    }

    public final boolean C(CoordinatorLayout r10, OUnitedTitleBar r11) {
        List<View> r12 = r10.getDependents(r11);
        int r13 = r12.size();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        CoordinatorLayout.Behavior r15 = ((CoordinatorLayout.c) r12.get(r14).getLayoutParams()).f();
        if ((r15 instanceof ScrollingViewBehavior) == true) goto L7;
        r14 = r14 + 1;
        goto L3
    L7:
        if (((ScrollingViewBehavior) r15).getOverlayTop() == 0) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    public final void D(CoordinatorLayout r10, OUnitedTitleBar r11) {
        int r12 = r11.getTopInset() + r11.getPaddingTop();
        int r13 = getTopBottomOffsetForScrollingSibling() - r12;
        int r14 = l(r11, r13);
        if (r14 < 0) goto L27;
        View r15 = r11.getChildAt(r14);
        LayoutParams r16 = (LayoutParams) r15.getLayoutParams();
        int r17 = r16.c();
        if ((r17 & 17) != 17) goto L28;
        int r18 = -r15.getTop();
        int r19 = -r15.getBottom();
        if (r14 != 0) goto L14;
        if (ViewCompat.x(r11) == false) goto L14;
        if (ViewCompat.x(r15) == false) goto L14;
        r18 = r18 - r11.getTopInset();
    L14:
        if (checkFlag(r17, 2) == false) goto L17;
        r19 = r19 + ViewCompat.B(r15);
    L23:
        if (checkFlag(r17, 32) == false) goto L25;
        r18 = r18 + ((FrameLayout.LayoutParams) r16).topMargin;
        r19 = r19 - ((FrameLayout.LayoutParams) r16).bottomMargin;
    L25:
        e(r10, r11, p.a.b(g(r13, r19, r18) + r12, -r11.getTotalScrollRange(), 0), 0.0f);
        return;
    L17:
        if (checkFlag(r17, 5) == false) goto L23;
        int r20 = ViewCompat.B(r15) + r19;
        if (r13 >= r20) goto L21;
        r18 = r20;
        goto L23
    L21:
        r19 = r20;
        goto L23
    L28:
        return;
    }

    public final void E(CoordinatorLayout r10, OUnitedTitleBar r11) {
        ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2750q.b());
        ViewCompat.j0(r10, AccessibilityNodeInfoCompat.a.f2751r.b());
        if (r11.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        View r12 = m(r10);
        if (r12 != null) goto L9;
        return;
    L9:
        if (j(r11) == true) goto L12;
        return;
    L12:
        if (ViewCompat.N(r10) == true) goto L14;
        ViewCompat.p0(r10, new b(this));
    L14:
        this.f17495p = c(r10, r11, r12);
    }

    public final void F(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, boolean r14) {
        View r15 = k(r11, r12);
        boolean r16 = false;
        if (r15 == null) goto L19;
        int r17 = ((LayoutParams) r15.getLayoutParams()).c();
        if ((r17 & 1) == 0) goto L19;
        int r18 = ViewCompat.B(r15);
        if (r13 <= 0) goto L14;
        if ((r17 & 12) == 0) goto L14;
        if ((-r12) < ((r15.getBottom() - r18) - r11.getTopInset())) goto L19;
    L12:
        r16 = true;
    L14:
        if ((r17 & 2) == 0) goto L19;
        if ((-r12) >= ((r15.getBottom() - r18) - r11.getTopInset())) goto L12;
    L19:
        if (r11.q() == false) goto L21;
        r16 = r11.x(findFirstScrollingChild(r10));
    L21:
        boolean r19 = r11.u(r16);
        if (r14 == true) goto L27;
        if (r19 == true) goto L25;
        return;
    L25:
        if (C(r10, r11) == true) goto L27;
        return;
    L27:
        if (r11.getBackground() == null) goto L30;
        r11.getBackground().jumpToCurrentState();
    L30:
        if (r11.getForeground() == null) goto L33;
        r11.getForeground().jumpToCurrentState();
    L33:
        if (r11.getStateListAnimator() == null) goto L38;
        r11.getStateListAnimator().jumpToCurrentState();
        return;
    }

    public final boolean c(CoordinatorLayout r11, OUnitedTitleBar r12, View r13) {
        boolean r10 = false;
        if (getTopBottomOffsetForScrollingSibling() == (-r12.getTotalScrollRange())) goto L6;
        d(r11, r12, AccessibilityNodeInfoCompat.a.f2750q, false);
        r10 = true;
    L6:
        if (getTopBottomOffsetForScrollingSibling() == 0) goto L14;
        if (r13.canScrollVertically(-1) == false) goto L12;
        int r14 = -r12.getDownNestedPreScrollRange();
        if (r14 == 0) goto L14;
        ViewCompat.l0(r11, AccessibilityNodeInfoCompat.a.f2751r, null, new c(this, r11, r12, r13, r14));
        return true;
    L12:
        d(r11, r12, AccessibilityNodeInfoCompat.a.f2751r, true);
        return true;
    L14:
        return r10;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ boolean canDragView(View r10) {
        return h((OUnitedTitleBar) r10);
    }

    public final void d(CoordinatorLayout r10, OUnitedTitleBar r11, AccessibilityNodeInfoCompat.a r12, boolean r13) {
        ViewCompat.l0(r10, r12, null, new d(this, r11, r13));
    }

    public final void f(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13) {
        int r14 = getTopBottomOffsetForScrollingSibling();
        if (r14 != r12) goto L10;
        ValueAnimator r15 = this.f17492m;
        if (r15 != null) goto L7;
        return;
    L7:
        if (r15.isRunning() == false) goto L17;
        this.f17492m.cancel();
        return;
    L17:
        return;
    L10:
        ValueAnimator r16 = this.f17492m;
        if (r16 != null) goto L13;
        ValueAnimator r17 = new ValueAnimator();
        this.f17492m = r17;
        r17.setInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        this.f17492m.addUpdateListener(new a(this, r10, r11));
    L14:
        this.f17492m.setDuration(Math.min(r13, 600));
        this.f17492m.setIntValues(new int[]{r14, r12});
        this.f17492m.start();
        return;
    L13:
        r16.cancel();
        goto L14
    }

    public final View findFirstScrollingChild(CoordinatorLayout r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L13;
        View r13 = r10.getChildAt(r12);
        if ((r13 instanceof NestedScrollingChild) == true) goto L12;
        if ((r13 instanceof AbsListView) == true) goto L12;
        if ((r13 instanceof ScrollView) == true) goto L12;
        r12 = r12 + 1;
    L12:
        return r13;
    L13:
        return null;
    }

    public final int g(int r10, int r11, int r12) {
        if (r10 >= ((r11 + r12) / 2)) goto L6;
        return r11;
    L6:
        return r12;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getMaxDragOffset(View r10) {
        return n((OUnitedTitleBar) r10);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r10) {
        return o((OUnitedTitleBar) r10);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.f17490k;
    }

    public boolean h(OUnitedTitleBar r10) {
        WeakReference r11 = this.f17494o;
        if (r11 == null) goto L13;
        View r12 = (View) r11.get();
        if (r12 != null) goto L7;
    L11:
        return false;
    L7:
        if (r12.isShown() == false) goto L11;
        if (r12.canScrollVertically(-1) == true) goto L11;
        return true;
    L13:
        return true;
    }

    public final boolean i(CoordinatorLayout r10, OUnitedTitleBar r11, View r12) {
        if (r11.n() == true) goto L5;
    L7:
        return false;
    L5:
        if ((r10.getHeight() - r12.getHeight()) > r11.getHeight()) goto L7;
        return true;
    }

    public final boolean j(OUnitedTitleBar r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (((LayoutParams) r10.getChildAt(r12).getLayoutParams()).f17496a != 0) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public final int l(OUnitedTitleBar r10, int r11) {
        int r12 = r10.getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        View r14 = r10.getChildAt(r13);
        int r15 = r14.getTop();
        int r16 = r14.getBottom();
        LayoutParams r17 = (LayoutParams) r14.getLayoutParams();
        if (checkFlag(r17.c(), 32) == false) goto L7;
        r15 = r15 - ((FrameLayout.LayoutParams) r17).topMargin;
        r16 = r16 + ((FrameLayout.LayoutParams) r17).bottomMargin;
    L7:
        int r18 = -r11;
        if (r15 > r18) goto L11;
        if (r16 < r18) goto L11;
        return r13;
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        return -1;
    }

    public final View m(CoordinatorLayout r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        View r13 = r10.getChildAt(r12);
        if ((((CoordinatorLayout.c) r13.getLayoutParams()).f() instanceof ScrollingViewBehavior) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return null;
    }

    public int n(OUnitedTitleBar r10) {
        return (-r10.getDownNestedScrollRange()) + r10.getTopInset();
    }

    public int o(OUnitedTitleBar r10) {
        return r10.getTotalScrollRange();
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r10, View r11) {
        q(r10, (OUnitedTitleBar) r11);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
        return r(r10, (OUnitedTitleBar) r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r10, View r11, int r12, int r13, int r14, int r15) {
        return s(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int[] r15, int r16) {
        t(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13, int r14, int r15, int r16, int r17) {
        u(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r10, View r11, Parcelable r12) {
        v(r10, (OUnitedTitleBar) r11, r12);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r10, View r11) {
        return w(r10, (OUnitedTitleBar) r11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r10, View r11, View r12, View r13, int r14, int r15) {
        return x(r10, (OUnitedTitleBar) r11, r12, r13, r14, r15);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r10, View r11, View r12, int r13) {
        y(r10, (OUnitedTitleBar) r11, r12, r13);
    }

    public final int p(OUnitedTitleBar r10, int r11) {
        int r12 = Math.abs(r11);
        int r13 = r10.getChildCount();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L21;
        View r16 = r10.getChildAt(r15);
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        Interpolator r18 = r17.d();
        if (r12 < r16.getTop()) goto L20;
        if (r12 > r16.getBottom()) goto L20;
        if (r18 == null) goto L21;
        int r19 = r17.c();
        if ((r19 & 1) == 0) goto L15;
        r14 = (r16.getHeight() + ((FrameLayout.LayoutParams) r17).topMargin) + ((FrameLayout.LayoutParams) r17).bottomMargin;
        if ((r19 & 2) == 0) goto L15;
        r14 = r14 - ViewCompat.B(r16);
    L15:
        if (ViewCompat.x(r16) == false) goto L17;
        r14 = r14 - r10.getTopInset();
    L17:
        if (r14 <= 0) goto L21;
        float r20 = r14;
        return Integer.signum(r11) * (r16.getTop() + Math.round(r20 * r18.getInterpolation((r12 - r16.getTop()) / r20)));
    L20:
        r15 = r15 + 1;
    L21:
        return r11;
    }

    public void q(CoordinatorLayout r10, OUnitedTitleBar r11) {
        D(r10, r11);
        if (r11.q() == false) goto L6;
        r11.u(r11.x(findFirstScrollingChild(r10)));
        return;
    }

    public boolean r(CoordinatorLayout r10, OUnitedTitleBar r11, int r12) {
        boolean r13 = super.onLayoutChild(r10, r11, r12);
        int r14 = r11.getPendingAction();
        SavedState r15 = this.f17493n;
        if (r15 != null) goto L5;
    L18:
        if (r14 != 0) goto L20;
    L34:
        r11.t();
        this.f17493n = null;
        setTopAndBottomOffset(p.a.b(getTopAndBottomOffset(), -r11.getTotalScrollRange(), 0));
        F(r10, r11, getTopAndBottomOffset(), 0, true);
        r11.i(getTopAndBottomOffset());
        E(r10, r11);
        return r13;
    L20:
        if ((r14 & 4) == 0) goto L22;
        boolean r16 = true;
    L24:
        if ((r14 & 1) == 0) goto L30;
        int r17 = -r11.getUpNestedPreScrollRange();
        if (r16 == false) goto L28;
        e(r10, r11, r17, 0.0f);
        goto L34
    L28:
        setHeaderTopBottomOffset(r10, r11, r17);
        goto L34
    L30:
        if ((r14 & 16) == 0) goto L34;
        if (r16 == false) goto L33;
        e(r10, r11, 0, 0.0f);
        goto L34
    L33:
        setHeaderTopBottomOffset(r10, r11, 0);
        goto L34
    L22:
        r16 = false;
        goto L24
    L5:
        if ((r14 & 8) != 0) goto L18;
        if (r15.fullyScrolled == false) goto L10;
        setHeaderTopBottomOffset(r10, r11, -r11.getTotalScrollRange());
        goto L34
    L10:
        if (r15.fullyExpanded == false) goto L12;
        setHeaderTopBottomOffset(r10, r11, 0);
        goto L34
    L12:
        View r18 = r11.getChildAt(r15.firstVisibleChildIndex);
        int r19 = -r18.getBottom();
        if (this.f17493n.firstVisibleChildAtMinimumHeight == false) goto L16;
        int r20 = ViewCompat.B(r18) + r11.getTopInset();
    L17:
        setHeaderTopBottomOffset(r10, r11, r19 + r20);
        goto L34
    L16:
        r20 = Math.round(r18.getHeight() * this.f17493n.firstVisibleChildPercentageShown);
        goto L17
    }

    public boolean s(CoordinatorLayout r10, OUnitedTitleBar r11, int r12, int r13, int r14, int r15) {
        if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.c) r11.getLayoutParams())).height != (-2)) goto L7;
        r10.onMeasureChild(r11, r12, r13, View.MeasureSpec.makeMeasureSpec(0, 0), r15);
        return true;
    L7:
        return super.onMeasureChild(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r10, View r11, int r12, int r13, int r14) {
        return B(r10, (OUnitedTitleBar) r11, r12, r13, r14);
    }

    public void t(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13, int r14, int[] r15, int r16) {
        if (r14 == 0) goto L10;
        if (r14 >= 0) goto L6;
        int r17 = -r11.getTotalScrollRange();
        int r18 = r11.getDownNestedPreScrollRange() + r17;
    L5:
        int r19 = r17;
        int r20 = r18;
        if (r19 == r20) goto L10;
        r15[1] = scroll(r10, r11, r14, r19, r20);
        goto L10
    L6:
        r17 = -r11.getUpNestedPreScrollRange();
        r18 = 0;
    L10:
        if (r11.q() == false) goto L13;
        r11.u(r11.x(r12));
        return;
    }

    public void u(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13, int r14, int r15, int r16, int r17) {
        if (r16 >= 0) goto L4;
        scroll(r10, r11, r16, -r11.getDownNestedScrollRange(), 0);
    L4:
        if (r16 != 0) goto L7;
        E(r10, r11);
        return;
    }

    public void v(CoordinatorLayout r10, OUnitedTitleBar r11, Parcelable r12) {
        if ((r12 instanceof SavedState) == false) goto L5;
        z((SavedState) r12, true);
        super.onRestoreInstanceState(r10, r11, this.f17493n.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r10, r11, r12);
        this.f17493n = null;
    }

    public Parcelable w(CoordinatorLayout r10, OUnitedTitleBar r11) {
        Parcelable r12 = super.onSaveInstanceState(r10, r11);
        SavedState r13 = A(r12, r11);
        if (r13 != null) goto L6;
        return r12;
    L6:
        return r13;
    }

    public boolean x(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, View r13, int r14, int r15) {
        if ((r14 & 2) != 0) goto L5;
    L9:
        boolean r16 = false;
    L10:
        if (r16 == false) goto L14;
        ValueAnimator r17 = this.f17492m;
        if (r17 == null) goto L14;
        r17.cancel();
    L14:
        this.f17494o = null;
        this.f17491l = r15;
        return r16;
    L5:
        if (r11.q() == false) goto L7;
    L8:
        r16 = true;
        goto L10
    L7:
        if (i(r10, r11, r12) == false) goto L9;
        goto L8
    }

    public void y(CoordinatorLayout r10, OUnitedTitleBar r11, View r12, int r13) {
        if (this.f17491l != 0) goto L5;
    L6:
        D(r10, r11);
        if (r11.q() == false) goto L9;
        r11.u(r11.x(r12));
    L9:
        this.f17494o = new WeakReference(r12);
        return;
    L5:
        if (r13 != 1) goto L9;
        goto L6
    }

    public void z(SavedState r10, boolean r11) {
        if (this.f17493n == null) goto L5;
        if (r11 == true) goto L5;
        return;
    L5:
        this.f17493n = r10;
    }

    public BaseBehavior(Context r10, AttributeSet r11) {
        super(r10, r11);
    }
}

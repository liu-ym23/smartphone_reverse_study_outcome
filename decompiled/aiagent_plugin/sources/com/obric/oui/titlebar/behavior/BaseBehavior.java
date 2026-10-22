package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.l;
import androidx.customview.view.AbsSavedState;
import com.obric.aiagent.plugin.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36661a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ValueAnimator f36663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SavedState f36664e;
    private WeakReference<View> f;
    private a g;
    private boolean h;

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int a(CoordinatorLayout r7, View r8, int r9, int r10, int r11) {
            return super.a(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r9, r10, r11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ void a(CoordinatorLayout r3, View r4, Parcelable r5) {
            Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.aiagent.plugin");
            super.a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ void a(CoordinatorLayout r3, View r4, View r5, int r6) {
            super.a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r5, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ void a(CoordinatorLayout r11, View r12, View r13, int r14, int r15, int r16, int r17, int r18) {
            super.a(r11, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r12, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r13, r14, r15, r16, r17, r18);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ void a(CoordinatorLayout r9, View r10, View r11, int r12, int r13, int[] r14, int r15) {
            super.a(r9, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r10, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, r15);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ boolean a(View r3) {
            return super.a((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.a, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r3, View r4, int r5) {
            return super.a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r8, View r9, int r10, int r11, int r12, int r13) {
            return super.a(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ boolean a(CoordinatorLayout r8, View r9, View r10, View r11, int r12, int r13) {
            return super.a(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int b(View r3) {
            return super.b((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ int c(View r3) {
            return super.c((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.b
        public /* synthetic */ Parcelable d(CoordinatorLayout r3, View r4) {
            return super.b(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* synthetic */ void e(CoordinatorLayout r3, View r4) {
            super.a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
        }

        public Behavior() {
        }

        public Behavior(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private b scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        public LayoutParams(Context r5, AttributeSet r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
            super(r7, r8);
            this.scrollFlags = 1;
            TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollFlags, "styleable", "AppBarLayout_Layout_layout_scrollFlags"), 0);
            setScrollEffect(0);
            if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, "styleable", "AppBarLayout_Layout_layout_scrollInterpolator")) == false) goto L5;
            this.scrollInterpolator = AnimationUtils.loadInterpolator(r7, r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, "styleable", "AppBarLayout_Layout_layout_scrollInterpolator"), 0));
        L5:
            r9.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.scrollFlags = 1;
            this.scrollFlags = r2.scrollFlags;
            this.scrollEffect = r2.scrollEffect;
            this.scrollInterpolator = r2.scrollInterpolator;
        }

        public void setScrollFlags(int r1) {
            this.scrollFlags = r1;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        private b createScrollEffectFromInt(int r1) {
            if (r1 == 1) goto L7;
            return null;
        L7:
            return new c();
        }

        public b getScrollEffect() {
            return this.scrollEffect;
        }

        public void setScrollEffect(b r1) {
            this.scrollEffect = r1;
        }

        public void setScrollEffect(int r1) {
            this.scrollEffect = createScrollEffectFromInt(r1);
        }

        public void setScrollInterpolator(Interpolator r3) {
            this.scrollInterpolator = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r3, Interpolator.class, "com.obric.aiagent.plugin");
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        boolean isCollapsible() {
            int r2 = this.scrollFlags;
            if ((r2 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r2 & 10) == 0) goto L7;
            return true;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean firstVisibleChildAtMinimumHeight;
        int firstVisibleChildIndex;
        float firstVisibleChildPercentageShown;
        boolean fullyExpanded;
        boolean fullyScrolled;

        public SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            boolean r0 = true;
            if (r3.readByte() == 0) goto L5;
            boolean r5 = true;
        L6:
            this.fullyScrolled = r5;
            if (r3.readByte() == 0) goto L9;
            boolean r6 = true;
        L10:
            this.fullyExpanded = r6;
            this.firstVisibleChildIndex = r3.readInt();
            this.firstVisibleChildPercentageShown = r3.readFloat();
            if (r3.readByte() != 0) goto L14;
            r0 = false;
        L14:
            this.firstVisibleChildAtMinimumHeight = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeByte(this.fullyScrolled ? 1 : 0);
            r1.writeByte(this.fullyExpanded ? 1 : 0);
            r1.writeInt(this.firstVisibleChildIndex);
            r1.writeFloat(this.firstVisibleChildPercentageShown);
            r1.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static abstract class a<T extends OUnitedTitleBar> {
        public abstract boolean a(T r1);
    }

    public static abstract class b {
        public abstract void a(OUnitedTitleBar r1, View r2, float r3);

        public b() {
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f36674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Rect f36675b;

        public c() {
            this.f36674a = new Rect();
            this.f36675b = new Rect();
        }

        private static void a(Rect r0, OUnitedTitleBar r1, View r2) {
            r2.getDrawingRect(r0);
            r1.offsetDescendantRectToMyCoords(r2, r0);
            r0.offset(0, -r1.getTopInset());
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior.b
        public void a(OUnitedTitleBar r4, View r5, float r6) {
            a(this.f36674a, r4, r5);
            float r7 = this.f36674a.top - Math.abs(r6);
            if (r7 > 0.0f) goto L9;
            float r8 = 1.0f - androidx.core.a.a.a(Math.abs(r7 / this.f36674a.height()), 0.0f, 1.0f);
            float r9 = (-r7) - ((this.f36674a.height() * 0.3f) * (1.0f - (r8 * r8)));
            r5.setTranslationY(r9);
            r5.getDrawingRect(this.f36675b);
            this.f36675b.offset(0, (int) (-r9));
            if (r9 < this.f36675b.height()) goto L7;
            r5.setVisibility(4);
        L8:
            ViewCompat.a(r5, this.f36675b);
            return;
        L7:
            r5.setVisibility(0);
            goto L8
        L9:
            ViewCompat.a(r5, null);
            r5.setTranslationY(0.0f);
            r5.setVisibility(0);
        }
    }

    private static boolean a(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean a(BaseBehavior r0) {
        return r0.h;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ int a(CoordinatorLayout r7, View r8, int r9, int r10, int r11) {
        return a(r7, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r8, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ void a(CoordinatorLayout r3, View r4, Parcelable r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.aiagent.plugin");
        a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ void a(CoordinatorLayout r3, View r4, View r5, int r6) {
        a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r5, r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ void a(CoordinatorLayout r11, View r12, View r13, int r14, int r15, int r16, int r17, int r18) {
        a(r11, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r12, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r13, r14, r15, r16, r17, r18);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ void a(CoordinatorLayout r9, View r10, View r11, int r12, int r13, int[] r14, int r15) {
        a(r9, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r10, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, r15);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ boolean a(View r3) {
        return a((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.a, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ boolean a(CoordinatorLayout r3, View r4, int r5) {
        return a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ boolean a(CoordinatorLayout r8, View r9, int r10, int r11, int r12, int r13) {
        return a(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ boolean a(CoordinatorLayout r8, View r9, View r10, View r11, int r12, int r13) {
        return a(r8, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r9, OUnitedTitleBar.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ int b(View r3) {
        return b((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ int c(View r3) {
        return c((OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r3, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public /* synthetic */ Parcelable d(CoordinatorLayout r3, View r4) {
        return b(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* synthetic */ void e(CoordinatorLayout r3, View r4) {
        a(r3, (OUnitedTitleBar) ZeusTransformUtils.preCheckCast(r4, OUnitedTitleBar.class, "com.obric.aiagent.plugin"));
    }

    public BaseBehavior() {
    }

    public BaseBehavior(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public boolean a(CoordinatorLayout r1, T r2, View r3, View r4, int r5, int r6) {
        if ((r5 & 2) != 0) goto L5;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L14;
        ValueAnimator r8 = this.f36663d;
        if (r8 == null) goto L14;
        r8.cancel();
    L14:
        this.f = null;
        this.f36662c = r6;
        return r7;
    L5:
        if (r2.isLiftOnScroll() == false) goto L7;
    L8:
        r7 = true;
        goto L10
    L7:
        if (a(r1, r2, r3) == false) goto L9;
        goto L8
    }

    private boolean a(CoordinatorLayout r1, T r2, View r3) {
        if (r2.hasScrollableChildren() == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L7;
        return true;
    }

    public void a(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int[] r12, int r13) {
        if (r11 == 0) goto L10;
        if (r11 >= 0) goto L5;
        int r14 = -r8.getTotalScrollRange();
        int r15 = r8.getDownNestedPreScrollRange() + r14;
    L6:
        int r4 = r14;
        int r5 = r15;
        if (r4 == r5) goto L10;
        r12[1] = b(r7, r8, r11, r4, r5);
        goto L10
    L5:
        r14 = -r8.getUpNestedPreScrollRange();
        r15 = 0;
    L10:
        if (r8.isLiftOnScroll() == false) goto L13;
        r8.setLiftedState(r8.shouldLift(r9));
        return;
    }

    public void a(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int r12, int r13, int r14) {
        if (r13 >= 0) goto L4;
        b(r7, r8, r13, -r8.getDownNestedScrollRange(), 0);
    L4:
        if (r13 != 0) goto L7;
        d(r7, r8);
        return;
    }

    public void a(CoordinatorLayout r2, T r3, View r4, int r5) {
        if (this.f36662c != 0) goto L5;
    L6:
        c(r2, r3);
        if (r3.isLiftOnScroll() == false) goto L9;
        r3.setLiftedState(r3.shouldLift(r4));
    L9:
        this.f = new WeakReference(r4);
        return;
    L5:
        if (r5 != 1) goto L9;
        goto L6
    }

    private void a(CoordinatorLayout r3, T r4, int r5, float r6) {
        int r0 = Math.abs(b() - r5);
        float r7 = Math.abs(r6);
        if (r7 <= 0.0f) goto L5;
        int r8 = Math.round((r0 / r7) * 1000.0f) * 3;
    L6:
        a(r3, r4, r5, r8);
        return;
    L5:
        r8 = (int) (((r0 / r4.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    private void a(final CoordinatorLayout r4, final T r5, int r6, int r7) {
        int r0 = b();
        if (r0 != r6) goto L10;
        ValueAnimator r8 = this.f36663d;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isRunning() == false) goto L17;
        this.f36663d.cancel();
        return;
    L17:
        return;
    L10:
        ValueAnimator r1 = this.f36663d;
        if (r1 != null) goto L13;
        ValueAnimator r2 = new ValueAnimator();
        this.f36663d = r2;
        r2.setInterpolator(com.google.android.material.animation.a.f13146e);
        this.f36663d.addUpdateListener(new AnonymousClass1(this, r4, r5));
    L14:
        this.f36663d.setDuration(Math.min(r7, 600));
        this.f36663d.setIntValues(new int[]{r0, r6});
        this.f36663d.start();
        return;
    L13:
        r1.cancel();
        goto L14
    }

    private int a(T r7, int r8) {
        int r6 = r7.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L12;
        View r1 = r7.getChildAt(r0);
        int r2 = r1.getTop();
        int r3 = r1.getBottom();
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (a(r4.getScrollFlags(), 32) == false) goto L7;
        r2 = r2 - r4.topMargin;
        r3 = r3 + r4.bottomMargin;
    L7:
        int r5 = -r8;
        if (r2 > r5) goto L11;
        if (r3 < r5) goto L11;
        return r0;
    L11:
        r0 = r0 + 1;
        goto L3
    L12:
        return -1;
    }

    private void c(CoordinatorLayout r9, T r10) {
        int r0 = r10.getTopInset() + r10.getPaddingTop();
        int r1 = b() - r0;
        int r2 = a(r10, r1);
        if (r2 < 0) goto L27;
        View r3 = r10.getChildAt(r2);
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r5 = r4.getScrollFlags();
        if ((r5 & 17) != 17) goto L28;
        int r6 = -r3.getTop();
        int r7 = -r3.getBottom();
        if (r2 != 0) goto L14;
        if (ViewCompat.v(r10) == false) goto L14;
        if (ViewCompat.v(r3) == false) goto L14;
        r6 = r6 - r10.getTopInset();
    L14:
        if (a(r5, 2) == false) goto L17;
        r7 = r7 + ViewCompat.o(r3);
    L23:
        if (a(r5, 32) == false) goto L25;
        r6 = r6 + r4.topMargin;
        r7 = r7 - r4.bottomMargin;
    L25:
        a(r9, r10, androidx.core.a.a.a(a(r1, r7, r6) + r0, -r10.getTotalScrollRange(), 0), 0.0f);
        return;
    L17:
        if (a(r5, 5) == false) goto L23;
        int r8 = ViewCompat.o(r3) + r7;
        if (r1 >= r8) goto L21;
        r6 = r8;
        goto L23
    L21:
        r7 = r8;
        goto L23
    L28:
        return;
    }

    private int a(int r1, int r2, int r3) {
        if (r1 >= ((r2 + r3) / 2)) goto L6;
        return r2;
    L6:
        return r3;
    }

    public boolean a(CoordinatorLayout r7, T r8, int r9, int r10, int r11, int r12) {
        if (((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).height != (-2)) goto L7;
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
        return true;
    L7:
        return super.a(r7, r8, r9, r10, r11, r12);
    }

    public boolean a(CoordinatorLayout r8, T r9, int r10) {
        boolean r11 = super.a(r8, r9, r10);
        int r0 = r9.getPendingAction();
        SavedState r1 = this.f36664e;
        if (r1 != null) goto L5;
    L17:
        if (r0 != 0) goto L19;
    L33:
        r9.resetPendingAction();
        this.f36664e = null;
        a(androidx.core.a.a.a(d(), -r9.getTotalScrollRange(), 0));
        a(r8, r9, d(), 0, true);
        r9.dispatchOffsetChange(d());
        d(r8, r9);
        return r11;
    L19:
        if ((r0 & 4) == 0) goto L21;
        boolean r2 = true;
    L23:
        if ((r0 & 1) == 0) goto L29;
        int r3 = -r9.getUpNestedPreScrollRange();
        if (r2 == false) goto L27;
        a(r8, r9, r3, 0.0f);
        goto L33
    L27:
        b_(r8, r9, r3);
        goto L33
    L29:
        if ((r0 & 16) == 0) goto L33;
        if (r2 == false) goto L32;
        a(r8, r9, 0, 0.0f);
        goto L33
    L32:
        b_(r8, r9, 0);
        goto L33
    L21:
        r2 = false;
        goto L23
    L5:
        if ((r0 & 8) != 0) goto L17;
        if (r1.fullyScrolled == false) goto L10;
        b_(r8, r9, -r9.getTotalScrollRange());
        goto L33
    L10:
        if (this.f36664e.fullyExpanded == false) goto L12;
        b_(r8, r9, 0);
        goto L33
    L12:
        View r4 = r9.getChildAt(this.f36664e.firstVisibleChildIndex);
        int r5 = -r4.getBottom();
        if (this.f36664e.firstVisibleChildAtMinimumHeight == false) goto L15;
        int r6 = ViewCompat.o(r4) + r9.getTopInset();
    L16:
        b_(r8, r9, r5 + r6);
        goto L33
    L15:
        r6 = Math.round(r4.getHeight() * this.f36664e.firstVisibleChildPercentageShown);
        goto L16
    }

    private void d(CoordinatorLayout r3, T r4) {
        ViewCompat.d(r3, androidx.core.view.accessibility.b.a.m.a());
        ViewCompat.d(r3, androidx.core.view.accessibility.b.a.n.a());
        if (r4.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        View r0 = a(r3);
        if (r0 != null) goto L9;
        return;
    L9:
        if (d(r4) == true) goto L12;
        return;
    L12:
        if (ViewCompat.b(r3) == true) goto L14;
        ViewCompat.a(r3, new AnonymousClass2(this));
    L14:
        this.h = b(r3, r4, r0);
    }

    private View a(CoordinatorLayout r6) {
        int r5 = r6.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L8;
        View r1 = r6.getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior(), ScrollingViewBehavior.class) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    private boolean d(OUnitedTitleBar r6) {
        int r5 = r6.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L9;
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r6.getChildAt(r1).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).scrollFlags != 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean b(final CoordinatorLayout r11, final T r12, final View r13) {
        boolean r2 = false;
        if (b() == (-r12.getTotalScrollRange())) goto L6;
        a(r11, r12, androidx.core.view.accessibility.b.a.m, false);
        r2 = true;
    L6:
        if (b() == 0) goto L14;
        if (r13.canScrollVertically(-1) == false) goto L12;
        final int r9 = -r12.getDownNestedPreScrollRange();
        if (r9 == 0) goto L14;
        ViewCompat.a(r11, androidx.core.view.accessibility.b.a.n, null, new AnonymousClass3(this, r11, r12, r13, r9));
        return true;
    L12:
        a(r11, r12, androidx.core.view.accessibility.b.a.n, true);
        return true;
    L14:
        return r2;
    }

    private void a(CoordinatorLayout r2, final T r3, androidx.core.view.accessibility.b.a r4, final boolean r5) {
        ViewCompat.a(r2, r4, null, new AnonymousClass4(this, r3, r5));
    }

    public boolean a(T r3) {
        a r0 = this.g;
        if (r0 != null) goto L5;
        WeakReference<View> r2 = this.f;
        if (r2 == null) goto L17;
        View r4 = (View) ZeusTransformUtils.preCheckCast(r2.get(), View.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
    L15:
        return false;
    L11:
        if (r4.isShown() == false) goto L15;
        if (r4.canScrollVertically(-1) == true) goto L15;
        return true;
    L17:
        return true;
    L5:
        return r0.a(r3);
    }

    public void a(CoordinatorLayout r2, T r3) {
        c(r2, r3);
        if (r3.isLiftOnScroll() == false) goto L6;
        r3.setLiftedState(r3.shouldLift(b(r2)));
        return;
    }

    public int b(T r1) {
        return (-r1.getDownNestedScrollRange()) + r1.getTopInset();
    }

    public int c(T r1) {
        return r1.getTotalScrollRange();
    }

    public int a(CoordinatorLayout r9, T r10, int r11, int r12, int r13) {
        int r0 = b();
        int r1 = 0;
        if (r12 == 0) goto L30;
        if (r0 < r12) goto L30;
        if (r0 > r13) goto L30;
        int r5 = androidx.core.a.a.a(r11, r12, r13);
        if (r0 != r5) goto L9;
    L31:
        d(r9, r10);
        return r1;
    L9:
        if (r10.hasChildWithInterpolator() == false) goto L11;
        int r14 = b(r10, r5);
    L12:
        boolean r15 = a(r14);
        int r16 = r0 - r5;
        this.f36661a = r5 - r14;
        int r17 = 1;
        if (r15 == true) goto L15;
    L22:
        if (r15 == false) goto L24;
    L26:
        r10.dispatchOffsetChange(d());
        if (r5 >= r0) goto L29;
        r17 = -1;
    L29:
        a(r9, r10, r5, r17, false);
        r1 = r16;
        goto L31
    L24:
        if (r10.hasChildWithInterpolator() == false) goto L26;
        r9.dispatchDependentViewsChanged(r10);
    L15:
        if (r1 >= r10.getChildCount()) goto L22;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getChildAt(r1).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        b r3 = r2.getScrollEffect();
        if (r3 == null) goto L21;
        if ((r2.getScrollFlags() & 1) == 0) goto L21;
        r3.a(r10, r10.getChildAt(r1), d());
    L21:
        r1 = r1 + 1;
        goto L15
    L11:
        r14 = r5;
    L30:
        this.f36661a = 0;
        goto L31
    }

    private int b(T r8, int r9) {
        int r7 = Math.abs(r9);
        int r0 = r8.getChildCount();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        View r3 = r8.getChildAt(r2);
        LayoutParams r4 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        Interpolator r5 = r4.getScrollInterpolator();
        if (r7 < r3.getTop()) goto L20;
        if (r7 > r3.getBottom()) goto L20;
        if (r5 == null) goto L21;
        int r6 = r4.getScrollFlags();
        if ((r6 & 1) == 0) goto L15;
        r1 = 0 + ((r3.getHeight() + r4.topMargin) + r4.bottomMargin);
        if ((r6 & 2) == 0) goto L15;
        r1 = r1 - ViewCompat.o(r3);
    L15:
        if (ViewCompat.v(r3) == false) goto L17;
        r1 = r1 - r8.getTopInset();
    L17:
        if (r1 <= 0) goto L21;
        float r10 = r1;
        return Integer.signum(r9) * (r3.getTop() + Math.round(r10 * r5.getInterpolation((r7 - r3.getTop()) / r10)));
    L20:
        r2 = r2 + 1;
    L21:
        return r9;
    }

    private void a(CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
        View r0 = c(r7, r8);
        boolean r1 = false;
        if (r0 == null) goto L19;
        int r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getScrollFlags();
        if ((r2 & 1) == 0) goto L19;
        int r3 = ViewCompat.o(r0);
        if (r9 <= 0) goto L14;
        if ((r2 & 12) == 0) goto L14;
        if ((-r8) < ((r0.getBottom() - r3) - r7.getTopInset())) goto L19;
    L12:
        r1 = true;
    L14:
        if ((r2 & 2) == 0) goto L19;
        if ((-r8) >= ((r0.getBottom() - r3) - r7.getTopInset())) goto L12;
    L19:
        if (r7.isLiftOnScroll() == false) goto L21;
        r1 = r7.shouldLift(b(r6));
    L21:
        boolean r11 = r7.setLiftedState(r1);
        if (r10 == true) goto L27;
        if (r11 == true) goto L25;
        return;
    L25:
        if (e(r6, r7) == true) goto L27;
        return;
    L27:
        if (r7.getBackground() == null) goto L30;
        r7.getBackground().jumpToCurrentState();
    L30:
        if (Build.VERSION.SDK_INT < 23) goto L35;
        if (r7.getForeground() == null) goto L35;
        r7.getForeground().jumpToCurrentState();
    L35:
        if (Build.VERSION.SDK_INT >= 21) goto L37;
        return;
    L37:
        if (r7.getStateListAnimator() == null) goto L43;
        r7.getStateListAnimator().jumpToCurrentState();
        return;
    }

    private boolean e(CoordinatorLayout r5, T r6) {
        List<View> r4 = r5.getDependents(r6);
        int r7 = r4.size();
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L11;
        CoordinatorLayout.b r1 = ((CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(((View) ZeusTransformUtils.preCheckCast(r4.get(r0), View.class, "com.obric.aiagent.plugin")).getLayoutParams(), CoordinatorLayout.LayoutParams.class, "com.obric.aiagent.plugin")).getBehavior();
        if (ZeusTransformUtils.instanceOf(r1, ScrollingViewBehavior.class) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        if (((ScrollingViewBehavior) ZeusTransformUtils.preCheckCast(r1, ScrollingViewBehavior.class, "com.obric.aiagent.plugin")).e() == 0) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    private static View c(OUnitedTitleBar r4, int r5) {
        int r6 = Math.abs(r5);
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = r4.getChildAt(r1);
        if (r6 < r2.getTop()) goto L9;
        if (r6 > r2.getBottom()) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    private View b(CoordinatorLayout r4) {
        int r3 = r4.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L13;
        View r1 = r4.getChildAt(r0);
        if (ZeusTransformUtils.instanceOf(r1, l.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r1, AbsListView.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r1, ScrollView.class) == true) goto L12;
        r0 = r0 + 1;
    L12:
        return r1;
    L13:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int b() {
        return d() + this.f36661a;
    }

    public Parcelable b(CoordinatorLayout r1, T r2) {
        Parcelable r3 = super.d(r1, r2);
        SavedState r0 = a(r3, r2);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return r0;
    }

    public void a(CoordinatorLayout r3, T r4, Parcelable r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, SavedState.class) == false) goto L5;
        a((SavedState) ZeusTransformUtils.preCheckCast(r6, SavedState.class, "com.obric.aiagent.plugin"), true);
        super.a(r3, r4, this.f36664e.getSuperState());
        return;
    L5:
        super.a(r3, r4, r6);
        this.f36664e = null;
    }

    SavedState a(Parcelable r7, T r8) {
        Parcelable r9 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.aiagent.plugin");
        int r6 = d();
        int r0 = r8.getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        View r3 = r8.getChildAt(r2);
        int r4 = r3.getBottom() + r6;
        if ((r3.getTop() + r6) > 0) goto L25;
        if (r4 < 0) goto L25;
        if (r9 != null) goto L10;
        r9 = AbsSavedState.EMPTY_STATE;
    L10:
        SavedState r5 = new SavedState(r9);
        if (r6 != 0) goto L13;
        boolean r10 = true;
    L14:
        r5.fullyExpanded = r10;
        if (r5.fullyExpanded == false) goto L17;
    L19:
        boolean r11 = false;
    L20:
        r5.fullyScrolled = r11;
        r5.firstVisibleChildIndex = r2;
        if (r4 != (ViewCompat.o(r3) + r8.getTopInset())) goto L23;
        r1 = true;
    L23:
        r5.firstVisibleChildAtMinimumHeight = r1;
        r5.firstVisibleChildPercentageShown = r4 / r3.getHeight();
        return r5;
    L17:
        if ((-r6) < r8.getTotalScrollRange()) goto L19;
        r11 = true;
        goto L20
    L13:
        r10 = false;
    L25:
        r2 = r2 + 1;
        goto L3
    L26:
        return null;
    }

    void a(SavedState r2, boolean r3) {
        if (this.f36664e == null) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        this.f36664e = r2;
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ae;
import androidx.core.view.af;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final a mVisAnimListener;
    protected ae mVisibilityAnim;

    protected class a implements af {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AbsActionBarView f337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f338c;

        public a(AbsActionBarView r1) {
            this.f337b = r1;
            this.f338c = false;
        }

        public a a(ae r2, int r3) {
            this.f337b.mVisibilityAnim = r2;
            this.f336a = r3;
            return this;
        }

        @Override // androidx.core.view.af
        public void a(View r2) {
            AbsActionBarView.access$001(this.f337b, 0);
            this.f338c = false;
        }

        @Override // androidx.core.view.af
        public void b(View r2) {
            if (this.f338c == false) goto L5;
            return;
        L5:
            this.f337b.mVisibilityAnim = null;
            AbsActionBarView.access$101(this.f337b, this.f336a);
        }

        @Override // androidx.core.view.af
        public void c(View r1) {
            this.f338c = true;
        }
    }

    public static int next(int r0, int r1, boolean r2) {
        if (r2 == false) goto L5;
        return r0 - r1;
    L5:
        return r0 + r1;
    }

    static /* synthetic */ void access$001(AbsActionBarView r0, int r1) {
        super.setVisibility(r1);
    }

    static /* synthetic */ void access$101(AbsActionBarView r0, int r1) {
        super.setVisibility(r1);
    }

    AbsActionBarView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    AbsActionBarView(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    AbsActionBarView(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        super(r8, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin"), r7);
        this.mVisAnimListener = new a(this);
        TypedValue r9 = new TypedValue();
        if (r8.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.actionBarPopupTheme, "attr", "actionBarPopupTheme"), r9, true) == true) goto L5;
    L7:
        this.mPopupContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r9.resourceId == 0) goto L7;
        this.mPopupContext = ZeusTransformUtils.wrapperContext(new ContextThemeWrapper(r8, r9.resourceId), "com.obric.aiagent.plugin");
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r6) {
        super.onConfigurationChanged(r6);
        TypedArray r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(null, R.styleable.ActionBar, ZeusTransformUtils.mapRes(R.attr.actionBarStyle, "attr", "actionBarStyle"), 0);
        setContentHeight(r0.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.ActionBar_height, "styleable", "ActionBar_height"), 0));
        r0.recycle();
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 == null) goto L6;
        r5.a(r6);
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r6 = super.onTouchEvent(r5);
        if (r0 != 0) goto L11;
        if (r6 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r0 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r0 != 3) goto L15;
        goto L14
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r7 = super.onHoverEvent(r6);
        if (r0 != 9) goto L12;
        if (r7 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r0 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r0 != 3) goto L16;
        goto L15
    }

    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
        requestLayout();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim == null) goto L7;
        return this.mVisAnimListener.f336a;
    L7:
        return getVisibility();
    }

    public ae setupAnimatorToVisibility(int r3, long r4) {
        ae r0 = this.mVisibilityAnim;
        if (r0 == null) goto L6;
        r0.b();
    L6:
        if (r3 == 0) goto L8;
        ae r1 = ViewCompat.p(this).a(0.0f);
        r1.a(r4);
        r1.a(this.mVisAnimListener.a(r1, r3));
        return r1;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        ae r2 = ViewCompat.p(this).a(1.0f);
        r2.a(r4);
        r2.a(this.mVisAnimListener.a(r2, r3));
        return r2;
    }

    public void animateToVisibility(int r3) {
        setupAnimatorToVisibility(r3, 200).c();
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        if (r2 == getVisibility()) goto L9;
        ae r0 = this.mVisibilityAnim;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        super.setVisibility(r2);
        return;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.c();
    }

    public void postShowOverflowMenu() {
        post(new AnonymousClass1(this));
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.d();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.g();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.h();
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.i() == false) goto L7;
        return true;
    }

    public boolean canShowOverflowMenu() {
        if (isOverflowReserved() == true) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility() != 0) goto L7;
        return true;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter r0 = this.mActionMenuPresenter;
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    public int measureChildView(View r1, int r2, int r3, int r4) {
        r1.measure(View.MeasureSpec.makeMeasureSpec(r2, Integer.MIN_VALUE), r3);
        return Math.max(0, (r2 - r1.getMeasuredWidth()) - r4);
    }

    public int positionChild(View r2, int r3, int r4, int r5, boolean r6) {
        int r1 = r2.getMeasuredWidth();
        int r0 = r2.getMeasuredHeight();
        int r7 = r4 + ((r5 - r0) / 2);
        if (r6 == false) goto L5;
        r2.layout(r3 - r1, r7, r3, r0 + r7);
    L6:
        if (r6 == true) goto L8;
        return r1;
    L8:
        return -r1;
    L5:
        r2.layout(r3, r7, r3 + r1, r0 + r7);
        goto L6
    }
}

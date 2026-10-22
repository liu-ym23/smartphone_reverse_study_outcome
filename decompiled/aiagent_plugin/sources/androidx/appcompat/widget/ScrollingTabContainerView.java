package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final int FADE_DURATION = 200;
    private static final String TAG = "ScrollingTabContainerView";
    private static final Interpolator sAlphaInterpolator = null;
    private boolean mAllowCollapse;
    private int mContentHeight;
    int mMaxTabWidth;
    private int mSelectedTabIndex;
    int mStackedTabMaxWidth;
    private TabClickListener mTabClickListener;
    LinearLayoutCompat mTabLayout;
    Runnable mTabSelector;
    private Spinner mTabSpinner;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimator mVisibilityAnim;

    private class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        TabAdapter(ScrollingTabContainerView r1) {
            this.this$0 = r1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mTabLayout.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            return ((TabView) ZeusTransformUtils.preCheckCast(this.this$0.mTabLayout.getChildAt(r2), TabView.class, "com.obric.aiagent.plugin")).getTab();
        }

        @Override // android.widget.Adapter
        public View getView(int r2, View r3, ViewGroup r4) {
            if (r3 == null) goto L7;
            ((TabView) ZeusTransformUtils.preCheckCast(r3, TabView.class, "com.obric.aiagent.plugin")).bindTab((ActionBar.c) ZeusTransformUtils.preCheckCast(getItem(r2), ActionBar.c.class, "com.obric.aiagent.plugin"));
            return r3;
        L7:
            return this.this$0.createTabView((ActionBar.c) ZeusTransformUtils.preCheckCast(getItem(r2), ActionBar.c.class, "com.obric.aiagent.plugin"), true);
        }
    }

    private class TabClickListener implements View.OnClickListener {
        final /* synthetic */ ScrollingTabContainerView this$0;

        TabClickListener(ScrollingTabContainerView r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r6) {
            ((TabView) ZeusTransformUtils.preCheckCast(r6, TabView.class, "com.obric.aiagent.plugin")).getTab().d();
            int r0 = this.this$0.mTabLayout.getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L9;
            View r3 = this.this$0.mTabLayout.getChildAt(r2);
            if (r3 != r6) goto L7;
            boolean r4 = true;
        L8:
            r3.setSelected(r4);
            r2 = r2 + 1;
            goto L3
        L7:
            r4 = false;
            goto L8
        }
    }

    private class TabView extends LinearLayout {
        private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private ActionBar.c mTab;
        private TextView mTextView;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public TabView(ScrollingTabContainerView r6, Context r7, ActionBar.c r8, boolean r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r6;
            super(r10, null, ZeusTransformUtils.mapRes(R.attr.actionBarTabStyle, "attr", "actionBarTabStyle"));
            int[] r11 = {android.R.attr.background};
            this.BG_ATTRS = r11;
            this.mTab = r8;
            y r12 = y.a(r10, null, r11, ZeusTransformUtils.mapRes(R.attr.actionBarTabStyle, "attr", "actionBarTabStyle"), 0);
            if (r12.g(0) == false) goto L5;
            setBackgroundDrawable(r12.a(0));
        L5:
            r12.b();
            if (r9 == false) goto L8;
            setGravity(8388627);
        L8:
            update();
        }

        public void bindTab(ActionBar.c r1) {
            this.mTab = r1;
            update();
        }

        @Override // android.view.View
        public void setSelected(boolean r2) {
            if (isSelected() == r2) goto L5;
            boolean r0 = true;
        L6:
            super.setSelected(r2);
            if (r0 == false) goto L11;
            if (r2 == false) goto L12;
            sendAccessibilityEvent(4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r1) {
            super.onInitializeAccessibilityEvent(r1);
            r1.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r1) {
            super.onInitializeAccessibilityNodeInfo(r1);
            r1.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            if (this.this$0.mMaxTabWidth > 0) goto L5;
            return;
        L5:
            if (getMeasuredWidth() <= this.this$0.mMaxTabWidth) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.this$0.mMaxTabWidth, 1073741824), r3);
            return;
        }

        public void update() {
            ActionBar.c r0 = this.mTab;
            View r1 = r0.c();
            CharSequence r4 = null;
            if (r1 == null) goto L15;
            ViewParent r2 = r1.getParent();
            if (r2 == this) goto L9;
            if (r2 == null) goto L8;
            ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r1);
        L8:
            addView(r1);
        L9:
            this.mCustomView = r1;
            TextView r3 = this.mTextView;
            if (r3 == null) goto L12;
            r3.setVisibility(8);
        L12:
            ImageView r5 = this.mIconView;
            if (r5 == null) goto L44;
            r5.setVisibility(8);
            this.mIconView.setImageDrawable(null);
            return;
        L44:
            return;
        L15:
            View r6 = this.mCustomView;
            if (r6 == null) goto L18;
            removeView(r6);
            this.mCustomView = null;
        L18:
            Drawable r7 = r0.a();
            CharSequence r8 = r0.b();
            if (r7 != null) goto L21;
            ImageView r9 = this.mIconView;
            if (r9 == null) goto L27;
            r9.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        L27:
            boolean r10 = !TextUtils.isEmpty(r8);
            if (r10 == true) goto L30;
            TextView r11 = this.mTextView;
            if (r11 == null) goto L36;
            r11.setVisibility(8);
            this.mTextView.setText(null);
        L36:
            ImageView r12 = this.mIconView;
            if (r12 == null) goto L39;
            r12.setContentDescription(r0.e());
        L39:
            if (r10 == true) goto L42;
            r4 = r0.e();
        L42:
            aa.a(this, r4);
            return;
        L30:
            if (this.mTextView != null) goto L32;
            AppCompatTextView r13 = new AppCompatTextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, ZeusTransformUtils.mapRes(R.attr.actionBarTabTextStyle, "attr", "actionBarTabTextStyle"));
            r13.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-2, -2);
            r14.gravity = 16;
            r13.setLayoutParams(r14);
            addView(r13);
            this.mTextView = r13;
        L32:
            this.mTextView.setText(r8);
            this.mTextView.setVisibility(0);
            goto L36
        L21:
            if (this.mIconView != null) goto L23;
            AppCompatImageView r15 = new AppCompatImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
            r16.gravity = 16;
            r15.setLayoutParams(r16);
            addView(r15, 0);
            this.mIconView = r15;
        L23:
            this.mIconView.setImageDrawable(r7);
            this.mIconView.setVisibility(0);
            goto L27
        }

        public ActionBar.c getTab() {
            return this.mTab;
        }
    }

    protected class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        private int mFinalVisibility;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public VisibilityAnimListener(ScrollingTabContainerView r1) {
            this.this$0 = r1;
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator r1, int r2) {
            this.mFinalVisibility = r2;
            this.this$0.mVisibilityAnim = r1;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            this.this$0.setVisibility(0);
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            this.this$0.mVisibilityAnim = null;
            this.this$0.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            this.mCanceled = true;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    static {
        sAlphaInterpolator = new DecelerateInterpolator();
    }

    public ScrollingTabContainerView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(r5);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        setHorizontalScrollBarEnabled(false);
        androidx.appcompat.view.a r6 = androidx.appcompat.view.a.a(r5);
        setContentHeight(r6.e());
        this.mStackedTabMaxWidth = r6.g();
        LinearLayoutCompat r7 = createTabLayout();
        this.mTabLayout = r7;
        addView(r7, new ViewGroup.LayoutParams(-2, -1));
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        int r9 = View.MeasureSpec.getMode(r7);
        boolean r0 = true;
        if (r9 != 1073741824) goto L5;
        boolean r3 = true;
    L6:
        setFillViewport(r3);
        int r4 = this.mTabLayout.getChildCount();
        if (r4 <= 1) goto L16;
        if (r9 == 1073741824) goto L12;
        if (r9 != Integer.MIN_VALUE) goto L16;
    L12:
        if (r4 <= 2) goto L14;
        this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(r7) * 0.4f);
    L15:
        this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
    L17:
        int r10 = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (r3 == false) goto L20;
    L22:
        r0 = false;
    L23:
        if (r0 == false) goto L28;
        this.mTabLayout.measure(0, r10);
        if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(r7)) goto L27;
        performCollapse();
    L29:
        int r1 = getMeasuredWidth();
        super.onMeasure(r7, r10);
        int r11 = getMeasuredWidth();
        if (r3 == false) goto L34;
        if (r1 == r11) goto L35;
        setTabSelected(this.mSelectedTabIndex);
        return;
    L35:
        return;
    L34:
        return;
    L27:
        performExpand();
        goto L29
    L28:
        performExpand();
        goto L29
    L20:
        if (this.mAllowCollapse == false) goto L22;
    L14:
        this.mMaxTabWidth = View.MeasureSpec.getSize(r7) / 2;
    L16:
        this.mMaxTabWidth = -1;
        goto L17
    L5:
        r3 = false;
        goto L6
    }

    private boolean isCollapsed() {
        Spinner r0 = this.mTabSpinner;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getParent() != this) goto L7;
        return true;
    }

    public void setAllowCollapse(boolean r1) {
        this.mAllowCollapse = r1;
    }

    private void performCollapse() {
        if (isCollapsed() == false) goto L6;
        return;
    L6:
        if (this.mTabSpinner != null) goto L8;
        this.mTabSpinner = createSpinner();
    L8:
        removeView(this.mTabLayout);
        addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() != null) goto L11;
        this.mTabSpinner.setAdapter(new TabAdapter(this));
    L11:
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L14;
        removeCallbacks(r0);
        this.mTabSelector = null;
    L14:
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        if (isCollapsed() == true) goto L5;
        return false;
    L5:
        removeView(this.mTabSpinner);
        addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.mTabSpinner.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int r6) {
        this.mSelectedTabIndex = r6;
        int r0 = this.mTabLayout.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        View r3 = this.mTabLayout.getChildAt(r2);
        if (r2 != r6) goto L7;
        boolean r4 = true;
    L8:
        r3.setSelected(r4);
        if (r4 == false) goto L11;
        animateToTab(r6);
    L11:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = false;
        goto L8
    L12:
        Spinner r5 = this.mTabSpinner;
        if (r5 == null) goto L20;
        if (r6 < 0) goto L21;
        r5.setSelection(r6);
        return;
    L21:
        return;
    }

    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
        requestLayout();
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat r0 = new LinearLayoutCompat((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, ZeusTransformUtils.mapRes(R.attr.actionBarTabBarStyle, "attr", "actionBarTabBarStyle"));
        r0.setMeasureWithLargestChildEnabled(true);
        r0.setGravity(17);
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return r0;
    }

    private Spinner createSpinner() {
        AppCompatSpinner r0 = new AppCompatSpinner((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, ZeusTransformUtils.mapRes(R.attr.actionDropDownStyle, "attr", "actionDropDownStyle"));
        r0.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        r0.setOnItemSelectedListener(this);
        return r0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        androidx.appcompat.view.a r4 = androidx.appcompat.view.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        setContentHeight(r4.e());
        this.mStackedTabMaxWidth = r4.g();
    }

    public void animateToVisibility(int r5) {
        ViewPropertyAnimator r0 = this.mVisibilityAnim;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (r5 == 0) goto L8;
        ViewPropertyAnimator r2 = animate().alpha(0.0f);
        r2.setDuration(200);
        r2.setInterpolator(sAlphaInterpolator);
        r2.setListener(this.mVisAnimListener.withFinalVisibility(r2, r5));
        r2.start();
        return;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        ViewPropertyAnimator r3 = animate().alpha(1.0f);
        r3.setDuration(200);
        r3.setInterpolator(sAlphaInterpolator);
        r3.setListener(this.mVisAnimListener.withFinalVisibility(r3, r5));
        r3.start();
    }

    public void animateToTab(int r2) {
        final View r3 = this.mTabLayout.getChildAt(r2);
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L5;
        removeCallbacks(r0);
    L5:
        Runnable r1 = new AnonymousClass1(this, r3);
        this.mTabSelector = r1;
        post(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L6;
        post(r0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r0 = this.mTabSelector;
        if (r0 == null) goto L6;
        removeCallbacks(r0);
        return;
    }

    TabView createTabView(ActionBar.c r5, boolean r6) {
        TabView r0 = new TabView(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, r6);
        if (r6 == false) goto L5;
        r0.setBackgroundDrawable(null);
        r0.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
    L9:
        return r0;
    L5:
        r0.setFocusable(true);
        if (this.mTabClickListener != null) goto L8;
        this.mTabClickListener = new TabClickListener(this);
    L8:
        r0.setOnClickListener(this.mTabClickListener);
        goto L9
    }

    public void addTab(ActionBar.c r6, boolean r7) {
        TabView r8 = createTabView(r6, false);
        this.mTabLayout.addView(r8, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r0 = this.mTabSpinner;
        if (r0 == null) goto L5;
        ((TabAdapter) ZeusTransformUtils.preCheckCast(r0.getAdapter(), TabAdapter.class, "com.obric.aiagent.plugin")).notifyDataSetChanged();
    L5:
        if (r7 == false) goto L8;
        r8.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    public void addTab(ActionBar.c r6, int r7, boolean r8) {
        TabView r9 = createTabView(r6, false);
        this.mTabLayout.addView(r9, r7, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r10 = this.mTabSpinner;
        if (r10 == null) goto L5;
        ((TabAdapter) ZeusTransformUtils.preCheckCast(r10.getAdapter(), TabAdapter.class, "com.obric.aiagent.plugin")).notifyDataSetChanged();
    L5:
        if (r8 == false) goto L8;
        r9.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    public void updateTab(int r3) {
        ((TabView) ZeusTransformUtils.preCheckCast(this.mTabLayout.getChildAt(r3), TabView.class, "com.obric.aiagent.plugin")).update();
        Spinner r4 = this.mTabSpinner;
        if (r4 == null) goto L6;
        ((TabAdapter) ZeusTransformUtils.preCheckCast(r4.getAdapter(), TabAdapter.class, "com.obric.aiagent.plugin")).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void removeTabAt(int r3) {
        this.mTabLayout.removeViewAt(r3);
        Spinner r4 = this.mTabSpinner;
        if (r4 == null) goto L6;
        ((TabAdapter) ZeusTransformUtils.preCheckCast(r4.getAdapter(), TabAdapter.class, "com.obric.aiagent.plugin")).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner r0 = this.mTabSpinner;
        if (r0 == null) goto L6;
        ((TabAdapter) ZeusTransformUtils.preCheckCast(r0.getAdapter(), TabAdapter.class, "com.obric.aiagent.plugin")).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        ((TabView) ZeusTransformUtils.preCheckCast(r2, TabView.class, "com.obric.aiagent.plugin")).getTab().d();
    }
}

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
import androidx.appcompat.view.ActionBarPolicy;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
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

    public class TabAdapter extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.this$0.mTabLayout.getChildCount();
        }

        public TabAdapter(ScrollingTabContainerView r100) {
            this.this$0 = r100;
        }

        @Override // android.widget.Adapter
        public Object getItem(int r100) {
            return ((TabView) this.this$0.mTabLayout.getChildAt(r100)).getTab();
        }

        @Override // android.widget.Adapter
        public View getView(int r100, View r101, ViewGroup r102) {
            if (r101 == null) goto L6;
            ((TabView) r101).bindTab((ActionBar.Tab) getItem(r100));
            return r101;
        L6:
            return this.this$0.createTabView((ActionBar.Tab) getItem(r100), true);
        }
    }

    public class TabClickListener implements View.OnClickListener {
        final /* synthetic */ ScrollingTabContainerView this$0;

        public TabClickListener(ScrollingTabContainerView r100) {
            this.this$0 = r100;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            ((TabView) r100).getTab().select();
            int r101 = this.this$0.mTabLayout.getChildCount();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L9;
            View r103 = this.this$0.mTabLayout.getChildAt(r102);
            if (r103 != r100) goto L7;
            boolean r104 = true;
        L8:
            r103.setSelected(r104);
            r102 = r102 + 1;
            goto L3
        L7:
            r104 = false;
            goto L8
        }
    }

    public class TabView extends LinearLayout {
        private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        private final int[] BG_ATTRS;
        private View mCustomView;
        private ImageView mIconView;
        private ActionBar.Tab mTab;
        private TextView mTextView;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public void update() {
            ActionBar.Tab r100 = this.mTab;
            View r101 = r100.getCustomView();
            CharSequence r102 = null;
            if (r101 == null) goto L15;
            ViewParent r103 = r101.getParent();
            if (r103 == this) goto L9;
            if (r103 == null) goto L8;
            ((ViewGroup) r103).removeView(r101);
        L8:
            addView(r101);
        L9:
            this.mCustomView = r101;
            TextView r104 = this.mTextView;
            if (r104 == null) goto L12;
            r104.setVisibility(8);
        L12:
            ImageView r105 = this.mIconView;
            if (r105 == null) goto L44;
            r105.setVisibility(8);
            this.mIconView.setImageDrawable(null);
            return;
        L44:
            return;
        L15:
            View r106 = this.mCustomView;
            if (r106 == null) goto L18;
            removeView(r106);
            this.mCustomView = null;
        L18:
            Drawable r107 = r100.getIcon();
            CharSequence r108 = r100.getText();
            if (r107 != null) goto L21;
            ImageView r109 = this.mIconView;
            if (r109 == null) goto L27;
            r109.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        L27:
            boolean r110 = !TextUtils.isEmpty(r108);
            if (r110 == true) goto L30;
            TextView r111 = this.mTextView;
            if (r111 == null) goto L36;
            r111.setVisibility(8);
            this.mTextView.setText(null);
        L36:
            ImageView r112 = this.mIconView;
            if (r112 == null) goto L39;
            r112.setContentDescription(r100.getContentDescription());
        L39:
            if (r110 == true) goto L42;
            r102 = r100.getContentDescription();
        L42:
            TooltipCompat.setTooltipText(this, r102);
            return;
        L30:
            if (this.mTextView != null) goto L32;
            AppCompatTextView r113 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
            r113.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
            r114.gravity = 16;
            r113.setLayoutParams(r114);
            addView(r113);
            this.mTextView = r113;
        L32:
            this.mTextView.setText(r108);
            this.mTextView.setVisibility(0);
            goto L36
        L21:
            if (this.mIconView != null) goto L23;
            AppCompatImageView r115 = new AppCompatImageView(getContext());
            LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
            r116.gravity = 16;
            r115.setLayoutParams(r116);
            addView(r115, 0);
            this.mIconView = r115;
        L23:
            this.mIconView.setImageDrawable(r107);
            this.mIconView.setVisibility(0);
            goto L27
        }

        public ActionBar.Tab getTab() {
            return this.mTab;
        }

        public void bindTab(ActionBar.Tab r100) {
            this.mTab = r100;
            update();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
            super.onInitializeAccessibilityEvent(r100);
            r100.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
            super.onInitializeAccessibilityNodeInfo(r100);
            r100.setClassName(ACCESSIBILITY_CLASS_NAME);
        }

        @Override // android.view.View
        public void setSelected(boolean r100) {
            if (isSelected() == r100) goto L5;
            boolean r101 = true;
        L6:
            super.setSelected(r100);
            if (r101 == false) goto L11;
            if (r100 == false) goto L12;
            sendAccessibilityEvent(4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int r100, int r101) {
            super.onMeasure(r100, r101);
            if (this.this$0.mMaxTabWidth <= 0) goto L8;
            int r102 = getMeasuredWidth();
            int r103 = this.this$0.mMaxTabWidth;
            if (r102 <= r103) goto L9;
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), r101);
            return;
        L9:
            return;
        }

        public TabView(ScrollingTabContainerView r100, Context r101, ActionBar.Tab r102, boolean r103) {
            this.this$0 = r100;
            super(r101, null, R.attr.actionBarTabStyle);
            int[] r104 = {android.R.attr.background};
            this.BG_ATTRS = r104;
            this.mTab = r102;
            TintTypedArray r105 = TintTypedArray.obtainStyledAttributes(r101, null, r104, R.attr.actionBarTabStyle, 0);
            if (r105.hasValue(0) == false) goto L5;
            setBackgroundDrawable(r105.getDrawable(0));
        L5:
            r105.recycle();
            if (r103 == false) goto L8;
            setGravity(8388627);
        L8:
            update();
        }
    }

    public class VisibilityAnimListener extends AnimatorListenerAdapter {
        private boolean mCanceled;
        private int mFinalVisibility;
        final /* synthetic */ ScrollingTabContainerView this$0;

        public VisibilityAnimListener(ScrollingTabContainerView r100) {
            this.this$0 = r100;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            ScrollingTabContainerView r101 = this.this$0;
            r101.mVisibilityAnim = null;
            r101.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            this.this$0.setVisibility(0);
            this.mCanceled = false;
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator r100, int r101) {
            this.mFinalVisibility = r101;
            this.this$0.mVisibilityAnim = r100;
            return this;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r100) {
    }

    static {
        sAlphaInterpolator = new DecelerateInterpolator();
    }

    private Spinner createSpinner() {
        AppCompatSpinner r100 = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        r100.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        r100.setOnItemSelectedListener(this);
        return r100;
    }

    private LinearLayoutCompat createTabLayout() {
        LinearLayoutCompat r100 = new LinearLayoutCompat(getContext(), null, R.attr.actionBarTabBarStyle);
        r100.setMeasureWithLargestChildEnabled(true);
        r100.setGravity(17);
        r100.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return r100;
    }

    private boolean isCollapsed() {
        Spinner r100 = this.mTabSpinner;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getParent() != this) goto L7;
        return true;
    }

    public void removeAllTabs() {
        this.mTabLayout.removeAllViews();
        Spinner r100 = this.mTabSpinner;
        if (r100 == null) goto L6;
        ((TabAdapter) r100.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
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
        Runnable r100 = this.mTabSelector;
        if (r100 == null) goto L14;
        removeCallbacks(r100);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable r100 = this.mTabSelector;
        if (r100 == null) goto L6;
        post(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r100 = this.mTabSelector;
        if (r100 == null) goto L6;
        removeCallbacks(r100);
        return;
    }

    public ScrollingTabContainerView(Context r100) {
        super(r100);
        this.mVisAnimListener = new VisibilityAnimListener(this);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy r101 = ActionBarPolicy.get(r100);
        setContentHeight(r101.getTabContainerHeight());
        this.mStackedTabMaxWidth = r101.getStackedTabMaxWidth();
        LinearLayoutCompat r102 = createTabLayout();
        this.mTabLayout = r102;
        addView(r102, new ViewGroup.LayoutParams(-2, -1));
    }

    public void animateToTab(int r100) {
        final View r101 = this.mTabLayout.getChildAt(r100);
        Runnable r102 = this.mTabSelector;
        if (r102 == null) goto L5;
        removeCallbacks(r102);
    L5:
        Runnable r103 = new AnonymousClass1(this, r101);
        this.mTabSelector = r103;
        post(r103);
    }

    public void animateToVisibility(int r100) {
        ViewPropertyAnimator r101 = this.mVisibilityAnim;
        if (r101 == null) goto L6;
        r101.cancel();
    L6:
        if (r100 == 0) goto L8;
        ViewPropertyAnimator r102 = animate().alpha(0.0f);
        r102.setDuration(200);
        r102.setInterpolator(sAlphaInterpolator);
        r102.setListener(this.mVisAnimListener.withFinalVisibility(r102, r100));
        r102.start();
        return;
    L8:
        if (getVisibility() == 0) goto L10;
        setAlpha(0.0f);
    L10:
        ViewPropertyAnimator r103 = animate().alpha(1.0f);
        r103.setDuration(200);
        r103.setInterpolator(sAlphaInterpolator);
        r103.setListener(this.mVisAnimListener.withFinalVisibility(r103, r100));
        r103.start();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        ActionBarPolicy r101 = ActionBarPolicy.get(getContext());
        setContentHeight(r101.getTabContainerHeight());
        this.mStackedTabMaxWidth = r101.getStackedTabMaxWidth();
    }

    public void removeTabAt(int r100) {
        this.mTabLayout.removeViewAt(r100);
        Spinner r101 = this.mTabSpinner;
        if (r101 == null) goto L6;
        ((TabAdapter) r101.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void setAllowCollapse(boolean r100) {
        this.mAllowCollapse = r100;
    }

    public void setContentHeight(int r100) {
        this.mContentHeight = r100;
        requestLayout();
    }

    public void setTabSelected(int r100) {
        this.mSelectedTabIndex = r100;
        int r101 = this.mTabLayout.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        View r103 = this.mTabLayout.getChildAt(r102);
        if (r102 != r100) goto L7;
        boolean r104 = true;
    L8:
        r103.setSelected(r104);
        if (r104 == false) goto L11;
        animateToTab(r100);
    L11:
        r102 = r102 + 1;
        goto L3
    L7:
        r104 = false;
        goto L8
    L12:
        Spinner r105 = this.mTabSpinner;
        if (r105 == null) goto L20;
        if (r100 < 0) goto L21;
        r105.setSelection(r100);
        return;
    L21:
        return;
    }

    public void updateTab(int r100) {
        ((TabView) this.mTabLayout.getChildAt(r100)).update();
        Spinner r101 = this.mTabSpinner;
        if (r101 == null) goto L6;
        ((TabAdapter) r101.getAdapter()).notifyDataSetChanged();
    L6:
        if (this.mAllowCollapse == false) goto L9;
        requestLayout();
        return;
    }

    public void addTab(ActionBar.Tab r100, boolean r101) {
        TabView r102 = createTabView(r100, false);
        this.mTabLayout.addView(r102, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r103 = this.mTabSpinner;
        if (r103 == null) goto L5;
        ((TabAdapter) r103.getAdapter()).notifyDataSetChanged();
    L5:
        if (r101 == false) goto L8;
        r102.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    public TabView createTabView(ActionBar.Tab r100, boolean r101) {
        TabView r102 = new TabView(this, getContext(), r100, r101);
        if (r101 == false) goto L5;
        r102.setBackgroundDrawable(null);
        r102.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
    L9:
        return r102;
    L5:
        r102.setFocusable(true);
        if (this.mTabClickListener != null) goto L8;
        this.mTabClickListener = new TabClickListener(this);
    L8:
        r102.setOnClickListener(this.mTabClickListener);
        goto L9
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        boolean r103 = true;
        if (r102 != 1073741824) goto L5;
        boolean r104 = true;
    L6:
        setFillViewport(r104);
        int r105 = this.mTabLayout.getChildCount();
        if (r105 <= 1) goto L16;
        if (r102 == 1073741824) goto L12;
        if (r102 != Integer.MIN_VALUE) goto L16;
    L12:
        if (r105 <= 2) goto L14;
        this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(r100) * 0.4f);
    L15:
        this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
    L17:
        int r106 = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
        if (r104 == false) goto L20;
    L22:
        r103 = false;
    L23:
        if (r103 == false) goto L28;
        this.mTabLayout.measure(0, r106);
        if (this.mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(r100)) goto L27;
        performCollapse();
    L29:
        int r107 = getMeasuredWidth();
        super.onMeasure(r100, r106);
        int r108 = getMeasuredWidth();
        if (r104 == false) goto L34;
        if (r107 == r108) goto L35;
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
        this.mMaxTabWidth = View.MeasureSpec.getSize(r100) / 2;
    L16:
        this.mMaxTabWidth = -1;
        goto L17
    L5:
        r104 = false;
        goto L6
    }

    public void addTab(ActionBar.Tab r100, int r101, boolean r102) {
        TabView r103 = createTabView(r100, false);
        this.mTabLayout.addView(r103, r101, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner r104 = this.mTabSpinner;
        if (r104 == null) goto L5;
        ((TabAdapter) r104.getAdapter()).notifyDataSetChanged();
    L5:
        if (r102 == false) goto L8;
        r103.setSelected(true);
    L8:
        if (this.mAllowCollapse == false) goto L11;
        requestLayout();
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r100, View r101, int r102, long r103) {
        ((TabView) r101).getTab().select();
    }
}

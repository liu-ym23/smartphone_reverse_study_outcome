package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.MathUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewRootImpl;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.animation.AnimationConstants;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshLoadListView extends ListView implements AbsListView.OnScrollListener {
    private static final int FOOTER_HEIGHT = 0;
    private static final int LOADING_MIN_DELAY = 100;
    private static final float OFFSET_RADIO = 1.8f;
    private static final int PULL_LOAD_MORE_DELTA = 25;
    private static final int SCROLLBACK_FOOTER = 1;
    private static final int SCROLLBACK_HEADER = 0;
    private static final int SCROLL_DURATION = 400;
    private boolean isChangeScrollMode;
    private float mDownY;
    private boolean mEnablePullLoad;
    private boolean mEnablePullRefresh;
    private int mFootViewHeight;
    private XListViewFooter mFooterView;
    private TextView mHeaderTimeView;
    private XListViewHeader mHeaderView;
    private RelativeLayout mHeaderViewContent;
    private int mHeaderViewHeight;
    private boolean mIsFooterReady;
    private float mLastY;
    private IXListViewListener mListViewListener;
    private boolean mPullLoading;
    private boolean mPullRefreshing;
    private int mScrollBack;
    private AbsListView.OnScrollListener mScrollListener;
    private int mScrollMode;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mStopScroll;
    private int mTotalItemCount;

    public interface IXListViewListener {
        void onLoadMore();

        void onRefresh();
    }

    public interface OnXScrollListener extends AbsListView.OnScrollListener {
        void onXScrolling(View r10);
    }

    public class XListViewFooter extends LinearLayout {
        public static final int STATE_END = 3;
        public static final int STATE_LOADING = 1;
        public static final int STATE_NORMAL = 0;
        public static final int STATE_RELOAD = 2;
        private View mContentView;
        private Context mContext;
        private TextView mHintView;
        private View mLineView;
        private View mProgressBar;
        private int mState;
        final /* synthetic */ RefreshLoadListView this$0;

        public XListViewFooter(RefreshLoadListView r10, Context r11) {
            this.this$0 = r10;
            super(r11);
            initView(r11);
        }

        public static /* synthetic */ View access$200(XListViewFooter r10) {
            return r10.mContentView;
        }

        public static /* synthetic */ int access$600(XListViewFooter r10) {
            return r10.mState;
        }

        private void initView(Context r10) {
            this.mContext = r10;
            RelativeLayout r11 = (RelativeLayout) LayoutInflater.from(r10).inflate(R$layout.listview_footer, null);
            addView(r11);
            r11.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.mContentView = r11.findViewById(R$id.listview_footer_content);
            this.mProgressBar = r11.findViewById(R$id.listview_footer_progressbar);
            this.mHintView = (TextView) r11.findViewById(R$id.listview_footer_hint_textview);
            this.mLineView = r11.findViewById(R$id.listview_footer_line);
        }

        public int getBottomMargin() {
            return ((LinearLayout.LayoutParams) this.mContentView.getLayoutParams()).bottomMargin;
        }

        public void hide() {
            if (RefreshLoadListView.access$100(this.this$0) == null) goto L6;
            RefreshLoadListView.access$100(this.this$0).setVisibility(4);
            return;
        }

        public boolean isLoadingSate() {
            if (this.mState == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public void loadMore() {
            LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) this.mContentView.getLayoutParams();
            r10.height = -2;
            this.mContentView.setLayoutParams(r10);
            this.mProgressBar.setVisibility(8);
            this.mHintView.setVisibility(0);
            this.mHintView.setText(R$string.listview_footer_hint_recommend);
            this.mLineView.setBackgroundResource(R$drawable.line);
            this.mLineView.setVisibility(0);
        }

        public void loading() {
            this.mHintView.setVisibility(8);
            this.mProgressBar.setVisibility(0);
        }

        public void normal() {
            this.mHintView.setVisibility(0);
            this.mProgressBar.setVisibility(8);
        }

        public void setBottomMargin(int r10) {
            LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.mContentView.getLayoutParams();
            r11.bottomMargin = r10;
            this.mContentView.setLayoutParams(r11);
        }

        public void setState(int r10) {
            this.mState = r10;
            this.mHintView.setVisibility(8);
            this.mProgressBar.setVisibility(8);
            if (r10 == 0) goto L16;
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L13;
            if (r10 != 3) goto L23;
            this.mProgressBar.setVisibility(8);
            this.mHintView.setVisibility(0);
            this.mHintView.setText(R$string.listview_footer_hint_end);
            return;
        L23:
            return;
        L13:
            if (RefreshLoadListView.access$800(this.this$0) == false) goto L20;
            this.mHintView.setVisibility(0);
            this.mHintView.setText(R$string.listview_footer_hint_ready);
            return;
        L20:
            return;
        L16:
            if (RefreshLoadListView.access$800(this.this$0) == false) goto L22;
            this.mProgressBar.setVisibility(0);
            this.mHintView.setVisibility(0);
            this.mHintView.setText(R$string.listview_footer_hint_normal);
            return;
        }

        public void show() {
            RefreshLoadListView.access$100(this.this$0).setVisibility(0);
            LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) this.mContentView.getLayoutParams();
            r10.height = -2;
            this.mContentView.setLayoutParams(r10);
            this.mContentView.setVisibility(0);
            View r11 = this.mProgressBar;
            if (RefreshLoadListView.access$800(this.this$0) == false) goto L5;
            int r12 = 0;
        L6:
            r11.setVisibility(r12);
            this.mHintView.setVisibility(0);
            this.mLineView.setVisibility(8);
            return;
        L5:
            r12 = 8;
            goto L6
        }

        public XListViewFooter(RefreshLoadListView r10, Context r11, AttributeSet r12) {
            this.this$0 = r10;
            super(r11, r12);
            initView(r11);
        }
    }

    public static class XListViewHeader extends LinearLayout {
        public static final int STATE_NORMAL = 0;
        public static final int STATE_READY = 1;
        public static final int STATE_REFRESHING = 2;
        private final int ROTATE_ANIM_DURATION;
        private ImageView mArrowImageView;
        private RelativeLayout mContainer;
        private TextView mHintTextView;
        private ProgressBar mProgressBar;
        private Animation mRotateDownAnim;
        private Animation mRotateUpAnim;
        private int mState;

        public XListViewHeader(Context r10) {
            super(r10);
            this.mContainer = null;
            this.mArrowImageView = null;
            this.mProgressBar = null;
            this.mHintTextView = null;
            this.mState = 0;
            this.mRotateUpAnim = null;
            this.mRotateDownAnim = null;
            this.ROTATE_ANIM_DURATION = AnimationConstants.DURATION_180;
            initView(r10);
        }

        private void initView(Context r11) {
            ViewGroup.LayoutParams r10 = new LinearLayout.LayoutParams(-1, 0);
            RelativeLayout r12 = (RelativeLayout) LayoutInflater.from(r11).inflate(R$layout.listview_header, null);
            this.mContainer = r12;
            addView(r12, r10);
            setGravity(80);
            this.mArrowImageView = (ImageView) findViewById(R$id.listview_header_arrow);
            this.mHintTextView = (TextView) findViewById(R$id.listview_header_hint_textview);
            this.mProgressBar = (ProgressBar) findViewById(R$id.listview_header_progressbar);
            RotateAnimation r13 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.mRotateUpAnim = r13;
            r13.setDuration(180);
            this.mRotateUpAnim.setFillAfter(true);
            RotateAnimation r14 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.mRotateDownAnim = r14;
            r14.setDuration(180);
            this.mRotateDownAnim.setFillAfter(true);
        }

        public int getVisiableHeight() {
            return this.mContainer.getHeight();
        }

        public void setState(int r10) {
            if (r10 != this.mState) goto L6;
            return;
        L6:
            if (r10 != 2) goto L8;
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.setVisibility(8);
            this.mProgressBar.setVisibility(0);
        L10:
            if (r10 == 0) goto L19;
            if (r10 == 1) goto L16;
            if (r10 != 2) goto L25;
            this.mHintTextView.setText(R$string.listview_header_hint_loading);
        L25:
            this.mState = r10;
            return;
        L16:
            if (this.mState == 1) goto L25;
            this.mArrowImageView.clearAnimation();
            this.mArrowImageView.startAnimation(this.mRotateUpAnim);
            this.mHintTextView.setText(R$string.listview_header_hint_ready);
            goto L25
        L19:
            if (this.mState != 1) goto L22;
            this.mArrowImageView.startAnimation(this.mRotateDownAnim);
        L22:
            if (this.mState != 2) goto L24;
            this.mArrowImageView.clearAnimation();
        L24:
            this.mHintTextView.setText(R$string.listview_header_hint_normal);
            goto L25
        L8:
            this.mArrowImageView.setVisibility(0);
            this.mProgressBar.setVisibility(8);
            goto L10
        }

        public void setVisiableHeight(int r10) {
            if (r10 >= 0) goto L4;
            r10 = 0;
        L4:
            LinearLayout.LayoutParams r11 = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
            r11.height = r10;
            this.mContainer.setLayoutParams(r11);
        }

        public XListViewHeader(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.mContainer = null;
            this.mArrowImageView = null;
            this.mProgressBar = null;
            this.mHintTextView = null;
            this.mState = 0;
            this.mRotateUpAnim = null;
            this.mRotateDownAnim = null;
            this.ROTATE_ANIM_DURATION = AnimationConstants.DURATION_180;
            initView(r10);
        }
    }

    static {
        FOOTER_HEIGHT = BaseApplication.c().getResources().getDimensionPixelSize(R$dimen.listview_footer_height);
    }

    public RefreshLoadListView(Context r10) {
        super(r10);
        this.mLastY = -1.0f;
        this.mEnablePullRefresh = true;
        this.mPullRefreshing = false;
        this.mIsFooterReady = false;
        this.mStopScroll = false;
        this.mFootViewHeight = FOOTER_HEIGHT;
        this.mDownY = 0.0f;
        initWithContext(r10);
    }

    public static /* synthetic */ int access$002(RefreshLoadListView r10, int r11) {
        r10.mFootViewHeight = r11;
        return r11;
    }

    public static /* synthetic */ XListViewFooter access$100(RefreshLoadListView r10) {
        return r10.mFooterView;
    }

    public static /* synthetic */ int access$302(RefreshLoadListView r10, int r11) {
        r10.mHeaderViewHeight = r11;
        return r11;
    }

    public static /* synthetic */ RelativeLayout access$400(RefreshLoadListView r10) {
        return r10.mHeaderViewContent;
    }

    public static /* synthetic */ void access$500(RefreshLoadListView r10) {
        r10.startLoadMore();
    }

    public static /* synthetic */ IXListViewListener access$700(RefreshLoadListView r10) {
        return r10.mListViewListener;
    }

    public static /* synthetic */ boolean access$800(RefreshLoadListView r10) {
        return r10.mEnablePullLoad;
    }

    private void initWithContext(Context r10) {
        this.mScroller = new Scroller(r10, new DecelerateInterpolator());
        super.setOnScrollListener(this);
        setOverScrollMode(2);
        XListViewHeader r11 = new XListViewHeader(r10);
        this.mHeaderView = r11;
        this.mHeaderViewContent = (RelativeLayout) r11.findViewById(R$id.listview_header_content);
        this.mHeaderTimeView = (TextView) this.mHeaderView.findViewById(R$id.listview_header_time);
        addHeaderView(this.mHeaderView);
        XListViewFooter r12 = new XListViewFooter(this, r10);
        this.mFooterView = r12;
        r12.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(this));
        this.mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass2(this));
    }

    private void invokeOnScrolling() {
        AbsListView.OnScrollListener r10 = this.mScrollListener;
        if ((r10 instanceof OnXScrollListener) == false) goto L6;
        ((OnXScrollListener) r10).onXScrolling(this);
        return;
    }

    private void resetFooterHeight() {
        XListViewFooter r10 = this.mFooterView;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() == 4) goto L21;
        int r11 = this.mFooterView.getBottomMargin();
        if (r11 > 0) goto L13;
        if (r11 == 0) goto L11;
        return;
    L11:
        if (this.mEnablePullLoad == false) goto L13;
        return;
    L13:
        if (this.mEnablePullLoad == false) goto L15;
        int r12 = 0;
    L16:
        this.mScrollBack = 1;
        this.mScroller.startScroll(0, r11, 0, -(r12 + r11), 400);
        invalidate();
        return;
    L15:
        r12 = this.mFootViewHeight;
        goto L16
    }

    private void resetHeaderHeight() {
        int r10 = this.mHeaderView.getVisiableHeight();
        if (r10 != 0) goto L5;
        return;
    L5:
        boolean r11 = this.mPullRefreshing;
        if (r11 == false) goto L11;
        if (r10 > this.mHeaderViewHeight) goto L11;
        return;
    L11:
        if (r11 == false) goto L15;
        int r12 = this.mHeaderViewHeight;
        if (r10 <= r12) goto L15;
    L16:
        this.mScrollBack = 0;
        this.mScroller.startScroll(0, r10, 0, r12 - r10, 400);
        invalidate();
        return;
    L15:
        r12 = 0;
        goto L16
    }

    private void startLoadMore() {
        if (this.mPullLoading == true) goto L8;
        this.mPullLoading = true;
        if (XListViewFooter.access$600(this.mFooterView) == 1) goto L9;
        this.mFooterView.setState(1);
        postDelayed(new AnonymousClass5(this), 100);
        return;
    L9:
        return;
    }

    private void updateFooterHeight(float r10) {
        XListViewFooter r11 = this.mFooterView;
        if (r11 != null) goto L5;
    L7:
        int r12 = this.mFooterView.getBottomMargin() + ((int) r10);
        if (r12 <= 0) goto L11;
        this.mFooterView.setBottomMargin(r12);
        return;
    L11:
        return;
    L5:
        if (r11.getVisibility() != 4) goto L7;
    }

    private void updateHeaderHeight(float r10) {
        XListViewHeader r11 = this.mHeaderView;
        r11.setVisiableHeight(((int) r10) + r11.getVisiableHeight());
        if (this.mEnablePullRefresh == true) goto L5;
    L10:
        setSelection(0);
        return;
    L5:
        if (this.mPullRefreshing == true) goto L10;
        if (this.mHeaderView.getVisiableHeight() <= this.mHeaderViewHeight) goto L9;
        this.mHeaderView.setState(1);
        goto L10
    L9:
        this.mHeaderView.setState(0);
        goto L10
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset() == false) goto L10;
        if (this.mScrollBack != 0) goto L7;
        this.mHeaderView.setVisiableHeight(this.mScroller.getCurrY());
    L8:
        postInvalidate();
        invokeOnScrolling();
    L12:
        super.computeScroll();
        return;
    L7:
        this.mFooterView.setBottomMargin(this.mScroller.getCurrY());
        goto L8
    L10:
        if (this.mFooterView.getBottomMargin() >= 0) goto L12;
        this.mFooterView.setBottomMargin(0);
        postInvalidate();
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        XListViewFooter r11 = this.mFooterView;
        if (r11 == null) goto L13;
        if (r11.getVisibility() == 4) goto L13;
        Scroller r12 = this.mScroller;
        if (r12 == null) goto L13;
        if (r12.isFinished() == true) goto L13;
        j.n("ignore touch event of listview");
        return true;
    L13:
        if (r10.getAction() != 0) goto L16;
        this.mDownY = r10.getY();
        this.mScrollMode = getOverScrollMode();
    L16:
        return super.dispatchTouchEvent(r10);
    }

    public View getAccessibilityFocusedChild(View r10) {
        ViewParent r11 = r10.getParent();
    L3:
        boolean r12 = r11 instanceof View;
        if (r12 == false) goto L7;
        if (r11 == this) goto L7;
        r10 = r11;
        r11 = r11.getParent();
    L7:
        if (r12 == true) goto L10;
        return null;
    L10:
        return r10;
    }

    public IXListViewListener getXListViewListener() {
        return this.mListViewListener;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        ViewRootImpl r10 = getViewRootImpl();
        if (r10 == null) goto L10;
        View r11 = r10.getAccessibilityFocusedHost();
        if (r11 == null) goto L9;
        View r12 = getAccessibilityFocusedChild(r11);
        if (r12 == null) goto L9;
        int r13 = getPositionForView(r12);
    L11:
        super.layoutChildren();
        if (r10 == null) goto L20;
        if (r13 == (-1)) goto L21;
        View r14 = getChildAt(MathUtils.constrain(r13 - getFirstVisiblePosition(), 0, getChildCount() - 1));
        if (r14 == null) goto L22;
        View r15 = r14.findViewById(r11.getId());
        if (r15 == null) goto L23;
        r15.requestAccessibilityFocus();
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r13 = -1;
        goto L11
    L10:
        r11 = null;
        goto L9
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r10, int r11, int r12, int r13) {
        this.mTotalItemCount = r13;
        if (this.mEnablePullLoad == true) goto L10;
        if (r11 != 0) goto L10;
        if (getLastVisiblePosition() != (this.mTotalItemCount - 1)) goto L10;
        XListViewFooter r14 = this.mFooterView;
        if (r14 == null) goto L10;
        r14.hide();
        this.isChangeScrollMode = true;
        setOverScrollMode(0);
    L10:
        AbsListView.OnScrollListener r15 = this.mScrollListener;
        if (r15 == null) goto L14;
        r15.onScroll(r10, r11, r12, r13);
    L14:
        if (getLastVisiblePosition() == (this.mTotalItemCount - 1)) goto L16;
        return;
    L16:
        if (this.mEnablePullLoad == true) goto L18;
        return;
    L18:
        if (this.mStopScroll == true) goto L23;
        startLoadMore();
        return;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r10, int r11) {
        this.mScrollState = r11;
        AbsListView.OnScrollListener r12 = this.mScrollListener;
        if (r12 == null) goto L8;
        if (this.mStopScroll == true) goto L8;
        r12.onScrollStateChanged(r10, r11);
    L8:
        if (getLastVisiblePosition() == (this.mTotalItemCount - 1)) goto L10;
        return;
    L10:
        if (this.mEnablePullLoad == false) goto L12;
    L13:
        resetFooterHeight();
        return;
    L12:
        if (this.mFooterView.getBottomMargin() >= 0) goto L13;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.mLastY != (-1.0f)) goto L5;
        this.mLastY = r10.getRawY();
    L5:
        int r11 = r10.getAction();
        if (r11 != 0) goto L8;
        this.mLastY = r10.getRawY();
    L58:
        return super.onTouchEvent(r10);
    L8:
        if (r11 == 2) goto L28;
        this.mLastY = -1.0f;
        this.mScrollMode = 2;
        this.mDownY = 0.0f;
        if (getFirstVisiblePosition() != 0) goto L22;
        if (this.mEnablePullRefresh == false) goto L19;
        if (this.mHeaderView.getVisiableHeight() <= this.mHeaderViewHeight) goto L19;
        this.mPullRefreshing = true;
        this.mHeaderView.setState(2);
        IXListViewListener r12 = this.mListViewListener;
        if (r12 == null) goto L19;
        r12.onRefresh();
    L19:
        if (this.mEnablePullRefresh == false) goto L58;
        resetHeaderHeight();
        goto L58
    L22:
        if (this.mEnablePullLoad == true) goto L58;
        if (getLastVisiblePosition() != (this.mTotalItemCount - 1)) goto L58;
        if (this.mScrollState != 0) goto L58;
        resetFooterHeight();
        goto L58
    L28:
        float r13 = r10.getRawY() - this.mLastY;
        this.mLastY = r10.getRawY();
        float r14 = r10.getY();
        if (this.isChangeScrollMode == true) goto L41;
        float r15 = this.mDownY;
        if ((r14 - r15) >= 0.0f) goto L36;
        if (this.mScrollMode == 2) goto L36;
        setOverScrollMode(2);
    L36:
        if ((r14 - r15) <= 0.0f) goto L41;
        if (this.mScrollMode == 0) goto L41;
        setOverScrollMode(0);
    L41:
        if (getFirstVisiblePosition() != 0) goto L50;
        if (this.mHeaderView.getVisiableHeight() > 0) goto L47;
        if (r13 <= 0.0f) goto L50;
    L47:
        if (this.mEnablePullRefresh == false) goto L58;
        updateHeaderHeight(r13 / OFFSET_RADIO);
        invokeOnScrolling();
    L50:
        if (getLastVisiblePosition() != (this.mTotalItemCount - 1)) goto L58;
        if (this.mFooterView.getBottomMargin() <= 0) goto L54;
    L55:
        updateFooterHeight((-r13) / OFFSET_RADIO);
        goto L58
    L54:
        if (r13 >= 0.0f) goto L58;
        goto L55
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r10) {
        setAdapter((ListAdapter) r10);
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener r10) {
        this.mScrollListener = r10;
    }

    public void setPullLoadEnable(boolean r10) {
        this.mEnablePullLoad = r10;
        this.isChangeScrollMode = false;
        if (r10 == false) goto L6;
        setOverScrollMode(2);
    L6:
        if (this.mEnablePullLoad == true) goto L8;
        this.mPullLoading = false;
        this.mFooterView.setState(3);
        this.mFooterView.show();
        this.mFooterView.setOnClickListener(null);
    L9:
        setFooterDividersEnabled(false);
        return;
    L8:
        this.mPullLoading = false;
        this.mFooterView.show();
        this.mFooterView.setState(0);
        this.mFooterView.setOnClickListener(new AnonymousClass3(this));
        goto L9
    }

    public void setPullRefreshEnable(boolean r10) {
        this.mEnablePullRefresh = r10;
        if (r10 == true) goto L5;
        this.mHeaderViewContent.setVisibility(8);
    L6:
        setHeaderDividersEnabled(r10);
        return;
    L5:
        this.mHeaderViewContent.setVisibility(0);
        goto L6
    }

    public void setRefreshTime(String r10) {
        this.mHeaderTimeView.setText(r10);
    }

    public void setShowMore(boolean r10, View.OnClickListener r11) {
        this.mStopScroll = r10;
        XListViewFooter r12 = this.mFooterView;
        if (r12 == null) goto L8;
        if (r10 == false) goto L6;
        r12.loadMore();
        this.mFooterView.setId(R$id.list_footer_view_id);
        this.mFooterView.setOnClickListener(r11);
        return;
    L6:
        r12.show();
        this.mFooterView.setState(0);
        this.mFooterView.setOnClickListener(new AnonymousClass4(this));
        return;
    }

    public void setXListViewListener(IXListViewListener r10) {
        this.mListViewListener = r10;
    }

    public void stopLoadMore() {
        if (this.mPullLoading == false) goto L6;
        this.mPullLoading = false;
        this.mFooterView.setState(2);
        return;
    }

    public void stopRefresh() {
        if (this.mPullRefreshing != true) goto L6;
        this.mPullRefreshing = false;
        resetHeaderHeight();
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r10) {
        if (this.mIsFooterReady == true) goto L5;
        this.mIsFooterReady = true;
        addFooterView(this.mFooterView);
    L5:
        super.setAdapter(r10);
    }

    public RefreshLoadListView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mLastY = -1.0f;
        this.mEnablePullRefresh = true;
        this.mPullRefreshing = false;
        this.mIsFooterReady = false;
        this.mStopScroll = false;
        this.mFootViewHeight = FOOTER_HEIGHT;
        this.mDownY = 0.0f;
        initWithContext(r10);
    }

    public RefreshLoadListView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mLastY = -1.0f;
        this.mEnablePullRefresh = true;
        this.mPullRefreshing = false;
        this.mIsFooterReady = false;
        this.mStopScroll = false;
        this.mFootViewHeight = FOOTER_HEIGHT;
        this.mDownY = 0.0f;
        initWithContext(r10);
    }
}

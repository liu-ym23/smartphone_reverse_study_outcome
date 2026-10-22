package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.RelativeLayout;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.bytedanceos.common.ui.animation.DeleteItemAnimation;
import com.bytedanceos.common.utils.BytedanceMenuHelper;
import com.obric.oui.popover.OPopover;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class MyAppSwipeItemView extends FrameLayout {
    private static final int FLING_DURATION = 200;
    private static final int OPEN_STATE_LEFT = 1;
    private static final int OPEN_STATE_NORMAL = 0;
    private static final int OPEN_STATE_RIGHT = 2;
    private static final int REBOUND_DURATION = 150;
    private static final int SCROLL_DURATION = 250;
    private static int sItemSwipeType;
    private AppInfo mAppInfo;
    private View mBottomHiddenView;
    private CheckBox mCheckBox;
    private FrameLayout mCheckBoxFrame;
    private int mCloseCoverLeft;
    private Context mContext;
    private Rect mCoverHitRect;
    private int mCurrentCoverLeft;
    private ImageView mDeletBtn;
    private boolean mDownOnCover;
    private RelativeLayout mForgroundLayout;
    private GestureDetector mGestureDetector;
    private GestureDetector.SimpleOnGestureListener mGestureListener;
    private int mGestureStartLeft;
    private boolean mIgnoreGesture;
    private View mInstallIcon;
    private boolean mIsInListViewLayout;
    private boolean mIsScrollGesture;
    private int mItemSwipeType;
    private int mLeftOpenBalanceDistance;
    private int mLeftOpenCoverLeft;
    private int mLeftReboundDistance;
    private boolean mNeedRebound;
    private BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener mOnMenuItemClickListener;
    private MyAppSwipeListView mParentView;
    private OPopover mPopupMenu;
    private int mScrollDuration;
    private ScrollRunner mScrollRunner;
    private SwipeItemOverScroller mScroller;
    private OnSwipeItemActionListener mSwipeListener;
    private View mTopShownView;
    private float mTopViewX;
    private float mTopViewY;

    public class DeleteAnimationListener implements Animation.AnimationListener {
        final /* synthetic */ MyAppSwipeItemView this$0;

        private DeleteAnimationListener(MyAppSwipeItemView r10) {
            this.this$0 = r10;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
            MyAppSwipeItemView.access$2300(this.this$0);
            MyAppSwipeItemView.access$2400(this.this$0);
            MyAppSwipeItemView.access$2500(this.this$0).setVisibility(0);
            MyAppSwipeItemView.access$2600(this.this$0).setAlpha(1.0f);
            MyAppSwipeItemView.access$2500(this.this$0).setAlpha(1.0f);
            if (MyAppSwipeItemView.access$2700(this.this$0) == null) goto L6;
            MyAppSwipeItemView.access$2700(this.this$0).refreshDataFromServer(MyAppSwipeItemView.access$2800(this.this$0));
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
        }

        public /* synthetic */ DeleteAnimationListener(MyAppSwipeItemView r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public interface OnSwipeItemActionListener {
        void activeRadioButtons();

        void freezeRadioButtons();

        boolean isMyAppsDownloading();

        void performBottomBtnClick(View r10, MyAppSwipeItemView r11);

        void refreshDataFromServer(Object r10);

        void showAppDetailInfo(View r10);
    }

    public static class ScrollRunner implements Runnable {
        private SoftReference<MyAppSwipeItemView> mItemViewSoftReference;

        public ScrollRunner(MyAppSwipeItemView r10) {
            this.mItemViewSoftReference = new SoftReference(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            SoftReference<MyAppSwipeItemView> r10 = this.mItemViewSoftReference;
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.get() == null) goto L23;
            MyAppSwipeItemView r11 = this.mItemViewSoftReference.get();
            boolean r12 = MyAppSwipeItemView.access$900(r11).computeScrollOffset();
            MyAppSwipeItemView.access$1000(r11, MyAppSwipeItemView.access$900(r11).getCurrX());
            if (r12 == false) goto L14;
            if (MyAppSwipeItemView.access$900(r11).getCurrX() >= MyAppSwipeItemView.access$1100(r11)) goto L12;
            MyAppSwipeItemView.access$1200(r11);
        L12:
            r11.post(this);
            return;
        L14:
            if (MyAppSwipeItemView.access$1300(r11) == true) goto L16;
            return;
        L16:
            if (r11.isClosed() == true) goto L22;
            r11.scrollTo(MyAppSwipeItemView.access$1400(r11), 150);
            MyAppSwipeItemView.access$1302(r11, false);
            return;
        L22:
            return;
        }
    }

    public static class SwipeItemOverScroller extends OverScroller {
        boolean mIgnoreInterrupt;

        public SwipeItemOverScroller(Context r10) {
            super(r10);
            this.mIgnoreInterrupt = false;
        }

        private boolean isFlingFinished() {
            if (getCurrX() == getFinalX()) goto L5;
        L9:
            return false;
        L5:
            if (getCurrY() != getFinalY()) goto L9;
            if (getCurrVelocity() != 0.0f) goto L9;
            return true;
        }

        public void fling(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, boolean r18) {
            super.fling(r10, r11, r12, r13, r14, r15, r16, r17);
            this.mIgnoreInterrupt = r18;
        }

        public boolean ignoreInterrupt() {
            if (isClearFinished() == false) goto L6;
            this.mIgnoreInterrupt = false;
        L6:
            return this.mIgnoreInterrupt;
        }

        public boolean isClearFinished() {
            if (isFinished() == false) goto L5;
        L8:
            return true;
        L5:
            if (isFlingFinished() == true) goto L8;
            return false;
        }

        public void startScroll(int r10, int r11, int r12, int r13, boolean r14) {
            super.startScroll(r10, r11, r12, r13);
            this.mIgnoreInterrupt = r14;
        }

        public SwipeItemOverScroller(Context r10, Interpolator r11) {
            super(r10, r11);
            this.mIgnoreInterrupt = false;
        }

        @Override // android.widget.OverScroller
        public void fling(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            fling(r11, r12, r13, r14, r15, r16, r17, r18, false);
        }

        @Override // android.widget.OverScroller
        public void startScroll(int r10, int r11, int r12, int r13) {
            startScroll(r10, r11, r12, r13, false);
        }

        public void fling(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, boolean r110) {
            super.fling(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
            this.mIgnoreInterrupt = r110;
        }

        public void startScroll(int r10, int r11, int r12, int r13, int r14, boolean r15) {
            super.startScroll(r10, r11, r12, r13, r14);
            this.mIgnoreInterrupt = r15;
        }

        @Override // android.widget.OverScroller
        public void fling(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22) {
            fling(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, false);
        }

        @Override // android.widget.OverScroller
        public void startScroll(int r10, int r11, int r12, int r13, int r14) {
            startScroll(r10, r11, r12, r13, r14, false);
        }
    }

    public MyAppSwipeItemView(Context r10) {
        super(r10);
        this.mDeletBtn = null;
        this.mGestureStartLeft = -1;
        this.mCloseCoverLeft = 0;
        this.mScrollDuration = AnimationConstants.DURATION_350;
        this.mItemSwipeType = 0;
        this.mOnMenuItemClickListener = new AnonymousClass3(this);
        this.mGestureListener = new AnonymousClass6(this);
        init(r10);
    }

    public static /* synthetic */ boolean a(MyAppSwipeItemView r10, View r11, MotionEvent r12) {
        return r10.lambda$onFinishInflate$0(r11, r12);
    }

    public static /* synthetic */ void access$000(MyAppSwipeItemView r10) {
        r10.performTopViewClick();
    }

    public static /* synthetic */ OPopover access$100(MyAppSwipeItemView r10) {
        return r10.mPopupMenu;
    }

    public static /* synthetic */ boolean access$1000(MyAppSwipeItemView r10, int r11) {
        return r10.immediatelyScrollTo(r11);
    }

    public static /* synthetic */ OPopover access$102(MyAppSwipeItemView r10, OPopover r11) {
        r10.mPopupMenu = r11;
        return r11;
    }

    public static /* synthetic */ int access$1100(MyAppSwipeItemView r10) {
        return r10.mLeftOpenBalanceDistance;
    }

    public static /* synthetic */ void access$1200(MyAppSwipeItemView r10) {
        r10.restoreCoveredScrollingView();
    }

    public static /* synthetic */ boolean access$1300(MyAppSwipeItemView r10) {
        return r10.mNeedRebound;
    }

    public static /* synthetic */ boolean access$1302(MyAppSwipeItemView r10, boolean r11) {
        r10.mNeedRebound = r11;
        return r11;
    }

    public static /* synthetic */ int access$1400(MyAppSwipeItemView r10) {
        return r10.mLeftOpenCoverLeft;
    }

    public static /* synthetic */ boolean access$1502(MyAppSwipeItemView r10, boolean r11) {
        r10.mIsScrollGesture = r11;
        return r11;
    }

    public static /* synthetic */ int access$1600(MyAppSwipeItemView r10) {
        return r10.mCurrentCoverLeft;
    }

    public static /* synthetic */ int access$1702(MyAppSwipeItemView r10, int r11) {
        r10.mGestureStartLeft = r11;
        return r11;
    }

    public static /* synthetic */ int access$1800(MyAppSwipeItemView r10, int r11, int r12) {
        return r10.getTargetX(r11, r12);
    }

    public static /* synthetic */ int access$1900(MyAppSwipeItemView r10) {
        return r10.mLeftReboundDistance;
    }

    public static /* synthetic */ BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener access$200(MyAppSwipeItemView r10) {
        return r10.mOnMenuItemClickListener;
    }

    public static /* synthetic */ void access$2000(MyAppSwipeItemView r10, int r11, float r12, int r13) {
        r10.flingTo(r11, r12, r13);
    }

    public static /* synthetic */ void access$2100(MyAppSwipeItemView r10, int r11) {
        r10.setOpenState(r11);
    }

    public static /* synthetic */ int access$2200(MyAppSwipeItemView r10) {
        return r10.mCloseCoverLeft;
    }

    public static /* synthetic */ void access$2300(MyAppSwipeItemView r10) {
        r10.activeParenView();
    }

    public static /* synthetic */ void access$2400(MyAppSwipeItemView r10) {
        r10.activeRadioButtons();
    }

    public static /* synthetic */ View access$2500(MyAppSwipeItemView r10) {
        return r10.mTopShownView;
    }

    public static /* synthetic */ View access$2600(MyAppSwipeItemView r10) {
        return r10.mBottomHiddenView;
    }

    public static /* synthetic */ OnSwipeItemActionListener access$2700(MyAppSwipeItemView r10) {
        return r10.mSwipeListener;
    }

    public static /* synthetic */ AppInfo access$2800(MyAppSwipeItemView r10) {
        return r10.mAppInfo;
    }

    public static /* synthetic */ float access$300(MyAppSwipeItemView r10) {
        return r10.mTopViewX;
    }

    public static /* synthetic */ float access$400(MyAppSwipeItemView r10) {
        return r10.mTopViewY;
    }

    public static /* synthetic */ ImageView access$500(MyAppSwipeItemView r10) {
        return r10.mDeletBtn;
    }

    public static /* synthetic */ void access$600(MyAppSwipeItemView r10, View r11) {
        r10.preformTopViewLongClick(r11);
    }

    public static /* synthetic */ void access$700(MyAppSwipeItemView r10, View r11) {
        r10.performBottomViewClick(r11);
    }

    public static /* synthetic */ SwipeItemOverScroller access$900(MyAppSwipeItemView r10) {
        return r10.mScroller;
    }

    private void activeParenView() {
        MyAppSwipeListView r10 = getAdapterViewParent();
        if (r10 == null) goto L6;
        r10.active();
        return;
    }

    private void activeRadioButtons() {
        OnSwipeItemActionListener r10 = this.mSwipeListener;
        if (r10 == null) goto L6;
        r10.activeRadioButtons();
        return;
    }

    private void dismissProgressBar() {
        if (this.mItemSwipeType == 0) goto L6;
        this.mBottomHiddenView.findViewById(R$id.delete_btn).setVisibility(0);
        this.mBottomHiddenView.findViewById(R$id.delete_progress_swipe).setVisibility(8);
        return;
    }

    private void flingTo(int r12, float r13, int r14) {
        int r10 = this.mCurrentCoverLeft;
        this.mScroller.fling(r10, 0, (int) r13, 0, r12, r12, 0, 0, r14, 0);
        post(newScrollRunner());
    }

    private void freezeParentView() {
        MyAppSwipeListView r10 = getAdapterViewParent();
        if (r10 == null) goto L6;
        r10.freeze();
        return;
    }

    private void freezeRadioButtons() {
        OnSwipeItemActionListener r10 = this.mSwipeListener;
        if (r10 == null) goto L6;
        r10.freezeRadioButtons();
        return;
    }

    private MyAppSwipeListView getAdapterViewParent() {
        ViewParent r10 = this.mParentView;
        if (r10 != null) goto L6;
        r10 = getParent();
    L6:
        if ((r10 instanceof AdapterView) == false) goto L11;
        AdapterView r11 = (AdapterView) r10;
        if ((r11 instanceof MyAppSwipeListView) == false) goto L11;
        MyAppSwipeListView r12 = (MyAppSwipeListView) r11;
        this.mParentView = r12;
        return r12;
    L11:
        return null;
    }

    private int getCoverCloseLeft() {
        return this.mCloseCoverLeft;
    }

    public static int getItemSwipeType() {
        return sItemSwipeType;
    }

    private int getTargetX(int r10, int r11) {
        int r12 = this.mCurrentCoverLeft + r11;
        int r13 = this.mLeftOpenCoverLeft;
        if (r12 <= r13) goto L7;
        if (r10 <= 0) goto L7;
        return (int) (((double) r13) + overScrollCurveB(r10));
    L7:
        return r12;
    }

    private boolean immediatelyScrollTo(int r10) {
        if (this.mCurrentCoverLeft == getCoverCloseLeft()) goto L5;
    L8:
        int r11 = this.mTopShownView.getWidth();
        if (r10 >= 0) goto L11;
        r10 = 0;
    L11:
        this.mTopShownView.setLeft(r10);
        this.mTopShownView.setRight(r11 + r10);
        this.mCurrentCoverLeft = r10;
        return true;
    L5:
        if (r10 == this.mCurrentCoverLeft) goto L8;
        if (r10 <= 0) goto L8;
        updateCoveredScrollingView();
        goto L8
    }

    private View inflateBottomView() {
        View r10 = LayoutInflater.from(getContext()).inflate(R$layout.myapp_swipe_list_delete, this, false);
        ImageView r11 = (ImageView) r10.findViewById(R$id.delete_btn);
        this.mDeletBtn = r11;
        r11.setOnClickListener(new AnonymousClass4(this));
        setOnLongClickListener(new AnonymousClass5(this));
        int r12 = sItemSwipeType;
        this.mItemSwipeType = r12;
        if (r12 == 1) goto L15;
        if (r12 != 2) goto L6;
        this.mDeletBtn.setImageResource(R$drawable.slide_hide_btn);
        this.mDeletBtn.setContentDescription(getResources().getString(R$string.content_description_ignore));
    L16:
        this.mDeletBtn.setImportantForAccessibility(2);
        return r10;
    L6:
        if (r12 != 3) goto L8;
        this.mDeletBtn.setImageResource(R$drawable.slide_show_btn);
        this.mDeletBtn.setContentDescription(getResources().getString(R$string.content_description_unignore));
        goto L16
    L8:
        if (r12 != 4) goto L10;
    L12:
        this.mDeletBtn.setImageResource(R$drawable.slide_clean_btn);
        this.mDeletBtn.setContentDescription(getResources().getString(R$string.content_description_delete));
        goto L16
    L10:
        if (r12 == 5) goto L12;
    L15:
        this.mDeletBtn.setImageResource(R$drawable.slide_delete_btn);
        this.mDeletBtn.setContentDescription(getResources().getString(R$string.content_description_delete));
        goto L16
    }

    private void init(Context r10) {
        this.mContext = r10;
        setFocusable(true);
        setClickable(true);
        setFocusableInTouchMode(true);
        this.mScroller = new SwipeItemOverScroller(r10, new DecelerateInterpolator());
        GestureDetector r11 = new GestureDetector(r10, this.mGestureListener);
        this.mGestureDetector = r11;
        r11.setIsLongpressEnabled(false);
        this.mLeftOpenCoverLeft = r10.getResources().getDimensionPixelSize(R$dimen.left_open_cover_left);
        this.mLeftReboundDistance = r10.getResources().getDimensionPixelSize(R$dimen.left_rebound_distance);
        this.mLeftOpenBalanceDistance = r10.getResources().getDimensionPixelSize(R$dimen.left_open_balance_distance);
    }

    private void interruptScroller() {
        if (this.mScroller.isClearFinished() == true) goto L5;
        this.mScroller.forceFinished(true);
    L5:
        ScrollRunner r10 = this.mScrollRunner;
        if (r10 == null) goto L9;
        removeCallbacks(r10);
        this.mScrollRunner = null;
        return;
    }

    private boolean isInListViewLayout() {
        return this.mIsInListViewLayout;
    }

    private boolean isMotionOnCover(MotionEvent r10) {
        if (this.mCoverHitRect != null) goto L5;
        this.mCoverHitRect = new Rect();
    L5:
        this.mTopShownView.getHitRect(this.mCoverHitRect);
        if (this.mCoverHitRect.contains((int) r10.getX(), (int) r10.getY()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isScrollable() {
        MyAppSwipeListView r10 = getAdapterViewParent();
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isSwipeAble();
    }

    private /* synthetic */ boolean lambda$onFinishInflate$0(View r10, MotionEvent r11) {
        this.mTopViewX = r11.getX();
        this.mTopViewY = r11.getY();
        return false;
    }

    private double overScrollCurveA(double r10) {
        return (Math.log((r10 + 100.0d) * 1.0d) / Math.log(1.05d)) * 2.0d;
    }

    private double overScrollCurveB(double r10) {
        return overScrollCurveA(r10) - overScrollCurveA(0.0d);
    }

    private void performBottomViewClick(View r10) {
        if (this.mSwipeListener == null) goto L5;
        freezeParentView();
        showProgressBar();
        freezeRadioButtons();
        this.mSwipeListener.performBottomBtnClick(r10, this);
    L5:
        tellParentViewEvent(this.mItemSwipeType);
    }

    private void performTopViewClick() {
        if (this.mSwipeListener != null) goto L5;
        return;
    L5:
        if (isScrollable() == false) goto L9;
        this.mSwipeListener.showAppDetailInfo(this);
        return;
    }

    private void preformTopViewLongClick(View r10) {
        if (this.mSwipeListener == null) goto L5;
        freezeParentView();
        freezeRadioButtons();
        this.mSwipeListener.performBottomBtnClick(r10, this);
    L5:
        tellParentViewEvent(this.mItemSwipeType);
    }

    private void restoreCoveredScrollingView() {
        this.mTopShownView.setBackgroundResource(R$drawable.myapp_list_selector);
        this.mTopShownView.setPadding(0, 0, 0, 0);
    }

    private boolean scrollByTouch(MotionEvent r10) {
        int r11 = r10.getAction() & PrivateKeyType.INVALID;
        if (r11 == 1) goto L7;
        if (r11 == 3) goto L7;
        if (r11 == 6) goto L7;
        interruptScroller();
    L7:
        boolean r12 = this.mGestureDetector.onTouchEvent(r10);
        if (r11 == 1) goto L13;
        if (r11 == 3) goto L13;
        if (r11 == 6) goto L13;
    L17:
        if (r12 == false) goto L20;
        if (r11 == 0) goto L20;
        return true;
    L20:
        return false;
    L13:
        if (this.mCurrentCoverLeft == this.mLeftOpenCoverLeft) goto L17;
        if (this.mScroller.isClearFinished() == false) goto L17;
        scrollIntoSlot();
        goto L17
    }

    private void scrollIntoSlot() {
        if (this.mCurrentCoverLeft <= this.mLeftOpenBalanceDistance) goto L5;
        int r10 = 1;
    L6:
        if (r10 == 0) goto L8;
        int r11 = this.mLeftOpenCoverLeft;
    L9:
        if (r10 == 0) goto L11;
        this.mNeedRebound = true;
    L11:
        setOpenState(r10);
        scrollTo(r11, 250);
        return;
    L8:
        r11 = this.mCloseCoverLeft;
        goto L9
    L5:
        r10 = 0;
        goto L6
    }

    public static void setItemSwipeType(int r10) {
        sItemSwipeType = r10;
    }

    private void setOpenState(int r10) {
        if (r10 == 1) goto L5;
        this.mDeletBtn.setImportantForAccessibility(2);
        return;
    L5:
        if (getParent() == null) goto L7;
        ((MyAppSwipeListView) getParent()).setFocusChild(this);
    L7:
        this.mDeletBtn.setImportantForAccessibility(0);
    }

    private void showProgressBar() {
        if (this.mItemSwipeType == 0) goto L6;
        this.mBottomHiddenView.findViewById(R$id.delete_btn).setVisibility(8);
        this.mBottomHiddenView.findViewById(R$id.delete_progress_swipe).setVisibility(0);
        return;
    }

    private void tellParentViewEvent(int r10) {
        MyAppSwipeListView r11 = getAdapterViewParent();
        if (r11 == null) goto L6;
        r11.onSubItemViewEvent(r10, this);
        return;
    }

    private void updateCoveredScrollingView() {
        this.mTopShownView.setBackgroundResource(R$drawable.slide_coverbar);
    }

    public void closeAutonomously() {
        restoreCoveredScrollingView();
        scrollTo(this.mCloseCoverLeft, 200);
        setOpenState(0);
        dismissProgressBar();
        activeParenView();
        activeRadioButtons();
    }

    public void dismissAnimation(AppInfo r10) {
        this.mNeedRebound = false;
        this.mAppInfo = r10;
        removeCallbacks(this.mScrollRunner);
        DeleteItemAnimation.slideAnimBottomView(this.mBottomHiddenView);
        DeleteItemAnimation.slideAnimTopView(this.mTopShownView, this, getWidth(), getHeight(), new DeleteAnimationListener(this, null));
    }

    public void forceClose() {
        restoreCoveredScrollingView();
        immediatelyScrollTo(this.mCloseCoverLeft);
        interruptScroller();
        dismissProgressBar();
        activeParenView();
        activeRadioButtons();
        clearFocus();
        setOpenState(0);
    }

    public View getCheckBoxFrame() {
        return this.mCheckBoxFrame;
    }

    public View getForgroundLayout() {
        return this.mForgroundLayout;
    }

    public View getInstallIconView() {
        return this.mInstallIcon;
    }

    public boolean isClosed() {
        if (this.mCurrentCoverLeft == this.mCloseCoverLeft) goto L5;
    L7:
        return false;
    L5:
        if (this.mScroller.isClearFinished() == false) goto L7;
        return true;
    }

    public boolean isLeftOpen() {
        if (this.mCurrentCoverLeft <= this.mCloseCoverLeft) goto L5;
        return true;
    L5:
        return false;
    }

    public ScrollRunner newScrollRunner() {
        removeCallbacks(this.mScrollRunner);
        ScrollRunner r10 = new ScrollRunner(this);
        this.mScrollRunner = r10;
        return r10;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View r10 = getChildAt(0);
        this.mTopShownView = r10;
        r10.setVisibility(0);
        this.mTopShownView.setOnClickListener(new AnonymousClass1(this));
        this.mTopShownView.setOnTouchListener(new a(this));
        this.mTopShownView.setOnLongClickListener(new AnonymousClass2(this));
        View r11 = inflateBottomView();
        this.mBottomHiddenView = r11;
        addView(r11, 0);
        this.mCheckBoxFrame = (FrameLayout) findViewById(R$id.checkBoxFrame);
        this.mCheckBox = (CheckBox) findViewById(R$id.checkBox);
        this.mForgroundLayout = (RelativeLayout) findViewById(R$id.forground_layout);
        this.mInstallIcon = findViewById(R$id.appStatusLay);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r10, int r11, Rect r12) {
        super.onFocusChanged(r10, r11, r12);
        if (r10 == false) goto L5;
        return;
    L5:
        if (isInListViewLayout() == false) goto L7;
        return;
    L7:
        if (isLeftOpen() == true) goto L9;
        return;
    L9:
        if (this.mSwipeListener.isMyAppsDownloading() == true) goto L15;
        closeAutonomously();
        return;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (r10.getAction() != 0) goto L6;
        this.mDownOnCover = isMotionOnCover(r10);
        this.mIgnoreGesture = false;
    L6:
        if (isScrollable() == true) goto L8;
    L26:
        return false;
    L8:
        if (this.mSwipeListener == null) goto L26;
        if (this.mDownOnCover == false) goto L26;
        if (this.mScroller.isClearFinished() == true) goto L19;
        if (this.mScroller.ignoreInterrupt() == false) goto L19;
        this.mIgnoreGesture = true;
        return true;
    L19:
        if (isClosed() == true) goto L22;
        return true;
    L22:
        if (r10.getPointerCount() != 1) goto L25;
        scrollByTouch(r10);
    L25:
        return this.mIsScrollGesture;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        View r15 = this.mTopShownView;
        int r16 = this.mCurrentCoverLeft;
        int r17 = (r13 - r11) + r16;
        r15.layout(r16, 0, r17, r14 - r12);
    }

    @Override // android.view.View
    public void onScreenStateChanged(int r10) {
        super.onScreenStateChanged(r10);
        if (r10 != 0) goto L6;
        forceClose();
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (isScrollable() == true) goto L7;
        return false;
    L7:
        if (r10.getPointerCount() <= 1) goto L14;
        if (isClosed() == true) goto L14;
        if (r10.getAction() == 6) goto L14;
        return true;
    L14:
        if (this.mIgnoreGesture == false) goto L17;
        return true;
    L17:
        if (r10.getActionMasked() != 0) goto L25;
        if (this.mCurrentCoverLeft < this.mLeftOpenCoverLeft) goto L25;
        if (isMotionOnCover(r10) == false) goto L25;
        this.mIgnoreGesture = true;
        closeAutonomously();
        return true;
    L25:
        if (r10.getActionMasked() == 3) goto L28;
        scrollByTouch(r10);
    L28:
        if ((getParent() instanceof MyAppSwipeListView) == false) goto L38;
        MyAppSwipeListView r11 = (MyAppSwipeListView) getParent();
        int r12 = r10.getActionMasked();
        if (r12 == 1) goto L35;
        if (r12 != 3) goto L38;
        r11.canceledTarget = this;
        goto L38
    L35:
        if (r11.canceledTarget != this) goto L38;
        r11.canceledTarget = null;
    L38:
        return super.onTouchEvent(r10);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        if (r10 == 0) goto L6;
        forceClose();
        return;
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        scrollTo(r10, false, r11);
    }

    public void setChecked(boolean r10) {
        CheckBox r11 = this.mCheckBox;
        if (r11 == null) goto L6;
        r11.setChecked(r10);
        return;
    }

    @Override // android.view.View
    public void setClickable(boolean r10) {
        super.setClickable(r10);
        View r11 = this.mTopShownView;
        if (r11 == null) goto L6;
        r11.setClickable(r10);
        return;
    }

    public void setInListViewLayout(boolean r10) {
        this.mIsInListViewLayout = r10;
    }

    public void setSwipeItemActionListener(OnSwipeItemActionListener r10) {
        this.mSwipeListener = r10;
    }

    private void scrollTo(int r10, boolean r11, int r12) {
        int r13 = this.mCurrentCoverLeft;
        this.mScroller.startScroll(r13, 0, r10 - r13, 0, r12, r11);
        post(newScrollRunner());
    }

    public void dismissAnimation(AppInfo r10, Runnable r11) {
        dismissAnimation(r10);
        r11.run();
    }

    public MyAppSwipeItemView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mDeletBtn = null;
        this.mGestureStartLeft = -1;
        this.mCloseCoverLeft = 0;
        this.mScrollDuration = AnimationConstants.DURATION_350;
        this.mItemSwipeType = 0;
        this.mOnMenuItemClickListener = new AnonymousClass3(this);
        this.mGestureListener = new AnonymousClass6(this);
        init(r10);
    }

    public MyAppSwipeItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mDeletBtn = null;
        this.mGestureStartLeft = -1;
        this.mCloseCoverLeft = 0;
        this.mScrollDuration = AnimationConstants.DURATION_350;
        this.mItemSwipeType = 0;
        this.mOnMenuItemClickListener = new AnonymousClass3(this);
        this.mGestureListener = new AnonymousClass6(this);
        init(r10);
    }
}

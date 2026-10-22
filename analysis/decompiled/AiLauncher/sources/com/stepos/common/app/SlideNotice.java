package com.stepos.common.app;

import O6.n;
import O6.s;
import O6.t;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$style;
import com.stepos.common.app.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class SlideNotice {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static final int NOTICE_CLICK = 0;
    public static final int NOTICE_TYPE_FAILURE = 0;
    public static final int NOTICE_TYPE_SUCCESS = 1;
    public static final int SHOW_ANIMATION_DURATION = 320;
    public static final int SLIDE_TYPE_FROM_BOTTOM = 2;
    public static final int SLIDE_TYPE_FROM_TOP = 1;
    private static final String TAG = "SlideNotice";
    private static b mService;
    private static Field sStepOSFlag;
    private boolean isAutoAdaptNavigationBar;
    private Context mContext;
    private int mDuration;
    private SlideViewController mSlideViewController;
    private Toast mToast;
    private static final Interpolator SHOW_INTERPOLATOR = new L6.a(0.2f, 0.46f, 0.1f, 1.0f);
    private static final Interpolator HIDE_INTERPOLATOR = new L6.a(0.33f, 0.061f, 0.24f, 1.0f);

    public static final class NoticeHandler extends Handler {
        private WeakReference<SlideNotice> mNotice;

        public NoticeHandler(SlideNotice slideNotice) {
            this.mNotice = new WeakReference<>(slideNotice);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            ((OnClickNoticeListener) message.obj).onClick(this.mNotice.get());
        }
    }

    public interface OnClickNoticeListener {
        void onClick(SlideNotice slideNotice);
    }

    public static final class SlideContainerView extends FrameLayout {
        public SlideContainerView(Context context) {
            super(context);
        }
    }

    public class SlideViewController implements b.InterfaceC0347b {
        private static final int SLIDE_STATE_TYPE_HIDDEN = 3;
        private static final int SLIDE_STATE_TYPE_HIDING = 1;
        private static final int SLIDE_STATE_TYPE_SHOWING = 0;
        private static final int SLIDE_STATE_TYPE_SHOWN = 2;
        private boolean isBelowDefaultActionBar;
        private boolean isSupportedImmersedStatusBar;
        private int mActionBarHeight;
        private WeakReference<View> mAnchor;
        private ViewPropertyAnimator mCurAnimator;
        private FrameLayout mCustom;
        private View mCustomView;
        private boolean mHasCustom;
        private boolean mIsOverlaidByStatusBarSet;
        private int mLeft;
        private int mNoticeBgColor;
        private Message mNoticeClickMsg;
        private Handler mNoticeHandler;
        private int mNoticeHeight;
        private LinearLayout mNoticePanel;
        private TextView mNoticeView;
        private int mNoticeWidth;
        private OnClickNoticeListener mOnClickNoticeListener;
        private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
        private View mSlideContent;
        private SlideContainerView mSlideDecorView;
        private SlidingHideListener mSlidingHideListener;
        private SlidingShowListener mSlidingShowListener;
        private int mStatusBarHeight;
        private WindowManager mWManager;
        int mYOffset;
        private boolean showing;
        private CharSequence text;
        private boolean mIsOverlaidByStatusBar = false;
        private WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        private final View.OnClickListener mContentClickListener = new View.OnClickListener() { // from class: com.stepos.common.app.SlideNotice.SlideViewController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Message messageObtain = SlideViewController.this.mNoticeClickMsg != null ? Message.obtain(SlideViewController.this.mNoticeClickMsg) : null;
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
            }
        };
        int mGravity = 80;
        int mSlideState = 3;
        int mSlideFromType = -1;
        private boolean isSlideAnim = false;

        public class SlidingHideListener extends AnimatorListenerAdapter {
            private SlidingHideListener() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlideViewController.this.destroy();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SlideViewController.this.mSlideState = 1;
            }
        }

        public class SlidingShowListener extends AnimatorListenerAdapter {
            private boolean mIsCanceled;

            private SlidingShowListener() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.mIsCanceled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (this.mIsCanceled) {
                    return;
                }
                SlideViewController.this.mSlideState = 2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SlideViewController.this.mSlideState = 0;
            }
        }

        public SlideViewController(SlideNotice slideNotice) throws RuntimeException {
            this.mNoticeHandler = new NoticeHandler(slideNotice);
            init();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            SlideContainerView slideContainerView = this.mSlideDecorView;
            if (slideContainerView != null && slideContainerView.getParent() != null) {
                this.mWManager.removeView(this.mSlideDecorView);
            }
            unregisterForScrollChanged();
            this.mOnScrollChangedListener = null;
            this.showing = false;
            this.mSlideState = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int[] findPositionByAnchor(View view, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int[] iArr = new int[2];
            int height = view.getHeight();
            view.getLocationInWindow(iArr);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int iC = t.c(SlideNotice.this.mContext);
            int iB = t.b(this.mWManager);
            int i11 = rect.bottom;
            if (i11 == iB) {
                iC = 0;
            }
            return i10 == 1 ? new int[]{iArr[0], iArr[1] + height + iC} : new int[]{iArr[0], (i11 - iArr[1]) + iC};
        }

        private int getActionBarHeight(Context context) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
                return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
            }
            return 144;
        }

        private void handleHide() {
            if (this.showing) {
                if (!this.isSlideAnim) {
                    this.mSlideState = 1;
                    destroy();
                    return;
                }
                ViewPropertyAnimator viewPropertyAnimator = this.mCurAnimator;
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.cancel();
                }
                if (this.mSlideState == 3) {
                    destroy();
                    return;
                }
                int measuredHeight = this.mSlideContent.getMeasuredHeight();
                if (this.mSlideFromType == 1) {
                    measuredHeight = -measuredHeight;
                }
                ViewPropertyAnimator viewPropertyAnimatorTranslationY = this.mSlideContent.animate().translationY(measuredHeight);
                viewPropertyAnimatorTranslationY.setDuration(320L);
                viewPropertyAnimatorTranslationY.setInterpolator(SlideNotice.HIDE_INTERPOLATOR);
                viewPropertyAnimatorTranslationY.setListener(this.mSlidingHideListener);
                viewPropertyAnimatorTranslationY.start();
                this.mCurAnimator = viewPropertyAnimatorTranslationY;
            }
        }

        private void handleShow() {
            if (this.showing) {
                return;
            }
            prepareNotice(this.mParams);
            setupPosition();
            setupView();
            invokeNotice();
            if (this.isSlideAnim) {
                this.mSlideContent.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.stepos.common.app.SlideNotice.SlideViewController.3
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        SlideViewController.this.mSlideContent.getViewTreeObserver().removeOnPreDrawListener(this);
                        int measuredHeight = SlideViewController.this.mSlideContent.getMeasuredHeight();
                        SlideViewController slideViewController = SlideViewController.this;
                        if (slideViewController.mSlideFromType == 1) {
                            measuredHeight = -measuredHeight;
                        }
                        slideViewController.mSlideContent.setTranslationY(measuredHeight);
                        ViewPropertyAnimator viewPropertyAnimatorTranslationY = SlideViewController.this.mSlideContent.animate().translationY(0.0f);
                        viewPropertyAnimatorTranslationY.setDuration(320L);
                        viewPropertyAnimatorTranslationY.setListener(SlideViewController.this.mSlidingShowListener);
                        viewPropertyAnimatorTranslationY.setInterpolator(SlideNotice.SHOW_INTERPOLATOR);
                        viewPropertyAnimatorTranslationY.start();
                        SlideViewController.this.mCurAnimator = viewPropertyAnimatorTranslationY;
                        return false;
                    }
                });
            } else {
                this.mSlideState = 2;
            }
            this.showing = true;
            trySendAccessibilityEvent();
        }

        private void init() throws RuntimeException {
            View viewInflate = LayoutInflater.from(SlideNotice.this.mContext).inflate(R$layout.mc_slide_notice_content, (ViewGroup) null);
            this.mSlideContent = viewInflate;
            this.mNoticeView = (TextView) viewInflate.findViewById(R$id.noticeView);
            this.mNoticePanel = (LinearLayout) this.mSlideContent.findViewById(R$id.noticePanel);
            this.mCustom = (FrameLayout) this.mSlideContent.findViewById(R$id.custom);
            this.mSlideContent.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            this.mStatusBarHeight = s.d(SlideNotice.this.mContext);
            this.mActionBarHeight = getActionBarHeight(SlideNotice.this.mContext);
            this.mSlidingHideListener = new SlidingHideListener();
            this.mSlidingShowListener = new SlidingShowListener();
            Context applicationContext = SlideNotice.this.mContext.getApplicationContext();
            if (applicationContext != null) {
                this.mWManager = (WindowManager) applicationContext.getSystemService("window");
            } else {
                this.mWManager = (WindowManager) SlideNotice.this.mContext.getSystemService("window");
            }
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.height = -2;
            layoutParams.width = -1;
            layoutParams.format = -3;
            layoutParams.setTitle("SlideNotice:" + Integer.toHexString(hashCode()));
            this.mParams.flags = 40;
            if (SlideNotice.this.mContext instanceof Activity) {
                return;
            }
            this.mActionBarHeight = SlideNotice.this.mContext.getResources().getDimensionPixelSize(R$dimen.stepos_action_bar_default_height);
        }

        private void invokeNotice() {
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.x = this.mLeft;
            layoutParams.y = this.mYOffset;
            if (SlideNotice.this.mContext != null) {
                this.mParams.packageName = SlideNotice.this.mContext.getPackageName();
            }
            this.mWManager.addView(this.mSlideDecorView, this.mParams);
        }

        private void prepareNotice(WindowManager.LayoutParams layoutParams) {
            Window window;
            if (SlideNotice.this.mContext instanceof Activity) {
                window = ((Activity) SlideNotice.this.mContext).getWindow();
                IBinder windowToken = window.getDecorView().getWindowToken();
                if (windowToken != null) {
                    layoutParams.token = windowToken;
                    layoutParams.type = 1000;
                } else {
                    layoutParams.type = 2005;
                }
            } else {
                layoutParams.type = 2005;
                window = null;
            }
            if (!this.isSlideAnim) {
                layoutParams.windowAnimations = R$style.Animation_StepOS_Snackbar;
            }
            boolean transStatusBar = setTransStatusBar(this.mParams, window);
            this.isSupportedImmersedStatusBar = transStatusBar;
            if (!transStatusBar) {
                this.mStatusBarHeight = 0;
            }
            int i10 = this.mNoticeWidth;
            if (i10 > 0) {
                layoutParams.width = i10;
            }
            int i11 = this.mGravity;
            layoutParams.gravity = i11;
            if (this.mSlideFromType == -1) {
                if ((i11 & 112) == 48) {
                    this.mSlideFromType = 1;
                } else if ((i11 & 112) == 80) {
                    this.mSlideFromType = 2;
                }
            }
        }

        private boolean setTransStatusBar(WindowManager.LayoutParams layoutParams, Window window) {
            if (window != null) {
                return true;
            }
            try {
                layoutParams.flags |= 67108864;
                return true;
            } catch (Exception e10) {
                Log.e(SlideNotice.TAG, "Can't set the status bar to be transparent, Caused by:" + e10.getMessage());
                return false;
            }
        }

        private void setWindowInsetsListener() {
            View childAt;
            if (SlideNotice.this.mContext instanceof Activity) {
                View decorView = ((Activity) SlideNotice.this.mContext).getWindow().getDecorView();
                if (!(decorView instanceof ViewGroup) || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.stepos.common.app.SlideNotice.SlideViewController.4
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        int iB = n.b(SlideNotice.this.mContext);
                        if (!SlideNotice.this.isAutoAdaptNavigationBar) {
                            SlideViewController slideViewController = SlideViewController.this;
                            if (slideViewController.mGravity != 80 || slideViewController.mYOffset != 0) {
                                return windowInsets;
                            }
                        }
                        int[] iArr = new int[2];
                        if (iB > 0) {
                            iArr[1] = iB + SlideNotice.this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_content_toast_content_margin_bottom_navigationBar);
                        } else {
                            iArr[1] = SlideNotice.this.mContext.getResources().getDimensionPixelSize(R$dimen.mc_content_toast_content_margin_bottom_default);
                        }
                        SlideViewController.this.update(iArr);
                        SlideNotice.this.isAutoAdaptNavigationBar = true;
                        return windowInsets;
                    }
                });
            }
        }

        private void setupContent() {
            this.mNoticeView.setVisibility(8);
            if (!this.mIsOverlaidByStatusBarSet && this.mSlideFromType == 1 && this.mYOffset < this.mStatusBarHeight && this.isSupportedImmersedStatusBar) {
                this.mIsOverlaidByStatusBar = true;
            }
            if (this.mIsOverlaidByStatusBar) {
                TextView textView = (TextView) this.mSlideContent.findViewById(R$id.noticeView_no_title_bar);
                this.mNoticeView = textView;
                ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = this.mStatusBarHeight;
            } else {
                ((LinearLayout.LayoutParams) this.mNoticeView.getLayoutParams()).topMargin = 0;
                this.mNoticeView = (TextView) this.mSlideContent.findViewById(R$id.noticeView);
            }
            if (this.mNoticeHeight > 0) {
                this.mNoticePanel.getLayoutParams().height = this.mNoticeHeight;
            }
            this.mNoticeView.setText(this.text);
            this.mNoticeView.setVisibility(0);
            this.mNoticePanel.setBackgroundColor(this.mNoticeBgColor);
            this.mNoticePanel.setVisibility(0);
        }

        private boolean setupCustom() {
            View view = this.mCustomView;
            if (view == null) {
                this.mCustom.setVisibility(8);
                return false;
            }
            ViewParent parent = view.getParent();
            FrameLayout frameLayout = this.mCustom;
            if (parent == frameLayout) {
                frameLayout.removeView(this.mCustomView);
            }
            this.mCustom.removeAllViews();
            this.mCustom.addView(this.mCustomView);
            ViewGroup.LayoutParams layoutParams = this.mCustomView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.mCustom.setVisibility(0);
            return true;
        }

        private void setupPosition() {
            WeakReference<View> weakReference = this.mAnchor;
            if (weakReference != null) {
                View view = weakReference != null ? weakReference.get() : null;
                if (view == null || view.getParent() == null) {
                    return;
                }
                this.mYOffset = findPositionByAnchor(view, this.mSlideFromType)[1];
                return;
            }
            if (this.isBelowDefaultActionBar && this.mYOffset == 0) {
                this.mYOffset = this.mActionBarHeight + this.mStatusBarHeight;
                return;
            }
            if (this.mGravity == 80 && this.mYOffset == 0) {
                if (n.b(SlideNotice.this.mContext) > 0 && this.mYOffset == 0) {
                    SlideNotice.this.isAutoAdaptNavigationBar = true;
                    this.mYOffset = n.b(SlideNotice.this.mContext);
                } else {
                    if (n.b(SlideNotice.this.mContext) > 0 || this.mYOffset != 0) {
                        return;
                    }
                    SlideNotice.this.isAutoAdaptNavigationBar = true;
                    this.mYOffset = 0;
                }
            }
        }

        private void setupView() {
            if (this.mSlideDecorView == null) {
                SlideContainerView slideContainerView = new SlideContainerView(SlideNotice.this.mContext);
                this.mSlideDecorView = slideContainerView;
                slideContainerView.addView(this.mSlideContent);
            }
            boolean z10 = setupCustom();
            this.mHasCustom = z10;
            if (z10) {
                this.mNoticePanel.setVisibility(8);
            } else {
                setupContent();
            }
            if (this.mOnClickNoticeListener != null) {
                this.mSlideContent.setOnClickListener(this.mContentClickListener);
                this.mNoticeClickMsg = this.mNoticeHandler.obtainMessage(0, this.mOnClickNoticeListener);
            }
            this.mSlideContent.setVisibility(0);
        }

        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager = (AccessibilityManager) SlideNotice.this.mContext.getSystemService("accessibility");
            if (accessibilityManager.isEnabled()) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(64);
                accessibilityEventObtain.setClassName(getClass().getName());
                accessibilityEventObtain.setPackageName(this.mSlideDecorView.getContext().getPackageName());
                this.mSlideDecorView.dispatchPopulateAccessibilityEvent(accessibilityEventObtain);
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            }
        }

        private void unregisterForScrollChanged() {
            WeakReference<View> weakReference = this.mAnchor;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null) {
                view.getViewTreeObserver().removeOnScrollChangedListener(this.mOnScrollChangedListener);
            }
            this.mAnchor = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(int[] iArr) {
            SlideContainerView slideContainerView;
            if (!this.showing || (slideContainerView = this.mSlideDecorView) == null || slideContainerView.getParent() == null) {
                return;
            }
            int i10 = iArr[1];
            this.mYOffset = i10;
            WindowManager.LayoutParams layoutParams = this.mParams;
            layoutParams.y = i10;
            this.mWManager.updateViewLayout(this.mSlideDecorView, layoutParams);
        }

        public CharSequence getText() {
            return this.text;
        }

        public int getTop() {
            return this.mYOffset;
        }

        @Override // com.stepos.common.app.b.InterfaceC0347b
        public void hide() {
            handleHide();
        }

        public boolean isShowing() {
            return this.showing;
        }

        public void resetTop() {
            if (this.isBelowDefaultActionBar) {
                this.mYOffset = this.mActionBarHeight + this.mStatusBarHeight;
            } else {
                this.mYOffset = 0;
            }
        }

        public void setAnchor(View view) {
            if (view != null) {
                unregisterForScrollChanged();
                this.mAnchor = new WeakReference<>(view);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    if (this.mOnScrollChangedListener == null) {
                        this.mOnScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.stepos.common.app.SlideNotice.SlideViewController.2
                            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                            public void onScrollChanged() {
                                View view2 = SlideViewController.this.mAnchor != null ? (View) SlideViewController.this.mAnchor.get() : null;
                                if (view2 == null || view2.getParent() == null || SlideViewController.this.mSlideContent == null) {
                                    return;
                                }
                                SlideViewController slideViewController = SlideViewController.this;
                                SlideViewController.this.update(slideViewController.findPositionByAnchor(view2, slideViewController.mSlideFromType));
                            }
                        };
                    }
                    viewTreeObserver.addOnScrollChangedListener(this.mOnScrollChangedListener);
                }
            }
        }

        public void setBelowDefaultActionBar(boolean z10) {
            this.isBelowDefaultActionBar = z10;
            if (z10) {
                this.mGravity = 48;
            }
        }

        public void setCustomView(View view) {
            this.mCustomView = view;
        }

        public void setIsOverlaidByStatusBar(boolean z10) {
            this.mIsOverlaidByStatusBar = z10;
            if (z10) {
                this.mGravity = 48;
            }
            this.mIsOverlaidByStatusBarSet = true;
        }

        public void setLeft(int i10) {
            this.mLeft = i10;
        }

        public void setNoticeBgColor(int i10) {
            this.mNoticeBgColor = i10;
        }

        public void setNoticeHeight(int i10) {
            this.mNoticeHeight = i10;
        }

        public void setNoticeWidth(int i10) {
            this.mNoticeWidth = i10;
        }

        public void setOnClickNoticeListener(OnClickNoticeListener onClickNoticeListener) {
            this.mOnClickNoticeListener = onClickNoticeListener;
        }

        public void setSlideAnimEnable(boolean z10) {
            this.isSlideAnim = z10;
        }

        public void setText(CharSequence charSequence) {
            this.text = charSequence;
            TextView textView = this.mNoticeView;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }

        @Override // com.stepos.common.app.b.InterfaceC0347b
        public void show() {
            handleShow();
            setWindowInsetsListener();
        }
    }

    public SlideNotice(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context can not be null!");
        }
        this.mContext = context;
        this.mSlideViewController = new SlideViewController(this);
    }

    private static b getManager() {
        b bVar = mService;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        mService = bVar2;
        return bVar2;
    }

    public static SlideNotice makeNotice(Context context, CharSequence charSequence) {
        return makeNotice(context, charSequence, 1, 0);
    }

    public static SlideNotice makeSlideNotice(Context context, CharSequence charSequence) {
        return makeSlideNotice(context, charSequence, 1, 0);
    }

    public void cancel() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.cancel();
        }
    }

    public void cancelNotice() {
        this.mSlideViewController.hide();
        getManager().c(this.mSlideViewController);
    }

    public void cancelWithoutAnim() {
        this.mSlideViewController.destroy();
        getManager().c(this.mSlideViewController);
    }

    public void finish() {
        cancel();
    }

    public int getDuration() {
        return this.mDuration;
    }

    public boolean isShowing() {
        return this.mSlideViewController.isShowing();
    }

    public void resetSlideFrom() {
        this.mSlideViewController.resetTop();
    }

    public void setActionBarToTop(boolean z10) {
        this.mSlideViewController.setBelowDefaultActionBar(z10);
    }

    public void setAnchorView(View view) {
        this.mSlideViewController.setAnchor(view);
    }

    public void setBeginColor(int i10) {
        setNoticeBackgroundColor(i10);
    }

    public void setBelowDefaultActionBar(boolean z10) {
        this.mSlideViewController.setBelowDefaultActionBar(z10);
    }

    public void setCustomView(View view) {
        this.mSlideViewController.setCustomView(view);
    }

    public void setDuration(int i10) {
        this.mDuration = i10;
        Toast toast = this.mToast;
        if (toast != null) {
            toast.setDuration(i10);
        }
    }

    public void setEndColor(int i10) {
        setNoticeBackgroundColor(i10);
    }

    public void setGravity(int i10) {
        this.mSlideViewController.mGravity = i10;
    }

    public void setHeight(int i10) {
        this.mSlideViewController.setNoticeHeight(i10);
    }

    public void setIsOverlaidByStatusBar(boolean z10) {
        this.mSlideViewController.setIsOverlaidByStatusBar(z10);
    }

    public void setLeft(int i10) {
        this.mSlideViewController.setLeft(i10);
    }

    public void setNoTitleBarStyle(boolean z10) {
        this.mSlideViewController.setIsOverlaidByStatusBar(z10);
    }

    public void setNoticeBackgroundColor(int i10) {
        this.mSlideViewController.setNoticeBgColor(i10);
    }

    public void setNoticeType(int i10) {
        if (this.mSlideViewController.isShowing()) {
            return;
        }
        if (i10 != 0) {
            setBeginColor(this.mContext.getResources().getColor(R$color.mc_slide_notice_success_begin_color));
            setEndColor(this.mContext.getResources().getColor(R$color.mc_slide_notice_success_end_color));
        } else {
            setBeginColor(this.mContext.getResources().getColor(R$color.mc_slide_notice_failure_begin_color));
            setEndColor(this.mContext.getResources().getColor(R$color.mc_slide_notice_failure_end_color));
        }
    }

    public void setOnClickNoticeListener(OnClickNoticeListener onClickNoticeListener) {
        this.mSlideViewController.setOnClickNoticeListener(onClickNoticeListener);
    }

    public void setSlideAnimEnable(boolean z10) {
        this.mSlideViewController.setSlideAnimEnable(z10);
    }

    public void setSlideType(int i10) {
        this.mSlideViewController.mSlideFromType = i10;
    }

    public void setText(CharSequence charSequence) {
        this.mSlideViewController.setText(charSequence);
        Toast toast = this.mToast;
        if (toast != null) {
            toast.setText(charSequence);
        }
    }

    public void setTop(int i10) {
        setYOffset(i10);
    }

    public void setWidth(int i10) {
        this.mSlideViewController.setNoticeWidth(i10);
    }

    public void setYOffset(int i10) {
        this.mSlideViewController.mYOffset = i10;
    }

    public void show(boolean z10) {
    }

    public void showAndFinish(long j10) {
    }

    public void showNotice() {
        getManager().d(this.mSlideViewController.getText(), this.mSlideViewController, this.mDuration);
    }

    public void slideToCancel() {
        cancelNotice();
    }

    public void slideToShow() {
        showNotice();
    }

    public static SlideNotice makeNotice(Context context, CharSequence charSequence, int i10) {
        return makeNotice(context, charSequence, 0, 0);
    }

    public static SlideNotice makeSlideNotice(Context context, CharSequence charSequence, int i10) {
        SlideNotice slideNotice = new SlideNotice(context);
        slideNotice.setText(charSequence);
        slideNotice.setNoticeType(i10);
        return slideNotice;
    }

    public void show() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.show();
        }
    }

    public void slideToShow(boolean z10) {
        showNotice(z10);
    }

    public static SlideNotice makeNotice(Context context, CharSequence charSequence, int i10, int i11) {
        return new SlideNotice(context, charSequence, i11);
    }

    public void showNotice(boolean z10) {
        if (z10) {
            this.mSlideViewController.show();
        } else {
            showNotice();
        }
    }

    public SlideNotice(Context context, CharSequence charSequence, int i10) {
        this(context);
        this.mToast = Toast.makeText(context, charSequence, i10);
    }

    public static SlideNotice makeSlideNotice(Context context, CharSequence charSequence, int i10, int i11) {
        SlideNotice slideNotice = new SlideNotice(context);
        slideNotice.setText(charSequence);
        slideNotice.setNoticeType(i10);
        slideNotice.mDuration = i11;
        return slideNotice;
    }
}

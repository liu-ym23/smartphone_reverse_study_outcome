package com.bytedance.android.live.uikit.toast;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bc1.d;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.common.utility.StringUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes7.dex */
public class CustomToast {
    public static final int LENGTH_LONG = 3500;
    public static final int LENGTH_SHORT = 2500;
    private float mActionCurrentY;
    private float mActionDownY;
    private View mContentView;
    private Context mContext;
    private int mDefaultLayoutId;
    private long mDuration;
    private int mGravity;
    private AnimatorSet mHideAnimatorSet;
    private int mIcon;
    private ImageView mImageView;
    private boolean mIsDismissing;
    private boolean mIsLightMode;
    private boolean mIsShowing;
    private int mLastLayoutId;
    private View mLastToast;
    private WindowManager.LayoutParams mLayoutParams;
    private int[] mMargin;
    private boolean mOnPause;
    private boolean mScalable;
    private AnimatorSet mScaleLargeAnimatorSet;
    private AnimatorSet mScaleSmallAnimatorSet;
    private AnimatorSet mShowAnimatorSet;
    private int mStartAnimHeight;
    private boolean mSwipeToDismiss;
    private String mText;
    private TextView mTextView;
    private ViewGroup mViewGroup;
    private WindowManager mWindowManager;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomToast f102471a;

        public a(CustomToast r100) {
            this.f102471a = r100;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 != 0) goto L5;
            CustomToast.access$002(this.f102471a, r101.getY());
            CustomToast r103 = this.f102471a;
            CustomToast.access$200(r103, CustomToast.access$100(r103), 1.0f, 0.98f);
            return false;
        L5:
            if (r102 != 1) goto L7;
            CustomToast r104 = this.f102471a;
            CustomToast.access$200(r104, CustomToast.access$400(r104), 0.98f, 1.0f);
            if (CustomToast.access$500(this.f102471a) == true) goto L16;
            return false;
        L16:
            if ((CustomToast.access$300(this.f102471a) - CustomToast.access$000(this.f102471a)) < 0.0f) goto L18;
            return false;
        L18:
            if (Math.abs(CustomToast.access$300(this.f102471a) - CustomToast.access$000(this.f102471a)) <= 20.0f) goto L27;
            bc1.a.b().c(this.f102471a);
            return false;
        L27:
            return false;
        L7:
            if (r102 != 2) goto L9;
            CustomToast.access$302(this.f102471a, r101.getY());
            return false;
        L9:
            if (r102 != 3) goto L29;
            CustomToast r105 = this.f102471a;
            CustomToast.access$200(r105, CustomToast.access$400(r105), 0.98f, 1.0f);
            return false;
        L29:
            return false;
        }
    }

    public void onPause() {
        this.mOnPause = true;
    }

    public void onResume() {
        this.mOnPause = false;
    }

    public void dismiss() {
        if (this.mIsShowing == true) goto L5;
        return;
    L5:
        ViewGroup r100 = this.mViewGroup;
        if (r100 != null) goto L8;
    L10:
        this.mIsShowing = false;
        return;
    L8:
        if (r100.getParent() == null) goto L10;
        this.mWindowManager.removeView(this.mViewGroup);
        this.mViewGroup.removeView(this.mContentView);
        goto L10
    }

    public View getContentView() {
        View r100 = this.mContentView;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.mViewGroup;
    }

    public AnimatorSet getHideAnimatorSet() {
        if (this.mHideAnimatorSet != null) goto L6;
        AnimatorSet r100 = new AnimatorSet();
        this.mHideAnimatorSet = r100;
        r100.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.mViewGroup, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -this.mStartAnimHeight}), ObjectAnimator.ofFloat(this.mViewGroup, "alpha", new float[]{1.0f, 0.0f})});
        this.mHideAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mHideAnimatorSet.setDuration(320);
    L6:
        return this.mHideAnimatorSet;
    }

    public AnimatorSet getShowAnimatorSet() {
        if (this.mShowAnimatorSet != null) goto L6;
        AnimatorSet r100 = new AnimatorSet();
        this.mShowAnimatorSet = r100;
        r100.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.mViewGroup, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-this.mStartAnimHeight, 0.0f}), ObjectAnimator.ofFloat(this.mViewGroup, "alpha", new float[]{0.0f, 1.0f})});
        this.mShowAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mShowAnimatorSet.setDuration(320);
    L6:
        return this.mShowAnimatorSet;
    }

    public boolean isShowing() {
        View r100 = this.mContentView;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isShown() == false) goto L7;
        return true;
    }

    public boolean isToastRelease() {
        if (this.mContext != null) goto L5;
    L8:
        return true;
    L5:
        if (this.mOnPause == true) goto L8;
        return false;
    }

    public void onDestroyed() {
        dismiss();
        this.mContentView.clearAnimation();
        this.mContext = null;
        bc1.a r100 = bc1.a.b();
        ((LinkedList) r100.f18561a).remove(this);
    L4:
        if (((LinkedList) r100.f18561a).contains(this) == false) goto L6;
        ((LinkedList) r100.f18561a).remove(this);
        goto L4
    }

    public void show() {
        if (isToastRelease() == false) goto L6;
        return;
    L6:
        if (this.mTextView != null) goto L8;
    L10:
        this.mIsShowing = true;
        this.mViewGroup.removeAllViews();
        if (this.mContentView.getParent() != null) goto L13;
        this.mViewGroup.addView(this.mContentView);
    L15:
        if (this.mLayoutParams != null) goto L20;
        WindowManager.LayoutParams r100 = new WindowManager.LayoutParams(-1, -2, 2, 262280, -2);
        r100.flags = 262280;
        int r101 = this.mGravity;
        r100.gravity = r101;
        if (r101 != 48) goto L19;
        r100.y = this.mMargin[0];
    L19:
        this.mLayoutParams = r100;
    L20:
        this.mWindowManager = (WindowManager) this.mContext.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (this.mViewGroup.getParent() == null) goto L26;
        this.mWindowManager.removeView(this.mViewGroup);
    L26:
        INVOKEINTERFACE_com_bytedance_android_live_uikit_toast_CustomToast_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(this.mWindowManager, this.mViewGroup, this.mLayoutParams);     // Catch: Exception -> L25
        return;
    L28:
        return;
    L13:
        ((ViewGroup) this.mContentView.getParent()).removeView(this.mContentView);
        this.mViewGroup.addView(this.mContentView);
        goto L15
    L8:
        if (StringUtils.isEmpty(this.mText) == true) goto L10;
        this.mTextView.setText(this.mText);
        goto L10
    }

    public Context getContext() {
        return this.mContext;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public String getToastMessage() {
        return this.mText;
    }

    public boolean isDismissing() {
        return this.mIsDismissing;
    }

    public void onStop() {
        onDestroyed();
    }

    public CustomToast(Context r100) {
        this.mGravity = 49;
        this.mDuration = 2500;
        this.mIsDismissing = false;
        this.mSwipeToDismiss = false;
        this.mIsLightMode = false;
        init(r100, null);
    }

    public static /* synthetic */ float access$000(CustomToast r100) {
        return r100.mActionDownY;
    }

    public static /* synthetic */ AnimatorSet access$100(CustomToast r100) {
        return r100.mScaleLargeAnimatorSet;
    }

    public static /* synthetic */ float access$300(CustomToast r100) {
        return r100.mActionCurrentY;
    }

    public static /* synthetic */ AnimatorSet access$400(CustomToast r100) {
        return r100.mScaleSmallAnimatorSet;
    }

    public static /* synthetic */ boolean access$500(CustomToast r100) {
        return r100.mSwipeToDismiss;
    }

    private View inflateContentView(int r100) {
        LayoutInflater r101 = LayoutInflater.from(this.mContext);
        if (r100 != this.mLastLayoutId) goto L7;
        return this.mLastToast;
    L7:
        if (r100 != (-1)) goto L23;
        r100 = this.mDefaultLayoutId;
        if (r100 > 0) goto L23;
        if (this.mIsLightMode == false) goto L14;
        r100 = R.layout.liveuikit_custom_default_toast_light;
        goto L23
    L14:
        r100 = R.layout.liveuikit_custom_default_toast_deep;
    L23:
        View r102 = r101.inflate(r100, this.mViewGroup, false);     // Catch: InflateException -> L18
        this.mLastToast = r102;     // Catch: InflateException -> L18
        this.mLastLayoutId = r100;     // Catch: InflateException -> L18
        return r102;
    L19:
        if (this.mLastToast != null) goto L21;
        this.mLastToast = r101.inflate(R.layout.liveuikit_custom_default_toast_deep, this.mViewGroup, false);
    L21:
        this.mLastLayoutId = R.layout.liveuikit_custom_default_toast_deep;
        return this.mLastToast;
    }

    public void setDismissing(boolean r100) {
        this.mIsDismissing = r100;
    }

    public CustomToast setDuration(long r100) {
        this.mDuration = r100;
        return this;
    }

    public CustomToast setGravity(int r100) {
        this.mGravity = r100;
        return this;
    }

    public CustomToast setLightMode(boolean r100) {
        this.mIsLightMode = r100;
        return this;
    }

    public CustomToast setMarginBottom(int r100) {
        this.mMargin[1] = r100;
        return this;
    }

    public CustomToast setMarginLeft(int r100) {
        this.mMargin[3] = r100;
        return this;
    }

    public CustomToast setMarginRight(int r100) {
        this.mMargin[2] = r100;
        return this;
    }

    public CustomToast setMarginTop(int r100) {
        this.mMargin[0] = r100;
        return this;
    }

    public CustomToast setScalable(boolean r100) {
        this.mScalable = r100;
        return this;
    }

    public CustomToast setSwipeToDismiss(boolean r100) {
        this.mSwipeToDismiss = r100;
        return this;
    }

    public void showToast(String r100) {
        this.mContentView = inflateContentView(-1);
        initView(r100, -1);
        bc1.a.b().a(this);
    }

    public CustomToast(Context r100, int r101) {
        this.mGravity = 49;
        this.mDuration = 2500;
        this.mIsDismissing = false;
        this.mSwipeToDismiss = false;
        this.mIsLightMode = false;
        this.mDefaultLayoutId = r101;
        init(r100, null);
    }

    public static /* synthetic */ float access$002(CustomToast r100, float r101) {
        r100.mActionDownY = r101;
        return r101;
    }

    public static /* synthetic */ float access$302(CustomToast r100, float r101) {
        r100.mActionCurrentY = r101;
        return r101;
    }

    private void init(Context r100, View r101) {
        this.mContext = r100;
        this.mMargin = new int[4];
        if (isToastRelease() == false) goto L5;
        return;
    L5:
        this.mViewGroup = new FrameLayout(this.mContext);
        this.mStartAnimHeight = (int) r100.getResources().getDimension(R.dimen.toast_start_anim_height);
        this.mViewGroup.setOnTouchListener(new a(this));
        if (r101 == null) goto L9;
        this.mContentView = r101;
        return;
    }

    private void initView(String r100, int r101) {
        if (isToastRelease() == false) goto L5;
        return;
    L5:
        this.mText = r100;
        View r102 = this.mContentView;
        if (r102 == null) goto L8;
        this.mTextView = (TextView) r102.findViewById(R.id.text);
        this.mImageView = (ImageView) this.mContentView.findViewById(R.id.icon);
    L8:
        ImageView r103 = this.mImageView;
        if (r103 != null) goto L11;
    L13:
        int r104 = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);
        int r105 = View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE);
        this.mContentView.measure(r104, r105);
        return;
    L11:
        if (r101 != (-1)) goto L13;
        r103.setVisibility(8);
        goto L13
    }

    public void setShowAndHideAnimatorSet(AnimatorSet r100, AnimatorSet r101) {
        this.mShowAnimatorSet = r100;
        this.mHideAnimatorSet = r101;
    }

    public void showToast(int r100, d r101) {
        this.mContentView = inflateContentView(r100);
        if (r101 == null) goto L5;
        r101.a();
    L5:
        initView("", -1);
        bc1.a.b().a(this);
    }

    public CustomToast(Context r100, View r101) {
        this.mGravity = 49;
        this.mDuration = 2500;
        this.mIsDismissing = false;
        this.mSwipeToDismiss = false;
        this.mIsLightMode = false;
        init(r100, r101);
    }

    public void showToast(String r100, int r101) {
        this.mContentView = inflateContentView(-1);
        initView(r100, r101);
        bc1.a.b().a(this);
    }

    public static void INVOKEINTERFACE_com_bytedance_android_live_uikit_toast_CustomToast_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r100, View r101, ViewGroup.LayoutParams r102) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r101, r102);
        r100.addView(r101, r102);
    }

    private void startScaleAnimation(AnimatorSet r100, float r101, float r102) {
        if (this.mScalable == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
    L9:
        if (r100 == null) goto L12;
        r100.start();
        return;
    L12:
        return;
    L7:
        if (this.mContentView == null) goto L9;
        r100 = new AnimatorSet();
        r100.play(ObjectAnimator.ofFloat(this.mViewGroup, LiveDegradeFpsAnimator.SCALE_X, new float[]{r101, r102})).with(ObjectAnimator.ofFloat(this.mViewGroup, LiveDegradeFpsAnimator.SCALE_Y, new float[]{r101, r102}));
        r100.setDuration(80);
        goto L9
    }

    public static /* synthetic */ void access$200(CustomToast r100, AnimatorSet r101, float r102, float r103) {
        r100.startScaleAnimation(r101, r102, r103);
    }

    public CustomToast setMargin(int r100, int r101, int r102, int r103) {
        int[] r104 = this.mMargin;
        r104[0] = r100;
        r104[1] = r101;
        r104[2] = r102;
        r104[3] = r103;
        return this;
    }
}

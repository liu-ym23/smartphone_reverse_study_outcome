package android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.StepOSCtsUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import com.android.internal.R;
import com.android.internal.policy.StepOSSystemBarController;
import com.stepos.internal.picker.ContentCapture;

/* loaded from: classes.dex */
public class StepOSPopupWindowExtImpl implements IStepOSPopupWindowExt {
    private static final int STEPOS_ANIMATION_STYLE_NONE = -1;
    private boolean mCenterHorizontalOfAnchor;
    private AnimationSet mEnterAnimations;
    private AnimationSet mExitAnimations;
    private PopupWindow mHost;
    private boolean mIsAnimationToDismiss;
    private int mStepOSAnimationStyle = -1;

    public void onAttach(PopupWindow host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public void onPrepareBackgroundView(View backgroundView) {
        backgroundView.setOutlineSpotShadowColor(-939524096);
        backgroundView.setOutlineAmbientShadowColor(StepOSSystemBarController.COLO_BLACK);
    }

    public void onAfterInvokePopup(View backgroundView) throws Resources.NotFoundException {
        startEnterAnimation(backgroundView);
    }

    public void tryAutoFitPosition(WindowManager.LayoutParams outParams, View anchor, int xOffset, int yOffset, int width, int height, int anchorWidth, int anchorHeight, int[] drawingLocation, int[] screenLocation, Rect displayFrame, int hgrav) throws Resources.NotFoundException {
        if (!StepOSCtsUtils.isCtsRunning() && this.mStepOSAnimationStyle != -1 && hgrav == 0) {
            tryFitHorizontal(outParams, anchor, xOffset, width, anchorWidth, drawingLocation[0], screenLocation[0], displayFrame.left, displayFrame.right);
            tryFitVertical(outParams, anchor, yOffset, height, anchorHeight, drawingLocation[1], screenLocation[1], displayFrame.top, displayFrame.bottom);
        }
    }

    public boolean isAnimationToDismiss() {
        return this.mIsAnimationToDismiss;
    }

    public void startExitAnimation(View decorView, ViewGroup contentHolder, View contentView, View backgroundView, final Runnable dismissCallback) throws Resources.NotFoundException {
        if (backgroundView == null || this.mHost == null || this.mHost.getAnimationStyle() != 0 || this.mHost.getEnterTransition() != null || this.mStepOSAnimationStyle == -1) {
            dismissCallback.run();
            return;
        }
        if (this.mEnterAnimations != null && this.mEnterAnimations.hasStarted()) {
            this.mEnterAnimations.cancel();
        }
        if (this.mExitAnimations != null && this.mExitAnimations.hasStarted()) {
            this.mExitAnimations.cancel();
        }
        int animStyle = recomputeAnimationResource();
        if (animStyle <= 0) {
            dismissCallback.run();
            return;
        }
        Context context = backgroundView.getContext();
        TypedArray a = context.obtainStyledAttributes(animStyle, R.styleable.WindowAnimation);
        int exitAnim = a.getResourceId(1, 0);
        a.recycle();
        if (exitAnim <= 0) {
            dismissCallback.run();
            return;
        }
        this.mExitAnimations = (AnimationSet) AnimationUtils.loadAnimation(context, exitAnim);
        this.mExitAnimations.setAnimationListener(new Animation.AnimationListener() { // from class: android.widget.StepOSPopupWindowExtImpl.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                StepOSPopupWindowExtImpl.this.mIsAnimationToDismiss = false;
                dismissCallback.run();
                StepOSPopupWindowExtImpl.this.mExitAnimations = null;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mIsAnimationToDismiss = true;
        backgroundView.startAnimation(this.mExitAnimations);
    }

    public void onDispatchTouchEvent(View view, MotionEvent ev) {
        ContentCapture.getInstance().dispatchTouchEvent(view, ev, (Window) null, -1);
    }

    public void applyStepOSAnimation(int style) {
        if (style < -1 || style > 6) {
            return;
        }
        if (style >= 0) {
            this.mHost.setAnimationStyle(0);
        }
        this.mStepOSAnimationStyle = style;
    }

    private int recomputeAnimationResource() {
        switch (this.mStepOSAnimationStyle) {
            case 0:
                return resolveAutoFitAnimStyle();
            case 1:
                return android.R.style.Animation.Material.Dialog;
            case 2:
                return android.R.style.Animation.PopupWindow.ActionMode;
            case 3:
                return android.R.style.Animation.Material.Popup;
            case 4:
                return android.R.style.Animation.RecentApplications;
            case 5:
                return android.R.style.Animation.Material.Activity;
            case 6:
                return android.R.style.Animation.PopupWindow;
            default:
                return -1;
        }
    }

    private int resolveAutoFitAnimStyle() {
        int animStyle;
        int i;
        int i2;
        if (this.mHost.isAboveAnchor()) {
            animStyle = android.R.style.Animation.PopupWindow;
        } else {
            animStyle = android.R.style.Animation.Material.Activity;
        }
        WindowManager.LayoutParams layoutParams = this.mHost.getDecorViewLayoutParams();
        View anchorView = this.mHost.getAnchor();
        if (layoutParams == null || anchorView == null) {
            return animStyle;
        }
        int popupCenterX = layoutParams.x + (this.mHost.getWidth() / 2);
        int[] locationOnScreen = new int[2];
        anchorView.getLocationOnScreen(locationOnScreen);
        int anchorCenterX = locationOnScreen[0] + (anchorView.getWidth() / 2);
        if (popupCenterX > anchorCenterX + 5) {
            if (this.mHost.isAboveAnchor()) {
                i2 = android.R.style.Animation.PopupWindow.ActionMode;
            } else {
                i2 = android.R.style.Animation.Material.Dialog;
            }
            int animStyle2 = i2;
            return animStyle2;
        }
        if (popupCenterX < anchorCenterX - 5) {
            if (this.mHost.isAboveAnchor()) {
                i = android.R.style.Animation.RecentApplications;
            } else {
                i = android.R.style.Animation.Material.Popup;
            }
            int animStyle3 = i;
            return animStyle3;
        }
        return animStyle;
    }

    private void startEnterAnimation(View backgroundView) throws Resources.NotFoundException {
        if (backgroundView == null || this.mHost == null || this.mHost.getAnimationStyle() != 0 || this.mHost.getEnterTransition() != null || this.mStepOSAnimationStyle == -1) {
            return;
        }
        if (this.mEnterAnimations != null && this.mEnterAnimations.hasStarted()) {
            this.mEnterAnimations.cancel();
        }
        if (this.mExitAnimations != null && this.mExitAnimations.hasStarted()) {
            this.mExitAnimations.cancel();
        }
        int animStyle = recomputeAnimationResource();
        if (animStyle <= 0) {
            return;
        }
        Context context = backgroundView.getContext();
        TypedArray a = context.obtainStyledAttributes(animStyle, R.styleable.WindowAnimation);
        int enterAnim = a.getResourceId(0, 0);
        a.recycle();
        if (enterAnim <= 0) {
            return;
        }
        this.mEnterAnimations = (AnimationSet) AnimationUtils.loadAnimation(context, enterAnim);
        backgroundView.startAnimation(this.mEnterAnimations);
    }

    private void tryFitVertical(WindowManager.LayoutParams outParams, View anchor, int yOffset, int height, int anchorHeight, int drawingLocationY, int screenLocationY, int displayFrameTop, int displayFrameBottom) throws Resources.NotFoundException {
        int winOffsetY = screenLocationY - drawingLocationY;
        int anchorTopInScreen = outParams.y + winOffsetY;
        int spaceBelow = displayFrameBottom - anchorTopInScreen;
        int spaceAbove = anchorTopInScreen - displayFrameTop;
        int popupVerticalOffset = anchor.getContext().getResources().getDimensionPixelSize(17106609);
        if (spaceAbove >= spaceBelow) {
            outParams.y -= anchorHeight + height;
            outParams.y -= popupVerticalOffset;
        } else {
            outParams.y += popupVerticalOffset;
        }
    }

    private void tryFitHorizontal(WindowManager.LayoutParams outParams, View anchor, int xOffset, int width, int anchorWidth, int drawingLocationX, int screenLocationX, int displayFrameLeft, int displayFrameRight) {
        this.mCenterHorizontalOfAnchor = false;
        int anchorRightInScreen = screenLocationX + anchorWidth;
        int displayCenter = (displayFrameRight - displayFrameLeft) / 2;
        if (screenLocationX >= displayCenter || anchorRightInScreen > displayCenter) {
            if (screenLocationX >= displayCenter) {
                outParams.x -= width - anchorWidth;
            } else {
                outParams.x += (anchorWidth - width) / 2;
                this.mCenterHorizontalOfAnchor = true;
            }
        }
    }
}

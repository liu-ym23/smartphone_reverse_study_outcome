package com.android.contacts.common.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import com.android.contacts.common.R;
import com.android.contacts.common.util.ViewUtil;
import com.android.phone.common.animation.AnimUtils;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButtonController {
    public static final int ALIGN_END = 2;
    public static final int ALIGN_MIDDLE = 0;
    public static final int ALIGN_QUARTER_END = 1;
    private static final int FAB_ICON_FADE_OUT_DURATION = 66;
    private static final int FAB_SCALE_IN_DURATION = 266;
    private static final int FAB_SCALE_IN_FADE_IN_DELAY = 100;
    private final int mAnimationDuration;
    private final Interpolator mFabInterpolator;
    private final ImageButton mFloatingActionButton;
    private final View mFloatingActionButtonContainer;
    private final int mFloatingActionButtonMarginRight;
    private final int mFloatingActionButtonWidth;
    private int mScreenWidth;

    public FloatingActionButtonController(Activity r3, View r4, ImageButton r5) {
        Resources r0 = r3.getResources();
        this.mFabInterpolator = AnimationUtils.loadInterpolator(r3, 17563661);
        this.mFloatingActionButtonWidth = r0.getDimensionPixelSize(R.dimen.floating_action_button_width);
        this.mFloatingActionButtonMarginRight = r0.getDimensionPixelOffset(R.dimen.floating_action_button_margin_right);
        this.mAnimationDuration = r0.getInteger(R.integer.floating_action_button_animation_duration);
        this.mFloatingActionButtonContainer = r4;
        this.mFloatingActionButton = r5;
        ViewUtil.setupFloatingActionButton(r4, r0);
    }

    public void setScreenWidth(int r1) {
        this.mScreenWidth = r1;
    }

    public void setVisible(boolean r1) {
        View r0 = this.mFloatingActionButtonContainer;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public boolean isVisible() {
        if (this.mFloatingActionButtonContainer.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void changeIcon(Drawable r2, String r3) {
        if (this.mFloatingActionButton.getDrawable() == r2) goto L5;
    L6:
        this.mFloatingActionButton.setImageDrawable(r2);
        this.mFloatingActionButton.setContentDescription(r3);
        return;
    L5:
        if (this.mFloatingActionButton.getContentDescription().equals(r3) == false) goto L6;
    }

    public void onPageScrolled(float r3) {
        this.mFloatingActionButtonContainer.setTranslationX((int) (r3 * getTranslationXForAlignment(2)));
    }

    public void align(int r2, boolean r3) {
        align(r2, 0, 0, r3);
    }

    public void align(int r2, int r3, int r4, boolean r5) {
        if (this.mScreenWidth != 0) goto L5;
        return;
    L5:
        int r6 = getTranslationXForAlignment(r2);
        if (r5 == true) goto L8;
    L10:
        this.mFloatingActionButtonContainer.setTranslationX(r6 + r3);
        this.mFloatingActionButtonContainer.setTranslationY(r4);
        return;
    L8:
        if (this.mFloatingActionButtonContainer.isShown() == false) goto L10;
        this.mFloatingActionButtonContainer.animate().translationX(r6 + r3).translationY(r4).setInterpolator(this.mFabInterpolator).setDuration(this.mAnimationDuration).start();
    }

    public void resize(int r1, boolean r2) {
        if (r2 == false) goto L4;
        AnimUtils.changeDimensions(this.mFloatingActionButtonContainer, r1, r1);
        return;
    L4:
        this.mFloatingActionButtonContainer.getLayoutParams().width = r1;
        this.mFloatingActionButtonContainer.getLayoutParams().height = r1;
        this.mFloatingActionButtonContainer.requestLayout();
    }

    public void scaleIn(int r3) {
        setVisible(true);
        AnimUtils.scaleIn(this.mFloatingActionButtonContainer, FAB_SCALE_IN_DURATION, r3);
        AnimUtils.fadeIn(this.mFloatingActionButton, FAB_SCALE_IN_DURATION, r3 + 100, null);
    }

    public void resetIn() {
        this.mFloatingActionButton.setAlpha(1.0f);
        this.mFloatingActionButton.setVisibility(0);
        this.mFloatingActionButtonContainer.setScaleX(1.0f);
        this.mFloatingActionButtonContainer.setScaleY(1.0f);
    }

    public void scaleOut() {
        AnimUtils.scaleOut(this.mFloatingActionButtonContainer, this.mAnimationDuration);
        AnimUtils.fadeOut(this.mFloatingActionButton, 66, null);
    }

    public int getTranslationXForAlignment(int r3) {
        int r0 = 0;
        if (r3 != 0) goto L5;
        return 0;
    L5:
        if (r3 != 1) goto L7;
        r0 = this.mScreenWidth / 4;
    L12:
        if (isLayoutRtl() == true) goto L14;
        return r0;
    L14:
        return r0 * (-1);
    L7:
        if (r3 != 2) goto L12;
        r0 = ((this.mScreenWidth / 2) - (this.mFloatingActionButtonWidth / 2)) - this.mFloatingActionButtonMarginRight;
        goto L12
    }

    private boolean isLayoutRtl() {
        if (this.mFloatingActionButtonContainer.getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}

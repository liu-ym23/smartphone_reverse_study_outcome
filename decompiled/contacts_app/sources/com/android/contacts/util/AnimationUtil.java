package com.android.contacts.util;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import java.util.Iterator;
import obric.api.IntentSmt;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationUtil {
    public static final int ANIM_DURATION = 200;
    public static final String HIDE_VOICE_SEARCH = "hidden";
    public static final int LEFT_IN_WITH_RIGHT_OUT = 3;
    public static final int NO_ANIMATION = 0;
    public static final int NO_ANIMATION_WITH_DOWN_OUT = 2;
    public static final int POPUP_IN_WHIT_DOWN_OUT = 4;
    public static final int POPUP_IN_WITH_NO_ANIMATION = 1;
    public static final int RIGHT_IN_WITH_LEFT_OUT = 5;
    public static final int TYPE_EMPTY = 1;
    public static final int TYPE_RESULT = 0;
    private static Animation sHideVoiceBtnAnimation;
    private static Animation sShowVoiceBtnAnimation;

    private static int[] getAnimationResources(int r6) {
        int r0 = R.anim.pop_up_in;
        if (r6 == 1) goto L16;
        int r4 = R.anim.slide_down_out;
        if (r6 != 2) goto L7;
        r0 = 0;
    L18:
        return new int[]{r0, r4};
    L7:
        if (r6 != 3) goto L9;
        r0 = R.anim.slide_in_from_left;
        r4 = R.anim.slide_out_to_right;
        goto L18
    L9:
        if (r6 == 4) goto L18;
        if (r6 == 5) goto L13;
        r0 = 0;
        r4 = 0;
        goto L18
    L13:
        r0 = R.anim.slide_in_from_right;
        r4 = R.anim.slide_out_to_left;
        goto L18
    L16:
        r4 = R.anim.fake_anim;
        goto L18
    }

    public static void switchActivityAnimation(Activity r0, int r1) {
    }

    public AnimationUtil() {
    }

    public static void startActivity(Context r1, Intent r2) {
        startActivityWithAnimExtra(r1, r2, -1);
    }

    public static void startActivityWithAnimExtra(Context r2, Intent r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
        if ((r2 instanceof Activity) == false) goto L7;
        Activity r5 = (Activity) r2;
        r5.startActivityForResult(r3, r4);
        r5.overridePendingTransition(R.anim.pop_up_in, R.anim.fake_anim);
        return;
    L7:
        r2.startActivity(r3);
    }

    public static void startActivityWithAnimExtra(Context r1, Intent r2, int r3, int r4) {
        r2.putExtra(IntentSmt.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), getAnimationResources(r4));
        int[] r5 = getAnimationResources(r3);
        r1.startActivity(r2, ActivityOptions.makeCustomAnimation(r1, r5[0], r5[1]).toBundle());
    }

    public static void setVisibilityWithAnimation(final View r10, boolean r11, boolean r12) {
        AnimationSet r0 = new AnimationSet(true);
        if (r11 == true) goto L5;
    L9:
        if (r11 == false) goto L11;
        return;
    L11:
        if (r10.getVisibility() == 0) goto L13;
        return;
    L13:
        if (r12 == true) goto L16;
        r10.setVisibility(8);
        return;
    L16:
        if (r10.isShown() == false) goto L18;
        ScaleAnimation r13 = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation r14 = new AlphaAnimation(1.0f, 0.0f);
        r14.setAnimationListener(new AnonymousClass1(r10));
        r0.addAnimation(r13);
        r0.addAnimation(r14);
        r0.setDuration(100);
        r0.setInterpolator(new DecelerateInterpolator(1.0f));
        r10.startAnimation(r0);
        return;
    L18:
        r10.setVisibility(8);
        return;
    L5:
        if (r10.getVisibility() == 0) goto L9;
        r10.setVisibility(0);
        if (r12 == false) goto L20;
        r0.addAnimation(new ScaleAnimation(1.1f, 1.0f, 1.1f, 1.0f, 1, 0.5f, 1, 0.5f));
        r0.setDuration(50);
        r0.setInterpolator(new LinearInterpolator());
        r10.startAnimation(r0);
        return;
    }

    public static void showResultDialogWithAnim(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getVisibility() == 0) goto L8;
        r5.setVisibility(0);
        TranslateAnimation r0 = new TranslateAnimation(0.0f, 0.0f, 100.0f, 0.0f);
        AnimationSet r1 = new AnimationSet(true);
        AlphaAnimation r3 = new AlphaAnimation(0.0f, 1.0f);
        r1.setInterpolator(new DecelerateInterpolator(1.0f));
        r1.addAnimation(r0);
        r1.addAnimation(r3);
        r1.setDuration(200);
        r5.startAnimation(r1);
        return;
    }

    public static void hideResultDialogWithAnim(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getVisibility() != 0) goto L8;
        TranslateAnimation r0 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 100.0f);
        r5.setVisibility(8);
        AnimationSet r1 = new AnimationSet(true);
        AlphaAnimation r3 = new AlphaAnimation(1.0f, 0.0f);
        r1.setInterpolator(new DecelerateInterpolator(1.0f));
        r1.addAnimation(r0);
        r1.addAnimation(r3);
        r1.setDuration(200);
        r5.startAnimation(r1);
        return;
    }

    public static void startRecordWithAnimation(final View r17) {
        AnimationSet r1 = new AnimationSet(true);
        float r3 = (float) ((Math.random() * 0.08d) + 1.0d);
        ScaleAnimation r4 = new ScaleAnimation(0.95f, r3, 0.95f, r3, 1, 0.5f, 1, 0.5f);
        r4.setDuration(80);
        ScaleAnimation r15 = new ScaleAnimation(r3, 0.95f, r3, 0.95f, 1, 0.5f, 1, 0.5f);
        r15.setStartOffset(80);
        r15.setDuration(100);
        r15.setInterpolator(new LinearInterpolator());
        r1.addAnimation(r4);
        r1.addAnimation(r15);
        r1.setAnimationListener(new AnonymousClass2(r17));
        r17.setPadding(1, 1, 1, 1);
        r17.setVisibility(0);
        r17.startAnimation(r1);
    }

    public static void cancelAnimation(View r2) {
        if (r2 == null) goto L16;
        Animation r3 = r2.getAnimation();
        if (r3 != null) goto L6;
    L12:
        if (r3 == null) goto L18;
        r3.cancel();
        return;
    L18:
        return;
    L6:
        if ((r3 instanceof AnimationSet) == false) goto L12;
        AnimationSet r4 = (AnimationSet) r3;
        Iterator<Animation> r0 = r4.getAnimations().iterator();
    L9:
        if (r0.hasNext() == false) goto L11;
        r0.next().cancel();
        goto L9
    L11:
        r4.cancel();
        return;
    }

    public static void stopRecordWithAnimation(final View r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.getVisibility() == 8) goto L8;
        ScaleAnimation r0 = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        r0.setDuration(200);
        r0.setAnimationListener(new AnonymousClass3(r11));
        r11.startAnimation(r0);
        return;
    }

    public static void showCoverWithAnimation(View r3, Animation.AnimationListener r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getVisibility() == 0) goto L12;
        ((TextView) r3).setTextSize(13.0f);
        AlphaAnimation r0 = new AlphaAnimation(0.0f, 1.0f);
        r0.setDuration(200);
        if (r4 == null) goto L8;
        r0.setAnimationListener(r4);
    L9:
        r3.clearAnimation();
        r3.startAnimation(r0);
        return;
    L8:
        r3.setVisibility(0);
        goto L9
    }

    public static void hideCoverWithAnimation(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getVisibility() != 0) goto L8;
        r3.setVisibility(8);
        ((TextView) r3).setTextSize(0.0f);
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        r0.setDuration(200);
        r3.clearAnimation();
        r3.startAnimation(r0);
        return;
    }

    public static void showVoiceBtnWithAnimation(final View r2) {
        if (ContactsUtils.isVoiceSearchEnabled() == true) goto L7;
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    L12:
        return;
    L7:
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.getVisibility() == 0) goto L14;
        Animation r0 = getShowVoiceBtnAnimation();
        r0.setAnimationListener(new AnonymousClass4(r2));
        r2.startAnimation(r0);
        return;
    }

    public static void hideVoiceBtnWithAnimation(View r2) {
        if (ContactsUtils.isVoiceSearchEnabled() == true) goto L7;
        if (r2 == null) goto L12;
        r2.setVisibility(8);
        return;
    L12:
        return;
    L7:
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.getVisibility() != 0) goto L14;
        r2.setVisibility(8);
        r2.startAnimation(getHideVoiceBtnAnimation());
        return;
    }

    private static Animation getShowVoiceBtnAnimation() {
        if (sShowVoiceBtnAnimation != null) goto L6;
        TranslateAnimation r0 = new TranslateAnimation(0.0f, 0.0f, 240.0f, 0.0f);
        sShowVoiceBtnAnimation = r0;
        r0.setDuration(200);
        sShowVoiceBtnAnimation.setInterpolator(new OvershootInterpolator());
    L6:
        return sShowVoiceBtnAnimation;
    }

    private static Animation getHideVoiceBtnAnimation() {
        if (sHideVoiceBtnAnimation != null) goto L6;
        TranslateAnimation r0 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 240.0f);
        sHideVoiceBtnAnimation = r0;
        r0.setDuration(100);
        sHideVoiceBtnAnimation.setInterpolator(new DecelerateInterpolator(1.0f));
    L6:
        return sHideVoiceBtnAnimation;
    }
}

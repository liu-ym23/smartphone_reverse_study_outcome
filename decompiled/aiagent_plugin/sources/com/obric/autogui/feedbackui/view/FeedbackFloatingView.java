package com.obric.autogui.feedbackui.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.a.d;
import com.obric.oui.tag.OTextTag;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FeedbackFloatingView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FeedbackFloatingView extends RelativeLayout {
    public static final a Companion = null;
    public static final String KEY_END_X = "end_x";
    public static final String KEY_END_Y = "end_y";
    public static final String KEY_EVENT_SCROLL = "key_event_scroll";
    public static final String KEY_SCROLL_DURATION = "duration";
    public static final String KEY_START_X = "start_x";
    public static final String KEY_START_Y = "start_y";
    private TextView mActionTextView;
    private ImageView mAppIcon;
    private TextView mAppNameText;
    private ImageView mCenteredDrawableView;
    private OTextTag mDoneChip;
    private TextView mFeedbackTextView;
    private TextView mMetricsTextView;
    private long mScrollAnimGeneration;
    private Animator mScrollAnimator;
    private OTextTag mThinkingChip;

    /* JADX INFO: compiled from: FeedbackFloatingView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public FeedbackFloatingView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public FeedbackFloatingView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$AiagaMn4siNvS63NYeLIEek1RBM(ImageView r0, float r1, float r2, float r3, float r4, ValueAnimator r5) {
        showScrollPath$lambda$7$lambda$6$lambda$5(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$ETS0pMHXpjNS7fuBP6cG_SMVzW8(ImageView r0) {
        showCenteredDrawable$lambda$3$lambda$2(r0);
    }

    public /* synthetic */ FeedbackFloatingView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ long access$getMScrollAnimGeneration$p(FeedbackFloatingView r2) {
        return r2.mScrollAnimGeneration;
    }

    public static final /* synthetic */ void access$setMScrollAnimator$p(FeedbackFloatingView r0, Animator r1) {
        r0.mScrollAnimator = r1;
    }

    public FeedbackFloatingView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    public final TextView getMFeedbackTextView() {
        return this.mFeedbackTextView;
    }

    public final TextView getMActionTextView() {
        return this.mActionTextView;
    }

    public final TextView getMMetricsTextView() {
        return this.mMetricsTextView;
    }

    public final OTextTag getMThinkingChip() {
        return this.mThinkingChip;
    }

    public final OTextTag getMDoneChip() {
        return this.mDoneChip;
    }

    public final void setOperatingApp(Drawable r4, CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        ImageView r7 = this.mAppIcon;
        if (r7 == null) goto L13;
        r7.setVisibility(8);
    L13:
        if (r6 != null) goto L17;
        TextView r3 = this.mAppNameText;
        if (r3 == null) goto L24;
        r3.setVisibility(8);
        return;
    L24:
        return;
    L17:
        TextView r8 = this.mAppNameText;
        if (r8 == null) goto L20;
        r8.setText(r6);
    L20:
        TextView r9 = this.mAppNameText;
        if (r9 == null) goto L26;
        r9.setVisibility(0);
        return;
    L26:
        return;
    L7:
        ImageView r2 = this.mAppIcon;
        if (r2 == null) goto L10;
        r2.setImageDrawable(r4);
    L10:
        ImageView r10 = this.mAppIcon;
        if (r10 == null) goto L13;
        r10.setVisibility(0);
        goto L13
    }

    public final void setFeedbackText(String r3) {
        o.e(r3, "text");
        TextView r2 = this.mFeedbackTextView;
        if (r2 == null) goto L6;
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void setMetricsText(String r4) {
        o.e(r4, "text");
        TextView r3 = this.mMetricsTextView;
        if (r3 != null) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        r3.setVisibility(8);
        return;
    L10:
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        r3.setVisibility(0);
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void showCenteredDrawable(Drawable r2, float r3, float r4) {
        o.e(r2, "drawable");
        maybeInitCenteredDrawable();
        final ImageView r1 = this.mCenteredDrawableView;
        if (r1 == null) goto L6;
        r1.setImageDrawable(r2);
        r1.setX(r3 - (r1.getWidth() / 2.0f));
        r1.setY(r4 - (r1.getHeight() / 2.0f));
        r1.setAlpha(1.0f);
        r1.setVisibility(0);
        r1.animate().scaleX(1.5f).scaleY(1.5f).setDuration(300).withEndAction(new $$Lambda$FeedbackFloatingView$ETS0pMHXpjNS7fuBP6cG_SMVzW8(r1)).start();
        return;
    }

    private static final void showCenteredDrawable$lambda$3$lambda$2(ImageView r2) {
        r2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
    }

    private final void maybeInitCenteredDrawable() {
        if (this.mCenteredDrawableView != null) goto L6;
        ImageView r0 = new ImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RelativeLayout.LayoutParams(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.feedback_click_pos_indicator_size, "dimen", "feedback_click_pos_indicator_size")), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.feedback_click_pos_indicator_size, "dimen", "feedback_click_pos_indicator_size"))), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        this.mCenteredDrawableView = r0;
        addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void showScrollPath(float r14, float r15, float r16, float r17, long r18, Drawable r20) {
        o.e(r20, "drawable");
        maybeInitCenteredDrawable();
        final boolean r2 = d.f28974a.Z();
        if (r2 == false) goto L5;
        final long r3 = this.mScrollAnimGeneration + 1;
        this.mScrollAnimGeneration = r3;
    L6:
        final ImageView r6 = this.mCenteredDrawableView;
        if (r6 == null) goto L20;
        if (r2 == false) goto L12;
        Animator r5 = this.mScrollAnimator;
        if (r5 == null) goto L12;
        r5.cancel();
    L12:
        final float r8 = r14 - (r6.getWidth() / 2.0f);
        final float r9 = r15 - (r6.getHeight() / 2.0f);
        final float r10 = r16 - (r6.getWidth() / 2.0f);
        final float r11 = r17 - (r6.getHeight() / 2.0f);
        r6.setImageDrawable(r20);
        r6.setAlpha(1.0f);
        if (r2 == false) goto L15;
        r6.setScaleX(1.0f);
        r6.setScaleY(1.0f);
    L15:
        r6.setVisibility(0);
        ValueAnimator r1 = ObjectAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.addUpdateListener(new $$Lambda$FeedbackFloatingView$AiagaMn4siNvS63NYeLIEek1RBM(r6, r8, r10, r9, r11));
        r1.setDuration(r18);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new AccelerateDecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r1.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new FeedbackFloatingView$showScrollPath$1$1$2(r2, this, r3), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        if (r2 == false) goto L18;
        this.mScrollAnimator = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.aiagent.plugin");
    L18:
        r1.start();
        return;
    L20:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    private static final void showScrollPath$lambda$7$lambda$6$lambda$5(ImageView r2, float r3, float r4, float r5, float r6, ValueAnimator r7) {
        o.e(r7, "it");
        Object r8 = r7.getAnimatedValue();
        o.a(r8, "null cannot be cast to non-null type kotlin.Float");
        float r9 = ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.setX(r3 + ((r4 - r3) * r9));
        r2.setY(r5 + ((r6 - r5) * r9));
    }

    public final void dimCenteredDrawable() {
        ImageView r1 = this.mCenteredDrawableView;
        if (r1 == null) goto L6;
        r1.setAlpha(0.5f);
        return;
    }

    public final void hideCenteredDrawable() {
        ImageView r1 = this.mCenteredDrawableView;
        if (r1 == null) goto L6;
        r1.setVisibility(8);
        return;
    }
}

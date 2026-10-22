package com.bytedance.android.ui.ec.widget.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "isAnimating", "", "()Z", "onAttachedToWindow", "", "onDetachedFromWindow", "setVisibility", RemoteMessageConst.Notification.VISIBILITY, "startAnimate", "stopAnimate", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECDuxLoadingAnimationView extends FrameLayout {
    private static final int ANIMATION_HEIGHT = 32;
    private static final int ANIMATION_WIDTH = 32;
    public static final Companion Companion = null;
    private static final String LOTTIE_RES_NAME = "ec_dux_new_double_color_ball_animation.json";
    private final LottieAnimationView animationView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView$Companion;", "", "()V", "ANIMATION_HEIGHT", "", "ANIMATION_WIDTH", "LOTTIE_RES_NAME", "", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ECDuxLoadingAnimationView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public ECDuxLoadingAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    public final boolean isAnimating() {
        return this.animationView.isAnimating();
    }

    public final void startAnimate() {
        if (this.animationView.isAnimating() == true) goto L6;
        this.animationView.playAnimation();
        return;
    }

    public final void stopAnimate() {
        if (this.animationView.isAnimating() == false) goto L6;
        this.animationView.cancelAnimation();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
    L11:
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L15;
        r100.width = UnitExtensionKt.dp2px(32);
        r100.height = UnitExtensionKt.dp2px(32);
        setLayoutParams(r100);
    L15:
        if (isShown() == false) goto L18;
        startAnimate();
        return;
    L18:
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L11;
        ViewParent r101 = getParent();
        if (r101 == null) goto L10;
        ((ViewGroup) r101).setClipChildren(false);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimate();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        startAnimate();
        return;
    L5:
        stopAnimate();
    }

    public ECDuxLoadingAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LottieAnimationView r103 = new LottieAnimationView(r100);
        this.animationView = r103;
        r103.setAnimation(LOTTIE_RES_NAME);
        r103.setRepeatCount(-1);
        r103.playAnimation();
        addView(r103);
    }

    public /* synthetic */ ECDuxLoadingAnimationView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}

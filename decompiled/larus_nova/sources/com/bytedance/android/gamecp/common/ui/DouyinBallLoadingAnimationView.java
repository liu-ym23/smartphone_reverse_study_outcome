package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/ui/DouyinBallLoadingAnimationView;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DouyinBallLoadingAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieAnimationView f56899a;

    public static final class a {
    }

    static {
    }

    public DouyinBallLoadingAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DouyinBallLoadingAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f56899a.isAnimating() == true) goto L6;
        this.f56899a.playAnimation();
        return;
    }

    public final void b() {
        if (this.f56899a.isAnimating() == false) goto L6;
        this.f56899a.cancelAnimation();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
    L11:
        ViewGroup.LayoutParams r100 = getLayoutParams();
        if (r100 == null) goto L15;
        r100.width = ToolUtils.dp2px(getContext(), 32.0f);
        r100.height = ToolUtils.dp2px(getContext(), 32.0f);
        setLayoutParams(r100);
    L15:
        if (isShown() == false) goto L18;
        a();
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
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        a();
        return;
    L5:
        b();
    }

    public DouyinBallLoadingAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LottieAnimationView r103 = new LottieAnimationView(r100);
        this.f56899a = r103;
        r103.setAnimation("ec_dux_new_double_color_ball_animation.json");
        r103.setRepeatCount(-1);
        r103.playAnimation();
        addView(r103);
    }

    public /* synthetic */ DouyinBallLoadingAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

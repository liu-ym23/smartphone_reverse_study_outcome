package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/slice/widgets/CartCircleLoadingView;", "Landroid/widget/FrameLayout;", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartCircleLoadingView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RotateAnimation f179195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f179196b;

    public CartCircleLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CartCircleLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f179195a.cancel();
        this.f179196b = false;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 == 0) goto L5;
        this.f179195a.cancel();
        this.f179196b = false;
        return;
    L5:
        if (this.f179196b == true) goto L11;
        this.f179196b = true;
        this.f179195a.start();
        return;
    }

    public CartCircleLoadingView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        ImageView r102 = new ImageView(r100);
        r102.setAnimation(AnimationUtils.loadAnimation(r100, R.anim.sku_anim_loading_rotate));
        r102.setImageResource(R.drawable.sku_icon_circle_white_loading);
        r102.setBackgroundColor(0);
        RotateAnimation r103 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.f179195a = r103;
        r103.setRepeatCount(-1);
        r103.setDuration(1000);
        r103.setInterpolator(new LinearInterpolator());
        r102.setAnimation(r103);
        removeAllViews();
        addView(r102, new FrameLayout.LayoutParams(-1, -1));
        if (this.f179196b == true) goto L7;
        this.f179196b = true;
        r103.start();
        return;
    }

    public /* synthetic */ CartCircleLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

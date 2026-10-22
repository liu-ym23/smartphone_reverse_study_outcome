package com.bytedance.android.shopping.skubuy.platform.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.ec.core.widget.DoubleColorBallAnimationView;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformLoadingView;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformLoadingView extends RoundConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoubleColorBallAnimationView f183193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlatformBodySkeletonView f183194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PlatformFooterSkeletonView f183195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f183196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f183197e;

    public PlatformLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PlatformLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator r100 = this.f183197e;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f183197e = null;
    }

    public PlatformLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.platform_loading_view, this, true);
        this.f183193a = (DoubleColorBallAnimationView) findViewById(R.id.loading_view_ball);
        this.f183194b = (PlatformBodySkeletonView) findViewById(R.id.skeleton_view);
        this.f183195c = (PlatformFooterSkeletonView) findViewById(R.id.footer_skeleton_view);
        this.f183196d = findViewById(R.id.sku_skeleton_loading_moving_anime);
    }

    public /* synthetic */ PlatformLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

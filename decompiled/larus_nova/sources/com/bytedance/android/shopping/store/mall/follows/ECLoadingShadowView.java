package com.bytedance.android.shopping.store.mall.follows;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import hj3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/ECLoadingShadowView;", "Landroid/widget/FrameLayout;", "Landroid/util/AttributeSet;", "b", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLoadingShadowView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObjectAnimator f185523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AttributeSet f185524b;

    public ECLoadingShadowView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECLoadingShadowView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.f185524b;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        super.onVisibilityChanged(r100, r101);
        if (r101 != 0) goto L5;
        View r102 = findViewById(R.id.shadow_view);
        r102.post(new a(this, r102));
        return;
    L5:
        ObjectAnimator r103 = this.f185523a;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isRunning() != true) goto L15;
        ObjectAnimator r104 = this.f185523a;
        if (r104 == null) goto L16;
        r104.cancel();
        return;
    L16:
        return;
    }

    public ECLoadingShadowView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f185524b = r101;
        LayoutInflater.from(getContext()).inflate(R.layout.ec_shop_layout_loading_shadow, this);
    }

    public /* synthetic */ ECLoadingShadowView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

package com.bytedance.android.ec.store.window;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import com.bytedance.android.ec.hybrid.list.view.ECPredictHeightLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/store/window/ECShopHybridRoundedLinearLayout;", "Lcom/bytedance/android/ec/hybrid/list/view/ECPredictHeightLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECShopHybridRoundedLinearLayout extends ECPredictHeightLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f48998b;

    public ECShopHybridRoundedLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECShopHybridRoundedLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = (this.f48998b > 0.0f ? 1 : (this.f48998b == 0.0f ? 0 : -1));
        super.dispatchDraw(r100);
    }

    public final void setRadius(float r100) {
        this.f48998b = r100;
        if (r100 <= 0) goto L11;
        ViewOutlineProvider r101 = getOutlineProvider();
        if ((r101 instanceof com.bytedance.android.ec.store.widget.a) == true) goto L7;
        r101 = null;
    L7:
        com.bytedance.android.ec.store.widget.a r102 = (com.bytedance.android.ec.store.widget.a) r101;
        if (r102 == null) goto L12;
        r102.f48992a = r100;
        return;
    L12:
        return;
    }

    public ECShopHybridRoundedLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECShopHybridRoundedLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = this.f48998b;
        int r105 = (r104 > 0.0f ? 1 : (r104 == 0.0f ? 0 : -1));
        if (r104 <= 0) goto L6;
        setClipToOutline(true);
        setOutlineProvider(new com.bytedance.android.ec.store.widget.a(this.f48998b, r100, r101));
        return;
    }
}

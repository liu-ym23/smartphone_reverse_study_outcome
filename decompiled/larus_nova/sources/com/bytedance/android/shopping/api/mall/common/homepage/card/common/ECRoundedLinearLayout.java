package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import com.bytedance.android.ec.hybrid.list.view.ECPredictHeightLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedLinearLayout;", "Lcom/bytedance/android/ec/hybrid/list/view/ECPredictHeightLayout;", "", "radius", "", "setRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECRoundedLinearLayout extends ECPredictHeightLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f170301b;

    public ECRoundedLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECRoundedLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        int r101 = (this.f170301b > 0.0f ? 1 : (this.f170301b == 0.0f ? 0 : -1));
        super.dispatchDraw(r100);
    }

    public final void setRadius(float r100) {
        this.f170301b = r100;
        if (r100 <= 0) goto L11;
        ViewOutlineProvider r101 = getOutlineProvider();
        if ((r101 instanceof d) == true) goto L7;
        r101 = null;
    L7:
        d r102 = (d) r101;
        if (r102 == null) goto L12;
        r102.f170307a = r100;
        return;
    L12:
        return;
    }

    public ECRoundedLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.left_rounded_radius, R.attr.rounded_radius}, r102, 0);
        if (r103.hasValue(1) == false) goto L5;
        this.f170301b = r103.getDimensionPixelOffset(1, 0);
    L5:
        r103.recycle();
    }

    public /* synthetic */ ECRoundedLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = this.f170301b;
        int r105 = (r104 > 0.0f ? 1 : (r104 == 0.0f ? 0 : -1));
        if (r104 <= 0) goto L6;
        setClipToOutline(true);
        setOutlineProvider(new d(this.f170301b, r100, r101));
        return;
    }
}

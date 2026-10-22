package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.shopping.store.tabkit.DeviceUtil;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/PadAdapterFrameLayout;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getEnablePadAdapter", "()Z", "setEnablePadAdapter", "(Z)V", "enablePadAdapter", "", "b", FaceService.girlLabel, "getRatio", "()F", "setRatio", "(F)V", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "get_enablePadAdapter", "_enablePadAdapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PadAdapterFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f186873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f186874b;

    public PadAdapterFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PadAdapterFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final boolean get_enablePadAdapter() {
        if (((Boolean) DeviceUtil.f186451a.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f186873a == false) goto L7;
        return true;
    }

    public final boolean getEnablePadAdapter() {
        return this.f186873a;
    }

    public final float getRatio() {
        return this.f186874b;
    }

    public final void setEnablePadAdapter(boolean r100) {
        this.f186873a = r100;
    }

    public final void setRatio(float r100) {
        this.f186874b = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (get_enablePadAdapter() == false) goto L9;
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        float r104 = r103;
        float r105 = r102 / r104;
        float r106 = this.f186874b;
        if (r105 <= r106) goto L7;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) (r104 * r106), View.MeasureSpec.getMode(r100)), r101);
    L8:
        setMeasuredDimension(r102, r103);
        return;
    L7:
        super.onMeasure(r100, r101);
        goto L8
    L9:
        super.onMeasure(r100, r101);
    }

    public PadAdapterFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f186873a = true;
        this.f186874b = 0.47368422f;
        setBackgroundColor(-1);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if ((r102 instanceof FrameLayout.LayoutParams) == true) goto L5;
        ViewGroup.LayoutParams r103 = null;
    L6:
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        if (r104 == null) goto L9;
        r104.gravity = 17;
    L9:
        super.addView(r100, r101, r102);
        return;
    L5:
        r103 = r102;
        goto L6
    }

    public /* synthetic */ PadAdapterFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/LengthenedCompatDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "setHeightRatio", "getHeightRatio", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LengthenedCompatDraweeView extends SimpleDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f168508a;

    public LengthenedCompatDraweeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LengthenedCompatDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final float getHeightRatio() {
        return this.f168508a;
    }

    public final void setHeightRatio(float r100) {
        this.f168508a = r100;
        requestLayout();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(r100) * this.f168508a), View.MeasureSpec.getMode(r100)));
    }

    public LengthenedCompatDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f168508a = 1.0f;
    }

    public /* synthetic */ LengthenedCompatDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

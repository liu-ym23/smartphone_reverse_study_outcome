package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ECStructViewPlanB;", "Lcom/bytedance/android/window/shop/widget/ECStructView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStructViewPlanB extends ECStructView {
    @Override // com.bytedance.android.window.shop.widget.ECStructView
    public final ECStructView.StructType[][] a() {
        ECStructView.StructType r100 = ECStructView.StructType.A;
        ECStructView.StructType r101 = ECStructView.StructType.C;
        ECStructView.StructType r102 = ECStructView.StructType.B;
        return new ECStructView.StructType[][]{new ECStructView.StructType[]{r100, r101, r100, r101}, new ECStructView.StructType[]{r102, r100, r102, r100}};
    }

    public ECStructViewPlanB(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}

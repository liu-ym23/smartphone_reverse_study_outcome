package com.bytedance.android.shopping.mall.homepage.card.common;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoViewForVideo;", "Lcom/bytedance/android/shopping/mall/homepage/card/common/BottomInfoView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomInfoViewForVideo extends BottomInfoView {
    @Override // com.bytedance.android.shopping.mall.homepage.card.common.BottomInfoView
    public final void R5() {
        Lazy r100 = HybridAppInfoService.f47530a;
        if (HybridAppInfoService.i() == false) goto L5;
        getNameView().setTextColor(ColorProtector.parseColor("#333333"));
        return;
    L5:
        getNameView().setTextColor(ColorProtector.parseColor("#3E3E3E"));
    }

    public BottomInfoViewForVideo(Context r100) {
        super(r100);
    }

    public BottomInfoViewForVideo(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public BottomInfoViewForVideo(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}

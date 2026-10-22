package com.bytedance.android.shopping.mall.homepage.card.headercard.channel;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/ChannelLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelLayoutManager extends GridLayoutManager {

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return false;
    }

    public ChannelLayoutManager(final ChannelAdapter r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, 4);
        setSpanSizeLookup(new AnonymousClass1(r100));
        GridLayoutManager.SpanSizeLookup r102 = getSpanSizeLookup();
        if (r102 == null) goto L6;
        r102.setSpanIndexCacheEnabled(true);
        return;
    }
}

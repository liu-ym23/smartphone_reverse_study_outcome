package com.bytedance.android.live.revlink.impl.pk.dialog.vm;

import com.bytedance.android.livesdk.link.model.IGroupRivals;
import com.bytedance.android.livesdk.link.model.IPkSubTabKey;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final int a(IPkSubTabKey r100) {
        if (r100 != null) goto L4;
    L5:
        if (r100 != null) goto L7;
    L9:
        if (r100 != null) goto L11;
    L13:
        IRivalRankRecommendResponse.LoadType r101 = IRivalRankRecommendResponse.LoadType.OnlyRecommendRivals;
    L15:
        return r101.ordinal();
    L11:
        if (r100.getGroupRivalsType() != IGroupRivals.GroupType.GroupFeedFollowed.ordinal()) goto L13;
        r101 = IRivalRankRecommendResponse.LoadType.OnlyFollowRivals;
        goto L15
    L7:
        if (r100.getType() != IPkSubTabKey.TabType.CommonPanel.ordinal()) goto L9;
    L16:
        return IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal();
    L4:
        if (r100.getType() == IPkSubTabKey.TabType.FlexActivity.ordinal()) goto L16;
        goto L5
    }
}

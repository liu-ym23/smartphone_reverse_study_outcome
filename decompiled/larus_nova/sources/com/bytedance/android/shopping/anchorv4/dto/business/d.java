package com.bytedance.android.shopping.anchorv4.dto.business;

import com.bytedance.android.shopping.anchorv4.data.FindSameSource;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public interface d {
    List<PicSearchGoodsData> getBusinessDataStruct();

    List<SameGoodsItem> getFeedStruct();

    FindSameSource getSourceType();

    Integer getStatusCodeInt();
}

package com.bytedance.android.livesdkapi.depend.live;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import java.util.List;
import zo2.a;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.gift.GiftServiceWrapper")
public interface ILiveGiftService extends IService {
    List<a> getGiftNitaViewList();

    List<a> getGiftPanelNitaViewList();

    void initGiftResourceManager(Context r100);

    void syncAssetsList(String r100, int r101);

    void syncGiftList();
}

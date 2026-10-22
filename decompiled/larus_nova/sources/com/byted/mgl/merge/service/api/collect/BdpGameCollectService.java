package com.byted.mgl.merge.service.api.collect;

import android.app.Activity;
import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpGameCollectService extends IBdpService {
    BdpGameCollectShowInfo getBdpCollectShowInfo(Context r100, boolean r101);

    boolean handleCollectResult(boolean r100, boolean r101, String r102, boolean r103, Activity r104, String r105, String r106, String r107, String r108, JSONObject r110);
}

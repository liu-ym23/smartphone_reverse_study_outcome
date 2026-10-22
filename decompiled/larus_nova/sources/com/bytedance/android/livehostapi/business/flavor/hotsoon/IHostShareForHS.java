package com.bytedance.android.livehostapi.business.flavor.hotsoon;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostShareForHS extends IService, IBaseHostShare {
    void getShortUrl(String r100, IHostShare.ValueCallback r101);

    JSONObject getTcActivitySettings();

    boolean isShareAvailable(String r100, Activity r101);

    void promotion(Activity r100, ShareParams r101);

    void share(Activity r100, ShareParams r101, IShareCallback r102);

    void shareActivity(Context r100, Map<String, Object> r101, IShareCallback r102);

    void showReportDialog(Activity r100, ShareParams r101, String r102);

    void showShareDialog(Activity r100, ShareParams r101, IShareCallback r102);
}

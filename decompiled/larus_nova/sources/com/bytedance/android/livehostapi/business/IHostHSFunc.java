package com.bytedance.android.livehostapi.business;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostHSFunc;
import com.bytedance.android.livehostapi.business.depend.ad.IAdConvertWidgetUpdateListener;
import com.bytedance.android.livehostapi.business.depend.ad.IAdVideoView;
import com.bytedance.android.livehostapi.business.depend.ad.IAdViewTrackService;
import com.bytedance.android.livesdkapi.depend.model.live.HotsoonAd;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostHSFunc extends IService, IBaseHostHSFunc {
    void adLog(Context r100, String r101, long r102, String r103, JSONObject r104, boolean r105);

    void adLog(Context r100, String r101, String r102, long r103, long r104, JSONObject r105);

    String anchorSchema();

    boolean anchorSwitch();

    String audienceSchema();

    boolean audienceSwitch();

    void bindHost(Context r100, JSONObject r101, Object... r102);

    IAdVideoView createAdVideoView(Context r100, JSONObject r101);

    String createRoomSchema();

    boolean createRoomSwitch();

    void onAdActionCLick(Context r100, JSONObject r101, int r102, Object... r103);

    void onClickEvent(Context r100, JSONObject r101, String r102, String r103, boolean r104);

    void onDislikeAd(Context r100, JSONObject r101, List<HotsoonAd.FilterWord> r102);

    void openDownloadWebView(String r100, Bundle r101, Context r102);

    boolean openSchema(Context r100, String r101);

    IAdViewTrackService provideViewTrackService();

    void sendAdStats(Context r100, List<String> r101, boolean r102, Object... r103);

    void tryBindDownloadManager(Context r100, int r101, IAdConvertWidgetUpdateListener r102, JSONObject r103);

    void tryUnBindDowloadManager(Context r100, int r101, JSONObject r102);

    void unBindHost(Context r100, JSONObject r101);
}

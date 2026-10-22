package com.bytedance.android.livehostapi.business.depend.gamecenter;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J&\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J&\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J0\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J&\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J&\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecenter/IHostGameCenterService;", "", "action", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "params", "Lorg/json/JSONObject;", "extra", "cancelDownload", "getDownloadList", "listener", "Lcom/bytedance/android/livehostapi/business/depend/gamecenter/IDownloadListListener;", "orderGame", "subscribe", "iDownloadListener", "Lcom/bytedance/android/livehostapi/business/depend/gamecenter/IDownloadStateChangeListener;", "unSubscribe", "updateDownloadConfig", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostGameCenterService {
    void action(Context r100, JSONObject r101, JSONObject r102);

    void cancelDownload(Context r100, JSONObject r101, JSONObject r102);

    void getDownloadList(Context r100, JSONObject r101, IDownloadListListener r102);

    void orderGame(Context r100, JSONObject r101);

    void subscribe(Context r100, JSONObject r101, JSONObject r102, IDownloadStateChangeListener r103);

    void unSubscribe(Context r100, JSONObject r101, JSONObject r102);

    void updateDownloadConfig(Context r100, JSONObject r101, JSONObject r102);
}

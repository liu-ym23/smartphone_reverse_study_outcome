package com.bytedance.android.ec.host.api.download;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import org.json.JSONObject;
import qi.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J \u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/host/api/download/IECDownloadAppService;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lorg/json/JSONObject;", "param", "Lqi/a;", "listener", "", "downloadApp", "cancelDownloadApp", "subscribeApp", "unsubscribeApp", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECDownloadAppService {
    void cancelDownloadApp(Context r100, JSONObject r101, a r102);

    void downloadApp(Context r100, JSONObject r101, a r102);

    void subscribeApp(Context r100, JSONObject r101, a r102);

    void unsubscribeApp(Context r100, JSONObject r101, a r102);
}

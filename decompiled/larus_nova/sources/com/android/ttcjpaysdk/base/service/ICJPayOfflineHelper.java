package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\u0005H&J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000f\u001a\u00020\u0005H&J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayOfflineHelper;", "", "checkCJGeckoUseful", "", "channel", "", "checkLiveChannelUseful", "forceUpdateChannel", "", "updateConfig", "Lcom/android/ttcjpaysdk/base/service/IUpdateConfig;", "getAK", "getChannel", "url", "getChannelVersion", "getOfflineDir", "shouldInterceptRequestByUrl", "Landroid/webkit/WebResourceResponse;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayOfflineHelper {
    boolean checkCJGeckoUseful(String r100);

    boolean checkLiveChannelUseful(String r100);

    void forceUpdateChannel(IUpdateConfig r100);

    String getAK();

    String getChannel(String r100);

    String getChannelVersion(String r100);

    String getOfflineDir();

    WebResourceResponse shouldInterceptRequestByUrl(String r100, Context r101);
}

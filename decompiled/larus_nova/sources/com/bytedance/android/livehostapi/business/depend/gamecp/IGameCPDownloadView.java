package com.bytedance.android.livehostapi.business.depend.gamecp;

import android.content.Context;
import android.view.View;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002\u0018\u0019J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H&J\b\u0010\u0007\u001a\u00020\bH&J:\u0010\t\u001a\u00020\b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J:\u0010\u0010\u001a\u00020\b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J0\u0010\u0011\u001a\u00020\b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rH&J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J0\u0010\u0015\u001a\u00020\b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rH&J0\u0010\u0016\u001a\u00020\b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rH&J0\u0010\u0017\u001a\u00020\b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rH&¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView;", "", "createView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "lynxContext", MapMonitorConst.EVENT_DESTROY, "", "getCurrentDownloadState", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callback", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView$Callback;", "performDownloadAction", "setDownloadInfo", "setDownloadStateListener", "listener", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView$DownloadStateListener;", "setDownloadText", "setDownloadUIStyle", "useCacheData", "Callback", "DownloadStateListener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameCPDownloadView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView$Callback;", "", "callback", "", "status", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface Callback {
        void callback(int r100, HashMap<String, Object> r101);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView$DownloadStateListener;", "", "onEvent", "", "params", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface DownloadStateListener {
        void onEvent(HashMap<String, Object> r100);
    }

    View createView(Context r100, Object r101);

    void destroy();

    void getCurrentDownloadState(HashMap<String, Object> r100, Callback r101);

    void performDownloadAction(HashMap<String, Object> r100, Callback r101);

    void setDownloadInfo(HashMap<String, Object> r100);

    void setDownloadStateListener(DownloadStateListener r100);

    void setDownloadText(HashMap<String, Object> r100);

    void setDownloadUIStyle(HashMap<String, Object> r100);

    void useCacheData(HashMap<String, Object> r100);
}

package com.bytedance.android.livesdkapi.depend.live.vs.listener;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/listener/IVsVideoListManager;", "", "getVSPageSourceLog", "", "", "onInterceptBackRoom", "", "onLeftSlideSafeArea", "", "tag", "location", "", "playNext", "isAutoPlay", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVsVideoListManager {
    Map<String, String> getVSPageSourceLog();

    boolean onInterceptBackRoom();

    void onLeftSlideSafeArea(String r100, int[] r101);

    void playNext(boolean r100);
}

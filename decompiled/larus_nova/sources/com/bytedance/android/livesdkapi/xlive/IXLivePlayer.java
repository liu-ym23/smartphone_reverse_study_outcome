package com.bytedance.android.livesdkapi.xlive;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/xlive/IXLivePlayer;", "", "createLivePlayerView", "Lcom/bytedance/android/livesdkapi/xlive/IXLivePlayerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enable", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IXLivePlayer {
    IXLivePlayerView createLivePlayerView(Context r100);

    boolean enable();
}

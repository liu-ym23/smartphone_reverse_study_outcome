package com.bytedance.android.live.platformplayer.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@ServiceLookup("com.bytedance.android.live.platformplayer.LivePlayViewProvider")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/platformplayer/api/ILivePlayViewProvider;", "Lcom/bytedance/android/live/base/IService;", "getInteractPlayView", "Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "platform-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayViewProvider extends IService {
    IInteractPlayView getInteractPlayView(Context r100);
}

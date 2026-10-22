package com.bytedance.android.livehostapi.foundation.player;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/player/IHostLivePlayerOptions;", "Lcom/bytedance/android/live/base/IService;", "getPlayerResolution", "", "streamData", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "defaultResolution", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostLivePlayerOptions extends IService {
    String getPlayerResolution(String r100, StreamUrl r101, String r102);
}

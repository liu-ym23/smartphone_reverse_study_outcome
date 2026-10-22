package com.media.cache.listener;

import com.media.cache.model.VideoCacheInfo;
import q9.a;

/* JADX INFO: loaded from: classes3.dex */
public interface IVideoInfoCallback {
    void onBaseVideoInfoFailed(Throwable r10);

    void onBaseVideoInfoSuccess(VideoCacheInfo r10);

    void onFinalUrl(String r10);

    void onLiveM3U8Callback(VideoCacheInfo r10);

    void onM3U8InfoFailed(Throwable r10);

    void onM3U8InfoSuccess(VideoCacheInfo r10, a r11);
}

package com.media.cache.listener;

import com.media.cache.model.VideoCacheInfo;
import q9.a;

/* JADX INFO: loaded from: classes3.dex */
public interface IVideoInfoParseCallback {
    void onM3U8FileParseFailed(VideoCacheInfo r10, Throwable r11);

    void onM3U8FileParseSuccess(VideoCacheInfo r10, a r11);
}

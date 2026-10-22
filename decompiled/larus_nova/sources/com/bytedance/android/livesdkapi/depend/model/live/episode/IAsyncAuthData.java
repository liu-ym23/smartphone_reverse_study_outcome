package com.bytedance.android.livesdkapi.depend.model.live.episode;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IAsyncAuthData;", "", "getAsyncAuthAB", "", "getKeepAliveTime", "getNeedRefreshStream", "getTempWatchBuffer", "setKeepAliveTime", "", "keepALiveTime", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAsyncAuthData {
    long getAsyncAuthAB();

    long getKeepAliveTime();

    long getNeedRefreshStream();

    long getTempWatchBuffer();

    void setKeepAliveTime(long r100);
}

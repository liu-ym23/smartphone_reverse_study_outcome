package com.bytedance.android.livesdkapi.depend.model.live.pay;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IAsyncAuthData;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
public class AsyncAuthData implements IAsyncAuthData {
    public static final long NEED_REFRESH_STREAM = 1;
    public static final long NO_NEED_REFRESH_STREAM = 0;

    @SerializedName("async_authentication_ab_type")
    public long asyncAuthAB;

    @SerializedName("keep_alive_time_stamp")
    public long keepAliveTime;

    @SerializedName("async_authentication_operate")
    public long needRefreshStream;

    @SerializedName("buffer")
    public long tempWatchBuffer;

    public AsyncAuthData() {
    }

    public String toString() {
        return "AsyncAuthData{keepAliveTime=" + this.keepAliveTime + ", needRefreshStream=" + this.needRefreshStream + ", asyncAuthAB=" + this.asyncAuthAB + ", tempWatchBuffer=" + this.tempWatchBuffer + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IAsyncAuthData
    public long getAsyncAuthAB() {
        return this.asyncAuthAB;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IAsyncAuthData
    public long getKeepAliveTime() {
        return this.keepAliveTime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IAsyncAuthData
    public long getNeedRefreshStream() {
        return this.needRefreshStream;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IAsyncAuthData
    public long getTempWatchBuffer() {
        return this.tempWatchBuffer;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IAsyncAuthData
    public void setKeepAliveTime(long r100) {
        this.keepAliveTime = r100;
    }
}

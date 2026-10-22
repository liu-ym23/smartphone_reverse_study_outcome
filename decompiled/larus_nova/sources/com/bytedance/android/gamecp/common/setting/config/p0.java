package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/p0;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "detailWatchLimit", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setDetailWatchLimit", "(J)V", "liveSingleWatchLimit", "c", "setLiveSingleWatchLimit", "videoSingleWatchLimit", "d", "setVideoSingleWatchLimit", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p0 {

    @SerializedName("detail_watch_limit")
    private long detailWatchLimit;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("live_single_watch_limit")
    private long liveSingleWatchLimit;

    @SerializedName("video_single_watch_limit")
    private long videoSingleWatchLimit;

    public p0() {
        this.enable = true;
        this.detailWatchLimit = 3;
        this.liveSingleWatchLimit = 3;
        this.videoSingleWatchLimit = 3;
    }

    public final long a() {
        return this.detailWatchLimit;
    }

    public final boolean b() {
        return this.enable;
    }

    public final long c() {
        return this.liveSingleWatchLimit;
    }

    public final long d() {
        return this.videoSingleWatchLimit;
    }
}

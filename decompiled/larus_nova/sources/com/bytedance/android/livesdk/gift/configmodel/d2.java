package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/d2;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", VideoThumbInfo.KEY_INTERVAL, "J", "getInterval", "()J", "setInterval", "(J)V", "", "preloadMaxCount", "I", "getPreloadMaxCount", "()I", "setPreloadMaxCount", "(I)V", "syncMaxCount", "getSyncMaxCount", "setSyncMaxCount", "assetDownloadEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAssetDownloadEnable", "downloadInterval", "getDownloadInterval", "setDownloadInterval", "touchDefaultSelectEnable", "c", "setTouchDefaultSelectEnable", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d2 {

    @SerializedName("asset_download_enable")
    private boolean assetDownloadEnable;

    @SerializedName("download_interval")
    private long downloadInterval;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private long interval;

    @SerializedName("max_preload")
    private int preloadMaxCount;

    @SerializedName("sync_max_count")
    private int syncMaxCount;

    @SerializedName("default_select_enable")
    private boolean touchDefaultSelectEnable;

    public d2() {
        this.interval = 30000;
        this.preloadMaxCount = 30;
        this.syncMaxCount = 500;
        this.downloadInterval = 300;
    }

    public final boolean a() {
        return this.assetDownloadEnable;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.touchDefaultSelectEnable;
    }
}

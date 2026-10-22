package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\"\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/o1;", "", "", "rateLimit", "J", "b", "()J", "setRateLimit", "(J)V", "", "jumpToDetail", "Z", "getJumpToDetail", "()Z", "setJumpToDetail", "(Z)V", "", "channelOverride", "I", "getChannelOverride", "()I", "setChannelOverride", "(I)V", "installFailCheckMd5", "getInstallFailCheckMd5", "setInstallFailCheckMd5", "subscribeNew", "getSubscribeNew", "setSubscribeNew", "useGameCpDownloader", "getUseGameCpDownloader", "setUseGameCpDownloader", "downloadStartMonitorEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDownloadStartMonitorEnable", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o1 {

    @SerializedName("game_promote_channel_overrite")
    private int channelOverride;

    @SerializedName("download_start_spend_time_enable")
    private boolean downloadStartMonitorEnable;

    @SerializedName(DownloadSettingKeys.KEY_INSTALL_FAILED_CHECK_TTMD5)
    private int installFailCheckMd5;

    @SerializedName("game_promote_download_btn_jump_detail")
    private boolean jumpToDetail;

    @SerializedName("game_promote_download_rate_limit")
    private long rateLimit;

    @SerializedName("game_promote_download_subscribe_new")
    private boolean subscribeNew;

    @SerializedName("game_promote_download_use_gamecp_downloader")
    private boolean useGameCpDownloader;

    public o1() {
        this.rateLimit = -1;
        this.channelOverride = 1;
        this.subscribeNew = true;
        this.useGameCpDownloader = true;
        this.downloadStartMonitorEnable = true;
    }

    public final boolean a() {
        return this.downloadStartMonitorEnable;
    }

    public final long b() {
        return this.rateLimit;
    }
}

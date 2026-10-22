package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/a2;", "", "", "urgentDownloadTTNet", "Z", "e", "()Z", "setUrgentDownloadTTNet", "(Z)V", "downloadNowSelect", "c", "setDownloadNowSelect", "downloadNowBuff", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDownloadNowBuff", "downloadForce", "getDownloadForce", "setDownloadForce", "logOpt", "d", "setLogOpt", "isFastDownload", "f", "setFastDownload", "downloadNowMsgReceive", "b", "setDownloadNowMsgReceive", "isDownloadFinishSwitchThread", "setDownloadFinishSwitchThread", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a2 {

    @SerializedName("download_force")
    private boolean downloadForce;

    @SerializedName("download_now_buff")
    private boolean downloadNowBuff;

    @SerializedName("download_now_msg_receive")
    private boolean downloadNowMsgReceive;

    @SerializedName("download_now_select")
    private boolean downloadNowSelect;

    @SerializedName("is_download_finish_switch_thread")
    private boolean isDownloadFinishSwitchThread;

    @SerializedName("is_fast_download")
    private boolean isFastDownload;

    @SerializedName("log_opt")
    private boolean logOpt;

    @SerializedName("download_cdn")
    private boolean urgentDownloadTTNet;

    public a2() {
    }

    public final boolean a() {
        return this.downloadNowBuff;
    }

    public final boolean b() {
        return this.downloadNowMsgReceive;
    }

    public final boolean c() {
        return this.downloadNowSelect;
    }

    public final boolean d() {
        return this.logOpt;
    }

    public final boolean e() {
        return this.urgentDownloadTTNet;
    }

    public final boolean f() {
        return this.isFastDownload;
    }
}

package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/b1;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "maxCount", "I", "b", "()I", "setMaxCount", "(I)V", "preLiveCount", "c", "setPreLiveCount", "", "duration", "J", "getDuration", "()J", "setDuration", "(J)V", "", "prefix", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "suffix", "e", "setSuffix", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b1 {

    @SerializedName("duration")
    private long duration;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT)
    private int maxCount;

    @SerializedName("per_live_count")
    private int preLiveCount;

    @SerializedName("prefix")
    private String prefix;

    @SerializedName("suffix")
    private String suffix;

    public b1() {
        this.maxCount = 3;
        this.preLiveCount = 1;
        this.duration = 3000;
        this.prefix = "不想收到";
        this.suffix = "礼物? ";
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.maxCount;
    }

    public final int c() {
        return this.preLiveCount;
    }

    public final String d() {
        return this.prefix;
    }

    public final String e() {
        return this.suffix;
    }
}

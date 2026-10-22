package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/j21;", "", "", "audienceRoomEnable", "Z", "b", "()Z", "setAudienceRoomEnable", "(Z)V", "optCrashRecoverRangeEnable", "c", "setOptCrashRecoverRangeEnable", "supportOtherCrashRecoverEnable", "d", "setSupportOtherCrashRecoverEnable", "", "allowRecoverLiveTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setAllowRecoverLiveTime", "(J)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j21 {

    @SerializedName("allow_recover_live_time")
    private long allowRecoverLiveTime;

    @SerializedName("audience_room_enable")
    private boolean audienceRoomEnable;

    @SerializedName("opt_crash_recover_range_enable")
    private boolean optCrashRecoverRangeEnable;

    @SerializedName("support_anr_recover_enable")
    private boolean supportOtherCrashRecoverEnable;

    public j21() {
        this.allowRecoverLiveTime = 60000;
    }

    public final long a() {
        return this.allowRecoverLiveTime;
    }

    public final boolean b() {
        return this.audienceRoomEnable;
    }

    public final boolean c() {
        return this.optCrashRecoverRangeEnable;
    }

    public final boolean d() {
        return this.supportOtherCrashRecoverEnable;
    }
}

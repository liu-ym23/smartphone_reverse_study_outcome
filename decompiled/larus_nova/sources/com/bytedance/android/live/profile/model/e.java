package com.bytedance.android.live.profile.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profile/model/e;", "", "", "playedTimes", "I", "b", "()I", "d", "(I)V", "", "lastPlayTimestamp", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "c", "(J)V", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("last_play_timestamp")
    private long lastPlayTimestamp;

    @SerializedName("played_times")
    private int playedTimes;

    public e() {
    }

    public final long a() {
        return this.lastPlayTimestamp;
    }

    public final int b() {
        return this.playedTimes;
    }

    public final void c(long r100) {
        this.lastPlayTimestamp = r100;
    }

    public final void d(int r100) {
        this.playedTimes = r100;
    }
}

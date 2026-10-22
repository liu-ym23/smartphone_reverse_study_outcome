package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/c1;", "", "", "cleanEnable", "Z", "b", "()Z", "setCleanEnable", "(Z)V", "", "cleanCount", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setCleanCount", "(I)V", "", "expireDuration", "J", "c", "()J", "setExpireDuration", "(J)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c1 {

    @SerializedName("clean_count")
    private int cleanCount;

    @SerializedName("clean_enable")
    private boolean cleanEnable;

    @SerializedName("expire_duration")
    private long expireDuration;

    public c1() {
        this.cleanCount = 50;
        this.expireDuration = 300;
    }

    public final int a() {
        return this.cleanCount;
    }

    public final boolean b() {
        return this.cleanEnable;
    }

    public final long c() {
        return this.expireDuration;
    }
}

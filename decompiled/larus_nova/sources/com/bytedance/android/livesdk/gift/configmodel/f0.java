package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/f0;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "", "durationMills", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setDurationMills", "(J)V", "", "scaleFloat", FaceService.girlLabel, "c", "()F", "setScaleFloat", "(F)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f0 {

    @SerializedName("duration_mills")
    private long durationMills;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("scale_float")
    private float scaleFloat;

    public f0() {
        this.durationMills = 400;
        this.scaleFloat = 1.14f;
    }

    public final long a() {
        return this.durationMills;
    }

    public final boolean b() {
        return this.enable;
    }

    public final float c() {
        return this.scaleFloat;
    }
}

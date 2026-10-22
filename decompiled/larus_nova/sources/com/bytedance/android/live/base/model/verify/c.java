package com.bytedance.android.live.base.model.verify;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class c {

    @SerializedName("cert_id")
    String certId;

    @SerializedName("certification_step")
    int certificationStep;

    @SerializedName("hotsoon_certification_status")
    int hotsoonCertificationStatus;

    @SerializedName("is_verified")
    public boolean isVerified;

    @SerializedName("real_name")
    String realName;

    @SerializedName("under_reviewing")
    boolean underReviewing;

    public c() {
    }

    public final int a() {
        return this.hotsoonCertificationStatus;
    }

    public final String b() {
        return this.realName;
    }

    public final boolean c() {
        return this.underReviewing;
    }
}

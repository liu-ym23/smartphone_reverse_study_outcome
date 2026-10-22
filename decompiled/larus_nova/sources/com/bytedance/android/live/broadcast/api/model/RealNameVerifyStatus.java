package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes45.dex */
public class RealNameVerifyStatus implements Serializable {
    public static final int STATUS_PHONE_3_ELEMENT_VERIFIED = 2;

    @SerializedName("is_verified")
    public boolean isVerified;

    @SerializedName("verify_status")
    public int verifyStatus;

    public RealNameVerifyStatus() {
    }
}

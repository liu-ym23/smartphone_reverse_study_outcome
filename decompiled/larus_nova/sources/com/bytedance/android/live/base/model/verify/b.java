package com.bytedance.android.live.base.model.verify;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class b extends c {

    @SerializedName("cert_status")
    int certStatus;

    @SerializedName("is_adult")
    boolean isAdult;

    @SerializedName("need_verify_type")
    int needVerifyType;

    @SerializedName("phone")
    String phone;

    @SerializedName("prompts_type")
    int promptsType;

    @SerializedName("use_manual_verify")
    boolean useManualVerify;

    @SerializedName("verify_status")
    int verify_status;

    public b() {
    }
}

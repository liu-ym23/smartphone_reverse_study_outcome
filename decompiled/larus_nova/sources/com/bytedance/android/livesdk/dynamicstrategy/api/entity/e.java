package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class e {

    @SerializedName("left")
    public a left;

    @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
    public String operator;

    @SerializedName("right")
    public a right;

    public e() {
    }
}

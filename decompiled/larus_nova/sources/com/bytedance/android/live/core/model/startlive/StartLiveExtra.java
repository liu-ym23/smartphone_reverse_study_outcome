package com.bytedance.android.live.core.model.startlive;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.livesdk.verify.VerifyErrorExtra;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class StartLiveExtra extends Extra {

    @SerializedName(VerifyErrorExtra.KEY_IS_PHONE_BIND)
    public boolean isPhoneBinded;

    @SerializedName(VerifyErrorExtra.KEY_LIVE_AGREEMENT)
    public boolean liveAgreement;

    @SerializedName(VerifyErrorExtra.KEY_LIVE_ANSWER)
    public boolean liveAnswer;

    @SerializedName(VerifyErrorExtra.KEY_REALNAME)
    public int realnameVerify;

    public StartLiveExtra() {
    }
}

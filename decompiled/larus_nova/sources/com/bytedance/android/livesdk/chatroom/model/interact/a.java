package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class a extends Extra {

    @SerializedName("link_mic_pay_hint")
    public String payHint;

    @SerializedName("pay_options")
    public List<n2> payPlans;

    public a() {
    }
}

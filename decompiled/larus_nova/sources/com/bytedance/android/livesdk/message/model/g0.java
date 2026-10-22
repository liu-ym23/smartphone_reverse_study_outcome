package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.message.Text;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class g0 {

    @SerializedName("display_text")
    public Text displayText;

    @SerializedName("display_user_role")
    public boolean displayUserRole;

    @SerializedName("user")
    public IBaseUser userInfo;

    public g0() {
    }
}

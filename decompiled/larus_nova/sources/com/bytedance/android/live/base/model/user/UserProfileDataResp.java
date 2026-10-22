package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class UserProfileDataResp {

    @SerializedName(BdpAppEventConstant.USER_PROFILE)
    public NewProfileUser profileUser;

    @SerializedName("user_data")
    public IBaseUser roomUser;

    public static class UserProfileExtra extends Extra {

        @SerializedName("anonymous_is_silence")
        public boolean anonymousIsSilence;

        @SerializedName("biz_extra")
        public Map<String, String> bizExtra;

        @SerializedName("mystery_detail_jump_schema")
        public String mysteryDetailJumpSchema;

        public UserProfileExtra() {
        }
    }

    public UserProfileDataResp() {
    }
}

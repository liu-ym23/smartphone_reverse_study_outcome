package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class UserExtra extends Extra {

    @SerializedName("anonymous_is_silence")
    public boolean anonymousIsSilence;

    @SerializedName("mystery_detail_jump_schema")
    public String mysteryDetailJumpSchema;

    public UserExtra() {
    }

    public String getMysteryDetailJumpSchema() {
        return this.mysteryDetailJumpSchema;
    }

    public long getNow() {
        return this.now;
    }

    public boolean isAnonymousIsSilence() {
        return this.anonymousIsSilence;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }
}

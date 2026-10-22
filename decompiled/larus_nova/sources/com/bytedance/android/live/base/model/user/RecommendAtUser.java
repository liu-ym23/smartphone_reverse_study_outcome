package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class RecommendAtUser implements Serializable {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    public long cursor;

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("recently_at_user_list")
    public List<User> recentlyAtUsers;

    @SerializedName("user_list")
    public List<User> users;

    public RecommendAtUser() {
    }
}

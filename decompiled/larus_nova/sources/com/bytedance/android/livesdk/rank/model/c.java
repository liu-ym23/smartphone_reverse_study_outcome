package com.bytedance.android.livesdk.rank.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class c {

    @SerializedName("currency")
    public String currency;

    @SerializedName("ranks")
    public List<a> ranks;

    @SerializedName("self_info")
    public a selfInfo;

    public class a {

        @SerializedName("gap_description")
        public String gapDescription;

        @SerializedName("rank")
        public int rank;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
        public long score;

        @SerializedName("user")
        public IBaseUser user;
    }

    public c() {
        this.ranks = new ArrayList();
    }
}

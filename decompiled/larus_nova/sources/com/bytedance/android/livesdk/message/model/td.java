package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class td extends o0 implements vh7.c.a<p8>, p8 {
    public static int FIRST_ENTER_FLAG = -1;
    public static int HOT_STATUS_FEVER = 1;
    public static int HOT_STATUS_NORMAL;

    @SerializedName("hot")
    public long hot;

    @SerializedName("hot_level")
    public int hotLevel;

    @SerializedName("hot_status")
    public int hotStatus;

    @SerializedName("level2_threshold")
    public long level2_thresHold;

    @SerializedName("level3_threshold")
    public long level3_thresHold;
    private transient FlexModelDelegate<p8> modelDefaultDelegate;

    @IgnoreProtoFieldCheck
    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    public String openId;

    @SerializedName("song_id")
    public long songId;

    @IgnoreProtoFieldCheck
    @SerializedName("user_id")
    public long userId;

    @Override // com.bytedance.android.livesdk.message.model.p8
    public String getUserIdString() {
        return com.bytedance.android.livesdk.d9.c(Long.valueOf(this.userId), this.openId);
    }

    public td() {
        this.modelDefaultDelegate = new FlexModelDelegate(p8.class, this);
        this.songId = 0;
        this.hot = -1;
        this.hotLevel = 0;
        this.userId = 0;
        this.openId = "";
        this.hotStatus = HOT_STATUS_NORMAL;
        this.level2_thresHold = 0;
        this.level3_thresHold = 0;
        this.type = MessageType.KTV_USER_SINGING_HOT_MESSAGE;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<p8> getDelegate() {
        return this.modelDefaultDelegate;
    }

    @Override // com.bytedance.android.livesdk.message.model.p8
    public long getHot() {
        return this.hot;
    }

    @Override // com.bytedance.android.livesdk.message.model.p8
    public int getHotLevel() {
        return this.hotLevel;
    }

    @Override // com.bytedance.android.livesdk.message.model.p8
    public int getHotStatus() {
        return this.hotStatus;
    }

    @Override // com.bytedance.android.livesdk.message.model.p8
    public long getLevel2_thresHold() {
        return this.level2_thresHold;
    }

    @Override // com.bytedance.android.livesdk.message.model.p8
    public long getLevel3_thresHold() {
        return this.level3_thresHold;
    }

    @Override // com.bytedance.android.livesdk.message.model.p8
    public long getSongId() {
        return this.songId;
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<p8>> R castTo(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castTo(r100);
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<p8>> R castToOrNull(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castToOrNull(r100);
    }
}

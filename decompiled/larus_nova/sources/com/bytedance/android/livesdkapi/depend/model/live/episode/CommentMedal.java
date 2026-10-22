package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.livesdk.paas.HostInfoPresenter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class CommentMedal implements Serializable, j0 {
    public static final String KEY_DOUYIN = "douyin";
    public static final String KEY_DOUYIN_LITE = "doulite";
    public static final String KEY_HOTSOON = "huoshan";

    @SerializedName("image")
    public k mImage;

    @SerializedName("jump_schema")
    public Map<String, String> mJumpSchema;

    @SerializedName("keyboard_image")
    public k mKeyBoardImage;

    @SerializedName("name")
    public String mMedalName;

    public CommentMedal() {
    }

    @Override // com.bytedance.android.live.base.model.message.j0
    public String getMedalJumpSchema() {
        Map<String, String> r100 = this.mJumpSchema;
        if (r100 != null) goto L5;
    L16:
        return "";
    L5:
        if (r100.size() == 0) goto L16;
        if (HostInfoPresenter.a() == false) goto L11;
        return this.mJumpSchema.get("douyin");
    L11:
        if (HostInfoPresenter.b() == false) goto L14;
        return this.mJumpSchema.get(KEY_DOUYIN_LITE);
    L14:
        if (HostInfoPresenter.b() == false) goto L16;
        return this.mJumpSchema.get(KEY_HOTSOON);
    }
}

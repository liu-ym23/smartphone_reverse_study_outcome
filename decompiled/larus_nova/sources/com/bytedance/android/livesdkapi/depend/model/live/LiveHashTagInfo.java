package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes12.dex */
public class LiveHashTagInfo implements ILiveHashTagInfo {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("cid")
    public String f162597id;

    @SerializedName("cha_name")
    public String name;

    public LiveHashTagInfo() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveHashTagInfo
    public String getName() {
        return this.name;
    }
}

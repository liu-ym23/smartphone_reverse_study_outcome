package com.bytedance.android.livesdk.microom.api.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class d {

    @SerializedName("background")
    public ImageModel background;

    @SerializedName("end_timestamp")
    public long endTimeStamp;

    @SerializedName("introduce")
    public String introduce;

    @SerializedName("start_timestamp")
    public long startTimeStamp;

    @SerializedName("user")
    public User user;

    public d() {
    }
}

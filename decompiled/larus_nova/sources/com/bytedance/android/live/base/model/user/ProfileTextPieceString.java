package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.SubInfo;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileTextPieceString {

    @SerializedName(SubInfo.KEY_FORMAT)
    ProfileTextFormat format;

    @SerializedName("string_value")
    String value;

    public ProfileTextPieceString() {
    }

    public ProfileTextFormat getFormat() {
        return this.format;
    }

    public String getValue() {
        return this.value;
    }

    public void setFormat(ProfileTextFormat r100) {
        this.format = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }
}

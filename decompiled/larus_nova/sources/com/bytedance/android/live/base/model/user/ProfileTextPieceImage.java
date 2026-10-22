package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileTextPieceImage {

    @SerializedName("image_format")
    ProfileImageFormat imageFormat;

    @SerializedName("image")
    py.k imageModel;

    public ProfileTextPieceImage() {
    }

    public ProfileImageFormat getImageFormat() {
        return this.imageFormat;
    }

    public py.k getImageModel() {
        return this.imageModel;
    }
}

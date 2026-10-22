package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class KtvLyricText {

    @SerializedName("singer_text")
    public String singerText;

    @SerializedName("user_text")
    public String userText;

    public KtvLyricText() {
        this.singerText = "";
        this.userText = "";
    }

    public KtvLyricText(String r100, String r101) {
        this.singerText = r100;
        this.userText = r101;
    }
}

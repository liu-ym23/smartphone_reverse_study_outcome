package com.bytedance.android.live.wallet.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class i {

    @SerializedName("form_html")
    private String formHtml;

    @SerializedName("order_id")
    private String mId;

    public i() {
    }

    public final String a() {
        return this.mId;
    }

    public final void b(String r100) {
        this.mId = r100;
    }
}

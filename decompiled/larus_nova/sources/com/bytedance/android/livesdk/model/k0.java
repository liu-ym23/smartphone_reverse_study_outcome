package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class k0 {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("inner_pre_inflate_count")
    public int innerPreInflateCount;

    @SerializedName("inner_pre_inflate_op")
    public int innerPreInflateOp;

    @SerializedName("preview_enable")
    public boolean previewEnable;

    public k0() {
        this.innerPreInflateCount = 2;
        this.innerPreInflateOp = 1;
    }
}

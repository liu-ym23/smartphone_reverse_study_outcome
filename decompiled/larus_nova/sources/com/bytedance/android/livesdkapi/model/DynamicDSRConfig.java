package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class DynamicDSRConfig {

    @SerializedName("delay")
    public long mDelay;

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("exit_restore")
    public boolean mExitRestore;

    public DynamicDSRConfig() {
        this.mEnable = false;
        this.mDelay = 30000;
        this.mExitRestore = false;
    }
}

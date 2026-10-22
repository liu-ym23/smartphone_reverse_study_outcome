package com.bytedance.android.livesdkapi.model;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LiveServerBlurBgConfig {

    @SerializedName(RNParamRegisterEventHandler.SRC_INNER)
    public boolean inner;

    @SerializedName("preview")
    public boolean preview;

    @SerializedName("smooth_enter")
    public boolean smoothEnter;

    public LiveServerBlurBgConfig() {
    }
}

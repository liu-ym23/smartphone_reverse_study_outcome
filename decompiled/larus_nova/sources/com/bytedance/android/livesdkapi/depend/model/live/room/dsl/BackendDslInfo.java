package com.bytedance.android.livesdkapi.depend.model.live.room.dsl;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
public class BackendDslInfo {

    @SerializedName("dsl_info")
    public LiveDSLModel detail;

    @SerializedName("loc_info")
    public String position;

    public BackendDslInfo() {
    }
}

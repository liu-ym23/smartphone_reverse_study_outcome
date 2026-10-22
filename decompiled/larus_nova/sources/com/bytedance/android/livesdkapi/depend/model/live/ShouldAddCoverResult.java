package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class ShouldAddCoverResult {

    @SerializedName("need_notice")
    private boolean needNotice;

    public ShouldAddCoverResult() {
    }

    public boolean isNeedNotice() {
        return this.needNotice;
    }

    public void setNeedNotice(boolean r100) {
        this.needNotice = r100;
    }
}

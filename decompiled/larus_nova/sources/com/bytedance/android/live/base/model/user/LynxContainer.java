package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.DownloadConstants;

/* JADX INFO: loaded from: classes45.dex */
public class LynxContainer {

    @SerializedName(DownloadConstants.KEY_EXTRA_JSON)
    public String extraJson;

    @SerializedName("scheme")
    public String scheme;

    public LynxContainer() {
    }
}

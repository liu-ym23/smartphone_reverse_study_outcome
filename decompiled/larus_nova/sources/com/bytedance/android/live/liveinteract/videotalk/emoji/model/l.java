package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes46.dex */
public abstract class l {

    @IgnoreProtoFieldCheck
    @SerializedName("bottom_text")
    public String bottomText;

    @SerializedName(EventConstant.Value.HAS_PERMISSION)
    public boolean hasPermission;

    @IgnoreProtoFieldCheck
    @SerializedName("schema")
    public String schemaJumpUrl;

    @SerializedName("toast_without_permission")
    public String toastWithoutPermission;

    public l() {
    }
}

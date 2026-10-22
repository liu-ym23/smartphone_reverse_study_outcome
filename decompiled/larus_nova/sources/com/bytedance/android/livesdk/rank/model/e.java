package com.bytedance.android.livesdk.rank.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class e {

    @SerializedName("local_status")
    public int localStatus;

    @SerializedName("options")
    public List<Long> options;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    public String prompt;

    @SerializedName("status")
    public int status;

    public e() {
    }
}

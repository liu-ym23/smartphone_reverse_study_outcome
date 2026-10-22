package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class f91 {

    @SerializedName("black_list")
    public List<String> blackList;

    public f91() {
        this.blackList = new ArrayList();
    }
}

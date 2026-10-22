package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class r2 {

    @SerializedName("source")
    private String source;

    @SerializedName("type")
    private String type;

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private List<x2> words;

    public r2() {
    }
}

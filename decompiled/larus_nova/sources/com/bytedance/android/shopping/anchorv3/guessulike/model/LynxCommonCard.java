package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/LynxCommonCard;", "Ljava/io/Serializable;", "()V", "lynxConfig", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/LynxConfig;", "getLynxConfig", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/LynxConfig;", "lynxData", "", "getLynxData", "()Ljava/lang/String;", "lynxTrack", "getLynxTrack", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxCommonCard implements Serializable {

    @SerializedName("lynx_config")
    private final LynxConfig lynxConfig;

    @SerializedName("lynx_data")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String lynxData;

    @SerializedName("lynx_track")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String lynxTrack;

    public LynxCommonCard() {
    }

    public final LynxConfig getLynxConfig() {
        return this.lynxConfig;
    }

    public final String getLynxData() {
        return this.lynxData;
    }

    public final String getLynxTrack() {
        return this.lynxTrack;
    }
}

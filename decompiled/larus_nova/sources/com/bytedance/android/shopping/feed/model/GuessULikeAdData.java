package com.bytedance.android.shopping.feed.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/GuessULikeAdData;", "Ljava/io/Serializable;", "()V", "adTrackCell", "", "getAdTrackCell", "()Ljava/lang/String;", "setAdTrackCell", "(Ljava/lang/String;)V", "id", "getId", "setId", "rawData", "getRawData", "setRawData", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuessULikeAdData implements Serializable {

    @SerializedName("AdPackCell")
    private String adTrackCell;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f175111id;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private String rawData;

    public GuessULikeAdData() {
    }

    public final String getAdTrackCell() {
        return this.adTrackCell;
    }

    public final String getId() {
        return this.f175111id;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final void setAdTrackCell(String r100) {
        this.adTrackCell = r100;
    }

    public final void setId(String r100) {
        this.f175111id = r100;
    }

    public final void setRawData(String r100) {
        this.rawData = r100;
    }
}

package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/AdInfoStruct;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "rawData", "getRawData", "showAdTag", "", "getShowAdTag", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AdInfoStruct implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f47927id;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private final String rawData;

    @SerializedName("show_ad_tag")
    private final Boolean showAdTag;

    public AdInfoStruct() {
    }

    public final String getId() {
        return this.f47927id;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final Boolean getShowAdTag() {
        return this.showAdTag;
    }
}

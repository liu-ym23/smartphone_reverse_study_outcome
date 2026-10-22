package com.bytedance.android.shopping.anchorv3.repository.dto;

import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/dto/InflowRespExtra;", "Ljava/io/Serializable;", "()V", "adExtra", "", "getAdExtra", "()Ljava/lang/String;", "setAdExtra", "(Ljava/lang/String;)V", "logId", "getLogId", "setLogId", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowRespExtra implements Serializable {

    @SerializedName("ad_extra")
    private String adExtra;

    @SerializedName(CronetDataStorageAccess.LOGID)
    private String logId;

    public InflowRespExtra() {
    }

    public final String getAdExtra() {
        return this.adExtra;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setAdExtra(String r100) {
        this.adExtra = r100;
    }

    public final void setLogId(String r100) {
        this.logId = r100;
    }
}

package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/FormatXplayChargeResponse;", "Ljava/io/Serializable;", "()V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatXplayChargeResponse implements Serializable {

    @SerializedName("status")
    private int status;

    public FormatXplayChargeResponse() {
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }
}

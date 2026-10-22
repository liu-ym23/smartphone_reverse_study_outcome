package com.bytedance.android.gamecp.base.network.response;

import com.bytedance.android.gamecp.host_api.model.network.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0001R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/base/network/response/ExtraResponse;", "", "DATA", "Lcom/bytedance/android/gamecp/host_api/model/network/Extra;", "EXTRA", "", "logId", "Ljava/lang/String;", "data", "Ljava/lang/Object;", "extra", "Lcom/bytedance/android/gamecp/host_api/model/network/Extra;", "Lcom/bytedance/android/gamecp/base/network/response/f;", "Lcom/bytedance/android/gamecp/base/network/response/i;", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ExtraResponse<DATA, EXTRA extends Extra> {

    @SerializedName("data")
    public final DATA data;

    @SerializedName("extra")
    public final EXTRA extra;
    public final transient String logId;

    public ExtraResponse() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExtraResponse(Object r100, Extra r101) {
        this.data = r100;
        this.extra = r101;
        this.logId = "";
    }
}

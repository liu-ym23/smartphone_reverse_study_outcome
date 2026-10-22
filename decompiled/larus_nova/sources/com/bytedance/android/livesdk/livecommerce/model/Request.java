package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("live.ProductRefreshMessage.RequestInfo.Request")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/Request;", "", "()V", "delayParam", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2DelayParam;", "params", "", "", "path", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Request {

    @SerializedName("delay_param")
    public ECV2DelayParam delayParam;

    @SerializedName("params")
    public Map<String, String> params;

    @SerializedName("path")
    public String path;

    public Request() {
    }
}

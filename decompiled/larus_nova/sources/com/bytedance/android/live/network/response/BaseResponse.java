package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes46.dex */
@Deprecated(message = "use ExtraResponse<T, R>")
public class BaseResponse<T, R extends Extra> {

    @SerializedName("data")
    public T data;
    public transient RequestError error;

    @SerializedName("extra")
    public R extra;
    public int isSocketReuse;
    public String logId;
    public int requestType;

    @SerializedName("status_code")
    public int statusCode;
    public String traceId;
    public String ttStable;

    public BaseResponse() {
        this.isSocketReuse = -1;
    }
}

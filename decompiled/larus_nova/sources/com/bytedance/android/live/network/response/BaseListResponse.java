package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes46.dex */
@Deprecated(message = "use ExtraResponse<List<T>, R> or ExtraResponse<Set<T>, R>")
public class BaseListResponse<T, R extends Extra> {

    @SerializedName("data")
    public List<T> data;
    public transient RequestError error;

    @SerializedName("extra")
    public R extra;

    @SerializedName("status_code")
    public int statusCode;

    public BaseListResponse() {
    }
}

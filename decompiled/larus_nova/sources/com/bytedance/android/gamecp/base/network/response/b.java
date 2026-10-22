package com.bytedance.android.gamecp.base.network.response;

import com.bytedance.android.gamecp.host_api.model.network.Extra;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "use ExtraResponse<T, R>")
public class b<T, R extends Extra> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f51686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient RequestError f51687b;

    @SerializedName("data")
    public T data;

    @SerializedName("extra")
    public R extra;

    @SerializedName("status_code")
    public int statusCode;

    public b() {
    }
}

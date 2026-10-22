package com.bytedance.android.gamecp.base.network.response;

import com.bytedance.android.gamecp.host_api.model.network.Extra;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "use ExtraResponse<List<T>, R> or ExtraResponse<Set<T>, R>")
public class a<T, R extends Extra> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient RequestError f51685a;

    @SerializedName("data")
    public List<T> data;

    @SerializedName("extra")
    public R extra;

    @SerializedName("status_code")
    public int statusCode;

    public a() {
    }
}

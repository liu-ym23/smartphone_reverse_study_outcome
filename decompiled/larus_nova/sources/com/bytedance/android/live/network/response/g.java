package com.bytedance.android.live.network.response;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes46.dex */
public class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient RequestError f83948a;

    @SerializedName("data")
    public T data;

    @SerializedName("extra")
    public Object extra;

    @SerializedName("status_code")
    public int statusCode;

    public g() {
    }
}

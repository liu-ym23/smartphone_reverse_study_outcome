package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LivePlayerResponse<T> {

    @SerializedName("data")
    public T data;

    @SerializedName("status_code")
    public int statusCode;

    public LivePlayerResponse() {
    }
}

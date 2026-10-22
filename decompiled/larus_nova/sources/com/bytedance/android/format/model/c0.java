package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/format/model/c0;", "", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "waitTimeSecs", "getWaitTimeSecs", "setWaitTimeSecs", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName("generate_status")
    private int status;

    @SerializedName("next_req_wait_time_s")
    private int waitTimeSecs;

    public c0() {
        this.status = 1;
        this.waitTimeSecs = 1;
    }
}

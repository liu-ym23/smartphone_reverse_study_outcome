package com.bytedance.android.ec.core.hybrid.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/model/ECFloatWindowDetailExtraParams;", "", "", "taskFinishMsg", "Ljava/lang/String;", "getTaskFinishMsg", "()Ljava/lang/String;", "coin", "getCoin", "schema", "getSchema", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowDetailExtraParams {

    @SerializedName("coin")
    private final String coin;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("taskFinishMsg")
    private final String taskFinishMsg;

    public ECFloatWindowDetailExtraParams() {
        this.coin = "0";
    }
}

package com.bytedance.android.ec.hybrid.list.view;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/view/ECFloatWindowDetailResponse;", "", "Lcom/google/gson/JsonObject;", "data", "Lcom/google/gson/JsonObject;", "getData", "()Lcom/google/gson/JsonObject;", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "", "statusMessage", "Ljava/lang/String;", "getStatusMessage", "()Ljava/lang/String;", "setStatusMessage", "(Ljava/lang/String;)V", "Lcom/bytedance/android/ec/hybrid/list/view/LogPbData;", "logPb", "Lcom/bytedance/android/ec/hybrid/list/view/LogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/hybrid/list/view/LogPbData;", "setLogPb", "(Lcom/bytedance/android/ec/hybrid/list/view/LogPbData;)V", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowDetailResponse {

    @SerializedName("data")
    private final JsonObject data;

    @SerializedName("log_pb")
    private LogPbData logPb;

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("status_msg")
    private String statusMessage;

    public ECFloatWindowDetailResponse() {
    }
}

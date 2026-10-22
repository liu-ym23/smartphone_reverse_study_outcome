package com.android.ttcjpaysdk.thirdparty.verify.mode;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/mode/TradeConfirmRecordInfo;", "", "jsonData", "Lorg/json/JSONObject;", "occurTs", "", "stackTrace", "", "(Lorg/json/JSONObject;JLjava/lang/String;)V", "getJsonData", "()Lorg/json/JSONObject;", "getOccurTs", "()J", "getStackTrace", "()Ljava/lang/String;", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TradeConfirmRecordInfo {
    private final JSONObject jsonData;
    private final long occurTs;
    private final String stackTrace;

    public final JSONObject getJsonData() {
        return this.jsonData;
    }

    public final long getOccurTs() {
        return this.occurTs;
    }

    public final String getStackTrace() {
        return this.stackTrace;
    }

    public TradeConfirmRecordInfo(JSONObject r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonData");
        Intrinsics.checkNotNullParameter(r102, "stackTrace");
        this.jsonData = r100;
        this.occurTs = r101;
        this.stackTrace = r102;
    }
}

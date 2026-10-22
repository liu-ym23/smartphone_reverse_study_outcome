package com.bytedance.android.livesdk.jsbridge.methods;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/v1;", "", "", "btmAB", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setBtmAB", "(Ljava/lang/String;)V", "sourceBtmToken", "c", "setSourceBtmToken", "Lcom/google/gson/JsonObject;", "bcm", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "setBcm", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v1 {

    @SerializedName("bcm")
    private JsonObject bcm;

    @SerializedName("btmAB")
    private String btmAB;

    @SerializedName("sourceBtmToken")
    private String sourceBtmToken;

    public v1() {
    }

    public final JsonObject a() {
        return this.bcm;
    }

    public final String b() {
        return this.btmAB;
    }

    public final String c() {
        return this.sourceBtmToken;
    }
}

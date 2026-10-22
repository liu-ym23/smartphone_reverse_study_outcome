package com.bytedance.android.livesdk.jsbridge.methods;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/o3;", "", "", "eventName", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setExtra", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o3 {

    @SerializedName("eventName")
    private String eventName;

    @SerializedName("extra")
    private JsonObject extra;

    public o3() {
    }

    public final String a() {
        return this.eventName;
    }

    public final JsonObject b() {
        return this.extra;
    }
}

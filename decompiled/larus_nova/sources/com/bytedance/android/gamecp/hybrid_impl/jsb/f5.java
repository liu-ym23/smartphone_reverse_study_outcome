package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/f5;", "", "", "schema", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "startParams", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setStartParams", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f5 {

    @SerializedName("schema")
    private String schema;

    @SerializedName("startParams")
    private JsonObject startParams;

    public f5() {
    }

    public final String a() {
        return this.schema;
    }

    public final JsonObject b() {
        return this.startParams;
    }
}

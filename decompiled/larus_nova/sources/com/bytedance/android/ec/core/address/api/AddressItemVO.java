package com.bytedance.android.ec.core.address.api;

import com.bytedance.android.ec.hybrid.list.util.k;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/address/api/AddressItemVO;", "Ljava/io/Serializable;", "", "parseAddress", "Lorg/json/JSONObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lorg/json/JSONObject;", "getAddressVO", "()Lorg/json/JSONObject;", "setAddressVO", "(Lorg/json/JSONObject;)V", "addressVO", "Lcom/google/gson/JsonObject;", "_address", "Lcom/google/gson/JsonObject;", "get_address", "()Lcom/google/gson/JsonObject;", "Lcom/bytedance/android/ec/core/address/api/RecommendAddressConfig;", "config", "Lcom/bytedance/android/ec/core/address/api/RecommendAddressConfig;", "getConfig", "()Lcom/bytedance/android/ec/core/address/api/RecommendAddressConfig;", "<init>", "(Lcom/google/gson/JsonObject;Lcom/bytedance/android/ec/core/address/api/RecommendAddressConfig;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddressItemVO implements Serializable {

    @SerializedName("address")
    private final JsonObject _address;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient JSONObject f43676a;

    @SerializedName("config")
    private final RecommendAddressConfig config;

    public final void parseAddress() {
        JsonObject r100 = this._address;
        if (r100 == null) goto L5;
        JSONObject r101 = k.b(r100);
    L6:
        this.f43676a = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final JSONObject getAddressVO() {
        return this.f43676a;
    }

    public final RecommendAddressConfig getConfig() {
        return this.config;
    }

    public final JsonObject get_address() {
        return this._address;
    }

    public final void setAddressVO(JSONObject r100) {
        this.f43676a = r100;
    }

    public AddressItemVO(JsonObject r100, RecommendAddressConfig r101) {
        this._address = r100;
        this.config = r101;
    }

    public /* synthetic */ AddressItemVO(JsonObject r100, RecommendAddressConfig r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}

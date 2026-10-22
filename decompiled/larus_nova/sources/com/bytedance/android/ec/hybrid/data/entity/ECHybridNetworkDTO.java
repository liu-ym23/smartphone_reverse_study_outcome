package com.bytedance.android.ec.hybrid.data.entity;

import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u000202R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R,\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR,\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020%\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010\u001eR&\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R \u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\b¨\u00063"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridNetworkDTO;", "Ljava/io/Serializable;", "()V", "aiPreloadUrl", "", "getAiPreloadUrl", "()Ljava/lang/String;", "setAiPreloadUrl", "(Ljava/lang/String;)V", "apiType", "", "getApiType$annotations", "getApiType", "()I", "setApiType", "(I)V", "clientHeaderKeys", "", "getClientHeaderKeys", "()Ljava/util/List;", "setClientHeaderKeys", "(Ljava/util/List;)V", "clientParamKeys", "getClientParamKeys", "setClientParamKeys", "headers", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "isMain", "setMain", e.f25671s, "getMethod", "setMethod", "params", "", "getParams", "setParams", "storageKeys", "getStorageKeys", "setStorageKeys", "url", "getUrl", "setUrl", "transformToVO", "Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridNetworkVO;", "apiKey", "isAiPrefetch", "", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridNetworkDTO implements Serializable {

    @SerializedName("ai_preload_url")
    private String aiPreloadUrl;

    @SerializedName("api_type")
    private int apiType;

    @SerializedName("client_header_keys")
    private List<String> clientHeaderKeys;

    @SerializedName("client_param_keys")
    private List<String> clientParamKeys;

    @SerializedName("headers")
    private Map<String, String> headers;

    @SerializedName("is_main")
    private int isMain;

    @SerializedName(e.f25671s)
    private String method;

    @SerializedName("params")
    private Map<String, ? extends Object> params;

    @SerializedName("storage_key_list")
    private List<String> storageKeys;

    @SerializedName("url")
    private String url;

    public static /* synthetic */ void getApiType$annotations() {
    }

    public ECHybridNetworkDTO() {
        this.apiType = 1;
    }

    public final String getAiPreloadUrl() {
        return this.aiPreloadUrl;
    }

    public final int getApiType() {
        return this.apiType;
    }

    public final List<String> getClientHeaderKeys() {
        return this.clientHeaderKeys;
    }

    public final List<String> getClientParamKeys() {
        return this.clientParamKeys;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final List<String> getStorageKeys() {
        return this.storageKeys;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int isMain() {
        return this.isMain;
    }

    public final void setAiPreloadUrl(String r100) {
        this.aiPreloadUrl = r100;
    }

    public final void setApiType(int r100) {
        this.apiType = r100;
    }

    public final void setClientHeaderKeys(List<String> r100) {
        this.clientHeaderKeys = r100;
    }

    public final void setClientParamKeys(List<String> r100) {
        this.clientParamKeys = r100;
    }

    public final void setHeaders(Map<String, String> r100) {
        this.headers = r100;
    }

    public final void setMain(int r100) {
        this.isMain = r100;
    }

    public final void setMethod(String r100) {
        this.method = r100;
    }

    public final void setParams(Map<String, ? extends Object> r100) {
        this.params = r100;
    }

    public final void setStorageKeys(List<String> r100) {
        this.storageKeys = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final ECHybridNetworkVO transformToVO(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        if (this.url != null) goto L5;
        return null;
    L5:
        if (this.method != null) goto L8;
        return null;
    L8:
        if (r101 == true) goto L10;
    L14:
        String r102 = this.url;
        Intrinsics.checkNotNull(r102);
        String r103 = this.method;
        Intrinsics.checkNotNull(r103);
        int r104 = this.apiType;
        if (this.isMain <= 0) goto L17;
        boolean r105 = true;
    L18:
        ECHybridNetworkVO r106 = new ECHybridNetworkVO(r102, r103, r104, r105, r100);
        Map<String, String> r107 = this.headers;
        if (r107 == null) goto L21;
        r106.a().putAll(r107);
    L21:
        Map<String, ? extends Object> r108 = this.params;
        if (r108 == null) goto L24;
        r106.b().putAll(r108);
    L24:
        return r106;
    L17:
        r105 = false;
        goto L18
    L10:
        if (this.isMain != 1) goto L14;
        if (TextUtils.isEmpty(this.aiPreloadUrl) == true) goto L14;
        this.url = this.aiPreloadUrl;
        goto L14
    }

    public static /* synthetic */ ECHybridNetworkVO transformToVO$default(ECHybridNetworkDTO r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.transformToVO(r101, r102);
    }
}

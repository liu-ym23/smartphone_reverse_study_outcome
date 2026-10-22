package com.bytedance.android.shopping.store.hybrid.entity;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00120\b\u0002\u0010\u0004\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R>\u0010\u0004\u001a*\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/ECStoreHybridTabInitialDataResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "bundleUrl", "", "components", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "passThrough2FE", "block", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getBlock", "()Lcom/google/gson/JsonObject;", "getBundleUrl", "()Ljava/lang/String;", "getComponents", "()Ljava/util/List;", "getPassThrough2FE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHybridTabInitialDataResponseDTO extends CommerceBaseResponse {

    @SerializedName("block")
    private final JsonObject block;

    @SerializedName("bundle_url")
    private final String bundleUrl;

    @SerializedName("components")
    private final List<HashMap<String, Object>> components;

    @SerializedName("pass_through_fe")
    private final String passThrough2FE;

    public ECStoreHybridTabInitialDataResponseDTO() {
        this(null, null, null, null, 15, null);
    }

    public final JsonObject getBlock() {
        return this.block;
    }

    public final String getBundleUrl() {
        return this.bundleUrl;
    }

    public final List<HashMap<String, Object>> getComponents() {
        return this.components;
    }

    public final String getPassThrough2FE() {
        return this.passThrough2FE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECStoreHybridTabInitialDataResponseDTO(String r100, List<? extends HashMap<String, Object>> r101, String r102, JsonObject r103) {
        this.bundleUrl = r100;
        this.components = r101;
        this.passThrough2FE = r102;
        this.block = r103;
    }

    public /* synthetic */ ECStoreHybridTabInitialDataResponseDTO(String r100, List r101, String r102, JsonObject r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}

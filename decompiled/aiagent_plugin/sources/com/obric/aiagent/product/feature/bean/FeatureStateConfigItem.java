package com.obric.aiagent.product.feature.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.feature.ProductSpecialConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FeatureConfigWrap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureStateConfigItem {

    @SerializedName("product_list")
    private final List<String> productList;

    @SerializedName("product_special_list")
    private final Map<String, Map<String, ProductSpecialConfig>> productSpecialList;

    @SerializedName("state")
    private final String state;

    @SerializedName("state_list")
    private final List<String> stateList;

    public FeatureStateConfigItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FeatureStateConfigItem copy$default(FeatureStateConfigItem r1, String r2, List r3, List r4, Map r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.state;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.stateList;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = r1.productList;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r10 = r1.productSpecialList;
    L15:
        return r1.copy(r2, r8, r9, r10);
    }

    public final String component1() {
        return this.state;
    }

    public final List<String> component2() {
        return this.stateList;
    }

    public final List<String> component3() {
        return this.productList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> component4() {
        return this.productSpecialList;
    }

    public final FeatureStateConfigItem copy(String r2, List<String> r3, List<String> r4, Map<String, ? extends Map<String, ProductSpecialConfig>> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "state");
        o.e(r1, "stateList");
        o.e(r6, "productList");
        o.e(r7, "productSpecialList");
        return new FeatureStateConfigItem(r2, r1, r6, r7);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureStateConfigItem.class) == true) goto L8;
        return false;
    L8:
        FeatureStateConfigItem r6 = (FeatureStateConfigItem) ZeusTransformUtils.preCheckCast(r5, FeatureStateConfigItem.class, "com.obric.aiagent.plugin");
        if (o.a(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (o.a(this.stateList, r6.stateList) == true) goto L15;
        return false;
    L15:
        if (o.a(this.productList, r6.productList) == true) goto L18;
        return false;
    L18:
        if (o.a(this.productSpecialList, r6.productSpecialList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.state.hashCode() * 31) + this.stateList.hashCode()) * 31) + this.productList.hashCode()) * 31) + this.productSpecialList.hashCode();
    }

    public String toString() {
        return "FeatureStateConfigItem(state=" + this.state + ", stateList=" + this.stateList + ", productList=" + this.productList + ", productSpecialList=" + this.productSpecialList + ')';
    }

    public FeatureStateConfigItem(String r3, List<String> r4, List<String> r5, Map<String, ? extends Map<String, ProductSpecialConfig>> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "state");
        o.e(r7, "stateList");
        o.e(r8, "productList");
        o.e(r9, "productSpecialList");
        this.state = r3;
        this.stateList = r7;
        this.productList = r8;
        this.productSpecialList = r9;
    }

    public final String getState() {
        return this.state;
    }

    public final List<String> getStateList() {
        return this.stateList;
    }

    public /* synthetic */ FeatureStateConfigItem(String r2, List r3, List r4, Map r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = p.b();
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = p.b();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r10 = ao.b();
    L14:
        this(r2, r8, r9, r10);
    }

    public final List<String> getProductList() {
        return this.productList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> getProductSpecialList() {
        return this.productSpecialList;
    }
}

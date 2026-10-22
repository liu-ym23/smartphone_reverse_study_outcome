package com.obric.aiagent.product.feature.bean;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: FeatureConfigWrap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureConfigWrap {

    @SerializedName("default_state")
    private final String defaultState;

    @SerializedName("default_state_list")
    private final List<String> defaultStateList;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("feature_state_config_list")
    private final List<FeatureStateConfigItem> featureStateConfigList;

    public FeatureConfigWrap() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ FeatureConfigWrap copy$default(FeatureConfigWrap r1, boolean r2, String r3, List r4, List r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<FeatureStateConfigItem> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.enabled;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.defaultState;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.defaultStateList;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r9 = r1.featureStateConfigList;
    L15:
        return r1.copy(r2, r3, r8, r9);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.defaultState;
    }

    public final List<String> component3() {
        return this.defaultStateList;
    }

    public final List<FeatureStateConfigItem> component4() {
        return this.featureStateConfigList;
    }

    public final FeatureConfigWrap copy(boolean r2, String r3, List<String> r4, List<FeatureStateConfigItem> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "defaultState");
        o.e(r1, "defaultStateList");
        o.e(r6, "featureStateConfigList");
        return new FeatureConfigWrap(r2, r3, r1, r6);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureConfigWrap.class) == true) goto L8;
        return false;
    L8:
        FeatureConfigWrap r6 = (FeatureConfigWrap) ZeusTransformUtils.preCheckCast(r5, FeatureConfigWrap.class, "com.obric.aiagent.plugin");
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (o.a(this.defaultState, r6.defaultState) == true) goto L15;
        return false;
    L15:
        if (o.a(this.defaultStateList, r6.defaultStateList) == true) goto L18;
        return false;
    L18:
        if (o.a(this.featureStateConfigList, r6.featureStateConfigList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.enabled) * 31) + this.defaultState.hashCode()) * 31) + this.defaultStateList.hashCode()) * 31) + this.featureStateConfigList.hashCode();
    }

    public String toString() {
        return "FeatureConfigWrap(enabled=" + this.enabled + ", defaultState=" + this.defaultState + ", defaultStateList=" + this.defaultStateList + ", featureStateConfigList=" + this.featureStateConfigList + ')';
    }

    public FeatureConfigWrap(boolean r3, String r4, List<String> r5, List<FeatureStateConfigItem> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<FeatureStateConfigItem> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "defaultState");
        o.e(r7, "defaultStateList");
        o.e(r8, "featureStateConfigList");
        this.enabled = r3;
        this.defaultState = r4;
        this.defaultStateList = r7;
        this.featureStateConfigList = r8;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getDefaultState() {
        return this.defaultState;
    }

    public final List<String> getDefaultStateList() {
        return this.defaultStateList;
    }

    public /* synthetic */ FeatureConfigWrap(boolean r2, String r3, List r4, List r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = p.b();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r9 = p.b();
    L14:
        this(r2, r3, r8, r9);
    }

    public final List<FeatureStateConfigItem> getFeatureStateConfigList() {
        return this.featureStateConfigList;
    }
}

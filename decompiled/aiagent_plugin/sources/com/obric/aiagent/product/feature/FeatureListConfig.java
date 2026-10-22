package com.obric.aiagent.product.feature;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.feature.bean.FeatureConfigWrap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: FeatureConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureListConfig {

    @SerializedName("feature_config_warps")
    private final Map<String, FeatureConfigWrap> featureConfigWraps;

    @SerializedName("feature_configs")
    private final Map<String, FeatureConfig> featureConfigs;

    @SerializedName("version")
    private final int version;

    public FeatureListConfig() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ FeatureListConfig copy$default(FeatureListConfig r1, int r2, Map r3, Map r4, int r5, Object r6) {
        Map<String, FeatureConfig> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map<String, FeatureConfigWrap> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.version;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.featureConfigs;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.featureConfigWraps;
    L12:
        return r1.copy(r2, r7, r8);
    }

    public final int component1() {
        return this.version;
    }

    public final Map<String, FeatureConfig> component2() {
        return this.featureConfigs;
    }

    public final Map<String, FeatureConfigWrap> component3() {
        return this.featureConfigWraps;
    }

    public final FeatureListConfig copy(int r2, Map<String, FeatureConfig> r3, Map<String, FeatureConfigWrap> r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r1, "featureConfigs");
        o.e(r5, "featureConfigWraps");
        return new FeatureListConfig(r2, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureListConfig.class) == true) goto L8;
        return false;
    L8:
        FeatureListConfig r6 = (FeatureListConfig) ZeusTransformUtils.preCheckCast(r5, FeatureListConfig.class, "com.obric.aiagent.plugin");
        if (this.version == r6.version) goto L12;
        return false;
    L12:
        if (o.a(this.featureConfigs, r6.featureConfigs) == true) goto L15;
        return false;
    L15:
        if (o.a(this.featureConfigWraps, r6.featureConfigWraps) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.version) * 31) + this.featureConfigs.hashCode()) * 31) + this.featureConfigWraps.hashCode();
    }

    public String toString() {
        return "FeatureListConfig(version=" + this.version + ", featureConfigs=" + this.featureConfigs + ", featureConfigWraps=" + this.featureConfigWraps + ')';
    }

    public FeatureListConfig(int r3, Map<String, FeatureConfig> r4, Map<String, FeatureConfigWrap> r5) {
        Map<String, FeatureConfig> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map<String, FeatureConfigWrap> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "featureConfigs");
        o.e(r7, "featureConfigWraps");
        this.version = r3;
        this.featureConfigs = r6;
        this.featureConfigWraps = r7;
    }

    public final int getVersion() {
        return this.version;
    }

    public final Map<String, FeatureConfig> getFeatureConfigs() {
        return this.featureConfigs;
    }

    public /* synthetic */ FeatureListConfig(int r2, Map r3, Map r4, int r5, h r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = ao.b();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r8 = ao.b();
    L11:
        this(r2, r7, r8);
    }

    public final Map<String, FeatureConfigWrap> getFeatureConfigWraps() {
        return this.featureConfigWraps;
    }
}

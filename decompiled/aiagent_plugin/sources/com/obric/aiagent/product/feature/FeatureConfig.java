package com.obric.aiagent.product.feature;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: FeatureConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FeatureConfig implements Parcelable {
    public static final Parcelable.Creator<FeatureConfig> CREATOR = null;

    @SerializedName("default_state")
    private final String defaultState;

    @SerializedName("dependency_os_feature_list")
    private final List<String> dependencyOsFeatureList;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("product_black_list")
    private final List<String> productBlackList;

    @SerializedName("product_special_list")
    private final Map<String, Map<String, ProductSpecialConfig>> productSpecialList;

    @SerializedName("product_white_list")
    private final List<String> productWhiteList;

    /* JADX INFO: compiled from: FeatureConfig.kt */
    public static final class Creator implements Parcelable.Creator<FeatureConfig> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeatureConfig createFromParcel(Parcel r17) {
            o.e(r17, "parcel");
            if (r17.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            String r5 = r17.readString();
            List r1 = (List) ZeusTransformUtils.preCheckCast(r17.createStringArrayList(), List.class, "com.obric.aiagent.plugin");
            List r7 = (List) ZeusTransformUtils.preCheckCast(r17.createStringArrayList(), List.class, "com.obric.aiagent.plugin");
            List r8 = (List) ZeusTransformUtils.preCheckCast(r17.createStringArrayList(), List.class, "com.obric.aiagent.plugin");
            int r3 = r17.readInt();
            LinkedHashMap r9 = new LinkedHashMap(r3);
            int r10 = 0;
        L7:
            if (r10 == r3) goto L13;
            String r11 = r17.readString();
            int r12 = r17.readInt();
            LinkedHashMap r13 = new LinkedHashMap(r12);
            int r14 = 0;
        L9:
            if (r14 == r12) goto L11;
            r13.put(r17.readString(), ProductSpecialConfig.CREATOR.createFromParcel(r17));
            r14 = r14 + 1;
            goto L9
        L11:
            r9.put(r11, r13);
            r10 = r10 + 1;
            goto L7
        L13:
            return new FeatureConfig(r4, r5, r1, r7, r8, (Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.aiagent.plugin"));
        L5:
            r4 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeatureConfig createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FeatureConfig[] newArray(int r1) {
            return new FeatureConfig[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FeatureConfig[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public FeatureConfig() {
        this(false, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ FeatureConfig copy$default(FeatureConfig r7, boolean r8, String r9, List r10, List r11, List r12, Map r13, int r14, Object r15) {
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List<String> r17 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List<String> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r19 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.enabled;
    L5:
        boolean r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = r7.defaultState;
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r16 = r7.dependencyOsFeatureList;
    L11:
        List<String> r3 = r16;
        if ((r14 & 8) == 0) goto L14;
        r17 = r7.productBlackList;
    L14:
        List<String> r4 = r17;
        if ((r14 & 16) == 0) goto L17;
        r18 = r7.productWhiteList;
    L17:
        List<String> r5 = r18;
        if ((r14 & 32) == 0) goto L21;
        r19 = r7.productSpecialList;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r19);
    }

    public final boolean component1() {
        return this.enabled;
    }

    public final String component2() {
        return this.defaultState;
    }

    public final List<String> component3() {
        return this.dependencyOsFeatureList;
    }

    public final List<String> component4() {
        return this.productBlackList;
    }

    public final List<String> component5() {
        return this.productWhiteList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> component6() {
        return this.productSpecialList;
    }

    public final FeatureConfig copy(boolean r9, String r10, List<String> r11, List<String> r12, List<String> r13, Map<String, ? extends Map<String, ProductSpecialConfig>> r14) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        o.e(r10, "defaultState");
        o.e(r4, "dependencyOsFeatureList");
        o.e(r5, "productBlackList");
        o.e(r6, "productWhiteList");
        o.e(r7, "productSpecialList");
        return new FeatureConfig(r9, r10, r4, r5, r6, r7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FeatureConfig.class) == true) goto L8;
        return false;
    L8:
        FeatureConfig r6 = (FeatureConfig) ZeusTransformUtils.preCheckCast(r5, FeatureConfig.class, "com.obric.aiagent.plugin");
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (o.a(this.defaultState, r6.defaultState) == true) goto L15;
        return false;
    L15:
        if (o.a(this.dependencyOsFeatureList, r6.dependencyOsFeatureList) == true) goto L18;
        return false;
    L18:
        if (o.a(this.productBlackList, r6.productBlackList) == true) goto L21;
        return false;
    L21:
        if (o.a(this.productWhiteList, r6.productWhiteList) == true) goto L24;
        return false;
    L24:
        if (o.a(this.productSpecialList, r6.productSpecialList) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.enabled) * 31) + this.defaultState.hashCode()) * 31) + this.dependencyOsFeatureList.hashCode()) * 31) + this.productBlackList.hashCode()) * 31) + this.productWhiteList.hashCode()) * 31) + this.productSpecialList.hashCode();
    }

    public String toString() {
        return "FeatureConfig(enabled=" + this.enabled + ", defaultState=" + this.defaultState + ", dependencyOsFeatureList=" + this.dependencyOsFeatureList + ", productBlackList=" + this.productBlackList + ", productWhiteList=" + this.productWhiteList + ", productSpecialList=" + this.productSpecialList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        o.e(r6, "dest");
        r6.writeInt(this.enabled ? 1 : 0);
        r6.writeString(this.defaultState);
        r6.writeStringList(this.dependencyOsFeatureList);
        r6.writeStringList(this.productBlackList);
        r6.writeStringList(this.productWhiteList);
        Map<String, Map<String, ProductSpecialConfig>> r5 = this.productSpecialList;
        r6.writeInt(r5.size());
        Iterator<Map.Entry<String, Map<String, ProductSpecialConfig>>> r8 = r5.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry<String, Map<String, ProductSpecialConfig>> r0 = r8.next();
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Map.class, "com.obric.aiagent.plugin");
        r6.writeInt(r1.size());
        Iterator r2 = r1.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        Object r3 = r2.next();
        r6.writeString((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        ((ProductSpecialConfig) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), ProductSpecialConfig.class, "com.obric.aiagent.plugin")).writeToParcel(r6, r7);
        goto L7
    }

    public FeatureConfig(boolean r3, String r4, List<String> r5, List<String> r6, List<String> r7, Map<String, ? extends Map<String, ProductSpecialConfig>> r8) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Map<String, Map<String, ProductSpecialConfig>> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "defaultState");
        o.e(r9, "dependencyOsFeatureList");
        o.e(r10, "productBlackList");
        o.e(r11, "productWhiteList");
        o.e(r12, "productSpecialList");
        this.enabled = r3;
        this.defaultState = r4;
        this.dependencyOsFeatureList = r9;
        this.productBlackList = r10;
        this.productWhiteList = r11;
        this.productSpecialList = r12;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getDefaultState() {
        return this.defaultState;
    }

    public final List<String> getDependencyOsFeatureList() {
        return this.dependencyOsFeatureList;
    }

    public /* synthetic */ FeatureConfig(boolean r8, String r9, List r10, List r11, List r12, Map r13, int r14, h r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r18 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        Map r19 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = true;
    L5:
        boolean r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = "enabled";
    L8:
        String r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r16 = p.b();
    L11:
        List r3 = r16;
        if ((r14 & 8) == 0) goto L14;
        r17 = p.b();
    L14:
        List r4 = r17;
        if ((r14 & 16) == 0) goto L17;
        r18 = p.b();
    L17:
        List r5 = r18;
        if ((r14 & 32) == 0) goto L20;
        r19 = ao.b();
    L20:
        this(r1, r2, r3, r4, r5, r19);
    }

    public final List<String> getProductBlackList() {
        return this.productBlackList;
    }

    public final List<String> getProductWhiteList() {
        return this.productWhiteList;
    }

    public final Map<String, Map<String, ProductSpecialConfig>> getProductSpecialList() {
        return this.productSpecialList;
    }
}

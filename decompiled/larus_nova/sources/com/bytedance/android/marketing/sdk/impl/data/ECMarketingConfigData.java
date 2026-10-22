package com.bytedance.android.marketing.sdk.impl.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J?\u0010\u0013\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/data/ECMarketingConfigData;", "", "ecMarketingRitsConfig", "", "", "", "ecMarketingStorageKeyConfig", "ecMarketingLifecycleFallback", "", "(Ljava/util/Map;Ljava/util/List;Z)V", "getEcMarketingLifecycleFallback", "()Z", "getEcMarketingRitsConfig", "()Ljava/util/Map;", "getEcMarketingStorageKeyConfig", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMarketingConfigData {

    @SerializedName("ec_marketing_lifecycle_fallback")
    private final boolean ecMarketingLifecycleFallback;

    @SerializedName("ec_marketing_rits_config")
    private final Map<String, List<String>> ecMarketingRitsConfig;

    @SerializedName("ec_marketing_storage_key_config")
    private final List<String> ecMarketingStorageKeyConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECMarketingConfigData copy$default(ECMarketingConfigData r100, Map r101, List r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.ecMarketingRitsConfig;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.ecMarketingStorageKeyConfig;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ecMarketingLifecycleFallback;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Map<String, List<String>> component1() {
        return this.ecMarketingRitsConfig;
    }

    public final List<String> component2() {
        return this.ecMarketingStorageKeyConfig;
    }

    public final boolean component3() {
        return this.ecMarketingLifecycleFallback;
    }

    public final ECMarketingConfigData copy(Map<String, ? extends List<String>> r100, List<String> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "ecMarketingRitsConfig");
        Intrinsics.checkNotNullParameter(r101, "ecMarketingStorageKeyConfig");
        return new ECMarketingConfigData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECMarketingConfigData) == false) goto L12;
        ECMarketingConfigData r101 = (ECMarketingConfigData) r100;
        if (Intrinsics.areEqual(this.ecMarketingRitsConfig, r101.ecMarketingRitsConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.ecMarketingStorageKeyConfig, r101.ecMarketingStorageKeyConfig) == true) goto L10;
        return false;
    L10:
        if (this.ecMarketingLifecycleFallback == r101.ecMarketingLifecycleFallback) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Map<String, List<String>> r100 = this.ecMarketingRitsConfig;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.ecMarketingStorageKeyConfig;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.ecMarketingLifecycleFallback;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECMarketingConfigData(ecMarketingRitsConfig=" + this.ecMarketingRitsConfig + ", ecMarketingStorageKeyConfig=" + this.ecMarketingStorageKeyConfig + ", ecMarketingLifecycleFallback=" + this.ecMarketingLifecycleFallback + ")";
    }

    public final boolean getEcMarketingLifecycleFallback() {
        return this.ecMarketingLifecycleFallback;
    }

    public final Map<String, List<String>> getEcMarketingRitsConfig() {
        return this.ecMarketingRitsConfig;
    }

    public final List<String> getEcMarketingStorageKeyConfig() {
        return this.ecMarketingStorageKeyConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECMarketingConfigData(Map<String, ? extends List<String>> r100, List<String> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "ecMarketingRitsConfig");
        Intrinsics.checkNotNullParameter(r101, "ecMarketingStorageKeyConfig");
        this.ecMarketingRitsConfig = r100;
        this.ecMarketingStorageKeyConfig = r101;
        this.ecMarketingLifecycleFallback = r102;
    }
}

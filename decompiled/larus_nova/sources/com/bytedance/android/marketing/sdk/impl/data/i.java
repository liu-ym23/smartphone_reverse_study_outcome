package com.bytedance.android.marketing.sdk.impl.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0005R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/data/i;", "", "planInfo", "Ljava/lang/Object;", "getPlanInfo", "()Ljava/lang/Object;", "", "componentKey", "Ljava/lang/String;", "getComponentKey", "()Ljava/lang/String;", "resourceInfo", "getResourceInfo", "uiInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "trackInfo", "getTrackInfo", "frequencyInfos", "getFrequencyInfos", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("component_key")
    private final String componentKey;

    @SerializedName("frequency_infos")
    private final Object frequencyInfos;

    @SerializedName("plan_info")
    private final Object planInfo;

    @SerializedName("resource_info")
    private final Object resourceInfo;

    @SerializedName("track_info")
    private final Object trackInfo;

    @SerializedName("ui_info")
    private final Object uiInfo;

    public final Map<String, Object> b() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("plan_info", this.planInfo), TuplesKt.to("compnent_key", this.componentKey), TuplesKt.to("resource_info", this.resourceInfo), TuplesKt.to("ui_info", this.uiInfo), TuplesKt.to("track_info", this.trackInfo), TuplesKt.to("frequency_infos", this.frequencyInfos)});
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L18;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.planInfo, r101.planInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentKey, r101.componentKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.resourceInfo, r101.resourceInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uiInfo, r101.uiInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.trackInfo, r101.trackInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.frequencyInfos, r101.frequencyInfos) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Object r100 = this.planInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.componentKey;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.resourceInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.uiInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Object r113 = this.trackInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Object r116 = this.frequencyInfos;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ViewData(planInfo=" + this.planInfo + ", componentKey=" + this.componentKey + ", resourceInfo=" + this.resourceInfo + ", uiInfo=" + this.uiInfo + ", trackInfo=" + this.trackInfo + ", frequencyInfos=" + this.frequencyInfos + ")";
    }

    public i() {
        this.planInfo = null;
        this.componentKey = null;
        this.resourceInfo = null;
        this.uiInfo = null;
        this.trackInfo = null;
        this.frequencyInfos = null;
    }

    public final Object a() {
        return this.uiInfo;
    }
}

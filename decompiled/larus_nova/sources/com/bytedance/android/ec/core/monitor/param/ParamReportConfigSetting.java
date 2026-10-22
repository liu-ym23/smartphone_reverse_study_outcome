package com.bytedance.android.ec.core.monitor.param;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012&\b\u0002\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ'\u0010\u001c\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003Jz\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062&\b\u0002\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R4\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/param/ParamReportConfigSetting;", "Ljava/io/Serializable;", "enable", "", "enableSchemaDiff", "defaultSample", "", "sampleConfigMap", "", "", "tradeBtmList", "", "filterKeys", "(ZZLjava/lang/Float;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V", "getDefaultSample", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEnable", "()Z", "getEnableSchemaDiff", "getFilterKeys", "()Ljava/util/List;", "getSampleConfigMap", "()Ljava/util/Map;", "getTradeBtmList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZZLjava/lang/Float;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Lcom/bytedance/android/ec/core/monitor/param/ParamReportConfigSetting;", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParamReportConfigSetting implements Serializable {

    @SerializedName("default_sample")
    private final Float defaultSample;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_schema_diff")
    private final boolean enableSchemaDiff;

    @SerializedName("filter_keys")
    private final List<String> filterKeys;

    @SerializedName("sample_config_map")
    private final Map<String, Map<String, Float>> sampleConfigMap;

    @SerializedName("trade_btm_list")
    private final List<String> tradeBtmList;

    public ParamReportConfigSetting() {
        this(false, false, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParamReportConfigSetting copy$default(ParamReportConfigSetting r100, boolean r101, boolean r102, Float r103, Map r104, List r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.enableSchemaDiff;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.defaultSample;
    L11:
        Float r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.sampleConfigMap;
    L14:
        Map r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.tradeBtmList;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.filterKeys;
    L20:
        boolean r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final boolean component2() {
        return this.enableSchemaDiff;
    }

    public final Float component3() {
        return this.defaultSample;
    }

    public final Map<String, Map<String, Float>> component4() {
        return this.sampleConfigMap;
    }

    public final List<String> component5() {
        return this.tradeBtmList;
    }

    public final List<String> component6() {
        return this.filterKeys;
    }

    public final ParamReportConfigSetting copy(boolean r100, boolean r110, Float r111, Map<String, ? extends Map<String, Float>> r112, List<String> r113, List<String> r114) {
        return new ParamReportConfigSetting(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ParamReportConfigSetting) == false) goto L18;
        ParamReportConfigSetting r101 = (ParamReportConfigSetting) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.enableSchemaDiff == r101.enableSchemaDiff) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.defaultSample, r101.defaultSample) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sampleConfigMap, r101.sampleConfigMap) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tradeBtmList, r101.tradeBtmList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.filterKeys, r101.filterKeys) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.enableSchemaDiff;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        Float r106 = this.defaultSample;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        Map<String, Map<String, Float>> r110 = this.sampleConfigMap;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.tradeBtmList;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.filterKeys;
        if (r116 == null) goto L25;
        r107 = r116.hashCode();
    L25:
        return r115 + r107;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    public String toString() {
        return "ParamReportConfigSetting(enable=" + this.enable + ", enableSchemaDiff=" + this.enableSchemaDiff + ", defaultSample=" + this.defaultSample + ", sampleConfigMap=" + this.sampleConfigMap + ", tradeBtmList=" + this.tradeBtmList + ", filterKeys=" + this.filterKeys + ")";
    }

    public final Float getDefaultSample() {
        return this.defaultSample;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableSchemaDiff() {
        return this.enableSchemaDiff;
    }

    public final List<String> getFilterKeys() {
        return this.filterKeys;
    }

    public final Map<String, Map<String, Float>> getSampleConfigMap() {
        return this.sampleConfigMap;
    }

    public final List<String> getTradeBtmList() {
        return this.tradeBtmList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ParamReportConfigSetting(boolean r100, boolean r101, Float r102, Map<String, ? extends Map<String, Float>> r103, List<String> r104, List<String> r105) {
        this.enable = r100;
        this.enableSchemaDiff = r101;
        this.defaultSample = r102;
        this.sampleConfigMap = r103;
        this.tradeBtmList = r104;
        this.filterKeys = r105;
    }

    public /* synthetic */ ParamReportConfigSetting(boolean r100, boolean r101, Float r102, Map r103, List r104, List r110, int r111, DefaultConstructorMarker r112) {
        boolean r105 = true;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = true;
    L7:
        if ((r111 & 2) != 0) goto L11;
        r105 = r101;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = Float.valueOf(1.0f);
    L13:
        Float r106 = r102;
        if ((r111 & 8) == 0) goto L16;
        Map r107 = null;
    L18:
        if ((r111 & 16) == 0) goto L20;
        List r108 = null;
    L22:
        if ((r111 & 32) == 0) goto L24;
        r110 = CollectionsKt.listOf(new String[]{"track_client", "track_client_entrance_info", "client_native_params_event_additions"});
    L24:
        this(r113, r105, r106, r107, r108, r110);
        return;
    L20:
        r108 = r104;
        goto L22
    L16:
        r107 = r103;
        goto L18
    L5:
        r113 = r100;
        goto L7
    }
}

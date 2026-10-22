package com.bytedance.android.ec.core.monitor;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0003J\u0088\u0001\u0010(\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\tHÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/PdpMonitorSetting;", "Ljava/io/Serializable;", "actionALogBlockList", "", "", "aLogSwitch", "", "uploadSwitch", "invalidMinute", "", "uploadSample", "", "aptActionMonitorIdList", "aptBtmWhiteList", "sampleConfigMap", "", "(Ljava/util/List;ZZLjava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getALogSwitch", "()Z", "getActionALogBlockList", "()Ljava/util/List;", "getAptActionMonitorIdList", "getAptBtmWhiteList", "getInvalidMinute", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSampleConfigMap", "()Ljava/util/Map;", "getUploadSample", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getUploadSwitch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/List;ZZLjava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)Lcom/bytedance/android/ec/core/monitor/PdpMonitorSetting;", "equals", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpMonitorSetting implements Serializable {

    @SerializedName("alog_switch")
    private final boolean aLogSwitch;

    @SerializedName("action_alog_block_list")
    private final List<String> actionALogBlockList;

    @SerializedName("apt_action_monitor_id_list")
    private final List<String> aptActionMonitorIdList;

    @SerializedName("apt_btm_white_list")
    private final List<String> aptBtmWhiteList;

    @SerializedName("apt_invalid_time")
    private final Integer invalidMinute;

    @SerializedName("sample_config_map")
    private final Map<String, Integer> sampleConfigMap;

    @SerializedName("upload_sample")
    private final Float uploadSample;

    @SerializedName("upload_switch")
    private final boolean uploadSwitch;

    public PdpMonitorSetting() {
        this(null, false, false, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PdpMonitorSetting copy$default(PdpMonitorSetting r100, List r110, boolean r111, boolean r112, Integer r113, Float r114, List r115, List r116, Map r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        List r101 = r100.actionALogBlockList;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = r100.aLogSwitch;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r103 = r100.uploadSwitch;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = r100.invalidMinute;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Float r105 = r100.uploadSample;
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = r100.aptActionMonitorIdList;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = r100.aptBtmWhiteList;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Map r108 = r100.sampleConfigMap;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final List<String> component1() {
        return this.actionALogBlockList;
    }

    public final boolean component2() {
        return this.aLogSwitch;
    }

    public final boolean component3() {
        return this.uploadSwitch;
    }

    public final Integer component4() {
        return this.invalidMinute;
    }

    public final Float component5() {
        return this.uploadSample;
    }

    public final List<String> component6() {
        return this.aptActionMonitorIdList;
    }

    public final List<String> component7() {
        return this.aptBtmWhiteList;
    }

    public final Map<String, Integer> component8() {
        return this.sampleConfigMap;
    }

    public final PdpMonitorSetting copy(List<String> r110, boolean r111, boolean r112, Integer r113, Float r114, List<String> r115, List<String> r116, Map<String, Integer> r117) {
        return new PdpMonitorSetting(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PdpMonitorSetting) == false) goto L22;
        PdpMonitorSetting r101 = (PdpMonitorSetting) r100;
        if (Intrinsics.areEqual(this.actionALogBlockList, r101.actionALogBlockList) == true) goto L8;
        return false;
    L8:
        if (this.aLogSwitch == r101.aLogSwitch) goto L10;
        return false;
    L10:
        if (this.uploadSwitch == r101.uploadSwitch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.invalidMinute, r101.invalidMinute) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.uploadSample, r101.uploadSample) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.aptActionMonitorIdList, r101.aptActionMonitorIdList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.aptBtmWhiteList, r101.aptBtmWhiteList) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.sampleConfigMap, r101.sampleConfigMap) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<String> r100 = this.actionALogBlockList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.aLogSwitch;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.uploadSwitch;
        if (r108 == true) goto L13;
        r105 = r108;
    L13:
        int r109 = (r107 + r105) * 31;
        Integer r110 = this.invalidMinute;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.uploadSample;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.aptActionMonitorIdList;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        List<String> r119 = this.aptBtmWhiteList;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        Map<String, Integer> r122 = this.sampleConfigMap;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PdpMonitorSetting(actionALogBlockList=" + this.actionALogBlockList + ", aLogSwitch=" + this.aLogSwitch + ", uploadSwitch=" + this.uploadSwitch + ", invalidMinute=" + this.invalidMinute + ", uploadSample=" + this.uploadSample + ", aptActionMonitorIdList=" + this.aptActionMonitorIdList + ", aptBtmWhiteList=" + this.aptBtmWhiteList + ", sampleConfigMap=" + this.sampleConfigMap + ")";
    }

    public final boolean getALogSwitch() {
        return this.aLogSwitch;
    }

    public final List<String> getActionALogBlockList() {
        return this.actionALogBlockList;
    }

    public final List<String> getAptActionMonitorIdList() {
        return this.aptActionMonitorIdList;
    }

    public final List<String> getAptBtmWhiteList() {
        return this.aptBtmWhiteList;
    }

    public final Integer getInvalidMinute() {
        return this.invalidMinute;
    }

    public final Map<String, Integer> getSampleConfigMap() {
        return this.sampleConfigMap;
    }

    public final Float getUploadSample() {
        return this.uploadSample;
    }

    public final boolean getUploadSwitch() {
        return this.uploadSwitch;
    }

    public PdpMonitorSetting(List<String> r100, boolean r101, boolean r102, Integer r103, Float r104, List<String> r105, List<String> r106, Map<String, Integer> r107) {
        this.actionALogBlockList = r100;
        this.aLogSwitch = r101;
        this.uploadSwitch = r102;
        this.invalidMinute = r103;
        this.uploadSample = r104;
        this.aptActionMonitorIdList = r105;
        this.aptBtmWhiteList = r106;
        this.sampleConfigMap = r107;
    }

    public /* synthetic */ PdpMonitorSetting(List r110, boolean r111, boolean r112, Integer r113, Float r114, List r115, List r116, Map r117, int r118, DefaultConstructorMarker r119) {
        Map r100 = null;
        if ((r118 & 1) == 0) goto L5;
        List r101 = null;
    L6:
        boolean r102 = false;
        if ((r118 & 2) == 0) goto L9;
        boolean r103 = false;
    L11:
        if ((r118 & 4) != 0) goto L15;
        r102 = r112;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Float r105 = Float.valueOf(0.0f);
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r103, r102, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}

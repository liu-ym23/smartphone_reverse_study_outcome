package com.bytedance.android.live.soloktv.record;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/soloktv/record/b;", "", "Lcom/google/gson/JsonObject;", "admServerCfg", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "", "admType", "Ljava/lang/Integer;", "getAdmType", "()Ljava/lang/Integer;", "", "qId", "Ljava/lang/String;", "getQId", "()Ljava/lang/String;", "supportHardwareEarMonitor", "b", "", "Lcom/bytedance/android/live/soloktv/record/a;", "hardwareAudioEffectTable", "Ljava/util/Map;", "getHardwareAudioEffectTable", "()Ljava/util/Map;", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("adm_server_cfg")
    private final JsonObject admServerCfg;

    @SerializedName("adm_type")
    private final Integer admType;

    @SerializedName("adm_hardware_audio_effect_table")
    private final Map<String, a> hardwareAudioEffectTable;

    @SerializedName("qId")
    private final String qId;

    @SerializedName("adm_support_hardware_ear_monitor")
    private final Integer supportHardwareEarMonitor;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.admServerCfg, r101.admServerCfg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.admType, r101.admType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.qId, r101.qId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.supportHardwareEarMonitor, r101.supportHardwareEarMonitor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.hardwareAudioEffectTable, r101.hardwareAudioEffectTable) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        JsonObject r100 = this.admServerCfg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.admType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.qId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.supportHardwareEarMonitor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, a> r113 = this.hardwareAudioEffectTable;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "PushBase(admServerCfg=" + this.admServerCfg + ", admType=" + this.admType + ", qId=" + this.qId + ", supportHardwareEarMonitor=" + this.supportHardwareEarMonitor + ", hardwareAudioEffectTable=" + this.hardwareAudioEffectTable + ")";
    }

    public final JsonObject a() {
        return this.admServerCfg;
    }

    public final Integer b() {
        return this.supportHardwareEarMonitor;
    }
}

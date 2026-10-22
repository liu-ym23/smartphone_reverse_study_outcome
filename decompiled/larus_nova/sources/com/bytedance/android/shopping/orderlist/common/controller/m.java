package com.bytedance.android.shopping.orderlist.common.controller;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR.\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/controller/m;", "", "", "", "schemeBusinessParams", "Ljava/util/Map;", "getSchemeBusinessParams", "()Ljava/util/Map;", "uid", "Ljava/lang/String;", "getUid", "()Ljava/lang/String;", "schemeParams", "getSchemeParams", "", "saveTime", "D", "getSaveTime", "()D", "", "validTime", "I", "getValidTime", "()I", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "response", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "getResponse", "()Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "", "preloadConfig", "getPreloadConfig", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("preload_config")
    private final Map<String, List<String>> preloadConfig;

    @SerializedName("response")
    private final com.bytedance.kmp.ec.yata.common.protocol.data.e response;

    @SerializedName("save_time")
    private final double saveTime;

    @SerializedName("schema_business_params")
    private final Map<String, String> schemeBusinessParams;

    @SerializedName("schema_params")
    private final Map<String, String> schemeParams;

    @SerializedName("uid")
    private final String uid;

    @SerializedName("valid_time")
    private final int validTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L20;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.schemeBusinessParams, r101.schemeBusinessParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r101.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schemeParams, r101.schemeParams) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.saveTime, r101.saveTime) == 0) goto L14;
        return false;
    L14:
        if (this.validTime == r101.validTime) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.response, r101.response) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadConfig, r101.preloadConfig) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.schemeBusinessParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.uid;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.schemeParams;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = Double.doubleToLongBits(this.saveTime);
        int r111 = (((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.validTime) * 31;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r112 = this.response;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        Map<String, List<String>> r115 = this.preloadConfig;
        if (r115 == null) goto L22;
        r101 = r115.hashCode();
    L22:
        return r114 + r101;
    L17:
        r113 = 0;
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
        return "OrderListH5PreloadResponse(schemeBusinessParams=" + this.schemeBusinessParams + ", uid=" + this.uid + ", schemeParams=" + this.schemeParams + ", saveTime=" + this.saveTime + ", validTime=" + this.validTime + ", response=" + this.response + ", preloadConfig=" + this.preloadConfig + ")";
    }

    public m() {
        this.schemeBusinessParams = null;
        this.uid = null;
        this.schemeParams = null;
        this.saveTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.validTime = 0;
        this.response = null;
        this.preloadConfig = null;
    }
}

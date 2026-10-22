package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinInfoData;", "", "config", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfig;", "configHashVal", "", "(Lcom/bytedance/android/shopping/api/mall/model/SkinConfig;Ljava/lang/String;)V", "getConfig", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfig;", "getConfigHashVal", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinInfoData {

    @SerializedName("config")
    private final SkinConfig config;

    @SerializedName("configHashVal")
    private final String configHashVal;

    /* JADX WARN: Multi-variable type inference failed */
    public SkinInfoData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SkinInfoData copy$default(SkinInfoData r100, SkinConfig r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.config;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.configHashVal;
    L9:
        return r100.copy(r101, r102);
    }

    public final SkinConfig component1() {
        return this.config;
    }

    public final String component2() {
        return this.configHashVal;
    }

    public final SkinInfoData copy(SkinConfig r100, String r101) {
        return new SkinInfoData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkinInfoData) == false) goto L10;
        SkinInfoData r101 = (SkinInfoData) r100;
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.configHashVal, r101.configHashVal) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        SkinConfig r100 = this.config;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.configHashVal;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkinInfoData(config=" + this.config + ", configHashVal=" + this.configHashVal + ")";
    }

    public final SkinConfig getConfig() {
        return this.config;
    }

    public final String getConfigHashVal() {
        return this.configHashVal;
    }

    public SkinInfoData(SkinConfig r100, String r101) {
        this.config = r100;
        this.configHashVal = r101;
    }

    public /* synthetic */ SkinInfoData(SkinConfig r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}

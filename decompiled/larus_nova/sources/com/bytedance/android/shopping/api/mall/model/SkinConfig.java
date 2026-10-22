package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SkinConfig;", "", "light", "Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle;", "dark", "extra", "", "(Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle;Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle;Ljava/lang/String;)V", "getDark", "()Lcom/bytedance/android/shopping/api/mall/model/SkinConfigStyle;", "getExtra", "()Ljava/lang/String;", "getLight", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkinConfig {

    @SerializedName("dark")
    private final SkinConfigStyle dark;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("light")
    private final SkinConfigStyle light;

    public SkinConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ SkinConfig copy$default(SkinConfig r100, SkinConfigStyle r101, SkinConfigStyle r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.light;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.dark;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final SkinConfigStyle component1() {
        return this.light;
    }

    public final SkinConfigStyle component2() {
        return this.dark;
    }

    public final String component3() {
        return this.extra;
    }

    public final SkinConfig copy(SkinConfigStyle r100, SkinConfigStyle r101, String r102) {
        return new SkinConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkinConfig) == false) goto L12;
        SkinConfig r101 = (SkinConfig) r100;
        if (Intrinsics.areEqual(this.light, r101.light) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dark, r101.dark) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        SkinConfigStyle r100 = this.light;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        SkinConfigStyle r104 = this.dark;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.extra;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkinConfig(light=" + this.light + ", dark=" + this.dark + ", extra=" + this.extra + ")";
    }

    public final SkinConfigStyle getDark() {
        return this.dark;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final SkinConfigStyle getLight() {
        return this.light;
    }

    public SkinConfig(SkinConfigStyle r100, SkinConfigStyle r101, String r102) {
        this.light = r100;
        this.dark = r101;
        this.extra = r102;
    }

    public /* synthetic */ SkinConfig(SkinConfigStyle r100, SkinConfigStyle r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}

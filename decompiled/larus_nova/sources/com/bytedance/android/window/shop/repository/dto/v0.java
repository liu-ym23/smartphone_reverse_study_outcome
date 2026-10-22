package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/v0;", "", "", "lynxConfig", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setLynxConfig", "(Ljava/lang/String;)V", "lynxData", "b", "setLynxData", "Lcom/bytedance/android/window/shop/repository/dto/w0;", "lynxSsr", "Lcom/bytedance/android/window/shop/repository/dto/w0;", "d", "()Lcom/bytedance/android/window/shop/repository/dto/w0;", "setLynxSsr", "(Lcom/bytedance/android/window/shop/repository/dto/w0;)V", "", "lynxItemType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setLynxItemType", "(Ljava/lang/Integer;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 {

    @SerializedName("lynx_config")
    private String lynxConfig;

    @SerializedName("lynx_data")
    private String lynxData;

    @SerializedName("lynx_item_type")
    private Integer lynxItemType;

    @SerializedName("lynx_ssr")
    private w0 lynxSsr;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v0) == false) goto L14;
        v0 r101 = (v0) r100;
        if (Intrinsics.areEqual(this.lynxConfig, r101.lynxConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.lynxData, r101.lynxData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxSsr, r101.lynxSsr) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxItemType, r101.lynxItemType) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.lynxConfig;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.lynxData;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        w0 r107 = this.lynxSsr;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.lynxItemType;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "WindowLynxItemDTO(lynxConfig=" + this.lynxConfig + ", lynxData=" + this.lynxData + ", lynxSsr=" + this.lynxSsr + ", lynxItemType=" + this.lynxItemType + ")";
    }

    public final boolean e() {
        String r100 = this.lynxConfig;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(r100)) != true) goto L7;
        return true;
    }

    public v0() {
        this.lynxConfig = null;
        this.lynxData = null;
        this.lynxSsr = null;
        this.lynxItemType = null;
    }

    public final String a() {
        return this.lynxConfig;
    }

    public final String b() {
        return this.lynxData;
    }

    public final Integer c() {
        return this.lynxItemType;
    }

    public final w0 d() {
        return this.lynxSsr;
    }
}

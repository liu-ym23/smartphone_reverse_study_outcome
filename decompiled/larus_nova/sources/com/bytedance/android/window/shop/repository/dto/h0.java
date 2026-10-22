package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/h0;", "", "", "Lcom/bytedance/android/window/shop/repository/dto/r0;", "impressionWords", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "windowDetailUrl", "Ljava/lang/String;", "getWindowDetailUrl", "()Ljava/lang/String;", "Lcom/bytedance/android/window/shop/repository/dto/x;", "fansInfo", "Lcom/bytedance/android/window/shop/repository/dto/x;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/window/shop/repository/dto/x;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName("fans_info")
    private final x fansInfo;

    @SerializedName("impression_words")
    private final List<r0> impressionWords;

    @SerializedName("detail_url")
    private final String windowDetailUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == false) goto L12;
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.impressionWords, r101.impressionWords) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.windowDetailUrl, r101.windowDetailUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.fansInfo, r101.fansInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<r0> r100 = this.impressionWords;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.windowDetailUrl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        x r107 = this.fansInfo;
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

    public final String toString() {
        return "WindowHeaderEveryoneTalkDTO(impressionWords=" + this.impressionWords + ", windowDetailUrl=" + this.windowDetailUrl + ", fansInfo=" + this.fansInfo + ")";
    }

    public h0() {
        this.impressionWords = null;
        this.windowDetailUrl = null;
        this.fansInfo = null;
    }

    public final x a() {
        return this.fansInfo;
    }

    public final List<r0> b() {
        return this.impressionWords;
    }
}

package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/n0;", "", "", "liveSellNum", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "", "buySchema", "Ljava/lang/String;", "getBuySchema", "()Ljava/lang/String;", "Lcom/bytedance/android/window/shop/repository/dto/g;", "replayStruct", "Lcom/bytedance/android/window/shop/repository/dto/g;", "b", "()Lcom/bytedance/android/window/shop/repository/dto/g;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SubDTO
    public final transient WindowV2ProductItemDTO f189423a;

    @SerializedName("buy_scheme")
    private final String buySchema;

    @SerializedName("live_sell_num")
    private final Long liveSellNum;

    @SerializedName("replay_struct")
    private final g replayStruct;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L14;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f189423a, r101.f189423a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveSellNum, r101.liveSellNum) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.buySchema, r101.buySchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replayStruct, r101.replayStruct) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        WindowV2ProductItemDTO r100 = this.f189423a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.liveSellNum;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.buySchema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        g r110 = this.replayStruct;
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
        return "WindowHotLiveRecommendProductDTO(productDTO=" + this.f189423a + ", liveSellNum=" + this.liveSellNum + ", buySchema=" + this.buySchema + ", replayStruct=" + this.replayStruct + ")";
    }

    public n0() {
        this.f189423a = null;
        this.liveSellNum = null;
        this.buySchema = null;
        this.replayStruct = null;
    }

    public final Long a() {
        return this.liveSellNum;
    }

    public final g b() {
        return this.replayStruct;
    }
}

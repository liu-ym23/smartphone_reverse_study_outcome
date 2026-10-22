package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/w;", "", "", "hasMore", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "", EffectConfiguration.KEY_CURSOR, "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "nextApi", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "commonPassThrough", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("common_pass_through")
    private final String commonPassThrough;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private final Integer cursor;

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("next_api")
    private final String nextApi;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w) == false) goto L14;
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cursor, r101.cursor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.nextApi, r101.nextApi) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.commonPassThrough, r101.commonPassThrough) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.hasMore;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cursor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nextApi;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.commonPassThrough;
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
        return "WindowExtentionsControlInfoDTO(hasMore=" + this.hasMore + ", cursor=" + this.cursor + ", nextApi=" + this.nextApi + ", commonPassThrough=" + this.commonPassThrough + ")";
    }

    public w() {
        this.hasMore = Boolean.FALSE;
        this.cursor = null;
        this.nextApi = null;
        this.commonPassThrough = null;
    }

    public final String a() {
        return this.commonPassThrough;
    }

    public final Integer b() {
        return this.cursor;
    }

    public final Boolean c() {
        return this.hasMore;
    }

    public final String d() {
        return this.nextApi;
    }
}

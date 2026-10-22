package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/util/BtmInfo;", "", "c", "", "d", "w", "btmInfo", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;)V", "getBtmInfo", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;", "setBtmInfo", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/BtmData;)V", "getC", "()Ljava/lang/String;", "setC", "(Ljava/lang/String;)V", "getD", "setD", "getW", "setW", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BtmInfo {
    private BtmData btmInfo;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f177877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f177878d;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f177879w;

    public BtmInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ BtmInfo copy$default(BtmInfo r100, String r101, String r102, String r103, BtmData r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f177877c;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f177878d;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f177879w;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.btmInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f177877c;
    }

    public final String component2() {
        return this.f177878d;
    }

    public final String component3() {
        return this.f177879w;
    }

    public final BtmData component4() {
        return this.btmInfo;
    }

    public final BtmInfo copy(String r100, String r101, String r102, BtmData r103) {
        return new BtmInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BtmInfo) == false) goto L14;
        BtmInfo r101 = (BtmInfo) r100;
        if (Intrinsics.areEqual(this.f177877c, r101.f177877c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f177878d, r101.f177878d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f177879w, r101.f177879w) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.btmInfo, r101.btmInfo) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.f177877c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f177878d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f177879w;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        BtmData r110 = this.btmInfo;
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

    public String toString() {
        return "BtmInfo(c=" + this.f177877c + ", d=" + this.f177878d + ", w=" + this.f177879w + ", btmInfo=" + this.btmInfo + ")";
    }

    public final BtmData getBtmInfo() {
        return this.btmInfo;
    }

    public final String getC() {
        return this.f177877c;
    }

    public final String getD() {
        return this.f177878d;
    }

    public final String getW() {
        return this.f177879w;
    }

    public final void setBtmInfo(BtmData r100) {
        this.btmInfo = r100;
    }

    public final void setC(String r100) {
        this.f177877c = r100;
    }

    public final void setD(String r100) {
        this.f177878d = r100;
    }

    public final void setW(String r100) {
        this.f177879w = r100;
    }

    public BtmInfo(String r100, String r101, String r102, BtmData r103) {
        this.f177877c = r100;
        this.f177878d = r101;
        this.f177879w = r102;
        this.btmInfo = r103;
    }

    public /* synthetic */ BtmInfo(String r100, String r101, String r102, BtmData r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}

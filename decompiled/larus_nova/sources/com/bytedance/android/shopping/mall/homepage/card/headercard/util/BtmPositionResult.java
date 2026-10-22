package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Bcm;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/util/BtmPositionResult;", "", "btm", "", "extra", "", "bcm", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;)V", "getBcm", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;", "setBcm", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Bcm;)V", "getBtm", "()Ljava/lang/String;", "setBtm", "(Ljava/lang/String;)V", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BtmPositionResult {
    private Bcm bcm;
    private String btm;
    private Map<String, ? extends Object> extra;

    public BtmPositionResult() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BtmPositionResult copy$default(BtmPositionResult r100, String r101, Map r102, Bcm r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.btm;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.extra;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.bcm;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.btm;
    }

    public final Map<String, Object> component2() {
        return this.extra;
    }

    public final Bcm component3() {
        return this.bcm;
    }

    public final BtmPositionResult copy(String r100, Map<String, ? extends Object> r101, Bcm r102) {
        return new BtmPositionResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BtmPositionResult) == false) goto L12;
        BtmPositionResult r101 = (BtmPositionResult) r100;
        if (Intrinsics.areEqual(this.btm, r101.btm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bcm, r101.bcm) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.btm;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, ? extends Object> r104 = this.extra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Bcm r107 = this.bcm;
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
        return "BtmPositionResult(btm=" + this.btm + ", extra=" + this.extra + ", bcm=" + this.bcm + ")";
    }

    public final Bcm getBcm() {
        return this.bcm;
    }

    public final String getBtm() {
        return this.btm;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final void setBcm(Bcm r100) {
        this.bcm = r100;
    }

    public final void setBtm(String r100) {
        this.btm = r100;
    }

    public final void setExtra(Map<String, ? extends Object> r100) {
        this.extra = r100;
    }

    public BtmPositionResult(String r100, Map<String, ? extends Object> r101, Bcm r102) {
        this.btm = r100;
        this.extra = r101;
        this.bcm = r102;
    }

    public /* synthetic */ BtmPositionResult(String r100, Map r101, Bcm r102, int r103, DefaultConstructorMarker r104) {
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

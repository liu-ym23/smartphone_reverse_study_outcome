package com.android.ttcjpaysdk.thirdparty.data.unifypay;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/CJUnifyPayTradeInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "tradeAmount", "", "payAmount", "outTradeNo", "", "extension", "tradeNo", "tradeName", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "getOutTradeNo", "getPayAmount", "()J", "getTradeAmount", "getTradeName", "getTradeNo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayTradeInfo implements CJPayObject {
    private final String extension;
    private final String outTradeNo;
    private final long payAmount;
    private final long tradeAmount;
    private final String tradeName;
    private final String tradeNo;

    public CJUnifyPayTradeInfo() {
        this(0, 0, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CJUnifyPayTradeInfo copy$default(CJUnifyPayTradeInfo r100, long r110, long r111, String r112, String r113, String r114, String r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        long r101 = r100.tradeAmount;
    L7:
        if ((r116 & 2) == 0) goto L9;
        long r102 = r100.payAmount;
    L11:
        if ((r116 & 4) == 0) goto L13;
        String r103 = r100.outTradeNo;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.extension;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = r100.tradeNo;
    L23:
        if ((r116 & 32) == 0) goto L25;
        String r106 = r100.tradeName;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final long component1() {
        return this.tradeAmount;
    }

    public final long component2() {
        return this.payAmount;
    }

    public final String component3() {
        return this.outTradeNo;
    }

    public final String component4() {
        return this.extension;
    }

    public final String component5() {
        return this.tradeNo;
    }

    public final String component6() {
        return this.tradeName;
    }

    public final CJUnifyPayTradeInfo copy(long r110, long r111, String r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r112, "outTradeNo");
        Intrinsics.checkNotNullParameter(r113, "extension");
        Intrinsics.checkNotNullParameter(r114, "tradeNo");
        Intrinsics.checkNotNullParameter(r115, "tradeName");
        return new CJUnifyPayTradeInfo(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJUnifyPayTradeInfo) == true) goto L8;
        return false;
    L8:
        CJUnifyPayTradeInfo r101 = (CJUnifyPayTradeInfo) r100;
        if (this.tradeAmount == r101.tradeAmount) goto L12;
        return false;
    L12:
        if (this.payAmount == r101.payAmount) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.outTradeNo, r101.outTradeNo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extension, r101.extension) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tradeNo, r101.tradeNo) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.tradeName, r101.tradeName) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        long r100 = this.tradeAmount;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.payAmount;
        return ((((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.outTradeNo.hashCode()) * 31) + this.extension.hashCode()) * 31) + this.tradeNo.hashCode()) * 31) + this.tradeName.hashCode();
    }

    public String toString() {
        return "CJUnifyPayTradeInfo(tradeAmount=" + this.tradeAmount + ", payAmount=" + this.payAmount + ", outTradeNo=" + this.outTradeNo + ", extension=" + this.extension + ", tradeNo=" + this.tradeNo + ", tradeName=" + this.tradeName + ')';
    }

    public final String getExtension() {
        return this.extension;
    }

    public final String getOutTradeNo() {
        return this.outTradeNo;
    }

    public final long getPayAmount() {
        return this.payAmount;
    }

    public final long getTradeAmount() {
        return this.tradeAmount;
    }

    public final String getTradeName() {
        return this.tradeName;
    }

    public final String getTradeNo() {
        return this.tradeNo;
    }

    public CJUnifyPayTradeInfo(long r100, long r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r102, "outTradeNo");
        Intrinsics.checkNotNullParameter(r103, "extension");
        Intrinsics.checkNotNullParameter(r104, "tradeNo");
        Intrinsics.checkNotNullParameter(r105, "tradeName");
        this.tradeAmount = r100;
        this.payAmount = r101;
        this.outTradeNo = r102;
        this.extension = r103;
        this.tradeNo = r104;
        this.tradeName = r105;
    }

    public /* synthetic */ CJUnifyPayTradeInfo(long r110, long r111, String r112, String r113, String r114, String r115, int r116, DefaultConstructorMarker r117) {
        long r100 = -1;
        if ((r116 & 1) == 0) goto L5;
        long r101 = -1;
    L7:
        if ((r116 & 2) != 0) goto L10;
        r100 = r111;
    L10:
        String r102 = "";
        if ((r116 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r116 & 32) != 0) goto L26;
        r102 = r115;
    L26:
        this(r101, r100, r103, r104, r105, r102);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L5:
        r101 = r110;
        goto L7
    }
}

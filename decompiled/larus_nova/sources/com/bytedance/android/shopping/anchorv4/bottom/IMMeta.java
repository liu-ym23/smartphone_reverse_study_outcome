package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/IMMeta;", "Ljava/io/Serializable;", "imUrl", "", "promotionSource", "", "sourcePage", "enterMethod", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "getImUrl", "getPromotionSource", "()J", "setPromotionSource", "(J)V", "getSourcePage", "setSourcePage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "fillCommonMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMMeta implements Serializable {
    private String enterMethod;

    @SerializedName("im_url")
    private final String imUrl;
    private long promotionSource;
    private String sourcePage;

    public IMMeta() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ IMMeta copy$default(IMMeta r100, String r101, long r102, String r103, String r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.imUrl;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.promotionSource;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.sourcePage;
    L11:
        String r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.enterMethod;
    L14:
        String r107 = r101;
        return r100.copy(r107, r106, r111, r104);
    }

    public final String component1() {
        return this.imUrl;
    }

    public final long component2() {
        return this.promotionSource;
    }

    public final String component3() {
        return this.sourcePage;
    }

    public final String component4() {
        return this.enterMethod;
    }

    public final IMMeta copy(String r100, long r101, String r110, String r111) {
        return new IMMeta(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IMMeta) == false) goto L14;
        IMMeta r101 = (IMMeta) r100;
        if (Intrinsics.areEqual(this.imUrl, r101.imUrl) == true) goto L8;
        return false;
    L8:
        if (this.promotionSource == r101.promotionSource) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.imUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.promotionSource;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.sourcePage;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.enterMethod;
        if (r108 == null) goto L14;
        r101 = r108.hashCode();
    L14:
        return r107 + r101;
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "IMMeta(imUrl=" + this.imUrl + ", promotionSource=" + this.promotionSource + ", sourcePage=" + this.sourcePage + ", enterMethod=" + this.enterMethod + ")";
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getImUrl() {
        return this.imUrl;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final IMMeta fillCommonMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        Long r102 = Long.valueOf(r100.getPromotionSource());
    L6:
        this.promotionSource = com.bytedance.android.shopping.extensions.k.h(r102);
        if (r100 == null) goto L9;
        String r103 = r100.getSourcePage();
    L10:
        this.sourcePage = r103;
        if (r100 == null) goto L13;
        r101 = r100.getEnterMethod();
    L13:
        this.enterMethod = r101;
        return this;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setPromotionSource(long r100) {
        this.promotionSource = r100;
    }

    public final void setSourcePage(String r100) {
        this.sourcePage = r100;
    }

    public IMMeta(String r100, long r101, String r102, String r103) {
        this.imUrl = r100;
        this.promotionSource = r101;
        this.sourcePage = r102;
        this.enterMethod = r103;
    }

    public /* synthetic */ IMMeta(String r100, long r101, String r102, String r103, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        long r104 = r101;
        if ((r110 & 4) == 0) goto L12;
        String r105 = null;
    L14:
        if ((r110 & 8) == 0) goto L16;
        String r113 = null;
    L17:
        this(r112, r104, r105, r113);
        return;
    L16:
        r113 = r103;
        goto L17
    L12:
        r105 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}

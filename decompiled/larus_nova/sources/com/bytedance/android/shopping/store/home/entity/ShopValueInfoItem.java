package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.crash.dumper.Scraps;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001)BC\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003JE\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001a¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ShopValueInfoItem;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component4", "component5", "numberText", "suffix", SocialConstants.PARAM_APP_DESC, "icon", "url", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getNumberText", "()Ljava/lang/String;", "setNumberText", "(Ljava/lang/String;)V", "getSuffix", "setSuffix", "getDesc", "setDesc", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getUrl", "setUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopValueInfoItem implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 2;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    @SerializedName("icon")
    private ECUrlModel icon;

    @SerializedName("number_text")
    private String numberText;

    @SerializedName(Scraps.INNER_UNIT)
    private String suffix;

    @SerializedName("url")
    private String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShopValueInfoItem() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ShopValueInfoItem copy$default(ShopValueInfoItem r100, String r101, String r102, String r103, ECUrlModel r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.numberText;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.suffix;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.desc;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.icon;
    L14:
        ECUrlModel r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.url;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.numberText;
    }

    public final String component2() {
        return this.suffix;
    }

    public final String component3() {
        return this.desc;
    }

    public final ECUrlModel component4() {
        return this.icon;
    }

    public final String component5() {
        return this.url;
    }

    public final ShopValueInfoItem copy(String r100, String r101, String r110, ECUrlModel r111, String r112) {
        return new ShopValueInfoItem(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShopValueInfoItem) == false) goto L16;
        ShopValueInfoItem r101 = (ShopValueInfoItem) r100;
        if (Intrinsics.areEqual(this.numberText, r101.numberText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.numberText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.suffix;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.desc;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECUrlModel r110 = this.icon;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.url;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "ShopValueInfoItem(numberText=" + this.numberText + ", suffix=" + this.suffix + ", desc=" + this.desc + ", icon=" + this.icon + ", url=" + this.url + ")";
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getNumberText() {
        return this.numberText;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setDesc(String r100) {
        this.desc = r100;
    }

    public final void setIcon(ECUrlModel r100) {
        this.icon = r100;
    }

    public final void setNumberText(String r100) {
        this.numberText = r100;
    }

    public final void setSuffix(String r100) {
        this.suffix = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public ShopValueInfoItem(String r100, String r101, String r102, ECUrlModel r103, String r104) {
        this.numberText = r100;
        this.suffix = r101;
        this.desc = r102;
        this.icon = r103;
        this.url = r104;
    }

    public /* synthetic */ ShopValueInfoItem(String r100, String r101, String r102, ECUrlModel r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        ECUrlModel r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}

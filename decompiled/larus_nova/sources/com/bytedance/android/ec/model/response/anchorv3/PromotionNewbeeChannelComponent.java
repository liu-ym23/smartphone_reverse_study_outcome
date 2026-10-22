package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'BM\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\n\u001a\u00020\tHÆ\u0003JO\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\t\u0010\u0012\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0013\u001a\u00020\tHÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionNewbeeChannelComponent;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component2", "component3", "component4", "component5", "", "component6", "url", "icon", SocialConstants.PARAM_APP_DESC, "descColor", "backgroundImage", "location", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getDesc", "getDescColor", "getBackgroundImage", "I", "getLocation", "()I", "<init>", "(Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionNewbeeChannelComponent implements Serializable {
    public static final a Companion = null;
    public static final int LOCATION_ABOVE_DETAIL = 2;
    public static final int LOCATION_ABOVE_GUESSULIKE = 3;
    public static final int LOCATION_BELOW_INSTALLMENT = 1;

    @SerializedName("bg_pic")
    private final ECUrlModel backgroundImage;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("desc_color")
    private final String descColor;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("location")
    private final int location;

    @SerializedName("url")
    private final String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionNewbeeChannelComponent() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ PromotionNewbeeChannelComponent copy$default(PromotionNewbeeChannelComponent r100, String r101, ECUrlModel r102, String r103, String r104, ECUrlModel r105, int r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.icon;
    L8:
        ECUrlModel r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.desc;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.descColor;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.backgroundImage;
    L17:
        ECUrlModel r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.location;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.url;
    }

    public final ECUrlModel component2() {
        return this.icon;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.descColor;
    }

    public final ECUrlModel component5() {
        return this.backgroundImage;
    }

    public final int component6() {
        return this.location;
    }

    public final PromotionNewbeeChannelComponent copy(String r100, ECUrlModel r110, String r111, String r112, ECUrlModel r113, int r114) {
        return new PromotionNewbeeChannelComponent(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionNewbeeChannelComponent) == false) goto L18;
        PromotionNewbeeChannelComponent r101 = (PromotionNewbeeChannelComponent) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.desc, r101.desc) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.descColor, r101.descColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.backgroundImage, r101.backgroundImage) == true) goto L16;
        return false;
    L16:
        if (this.location == r101.location) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.icon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.desc;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.descColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.backgroundImage;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((r112 + r101) * 31) + this.location;
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
        return "PromotionNewbeeChannelComponent(url=" + this.url + ", icon=" + this.icon + ", desc=" + this.desc + ", descColor=" + this.descColor + ", backgroundImage=" + this.backgroundImage + ", location=" + this.location + ")";
    }

    public final ECUrlModel getBackgroundImage() {
        return this.backgroundImage;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescColor() {
        return this.descColor;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final int getLocation() {
        return this.location;
    }

    public final String getUrl() {
        return this.url;
    }

    public PromotionNewbeeChannelComponent(String r100, ECUrlModel r101, String r102, String r103, ECUrlModel r104, int r105) {
        this.url = r100;
        this.icon = r101;
        this.desc = r102;
        this.descColor = r103;
        this.backgroundImage = r104;
        this.location = r105;
    }

    public /* synthetic */ PromotionNewbeeChannelComponent(String r100, ECUrlModel r101, String r102, String r103, ECUrlModel r104, int r110, int r111, DefaultConstructorMarker r112) {
        ECUrlModel r105 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        ECUrlModel r106 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r108 = null;
    L19:
        if ((r111 & 16) != 0) goto L23;
        r105 = r104;
    L23:
        if ((r111 & 32) == 0) goto L25;
        int r114 = 0;
    L26:
        this(r113, r106, r107, r108, r105, r114);
        return;
    L25:
        r114 = r110;
        goto L26
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}

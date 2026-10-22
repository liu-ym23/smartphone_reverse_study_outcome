package com.bytedance.android.ec.model.response.anchorv3;

import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010\u0007R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\u0007R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u001c8\u0006X\u0087D¢\u0006\f\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 ¨\u00066"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;", "Ljava/io/Serializable;", "", "getOrderUrl", "extra", "Ljava/lang/String;", "getExtra", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "links", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "getLinks", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductLink;", "text", "getText", n.KEY_SUB_TEXT, "getSubText", "", "couponAmount", "Ljava/lang/Integer;", "getCouponAmount", "()Ljava/lang/Integer;", "orderStatus", "getOrderStatus", "buriedPointType", "getBuriedPointType", "setBuriedPointType", "(Ljava/lang/Integer;)V", "", "invalidVersion", "Z", "getInvalidVersion", "()Z", "setInvalidVersion", "(Z)V", "versionToast", "getVersionToast", "setVersionToast", "(Ljava/lang/String;)V", "noStockTip", "getNoStockTip", "toast", "getToast", "Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "buttonTips", "Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "getButtonTips", "()Lcom/bytedance/android/ec/model/response/anchorv3/ButtonTipsStruct;", "grayButton", "getGrayButton", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductButtonStruct implements Serializable {
    public static final int BUY_POINT_TYPE_0 = 0;
    public static final int BUY_POINT_TYPE_1 = 1;
    public static final a Companion = null;

    @SerializedName("buried_point_type")
    private Integer buriedPointType;

    @SerializedName("button_tips")
    private final ButtonTipsStruct buttonTips;

    @SerializedName("coupon_amount")
    private final Integer couponAmount;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("gray_button")
    private final boolean grayButton;

    @SerializedName("invalid_version")
    private boolean invalidVersion;

    @SerializedName("links")
    private final PromotionProductLink links;

    @SerializedName("tips")
    private final String noStockTip;

    @SerializedName(EventConstants.ExtraJson.KEY_ORDER_STATUS)
    private final Integer orderStatus;

    @SerializedName("sub_text")
    private final String subText;

    @SerializedName("text")
    private final String text;

    @SerializedName("toast")
    private final String toast;

    @SerializedName("version_toast")
    private String versionToast;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductButtonStruct() {
    }

    public final String getOrderUrl() {
        PromotionProductLink r100 = this.links;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getH5Url();
    }

    public final Integer getBuriedPointType() {
        return this.buriedPointType;
    }

    public final ButtonTipsStruct getButtonTips() {
        return this.buttonTips;
    }

    public final Integer getCouponAmount() {
        return this.couponAmount;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final boolean getGrayButton() {
        return this.grayButton;
    }

    public final boolean getInvalidVersion() {
        return this.invalidVersion;
    }

    public final PromotionProductLink getLinks() {
        return this.links;
    }

    public final String getNoStockTip() {
        return this.noStockTip;
    }

    public final Integer getOrderStatus() {
        return this.orderStatus;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final String getText() {
        return this.text;
    }

    public final String getToast() {
        return this.toast;
    }

    public final String getVersionToast() {
        return this.versionToast;
    }

    public final void setBuriedPointType(Integer r100) {
        this.buriedPointType = r100;
    }

    public final void setInvalidVersion(boolean r100) {
        this.invalidVersion = r100;
    }

    public final void setVersionToast(String r100) {
        this.versionToast = r100;
    }
}

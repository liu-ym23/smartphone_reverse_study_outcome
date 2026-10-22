package com.bytedance.android.ec.model.response;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R$\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\rR$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006<"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionAuctionInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "getHotAtmosphere", "", "bidLeftIconRes", "bidSuccessLeftIconRes", "getIntroHotAtmosphere", "productId", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "", "price", "Ljava/lang/Long;", "getPrice", "()Ljava/lang/Long;", "setPrice", "(Ljava/lang/Long;)V", "priceLabel", "getPriceLabel", "setPriceLabel", "buttonLabel", "getButtonLabel", "setButtonLabel", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "jumpUrl", "getJumpUrl", "setJumpUrl", "Lcom/bytedance/android/ec/model/response/CurrentUserInfo;", "currentUserInfo", "Lcom/bytedance/android/ec/model/response/CurrentUserInfo;", "getCurrentUserInfo", "()Lcom/bytedance/android/ec/model/response/CurrentUserInfo;", "setCurrentUserInfo", "(Lcom/bytedance/android/ec/model/response/CurrentUserInfo;)V", "bizId", "I", "getBizId", "()I", "setBizId", "(I)V", "endTime", "J", "getEndTime", "()J", "setEndTime", "(J)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionAuctionInfo implements Serializable {
    public static final int BIZ_ID_AUCTION = 0;
    public static final int BIZ_ID_JINGPAI = 1;
    public static final a Companion = null;
    public static final int STATUS_CANCEL = 5;
    public static final int STATUS_END = 4;
    public static final int STATUS_ONGOING = 2;
    public static final int STATUS_PREPARE = 1;
    public static final int STATUS_PRE_END = 6;
    public static final int STATUS_SUCCESS = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient ECHotAtmosphere f47902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient boolean f47903b;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    private int bizId;

    @SerializedName("button_label")
    private String buttonLabel;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient ECHotAtmosphere f47904c;

    @SerializedName("current_user_info")
    private CurrentUserInfo currentUserInfo;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient boolean f47905d;

    @SerializedName("end_time")
    private long endTime;

    @SerializedName("jump_url")
    private String jumpUrl;

    @SerializedName("price")
    private Long price;

    @SerializedName("price_label")
    private String priceLabel;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("status")
    private Integer status;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECPromotionAuctionInfo() {
    }

    public final ECHotAtmosphere getHotAtmosphere() {
        if (this.f47903b == true) goto L32;
        boolean r100 = true;
        this.f47903b = true;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "auction");
        CurrentUserInfo r101 = getCurrentUserInfo();
        ECHotAtmosphere r102 = null;
        String r103 = null;
        r102 = null;
        if (r101 != null) goto L7;
    L30:
        this.f47902a = r102;
        goto L32
    L7:
        if (r101.getUserId() > 0) goto L10;
        r100 = false;
    L10:
        if (r100 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L30;
        ECHotAtmosphere r104 = new ECHotAtmosphere();
        r104.uiType = 0;
        ECUrlModel r105 = r101.getUserPic();
        if (r105 == null) goto L17;
        r103 = r105.getFirstUrl();
    L17:
        r104.img = r103;
        Long r106 = getPrice();
        if (r106 == null) goto L21;
        String r107 = String.valueOf(r106.longValue());
        if (r107 == null) goto L21;
    L22:
        r104.num = r107;
        Integer r108 = getStatus();
        if (r108 != null) goto L26;
    L28:
        int r109 = 10002;
    L29:
        r104.type = r109;
        r102 = r104;
        goto L30
    L26:
        if (r108.intValue() != 2) goto L28;
        r109 = 10001;
    L21:
        r107 = "0";
    L32:
        return this.f47902a;
    }

    public final int getBizId() {
        return this.bizId;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final CurrentUserInfo getCurrentUserInfo() {
        return this.currentUserInfo;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Long getPrice() {
        return this.price;
    }

    public final String getPriceLabel() {
        return this.priceLabel;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final void setBizId(int r100) {
        this.bizId = r100;
    }

    public final void setButtonLabel(String r100) {
        this.buttonLabel = r100;
    }

    public final void setCurrentUserInfo(CurrentUserInfo r100) {
        this.currentUserInfo = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setPrice(Long r100) {
        this.price = r100;
    }

    public final void setPriceLabel(String r100) {
        this.priceLabel = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final ECHotAtmosphere getIntroHotAtmosphere(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "bidLeftIconRes");
        Intrinsics.checkNotNullParameter(r110, "bidSuccessLeftIconRes");
        if (this.f47905d == true) goto L36;
        boolean r101 = true;
        this.f47905d = true;
        Companion.getClass();
        Intrinsics.checkNotNullParameter(this, "auction");
        Intrinsics.checkNotNullParameter(r100, "bidLeftIconRes");
        Intrinsics.checkNotNullParameter(r110, "bidSuccessLeftIconRes");
        CurrentUserInfo r102 = getCurrentUserInfo();
        ECHotAtmosphere r103 = null;
        if (r102 != null) goto L7;
    L34:
        this.f47904c = r103;
        goto L36
    L7:
        if (r102.getUserId() > 0) goto L10;
        r101 = false;
    L10:
        if (r101 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L34;
        r103 = new ECHotAtmosphere();
        r103.uiType = 5000;
        Long r104 = getPrice();
        if (r104 == null) goto L18;
        String r105 = String.valueOf(r104.longValue());
        if (r105 == null) goto L18;
    L19:
        r103.num = r105;
        Integer r106 = getStatus();
        if (r106 != null) goto L23;
    L25:
        int r107 = 10002;
    L26:
        r103.type = r107;
        Integer r108 = getStatus();
        if (r108 != null) goto L30;
    L32:
        r100 = r110;
    L33:
        r103.img = r100;
        goto L34
    L30:
        if (r108.intValue() != 2) goto L32;
    L23:
        if (r106.intValue() != 2) goto L25;
        r107 = 10001;
    L18:
        r105 = "0";
    L36:
        return this.f47904c;
    }
}

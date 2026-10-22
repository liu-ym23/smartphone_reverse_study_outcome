package com.bytedance.android.shopping.new_cart.dto;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/dto/CartMarketingResourceSchemaResponse;", "Ljava/io/Serializable;", "", "isShow", "Z", "()Z", "", "couponSchema", "Ljava/lang/String;", "getCouponSchema", "()Ljava/lang/String;", "marketingExpressSchema", "getMarketingExpressSchema", "marketingExpressMega", "getMarketingExpressMega", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartMarketingResourceSchemaResponse implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName(ILiveRoomPlayFragmentConstant.COUPON_SCHEMA)
    private final String couponSchema;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW)
    private final boolean isShow;

    @SerializedName("marketing_express_mega")
    private final String marketingExpressMega;

    @SerializedName("marketing_express_schema")
    private final String marketingExpressSchema;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CartMarketingResourceSchemaResponse() {
        this(false, null, null, null, 15, null);
    }

    public final String getCouponSchema() {
        return this.couponSchema;
    }

    public final String getMarketingExpressMega() {
        return this.marketingExpressMega;
    }

    public final String getMarketingExpressSchema() {
        return this.marketingExpressSchema;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public CartMarketingResourceSchemaResponse(boolean r100, String r101, String r102, String r103) {
        this.isShow = r100;
        this.couponSchema = r101;
        this.marketingExpressSchema = r102;
        this.marketingExpressMega = r103;
    }

    public /* synthetic */ CartMarketingResourceSchemaResponse(boolean r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
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

package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig;", "", "", "spuId", "J", "", "spuIdStr", "Ljava/lang/String;", "skuId", "skuIdStr", "title", "subTitle", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "Lpy/k;", "cover", "Lpy/k;", "", "sellStatus", "I", "status", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig$PriceInfo;", "iosPayPriceInfo", "androidPayPriceInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig$UserRight;", "userRight", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig$UserRight;", "<init>", "()V", "PayType", "PriceInfo", "UserRight", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidLiveConfig implements h {
    public static final int Cash = 1;
    public static final int DouCoin = 2;
    public static final PayType PayType = null;
    public static final int UnKnown = 0;

    @SerializedName("android_pay_price_info")
    public List<PriceInfo> androidPayPriceInfo;

    @SerializedName("cover")
    public k cover;

    @SerializedName("ios_pay_price_info")
    public List<PriceInfo> iosPayPriceInfo;

    @SerializedName("sell_status")
    public int sellStatus;

    @SerializedName(a.KEY_SKU_ID)
    public long skuId;

    @SerializedName("sku_id_str")
    public String skuIdStr;

    @SerializedName("spu_id")
    public long spuId;

    @SerializedName("spu_id_str")
    public String spuIdStr;

    @SerializedName("status")
    public int status;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public String subTitle;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<String> tags;

    @SerializedName("title")
    public String title;

    @SerializedName("user_right")
    public UserRight userRight;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig$PayType;", "", "()V", "Cash", "", "DouCoin", "UnKnown", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PayType {
        private PayType() {
        }

        public /* synthetic */ PayType(DefaultConstructorMarker r100) {
            this();
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig$PriceInfo;", "", "()V", "payType", "", "price", "", "rightDuration", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class PriceInfo implements h {

        @SerializedName("pay_type")
        public int payType;

        @SerializedName("price")
        public long price;

        @SerializedName("right_duration")
        public int rightDuration;

        public PriceInfo() {
        }

        public PriceInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L15;
            if (r102 != 1) goto L8;
            this.payType = r100.i();
            goto L3
        L8:
            if (r102 != 2) goto L10;
            this.price = r100.j();
            goto L3
        L10:
            if (r102 != 3) goto L11;
            this.rightDuration = r100.i();
            goto L3
        L11:
            am3.h.e(r100);
            goto L3
        L15:
            r100.d(r101);
        }
    }

    @ForMain
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/PaidLiveConfig$UserRight;", "", "()V", "delivery", "", "duration", "", "needDeliveryNotice", "", "viewRight", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class UserRight implements h {

        @SerializedName("delivery")
        public int delivery;

        @SerializedName("duration")
        public long duration;

        @SerializedName("need_delivery_notice")
        public boolean needDeliveryNotice;

        @SerializedName("view_right")
        public int viewRight;

        public UserRight() {
        }

        public UserRight(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L18;
            if (r102 != 1) goto L8;
            this.viewRight = r100.i();
            goto L3
        L8:
            if (r102 != 3) goto L10;
            this.duration = r100.j();
            goto L3
        L10:
            if (r102 != 6) goto L12;
            this.delivery = r100.i();
            goto L3
        L12:
            if (r102 != 7) goto L13;
            this.needDeliveryNotice = am3.h.a(r100);
            goto L3
        L13:
            am3.h.e(r100);
            goto L3
        L18:
            r100.d(r101);
        }
    }

    static {
        PayType = new PayType(null);
    }

    public PaidLiveConfig() {
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public PaidLiveConfig(g r100) {
        this.tags = new ArrayList();
        this.iosPayPriceInfo = new ArrayList();
        this.androidPayPriceInfo = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        switch(r102) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.userRight = new UserRight(r100);
        goto L3
    L8:
        List r103 = this.androidPayPriceInfo;
        Object r104 = new PriceInfo(r100);
    L14:
        r103.add(r104);
        goto L3
    L9:
        r103 = this.iosPayPriceInfo;
        r104 = new PriceInfo(r100);
        goto L14
    L10:
        this.status = r100.i();
        goto L3
    L11:
        this.sellStatus = r100.i();
        goto L3
    L12:
        this.cover = f.a(r100, k.class);
        goto L3
    L13:
        r103 = this.tags;
        r104 = am3.h.c(r100);
        goto L14
    L15:
        this.subTitle = am3.h.c(r100);
        goto L3
    L16:
        this.title = am3.h.c(r100);
        goto L3
    L17:
        this.skuIdStr = am3.h.c(r100);
        goto L3
    L18:
        this.skuId = r100.j();
        goto L3
    L19:
        this.spuIdStr = am3.h.c(r100);
        goto L3
    L20:
        this.spuId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}

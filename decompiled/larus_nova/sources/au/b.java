package au;

import am3.g;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.CouponTemplate")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lau/b;", "", "", GXTemplateKey.GAIAX_TEMPLATE_ID, "Ljava/lang/String;", "templateName", "claimExpireBeginTime", "claimExpireEndTime", "useExpireDate", "userReceiveLimit", "couponDiscountType", "couponDiscountAmount", "couponDiscountLimit", "couponDistributeType", "couponType", "anchorDistributeAmount", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("anchor_distribute_amount")
    public String anchorDistributeAmount;

    @SerializedName("claim_expire_begin_time")
    public String claimExpireBeginTime;

    @SerializedName("claim_expire_end_time")
    public String claimExpireEndTime;

    @SerializedName("coupon_discount_amount")
    public String couponDiscountAmount;

    @SerializedName("coupon_discount_limit")
    public String couponDiscountLimit;

    @SerializedName("coupon_discount_type")
    public String couponDiscountType;

    @SerializedName("coupon_distribute_type")
    public String couponDistributeType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE)
    public String couponType;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    public String templateId;

    @SerializedName("template_name")
    public String templateName;

    @SerializedName("use_expire_date")
    public String useExpireDate;

    @SerializedName("user_receive_limit")
    public String userReceiveLimit;

    public b() {
    }

    public b(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L19;
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.anchorDistributeAmount = am3.h.c(r100);
        goto L3
    L8:
        this.couponType = am3.h.c(r100);
        goto L3
    L9:
        this.couponDistributeType = am3.h.c(r100);
        goto L3
    L10:
        this.couponDiscountLimit = am3.h.c(r100);
        goto L3
    L11:
        this.couponDiscountAmount = am3.h.c(r100);
        goto L3
    L12:
        this.couponDiscountType = am3.h.c(r100);
        goto L3
    L13:
        this.userReceiveLimit = am3.h.c(r100);
        goto L3
    L14:
        this.useExpireDate = am3.h.c(r100);
        goto L3
    L15:
        this.claimExpireEndTime = am3.h.c(r100);
        goto L3
    L16:
        this.claimExpireBeginTime = am3.h.c(r100);
        goto L3
    L17:
        this.templateName = am3.h.c(r100);
        goto L3
    L18:
        this.templateId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L19:
        r100.d(r101);
    }
}

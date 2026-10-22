package com.bytedance.android.shopping.order.dto;

import cg3.b;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/order/dto/MotivateInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;", "toCommentOrder", "Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;", "getToCommentOrder", "()Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;", "", "ret", "J", "getRet", "()J", "typ", "getTyp", "amount", "getAmount", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "type", "getType", "rulePage", "getRulePage", "Lcom/bytedance/android/shopping/order/dto/CouponInfo;", "additionalCouponInfo", "Lcom/bytedance/android/shopping/order/dto/CouponInfo;", "getAdditionalCouponInfo", "()Lcom/bytedance/android/shopping/order/dto/CouponInfo;", "couponInfo", "getCouponInfo", "Lcg3/b;", "action", "Lcg3/b;", "getAction", "()Lcg3/b;", "<init>", "(Lcom/bytedance/android/shopping/order/dto/ToCommentOrder;JJJLjava/lang/String;JLjava/lang/String;Lcom/bytedance/android/shopping/order/dto/CouponInfo;Lcom/bytedance/android/shopping/order/dto/CouponInfo;Lcg3/b;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MotivateInfo implements Serializable {

    @SerializedName("action")
    private final b action;

    @SerializedName("additional_coupon_info")
    private final CouponInfo additionalCouponInfo;

    @SerializedName("amount")
    private final long amount;

    @SerializedName(a.KEY_COUPON_INFO)
    private final CouponInfo couponInfo;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private final String desc;

    @SerializedName("ret")
    private final long ret;

    @SerializedName("rule_page")
    private final String rulePage;

    @SerializedName("to_comment_order")
    private final ToCommentOrder toCommentOrder;

    @SerializedName("typ")
    private final long typ;

    @SerializedName("type")
    private final long type;

    public MotivateInfo() {
        this(null, 0, 0, 0, null, 0, null, null, null, null, 1023, null);
    }

    public final b getAction() {
        return this.action;
    }

    public final CouponInfo getAdditionalCouponInfo() {
        return this.additionalCouponInfo;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final CouponInfo getCouponInfo() {
        return this.couponInfo;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final long getRet() {
        return this.ret;
    }

    public final String getRulePage() {
        return this.rulePage;
    }

    public final ToCommentOrder getToCommentOrder() {
        return this.toCommentOrder;
    }

    public final long getTyp() {
        return this.typ;
    }

    public final long getType() {
        return this.type;
    }

    public MotivateInfo(ToCommentOrder r100, long r101, long r102, long r103, String r104, long r105, String r110, CouponInfo r111, CouponInfo r112, b r113) {
        this.toCommentOrder = r100;
        this.ret = r101;
        this.typ = r102;
        this.amount = r103;
        this.desc = r104;
        this.type = r105;
        this.rulePage = r110;
        this.additionalCouponInfo = r111;
        this.couponInfo = r112;
        this.action = r113;
    }

    public /* synthetic */ MotivateInfo(ToCommentOrder r110, long r111, long r112, long r210, String r211, long r212, String r213, CouponInfo r214, CouponInfo r215, b r216, int r310, DefaultConstructorMarker r311) {
        b r100 = null;
        if ((r310 & 1) == 0) goto L5;
        ToCommentOrder r101 = null;
    L6:
        long r102 = 0;
        if ((r310 & 2) == 0) goto L9;
        long r103 = 0;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r310 & 8) == 0) goto L17;
        long r113 = 0;
    L18:
        String r114 = "";
        if ((r310 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r310 & 32) != 0) goto L27;
        r102 = r212;
    L27:
        if ((r310 & 64) != 0) goto L31;
        r114 = r213;
    L31:
        if ((r310 & 128) == 0) goto L33;
        CouponInfo r115 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        CouponInfo r116 = null;
    L39:
        if ((r310 & 512) != 0) goto L42;
        r100 = r216;
    L42:
        this(r101, r103, r104, r113, r105, r102, r114, r115, r116, r100);
        return;
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L21:
        r105 = r211;
        goto L23
    L17:
        r113 = r210;
        goto L18
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}

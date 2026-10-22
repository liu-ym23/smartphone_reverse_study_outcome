package au;

import am3.g;
import com.bytedance.android.gamecp.business.v;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.UserCoupon")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lau/a;", "", "Lau/b;", "templateInfo", "Lau/b;", "", "couponState", "Ljava/lang/String;", "Lcom/bytedance/android/gamecp/business/v;", "gameInfo", "Lcom/bytedance/android/gamecp/business/v;", "anchorName", "", "expireLeftTime", "Ljava/lang/Long;", "anchorId", "", "defaultCoupon", "Ljava/lang/Boolean;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("bind_anchor_id")
    public Long anchorId;

    @SerializedName("bind_coupon_anchor")
    public String anchorName;

    @SerializedName("user_coupon_status")
    public String couponState;

    @SerializedName("default_coupon")
    public Boolean defaultCoupon;

    @SerializedName("coupon_expire_left_time")
    public Long expireLeftTime;

    @SerializedName("game_info")
    public v gameInfo;

    @SerializedName("template_info")
    public b templateInfo;

    /* JADX INFO: renamed from: au.a$a, reason: collision with other inner class name */
    public static final class C0231a {
    }

    static {
    }

    public a() {
        this.defaultCoupon = Boolean.FALSE;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.defaultCoupon = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        this.anchorId = Long.valueOf(r100.j());
        goto L3
    L9:
        this.expireLeftTime = Long.valueOf(r100.j());
        goto L3
    L10:
        this.anchorName = am3.h.c(r100);
        goto L3
    L11:
        this.gameInfo = new v(r100);
        goto L3
    L12:
        this.couponState = am3.h.c(r100);
        goto L3
    L13:
        this.templateInfo = new b(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.defaultCoupon != null) goto L36;
        this.defaultCoupon = Boolean.FALSE;
        return;
    }
}

package com.bytedance.android.livesdk.coupon.expandcoupon.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes8.dex */
@ProtoMessage("webcast.api.open_user_benefit.QueryUserBenefitPopupResponse.QcpxCouponInfo")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/e;", "", "", "couponValue", "J", "d", "()J", "setCouponValue", "(J)V", "couponThreshold", "c", "setCouponThreshold", "applyTime", "getApplyTime", "setApplyTime", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "getExpireTime", "setExpireTime", "", "applied", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setApplied", "(Z)V", "", "Lcom/bytedance/android/livesdk/coupon/expandcoupon/model/c;", "couponTaskInfo", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setCouponTaskInfo", "(Ljava/util/Map;)V", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class e implements h {

    @SerializedName("applied")
    protected boolean applied;

    @SerializedName("apply_time")
    protected long applyTime;

    @SerializedName("incr_coupon")
    protected Map<Long, c> couponTaskInfo;

    @SerializedName("qpon_threshold")
    protected long couponThreshold;

    @SerializedName("qpon_value")
    protected long couponValue;

    @SerializedName("expire_time")
    protected long expireTime;

    public e() {
    }

    public final boolean a() {
        return this.applied;
    }

    public final Map<Long, c> b() {
        return this.couponTaskInfo;
    }

    public final long c() {
        return this.couponThreshold;
    }

    public final long d() {
        return this.couponValue;
    }

    public e(g r110) {
        this.couponTaskInfo = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        switch(r101) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        long r102 = r110.c();
        Long r103 = null;
        c r104 = null;
    L8:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = Long.valueOf(r110.j());
        goto L8
    L13:
        if (r105 != 2) goto L14;
        r104 = new c(r110);
        goto L8
    L14:
        am3.h.e(r110);
        goto L8
    L17:
        r110.d(r102);
        Map<Long, c> r106 = this.couponTaskInfo;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.applied = am3.h.a(r110);
        goto L3
    L26:
        this.expireTime = r110.j();
        goto L3
    L27:
        this.applyTime = r110.j();
        goto L3
    L28:
        this.couponThreshold = r110.j();
        goto L3
    L29:
        this.couponValue = r110.j();
        goto L3
    L6:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
    }
}

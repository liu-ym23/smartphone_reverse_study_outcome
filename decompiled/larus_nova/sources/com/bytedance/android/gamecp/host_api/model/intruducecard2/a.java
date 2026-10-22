package com.bytedance.android.gamecp.host_api.model.intruducecard2;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.IntroduceDispatchStrategy")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/intruducecard2/a;", "", "", "maxRetryTimes", "Ljava/lang/Integer;", "getMaxRetryTimes", "()Ljava/lang/Integer;", "minRandom", "getMinRandom", ControlRule.KEY_STRATEGY_TYPE, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "maxRandom", "getMaxRandom", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("max_random_ms")
    protected Integer maxRandom;

    @SerializedName("max_retry_times")
    protected Integer maxRetryTimes;

    @SerializedName("min_random_ms")
    protected Integer minRandom;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_STRATEGY_TYPE)
    protected Integer strategyType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.maxRetryTimes, r101.maxRetryTimes) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.minRandom, r101.minRandom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategyType, r101.strategyType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxRandom, r101.maxRandom) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.maxRetryTimes;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.minRandom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.strategyType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.maxRandom;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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

    public final String toString() {
        return "IntroduceDispatchStrategyV2(maxRetryTimes=" + this.maxRetryTimes + ", minRandom=" + this.minRandom + ", strategyType=" + this.strategyType + ", maxRandom=" + this.maxRandom + ")";
    }

    public a() {
        this.maxRetryTimes = 0;
        this.minRandom = 0;
        this.strategyType = 0;
        this.maxRandom = 0;
    }

    public final Integer a() {
        return this.strategyType;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.strategyType = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.maxRetryTimes = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.minRandom = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.maxRandom = Integer.valueOf(r100.i());
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.maxRetryTimes != null) goto L22;
        this.maxRetryTimes = 0;
    L22:
        if (this.minRandom != null) goto L25;
        this.minRandom = 0;
    L25:
        if (this.strategyType != null) goto L28;
        this.strategyType = 0;
    L28:
        if (this.maxRandom != null) goto L46;
        this.maxRandom = 0;
        return;
    }
}

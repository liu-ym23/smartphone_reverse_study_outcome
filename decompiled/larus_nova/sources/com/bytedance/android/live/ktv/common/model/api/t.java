package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/t;", "", "", GearStrategyConsts.EV_SELECT_BEGIN, "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setBegin", "(J)V", "end", "b", "setEnd", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t implements vh7.h {

    @SerializedName(GearStrategyConsts.EV_SELECT_BEGIN)
    protected long begin;

    @SerializedName("end")
    protected long end;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L10;
        t r101 = (t) r100;
        if (this.begin == r101.begin) goto L8;
        return false;
    L8:
        if (this.end == r101.end) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.begin;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.end;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "GuessWordPos(begin=" + this.begin + ", end=" + this.end + ")";
    }

    public t() {
        this.begin = 0;
        this.end = 0;
    }

    public final long a() {
        return this.begin;
    }

    public final long b() {
        return this.end;
    }

    public t(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L11;
        if (r103 != 1) goto L7;
        this.begin = r100.j();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L8;
        this.end = r100.j();
        r102 = r102 | 2;
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L11:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L15;
        this.begin = 0;
    L15:
        if ((r102 & 2) != 0) goto L27;
        this.end = 0;
        return;
    }
}

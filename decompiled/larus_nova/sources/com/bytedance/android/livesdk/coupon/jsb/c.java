package com.bytedance.android.livesdk.coupon.jsb;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f121916a;

    public c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "iExpandCouponJsb");
        this.f121916a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        UtilityKotlinExtentionsKt.s(0, false, false, new DoExpandCoupon$invoke$1(this), 7);
        return null;
    }
}

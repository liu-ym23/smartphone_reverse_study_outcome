package com.bytedance.android.livesdk.coupon.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f121918a;

    public e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "iExpandCouponJsb");
        this.f121918a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ct1.b r102 = this.f121918a.b();
        return b.a(this.f121918a.a(), r102);
    }
}

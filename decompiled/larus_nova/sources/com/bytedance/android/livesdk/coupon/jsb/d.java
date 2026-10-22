package com.bytedance.android.livesdk.coupon.jsb;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends g<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f121917a;

    public d(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f121917a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r100, final CallContext r101) {
        final JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        UtilityKotlinExtentionsKt.s(0, false, false, new ExchangeCoupon$invoke$1(this, r101, r102), 7);
        return null;
    }
}

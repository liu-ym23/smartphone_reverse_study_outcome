package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "makePhoneCall")
public final class CallPhoneMethod extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Throwable, Unit> f63230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Object, Unit> f63231b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public CallPhoneMethod() {
        this.f63230a = new CallPhoneMethod$onFailed$1(this);
        this.f63231b = new CallPhoneMethod$onSuccess$1(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = m1.f63551a;
        m1.a(r102, r101, this.f63230a, this.f63231b);
    }
}

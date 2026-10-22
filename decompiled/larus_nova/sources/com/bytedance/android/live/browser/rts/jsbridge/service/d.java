package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.n;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements z<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f64180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f64181b;

    public static final class a implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f64182a;

        public a(d r100) {
            this.f64182a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void a(JSONObject r100) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onFailed(Throwable r100) {
            Function1 r101 = this.f64182a.f64181b;
            RTSLiveJSBResponseCode r102 = RTSLiveJSBResponseCode.FAILED;
            r101.invoke(new n(new LinkedHashMap()));
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onSucceed(Object r100) {
            if (r100 == null) goto L7;
            RTSLiveJSBResponseCode r101 = RTSLiveJSBResponseCode.FAILED;
            e.f64183a.getClass();
            Map r102 = e.a.a(r100);
            if (r102 != null) goto L6;
            r102 = new LinkedHashMap();
        L6:
            n r103 = new n(r102);
        L8:
            this.f64182a.f64181b.invoke(r103);
            return;
        L7:
            LinkedHashMap r104 = new LinkedHashMap();
            RTSLiveJSBResponseCode r105 = RTSLiveJSBResponseCode.FAILED;
            r103 = new n(r104);
            goto L8
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final z.a getCallBack() {
        return new a(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final CallContext a() {
        return this.f64180a;
    }

    public d(CallContext r100, Function1 r101) {
        this.f64180a = r100;
        this.f64181b = r101;
    }
}

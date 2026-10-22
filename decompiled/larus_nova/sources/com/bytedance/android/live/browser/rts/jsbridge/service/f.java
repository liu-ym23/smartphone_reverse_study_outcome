package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.r;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements z<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f64184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f64185b;

    public static final class a implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f64186a;

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void a(JSONObject r100) {
        }

        public a(f r100) {
            this.f64186a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onFailed(Throwable r100) {
            Function1 r101 = this.f64186a.f64185b;
            RTSLiveJSBResponseCode r102 = RTSLiveJSBResponseCode.FAILED;
            if (r100 == null) goto L6;
            String r103 = r100.getMessage();
            if (r103 == null) goto L6;
        L7:
            r101.invoke(new r(r102, r103));
            return;
        L6:
            r103 = "";
            goto L7
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onSucceed(Object r100) {
            this.f64186a.f64185b.invoke(new r(RTSLiveJSBResponseCode.SUCCESS, "success"));
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final z.a getCallBack() {
        return new a(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final CallContext a() {
        return this.f64184a;
    }

    public f(CallContext r100, Function1 r101) {
        this.f64184a = r100;
        this.f64185b = r101;
    }
}

package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.android.livesdk.jsbridge.methods.CloseLiveRoomResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements z<CloseLiveRoomResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f64171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f64172b;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.rts.jsbridge.service.a$a, reason: collision with other inner class name */
    public static final class C1054a implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f64173a;

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void a(JSONObject r100) {
        }

        public C1054a(a r100) {
            this.f64173a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onFailed(Throwable r100) {
            this.f64173a.f64172b.invoke(new p30.b(RTSLiveJSBResponseCode.FAILED));
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onSucceed(Object r100) {
            if ((r100 instanceof CloseLiveRoomResultModel) == false) goto L6;
            Function1 r101 = this.f64173a.f64172b;
            RTSLiveJSBResponseCode r102 = RTSLiveJSBResponseCode.SUCCESS;
            ((CloseLiveRoomResultModel) r100).getClass();
            r101.invoke(new p30.b(r102));
            return;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final z.a getCallBack() {
        return new C1054a(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final CallContext a() {
        return this.f64171a;
    }

    public a(CallContext r100, Function1 r101) {
        this.f64171a = r100;
        this.f64172b = r101;
    }
}

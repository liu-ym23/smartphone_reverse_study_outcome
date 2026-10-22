package com.bytedance.android.live.browser.rts.jsbridge.service;

import com.bytedance.android.live.browser.jsbridge.base.CommunityGetEnableLiveHistoryResultModel;
import com.bytedance.android.live.browser.rts.jsbridge.api.RTSLiveJSBResponseCode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import p30.i;

/* JADX INFO: loaded from: classes45.dex */
public final class c implements z<CommunityGetEnableLiveHistoryResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f64177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f64178b;

    public static final class a implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f64179a;

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void a(JSONObject r100) {
        }

        public a(c r100) {
            this.f64179a = r100;
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onFailed(Throwable r100) {
            this.f64179a.f64178b.invoke(new i(RTSLiveJSBResponseCode.FAILED, Boolean.FALSE));
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onSucceed(Object r100) {
            if ((r100 instanceof CommunityGetEnableLiveHistoryResultModel) == false) goto L10;
            Function1 r101 = this.f64179a.f64178b;
            RTSLiveJSBResponseCode r102 = RTSLiveJSBResponseCode.SUCCESS;
            CommunityGetEnableLiveHistoryResultModel.a r103 = ((CommunityGetEnableLiveHistoryResultModel) r100).a();
            if (r103 == null) goto L7;
            Boolean r104 = r103.a();
        L8:
            r101.invoke(new i(r102, r104));
            return;
        L7:
            r104 = null;
            goto L8
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final z.a getCallBack() {
        return new a(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final CallContext a() {
        return this.f64177a;
    }

    public c(CallContext r100, Function1 r101) {
        this.f64177a = r100;
        this.f64178b = r101;
    }
}

package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.browser.jsbridge.base.DoLiveCertResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.s8;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "doLiveCert")
public final class q2 extends w20.m0<s8, DoLiveCertResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f142179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f142180b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f142180b.clear();
    }

    public q2() {
        this.f142179a = "OpenLiveFaceCert";
        this.f142180b = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        s8 r102 = (s8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IUserService r103 = (IUserService) jc1.k.f(IUserService.class);
        IHostContext r104 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r103 == null) goto L39;
        if (r104 == null) goto L39;
        if (r103.user().isLogin() == false) goto L39;
        Context r105 = r101.getContext();
        if ((r105 instanceof Activity) == false) goto L38;
        v80.c r106 = new v80.c();
        r106.f553648a = r105;
        Boolean r107 = r102.c();
        if (r107 == null) goto L13;
        r106.f553608d = r107.booleanValue();
    L13:
        String r108 = r102.e();
        if (r108 == null) goto L16;
        Intrinsics.checkNotNullParameter(r108, "identityCode");
        r106.f553607c.put(BytedCertConstant.CertKey.IDENTITY_CODE, r108);
    L16:
        String r109 = r102.f();
        if (r109 == null) goto L19;
        Intrinsics.checkNotNullParameter(r109, "identityName");
        r106.f553607c.put(BytedCertConstant.CertKey.IDENTITY_NAME, r109);
    L19:
        String r110 = r102.h();
        if (r110 == null) goto L22;
        r106.a("scene", r110);
    L22:
        String r111 = r102.d();
        if (r111 == null) goto L25;
        r106.a(BytedCertConstant.CertKey.FLOW, r111);
    L25:
        String r112 = r102.i();
        if (r112 == null) goto L28;
        r106.a("ticket", r112);
    L28:
        String r113 = r102.a();
        if (r113 == null) goto L31;
        r106.a("cert_app_id", r113);
    L31:
        String r114 = r102.g();
        if (r114 == null) goto L34;
        r106.a("mode", r114);
    L34:
        JSONObject r115 = r102.b();
        if (r115 == null) goto L37;
        Intrinsics.checkNotNullParameter(r115, "extra");
    L37:
        ALogger.i("[LiveVerifyFullTracer]", this.f142179a + "， flow = " + r102.d() + ", scene = " + r102.h() + "， face_Only = " + r102.c());
        p2 r116 = new p2(this);
        Intrinsics.checkNotNullParameter(r116, "callback");
        r106.f553606b = r116;
        x80.c.a(3).f562883a.a(r106);
        return;
    L38:
        finishWithFailure(new Throwable("context is not Activity instance."));
        return;
    L39:
        DoLiveCertResultModel r117 = new DoLiveCertResultModel();
        r117.c(DoLiveCertResultModel.Code.Failed);
        r117.h("ocr service proxy is unavaliable");
        Unit r118 = Unit.INSTANCE;
        finishWithResult(r117);
    }
}

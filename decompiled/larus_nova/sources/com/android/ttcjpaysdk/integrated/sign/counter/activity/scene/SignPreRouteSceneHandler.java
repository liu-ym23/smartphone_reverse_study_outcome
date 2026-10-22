package com.android.ttcjpaysdk.integrated.sign.counter.activity.scene;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import com.android.ttcjpaysdk.base.saas.CJPaySaasUtils;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedSignCallback;
import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterHost;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.scene.presign.SignPreRouteExecutor;
import com.android.ttcjpaysdk.integrated.sign.counter.session.SignCounterSessionManager;
import com.android.ttcjpaysdk.integrated.sign.counter.session.SignPreRouteSession;
import com.android.ttcjpaysdk.integrated.sign.counter.session.SignPreRouteSessionState;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J2\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/scene/SignPreRouteSceneHandler;", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterSceneHandler;", "()V", "args", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/SignCounterLaunchArgs;", "executor", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/scene/presign/SignPreRouteExecutor;", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "", "host", "Lcom/android/ttcjpaysdk/integrated/sign/counter/activity/ISignCounterHost;", "applySaasEnvIfNeeded", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", d.D, "", "", "buildCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayIntegratedSignCallback;", "sessionId", "finishWithResult", "code", "msg", "data", "onBackPressed", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "onNewIntent", "onNext", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignPreRouteSceneHandler implements ISignCounterSceneHandler {
    private SignCounterLaunchArgs args;
    private final SignPreRouteExecutor executor;
    private boolean finished;
    private ISignCounterHost host;

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public boolean onBackPressed() {
        if (this.finished == true) goto L7;
        ICJPayIntegratedSignCallback.Companion r100 = ICJPayIntegratedSignCallback.Companion;
        finishWithResult$default(this, (String) r100.getCJ_PAY_DYPAY_CANCEL().first, (String) r100.getCJ_PAY_DYPAY_CANCEL().second, null, null, 8, null);
        return true;
    L7:
        return true;
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onDestroy() {
        if (this.finished == true) goto L21;
        ISignCounterHost r100 = this.host;
        boolean r101 = false;
        if (r100 == null) goto L11;
        Activity r102 = r100.getActivity();
        if (r102 == null) goto L11;
        if (r102.isFinishing() != true) goto L11;
        r101 = true;
    L11:
        if (r101 == false) goto L21;
        SignCounterLaunchArgs r103 = this.args;
        if (r103 == null) goto L15;
        String r104 = r103.getSessionId();
    L16:
        SignCounterSessionManager r105 = SignCounterSessionManager.INSTANCE;
        SignPreRouteSession r106 = r105.getPreSignSession(r104);
        if (r106 == null) goto L20;
        r106.setState(SignPreRouteSessionState.FINISHED);
    L20:
        r105.removePreSignSession(r104);
        goto L21
    L15:
        r104 = null;
    L21:
        this.host = null;
        this.args = null;
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onNext() {
        SignCounterLaunchArgs r100 = this.args;
        if (r100 == null) goto L5;
        String r101 = r100.getSessionId();
    L6:
        SignPreRouteSession r102 = SignCounterSessionManager.INSTANCE.getPreSignSession(r101);
        if (r102 != null) goto L13;
        ISignCounterHost r103 = this.host;
        if (r103 == null) goto L27;
        r103.finishHost();
        return;
    L27:
        return;
    L13:
        if (r102.getState() == SignPreRouteSessionState.CREATED) goto L15;
        return;
    L15:
        ISignCounterHost r104 = this.host;
        if (r104 == null) goto L28;
        Activity r105 = r104.getActivity();
        if (r105 == null) goto L29;
        applySaasEnvIfNeeded(r105, r102.getSdkInfo());
        r102.setState(SignPreRouteSessionState.REQUESTING);
        Map<String, Object> r106 = r102.getExtraInfo();
        if (r106 == null) goto L24;
        Object r107 = r106.get("source");
        if (r107 == null) goto L24;
    L25:
        this.executor.execute(r105, r102.getCjContext(), r102.getSdkInfo(), r107.toString(), buildCallback(r101), new C92681(this));
        return;
    L24:
        r107 = "";
        goto L25
    L29:
        return;
    L28:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public SignPreRouteSceneHandler() {
        this.executor = new SignPreRouteExecutor();
    }

    public static final /* synthetic */ ISignCounterHost access$getHost$p(SignPreRouteSceneHandler r100) {
        return r100.host;
    }

    private final ICJPayIntegratedSignCallback buildCallback(final String r100) {
        return new AnonymousClass1(this, r100);
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onEvent(BaseEvent r100) {
        ISignCounterSceneHandler.DefaultImpls.onEvent(this, r100);
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onNewIntent(SignCounterLaunchArgs r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        this.args = r100;
    }

    private final void applySaasEnvIfNeeded(Context r100, Map<String, String> r101) {
        String r102 = r101.get(CJOuterPayBean.KEY_SAAS_SCENE);
        if (r102 == null) goto L6;
        CJPaySaasUtils.INSTANCE.saveSaasEnv(r100, r102, false);
        return;
    }

    @Override // com.android.ttcjpaysdk.integrated.sign.counter.activity.ISignCounterSceneHandler
    public void onCreate(ISignCounterHost r100, SignCounterLaunchArgs r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "args");
        this.host = r100;
        this.args = r101;
        r100.getSceneContainer().removeAllViews();
        LayoutInflater.from(r100.getActivity()).inflate(R.layout.cj_pay_pre_sign_scene_layout, r100.getSceneContainer(), true);
    }

    private final void finishWithResult(String r100, String r101, String r102, String r103) {
        if (this.finished == false) goto L5;
        return;
    L5:
        this.finished = true;
        SignCounterSessionManager r104 = SignCounterSessionManager.INSTANCE;
        SignPreRouteSession r105 = r104.getPreSignSession(r103);
        if (r105 == null) goto L9;
        r105.setState(SignPreRouteSessionState.FINISHED);
    L9:
        if (r105 == null) goto L13;
        ICJPayIntegratedSignCallback r106 = r105.getCallback();
        if (r106 == null) goto L13;
        r106.onResult(r100, r101, r102);
    L13:
        r104.removePreSignSession(r103);
        ISignCounterHost r107 = this.host;
        if (r107 == null) goto L17;
        r107.finishHost();
        return;
    }

    public static final /* synthetic */ void access$finishWithResult(SignPreRouteSceneHandler r100, String r101, String r102, String r103, String r104) {
        r100.finishWithResult(r101, r102, r103, r104);
    }

    public static /* synthetic */ void finishWithResult$default(SignPreRouteSceneHandler r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L8;
        SignCounterLaunchArgs r107 = r100.args;
        if (r107 == null) goto L7;
        r104 = r107.getSessionId();
        goto L8
    L7:
        r104 = null;
    L8:
        r100.finishWithResult(r101, r102, r103, r104);
    }
}

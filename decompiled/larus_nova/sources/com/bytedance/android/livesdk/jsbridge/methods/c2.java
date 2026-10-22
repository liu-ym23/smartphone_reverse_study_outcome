package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.lottie.ILottieService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "lottieAnimation")
public final class c2 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f142061a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f142061a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f142061a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f142061a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f142061a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public c2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r103 = r102.optLong("assetId", 0);
        boolean r104 = r102.optBoolean("autoFinish", false);
        this.f142061a = ((ILottieService) jc1.k.n(ILottieService.class)).tryStartLottieAnimation(r103, r104).observeOn(AndroidSchedulers.mainThread()).subscribe(new a2(this, r101), new b2(this, r101));
    }
}

package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "banner动态化后不使用")
@XBridgeMethod(biz = "webcast", name = "saveGiftExtraDataToNative")
public final class q extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f129725a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f129725a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public q() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString("biz_type");
        if (r103 != null) goto L6;
    L11:
        boolean r104 = false;
    L12:
        this.f129725a = Single.fromCallable(new n(r102)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, r104), new p(this));
        return;
    L6:
        if (r103.hashCode() != 210881801) goto L11;
        if (r103.equals("market_mission_finish") == false) goto L11;
        r104 = true;
        goto L12
    }
}

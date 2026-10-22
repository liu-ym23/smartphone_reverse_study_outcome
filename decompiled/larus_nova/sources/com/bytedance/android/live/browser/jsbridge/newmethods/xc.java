package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showLeaveRoomDialog")
public final class xc extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f63721a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f63721a.clear();
    }

    public xc() {
        this.f63721a = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONObject r102 = new JSONObject();
        com.bytedance.android.livesdk.widget.z0 r103 = com.bytedance.android.livesdk.widget.z0.a();
        Context r104 = r101.getContext();
        r103.getClass();
        com.bytedance.android.livesdk.widget.x0.b r105 = new com.bytedance.android.livesdk.widget.x0.b(r104, 4);
        r105.f162238a.f162245d = "确认前往其他直播间吗？";
        r105.i(1, R.string.ttlive_cancel, new uc(r102));
        r105.i(0, R.string.ttlive_go, new vc(r102));
        r105.f162238a.f162250i = new wc(this, r102);
        r105.n();
    }
}

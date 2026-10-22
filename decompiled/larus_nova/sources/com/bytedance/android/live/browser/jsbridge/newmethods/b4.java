package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b4 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveHybridContainer f63309a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b4(ILiveHybridContainer r100) {
        this.f63309a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONObject r102 = new JSONObject();
        ILiveHybridContainer r103 = this.f63309a;
        if (r103 == null) goto L6;
        String r104 = r103.getContainerId();
        if (r104 == null) goto L6;
    L7:
        r102.put("containerID", r104);
        finishWithResult(r102);
        return;
    L6:
        r104 = "";
        goto L7
    }
}

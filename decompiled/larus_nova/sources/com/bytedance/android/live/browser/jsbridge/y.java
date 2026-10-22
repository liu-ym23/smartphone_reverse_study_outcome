package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class y implements XBridgeMethod.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y6.c f64145a;

    public y(y6.c r100) {
        this.f64145a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
    public final void sendJsEvent(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (r101 == null) goto L5;
        JSONObject r102 = com.bytedance.ies.xbridge.utils.j.d(r101);
    L6:
        this.f64145a.sendJSEvent(r100, r102);
        return;
    L5:
        r102 = new JSONObject();
        goto L6
    }
}

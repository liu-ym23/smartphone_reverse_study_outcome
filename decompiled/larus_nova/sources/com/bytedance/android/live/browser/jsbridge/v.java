package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.common.utility.Logger;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements XBridgeMethod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f64108a;

    public v(w r100) {
        this.f64108a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
    public final void invoke(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r101 = r100.get("data");
        if ((r101 instanceof Map) == false) goto L5;
        w r102 = this.f64108a;
        int r103 = i0.f63221a;
        JSONObject r104 = new JSONObject((Map) r101);
        i0.a(r104, r100.get("code"));
        r102.finishWithResult(r104);
        Logger.d("XbridgeManager", "xbridge end,fun name:" + this.f64108a.f64109a.f64142a);
        return;
    L5:
        w r105 = this.f64108a;
        int r106 = i0.f63221a;
        JSONObject r107 = new JSONObject(r100);
        i0.a(r107, null);
        r105.finishWithResult(r107);
        Logger.d("XbridgeManager", "xbridge data is error,fun name:" + this.f64108a.f64109a.f64142a);
    }
}

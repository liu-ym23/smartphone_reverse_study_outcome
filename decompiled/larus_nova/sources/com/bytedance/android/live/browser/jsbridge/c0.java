package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.common.utility.Logger;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 implements XBridgeMethod.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0.a f63188a;

    public c0(d0.a r100) {
        this.f63188a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.Callback
    public final void invoke(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r101 = r100.get("data");
        if ((r101 instanceof Map) == false) goto L5;
        this.f63188a.finishWithResult(new JSONObject((Map) r101));
        Logger.d("XbridgeManager", "xbridge end,fun name:" + this.f63188a.f63194a.f63190a);
        return;
    L5:
        this.f63188a.finishWithResult(new JSONObject(r100));
        Logger.d("XbridgeManager", "xbridge data is error,fun name:" + this.f63188a.f63194a.f63190a);
    }
}

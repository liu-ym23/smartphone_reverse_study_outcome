package com.bytedance.android.shopping.anchorv4.event_chain.custom_event.v2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class i0 implements ti.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PDPLynxListenerActionEvent f166646a;

    public i0(PDPLynxListenerActionEvent r100) {
        this.f166646a = r100;
    }

    @Override // ti.j
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        String r101 = r100.optString(LocationMonitorConst.IDENTIFIER);
        String r102 = this.f166646a.f166588k.getSessionId();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.equals(r101) != true) goto L9;
        this.f166646a.f166588k.q0(false);
        return;
    }
}

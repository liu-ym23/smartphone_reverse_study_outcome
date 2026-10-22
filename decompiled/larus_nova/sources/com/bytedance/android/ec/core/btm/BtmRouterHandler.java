package com.bytedance.android.ec.core.btm;

import android.content.Context;
import android.net.Uri;
import bf.d;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class BtmRouterHandler implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f43902a;

    public BtmRouterHandler() {
        this.f43902a = LazyKt.lazy(BtmRouterHandler$eventService$2.INSTANCE);
    }

    @Override // bf.d
    public final void a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (BtmSDK.INSTANCE.enableRouterMonitor() == true) goto L17;
        return;
    L17:
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L11
        if (r101 == null) goto L8;
        String r103 = r101.toString();     // Catch: Exception -> L11
    L9:
        r102.put("url", r103);     // Catch: Exception -> L11
        r102.put("sourceVC", r100.getClass().getName());     // Catch: Exception -> L11
    L13:
        xi.a r104 = (xi.a) this.f43902a.getValue();
        if (r104 == null) goto L19;
        r104.logV3("IESEC_Router_Monitor", r102);
        return;
    L19:
        return;
    L8:
        r103 = null;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r102 = new JSONObject();
        goto L13
    }
}

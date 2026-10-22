package com.bytedance.android.anniex.worker;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements XBridgeMethod.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSWorkerBDXBridge f41498a;

    public b(JSWorkerBDXBridge r100) {
        this.f41498a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod.b
    public final void sendJsEvent(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        JSWorkerBDXBridge r102 = this.f41498a;
        if (r101 == null) goto L5;
        Map<String, ? extends Object> r103 = r101.toMap();
    L6:
        r102.a(r100, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}

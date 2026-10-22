package com.bytedance.android.live.browser.jsbridge.method;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import e30.d;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import n56.c;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openLive")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/method/OpenLiveMethodV3;", "Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenLiveMethodV3 extends IJavaMethod2Annie {
    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public final String getName() {
        return "openLive";
    }

    public OpenLiveMethodV3(b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
    }

    @Override // com.bytedance.android.annie.xbridge.mix.IJavaMethod2Annie
    public final c c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "providerFactory");
        ue7.c r101 = (ue7.c) r100.c(ue7.c.class);
        HybridLogger r102 = HybridLogger.f246343a;
        StringBuilder r103 = new StringBuilder("containerInstance?.context() = ");
        View r104 = null;
        if (r101 == null) goto L5;
        Context r105 = r101.context();
    L6:
        r103.append(r105);
        HybridLogger.m("OpenLiveMethodV3", r103.toString(), null, null, 12);
        if (r101 == null) goto L9;
        Context r106 = r101.context();
    L10:
        WeakReference r107 = new WeakReference(r106);
        if (r101 == null) goto L14;
        r104 = r101.i();
    L14:
        return new d(r107, new WeakReference(r104));
    L9:
        r106 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}

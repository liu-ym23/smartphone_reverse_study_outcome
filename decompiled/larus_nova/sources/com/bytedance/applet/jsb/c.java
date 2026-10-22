package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.platform.api.ISdkDouyinAuth;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.checkDouyinOpenAuthStatus";
    }

    public c() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = r100.getString("client_key");
        String r104 = r100.getString("scope");
        String r105 = r100.getString("state");
        ISdkDouyinAuth r106 = com.larus.platform.service.i0.a();
        if (r106 == null) goto L6;
        r106.i(r103, r104, r105, new b(this, r101));
        return;
    }
}

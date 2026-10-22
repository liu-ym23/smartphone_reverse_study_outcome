package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.displayFloatingMask";
    }

    public k() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = r100.getString("viewId");
        boolean r104 = r100.getBoolean("show");
        Lazy<i2.f> r105 = i2.f.f488023i;
        i2.f r106 = i2.f.a.a();
        if (r106 != null) goto L5;
        bx7.c.c(this, r101, 0, "FloatingViewManager unavailable", 8);
        return;
    L5:
        if (r106.n(r103, r104) == false) goto L7;
        bx7.c.d(this, r101, new LinkedHashMap());
        return;
    L7:
        bx7.c.c(this, r101, 0, "displayFloatingMask failed", 8);
    }
}

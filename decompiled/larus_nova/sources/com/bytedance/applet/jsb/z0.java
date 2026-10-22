package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class z0 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.stopMusic";
    }

    public z0() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = c0.f192046b;
        if (r103 == null) goto L14;
        MusicPlayManagerDelegate r104 = MusicPlayManagerDelegate.f290176b;
        a88.e r105 = r104.a();
        if (r105 == null) goto L7;
        String r106 = r105.f2189a;
    L9:
        if (Intrinsics.areEqual(r103, r106) == false) goto L14;
        if (r104.c(r103) == false) goto L14;
        bx7.c.d(this, r101, new LinkedHashMap());
        return;
    L7:
        r106 = null;
    L14:
        bx7.c.c(this, r101, 0, null, 12);
    }
}

package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r0 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.setMusicVolume";
    }

    public r0() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
    L8:
        bx7.c.c(this, r101, 0, null, 12);
        return;
    L4:
        if (d0.a((int) r100.get(ITTVideoEngineEventSource.KEY_VOLUME).c()) == false) goto L6;
        bx7.c.d(this, r101, new LinkedHashMap());     // Catch: Exception -> L8
    L10:
        return;
    L6:
        bx7.c.c(this, r101, 0, null, 12);     // Catch: Exception -> L8
        goto L10
    }
}

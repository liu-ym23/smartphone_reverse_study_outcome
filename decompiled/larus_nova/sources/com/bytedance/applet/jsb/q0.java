package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q0 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.setMusicPlaybackTime";
    }

    public q0() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        int r103 = cx7.a.c(r100, "playback_time");
        String r104 = c0.f192046b;
        if (r104 == null) goto L11;
        MusicPlayManagerDelegate r105 = MusicPlayManagerDelegate.f290176b;
        a88.e r106 = r105.a();
        if (r106 == null) goto L7;
        String r107 = r106.f2189a;
    L9:
        if (Intrinsics.areEqual(r104, r107) == false) goto L11;
        r105.o(r104, r103, new p0(this, r101));
        return;
    L7:
        r107 = null;
    L11:
        bx7.c.c(this, r101, 0, null, 12);
    }
}

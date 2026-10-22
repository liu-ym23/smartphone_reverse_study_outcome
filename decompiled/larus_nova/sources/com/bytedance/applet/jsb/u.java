package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class u extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.getMusicStatus";
    }

    public u() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        a88.e r103 = MusicPlayManagerDelegate.f290176b.a();
        if (r103 == null) goto L9;
        String r104 = r103.f2189a;
        if (r104 == null) goto L9;
        if (Intrinsics.areEqual(r104, c0.f192046b) == false) goto L9;
        String r105 = c0.f192047c;
    L10:
        bx7.c.d(this, r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("music_id", r104), TuplesKt.to("status", r105)}));
        return;
    L9:
        r104 = "";
        r105 = "stopped";
        goto L10
    }
}

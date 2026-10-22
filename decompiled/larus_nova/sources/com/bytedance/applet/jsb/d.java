package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.lynx.canvas.KryptonCamera;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.configMusicResolution";
    }

    public d() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = cx7.a.d(r100, "resolution", "");
        c0 r104 = c0.f192045a;
        Intrinsics.checkNotNullParameter(r103, "mappedResolution");
        switch(r103.hashCode()) {
            case -1919475908: goto L18;
            case -1217394225: goto L14;
            case -1078030475: goto L10;
            case 915484836: goto L6;
            default: goto L21;
        };
    L21:
        String r105 = "Undefine";
    L22:
        String r106 = c0.f192046b;
        if (r106 == null) goto L26;
        bx7.c.d(this, r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(MusicPlayManagerDelegate.f290176b.p(r106, r105)))}));
        return;
    L26:
        bx7.c.c(this, r101, 0, null, 12);
        return;
    L6:
        if (r103.equals("highest") == false) goto L21;
        r105 = "SuperHigh";
        goto L22
    L10:
        if (r103.equals(KryptonCamera.Config.RESOLUTION_MEDIUM) == false) goto L21;
        r105 = "Standard";
        goto L22
    L14:
        if (r103.equals("higher") == false) goto L21;
        r105 = "High";
        goto L22
    L18:
        if (r103.equals("lossless") == false) goto L21;
        r105 = "FourK";
        goto L22
    }
}

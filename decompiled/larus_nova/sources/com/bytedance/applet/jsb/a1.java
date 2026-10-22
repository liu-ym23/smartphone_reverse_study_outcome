package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a1 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.updateMusicFavoriteStatus";
    }

    public a1() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        String r103 = cx7.a.d(r100, "music_id", "");
        if (StringsKt.isBlank(r103) == false) goto L6;
        bx7.c.c(this, r101, -3, null, 12);
        return;
    L6:
        boolean r104 = cx7.a.b(r100, "status", false);
        MusicPlayManagerDelegate.f290176b.m(r104, r103, null);
        bx7.c.d(this, r101, new LinkedHashMap());
    }
}

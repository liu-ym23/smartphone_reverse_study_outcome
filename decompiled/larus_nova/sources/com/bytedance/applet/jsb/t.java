package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.getMusicResolutionInfo";
    }

    public t() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        ArrayList r103 = new ArrayList();
        String r104 = c0.f192046b;
        if (r104 == null) goto L10;
        Iterator<T> r105 = MusicPlayManagerDelegate.f290176b.i(r104).iterator();
    L6:
        if (r105.hasNext() == false) goto L10;
        String r106 = c0.f192045a.k((String) r105.next());
        if (r106 == null) goto L6;
        r103.add(r106);
    L10:
        String r107 = c0.f192045a.k(MusicPlayManagerDelegate.f290176b.n());
        if (r107 != null) goto L13;
        r107 = "undefine";
    L13:
        bx7.c.d(this, r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("resolution_list", r103), TuplesKt.to("current_resolution", r107)}));
    }
}

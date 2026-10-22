package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.getAudioPlaybackTime";
    }

    public p() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        bx7.c.d(this, r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("playback_time", Integer.valueOf(NewsUrlAudioManagerDelegate.f290179b.f()))}));
    }
}

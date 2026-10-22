package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n0 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.setAudioPlaybackTime";
    }

    public n0() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r110, "type");
        String r102 = cx7.a.d(r100, "url", "");
        int r103 = cx7.a.c(r100, "playback_time");
        if (NewsUrlAudioManagerDelegate.f290179b.b(r102, Integer.valueOf(SOURCE_TYPE.URL.getValue()), "", r103, new m0(this, r101)) == true) goto L6;
        bx7.c.d(this, r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Boolean.FALSE)}));
        return;
    }
}

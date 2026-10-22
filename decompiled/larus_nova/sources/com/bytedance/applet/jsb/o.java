package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.SOURCE_TYPE;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.getAudioPlayStatus";
    }

    public o() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        bx7.c.d(this, r101, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("value", NewsUrlAudioManagerDelegate.f290179b.h(r100.getString("url"), Integer.valueOf(SOURCE_TYPE.URL.getValue()), "").getValue())}));
    }
}

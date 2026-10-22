package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l0 extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.resumeAudio";
    }

    public l0() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r110, ux7.d.C7943d r111, IvyBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        String r113 = r110.getString("url");
        if (r113 != null) goto L5;
        r113 = "";
    L5:
        int r100 = r110.getInt("sourceType");
        b88.d r114 = new b88.d("old_version", r100, r113, r110.getString("videoModel"), "", "", null, null, null, null);
        NewsUrlAudioManagerDelegate.f290179b.i(r114, a.f192039a);
    }
}

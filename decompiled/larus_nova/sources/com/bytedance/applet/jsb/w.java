package com.bytedance.applet.jsb;

import android.media.AudioManager;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w extends bx7.c {
    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "applet.getSystemVolumeInfo";
    }

    public w() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Object r103 = AppHost.f326268a.getApplication().getSystemService("audio");
        if ((r103 instanceof AudioManager) == false) goto L5;
        AudioManager r104 = (AudioManager) r103;
    L6:
        Pair[] r105 = new Pair[2];
        if (r104 == null) goto L9;
        int r106 = r104.getStreamVolume(3);
    L10:
        r105[0] = TuplesKt.to(ITTVideoEngineEventSource.KEY_VOLUME, Integer.valueOf(r106));
        if (r104 == null) goto L13;
        int r107 = r104.getStreamMaxVolume(3);
    L14:
        r105[1] = TuplesKt.to("max_volume", Integer.valueOf(r107));
        bx7.c.d(this, r101, MapsKt.mutableMapOf(r105));
        return;
    L13:
        r107 = 15;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}

package com.bytedance.android.livesdk.revenue.network;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PluginType f157219a;

    public final boolean b() {
        return this.f157219a.isInstalled();
    }

    public g(PluginType r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f157219a = r100;
    }

    public final void a(Context r100, c12.i r101) {
        this.f157219a.checkInstall(r100, "", new f(r101), false);
    }
}

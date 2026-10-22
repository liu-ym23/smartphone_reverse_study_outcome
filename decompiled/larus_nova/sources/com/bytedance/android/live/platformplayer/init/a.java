package com.bytedance.android.live.platformplayer.init;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.w51;
import com.bytedance.android.livesdkapi.host.ILivePlayerALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements ILivePlayerALogger {
    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.host.ILivePlayerALogger
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        int r102 = w51.f121499a;
        pm0.b r103 = om0.c.f();
        if (r103 == null) goto L5;
        r103.i(r100, r101);
        return;
    L5:
        ALogger.i(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.host.ILivePlayerALogger
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        int r102 = w51.f121499a;
        pm0.b r103 = om0.c.f();
        if (r103 == null) goto L5;
        r103.e(r100, r101);
        return;
    L5:
        ALogger.e(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.host.ILivePlayerALogger
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        int r102 = w51.f121499a;
        pm0.b r103 = om0.c.f();
        if (r103 == null) goto L5;
        r103.i(r100, r101);
        return;
    L5:
        ALogger.i(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.host.ILivePlayerALogger
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        int r102 = w51.f121499a;
        pm0.b r103 = om0.c.f();
        if (r103 == null) goto L5;
        r103.w(r100, r101);
        return;
    L5:
        ALogger.w(r100, r101);
    }
}

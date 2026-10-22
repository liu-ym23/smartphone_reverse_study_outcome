package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f78766a = 0;

    static {
    }

    public static void a(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        sh0.i0 r101 = sh0.j0.a(null);
        if (r101 != null) goto L5;
    L12:
        r100.put("is_from_game", "0");
        return;
    L5:
        if (r101.g() != true) goto L12;
        int r102 = sh0.h0.f541915a;
        com.bytedance.android.live.liveinteract.revenue.game.e r103 = (com.bytedance.android.live.liveinteract.revenue.game.e) sh0.j0.d(null, "linkmic_game_state");
        r100.put("is_from_game", "1");
        if (r103 == null) goto L10;
        String r104 = r103.f78323b;
        if (r104 == null) goto L10;
    L11:
        r100.put("game_id", r104);
        return;
    L10:
        r104 = "";
        goto L11
    }

    public static void b(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        sh0.i0 r101 = sh0.j0.a(null);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.g() != true) goto L19;
        int r102 = sh0.h0.f541915a;
        com.bytedance.android.live.liveinteract.revenue.game.e r103 = (com.bytedance.android.live.liveinteract.revenue.game.e) sh0.j0.d(null, "linkmic_game_state");
        if (r103 == null) goto L10;
        String r104 = r103.f78324c;
        if (r104 == null) goto L10;
    L11:
        r100.put(FastStartLiveConfig.PLAY_MODE, r104);
        if (r103 == null) goto L15;
        String r105 = r103.f78323b;
        if (r105 == null) goto L15;
    L16:
        r100.put("game_id", r105);
        return;
    L15:
        r105 = "";
    L10:
        r104 = "danmu";
        goto L11
    }
}

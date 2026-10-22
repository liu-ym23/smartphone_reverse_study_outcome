package com.bytedance.android.gamecp.business.download.multichannel;

import android.util.LruCache;
import com.bytedance.android.gamecp.business.download.AppLifecycleObserver;
import com.bytedance.android.gamecp.business.download.GameStatusCacheHelper;
import com.bytedance.android.gamecp.business.download.k1;
import com.bytedance.android.gamecp.business.download.p;
import com.bytedance.android.gamecp.common.utils.PkgInstallChecker;
import com.bytedance.android.gamecp.common.utils.r0;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f52825a = 0;

    static {
    }

    public static Map a(p r100, r0 r101, long r102) {
        LruCache<String, Triple<Integer, Object, Boolean>> r103 = GameStatusCacheHelper.f52434a;
        if (GameStatusCacheHelper.c() == false) goto L5;
    L8:
        Map r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_id", String.valueOf(r100.f52855k)), TuplesKt.to(EventConstants.ExtraJson.GAME_NAME, r100.f52836a0), TuplesKt.to("package_name", String.valueOf(r100.f52860m0))});
    L9:
        r104.put("g_cost_mills", String.valueOf(r102));
        if (r101 == null) goto L12;
        r104.put("g_install_pkg", r101.f57273a);
        r104.put("g_ver_code", String.valueOf(r101.f57275c));
        r104.put("g_install_time", String.valueOf(r101.f57277e));
    L12:
        return r104;
    L5:
        if (PkgInstallChecker.b() == true) goto L8;
        AppLifecycleObserver r105 = k1.f52798a;
        r104 = k1.c(r100);
        goto L9
    }
}

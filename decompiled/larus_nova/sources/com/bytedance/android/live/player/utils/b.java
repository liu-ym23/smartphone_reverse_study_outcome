package com.bytedance.android.live.player.utils;

import com.bytedance.android.livesdkapi.host.ILivePlayerALogger;
import com.bytedance.android.livesdkapi.host.ILivePlayerHostService;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Map<Integer, ConcurrentLinkedQueue<String>> f85849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Integer> f85850b = null;

    static {
        f85849a = new LinkedHashMap();
        f85850b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void b(String r100) {
        ILivePlayerHostService r101 = is0.c.c().hostService();
        if (r101 == null) goto L7;
        ILivePlayerALogger r102 = r101.alog();
        if (r102 == null) goto L7;
        r102.d("tt_live_player", r100);
        return;
    L7:
        Intrinsics.checkNotNull(r100);
    }

    @JvmStatic
    public static final void d(String r100) {
        ILivePlayerHostService r101 = is0.c.c().hostService();
        if (r101 == null) goto L7;
        ILivePlayerALogger r102 = r101.alog();
        if (r102 == null) goto L7;
        r102.e("tt_live_player", r100);
        return;
    L7:
        Intrinsics.checkNotNull(r100);
    }

    @JvmStatic
    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter("LiveVrEffect_VrEffectDownloader", "tag");
        ILivePlayerHostService r101 = is0.c.c().hostService();
        if (r101 == null) goto L7;
        ILivePlayerALogger r102 = r101.alog();
        if (r102 == null) goto L7;
        r102.e("LiveVrEffect_VrEffectDownloader", r100);
        return;
    L7:
        Intrinsics.checkNotNull(r100);
    }

    @JvmStatic
    public static final void f(String r100) {
        ILivePlayerHostService r101 = is0.c.c().hostService();
        if (r101 == null) goto L7;
        ILivePlayerALogger r102 = r101.alog();
        if (r102 == null) goto L7;
        r102.i("tt_live_player", r100);
        return;
    L7:
        Intrinsics.checkNotNull(r100);
    }

    @JvmStatic
    public static final void a(String r100, int r101) {
        Map<Integer, ConcurrentLinkedQueue<String>> r102 = f85849a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        if (r103.get(Integer.valueOf(r101)) != null) goto L10;
        Map<Integer, ConcurrentLinkedQueue<String>> r104 = f85849a;
        Map<Integer, Integer> r105 = f85850b;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        LinkedHashMap r107 = (LinkedHashMap) r104;
        if (r107.get(r106.get(Integer.valueOf(r101))) != null) goto L7;
        ConcurrentLinkedQueue<String> r108 = new ConcurrentLinkedQueue();
        r108.add(String.valueOf(r100));
        f85849a.put(Integer.valueOf(r101), r108);
        return;
    L7:
        Map<Integer, ConcurrentLinkedQueue<String>> r109 = f85849a;
        LinkedHashMap r110 = (LinkedHashMap) r105;
        LinkedHashMap r111 = (LinkedHashMap) r109;
        ConcurrentLinkedQueue r112 = (ConcurrentLinkedQueue) r111.get(r110.get(Integer.valueOf(r101)));
        if (r112 == null) goto L15;
        r112.add(String.valueOf(r100));
        return;
    L15:
        return;
    L10:
        Map<Integer, ConcurrentLinkedQueue<String>> r113 = f85849a;
        LinkedHashMap r114 = (LinkedHashMap) r113;
        ConcurrentLinkedQueue r115 = (ConcurrentLinkedQueue) r114.get(Integer.valueOf(r101));
        if (r115 == null) goto L17;
        r115.add(String.valueOf(r100));
        return;
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILivePlayerHostService r102 = is0.c.c().hostService();
        if (r102 == null) goto L7;
        ILivePlayerALogger r103 = r102.alog();
        if (r103 == null) goto L7;
        r103.d(r100, r101);
        return;
    L7:
        Intrinsics.checkNotNull(r101);
    }

    @JvmStatic
    public static final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ILivePlayerHostService r102 = is0.c.c().hostService();
        if (r102 == null) goto L7;
        ILivePlayerALogger r103 = r102.alog();
        if (r103 == null) goto L7;
        r103.i(r100, r101);
        return;
    L7:
        Intrinsics.checkNotNull(r101);
    }
}

package com.bytedance.android.live.platformplayer;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.utils.h;
import com.bytedance.android.livesdkapi.model.PlayerModularizationConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerViewKt;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class LivePlatformPlayerManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, as0.a> f85442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, com.bytedance.android.live.platformplayer.layout.c> f85443b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f85444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f85445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<Long, as0.a.c> f85446e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f85447f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f85448g = null;

    public static final PlayerModularizationConfig g() {
        return (PlayerModularizationConfig) f85448g.getValue();
    }

    static {
        f85442a = new ConcurrentHashMap();
        f85443b = new ConcurrentHashMap();
        f85446e = new ConcurrentHashMap();
        f85447f = LazyKt.lazy(LivePlatformPlayerManager$playerConfig$2.INSTANCE);
        f85448g = LazyKt.lazy(LivePlatformPlayerManager$modularizationConfig$2.INSTANCE);
    }

    public static as0.a b() {
        return e(f85444c, f85445d);
    }

    public static final ILivePlayerClient f() {
        return c(f85444c, f85445d).player();
    }

    public static boolean i() {
        ILivePlayerClient r100 = f();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isVideoHorizontal();
    }

    @JvmStatic
    public static final void j(h r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        ILivePlayerClient r101 = f();
        if (r101 == null) goto L6;
        r100.a(r101);
        return;
    }

    @JvmStatic
    public static final ILivePlayerClient a(long r100, boolean r101) {
        return c(r100, r101).player();
    }

    @JvmStatic
    public static final as0.a c(long r100, boolean r101) {
        String r102 = h(r100, r101);
        ConcurrentHashMap<String, as0.a> r103 = f85442a;
        as0.a r104 = r103.get(r102);
        if (r104 != null) goto L13;
        com.bytedance.android.live.platformplayer.service.a r105 = (com.bytedance.android.live.platformplayer.service.a) k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r105 == null) goto L19;
        LivePlatformPlayer r106 = r105.m2(r100);
        r103.put(r102, r106);
        r106.log("create room player context, identifier : " + r102);
        Iterator<T> r107 = f85446e.values().iterator();
    L9:
        if (r107.hasNext() == false) goto L20;
        as0.a.c r108 = (as0.a.c) r107.next();
        if (r108.f16074b != r100) goto L9;
        r106.j(r108);
        goto L9
    L20:
        return r106;
    L19:
        return new a();
    L13:
        return r104;
    }

    @JvmStatic
    public static final as0.a e(long r100, boolean r101) {
        return f85442a.get(h(r100, r101));
    }

    public static String h(long r100, boolean r101) {
        as0.a.c r102 = f85446e.get(Long.valueOf(r100));
        if (r102 == null) goto L14;
        Long r103 = Long.valueOf(r102.f16074b);
        if (r103.longValue() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L14;
        r100 = r103.longValue();
        goto L14
    L7:
        r104 = false;
    L14:
        if (r100 < 0) goto L20;
        StringBuilder r105 = new StringBuilder();
        if (r101 == false) goto L18;
        String r106 = "shadow_";
    L19:
        r105.append(r106);
        r105.append("inner_room:");
        r105.append(r100);
        return r105.toString();
    L18:
        r106 = "";
        goto L19
    L20:
        return "default_room";
    }

    @JvmStatic
    public static final void k(long r100, boolean r110) {
        ConcurrentHashMap<Long, as0.a.c> r101 = f85446e;
        Long r102 = null;
        if (r101.containsKey(Long.valueOf(r100)) == false) goto L9;
        as0.a r103 = e(r100, r110);
        if (r103 == null) goto L7;
        r103.j(null);
    L7:
        r101.remove(Long.valueOf(r100));
        ALogger.i(LivePlayerViewKt.TAG, "unBindSameRoom: roomId:" + r100 + " isShadow:" + r110);
        return;
    L9:
        if ((!r101.isEmpty()) == false) goto L33;
        Iterator<T> r104 = r101.values().iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        if (((as0.a.c) r105).f16074b != r100) goto L16;
        boolean r106 = true;
    L17:
        if (r106 == false) goto L12;
    L20:
        as0.a.c r107 = (as0.a.c) r105;
        if (r107 == null) goto L23;
        r102 = Long.valueOf(r107.f16073a);
    L23:
        if (r102 == null) goto L25;
        as0.a.c r108 = f85446e.remove(Long.valueOf(r102.longValue()));
    L25:
        ALogger.i(LivePlayerViewKt.TAG, "unBindSameRoom: newRoomId:" + r102 + " isShadow:" + r110);
        return;
    L16:
        r106 = false;
        goto L17
    L19:
        r105 = null;
        goto L20
    }

    @JvmStatic
    public static final boolean d(long r100, boolean r101, Context r102) {
        String r103 = h(r100, r101);
        ConcurrentHashMap<String, as0.a> r104 = f85442a;
        as0.a r105 = r104.get(r103);
        if (r105 != null) goto L5;
    L10:
        if (r105 == null) goto L12;
        r105.log("failed remove player context from pool");
    L12:
        return false;
    L5:
        if (r105.q(r102) != true) goto L10;
        r105.log("success remove player context from pool");
        if (r104.remove(r103) == null) goto L13;
        return true;
    L13:
        return false;
    }
}

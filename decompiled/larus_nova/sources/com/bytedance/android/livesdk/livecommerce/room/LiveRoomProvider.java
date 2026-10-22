package com.bytedance.android.livesdk.livecommerce.room;

import android.os.Process;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.s;
import com.bytedance.android.livesdk.livecommerce.room.controller.t;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveRoomProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f151373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f151374b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f151375c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Object> f151376d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Object> f151377e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Object f151378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f151379g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LiveRoomProvider f151380h = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/LiveRoomProvider$ECProviderSource;", "", "PREVIEW", "DEFAULT", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ECProviderSource extends Enum<ECProviderSource> {
        public static final ECProviderSource DEFAULT = null;
        public static final ECProviderSource PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ECProviderSource[] f151381a = null;

        static {
            ECProviderSource r100 = new ECProviderSource("PREVIEW", 0);
            PREVIEW = r100;
            ECProviderSource r101 = new ECProviderSource("DEFAULT", 1);
            DEFAULT = r101;
            f151381a = new ECProviderSource[]{r100, r101};
        }

        public static ECProviderSource valueOf(String r100) {
            return (ECProviderSource) r27.a.a(ECProviderSource.class, r100);
        }

        public static ECProviderSource[] values() {
            return (ECProviderSource[]) f151381a.clone();
        }

        public ECProviderSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a extends LruCache<String, Object> implements h {
        @Override // com.bytedance.android.livesdk.livecommerce.room.h
        public final void clear() {
            evictAll();
        }

        public a(int r100) {
            super(r100);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.h
        public final Object getController(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Lazy r102 = LiveRoomProvider.f151373a;
            if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L14;
            if (r101.length() != 0) goto L7;
            boolean r103 = true;
        L8:
            if (r103 == false) goto L12;
            r100 = (String) ((LinkedHashMap) LiveRoomProvider.f151374b).get(r100);
            if (r100 != null) goto L14;
            r100 = "";
            goto L14
        L12:
            r100 = r101;
            goto L14
        L7:
            r103 = false;
        L14:
            return get(r100);
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.h
        public final void a(String r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            Intrinsics.checkNotNullParameter(r101, "uniqueKey");
            Intrinsics.checkNotNullParameter(r102, "controller");
            if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L5;
            Lazy r103 = LiveRoomProvider.f151373a;
            LiveRoomProvider.f151374b.put(r100, r101);
            r100 = r101;
        L5:
            put(r100, r102);
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r100, String r101, Object r102, Object r103) {
            String r104 = r101;
            super.entryRemoved(r100, r104, r102, r103);
            Map<String, String> r105 = LiveRoomProvider.f151374b;
            Iterator r106 = ((LinkedHashMap) r105).entrySet().iterator();
        L3:
            String r107 = null;
            if (r106.hasNext() == false) goto L8;
            Object r108 = r106.next();
            if (Intrinsics.areEqual((String) ((Map.Entry) r108).getValue(), r104) == false) goto L3;
        L9:
            Map.Entry r109 = (Map.Entry) r108;
            if (r109 == null) goto L12;
            r107 = (String) r109.getKey();
        L12:
            if (r105 == null) goto L25;
            TypeIntrinsics.asMutableMap(r105).remove(r107);
            if (r100 == false) goto L21;
            int r110 = com.bytedance.android.livesdk.livecommerce.room.controller.d.f151687a;
            com.bytedance.android.livesdk.livecommerce.room.controller.d.a("out of cache capacity, roomId = " + r104);
            if (ControllerCenter.a() == true) goto L21;
            com.bytedance.android.livesdk.livecommerce.room.controller.c r111 = new com.bytedance.android.livesdk.livecommerce.room.controller.c();
            r111.n("remove controller from cache");
            if (r104 != null) goto L20;
            r104 = "null";
        L20:
            Intrinsics.checkNotNullParameter(r104, "roomId");
            r111.f("c_invoke_room_id", r104);
            Intrinsics.checkNotNullParameter("DEFAULT", "env");
            r111.f("env", "DEFAULT");
        L21:
            if (r102 == null) goto L29;
            Lazy r112 = LiveRoomProvider.f151373a;
            LiveRoomProvider.b(r102);
            return;
        L29:
            return;
        L25:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        L8:
            r108 = null;
            goto L9
        }
    }

    public LiveRoomProvider() {
    }

    public static String e() {
        String r100 = null;
        String r101 = String.valueOf(Process.myPid());     // Catch: Exception -> L8
        String r102 = null;
        r100 = com.bytedance.frameworks.baselib.network.http.util.i.b(ECAppInfoService.f48114e.getApplicationContext());     // Catch: Exception -> L6
    L12:
        return "pid = " + r101 + ", process_name = " + r100 + ", exception = " + r102;
    L6:
        Exception e100 = e;
    L10:
        r102 = Log.getStackTraceString(e100);
    L8:
        e = move-exception;
        e100 = e;
        r101 = null;
        goto L10
    }

    static {
        f151380h = new LiveRoomProvider();
        Lazy r100 = LazyKt.lazy(LiveRoomProvider$MAX_CACHE_SIZE$2.INSTANCE);
        f151373a = r100;
        f151374b = new LinkedHashMap();
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L5;
        h r101 = new com.bytedance.android.livesdk.livecommerce.room.a();
    L6:
        f151375c = r101;
        f151376d = new LinkedHashMap();
        f151377e = new LinkedHashMap();
        f151379g = new g(0);
        return;
    L5:
        r101 = new a(((Number) r100.getValue()).intValue());
        goto L6
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        Iterator<Map.Entry<String, Object>> r101 = f151375c.snapshot().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, Object> r102 = r101.next();
        r100.append(r102.getKey());
        r100.append("_");
        r100.append(r102.getValue().hashCode());
        r100.append(",");
        goto L4
    L7:
        return StringsKt.removeSuffix(r100.toString(), ",");
    }

    public final String f() {
        StringBuilder r100 = new StringBuilder("provider = ");
        r100.append(hashCode());
        r100.append(", cache = ");
        h r101 = f151375c;
        r100.append(r101.hashCode());
        r100.append(", cache_size = ");
        r100.append(r101.snapshot().size());
        return r100.toString();
    }

    public static void b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        dm.a.a("LiveRoomProvider").i("clearController");
        if ((r100 instanceof rd.a) == false) goto L6;
        rd.a r101 = (rd.a) r100;
        r101.onExitRoom();
        r101.onDestroy();
        return;
    L6:
        if ((r100 instanceof ILiveRoomController) == false) goto L10;
        ILiveRoomController r102 = (ILiveRoomController) r100;
        r102.onExitRoom();
        r102.onDestroy();
        return;
    }

    public static com.bytedance.android.livesdk.livecommerce.room.api.b g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Object r102 = f151375c.getController(r100, r101);
        if ((r102 instanceof s) == false) goto L7;
        return ((s) r102).f151714b;
    L7:
        if ((r102 instanceof t) == true) goto L9;
        return null;
    L9:
        return ((t) r102).f151716b;
    }

    public static void c(String r100, String r101, boolean r102) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        Object r103 = f151377e.remove(r100);
        if (r102 == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L18;
        b(r103);
        return;
    L18:
        return;
    L11:
        Iterator r104 = ((LinkedHashMap) f151377e).entrySet().iterator();
    L13:
        if (r104.hasNext() == false) goto L15;
        b(((Map.Entry) r104.next()).getValue());
        goto L13
    L15:
        ((LinkedHashMap) f151377e).clear();
    }

    public static Object d(String r100, String r101, ECProviderSource r110, i r111) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r110, "env");
        Intrinsics.checkNotNullParameter(r111, "factory");
        ECProviderSource r102 = ECProviderSource.PREVIEW;
        if (r110 != r102) goto L14;
        Map<String, Object> r112 = f151376d;
        Object r103 = ((LinkedHashMap) r112).get(r100);
        if (r103 != null) goto L12;
        int r104 = com.bytedance.android.livesdk.livecommerce.room.controller.d.f151687a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = PREVIEW miss cache, generate new controller, roomId = " + r100 + ", uniqueKey = " + r101);
        r103 = r111.b(r100, r101, r102);
        if ((!StringsKt.isBlank(r100)) == false) goto L9;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = PREVIEW put into cache, roomId = " + r100 + ", uniqueKey = " + r101);
        r112.put(r100, r103);
    L13:
        return r103;
    L9:
        String r105 = LiveRoomProvider.class.getSimpleName();
        Intrinsics.checkNotNullParameter("env = PREVIEW illegal roomId", "msg");
        com.bytedance.android.livesdk.livecommerce.room.controller.d.b(r105);
        if (ControllerCenter.a() == true) goto L13;
        com.bytedance.android.livesdk.livecommerce.room.controller.c r106 = new com.bytedance.android.livesdk.livecommerce.room.controller.c();
        r106.n("env = PREVIEW get controller with a blank roomId");
        Intrinsics.checkNotNullParameter("PREVIEW", "env");
        r106.f("env", "PREVIEW");
        r106.k();
        goto L13
    L12:
        int r113 = com.bytedance.android.livesdk.livecommerce.room.controller.d.f151687a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = PREVIEW hit cache, roomId = " + r100 + ", uniqueKey = " + r101);
        goto L13
    L14:
        h r107 = f151375c;
        Object r108 = r107.getController(r100, r101);
        if (r108 != null) goto L20;
        r108 = ((LinkedHashMap) f151377e).get(r100);
        if (r108 == null) goto L20;
        int r109 = com.bytedance.android.livesdk.livecommerce.room.controller.d.f151687a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = " + r110 + " put into cache, roomId = " + r100 + ", uniqueKey = " + r101);
        r107.a(r100, r101, r108);
    L20:
        if ((r108 instanceof Object) == true) goto L22;
        r108 = null;
    L22:
        if (r108 != null) goto L29;
        int r114 = com.bytedance.android.livesdk.livecommerce.room.controller.d.f151687a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = " + r110 + " miss cache, generate new controller, roomId = " + r100 + ", uniqueKey = " + r101);
        r108 = r111.b(r100, r101, r110);
        if ((!StringsKt.isBlank(r100)) == false) goto L26;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("env = " + r110 + " put into cache, roomId = " + r100 + ", uniqueKey = " + r101);
        r107.a(r100, r101, r108);
    L30:
        return r108;
    L26:
        String r115 = LiveRoomProvider.class.getSimpleName();
        Intrinsics.checkNotNullParameter("env = " + r110 + " illegal roomId", "msg");
        com.bytedance.android.livesdk.livecommerce.room.controller.d.b(r115);
        if (ControllerCenter.a() == true) goto L30;
        com.bytedance.android.livesdk.livecommerce.room.controller.c r116 = new com.bytedance.android.livesdk.livecommerce.room.controller.c();
        r116.n("env = " + r110 + " get controller with a blank roomId");
        String r117 = r110.name();
        Intrinsics.checkNotNullParameter(r117, "env");
        r116.f("env", r117);
        r116.k();
        goto L30
    L29:
        int r118 = com.bytedance.android.livesdk.livecommerce.room.controller.d.f151687a;
        com.bytedance.android.livesdk.livecommerce.room.controller.d.a("hit cache, roomId = " + r100 + ", uniqueKey = " + r101);
        goto L30
    }
}

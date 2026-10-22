package com.bytedance.android.ec.hybrid.card.event;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import yj.g;

/* JADX INFO: loaded from: classes44.dex */
public final class ECEventCenterImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f46474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f46475b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<String> f46476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f46477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f46478e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f46479f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f46480g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f46481h = null;

    public static CopyOnWriteArrayList b() {
        return (CopyOnWriteArrayList) f46479f.getValue();
    }

    public static ConcurrentHashMap c() {
        return (ConcurrentHashMap) f46480g.getValue();
    }

    static {
        f46475b = LazyKt.lazy(ECEventCenterImpl$eventValidTime$2.INSTANCE);
        f46478e = LazyKt.lazy(ECEventCenterImpl$clearEventInterval$2.INSTANCE);
        f46479f = LazyKt.lazy(ECEventCenterImpl$eventQueue$2.INSTANCE);
        f46480g = LazyKt.lazy(ECEventCenterImpl$eventSubscribers$2.INSTANCE);
        f46481h = LazyKt.lazy(ECEventCenterImpl$nativeSubscribers$2.INSTANCE);
    }

    public static void a(b r100, f r101) {
        if (r100.f46485d == false) goto L5;
    L8:
        a r102 = r101.f46494d;
        if (r102 == null) goto L11;
        r102.a(r100.f46482a, r100.f46486e);
    L11:
        Lazy r103 = ECMallLogUtil.f47441a;
        com.bytedance.android.ec.hybrid.log.mall.d.a r104 = com.bytedance.android.ec.hybrid.log.mall.d.a.f47465b;
        ECMallLogUtil.c(r104, "ECEventCenter#compatSendEvent(), event = " + r100 + ", subscriber = " + r101);
        Map<String, Object> r105 = r100.f46486e;
        String r106 = r100.f46482a;
        Intrinsics.checkNotNullParameter(r106, "eventName");
        IHybridHostService r107 = com.bytedance.android.ec.hybrid.a.h();
        if (r107 == null) goto L18;
        g r108 = r107.getHostAB();
        if (r108 == null) goto L18;
        Map<String, List<String>> r109 = r108.s();
        if (r109 == null) goto L18;
        List<String> r110 = r109.get("event");
    L19:
        if (r110 != null) goto L21;
    L23:
        ECMallLogUtil.h(r104, r105, "eventName: " + r106 + ",  ");
        return;
    L21:
        if (r110.contains(r106) == false) goto L23;
        return;
    L18:
        r110 = null;
        goto L19
    L5:
        if ((!Intrinsics.areEqual(r100.f46484c, r101.f46491a)) == false) goto L8;
        Lazy r111 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.d.a.f47465b, "ECEventCenter#compatSendEvent(), sceneID is not matched, event#sceneID = " + r100.f46484c + ", subscriber#sceneID = " + r101.f46491a);
    }

    public static boolean d(b r100, Long r101) {
        if (r100.f46487f == false) goto L5;
        return true;
    L5:
        if (r101 == null) goto L7;
        long r102 = r101.longValue();
    L8:
        Lazy r103 = f46475b;
        if (((Long) r103.getValue()) == null) goto L13;
        Long r104 = (Long) r103.getValue();
        Intrinsics.checkNotNull(r104);
        if (r104.longValue() <= 0) goto L13;
        Long r105 = (Long) r103.getValue();
        Intrinsics.checkNotNull(r105);
        long r106 = r105.longValue();
    L15:
        if (Math.abs(r102 - r100.f46483b) <= r106) goto L19;
        return false;
    L19:
        return true;
    L13:
        r106 = 30000;
        goto L15
    L7:
        r102 = System.currentTimeMillis();
        goto L8
    }

    @JvmStatic
    public static final void e(f r100, String r101, boolean r110) {
        if (r101 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) c().get(r101);
        if (r102 != null) goto L8;
        r102 = new CopyOnWriteArrayList();
        c().put(r101, r102);
    L10:
        r102.add(r100);
        c().put(r101, r102);
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.d.a.f47465b, "ECEventCenter#registerSubscriber(), eventName = " + r101 + ", subscriber = " + r100);
        HashSet r104 = new HashSet();
        Iterator r105 = b().iterator();
    L12:
        if (r105.hasNext() == false) goto L22;
        b r106 = (b) r105.next();
        if (Intrinsics.areEqual(r106.f46482a, r101) == false) goto L12;
        if (r100.f46493c <= r106.f46483b) goto L19;
        if (r106.f46487f == false) goto L12;
    L19:
        a(r106, r100);
        if (r110 == false) goto L12;
        r104.add(r106);
        goto L12
    L22:
        b().removeAll(r104);
        return;
    L8:
        if (r102.contains(r100) == false) goto L10;
    }
}

package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p22.n;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements rk6.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f141752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f141753b;

    @Override // rk6.a
    public final boolean c() {
        return false;
    }

    public final void a() {
        Iterator<uc2.b> r100 = this.f141752a.f141747a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().f549423c = null;
        goto L4
    }

    public h(n r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuConfig");
        this.f141753b = r100;
        this.f141752a = new g(r100);
    }

    @Override // rk6.a
    public final void b(vk6.e r110, float r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r110, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r112, "nextPreparedDanmakuSupplier");
        Iterator r100 = r110.iterator();
    L3:
        vk6.e.a r101 = (vk6.e.a) r100;
        if (r101.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r102 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r101.next();
        if (r102.c() < 0) goto L7;
        r102.d((-r111) * this.f141753b.f527443g, 0.0f);
        this.f141752a.getClass();
        g.a(r102);
        goto L3
    L7:
        r101.remove();
        this.f141752a.getClass();
        Intrinsics.checkNotNullParameter(r102, "danmaku");
        uc2.b r103 = r102.f141635e;
        if (r103 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r104 = r103.f549423c;
    L12:
        if (Intrinsics.areEqual(r104, r102) == false) goto L3;
        uc2.b r105 = r102.f141635e;
        if (r105 == null) goto L3;
        r105.f549423c = null;
        goto L3
    L10:
        r104 = null;
        goto L12
    L17:
        g r113 = this.f141752a;
        r113.f141748b.clear();
        Iterator<uc2.b> r106 = r113.f141747a.iterator();
    L19:
        if (r106.hasNext() == false) goto L28;
        uc2.b r107 = r106.next();
        if (r107.f549425e == false) goto L19;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r108 = r107.f549423c;
        if (r108 == null) goto L24;
        float r109 = r108.c();
        n r114 = r113.f141750d;
        if ((r109 + r114.f527442f) >= r114.f527438b) goto L19;
        r113.f141748b.add(Integer.valueOf(r107.f549424d));
        goto L19
    L24:
        r113.f141748b.add(Integer.valueOf(r107.f549424d));
        goto L19
    L28:
        CollectionsKt.sortWith(r113.f141748b, r113.f141749c);
        Iterator<Integer> r115 = r113.f141748b.iterator();
    L30:
        if (r115.hasNext() == false) goto L69;
        int r116 = r115.next().intValue();
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r117 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r112.invoke();
        if (r117 != null) goto L34;
        boolean r118 = true;
    L42:
        if (r118 == false) goto L30;
        return;
    L34:
        g r119 = this.f141752a;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r117, "danmaku");
        uc2.b r120 = (uc2.b) CollectionsKt.getOrNull(r119.f141747a, r116);
        if (r120 != null) goto L37;
    L40:
        i.b("targetLine is null or !enable");
    L41:
        r110.add(r117);
        r118 = false;
        goto L42
    L37:
        if (r120.f549425e == false) goto L40;
        n r121 = r119.f141750d;
        r117.e(r121.f527438b, r116 * (r121.f527440d + r121.f527441e));
        r117.f141636f = r116;
        r117.f141635e = r120;
        g.a(r117);
        goto L41
    }
}

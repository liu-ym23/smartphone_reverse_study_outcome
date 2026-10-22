package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q72.a f141674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uc2.f f141675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f141676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f141677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f141678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f141679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f141680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f141681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f141682i;

    @Override // rk6.a
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void a() {
        this.f141676c.clear();
        this.f141677d.clear();
        this.f141678e.clear();
        ((PriorityQueue) this.f141679f).clear();
    }

    public j(q72.a r100) {
        c r101 = c.f141657a;
        Intrinsics.checkNotNullParameter(r100, "initialConfig");
        Intrinsics.checkNotNullParameter(r101, "linePriorityStrategy");
        super(r100);
        this.f141674a = r100;
        fc2.a r102 = ec2.k.f472030a.getValue();
        this.f141675b = new uc2.f(r100);
        if (r102.controlEnable.booleanValue() == false) goto L5;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r103 = new LimitQueue(r102.eggPendingListThreshold);
    L6:
        this.f141676c = r103;
        if (r102.controlEnable.booleanValue() == false) goto L9;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r104 = new LimitQueue(r102.eggPendingListThreshold);
    L10:
        this.f141677d = r104;
        if (r102.controlEnable.booleanValue() == false) goto L13;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r105 = new LimitQueue(r102.danmakuPendingListThreshold);
    L14:
        this.f141678e = r105;
        this.f141679f = new PriorityQueue(16, i.f141673a);
        this.f141680g = 5;
        this.f141682i = new h(this);
        com.bytedance.android.livesdk.interactivity.utils.e r106 = com.bytedance.android.livesdk.interactivity.utils.e.f141372f;
        Function1<com.bytedance.android.livesdk.interactivity.utils.e, Unit> r107 = new LinearCarnivalDanmakuLayoutManager$1(this);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "action");
        if (ec2.l.f472033a.getValue().booleanValue() == false) goto L18;
        r107.invoke(r106);
        return;
    L18:
        return;
    L13:
        r105 = new LinkedList();
        goto L14
    L9:
        r104 = new LinkedList();
        goto L10
    L5:
        r103 = new LinkedList();
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void d(q72.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        this.f141674a = r100;
        this.f141675b.e(r100);
        this.f141681h = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void e(int r100) {
        this.f141680g = r100;
    }

    @Override // rk6.a
    public final void b(vk6.e r110, float r111, Function0 r112) {
        Intrinsics.checkNotNullParameter(r110, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r112, "nextPreparedDanmakuSupplier");
        q72.a r100 = this.f141674a;
        int r101 = r100.f531917b;
        int r102 = r100.f531918c;
        Iterator r103 = r110.iterator();
    L3:
        vk6.e.a r104 = (vk6.e.a) r103;
        if (r104.hasNext() == false) goto L30;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r105 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r104.next();
        if (this.f141674a.f531922g == false) goto L8;
        if (r105.a() <= r101) goto L29;
        r104.remove();
        Intrinsics.checkNotNullParameter(r105, "danmaku");
        uc2.b r106 = r105.f141635e;
        if (r106 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r107 = r106.f549423c;
    L25:
        if (Intrinsics.areEqual(r107, r105) == false) goto L3;
        uc2.b r108 = r105.f141635e;
        if (r108 == null) goto L3;
        r108.f549423c = null;
        goto L3
    L23:
        r107 = null;
    L29:
        r105.m(r111, this.f141674a.f531922g);
        this.f141675b.f(r105.f141636f, r105);
        goto L3
    L8:
        if (r105.c() >= 0) goto L29;
        r104.remove();
        Intrinsics.checkNotNullParameter(r105, "danmaku");
        uc2.b r109 = r105.f141635e;
        if (r109 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r113 = r109.f549423c;
    L14:
        if (Intrinsics.areEqual(r113, r105) == false) goto L3;
        uc2.b r114 = r105.f141635e;
        if (r114 == null) goto L3;
        r114.f549423c = null;
        goto L3
    L12:
        r113 = null;
        goto L14
    L30:
        Iterator<Integer> r115 = this.f141675b.a(this.f141682i).iterator();
    L32:
        if (r115.hasNext() == false) goto L94;
        int r116 = r115.next().intValue();
        boolean r117 = true;
        if ((this.f141674a.f531919d * r116) > r102) goto L93;
        if (r116 == 0) goto L38;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r118 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r112.invoke();
    L42:
        if (r118 == null) goto L60;
        int r119 = g.f141671a[r118.getType().ordinal()];
        if (r119 != 1) goto L46;
        this.f141677d.add(r118);
        goto L60
    L46:
        if (r119 == 2) goto L57;
        tc2.f r120 = (tc2.f) r118.b().e(tc2.f.class);
        if (r120 == null) goto L50;
        Integer r121 = r120.f545385d;
    L51:
        if (r121 != null) goto L54;
    L56:
        this.f141678e.add(r118);
        goto L60
    L54:
        if (r121.intValue() != 0) goto L56;
        ((PriorityQueue) this.f141679f).add(r118);
        goto L60
    L50:
        r121 = null;
        goto L51
    L57:
        this.f141676c.add(r118);
    L60:
        if (CarnivalDanmakuWidget.A == false) goto L79;
        if (this.f141681h < this.f141680g) goto L79;
        if ((!this.f141676c.isEmpty()) == false) goto L66;
        Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r122 = this.f141676c;
    L68:
        if (r122.size() <= 0) goto L92;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r123 = r122.remove();
        tc2.f r124 = (tc2.f) r123.b().e(tc2.f.class);
        if (r124 == null) goto L72;
        Boolean r125 = r124.f545384c;
    L74:
        if (Intrinsics.areEqual(r125, Boolean.TRUE) == false) goto L76;
        uc2.f r126 = this.f141675b;
        r126.d(r126.f549437a.size() - 1, r123);
    L77:
        r110.add(r123);
        this.f141681h = 0;
    L86:
        if (this.f141678e.isEmpty() == false) goto L92;
        if (this.f141679f.isEmpty() == false) goto L92;
        if (this.f141677d.isEmpty() == false) goto L92;
    L76:
        this.f141675b.d(r116, r123);
        goto L77
    L72:
        r125 = null;
    L92:
        r117 = false;
        goto L93
    L66:
        r122 = this.f141677d;
    L79:
        if (this.f141678e.size() <= 0) goto L92;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r127 = this.f141678e.remove();
        this.f141675b.d(r116, r127);
        r110.add(r127);
        this.f141681h++;
        com.bytedance.android.livesdk.interactivity.utils.e.f141372f.getClass();
        com.bytedance.android.livesdk.interactivity.utils.e.f141368b++;
        if (v.a() == false) goto L86;
        if (CarnivalAutoTestUtil.f133551a == false) goto L86;
        CarnivalAutoTestUtil.a();
        goto L86
    L38:
        if ((!this.f141679f.isEmpty()) == false) goto L40;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r128 = this.f141679f.remove();
        com.bytedance.android.livesdk.interactivity.utils.e.f141372f.getClass();
        com.bytedance.android.livesdk.interactivity.utils.e.f141368b++;
        this.f141675b.d(r116, r128);
        r110.add(r128);
        this.f141681h++;
        goto L92
    L40:
        r118 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r112.invoke();
    L93:
        if (r117 == false) goto L32;
        return;
    }
}

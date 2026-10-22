package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

import com.bytedance.android.livesdk.interactivity.barrage.widget.CarnivalDanmakuWidget;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q72.a f141664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final uc2.f f141665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f141666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.zdanmaku.i> f141667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f141668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f141669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f141670g;

    @Override // rk6.a
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void a() {
        ((ArrayList) this.f141666c).clear();
        ((ArrayList) this.f141667d).clear();
    }

    public e(q72.a r100) {
        c r101 = c.f141657a;
        Intrinsics.checkNotNullParameter(r100, "initialConfig");
        Intrinsics.checkNotNullParameter(r101, "linePriorityStrategy");
        super(r100);
        this.f141664a = r100;
        this.f141665b = new uc2.f(r100);
        this.f141666c = new ArrayList();
        this.f141667d = new ArrayList();
        this.f141668e = 5;
        this.f141670g = new d(this, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void d(q72.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        this.f141664a = r100;
        this.f141665b.e(r100);
        this.f141669f = 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.a
    public final void e(int r100) {
        this.f141668e = r100;
    }

    @Override // rk6.a
    public final void b(vk6.e r100, float r101, Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "runningDanmakuList");
        Intrinsics.checkNotNullParameter(r110, "nextPreparedDanmakuSupplier");
        q72.a r102 = this.f141664a;
        int r103 = r102.f531917b;
        int r104 = r102.f531918c;
        Iterator r105 = r100.iterator();
    L3:
        vk6.e.a r106 = (vk6.e.a) r105;
        if (r106.hasNext() == false) goto L14;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r107 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r106.next();
        if (this.f141664a.f531922g == false) goto L8;
        if (r107.a() <= r103) goto L13;
        r106.remove();
    L13:
        r107.m(r101, this.f141664a.f531922g);
        this.f141665b.f(r107.f141636f, r107);
        goto L3
    L8:
        if (r107.c() >= 0) goto L13;
        r106.remove();
        goto L3
    L14:
        uc2.f r108 = this.f141665b;
        d r109 = this.f141670g;
        r109.f141658a = r103;
        r109.f141659b = this.f141664a.f531916a;
        Unit r111 = Unit.INSTANCE;
        Iterator<Integer> r112 = r108.a(r109).iterator();
    L16:
        if (r112.hasNext() == false) goto L47;
        int r113 = r112.next().intValue();
        boolean r114 = true;
        if ((this.f141664a.f531919d * r113) > r104) goto L46;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r115 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r110.invoke();
        if (r115 == null) goto L46;
        if (r115.getType() != DanmakuType.CarnivalEgg) goto L26;
        ((ArrayList) this.f141666c).add(r115);
    L28:
        if (CarnivalDanmakuWidget.A == false) goto L43;
        if (this.f141669f < this.f141668e) goto L43;
        if (((ArrayList) this.f141666c).size() <= 0) goto L45;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r116 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) ListProtector.remove(this.f141666c, 0);
        tc2.f r117 = (tc2.f) r115.b().e(tc2.f.class);
        if (r117 == null) goto L36;
        Boolean r118 = r117.f545384c;
    L38:
        if (Intrinsics.areEqual(r118, Boolean.TRUE) == false) goto L40;
        uc2.f r119 = this.f141665b;
        r119.d(r119.f549437a.size() - 1, r116);
    L41:
        r100.add(r116);
        this.f141669f = 0;
        goto L45
    L40:
        this.f141665b.d(r113, r116);
        goto L41
    L36:
        r118 = null;
    L45:
        r114 = false;
    L43:
        if (((ArrayList) this.f141667d).size() <= 0) goto L45;
        com.bytedance.android.livesdk.interactivity.zdanmaku.i r120 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) ListProtector.remove(this.f141667d, 0);
        this.f141665b.d(r113, r120);
        r100.add(r120);
        this.f141669f++;
        goto L45
    L26:
        ((ArrayList) this.f141667d).add(r115);
    L46:
        if (r114 == false) goto L16;
        return;
    }
}

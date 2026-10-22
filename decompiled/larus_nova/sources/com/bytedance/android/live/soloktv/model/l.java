package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.live.soloktv.view.SegmentSelectResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static final k a(k r110) {
        Intrinsics.checkNotNullParameter(r110, "$this$deepCopy");
        k r100 = new k(r110.a(), fb1.b.a(r110.c()), fb1.e.a(r110.d()));
        eb1.f r101 = r110.b();
        Intrinsics.checkNotNullParameter(r101, "$this$deepCopy");
        eb1.f r102 = new eb1.f();
        r102.v(r101.j());
        r102.w(r101.k());
        r102.x(r101.l());
        r102.q(r101.e());
        r102.s(r101.g());
        eb1.b r103 = r101.a();
        Intrinsics.checkNotNullParameter(r103, "$this$deepCopy");
        eb1.b r104 = new eb1.b();
        CopyOnWriteArrayList<eb1.a> r105 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<eb1.a> r106 = r103.b();
        if ((!r106.isEmpty()) == true) goto L6;
        r106 = null;
    L6:
        if (r106 == null) goto L8;
        r105.addAll(r106);
    L8:
        r104.c(r105);
        r102.m(r104);
        eb1.e r107 = r101.f();
        Intrinsics.checkNotNullParameter(r107, "$this$deepCopy");
        eb1.e r108 = new eb1.e();
        CopyOnWriteArrayList<eb1.d> r109 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<eb1.d> r111 = r107.b();
        if ((!r111.isEmpty()) == true) goto L12;
        r111 = null;
    L12:
        if (r111 == null) goto L14;
        r109.addAll(r111);
    L14:
        r108.c(r109);
        ArrayList r112 = new ArrayList();
        List<cb0.c> r113 = r107.f471794a;
        if (r113 != null) goto L17;
    L31:
        r108.f471794a = r112;
        r102.r(r108);
        SegmentSelectResult r114 = r101.h();
        if (r114 == null) goto L34;
        Intrinsics.checkNotNullParameter(r114, "$this$deepCopy");
        SegmentSelectResult r115 = new SegmentSelectResult(r114.c(), r114.a(), r114.d(), r114.b());
    L35:
        r102.t(r115);
        List<eb1.c> r116 = r101.d();
        if (r116 == null) goto L38;
        ArrayList r117 = new ArrayList();
        r117.addAll(r116);
        Unit r118 = Unit.INSTANCE;
        r102.p(r117);
    L38:
        r102.u(r101.i());
        r102.n(r101.b());
        r100.e(r102);
        List<com.bytedance.component.lyric.model.b> r119 = r110.f101398a;
        if (r119 == null) goto L41;
        ArrayList r120 = new ArrayList();
        r100.f101398a = r120;
        r120.addAll(r119);
    L41:
        return r100;
    L34:
        r115 = null;
        goto L35
    L17:
        if ((!r113.isEmpty()) == true) goto L20;
        r113 = null;
    L20:
        if (r113 == null) goto L31;
        Iterator<T> r121 = r113.iterator();
    L23:
        if (r121.hasNext() == false) goto L31;
        cb0.c r122 = (cb0.c) r121.next();
        ArrayList r123 = new ArrayList();
        List<cb0.a> r124 = r122.f22993c;
        if (r124 == null) goto L30;
        Iterator<T> r125 = r124.iterator();
    L28:
        if (r125.hasNext() == false) goto L30;
        cb0.a r126 = (cb0.a) r125.next();
        ArrayList r127 = r123;
        r127.add(new cb0.a(r126.f22988a, r126.f22989b));
        r123 = r127;
    L30:
        cb0.a r128 = r122.f22991a;
        r112.add(new cb0.c(new cb0.a(r128.f22988a, r128.f22989b), r122.f22992b, r123));
        goto L23
    }
}

package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e implements tb0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tb0.c f70685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<m> f70686b;

    @Override // tb0.a
    public final void onBizDestory() {
    }

    @Override // tb0.a
    public final void onBizEnterRoom() {
    }

    @Override // tb0.a
    public final void onBizHide() {
    }

    @Override // tb0.a
    public final void onBizLeaveRoom() {
    }

    @Override // tb0.a
    public final void onBizShow() {
    }

    public e() {
        this.f70685a = tb0.c.C7707c.f545227c;
        this.f70686b = new CopyOnWriteArrayList();
    }

    public final void a(tb0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lc");
        this.f70686b.add(new d(r100));
    }

    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        if ((this.f70685a instanceof tb0.c.b) == true) goto L5;
        Lazy r101 = KtvCommonSettingHelper.f142336a;
        return;
    L5:
        r100.invoke();
    }

    public final void c(tb0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "lc");
        CopyOnWriteArrayList<m> r101 = this.f70686b;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        m r105 = (m) r104;
        if ((r105 instanceof d) == true) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        if (Intrinsics.areEqual(((d) r105).f70684a, r100) == false) goto L10;
        r106 = true;
        goto L11
    L13:
        this.f70686b.removeAll(r102);
    }

    public final void d(tb0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        tb0.c r101 = this.f70685a;
        if ((r100 instanceof tb0.b.a) == false) goto L6;
        this.f70685a = new tb0.c.b(r100);
    L12:
        Iterator<m> r102 = this.f70686b.iterator();
    L14:
        if (r102.hasNext() == false) goto L17;
        r102.next().a(r100, this.f70685a);
        goto L14
    L17:
        if ((!Intrinsics.areEqual(r101.f545226b, this.f70685a.f545226b)) == false) goto L22;
        Iterator<m> r103 = this.f70686b.iterator();
    L20:
        if (r103.hasNext() == false) goto L25;
        r103.next().b(this.f70685a);
        goto L20
    L25:
        return;
    L22:
        return;
    L6:
        if ((r100 instanceof tb0.b.C7706b) == false) goto L9;
        this.f70685a = new tb0.c.a(r100);
        goto L12
    L9:
        if ((r100 instanceof tb0.b.e) == false) goto L11;
        this.f70685a = tb0.c.C7707c.f545227c;
        goto L12
    L11:
        r101.f545225a = r100;
        goto L12
    }
}

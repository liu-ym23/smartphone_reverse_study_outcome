package com.bytedance.android.shopping.ligo.context;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w83.c;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T extends w83.c> implements w83.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<z83.a> f176451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Pair<ViewGroup, View>> f176452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, a93.a<?>> f176453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f176454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final T f176455e;

    public static final class a {
    }

    static {
    }

    @Override // w83.d
    public final w83.b<T> a() {
        return new com.bytedance.android.shopping.ligo.context.a(this, this.f176455e);
    }

    public b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f176455e = r100;
        CopyOnWriteArrayList<z83.a> r101 = new CopyOnWriteArrayList();
        this.f176451a = r101;
        this.f176452b = new LinkedHashMap();
        this.f176453c = new LinkedHashMap();
        c r102 = new c();
        r101.add(r102);
        Unit r103 = Unit.INSTANCE;
        this.f176454d = r102;
    }

    public final <T> T d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a93.a r101 = (a93.a) ((LinkedHashMap) this.f176453c).get(r100);
        if (r101 != null) goto L5;
    L8:
        T r102 = null;
    L10:
        if ((r102 instanceof Object) == true) goto L13;
        return null;
    L13:
        return (T) r102;
    L5:
        if (r101.f2273a != 1) goto L8;
        r102 = r101.f2274b;
        goto L10
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        dm.a.a("LigoContext").a("removeGlobalProperty: key=".concat(r100));
        if (this.f176453c.containsKey(r100) == false) goto L6;
        this.f176453c.remove(r100);
        return;
    }

    public final void g(z83.b r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        dm.a.a("LigoContext").i("send event: " + r100.f570911a);
        Iterator r101 = CollectionsKt.toMutableList(this.f176451a).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        ((z83.a) r101.next()).onEvent(r100);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w83.d
    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("live_commerce", "bizName");
        dm.a.a("LigoContext").a("putGlobalProperty: key=" + r100 + ", value=" + r101 + ", bizName=live_commerce");
        if (this.f176453c.containsKey(r100) == true) goto L5;
        this.f176453c.put(r100, new a93.a());
    L5:
        a93.a r102 = (a93.a) ((LinkedHashMap) this.f176453c).get(r100);
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.f2273a == 2) goto L25;
        r102.f2273a = 1;
        if ((r101 instanceof Object) == true) goto L13;
        T r103 = 0;
    L14:
        if (r103 == 0) goto L23;
        T r104 = r102.f2274b;
        r102.f2274b = r103;
        if ((!Intrinsics.areEqual(r104, r101)) == false) goto L24;
        Iterator r105 = ((ArrayList) r102.f2275c).iterator();
    L19:
        if (r105.hasNext() == false) goto L26;
        ((a93.b) r105.next()).a(r102.f2274b);
        goto L19
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r103 = r101;
        goto L14
    }

    public final void c(String r100, a93.b r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter("live_commerce", "bizName");
        if (this.f176453c.containsKey(r100) == true) goto L5;
        this.f176453c.put(r100, new a93.a());
    L5:
        a93.a r102 = (a93.a) ((LinkedHashMap) this.f176453c).get(r100);
        if (r102 == null) goto L15;
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r102.f2273a == 2) goto L18;
        if (r101 == null) goto L16;
        ((ArrayList) r102.f2275c).add(r101);
        T r103 = r102.f2274b;
        if (r103 == 0) goto L17;
        r101.a(r103);
        return;
    L17:
        return;
    L16:
        return;
    L18:
        return;
    }

    public final void e(String r100, ViewGroup r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        this.f176452b.put(r100, new Pair(r101, r102));
    }
}

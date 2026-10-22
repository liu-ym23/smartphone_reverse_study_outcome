package com.bytedance.android.live.broadcastgame.xplay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<g10.b> f62349a = null;

    static {
        f62349a = new LinkedHashSet();
    }

    public static List b() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = f62349a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        g10.b r102 = (g10.b) r101.next();
        if ((r102 instanceof g10.e) == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public static void a(IXplayMainService.State r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        int r103 = r.f62347a[r100.ordinal()];
        if (r103 != 1) goto L5;
        Set<g10.b> r104 = f62349a;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        if ((r107 instanceof g10.c) == false) goto L19;
        r105.add(r107);
        goto L19
    L23:
        Iterator r108 = r105.iterator();
    L25:
        if (r108.hasNext() == false) goto L41;
        ((g10.c) r108.next()).f();
        goto L25
    L41:
        return;
    L5:
        if (r103 != 2) goto L27;
        Set<g10.b> r109 = f62349a;
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r109.iterator();
    L9:
        if (r111.hasNext() == false) goto L13;
        Object r112 = r111.next();
        if ((r112 instanceof g10.c) == false) goto L9;
        r110.add(r112);
        goto L9
    L13:
        Iterator r113 = r110.iterator();
    L15:
        if (r113.hasNext() == false) goto L40;
        ((g10.c) r113.next()).b();
        goto L15
    L40:
        return;
    }
}

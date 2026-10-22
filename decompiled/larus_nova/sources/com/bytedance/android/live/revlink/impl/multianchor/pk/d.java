package com.bytedance.android.live.revlink.impl.multianchor.pk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f94502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f94503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final T f94504c;

    public final Map<String, T> a(List<? extends af2.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreList");
        HashMap r101 = new HashMap();
        Iterator<? extends af2.b> r102 = r100.iterator();
        String r103 = null;
    L4:
        if (r102.hasNext() == false) goto L8;
        af2.b r104 = r102.next();
        if (((int) r104.getBattleRank()) != 1) goto L4;
        r103 = af2.c.a(r104);
        goto L4
    L8:
        Iterator<? extends af2.b> r105 = r100.iterator();
    L10:
        if (r105.hasNext() == false) goto L20;
        af2.b r106 = r105.next();
        String r107 = af2.c.a(r106);
        if (r107 == null) goto L10;
        if (r103 == null) goto L15;
        if (Intrinsics.areEqual(r103, af2.c.a(r106)) == true) goto L18;
        r101.put(r107, this.f94503b);
        goto L10
    L18:
        r101.put(r107, this.f94502a);
        goto L10
    L15:
        r101.put(r107, this.f94504c);
        goto L10
    L20:
        return r101;
    }

    public final Map<String, T> b(List<? extends af2.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "scoreList");
        HashMap r100 = new HashMap();
        List<? extends af2.b> r101 = r110;
        boolean r102 = true;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L16;
        if (((af2.b) r103.next()).getMultiPkTeamRank() != 1) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
        r102 = false;
        goto L16
    L13:
        r104 = false;
    L16:
        if (r102 == false) goto L24;
        Iterator<? extends af2.b> r111 = r110.iterator();
    L19:
        if (r111.hasNext() == false) goto L23;
        String r105 = af2.c.a(r111.next());
        if (r105 == null) goto L19;
        r100.put(r105, this.f94504c);
        goto L19
    L23:
        return r100;
    L24:
        Iterator<? extends af2.b> r112 = r110.iterator();
    L26:
        if (r112.hasNext() == false) goto L34;
        af2.b r106 = r112.next();
        String r107 = af2.c.a(r106);
        if (r107 == null) goto L26;
        if (r106.getMultiPkTeamRank() != 1) goto L32;
        T r108 = this.f94502a;
    L33:
        r100.put(r107, r108);
        goto L26
    L32:
        r108 = this.f94503b;
        goto L33
    L34:
        return r100;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    public d(T r100, T r101, T r102) {
        this.f94502a = r100;
        this.f94503b = r101;
        this.f94504c = r102;
    }
}

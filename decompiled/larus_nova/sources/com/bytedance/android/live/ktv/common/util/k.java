package com.bytedance.android.live.ktv.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f70691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<v> f70692b;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Iterator<v> r100 = this.f70692b.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        v r101 = r100.next();
        if (r101.f70703b.getOneDrawCallback() != null) goto L4;
        r101.f70703b.setOneDrawCallback(new ViewStatisticsWrapper$startWatchNextDraw$1(r101));
        goto L4
    }

    public k() {
        this.f70692b = new ArrayList();
    }

    public final void b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewStatistics");
        String r101 = r100.getTypeName();
        Iterator<v> r102 = this.f70692b.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        v r103 = r102.next();
        if (Intrinsics.areEqual(r103.f70702a, r101) == false) goto L4;
    L9:
        v r104 = r103;
        if (r104 == null) goto L12;
        this.f70692b.remove(r104);
    L12:
        ArrayList<v> r105 = this.f70692b;
        v r106 = new v(r101, r100, this);
        if (r106.f70703b.getOneDrawCallback() != null) goto L16;
        r106.f70703b.setOneDrawCallback(new ViewStatisticsWrapper$startWatchNextDraw$1(r106));
    L16:
        Unit r107 = Unit.INSTANCE;
        r105.add(r106);
        return;
    L8:
        r103 = null;
        goto L9
    }
}

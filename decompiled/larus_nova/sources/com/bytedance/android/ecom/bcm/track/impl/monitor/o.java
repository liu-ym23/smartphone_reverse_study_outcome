package com.bytedance.android.ecom.bcm.track.impl.monitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g> f51133b;

    public o(com.bytedance.android.ecom.bcm.track.impl.setting.h r110) {
        this.f51132a = r110.c();
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r110.b().iterator();
    L4:
        if (r101.hasNext() == false) goto L18;
        String r102 = (String) r101.next();
        g.a r103 = g.f51114a;
        String r104 = r110.a();
        if (r110.d() == 0) goto L8;
        boolean r111 = true;
    L9:
        r103.getClass();
        Iterator r105 = CollectionsKt.asReversed(StringsKt.split$default(r102, new String[]{"."}, false, 0, 6, null)).iterator();
        g r106 = null;
    L11:
        if (r105.hasNext() == false) goto L16;
        String r107 = (String) r105.next();
        if (r106 == null) goto L14;
        r106 = new i(StringsKt.trimEnd(r107, new char[]{'[', ']'}), r106);
        goto L11
    L14:
        r106 = new p(r107, r104, r111);
        goto L11
    L16:
        if (r106 == null) goto L4;
        r100.add(r106);
        goto L4
    L8:
        r111 = false;
        goto L9
    L18:
        this.f51133b = r100;
    }
}

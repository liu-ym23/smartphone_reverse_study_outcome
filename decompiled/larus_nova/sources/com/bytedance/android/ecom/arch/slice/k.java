package com.bytedance.android.ecom.arch.slice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements zp.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcContext f50078a;

    public k(SlcContext r100) {
        this.f50078a = r100;
    }

    @Override // zp.b
    public final Object a(zp.a r100, List<? extends Object> r101) {
        if (r101 == null) goto L5;
        Object r102 = CollectionsKt.getOrNull(r101, 0);
    L7:
        if ((r102 instanceof List) == true) goto L9;
        r102 = null;
    L9:
        List r103 = (List) r102;
        if (r103 == null) goto L31;
        List<g> r104 = this.f50078a.u();
        if (r104 == null) goto L32;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L15:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        if (CollectionsKt.contains(r103, ((g) r107).getSliceId()) == false) goto L15;
        r105.add(r107);
        goto L15
    L19:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r109 = r105.iterator();
    L21:
        if (r109.hasNext() == false) goto L24;
        r108.add(((g) r109.next()).getData());
        goto L21
    L24:
        return r108;
    L32:
        return null;
    L31:
        return null;
    L5:
        r102 = null;
        goto L7
    }
}

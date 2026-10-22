package com.bytedance.android.ecom.arch.slice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements zp.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcContext f50076a;

    public i(SlcContext r100) {
        this.f50076a = r100;
    }

    @Override // zp.b
    public final Object a(zp.a r100, List<? extends Object> r101) {
        List<g> r102 = this.f50076a.u();
        if (r102 == null) goto L8;
        List<g> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L11;
        r104.add(((g) r105.next()).getData());
        goto L6
    L11:
        return r104;
    L8:
        return null;
    }
}

package com.bytedance.android.ecom.arch.slice;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements zp.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlcContext f50077a;

    public j(SlcContext r100) {
        this.f50077a = r100;
    }

    @Override // zp.b
    public final Object a(zp.a r100, List<? extends Object> r101) {
        if (r101 == null) goto L5;
        Object r102 = CollectionsKt.getOrNull(r101, 0);
    L7:
        if ((r102 instanceof String) == true) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 == null) goto L22;
        List<g> r104 = this.f50077a.u();
        if (r104 == null) goto L26;
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L21;
        g r106 = (g) r105.next();
        if (Intrinsics.areEqual(r106.getSliceId(), r103) == false) goto L15;
        if (r106 != null) goto L28;
        return null;
    L28:
        return r106.getData();
    L21:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L26:
        return null;
    L22:
        return null;
    L5:
        r102 = null;
        goto L7
    }
}

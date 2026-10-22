package com.bytedance.android.ecom.arch.slice;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements zp.b {
    public n() {
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
        if (r103 != null) goto L12;
        return null;
    L12:
        if (r103.isEmpty() == false) goto L16;
        return Boolean.FALSE;
    L16:
        if (r103.size() == 1) goto L18;
        Iterator r104 = r103.iterator();
        if (r104.hasNext() == false) goto L32;
        Object r105 = r104.next();
    L23:
        if (r104.hasNext() == false) goto L30;
        boolean r106 = ((Boolean) r104.next()).booleanValue();
        if (((Boolean) r105).booleanValue() == false) goto L28;
        if (r106 == false) goto L28;
        boolean r107 = true;
    L29:
        r105 = Boolean.valueOf(r107);
    L28:
        r107 = false;
        goto L29
    L30:
        return r105;
    L32:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    L18:
        return ListProtector.get(r103, 0);
    L5:
        r102 = null;
        goto L7
    }
}

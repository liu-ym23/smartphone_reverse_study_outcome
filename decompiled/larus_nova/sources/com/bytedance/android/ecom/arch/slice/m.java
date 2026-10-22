package com.bytedance.android.ecom.arch.slice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements zp.b {
    public m() {
    }

    @Override // zp.b
    public final Object a(zp.a r100, List<? extends Object> r101) {
        boolean r102 = false;
        if (r101 == null) goto L5;
        Object r103 = CollectionsKt.getOrNull(r101, 0);
    L7:
        if ((r103 instanceof List) == true) goto L9;
        r103 = null;
    L9:
        List r104 = (List) r103;
        if (r101 == null) goto L12;
        Object r105 = CollectionsKt.getOrNull(r101, 1);
    L14:
        if ((r105 instanceof String) == true) goto L16;
        r105 = null;
    L16:
        String r106 = (String) r105;
        if (r104 != null) goto L19;
    L38:
        return null;
    L19:
        if ((!r104.isEmpty()) == false) goto L38;
        if (r106 == null) goto L38;
        if (r106.length() <= 0) goto L24;
        r102 = true;
    L24:
        if (r102 == false) goto L38;
        ArrayList r107 = new ArrayList();
        Iterator r108 = r104.iterator();
    L27:
        if (r108.hasNext() == false) goto L37;
        Object r109 = r108.next();
        if ((r109 instanceof Map) == true) goto L31;
        r109 = null;
    L31:
        Map r110 = (Map) r109;
        if (r110 == null) goto L34;
        Object r111 = r110.get(r106);
    L35:
        if (r111 == null) goto L27;
        r107.add(r111);
        goto L27
    L34:
        r111 = null;
        goto L35
    L37:
        return r107;
    L12:
        r105 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }
}

package com.bytedance.android.bcm.impl.paramcheck.checker;

import com.bytedance.android.bcm.api.model.BcmParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements d {
    public e() {
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.checker.d
    public final List<a> a(com.bytedance.android.bcm.impl.paramcheck.c r100, com.bytedance.android.bcm.impl.paramcheck.a r101, boolean r102) {
        List<com.bytedance.android.bcm.impl.model.f> r103 = r101.f41865a;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if (((com.bytedance.android.bcm.impl.model.f) r106).e() == false) goto L4;
        r104.add(r106);
        goto L4
    L8:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r108 = r104.iterator();
    L10:
        if (r108.hasNext() == false) goto L12;
        r107.add(((com.bytedance.android.bcm.impl.model.f) r108.next()).a());
        goto L10
    L12:
        Set r109 = CollectionsKt.toMutableSet(r107);
        BcmParams r110 = r100.b();
        if (r110 == null) goto L19;
        Map<String, Object> r111 = r110.toMap();
        if (r111 == null) goto L19;
        Set<String> r112 = r111.keySet();
        if (r112 == null) goto L19;
        r109.removeAll(r112);
    L19:
        Set r113 = r109;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
    L21:
        if (r115.hasNext() == false) goto L23;
        r114.add(c.a((String) r115.next(), BcmCheckErrorType.MISS_PARAM, null, null));
        goto L21
    L23:
        return r114;
    }
}

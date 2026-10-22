package com.bytedance.android.bcm.impl.paramcheck.checker;

import com.bytedance.android.bcm.api.model.BcmParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f41879a = null;

    public static final class a {
    }

    public h() {
    }

    static {
        f41879a = SetsKt.emptySet();
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.checker.d
    public final List<com.bytedance.android.bcm.impl.paramcheck.checker.a> a(com.bytedance.android.bcm.impl.paramcheck.c r100, com.bytedance.android.bcm.impl.paramcheck.a r101, boolean r102) {
        BcmParams r103 = r100.b();
        if (r103 == null) goto L25;
        List<com.bytedance.android.bcm.impl.model.f> r104 = r101.f41865a;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        r105.add(((com.bytedance.android.bcm.impl.model.f) r106.next()).a());
        goto L6
    L8:
        Set<String> r107 = r103.toMap().keySet();
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L10:
        if (r109.hasNext() == false) goto L19;
        Object r110 = r109.next();
        String r111 = (String) r110;
        if (f41879a.contains(r111) == true) goto L14;
    L16:
        boolean r112 = false;
    L17:
        if (r112 == false) goto L10;
        r108.add(r110);
        goto L10
    L14:
        if (r105.contains(r111) == true) goto L16;
        r112 = true;
        goto L17
    L19:
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r114 = r108.iterator();
    L21:
        if (r114.hasNext() == false) goto L23;
        r113.add(c.a((String) r114.next(), BcmCheckErrorType.UNNEEDED_PARAM, null, null));
        goto L21
    L23:
        return r113;
    L25:
        return CollectionsKt.emptyList();
    }
}

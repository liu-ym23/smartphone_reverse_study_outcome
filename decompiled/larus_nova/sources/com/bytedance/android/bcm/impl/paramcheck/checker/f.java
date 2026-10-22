package com.bytedance.android.bcm.impl.paramcheck.checker;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bcm.impl.model.ValueType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f41877a = null;

    public static final class a {
    }

    public f() {
    }

    static {
        f41877a = CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.bcm.impl.paramcheck.checker.d
    public final List<com.bytedance.android.bcm.impl.paramcheck.checker.a> a(com.bytedance.android.bcm.impl.paramcheck.c r110, com.bytedance.android.bcm.impl.paramcheck.a r111, boolean r112) {
        BcmParams r100 = r110.b();
        if (r100 == null) goto L45;
        Map<String, Object> r101 = r100.toMap();
        if (r101 == null) goto L45;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r111.f41865a.iterator();
    L8:
        if (r103.hasNext() == false) goto L43;
        com.bytedance.android.bcm.impl.model.f r104 = (com.bytedance.android.bcm.impl.model.f) r103.next();
        Object r105 = r101.get(r104.a());
        if (r105 == null) goto L8;
        if (f41877a.contains(r104.a()) == true) goto L8;
        ValueType r106 = r104.g();
        int r107 = g.f41878a[r106.ordinal()];
        boolean r108 = false;
        boolean r109 = true;
        if (r107 != 1) goto L17;
        boolean r113 = r105 instanceof String;
    L27:
        if (r113 == false) goto L28;
        List<Object> r114 = r104.f();
        List<Object> r115 = r114;
        if (r115 != null) goto L32;
    L33:
        r108 = true;
    L34:
        if (r108 == true) goto L37;
        r109 = r114.contains(r105);
    L37:
        if (r109 == true) goto L8;
        String r116 = r104.a();
        BcmCheckErrorType r117 = BcmCheckErrorType.VALUE_ERROR;
        List<Object> r118 = r104.f();
        if (r118 == null) goto L41;
        String r119 = CollectionsKt.joinToString$default(r118, null, null, null, 0, null, null, 63, null);
    L42:
        r102.add(c.a(r116, r117, r119, r105));
        goto L8
    L41:
        r119 = null;
        goto L42
    L32:
        if (r115.isEmpty() == false) goto L34;
    L28:
        r102.add(c.a(r104.a(), BcmCheckErrorType.TYPE_ERROR, r104.g().name(), r105));
        goto L8
    L17:
        if (r107 == 2) goto L20;
    L25:
        r113 = true;
        goto L27
    L20:
        if ((r105 instanceof Integer) == true) goto L25;
        if ((r105 instanceof Long) == true) goto L25;
        r113 = false;
        goto L27
    L43:
        return r102;
    L45:
        return CollectionsKt.emptyList();
    }
}

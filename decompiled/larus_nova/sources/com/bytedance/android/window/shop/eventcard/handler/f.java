package com.bytedance.android.window.shop.eventcard.handler;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ep3.b f187807a;

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    public f(ep3.c[] r100) {
        Intrinsics.checkNotNullParameter(r100, "providers");
        this.f187807a = new ep3.b(ArraysKt.toList(r100));
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Object r102 = r101.get("query_keys");
        if ((r102 instanceof List) == true) goto L5;
        r102 = null;
    L5:
        List r103 = (List) r102;
        if (r103 == null) goto L8;
        List r104 = r103;
        boolean r105 = true;
        if ((r104 instanceof Collection) == true) goto L12;
    L14:
        Iterator r106 = r104.iterator();
    L16:
        if (r106.hasNext() == false) goto L20;
        if ((r106.next() instanceof String) == true) goto L16;
        r105 = false;
    L20:
        if (r105 == false) goto L22;
        ep3.b r107 = this.f187807a;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator r109 = r103.iterator();
    L25:
        if (r109.hasNext() == false) goto L30;
        String r110 = (String) r109.next();
        Object r111 = r107.a(r110);
        if (r111 == null) goto L25;
        r108.put(r110, r111);
        goto L25
    L30:
        return r108;
    L22:
        return MapsKt.emptyMap();
    L12:
        if (r104.isEmpty() == false) goto L14;
    L8:
        return MapsKt.emptyMap();
    }
}

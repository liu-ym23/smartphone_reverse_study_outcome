package com.bytedance.android.window.shop.eventcard.handler;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Boolean> f187800a;

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
        this.f187800a.clear();
    }

    public b() {
        this.f187800a = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Object r102 = r101.get("blocked_events");
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
        Iterator r107 = r104.iterator();
    L25:
        if (r107.hasNext() == false) goto L28;
        String r108 = (String) r107.next();
        this.f187800a.put(r108, Boolean.TRUE);
        goto L25
    L28:
        return MapsKt.emptyMap();
    L22:
        return MapsKt.emptyMap();
    L12:
        if (r104.isEmpty() == false) goto L14;
    L8:
        return MapsKt.emptyMap();
    }
}

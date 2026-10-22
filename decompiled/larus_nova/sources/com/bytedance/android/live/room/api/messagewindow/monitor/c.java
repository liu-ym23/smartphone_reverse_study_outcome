package com.bytedance.android.live.room.api.messagewindow.monitor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f99002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f99003b;

    public final b a() {
        String r100 = this.f99003b;
        HashMap r101 = (HashMap) this.f99002a;
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Map.Entry r104 = (Map.Entry) r103.next();
        Object r105 = r104.getKey();
        Object r106 = r104.getValue();
        if (r106 == null) goto L9;
        String r107 = r106.toString();
        if (r107 == null) goto L9;
    L10:
        r102.put(r105, r107);
    L9:
        r107 = "";
        goto L10
    L12:
        return new b(r100, r102);
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f99003b = r100;
        this.f99002a = new HashMap();
    }

    public final void c(Pair... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        Pair r103 = r100[r102];
        if (r103 == null) goto L9;
        if (r103.getSecond() == null) goto L9;
        Map<String, Object> r104 = this.f99002a;
        HashMap r105 = (HashMap) r104;
        r105.put(r103.getFirst(), r103.getSecond());
    L9:
        r102 = r102 + 1;
        goto L3
    }

    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ((HashMap) this.f99002a).put(r100, r101);
    }
}

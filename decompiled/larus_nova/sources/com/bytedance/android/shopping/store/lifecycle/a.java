package com.bytedance.android.shopping.store.lifecycle;

import com.bytedance.android.shopping.store.home.s;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Long, m> f185441a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, s> f185442b = null;

    static {
        f185441a = new LinkedHashMap();
        f185442b = new LinkedHashMap();
    }

    public static m a(Long r100) {
        return (m) ((LinkedHashMap) f185441a).get(r100);
    }

    public static s b(Long r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Map<Long, s> r101 = f185442b;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        if (r102.get(r100) != null) goto L9;
        r101.put(r100, new s());
    L9:
        return (s) r102.get(r100);
    }
}

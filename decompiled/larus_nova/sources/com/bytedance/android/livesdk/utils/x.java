package com.bytedance.android.livesdk.utils;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Long, w> f159204a = null;

    static {
        f159204a = new HashMap();
    }

    public static w a(long r100) {
        HashMap<Long, w> r101 = f159204a;
        if (r101.get(Long.valueOf(r100)) != null) goto L6;
        w r102 = new w();
        r101.put(Long.valueOf(r100), r102);
    L6:
        return r101.get(Long.valueOf(r100));
    }

    public static void b(long r100) {
        HashMap<Long, w> r101 = f159204a;
        w r102 = r101.get(Long.valueOf(r100));
        if (r102 == null) goto L10;
        Map<Class<?>, a0> r103 = r102.f159194a;
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.size() <= 0) goto L12;
        r102.f159194a.clear();
        r101.remove(Long.valueOf(r100));
        return;
    L12:
        return;
    }
}

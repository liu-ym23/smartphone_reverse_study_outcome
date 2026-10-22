package com.bytedance.android.livesdk.chatroom.model;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Long, t2> f106975a = null;

    static {
        f106975a = new LinkedHashMap();
    }

    public static t2 a(Long r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.longValue() == 0) goto L13;
        Map<Long, t2> r101 = f106975a;
        t2 r102 = (t2) ((LinkedHashMap) r101).get(r100);
        if (r102 != null) goto L12;
        t2 r103 = new t2();
        r101.put(r100, r103);
        return r103;
    L12:
        return r102;
    L13:
        return null;
    }
}

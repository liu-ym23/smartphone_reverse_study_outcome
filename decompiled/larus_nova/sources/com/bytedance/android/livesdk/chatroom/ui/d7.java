package com.bytedance.android.livesdk.chatroom.ui;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class d7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Long, Long> f112710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f112711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f112712c;

    static {
        f112710a = new LinkedHashMap();
    }

    public static boolean a(long r100) {
        if (com.bytedance.android.livesdk.config.v9.f121428a.getValue().a() == true) goto L6;
        return false;
    L6:
        if (f112711b == false) goto L8;
        return false;
    L8:
        long r101 = System.currentTimeMillis() - f112712c;
        Map<Long, Long> r102 = f112710a;
        Long r103 = Long.valueOf(r100);
        Long r104 = (Long) ((LinkedHashMap) r102).get(Long.valueOf(r100));
        if (r104 == null) goto L11;
        long r105 = r104.longValue();
    L12:
        r102.put(r103, Long.valueOf(r105 + r101));
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r107 = ((LinkedHashMap) r102).entrySet().iterator();
    L13:
        boolean r108 = true;
        if (r107.hasNext() == false) goto L22;
        Map.Entry r109 = (Map.Entry) r107.next();
        if (((Number) r109.getValue()).longValue() > 30000) goto L19;
        r108 = false;
    L19:
        if (r108 == false) goto L13;
        r106.put(r109.getKey(), r109.getValue());
        goto L13
    L22:
        if (r106.size() > 0) goto L25;
        return false;
    L25:
        if (com.bytedance.android.livesdk.chatroom.utils.o4.f114574d == true) goto L27;
        return false;
    L27:
        return true;
    L11:
        r105 = 0;
        goto L12
    }
}

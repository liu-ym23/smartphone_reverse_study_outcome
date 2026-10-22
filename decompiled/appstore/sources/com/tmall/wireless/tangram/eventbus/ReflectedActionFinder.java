package com.tmall.wireless.tangram.eventbus;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ReflectedActionFinder {
    private static final int MAX_CACHE_SIZE = 50;
    private static final Map<Object, Map<String, Method>> methodCache = null;

    static {
        methodCache = Collections.synchronizedMap(new AnonymousClass1());
    }

    public ReflectedActionFinder() {
    }

    public static void clear() {
        methodCache.clear();
    }

    public static Method findMethodByName(@NonNull String r10, @NonNull Object r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = "execute";
    L5:
        Map<Object, Map<String, Method>> r12 = methodCache;
        Map<String, Method> r13 = r12.get(r11);
        if (r13 != null) goto L8;
        r13 = new HashMap();
        r12.put(r11, r13);
    L8:
        Method r14 = r13.get(r10);
        if (r14 != null) goto L19;
        Class<?> r15 = r11.getClass();
    L20:
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L12:
        if (r15.equals(Object.class) == true) goto L19;
        r14 = r15.getMethod(r10, new Class[]{Event.class});     // Catch: NoSuchMethodException -> L17
        if (r14 == null) goto L20;
        r13.put(r10, r14);     // Catch: NoSuchMethodException -> L17
    L19:
        return r14;
    }

    public static void removeMethod(Object r10) {
        methodCache.remove(r10);
    }
}

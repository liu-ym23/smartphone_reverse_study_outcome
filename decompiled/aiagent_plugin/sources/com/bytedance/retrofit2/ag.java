package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: ServiceMethod.java */
/* JADX INFO: loaded from: classes.dex */
abstract class ag<T> {
    abstract T a(Object[] r1);

    ag() {
    }

    static <T> ag<T> a(ab r4, Method r5, af r6) {
        r6.F();
        aa r0 = aa.a(r4, r5, r6);     // Catch: Throwable -> L19
        r6.G();
        Type r1 = r5.getGenericReturnType();
        if (an.d(r1) == true) goto L18;
        if (r1 == Void.TYPE) goto L16;
        r6.H();
        p r7 = p.a(r4, r5, r0);     // Catch: Throwable -> L12
        r6.I();
        return r7;
    L12:
        th = move-exception;
        r6.I();
        throw th;
    L16:
        throw an.a(r5, "Service methods cannot return void.", new Object[0]);
    L18:
        throw an.a(r5, "Method return type must not include a type variable or wildcard: %s", new Object[]{r1});
    L19:
        th = move-exception;
        r6.G();
        throw th;
    }
}

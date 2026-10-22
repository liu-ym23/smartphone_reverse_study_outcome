package com.fasterxml.jackson.databind.b.b;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: JdkDeserializers.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f12450a = null;

    static {
        f12450a = new HashSet();
        int r3 = 0;
        Class[] r1 = {UUID.class, AtomicBoolean.class, AtomicInteger.class, AtomicLong.class, StackTraceElement.class, ByteBuffer.class, Void.class};
        int r2 = 0;
    L3:
        if (r2 >= 7) goto L5;
        f12450a.add(r1[r2].getName());
        r2 = r2 + 1;
        goto L3
    L5:
        Class<?>[] r0 = o.h();
        int r4 = r0.length;
    L6:
        if (r3 >= r4) goto L8;
        f12450a.add(r0[r3].getName());
        r3 = r3 + 1;
        goto L6
    }

    public static com.fasterxml.jackson.databind.l<?> a(Class<?> r1, String r2) {
        if (f12450a.contains(r2) == false) goto L35;
        o<?> r3 = o.a(r1);
        if (r3 == null) goto L8;
        return r3;
    L8:
        if (r1 != UUID.class) goto L12;
        return new al();
    L12:
        if (r1 != StackTraceElement.class) goto L16;
        return new z();
    L16:
        if (r1 != AtomicBoolean.class) goto L20;
        return new b();
    L20:
        if (r1 != AtomicInteger.class) goto L24;
        return new c();
    L24:
        if (r1 != AtomicLong.class) goto L28;
        return new d();
    L28:
        if (r1 != ByteBuffer.class) goto L32;
        return new g();
    L32:
        if (r1 == Void.class) goto L34;
        return null;
    L34:
        return u.f12467a;
    L35:
        return null;
    }
}

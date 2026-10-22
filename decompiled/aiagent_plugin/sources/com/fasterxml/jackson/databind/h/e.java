package com.fasterxml.jackson.databind.h;

import com.fasterxml.jackson.a.k;
import com.fasterxml.jackson.a.n;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/* JADX INFO: compiled from: TypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.h.e$1, reason: invalid class name */
    /* JADX INFO: compiled from: TypeDeserializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12752a = null;

        static {
            int[] r0 = new int[n.values().length];
            f12752a = r0;
            r0[n.h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f12752a[n.i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f12752a[n.j.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f12752a[n.k.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f12752a[n.l.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public abstract JsonTypeInfo.As a();

    public abstract e a(com.fasterxml.jackson.databind.d r1);

    public abstract Object a(k r1, com.fasterxml.jackson.databind.h r2);

    public abstract Object b(k r1, com.fasterxml.jackson.databind.h r2);

    public abstract String b();

    public abstract f c();

    public abstract Object c(k r1, com.fasterxml.jackson.databind.h r2);

    public abstract Class<?> d();

    public abstract Object d(k r1, com.fasterxml.jackson.databind.h r2);

    public e() {
    }

    public boolean e() {
        if (d() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static Object a(k r0, com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.k r2) {
        return a(r0, r1, r2.e());
    }

    public static Object a(k r2, com.fasterxml.jackson.databind.h r3, Class<?> r4) {
        n r5 = r2.l();
        if (r5 != null) goto L5;
        return null;
    L5:
        int r6 = AnonymousClass1.f12752a[r5.ordinal()];
        if (r6 == 1) goto L33;
        if (r6 == 2) goto L29;
        if (r6 == 3) goto L25;
        if (r6 == 4) goto L21;
        if (r6 == 5) goto L17;
    L36:
        return null;
    L17:
        if (r4.isAssignableFrom(Boolean.class) == false) goto L36;
        return Boolean.FALSE;
    L21:
        if (r4.isAssignableFrom(Boolean.class) == false) goto L36;
        return Boolean.TRUE;
    L25:
        if (r4.isAssignableFrom(Double.class) == false) goto L36;
        return Double.valueOf(r2.L());
    L29:
        if (r4.isAssignableFrom(Integer.class) == false) goto L36;
        return Integer.valueOf(r2.H());
    L33:
        if (r4.isAssignableFrom(String.class) == false) goto L36;
        return r2.x();
    }
}

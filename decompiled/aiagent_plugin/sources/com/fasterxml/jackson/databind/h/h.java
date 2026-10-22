package com.fasterxml.jackson.databind.h;

import com.fasterxml.jackson.a.h.q;
import com.fasterxml.jackson.a.n;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/* JADX INFO: compiled from: TypeSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.h.h$1, reason: invalid class name */
    /* JADX INFO: compiled from: TypeSerializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12753a = null;

        static {
            int[] r0 = new int[JsonTypeInfo.As.values().length];
            f12753a = r0;
            r0[JsonTypeInfo.As.EXISTING_PROPERTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f12753a[JsonTypeInfo.As.EXTERNAL_PROPERTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f12753a[JsonTypeInfo.As.PROPERTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f12753a[JsonTypeInfo.As.WRAPPER_ARRAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f12753a[JsonTypeInfo.As.WRAPPER_OBJECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public abstract com.fasterxml.jackson.a.g.b a(com.fasterxml.jackson.a.h r1, com.fasterxml.jackson.a.g.b r2);

    public abstract JsonTypeInfo.As a();

    public abstract h a(com.fasterxml.jackson.databind.d r1);

    public abstract com.fasterxml.jackson.a.g.b b(com.fasterxml.jackson.a.h r1, com.fasterxml.jackson.a.g.b r2);

    public abstract String b();

    public h() {
    }

    public com.fasterxml.jackson.a.g.b a(Object r2, n r3) {
        com.fasterxml.jackson.a.g.b r0 = new com.fasterxml.jackson.a.g.b(r2, r3);
        int r4 = AnonymousClass1.f12753a[a().ordinal()];
        if (r4 != 1) goto L5;
        r0.f12071e = com.fasterxml.jackson.a.g.b.a.f12075d;
        r0.f12070d = b();
    L18:
        return r0;
    L5:
        if (r4 != 2) goto L7;
        r0.f12071e = com.fasterxml.jackson.a.g.b.a.f12076e;
        r0.f12070d = b();
        goto L18
    L7:
        if (r4 != 3) goto L9;
        r0.f12071e = com.fasterxml.jackson.a.g.b.a.f12074c;
        r0.f12070d = b();
        goto L18
    L9:
        if (r4 != 4) goto L11;
        r0.f12071e = com.fasterxml.jackson.a.g.b.a.f12072a;
        goto L18
    L11:
        if (r4 == 5) goto L13;
        q.a();
        goto L18
    L13:
        r0.f12071e = com.fasterxml.jackson.a.g.b.a.f12073b;
        goto L18
    }

    public com.fasterxml.jackson.a.g.b a(Object r1, n r2, Object r3) {
        com.fasterxml.jackson.a.g.b r0 = a(r1, r2);
        r0.f12069c = r3;
        return r0;
    }

    public com.fasterxml.jackson.a.g.b a(Object r1, Class<?> r2, n r3) {
        com.fasterxml.jackson.a.g.b r0 = a(r1, r3);
        r0.f12068b = r2;
        return r0;
    }
}

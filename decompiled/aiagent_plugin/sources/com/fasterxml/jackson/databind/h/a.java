package com.fasterxml.jackson.databind.h;

import com.fasterxml.jackson.databind.a.m;
import com.fasterxml.jackson.databind.k;
import java.io.Closeable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: DefaultBaseTypeLimitingValidator.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c implements Serializable {

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DefaultBaseTypeLimitingValidator.java */
    private static final class C0273a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0273a f12714a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f12715b;

        private C0273a() {
            HashSet r0 = new HashSet();
            this.f12715b = r0;
            r0.add(Object.class.getName());
            r0.add(Closeable.class.getName());
            r0.add(Serializable.class.getName());
            r0.add(AutoCloseable.class.getName());
            r0.add(Cloneable.class.getName());
            r0.add("java.util.logging.Handler");
            r0.add("javax.naming.Referenceable");
            r0.add("javax.sql.DataSource");
        }

        static {
            f12714a = new C0273a();
        }

        public boolean a(Class<?> r1) {
            return this.f12715b.contains(r1.getName());
        }
    }

    public boolean b(m<?> r1, k r2, k r3) {
        return true;
    }

    public a() {
    }

    @Override // com.fasterxml.jackson.databind.h.c
    public c.b a(m<?> r1, k r2) {
        if (b(r1, r2) == false) goto L7;
        return c.b.f12749b;
    L7:
        return c.b.f12750c;
    }

    @Override // com.fasterxml.jackson.databind.h.c
    public c.b a(m<?> r1, k r2, String r3) {
        return c.b.f12750c;
    }

    @Override // com.fasterxml.jackson.databind.h.c
    public c.b a(m<?> r1, k r2, k r3) {
        if (b(r1, r2, r3) == false) goto L6;
        return c.b.f12748a;
    L6:
        return c.b.f12749b;
    }

    public boolean b(m<?> r1, k r2) {
        return C0273a.f12714a.a(r2.e());
    }
}

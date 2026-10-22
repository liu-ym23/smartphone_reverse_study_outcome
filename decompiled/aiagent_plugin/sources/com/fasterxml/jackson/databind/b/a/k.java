package com.fasterxml.jackson.databind.b.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: JDKValueInstantiators.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: compiled from: JDKValueInstantiators.java */
    private static class a extends com.fasterxml.jackson.databind.b.y.a implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12309b = null;

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean c() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean k() {
            return true;
        }

        static {
            f12309b = new a();
        }

        public a() {
            super(ArrayList.class);
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public Object a(com.fasterxml.jackson.databind.h r1) {
            return new ArrayList();
        }
    }

    /* JADX INFO: compiled from: JDKValueInstantiators.java */
    private static class b extends com.fasterxml.jackson.databind.b.y.a implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f12310b;

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean c() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean k() {
            return true;
        }

        public b(Object r2) {
            super(r2.getClass());
            this.f12310b = r2;
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public Object a(com.fasterxml.jackson.databind.h r1) {
            return this.f12310b;
        }
    }

    /* JADX INFO: compiled from: JDKValueInstantiators.java */
    private static class c extends com.fasterxml.jackson.databind.b.y.a implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f12311b = null;

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean c() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean k() {
            return true;
        }

        static {
            f12311b = new c();
        }

        public c() {
            super(HashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public Object a(com.fasterxml.jackson.databind.h r1) {
            return new HashMap();
        }
    }

    /* JADX INFO: compiled from: JDKValueInstantiators.java */
    private static class d extends com.fasterxml.jackson.databind.b.y.a implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f12312b = null;

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean c() {
            return true;
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public boolean k() {
            return true;
        }

        static {
            f12312b = new d();
        }

        public d() {
            super(LinkedHashMap.class);
        }

        @Override // com.fasterxml.jackson.databind.b.y
        public Object a(com.fasterxml.jackson.databind.h r1) {
            return new LinkedHashMap();
        }
    }

    public static com.fasterxml.jackson.databind.b.y a(com.fasterxml.jackson.databind.g r0, Class<?> r1) {
        if (r1 != com.fasterxml.jackson.a.i.class) goto L7;
        return new com.fasterxml.jackson.databind.b.b.q();
    L7:
        if (Collection.class.isAssignableFrom(r1) == false) goto L21;
        if (r1 != ArrayList.class) goto L13;
        return a.f12309b;
    L13:
        if (Collections.EMPTY_SET.getClass() != r1) goto L17;
        return new b(Collections.EMPTY_SET);
    L17:
        if (Collections.EMPTY_LIST.getClass() == r1) goto L19;
        return null;
    L19:
        return new b(Collections.EMPTY_LIST);
    L21:
        if (Map.class.isAssignableFrom(r1) == true) goto L23;
        return null;
    L23:
        if (r1 != LinkedHashMap.class) goto L27;
        return d.f12312b;
    L27:
        if (r1 != HashMap.class) goto L31;
        return c.f12311b;
    L31:
        if (Collections.EMPTY_MAP.getClass() == r1) goto L33;
        return null;
    L33:
        return new b(Collections.EMPTY_MAP);
    }
}

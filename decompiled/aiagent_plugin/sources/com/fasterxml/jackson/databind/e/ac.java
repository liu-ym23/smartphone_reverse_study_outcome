package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.annotation.SimpleObjectIdResolver;

/* JADX INFO: compiled from: ObjectIdInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class ac {
    private static final ac f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.x f12570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Class<? extends ObjectIdGenerator<?>> f12571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Class<? extends ObjectIdResolver> f12572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Class<?> f12573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final boolean f12574e;

    static {
        f = new ac(com.fasterxml.jackson.databind.x.f13133b, Object.class, null, false, null);
    }

    public ac(com.fasterxml.jackson.databind.x r7, Class<?> r8, Class<? extends ObjectIdGenerator<?>> r9, Class<? extends ObjectIdResolver> r10) {
        this(r7, r8, r9, false, r10);
    }

    public ac(com.fasterxml.jackson.databind.x r1, Class<?> r2, Class<? extends ObjectIdGenerator<?>> r3, boolean r4, Class<? extends ObjectIdResolver> r5) {
        this.f12570a = r1;
        this.f12573d = r2;
        this.f12571b = r3;
        this.f12574e = r4;
        if (r5 != null) goto L5;
        r5 = SimpleObjectIdResolver.class;
    L5:
        this.f12572c = r5;
    }

    public static ac a() {
        return f;
    }

    public ac a(boolean r8) {
        if (this.f12574e != r8) goto L6;
        return this;
    L6:
        return new ac(this.f12570a, this.f12573d, this.f12571b, r8, this.f12572c);
    }

    public com.fasterxml.jackson.databind.x b() {
        return this.f12570a;
    }

    public Class<?> c() {
        return this.f12573d;
    }

    public Class<? extends ObjectIdGenerator<?>> d() {
        return this.f12571b;
    }

    public Class<? extends ObjectIdResolver> e() {
        return this.f12572c;
    }

    public boolean f() {
        return this.f12574e;
    }

    public String toString() {
        return "ObjectIdInfo: propName=" + this.f12570a + ", scope=" + com.fasterxml.jackson.databind.l.h.h(this.f12573d) + ", generatorType=" + com.fasterxml.jackson.databind.l.h.h(this.f12571b) + ", alwaysAsId=" + this.f12574e;
    }
}

package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: ContainerDeserializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i<T> extends ab<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12422e;
    protected final com.fasterxml.jackson.databind.b.s f;
    protected final boolean g;
    protected final Boolean h;

    public abstract com.fasterxml.jackson.databind.l<Object> h();

    public i(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f12422e = r3;
        this.h = r5;
        this.f = r6;
        this.g = com.fasterxml.jackson.databind.b.a.q.a(r6);
    }

    public i(com.fasterxml.jackson.databind.k r2) {
        this(r2, null, null);
    }

    public i(i<?> r3) {
        this(r3, r3.f, r3.h);
    }

    public i(i<?> r3, com.fasterxml.jackson.databind.b.s r4, Boolean r5) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        super(r3.f12422e);
        this.f12422e = r3.f12422e;
        this.f = r6;
        this.h = r5;
        this.g = com.fasterxml.jackson.databind.b.a.q.a(r6);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.k j() {
        return this.f12422e;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.b.v a(String r4) {
        com.fasterxml.jackson.databind.l<Object> r0 = h();
        if (r0 == null) goto L7;
        return r0.a(r4);
    L7:
        throw new IllegalArgumentException(String.format("Cannot handle managed/back reference '%s': type: container deserializer of type %s returned null for 'getContentDeserializer()'", new Object[]{r4, getClass().getName()}));
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12996c;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r4) {
        com.fasterxml.jackson.databind.b.y r0 = k();
        if (r0 != null) goto L5;
    L6:
        com.fasterxml.jackson.databind.k r3 = j();
        r4.b(r3, String.format("Cannot create empty instance of %s, no default Creator", new Object[]{r3}));
    L12:
        return r0.a(r4);
    L9:
        e = move-exception;
        return com.fasterxml.jackson.databind.l.h.a(r4, e);
    L5:
        if (r0.k() == true) goto L12;
        goto L6
    }

    public <BOGUS> BOGUS a(com.fasterxml.jackson.databind.h r1, Throwable r2, Object r3, String r4) {
    L3:
        if (ZeusTransformUtils.instanceOf(r2, InvocationTargetException.class) == false) goto L7;
        if (r2.getCause() == null) goto L7;
        r2 = r2.getCause();
    L7:
        com.fasterxml.jackson.databind.l.h.a(r2);
        if (r1 == null) goto L13;
        if (r1.a(com.fasterxml.jackson.databind.i.p) == true) goto L13;
        com.fasterxml.jackson.databind.l.h.b(r2);
    L13:
        if (ZeusTransformUtils.instanceOf(r2, IOException.class) == false) goto L19;
        if (ZeusTransformUtils.instanceOf(r2, com.fasterxml.jackson.databind.m.class) == true) goto L19;
        throw ((IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin"));
    L19:
        throw com.fasterxml.jackson.databind.m.a(r2, r3, (String) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.a(r4, "N/A"), String.class, "com.obric.aiagent.plugin"));
    }
}

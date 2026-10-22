package com.fasterxml.jackson.databind;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ObjectReader.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends com.fasterxml.jackson.a.o implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final g f13106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.b.m f13107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.f f13108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final boolean f13109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final k f13110e;
    protected final l<Object> f;
    protected final Object g;
    protected final com.fasterxml.jackson.a.d h;
    protected final j i;
    protected final com.fasterxml.jackson.databind.b.l j;
    protected final ConcurrentHashMap<k, l<Object>> k;
    private final com.fasterxml.jackson.a.c.a l;

    public u(t r3, g r4, k r5, Object r6, com.fasterxml.jackson.a.d r7, j r8) {
        com.fasterxml.jackson.a.d r9 = (com.fasterxml.jackson.a.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.a.d.class, "com.obric.aiagent.plugin");
        this.f13106a = r4;
        this.f13107b = r3.n;
        this.k = r3.o;
        this.f13108c = r3.f13103c;
        this.f13110e = r5;
        this.g = r6;
        this.h = r9;
        this.i = r8;
        this.f13109d = r4.a();
        this.f = a(r5);
        this.j = null;
        this.l = null;
    }

    @Override // com.fasterxml.jackson.a.o
    public com.fasterxml.jackson.a.f b() {
        return this.f13108c;
    }

    @Override // com.fasterxml.jackson.a.o
    public void a(com.fasterxml.jackson.a.h r1, Object r2) {
        throw new UnsupportedOperationException("Not implemented for ObjectReader");
    }

    public com.fasterxml.jackson.databind.b.m c() {
        return this.f13107b.a(this.f13106a);
    }

    public l<Object> a(k r4) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (this.f13106a.a(i.B) == false) goto L17;
        l<Object> r0 = (l) ZeusTransformUtils.preCheckCast(this.k.get(r4), l.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L15;
    L11:
        return r0;
    L15:
        r0 = c().b(r4);     // Catch: com.fasterxml.jackson.a.e -> L14
        if (r0 == null) goto L11;
        this.k.put(r4, r0);     // Catch: com.fasterxml.jackson.a.e -> L14
        goto L11
    L17:
        return null;
    }
}

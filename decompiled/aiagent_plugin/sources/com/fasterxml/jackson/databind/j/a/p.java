package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TypeWrappedSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p extends com.fasterxml.jackson.databind.p<Object> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.h f12846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.p<Object> f12847b;

    public p(com.fasterxml.jackson.databind.h.h r1, com.fasterxml.jackson.databind.p<?> r2) {
        this.f12846a = r1;
        this.f12847b = r2;
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4) {
        this.f12847b.a(r2, r3, r4, this.f12846a);
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, ac r3, com.fasterxml.jackson.databind.h.h r4) {
        this.f12847b.a(r1, r2, r3, r4);
    }

    @Override // com.fasterxml.jackson.databind.p
    public Class<Object> a() {
        return Object.class;
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(ac r3, com.fasterxml.jackson.databind.d r4) {
        com.fasterxml.jackson.databind.d r5 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.p<?> r0 = this.f12847b;
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.j.j.class) == false) goto L6;
        r0 = r3.b(r0, r5);
    L6:
        if (r0 != this.f12847b) goto L9;
        return this;
    L9:
        return new p(this.f12846a, r0);
    }
}

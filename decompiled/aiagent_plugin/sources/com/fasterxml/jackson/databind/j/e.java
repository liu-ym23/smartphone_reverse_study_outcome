package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: BeanSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends com.fasterxml.jackson.databind.j.b.d {
    public e(com.fasterxml.jackson.databind.k r1, f r2, d[] r3, d[] r4) {
        super(r1, r2, r3, r4);
    }

    public e(com.fasterxml.jackson.databind.j.b.d r1, com.fasterxml.jackson.databind.j.a.i r2, Object r3) {
        super(r1, r2, r3);
    }

    public e(com.fasterxml.jackson.databind.j.b.d r3, Set<String> r4, Set<String> r5) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
    }

    public e(com.fasterxml.jackson.databind.j.b.d r1, d[] r2, d[] r3) {
        super(r1, r2, r3);
    }

    public static e a(com.fasterxml.jackson.databind.k r3, f r4) {
        return new e(r3, r4, f12894c, null);
    }

    @Override // com.fasterxml.jackson.databind.p
    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.l.q r2) {
        return new com.fasterxml.jackson.databind.j.a.t(this, r2);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(com.fasterxml.jackson.databind.j.a.i r3) {
        return new e(this, r3, this.h);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(Object r3) {
        return new e(this, this.j, r3);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(Set<String> r3, Set<String> r4) {
        return new e(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(d[] r2, d[] r3) {
        return new e(this, r2, r3);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d d() {
        if (this.j == null) goto L5;
    L10:
        return this;
    L5:
        if (this.g != null) goto L10;
        if (this.h != null) goto L10;
        return new com.fasterxml.jackson.databind.j.a.b(this);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public final void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4) {
        if (this.j == null) goto L6;
        r3.a(r2);
        a(r2, r3, r4, true);
        return;
    L6:
        r3.c(r2);
        if (this.h == null) goto L9;
        d(r2, r3, r4);
    L10:
        r3.k();
        return;
    L9:
        c(r2, r3, r4);
        goto L10
    }

    public String toString() {
        return "BeanSerializer for " + a().getName();
    }
}

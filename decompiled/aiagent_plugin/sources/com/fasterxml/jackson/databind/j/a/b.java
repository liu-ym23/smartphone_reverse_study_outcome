package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ab;
import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: BeanAsArraySerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends com.fasterxml.jackson.databind.j.b.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.b.d f12804a;

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(com.fasterxml.jackson.databind.j.d[] r1, com.fasterxml.jackson.databind.j.d[] r2) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean c() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d d() {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public /* synthetic */ com.fasterxml.jackson.databind.j.b.d a(Set r3, Set r4) {
        return b((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    public b(com.fasterxml.jackson.databind.j.b.d r4) {
        super(r4, (i) ZeusTransformUtils.preCheckCast(null, i.class, "com.obric.aiagent.plugin"));
        this.f12804a = r4;
    }

    public b(com.fasterxml.jackson.databind.j.b.d r3, Set<String> r4, Set<String> r5) {
        super(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin"));
        this.f12804a = r3;
    }

    public b(com.fasterxml.jackson.databind.j.b.d r1, i r2, Object r3) {
        super(r1, r2, r3);
        this.f12804a = r1;
    }

    @Override // com.fasterxml.jackson.databind.p
    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.l.q r1) {
        return this.f12804a.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(i r1) {
        return this.f12804a.a(r1);
    }

    @Override // com.fasterxml.jackson.databind.j.b.d
    public com.fasterxml.jackson.databind.j.b.d a(Object r3) {
        return new b(this, this.j, r3);
    }

    public b b(Set<String> r3, Set<String> r4) {
        return new b(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.d, com.fasterxml.jackson.databind.p
    public void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4, com.fasterxml.jackson.databind.h.h r5) {
        if (this.j == null) goto L6;
        b(r2, r3, r4, r5);
        return;
    L6:
        com.fasterxml.jackson.a.g.b r0 = a(r5, r2, com.fasterxml.jackson.a.n.f12154d);
        r5.a(r3, r0);
        r3.a(r2);
        b(r2, r3, r4);
        r5.b(r3, r0);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public final void a(Object r2, com.fasterxml.jackson.a.h r3, ac r4) {
        if (r4.a(ab.u) == true) goto L5;
    L8:
        r3.b(r2);
        b(r2, r3, r4);
        r3.i();
        return;
    L5:
        if (b(r4) == false) goto L8;
        b(r2, r3, r4);
    }

    private boolean b(ac r2) {
        if (this.f != null) goto L5;
    L7:
        com.fasterxml.jackson.databind.j.d[] r1 = this.f12896e;
    L9:
        if (r1.length == 1) goto L13;
        return false;
    L13:
        return true;
    L5:
        if (r2.e() == null) goto L7;
        r1 = this.f;
        goto L9
    }

    public final void b(Object r5, com.fasterxml.jackson.a.h r6, ac r7) {
        if (this.f != null) goto L5;
    L7:
        com.fasterxml.jackson.databind.j.d[] r0 = this.f12896e;
    L8:
        int r1 = 0;
        int r2 = r0.length;     // Catch: StackOverflowError -> L16 Exception -> L19
    L10:
        if (r1 >= r2) goto L27;
        com.fasterxml.jackson.databind.j.d r3 = r0[r1];     // Catch: StackOverflowError -> L16 Exception -> L19
        if (r3 != null) goto L14;
        r6.l();     // Catch: StackOverflowError -> L16 Exception -> L19
    L15:
        r1 = r1 + 1;
        goto L10
    L14:
        r3.c(r5, r6, r7);     // Catch: StackOverflowError -> L16 Exception -> L19
        goto L15
    L27:
        return;
    L19:
        e = move-exception;
        a(r7, e, r5, r0[r1].a());
        return;
    L16:
        e = move-exception;
        com.fasterxml.jackson.databind.m r4 = com.fasterxml.jackson.databind.m.a(r6, "Infinite recursion (StackOverflowError)", e);
        r4.a(r5, r0[r1].a());
        throw r4;
    L5:
        if (r7.e() == null) goto L7;
        r0 = this.f;
        goto L8
    }

    public String toString() {
        return "BeanAsArraySerializer for " + a().getName();
    }
}

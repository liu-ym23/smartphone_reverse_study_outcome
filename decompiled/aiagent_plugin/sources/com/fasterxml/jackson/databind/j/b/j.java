package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: CollectionSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends b<Collection<?>> {
    @Override // com.fasterxml.jackson.databind.j.b.b, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Object r3) {
        return a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ b<Collection<?>> b(com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.h.h r4, com.fasterxml.jackson.databind.p r5, Boolean r6) {
        return a((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ void b(Collection<?> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        b2((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public j(com.fasterxml.jackson.databind.k r7, boolean r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<Object> r10) {
        super(Collection.class, r7, r8, r9, r10);
    }

    public j(j r7, com.fasterxml.jackson.databind.d r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<?> r10, Boolean r11) {
        super(r7, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r8) {
        return new j(this, this.f12889b, r8, this.f, this.f12891d);
    }

    public j a(com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.p<?> r9, Boolean r10) {
        return new j(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r8, r9, r10);
    }

    public boolean a(com.fasterxml.jackson.databind.ac r1, Collection<?> r2) {
        return ((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty();
    }

    public boolean a(Collection<?> r2) {
        if (((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.aiagent.plugin")).size() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void a(Collection<?> r4, com.fasterxml.jackson.a.h r5, com.fasterxml.jackson.databind.ac r6) {
        Collection<?> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        int r0 = r7.size();
        if (r0 == 1) goto L5;
    L12:
        r5.a(r7, r0);
        b2(r7, r5, r6);
        r5.i();
        return;
    L5:
        if (this.f12891d != null) goto L9;
        if (r6.a(com.fasterxml.jackson.databind.ab.u) == false) goto L9;
    L10:
        b2(r7, r5, r6);
        return;
    L9:
        if (this.f12891d != Boolean.TRUE) goto L12;
        goto L10
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(Collection<?> r8, com.fasterxml.jackson.a.h r9, com.fasterxml.jackson.databind.ac r10) {
        Collection<?> r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.aiagent.plugin");
        r9.a(r11);
        if (this.f == null) goto L6;
        a(r11, r9, r10, this.f);
        return;
    L6:
        Iterator<?> r0 = r11.iterator();
        if (r0.hasNext() == true) goto L9;
        return;
    L9:
        com.fasterxml.jackson.databind.j.a.k r1 = this.g;
        com.fasterxml.jackson.databind.h.h r2 = this.f12892e;
        int r3 = 0;
    L29:
        Object r4 = r0.next();     // Catch: Exception -> L26
        if (r4 != null) goto L13;
        r10.a(r9);     // Catch: Exception -> L26
    L23:
        r3 = r3 + 1;     // Catch: Exception -> L26
        if (r0.hasNext() == true) goto L29;
        return;
    L13:
        Class<?> r5 = r4.getClass();     // Catch: Exception -> L26
        com.fasterxml.jackson.databind.p<Object> r6 = r1.a(r5);     // Catch: Exception -> L26
        if (r6 == null) goto L16;
    L20:
        if (r2 != null) goto L22;
        r6.a(r4, r9, r10);     // Catch: Exception -> L26
        goto L23
    L22:
        r6.a(r4, r9, r10, r2);     // Catch: Exception -> L26
        goto L23
    L16:
        if (this.f12888a.v() == false) goto L18;
        com.fasterxml.jackson.databind.p<Object> r7 = a(r1, r10.a(this.f12888a, r5), r10);     // Catch: Exception -> L26
    L19:
        r6 = r7;
        r1 = this.g;     // Catch: Exception -> L26
        goto L20
    L18:
        r7 = a(r1, r5, r10);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        a(r10, e, r11, r3);
    }

    public void a(Collection<?> r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7, com.fasterxml.jackson.databind.p<Object> r8) {
        Collection r9 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        Iterator r0 = r9.iterator();
        if (r0.hasNext() == false) goto L17;
        com.fasterxml.jackson.databind.h.h r1 = this.f12892e;
        int r2 = 0;
    L5:
        Object r3 = r0.next();
        if (r3 == null) goto L18;
        if (r1 != null) goto L12;
        r8.a(r3, r6, r7);     // Catch: Exception -> L8
    L13:
        r2 = r2 + 1;
    L16:
        if (r0.hasNext() == true) goto L5;
        return;
    L12:
        r8.a(r3, r6, r7, r1);     // Catch: Exception -> L8
        goto L13
    L18:
        r7.a(r6);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        a(r7, e, r9, r2);
        goto L16
    }
}

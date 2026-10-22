package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: IterableSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class r extends b<Iterable<?>> {
    @Override // com.fasterxml.jackson.databind.j.b.b, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Object r3) {
        return a((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ b<Iterable<?>> b(com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.h.h r4, com.fasterxml.jackson.databind.p r5, Boolean r6) {
        return a((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ void b(Iterable<?> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        b2((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public r(com.fasterxml.jackson.databind.k r7, boolean r8, com.fasterxml.jackson.databind.h.h r9) {
        super(Iterable.class, r7, r8, r9, null);
    }

    public r(r r7, com.fasterxml.jackson.databind.d r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<?> r10, Boolean r11) {
        super(r7, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r8) {
        return new r(this, this.f12889b, r8, this.f, this.f12891d);
    }

    public r a(com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.p<?> r9, Boolean r10) {
        return new r(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r8, r9, r10);
    }

    public boolean a(com.fasterxml.jackson.databind.ac r1, Iterable<?> r2) {
        return !((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin")).iterator().hasNext();
    }

    public boolean a(Iterable<?> r2) {
        Iterable r1 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        Iterator r3 = r1.iterator();
        if (r3.hasNext() == false) goto L12;
        r3.next();
        if (r3.hasNext() == true) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    public final void a(Iterable<?> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        Iterable<?> r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        if (this.f12891d != null) goto L7;
        if (r5.a(com.fasterxml.jackson.databind.ab.u) == false) goto L7;
    L9:
        if (a(r6) == false) goto L12;
        b2(r6, r4, r5);
        return;
    L12:
        r4.b(r6);
        b2(r6, r4, r5);
        r4.i();
        return;
    L7:
        if (this.f12891d != Boolean.TRUE) goto L12;
        goto L12
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(Iterable<?> r7, com.fasterxml.jackson.a.h r8, com.fasterxml.jackson.databind.ac r9) {
        Iterator r10 = ((Iterable) ZeusTransformUtils.wrapperContextForParams(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r10.hasNext() == false) goto L22;
        com.fasterxml.jackson.databind.h.h r0 = this.f12892e;
        Class<?> r1 = null;
        com.fasterxml.jackson.databind.p<Object> r2 = null;
    L5:
        Object r3 = r10.next();
        if (r3 != null) goto L8;
        r9.a(r8);
    L21:
        if (r10.hasNext() == true) goto L5;
        return;
    L8:
        com.fasterxml.jackson.databind.p<Object> r4 = this.f;
        if (r4 != null) goto L15;
        Class<?> r5 = r3.getClass();
        if (r5 == r1) goto L14;
        r2 = r9.a(r5, this.f12889b);
        r1 = r5;
    L14:
        com.fasterxml.jackson.databind.p<Object> r6 = r2;
    L16:
        if (r0 != null) goto L18;
        r2.a(r3, r8, r9);
    L19:
        r2 = r6;
        goto L21
    L18:
        r2.a(r3, r8, r9, r0);
        goto L19
    L15:
        r6 = r2;
        r2 = r4;
        goto L16
    }
}

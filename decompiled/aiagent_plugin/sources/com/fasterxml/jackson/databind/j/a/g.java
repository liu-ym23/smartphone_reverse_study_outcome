package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: IteratorSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class g extends com.fasterxml.jackson.databind.j.b.b<Iterator<?>> {
    public boolean a(Iterator<?> r2) {
        Iterator r1 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.aiagent.plugin");
        return false;
    }

    @Override // com.fasterxml.jackson.databind.j.b.b, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, ac r5) {
        a((Iterator) ZeusTransformUtils.preCheckCast(r3, Iterator.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(ac r3, Object r4) {
        return a(r3, (Iterator) ZeusTransformUtils.preCheckCast(r4, Iterator.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Object r3) {
        return a((Iterator) ZeusTransformUtils.preCheckCast(r3, Iterator.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ com.fasterxml.jackson.databind.j.b.b<Iterator<?>> b(com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.h.h r4, com.fasterxml.jackson.databind.p r5, Boolean r6) {
        return a((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ void b(Iterator<?> r3, com.fasterxml.jackson.a.h r4, ac r5) {
        b2((Iterator) ZeusTransformUtils.preCheckCast(r3, Iterator.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public g(com.fasterxml.jackson.databind.k r7, boolean r8, com.fasterxml.jackson.databind.h.h r9) {
        super(Iterator.class, r7, r8, r9, null);
    }

    public g(g r7, com.fasterxml.jackson.databind.d r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<?> r10, Boolean r11) {
        super(r7, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    public boolean a(ac r1, Iterator<?> r2) {
        return !((Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.aiagent.plugin")).hasNext();
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public com.fasterxml.jackson.databind.j.i<?> b(com.fasterxml.jackson.databind.h.h r8) {
        return new g(this, this.f12889b, r8, this.f, this.f12891d);
    }

    public g a(com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.p<?> r9, Boolean r10) {
        return new g(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r8, r9, r10);
    }

    public final void a(Iterator<?> r3, com.fasterxml.jackson.a.h r4, ac r5) {
        Iterator<?> r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin");
        r4.b(r6);
        b2(r6, r4, r5);
        r4.i();
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(Iterator<?> r3, com.fasterxml.jackson.a.h r4, ac r5) {
        Iterator<?> r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin");
        if (r6.hasNext() == true) goto L5;
        return;
    L5:
        com.fasterxml.jackson.databind.p<Object> r0 = this.f;
        if (r0 != null) goto L9;
        c(r6, r4, r5);
        return;
    L9:
        com.fasterxml.jackson.databind.h.h r2 = this.f12892e;
    L10:
        Object r1 = r6.next();
        if (r1 != null) goto L13;
        r5.a(r4);
    L17:
        if (r6.hasNext() == true) goto L10;
        return;
    L13:
        if (r2 != null) goto L15;
        r0.a(r1, r4, r5);
        goto L17
    L15:
        r0.a(r1, r4, r5, r2);
        goto L17
    }

    public void c(Iterator<?> r6, com.fasterxml.jackson.a.h r7, ac r8) {
        Iterator r9 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r6, Iterator.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.h r0 = this.f12892e;
        k r1 = this.g;
    L3:
        Object r2 = r9.next();
        if (r2 != null) goto L6;
        r8.a(r7);
    L17:
        if (r9.hasNext() == true) goto L3;
        return;
    L6:
        Class<?> r3 = r2.getClass();
        com.fasterxml.jackson.databind.p<Object> r4 = r1.a(r3);
        if (r4 == null) goto L9;
    L13:
        if (r0 != null) goto L15;
        r4.a(r2, r7, r8);
        goto L17
    L15:
        r4.a(r2, r7, r8, r0);
        goto L17
    L9:
        if (this.f12888a.v() == false) goto L11;
        com.fasterxml.jackson.databind.p<Object> r5 = a(r1, r8.a(this.f12888a, r3), r8);
    L12:
        r4 = r5;
        r1 = this.g;
        goto L13
    L11:
        r5 = a(r1, r3, r8);
        goto L12
    }
}

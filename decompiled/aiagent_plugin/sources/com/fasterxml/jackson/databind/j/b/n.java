package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: compiled from: EnumSetSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends b<EnumSet<? extends Enum<?>>> {
    public n c(com.fasterxml.jackson.databind.h.h r1) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.j.b.b, com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((EnumSet) ZeusTransformUtils.preCheckCast(r3, EnumSet.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (EnumSet) ZeusTransformUtils.preCheckCast(r4, EnumSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Object r3) {
        return a((EnumSet) ZeusTransformUtils.preCheckCast(r3, EnumSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ b<EnumSet<? extends Enum<?>>> b(com.fasterxml.jackson.databind.d r3, com.fasterxml.jackson.databind.h.h r4, com.fasterxml.jackson.databind.p r5, Boolean r6) {
        return a((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ com.fasterxml.jackson.databind.j.i b(com.fasterxml.jackson.databind.h.h r1) {
        return c(r1);
    }

    @Override // com.fasterxml.jackson.databind.j.b.b
    public /* synthetic */ void b(EnumSet<? extends Enum<?>> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        b2((EnumSet) ZeusTransformUtils.preCheckCast(r3, EnumSet.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public n(com.fasterxml.jackson.databind.k r7) {
        super(EnumSet.class, r7, true, null, null);
    }

    public n(n r7, com.fasterxml.jackson.databind.d r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<?> r10, Boolean r11) {
        super(r7, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    public n a(com.fasterxml.jackson.databind.d r7, com.fasterxml.jackson.databind.h.h r8, com.fasterxml.jackson.databind.p<?> r9, Boolean r10) {
        return new n(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r8, r9, r10);
    }

    public boolean a(com.fasterxml.jackson.databind.ac r1, EnumSet<? extends Enum<?>> r2) {
        return r2.isEmpty();
    }

    public boolean a(EnumSet<? extends Enum<?>> r1) {
        if (r1.size() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void a(EnumSet<? extends Enum<?>> r4, com.fasterxml.jackson.a.h r5, com.fasterxml.jackson.databind.ac r6) {
        int r0 = r4.size();
        if (r0 == 1) goto L5;
    L12:
        r5.a(r4, r0);
        b2(r4, r5, r6);
        r5.i();
        return;
    L5:
        if (this.f12891d != null) goto L9;
        if (r6.a(com.fasterxml.jackson.databind.ab.u) == false) goto L9;
    L10:
        b2(r4, r5, r6);
        return;
    L9:
        if (this.f12891d != Boolean.TRUE) goto L12;
        goto L10
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public void b2(EnumSet<? extends Enum<?>> r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7) {
        com.fasterxml.jackson.databind.p<Object> r0 = this.f;
        Iterator r8 = r5.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Enum r1 = (Enum) ZeusTransformUtils.preCheckCast(r8.next(), Enum.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        r0 = r7.c(r1.getDeclaringClass(), this.f12889b);
    L8:
        r0.a(r1, r6, r7);
        goto L4
    }
}

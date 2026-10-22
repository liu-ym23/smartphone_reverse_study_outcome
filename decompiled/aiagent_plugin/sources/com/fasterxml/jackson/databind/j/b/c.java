package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AtomicReferenceSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends aa<AtomicReference<?>> {
    @Override // com.fasterxml.jackson.databind.j.b.aa
    public /* synthetic */ Object a(AtomicReference<?> r3) {
        return c2((AtomicReference) ZeusTransformUtils.preCheckCast(r3, AtomicReference.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.aa
    public /* synthetic */ Object b(AtomicReference<?> r3) {
        return b2((AtomicReference) ZeusTransformUtils.preCheckCast(r3, AtomicReference.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.aa
    public /* synthetic */ boolean c(AtomicReference<?> r3) {
        return a2((AtomicReference) ZeusTransformUtils.preCheckCast(r3, AtomicReference.class, "com.obric.aiagent.plugin"));
    }

    public c(com.fasterxml.jackson.databind.k.j r1, boolean r2, com.fasterxml.jackson.databind.h.h r3, com.fasterxml.jackson.databind.p<Object> r4) {
        super(r1, r2, r3, r4);
    }

    public c(c r9, com.fasterxml.jackson.databind.d r10, com.fasterxml.jackson.databind.h.h r11, com.fasterxml.jackson.databind.p<?> r12, com.fasterxml.jackson.databind.l.q r13, Object r14, boolean r15) {
        super(r9, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r10, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, r15);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aa
    public aa<AtomicReference<?>> a(com.fasterxml.jackson.databind.d r9, com.fasterxml.jackson.databind.h.h r10, com.fasterxml.jackson.databind.p<?> r11, com.fasterxml.jackson.databind.l.q r12) {
        return new c(this, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r9, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r10, r11, r12, this.h, this.i);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aa
    public aa<AtomicReference<?>> a(Object r10, boolean r11) {
        return new c(this, this.f12863c, this.f12864d, this.f12865e, this.f, r10, r11);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(AtomicReference<?> r1) {
        if (r1.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    public Object b2(AtomicReference<?> r1) {
        return r1.get();
    }

    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method */
    public Object c2(AtomicReference<?> r1) {
        return r1.get();
    }
}

package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AtomicReferenceDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends y<AtomicReference<Object>> {
    @Override // com.fasterxml.jackson.databind.l, com.fasterxml.jackson.databind.b.s
    public Object b(com.fasterxml.jackson.databind.h r1) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b.b.y, com.fasterxml.jackson.databind.l, com.fasterxml.jackson.databind.b.s
    public /* synthetic */ Object a(com.fasterxml.jackson.databind.h r1) {
        return d(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.b.y
    public /* synthetic */ AtomicReference<Object> a(AtomicReference<Object> r3, Object r4) {
        return a2((AtomicReference) ZeusTransformUtils.preCheckCast(r3, AtomicReference.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.fasterxml.jackson.databind.b.b.y
    public /* synthetic */ y<AtomicReference<Object>> b(com.fasterxml.jackson.databind.h.e r1, com.fasterxml.jackson.databind.l r2) {
        return a(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.y
    public /* synthetic */ Object b(AtomicReference<Object> r3) {
        return a((AtomicReference) ZeusTransformUtils.preCheckCast(r3, AtomicReference.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.b.b.y
    public /* synthetic */ AtomicReference<Object> c(Object r1) {
        return a(r1);
    }

    public e(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.b.y r2, com.fasterxml.jackson.databind.h.e r3, com.fasterxml.jackson.databind.l<?> r4) {
        super(r1, r2, r3, r4);
    }

    public e a(com.fasterxml.jackson.databind.h.e r3, com.fasterxml.jackson.databind.l<?> r4) {
        return new e(this.f12501a, this.f12502b, r3, r4);
    }

    public AtomicReference<Object> d(com.fasterxml.jackson.databind.h r2) {
        return new AtomicReference(this.f12504d.a(r2));
    }

    @Override // com.fasterxml.jackson.databind.b.b.y, com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return d(r1);
    }

    public AtomicReference<Object> a(Object r1) {
        return new AtomicReference(r1);
    }

    public Object a(AtomicReference<Object> r1) {
        return r1.get();
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public AtomicReference<Object> a2(AtomicReference<Object> r1, Object r2) {
        r1.set(r2);
        return r1;
    }

    @Override // com.fasterxml.jackson.databind.b.b.y, com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.TRUE;
    }
}

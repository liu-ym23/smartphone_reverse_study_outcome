package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: compiled from: ArrayBlockingQueueDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends h {
    @Override // com.fasterxml.jackson.databind.b.b.h
    public Collection<Object> d(com.fasterxml.jackson.databind.h r1) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b.b.h
    public /* synthetic */ h b(com.fasterxml.jackson.databind.l r7, com.fasterxml.jackson.databind.l r8, com.fasterxml.jackson.databind.h.e r9, com.fasterxml.jackson.databind.b.s r10, Boolean r11) {
        return a(r7, r8, r9, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r10, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r11);
    }

    public a(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.l<Object> r2, com.fasterxml.jackson.databind.h.e r3, com.fasterxml.jackson.databind.b.y r4) {
        super(r1, r2, r3, r4);
    }

    public a(com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.l<Object> r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.b.y r12, com.fasterxml.jackson.databind.l<Object> r13, com.fasterxml.jackson.databind.b.s r14, Boolean r15) {
        super(r9, r10, r11, r12, r13, (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r14, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin"), r15);
    }

    public a a(com.fasterxml.jackson.databind.l<?> r9, com.fasterxml.jackson.databind.l<?> r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.b.s r12, Boolean r13) {
        com.fasterxml.jackson.databind.b.s r6 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r12, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        return new a(this.f12422e, r10, r11, this.f12415c, r9, r6, r13);
    }

    @Override // com.fasterxml.jackson.databind.b.b.h
    public Collection<Object> a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Collection<Object> r5) {
        Collection<Object> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        r6 = new ArrayList();
    L5:
        Collection<Object> r2 = super.a(r3, r4, r6);
        if (r2.isEmpty() == false) goto L10;
        return new ArrayBlockingQueue(1, false);
    L10:
        return new ArrayBlockingQueue(r2.size(), false, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.h, com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.b(r1, r2);
    }
}

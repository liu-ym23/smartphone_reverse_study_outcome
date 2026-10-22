package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AttributePropertyWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends com.fasterxml.jackson.databind.j.t {
    protected final String w;

    public a(String r7, com.fasterxml.jackson.databind.e.t r8, com.fasterxml.jackson.databind.l.b r9, com.fasterxml.jackson.databind.k r10) {
        this(r7, r8, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r9, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"), r10, r8.B());
    }

    public a(String r10, com.fasterxml.jackson.databind.e.t r11, com.fasterxml.jackson.databind.l.b r12, com.fasterxml.jackson.databind.k r13, JsonInclude.Value r14) {
        super(r11, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r12, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"), r13, null, null, null, r14, null);
        this.w = r10;
    }

    public static a a(String r2, com.fasterxml.jackson.databind.e.t r3, com.fasterxml.jackson.databind.l.b r4, com.fasterxml.jackson.databind.k r5) {
        return new a(r2, r3, (com.fasterxml.jackson.databind.l.b) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.l.b.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.fasterxml.jackson.databind.j.t
    public com.fasterxml.jackson.databind.j.t a(com.fasterxml.jackson.databind.a.m<?> r1, com.fasterxml.jackson.databind.e.d r2, com.fasterxml.jackson.databind.e.t r3, com.fasterxml.jackson.databind.k r4) {
        throw new IllegalStateException("Should not be called on this type");
    }

    @Override // com.fasterxml.jackson.databind.j.t
    public Object e(Object r1, com.fasterxml.jackson.a.h r2, ac r3) {
        return r3.a(this.w);
    }
}

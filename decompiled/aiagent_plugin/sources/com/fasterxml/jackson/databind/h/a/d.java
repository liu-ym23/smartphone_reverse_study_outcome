package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AsExistingPropertyTypeSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends h {
    @Override // com.fasterxml.jackson.databind.h.a.h, com.fasterxml.jackson.databind.h.a.b, com.fasterxml.jackson.databind.h.h
    public /* synthetic */ com.fasterxml.jackson.databind.h.h a(com.fasterxml.jackson.databind.d r3) {
        return c((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.h.a.h, com.fasterxml.jackson.databind.h.a.b
    public /* synthetic */ b b(com.fasterxml.jackson.databind.d r3) {
        return c((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.h.a.h
    public /* synthetic */ h d(com.fasterxml.jackson.databind.d r3) {
        return c((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    public d(com.fasterxml.jackson.databind.h.f r3, com.fasterxml.jackson.databind.d r4, String r5) {
        super((com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin"), (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"), r5);
    }

    public d c(com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (this.f12744c != r4) goto L6;
        return this;
    L6:
        return new d(this.f12743b, r4, this.f12719a);
    }

    @Override // com.fasterxml.jackson.databind.h.a.h, com.fasterxml.jackson.databind.h.a.b, com.fasterxml.jackson.databind.h.h
    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.EXISTING_PROPERTY;
    }
}

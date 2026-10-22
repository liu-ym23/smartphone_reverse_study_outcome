package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AsArrayTypeSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends t {
    @Override // com.fasterxml.jackson.databind.h.h
    public /* synthetic */ com.fasterxml.jackson.databind.h.h a(com.fasterxml.jackson.databind.d r3) {
        return b((com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    public b(com.fasterxml.jackson.databind.h.f r3, com.fasterxml.jackson.databind.d r4) {
        super((com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin"), (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    public b b(com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (this.f12744c != r4) goto L6;
        return this;
    L6:
        return new b(this.f12743b, r4);
    }

    @Override // com.fasterxml.jackson.databind.h.h
    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.WRAPPER_ARRAY;
    }
}

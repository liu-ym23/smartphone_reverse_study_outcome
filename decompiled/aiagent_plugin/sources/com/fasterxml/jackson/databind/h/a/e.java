package com.fasterxml.jackson.databind.h.a;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AsExternalTypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    @Override // com.fasterxml.jackson.databind.h.a.a
    public boolean f() {
        return true;
    }

    public e(com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.h.f r8, String r9, boolean r10, com.fasterxml.jackson.databind.k r11) {
        super(r7, (com.fasterxml.jackson.databind.h.f) ZeusTransformUtils.wrapperContextForParams(r8, com.fasterxml.jackson.databind.h.f.class, "com.obric.aiagent.plugin"), r9, r10, r11);
    }

    public e(e r3, com.fasterxml.jackson.databind.d r4) {
        super(r3, (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public com.fasterxml.jackson.databind.h.e a(com.fasterxml.jackson.databind.d r3) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        if (r4 != this.f12737e) goto L6;
        return this;
    L6:
        return new e(this, r4);
    }

    @Override // com.fasterxml.jackson.databind.h.a.a, com.fasterxml.jackson.databind.h.e
    public JsonTypeInfo.As a() {
        return JsonTypeInfo.As.EXTERNAL_PROPERTY;
    }
}

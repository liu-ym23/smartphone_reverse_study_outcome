package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: StringSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public final class ak extends ai<Object> {
    public ak() {
        super(String.class, false);
    }

    @Override // com.fasterxml.jackson.databind.p
    public boolean a(com.fasterxml.jackson.databind.ac r1, Object r2) {
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")).isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.b((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.b.ai, com.fasterxml.jackson.databind.p
    public final void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.h.h r4) {
        r2.b((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"));
    }
}

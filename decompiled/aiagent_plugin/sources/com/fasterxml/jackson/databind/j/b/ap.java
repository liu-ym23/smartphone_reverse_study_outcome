package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TokenBufferSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class ap extends aj<com.fasterxml.jackson.databind.l.y> {
    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((com.fasterxml.jackson.databind.l.y) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.l.y.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((com.fasterxml.jackson.databind.l.y) ZeusTransformUtils.preCheckCast(r3, com.fasterxml.jackson.databind.l.y.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    public ap() {
        super(com.fasterxml.jackson.databind.l.y.class);
    }

    public void a(com.fasterxml.jackson.databind.l.y r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r1.a(r2);
    }

    public final void a(com.fasterxml.jackson.databind.l.y r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4, com.fasterxml.jackson.databind.h.h r5) {
        com.fasterxml.jackson.a.g.b r0 = r5.a(r3, r5.a(r2, com.fasterxml.jackson.a.n.g));
        a(r2, r3, r4);
        r5.b(r3, r0);
    }
}

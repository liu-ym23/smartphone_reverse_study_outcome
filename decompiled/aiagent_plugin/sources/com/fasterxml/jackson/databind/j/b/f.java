package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ByteArraySerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class f extends aj<byte[]> {
    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.aiagent.plugin"));
    }

    public f() {
        super(byte[].class);
    }

    public boolean a(com.fasterxml.jackson.databind.ac r1, byte[] r2) {
        if (r2.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(byte[] r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        r3.a(r4.c().u(), r2, 0, r2.length);
    }

    public void a(byte[] r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        com.fasterxml.jackson.a.g.b r2 = r6.a(r4, r6.a(r3, com.fasterxml.jackson.a.n.g));
        r4.a(r5.c().u(), r3, 0, r3.length);
        r6.b(r4, r2);
    }
}

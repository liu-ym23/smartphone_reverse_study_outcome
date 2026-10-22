package com.fasterxml.jackson.databind.b.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ae<ByteBuffer> {
    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return a(r3, r4, (ByteBuffer) ZeusTransformUtils.preCheckCast(r5, ByteBuffer.class, "com.obric.aiagent.plugin"));
    }

    public g() {
        super(ByteBuffer.class);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ae, com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.k;
    }

    public ByteBuffer b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return ByteBuffer.wrap(r1.O());
    }

    public ByteBuffer a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, ByteBuffer r3) {
        com.fasterxml.jackson.databind.l.g r0 = new com.fasterxml.jackson.databind.l.g(r3);
        r1.a(r2.k(), r0);
        r0.close();
        return r3;
    }
}

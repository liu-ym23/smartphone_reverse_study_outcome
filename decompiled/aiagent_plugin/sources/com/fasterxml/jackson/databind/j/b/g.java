package com.fasterxml.jackson.databind.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ai<ByteBuffer> {
    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public g() {
        super(ByteBuffer.class);
    }

    public void a(ByteBuffer r2, com.fasterxml.jackson.a.h r3, com.fasterxml.jackson.databind.ac r4) {
        if (r2.hasArray() == false) goto L6;
        int r1 = r2.position();
        r3.a(r2.array(), r2.arrayOffset() + r1, r2.limit() - r1);
        return;
    L6:
        ByteBuffer r5 = r2.asReadOnlyBuffer();
        if (r5.position() <= 0) goto L9;
        r5.rewind();
    L9:
        com.fasterxml.jackson.databind.l.f r6 = new com.fasterxml.jackson.databind.l.f(r5);
        r3.a(r6, r5.remaining());
        r6.close();
    }
}

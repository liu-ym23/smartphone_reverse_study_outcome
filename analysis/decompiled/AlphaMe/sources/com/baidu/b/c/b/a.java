package com.baidu.b.c.b;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class a {
    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i4) {
        if (i4 < 0 || byteBuffer2.remaining() < i4 || byteBuffer3.remaining() < i4 || byteBuffer.remaining() < i4) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }
}

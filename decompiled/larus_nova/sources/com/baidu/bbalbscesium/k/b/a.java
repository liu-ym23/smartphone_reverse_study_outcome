package com.baidu.bbalbscesium.k.b;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
final class a {
    public a() {
    }

    public static void a(ByteBuffer r100, ByteBuffer r101, ByteBuffer r102, int r103) {
        if (r103 < 0) goto L14;
        if (r101.remaining() < r103) goto L14;
        if (r102.remaining() < r103) goto L14;
        if (r100.remaining() < r103) goto L14;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L12;
        r100.put((byte) (r101.get() ^ r102.get()));
        r104 = r104 + 1;
        goto L10
    L12:
        return;
    L14:
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }
}

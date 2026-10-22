package com.bytedance.librarian.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Dynamic64Structure.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c.a {
    public b(f r4, c.b r5, long r6, int r8) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r5.f8736a == false) goto L5;
        ByteOrder r7 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r7);
        long r9 = r6 + ((long) (r8 * 16));
        this.f8734a = r4.b(r0, r9);
        this.f8735b = r4.b(r0, r9 + 8);
        return;
    L5:
        r7 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}

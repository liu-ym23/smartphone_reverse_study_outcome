package com.bytedance.librarian.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Dynamic32Structure.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c.a {
    public a(f r4, c.b r5, long r6, int r8) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r5.f8736a == false) goto L5;
        ByteOrder r7 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r7);
        long r9 = r6 + ((long) (r8 * 8));
        this.f8734a = r4.c(r0, r9);
        this.f8735b = r4.c(r0, r9 + 4);
        return;
    L5:
        r7 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}

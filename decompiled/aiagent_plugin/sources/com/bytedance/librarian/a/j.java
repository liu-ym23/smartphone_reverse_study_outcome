package com.bytedance.librarian.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Section64Header.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends c.d {
    public j(f r4, c.b r5, int r6) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        if (r5.f8736a == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        this.f8745a = r4.c(r0, (r5.f8739d + ((long) (r6 * r5.g))) + 44);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}

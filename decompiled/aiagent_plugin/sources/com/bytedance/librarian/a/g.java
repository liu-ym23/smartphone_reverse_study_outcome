package com.bytedance.librarian.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Program32Header.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends c.AbstractC0197c {
    public g(f r6, c.b r7, long r8) {
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r7.f8736a == false) goto L5;
        ByteOrder r1 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r1);
        long r2 = r7.f8738c + (r8 * ((long) r7.f8740e));
        this.f8741a = r6.c(r0, r2);
        this.f8742b = r6.c(r0, 4 + r2);
        this.f8743c = r6.c(r0, 8 + r2);
        this.f8744d = r6.c(r0, r2 + 20);
        return;
    L5:
        r1 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}

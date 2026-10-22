package com.bytedance.librarian.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class b extends Elf.a {
    public b(e r10, Elf.b r11, long r12, int r13) {
        ByteBuffer r14 = ByteBuffer.allocate(8);
        if (r11.f7687a == false) goto L5;
        ByteOrder r15 = ByteOrder.BIG_ENDIAN;
    L6:
        r14.order(r15);
        long r16 = r12 + ((long) (r13 * 16));
        this.f7685a = r10.g(r14, r16);
        this.f7686b = r10.g(r14, r16 + 8);
        return;
    L5:
        r15 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}

package com.bytedance.librarian.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class f extends Elf.c {
    public f(e r10, Elf.b r11, long r12) {
        ByteBuffer r13 = ByteBuffer.allocate(4);
        if (r11.f7687a == false) goto L5;
        ByteOrder r14 = ByteOrder.BIG_ENDIAN;
    L6:
        r13.order(r14);
        long r15 = r11.f7689c + (r12 * ((long) r11.f7691e));
        this.f7696a = r10.i(r13, r15);
        this.f7697b = r10.i(r13, 4 + r15);
        this.f7698c = r10.i(r13, 8 + r15);
        this.f7699d = r10.i(r13, r15 + 20);
        return;
    L5:
        r14 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}

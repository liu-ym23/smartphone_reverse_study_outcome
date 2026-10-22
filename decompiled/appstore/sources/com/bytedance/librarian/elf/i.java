package com.bytedance.librarian.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class i extends Elf.d {
    public i(e r10, Elf.b r11, int r12) {
        ByteBuffer r13 = ByteBuffer.allocate(8);
        if (r11.f7687a == false) goto L5;
        ByteOrder r14 = ByteOrder.BIG_ENDIAN;
    L6:
        r13.order(r14);
        this.f7700a = r10.i(r13, (r11.f7690d + ((long) (r12 * r11.f7693g))) + 44);
        return;
    L5:
        r14 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}

package com.bytedance.librarian.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class c extends Elf.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f7701j;

    public c(boolean r10, e r11) {
        this.f7687a = r10;
        this.f7701j = r11;
        ByteBuffer r12 = ByteBuffer.allocate(4);
        if (r10 == false) goto L5;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L6:
        r12.order(r13);
        this.f7688b = r11.f(r12, 16);
        this.f7689c = r11.i(r12, 28);
        this.f7690d = r11.i(r12, 32);
        this.f7691e = r11.f(r12, 42);
        this.f7692f = r11.f(r12, 44);
        this.f7693g = r11.f(r12, 46);
        this.f7694h = r11.f(r12, 48);
        this.f7695i = r11.f(r12, 50);
        return;
    L5:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // com.bytedance.librarian.elf.Elf.b
    public Elf.a a(long r10, int r11) {
        return new a(this.f7701j, this, r10, r11);
    }

    @Override // com.bytedance.librarian.elf.Elf.b
    public Elf.c b(long r10) {
        return new f(this.f7701j, this, r10);
    }

    @Override // com.bytedance.librarian.elf.Elf.b
    public Elf.d c(int r10) {
        return new h(this.f7701j, this, r10);
    }
}

package com.bytedance.librarian.elf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class d extends Elf.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f7702j;

    public d(boolean r10, e r11) {
        this.f7687a = r10;
        this.f7702j = r11;
        ByteBuffer r12 = ByteBuffer.allocate(8);
        if (r10 == false) goto L5;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L6:
        r12.order(r13);
        this.f7688b = r11.f(r12, 16);
        this.f7689c = r11.g(r12, 32);
        this.f7690d = r11.g(r12, 40);
        this.f7691e = r11.f(r12, 54);
        this.f7692f = r11.f(r12, 56);
        this.f7693g = r11.f(r12, 58);
        this.f7694h = r11.f(r12, 60);
        this.f7695i = r11.f(r12, 62);
        return;
    L5:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // com.bytedance.librarian.elf.Elf.b
    public Elf.a a(long r10, int r11) {
        return new b(this.f7702j, this, r10, r11);
    }

    @Override // com.bytedance.librarian.elf.Elf.b
    public Elf.c b(long r10) {
        return new g(this.f7702j, this, r10);
    }

    @Override // com.bytedance.librarian.elf.Elf.b
    public Elf.d c(int r10) {
        return new i(this.f7702j, this, r10);
    }
}

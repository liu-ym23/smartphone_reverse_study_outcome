package com.bytedance.librarian.elf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class Elf32Header extends Elf.Header {
    private final ElfParser parser;

    public Elf32Header(boolean r4, ElfParser r5) throws IOException {
        this.bigEndian = r4;
        this.parser = r5;
        ByteBuffer r0 = ByteBuffer.allocate(4);
        if (r4 == false) goto L5;
        ByteOrder r6 = ByteOrder.BIG_ENDIAN;
    L6:
        r0.order(r6);
        this.type = r5.readHalf(r0, 16);
        this.phoff = r5.readWord(r0, 28);
        this.shoff = r5.readWord(r0, 32);
        this.phentsize = r5.readHalf(r0, 42);
        this.phnum = r5.readHalf(r0, 44);
        this.shentsize = r5.readHalf(r0, 46);
        this.shnum = r5.readHalf(r0, 48);
        this.shstrndx = r5.readHalf(r0, 50);
        return;
    L5:
        r6 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // com.bytedance.librarian.elf.Elf.Header
    public Elf.SectionHeader getSectionHeader(int r3) throws IOException {
        return new Section32Header(this.parser, this, r3);
    }

    @Override // com.bytedance.librarian.elf.Elf.Header
    public Elf.ProgramHeader getProgramHeader(long r3) throws IOException {
        return new Program32Header(this.parser, this, r3);
    }

    @Override // com.bytedance.librarian.elf.Elf.Header
    public Elf.DynamicStructure getDynamicStructure(long r8, int r10) throws IOException {
        return new Dynamic32Structure(this.parser, this, r8, r10);
    }
}

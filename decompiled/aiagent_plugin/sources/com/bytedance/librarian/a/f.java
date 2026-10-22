package com.bytedance.librarian.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ElfParser.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements c, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileChannel f8747b;

    public f(File r2) {
        this.f8746a = 1179403647;
        if (r2 == null) goto L9;
        if (r2.exists() == false) goto L9;
        this.f8747b = new FileInputStream(r2).getChannel();
        return;
    L9:
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public c.b a() {
        this.f8747b.position(0);
        ByteBuffer r0 = ByteBuffer.allocate(8);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        if (c(r0, 0) != 1179403647) goto L17;
        short r1 = e(r0, 4);
        if (e(r0, 5) != 2) goto L7;
        boolean r2 = true;
    L8:
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L15;
        return new e(r2, this);
    L15:
        throw new IllegalStateException("Invalid class type!");
    L10:
        return new d(r2, this);
    L7:
        r2 = false;
        goto L8
    L17:
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public List<String> b() {
        this.f8747b.position(0);
        ArrayList r7 = new ArrayList();
        c.b r3 = a();
        ByteBuffer r8 = ByteBuffer.allocate(8);
        if (r3.f8736a == false) goto L5;
        ByteOrder r0 = ByteOrder.BIG_ENDIAN;
    L6:
        r8.order(r0);
        long r4 = r3.f;
        int r9 = 0;
        if (r4 != 65535) goto L9;
        r4 = r3.a(0).f8745a;
    L9:
        long r10 = 0;
    L11:
        if (r10 >= r4) goto L16;
        c.AbstractC0197c r1 = r3.a(r10);
        if (r1.f8741a == 2) goto L14;
        r10 = r10 + 1;
        goto L11
    L14:
        long r11 = r1.f8742b;
    L18:
        if (r11 == 0) goto L20;
        ArrayList r14 = new ArrayList();
        long r15 = 0;
    L22:
        c.a r2 = r3.a(r11, r9);
        if (r2.f8734a != 1) goto L26;
        r14.add(Long.valueOf(r2.f8735b));
    L28:
        r9 = r9 + 1;
        if (r2.f8734a != 0) goto L22;
        if (r15 == 0) goto L38;
        long r5 = a(r3, r4, r15);
        Iterator r6 = r14.iterator();
    L34:
        if (r6.hasNext() == false) goto L36;
        r7.add(a(r8, ((Long) ZeusTransformUtils.preCheckCast(r6.next(), Long.class, "com.obric.aiagent.plugin")).longValue() + r5));
        goto L34
    L36:
        return r7;
    L38:
        throw new IllegalStateException("String table offset not found!");
    L26:
        if (r2.f8734a != 5) goto L28;
        r15 = r2.f8735b;
        goto L28
    L20:
        return Collections.unmodifiableList(r7);
    L16:
        r11 = 0;
        goto L18
    L5:
        r0 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    private long a(c.b r9, long r10, long r12) {
        long r0 = 0;
    L4:
        if (r0 >= r10) goto L15;
        c.AbstractC0197c r8 = r9.a(r0);
        if (r8.f8741a != 1) goto L13;
        if (r8.f8743c > r12) goto L13;
        if (r12 > (r8.f8743c + r8.f8744d)) goto L13;
        return (r12 - r8.f8743c) + r8.f8742b;
    L13:
        r0 = r0 + 1;
        goto L4
    L15:
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f8747b.close();
    }

    public String a(ByteBuffer r4, long r5) {
        StringBuilder r0 = new StringBuilder();
    L3:
        long r1 = 1 + r5;
        short r6 = e(r4, r5);
        if (r6 == 0) goto L7;
        r0.append((char) r6);
        r5 = r1;
        goto L3
    L7:
        return r0.toString();
    }

    public long b(ByteBuffer r2, long r3) {
        a(r2, r3, 8);
        return r2.getLong();
    }

    public long c(ByteBuffer r2, long r3) {
        a(r2, r3, 4);
        return ((long) r2.getInt()) & 4294967295L;
    }

    public int d(ByteBuffer r2, long r3) {
        a(r2, r3, 2);
        return r2.getShort() & 65535;
    }

    public short e(ByteBuffer r2, long r3) {
        a(r2, r3, 1);
        return (short) (r2.get() & 255);
    }

    public void a(ByteBuffer r7, long r8, int r10) {
        r7.position(0);
        r7.limit(r10);
        long r1 = 0;
    L4:
        if (r1 >= r10) goto L10;
        int r3 = this.f8747b.read(r7, r8 + r1);
        if (r3 == (-1)) goto L9;
        r1 = r1 + ((long) r3);
        goto L4
    L9:
        throw new EOFException();
    L10:
        r7.position(0);
    }
}

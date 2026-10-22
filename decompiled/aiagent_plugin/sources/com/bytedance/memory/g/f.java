package com.bytedance.memory.g;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: HprofReader.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f8817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8818b;

    public f(InputStream r2) {
        this.f8818b = 0;
        this.f8817a = r2;
    }

    public void a(g r1) {
        b(r1);
        c(r1);
        r1.a();
    }

    private void b(g r5) {
        String r0 = i.d(this.f8817a);
        int r1 = i.c(this.f8817a);
        if (r1 <= 0) goto L9;
        if (r1 >= 1073741823) goto L9;
        long r2 = i.b(this.f8817a);
        this.f8818b = r1;
        r5.a(r0, r1, r2);
        return;
    L9:
        throw new IOException("bad idSize: " + r1);
    }

    private void c(g r8) {
    L22:
        int r2 = this.f8817a.read();     // Catch: EOFException -> L21
        int r3 = i.c(this.f8817a);     // Catch: EOFException -> L21
        long r4 = 4294967295L & ((long) i.c(this.f8817a));     // Catch: EOFException -> L21
        if (r2 != 1) goto L5;
        a(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L5:
        if (r2 != 2) goto L7;
        b(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L7:
        if (r2 != 4) goto L9;
        c(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L9:
        if (r2 != 5) goto L11;
        d(r3, r4, r8);     // Catch: EOFException -> L21
        goto L22
    L11:
        if (r2 == 12) goto L15;
        if (r2 == 28) goto L15;
        b(r2, r3, r4, r8);     // Catch: EOFException -> L21
    L15:
        a(r2, r3, r4, r8);     // Catch: EOFException -> L21
    }

    private void a(int r9, long r10, g r12) {
        r12.a(i.a(this.f8817a, this.f8818b), i.a(this.f8817a, r10 - ((long) this.f8818b)), r9, r10);
    }

    private void b(int r10, long r11, g r13) {
        r13.a(i.c(this.f8817a), i.a(this.f8817a, this.f8818b), i.c(this.f8817a), i.a(this.f8817a, this.f8818b), r10, r11);
    }

    private void c(int r14, long r15, g r17) {
        r17.a(i.a(this.f8817a, this.f8818b), i.a(this.f8817a, this.f8818b), i.a(this.f8817a, this.f8818b), i.a(this.f8817a, this.f8818b), i.c(this.f8817a), i.c(this.f8817a), r14, r15);
    }

    private void d(int r9, long r10, g r12) {
        int r2 = i.c(this.f8817a);
        int r3 = i.c(this.f8817a);
        int r0 = i.c(this.f8817a);
        e[] r4 = new e[r0];
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4[r1] = i.a(this.f8817a, this.f8818b);
        r1 = r1 + 1;
        goto L3
    L5:
        r12.a(r2, r3, r4, r9, r10);
    }

    private void a(int r3, int r4, long r5, g r7) {
        d r6 = r7.a(r3, r4, r5);
        if (r6 != null) goto L7;
        i.b(this.f8817a, r5);
        return;
    L7:
        if (r5 <= 0) goto L44;
        int r8 = this.f8817a.read();
        long r9 = r5 - 1;
        if (r8 != 144) goto L11;
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        int r10 = this.f8818b;
    L39:
        r5 = r9 - ((long) r10);
        goto L7
    L11:
        if (r8 != 195) goto L13;
        r10 = a(r8, r6);
        goto L39
    L13:
        if (r8 != 254) goto L15;
        r10 = a(r6);
        goto L39
    L15:
        if (r8 == 255) goto L40;
        switch(r8) {
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L35;
            case 5: goto L34;
            case 6: goto L33;
            case 7: goto L32;
            case 8: goto L31;
            default: goto L17;
        };
    L17:
        switch(r8) {
            case 32: goto L30;
            case 33: goto L29;
            case 34: goto L28;
            case 35: goto L27;
            default: goto L18;
        };
    L18:
        switch(r8) {
            case 137: goto L26;
            case 138: goto L25;
            case 139: goto L24;
            case 140: goto L23;
            case 141: goto L22;
            case 142: goto L21;
            default: goto L20;
        };
    L21:
        r10 = j(r6);
        goto L39
    L22:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L23:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L24:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L25:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L26:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L20:
        throw new IllegalArgumentException("acceptHeapDumpRecord loop with unknown tag " + r8 + " with " + this.f8817a.available() + " bytes possibly remaining");
    L27:
        r10 = a(r8, r6);
        goto L39
    L28:
        r10 = i(r6);
        goto L39
    L29:
        r10 = h(r6);
        goto L39
    L30:
        r10 = g(r6);
        goto L39
    L31:
        r10 = f(r6);
        goto L39
    L32:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L33:
        r10 = e(r6);
        goto L39
    L34:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L35:
        r10 = d(r6);
        goto L39
    L36:
        r10 = c(r6);
        goto L39
    L37:
        r10 = b(r6);
        goto L39
    L38:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        i.b(this.f8817a, this.f8818b);
        r10 = this.f8818b << 1;
        goto L39
    L40:
        r6.b(r8, i.a(this.f8817a, this.f8818b));
        r10 = this.f8818b;
        goto L39
    L44:
        r6.a();
    }

    private void b(int r8, int r9, long r10, g r12) {
        byte[] r6 = new byte[(int) r10];
        i.a(this.f8817a, r6, 0, r10);
        r12.a(r8, r9, r10, r6);
    }

    private int a(d r4) {
        r4.a(i.c(this.f8817a), i.a(this.f8817a, this.f8818b));
        return this.f8818b + 4;
    }

    private int b(d r4) {
        r4.a(i.a(this.f8817a, this.f8818b), i.c(this.f8817a), i.c(this.f8817a));
        return (this.f8818b + 4) + 4;
    }

    private int c(d r4) {
        r4.b(i.a(this.f8817a, this.f8818b), i.c(this.f8817a), i.c(this.f8817a));
        return (this.f8818b + 4) + 4;
    }

    private int d(d r3) {
        r3.a(i.a(this.f8817a, this.f8818b), i.c(this.f8817a));
        return this.f8818b + 4;
    }

    private int e(d r3) {
        r3.b(i.a(this.f8817a, this.f8818b), i.c(this.f8817a));
        return this.f8818b + 4;
    }

    private int f(d r4) {
        r4.c(i.a(this.f8817a, this.f8818b), i.c(this.f8817a), i.c(this.f8817a));
        return (this.f8818b + 4) + 4;
    }

    private int g(d r17) {
        e r4 = i.a(this.f8817a, this.f8818b);
        int r5 = i.c(this.f8817a);
        e r6 = i.a(this.f8817a, this.f8818b);
        e r7 = i.a(this.f8817a, this.f8818b);
        i.b(this.f8817a, this.f8818b << 2);
        int r8 = i.c(this.f8817a);
        int r1 = ((this.f8818b * 7) + 4) + 4;
        short r2 = i.a(this.f8817a);
        int r3 = r1 + 2;
        int r9 = 0;
        int r10 = 0;
    L3:
        if (r10 >= r2) goto L5;
        i.b(this.f8817a, 2);
        r3 = r3 + (a() + 2);
        r10 = r10 + 1;
        goto L3
    L5:
        int r11 = i.a(this.f8817a);
        c[] r12 = new c[r11];
        int r13 = r3 + 2;
        int r14 = 0;
    L6:
        if (r14 >= r11) goto L12;
        e r15 = i.a(this.f8817a, this.f8818b);
        int r16 = this.f8817a.read();
        a r18 = a.getType(r16);
        if (r18 == null) goto L11;
        r12[r14] = new c(r16, r15, i.a(this.f8817a, r18, this.f8818b));
        int r19 = this.f8818b;
        r13 = r13 + ((r19 + 1) + r18.a(r19));
        r14 = r14 + 1;
        goto L6
    L11:
        throw new IllegalStateException("accept class failed, lost type def of typeId: " + r16);
    L12:
        int r20 = i.a(this.f8817a);
        c[] r110 = new c[r20];
        int r21 = r13 + 2;
    L13:
        if (r9 >= r20) goto L15;
        r110[r9] = new c(this.f8817a.read(), i.a(this.f8817a, this.f8818b), null);
        r21 = r21 + (this.f8818b + 1);
        r9 = r9 + 1;
        goto L13
    L15:
        r17.a(r4, r5, r6, r7, r8, r12, r110);
        return r21;
    }

    private int h(d r10) {
        e r0 = i.a(this.f8817a, this.f8818b);
        int r1 = i.c(this.f8817a);
        e r2 = i.a(this.f8817a, this.f8818b);
        int r3 = i.c(this.f8817a);
        byte[] r4 = new byte[r3];
        i.a(this.f8817a, r4, 0, r3);
        r10.a(r0, r1, r2, r4);
        int r9 = this.f8818b;
        return (((r9 + 4) + r9) + 4) + r3;
    }

    private int i(d r11) {
        e r3 = i.a(this.f8817a, this.f8818b);
        int r4 = i.c(this.f8817a);
        int r5 = i.c(this.f8817a);
        e r6 = i.a(this.f8817a, this.f8818b);
        int r0 = this.f8818b * r5;
        byte[] r7 = new byte[r0];
        i.a(this.f8817a, r7, 0, r0);
        r11.a(r3, r4, r5, r6, r7);
        int r10 = this.f8818b;
        return (((r10 + 4) + 4) + r10) + r0;
    }

    private int a(int r12, d r13) {
        e r4 = i.a(this.f8817a, this.f8818b);
        int r5 = i.c(this.f8817a);
        int r6 = i.c(this.f8817a);
        int r7 = this.f8817a.read();
        a r0 = a.getType(r7);
        if (r0 == null) goto L7;
        int r1 = r0.a(this.f8818b) * r6;
        byte[] r8 = new byte[r1];
        i.a(this.f8817a, r8, 0, r1);
        r13.a(r12, r4, r5, r6, r7, r8);
        return (((this.f8818b + 4) + 4) + 1) + r1;
    L7:
        throw new IllegalStateException("accept primitive array failed, lost type def of typeId: " + r7);
    }

    private int j(d r4) {
        r4.d(i.a(this.f8817a, this.f8818b), i.c(this.f8817a), i.c(this.f8817a));
        return (this.f8818b + 4) + 4;
    }

    private int a() {
        int r0 = this.f8817a.read();
        a r1 = a.getType(r0);
        if (r1 == null) goto L7;
        int r2 = r1.a(this.f8818b);
        i.b(this.f8817a, r2);
        return r2 + 1;
    L7:
        throw new IllegalStateException("failure to skip type, cannot find type def of typeid: " + r0);
    }
}

package com.fasterxml.jackson.a.f;

import com.fasterxml.jackson.a.f;
import com.fasterxml.jackson.a.h.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final b f12055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicReference<C0267b> f12056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f12057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f12058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f12059e;
    protected String[] f;
    protected a[] g;
    protected int h;
    protected int i;
    protected int j;
    protected int k;
    protected boolean l;
    protected BitSet m;

    /* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f12061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12062c;

        public a(String r1, a r2) {
            this.f12060a = r1;
            this.f12061b = r2;
            int r3 = 1;
            if (r2 == null) goto L6;
            r3 = 1 + r2.f12062c;
        L6:
            this.f12062c = r3;
        }

        public String a(char[] r5, int r6, int r7) {
            if (this.f12060a.length() == r7) goto L5;
            return null;
        L5:
            int r0 = 0;
        L7:
            if (this.f12060a.charAt(r0) != r5[r6 + r0]) goto L8;
            r0 = r0 + 1;
            if (r0 < r7) goto L7;
            return this.f12060a;
        L8:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.fasterxml.jackson.a.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CharsToNameCanonicalizer.java */
    private static final class C0267b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f12063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f12064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String[] f12065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final a[] f12066d;

        public C0267b(int r1, int r2, String[] r3, a[] r4) {
            this.f12063a = r1;
            this.f12064b = r2;
            this.f12065c = r3;
            this.f12066d = r4;
        }

        public C0267b(b r2) {
            this.f12063a = r2.h;
            this.f12064b = r2.k;
            this.f12065c = r2.f;
            this.f12066d = r2.g;
        }

        public static C0267b a(int r3) {
            return new C0267b(0, 0, new String[r3], new a[r3 >> 1]);
        }
    }

    private static int e(int r1) {
        return r1 - (r1 >> 2);
    }

    private b(int r2) {
        this.f12055a = null;
        this.f12057c = r2;
        this.f12059e = true;
        this.f12058d = -1;
        this.l = false;
        this.k = 0;
        this.f12056b = new AtomicReference(C0267b.a(64));
    }

    private b(b r1, int r2, int r3, C0267b r4) {
        this.f12055a = r1;
        this.f12057c = r3;
        this.f12056b = null;
        this.f12058d = r2;
        this.f12059e = f.a.f12041b.a(r2);
        this.f = r4.f12065c;
        this.g = r4.f12066d;
        this.h = r4.f12063a;
        this.k = r4.f12064b;
        int r5 = this.f.length;
        this.i = e(r5);
        this.j = r5 - 1;
        this.l = true;
    }

    public static b a() {
        long r0 = System.currentTimeMillis();
        return a((((int) r0) + ((int) (r0 >>> 32))) | 1);
    }

    public static b a(int r1) {
        return new b(r1);
    }

    public b b(int r6) {
        return new b(this, r6, this.f12057c, (C0267b) ZeusTransformUtils.preCheckCast(this.f12056b.get(), C0267b.class, "com.obric.aiagent.plugin"));
    }

    public void b() {
        if (c() == true) goto L5;
        return;
    L5:
        b r0 = this.f12055a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.f12059e == false) goto L12;
        r0.a(new C0267b(this));
        this.l = true;
        return;
    }

    private void a(C0267b r5) {
        int r0 = r5.f12063a;
        C0267b r1 = (C0267b) ZeusTransformUtils.preCheckCast(this.f12056b.get(), C0267b.class, "com.obric.aiagent.plugin");
        if (r0 != r1.f12063a) goto L6;
        return;
    L6:
        if (r0 <= 12000) goto L8;
        r5 = C0267b.a(64);
    L8:
        this.f12056b.compareAndSet(r1, r5);
    }

    public boolean c() {
        return !this.l;
    }

    public int d() {
        return this.f12057c;
    }

    public String a(char[] r7, int r8, int r9, int r10) {
        if (r9 >= 1) goto L7;
        return "";
    L7:
        if (this.f12059e == false) goto L9;
        int r5 = c(r10);
        String r0 = this.f[r5];
        if (r0 == null) goto L29;
        if (r0.length() != r9) goto L20;
        int r1 = 0;
    L16:
        if (r0.charAt(r1) != r7[r8 + r1]) goto L20;
        r1 = r1 + 1;
        if (r1 != r9) goto L16;
        return r0;
    L20:
        a r2 = this.g[r5 >> 1];
        if (r2 == null) goto L29;
        String r3 = r2.a(r7, r8, r9);
        if (r3 == null) goto L25;
        return r3;
    L25:
        String r4 = a(r7, r8, r9, r2.f12061b);
        if (r4 == null) goto L29;
        return r4;
    L29:
        return a(r7, r8, r9, r10, r5);
    L9:
        return new String(r7, r8, r9);
    }

    private String a(char[] r1, int r2, int r3, a r4) {
    L2:
        if (r4 == null) goto L7;
        String r0 = r4.a(r1, r2, r3);
        if (r0 != null) goto L5;
        r4 = r4.f12061b;
        goto L2
    L5:
        return r0;
    L7:
        return null;
    }

    private String a(char[] r2, int r3, int r4, int r5, int r6) {
        if (this.l == false) goto L6;
        e();
        this.l = false;
    L8:
        String r7 = new String(r2, r3, r4);
        if (f.a.f12040a.a(this.f12058d) == false) goto L11;
        r7 = g.f12107a.a(r7);
    L11:
        this.h++;
        String[] r8 = this.f;
        if (r8[r6] != null) goto L14;
        r8[r6] = r7;
    L18:
        return r7;
    L14:
        int r9 = r6 >> 1;
        a r10 = new a(r7, this.g[r9]);
        int r11 = r10.f12062c;
        if (r11 <= 150) goto L17;
        a(r9, r10, r6);
        goto L18
    L17:
        this.g[r9] = r10;
        this.k = Math.max(r11, this.k);
        goto L18
    L6:
        if (this.h < this.i) goto L8;
        f();
        r6 = c(a(r2, r3, r4));
        goto L8
    }

    private void a(int r3, a r4, int r5) {
        BitSet r0 = this.m;
        if (r0 != null) goto L6;
        BitSet r1 = new BitSet();
        this.m = r1;
        r1.set(r3);
    L12:
        this.f[r5] = r4.f12060a;
        this.g[r3] = null;
        this.h -= r4.f12062c;
        this.k = -1;
        return;
    L6:
        if (r0.get(r3) == true) goto L8;
        this.m.set(r3);
        goto L12
    L8:
        if (f.a.f12042c.a(this.f12058d) == false) goto L10;
        d(150);
    L10:
        this.f12059e = false;
        goto L12
    }

    public int c(int r2) {
        int r3 = r2 + (r2 >>> 15);
        int r4 = r3 ^ (r3 << 7);
        int r1 = this.j;
        return r1 & (r4 + (r4 >>> 3));
    }

    public int a(char[] r2, int r3, int r4) {
        int r1 = this.f12057c;
        int r5 = r4 + r3;
    L3:
        if (r3 >= r5) goto L5;
        r1 = (r1 * 33) + r2[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        if (r1 != 0) goto L9;
        return 1;
    L9:
        return r1;
    }

    public int a(String r4) {
        int r0 = r4.length();
        int r3 = this.f12057c;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3 = (r3 * 33) + r4.charAt(r1);
        r1 = r1 + 1;
        goto L3
    L5:
        if (r3 != 0) goto L9;
        return 1;
    L9:
        return r3;
    }

    private void e() {
        String[] r0 = this.f;
        this.f = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r0.length), String[].class, "com.obric.aiagent.plugin");
        a[] r1 = this.g;
        this.g = (a[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length), a[].class, "com.obric.aiagent.plugin");
    }

    private void f() {
        String[] r0 = this.f;
        int r1 = r0.length;
        int r2 = r1 + r1;
        if (r2 <= 65536) goto L6;
        this.h = 0;
        this.f12059e = false;
        this.f = new String[64];
        this.g = new a[32];
        this.j = 63;
        this.l = false;
        return;
    L6:
        a[] r4 = this.g;
        this.f = new String[r2];
        this.g = new a[r2 >> 1];
        this.j = r2 - 1;
        this.i = e(r2);
        int r3 = 0;
        int r5 = 0;
        int r6 = 0;
    L7:
        if (r3 >= r1) goto L15;
        String r7 = r0[r3];
        if (r7 == null) goto L14;
        r5 = r5 + 1;
        int r8 = c(a(r7));
        String[] r9 = this.f;
        if (r9[r8] != null) goto L13;
        r9[r8] = r7;
        goto L14
    L13:
        int r10 = r8 >> 1;
        a r11 = new a(r7, this.g[r10]);
        this.g[r10] = r11;
        r6 = Math.max(r6, r11.f12062c);
    L14:
        r3 = r3 + 1;
        goto L7
    L15:
        int r12 = r1 >> 1;
        int r13 = 0;
    L16:
        if (r13 >= r12) goto L25;
        a r14 = r4[r13];
    L18:
        if (r14 == null) goto L24;
        r5 = r5 + 1;
        String r15 = r14.f12060a;
        int r16 = c(a(r15));
        String[] r17 = this.f;
        if (r17[r16] != null) goto L22;
        r17[r16] = r15;
    L23:
        r14 = r14.f12061b;
        goto L18
    L22:
        int r18 = r16 >> 1;
        a r19 = new a(r15, this.g[r18]);
        this.g[r18] = r19;
        r6 = Math.max(r6, r19.f12062c);
        goto L23
    L24:
        r13 = r13 + 1;
        goto L16
    L25:
        this.k = r6;
        this.m = null;
        if (r5 != this.h) goto L29;
        return;
    L29:
        throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", new Object[]{Integer.valueOf(this.h), Integer.valueOf(r5)}));
    }

    public void d(int r4) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.h + ") now exceeds maximum, " + r4 + " -- suspect a DoS attack based on hash collisions");
    }
}

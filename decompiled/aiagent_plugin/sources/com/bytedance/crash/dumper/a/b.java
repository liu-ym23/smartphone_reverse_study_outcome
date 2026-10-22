package com.bytedance.crash.dumper.a;

import com.google.protobuf.DescriptorProtos;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.Year;

/* JADX INFO: compiled from: CachedStringDumper.java */
/* JADX INFO: loaded from: classes.dex */
class b extends com.bytedance.crash.dumper.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f7387b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f7388c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f7389d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f7390e = null;
    private static final C0161b f = null;
    private static final d g = null;
    private final char[] h;
    private int i;

    /* JADX INFO: compiled from: CachedStringDumper.java */
    static abstract class a<A> {
        abstract int a(A r1);

        abstract void a(A r1, int r2, char[] r3, int r4, int r5);

        a() {
        }

        void a(b r13, A r14) {
            int r0 = a(r14);
            char[] r7 = r13.c();
            int r10 = r0;
            int r9 = r13.d();
            int r1 = 0;
        L3:
            int r11 = r10 + r9;
            if (r11 < r7.length) goto L9;
            int r12 = r7.length - r9;
            a(r14, r1, r7, r9, r12);
            r13.e();
            if (r9 == 0) goto L8;
            r13.b(0);
            r9 = 0;
        L8:
            r1 = r1 + r12;
            r10 = r10 - r12;
            goto L3
        L9:
            if (r10 <= 0) goto L15;
            a(r14, r1, r7, r9, r10);
            r13.b(r11);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.crash.dumper.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CachedStringDumper.java */
    static class C0161b extends a<byte[]> {
        C0161b() {
        }

        @Override // com.bytedance.crash.dumper.a.b.a
        /* synthetic */ int a(byte[] r3) {
            return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.crash.dumper.a.b.a
        /* synthetic */ void a(byte[] r7, int r8, char[] r9, int r10, int r11) {
            a2((byte[]) ZeusTransformUtils.preCheckCast(r7, byte[].class, "com.obric.aiagent.plugin"), r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        void a2(byte[] r3, int r4, char[] r5, int r6, int r7) {
            int r2 = 0;
        L3:
            if (r2 >= r7) goto L5;
            r5[r6 + r2] = (char) r3[r4 + r2];
            r2 = r2 + 1;
            goto L3
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        int a2(byte[] r1) {
            return r1.length;
        }
    }

    /* JADX INFO: compiled from: CachedStringDumper.java */
    static class c extends a<char[]> {
        c() {
        }

        @Override // com.bytedance.crash.dumper.a.b.a
        /* synthetic */ int a(char[] r3) {
            return a2((char[]) ZeusTransformUtils.preCheckCast(r3, char[].class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.crash.dumper.a.b.a
        /* synthetic */ void a(char[] r7, int r8, char[] r9, int r10, int r11) {
            a2((char[]) ZeusTransformUtils.preCheckCast(r7, char[].class, "com.obric.aiagent.plugin"), r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        void a2(char[] r1, int r2, char[] r3, int r4, int r5) {
            System.arraycopy(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        int a2(char[] r1) {
            return r1.length;
        }
    }

    /* JADX INFO: compiled from: CachedStringDumper.java */
    static class d extends a<String> {
        d() {
        }

        @Override // com.bytedance.crash.dumper.a.b.a
        /* synthetic */ int a(String r3) {
            return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.bytedance.crash.dumper.a.b.a
        /* synthetic */ void a(String r7, int r8, char[] r9, int r10, int r11) {
            a2((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        void a2(String r1, int r2, char[] r3, int r4, int r5) {
            r1.getChars(r2, r5 + r2, r3, r4);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        int a2(String r1) {
            return r1.length();
        }
    }

    private static int b(long r6) {
        int r0 = 1;
        long r3 = 10;
    L4:
        if (r0 >= 19) goto L9;
        if (r6 < r3) goto L7;
        r3 = r3 * 10;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return 19;
    }

    static {
        f7387b = new char[]{'-', '2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
        f7388c = new char[]{'-', '9', '2', '2', '3', '3', '7', '2', '0', '3', '6', '8', '5', '4', '7', '7', '5', '8', '0', '8'};
        f7389d = new int[]{9, 99, 999, 9999, DescriptorProtos.Edition.EDITION_99999_TEST_ONLY_VALUE, 999999, 9999999, 99999999, Year.MAX_VALUE, Integer.MAX_VALUE};
        f7390e = new c();
        f = new C0161b();
        g = new d();
    }

    b(String r3) {
        int r0 = 1024;
        char[] r1 = new char[1024];     // Catch: Throwable -> L5
    L6:
        this.h = r1;
        this.i = 0;
        this.f7386a = a(r3, r0);
        return;
    L5:
        r0 = 128;
        r1 = new char[128];
        goto L6
    }

    char[] c() {
        return this.h;
    }

    int d() {
        return this.i;
    }

    void b(int r1) {
        this.i = r1;
    }

    void e() {
        com.bytedance.crash.dumper.a.d r0 = this.f7386a;
        char[] r2 = this.h;
        r0.a(r2, r2.length);
    }

    private static int c(int r2) {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L10;
        if (r2 <= f7389d[r0]) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0 + 1;
    L10:
        return 11;
    }

    private static void a(int r3, char[] r4, int r5) {
    L3:
        if (r3 < 65536) goto L5;
        int r0 = r3 / 100;
        int r6 = r3 - (((r0 << 6) + (r0 << 5)) + (r0 << 2));
        int r1 = r6 / 10;
        int r7 = r5 - 1;
        r4[r7] = (char) ((r6 - (r1 * 10)) + 48);
        r5 = r7 - 1;
        r4[r5] = (char) (r1 + 48);
        r3 = r0;
    L5:
        if (r3 == 0) goto L7;
        int r2 = (52429 * r3) >>> 19;
        r5 = r5 - 1;
        r4[r5] = (char) ((r3 - ((r2 << 3) + (r2 << 1))) + 48);
        r3 = r2;
        goto L5
    }

    private static void a(long r6, char[] r8, int r9) {
    L3:
        if (r6 <= 2147483647L) goto L5;
        long r0 = r6 / 100;
        int r7 = (int) (r6 - (((r0 << 6) + (r0 << 5)) + (r0 << 2)));
        int r10 = r7 / 10;
        int r11 = r9 - 1;
        r8[r11] = (char) ((r7 - (r10 * 10)) + 48);
        r9 = r11 - 1;
        r8[r9] = (char) (r10 + 48);
        r6 = r0;
        goto L3
    L5:
        a((int) r6, r8, r9);
    }

    private void b(char r3) {
        char[] r0 = this.h;
        int r1 = this.i;
        r0[r1] = r3;
        int r2 = r1 + 1;
        this.i = r2;
        if (r2 != r0.length) goto L6;
        com.bytedance.crash.dumper.a.d r4 = this.f7386a;
        char[] r5 = this.h;
        r4.a(r5, r5.length);
        this.i = 0;
        return;
    }

    @Override // com.bytedance.crash.dumper.a.a
    void a(int r5) {
        if (r5 != Integer.MIN_VALUE) goto L5;
        a(f7387b);
        return;
    L5:
        if (r5 >= 0) goto L8;
        r5 = -r5;
        b('-');
    L8:
        if (r5 < 100) goto L10;
        int r0 = c(r5);
        if ((this.i + r0) < this.h.length) goto L16;
        this.f7386a.a(this.h, this.i);
        this.i = 0;
    L16:
        int r1 = this.i + r0;
        this.i = r1;
        a(r5, this.h, r1);
        return;
    L10:
        if (r5 >= 10) goto L12;
        b((char) (r5 + 48));
        return;
    L12:
        int r2 = r5 / 10;
        int r6 = r5 - (r2 * 10);
        b((char) (r2 + 48));
        b((char) (r6 + 48));
    }

    @Override // com.bytedance.crash.dumper.a.a
    void a(long r8) {
        if (r8 != Long.MIN_VALUE) goto L6;
        a(f7388c);
        return;
    L6:
        if (r8 >= 0) goto L9;
        r8 = -r8;
        b('-');
    L9:
        if (r8 < 100) goto L11;
        int r0 = b(r8);
        if ((this.i + r0) < this.h.length) goto L17;
        this.f7386a.a(this.h, this.i);
        this.i = 0;
    L17:
        int r1 = this.i + r0;
        this.i = r1;
        a(r8, this.h, r1);
        return;
    L11:
        if (r8 >= 10) goto L13;
        b((char) (r8 + 48));
        return;
    L13:
        long r5 = r8 / 10;
        b((char) (r5 + 48));
        b((char) ((r8 - (10 * r5)) + 48));
    }

    @Override // com.bytedance.crash.dumper.a.a
    void a(char r1) {
        b(r1);
    }

    @Override // com.bytedance.crash.dumper.a.a
    void a() {
        if (this.i <= 0) goto L5;
        this.f7386a.a(this.h, this.i);
        this.i = 0;
    L5:
        this.f7386a.b();
    }

    @Override // com.bytedance.crash.dumper.a.a
    void b() {
        a();
        this.f7386a.a();
    }

    @Override // com.bytedance.crash.dumper.a.a
    void a(char[] r2) {
        f7390e.a(this, r2);
    }

    @Override // com.bytedance.crash.dumper.a.a
    public void a(String r2) {
        g.a(this, r2);
    }
}

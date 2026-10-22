package com.bytedance.memory.g;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: HprofWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OutputStream f8820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ByteArrayOutputStream f8822d;

    /* JADX INFO: compiled from: HprofWriter.java */
    private class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f8823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f8824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f8825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f8826e;

        a(h r1, int r2, int r3, long r4) {
            this.f8823b = r1;
            super(null);
            this.f8824c = r2;
            this.f8825d = r3;
            this.f8826e = r4;
        }

        @Override // com.bytedance.memory.g.d
        public void a(int r3, e r4) {
            h.a(this.f8823b).write(254);     // Catch: Throwable -> L4
            i.b(h.a(this.f8823b), r3);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r4.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void b(int r3, e r4) {
            h.a(this.f8823b).write(r3);     // Catch: Throwable -> L6
            h.a(this.f8823b).write(r4.a());     // Catch: Throwable -> L6
            if (r3 != 1) goto L11;
            i.b(h.a(this.f8823b), h.b(this.f8823b));     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void a(e r1, int r2, int r3) {
            h.a(this.f8823b).write(2);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void b(e r1, int r2, int r3) {
            h.a(this.f8823b).write(3);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void a(e r2, int r3) {
            h.a(this.f8823b).write(4);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r2.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void b(e r2, int r3) {
            h.a(this.f8823b).write(6);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r2.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void c(e r1, int r2, int r3) {
            h.a(this.f8823b).write(8);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void a(e r2, int r3, e r4, e r5, int r6, c[] r7, c[] r8) {
            h.a(this.f8823b).write(32);     // Catch: Throwable -> L10
            h.a(this.f8823b).write(r2.a());     // Catch: Throwable -> L10
            h.a(this.f8823b).write(r4.a());     // Catch: Throwable -> L10
            h.a(this.f8823b).write(r5.a());     // Catch: Throwable -> L10
            i.b(h.a(this.f8823b), h.b(this.f8823b) << 1);     // Catch: Throwable -> L10
            i.a(h.a(this.f8823b), r6);     // Catch: Throwable -> L10
            int r9 = 0;
            i.a(h.a(this.f8823b), 0);     // Catch: Throwable -> L10
            i.a(h.a(this.f8823b), r7.length);     // Catch: Throwable -> L10
            int r10 = r7.length;     // Catch: Throwable -> L10
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            c r12 = r7[r11];     // Catch: Throwable -> L10
            i.a(h.a(this.f8823b), r12.f8813b);     // Catch: Throwable -> L10
            h.a(this.f8823b).write(r12.f8812a);     // Catch: Throwable -> L10
            i.a(h.a(this.f8823b), r12.f8814c);     // Catch: Throwable -> L10
            r11 = r11 + 1;     // Catch: Throwable -> L10
            goto L3
        L5:
            i.a(h.a(this.f8823b), r8.length);     // Catch: Throwable -> L10
            int r13 = r8.length;     // Catch: Throwable -> L10
        L6:
            if (r9 >= r13) goto L9;
            c r14 = r8[r9];     // Catch: Throwable -> L10
            i.a(h.a(this.f8823b), r14.f8813b);     // Catch: Throwable -> L10
            h.a(this.f8823b).write(r14.f8812a);     // Catch: Throwable -> L10
            r9 = r9 + 1;
            goto L6
        L9:
            return;
        L10:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void a(e r2, int r3, e r4, byte[] r5) {
            h.a(this.f8823b).write(33);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r2.a());     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r4.a());     // Catch: Throwable -> L4
            i.b(h.a(this.f8823b), r5.length);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r5);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void a(e r2, int r3, int r4, e r5, byte[] r6) {
            h.a(this.f8823b).write(34);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r2.a());     // Catch: Throwable -> L4
            i.b(h.a(this.f8823b), r4);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r5.a());     // Catch: Throwable -> L4
            int r7 = r4 * h.b(this.f8823b);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r6, 0, r7);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void a(int r1, e r2, int r3, int r4, int r5, byte[] r6) {
            h.a(this.f8823b).write(r1);     // Catch: Throwable -> L8
            h.a(this.f8823b).write(r2.a());     // Catch: Throwable -> L8
            i.b(h.a(this.f8823b), r4);     // Catch: Throwable -> L8
            h.a(this.f8823b).write(r5);     // Catch: Throwable -> L8
            com.bytedance.memory.g.a r7 = com.bytedance.memory.g.a.getType(r5);     // Catch: Throwable -> L8
            if (r7 != com.bytedance.memory.g.a.f8809c) goto L5;
            return;
        L5:
            if (r7 == com.bytedance.memory.g.a.f) goto L14;
            i.b(h.a(this.f8823b), r4 * com.bytedance.memory.g.a.getType(r5).a(h.b(this.f8823b)));     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L8:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void d(e r1, int r2, int r3) {
            h.a(this.f8823b).write(142);     // Catch: Throwable -> L4
            h.a(this.f8823b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void a() {
            h.c(this.f8823b).write(this.f8824c);     // Catch: Throwable -> L4
            h.c(this.f8823b).write(h.a(this.f8823b).toByteArray());     // Catch: Throwable -> L4
            h.a(this.f8823b).reset();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }
    }

    @Override // com.bytedance.memory.g.g
    public void a(int r1, int r2, e[] r3, int r4, long r5) {
    }

    @Override // com.bytedance.memory.g.g
    public void a(e r1, e r2, e r3, e r4, int r5, int r6, int r7, long r8) {
    }

    static /* synthetic */ ByteArrayOutputStream a(h r0) {
        return r0.f8822d;
    }

    static /* synthetic */ int b(h r0) {
        return r0.f8821c;
    }

    static /* synthetic */ OutputStream c(h r0) {
        return r0.f8820b;
    }

    @Override // com.bytedance.memory.g.g
    public /* synthetic */ d a(int r1, int r2, long r3) {
        return b(r1, r2, r3);
    }

    public h(OutputStream r2) {
        super(null);
        this.f8821c = 0;
        this.f8822d = new ByteArrayOutputStream();
        this.f8820b = r2;
    }

    @Override // com.bytedance.memory.g.g
    public void a(String r1, int r2, long r3) {
        this.f8821c = r2;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public void a(e r2, String r3, int r4, long r5) {
        this.f8820b.write(1);     // Catch: Throwable -> L4
        i.a(this.f8820b, (int) r5);     // Catch: Throwable -> L4
        this.f8820b.write(r2.a());     // Catch: Throwable -> L4
        i.a(this.f8820b, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public void a(int r1, e r2, int r3, e r4, int r5, long r6) {
        this.f8820b.write(2);     // Catch: Throwable -> L4
        this.f8820b.write(r2.a());     // Catch: Throwable -> L4
        this.f8820b.write(r4.a());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public a b(int r8, int r9, long r10) {
        return new a(this, r8, r9, r10);
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public void a(int r1, int r2, long r3, byte[] r5) {
        if (r1 == 44) goto L10;
        return;
    L10:
        this.f8820b.write(r1);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public void a() {
        this.f8820b.flush();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }
}

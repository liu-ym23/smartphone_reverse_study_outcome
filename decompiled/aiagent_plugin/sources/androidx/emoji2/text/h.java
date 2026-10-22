package androidx.emoji2.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: MetadataListReader.java */
/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: compiled from: MetadataListReader.java */
    private static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f1653a;

        a(ByteBuffer r1) {
            this.f1653a = r1;
            r1.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.h.c
        public int a() {
            return h.a(this.f1653a.getShort());
        }

        @Override // androidx.emoji2.text.h.c
        public long b() {
            return h.a(this.f1653a.getInt());
        }

        @Override // androidx.emoji2.text.h.c
        public int c() {
            return this.f1653a.getInt();
        }

        @Override // androidx.emoji2.text.h.c
        public void a(int r2) {
            ByteBuffer r1 = this.f1653a;
            r1.position(r1.position() + r2);
        }

        @Override // androidx.emoji2.text.h.c
        public long d() {
            return this.f1653a.position();
        }
    }

    /* JADX INFO: compiled from: MetadataListReader.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f1654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f1655b;

        b(long r1, long r3) {
            this.f1654a = r1;
            this.f1655b = r3;
        }

        long a() {
            return this.f1654a;
        }
    }

    /* JADX INFO: compiled from: MetadataListReader.java */
    private interface c {
        int a();

        void a(int r1);

        long b();

        int c();

        long d();
    }

    static int a(short r1) {
        return r1 & 65535;
    }

    static long a(int r4) {
        return ((long) r4) & 4294967295L;
    }

    static androidx.emoji2.text.a.b a(ByteBuffer r2) {
        ByteBuffer r3 = r2.duplicate();
        r3.position((int) a(new a(r3)).a());
        return androidx.emoji2.text.a.b.a(r3);
    }

    private static b a(c r12) {
        c r13 = (c) ZeusTransformUtils.wrapperContextForParams(r12, c.class, "com.obric.aiagent.plugin");
        r13.a(4);
        int r1 = r13.a();
        if (r1 > 100) goto L28;
        r13.a(6);
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        int r7 = r13.c();
        r13.a(4);
        long r8 = r13.b();
        r13.a(4);
        if (1835365473 == r7) goto L13;
        r4 = r4 + 1;
    L13:
        if (r8 == (-1)) goto L26;
        r13.a((int) (r8 - r13.d()));
        r13.a(12);
        long r0 = r13.b();
    L16:
        if (r3 >= r0) goto L26;
        int r5 = r13.c();
        long r6 = r13.b();
        long r10 = r13.b();
        if (1164798569 == r5) goto L24;
        if (1701669481 == r5) goto L24;
        r3 = r3 + 1;
    L24:
        return new b(r6 + r8, r10);
    L26:
        throw new IOException("Cannot read metadata.");
    L11:
        r8 = -1;
        goto L13
    L28:
        throw new IOException("Cannot read metadata.");
    }
}

package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
class l {

    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f10364a;

        a(ByteBuffer byteBuffer) {
            this.f10364a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.l.c
        public int a() {
            return this.f10364a.getInt();
        }

        @Override // androidx.emoji2.text.l.c
        public void b(int i5) {
            ByteBuffer byteBuffer = this.f10364a;
            byteBuffer.position(byteBuffer.position() + i5);
        }

        @Override // androidx.emoji2.text.l.c
        public long c() {
            return l.c(this.f10364a.getInt());
        }

        @Override // androidx.emoji2.text.l.c
        public long getPosition() {
            return this.f10364a.position();
        }

        @Override // androidx.emoji2.text.l.c
        public int readUnsignedShort() {
            return l.d(this.f10364a.getShort());
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f10365a;

        /* renamed from: b, reason: collision with root package name */
        private final long f10366b;

        b(long j5, long j6) {
            this.f10365a = j5;
            this.f10366b = j6;
        }

        long a() {
            return this.f10365a;
        }
    }

    private interface c {
        int a();

        void b(int i5);

        long c();

        long getPosition();

        int readUnsignedShort();
    }

    private static b a(c cVar) throws IOException {
        long jC;
        cVar.b(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i5 = 0;
        while (true) {
            if (i5 >= unsignedShort) {
                jC = -1;
                break;
            }
            int iA = cVar.a();
            cVar.b(4);
            jC = cVar.c();
            cVar.b(4);
            if (1835365473 == iA) {
                break;
            }
            i5++;
        }
        if (jC != -1) {
            cVar.b((int) (jC - cVar.getPosition()));
            cVar.b(12);
            long jC2 = cVar.c();
            for (int i6 = 0; i6 < jC2; i6++) {
                int iA2 = cVar.a();
                long jC3 = cVar.c();
                long jC4 = cVar.c();
                if (1164798569 == iA2 || 1701669481 == iA2) {
                    return new b(jC3 + jC, jC4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    static Q.b b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return Q.b.h(byteBufferDuplicate);
    }

    static long c(int i5) {
        return i5 & 4294967295L;
    }

    static int d(short s5) {
        return s5 & 65535;
    }
}

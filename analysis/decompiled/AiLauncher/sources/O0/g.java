package O0;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class g {

    public static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f5142a;

        public a(ByteBuffer byteBuffer) {
            this.f5142a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // O0.g.c
        public int a() throws IOException {
            return this.f5142a.getInt();
        }

        @Override // O0.g.c
        public void b(int i10) throws IOException {
            ByteBuffer byteBuffer = this.f5142a;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        @Override // O0.g.c
        public long c() throws IOException {
            return g.c(this.f5142a.getInt());
        }

        @Override // O0.g.c
        public long getPosition() {
            return this.f5142a.position();
        }

        @Override // O0.g.c
        public int readUnsignedShort() throws IOException {
            return g.d(this.f5142a.getShort());
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final long f5143a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5144b;

        public b(long j10, long j11) {
            this.f5143a = j10;
            this.f5144b = j11;
        }

        public long a() {
            return this.f5143a;
        }
    }

    public interface c {
        int a() throws IOException;

        void b(int i10) throws IOException;

        long c() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    public static b a(c cVar) throws IOException {
        long jC;
        cVar.b(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i10 = 0;
        while (true) {
            if (i10 >= unsignedShort) {
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
            i10++;
        }
        if (jC != -1) {
            cVar.b((int) (jC - cVar.getPosition()));
            cVar.b(12);
            long jC2 = cVar.c();
            for (int i11 = 0; i11 < jC2; i11++) {
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

    public static P0.b b(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return P0.b.h(byteBufferDuplicate);
    }

    public static long c(int i10) {
        return i10 & 4294967295L;
    }

    public static int d(short s10) {
        return s10 & 65535;
    }
}

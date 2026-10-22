package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public abstract class MetadataListReader {

    public interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag() throws IOException;

        long readUnsignedInt() throws IOException;

        int readUnsignedShort() throws IOException;

        void skip(int r10) throws IOException;
    }

    public static class a implements OpenTypeReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f3052a;

        public a(ByteBuffer r10) {
            this.f3052a = r10;
            r10.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.f3052a.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() {
            return this.f3052a.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() {
            return MetadataListReader.c(this.f3052a.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() {
            return MetadataListReader.d(this.f3052a.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int r10) {
            ByteBuffer r11 = this.f3052a;
            r11.position(r11.position() + r10);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f3053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f3054b;

        public b(long r10, long r11) {
            this.f3053a = r10;
            this.f3054b = r11;
        }

        public long a() {
            return this.f3053a;
        }
    }

    public static b a(OpenTypeReader r12) {
        r12.skip(4);
        int r10 = r12.readUnsignedShort();
        if (r10 > 100) goto L28;
        r12.skip(6);
        int r11 = 0;
        int r13 = 0;
    L6:
        if (r13 >= r10) goto L11;
        int r14 = r12.readTag();
        r12.skip(4);
        long r15 = r12.readUnsignedInt();
        r12.skip(4);
        if (1835365473 == r14) goto L13;
        r13 = r13 + 1;
    L13:
        if (r15 == (-1)) goto L26;
        r12.skip((int) (r15 - r12.getPosition()));
        r12.skip(12);
        long r16 = r12.readUnsignedInt();
    L16:
        if (r11 >= r16) goto L26;
        int r17 = r12.readTag();
        long r18 = r12.readUnsignedInt();
        long r19 = r12.readUnsignedInt();
        if (1164798569 == r17) goto L24;
        if (1701669481 == r17) goto L24;
        r11 = r11 + 1;
    L24:
        return new b(r18 + r15, r19);
    L26:
        throw new IOException("Cannot read metadata.");
    L11:
        r15 = -1;
        goto L13
    L28:
        throw new IOException("Cannot read metadata.");
    }

    public static androidx.emoji2.text.flatbuffer.b b(ByteBuffer r10) {
        ByteBuffer r11 = r10.duplicate();
        r11.position((int) a(new a(r11)).a());
        return androidx.emoji2.text.flatbuffer.b.h(r11);
    }

    public static long c(int r10) {
        return ((long) r10) & 4294967295L;
    }

    public static int d(short r10) {
        return r10 & 65535;
    }
}

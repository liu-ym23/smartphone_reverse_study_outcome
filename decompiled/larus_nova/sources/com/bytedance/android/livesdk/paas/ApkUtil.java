package com.bytedance.android.livesdk.paas;

import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class ApkUtil {

    public static class SignatureNotFoundException extends Exception {
        private static final long serialVersionUID = 1;

        public SignatureNotFoundException(String r100) {
            super(r100);
        }

        public SignatureNotFoundException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public static final class a<A, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final A f154197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final B f154198b;

        public final int hashCode() {
            A r100 = this.f154197a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            B r104 = this.f154198b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (a.class == r100.getClass()) goto L11;
            return false;
        L11:
            a r101 = (a) r100;
            A r102 = this.f154197a;
            if (r102 != null) goto L17;
            if (r101.f154197a == null) goto L19;
            return false;
        L19:
            B r103 = this.f154198b;
            if (r103 != null) goto L25;
            if (r101.f154198b == null) goto L27;
            return false;
        L27:
            return true;
        L25:
            if (r103.equals(r101.f154198b) == true) goto L27;
            return false;
        L17:
            if (r102.equals(r101.f154197a) == true) goto L19;
            return false;
        }

        public a(A r100, B r101) {
            this.f154197a = r100;
            this.f154198b = r101;
        }
    }

    public static a<ByteBuffer, Long> a(FileChannel r110) throws IOException, SignatureNotFoundException {
        long r100 = r110.size();
        if (r100 < 22) goto L41;
        long r101 = r100 - 22;
        long r102 = Math.min(r101, 65535);
        int r103 = 0;
    L5:
        long r104 = r103;
        if (r104 > r102) goto L39;
        long r105 = r101 - r104;
        ByteBuffer r106 = ByteBuffer.allocate(4);
        r110.position(r105);
        r110.read(r106);
        ByteOrder r111 = ByteOrder.LITTLE_ENDIAN;
        r106.order(r111);
        if (r106.getInt(0) != 101010256) goto L37;
        ByteBuffer r107 = ByteBuffer.allocate(2);
        r110.position(r105 + 20);
        r110.read(r107);
        r107.order(r111);
        short r108 = r107.getShort(0);
        if (r108 != r103) goto L37;
        ByteBuffer r109 = ByteBuffer.allocate(4);
        r109.order(r111);
        r110.position((r110.size() - ((long) r108)) - 6);
        r110.read(r109);
        long r112 = r109.getInt(0);
        if (r112 < 32) goto L36;
        r110.position(r112 - 24);
        ByteBuffer r113 = ByteBuffer.allocate(24);
        r110.read(r113);
        r113.order(r111);
        if (r113.getLong(8) != 2334950737559900225L) goto L34;
        if (r113.getLong(16) != 3617552046287187010L) goto L34;
        long r114 = r113.getLong(0);
        if (r114 < r113.capacity()) goto L32;
        if (r114 > 2147483639) goto L32;
        int r115 = (int) (8 + r114);
        long r116 = r112 - ((long) r115);
        if (r116 < 0) goto L30;
        r110.position(r116);
        ByteBuffer r117 = ByteBuffer.allocate(r115);
        r110.read(r117);
        r117.order(r111);
        long r118 = r117.getLong(0);
        if (r118 != r114) goto L28;
        return new a(r117, Long.valueOf(r116));
    L28:
        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + r118 + " vs " + r114);
    L30:
        throw new SignatureNotFoundException("APK Signing Block offset out of range: " + r116);
    L32:
        throw new SignatureNotFoundException("APK Signing Block size out of range: " + r114);
    L34:
        throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
    L36:
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + r112);
    L37:
        r103 = r103 + 1;
        goto L5
    L39:
        throw new IOException("ZIP End of Central Directory (EOCD) record not found");
    L41:
        throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L34;
        return null;
    L34:
        RandomAccessFile r101 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L13
        Map<Integer, ByteBuffer> r102 = c(a(r101.getChannel()).f154197a);     // Catch: Throwable -> L11
        if (r102.containsKey(1903654775) == false) goto L26;
        ByteBuffer r103 = (ByteBuffer) ((LinkedHashMap) r102).get(1903654775);     // Catch: Throwable -> L11
        byte[] r104 = r103.array();     // Catch: Throwable -> L11
        int r105 = r103.arrayOffset();     // Catch: Throwable -> L11
        String r106 = new String(Arrays.copyOfRange(r104, r103.position() + r105, r105 + r103.limit()));     // Catch: Throwable -> L11
        r101.close();     // Catch: Throwable -> L23
    L10:
        return r106;
    L26:
        r101.close();     // Catch: Throwable -> L24
    L18:
        return null;
    L11:
        th = th;
    L28:
        th.printStackTrace();     // Catch: Throwable -> L19
        if (r101 == null) goto L18;
    L19:
        th = move-exception;
        if (r101 != null) goto L36;
    L22:
        throw th;
    L36:
        r101.close();     // Catch: Throwable -> L25
    L13:
        th = th;
        r101 = null;
        goto L28
    }

    public static Map<Integer, ByteBuffer> c(ByteBuffer r110) throws SignatureNotFoundException {
        if (r110.order() != ByteOrder.LITTLE_ENDIAN) goto L51;
        int r100 = r110.capacity() - 24;
        if (r100 < 8) goto L49;
        int r101 = r110.capacity();
        if (r100 > r110.capacity()) goto L47;
        int r102 = r110.limit();
        int r103 = r110.position();
        int r104 = 0;
        r110.position(0);     // Catch: Throwable -> L43
        r110.limit(r100);     // Catch: Throwable -> L43
        r110.position(8);     // Catch: Throwable -> L43
        ByteBuffer r105 = r110.slice();     // Catch: Throwable -> L43
        r105.order(r110.order());     // Catch: Throwable -> L43
        r110.position(0);
        r110.limit(r102);
        r110.position(r103);
        LinkedHashMap r111 = new LinkedHashMap();
    L12:
        if (r105.hasRemaining() == false) goto L42;
        r104 = r104 + 1;
        if (r105.remaining() < 8) goto L41;
        long r106 = r105.getLong();
        if (r106 < 4) goto L39;
        if (r106 > SieveCacheKt.NodeLinkMask) goto L39;
        int r107 = (int) r106;
        int r108 = r105.position() + r107;
        if (r107 > r105.remaining()) goto L37;
        Integer r109 = Integer.valueOf(r105.getInt());
        int r112 = r107 - 4;
        if (r112 < 0) goto L35;
        int r113 = r105.limit();
        int r114 = r105.position();
        int r115 = r112 + r114;
        if (r115 < r114) goto L33;
        if (r115 > r113) goto L33;
        r105.limit(r115);
        ByteBuffer r116 = r105.slice();     // Catch: Throwable -> L29
        r116.order(r105.order());     // Catch: Throwable -> L29
        r105.position(r115);     // Catch: Throwable -> L29
        r105.limit(r113);
        r111.put(r109, r116);
        r105.position(r108);
    L29:
        th = move-exception;
        r105.limit(r113);
        throw th;
    L33:
        throw new BufferUnderflowException();
    L35:
        throw new IllegalArgumentException("size: " + r112);
    L37:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r104 + " size out of range: " + r107 + ", available: " + r105.remaining());
    L39:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r104 + " size out of range: " + r106);
    L41:
        throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + r104);
    L42:
        return r111;
    L43:
        th = move-exception;
        r110.position(0);
        r110.limit(r102);
        r110.position(r103);
        throw th;
    L47:
        throw new IllegalArgumentException("end > capacity: " + r100 + " > " + r101);
    L49:
        throw new IllegalArgumentException("end < start: " + r100 + " < 8");
    L51:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
}

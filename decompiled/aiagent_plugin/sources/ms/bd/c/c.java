package ms.bd.c;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    static final class a<A, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final A f39463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final B f39464b;

        /* JADX WARN: Multi-variable type inference failed */
        private a(ByteBuffer r1, Long r2) {
            this.f39463a = r1;
            this.f39464b = r2;
        }

        public static a a(ByteBuffer r1, Long r2) {
            return new a(r1, r2);
        }

        public final A a() {
            return this.f39463a;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (a.class == r5.getClass()) goto L11;
            return false;
        L11:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            A r0 = this.f39463a;
            if (r0 != null) goto L17;
            if (r6.f39463a == null) goto L19;
            return false;
        L19:
            B r4 = this.f39464b;
            if (r4 != null) goto L27;
            if (r6.f39464b != null) goto L25;
            return true;
        L25:
            return false;
        L27:
            return r4.equals(r6.f39464b);
        L17:
            if (r0.equals(r6.f39463a) == true) goto L19;
            return false;
        }

        public final int hashCode() {
            A r0 = this.f39463a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r2 + 31) * 31;
            B r4 = this.f39464b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }
    }

    public static class b extends Exception {
        public b(String r1) {
            super(r1);
        }
    }

    public static HashMap a(String r12) {
        RandomAccessFile r2 = null;
        if (TextUtils.isEmpty(r12) == false) goto L5;
        return null;
    L5:
        HashMap r1 = new HashMap();
        RandomAccessFile r3 = new RandomAccessFile(r12, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "d1fceb", new byte[]{103}), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
        a<ByteBuffer, Long> r13 = a(r3.getChannel());     // Catch: Throwable -> L25
        if (r13 == null) goto L24;
        Iterator r14 = a((ByteBuffer) ZeusTransformUtils.preCheckCast(r13.a(), ByteBuffer.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L25
    L11:
        if (r14.hasNext() == false) goto L24;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r4 == null) goto L11;
        if (r4.getKey() == null) goto L11;
        if (((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue() == 1896449818) goto L11;
        ByteBuffer r5 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r4.getValue(), ByteBuffer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        byte[] r6 = r5.array();     // Catch: Throwable -> L29
        int r7 = r5.arrayOffset();     // Catch: Throwable -> L29
        r1.put((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.aiagent.plugin"), new String(Arrays.copyOfRange(r6, r5.position() + r7, r5.limit() + r7)));     // Catch: Throwable -> L29
    L24:
        r3.close();     // Catch: Throwable -> L30
    L36:
    L25:
        r2 = r3;
    L26:
        if (r2 == null) goto L28;
        r2.close();     // Catch: Throwable -> L30
    L28:
        return r1;
    }

    public static a<ByteBuffer, Long> a(FileChannel r15) {
        long r0 = r15.size();
        if (r0 < 22) goto L38;
        long r1 = r0 - 22;
        long r2 = Math.min(r1, 65535);
        int r7 = 0;
    L5:
        long r8 = r7;
        if (r8 > r2) goto L36;
        long r9 = r1 - r8;
        ByteBuffer r11 = ByteBuffer.allocate(4);
        r15.position(r9);
        r15.read(r11);
        ByteOrder r12 = ByteOrder.LITTLE_ENDIAN;
        r11.order(r12);
        if (r11.getInt(0) != 101010256) goto L34;
        ByteBuffer r13 = ByteBuffer.allocate(2);
        r15.position(r9 + 20);
        r15.read(r13);
        r13.order(r12);
        short r10 = r13.getShort(0);
        if (r10 != r7) goto L34;
        ByteBuffer r3 = ByteBuffer.allocate(4);
        r3.order(r12);
        r15.position((r15.size() - ((long) r10)) - 6);
        r15.read(r3);
        long r4 = r3.getInt(0);
        if (r4 < 32) goto L33;
        r15.position(r4 - 24);
        ByteBuffer r5 = ByteBuffer.allocate(24);
        r15.read(r5);
        r5.order(r12);
        if (r5.getLong(8) == 2334950737559900225L) goto L16;
    L30:
        return null;
    L16:
        if (r5.getLong(16) != 3617552046287187010L) goto L30;
        long r6 = r5.getLong(0);
        if (r6 < r5.capacity()) goto L30;
        if (r6 > 2147483639) goto L30;
        int r14 = (int) (8 + r6);
        long r16 = r4 - ((long) r14);
        if (r16 < 0) goto L30;
        r15.position(r16);
        ByteBuffer r17 = ByteBuffer.allocate(r14);
        r15.read(r17);
        r17.order(r12);
        if (r17.getLong(0) != r6) goto L30;
        return a.a(r17, Long.valueOf(r16));
    L33:
        throw new b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fd42c0", new byte[]{46}), String.class, "com.obric.aiagent.plugin"));
    L34:
        r7 = r7 + 1;
        goto L5
    L36:
        throw new IOException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "95804c", new byte[]{121, 103}), String.class, "com.obric.aiagent.plugin"));
    L38:
        throw new IOException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b31f03", new byte[]{34, 96}), String.class, "com.obric.aiagent.plugin"));
    }

    public static LinkedHashMap a(ByteBuffer r12) {
        if (r12.order() != ByteOrder.LITTLE_ENDIAN) goto L51;
        int r0 = r12.capacity() - 24;
        if (r0 < 8) goto L49;
        r12.capacity();
        if (r0 > r12.capacity()) goto L47;
        int r1 = r12.limit();
        int r7 = r12.position();
        r12.position(0);     // Catch: Throwable -> L43
        r12.limit(r0);     // Catch: Throwable -> L43
        r12.position(8);     // Catch: Throwable -> L43
        ByteBuffer r2 = r12.slice();     // Catch: Throwable -> L43
        r2.order(r12.order());     // Catch: Throwable -> L43
        r12.position(0);
        r12.limit(r1);
        r12.position(r7);
        LinkedHashMap r13 = new LinkedHashMap();
    L12:
        if (r2.hasRemaining() == false) goto L42;
        if (r2.remaining() < 8) goto L41;
        long r8 = r2.getLong();
        if (r8 < 4) goto L39;
        if (r8 > 2147483647L) goto L39;
        int r3 = (int) r8;
        int r9 = r2.position() + r3;
        if (r3 > r2.remaining()) goto L37;
        Integer r10 = Integer.valueOf(r2.getInt());
        int r4 = r3 - 4;
        if (r4 < 0) goto L35;
        int r11 = r2.limit();
        int r14 = r2.position();
        int r5 = r4 + r14;
        if (r5 < r14) goto L33;
        if (r5 > r11) goto L33;
        r2.limit(r5);
        ByteBuffer r15 = r2.slice();     // Catch: Throwable -> L29
        r15.order(r2.order());     // Catch: Throwable -> L29
        r2.position(r5);     // Catch: Throwable -> L29
        r2.limit(r11);
        r13.put(r10, r15);
        r2.position(r9);
    L29:
        th = move-exception;
        r2.limit(r11);
        throw th;
    L33:
        throw new BufferUnderflowException();
    L35:
        throw new IllegalArgumentException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fe0ff6", new byte[]{37}), String.class, "com.obric.aiagent.plugin"));
    L37:
        throw new b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7a0cd5", new byte[]{126}), String.class, "com.obric.aiagent.plugin"));
    L39:
        throw new b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "0af810", new byte[]{118}), String.class, "com.obric.aiagent.plugin"));
    L41:
        throw new b((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "21c536", new byte[]{117}), String.class, "com.obric.aiagent.plugin"));
    L42:
        return r13;
    L43:
        th = move-exception;
        r12.position(0);
        r12.limit(r1);
        r12.position(r7);
        throw th;
    L47:
        throw new IllegalArgumentException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "6d2a5c", new byte[]{114}), String.class, "com.obric.aiagent.plugin"));
    L49:
        throw new IllegalArgumentException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7858ce", new byte[]{114}), String.class, "com.obric.aiagent.plugin"));
    L51:
        throw new IllegalArgumentException((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5a4480", new byte[]{117}), String.class, "com.obric.aiagent.plugin"));
    }
}

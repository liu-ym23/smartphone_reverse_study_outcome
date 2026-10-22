package com.bytedance.memory.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: MemoryIOUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: com.bytedance.memory.g.i$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemoryIOUtil.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8827a = null;

        static {
            int[] r0 = new int[a.values().length];
            f8827a = r0;
            r0[a.f8807a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f8827a[a.f8808b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f8827a[a.f8809c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f8827a[a.f8810d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f8827a[a.f8811e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f8827a[a.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f8827a[a.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f8827a[a.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f8827a[a.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static short a(InputStream r2) {
        int r0 = r2.read();
        int r3 = r2.read();
        if ((r0 | r3) < 0) goto L7;
        return (short) (r3 | (r0 << 8));
    L7:
        throw new EOFException();
    }

    public static long b(InputStream r6) {
        byte[] r1 = new byte[8];
        a(r6, r1, 0, 8);
        return (((((((((long) r1[0]) << 56) + (((long) (r1[1] & 255)) << 48)) + (((long) (r1[2] & 255)) << 40)) + (((long) (r1[3] & 255)) << 32)) + (((long) (r1[4] & 255)) << 24)) + ((long) ((r1[5] & 255) << 16))) + ((long) ((r1[6] & 255) << 8))) + ((long) (r1[7] & 255));
    }

    public static int c(InputStream r4) {
        int r0 = r4.read();
        int r1 = r4.read();
        int r2 = r4.read();
        int r5 = r4.read();
        if ((((r0 | r1) | r2) | r5) < 0) goto L7;
        return (((r0 << 24) + (r1 << 16)) + (r2 << 8)) + r5;
    L7:
        throw new EOFException();
    }

    public static void a(InputStream r3, byte[] r4, int r5, long r6) {
        int r7 = 0;
    L3:
        long r0 = r7;
        if (r0 >= r6) goto L10;
        int r1 = r3.read(r4, r7, (int) (r6 - r0));
        if (r1 < 0) goto L9;
        r7 = r7 + r1;
        goto L3
    L9:
        throw new EOFException();
    }

    public static String d(InputStream r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r3.read();
        int r2 = 0;
    L3:
        if (r1 == 0) goto L10;
        r0.append((char) r1);
        r2 = r2 + 1;
        if (r2 > 2048) goto L8;
        r1 = r3.read();
        goto L3
    L8:
        throw new IOException("Bad string data which causes result to be too long.");
    L10:
        return r0.toString();
    }

    public static String a(InputStream r2, long r3) {
        byte[] r0 = new byte[(int) r3];
        a(r2, r0, 0, r3);
        return new String(r0, Charset.forName("UTF-8"));
    }

    public static e a(InputStream r3, int r4) {
        byte[] r0 = new byte[r4];
        a(r3, r0, 0, r4);
        return new e(r0);
    }

    public static Object a(InputStream r1, a r2, int r3) {
        switch(AnonymousClass1.f8827a[r2.ordinal()]) {
            case 1: goto L27;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return Long.valueOf(b(r1));
    L9:
        return Integer.valueOf(c(r1));
    L11:
        return Short.valueOf(a(r1));
    L13:
        return Byte.valueOf((byte) r1.read());
    L15:
        return Double.valueOf(Double.longBitsToDouble(b(r1)));
    L17:
        return Float.valueOf(Float.intBitsToFloat(c(r1)));
    L19:
        return Character.valueOf((char) a(r1));
    L21:
        if (r1.read() == 0) goto L23;
        boolean r4 = true;
    L25:
        return Boolean.valueOf(r4);
    L23:
        r4 = false;
        goto L25
    L27:
        return a(r1, r3);
    }

    public static void b(InputStream r7, long r8) {
        long r2 = 0;
    L4:
        if (r2 >= r8) goto L10;
        long r4 = r7.skip(r8 - r2);
        if (r4 < 0) goto L9;
        r2 = r2 + r4;
        goto L4
    L9:
        throw new EOFException();
    }

    public static void a(OutputStream r1, int r2) {
        r1.write((r2 >>> 8) & 255);
        r1.write(r2 & 255);
    }

    public static void b(OutputStream r1, int r2) {
        r1.write((r2 >>> 24) & 255);
        r1.write((r2 >>> 16) & 255);
        r1.write((r2 >>> 8) & 255);
        r1.write(r2 & 255);
    }

    public static void a(OutputStream r6, long r7) {
        r6.write(new byte[]{(byte) (r7 >>> 56), (byte) (r7 >>> 48), (byte) (r7 >>> 40), (byte) (r7 >>> 32), (byte) (r7 >>> 24), (byte) (r7 >>> 16), (byte) (r7 >>> 8), (byte) r7}, 0, 8);
    }

    public static void a(OutputStream r2, String r3) {
        byte[] r4 = r3.getBytes(Charset.forName("UTF-8"));
        r2.write(r4, 0, r4.length);
    }

    public static void a(OutputStream r0, e r1) {
        r0.write(r1.a());
    }

    public static void a(OutputStream r3, Object r4) {
        if (r4 == null) goto L58;
        if (ZeusTransformUtils.instanceOf(r4, e.class) == false) goto L7;
        a(r3, (e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.aiagent.plugin"));
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L9;
    L55:
        r3.write(((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() ? 1 : 0);
        return;
    L9:
        if (Boolean.TYPE.isAssignableFrom(r4.getClass()) == true) goto L55;
        if (ZeusTransformUtils.instanceOf(r4, Character.class) == false) goto L14;
    L54:
        a(r3, ((Character) ZeusTransformUtils.preCheckCast(r4, Character.class, "com.obric.aiagent.plugin")).charValue());
        return;
    L14:
        if (Character.TYPE.isAssignableFrom(r4.getClass()) == true) goto L54;
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L19;
    L53:
        b(r3, Float.floatToRawIntBits(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue()));
        return;
    L19:
        if (Float.TYPE.isAssignableFrom(r4.getClass()) == true) goto L53;
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L24;
    L52:
        a(r3, Double.doubleToRawLongBits(((Double) ZeusTransformUtils.preCheckCast(r4, Double.class, "com.obric.aiagent.plugin")).doubleValue()));
        return;
    L24:
        if (Double.TYPE.isAssignableFrom(r4.getClass()) == true) goto L52;
        if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L29;
    L51:
        r3.write(((Byte) ZeusTransformUtils.preCheckCast(r4, Byte.class, "com.obric.aiagent.plugin")).byteValue());
        return;
    L29:
        if (Byte.TYPE.isAssignableFrom(r4.getClass()) == true) goto L51;
        if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L34;
    L50:
        a(r3, ((Short) ZeusTransformUtils.preCheckCast(r4, Short.class, "com.obric.aiagent.plugin")).shortValue());
        return;
    L34:
        if (Short.TYPE.isAssignableFrom(r4.getClass()) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L39;
    L49:
        b(r3, ((Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L39:
        if (Integer.TYPE.isAssignableFrom(r4.getClass()) == true) goto L49;
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L44;
    L48:
        a(r3, ((Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L44:
        if (Long.TYPE.isAssignableFrom(r4.getClass()) == true) goto L48;
        throw new IllegalArgumentException("bad value type: " + r4.getClass().getName());
    L58:
        throw new IllegalArgumentException("value is null.");
    }

    public static void b(OutputStream r7, long r8) {
        byte[] r0 = new byte[4096];
        int r2 = 0;
    L4:
        if (r2 >= (r8 >> 12)) goto L6;
        r7.write(r0);
        r2 = r2 + 1;
        goto L4
    L6:
        r7.write(r0, 0, (int) (r8 & 4095));
    }
}

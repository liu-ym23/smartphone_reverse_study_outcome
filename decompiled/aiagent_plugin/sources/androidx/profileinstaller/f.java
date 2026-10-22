package androidx.profileinstaller;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: ProfileTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f2257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f2258b = null;

    private static int b(int r0) {
        return ((r0 + 8) - 1) & (-8);
    }

    static {
        f2257a = new byte[]{112, 114, 111, 0};
        f2258b = new byte[]{112, 114, 109, 0};
    }

    static byte[] a(InputStream r1, byte[] r2) {
        if (Arrays.equals(r2, c.a(r1, r2.length)) == false) goto L7;
        return c.a(r1, h.f2270b.length);
    L7:
        throw c.b("Invalid magic");
    }

    static void a(OutputStream r1, byte[] r2) {
        r1.write(f2257a);
        r1.write(r2);
    }

    static boolean a(OutputStream r2, byte[] r3, b[] r4) {
        if (Arrays.equals(r3, h.f2269a) == false) goto L7;
        b(r2, r4);
        return true;
    L7:
        if (Arrays.equals(r3, h.f2270b) == false) goto L11;
        d(r2, r4);
        return true;
    L11:
        if (Arrays.equals(r3, h.f2272d) == false) goto L15;
        f(r2, r4);
        return true;
    L15:
        if (Arrays.equals(r3, h.f2271c) == false) goto L19;
        e(r2, r4);
        return true;
    L19:
        if (Arrays.equals(r3, h.f2273e) == false) goto L22;
        a(r2, r4);
        return true;
    L22:
        return false;
    }

    private static void a(OutputStream r8, b[] r9) {
        c.b(r8, r9.length);
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        b r3 = r9[r2];
        String r4 = a(r3.f2245a, r3.f2246b, h.f2273e);
        c.b(r8, c.a(r4));
        c.b(r8, r3.i.size());
        c.b(r8, r3.h.length);
        c.a(r8, r3.f2247c);
        c.a(r8, r4);
        Iterator<Integer> r5 = r3.i.keySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        c.b(r8, ((Integer) ZeusTransformUtils.preCheckCast(r5.next(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        goto L6
    L8:
        int[] r6 = r3.h;
        int r7 = r6.length;
        int r10 = 0;
    L9:
        if (r10 >= r7) goto L11;
        c.b(r8, r6[r10]);
        r10 = r10 + 1;
        goto L9
    L11:
        r2 = r2 + 1;
        goto L3
    }

    private static void b(OutputStream r0, b[] r1) {
        c(r0, r1);
    }

    private static void c(OutputStream r10, b[] r11) {
        ArrayList r0 = new ArrayList(3);
        ArrayList r2 = new ArrayList(3);
        r0.add(a(r11));
        r0.add(b(r11));
        r0.add(c(r11));
        long r3 = ((((long) h.f2269a.length) + ((long) f2257a.length)) + 4) + ((long) (r0.size() * 16));
        c.a(r10, r0.size());
        int r12 = 0;
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L11;
        i r5 = (i) ZeusTransformUtils.preCheckCast(r0.get(r1), i.class, "com.obric.aiagent.plugin");
        c.a(r10, r5.f2274a.a());
        c.a(r10, r3);
        if (r5.f2277d == false) goto L8;
        long r6 = r5.f2276c.length;
        byte[] r7 = c.a(r5.f2276c);
        r2.add(r7);
        c.a(r10, r7.length);
        c.a(r10, r6);
        int r8 = r7.length;
    L9:
        r3 = r3 + ((long) r8);
        r1 = r1 + 1;
        goto L4
    L8:
        r2.add(r5.f2276c);
        c.a(r10, r5.f2276c.length);
        c.a(r10, 0);
        r8 = r5.f2276c.length;
    L11:
        if (r12 >= r2.size()) goto L13;
        r10.write((byte[]) ZeusTransformUtils.preCheckCast(r2.get(r12), byte[].class, "com.obric.aiagent.plugin"));
        r12 = r12 + 1;
        goto L11
    }

    private static i a(b[] r8) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        c.b(r0, r8.length);     // Catch: Throwable -> L14
        int r3 = 0;
        int r4 = 2;
    L5:
        if (r3 >= r8.length) goto L7;
        b r5 = r8[r3];     // Catch: Throwable -> L14
        c.a(r0, r5.f2247c);     // Catch: Throwable -> L14
        c.a(r0, r5.f2248d);     // Catch: Throwable -> L14
        c.a(r0, r5.g);     // Catch: Throwable -> L14
        String r6 = a(r5.f2245a, r5.f2246b, h.f2269a);     // Catch: Throwable -> L14
        int r7 = c.a(r6);     // Catch: Throwable -> L14
        c.b(r0, r7);     // Catch: Throwable -> L14
        r4 = ((((r4 + 4) + 4) + 4) + 2) + (r7 * 1);     // Catch: Throwable -> L14
        c.a(r0, r6);     // Catch: Throwable -> L14
        r3 = r3 + 1;     // Catch: Throwable -> L14
        goto L5
    L7:
        byte[] r9 = r0.toByteArray();     // Catch: Throwable -> L14
        if (r4 != r9.length) goto L13;
        i r2 = new i(d.f2250a, r4, r9, false);     // Catch: Throwable -> L14
        r0.close();
        return r2;
    L13:
        throw c.b("Expected size " + r4 + ", does not match actual size " + r9.length);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    private static i b(b[] r5) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = 0;
        int r2 = 0;
    L19:
    L13:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        if (r1 >= r5.length) goto L6;
        b r3 = r5[r1];     // Catch: Throwable -> L13
        c.b(r0, r1);     // Catch: Throwable -> L13
        c.b(r0, r3.f2249e);     // Catch: Throwable -> L13
        r2 = ((r2 + 2) + 2) + (r3.f2249e * 2);     // Catch: Throwable -> L13
        c(r0, r3);     // Catch: Throwable -> L13
        r1 = r1 + 1;     // Catch: Throwable -> L13
        goto L19
    L6:
        byte[] r6 = r0.toByteArray();     // Catch: Throwable -> L13
        if (r2 != r6.length) goto L12;
        i r4 = new i(d.f2252c, r2, r6, true);     // Catch: Throwable -> L13
        r0.close();
        return r4;
    L12:
        throw c.b("Expected size " + r2 + ", does not match actual size " + r6.length);     // Catch: Throwable -> L13
    }

    private static i c(b[] r9) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        int r1 = 0;
        int r2 = 0;
    L21:
    L13:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        if (r1 >= r9.length) goto L6;
        b r3 = r9[r1];     // Catch: Throwable -> L13
        int r4 = c(r3);     // Catch: Throwable -> L13
        byte[] r5 = a(r3);     // Catch: Throwable -> L13
        byte[] r6 = b(r3);     // Catch: Throwable -> L13
        c.b(r0, r1);     // Catch: Throwable -> L13
        int r7 = (r5.length + 2) + r6.length;     // Catch: Throwable -> L13
        c.a(r0, r7);     // Catch: Throwable -> L13
        c.b(r0, r4);     // Catch: Throwable -> L13
        r0.write(r5);     // Catch: Throwable -> L13
        r0.write(r6);     // Catch: Throwable -> L13
        r2 = ((r2 + 2) + 4) + r7;     // Catch: Throwable -> L13
        r1 = r1 + 1;     // Catch: Throwable -> L13
        goto L21
    L6:
        byte[] r10 = r0.toByteArray();     // Catch: Throwable -> L13
        if (r2 != r10.length) goto L12;
        i r8 = new i(d.f2253d, r2, r10, true);     // Catch: Throwable -> L13
        r0.close();
        return r8;
    L12:
        throw c.b("Expected size " + r2 + ", does not match actual size " + r10.length);     // Catch: Throwable -> L13
    }

    private static byte[] a(b r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        d(r0, r1);     // Catch: Throwable -> L6
        byte[] r2 = r0.toByteArray();     // Catch: Throwable -> L6
        r0.close();
        return r2;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static byte[] b(b r1) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        b(r0, r1);     // Catch: Throwable -> L6
        byte[] r2 = r0.toByteArray();     // Catch: Throwable -> L6
        r0.close();
        return r2;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static int c(b r4) {
        Iterator<Map.Entry<Integer, Integer>> r5 = r4.i.entrySet().iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | ((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        goto L4
    L6:
        return r0;
    }

    private static void d(OutputStream r1, b[] r2) {
        byte[] r0 = a(r2, h.f2270b);
        c.a(r1, r2.length);
        c.a(r1, r0);
    }

    private static void e(OutputStream r1, b[] r2) {
        byte[] r0 = a(r2, h.f2271c);
        c.a(r1, r2.length);
        c.a(r1, r0);
    }

    private static void f(OutputStream r8, b[] r9) {
        c.a(r8, r9.length);
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        b r3 = r9[r2];
        int r4 = r3.i.size() * 4;
        String r5 = a(r3.f2245a, r3.f2246b, h.f2272d);
        c.b(r8, c.a(r5));
        c.b(r8, r3.h.length);
        c.a(r8, r4);
        c.a(r8, r3.f2247c);
        c.a(r8, r5);
        Iterator<Integer> r6 = r3.i.keySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        c.b(r8, ((Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.aiagent.plugin")).intValue());
        c.b(r8, 0);
        goto L6
    L8:
        int[] r7 = r3.h;
        int r10 = r7.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L11;
        c.b(r8, r7[r11]);
        r11 = r11 + 1;
        goto L9
    L11:
        r2 = r2 + 1;
        goto L3
    }

    private static byte[] a(b[] r8, byte[] r9) {
        int r0 = r8.length;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        b r4 = r8[r2];
        r3 = r3 + ((((c.a(a(r4.f2245a, r4.f2246b, r9)) + 16) + (r4.f2249e * 2)) + r4.f) + a(r4.g));
        r2 = r2 + 1;
        goto L3
    L5:
        ByteArrayOutputStream r5 = new ByteArrayOutputStream(r3);
        if (Arrays.equals(r9, h.f2271c) == false) goto L10;
        int r6 = r8.length;
    L8:
        if (r1 >= r6) goto L17;
        b r7 = r8[r1];
        a(r5, r7, a(r7.f2245a, r7.f2246b, r9));
        a(r5, r7);
        r1 = r1 + 1;
    L17:
        if (r5.size() != r3) goto L21;
        return r5.toByteArray();
    L21:
        throw c.b("The bytes saved do not match expectation. actual=" + r5.size() + " expected=" + r3);
    L10:
        int r10 = r8.length;
        int r11 = 0;
    L11:
        if (r11 >= r10) goto L13;
        b r12 = r8[r11];
        a(r5, r12, a(r12.f2245a, r12.f2246b, r9));
        r11 = r11 + 1;
        goto L11
    L13:
        int r13 = r8.length;
    L14:
        if (r1 >= r13) goto L17;
        a(r5, r8[r1]);
        r1 = r1 + 1;
        goto L14
    }

    private static int a(int r0) {
        return b(r0 * 2) / 8;
    }

    private static void a(byte[] r1, int r2, int r3, b r4) {
        int r5 = a(r2, r3, r4.g);
        int r6 = r5 / 8;
        int r7 = 1 << (r5 % 8);
        r1[r6] = (byte) (r7 | r1[r6]);
    }

    private static void a(OutputStream r2, b r3, String r4) {
        c.b(r2, c.a(r4));
        c.b(r2, r3.f2249e);
        c.a(r2, r3.f);
        c.a(r2, r3.f2247c);
        c.a(r2, r3.g);
        c.a(r2, r4);
    }

    private static void a(OutputStream r0, b r1) {
        b(r0, r1);
        c(r0, r1);
        d(r0, r1);
    }

    private static void b(OutputStream r6, b r7) {
        Iterator<Map.Entry<Integer, Integer>> r8 = r7.i.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        if ((((Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue() & 1) == 0) goto L4;
        c.b(r6, r3 - r1);
        c.b(r6, 0);
        r1 = r3;
        goto L4
    }

    private static void c(OutputStream r5, b r6) {
        int[] r7 = r6.h;
        int r0 = r7.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Integer r3 = Integer.valueOf(r7[r1]);
        c.b(r5, r3.intValue() - r2);
        r2 = r3.intValue();
        r1 = r1 + 1;
        goto L3
    }

    private static void d(OutputStream r6, b r7) {
        byte[] r0 = new byte[a(r7.g)];
        Iterator<Map.Entry<Integer, Integer>> r1 = r7.i.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        int r3 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue();
        if ((r4 & 2) == 0) goto L9;
        a(r0, 2, r3, r7);
    L9:
        if ((r4 & 4) == 0) goto L4;
        a(r0, 4, r3, r7);
        goto L4
    L11:
        r6.write(r0);
    }

    static b[] a(InputStream r4, byte[] r5, String r6) {
        if (Arrays.equals(r5, h.f2270b) == false) goto L19;
        int r7 = c.a(r4);
        long r0 = c.c(r4);
        byte[] r1 = c.a(r4, (int) c.c(r4), (int) r0);
        if (r4.read() > 0) goto L17;
        ByteArrayInputStream r8 = new ByteArrayInputStream(r1);
        b[] r9 = a(r8, r6, r7);     // Catch: Throwable -> L10
        r8.close();
        return r9;
    L10:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw c.b("Content found after the end of file");
    L19:
        throw c.b("Unsupported version");
    }

    static b[] a(InputStream r1, byte[] r2, byte[] r3, b[] r4) {
        if (Arrays.equals(r2, h.f) == false) goto L11;
        if (Arrays.equals(h.f2269a, r3) == true) goto L9;
        return a(r1, r2, r4);
    L9:
        throw c.b("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
    L11:
        if (Arrays.equals(r2, h.g) == false) goto L15;
        return b(r1, r3, r4);
    L15:
        throw c.b("Unsupported meta version");
    }

    static b[] a(InputStream r4, byte[] r5, b[] r6) {
        if (Arrays.equals(r5, h.f) == false) goto L19;
        int r7 = c.a(r4);
        long r0 = c.c(r4);
        byte[] r1 = c.a(r4, (int) c.c(r4), (int) r0);
        if (r4.read() > 0) goto L17;
        ByteArrayInputStream r8 = new ByteArrayInputStream(r1);
        b[] r9 = a(r8, r7, r6);     // Catch: Throwable -> L10
        r8.close();
        return r9;
    L10:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw c.b("Content found after the end of file");
    L19:
        throw c.b("Unsupported meta version");
    }

    static b[] b(InputStream r5, byte[] r6, b[] r7) {
        int r0 = c.b(r5);
        long r1 = c.c(r5);
        byte[] r2 = c.a(r5, (int) c.c(r5), (int) r1);
        if (r5.read() > 0) goto L15;
        ByteArrayInputStream r8 = new ByteArrayInputStream(r2);
        b[] r9 = a(r8, r6, r0, r7);     // Catch: Throwable -> L8
        r8.close();
        return r9;
    L8:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    L15:
        throw c.b("Content found after the end of file");
    }

    private static b[] a(InputStream r6, byte[] r7, int r8, b[] r9) {
        int r1 = 0;
        if (r6.available() != 0) goto L7;
        return new b[0];
    L7:
        if (r8 != r9.length) goto L19;
    L8:
        if (r1 >= r8) goto L17;
        c.b(r6);
        String r0 = c.c(r6, c.b(r6));
        long r2 = c.c(r6);
        int r4 = c.b(r6);
        b r5 = a(r9, r0);
        if (r5 == null) goto L16;
        r5.f2248d = r2;
        int[] r3 = a(r6, r4);
        if (Arrays.equals(r7, h.f2273e) == false) goto L14;
        r5.f2249e = r4;
        r5.h = r3;
    L14:
        r1 = r1 + 1;
        goto L8
    L16:
        throw c.b("Missing profile key: " + r0);
    L17:
        return r9;
    L19:
        throw c.b("Mismatched number of dex files found in metadata");
    }

    private static b a(b[] r3, String r4) {
        if (r3.length > 0) goto L5;
        return null;
    L5:
        String r5 = a(r4);
        int r0 = 0;
    L7:
        if (r0 >= r3.length) goto L13;
        if (r3[r0].f2246b.equals(r5) == true) goto L11;
        r0 = r0 + 1;
        goto L7
    L11:
        return r3[r0];
    L13:
        return null;
    }

    private static b[] a(InputStream r6, int r7, b[] r8) {
        int r1 = 0;
        if (r6.available() != 0) goto L7;
        return new b[0];
    L7:
        if (r7 != r8.length) goto L19;
        String[] r0 = new String[r7];
        int[] r2 = new int[r7];
        int r3 = 0;
    L9:
        if (r3 >= r7) goto L11;
        int r4 = c.b(r6);
        r2[r3] = c.b(r6);
        r0[r3] = c.c(r6, r4);
        r3 = r3 + 1;
    L11:
        if (r1 >= r7) goto L17;
        b r5 = r8[r1];
        if (r5.f2246b.equals(r0[r1]) == false) goto L16;
        r5.f2249e = r2[r1];
        r5.h = a(r6, r5.f2249e);
        r1 = r1 + 1;
        goto L11
    L16:
        throw c.b("Order of dexfiles in metadata did not match baseline");
    L17:
        return r8;
    L19:
        throw c.b("Mismatched number of dex files found in metadata");
    }

    private static String a(String r2, String r3, byte[] r4) {
        String r0 = h.a(r4);
        if (r2.length() > 0) goto L7;
        return a(r3, r0);
    L7:
        if (r3.equals("classes.dex") == false) goto L10;
        return r2;
    L10:
        if (r3.contains("!") == true) goto L20;
        if (r3.contains(":") == true) goto L20;
        if (r3.endsWith(".apk") == false) goto L18;
        return r3;
    L18:
        return r2 + h.a(r4) + r3;
    L20:
        return a(r3, r0);
    }

    private static String a(String r3, String r4) {
        if ("!".equals(r4) == false) goto L7;
        return r3.replace(":", "!");
    L7:
        if (":".equals(r4) == true) goto L9;
        return r3;
    L9:
        return r3.replace("!", ":");
    }

    private static String a(String r1) {
        int r0 = r1.indexOf("!");
        if (r0 >= 0) goto L5;
        r0 = r1.indexOf(":");
    L5:
        if (r0 > 0) goto L7;
        return r1;
    L7:
        return r1.substring(r0 + 1);
    }

    private static b[] a(InputStream r20, String r21, int r22) {
        int r3 = 0;
        if (r20.available() == 0) goto L5;
        b[] r2 = new b[r22];
        int r4 = 0;
    L7:
        if (r4 >= r22) goto L9;
        int r5 = c.b(r20);
        int r13 = c.b(r20);
        long r6 = c.c(r20);
        r2[r4] = new b(r21, c.c(r20, r5), c.c(r20), 0, r13, (int) r6, (int) c.c(r20), new int[r13], new TreeMap());
        r4 = r4 + 1;
    L9:
        if (r3 >= r22) goto L11;
        b r7 = r2[r3];
        a(r20, r7);
        r7.h = a(r20, r7.f2249e);
        b(r20, r7);
        r3 = r3 + 1;
        goto L9
    L11:
        return r2;
    L5:
        return new b[0];
    }

    private static void a(InputStream r5, b r6) {
        int r0 = r5.available() - r6.f;
        int r1 = 0;
    L4:
        if (r5.available() <= r0) goto L9;
        r1 = r1 + c.b(r5);
        r6.i.put(Integer.valueOf(r1), 1);
        int r2 = c.b(r5);
    L6:
        if (r2 <= 0) goto L4;
        a(r5);
        r2 = r2 - 1;
        goto L6
    L9:
        if (r5.available() != r0) goto L12;
        return;
    L12:
        throw c.b("Read too much data during profile line parse");
    }

    private static void a(InputStream r2) {
        c.b(r2);
        int r0 = c.a(r2);
        if (r0 != 6) goto L6;
        return;
    L6:
        if (r0 != 7) goto L8;
        return;
    L8:
        if (r0 <= 0) goto L13;
        c.a(r2);
        int r1 = c.a(r2);
    L10:
        if (r1 <= 0) goto L12;
        c.b(r2);
        r1 = r1 - 1;
        goto L10
    L12:
        r0 = r0 - 1;
        goto L8
    }

    private static int[] a(InputStream r4, int r5) {
        int[] r0 = new int[r5];
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r2 = r2 + c.b(r4);
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    private static void b(InputStream r6, b r7) {
        BitSet r8 = BitSet.valueOf(c.a(r6, c.a(r7.g * 2)));
        int r1 = 0;
    L4:
        if (r1 >= r7.g) goto L12;
        int r2 = a(r8, r1, r7.g);
        if (r2 == 0) goto L11;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r7.i.get(Integer.valueOf(r1)), Integer.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L10;
        r3 = 0;
    L10:
        r7.i.put(Integer.valueOf(r1), Integer.valueOf(r2 | r3.intValue()));
    L11:
        r1 = r1 + 1;
        goto L4
    }

    private static int a(BitSet r2, int r3, int r4) {
        int r0 = 2;
        if (r2.get(a(2, r3, r4)) == true) goto L7;
        r0 = 0;
    L7:
        if (r2.get(a(4, r3, r4)) == true) goto L9;
        return r0;
    L9:
        return r0 | 4;
    }

    private static int a(int r1, int r2, int r3) {
        if (r1 == 1) goto L14;
        if (r1 != 2) goto L7;
        return r2;
    L7:
        if (r1 != 4) goto L11;
        return r2 + r3;
    L11:
        throw c.b("Unexpected flag: " + r1);
    L14:
        throw c.b("HOT methods are not stored in the bitmap");
    }
}

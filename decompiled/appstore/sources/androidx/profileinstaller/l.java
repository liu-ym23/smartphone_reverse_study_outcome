package androidx.profileinstaller;

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

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f3971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f3972b = null;

    static {
        f3971a = new byte[]{112, 114, 111, 0};
        f3972b = new byte[]{112, 114, 109, 0};
    }

    public static void A(InputStream r10) {
        e.h(r10);
        int r11 = e.j(r10);
        if (r11 != 6) goto L6;
        return;
    L6:
        if (r11 != 7) goto L8;
        return;
    L8:
        if (r11 <= 0) goto L13;
        e.j(r10);
        int r12 = e.j(r10);
    L10:
        if (r12 <= 0) goto L12;
        e.h(r10);
        r12 = r12 - 1;
        goto L10
    L12:
        r11 = r11 - 1;
        goto L8
    }

    public static boolean B(OutputStream r10, byte[] r11, d[] r12) {
        if (Arrays.equals(r11, m.f3973a) == false) goto L7;
        N(r10, r12);
        return true;
    L7:
        if (Arrays.equals(r11, m.f3974b) == false) goto L11;
        M(r10, r12);
        return true;
    L11:
        if (Arrays.equals(r11, m.f3976d) == false) goto L15;
        K(r10, r12);
        return true;
    L15:
        if (Arrays.equals(r11, m.f3975c) == false) goto L19;
        L(r10, r12);
        return true;
    L19:
        if (Arrays.equals(r11, m.f3977e) == false) goto L22;
        J(r10, r12);
        return true;
    L22:
        return false;
    }

    public static void C(OutputStream r10, d r11) {
        int[] r12 = r11.f3961h;
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        int r16 = r12[r14];
        e.p(r10, r16 - r15);
        r14 = r14 + 1;
        r15 = r16;
        goto L3
    }

    public static n D(d[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        e.p(r11, r10.length);     // Catch: Throwable -> L7
        int r12 = 2;
        int r13 = 0;
    L5:
        if (r13 >= r10.length) goto L9;
        d r14 = r10[r13];     // Catch: Throwable -> L7
        e.q(r11, r14.f3956c);     // Catch: Throwable -> L7
        e.q(r11, r14.f3957d);     // Catch: Throwable -> L7
        e.q(r11, r14.f3960g);     // Catch: Throwable -> L7
        String r15 = j(r14.f3954a, r14.f3955b, m.f3973a);     // Catch: Throwable -> L7
        int r16 = e.k(r15);     // Catch: Throwable -> L7
        e.p(r11, r16);     // Catch: Throwable -> L7
        r12 = (r12 + 14) + r16;     // Catch: Throwable -> L7
        e.n(r11, r15);     // Catch: Throwable -> L7
        r13 = r13 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        byte[] r17 = r11.toByteArray();     // Catch: Throwable -> L7
        if (r12 != r17.length) goto L15;
        n r18 = new n(FileSectionType.DEX_FILES, r12, r17, false);     // Catch: Throwable -> L7
        r11.close();
        return r18;
    L15:
        throw e.c("Expected size " + r12 + ", does not match actual size " + r17.length);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    public static void E(OutputStream r10, byte[] r11) {
        r10.write(f3971a);
        r10.write(r11);
    }

    public static void F(OutputStream r10, d r11) {
        I(r10, r11);
        C(r10, r11);
        H(r10, r11);
    }

    public static void G(OutputStream r10, d r11, String r12) {
        e.p(r10, e.k(r12));
        e.p(r10, r11.f3958e);
        e.q(r10, r11.f3959f);
        e.q(r10, r11.f3956c);
        e.q(r10, r11.f3960g);
        e.n(r10, r12);
    }

    public static void H(OutputStream r10, d r11) {
        byte[] r12 = new byte[k(r11.f3960g)];
        Iterator r13 = r11.f3962i.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r14 = (Map.Entry) r13.next();
        int r15 = ((Integer) r14.getKey()).intValue();
        int r16 = ((Integer) r14.getValue()).intValue();
        if ((r16 & 2) == 0) goto L9;
        z(r12, 2, r15, r11);
    L9:
        if ((r16 & 4) == 0) goto L4;
        z(r12, 4, r15, r11);
        goto L4
    L11:
        r10.write(r12);
    }

    public static void I(OutputStream r10, d r11) {
        Iterator r12 = r11.f3962i.entrySet().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r14 = (Map.Entry) r12.next();
        int r15 = ((Integer) r14.getKey()).intValue();
        if ((((Integer) r14.getValue()).intValue() & 1) == 0) goto L4;
        e.p(r10, r15 - r13);
        e.p(r10, 0);
        r13 = r15;
        goto L4
    }

    public static void J(OutputStream r10, d[] r11) {
        e.p(r10, r11.length);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        d r14 = r11[r13];
        String r15 = j(r14.f3954a, r14.f3955b, m.f3977e);
        e.p(r10, e.k(r15));
        e.p(r10, r14.f3962i.size());
        e.p(r10, r14.f3961h.length);
        e.q(r10, r14.f3956c);
        e.n(r10, r15);
        Iterator r16 = r14.f3962i.keySet().iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        e.p(r10, ((Integer) r16.next()).intValue());
        goto L6
    L8:
        int[] r17 = r14.f3961h;
        int r18 = r17.length;
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L11;
        e.p(r10, r17[r19]);
        r19 = r19 + 1;
        goto L9
    L11:
        r13 = r13 + 1;
        goto L3
    }

    public static void K(OutputStream r10, d[] r11) {
        e.r(r10, r11.length);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        d r14 = r11[r13];
        int r15 = r14.f3962i.size() * 4;
        String r16 = j(r14.f3954a, r14.f3955b, m.f3976d);
        e.p(r10, e.k(r16));
        e.p(r10, r14.f3961h.length);
        e.q(r10, r15);
        e.q(r10, r14.f3956c);
        e.n(r10, r16);
        Iterator r17 = r14.f3962i.keySet().iterator();
    L6:
        if (r17.hasNext() == false) goto L8;
        e.p(r10, ((Integer) r17.next()).intValue());
        e.p(r10, 0);
        goto L6
    L8:
        int[] r18 = r14.f3961h;
        int r19 = r18.length;
        int r20 = 0;
    L9:
        if (r20 >= r19) goto L11;
        e.p(r10, r18[r20]);
        r20 = r20 + 1;
        goto L9
    L11:
        r13 = r13 + 1;
        goto L3
    }

    public static void L(OutputStream r10, d[] r11) {
        byte[] r12 = b(r11, m.f3975c);
        e.r(r10, r11.length);
        e.m(r10, r12);
    }

    public static void M(OutputStream r10, d[] r11) {
        byte[] r12 = b(r11, m.f3974b);
        e.r(r10, r11.length);
        e.m(r10, r12);
    }

    public static void N(OutputStream r10, d[] r11) {
        O(r10, r11);
    }

    public static void O(OutputStream r10, d[] r11) {
        ArrayList r12 = new ArrayList(3);
        ArrayList r13 = new ArrayList(3);
        r12.add(D(r11));
        r12.add(c(r11));
        r12.add(d(r11));
        long r14 = ((((long) m.f3973a.length) + ((long) f3971a.length)) + 4) + ((long) (r12.size() * 16));
        e.q(r10, r12.size());
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r16 >= r12.size()) goto L12;
        n r17 = (n) r12.get(r16);
        e.q(r10, r17.f3980a.getValue());
        e.q(r10, r14);
        if (r17.f3983d == false) goto L9;
        byte[] r18 = r17.f3982c;
        long r19 = r18.length;
        byte[] r20 = e.b(r18);
        r13.add(r20);
        e.q(r10, r20.length);
        e.q(r10, r19);
        int r21 = r20.length;
    L8:
        r14 = r14 + ((long) r21);
        r16 = r16 + 1;
        goto L4
    L9:
        r13.add(r17.f3982c);
        e.q(r10, r17.f3982c.length);
        e.q(r10, 0);
        r21 = r17.f3982c.length;
    L12:
        if (r15 >= r13.size()) goto L14;
        r10.write((byte[]) r13.get(r15));
        r15 = r15 + 1;
        goto L12
    }

    public static int a(d r10) {
        Iterator r11 = r10.f3962i.entrySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | ((Integer) ((Map.Entry) r11.next()).getValue()).intValue();
        goto L4
    L6:
        return r12;
    }

    public static byte[] b(d[] r10, byte[] r11) {
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r12) goto L5;
        d r16 = r10[r14];
        r15 = r15 + ((((e.k(j(r16.f3954a, r16.f3955b, r11)) + 16) + (r16.f3958e * 2)) + r16.f3959f) + k(r16.f3960g));
        r14 = r14 + 1;
        goto L3
    L5:
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(r15);
        if (Arrays.equals(r11, m.f3975c) == false) goto L10;
        int r18 = r10.length;
    L8:
        if (r13 >= r18) goto L17;
        d r19 = r10[r13];
        G(r17, r19, j(r19.f3954a, r19.f3955b, r11));
        F(r17, r19);
        r13 = r13 + 1;
    L17:
        if (r17.size() != r15) goto L21;
        return r17.toByteArray();
    L21:
        throw e.c("The bytes saved do not match expectation. actual=" + r17.size() + " expected=" + r15);
    L10:
        int r20 = r10.length;
        int r21 = 0;
    L11:
        if (r21 >= r20) goto L13;
        d r22 = r10[r21];
        G(r17, r22, j(r22.f3954a, r22.f3955b, r11));
        r21 = r21 + 1;
        goto L11
    L13:
        int r23 = r10.length;
    L14:
        if (r13 >= r23) goto L17;
        F(r17, r10[r13]);
        r13 = r13 + 1;
        goto L14
    }

    public static n c(d[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        int r12 = 0;
        int r13 = 0;
    L20:
    L6:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        if (r12 >= r10.length) goto L8;
        d r14 = r10[r12];     // Catch: Throwable -> L6
        e.p(r11, r12);     // Catch: Throwable -> L6
        e.p(r11, r14.f3958e);     // Catch: Throwable -> L6
        r13 = (r13 + 4) + (r14.f3958e * 2);     // Catch: Throwable -> L6
        C(r11, r14);     // Catch: Throwable -> L6
        r12 = r12 + 1;     // Catch: Throwable -> L6
        goto L20
    L8:
        byte[] r15 = r11.toByteArray();     // Catch: Throwable -> L6
        if (r13 != r15.length) goto L14;
        n r16 = new n(FileSectionType.CLASSES, r13, r15, true);     // Catch: Throwable -> L6
        r11.close();
        return r16;
    L14:
        throw e.c("Expected size " + r13 + ", does not match actual size " + r15.length);     // Catch: Throwable -> L6
    }

    public static n d(d[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        int r12 = 0;
        int r13 = 0;
    L20:
    L6:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        if (r12 >= r10.length) goto L8;
        d r14 = r10[r12];     // Catch: Throwable -> L6
        int r15 = a(r14);     // Catch: Throwable -> L6
        byte[] r16 = e(r14);     // Catch: Throwable -> L6
        byte[] r17 = f(r14);     // Catch: Throwable -> L6
        e.p(r11, r12);     // Catch: Throwable -> L6
        int r18 = (r16.length + 2) + r17.length;     // Catch: Throwable -> L6
        e.q(r11, r18);     // Catch: Throwable -> L6
        e.p(r11, r15);     // Catch: Throwable -> L6
        r11.write(r16);     // Catch: Throwable -> L6
        r11.write(r17);     // Catch: Throwable -> L6
        r13 = (r13 + 6) + r18;     // Catch: Throwable -> L6
        r12 = r12 + 1;     // Catch: Throwable -> L6
        goto L20
    L8:
        byte[] r19 = r11.toByteArray();     // Catch: Throwable -> L6
        if (r13 != r19.length) goto L14;
        n r20 = new n(FileSectionType.METHODS, r13, r19, true);     // Catch: Throwable -> L6
        r11.close();
        return r20;
    L14:
        throw e.c("Expected size " + r13 + ", does not match actual size " + r19.length);     // Catch: Throwable -> L6
    }

    public static byte[] e(d r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        H(r11, r10);     // Catch: Throwable -> L6
        byte[] r12 = r11.toByteArray();     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public static byte[] f(d r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        I(r11, r10);     // Catch: Throwable -> L6
        byte[] r12 = r11.toByteArray();     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public static String g(String r10, String r11) {
        if ("!".equals(r11) == false) goto L7;
        return r10.replace(":", "!");
    L7:
        if (":".equals(r11) == true) goto L9;
        return r10;
    L9:
        return r10.replace("!", ":");
    }

    public static String h(String r10) {
        int r11 = r10.indexOf("!");
        if (r11 >= 0) goto L5;
        r11 = r10.indexOf(":");
    L5:
        if (r11 > 0) goto L7;
        return r10;
    L7:
        return r10.substring(r11 + 1);
    }

    public static d i(d[] r10, String r11) {
        if (r10.length > 0) goto L5;
        return null;
    L5:
        String r12 = h(r11);
        int r13 = 0;
    L7:
        if (r13 >= r10.length) goto L13;
        if (r10[r13].f3955b.equals(r12) == true) goto L11;
        r13 = r13 + 1;
        goto L7
    L11:
        return r10[r13];
    L13:
        return null;
    }

    public static String j(String r10, String r11, byte[] r12) {
        String r13 = m.a(r12);
        if (r10.length() > 0) goto L7;
        return g(r11, r13);
    L7:
        if (r11.equals("classes.dex") == false) goto L10;
        return r10;
    L10:
        if (r11.contains("!") == true) goto L20;
        if (r11.contains(":") == true) goto L20;
        if (r11.endsWith(".apk") == false) goto L18;
        return r11;
    L18:
        return r10 + m.a(r12) + r11;
    L20:
        return g(r11, r13);
    }

    public static int k(int r10) {
        return y(r10 * 2) / 8;
    }

    public static int l(int r10, int r11, int r12) {
        if (r10 == 1) goto L14;
        if (r10 != 2) goto L7;
        return r11;
    L7:
        if (r10 != 4) goto L11;
        return r11 + r12;
    L11:
        throw e.c("Unexpected flag: " + r10);
    L14:
        throw e.c("HOT methods are not stored in the bitmap");
    }

    public static int[] m(InputStream r10, int r11) {
        int[] r12 = new int[r11];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r14 = r14 + e.h(r10);
        r12[r13] = r14;
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public static int n(BitSet r10, int r11, int r12) {
        int r13 = 2;
        if (r10.get(l(2, r11, r12)) == true) goto L7;
        r13 = 0;
    L7:
        if (r10.get(l(4, r11, r12)) == true) goto L9;
        return r13;
    L9:
        return r13 | 4;
    }

    public static byte[] o(InputStream r10, byte[] r11) {
        if (Arrays.equals(r11, e.d(r10, r11.length)) == false) goto L7;
        return e.d(r10, m.f3974b.length);
    L7:
        throw e.c("Invalid magic");
    }

    public static void p(InputStream r10, d r11) {
        int r12 = r10.available() - r11.f3959f;
        int r13 = 0;
    L4:
        if (r10.available() <= r12) goto L9;
        r13 = r13 + e.h(r10);
        r11.f3962i.put(Integer.valueOf(r13), 1);
        int r14 = e.h(r10);
    L6:
        if (r14 <= 0) goto L4;
        A(r10);
        r14 = r14 - 1;
        goto L6
    L9:
        if (r10.available() != r12) goto L12;
        return;
    L12:
        throw e.c("Read too much data during profile line parse");
    }

    public static d[] q(InputStream r10, byte[] r11, byte[] r12, d[] r13) {
        if (Arrays.equals(r11, m.f3978f) == false) goto L11;
        if (Arrays.equals(m.f3973a, r12) == true) goto L9;
        return r(r10, r11, r13);
    L9:
        throw e.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
    L11:
        if (Arrays.equals(r11, m.f3979g) == false) goto L15;
        return t(r10, r12, r13);
    L15:
        throw e.c("Unsupported meta version");
    }

    public static d[] r(InputStream r10, byte[] r11, d[] r12) {
        if (Arrays.equals(r11, m.f3978f) == false) goto L19;
        int r13 = e.j(r10);
        long r14 = e.i(r10);
        byte[] r15 = e.e(r10, (int) e.i(r10), (int) r14);
        if (r10.read() > 0) goto L17;
        ByteArrayInputStream r16 = new ByteArrayInputStream(r15);
        d[] r17 = s(r16, r13, r12);     // Catch: Throwable -> L10
        r16.close();
        return r17;
    L10:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw e.c("Content found after the end of file");
    L19:
        throw e.c("Unsupported meta version");
    }

    public static d[] s(InputStream r10, int r11, d[] r12) {
        int r13 = 0;
        if (r10.available() != 0) goto L7;
        return new d[0];
    L7:
        if (r11 != r12.length) goto L19;
        String[] r14 = new String[r11];
        int[] r15 = new int[r11];
        int r16 = 0;
    L9:
        if (r16 >= r11) goto L11;
        int r17 = e.h(r10);
        r15[r16] = e.h(r10);
        r14[r16] = e.f(r10, r17);
        r16 = r16 + 1;
    L11:
        if (r13 >= r11) goto L17;
        d r18 = r12[r13];
        if (r18.f3955b.equals(r14[r13]) == false) goto L16;
        int r19 = r15[r13];
        r18.f3958e = r19;
        r18.f3961h = m(r10, r19);
        r13 = r13 + 1;
        goto L11
    L16:
        throw e.c("Order of dexfiles in metadata did not match baseline");
    L17:
        return r12;
    L19:
        throw e.c("Mismatched number of dex files found in metadata");
    }

    public static d[] t(InputStream r10, byte[] r11, d[] r12) {
        int r13 = e.h(r10);
        long r14 = e.i(r10);
        byte[] r15 = e.e(r10, (int) e.i(r10), (int) r14);
        if (r10.read() > 0) goto L15;
        ByteArrayInputStream r16 = new ByteArrayInputStream(r15);
        d[] r17 = u(r16, r11, r13, r12);     // Catch: Throwable -> L8
        r16.close();
        return r17;
    L8:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    L15:
        throw e.c("Content found after the end of file");
    }

    public static d[] u(InputStream r10, byte[] r11, int r12, d[] r13) {
        int r14 = 0;
        if (r10.available() != 0) goto L7;
        return new d[0];
    L7:
        if (r12 != r13.length) goto L19;
    L8:
        if (r14 >= r12) goto L17;
        e.h(r10);
        String r15 = e.f(r10, e.h(r10));
        long r16 = e.i(r10);
        int r17 = e.h(r10);
        d r18 = i(r13, r15);
        if (r18 == null) goto L16;
        r18.f3957d = r16;
        int[] r19 = m(r10, r17);
        if (Arrays.equals(r11, m.f3977e) == false) goto L14;
        r18.f3958e = r17;
        r18.f3961h = r19;
    L14:
        r14 = r14 + 1;
        goto L8
    L16:
        throw e.c("Missing profile key: " + r15);
    L17:
        return r13;
    L19:
        throw e.c("Mismatched number of dex files found in metadata");
    }

    public static void v(InputStream r10, d r11) {
        BitSet r12 = BitSet.valueOf(e.d(r10, e.a(r11.f3960g * 2)));
        int r13 = 0;
    L3:
        int r14 = r11.f3960g;
        if (r13 >= r14) goto L12;
        int r15 = n(r12, r13, r14);
        if (r15 == 0) goto L11;
        Integer r16 = (Integer) r11.f3962i.get(Integer.valueOf(r13));
        if (r16 != null) goto L10;
        r16 = 0;
    L10:
        r11.f3962i.put(Integer.valueOf(r13), Integer.valueOf(r15 | r16.intValue()));
    L11:
        r13 = r13 + 1;
        goto L3
    }

    public static d[] w(InputStream r10, byte[] r11, String r12) {
        if (Arrays.equals(r11, m.f3974b) == false) goto L19;
        int r13 = e.j(r10);
        long r14 = e.i(r10);
        byte[] r15 = e.e(r10, (int) e.i(r10), (int) r14);
        if (r10.read() > 0) goto L17;
        ByteArrayInputStream r16 = new ByteArrayInputStream(r15);
        d[] r17 = x(r16, r12, r13);     // Catch: Throwable -> L10
        r16.close();
        return r17;
    L10:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw e.c("Content found after the end of file");
    L19:
        throw e.c("Unsupported version");
    }

    public static d[] x(InputStream r19, String r20, int r21) {
        int r10 = 0;
        if (r19.available() == 0) goto L5;
        d[] r11 = new d[r21];
        int r12 = 0;
    L7:
        if (r12 >= r21) goto L9;
        int r13 = e.h(r19);
        int r14 = e.h(r19);
        long r15 = e.i(r19);
        r11[r12] = new d(r20, e.f(r19, r13), e.i(r19), 0, r14, (int) r15, (int) e.i(r19), new int[r14], new TreeMap());
        r12 = r12 + 1;
    L9:
        if (r10 >= r21) goto L11;
        d r16 = r11[r10];
        p(r19, r16);
        r16.f3961h = m(r19, r16.f3958e);
        v(r19, r16);
        r10 = r10 + 1;
        goto L9
    L11:
        return r11;
    L5:
        return new d[0];
    }

    public static int y(int r10) {
        return (r10 + 7) & (-8);
    }

    public static void z(byte[] r10, int r11, int r12, d r13) {
        int r14 = l(r11, r12, r13.f3960g);
        int r15 = r14 / 8;
        int r16 = 1 << (r14 % 8);
        r10[r15] = (byte) (r16 | r10[r15]);
    }
}

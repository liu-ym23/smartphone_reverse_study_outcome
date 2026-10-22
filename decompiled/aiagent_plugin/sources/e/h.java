package e;

import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes4.dex */
public class h implements Serializable, Comparable<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38722a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f38723b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f38724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient int f38725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private transient String f38726e;

    /* JADX INFO: compiled from: ByteString.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public static /* synthetic */ h a(a r0, byte[] r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = b.a();
        L9:
            return r0.a(r1, r2, r3);
        }

        private a() {
        }

        public final h a(String r1, Charset r2) {
            d.h.b.o.e(r1, "<this>");
            d.h.b.o.e(r2, "charset");
            byte[] r3 = r1.getBytes(r2);
            d.h.b.o.c(r3, "this as java.lang.String).getBytes(charset)");
            return new h(r3);
        }

        public final h a(byte... r2) {
            d.h.b.o.e(r2, "data");
            byte[] r3 = Arrays.copyOf(r2, r2.length);
            d.h.b.o.c(r3, "copyOf(this, size)");
            return new h(r3);
        }

        public final h a(byte[] r7, int r8, int r9) {
            d.h.b.o.e(r7, "<this>");
            int r6 = b.a(r7, r9);
            b.a(r7.length, r8, r6);
            return new h(d.a.i.a(r7, r8, r6 + r8));
        }

        public final h a(String r2) {
            d.h.b.o.e(r2, "<this>");
            h r1 = new h(ad.a(r2));
            r1.a(r2);
            return r1;
        }

        public final h b(String r1) {
            d.h.b.o.e(r1, "<this>");
            byte[] r0 = e.a.a(r1);
            if (r0 != null) goto L7;
            return null;
        L7:
            return new h(r0);
        }

        public final h c(String r6) {
            d.h.b.o.e(r6, "<this>");
            int r0 = 0;
            if ((r6.length() % 2) != 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L13;
            int r7 = r6.length() / 2;
            byte[] r2 = new byte[r7];
        L8:
            if (r0 >= r7) goto L11;
            int r3 = r0 * 2;
            r2[r0] = (byte) ((e.a.b.a(r6.charAt(r3)) << 4) + e.a.b.a(r6.charAt(r3 + 1)));
            r0 = r0 + 1;
            goto L8
        L11:
            return new h(r2);
        L13:
            throw new IllegalArgumentException(("Unexpected hex string: " + r6).toString());
        L5:
            r5 = false;
            goto L6
        }
    }

    public static final h a(byte... r1) {
        return f38722a.a(r1);
    }

    public static final h c(String r1) {
        return f38722a.a(r1);
    }

    public h(byte[] r2) {
        d.h.b.o.e(r2, "data");
        this.f38724c = r2;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(h r3) {
        return b((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
    }

    public final byte[] a() {
        return this.f38724c;
    }

    public final void a(int r1) {
        this.f38725d = r1;
    }

    public final int b() {
        return this.f38725d;
    }

    public final void a(String r1) {
        this.f38726e = r1;
    }

    public final String c() {
        return this.f38726e;
    }

    public final h f() {
        return b(CryptoConst.ALGORITHM_MD5);
    }

    public final h g() {
        return b("SHA-1");
    }

    public final h h() {
        return b("SHA-256");
    }

    public h b(String r3) {
        d.h.b.o.e(r3, "algorithm");
        MessageDigest r4 = MessageDigest.getInstance(r3);
        r4.update(this.f38724c, 0, k());
        byte[] r2 = r4.digest();
        d.h.b.o.a(r2);
        return new h(r2);
    }

    public final byte c(int r1) {
        return b(r1);
    }

    public final int k() {
        return l();
    }

    public void a(e r2, int r3, int r4) {
        d.h.b.o.e(r2, "buffer");
        e.a.b.a(this, r2, r3, r4);
    }

    static {
        f38722a = new a(null);
        f38723b = new h(new byte[0]);
    }

    public String d() {
        String r0 = c();
        if (r0 != null) goto L6;
        String r1 = ad.a(n());
        a(r1);
        return r1;
    L6:
        return r0;
    }

    public String e() {
        return e.a.a(a(), null, 1, null);
    }

    public String i() {
        char[] r0 = new char[a().length * 2];
        byte[] r8 = a();
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        byte r4 = r8[r2];
        int r5 = r3 + 1;
        r0[r3] = e.a.b.a()[(r4 >> 4) & 15];
        r3 = r5 + 1;
        r0[r5] = e.a.b.a()[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return d.o.o.a(r0);
    }

    public h j() {
        int r0 = 0;
    L4:
        if (r0 >= a().length) goto L30;
        byte r1 = a()[r0];
        if (r1 < 65) goto L20;
        if (r1 > 90) goto L20;
        byte[] r5 = a();
        byte[] r6 = Arrays.copyOf(r5, r5.length);
        d.h.b.o.c(r6, "copyOf(this, size)");
        int r4 = r0 + 1;
        r6[r0] = (byte) (r1 + 32);
    L12:
        if (r4 >= r6.length) goto L21;
        byte r2 = r6[r4];
        if (r2 < 65) goto L18;
        if (r2 > 90) goto L18;
        r6[r4] = (byte) (r2 + 32);
    L18:
        r4 = r4 + 1;
        goto L12
    L21:
        return new h(r6);
    L20:
        r0 = r0 + 1;
        goto L4
    L30:
        return this;
    }

    public byte b(int r1) {
        return a()[r1];
    }

    public int l() {
        return a().length;
    }

    public byte[] m() {
        byte[] r1 = a();
        byte[] r2 = Arrays.copyOf(r1, r1.length);
        d.h.b.o.c(r2, "copyOf(this, size)");
        return r2;
    }

    public byte[] n() {
        return a();
    }

    public boolean a(int r2, h r3, int r4, int r5) {
        d.h.b.o.e(r3, "other");
        return r3.a(r4, a(), r2, r5);
    }

    public boolean a(int r2, byte[] r3, int r4, int r5) {
        d.h.b.o.e(r3, "other");
        if (r2 >= 0) goto L5;
    L12:
        return false;
    L5:
        if (r2 > (a().length - r5)) goto L12;
        if (r4 < 0) goto L12;
        if (r4 > (r3.length - r5)) goto L12;
        if (b.a(a(), r2, r3, r4, r5) == false) goto L12;
        return true;
    }

    public final boolean a(h r3) {
        d.h.b.o.e(r3, "prefix");
        return a(0, r3, 0, r3.k());
    }

    public boolean equals(Object r7) {
        if (r7 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L13;
        if (((h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin")).k() != a().length) goto L13;
        if (((h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.aiagent.plugin")).a(0, a(), 0, a().length) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        int r0 = b();
        if (r0 != 0) goto L7;
        int r1 = Arrays.hashCode(a());
        a(r1);
        return r1;
    L7:
        return r0;
    }

    public int b(h r10) {
        d.h.b.o.e(r10, "other");
        int r0 = k();
        int r1 = r10.k();
        int r2 = Math.min(r0, r1);
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L10;
        int r7 = c(r4) & 255;
        int r8 = r10.c(r4) & 255;
        if (r7 != r8) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        if (r7 < r8) goto L18;
    L15:
        return 1;
    L18:
        return -1;
    L10:
        if (r0 == r1) goto L19;
        if (r0 >= r1) goto L15;
    L19:
        return 0;
    }

    public String toString() {
        boolean r1 = true;
        if (a().length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return "[size=0]";
    L8:
        int r2 = e.a.b.a(a(), 64);
        if (r2 == (-1)) goto L11;
        String r3 = d();
        String r8 = r3.substring(0, r2);
        d.h.b.o.c(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        String r4 = d.o.o.a(d.o.o.a(d.o.o.a(r8, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r2 >= r3.length()) goto L36;
        return "[size=" + a().length + " text=" + r4 + "…]";
    L36:
        return "[text=" + r4 + ']';
    L11:
        if (a().length <= 64) goto L38;
        StringBuilder r5 = new StringBuilder().append("[size=").append(a().length).append(" hex=");
        int r6 = b.a(this, 64);
        if (r6 > a().length) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L31;
        if ((r6 + 0) >= 0) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L29;
        if (r6 != a().length) goto L26;
        h r9 = this;
    L39:
        return r5.append(r9.i()).append("…]").toString();
    L26:
        r9 = new h(d.a.i.a(a(), 0, r6));
        goto L39
    L29:
        throw new IllegalArgumentException("endIndex < beginIndex".toString());
    L31:
        throw new IllegalArgumentException(("endIndex > length(" + a().length + ')').toString());
    L16:
        r7 = false;
        goto L17
    L38:
        return "[hex=" + i() + ']';
    L5:
        r0 = false;
        goto L6
    }
}

package okhttp3.internal;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import e.e;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: hostnames.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final String a(String r6) {
        o.e(r6, "<this>");
        boolean r3 = false;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(":", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == true) goto L5;
        String r7 = IDN.toASCII(r6);     // Catch: IllegalArgumentException -> L32
        o.c(r7, "toASCII(host)");     // Catch: IllegalArgumentException -> L32
        Locale r0 = Locale.US;     // Catch: IllegalArgumentException -> L32
        o.c(r0, "US");     // Catch: IllegalArgumentException -> L32
        String r8 = r7.toLowerCase(r0);     // Catch: IllegalArgumentException -> L32
        o.c(r8, "this as java.lang.String).toLowerCase(locale)");     // Catch: IllegalArgumentException -> L32
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L27;
        return null;
    L27:
        if (b(r8) == false) goto L31;
        return null;
    L31:
        return r8;
    L36:
        return null;
    L5:
        if (d.o.o.b(r6, "[", false, 2, null) == true) goto L7;
    L9:
        InetAddress r1 = a(r6, 0, r6.length());
    L10:
        if (r1 != null) goto L12;
        return null;
    L12:
        byte[] r2 = r1.getAddress();
        if (r2.length != 16) goto L17;
        o.c(r2, SensitiveType.ADDRESS);
        return a(r2);
    L17:
        if (r2.length != 4) goto L21;
        return r1.getHostAddress();
    L21:
        throw new AssertionError("Invalid IPv6 address: '" + r6 + '\'');
    L7:
        if (d.o.o.c(r6, "]", false, 2, null) == false) goto L9;
        r1 = a(r6, 1, r6.length() - 1);
        goto L10
    }

    private static final boolean b(String r10) {
        int r0 = r10.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        char r4 = r10.charAt(r2);
        if (o.a(r4, 31) <= 0) goto L13;
        if (o.a(r4, 127) >= 0) goto L13;
        if (d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(" #%/:?@[\\]", CharSequence.class, "com.obric.aiagent.plugin"), r4, 0, false, 6, null) != (-1)) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    private static final InetAddress a(String r18, int r19, int r20) {
        byte[] r9 = new byte[16];
        int r12 = r19;
        int r14 = -1;
        int r15 = -1;
        int r13 = 0;
    L4:
        if (r12 >= r20) goto L41;
        if (r13 == 16) goto L6;
        int r5 = r12 + 2;
        if (r5 <= r20) goto L10;
    L17:
        if (r13 != 0) goto L19;
    L28:
        r15 = r12;
    L29:
        r12 = r15;
        int r0 = 0;
    L30:
        if (r12 >= r20) goto L34;
        int r1 = c.a(r18.charAt(r12));
        if (r1 == (-1)) goto L34;
        r0 = (r0 << 4) + r1;
        r12 = r12 + 1;
    L34:
        int r2 = r12 - r15;
        if (r2 == 0) goto L40;
        if (r2 > 4) goto L40;
        int r3 = r13 + 1;
        r9[r13] = (byte) ((r0 >>> 8) & 255);
        r13 = r3 + 1;
        r9[r3] = (byte) (r0 & 255);
    L40:
        return null;
    L19:
        if (d.o.o.a(r18, ":", r12, false, 4, null) == false) goto L22;
        r12 = r12 + 1;
        goto L28
    L22:
        if (d.o.o.a(r18, ".", r12, false, 4, null) == true) goto L24;
        return null;
    L24:
        if (a(r18, r15, r20, r9, r13 - 2) == true) goto L26;
        return null;
    L26:
        r13 = r13 + 2;
        goto L41
    L10:
        if (d.o.o.a(r18, "::", r12, false, 4, null) == false) goto L17;
        if (r14 != (-1)) goto L12;
        r13 = r13 + 2;
        if (r5 == r20) goto L15;
        r15 = r5;
        r14 = r13;
        goto L29
    L15:
        r14 = r13;
        goto L41
    L12:
        return null;
    L6:
        return null;
    L41:
        if (r13 == 16) goto L46;
        if (r14 != (-1)) goto L44;
        return null;
    L44:
        int r4 = r13 - r14;
        System.arraycopy(r9, r14, r9, 16 - r4, r4);
        Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
    L46:
        return InetAddress.getByAddress(r9);
    }

    private static final boolean a(String r7, int r8, int r9, byte[] r10, int r11) {
        int r0 = r11;
    L4:
        if (r8 >= r9) goto L32;
        if (r0 == r10.length) goto L7;
        if (r0 != r11) goto L10;
    L13:
        int r2 = r8;
        int r3 = 0;
    L14:
        if (r2 >= r9) goto L28;
        char r4 = r7.charAt(r2);
        if (o.a(r4, 48) < 0) goto L28;
        if (o.a(r4, 57) > 0) goto L28;
        if (r3 != 0) goto L23;
        if (r8 == r2) goto L23;
        return false;
    L23:
        r3 = ((r3 * 10) + r4) - 48;
        if (r3 > 255) goto L25;
        r2 = r2 + 1;
        goto L14
    L25:
        return false;
    L28:
        if ((r2 - r8) == 0) goto L29;
        r10[r0] = (byte) r3;
        r0 = r0 + 1;
        r8 = r2;
        goto L4
    L29:
        return false;
    L10:
        if (r7.charAt(r8) != '.') goto L11;
        r8 = r8 + 1;
        goto L13
    L11:
        return false;
    L7:
        return false;
    L32:
        if (r0 != (r11 + 4)) goto L44;
        return true;
    L44:
        return false;
    }

    private static final String a(byte[] r8) {
        int r0 = 0;
        int r1 = -1;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r8.length) goto L18;
        int r4 = r2;
    L6:
        if (r4 >= 16) goto L12;
        if (r8[r4] != 0) goto L12;
        if (r8[r4 + 1] != 0) goto L12;
        r4 = r4 + 2;
    L12:
        int r5 = r4 - r2;
        if (r5 <= r3) goto L17;
        if (r5 < 4) goto L17;
        r1 = r2;
        r3 = r5;
    L17:
        r2 = r4 + 2;
        goto L4
    L18:
        e r6 = new e();
    L20:
        if (r0 >= r8.length) goto L30;
        if (r0 == r1) goto L23;
        if (r0 <= 0) goto L28;
        r6.b(58);
    L28:
        r6.l((c.a(r8[r0], 255) << 8) | c.a(r8[r0 + 1], 255));
        r0 = r0 + 2;
        goto L20
    L23:
        r6.b(58);
        r0 = r0 + r3;
        if (r0 != 16) goto L20;
        r6.b(58);
        goto L20
    L30:
        return r6.u();
    }
}

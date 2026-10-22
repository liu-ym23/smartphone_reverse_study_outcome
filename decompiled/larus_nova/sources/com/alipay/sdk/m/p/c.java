package com.alipay.sdk.m.p;

import com.alipay.sdk.m.u.n;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes28.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25652b;

    public c(boolean r100) {
        this.f25651a = r100;
        this.f25652b = n.a(24);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    public static byte[] a(byte[]... r100) {
        ?? r101 = 0;
        byte[] r102 = null;
        r102 = null;
        if (r100 == null) goto L43;
        ?? r103 = r100.length;
        if (r103 == 0) goto L43;
        r103 = new ByteArrayOutputStream();     // Catch: Throwable -> L22 Exception -> L24
        DataOutputStream r104 = new DataOutputStream(r103);     // Catch: Throwable -> L17 Exception -> L20
        int r105 = r100.length;     // Catch: Exception -> L15 Throwable -> L34
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L12;
        byte[] r107 = r100[r106];     // Catch: Exception -> L15 Throwable -> L34
        r104.write(a(r107.length).getBytes());     // Catch: Exception -> L15 Throwable -> L34
        r104.write(r107);     // Catch: Exception -> L15 Throwable -> L34
        r106 = r106 + 1;     // Catch: Exception -> L15 Throwable -> L34
        goto L10
    L12:
        r104.flush();     // Catch: Exception -> L15 Throwable -> L34
        byte[] r108 = r103.toByteArray();     // Catch: Exception -> L15 Throwable -> L34
        r103.close();     // Catch: Exception -> L44
    L14:
        r102 = r108;
    L54:
        r104.close();     // Catch: Exception -> L45
    L33:
        return r102;
    L15:
        e = e;
    L26:
        com.alipay.sdk.m.u.e.a(e);     // Catch: Throwable -> L34
        if (r103 != 0) goto L47;
    L31:
        if (r104 == null) goto L33;
    L47:
        r103.close();     // Catch: Exception -> L30
        goto L31
    L20:
        e = e;
        r104 = null;
    L17:
        th = th;
    L19:
        r101 = r103;
    L36:
        if (r101 != 0) goto L49;
    L40:
        if (r101 == 0) goto L65;
        r101.close();     // Catch: Exception -> L46
        throw th;
    L66:
        throw th;
    L65:
        throw th;
    L49:
        r101.close();     // Catch: Exception -> L39
        goto L40
    L24:
        e = e;
        r103 = 0;
        r104 = null;
    L22:
        th = th;
    L34:
        th = th;
    L43:
        return null;
    }

    public static String a(int r100) {
        return String.format(Locale.getDefault(), "%05d", new Object[]{Integer.valueOf(r100)});
    }

    public static int a(String r100) {
        return CastIntegerProtector.parseInt(r100);
    }

    public b a(d r100, String r101) {
        ByteArrayInputStream r102 = null;
        ByteArrayInputStream r103 = new ByteArrayInputStream(r100.a());     // Catch: Throwable -> L24 Exception -> L26
    L49:
        byte[] r104 = new byte[5];     // Catch: Exception -> L22 Throwable -> L39
        r103.read(r104);     // Catch: Exception -> L22 Throwable -> L39
        byte[] r105 = new byte[a(new String(r104))];     // Catch: Exception -> L22 Throwable -> L39
        r103.read(r105);     // Catch: Exception -> L22 Throwable -> L39
        String r106 = new String(r105);     // Catch: Exception -> L22 Throwable -> L39
        byte[] r107 = new byte[5];     // Catch: Exception -> L20 Throwable -> L39
        r103.read(r107);     // Catch: Exception -> L20 Throwable -> L39
        int r108 = a(new String(r107));     // Catch: Exception -> L20 Throwable -> L39
        if (r108 <= 0) goto L16;
        byte[] r109 = new byte[r108];     // Catch: Exception -> L20 Throwable -> L39
        r103.read(r109);     // Catch: Exception -> L20 Throwable -> L39
        if (this.f25651a == false) goto L12;
        r109 = a(this.f25652b, r109, r101);     // Catch: Exception -> L20 Throwable -> L39
    L12:
        if (r100.b() == false) goto L14;
        r109 = com.alipay.sdk.m.n.b.b(r109);     // Catch: Exception -> L20 Throwable -> L39
    L14:
        String r110 = new String(r109);     // Catch: Exception -> L20 Throwable -> L39
    L53:
        r103.close();     // Catch: Exception -> L19
    L34:
        if (r106 != null) goto L38;
        if (r110 != null) goto L38;
        return null;
    L38:
        return new b(r106, r110);
    L16:
        r110 = null;
    L20:
        e = e;
    L28:
        com.alipay.sdk.m.u.e.a(e);     // Catch: Throwable -> L39
        if (r103 != null) goto L47;
    L33:
        r110 = null;
        goto L34
    L47:
        r103.close();     // Catch: Exception -> L32
    L22:
        e = e;
        r106 = null;
    L39:
        th = th;
        r102 = r103;
    L41:
        if (r102 != null) goto L45;
    L43:
        throw th;
    L45:
        r102.close();     // Catch: Exception -> L44
    L26:
        e = e;
        r103 = null;
        r106 = null;
    L24:
        th = th;
        goto L41
    }

    public static byte[] a(String r100, String r101) {
        return com.alipay.sdk.m.n.d.a(r100, r101);
    }

    public static byte[] b(String r100, byte[] r101, String r102) {
        return com.alipay.sdk.m.n.e.b(r100, r101, r102);
    }

    public d a(b r100, boolean r101, String r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        byte[] r103 = r100.b().getBytes();
        byte[] r104 = r100.a().getBytes();
        if (r101 == false) goto L11;
        r104 = com.alipay.sdk.m.n.b.a(r104);     // Catch: Exception -> L9
    L9:
        r101 = false;
    L11:
        if (this.f25651a == false) goto L13;
        byte[] r105 = a(new byte[][]{r103, a(this.f25652b, com.alipay.sdk.m.l.a.f25458f), b(this.f25652b, r104, r102)});
    L15:
        return new d(r101, r105);
    L13:
        r105 = a(new byte[][]{r103, r104});
        goto L15
    }

    public static byte[] a(String r100, byte[] r101, String r102) {
        return com.alipay.sdk.m.n.e.a(r100, r101, r102);
    }
}

package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class s7 extends s5 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected Context f27959o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected w5 f27960p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected byte[] f27961q;

    public String f() {
        return "2.1";
    }

    public String g() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.f27960p.b(), this.f27960p.d()});
    }

    public abstract byte[] i();

    public abstract byte[] j();

    private static byte[] c() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(x5.e("PANDORA$"));     // Catch: Throwable -> L9
        r100.write(new byte[]{1});     // Catch: Throwable -> L9
        r100.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r101 = r100.toByteArray();     // Catch: Throwable -> L9
        r100.close();     // Catch: Throwable -> L6
    L8:
        return r101;
    L6:
        th = move-exception;
        p6.a(th, "bre", "gbh");
    L9:
        th = move-exception;
        p6.a(th, "bre", "gbh");     // Catch: Throwable -> L17
        r100.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        p6.a(th, "bre", "gbh");
        return null;
    L17:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        p6.a(th, "bre", "gbh");
        goto L22
    }

    private byte[] d() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = i();     // Catch: Throwable -> L20
        if (r101 != null) goto L6;
    L14:
        r100.write(new byte[]{0});     // Catch: Throwable -> L20
        byte[] r102 = r100.toByteArray();     // Catch: Throwable -> L20
        r100.close();     // Catch: Throwable -> L17
    L19:
        return r102;
    L17:
        th = move-exception;
        p6.a(th, "bre", "grrd");
        goto L19
    L6:
        if (r101.length == 0) goto L14;
        r100.write(new byte[]{1});     // Catch: Throwable -> L20
        r100.write(a(r101));     // Catch: Throwable -> L20
        r100.write(r101);     // Catch: Throwable -> L20
        byte[] r103 = r100.toByteArray();     // Catch: Throwable -> L20
        r100.close();     // Catch: Throwable -> L11
    L13:
        return r103;
    L11:
        th = move-exception;
        p6.a(th, "bre", "grrd");
    L20:
        th = move-exception;
        p6.a(th, "bre", "grrd");     // Catch: Throwable -> L28
        r100.close();     // Catch: Throwable -> L24
    L27:
        return new byte[]{0};
    L24:
        th = move-exception;
        p6.a(th, "bre", "grrd");
    L28:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        p6.a(th, "bre", "grrd");
        goto L33
    }

    private byte[] e() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = j();     // Catch: Throwable -> L20
        if (r101 != null) goto L6;
    L14:
        r100.write(new byte[]{0});     // Catch: Throwable -> L20
        byte[] r102 = r100.toByteArray();     // Catch: Throwable -> L20
        r100.close();     // Catch: Throwable -> L17
    L19:
        return r102;
    L17:
        th = move-exception;
        p6.a(th, "bre", "gred");
        goto L19
    L6:
        if (r101.length == 0) goto L14;
        r100.write(new byte[]{1});     // Catch: Throwable -> L20
        byte[] r103 = q5.d(r101);     // Catch: Throwable -> L20
        r100.write(a(r103));     // Catch: Throwable -> L20
        r100.write(r103);     // Catch: Throwable -> L20
        byte[] r104 = r100.toByteArray();     // Catch: Throwable -> L20
        r100.close();     // Catch: Throwable -> L11
    L13:
        return r104;
    L11:
        th = move-exception;
        p6.a(th, "bre", "gred");
    L20:
        th = move-exception;
        p6.a(th, "bre", "gred");     // Catch: Throwable -> L28
        r100.close();     // Catch: Throwable -> L24
    L27:
        return new byte[]{0};
    L24:
        th = move-exception;
        p6.a(th, "bre", "gred");
    L28:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        p6.a(th, "bre", "gred");
        goto L33
    }

    @Override // com.amap.api.mapcore.util.y7
    public final byte[] getEntityBytes() {
        byte[] r100 = this.f27961q;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        r101.write(c());     // Catch: Throwable -> L12
        r101.write(h());     // Catch: Throwable -> L12
        r101.write(d());     // Catch: Throwable -> L12
        r101.write(e());     // Catch: Throwable -> L12
        byte[] r102 = r101.toByteArray();     // Catch: Throwable -> L12
        this.f27961q = r102;     // Catch: Throwable -> L12
        r101.close();     // Catch: Throwable -> L9
    L11:
        return r102;
    L9:
        th = move-exception;
        p6.a(th, "bre", "geb");
    L12:
        th = move-exception;
        p6.a(th, "bre", "geb");     // Catch: Throwable -> L20
        r101.close();     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        p6.a(th, "bre", "geb");
        return null;
    L20:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        p6.a(th, "bre", "geb");
        goto L25
    }

    @Override // com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        String r100 = l5.e(this.f27959o);
        String r101 = n5.a();
        String r102 = n5.a(this.f27959o, r101, "key=".concat(String.valueOf(r100)));
        HashMap r103 = new HashMap();
        r103.put("ts", r101);
        r103.put("key", r100);
        r103.put("scode", r102);
        return r103;
    }

    public byte[] h() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(new byte[]{3});     // Catch: Throwable -> L28
        Context r101 = this.f27959o;     // Catch: Throwable -> L28
        w5 r102 = this.f27960p;     // Catch: Throwable -> L28
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        byte[] r104 = n5.a(r101, false, r103);     // Catch: Throwable -> L28
        r100.write(a(r104));     // Catch: Throwable -> L28
        r100.write(r104);     // Catch: Throwable -> L28
        byte[] r105 = x5.e(f());     // Catch: Throwable -> L28
        if (r105 != null) goto L13;
    L15:
        r100.write(new byte[]{0, 0});     // Catch: Throwable -> L28
    L16:
        byte[] r106 = x5.e(g());     // Catch: Throwable -> L28
        if (r106 != null) goto L19;
    L21:
        r100.write(new byte[]{0, 0});     // Catch: Throwable -> L28
    L22:
        byte[] r107 = r100.toByteArray();     // Catch: Throwable -> L28
        r100.close();     // Catch: Throwable -> L25
    L27:
        return r107;
    L25:
        th = move-exception;
        p6.a(th, "bre", "gred");
        goto L27
    L19:
        if (r106.length <= 0) goto L21;
        r100.write(a(r106));     // Catch: Throwable -> L28
        r100.write(r106);     // Catch: Throwable -> L28
        goto L22
    L13:
        if (r105.length <= 0) goto L15;
        r100.write(a(r105));     // Catch: Throwable -> L28
        r100.write(r105);     // Catch: Throwable -> L28
        goto L16
    L7:
        if ("navi".equals(r102.d()) == false) goto L9;
        r103 = true;
    L28:
        th = move-exception;
        p6.a(th, "bre", "gpd");     // Catch: Throwable -> L36
        r100.close();     // Catch: Throwable -> L32
    L35:
        return new byte[]{0};
    L32:
        th = move-exception;
        p6.a(th, "bre", "gred");
    L36:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L39
    L41:
        throw th;
    L39:
        th = move-exception;
        p6.a(th, "bre", "gred");
        goto L41
    }

    public byte[] a(byte[] r100) {
        return x5.a(r100.length, 2);
    }

    public s7(Context r100, w5 r101) {
        if (r100 == null) goto L5;
        this.f27959o = r100.getApplicationContext();
    L5:
        this.f27960p = r101;
        setBinary(true);
    }
}

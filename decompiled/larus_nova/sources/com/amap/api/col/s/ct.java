package com.amap.api.col.s;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class ct extends bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f26479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected br f26480b;

    public abstract byte[] d();

    public String i() {
        return "2.1";
    }

    public final String l() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.f26480b.d(), this.f26480b.b()});
    }

    private static byte[] a() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(bs.a("PANDORA$"));     // Catch: Throwable -> L9
        r100.write(new byte[]{1});     // Catch: Throwable -> L9
        r100.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r101 = r100.toByteArray();     // Catch: Throwable -> L9
        r100.close();     // Catch: Throwable -> L6
    L8:
        return r101;
    L6:
        th = move-exception;
        cd.a(th, "bre", "gbh");
    L9:
        th = move-exception;
        cd.a(th, "bre", "gbh");     // Catch: Throwable -> L17
        r100.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        cd.a(th, "bre", "gbh");
        return null;
    L17:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        cd.a(th, "bre", "gbh");
        goto L22
    }

    private byte[] p() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(new byte[]{3});     // Catch: Throwable -> L27
        Context r101 = this.f26479a;     // Catch: Throwable -> L27
        br r102 = this.f26480b;     // Catch: Throwable -> L27
        if (r102 != null) goto L6;
    L8:
        boolean r103 = false;
    L9:
        byte[] r104 = bl.a(r101, r103);     // Catch: Throwable -> L27
        r100.write(bs.a(r104.length));     // Catch: Throwable -> L27
        r100.write(r104);     // Catch: Throwable -> L27
        byte[] r105 = bs.a(i());     // Catch: Throwable -> L27
        if (r105 != null) goto L12;
    L14:
        r100.write(new byte[]{0, 0});     // Catch: Throwable -> L27
    L15:
        byte[] r106 = bs.a(l());     // Catch: Throwable -> L27
        if (r106 != null) goto L18;
    L20:
        r100.write(new byte[]{0, 0});     // Catch: Throwable -> L27
    L21:
        byte[] r107 = r100.toByteArray();     // Catch: Throwable -> L27
        r100.close();     // Catch: Throwable -> L24
    L26:
        return r107;
    L24:
        th = move-exception;
        cd.a(th, "bre", "gred");
        goto L26
    L18:
        if (r106.length <= 0) goto L20;
        r100.write(bs.a(r106.length));     // Catch: Throwable -> L27
        r100.write(r106);     // Catch: Throwable -> L27
        goto L21
    L12:
        if (r105.length <= 0) goto L14;
        r100.write(bs.a(r105.length));     // Catch: Throwable -> L27
        r100.write(r105);     // Catch: Throwable -> L27
        goto L15
    L6:
        if ("navi".equals(r102.b()) == false) goto L8;
        r103 = true;
    L27:
        th = move-exception;
        cd.a(th, "bre", "gpd");     // Catch: Throwable -> L35
        r100.close();     // Catch: Throwable -> L31
    L34:
        return new byte[]{0};
    L31:
        th = move-exception;
        cd.a(th, "bre", "gred");
    L35:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L38
    L40:
        throw th;
    L38:
        th = move-exception;
        cd.a(th, "bre", "gred");
        goto L40
    }

    private static byte[] q() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(new byte[]{0});     // Catch: Throwable -> L9
        byte[] r101 = r100.toByteArray();     // Catch: Throwable -> L9
        r100.close();     // Catch: Throwable -> L6
    L8:
        return r101;
    L6:
        th = move-exception;
        cd.a(th, "bre", "grrd");
    L9:
        th = move-exception;
        cd.a(th, "bre", "grrd");     // Catch: Throwable -> L17
        r100.close();     // Catch: Throwable -> L13
    L16:
        return new byte[]{0};
    L13:
        th = move-exception;
        cd.a(th, "bre", "grrd");
    L17:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        cd.a(th, "bre", "grrd");
        goto L22
    }

    private byte[] r() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        byte[] r101 = d();     // Catch: Throwable -> L20
        if (r101 != null) goto L6;
    L14:
        r100.write(new byte[]{0});     // Catch: Throwable -> L20
        byte[] r102 = r100.toByteArray();     // Catch: Throwable -> L20
        r100.close();     // Catch: Throwable -> L17
    L19:
        return r102;
    L17:
        th = move-exception;
        cd.a(th, "bre", "gred");
        goto L19
    L6:
        if (r101.length == 0) goto L14;
        r100.write(new byte[]{1});     // Catch: Throwable -> L20
        byte[] r103 = bn.a(r101);     // Catch: Throwable -> L20
        r100.write(bs.a(r103.length));     // Catch: Throwable -> L20
        r100.write(r103);     // Catch: Throwable -> L20
        byte[] r104 = r100.toByteArray();     // Catch: Throwable -> L20
        r100.close();     // Catch: Throwable -> L11
    L13:
        return r104;
    L11:
        th = move-exception;
        cd.a(th, "bre", "gred");
    L20:
        th = move-exception;
        cd.a(th, "bre", "gred");     // Catch: Throwable -> L28
        r100.close();     // Catch: Throwable -> L24
    L27:
        return new byte[]{0};
    L24:
        th = move-exception;
        cd.a(th, "bre", "gred");
    L28:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L31
    L33:
        throw th;
    L31:
        th = move-exception;
        cd.a(th, "bre", "gred");
        goto L33
    }

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> e() {
        String r100 = bi.f(this.f26479a);
        String r101 = bl.a();
        String r102 = bl.a(this.f26479a, r101, "key=".concat(String.valueOf(r100)));
        HashMap r103 = new HashMap();
        r103.put("ts", r101);
        r103.put("key", r100);
        r103.put("scode", r102);
        return r103;
    }

    @Override // com.amap.api.col.s.cy
    public final byte[] g() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        r100.write(a());     // Catch: Throwable -> L9
        r100.write(p());     // Catch: Throwable -> L9
        r100.write(q());     // Catch: Throwable -> L9
        r100.write(r());     // Catch: Throwable -> L9
        byte[] r101 = r100.toByteArray();     // Catch: Throwable -> L9
        r100.close();     // Catch: Throwable -> L6
    L8:
        return r101;
    L6:
        th = move-exception;
        cd.a(th, "bre", "geb");
    L9:
        th = move-exception;
        cd.a(th, "bre", "geb");     // Catch: Throwable -> L17
        r100.close();     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        cd.a(th, "bre", "geb");
        return null;
    L17:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        cd.a(th, "bre", "geb");
        goto L22
    }

    public ct(Context r100, br r101) {
        if (r100 == null) goto L5;
        this.f26479a = r100.getApplicationContext();
    L5:
        this.f26480b = r101;
    }
}

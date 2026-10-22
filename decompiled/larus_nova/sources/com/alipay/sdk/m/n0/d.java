package com.alipay.sdk.m.n0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes28.dex */
public class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f25625i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static d f25626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25627k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f25630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.alipay.sdk.m.m0.a f25633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.alipay.sdk.m.m0.a f25634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Pattern f25635h;

    public synchronized String a() {
        monitor-enter(this);
        String r100 = c();     // Catch: Throwable -> L21
        this.f25629b = r100;     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r100) == true) goto L24;
        String r101 = this.f25629b;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r101;
    L24:
        byte[] r102 = e();     // Catch: Exception -> L16 Throwable -> L21
        if (r102 == null) goto L18;
        String r103 = com.alipay.sdk.m.l0.b.c(r102, 2);     // Catch: Exception -> L16 Throwable -> L21
        this.f25629b = r103;     // Catch: Exception -> L16 Throwable -> L21
        b(r103);     // Catch: Exception -> L16 Throwable -> L21
        String r104 = this.f25630c.a(r102);     // Catch: Exception -> L16 Throwable -> L21
        if (r104 == null) goto L13;
        c(r104);     // Catch: Exception -> L16 Throwable -> L21
    L13:
        String r105 = this.f25629b;     // Catch: Exception -> L16 Throwable -> L21
        monitor-exit(this);
        return r105;
    L18:
        monitor-exit(this);
        return null;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public synchronized String b() {
        monitor-enter(this);
        String r100 = this.f25629b;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        monitor-exit(this);
        return r100;
    L7:
        String r101 = a();     // Catch: Throwable -> L10
        monitor-exit(this);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized String c() {
        monitor-enter(this);
        String r100 = f();     // Catch: Throwable -> L23
        if (a(r100) == false) goto L8;
        c(this.f25630c.a(r100));     // Catch: Throwable -> L23
        this.f25629b = r100;     // Catch: Throwable -> L23
        monitor-exit(this);
        return r100;
    L8:
        String r101 = this.f25633f.a(this.f25631d);     // Catch: Throwable -> L23
        if (com.alipay.sdk.m.l0.f.m8017a(r101) == true) goto L20;
        String r102 = new f().a(r101);     // Catch: Throwable -> L23
        if (a(r102) == true) goto L14;
        r102 = this.f25630c.b(r101);     // Catch: Throwable -> L23
    L14:
        if (a(r102) == false) goto L20;
        if (com.alipay.sdk.m.l0.f.m8017a(r102) == true) goto L20;
        this.f25629b = r102;     // Catch: Throwable -> L23
        b(r102);     // Catch: Throwable -> L23
        String r103 = this.f25629b;     // Catch: Throwable -> L23
        monitor-exit(this);
        return r103;
    L20:
        monitor-exit(this);
        return null;
    L23:
        th = move-exception;
        throw th;
    }

    static {
        f25625i = new Object();
        f25627k = ".UTSystemConfig" + File.separator + "Global";
    }

    private void d() {
        com.alipay.sdk.m.m0.a r100 = this.f25634g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (com.alipay.sdk.m.l0.f.m8017a(r100.a("UTDID2")) == false) goto L9;
        String r101 = this.f25634g.a("UTDID");
        if (com.alipay.sdk.m.l0.f.m8017a(r101) == true) goto L9;
        b(r101);
    L9:
        boolean r102 = true;
        if (com.alipay.sdk.m.l0.f.m8017a(this.f25634g.a("DID")) == true) goto L12;
        this.f25634g.b("DID");
        boolean r103 = true;
    L14:
        if (com.alipay.sdk.m.l0.f.m8017a(this.f25634g.a("EI")) == true) goto L17;
        this.f25634g.b("EI");
        r103 = true;
    L17:
        if (com.alipay.sdk.m.l0.f.m8017a(this.f25634g.a("SI")) == true) goto L19;
        this.f25634g.b("SI");
    L20:
        if (r102 == false) goto L24;
        this.f25634g.a();
        return;
    L24:
        return;
    L19:
        r102 = r103;
        goto L20
    L12:
        r103 = false;
        goto L14
    }

    private byte[] e() throws Exception {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        int r101 = (int) (System.currentTimeMillis() / 1000);
        int r102 = new Random().nextInt();
        byte[] r103 = com.alipay.sdk.m.l0.c.a(r101);
        byte[] r104 = com.alipay.sdk.m.l0.c.a(r102);
        r100.write(r103, 0, 4);
        r100.write(r104, 0, 4);
        r100.write(3);
        r100.write(0);
        String r105 = com.alipay.sdk.m.l0.d.a(this.f25628a);     // Catch: Exception -> L5
    L6:
        r100.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(r105)), 0, 4);
        r100.write(com.alipay.sdk.m.l0.c.a(com.alipay.sdk.m.l0.f.a(a(r100.toByteArray()))));
        return r100.toByteArray();
    L5:
        r105 = "" + new Random().nextInt();
        goto L6
    }

    private String f() {
        com.alipay.sdk.m.m0.a r100 = this.f25634g;
        if (r100 == null) goto L9;
        String r101 = r100.a("UTDID2");
        if (com.alipay.sdk.m.l0.f.m8017a(r101) == false) goto L7;
        return null;
    L7:
        if (this.f25630c.a(r101) == null) goto L12;
        return r101;
    L12:
        return null;
    L9:
        return null;
    }

    public d(Context r110) {
        this.f25628a = null;
        this.f25629b = null;
        this.f25630c = null;
        this.f25631d = "xx_utdid_key";
        this.f25632e = "xx_utdid_domain";
        this.f25633f = null;
        this.f25634g = null;
        this.f25635h = PatternProtector.compile("[^0-9a-zA-Z=/+]+");
        this.f25628a = r110;
        this.f25634g = new com.alipay.sdk.m.m0.a(r110, f25627k, "Alvin2", false, true);
        this.f25633f = new com.alipay.sdk.m.m0.a(r110, ".DataStorage", "ContextData", false, true);
        this.f25630c = new e();
        this.f25631d = String.format("K_%d", new Object[]{Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.f25631d))});
        this.f25632e = String.format("D_%d", new Object[]{Integer.valueOf(com.alipay.sdk.m.l0.f.a(this.f25632e))});
    }

    public static String a(byte[] r100) throws Exception {
        byte[] r101 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, PSSSigner.TRAILER_IMPLICIT, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93};
        Mac r102 = Mac.getInstance("HmacSHA1");
        r102.init(new SecretKeySpec(com.alipay.sdk.m.l0.e.a(r101), r102.getAlgorithm()));
        return com.alipay.sdk.m.l0.b.c(r102.doFinal(r100), 2);
    }

    private void b(String r100) {
        if (a(r100) == true) goto L5;
        return;
    L5:
        if (r100.endsWith("\n") == false) goto L8;
        r100 = r100.substring(0, r100.length() - 1);
    L8:
        if (r100.length() != 24) goto L14;
        com.alipay.sdk.m.m0.a r101 = this.f25634g;
        if (r101 == null) goto L15;
        r101.a("UTDID2", r100);
        this.f25634g.a();
        return;
    L15:
        return;
    }

    private void c(String r100) {
        if (r100 == null) goto L9;
        com.alipay.sdk.m.m0.a r101 = this.f25633f;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.equals(r101.a(this.f25631d)) == true) goto L11;
        this.f25633f.a(this.f25631d, r100);
        this.f25633f.a();
        return;
    L11:
        return;
    }

    private boolean a(String r100) {
        if (r100 != null) goto L5;
    L12:
        return false;
    L5:
        if (r100.endsWith("\n") == false) goto L8;
        r100 = r100.substring(0, r100.length() - 1);
    L8:
        if (24 != r100.length()) goto L12;
        if (this.f25635h.matcher(r100).find() == true) goto L12;
        return true;
    }

    public static d a(Context r100) {
        if (r100 == null) goto L16;
        if (f25626j != null) goto L16;
        Object r101 = f25625i;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (f25626j != null) goto L10;
        d r102 = new d(r100);     // Catch: Throwable -> L12
        f25626j = r102;     // Catch: Throwable -> L12
        r102.d();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
    L16:
        return f25626j;
    }
}

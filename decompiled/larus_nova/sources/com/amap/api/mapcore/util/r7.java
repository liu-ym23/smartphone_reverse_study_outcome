package com.amap.api.mapcore.util;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes28.dex */
public class r7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f27936a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f27937b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static r7 f27938c;

    public interface a {
        URLConnection a(Proxy r100, URL r101);
    }

    public static r7 a() {
        if (f27938c != null) goto L6;
        f27938c = new r7();
    L6:
        return f27938c;
    }

    public r7() {
        m5.g();
    }

    public z7 a(y7 r100) throws k5 {
        boolean r101 = r100.isHttps();
        d(r100);
        if (r101 == false) goto L5;
        y7.c r102 = y7.c.f28468b;
    L6:
        r100.setHttpProtocol(r102);
        z7 r103 = null;
        long r104 = 0;
        if (c(r100) == false) goto L21;
        boolean r105 = b(r100);
        r104 = SystemClock.elapsedRealtime();     // Catch: k5 -> L11
        r103 = a(r100, b(r100, r105), c(r100, r105));     // Catch: k5 -> L11
    L11:
        e = move-exception;
        if (e.c() == 21) goto L15;
    L18:
        if (r105 == false) goto L20;
        boolean r106 = true;
    L22:
        if (r103 == null) goto L33;
        byte[] r107 = r103.f28591a;
        if (r107 == null) goto L33;
        if (r107.length <= 0) goto L33;
        return r103;
    L33:
        return a(r100, a(r100, r106), a(r100, r104));
    L29:
        e = move-exception;
        throw e;
    L20:
        throw e;
    L15:
        if (r100.getDegradeAbility() != y7.a.f28453b) goto L18;
        throw e;
    L21:
        r106 = false;
        goto L22
    L5:
        r102 = y7.c.f28467a;
        goto L6
    }

    public boolean b(y7 r100) throws k5 {
        d(r100);
        if (c(r100) == true) goto L6;
        return true;
    L6:
        String r101 = r100.getIPV6URL();     // Catch: Throwable -> L16
        if (r100.getURL().equals(r101) == false) goto L10;
        return false;
    L10:
        if (r100.getDegradeAbility() != y7.a.f28456e) goto L12;
        return false;
    L12:
        if (m5.f27580s == true) goto L15;
        return false;
    L15:
        return true;
    }

    public boolean c(y7 r100) throws k5 {
        d(r100);
        String r101 = r100.getIPV6URL();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        String r102 = new URL(r101).getHost();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r100.getIPDNSName()) == true) goto L10;
        r102 = r100.getIPDNSName();     // Catch: Throwable -> L12
    L10:
        return m5.g(r102);
    L12:
        return true;
    }

    public void d(y7 r100) throws k5 {
        if (r100 == null) goto L11;
        if (r100.getURL() == null) goto L9;
        if ("".equals(r100.getURL()) == true) goto L9;
        return;
    L9:
        throw new k5("request url is empty");
    L11:
        throw new k5("requeust is null");
    }

    public int a(y7 r100, long r101) {
        d(r100);     // Catch: Throwable -> L21
        long r102 = 0;
        if (r101 == 0) goto L6;
        r102 = SystemClock.elapsedRealtime() - r101;     // Catch: Throwable -> L21
    L6:
        int r103 = r100.getConntectionTimeout();     // Catch: Throwable -> L21
        if (r100.getDegradeAbility() != y7.a.f28455d) goto L9;
    L20:
        return r103;
    L9:
        if (r100.getDegradeAbility() == y7.a.f28456e) goto L20;
        long r104 = r103;
        if (r102 >= r104) goto L19;
        long r105 = r104 - r102;     // Catch: Throwable -> L21
        if (r105 < 1000) goto L19;
        return (int) r105;
    L19:
        return Math.min(1000, r100.getConntectionTimeout());
    L21:
        return 5000;
    }

    public y7.b b(y7 r100, boolean r101) {
        if (r100.getDegradeAbility() != y7.a.f28455d) goto L7;
        return y7.b.f28462f;
    L7:
        if (r100.getDegradeAbility() == y7.a.f28456e) goto L9;
        if (r101 == false) goto L14;
        return y7.b.f28458b;
    L14:
        return y7.b.f28459c;
    L9:
        return y7.b.f28459c;
    }

    public int c(y7 r100, boolean r101) {
        d(r100);     // Catch: Throwable -> L12
        int r102 = r100.getConntectionTimeout();     // Catch: Throwable -> L12
        int r103 = m5.f27576o;     // Catch: Throwable -> L12
        if (r100.getDegradeAbility() == y7.a.f28455d) goto L11;
        if (r100.getDegradeAbility() == y7.a.f28456e) goto L11;
        if (r102 >= r103) goto L9;
        return r102;
    L9:
        if (r101 == false) goto L11;
        return r103;
    L11:
        return r102;
    L12:
        return 5000;
    }

    public y7.b a(y7 r100, boolean r101) {
        if (r100.getDegradeAbility() != y7.a.f28455d) goto L9;
        if (r101 == false) goto L8;
        return y7.b.f28463g;
    L8:
        return y7.b.f28464h;
    L9:
        if (r101 == false) goto L13;
        return y7.b.f28460d;
    L13:
        return y7.b.f28461e;
    }

    private z7 a(y7 r100, y7.b r101, int r102) throws k5 {
        d(r100);     // Catch: Throwable -> L4 k5 -> L7
        r100.setDegradeType(r101);     // Catch: Throwable -> L4 k5 -> L7
        r100.setReal_max_timeout(r102);     // Catch: Throwable -> L4 k5 -> L7
        return new v7().c(r100);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new k5("未知的错误");
    }
}

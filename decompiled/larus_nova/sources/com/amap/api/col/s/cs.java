package com.amap.api.col.s;

import android.text.TextUtils;
import java.net.URLConnection;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f26476a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f26477b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static cs f26478c;

    public interface a {
        URLConnection a();
    }

    public cs() {
    }

    public static cs a() {
        if (f26478c != null) goto L6;
        f26478c = new cs();
    L6:
        return f26478c;
    }

    public static byte[] a(cy r100) throws bh {
        cz r101 = a(r100, true);     // Catch: Throwable -> L9 bh -> L11
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.f26524a;
    L11:
        e = move-exception;
        throw e;
    L10:
        throw new bh("未知的错误");
    }

    public static void c(cy r100) throws bh {
        if (r100 == null) goto L11;
        if (r100.h() == null) goto L9;
        if ("".equals(r100.h()) == true) goto L9;
        return;
    L9:
        throw new bh("request url is empty");
    L11:
        throw new bh("requeust is null");
    }

    public byte[] b(cy r100) throws bh {
        cz r101 = a(r100, false);     // Catch: Throwable -> L9 bh -> L12
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.f26524a;
    L12:
        e = move-exception;
        throw e;
    L9:
        th = move-exception;
        cd.a(th, "bm", com.alipay.sdk.m.o.a.f25636a);
        throw new bh("未知的错误");
    }

    public static cz a(cy r100, boolean r101) throws bh {
        int r102 = cv.a(r100);
        cz r103 = a(r100, r101, r102);     // Catch: bh -> L5
    L9:
        if (r103 == null) goto L15;
        byte[] r104 = r103.f26524a;
        if (r104 == null) goto L15;
        if (r104.length <= 0) goto L15;
    L21:
        return r103;
    L15:
        if (cv.a(r102) == false) goto L21;
        return a(r100, r101, 3);
    L19:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (cv.a(r102) == false) goto L22;
        r103 = null;
        goto L9
    L22:
        throw e;
    }

    private static cz a(cy r100, boolean r101, int r110) throws bh {
        c(r100);     // Catch: Throwable -> L12 bh -> L15
        cv r102 = new cv(r100, r101);     // Catch: Throwable -> L12 bh -> L15
        String r103 = r100.m();     // Catch: Throwable -> L12 bh -> L15
        String r104 = r100.n();     // Catch: Throwable -> L12 bh -> L15
        boolean r105 = r100.o();     // Catch: Throwable -> L12 bh -> L15
        String r106 = r100.j();     // Catch: Throwable -> L12 bh -> L15
        Map<String, String> r107 = r100.f();     // Catch: Throwable -> L12 bh -> L15
        byte[] r108 = r100.g();     // Catch: Throwable -> L12 bh -> L15
        if (r108 != null) goto L5;
    L6:
        String r109 = cv.a(r100.e());     // Catch: Throwable -> L12 bh -> L15
        if (TextUtils.isEmpty(r109) == true) goto L9;
        byte[] r111 = bs.a(r109);     // Catch: Throwable -> L12 bh -> L15
    L10:
        return r102.a(r103, r104, r105, r106, r107, r111, r110);
    L9:
        r111 = r108;
        goto L10
    L5:
        if (r108.length != 0) goto L9;
    L15:
        e = move-exception;
        throw e;
    L12:
        th = move-exception;
        th.printStackTrace();
        throw new bh("未知的错误");
    }
}

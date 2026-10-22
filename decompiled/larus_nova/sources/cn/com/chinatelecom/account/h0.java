package cn.com.chinatelecom.account;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Charset f24399a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f24400b;

    static {
        f24399a = Charset.forName("UTF-8");
        f24400b = new byte[]{68, 64, 94, 49, 50, 83};
    }

    public static String a(byte[] r100) {
        int r101 = r100.length;     // Catch: Throwable -> L10
        byte[] r102 = new byte[r101];     // Catch: Throwable -> L10
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L8;
        r102[r103] = r100[r103];     // Catch: Throwable -> L10
        byte[] r104 = f24400b;     // Catch: Throwable -> L10
        int r105 = r104.length;     // Catch: Throwable -> L10
        int r106 = 0;
    L5:
        if (r106 >= r105) goto L7;
        r102[r103] = (byte) (r104[r106] ^ r102[r103]);     // Catch: Throwable -> L10
        r106 = r106 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        r103 = r103 + 1;     // Catch: Throwable -> L10
        goto L3
    L8:
        return new String(r102);
    L10:
        th = move-exception;
        th.printStackTrace();
        return "";
    }
}

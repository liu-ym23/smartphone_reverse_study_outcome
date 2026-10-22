package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public class j5 {
    private static byte[] a(String r100) {
        String[] r101 = new StringBuffer(r100).reverse().toString().split(",");     // Catch: Throwable -> L12
        int r102 = r101.length;     // Catch: Throwable -> L12
        byte[] r103 = new byte[r102];     // Catch: Throwable -> L12
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r102) goto L6;
        r103[r105] = Byte.parseByte(r101[r105]);     // Catch: Throwable -> L12
        r105 = r105 + 1;     // Catch: Throwable -> L12
        goto L4
    L6:
        String[] r106 = new StringBuffer(new String(h6.a(new String(r103)), "UTF-8")).reverse().toString().split(",");     // Catch: Throwable -> L12
        byte[] r107 = new byte[r106.length];     // Catch: Throwable -> L12
    L7:
        if (r104 >= r106.length) goto L11;
        r107[r104] = Byte.parseByte(r106[r104]);     // Catch: Throwable -> L12
        r104 = r104 + 1;
        goto L7
    L11:
        return r107;
    L12:
        th = move-exception;
        t6.a(th, "AMU", "rcs");
        return null;
    }

    public static byte[] b(byte[] r100) {
        byte[] r101 = null;
        byte[] r102 = a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");     // Catch: Throwable -> L5
    L18:
        r101 = a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");     // Catch: Throwable -> L10
    L12:
        return q5.c(r102, r100, r101);
    L10:
        th = move-exception;
        t6.a(th, "AMU", "giv");     // Catch: Throwable -> L14
        goto L12
    L5:
        th = move-exception;
        t6.a(th, "AMU", "grk");     // Catch: Throwable -> L14
        r102 = null;
    L15:
        return new byte[0];
    }

    public static byte[] a(byte[] r100) {
        byte[] r101 = null;
        byte[] r102 = a("16,99,86,77,511,98,86,97,511,99,86,77,511,18,48,97,511,99,86,77,511,58,601,77,511,58,48,77,511,58,86,87,511,18,48,97,511,58,86,87,511,18,48,97,511,98,48,87,511,98,48,97,511,99,86,77,511,58,221,77,511,98,601,87");     // Catch: Throwable -> L5
    L16:
        r101 = a("16,18,86,97,511,18,48,97,511,18,86,97,511,58,86,77,511,18,86,97,511,58,48,77,511,18,86,97,511,58,601,77,511,18,86,97,511,58,221,77,511,18,86,97,511,58,86,87,511,18,86,97,511,58,48,87,511,18,86,97,511,58,601,87");     // Catch: Throwable -> L10
    L12:
        return q5.b(r102, r100, r101);
    L10:
        th = move-exception;
        t6.a(th, "AMU", "giv");     // Catch: Exception -> L14
        goto L12
    L5:
        th = move-exception;
        t6.a(th, "AMU", "grk");     // Catch: Exception -> L14
        r102 = null;
    L15:
        return new byte[0];
    }
}

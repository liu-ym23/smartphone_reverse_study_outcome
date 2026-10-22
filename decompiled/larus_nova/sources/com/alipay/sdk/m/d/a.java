package com.alipay.sdk.m.d;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25267a = "OpenId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f25268b;

    public a() {
    }

    public static void a(boolean r100) {
        f25268b = r100;
    }

    public static String a(String r100, Object... r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return "";
    L6:
        StringBuilder r102 = new StringBuilder();
        Object[] r103 = new Object[1];
        if (r100 != null) goto L9;
        r100 = "-";
    L9:
        int r104 = 0;
        r103[0] = r100;
        r102.append(String.format("[%s] ", r103));
        if (r101 == null) goto L22;
        int r105 = r101.length;
    L12:
        int r106 = r104 + 1;
        if (r106 >= r101.length) goto L19;
        r102.append(a(r101[r104], r101[r106]));
        if (r106 >= (r105 - 1)) goto L17;
        r102.append(",");
    L17:
        r104 = r106 + 1;
        goto L12
    L19:
        if (r104 != (r101.length - 1)) goto L22;
        r102.append(r101[r104]);
    L22:
        return r102.toString();
    }

    public static void b(String r100, Object... r101) {
        if (f25268b == false) goto L6;
        a(r100, r101);
        return;
    }

    public static void c(String r100, Object... r101) {
        if (f25268b == false) goto L6;
        a(r100, r101);
        return;
    }

    public static void d(String r100, Object... r101) {
        if (f25268b == false) goto L6;
        a(r100, r101);
        return;
    }

    public static void e(String r100, Object... r101) {
        if (f25268b == false) goto L6;
        a(r100, r101);
        return;
    }

    public static String a(Object r100, Object r101) {
        Object[] r102 = new Object[2];
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102[0] = r100;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r102[1] = r101;
        return String.format("%s:%s", r102);
    }
}

package b27;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f17068b;

    public static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L43;
        return "unknown message";
    L43:
        String[] r101 = r100.split(":");     // Catch: Throwable -> L40
        if (r101.length != 2) goto L10;
        String r102 = r101[1];     // Catch: Throwable -> L40
    L12:
        if (r100.contains("{") == true) goto L14;
    L17:
        String r103 = r100;
    L19:
        if (r100.contains("@") == false) goto L24;
        String[] r104 = r100.split("@");     // Catch: Throwable -> L38
        if (r104.length <= 1) goto L24;
        r100 = r104[0];     // Catch: Throwable -> L38
    L24:
        if (r100.contains("(") == false) goto L34;
        if (r100.contains(")") == false) goto L34;
        if (r100.endsWith(" null") == true) goto L34;
        String[] r105 = r100.split("\\(");     // Catch: Throwable -> L38
        if (r105.length <= 1) goto L32;
        r100 = r105[1];     // Catch: Throwable -> L38
    L32:
        r100 = r100.replace(")", "");     // Catch: Throwable -> L38
    L34:
        if (r100.startsWith(" ") == false) goto L36;
        r100 = r100.replace(" ", "");     // Catch: Throwable -> L38
    L36:
        return r100 + r102;
    L39:
        return r103;
    L14:
        if (r100.contains(com.alipay.sdk.m.u.i.f25855d) == false) goto L17;
        r103 = r100.split("\\{")[0];     // Catch: Throwable -> L40
        r100 = r103 + r100.split("\\}")[1];     // Catch: Throwable -> L38
        goto L19
    L10:
        r102 = "";
    L45:
        return r100;
    }

    public static String b(StackTraceElement[] r100) {
        if (r100 != null) goto L5;
        return "Invalid Stack\n";
    L5:
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= r102) goto L12;
        StackTraceElement r105 = r100[r103];
        r104 = r104 + 1;
        r101.append("\tat " + r105.getClassName());
        r101.append(".");
        r101.append(r105.getMethodName());
        r101.append("(");
        r101.append(r105.getFileName());
        r101.append(":");
        r101.append(r105.getLineNumber());
        r101.append(")\n");
        if (r104 > 40) goto L12;
        r103 = r103 + 1;
    L12:
        return r101.toString();
    }
}

package com.baidu.mshield.b.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes39.dex */
public class f {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f32362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f32363c;

        public String toString() {
            return "CommandResult{result=" + this.f32361a + ", successMsg='" + this.f32362b + "', errorMsg='" + this.f32363c + "'}";
        }

        public a(int r100, String r101, String r102) {
            this.f32361a = r100;
            this.f32362b = r101;
            this.f32363c = r102;
        }
    }

    public static a a(String r100, boolean r101) {
        return a(new String[]{r100}, r101, true);
    }

    private static Process com_baidu_mshield_b_a_f_java_lang_Runtime_exec(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static a a(String[] r100, boolean r110, boolean r111) {
        DataOutputStream r101 = null;
        String r102 = null;
        String r103 = null;
        BufferedReader r104 = null;
        r101 = null;
        r101 = null;
        int r105 = -1;
        if (r100 == null) goto L122;
        if (r100.length == 0) goto L122;
        Runtime r106 = Runtime.getRuntime();     // Catch: Throwable -> L72 IOException -> L88
        if (r110 == 0) goto L10;
        String r112 = "su";
    L11:
        r110 = com_baidu_mshield_b_a_f_java_lang_Runtime_exec(r106, r112);     // Catch: Throwable -> L72 IOException -> L88
        DataOutputStream r107 = new DataOutputStream(r110.getOutputStream());     // Catch: Throwable -> L68 IOException -> L70
    L142:
        int r108 = r100.length;     // Catch: Throwable -> L62 IOException -> L65
        int r109 = 0;
    L14:
        if (r109 >= r108) goto L20;
        String r113 = r100[r109];     // Catch: Throwable -> L62 IOException -> L65
        if (r113 == null) goto L19;
        r107.write(r113.getBytes());     // Catch: Throwable -> L62 IOException -> L65
        r107.writeBytes("\n");     // Catch: Throwable -> L62 IOException -> L65
        r107.flush();     // Catch: Throwable -> L62 IOException -> L65
    L19:
        r109 = r109 + 1;     // Catch: Throwable -> L62 IOException -> L65
        goto L14
    L20:
        r107.writeBytes("exit\n");     // Catch: Throwable -> L62 IOException -> L65
        r107.flush();     // Catch: Throwable -> L62 IOException -> L65
        r105 = r110.waitFor();     // Catch: Throwable -> L62 IOException -> L65
        if (r111 == false) goto L53;
        StringBuilder r114 = new StringBuilder();     // Catch: Throwable -> L62 IOException -> L65
        StringBuilder r115 = new StringBuilder();     // Catch: Throwable -> L62 IOException -> L65
        BufferedReader r116 = new BufferedReader(new InputStreamReader(r110.getInputStream()));     // Catch: Throwable -> L62 IOException -> L65
    L144:
        BufferedReader r117 = new BufferedReader(new InputStreamReader(r110.getErrorStream()));     // Catch: Throwable -> L49 IOException -> L51
    L134:
        String r118 = r116.readLine();     // Catch: Throwable -> L43 IOException -> L46
        if (r118 == null) goto L28;
        r114.append(r118);     // Catch: Throwable -> L43 IOException -> L46
        r114.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: Throwable -> L43 IOException -> L46
        goto L134
    L28:
        String r119 = r114.toString();     // Catch: Throwable -> L43 IOException -> L46
    L140:
    L41:
        e = move-exception;
        r102 = r119;
        e = e;
        Object r120 = null;
    L48:
        ?? r121 = r120;
        String r122 = r102;
        r101 = r107;
        int r123 = r105;
        r110 = r110;
    L91:
        com.baidu.mshield.b.c.a.a(e);     // Catch: Throwable -> L107
        if (r101 != null) goto L130;
    L96:
        if (r116 == null) goto L98;
        r116.close();     // Catch: IOException -> L94
    L98:
        if (r117 == null) goto L102;
        r117.close();     // Catch: IOException -> L94
    L94:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
    L102:
        if (r110 == 0) goto L106;
    L103:
        r119 = r122;
        ?? r124 = r121;
        r105 = r123;
    L104:
        r110.destroy();
        r123 = r105;
        r121 = r124;
        r122 = r119;
    L106:
        return new a(r123, r122, r121);
    L130:
        r101.close();     // Catch: IOException -> L94
    L39:
        th = move-exception;
        r103 = r119;
        th = th;
        Object r125 = null;
    L45:
        r121 = r125;
        r122 = r103;
        r101 = r107;
        r123 = r105;
        r110 = r110;
    L75:
        com.baidu.mshield.b.c.a.a(th);     // Catch: Throwable -> L107
        if (r101 != null) goto L132;
    L80:
        if (r116 == null) goto L82;
        r116.close();     // Catch: IOException -> L78
    L82:
        if (r117 == null) goto L86;
        r117.close();     // Catch: IOException -> L78
    L78:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
    L86:
        if (r110 == 0) goto L106;
    L132:
        r101.close();     // Catch: IOException -> L78
        goto L80
    L30:
        if (r119.length() <= 0) goto L32;
        r119 = r119.substring(0, r119.length() - 1);     // Catch: Throwable -> L39 IOException -> L41
    L32:
        String r126 = r117.readLine();     // Catch: Throwable -> L39 IOException -> L41
        if (r126 == null) goto L35;
        r115.append(r126);     // Catch: Throwable -> L39 IOException -> L41
        r115.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);     // Catch: Throwable -> L39 IOException -> L41
        goto L32
    L35:
        String r127 = r115.toString();     // Catch: Throwable -> L39 IOException -> L41
        if (r127.length() <= 0) goto L38;
        r127 = r127.substring(0, r127.length() - 1);     // Catch: Throwable -> L39 IOException -> L41
    L38:
        r124 = r127;
        r104 = r116;
    L126:
        r107.close();     // Catch: IOException -> L60
        if (r104 == null) goto L57;
        r104.close();     // Catch: IOException -> L60
    L57:
        if (r117 == null) goto L104;
        r117.close();     // Catch: IOException -> L60
    L60:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
    L46:
        e = e;
        r120 = null;
    L43:
        th = th;
        r125 = null;
        goto L45
    L51:
        e = e;
        r122 = null;
        r117 = null;
    L67:
        r101 = r107;
        r123 = r105;
        r121 = r117;
        r110 = r110;
    L49:
        th = th;
        r122 = null;
        r117 = null;
    L64:
        r101 = r107;
        r123 = r105;
        r121 = r117;
        r110 = r110;
        goto L75
    L53:
        r119 = null;
        r124 = 0;
        r117 = null;
    L65:
        e = e;
        r122 = null;
        r116 = null;
        r117 = null;
    L62:
        th = th;
        r122 = null;
        r116 = null;
        r117 = null;
    L70:
        e = e;
    L90:
        r122 = null;
        r121 = 0;
        r116 = null;
        r117 = null;
        r123 = -1;
        r110 = r110;
    L68:
        th = th;
    L74:
        r122 = null;
        r121 = 0;
        r116 = null;
        r117 = null;
        r123 = -1;
        r110 = r110;
        goto L75
    L10:
        r112 = "sh";
    L88:
        e = e;
        r110 = 0;
    L72:
        th = th;
        r110 = 0;
    L107:
        th = move-exception;
        if (r101 != null) goto L128;
    L112:
        if (r116 == null) goto L114;
        r116.close();     // Catch: IOException -> L110
    L114:
        if (r117 == null) goto L118;
        r117.close();     // Catch: IOException -> L110
    L110:
        e = move-exception;
        com.baidu.mshield.b.c.a.a(e);
    L118:
        if (r110 == 0) goto L152;
        r110.destroy();
        throw th;
    L152:
        throw th;
    L128:
        r101.close();     // Catch: IOException -> L110
    L122:
        return new a(-1, null, null);
    }
}

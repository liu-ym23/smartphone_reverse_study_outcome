package com.baidu.mshield.x6.f;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: classes.dex */
public class b {
    public static void a(Context context, String str, String str2) {
        TextUtils.isEmpty(str);
    }

    public static String b(Context context) {
        try {
            String strQ = com.baidu.mshield.x6.c.b.b() ? new com.baidu.mshield.x6.b.b(context).Q() : new com.baidu.mshield.x6.b.b(context).A();
            if (TextUtils.isEmpty(strQ)) {
                strQ = com.baidu.mshield.x6.c.b.b() ? b(context, "x_o_b_d") : b(context, "x_b_d");
            }
            if (TextUtils.isEmpty(strQ)) {
                return com.baidu.mshield.x6.c.b.b() ? a(context, ".x_o_b_d") : a(context, ".x_b_d");
            }
            return strQ;
        } catch (Throwable th) {
            f.b(th);
            return "";
        }
    }

    public static void c(Context context) {
        try {
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            String strB = b(context);
            if (!TextUtils.isEmpty(strB) && !bVar.l()) {
                if (!a(strB)) {
                    return;
                }
                a(context, 1);
                a(context, 2);
                a(context, 3);
            }
            bVar.f(true);
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.baidu.mshield.x6.c.b.b()) {
                new com.baidu.mshield.x6.b.b(context).q(str);
                b(context, str, "x_o_b_d");
                a(context, str, ".x_o_b_d");
            } else {
                new com.baidu.mshield.x6.b.b(context).i(str);
                b(context, str, "x_b_d");
                a(context, str, ".x_b_d");
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void e(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            new com.baidu.mshield.x6.b.b(context).y(str);
            b(context, str, "g_b_d_v");
            a(context, str, ".g_b_d_v");
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static String a(Context context, String str) {
        try {
            if (!com.baidu.sec.privacy.f.c.d(context) || !k.a(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE"})) {
                return "";
            }
            File fileA = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory() + File.separator + str);
            if (fileA == null || !fileA.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileA));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(line);
            }
        } catch (Throwable th) {
            f.b(th);
            return "";
        }
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (com.baidu.mshield.x6.c.b.b()) {
                new com.baidu.mshield.x6.b.b(context).p(str);
                b(context, str, "g_m_o_bs");
                a(context, str, ".g_m_o_bs");
            } else {
                new com.baidu.mshield.x6.b.b(context).f(str);
                b(context, str, "g_m_b_s");
                a(context, str, ".g_m_b_s");
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !k.a(context, new String[]{"android.permission.WRITE_SETTINGS"})) {
            return;
        }
        try {
            com.baidu.mshield.b.e.a.a(context, str2, str);
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static boolean a(String str) {
        try {
        } catch (Throwable th) {
            f.b(th);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.length() > 70;
    }

    public static String b(Context context, String str) {
        try {
            return com.baidu.mshield.b.e.a.d(context, str);
        } catch (Throwable th) {
            f.b(th);
            return "";
        }
    }

    public static void a(Context context, int i4) {
        String str;
        String str2;
        try {
            com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(context);
            if (i4 == 1) {
                if (com.baidu.mshield.x6.c.b.b()) {
                    bVar.q("");
                    str = "x_o_b_d";
                    str2 = ".x_o_b_d";
                } else {
                    bVar.i("");
                    str = "x_b_d";
                    str2 = ".x_b_d";
                }
            } else if (i4 == 2) {
                bVar.y("");
                str = "g_b_d_v";
                str2 = ".g_b_d_v";
            } else if (i4 == 3) {
                bVar.k("");
                str = "g_c_o_m";
                str2 = ".g_c_o_m";
            } else {
                str = "";
                str2 = str;
            }
            try {
                if (!TextUtils.isEmpty(str) && k.a(context, new String[]{"android.permission.WRITE_SETTINGS"})) {
                    com.baidu.mshield.b.e.a.a(context, str, "");
                }
            } catch (Throwable th) {
                f.b(th);
            }
            try {
                if (!TextUtils.isEmpty(str2) && com.baidu.sec.privacy.f.c.d(context) && k.a(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"})) {
                    File fileA = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory() + File.separator + str2);
                    if (fileA == null || !fileA.exists()) {
                        return;
                    }
                    fileA.delete();
                }
            } catch (Throwable th2) {
                f.b(th2);
            }
        } catch (Throwable th3) {
            f.b(th3);
        }
    }

    public static String a(Context context) {
        String strA;
        String strB;
        String strA2;
        try {
            if (com.baidu.mshield.x6.c.b.b()) {
                strA = new com.baidu.mshield.x6.b.b(context).Q();
                strB = b(context, "x_o_b_d");
                strA2 = a(context, ".x_o_b_d");
            } else {
                strA = new com.baidu.mshield.x6.b.b(context).A();
                strB = b(context, "x_b_d");
                strA2 = a(context, ".x_b_d");
            }
            boolean zA = k.a(context, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
            boolean zA2 = k.a(context, new String[]{"android.permission.WRITE_SETTINGS"});
            return (zA && zA2) ? (TextUtils.isEmpty(strA) && TextUtils.isEmpty(strB) && TextUtils.isEmpty(strA2)) ? "1" : (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB) || TextUtils.isEmpty(strA2)) ? (!TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB) || TextUtils.isEmpty(strA2)) ? "4" : "3" : "2" : (!zA || zA2) ? (zA || !zA2) ? !TextUtils.isEmpty(strA) ? "2" : "4" : (TextUtils.isEmpty(strA) && TextUtils.isEmpty(strB)) ? "1" : (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB)) ? (!TextUtils.isEmpty(strA) || TextUtils.isEmpty(strB)) ? "4" : "3" : "2" : (TextUtils.isEmpty(strA) && TextUtils.isEmpty(strA2)) ? "1" : (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2)) ? (!TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2)) ? "4" : "3" : "2";
        } catch (Throwable th) {
            f.b(th);
            return "4";
        }
    }
}

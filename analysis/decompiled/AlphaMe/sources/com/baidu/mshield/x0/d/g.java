package com.baidu.mshield.x0.d;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.util.UUID;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static String f8393a = "";

    public static String b(Context context) {
        if (TextUtils.isEmpty(f8393a)) {
            f8393a = new g().f(context);
        }
        return f8393a;
    }

    public String a(Context context) {
        String strA = e.a(context);
        if (TextUtils.isEmpty("") && TextUtils.isEmpty(strA)) {
            return "1|" + com.baidu.mshield.b.f.e.a(UUID.randomUUID().toString());
        }
        return "0|" + com.baidu.mshield.b.f.e.a("" + strA);
    }

    public final void c(Context context, String str) {
    }

    public String d(Context context) {
        try {
        } catch (Throwable th) {
            d.a(th);
        }
        if (!a(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            return "";
        }
        if (!com.baidu.sec.privacy.f.c.d(context)) {
            com.baidu.mshield.b.c.a.a("getNewUidBySdCard isCanRequestNetBackground=false");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb.append(str);
        sb.append(".zp");
        sb.append(str);
        sb.append(".icosc");
        File fileA = com.baidu.mshield.b.e.a.a(context, sb.toString());
        if (fileA.exists()) {
            return a(fileA);
        }
        return "";
    }

    public String e(Context context) {
        try {
            return b(context, "com.q.zi.i");
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = r4.c(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L2e
            java.lang.String r0 = r4.e(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r3 = 1
            if (r1 == 0) goto L2a
            java.lang.String r0 = r4.d(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L27
            java.lang.String r0 = r4.a(r5)
            r1 = r3
            r2 = r1
            goto L30
        L27:
            r1 = r2
            r2 = r3
            goto L30
        L2a:
            r1 = r2
            r2 = r3
        L2c:
            r3 = r1
            goto L30
        L2e:
            r1 = r2
            goto L2c
        L30:
            if (r2 != 0) goto L3c
            java.lang.String r2 = r4.c(r5)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L44
        L3c:
            com.baidu.mshield.x0.l.c r2 = new com.baidu.mshield.x0.l.c
            r2.<init>(r5)
            r2.a(r0)
        L44:
            if (r3 != 0) goto L50
            java.lang.String r2 = r4.e(r5)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L55
        L50:
            java.lang.String r2 = "com.q.zi.i"
            r4.a(r5, r2, r0)
        L55:
            java.lang.String r2 = "android.permission.WRITE_EXTERNAL_STORAGE"
            boolean r2 = r4.a(r5, r2)
            if (r2 == 0) goto L6c
            if (r1 != 0) goto L69
            java.lang.String r1 = r4.d(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L6c
        L69:
            r4.c(r5, r0)
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x0.d.g.f(android.content.Context):java.lang.String");
    }

    public String c(Context context) {
        try {
            com.baidu.mshield.x0.l.c cVar = new com.baidu.mshield.x0.l.c(context);
            String strC = cVar.c();
            if (!TextUtils.isEmpty(strC)) {
                return strC;
            }
            String strB = cVar.b();
            if (TextUtils.isEmpty(strB)) {
                return "";
            }
            cVar.b(strB);
            return strB;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public final String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (Throwable th) {
            th = th;
            fileReader = null;
        }
        try {
            char[] cArr = new char[8192];
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                int i4 = fileReader.read(cArr);
                if (i4 <= 0) {
                    break;
                }
                charArrayWriter.write(cArr, 0, i4);
            }
            String string = charArrayWriter.toString();
            try {
                fileReader.close();
            } catch (Throwable th2) {
                d.a(th2);
            }
            return string;
        } catch (Throwable th3) {
            th = th3;
            try {
                d.a(th);
                return null;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        d.a(th4);
                    }
                }
            }
        }
    }

    public final String b(Context context, String str) {
        try {
            return com.baidu.mshield.b.e.a.d(context, str);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public final boolean a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public final boolean a(Context context, String str, String str2) {
        try {
            com.baidu.mshield.b.e.a.a(context, str, str2);
            return true;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }
}

package aa;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f74a;

    static {
    }

    public static Map a(Context r10) {
        HashMap r11 = new HashMap();
        String[] r12 = f74a;
        if (r12 == null) goto L7;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L7;
        String r15 = r12[r14];
        r11.put(r15, Boolean.valueOf(com.monitor.cloudmessage.utils.c.a(r10, r15)));
        r14 = r14 + 1;
    L7:
        return r11;
    }

    public static File b(Context r10) {
        BufferedWriter r11 = null;
        f74a = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L52
        StringBuilder r12 = new StringBuilder();
        r12.append(com.monitor.cloudmessage.utils.b.h(r10).getAbsolutePath());
        String r13 = File.separator;
        r12.append(r13);
        r12.append("permissionInfo");
        String r14 = r12.toString();
        String r15 = r14 + r13 + "permission.txt";
        File r16 = new File(r14);     // Catch: Throwable -> L8 IOException -> L10
        if (r16.exists() == true) goto L12;
        r16.mkdirs();     // Catch: Throwable -> L8 IOException -> L10
    L12:
        FileWriter r17 = new FileWriter(r14 + r13 + "permission.txt");     // Catch: Throwable -> L8 IOException -> L10
    L68:
        BufferedWriter r18 = new BufferedWriter(r17);     // Catch: Throwable -> L29 IOException -> L31
        Iterator r19 = a(r10).entrySet().iterator();     // Catch: Throwable -> L19 IOException -> L21
    L16:
        if (r19.hasNext() == false) goto L62;
        Map.Entry r20 = (Map.Entry) r19.next();     // Catch: Throwable -> L19 IOException -> L21
        r18.write(String.format("permission: %s, result: %b\n", new Object[]{r20.getKey(), r20.getValue()}));     // Catch: Throwable -> L19 IOException -> L21
        goto L16
    L62:
        r18.close();     // Catch: IOException -> L25
        r17.close();     // Catch: IOException -> L25
    L28:
        return new File(r15);
    L25:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L19
        if (r18 != null) goto L55;
    L38:
        if (r17 == null) goto L42;
        r17.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L42:
        return null;
    L55:
        r18.close();     // Catch: IOException -> L36
    L19:
        th = th;
        r11 = r18;
    L43:
        if (r11 != null) goto L64;
    L47:
        if (r17 == null) goto L51;
        r17.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L64:
        r11.close();     // Catch: IOException -> L45
        goto L47
    L31:
        e = e;
        r18 = null;
    L29:
        th = th;
    L10:
        e = e;
        r18 = null;
        r17 = null;
    L8:
        th = th;
        r17 = null;
    L52:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}

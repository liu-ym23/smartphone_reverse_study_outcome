package com.baidu.mshield.utility;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.MyProvider;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.rp.Report;
import com.stepos.activeview.utils.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f8346a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f8347b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f8348c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f8349d = "";

    /* renamed from: e, reason: collision with root package name */
    public static int f8350e = -1;

    public static void a(Throwable th) {
        com.baidu.mshield.b.c.a.a(th);
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strA = com.baidu.xclient.gdid.a.a(context);
            if (strA == null) {
                strA = "";
            }
            jSONObject.put("0", strA);
            String strB = com.baidu.xclient.gdid.a.b(context);
            if (strB == null) {
                strB = "";
            }
            jSONObject.put("1", strB);
            String strE = com.baidu.xclient.gdid.a.e(context);
            if (strE == null) {
                strE = "";
            }
            jSONObject.put("2", strE);
            String str = Build.HOST;
            if (str == null) {
                str = "";
            }
            jSONObject.put("3", str);
            String strA2 = c.a();
            if (strA2 == null) {
                strA2 = "";
            }
            jSONObject.put("4", strA2);
            String strH = com.baidu.xclient.gdid.a.h(context);
            if (strH == null) {
                strH = "";
            }
            jSONObject.put("5", strH);
            String str2 = Build.VERSION.CODENAME;
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("6", str2);
            String str3 = Build.VERSION.INCREMENTAL;
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("7", str3);
            jSONObject.put("8", c.b(context));
            String strG = com.baidu.xclient.gdid.a.g(context);
            if (strG == null) {
                strG = "";
            }
            jSONObject.put("9", strG);
            String strA3 = com.baidu.mshield.core.a.a("mod");
            if (strA3 == null) {
                strA3 = "";
            }
            jSONObject.put("10", strA3);
            jSONObject.put("11", c.g(context));
            String strA4 = com.baidu.mshield.core.a.a("arv");
            jSONObject.put("12", strA4 != null ? strA4 : "");
            jSONObject.put("13", c.h(context));
            jSONObject.put("20", com.baidu.mshield.core.a.a("arl"));
        } catch (Throwable th) {
            a(th);
        }
        return jSONObject;
    }

    public static String[] c(Context context) {
        if (!TextUtils.isEmpty(f8346a) && !TextUtils.isEmpty(f8347b)) {
            return new String[]{f8346a, f8347b};
        }
        String strK = com.baidu.mshield.sharedpreferences.a.a(context).K();
        if (TextUtils.isEmpty(strK)) {
            return new String[0];
        }
        String[] strArrSplit = strK.split("-");
        if (strArrSplit == null || strArrSplit.length != 2) {
            return new String[2];
        }
        f8346a = strArrSplit[0];
        f8347b = strArrSplit[1];
        return strArrSplit;
    }

    @SuppressLint({"MissingPermission"})
    public static int d(Context context) {
        NetworkInfo networkInfoA;
        try {
            networkInfoA = com.baidu.mshield.b.e.b.a(context);
        } catch (Throwable th) {
            a(th);
            networkInfoA = null;
        }
        if (networkInfoA == null) {
            return 0;
        }
        if (1 == networkInfoA.getType()) {
            return 2;
        }
        networkInfoA.getType();
        return 1;
    }

    public static String e(Context context) {
        try {
        } catch (Throwable th) {
            a(th);
        }
        if (TextUtils.isEmpty(f8349d) && f8350e != 1) {
            try {
                ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + ".mshield.ac.provider", 0);
                if (providerInfoResolveContentProvider != null && !providerInfoResolveContentProvider.multiprocess) {
                    f8349d = providerInfoResolveContentProvider.processName;
                }
            } catch (Throwable th2) {
                a(th2);
            }
            f8350e = 1;
            return f8349d;
        }
        return f8349d;
    }

    public static String f(Context context) {
        try {
            StringBuilder sb = new StringBuilder("host=");
            String str = f.f8358a;
            sb.append(str);
            com.baidu.mshield.b.c.a.b(sb.toString());
            return new String(F.getInstance().ad(Base64.decode(str, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void g(Context context) {
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
        if (System.currentTimeMillis() - aVarA.b() <= 86400000) {
            aVarA.a(aVarA.l() + 1);
            return;
        }
        HashMap map = new HashMap();
        map.put("0", Integer.valueOf(aVarA.l() + 1));
        aVarA.a(0);
        aVarA.k();
        a(context, "1067119", map);
    }

    public static int h(Context context) {
        int iA;
        try {
            if (MyProvider.a() || TextUtils.isEmpty(e(context)) || (iA = a(context)) == 1) {
                return 1;
            }
            if (iA == 2) {
                return 0;
            }
            return MyProvider.a() ? 1 : 0;
        } catch (Throwable th) {
            a(th);
            return -1;
        }
    }

    public static String[] i(Context context) {
        String str = f8346a;
        String str2 = f8347b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.baidu.mshield.b.c.a.b("get key key select by in memory!");
            return new String[]{str, str2};
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String strK = com.baidu.mshield.sharedpreferences.a.a(context).K();
            if (!TextUtils.isEmpty(strK)) {
                String[] strArrSplit = strK.split("-");
                if (strArrSplit.length == 2) {
                    com.baidu.mshield.b.c.a.b("get key key select by  from Info");
                    return strArrSplit;
                }
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            String strA = com.baidu.mshield.sharedpreferences.a.a(context).a();
            if (!TextUtils.isEmpty(strA)) {
                String[] strArrSplit2 = strA.split("-");
                if (strArrSplit2.length == 2) {
                    com.baidu.mshield.b.c.a.b("get key key select by  in mark");
                    return strArrSplit2;
                }
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.baidu.mshield.b.c.a.b("get key key select by by default");
            str = "985050001";
            str2 = "83162820e470e3b72501f0683504560e";
        }
        return new String[]{str, str2};
    }

    public static void a(String str, String str2) {
        f8346a = str;
        f8347b = str2;
    }

    public static void a(Context context, String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "");
            jSONObject2.put("2", "");
            String[] strArrI = i(context);
            jSONObject2.put("3", (strArrI == null || strArrI.length != 2 || TextUtils.isEmpty(strArrI[0]) || TextUtils.isEmpty(strArrI[1])) ? "985050001" : strArrI[0]);
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", "mshield");
            jSONObject2.put("9", "4.2.6");
            jSONObject2.put("10", str);
            jSONObject.put("Common_section", jSONObject2);
            if (map != null && map.size() > 0) {
                jSONObject.put("Module_section", new JSONObject(map));
            } else {
                jSONObject.put("Module_section", new JSONObject());
            }
            Report report = Report.getInstance(context);
            String string = jSONObject.toString();
            com.baidu.mshield.b.c.a.b("sendEventUDC:" + string);
            report.s(string);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void b(Context context, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("Common_section");
            long jOptLong = jSONObjectOptJSONObject.optLong("0");
            String strOptString = jSONObjectOptJSONObject.optString("10");
            int iOptInt = jSONObjectOptJSONObject.optInt("5");
            int iOptInt2 = jSONObjectOptJSONObject.optInt("6");
            int iOptInt3 = jSONObjectOptJSONObject.optInt("7");
            int iOptInt4 = jSONObjectOptJSONObject.optInt("11");
            String strOptString2 = jSONObjectOptJSONObject.optString("12", "");
            if (iOptInt2 == 0) {
                iOptInt2 = 1;
            }
            com.baidu.mshield.rp.d.a aVar = new com.baidu.mshield.rp.d.a();
            aVar.f8305d = str;
            aVar.f8303b = strOptString;
            aVar.f8308g = iOptInt;
            aVar.f8304c = 3;
            aVar.f8306e = jOptLong;
            aVar.f8307f = iOptInt2;
            aVar.f8309h = iOptInt3;
            aVar.f8310i = iOptInt4;
            aVar.f8311j = strOptString2;
            b.a(context).a(aVar);
        } catch (Throwable th) {
            a(th);
        }
    }

    public static void a(Context context, byte[] bArr) {
        try {
            String[] strArrI = i(context);
            if (strArrI.length == 2) {
                if (TextUtils.isEmpty(strArrI[0]) || TextUtils.isEmpty(strArrI[1]) || !"200080".equals(strArrI[0]) || !context.getPackageName().equals("com.baidu.BaiduMap") || bArr == null) {
                    return;
                }
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    bArr[i4] = (byte) (bArr[i4] ^ 246);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(Context context, com.baidu.mshield.rp.b.a aVar, String str, boolean z4) {
        return a(context, aVar.f8293a, aVar.f8295c, z4 ? aVar.f8296d : aVar.f8297e, str);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        b.a(context).a(false);
        b.a(context).e();
        com.baidu.mshield.rp.b.a aVar = new com.baidu.mshield.rp.b.a();
        aVar.f8293a = str;
        aVar.f8294b = str2;
        aVar.f8295c = str3;
        aVar.f8296d = str4;
        aVar.f8297e = str5;
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
        List<com.baidu.mshield.rp.b.a> listP = aVarA.p();
        if (listP == null || !listP.contains(aVar)) {
            aVarA.a(aVar);
            if (!aVarA.e(aVar.f8297e)) {
                b.a(context).a(aVar);
            }
            b.a(context).b();
            b.a(context).d();
            return;
        }
        aVarA.a(listP, aVar);
        b.a(context).b();
    }

    public static void a(Context context, String str) {
        String strValueOf = "";
        com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("0");
                if (jSONObjectOptJSONObject != null) {
                    String strValueOf2 = "";
                    while (jSONObjectOptJSONObject.keys().hasNext()) {
                        strValueOf2 = String.valueOf(jSONObjectOptJSONObject.keys().next());
                        if (!TextUtils.isEmpty(strValueOf2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        aVarA.a(strValueOf2, jSONObjectOptJSONObject.optString(strValueOf2));
                    }
                }
            } catch (Throwable th) {
                a(th);
            }
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("1");
                if (jSONObjectOptJSONObject2 != null) {
                    while (jSONObjectOptJSONObject2.keys().hasNext()) {
                        strValueOf = String.valueOf(jSONObjectOptJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(strValueOf)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(strValueOf)) {
                        aVarA.b(strValueOf, jSONObjectOptJSONObject2.optString(strValueOf));
                    }
                }
            } catch (Throwable th2) {
                a(th2);
            }
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("2");
                if (jSONArrayOptJSONArray != null) {
                    com.baidu.mshield.b.c.a.b("setAliveData rp= " + jSONArrayOptJSONArray.toString());
                    aVarA.f(jSONArrayOptJSONArray.toString());
                }
            } catch (Throwable th3) {
                a(th3);
            }
        } catch (Throwable th4) {
            a(th4);
        }
    }

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1) + "" + calendar.get(2) + "" + calendar.get(5);
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("0", System.currentTimeMillis());
            jSONObject2.put("1", "0");
            jSONObject2.put("2", "0");
            String[] strArrI = i(context);
            if (strArrI.length == 2) {
                jSONObject2.put("3", strArrI[0]);
            } else {
                jSONObject2.put("3", "985050001");
            }
            jSONObject2.put("4", 0);
            jSONObject2.put("5", 0);
            jSONObject2.put("6", 1);
            jSONObject2.put("7", 0);
            jSONObject2.put("8", str);
            jSONObject2.put("9", str2);
            jSONObject2.put("10", str3);
            JSONObject jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                try {
                    jSONObject3 = new JSONObject(str4);
                } catch (Throwable th) {
                    a(th);
                }
            }
            jSONObject.put("Common_section", jSONObject2);
            jSONObject.put("Module_section", jSONObject3);
        } catch (Throwable th2) {
            a(th2);
        }
        return jSONObject;
    }

    public static void a(Context context, long j4) {
        try {
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            new Intent("com.b.r.p").setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 201326592);
            try {
                alarmManager.cancel(broadcast);
            } catch (Throwable th) {
                a(th);
            }
            try {
                alarmManager.set(0, System.currentTimeMillis() + j4, broadcast);
            } catch (Throwable th2) {
                a(th2);
            }
        } catch (Throwable th3) {
            a(th3);
        }
    }

    public static String a(byte[] bArr) {
        String string = "";
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & UByte.MAX_VALUE);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            StringBuilder sbS = B0.g.s(string);
            sbS.append(hexString.toUpperCase());
            string = sbS.toString();
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0156 A[Catch: all -> 0x015a, TRY_ENTER, TryCatch #4 {all -> 0x015a, blocks: (B:23:0x0087, B:25:0x008c, B:27:0x009a, B:29:0x00bf, B:31:0x00c8, B:33:0x00d7, B:35:0x00e2, B:37:0x00eb, B:39:0x00f4, B:45:0x0114, B:47:0x011b, B:49:0x0124, B:51:0x012d, B:53:0x0136, B:56:0x0156, B:59:0x015c, B:22:0x0080), top: B:73:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015c A[Catch: all -> 0x015a, TRY_LEAVE, TryCatch #4 {all -> 0x015a, blocks: (B:23:0x0087, B:25:0x008c, B:27:0x009a, B:29:0x00bf, B:31:0x00c8, B:33:0x00d7, B:35:0x00e2, B:37:0x00eb, B:39:0x00f4, B:45:0x0114, B:47:0x011b, B:49:0x0124, B:51:0x012d, B:53:0x0136, B:56:0x0156, B:59:0x015c, B:22:0x0080), top: B:73:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject a(android.content.Context r18, org.json.JSONObject r19) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.utility.a.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public static int a(Context context) {
        try {
            String strE = e(context);
            if (TextUtils.isEmpty(f8348c)) {
                f8348c = a(Process.myPid());
            }
            if (TextUtils.isEmpty(f8348c)) {
                return 0;
            }
            return !TextUtils.isEmpty(strE) ? strE.equals(f8348c) ? 1 : 2 : context.getPackageName().equals(f8348c) ? 3 : 4;
        } catch (Throwable th) {
            a(th);
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.StringBuilder] */
    public static String a(int i4) {
        String str;
        String processName;
        ?? A4 = 0;
        A4 = 0;
        try {
            processName = Application.getProcessName();
            try {
            } catch (Throwable th) {
                th = th;
                A4 = processName;
                a(th);
                str = A4;
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
            a(th);
            str = A4;
            return str;
        }
        if (!TextUtils.isEmpty(processName)) {
            com.baidu.mshield.b.c.a.b("getProcessName return by P+:" + processName);
            return processName.trim();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            A4 = objInvoke instanceof String;
            if (A4 != 0) {
                processName = (String) objInvoke;
            }
        } catch (Throwable th3) {
            a(th3);
        }
        if (!TextUtils.isEmpty(processName)) {
            com.baidu.mshield.b.c.a.b("getProcessName return by reflect:" + processName);
            return processName.trim();
        }
        A4 = a(String.format("/proc/%d/cmdline", Integer.valueOf(i4)));
        boolean zIsEmpty = TextUtils.isEmpty(A4);
        str = A4;
        if (!zIsEmpty) {
            com.baidu.mshield.b.c.a.b("getProcessName return by cmdline:" + A4);
            return A4.trim();
        }
        return str;
    }

    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                String strA = a(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (Throwable th) {
                    a(th);
                }
                return strA;
            } catch (Throwable th2) {
                th = th2;
                try {
                    a(th);
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            a(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Constants.UTF_8_CODE));
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                if (z4) {
                    z4 = false;
                } else {
                    sb.append('\n');
                }
                sb.append(line);
            } else {
                return sb.toString();
            }
        }
    }
}

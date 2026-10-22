package com.baidu.mshield.x6.c;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import ch.qos.logback.classic.spi.CallerData;
import com.baidu.mshield.x6.f.f;
import com.baidu.platform.comapi.map.MapController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        return "";
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String b(Context context) {
        return "";
    }

    public static void c(int i4, String str, String str2, String str3, List<String> list) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData13===" + i4 + ";" + str + ";" + str2 + ";" + str3);
            if (i4 == 0) {
                String[] strArrSplit = str3.split("\\|");
                if (1 == a(str, strArrSplit[0], strArrSplit.length == 2 ? strArrSplit[1].replace("$", "#") : null)) {
                    list.add(str2);
                }
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void d(int i4, String str, String str2, String str3, List<String> list) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData14===" + i4 + ";" + str + ";" + str2 + ";" + str3);
            if (i4 == 0) {
                String[] strArrSplit = str3.split("\\|");
                if (strArrSplit.length != 2) {
                    return;
                }
                String str4 = (String) com.baidu.xclient.gdid.a.a(16, str, strArrSplit[0], new long[]{Long.valueOf(strArrSplit[1]).longValue(), c(str)});
                com.baidu.mshield.b.c.a.b("GH jniCtl ===" + str4);
                if ("1".equals(str4)) {
                    list.add(str2);
                }
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void e(int i4, String str, String str2, String str3, List<String> list) {
        try {
            if (i4 == 1) {
                if (!f(str) || list.contains(str2)) {
                    return;
                }
                list.add(str2);
                return;
            }
            if (i4 == 2) {
                if (f(str) || list.contains(str2)) {
                    return;
                }
                list.add(str2);
                return;
            }
            if (i4 != 6 || TextUtils.isEmpty(str3)) {
                return;
            }
            if (str.contains(CallerData.NA)) {
                if (!a(str, str3, 2) || list.contains(str2)) {
                    return;
                }
                list.add(str2);
                return;
            }
            File[] fileArrListFiles = new File(str).listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file : fileArrListFiles) {
                String name = file.getName();
                if (name != null && name.contains(str3)) {
                    if (list.contains(str2)) {
                        return;
                    }
                    list.add(str2);
                    return;
                }
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void f(int i4, String str, String str2, String str3, List<String> list) {
        try {
            if (i4 == 1) {
                if (!TextUtils.isEmpty(d(str)) && !list.contains(str2)) {
                    list.add(str2);
                }
            } else if (i4 == 2) {
                if (TextUtils.isEmpty(d(str)) && !list.contains(str2)) {
                    list.add(str2);
                }
            } else if (i4 == 3) {
                String strD = d(str);
                if (!TextUtils.isEmpty(strD) && !TextUtils.isEmpty(str3) && strD.contains(str3) && !list.contains(str2)) {
                    list.add(str2);
                }
            } else {
                if (i4 != 4) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    String strD2 = d(str);
                    if (!TextUtils.isEmpty(strD2) && !TextUtils.isEmpty(str3) && strD2.startsWith(str3) && !list.contains(str2)) {
                        list.add(str2);
                    }
                }
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    /* JADX WARN: Finally extract failed */
    public static List<String> a(String str) {
        String strValueOf;
        int i4;
        String string;
        String string2;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i5);
                try {
                    strValueOf = String.valueOf(jSONObject.getInt("eid"));
                } catch (Throwable th) {
                    f.b(th);
                    strValueOf = null;
                }
                int i6 = -1;
                try {
                    i4 = jSONObject.getInt("pattern");
                } catch (Throwable th2) {
                    f.b(th2);
                    i4 = -1;
                }
                try {
                    string = jSONObject.getString(MapController.ITEM_LAYER_TAG);
                } catch (Throwable th3) {
                    f.b(th3);
                    string = null;
                }
                try {
                    i6 = jSONObject.getInt("type");
                } catch (Throwable th4) {
                    f.b(th4);
                }
                try {
                    string2 = jSONObject.getString("value");
                } catch (Throwable th5) {
                    f.b(th5);
                    string2 = null;
                }
                if (i6 == 0 && !TextUtils.isEmpty(string)) {
                    a(i4, string, strValueOf, string2, arrayList);
                } else if (i6 == 1 && !TextUtils.isEmpty(string)) {
                    b(i4, string, strValueOf, string2, arrayList);
                } else if (i6 == 2 && !TextUtils.isEmpty(string)) {
                    e(i4, string, strValueOf, string2, arrayList);
                } else if (i6 == 3 && !TextUtils.isEmpty(string)) {
                    f(i4, string, strValueOf, string2, arrayList);
                } else if (i6 == 4 && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                    try {
                        fileReader = new FileReader(new File("/proc/cpuinfo"));
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    if (line.contains(string)) {
                                        String strA = a(line, string);
                                        if (!TextUtils.isEmpty(strA) && strA.startsWith(string2)) {
                                            if (!arrayList.contains(strValueOf)) {
                                                arrayList.add(strValueOf);
                                            }
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    try {
                                        f.b(th);
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    } catch (Throwable th7) {
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        throw th7;
                                    }
                                }
                            }
                            fileReader.close();
                            bufferedReader.close();
                        } catch (Throwable th8) {
                            th = th8;
                            bufferedReader = null;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        fileReader = null;
                        bufferedReader = null;
                    }
                } else if (i6 == 13 && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                    c(i4, string, strValueOf, string2, arrayList);
                } else if (i6 == 14 && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
                    d(i4, string, strValueOf, string2, arrayList);
                }
            }
            return arrayList;
        } catch (Throwable th10) {
            f.b(th10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        if (r6.contains(r4) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        r6.add(r4);
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(int r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.List<java.lang.String> r6) {
        /*
            r0 = 1
            if (r2 != r0) goto L17
            boolean r2 = f(r3)     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L89
            boolean r2 = r6.contains(r4)     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto L89
            r6.add(r4)     // Catch: java.lang.Throwable -> L14
            goto L89
        L14:
            r2 = move-exception
            goto L86
        L17:
            r0 = 2
            if (r2 != r0) goto L2b
            boolean r2 = f(r3)     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto L89
            boolean r2 = r6.contains(r4)     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto L89
            r6.add(r4)     // Catch: java.lang.Throwable -> L14
            goto L89
        L2b:
            r0 = 3
            if (r2 != r0) goto L89
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto L89
            r2 = 0
            java.io.FileReader r0 = new java.io.FileReader     // Catch: java.lang.Throwable -> L6a
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L6a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L6a
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L6a
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L67
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L67
        L44:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L5c
            boolean r2 = r2.contains(r5)     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L44
            boolean r2 = r6.contains(r4)     // Catch: java.lang.Throwable -> L5a
            if (r2 != 0) goto L5c
            r6.add(r4)     // Catch: java.lang.Throwable -> L5a
            goto L5c
        L5a:
            r2 = move-exception
            goto L63
        L5c:
            r0.close()     // Catch: java.lang.Throwable -> L14
            r3.close()     // Catch: java.lang.Throwable -> L14
            goto L89
        L63:
            r4 = r3
            r3 = r2
        L65:
            r2 = r0
            goto L6c
        L67:
            r3 = move-exception
            r4 = r2
            goto L65
        L6a:
            r3 = move-exception
            r4 = r2
        L6c:
            com.baidu.mshield.x6.f.f.b(r3)     // Catch: java.lang.Throwable -> L7a
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.lang.Throwable -> L14
        L74:
            if (r4 == 0) goto L89
            r4.close()     // Catch: java.lang.Throwable -> L14
            goto L89
        L7a:
            r3 = move-exception
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.lang.Throwable -> L14
        L80:
            if (r4 == 0) goto L85
            r4.close()     // Catch: java.lang.Throwable -> L14
        L85:
            throw r3     // Catch: java.lang.Throwable -> L14
        L86:
            com.baidu.mshield.x6.f.f.b(r2)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.c.a.b(int, java.lang.String, java.lang.String, java.lang.String, java.util.List):void");
    }

    public static long c(String str) {
        String line;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("proc/self/maps", "r");
            do {
                line = randomAccessFile.readLine();
                if (line == null) {
                    break;
                }
                line = line.trim();
            } while (!line.endsWith(str));
            long jE = !TextUtils.isEmpty(line) ? e(line.split("-")[0]) : 0L;
            randomAccessFile.close();
            return jE;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            f.b(th);
            return null;
        }
    }

    public static void d(int i4, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData9 item=" + str);
            String str4 = (String) com.baidu.xclient.gdid.a.a(10, str, str3, (Object) null);
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData9 prop=" + str4);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put(str2, str4);
            } else {
                jSONObject.put(str2, "");
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void c(int i4, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 item=" + str);
            if (i4 == 0) {
                String str4 = (String) com.baidu.xclient.gdid.a.a(24, str, str3, (Object) null);
                jSONObject.put(str2, str4);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=0, jniRet=" + str4);
            } else if (i4 == 2) {
                String str5 = (String) com.baidu.xclient.gdid.a.a(25, str, str3, (Object) null);
                jSONObject.put(str2, str5);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=2, jniRet=" + str5);
            } else if (i4 == 3) {
                String str6 = (String) com.baidu.xclient.gdid.a.a(26, str, str3, (Object) null);
                jSONObject.put(str2, str6);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=3, jniRet=" + str6);
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static long e(String str) {
        try {
            return Long.valueOf(str, 16).longValue();
        } catch (NumberFormatException e4) {
            f.b(e4);
            return -2147483648L;
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String strA = com.baidu.xclient.gdid.a.a(str);
            com.baidu.mshield.b.c.a.b("GH getFileInode===" + strA);
            return !"-1".equals(new JSONObject(strA).optString("0"));
        } catch (Throwable th) {
            f.b(th);
            return false;
        }
    }

    public static JSONObject b(String str) {
        String strValueOf;
        int i4;
        String string;
        String string2;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                try {
                    strValueOf = String.valueOf(jSONObject2.getInt("eid"));
                } catch (Throwable th) {
                    f.b(th);
                    strValueOf = null;
                }
                int i6 = -1;
                try {
                    i4 = jSONObject2.getInt("pattern");
                } catch (Throwable th2) {
                    f.b(th2);
                    i4 = -1;
                }
                try {
                    string = jSONObject2.getString(MapController.ITEM_LAYER_TAG);
                } catch (Throwable th3) {
                    f.b(th3);
                    string = null;
                }
                try {
                    i6 = jSONObject2.getInt("type");
                } catch (Throwable th4) {
                    f.b(th4);
                }
                try {
                    string2 = jSONObject2.getString("value");
                } catch (Throwable th5) {
                    f.b(th5);
                    string2 = null;
                }
                if (i6 == 9 && !TextUtils.isEmpty(string)) {
                    d(i4, string, strValueOf, string2, jSONObject);
                } else if (i6 == 11 && !TextUtils.isEmpty(string)) {
                    a(i4, string, strValueOf, string2, jSONObject);
                } else if (i6 == 12 && !TextUtils.isEmpty(string)) {
                    b(i4, string, strValueOf, string2, jSONObject);
                } else if (i6 == 20 && !TextUtils.isEmpty(string)) {
                    c(i4, string, strValueOf, string2, jSONObject);
                }
            }
            return jSONObject;
        } catch (Throwable th6) {
            f.b(th6);
            return null;
        }
    }

    public static void a(int i4, String str, String str2, String str3, List<String> list) {
        try {
            if (i4 == 1) {
                if (str.contains("/")) {
                    try {
                        Class.forName(str.replace("/", "."), false, ClassLoader.getSystemClassLoader());
                        list.add(str2);
                    } catch (ClassNotFoundException e4) {
                        f.b(e4);
                    }
                }
            } else {
                if (i4 != 2) {
                    return;
                }
                try {
                    Class.forName(str.replace("/", "."), false, ClassLoader.getSystemClassLoader());
                } catch (ClassNotFoundException e5) {
                    f.b(e5);
                    list.add(str2);
                }
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static void b(int i4, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 item=" + str);
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 value=" + str3);
            if (i4 == 0) {
                String str4 = (String) com.baidu.xclient.gdid.a.a(23, str, Integer.valueOf(Integer.parseInt(str3)), (Object) null);
                jSONObject.put(str2, str4);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 pat=0, jniRet=" + str4);
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public static boolean a(String str, String str2, int i4) {
        int i5 = i4 - 1;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String strReplaceAll = str.replaceAll("\\?", "");
                File[] fileArrListFiles = new File(strReplaceAll).listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    for (File file : fileArrListFiles) {
                        String name = file.getName();
                        if (name != null && name.contains(str2)) {
                            return true;
                        }
                        if ((name == null || !name.equals(".")) && ((name == null || !name.equals("..")) && i4 > 0)) {
                            File file2 = new File(strReplaceAll, file.getName());
                            if (file2.isDirectory()) {
                                return a(file2.getAbsolutePath(), str2, i5);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                f.b(th);
            }
        }
        return false;
    }

    public static String a(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(?i)" + str2 + "\t*: (.*)").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        } catch (Throwable th) {
            f.b(th);
            return null;
        }
    }

    public static int a(String str, String str2, String str3) {
        Method declaredMethod;
        StringBuilder sbX = g.x("getAPH===", str, ";", str2, ";");
        sbX.append(str3);
        com.baidu.mshield.b.c.a.b(sbX.toString());
        try {
            Class<?> cls = Class.forName(str);
            if (!TextUtils.isEmpty(str3)) {
                String[] strArrSplit = str3.split("#");
                if (strArrSplit != null && strArrSplit.length > 0) {
                    Class<?>[] clsArr = new Class[strArrSplit.length];
                    for (int i4 = 0; i4 < strArrSplit.length; i4++) {
                        clsArr[i4] = Class.forName(strArrSplit[i4]);
                    }
                    declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                } else {
                    declaredMethod = cls.getDeclaredMethod(str2, new Class[0]);
                }
            } else {
                declaredMethod = cls.getDeclaredMethod(str2, new Class[0]);
            }
            if (declaredMethod != null) {
                if (Modifier.isNative(declaredMethod.getModifiers())) {
                    return 1;
                }
            }
        } catch (Throwable th) {
            f.b(th);
        }
        try {
            Field declaredField = Class.forName("de.robv.android.xposed.XposedHelpers", true, ClassLoader.getSystemClassLoader()).getDeclaredField("methodCache");
            declaredField.setAccessible(true);
            HashMap map = (HashMap) declaredField.get(null);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("#");
            stringBuffer.append(str2);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                if (((String) it.next()).contains(stringBuffer.toString())) {
                    return 1;
                }
            }
        } catch (Throwable th2) {
            f.b(th2);
            com.baidu.mshield.b.c.a.b("getAPH exe===" + th2);
        }
        return 0;
    }

    public static void a(int i4, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 item=" + str);
            if (i4 == 0) {
                String str4 = (String) com.baidu.xclient.gdid.a.a(21, str, str3, (Object) null);
                jSONObject.put(str2, str4);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 pat=0, jniRet=" + str4);
            } else if (i4 == 1) {
                String str5 = (String) com.baidu.xclient.gdid.a.a(22, str, str3, (Object) null);
                jSONObject.put(str2, str5);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 pat=1, jniRet=" + str5);
            }
        } catch (Throwable th) {
            f.b(th);
        }
    }
}

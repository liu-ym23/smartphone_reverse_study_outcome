package Z7;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import io.ktor.sse.ServerSentEventKt;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static List<File> f7657a = new ArrayList();

    /* JADX WARN: Type inference failed for: r5v3, types: [boolean] */
    public static CrashDetailBean a(Context context, String str, Y7.a aVar) {
        BufferedInputStream bufferedInputStream;
        String str2;
        String strD;
        BufferedInputStream bufferedInputStream2 = null;
        if (context == null || str == null || aVar == null) {
            C1139k.j("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (file.exists()) {
            ?? CanRead = file.canRead();
            try {
                if (CanRead != 0) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            String strD2 = d(bufferedInputStream);
                            if (strD2 != null && strD2.equals("NATIVE_RQD_REPORT")) {
                                HashMap map = new HashMap();
                                loop0: while (true) {
                                    str2 = null;
                                    while (true) {
                                        strD = d(bufferedInputStream);
                                        if (strD == null) {
                                            break loop0;
                                        }
                                        if (str2 == null) {
                                            str2 = strD;
                                        }
                                    }
                                    map.put(str2, strD);
                                }
                                if (str2 != null) {
                                    C1139k.j("record not pair! drop! %s", str2);
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                    return null;
                                }
                                CrashDetailBean crashDetailBeanB = b(context, map, aVar);
                                try {
                                    bufferedInputStream.close();
                                    return crashDetailBeanB;
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                    return crashDetailBeanB;
                                }
                            }
                            C1139k.j("record read fail! %s", strD2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                            return null;
                        } catch (IOException e13) {
                            e = e13;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                }
                            }
                            return null;
                        }
                    } catch (IOException e15) {
                        e = e15;
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = CanRead;
            }
        }
        return null;
    }

    public static CrashDetailBean b(Context context, Map<String, String> map, Y7.a aVar) throws NumberFormatException {
        boolean zEqualsIgnoreCase;
        if (C1130b.h(context) == null) {
            C1139k.j("abnormal com info not created", new Object[0]);
        } else {
            String str = map.get("intStateStr");
            if (str != null && str.trim().length() > 0) {
                Map<String, Integer> mapO = o(map.get("intStateStr"));
                if (mapO == null) {
                    C1139k.j("parse intSateMap fail", Integer.valueOf(map.size()));
                    return null;
                }
                try {
                    mapO.get("sino").getClass();
                    mapO.get("sud").getClass();
                    String str2 = map.get("soVersion");
                    if (TextUtils.isEmpty(str2)) {
                        C1139k.j("error format at version", new Object[0]);
                        return null;
                    }
                    String str3 = (String) c(map, "codeMsg", "unknown");
                    String str4 = (String) c(map, "signalName", "unknown");
                    map.get("errnoMsg");
                    String str5 = (String) c(map, "stack", "unknown");
                    String str6 = map.get("jstack");
                    if (str6 != null) {
                        str5 = str5 + "java:\n" + str6;
                    }
                    Integer num = mapO.get("sico");
                    if (num != null && num.intValue() > 0) {
                        str4 = str4 + "(" + str3 + ")";
                        str3 = "KERNEL";
                    }
                    String str7 = str3;
                    String str8 = str4;
                    String str9 = map.get("nativeLog");
                    byte[] bArrX = (str9 == null || str9.isEmpty()) ? null : C1143o.x(str9, "BuglyNativeLog.txt");
                    String str10 = (String) c(map, "sendingProcess", "unknown");
                    Integer num2 = mapO.get("spd");
                    if (num2 != null) {
                        str10 = str10 + "(" + num2 + ")";
                    }
                    String str11 = str10;
                    String str12 = (String) c(map, "threadName", "unknown");
                    Integer num3 = mapO.get("et");
                    if (num3 != null) {
                        str12 = str12 + "(" + num3 + ")";
                    }
                    String str13 = str12;
                    String str14 = (String) c(map, "processName", "unknown");
                    Integer num4 = mapO.get("ep");
                    if (num4 != null) {
                        str14 = str14 + "(" + num4 + ")";
                    }
                    CrashDetailBean crashDetailBeanA = aVar.a(str14, str13, (mapO.get("ets").intValue() * 1000) + (mapO.get("etms").intValue() / 1000), str8, (String) c(map, "errorAddr", "unknown"), e(str5), str7, str11, (String) c(map, "tombPath", "unknown"), map.get("sysLogPath"), map.get("jniLogPath"), str2, bArrX, h(map), false, false);
                    if (crashDetailBeanA != null) {
                        String str15 = (String) c(map, "userId", crashDetailBeanA.f31509m);
                        crashDetailBeanA.f31509m = str15;
                        C1139k.h("[Native record info] userId: %s", str15);
                        String str16 = (String) c(map, "sysLog", crashDetailBeanA.f31519w);
                        crashDetailBeanA.f31519w = str16;
                        String str17 = (String) c(map, "appVersion", str16);
                        crashDetailBeanA.f31502f = str17;
                        C1139k.h("[Native record info] appVersion: %s", str17);
                        String str18 = map.get("isAppForeground");
                        if (str18 != null) {
                            C1139k.h("[Native record info] isAppForeground: %s", str18);
                            zEqualsIgnoreCase = str18.equalsIgnoreCase("true");
                        } else {
                            zEqualsIgnoreCase = false;
                        }
                        crashDetailBeanA.f31487R = zEqualsIgnoreCase;
                        crashDetailBeanA.f31486Q = j(map);
                        crashDetailBeanA.f31522z = null;
                        crashDetailBeanA.f31507k = true;
                    }
                    return crashDetailBeanA;
                } catch (Throwable th) {
                    C1139k.j("error format", new Object[0]);
                    th.printStackTrace();
                    return null;
                }
            }
            C1139k.j("no intStateStr", new Object[0]);
        }
        return null;
    }

    public static <KeyT, ValueT> ValueT c(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        try {
            ValueT valuet2 = map.get(keyt);
            return valuet2 != null ? valuet2 : valuet;
        } catch (Exception e10) {
            C1139k.e(e10);
            return valuet;
        }
    }

    public static String d(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int i10 = bufferedInputStream.read();
                    if (i10 == -1) {
                        break;
                    }
                    if (i10 == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(i10);
                } catch (Throwable th) {
                    th = th;
                    try {
                        C1139k.e(th);
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb2.append(str2);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static String f(String str, int i10, String str2, boolean z10) throws IOException {
        BufferedReader bufferedReader = null;
        if (str != null && i10 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                C1139k.d("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                f7657a.add(file);
                C1139k.h("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return C1143o.i(new File(str), i10, z10);
                }
                String sb2 = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(line).find()) {
                                    sb2.append(line);
                                    sb2.append("\n");
                                }
                                if (i10 > 0 && sb2.length() > i10) {
                                    if (z10) {
                                        sb2.delete(i10, sb2.length());
                                        break;
                                    }
                                    sb2.delete(0, sb2.length() - i10);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    C1139k.e(th);
                                    sb2.append("\n[error:" + th.toString() + "]");
                                    sb2 = sb2.toString();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                        sb2 = sb2;
                                    }
                                    return sb2;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e10) {
                                            C1139k.e(e10);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String string = sb2.toString();
                        bufferedReader2.close();
                        sb2 = string;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e11) {
                    C1139k.e(e11);
                }
                return sb2;
            }
        }
        return null;
    }

    public static String g(String str, String str2) throws IOException {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        String strL = l(str, str2);
        if (strL != null && !strL.isEmpty()) {
            sb2.append("Register infos:\n");
            sb2.append(strL);
        }
        String strM = m(str, str2);
        if (strM != null && !strM.isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            sb2.append("System SO infos:\n");
            sb2.append(strM);
        }
        return sb2.toString();
    }

    public static Map<String, String> h(Map<String, String> map) {
        String str = map.get("key-value");
        if (str == null) {
            return null;
        }
        HashMap map2 = new HashMap();
        for (String str2 : str.split("\n")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2) {
                map2.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map2;
    }

    public static void i(boolean z10, String str) {
        if (str != null) {
            f7657a.add(new File(str, "rqd_record.eup"));
            f7657a.add(new File(str, "reg_record.txt"));
            f7657a.add(new File(str, "map_record.txt"));
            f7657a.add(new File(str, "backup_record.txt"));
            if (z10) {
                n(str);
            }
        }
        List<File> list = f7657a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : f7657a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                C1139k.h("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    public static long j(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str == null) {
            return -1L;
        }
        C1139k.h("[Native record info] launchTime: %s", str);
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e10) {
            if (C1139k.e(e10)) {
                return -1L;
            }
            e10.printStackTrace();
            return -1L;
        }
    }

    public static String k(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static String l(String str, String str2) throws IOException {
        BufferedReader bufferedReaderA = C1143o.A(str, "reg_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String line = bufferedReaderA.readLine();
            if (line != null && line.startsWith(str2)) {
                int i10 = 18;
                int i11 = 0;
                int length = 0;
                while (true) {
                    String line2 = bufferedReaderA.readLine();
                    if (line2 == null) {
                        sb2.append("\n");
                        String string = sb2.toString();
                        try {
                            return string;
                        } catch (Exception e10) {
                            return string;
                        }
                    }
                    if (i11 % 4 == 0) {
                        if (i11 > 0) {
                            sb2.append("\n");
                        }
                        sb2.append("  ");
                    } else {
                        if (line2.length() > 16) {
                            i10 = 28;
                        }
                        sb2.append("                ".substring(0, i10 - length));
                    }
                    length = line2.length();
                    sb2.append(line2);
                    i11++;
                }
            }
            try {
                bufferedReaderA.close();
            } catch (Exception e11) {
                C1139k.e(e11);
            }
            return null;
        } catch (Throwable th) {
            try {
                C1139k.e(th);
                try {
                    bufferedReaderA.close();
                } catch (Exception e12) {
                    C1139k.e(e12);
                }
                return null;
            } finally {
                try {
                    bufferedReaderA.close();
                } catch (Exception e102) {
                    C1139k.e(e102);
                }
            }
        }
    }

    public static String m(String str, String str2) throws IOException {
        BufferedReader bufferedReaderA = C1143o.A(str, "map_record.txt");
        if (bufferedReaderA == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String line = bufferedReaderA.readLine();
            if (line != null && line.startsWith(str2)) {
                while (true) {
                    String line2 = bufferedReaderA.readLine();
                    if (line2 == null) {
                        String string = sb2.toString();
                        try {
                            return string;
                        } catch (Exception e10) {
                            return string;
                        }
                    }
                    sb2.append("  ");
                    sb2.append(line2);
                    sb2.append("\n");
                }
            }
            try {
                bufferedReaderA.close();
            } catch (Exception e11) {
                C1139k.e(e11);
            }
            return null;
        } catch (Throwable th) {
            try {
                C1139k.e(th);
                try {
                    bufferedReaderA.close();
                } catch (Exception e12) {
                    C1139k.e(e12);
                }
                return null;
            } finally {
                try {
                    bufferedReaderA.close();
                } catch (Exception e102) {
                    C1139k.e(e102);
                }
            }
        }
    }

    public static void n(String str) {
        File[] fileArrListFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        C1139k.h("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            C1139k.e(th);
        }
    }

    public static Map<String, Integer> o(String str) throws NumberFormatException {
        if (str == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (String str2 : str.split(Const.STR_MART_COMMA)) {
                String[] strArrSplit = str2.split(ServerSentEventKt.COLON);
                if (strArrSplit.length != 2) {
                    C1139k.j("error format at %s", str2);
                    return null;
                }
                map.put(strArrSplit[0], Integer.valueOf(Integer.parseInt(strArrSplit[1])));
            }
            return map;
        } catch (Exception e10) {
            C1139k.j("error format intStateStr %s", str);
            e10.printStackTrace();
            return null;
        }
    }
}

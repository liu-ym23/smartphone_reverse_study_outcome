package y2;

import M0.i;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w2.AbstractC2095a;

/* renamed from: y2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2128a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6888a = false;
    public static int b = -1;
    public static final Pattern c = Pattern.compile("^0-([\\d]+)$");

    public static String a() {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            line = bufferedReader.readLine();
            bufferedReader.close();
            i.i(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            i.i(bufferedReader);
            return line;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return true;
        }
        try {
            String str2 = Build.BRAND;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                String str3 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str3)) {
                    return false;
                }
                if (!str3.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(String str) throws IOException {
        int i = -1;
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        bufferedReader2.close();
                        return -1;
                    }
                    Matcher matcher = c.matcher(line);
                    if (matcher.matches()) {
                        try {
                            i = Integer.parseInt(matcher.group(1)) + 1;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused2) {
                    }
                    return i;
                } catch (Throwable unused3) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return -1;
                }
            } catch (Throwable unused4) {
            }
        } catch (IOException unused5) {
        }
    }

    public static boolean d() throws ClassNotFoundException {
        if (!f6888a) {
            try {
                Class.forName("miui.os.Build");
                AbstractC2095a.c = true;
                f6888a = true;
                return true;
            } catch (Exception unused) {
                f6888a = true;
            }
        }
        return AbstractC2095a.c;
    }

    public static int e() throws IOException {
        File[] fileArrListFiles;
        int i = b;
        if (i > 0) {
            return i;
        }
        int iC = c("/sys/devices/system/cpu/possible");
        if (iC <= 0) {
            iC = c("/sys/devices/system/cpu/present");
        }
        if (iC <= 0) {
            try {
                fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new X9.a());
            } catch (Throwable unused) {
            }
            iC = (fileArrListFiles == null || fileArrListFiles.length <= 0) ? -1 : fileArrListFiles.length;
        }
        if (iC <= 0) {
            iC = Runtime.getRuntime().availableProcessors();
        }
        if (iC <= 0) {
            iC = 1;
        }
        b = iC;
        return iC;
    }
}

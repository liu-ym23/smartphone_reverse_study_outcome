package com.zyql.ai.selector.immersive;

import android.os.Build;
import android.text.TextUtils;
import com.zyql.ai.selector.tools.StringUtils;
import com.zyql.ai.selector.tools.ValueOf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes4.dex */
public class RomUtils {
    private static Integer romType;

    public static class AvailableRomType {
        public static final int ANDROID_NATIVE = 3;
        public static final int FLYME = 2;
        public static final int MIUI = 1;
        public static final int NA = 4;
    }

    public static int getFlymeVersion() {
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme")) {
            return 0;
        }
        return StringUtils.stringToInt(str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(" ", "").substring(0, 1));
    }

    public static int getLightStatausBarAvailableRomType() {
        Integer num = romType;
        if (num != null) {
            return num.intValue();
        }
        if (isMIUIV6OrAbove()) {
            Integer num2 = 1;
            romType = num2;
            return num2.intValue();
        }
        if (isFlymeV4OrAbove()) {
            Integer num3 = 2;
            romType = num3;
            return num3.intValue();
        }
        if (isAndroid5OrAbove()) {
            Integer num4 = 3;
            romType = num4;
            return num4.intValue();
        }
        Integer num5 = 4;
        romType = num5;
        return num5.intValue();
    }

    public static int getMIUIVersionCode() throws Throwable {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (!TextUtils.isEmpty(systemProperty)) {
            try {
                return ValueOf.toInt(systemProperty);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return 0;
    }

    public static String getSystemProperty(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                    return line;
                } catch (IOException e10) {
                    e10.printStackTrace();
                    return line;
                }
            } catch (IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean isAndroid5OrAbove() {
        return true;
    }

    private static boolean isFlymeV4OrAbove() {
        return getFlymeVersion() >= 4;
    }

    private static boolean isMIUIV6OrAbove() throws Throwable {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        try {
            return ValueOf.toInt(systemProperty) >= 4;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}

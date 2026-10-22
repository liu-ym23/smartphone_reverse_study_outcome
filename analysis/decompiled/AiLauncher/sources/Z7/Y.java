package Z7;

import android.app.Activity;
import android.app.ActivityThread;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.autonavi.aps.amapapi.config.Const;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class Y {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f7415a = "@buglyAllChannel@".split(Const.STR_MART_COMMA);

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f7416b = "@buglyAllChannelPriority@".split(Const.STR_MART_COMMA);

    public static String a(int i10) {
        FileReader fileReader;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/" + i10 + "/cmdline");
        } catch (Throwable th2) {
            fileReader = null;
            th = th2;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i11 = 0;
            while (i11 < 512 && cArr[i11] != 0) {
                i11++;
            }
            String strSubstring = new String(cArr).substring(0, i11);
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return strSubstring;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!C1139k.e(th)) {
                    th.printStackTrace();
                }
                String strValueOf = String.valueOf(i10);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                return strValueOf;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                    }
                }
            }
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static List<String> c(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                String[] strArrSplit = str.split(Const.STR_MART_COMMA);
                for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                    strArrSplit[i10] = strArrSplit[i10].trim();
                }
                return Arrays.asList(strArrSplit);
            }
            return null;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean d() {
        try {
            Field declaredField = ActivityThread.class.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(ActivityThread.class);
            Field declaredField2 = ActivityThread.class.getDeclaredField("mActivities");
            declaredField2.setAccessible(true);
            for (Map.Entry entry : ((Map) declaredField2.get(obj)).entrySet()) {
                Field declaredField3 = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("activity");
                declaredField3.setAccessible(true);
                Activity activity = (Activity) declaredField3.get(entry.getValue());
                Field declaredField4 = Activity.class.getDeclaredField("mResumed");
                declaredField4.setAccessible(true);
                if (((Boolean) declaredField4.get(activity)).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            C1139k.g(th);
            return true;
        }
    }

    public static PackageInfo e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(b(context), 0);
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String f(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> g(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap map = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                map.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                map.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                map.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                map.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                map.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                map.put("com.tencent.rdm.uuid", obj6.toString());
            }
            Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
            if (obj7 != null) {
                map.put("BUGLY_APP_BUILD_NO", obj7.toString());
            }
            Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
            if (obj8 != null) {
                map.put("BUGLY_AREA", obj8.toString());
            }
            return map;
        } catch (Throwable th) {
            if (!C1139k.e(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}

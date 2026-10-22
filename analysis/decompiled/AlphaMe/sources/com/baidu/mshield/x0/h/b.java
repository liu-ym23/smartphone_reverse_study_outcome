package com.baidu.mshield.x0.h;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mshield.b.e.c;
import com.baidu.mshield.x0.d.d;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class b {

    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f8426a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, String[] strArr) {
            super(looper);
            this.f8426a = strArr;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mInstrumentation");
                declaredField.setAccessible(true);
                this.f8426a[0] = declaredField.get(objInvoke).getClass().getCanonicalName();
                Method declaredMethod = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]);
                declaredMethod.setAccessible(true);
                this.f8426a[1] = declaredMethod.invoke(null, new Object[0]).getClass().getCanonicalName();
            } catch (Throwable th) {
                d.a(th);
            }
            super.handleMessage(message);
        }
    }

    public static String[] a(Context context) {
        String[] strArr = new String[2];
        try {
            if (d.a(context, "plc94", false)) {
                return strArr;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            a aVar = new a(context.getMainLooper(), strArr);
            aVar.sendEmptyMessage(1);
            while (System.currentTimeMillis() - jCurrentTimeMillis < 100) {
                Thread.sleep(10L);
                if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1])) {
                    break;
                }
            }
            aVar.removeCallbacksAndMessages(null);
            com.baidu.mshield.b.c.a.b(" spend time : " + (System.currentTimeMillis() - jCurrentTimeMillis) + "");
            return strArr;
        } catch (Throwable th) {
            d.a(th);
            return strArr;
        }
    }

    public static String b(Context context) {
        try {
            Object objInvoke = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = objInvoke.getClass().getDeclaredField("mPackages");
            boolean z4 = true;
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map == null || map.size() <= 0) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : map.keySet()) {
                String string = obj.toString();
                if (obj.toString().length() > 1 && !string.equals(context.getPackageName()) && !string.endsWith("android.webview") && !string.startsWith("com.baidu.")) {
                    context.getPackageManager().getApplicationInfo(obj.toString(), 0);
                    File file = new File("/data/data/" + obj.toString());
                    if (file.exists() && file.canWrite()) {
                        arrayList.add(obj.toString());
                    }
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!z4) {
                    stringBuffer.append(";");
                }
                stringBuffer.append(str);
                z4 = false;
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String c(Context context) {
        try {
            Class clsC = com.baidu.mshield.b.e.a.c(context);
            if (clsC != null) {
                return clsC.getMethod("getService", String.class).invoke(clsC.newInstance(), "phone").getClass().getCanonicalName();
            }
            return null;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static List<String> d(Context context) {
        try {
            List<String> listA = a(context, d.f());
            if (listA != null && listA.size() > 0) {
                Iterator<String> it = listA.iterator();
                while (it.hasNext()) {
                    com.baidu.mshield.b.c.a.b("vpn app:" + it.next());
                }
            }
            return listA;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static int e(Context context) {
        String strC;
        String[] strArrA;
        int callingUid;
        int length;
        try {
            strC = c(context);
            strArrA = a(context);
            try {
                callingUid = Binder.getCallingUid();
            } catch (Throwable th) {
                d.a(th);
                callingUid = 0;
            }
            length = String.valueOf(callingUid).length();
        } catch (Throwable th2) {
            d.a(th2);
        }
        if (a(strArrA) && a(strC) && length < 6) {
            return 1;
        }
        if (!(a(strArrA) && a(strC)) && length >= 6) {
            return 2;
        }
        if (a(strArrA)) {
            if (a(strC) && length >= 6) {
                return 3;
            }
        }
        return 0;
    }

    public static boolean a(String[] strArr) {
        String str;
        if (strArr == null) {
            return false;
        }
        try {
            str = strArr[0];
        } catch (Throwable th) {
            d.a(th);
        }
        if (str != null && !str.equals("android.app.Instrumentation")) {
            return true;
        }
        String str2 = strArr[1];
        if (str2 != null) {
            if (!str2.equals("android.app.ActivityManagerProxy")) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        try {
        } catch (Throwable th) {
            d.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !"android.os.BinderProxy".equals(str);
    }

    public static List<String> a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                String string = jSONArray.getString(i4);
                if (c.a(context, string, 0) != null) {
                    arrayList.add(string);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }
}

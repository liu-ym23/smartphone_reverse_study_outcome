package com.android.ttcjpaysdk.base.theme;

import android.app.Activity;
import android.app.ActivityOptions;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayTranslucentHelper {

    public static class MyInvocationHandler implements InvocationHandler {
        private TranslucentListener listener;

        public MyInvocationHandler(TranslucentListener r100) {
            this.listener = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        L9:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayTranslucentHelper#invoke", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayTranslucentHelper#invoke", e);
            return null;
        L4:
            if (((Boolean) r102[0]).booleanValue() == false) goto L15;
            TranslucentListener r103 = this.listener;     // Catch: Exception -> L9
            if (r103 == null) goto L16;
            r103.onTranslucent();     // Catch: Exception -> L9
            return null;
        L16:
            return null;
        L15:
            return null;
        }
    }

    public interface TranslucentListener {
        void onTranslucent();
    }

    public CJPayTranslucentHelper() {
    }

    public static boolean cancelTranslucent(Activity r100) {
        if (checkTranslucent(r100) == true) goto L10;
        return false;
    L10:
        Method r101 = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        r101.invoke(r100, new Object[0]);     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTranslucentHelper#cancelTranslucent", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTranslucentHelper#cancelTranslucent", th);
        return false;
    }

    private static boolean checkCancelTranslucent(Activity r100) {
        Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTranslucentHelper#checkCancelTranslucent", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTranslucentHelper#checkCancelTranslucent", th);
        return false;
    }

    private static boolean checkTranslucent(Activity r100) {
        Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);     // Catch: Throwable -> L11
        Class<?>[] r101 = Activity.class.getDeclaredClasses();     // Catch: Throwable -> L11
        int r102 = r101.length;     // Catch: Throwable -> L11
        Class<?> r103 = null;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L9;
        Class<?> r105 = r101[r104];     // Catch: Throwable -> L11
        if (r105.getSimpleName().contains("TranslucentConversionListener") == false) goto L8;
        r103 = r105;
    L8:
        r104 = r104 + 1;     // Catch: Throwable -> L11
        goto L4
    L9:
        Method r106 = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);     // Catch: Throwable -> L11
        r106.setAccessible(true);     // Catch: Throwable -> L11
        r106.invoke(r100, new Object[0]);     // Catch: Throwable -> L11
        Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{r103, ActivityOptions.class});     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTranslucentHelper#checkTranslucent", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTranslucentHelper#checkTranslucent", th);
        return false;
    }

    public static boolean setTranslucent(Activity r100) {
        if (checkCancelTranslucent(r100) == true) goto L16;
        return false;
    L16:
        Class<?>[] r101 = Activity.class.getDeclaredClasses();     // Catch: Throwable -> L13
        int r102 = r101.length;     // Catch: Throwable -> L13
        Class<?> r103 = null;
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L11;
        Class<?> r105 = r101[r104];     // Catch: Throwable -> L13
        if (r105.getSimpleName().contains("TranslucentConversionListener") == false) goto L10;
        r103 = r105;
    L10:
        r104 = r104 + 1;     // Catch: Throwable -> L13
        goto L6
    L11:
        Object r106 = Proxy.newProxyInstance(Activity.class.getClassLoader(), new Class[]{r103}, new MyInvocationHandler(null));     // Catch: Throwable -> L13
        Method r107 = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);     // Catch: Throwable -> L13
        r107.setAccessible(true);     // Catch: Throwable -> L13
        Object r108 = r107.invoke(r100, new Object[0]);     // Catch: Throwable -> L13
        Method r109 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{r103, ActivityOptions.class});     // Catch: Throwable -> L13
        r109.setAccessible(true);     // Catch: Throwable -> L13
        r109.invoke(r100, new Object[]{r106, r108});     // Catch: Throwable -> L13
        return true;
    L13:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayTranslucentHelper#setTranslucent", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayTranslucentHelper#setTranslucent", th);
        return false;
    }
}

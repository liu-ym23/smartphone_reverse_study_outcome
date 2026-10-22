package com.bytedance.apm.agent.wrapper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes14.dex */
public class TTToastWrapper {

    public @interface Duration {
    }

    public static class ProxyTNHandler extends Handler {
        private Method handleHideMethod;
        private Method handleShowMethod;
        private Object tnObject;

        public ProxyTNHandler(Object r100) {
            this.tnObject = r100;
            Method r101 = r100.getClass().getDeclaredMethod("handleShow", new Class[]{IBinder.class});     // Catch: NoSuchMethodException -> L5
            this.handleShowMethod = r101;     // Catch: NoSuchMethodException -> L5
            r101.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r102 = r100.getClass().getDeclaredMethod("handleHide", new Class[0]);     // Catch: NoSuchMethodException -> L5
            this.handleHideMethod = r102;     // Catch: NoSuchMethodException -> L5
            r102.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 == 0) goto L24;
            if (r101 != 1) goto L6;
            Method r102 = this.handleHideMethod;
            if (r102 != null) goto L36;
        L34:
            super.handleMessage(r100);
            return;
        L36:
            r102.invoke(this.tnObject, new Object[0]);     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L22
        L22:
            e = move-exception;
            e.printStackTrace();
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L34
        L6:
            if (r101 != 2) goto L34;
            Method r103 = this.handleHideMethod;
            if (r103 == null) goto L34;
            r103.invoke(this.tnObject, new Object[0]);     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L34
        L24:
            IBinder r104 = (IBinder) r100.obj;
            Method r105 = this.handleShowMethod;
            if (r105 == null) goto L34;
            r105.invoke(this.tnObject, new Object[]{r104});     // Catch: WindowManager.BadTokenException -> L28 InvocationTargetException -> L30 IllegalAccessException -> L32
        L28:
            e = move-exception;
            e.printStackTrace();
        L32:
            e = move-exception;
            e.printStackTrace();
        L30:
            e = move-exception;
            e.printStackTrace();
            goto L34
        }
    }

    public TTToastWrapper() {
    }

    public static boolean initToastHook(Toast r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 != 24) goto L5;
    L6:
        reflectAndoridNTNHandler(r100);
        return true;
    L5:
        if (r101 == 25) goto L6;
        return true;
    }

    private static boolean reflectAndoridNTNHandler(Toast r100) {
    L20:
        e = move-exception;
        e.printStackTrace();
    L24:
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L5:
        if (r100.getClass().getSuperclass() != null) goto L7;
    L9:
        Field r101 = r100.getClass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
    L10:
        if (r101 != null) goto L12;
        return false;
    L12:
        r101.setAccessible(true);     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        Object r102 = r101.get(r100);     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        if (r102 != null) goto L15;
        return false;
    L15:
        Field r103 = r102.getClass().getDeclaredField("mHandler");     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        if (r103 != null) goto L18;
        return false;
    L18:
        r103.setAccessible(true);     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        r103.set(r102, new ProxyTNHandler(r102));     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        return true;
    L7:
        if (Toast.class.getName().equals(r100.getClass().getSuperclass().getName()) == false) goto L9;
        r101 = r100.getClass().getSuperclass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L20 NoSuchFieldException -> L22
        goto L10
    }

    public static Toast makeText(Context r100, int r101, int r102) throws Resources.NotFoundException {
        return makeText(r100, r100.getResources().getText(r101) + "__wrapper", r102);
    }

    public static Toast makeText(Context r100, CharSequence r101, int r102) {
        Toast r103 = Toast.makeText(r100, r101 + "__wrapper", r102);
        initToastHook(r103);
        return r103;
    }
}

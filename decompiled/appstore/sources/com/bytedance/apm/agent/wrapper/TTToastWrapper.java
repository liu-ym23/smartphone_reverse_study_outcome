package com.bytedance.apm.agent.wrapper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.StringRes;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TTToastWrapper {

    public @interface Duration {
    }

    public static class ProxyTNHandler extends Handler {
        private Method handleHideMethod;
        private Method handleShowMethod;
        private Object tnObject;

        public ProxyTNHandler(Object r10) {
            this.tnObject = r10;
            Method r11 = r10.getClass().getDeclaredMethod("handleShow", new Class[]{IBinder.class});     // Catch: NoSuchMethodException -> L5
            this.handleShowMethod = r11;     // Catch: NoSuchMethodException -> L5
            r11.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r12 = r10.getClass().getDeclaredMethod("handleHide", null);     // Catch: NoSuchMethodException -> L5
            this.handleHideMethod = r12;     // Catch: NoSuchMethodException -> L5
            r12.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            if (r11 != 0) goto L5;
            IBinder r12 = (IBinder) r10.obj;
            Method r13 = this.handleShowMethod;
            if (r13 != null) goto L48;
        L42:
            super.handleMessage(r10);
            return;
        L48:
            r13.invoke(this.tnObject, new Object[]{r12});     // Catch: WindowManager.BadTokenException -> L33 InvocationTargetException -> L35 IllegalAccessException -> L37
        L33:
            e = move-exception;
            e.printStackTrace();
        L37:
            e = move-exception;
            e.printStackTrace();
        L35:
            e = move-exception;
            e.printStackTrace();
            goto L42
        L5:
            if (r11 != 1) goto L7;
            Method r14 = this.handleHideMethod;
            if (r14 == null) goto L42;
            r14.invoke(this.tnObject, null);     // Catch: InvocationTargetException -> L23 IllegalAccessException -> L25
        L25:
            e = move-exception;
            e.printStackTrace();
        L23:
            e = move-exception;
            e.printStackTrace();
            goto L42
        L7:
            if (r11 != 2) goto L42;
            Method r15 = this.handleHideMethod;
            if (r15 == null) goto L42;
            r15.invoke(this.tnObject, null);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L15
        L15:
            e = move-exception;
            e.printStackTrace();
        L13:
            e = move-exception;
            e.printStackTrace();
            goto L42
        }
    }

    public TTToastWrapper() {
    }

    public static boolean initToastHook(Toast r10) {
        return true;
    }

    public static Toast makeText(Context r10, CharSequence r11, @Duration int r12) {
        Toast r13 = Toast.makeText(r10, r11 + "__wrapper", r12);
        initToastHook(r13);
        return r13;
    }

    private static boolean reflectAndoridNTNHandler(Toast r10) {
    L9:
        e = move-exception;
        e.printStackTrace();
    L26:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L5:
        if (r10.getClass().getSuperclass() != null) goto L7;
    L13:
        Field r11 = r10.getClass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
    L14:
        if (r11 != null) goto L16;
        return false;
    L16:
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        Object r12 = r11.get(r10);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        if (r12 != null) goto L19;
        return false;
    L19:
        Field r13 = r12.getClass().getDeclaredField("mHandler");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        if (r13 != null) goto L22;
        return false;
    L22:
        r13.setAccessible(true);     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        r13.set(r12, new ProxyTNHandler(r12));     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        return true;
    L7:
        if (Toast.class.getName().equals(r10.getClass().getSuperclass().getName()) == false) goto L13;
        r11 = r10.getClass().getSuperclass().getDeclaredField("mTN");     // Catch: IllegalAccessException -> L9 NoSuchFieldException -> L11
        goto L14
    }

    public static Toast makeText(Context r10, @StringRes int r11, @Duration int r12) throws Resources.NotFoundException {
        return makeText(r10, r10.getResources().getText(r11) + "__wrapper", r12);
    }
}

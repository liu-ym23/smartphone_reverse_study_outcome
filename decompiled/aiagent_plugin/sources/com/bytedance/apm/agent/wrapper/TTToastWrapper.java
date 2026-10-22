package com.bytedance.apm.agent.wrapper;

import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.WindowManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TTToastWrapper {

    private static class ProxyTNHandler extends Handler {
        private Method handleHideMethod;
        private Method handleShowMethod;
        private Object tnObject;

        ProxyTNHandler(Object r7) {
            this.tnObject = r7;
            Method r0 = r7.getClass().getDeclaredMethod("handleShow", new Class[]{IBinder.class});     // Catch: NoSuchMethodException -> L5
            this.handleShowMethod = r0;     // Catch: NoSuchMethodException -> L5
            r0.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            Method r8 = r7.getClass().getDeclaredMethod("handleHide", new Class[0]);     // Catch: NoSuchMethodException -> L5
            this.handleHideMethod = r8;     // Catch: NoSuchMethodException -> L5
            r8.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            int r0 = r6.what;
            if (r0 == 0) goto L24;
            if (r0 != 1) goto L6;
            Method r1 = this.handleHideMethod;
            if (r1 != null) goto L36;
        L34:
            super.handleMessage(r6);
            return;
        L36:
            r1.invoke(this.tnObject, new Object[0]);     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L22
        L22:
            e = move-exception;
            e.printStackTrace();
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L34
        L6:
            if (r0 != 2) goto L34;
            Method r2 = this.handleHideMethod;
            if (r2 == null) goto L34;
            r2.invoke(this.tnObject, new Object[0]);     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14
        L14:
            e = move-exception;
            e.printStackTrace();
        L12:
            e = move-exception;
            e.printStackTrace();
            goto L34
        L24:
            IBinder r3 = (IBinder) ZeusTransformUtils.preCheckCast(r6.obj, IBinder.class, "com.obric.aiagent.plugin");
            Method r4 = this.handleShowMethod;
            if (r4 == null) goto L34;
            r4.invoke(this.tnObject, new Object[]{r3});     // Catch: WindowManager.BadTokenException -> L28 InvocationTargetException -> L30 IllegalAccessException -> L32
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
}

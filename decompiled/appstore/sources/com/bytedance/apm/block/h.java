package com.bytedance.apm.block;

import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static void a() {
        Class<?> r10 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Exception -> L8
        Object r11 = r10.getMethod("getInstance", null).invoke(null, null);     // Catch: Exception -> L8
        Field r12 = r10.getDeclaredField("mRoots");     // Catch: Exception -> L8
        r12.setAccessible(true);     // Catch: Exception -> L8
        ArrayList r13 = (ArrayList) r12.get(r11);     // Catch: Exception -> L8
        Field r14 = Class.forName("android.view.ViewRootImpl").getDeclaredField("mView");     // Catch: Exception -> L8
        r14.setAccessible(true);     // Catch: Exception -> L8
        Field r15 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L8
        r15.setAccessible(true);     // Catch: Exception -> L8
        int r16 = 0;
        Method r17 = g1.d.H(Class.forName("android.graphics.RenderNode"), "output", new Class[0]);     // Catch: Exception -> L8
    L5:
        if (r16 >= r13.size()) goto L14;
        r17.invoke(r15.get(r14.get(r13.get(r16))), null);     // Catch: Exception -> L8
        r16 = r16 + 1;
        goto L5
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}

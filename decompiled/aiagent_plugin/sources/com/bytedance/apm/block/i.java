package com.bytedance.apm.block;

import android.os.Build;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: compiled from: GFXInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a() {
        Class r1 = ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        Object r2 = r1.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L12
        Field r3 = r1.getDeclaredField("mRoots");     // Catch: Exception -> L12
        r3.setAccessible(true);     // Catch: Exception -> L12
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(r3.get(r2), ArrayList.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        Field r5 = ZeusTransformUtils.forName("android.view.ViewRootImpl", "com.obric.aiagent.plugin").getDeclaredField("mView");     // Catch: Exception -> L12
        r5.setAccessible(true);     // Catch: Exception -> L12
        Field r6 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L12
        r6.setAccessible(true);     // Catch: Exception -> L12
        if (Build.VERSION.SDK_INT <= 28) goto L6;
        Class r0 = ZeusTransformUtils.forName("android.graphics.RenderNode", "com.obric.aiagent.plugin");     // Catch: Exception -> L12
    L7:
        Method r7 = com.bytedance.apm.block.trace.f.a(r0, "output", new Class[0]);     // Catch: Exception -> L12
        int r8 = 0;
    L8:
        if (r8 >= r4.size()) goto L18;
        r7.invoke(r6.get(r5.get(r4.get(r8))), new Object[0]);     // Catch: Exception -> L12
        r8 = r8 + 1;
        goto L8
    L18:
        return;
    L6:
        r0 = ZeusTransformUtils.forName("android.view.RenderNode", "com.obric.aiagent.plugin");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}

package com.bytedance.apm.block;

import android.os.Build;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class h {
    public static void b() {
        Class r100 = a("android.view.WindowManagerGlobal");     // Catch: Exception -> L11
        Object r101 = r100.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
        Field r102 = r100.getDeclaredField("mRoots");     // Catch: Exception -> L11
        r102.setAccessible(true);     // Catch: Exception -> L11
        ArrayList r103 = (ArrayList) r102.get(r101);     // Catch: Exception -> L11
        Field r104 = a("android.view.ViewRootImpl").getDeclaredField("mView");     // Catch: Exception -> L11
        r104.setAccessible(true);     // Catch: Exception -> L11
        Field r105 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L11
        r105.setAccessible(true);     // Catch: Exception -> L11
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        Class r106 = a("android.graphics.RenderNode");     // Catch: Exception -> L11
    L6:
        Method r107 = es3.h.h(r106, new Class[0]);     // Catch: Exception -> L11
        int r108 = 0;
    L7:
        if (r108 >= r103.size()) goto L17;
        r107.invoke(r105.get(r104.get(ListProtector.get(r103, r108))), new Object[0]);     // Catch: Exception -> L11
        r108 = r108 + 1;
        goto L7
    L17:
        return;
    L5:
        r106 = a("android.view.RenderNode");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}

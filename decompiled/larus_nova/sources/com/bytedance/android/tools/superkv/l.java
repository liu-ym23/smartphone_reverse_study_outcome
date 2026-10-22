package com.bytedance.android.tools.superkv;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.controller.Global;
import java.nio.MappedByteBuffer;
import java.security.PrivilegedAction;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements PrivilegedAction<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MappedByteBuffer f187650a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("sun.misc.Cleaner");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("sun.misc.Cleaner");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("sun.misc.Cleaner");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("sun.misc.Cleaner");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("sun.misc.Cleaner");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("sun.misc.Cleaner");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("sun.misc.Cleaner");
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
    L13:
        e = move-exception;
        b.b("Unable to unmap MappedByteBuffer! API: " + Build.VERSION.SDK_INT, e);
        return null;
    L3:
        if (m.f187653c != null) goto L6;
        m.f187653c = this.f187650a.getClass().getMethod("cleaner", new Class[0]);     // Catch: Exception -> L13
    L6:
        if (m.f187654d != null) goto L9;
        m.f187654d = a();     // Catch: Exception -> L13
    L9:
        if (m.f187655e != null) goto L11;
        m.f187655e = m.f187654d.getMethod(Global.RECORDING_TYPE_CLEAN, new Class[0]);     // Catch: Exception -> L13
    L11:
        m.f187653c.setAccessible(true);     // Catch: Exception -> L13
        m.f187655e.setAccessible(true);     // Catch: Exception -> L13
        m.f187655e.invoke(m.f187653c.invoke(this.f187650a, new Object[0]), new Object[0]);     // Catch: Exception -> L13
        return null;
    }

    public l(MappedByteBuffer r100) {
        this.f187650a = r100;
    }
}

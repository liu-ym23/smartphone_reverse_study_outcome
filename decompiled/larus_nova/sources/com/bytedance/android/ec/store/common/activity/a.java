package com.bytedance.android.ec.store.common.activity;

import android.content.Intent;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import hm.c;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements b {
    public a() {
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

    public final void b(Intent r100, Intent r101, String r102) {
        String r103 = r100.getStringExtra(r102);
        if (r101 == null) goto L5;
        String r104 = r101.getStringExtra(r102);
    L6:
        if (r103 != null) goto L9;
        if (r104 != null) goto L9;
    L18:
        r103 = null;
    L19:
        if (r103 == null) goto L23;
        if (r101 == null) goto L24;
        r101.putExtra(r102, r103);
        return;
    L24:
        return;
    L23:
        return;
    L9:
        if (r103 != null) goto L11;
        r103 = r104;
        goto L19
    L11:
        if (r104 == null) goto L19;
        JSONObject r105 = k.w(r103);
        JSONObject r106 = k.w(r104);
        if (r106 == null) goto L16;
        c.b(r106, r105, false);
    L16:
        if (r106 == null) goto L18;
        r103 = r106.toString();
        goto L19
    L5:
        r104 = null;
        goto L6
    }
}

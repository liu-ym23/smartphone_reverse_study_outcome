package com.bytedance.android.livesdk.chatroom.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes8.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f114442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f114443b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.samsung.android.feature.SemFloatingFeature");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.samsung.android.feature.SemFloatingFeature");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.samsung.android.feature.SemFloatingFeature");
    }

    @JvmStatic
    public static final boolean b() {
        if (f114443b == true) goto L5;
        boolean r100 = false;
        if (Intrinsics.areEqual(Build.BRAND, SmEditTextLeakOpt.SAMSUNG) == true) goto L20;
    L18:
        f114442a = r100;
        f114443b = true;
        return f114442a;
    L20:
        Class r101 = a();     // Catch: Exception -> L11
        Object r102 = r101.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
        String r103 = (String) r101.getDeclaredMethod("getString", new Class[]{String.class}).invoke(r102, new Object[]{"SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_MULTI_FOLD"});     // Catch: Exception -> L11
    L13:
        if (r103 != null) goto L15;
    L16:
        r103 = "unknown";
    L17:
        r100 = Intrinsics.areEqual(r103, "TRUE");
        goto L18
    L15:
        if (TextUtils.isEmpty(r103) == false) goto L17;
    L11:
        e = move-exception;
        e.printStackTrace();
        r103 = "";
        goto L13
    L5:
        return f114442a;
    }

    @JvmStatic
    public static final boolean c() {
        if (Intrinsics.areEqual(Build.BRAND, SmEditTextLeakOpt.SAMSUNG) == false) goto L22;
        Resources r100 = com.bytedance.android.live.core.utils.s1.getResources();
        if (r100 == null) goto L7;
        Configuration r101 = r100.getConfiguration();
    L8:
        int r102 = -1;
        if (r101 != null) goto L21;
    L18:
        if (r102 != 0) goto L23;
        return true;
    L23:
        return false;
    L21:
        Field r103 = r101.getClass().getDeclaredField("semDisplayDeviceType");     // Catch: Exception -> L16
        r103.setAccessible(true);     // Catch: Exception -> L16
        Object r104 = r103.get(r101);     // Catch: Exception -> L16
        if (r104 == null) goto L15;
        r102 = ((Integer) r104).intValue();     // Catch: Exception -> L16
        goto L18
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L7:
        r101 = null;
        goto L8
    L22:
        return false;
    }

    static {
    }
}

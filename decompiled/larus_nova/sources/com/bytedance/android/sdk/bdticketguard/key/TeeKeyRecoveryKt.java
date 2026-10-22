package com.bytedance.android.sdk.bdticketguard.key;

import android.os.Build;
import com.bytedance.android.sdk.bdticketguard.r0;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class TeeKeyRecoveryKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163837a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f163838b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f163839c = null;

    static {
        f163837a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinPackage(TeeKeyRecoveryKt.class, "bd_ticket_guard_core_release"), CloudControlInf.SP, "getSp()Landroid/content/SharedPreferences;"))};
        f163838b = LazyKt.lazy(TeeKeyRecoveryKt$sp$2.INSTANCE);
        f163839c = new AtomicBoolean(false);
    }

    public static final int c() {
        boolean r100 = false;
        if (Build.VERSION.SDK_INT >= 31) goto L5;
        boolean r101 = true;
    L6:
        Class r102 = null;
        Class r103 = a("android.security.keystore2.AndroidKeyStoreProvider");     // Catch: Throwable -> L9
    L10:
        if (r103 == null) goto L12;
        boolean r104 = true;
    L31:
        r102 = a("android.security.keystore.AndroidKeyStoreProvider");     // Catch: Throwable -> L28
    L15:
        if (r102 == null) goto L17;
        boolean r105 = true;
    L18:
        if (r101 == false) goto L22;
        if (r104 == true) goto L22;
        if (r105 == false) goto L22;
        r100 = true;
    L22:
        if (r100 == true) goto L34;
        if (r104 == false) goto L26;
        return 2;
    L26:
        return -1;
    L34:
        return 1;
    L17:
        r105 = false;
        goto L18
    L12:
        r104 = false;
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = false;
        goto L6
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

    public static final void d(String r100) {
        if (f163839c.compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        Flipped.invokeHiddenApiRestrictions();     // Catch: Throwable -> L7
        int r101 = r0.f163979a;     // Catch: Throwable -> L7
        r0.c("TeeKeyRecovery", "Flipped initialized (" + r100 + ')');     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        int r103 = r0.f163979a;
        r0.d(6, "TeeKeyRecovery", "Failed to init Flipped (" + r100 + ')', th);
        Unit r104 = Unit.INSTANCE;
    }

    public static final Object b(Object r100, Class r101, String r102) {
        Field r103 = r101.getDeclaredField(r102);     // Catch: NoSuchFieldException -> L4
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return r103.get(r100);
    L4:
        e = move-exception;
        int r104 = r0.f163979a;
        r0.d(5, "TeeKeyRecovery", "Field " + r102 + " not found in " + r101.getName(), e);
        return null;
    }
}

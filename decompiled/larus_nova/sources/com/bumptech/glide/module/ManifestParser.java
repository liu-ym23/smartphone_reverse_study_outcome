package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public List<GlideModule> parse() {
        GlideLogUtil.d(TAG, "Loading Glide modules");
        ArrayList r100 = new ArrayList();
        ApplicationInfo r101 = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r101.metaData != null) goto L7;
        GlideLogUtil.d(TAG, "Got null app info metadata");     // Catch: PackageManager.NameNotFoundException -> L16
        return r100;
    L7:
        GlideLogUtil.v(TAG, "Got app info metadata: " + r101.metaData);     // Catch: PackageManager.NameNotFoundException -> L16
        Iterator<String> r102 = r101.metaData.keySet().iterator();     // Catch: PackageManager.NameNotFoundException -> L16
    L9:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();     // Catch: PackageManager.NameNotFoundException -> L16
        if (GLIDE_MODULE_VALUE.equals(r101.metaData.get(r103)) == false) goto L9;
        r100.add(parseModule(r103));     // Catch: PackageManager.NameNotFoundException -> L16
        GlideLogUtil.d(TAG, "Loaded Glide module: " + r103);     // Catch: PackageManager.NameNotFoundException -> L16
        goto L9
    L14:
        GlideLogUtil.i(TAG, "Finished loading Glide modules");
        return r100;
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
    }

    public ManifestParser(Context r100) {
        this.context = r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bumptech_glide_module_ManifestParser_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    private static GlideModule parseModule(String r100) {
        Class r101 = INVOKESTATIC_com_bumptech_glide_module_ManifestParser_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: ClassNotFoundException -> L21
        Object r102 = r101.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: InvocationTargetException -> L6 NoSuchMethodException -> L8 IllegalAccessException -> L10 InstantiationException -> L12
    L16:
        if ((r102 instanceof GlideModule) == false) goto L20;
        return (GlideModule) r102;
    L20:
        throw new RuntimeException("Expected instanceof GlideModule, but found: " + r102);
    L10:
        e = move-exception;
        throwInstantiateGlideModuleException(r101, e);
    L14:
        r102 = null;
    L12:
        e = move-exception;
        throwInstantiateGlideModuleException(r101, e);
    L8:
        e = move-exception;
        throwInstantiateGlideModuleException(r101, e);
    L6:
        e = move-exception;
        throwInstantiateGlideModuleException(r101, e);
    L21:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find GlideModule implementation", e);
    }

    private static void throwInstantiateGlideModuleException(Class<?> r100, Exception r101) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + r100, r101);
    }
}

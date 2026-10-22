package com.bytedance.android.shopping.store.arch;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Boolean f183492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f183493b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f183494c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f183495d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f183496e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f183497f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f183498g = null;

    public a() {
    }

    static {
        f183498g = new a();
        f183493b = SetsKt.setOf(new String[]{"HWTAH", "HWTAH-C", "unknownRLI", "unknownRHA", "unknownTXL"});
        f183494c = SetsKt.setOf(new String[]{"TAH-AN00", "TAH-N29", "TAH-AN00m", "TAH-N29m", "RLI-AN00", "RLI-N29", "RHA-AN00m", "RHA-N29m"});
        f183495d = SetsKt.setOf(new String[]{"DIA-AN00", "MGI-AN00"});
        f183496e = SetsKt.setOf(new String[]{"OP4E75L1", "OP55F1L1"});
        f183497f = SetsKt.setOf("M2011J18C");
    }

    public static boolean b() {
        if (f183496e.contains(Build.DEVICE) == false) goto L5;
        return true;
    L5:
        Class r100 = a("com.oplus.content.OplusFeatureConfigManager");
        Object r101 = null;
        Object r102 = r100.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        Object r103 = r100.getDeclaredMethod("hasFeature", new Class[]{String.class}).invoke(r102, new Object[]{"oplus.hardware.type.fold"});
        if ((r103 instanceof Boolean) == false) goto L10;
        r101 = r103;
    L10:
        return Intrinsics.areEqual((Boolean) r101, Boolean.TRUE);
    }

    public static boolean c() {
        String r100 = Build.MODEL;
        String r101 = null;
        if (StringsKt.startsWith$default(r100, "SM-F9", false, 2, null) == false) goto L5;
    L12:
        return true;
    L5:
        if (StringsKt.startsWith$default(r100, "SM-W202", false, 2, null) == true) goto L12;
        Class r102 = a("com.samsung.android.feature.SemFloatingFeature");
        Object r103 = r102.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        Object r104 = r102.getDeclaredMethod("getString", new Class[]{String.class}).invoke(r103, new Object[]{"SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"});
        if (r104 == null) goto L11;
        r101 = r104.toString();
    L11:
        return StringsKt.equals(r101, "true", true);
    }

    public static boolean d() {
        if (f183497f.contains(Build.MODEL) == false) goto L5;
        return true;
    L5:
        Class r100 = a("android.os.SystemProperties");
        return Intrinsics.areEqual(r100.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r100, new Object[]{"persist.sys.muiltdisplay_type", 0}), 2);
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

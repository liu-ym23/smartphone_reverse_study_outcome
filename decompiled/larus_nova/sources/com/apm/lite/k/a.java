package com.apm.lite.k;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f29987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f29988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f29989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f29990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f29991e;

    public static long b(int r100) {
        if (r100 >= 0) goto L6;
        return 0;
    L6:
        return ((long) r100) * 1024;
    }

    public static void c(Context r100, JSONObject r101) {
        d(r101);     // Catch: Throwable -> L7
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L7
        if (r102 == null) goto L5;
        g(r101, r102);     // Catch: Throwable -> L7
    L5:
        e(r101, r102);     // Catch: Throwable -> L7
        return;
    }

    public static void e(JSONObject r110, ActivityManager r111) {
        JSONObject r100 = new JSONObject();
        boolean r101 = true;
        if (Debug.getNativeHeapAllocatedSize() <= 209715200) goto L5;
        boolean r102 = true;
    L6:
        k1.a.g(r110, "filters", "native_heap_leak", String.valueOf(r102));
        r100.put("native_heap_size", Debug.getNativeHeapSize());
        r100.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
        r100.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
        Runtime r103 = Runtime.getRuntime();
        long r104 = r103.maxMemory();
        long r105 = r103.freeMemory();
        long r106 = r103.totalMemory();
        r100.put("max_memory", r104);
        r100.put("free_memory", r105);
        r100.put("total_memory", r106);
        if ((r106 - r105) > (r104 * 0.95f)) goto L10;
        r101 = false;
    L10:
        k1.a.g(r110, "filters", "java_heap_leak", String.valueOf(r101));
        if (r111 == null) goto L13;
        r100.put("memory_class", r111.getMemoryClass());
        r100.put("large_memory_class", r111.getLargeMemoryClass());
    L13:
        r110.put("app_memory_info", r100);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static boolean h(Context r100) {
        String r101 = i();
        if (r101 == null) goto L8;
        if (r101.contains(":") == false) goto L8;
        return false;
    L8:
        if (r101 != null) goto L10;
    L12:
        if (r101 != null) goto L14;
        return false;
    L14:
        if (r101.equals(r100.getApplicationInfo().processName) == false) goto L18;
        return true;
    L18:
        return false;
    L10:
        if (r101.equals(r100.getPackageName()) == false) goto L12;
        return true;
    }

    public static Class<?> j(Context r100) {
        if (f29988b != null) goto L9;
        if (f29991e == true) goto L9;
        f29988b = a(r100.getPackageName() + ".BuildConfig");     // Catch: ClassNotFoundException -> L10
    L7:
        f29991e = true;
    L9:
        return f29988b;
    }

    public static String i() {
        if (TextUtils.isEmpty(f29987a) == false) goto L5;
        BufferedReader r100 = null;
        String r101 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L41;
    L12:
        String r102 = null;
    L13:
        f29987a = r102;
        if (TextUtils.isEmpty(r102) == false) goto L16;
    L23:
        th = move-exception;
        th.printStackTrace();
        String r103 = null;
    L25:
        f29987a = r103;
        if (TextUtils.isEmpty(r103) == true) goto L47;
        return f29987a;
    L47:
        BufferedReader r104 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L37
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L40
    L32:
        int r106 = r104.read();     // Catch: Throwable -> L40
        if (r106 <= 0) goto L35;
        r105.append((char) r106);     // Catch: Throwable -> L40
        goto L32
    L35:
        r101 = r105.toString();     // Catch: Throwable -> L40
    L36:
        String r107 = r101;
        r100 = r104;
    L38:
        j.a(r100);
        f29987a = r107;
        return r107;
    L37:
        r107 = null;
        goto L38
    L45:
        Object r108 = m1.a.b(m1.a.a("android.app.ActivityThread"), "currentProcessName", new Object[0]);     // Catch: Exception -> L20 Throwable -> L23
    L21:
        r103 = (String) r108;     // Catch: Throwable -> L23
        goto L25
    L20:
        r108 = null;
        goto L21
    L16:
        return f29987a;
    L41:
        r102 = Application.getProcessName();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    L5:
        return f29987a;
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

    public static void d(JSONObject r100) {
        Debug.MemoryInfo r101 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r101);
        JSONObject r102 = new JSONObject();
        r102.put("dalvikPrivateDirty", b(r101.dalvikPrivateDirty));
        r102.put("dalvikPss", b(r101.dalvikPss));
        r102.put("dalvikSharedDirty", b(r101.dalvikSharedDirty));
        r102.put("nativePrivateDirty", b(r101.nativePrivateDirty));
        r102.put("nativePss", b(r101.nativePss));
        r102.put("nativeSharedDirty", b(r101.nativeSharedDirty));
        r102.put("otherPrivateDirty", b(r101.otherPrivateDirty));
        r102.put("otherPss", b(r101.otherPss));
        r102.put("otherSharedDirty", r101.otherSharedDirty);
        if (Build.VERSION.SDK_INT >= 23) goto L10;
    L7:
        int r103 = c.f29993a;
        r102.put("totalPrivateClean", r101.getTotalPrivateClean());
        r102.put("totalPrivateDirty", r101.getTotalPrivateDirty());
        r102.put("totalPss", b(r101.getTotalPss()));
        r102.put("totalSharedClean", r101.getTotalSharedClean());
        r102.put("totalSharedDirty", b(r101.getTotalSharedDirty()));
        r102.put("totalSwappablePss", b(r101.getTotalSwappablePss()));
        r100.put("memory_info", r102);
        return;
    L10:
        String r104 = r101.getMemoryStat("summary.graphics");     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(r104) == true) goto L7;
        r102.put("summary.graphics", b(CastIntegerProtector.parseInt(r104)));     // Catch: Throwable -> L9
        goto L7
    }

    public static boolean f(Context r100) {
        if (r100 != null) goto L6;
        return s1.c.c().f540097p;
    L6:
        if (s1.c.c().f540097p == true) goto L28;
        String r101 = r100.getPackageName();
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L25
        if (r102 == null) goto L20;
        List<ActivityManager.RunningTaskInfo> r103 = r102.getRunningTasks(1);     // Catch: Throwable -> L25
        if (r103 == null) goto L20;
        if (r103.isEmpty() == true) goto L20;
        ComponentName r104 = ((ActivityManager.RunningTaskInfo) ListProtector.get(r103, 0)).topActivity;     // Catch: Throwable -> L25
        if (r104 == null) goto L20;
        if (r101.equals(r104.getPackageName()) == false) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L29;
        return false;
    L29:
        return true;
    L20:
        r105 = false;
        goto L21
    L28:
        return true;
    }

    public static void g(JSONObject r100, ActivityManager r101) {
        JSONObject r102 = new JSONObject();
        ActivityManager.MemoryInfo r103 = new ActivityManager.MemoryInfo();
        r101.getMemoryInfo(r103);
        r102.put("availMem", r103.availMem);
        r102.put("lowMemory", r103.lowMemory);
        r102.put("threshold", r103.threshold);
        int r104 = l.f30002a;
        r102.put("totalMem", r103.totalMem);
        r100.put("sys_memory_info", r102);
    }
}

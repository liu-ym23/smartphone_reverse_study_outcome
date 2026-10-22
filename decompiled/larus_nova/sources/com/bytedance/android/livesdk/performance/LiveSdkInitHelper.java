package com.bytedance.android.livesdk.performance;

import android.app.Application;
import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public class LiveSdkInitHelper {
    private static boolean isEnableEnterRoomOpt;
    private static boolean isEnableLauncherOpt;
    private static boolean isEnableServiceOpt;
    private static boolean isEnableSettingOpt;
    private static final Executor liveExecutor = null;
    private static CountDownLatch liveFeedProtoDecodersLock;

    public LiveSdkInitHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static Application getApplicationUsingReflection() {
        return (Application) INVOKESTATIC_com_bytedance_android_livesdk_performance_LiveSdkInitHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    L5:
        return null;
    }

    static {
        liveExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("LiveSdkInitHelper"));
    }

    public static Context getContext() {
        if (jc1.a.b() != null) goto L7;
        return getApplicationUsingReflection();
    L7:
        return jc1.a.b();
    }

    public static Executor getLiveExecutor() {
        return liveExecutor;
    }

    public static CountDownLatch getLiveFeedProtoDecodersLock() {
        return liveFeedProtoDecodersLock;
    }

    public static boolean isEnableEnterRoomOpt() {
        return isEnableEnterRoomOpt;
    }

    public static boolean isEnableLauncherOpt() {
        return isEnableLauncherOpt;
    }

    public static boolean isEnableServiceOpt() {
        return isEnableServiceOpt;
    }

    public static boolean isEnableSettingOpt() {
        return isEnableSettingOpt;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdk_performance_LiveSdkInitHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static void setEnableEnterRoomOpt(boolean r100) {
        isEnableEnterRoomOpt = r100;
    }

    public static void setEnableLauncherOpt(boolean r100) {
        isEnableLauncherOpt = r100;
    }

    public static void setEnableServiceOpt(boolean r100) {
        isEnableServiceOpt = r100;
    }

    public static void setEnableSettingOpt(boolean r100) {
        isEnableSettingOpt = r100;
    }

    public static void setLiveFeedProtoDecodersLock(CountDownLatch r100) {
        liveFeedProtoDecodersLock = r100;
    }
}

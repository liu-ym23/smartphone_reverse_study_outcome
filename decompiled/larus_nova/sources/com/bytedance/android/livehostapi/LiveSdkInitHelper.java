package com.bytedance.android.livehostapi;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.core.setting.n3;
import com.bytedance.android.livesdk.config.al0;
import com.bytedance.android.livesdk.config.zk0;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import jc1.a;
import jc1.e;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public class LiveSdkInitHelper {
    public static final String LIVE_SDK_INIT_DURATION_OPT = "live_sdk_init_duration_opt_v2";
    private static final String TAG = "LiveSdkInitHelper";
    private static final Method enableInitFeedOpt = null;
    private static final Method enableInitLauncherOpt = null;
    private static final Method enableInitServiceOpt = null;
    private static final Method enableInitSettingOpt = null;
    private static volatile Boolean feedOpt;
    private static volatile Boolean injectWithServiceInit;
    private static volatile Boolean launcherOpt;
    private static volatile Boolean optGetSwitch;
    private static volatile Boolean readSettingOpt;
    private static volatile Boolean serviceOpt;
    private static volatile Boolean settingOpt;

    public LiveSdkInitHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static Application getApplicationUsingReflection() {
        return (Application) INVOKESTATIC_com_bytedance_android_livehostapi_LiveSdkInitHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
    L5:
        return null;
    }

    private static Class<?> getLiveInitSettingKeys() {
        int r100 = e.f498076a;     // Catch: Throwable -> L4
        return INVOKESTATIC_com_bytedance_android_livehostapi_LiveSdkInitHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.livesdk.config.LiveInitSettingKeys");
    L4:
        return null;
    }

    private static boolean isEnableFeedOptInner() {
        Method r100 = enableInitFeedOpt;
        if (r100 != null) goto L8;
    L6:
        return false;
    L8:
        return ((Boolean) r100.invoke(null, new Object[0])).booleanValue();
    }

    private static boolean isEnableLauncherOptInner() {
        Method r100 = enableInitLauncherOpt;
        if (r100 != null) goto L8;
    L6:
        return false;
    L8:
        return ((Boolean) r100.invoke(null, new Object[0])).booleanValue();
    }

    private static boolean isEnableServiceOptInner() {
        Method r100 = enableInitServiceOpt;
        if (r100 != null) goto L8;
    L6:
        return false;
    L8:
        return ((Boolean) r100.invoke(null, new Object[0])).booleanValue();
    }

    private static boolean isEnableSettingOptInner() {
        Method r100 = enableInitSettingOpt;
        if (r100 != null) goto L8;
    L6:
        return false;
    L8:
        return ((Boolean) r100.invoke(null, new Object[0])).booleanValue();
    }

    public static boolean isInjectWithServiceInit() {
        Boolean r100 = readSettingOpt;
        if (r100 != null) goto L6;
        r100 = al0.f119802a.getValue();
        readSettingOpt = r100;
        injectWithServiceInit = zk0.f121773a.getValue();
    L6:
        if (r100.booleanValue() == true) goto L8;
    L10:
        return false;
    L8:
        if (injectWithServiceInit.booleanValue() == false) goto L10;
        return true;
    }

    private static boolean isOptGetSwitch() {
        Boolean r100 = optGetSwitch;
        if (r100 != null) goto L6;
        r100 = n3.f65366a.getValue();
        optGetSwitch = r100;
    L6:
        return r100.booleanValue();
    }

    static {
        Class<?> r100 = getLiveInitSettingKeys();
        enableInitSettingOpt = getMethod(r100, "enableInitSettingOpt");
        enableInitLauncherOpt = getMethod(r100, "enableInitLauncherOpt");
        enableInitServiceOpt = getMethod(r100, "enableInitServiceOpt");
        enableInitFeedOpt = getMethod(r100, "enableInitFeedOpt");
    }

    public static Context getContext() {
        if (a.b() != null) goto L7;
        return getApplicationUsingReflection();
    L7:
        return a.b();
    }

    public static boolean isEnableFeedOpt() {
        if (isOptGetSwitch() == false) goto L10;
        Boolean r100 = feedOpt;
        if (r100 != null) goto L8;
        r100 = Boolean.valueOf(isEnableFeedOptInner());
        feedOpt = r100;
    L8:
        return r100.booleanValue();
    L10:
        return isEnableFeedOptInner();
    }

    public static boolean isEnableLauncherOpt() {
        if (isOptGetSwitch() == false) goto L10;
        Boolean r100 = launcherOpt;
        if (r100 != null) goto L8;
        r100 = Boolean.valueOf(isEnableLauncherOptInner());
        launcherOpt = r100;
    L8:
        return r100.booleanValue();
    L10:
        return isEnableLauncherOptInner();
    }

    public static boolean isEnableServiceOpt() {
        if (isOptGetSwitch() == false) goto L10;
        Boolean r100 = serviceOpt;
        if (r100 != null) goto L8;
        r100 = Boolean.valueOf(isEnableServiceOptInner());
        serviceOpt = r100;
    L8:
        return r100.booleanValue();
    L10:
        return isEnableServiceOptInner();
    }

    public static boolean isEnableSettingOpt() {
        if (isOptGetSwitch() == false) goto L10;
        Boolean r100 = settingOpt;
        if (r100 != null) goto L8;
        r100 = Boolean.valueOf(isEnableSettingOptInner());
        settingOpt = r100;
    L8:
        return r100.booleanValue();
    L10:
        return isEnableSettingOptInner();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livehostapi_LiveSdkInitHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static Method getMethod(Class<?> r100, String r101) {
        if (r100 != null) goto L9;
        return null;
    L9:
        Method r102 = r100.getDeclaredMethod(r101, new Class[0]);     // Catch: Throwable -> L8
        r102.setAccessible(true);     // Catch: Throwable -> L8
        return r102;
    L8:
        return null;
    }
}

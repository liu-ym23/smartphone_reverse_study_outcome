package com.ss.android.ugc.aweme.framework.services.plugin;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.agilelogger.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.t;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PluginInstaller.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PluginInstaller {
    private static final String GEN_CLASS_NAME = "SpiPluginBinder";
    public static final PluginInstaller INSTANCE = null;
    private static final String TAG = "SPIPluginInstaller";

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    static {
        INSTANCE = new PluginInstaller();
    }

    private PluginInstaller() {
    }

    public final boolean onPluginInstall(String r5) {
        o.d(r5, "pluginPackageName");
        Class r2 = ZeusTransformUtils.forName(r5 + ".SpiPluginBinder", "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        Object r3 = r2.newInstance();     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        ((IPluginBinder) ZeusTransformUtils.preCheckCast(r3, IPluginBinder.class, "com.obric.aiagent.plugin")).bindPluginSpi();     // Catch: Throwable -> L12
        goto L10
    L9:
        throw new t("null cannot be cast to non-null type com.ss.android.ugc.aweme.framework.services.plugin.IPluginBinder");     // Catch: Throwable -> L12
    L10:
        logD("Install service for " + r5 + " success");
        return true;
    L12:
        th = move-exception;
        th.printStackTrace();
        logD("Install service for " + r5 + " failed with " + th + " \n classLoader -> " + getClass().getClassLoader());
        return false;
    }

    private final void logD(String r1) {
        a.b(TAG, r1);
        INVOKESTATIC_com_ss_android_ugc_aweme_framework_services_plugin_PluginInstaller_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_ss_android_ugc_aweme_framework_services_plugin_PluginInstaller_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}

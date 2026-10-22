package com.ss.android.ugc.aweme.framework.services.plugin;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PluginInstaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/plugin/PluginInstaller;", "", "()V", "GEN_CLASS_NAME", "", "TAG", "logD", "", NotificationCompat.CATEGORY_MESSAGE, "onPluginInstall", "", "pluginPackageName", "spi_release"}, k = 1, mv = {1, 1, 15})
public final class PluginInstaller {
    private static final String GEN_CLASS_NAME = "SpiPluginBinder";
    public static final PluginInstaller INSTANCE = null;
    private static final String TAG = "SPIPluginInstaller";

    static {
        INSTANCE = new PluginInstaller();
    }

    private PluginInstaller() {
    }

    public final boolean onPluginInstall(String r4) {
        Intrinsics.checkParameterIsNotNull(r4, "pluginPackageName");
        Class<?> r1 = Class.forName(r4 + ".SpiPluginBinder");     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Object r2 = r1.newInstance();     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        ((IPluginBinder) r2).bindPluginSpi();     // Catch: Throwable -> L12
        goto L10
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.ss.android.ugc.aweme.framework.services.plugin.IPluginBinder");     // Catch: Throwable -> L12
    L10:
        logD("Install service for " + r4 + " success");
        return true;
    L12:
        th = move-exception;
        th.printStackTrace();
        logD("Install service for " + r4 + " failed with " + th + " \n classLoader -> " + getClass().getClassLoader());
        return false;
    }

    private final void logD(String r1) {
        ALog.d(TAG, r1);
        Log.d(TAG, r1);
    }
}

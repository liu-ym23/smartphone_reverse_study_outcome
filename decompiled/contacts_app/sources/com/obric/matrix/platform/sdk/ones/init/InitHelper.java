package com.obric.matrix.platform.sdk.ones.init;

import android.app.Application;
import android.content.pm.PackageManager;
import com.GlobalProxyLancet;
import com.obric.matrix.platform.sdk.ones.crash.MatrixCrashConfigBuilder;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsConfig;
import com.obric.matrix.platform.sdk.ones.settings.MatrixSettingsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/init/InitHelper;", "", "()V", "TAG", "", "getVersionCode", "", "application", "Landroid/app/Application;", "getVersionName", "initCrashProtect", "", "initSettingsAndCrashProtect", "isBoolean", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InitHelper {
    public static final InitHelper INSTANCE = null;
    public static final String TAG = "InitHelper";

    static {
        INSTANCE = new InitHelper();
    }

    private InitHelper() {
    }

    private final int getVersionCode(Application r3) {
        return r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionCode;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to get version code", e);
        return 0;
    }

    private final String getVersionName(Application r3) {
        String r4 = r3.getPackageManager().getPackageInfo(r3.getPackageName(), 0).versionName;     // Catch: PackageManager.NameNotFoundException -> L7
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to get version name", e);
        return "";
    }

    public final void initSettingsAndCrashProtect(Application r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "application");
        if (MatrixSettingsManager.Companion.isInited() == true) goto L5;
        MatrixSettingsConfig.Builder r0 = new MatrixSettingsConfig.Builder();
        String r1 = r4.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r1, "application.packageName");
        MatrixSettingsConfig r6 = r0.setPackageName(r1).setVersionCode(getVersionCode(r4)).setIsBoe(r5).setVersionName(getVersionName(r4)).build();
        MatrixSettingsManager.Companion.init(r4, r6);
    L5:
        MatrixSettingsManager.Companion.getInstance().addSettingsUpdateListener(new C03021());
        initCrashProtect(r4);
    }

    private final void initCrashProtect(Application r4) {
        CrashProvider.INSTANCE.refreshJson(MatrixSettingsManager.Companion.getInstance().getAllSettings());     // Catch: Exception -> L4
        MatrixCrashConfigBuilder r0 = new MatrixCrashConfigBuilder(r4).enableSpBlockPlugin(true).enableSpFetcherDeadObjectPlugin(true).enableProviderInstalledFailedPlugin(true).enableCookieManagerPlugin(true).enableFinalizeTimeoutPlugin(true).enableJsDialogBadTokenPlugin(true).enableStopActivityNPEPlugin(true).enableToastBadTokenPlugin(true).enableSuperUncaughtExceptionPlugin(true);     // Catch: Exception -> L4
        String r1 = r4.getPackageName();     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r1, "application.packageName");     // Catch: Exception -> L4
        r0.packageName(r1).appVersion(getVersionName(r4)).updateVersion(getVersionCode(r4)).crashPortraitProvider(AnonymousClass1.INSTANCE).onCrashCatchSucceed(AnonymousClass2.INSTANCE).buildAndInit();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MLog.e(TAG, "initCrashProtect error", e);
    }
}

package com.obric.autogui.common.api.platform.packages;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherEntryInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.LauncherShortcutInfo;
import com.obric.autogui.common.api.platform.packages.appinfo.OpenableAppInfo;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import java.util.Collection;

/* JADX INFO: compiled from: IAutoActionPackagesApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionPackagesApi {

    /* JADX INFO: compiled from: IAutoActionPackagesApi.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Collection getLauncherEntriesForLabel$default(IAutoActionPackagesApi r2, Context r3, String r4, boolean r5, int r6, Object r7) {
            IAutoActionPackagesApi r8 = (IAutoActionPackagesApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L8;
            r5 = true;
        L8:
            return r8.getLauncherEntriesForLabel(r9, r4, r5);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLauncherEntriesForLabel");
        }

        public static /* synthetic */ Collection getLauncherShortcutsForLabel$default(IAutoActionPackagesApi r2, Context r3, String r4, boolean r5, int r6, Object r7) {
            IAutoActionPackagesApi r8 = (IAutoActionPackagesApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L8;
            r5 = true;
        L8:
            return r8.getLauncherShortcutsForLabel(r9, r4, r5);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLauncherShortcutsForLabel");
        }

        public static /* synthetic */ Collection getPackageNamesForLabel$default(IAutoActionPackagesApi r2, Context r3, String r4, boolean r5, int r6, Object r7) {
            IAutoActionPackagesApi r8 = (IAutoActionPackagesApi) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin");
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L8;
            r5 = true;
        L8:
            return r8.getPackageNamesForLabel(r9, r4, r5);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPackageNamesForLabel");
        }

        public static /* synthetic */ Object killAppAndDelay$default(IAutoActionPackagesApi r8, String r9, boolean r10, long r11, d r13, int r14, Object r15) {
            IAutoActionPackagesApi r2 = (IAutoActionPackagesApi) ZeusTransformUtils.wrapperContextForParams(r8, IAutoActionPackagesApi.class, "com.obric.aiagent.plugin");
            d<? super Boolean> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 4) == 0) goto L8;
            r11 = com.obric.autogui.common.a.d.f28974a.R();
        L8:
            return r2.killAppAndDelay(r9, r10, r11, r7);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: killAppAndDelay");
        }
    }

    /* JADX INFO: compiled from: IAutoActionPackagesApi.kt */
    public interface PackageChangeListener {
        void onPackageAdded(String r1);

        void onPackageChanged(String r1);

        void onPackageRemoved(String r1);
    }

    String getAppApkMd5(Context r1, String r2);

    String getAppApkMd5FromCacheOnly(String r1);

    Drawable getAppIconDrawable(Context r1, String r2);

    AppInfoEntry getAppInfo(Context r1, String r2);

    String getAppSign(Context r1, String r2);

    Intent getLaunchIntent(Context r1, String r2);

    Collection<LauncherEntryInfo> getLauncherEntriesForLabel(Context r1, String r2, boolean r3);

    Collection<LauncherShortcutInfo> getLauncherShortcutsForLabel(Context r1, String r2, boolean r3);

    Object getOpenableApps(Context r1, d<? super Collection<OpenableAppInfo>> r2);

    Collection<String> getPackageNamesForLabel(Context r1, String r2, boolean r3);

    void init(Context r1);

    void invalidateCache();

    boolean isSystemApp(Context r1, String r2);

    boolean killApp(String r1, boolean r2);

    Object killAppAndDelay(String r1, boolean r2, long r3, d<? super Boolean> r5);

    boolean openAppOnMainDisplay(Context r1, String r2);

    void prefetchAppSignAndMd5(Context r1, String r2);

    void refreshCacheAsync(Context r1);

    void registerPackageChangeListener(PackageChangeListener r1);

    StartActivityResult startActivity(Context r1, Intent r2, StartActivityPosition r3);

    StartActivityResult startActivity(Context r1, Intent r2, AOOperatingSpace r3);

    void startActivityUnsafe(Context r1, Intent r2, int r3);

    StartActivityResult startShortcut(Context r1, String r2, String r3, StartActivityPosition r4);

    void unregisterPackageChangeListener(PackageChangeListener r1);
}

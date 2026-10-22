package com.android.server.compat;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.android.internal.compat.AndroidBuildClassifier;
import com.android.internal.compat.IOverrideValidator;
import com.android.internal.compat.OverrideAllowedState;

/* JADX INFO: loaded from: classes.dex */
public class OverrideValidatorImpl extends IOverrideValidator.Stub {
    private AndroidBuildClassifier mAndroidBuildClassifier;
    private CompatConfig mCompatConfig;
    private Context mContext;
    private boolean mForceNonDebuggableFinalBuild;

    private class SettingsObserver extends ContentObserver {
        final /* synthetic */ OverrideValidatorImpl this$0;

        SettingsObserver(OverrideValidatorImpl r1) {
            this.this$0 = r1;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            OverrideValidatorImpl r0 = this.this$0;
            boolean r3 = false;
            if (Settings.Global.getInt(OverrideValidatorImpl.m3039$$Nest$fgetmContext(this.this$0).getContentResolver(), "force_non_debuggable_final_build_for_compat", 0) != 1) goto L5;
            r3 = true;
        L5:
            OverrideValidatorImpl.m3040$$Nest$fputmForceNonDebuggableFinalBuild(r0, r3);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3039$$Nest$fgetmContext(OverrideValidatorImpl r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmForceNonDebuggableFinalBuild, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3040$$Nest$fputmForceNonDebuggableFinalBuild(OverrideValidatorImpl r0, boolean r1) {
        r0.mForceNonDebuggableFinalBuild = r1;
    }

    OverrideValidatorImpl(AndroidBuildClassifier androidBuildClassifier, Context context, CompatConfig config) {
        this.mAndroidBuildClassifier = androidBuildClassifier;
        this.mContext = context;
        this.mCompatConfig = config;
        this.mForceNonDebuggableFinalBuild = false;
    }

    OverrideAllowedState getOverrideAllowedStateForRecheck(long changeId, String packageName) {
        return getOverrideAllowedStateInternal(changeId, packageName, true);
    }

    public OverrideAllowedState getOverrideAllowedState(long changeId, String packageName) {
        return getOverrideAllowedStateInternal(changeId, packageName, false);
    }

    private OverrideAllowedState getOverrideAllowedStateInternal(long changeId, String packageName, boolean isRecheck) {
        if (this.mCompatConfig.isLoggingOnly(changeId) == false) goto L7;
        return new OverrideAllowedState(5, -1, -1);
    L7:
        if (this.mAndroidBuildClassifier.isDebuggableBuild() == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        boolean debuggableBuild = r0;
        if (this.mAndroidBuildClassifier.isFinalBuild() == false) goto L15;
    L18:
        boolean r1 = true;
    L19:
        boolean finalBuild = r1;
        int maxTargetSdk = this.mCompatConfig.maxTargetSdkForChangeIdOptIn(changeId);
        boolean disabled = this.mCompatConfig.isDisabled(changeId);
        if (debuggableBuild == false) goto L24;
        return new OverrideAllowedState(0, -1, -1);
    L24:
        if (maxTargetSdk >= this.mAndroidBuildClassifier.platformTargetSdk()) goto L26;
        PackageManager packageManager = this.mContext.getPackageManager();
        if (packageManager == null) goto L60;
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 4194304);     // Catch: PackageManager.NameNotFoundException -> L56
        if (this.mCompatConfig.isOverridable(changeId) == false) goto L38;
        if (isRecheck == true) goto L37;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.OVERRIDE_COMPAT_CHANGE_CONFIG_ON_RELEASE_BUILD") != 0) goto L38;
    L37:
        return new OverrideAllowedState(0, -1, -1);
    L38:
        int appTargetSdk = applicationInfo.targetSdkVersion;
        if ((applicationInfo.flags & 2) == 0) goto L41;
        if (finalBuild == false) goto L44;
        if (maxTargetSdk != (-1)) goto L49;
        if (disabled == true) goto L49;
        return new OverrideAllowedState(2, appTargetSdk, maxTargetSdk);
    L49:
        if (disabled == true) goto L55;
        if (appTargetSdk <= maxTargetSdk) goto L55;
        return new OverrideAllowedState(3, appTargetSdk, maxTargetSdk);
    L55:
        return new OverrideAllowedState(0, appTargetSdk, maxTargetSdk);
    L44:
        return new OverrideAllowedState(0, appTargetSdk, maxTargetSdk);
    L41:
        return new OverrideAllowedState(1, -1, -1);
    L58:
        return new OverrideAllowedState(4, -1, -1);
    L60:
        throw new IllegalStateException("No PackageManager!");
    L26:
        return new OverrideAllowedState(6, -1, maxTargetSdk);
    L15:
        if (this.mForceNonDebuggableFinalBuild == true) goto L18;
        r1 = false;
        goto L19
    L9:
        if (this.mForceNonDebuggableFinalBuild == true) goto L11;
        r0 = true;
        goto L12
    }

    void registerContentObserver() {
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("force_non_debuggable_final_build_for_compat"), false, new SettingsObserver(this));
    }

    void forceNonDebuggableFinalForTest(boolean value) {
        this.mForceNonDebuggableFinalBuild = value;
    }
}

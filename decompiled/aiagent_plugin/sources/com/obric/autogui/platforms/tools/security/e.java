package com.obric.autogui.platforms.tools.security;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.StartActivityPosition;
import com.obric.autogui.common.api.platform.packages.StartActivityResult;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: StandardPermissionApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements IAutoActionPermissionApi {
    private static final String TAG = "PermissionImpl/Std";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30544a = null;

    /* JADX INFO: compiled from: StandardPermissionApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f30544a = new a(null);
    }

    public e() {
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi
    public IAutoActionPermissionApi.PermissionCheckResult checkPermission(Context r5, String r6, String r7) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        o.e(r6, "forPackage");
        o.e(r7, "permName");
        boolean r8 = false;
        if (r4.getPackageManager().checkPermission(r7, r6) != 0) goto L8;
        r8 = true;
    L8:
        return new IAutoActionPermissionApi.PermissionCheckResult(true, r8, "system-result");
    L9:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to check permission '" + r7 + "' for package '" + r6 + '\'', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new IAutoActionPermissionApi.PermissionCheckResult(false, false, "exception-" + e);
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi
    public IAutoActionPermissionApi.PermissionCheckResult checkPermission(Context r6, String r7) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r7, "permName");
        boolean r8 = false;
        if (r5.getPackageManager().checkPermission(r7, r5.getPackageName()) != 0) goto L8;
        r8 = true;
    L8:
        return new IAutoActionPermissionApi.PermissionCheckResult(true, r8, "system-result");
    L9:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to check permission '" + r7 + "' for package '" + r5.getPackageName() + '\'', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return new IAutoActionPermissionApi.PermissionCheckResult(false, false, "exception-" + e);
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi
    public StartActivityResult openAllPermissionSettings(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r5, "forPackage");
        AppInfoEntry r6 = AOPackagesTools.INSTANCE.getAppInfo(r3, r5);
        if (r6 != null) goto L6;
        Loog.INSTANCE.w(TAG, "[OpenAllPermissionSettings] not-found pkgName = " + r5);
        return new StartActivityResult(StartActivityResult.Status.TargetNotFound);
    L6:
        Intent r0 = new Intent();
        r0.setPackage("com.android.permissioncontroller");
        r0.setClassName("com.android.permissioncontroller", "com.android.permissioncontroller.permissionplus.ui.AppAllPermissionsActivity");
        r0.addFlags(268435456);
        r0.putExtra("PACKAGE_NAME", r5);
        r0.putExtra("APP_NAME", r6.getAppLabel());
        return AOSystemTools.INSTANCE.startActivity(r3, r0, StartActivityPosition.MainDisplay);
    }

    @Override // com.obric.autogui.common.api.platform.security.IAutoActionPermissionApi
    public IAutoActionPermissionApi.PermissionDialogueResult showPermissionDialogue(Activity r2, String r3) {
        o.e((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin"), "activity");
        o.e(r3, "permName");
        return IAutoActionPermissionApi.PermissionDialogueResult.Opened;
    }
}

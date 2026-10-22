package com.android.server.wm;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.Window;
import com.android.server.utils.AppInstallerUtil;

/* JADX INFO: loaded from: classes3.dex */
class DeprecatedTargetSdkVersionDialog extends AppWarnings.BaseDialog {
    public static /* synthetic */ void $r8$lambda$4Mx4ewI1_zJvTwknmrE_4TysHJA(Context r0, Intent r1, DialogInterface r2, int r3) {
        lambda$new$1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$DreduZ8h4DqHq-UklEonGJsvBUo, reason: not valid java name */
    public static /* synthetic */ void m9855$r8$lambda$DreduZ8h4DqHqUklEonGJsvBUo(DeprecatedTargetSdkVersionDialog r0, AppWarnings r1, DialogInterface r2, int r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    DeprecatedTargetSdkVersionDialog(final AppWarnings manager, final Context context, ApplicationInfo appInfo, int userId) {
        super(manager, context, appInfo.packageName, userId);
        PackageManager pm = context.getPackageManager();
        CharSequence label = appInfo.loadSafeLabel(pm, 1000.0f, 5);
        CharSequence message = context.getString(R.string.emailTypeOther);
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setPositiveButton(R.string.ok, new DeprecatedTargetSdkVersionDialog$$ExternalSyntheticLambda0(this, manager)).setMessage(message).setTitle(label);
        final Intent installerIntent = AppInstallerUtil.createIntent(context, appInfo.packageName);
        if (installerIntent == null) goto L5;
        builder.setNeutralButton(R.string.emailTypeMobile, new DeprecatedTargetSdkVersionDialog$$ExternalSyntheticLambda1(context, installerIntent));
    L5:
        this.mDialog = builder.create();
        this.mDialog.create();
        Window window = this.mDialog.getWindow();
        window.setType(2002);
        window.getAttributes().setTitle("DeprecatedTargetSdkVersionDialog");
    }

    private /* synthetic */ void lambda$new$0(AppWarnings manager, DialogInterface dialog, int which) {
        manager.setPackageFlag(this.mUserId, this.mPackageName, 4, true);
    }

    private static /* synthetic */ void lambda$new$1(Context context, Intent installerIntent, DialogInterface dialog, int which) {
        context.startActivity(installerIntent);
    }
}

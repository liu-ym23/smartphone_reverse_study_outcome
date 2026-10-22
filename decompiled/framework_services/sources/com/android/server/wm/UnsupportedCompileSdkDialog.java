package com.android.server.wm;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.android.server.utils.AppInstallerUtil;

/* JADX INFO: loaded from: classes3.dex */
class UnsupportedCompileSdkDialog extends AppWarnings.BaseDialog {
    public static /* synthetic */ void $r8$lambda$VSqa4K4_ZC3Z_WdPqeZDHSWgepE(Context r0, Intent r1, DialogInterface r2, int r3) {
        lambda$new$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZdEyLs1mAPOe6LWZSOQhguaGw6c(UnsupportedCompileSdkDialog r0, AppWarnings r1, CompoundButton r2, boolean r3) {
        r0.lambda$new$1(r1, r2, r3);
    }

    UnsupportedCompileSdkDialog(final AppWarnings manager, final Context context, ApplicationInfo appInfo, int userId) {
        super(manager, context, appInfo.packageName, userId);
        PackageManager pm = context.getPackageManager();
        CharSequence label = appInfo.loadSafeLabel(pm, 1000.0f, 5);
        CharSequence message = context.getString(17042274, new Object[]{label});
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setPositiveButton(R.string.ok, null).setMessage(message).setView(17367525);
        final Intent installerIntent = AppInstallerUtil.createIntent(context, appInfo.packageName);
        if (installerIntent == null) goto L5;
        builder.setNeutralButton(17042273, new UnsupportedCompileSdkDialog$$ExternalSyntheticLambda0(context, installerIntent));
    L5:
        this.mDialog = builder.create();
        this.mDialog.create();
        Window window = this.mDialog.getWindow();
        window.setType(2002);
        window.getAttributes().setTitle("UnsupportedCompileSdkDialog");
        CheckBox alwaysShow = (CheckBox) this.mDialog.findViewById(R.id.assertive);
        alwaysShow.setChecked(true);
        alwaysShow.setOnCheckedChangeListener(new UnsupportedCompileSdkDialog$$ExternalSyntheticLambda1(this, manager));
    }

    private static /* synthetic */ void lambda$new$0(Context context, Intent installerIntent, DialogInterface dialog, int which) {
        context.startActivity(installerIntent);
    }

    private /* synthetic */ void lambda$new$1(AppWarnings manager, CompoundButton buttonView, boolean isChecked) {
        manager.setPackageFlag(this.mUserId, this.mPackageName, 2, !isChecked);
    }
}

package com.android.server.wm;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
class DeprecatedAbiDialog extends AppWarnings.BaseDialog {
    public static /* synthetic */ void $r8$lambda$kU_MS0J9MjIWiDXeLyl4UpPyFCA(DeprecatedAbiDialog r0, AppWarnings r1, DialogInterface r2, int r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    DeprecatedAbiDialog(final AppWarnings manager, Context context, ApplicationInfo appInfo, int userId) {
        super(manager, context, appInfo.packageName, userId);
        PackageManager pm = context.getPackageManager();
        CharSequence label = appInfo.loadSafeLabel(pm, 1000.0f, 5);
        CharSequence message = context.getString(R.string.emailTypeHome);
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setPositiveButton(R.string.ok, new DeprecatedAbiDialog$$ExternalSyntheticLambda0(this, manager)).setMessage(message).setTitle(label);
        this.mDialog = builder.create();
        this.mDialog.create();
        Window window = this.mDialog.getWindow();
        window.setType(2002);
        window.getAttributes().setTitle("DeprecatedAbiDialog");
    }

    private /* synthetic */ void lambda$new$0(AppWarnings manager, DialogInterface dialog, int which) {
        manager.setPackageFlag(this.mUserId, this.mPackageName, 8, true);
    }
}

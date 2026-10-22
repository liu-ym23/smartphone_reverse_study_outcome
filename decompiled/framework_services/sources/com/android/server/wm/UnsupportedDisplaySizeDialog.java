package com.android.server.wm;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes3.dex */
class UnsupportedDisplaySizeDialog extends AppWarnings.BaseDialog {
    public static /* synthetic */ void $r8$lambda$wXvVKOP1FoaE5vOmLw0qEu9mUhM(UnsupportedDisplaySizeDialog r0, AppWarnings r1, CompoundButton r2, boolean r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    UnsupportedDisplaySizeDialog(final AppWarnings manager, Context context, ApplicationInfo appInfo, int userId) {
        super(manager, context, appInfo.packageName, userId);
        PackageManager pm = context.getPackageManager();
        CharSequence label = appInfo.loadSafeLabel(pm, 1000.0f, 5);
        CharSequence message = context.getString(17042276, new Object[]{label});
        this.mDialog = new AlertDialog.Builder(context).setPositiveButton(R.string.ok, null).setMessage(message).setView(17367526).create();
        this.mDialog.create();
        Window window = this.mDialog.getWindow();
        window.setType(2002);
        window.getAttributes().setTitle("UnsupportedDisplaySizeDialog");
        CheckBox alwaysShow = (CheckBox) this.mDialog.findViewById(R.id.assertive);
        alwaysShow.setChecked(true);
        alwaysShow.setOnCheckedChangeListener(new UnsupportedDisplaySizeDialog$$ExternalSyntheticLambda0(this, manager));
    }

    private /* synthetic */ void lambda$new$0(AppWarnings manager, CompoundButton buttonView, boolean isChecked) {
        manager.setPackageFlag(this.mUserId, this.mPackageName, 1, !isChecked);
    }
}

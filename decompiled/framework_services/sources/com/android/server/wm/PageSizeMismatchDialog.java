package com.android.server.wm;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
class PageSizeMismatchDialog extends AppWarnings.BaseDialog {
    /* JADX INFO: renamed from: $r8$lambda$fUlZjXwRjA-OJayvWA83KQUpQuo, reason: not valid java name */
    public static /* synthetic */ void m10074$r8$lambda$fUlZjXwRjAOJayvWA83KQUpQuo(PageSizeMismatchDialog r0, AppWarnings r1, DialogInterface r2, int r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    PageSizeMismatchDialog(final AppWarnings manager, Context context, ApplicationInfo appInfo, int userId, String warning) {
        super(manager, context, appInfo.packageName, userId);
        PackageManager pm = context.getPackageManager();
        CharSequence label = appInfo.loadSafeLabel(pm, 1000.0f, 5);
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setPositiveButton(R.string.ok, new PageSizeMismatchDialog$$ExternalSyntheticLambda0(this, manager)).setMessage(Html.fromHtml(warning, 63)).setTitle(label);
        this.mDialog = builder.create();
        this.mDialog.create();
        Window window = this.mDialog.getWindow();
        window.setType(2038);
    }

    private /* synthetic */ void lambda$new$0(AppWarnings manager, DialogInterface dialog, int which) {
        manager.setPackageFlag(this.mUserId, this.mPackageName, 16, true);
    }

    @Override // com.android.server.wm.AppWarnings.BaseDialog
    public void show() {
        super.show();
        TextView msgTxt = (TextView) this.mDialog.findViewById(R.id.message);
        msgTxt.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

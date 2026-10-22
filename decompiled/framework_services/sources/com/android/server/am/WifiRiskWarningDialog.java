package com.android.server.am;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes.dex */
final class WifiRiskWarningDialog extends BaseErrorDialog {
    private final Handler mHandler;

    public WifiRiskWarningDialog(ActivityManagerService service, Context context, ProcessRecord app) {
        super(context);
        this.mHandler = new AnonymousClass1(this);
        Resources res = context.getResources();
        setCancelable(false);
        setMessage(res.getString(17042428));
        setButton(-1, res.getString(17042427), this.mHandler.obtainMessage(1, app));
        setTitle(res.getString(17042429));
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.setTitle("WifiRisk");
        getWindow().setAttributes(attrs);
    }

    @Override // com.android.server.am.BaseErrorDialog, android.app.Dialog
    public void onStop() {
    }
}

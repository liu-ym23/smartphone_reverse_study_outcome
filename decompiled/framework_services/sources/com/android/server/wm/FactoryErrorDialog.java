package com.android.server.wm;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;
import com.android.server.am.BaseErrorDialog;

/* JADX INFO: loaded from: classes3.dex */
final class FactoryErrorDialog extends BaseErrorDialog {
    private final Handler mHandler;

    public FactoryErrorDialog(Context context, CharSequence msg) {
        super(context);
        this.mHandler = new AnonymousClass1(this);
        setCancelable(false);
        setTitle(context.getText(R.string.geofencing_service));
        setMessage(msg);
        setButton(-1, context.getText(R.string.global_action_emergency), this.mHandler.obtainMessage(0));
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.setTitle("Factory Error");
        getWindow().setAttributes(attrs);
    }

    @Override // com.android.server.am.BaseErrorDialog
    protected void closeDialog() {
    }
}

package com.stepos.stability;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.stepos.pps.common.ThreadPool;
import com.stepos.pps.common.Utils;
import org.json.JSONException;

/* loaded from: classes.dex */
public class KEReportReceiver extends BroadcastReceiver {
    private static final String TAG = "KEReportReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals("android.intent.action.BOOT_COMPLETED", intent.getAction()) && Utils.isSetupWizardPrivacyConfirmed(context)) {
            ThreadPool.getInstance().execute(new Runnable() { // from class: com.stepos.stability.KEReportReceiver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    new KernelExceptionReporter().checkCrash();
                }
            });
        }
    }
}

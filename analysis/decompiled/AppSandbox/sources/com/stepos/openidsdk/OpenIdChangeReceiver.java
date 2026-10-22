package com.stepos.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.stepos.pps.logpull.LogPullAuthActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
class OpenIdChangeReceiver extends BroadcastReceiver {
    OpenIdChangeReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            OpenIdManager.log("context and intent is null");
            return;
        }
        if (!shouldUpdateId(context, intent)) {
            OpenIdManager.log("shouldUpdateId is false");
            return;
        }
        String stringExtra = intent.getStringExtra("openIdType");
        OpenId openId = OpenIdManager.getInstance().getOpenId(stringExtra);
        if (openId != null) {
            openId.setDataExpired();
        }
        if (LogPullAuthActivity.EXTRA_OAID.equals(stringExtra)) {
            OpenIdManager.log("onOAIDChanged");
            OpenIdManager.getInstance().onOAIDChanged();
        }
    }

    private boolean shouldUpdateId(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        OpenIdManager.log("shouldUpdateId, notifyFlag : " + intExtra);
        if (intExtra == 1) {
            return TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName());
        }
        if (intExtra != 2) {
            return intExtra == 0;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
        if (stringArrayListExtra != null) {
            return stringArrayListExtra.contains(context.getPackageName());
        }
        return false;
    }
}

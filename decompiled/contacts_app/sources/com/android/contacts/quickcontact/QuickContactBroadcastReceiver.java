package com.android.contacts.quickcontact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.obric.privacyhook.BaseBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class QuickContactBroadcastReceiver extends BaseBroadcastReceiver {
    public QuickContactBroadcastReceiver() {
    }

    @Override // com.obric.privacyhook.BaseBroadcastReceiver
    public void onReceiveAction(Context r3, Intent r4) {
        Uri r2 = r4.getData();
        Intent r0 = new Intent("android.provider.action.QUICK_CONTACT");
        r0.setSourceBounds(r4.getSourceBounds());
        r0.addFlags(268468224);
        r0.setData(r2);
        r3.startActivity(r0);
    }
}

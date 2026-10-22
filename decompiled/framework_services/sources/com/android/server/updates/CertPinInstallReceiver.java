package com.android.server.updates;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public class CertPinInstallReceiver extends ConfigUpdateInstallReceiver {
    private static final String KEYCHAIN_DIR = "/data/misc/keychain/";

    public CertPinInstallReceiver() {
        super(KEYCHAIN_DIR, "pins", "metadata/", "version");
    }

    @Override // com.android.server.updates.ConfigUpdateInstallReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()) == true) goto L7;
        super.onReceive(context, intent);
        return;
    }
}

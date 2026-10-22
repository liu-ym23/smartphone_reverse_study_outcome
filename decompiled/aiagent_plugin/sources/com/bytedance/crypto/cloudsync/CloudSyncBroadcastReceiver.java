package com.bytedance.crypto.cloudsync;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CloudSyncBroadcastReceiver extends PluginBroadcastReceiver {
    public static final String PERMISSION = "slardaros.intent.permission";
    private static final String TAG = "CloudSyncBroadcastReceiver";
    public static final String WHITELIST_ACTION = "com.bytedance.security.CLOUD_SYNC_APP_WHITELIST";

    public CloudSyncBroadcastReceiver() {
    }

    public void onReceive(Context r4, Intent r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L12;
        if (r5 == null) goto L12;
        String r0 = r5.getAction();
        LogUtils.i(TAG, "Receive broadcast action:" + r0);
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return;
    L9:
        if (r0.equals(WHITELIST_ACTION) == false) goto L15;
        String r6 = r5.getStringExtra("data");
        LogUtils.d(TAG, "WHITELIST_ACTION data:" + r6);
        String r7 = r3.getFilesDir().getAbsolutePath() + "/" + CloudConfig.WHITE_LIST_FILE_NAME;
        LogUtils.d(TAG, "WHITELIST_ACTION filePath:" + r7);
        CloudConfig.getInstance().updateWhiteListApps(r7, r6);
        return;
    L15:
        return;
    L12:
        LogUtils.e(TAG, "context or intent is null");
    }
}

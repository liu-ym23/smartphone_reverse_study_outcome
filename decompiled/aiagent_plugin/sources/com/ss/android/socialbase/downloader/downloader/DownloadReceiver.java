package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadReceiver extends PluginBroadcastReceiver {
    private static final String TAG = "DownloadReceiver";

    static {
    }

    public DownloadReceiver() {
    }

    public void onReceive(Context r4, Intent r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        if (r5 == null) goto L33;
        String r7 = r5.getAction();
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return;
    L10:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "onReceive", "Action:" + r7);
    L13:
        if (r7.equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L16;
        autoRefreshUnsuccessDownloadTask(r6, r7);
        return;
    L16:
        if (r7.equals("android.intent.action.MEDIA_UNMOUNTED") == false) goto L18;
    L27:
        forceStopAllDownloadTask(r6, r7);
        return;
    L18:
        if (r7.equals("android.intent.action.MEDIA_REMOVED") == true) goto L27;
        if (r7.equals("android.intent.action.MEDIA_BAD_REMOVAL") == true) goto L27;
        if (r7.equals("android.intent.action.MEDIA_EJECT") == true) goto L27;
        if (r7.equals("android.intent.action.MEDIA_MOUNTED") == false) goto L31;
        DownloadComponentManager.submitCPUTask(new AnonymousClass1(this, r6));
        return;
    L31:
        return;
    L33:
        return;
    }

    private void autoRefreshUnsuccessDownloadTask(Context r7, final String r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (DownloadComponentManager.needAutoRefreshUnSuccessTask() == true) goto L5;
        return;
    L5:
        long r2 = 2000;
        long r0 = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.DELAY_REFRESH_UNSUCCESS_TASK_MS, 2000);
        if (r0 <= 0) goto L9;
        r2 = r0;
    L9:
        DownloadComponentManager.submitScheduleTask(new AnonymousClass2(this, r9, r8), r2, TimeUnit.MILLISECONDS);
    }

    private void forceStopAllDownloadTask(Context r3, final String r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        DownloadComponentManager.submitCPUTask(new AnonymousClass3(this, r5, r4));
    }
}

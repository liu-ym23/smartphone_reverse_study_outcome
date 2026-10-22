package com.android.server.integrity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.integrity.IAppIntegrityManager;
import android.content.integrity.Rule;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Slog;
import com.android.server.LocalServices;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppIntegrityManagerServiceImpl extends IAppIntegrityManager.Stub {
    public static final boolean DEBUG_INTEGRITY_COMPONENT = false;
    private static final String PACKAGE_MIME_TYPE = "application/vnd.android.package-archive";
    private static final String TAG = "AppIntegrityManagerServiceImpl";
    private final Context mContext;
    private final Handler mHandler;
    private final PackageManagerInternal mPackageManagerInternal;

    public static AppIntegrityManagerServiceImpl create(Context context) {
        HandlerThread handlerThread = new HandlerThread("AppIntegrityManagerServiceHandler");
        handlerThread.start();
        return new AppIntegrityManagerServiceImpl(context, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), handlerThread.getThreadHandler());
    }

    AppIntegrityManagerServiceImpl(Context context, PackageManagerInternal packageManagerInternal, Handler handler) {
        this.mContext = context;
        this.mPackageManagerInternal = packageManagerInternal;
        this.mHandler = handler;
    }

    public void updateRuleSet(String version, ParceledListSlice<Rule> rules, IntentSender statusReceiver) {
        Intent intent = new Intent();
        intent.putExtra("android.content.integrity.extra.STATUS", 0);
        statusReceiver.sendIntent(this.mContext, 0, intent, null, null);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Exception e = e;
    L11:
        Slog.e(TAG, "Error sending status feedback.", e);
        return;
    L9:
        e = move-exception;
        e = e;
        goto L11
    }

    public String getCurrentRuleSetVersion() {
        return "";
    }

    public String getCurrentRuleSetProvider() {
        return "";
    }

    public ParceledListSlice<Rule> getCurrentRules() {
        return new ParceledListSlice(Collections.emptyList());
    }

    public List<String> getWhitelistedRuleProviders() {
        return Collections.emptyList();
    }
}

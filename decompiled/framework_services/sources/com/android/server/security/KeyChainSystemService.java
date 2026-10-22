package com.android.server.security;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.Settings;

/* JADX INFO: loaded from: classes3.dex */
public class KeyChainSystemService extends SystemService {
    private static final int KEYCHAIN_IDLE_ALLOWLIST_DURATION_MS = 30000;
    private static final String TAG = "KeyChainSystemService";
    private final BroadcastReceiver mPackageReceiver;

    /* JADX INFO: renamed from: -$$Nest$mstartServiceInBackgroundAsUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8026$$Nest$mstartServiceInBackgroundAsUser(KeyChainSystemService r0, Intent r1, UserHandle r2) {
        r0.startServiceInBackgroundAsUser(r1, r2);
    }

    public KeyChainSystemService(Context context) {
        super(context);
        this.mPackageReceiver = new AnonymousClass1(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        IntentFilter packageFilter = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        packageFilter.addDataScheme(Settings.ATTR_PACKAGE);
        getContext().registerReceiverAsUser(this.mPackageReceiver, UserHandle.ALL, packageFilter, null, null);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Unable to register for package removed broadcast", e);
    }

    private void startServiceInBackgroundAsUser(Intent intent, UserHandle user) {
        if (intent.getComponent() != null) goto L5;
        return;
    L5:
        String packageName = intent.getComponent().getPackageName();
        DeviceIdleInternal idleController = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
        idleController.addPowerSaveTempWhitelistApp(Process.myUid(), packageName, 30000, user.getIdentifier(), false, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_KEY_CHAIN, "keychain");
        getContext().startServiceAsUser(intent, user);
    }
}

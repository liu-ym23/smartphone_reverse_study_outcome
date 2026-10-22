package com.android.server.signedconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.net.Uri;
import android.os.Bundle;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.pm.Settings;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public class SignedConfigService {
    private static final boolean DBG = false;
    private static final String KEY_GLOBAL_SETTINGS = "android.settings.global";
    private static final String KEY_GLOBAL_SETTINGS_SIGNATURE = "android.settings.global.signature";
    private static final String TAG = "SignedConfig";
    private final Context mContext;
    private final PackageManagerInternal mPacMan;

    private static class UpdateReceiver extends BroadcastReceiver {
        /* synthetic */ UpdateReceiver(SignedConfigServiceIA r1) {
            this();
        }

        private UpdateReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            new SignedConfigService(context).handlePackageBroadcast(intent);
        }
    }

    public SignedConfigService(Context context) {
        this.mContext = context;
        this.mPacMan = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    }

    void handlePackageBroadcast(Intent intent) {
        Uri packageData = intent.getData();
        if (packageData != null) goto L5;
        String r0 = null;
    L6:
        String packageName = r0;
        if (packageName != null) goto L9;
        return;
    L9:
        int userId = this.mContext.getUser().getIdentifier();
        PackageInfo pi = this.mPacMan.getPackageInfo(packageName, 128, 1000, userId);
        if (pi != null) goto L13;
        Slog.w(TAG, "Got null PackageInfo for " + packageName + "; user " + userId);
        return;
    L13:
        Bundle metaData = pi.applicationInfo.metaData;
        if (metaData != null) goto L17;
        return;
    L17:
        if (metaData.containsKey(KEY_GLOBAL_SETTINGS) == true) goto L19;
        return;
    L19:
        if (metaData.containsKey(KEY_GLOBAL_SETTINGS_SIGNATURE) == false) goto L38;
        SignedConfigEvent event = new SignedConfigEvent();
        event.type = 1;     // Catch: Throwable -> L26
        event.fromPackage = packageName;     // Catch: Throwable -> L26
        String config = metaData.getString(KEY_GLOBAL_SETTINGS);     // Catch: Throwable -> L26
        String signature = metaData.getString(KEY_GLOBAL_SETTINGS_SIGNATURE);     // Catch: Throwable -> L26
        new GlobalSettingsConfigApplicator(this.mContext, packageName, event).applyConfig(new String(Base64.getDecoder().decode(config), StandardCharsets.UTF_8), signature);     // Catch: Throwable -> L26
        event.send();
        return;
    L29:
        Slog.e(TAG, "Failed to base64 decode global settings config from " + packageName);     // Catch: Throwable -> L26
        event.status = 2;     // Catch: Throwable -> L26
        event.send();
        return;
    L26:
        th = move-exception;
        event.send();
        throw th;
    L38:
        return;
    L5:
        r0 = packageData.getSchemeSpecificPart();
        goto L6
    }

    public static void registerUpdateReceiver(Context context) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        context.registerReceiver(new UpdateReceiver(null), filter);
    }
}

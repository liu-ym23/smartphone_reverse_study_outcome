package com.bytedance.server.security;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import com.bytedance.security.keymanager.KeyManager;
import com.bytedance.security.secretdata.SecretDataManager;

/* JADX INFO: loaded from: classes3.dex */
public class SecurityService extends SystemService {
    private static final String TAG = null;
    private Context mContext;

    private class SecurityBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ SecurityService this$0;

        /* synthetic */ SecurityBroadcastReceiver(SecurityService r1, SecurityServiceIA r2) {
            this(r1);
        }

        private SecurityBroadcastReceiver(SecurityService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i(SecurityService.m10546$$Nest$sfgetTAG(), "onReceive " + intent.getAction());
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_FULLY_REMOVED") == false) goto L5;
        L6:
            String packageName = intent.getData().getSchemeSpecificPart();
            int uid = intent.getIntExtra("android.intent.extra.UID", -1);
            if (uid != (-1)) goto L10;
            uid = SecurityService.m10547$$Nest$smgetUidFromPkgName(this.this$0.getContext(), packageName);
        L10:
            if (uid != 1000) goto L13;
            Log.i(SecurityService.m10546$$Nest$sfgetTAG(), "System uid app no need to clear data.");
            return;
        L13:
            Log.i(SecurityService.m10546$$Nest$sfgetTAG(), "onReceive packageName:" + packageName + " uid:" + uid);
            int result = SecurityService.m10544$$Nest$mclearAppData(this.this$0, packageName, uid);
            Log.i(SecurityService.m10546$$Nest$sfgetTAG(), "App data clear result:" + result);
            int result2 = SecurityService.m10545$$Nest$mclearAppKeyData(this.this$0, packageName, uid);
            Log.i(SecurityService.m10546$$Nest$sfgetTAG(), "App key data clear result:" + result2);
            return;
        L5:
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_DATA_CLEARED") == true) goto L6;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAppData, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10544$$Nest$mclearAppData(SecurityService r0, String r1, int r2) {
        return r0.clearAppData(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAppKeyData, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10545$$Nest$mclearAppKeyData(SecurityService r0, String r1, int r2) {
        return r0.clearAppKeyData(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m10546$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetUidFromPkgName, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m10547$$Nest$smgetUidFromPkgName(Context r0, String r1) {
        return getUidFromPkgName(r0, r1);
    }

    static {
        TAG = SecurityService.class.getSimpleName();
    }

    public SecurityService(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        Log.i(TAG, "onStart");
        broadcastReceiverRegister();
    }

    private void broadcastReceiverRegister() {
        if (this.mContext != null) goto L6;
        Log.e(TAG, "context is null");
        return;
    L6:
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_FULLY_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        SecurityBroadcastReceiver receiver = new SecurityBroadcastReceiver(this, null);
        this.mContext.registerReceiver(receiver, intentFilter);
    }

    private static int getUidFromPkgName(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();     // Catch: Exception -> L4
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);     // Catch: Exception -> L4
        return applicationInfo.uid;
    L4:
        e = move-exception;
        Log.e(TAG, "Get uid failed, error:" + e.getMessage());
        return -1;
    }

    private int clearAppData(String pkgName, int uid) {
        SecretDataManager secDataManager = SecretDataManager.getInstance();
        if (secDataManager != null) goto L7;
        Log.e(TAG, "Get secret data manager failed!!");
        return -3;
    L7:
        return secDataManager.clearAppData(pkgName, uid, new Bundle());
    }

    private int clearAppKeyData(String pkgName, int uid) {
        KeyManager keyManager = KeyManager.getInstance();
        if (keyManager != null) goto L7;
        Log.e(TAG, "Get KeyManager failed!!");
        return -3;
    L7:
        return keyManager.clearAppKeyData(pkgName, uid, new Bundle());
    }
}

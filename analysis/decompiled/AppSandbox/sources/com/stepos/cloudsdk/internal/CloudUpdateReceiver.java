package com.stepos.cloudsdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.stepos.cloudsdk.Constants;
import com.stepos.cloudsdk.Logger;

/* loaded from: classes.dex */
public class CloudUpdateReceiver extends BroadcastReceiver {
    private static final String TAG = "ConfigUpdateReceiver";
    private final ConfigUpdateCallback callback;

    public interface ConfigUpdateCallback {
        void onConfigUpdated(String str);
    }

    public CloudUpdateReceiver(ConfigUpdateCallback configUpdateCallback) {
        this.callback = configUpdateCallback;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && Constants.ACTION_CONFIG_UPDATED.equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(Constants.EXTRA_KEY);
            if (TextUtils.isEmpty(stringExtra)) {
                Logger.w(TAG, "onReceive: key is empty");
                return;
            }
            Logger.d(TAG, "onReceive: config updated, key=" + stringExtra);
            this.callback.onConfigUpdated(stringExtra);
        }
    }

    public void register(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.ACTION_CONFIG_UPDATED);
        context.registerReceiver(this, intentFilter, Constants.PERMISSION_SEND_CLOUD_CONFIG, null, 2);
        Logger.d(TAG, "register: registered with permission com.stepos.permission.SEND_CLOUD_CONFIG");
    }

    public void unregister(Context context) {
        try {
            context.unregisterReceiver(this);
            Logger.d(TAG, "unregister: unregistered");
        } catch (IllegalArgumentException e) {
            Logger.w(TAG, "unregister: receiver not registered", e);
        }
    }
}

package com.android.server.biometrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Slog;
import com.android.server.am.ProcessList;
import com.android.server.biometrics.sensors.BiometricNotificationImpl;
import java.time.Clock;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticationStatsBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "AuthenticationStatsBroadcastReceiver";
    private final Consumer<AuthenticationStatsCollector> mCollectorConsumer;
    private final int mModality;

    public AuthenticationStatsBroadcastReceiver(Context context, int modality, Consumer<AuthenticationStatsCollector> callback) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        context.registerReceiver(this, intentFilter);
        this.mCollectorConsumer = callback;
        this.mModality = modality;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int userId = intent.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);
        if (userId != (-10000)) goto L5;
        return;
    L5:
        if ("android.intent.action.USER_UNLOCKED".equals(intent.getAction()) == false) goto L9;
        Slog.d(TAG, "Received: " + intent.getAction());
        this.mCollectorConsumer.accept(new AuthenticationStatsCollector(context, this.mModality, new BiometricNotificationImpl(), Clock.systemUTC()));
        context.unregisterReceiver(this);
        return;
    }
}

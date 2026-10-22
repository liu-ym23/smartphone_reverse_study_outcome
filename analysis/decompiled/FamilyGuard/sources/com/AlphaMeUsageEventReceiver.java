package com;

import C2.d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.minor.WhitelistApp;
import f2.C0702g;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class AlphaMeUsageEventReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i5;
        int i6;
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        if (!d.b(context, callingUid)) {
            Log.w("AMUEReceiver", "onReceive rejected untrusted uid=" + callingUid);
            return;
        }
        String action = intent.getAction();
        long longExtra = intent.getLongExtra("start_time", 0L);
        long longExtra2 = intent.getLongExtra("end_time", 0L);
        Log.d("AMUEReceiver", "onReceive intent = " + C0702g.j(intent));
        Intent intent2 = new Intent(context, (Class<?>) DigitalWellbeingService.class);
        intent2.setAction(action);
        if (TextUtils.equals(action, "com.stepos.alphame.intent.action.APP_EVENT")) {
            String stringExtra = intent.getStringExtra(WhitelistApp.COLUMN_PACKAGE_NAME);
            if (TextUtils.isEmpty(stringExtra)) {
                Log.w("AMUEReceiver", "onReceive APP_EVENT empty package");
                return;
            }
            if (longExtra == longExtra2) {
                i5 = 1;
            } else {
                i5 = 2;
                longExtra = longExtra2;
            }
            intent2.putExtra(WhitelistApp.COLUMN_PACKAGE_NAME, stringExtra);
        } else if (TextUtils.equals(action, "com.stepos.alphame.intent.action.SCREEN_EVENT")) {
            String stringExtra2 = intent.getStringExtra("state");
            if (TextUtils.equals(stringExtra2, "screen_on")) {
                i6 = 3;
            } else if (TextUtils.equals(stringExtra2, "screen_off")) {
                i6 = 4;
            } else {
                i5 = 0;
                intent2.putExtra(WhitelistApp.COLUMN_PACKAGE_NAME, BuildConfig.FLAVOR);
            }
            i5 = i6;
            intent2.putExtra(WhitelistApp.COLUMN_PACKAGE_NAME, BuildConfig.FLAVOR);
        } else {
            longExtra = 0;
            i5 = 0;
        }
        if (i5 == 0) {
            Log.w("AMUEReceiver", "onReceive ignored unknown command action=" + action);
            return;
        }
        intent2.putExtra("command_id", i5);
        intent2.putExtra("time", longExtra);
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        try {
            DigitalWellbeingService.S(context, intent2);
        } finally {
            pendingResultGoAsync.finish();
        }
    }
}

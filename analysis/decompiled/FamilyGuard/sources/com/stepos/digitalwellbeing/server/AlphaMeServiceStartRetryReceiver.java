package com.stepos.digitalwellbeing.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import f2.C0702g;

/* loaded from: classes.dex */
public class AlphaMeServiceStartRetryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.stepos.digitalwellbeing.action.ALPHAME_SERVICE_RETRY".equals(intent.getAction()) && !a.b()) {
            C0702g.b("AlphaMeRetryReceiver", "onReceive retry pending AlphaMe events");
            DigitalWellbeingService.S(context, new Intent(context, (Class<?>) DigitalWellbeingService.class));
        }
    }
}

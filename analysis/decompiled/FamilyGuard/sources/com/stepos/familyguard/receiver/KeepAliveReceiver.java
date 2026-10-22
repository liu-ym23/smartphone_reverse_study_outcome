package com.stepos.familyguard.receiver;

import R1.a;
import T1.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import p2.g;

/* loaded from: classes.dex */
public class KeepAliveReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"com.stepos.familyguard.KEEP_ALIVE".equals(intent.getAction())) {
            return;
        }
        Log.e("AIOSBUG-4839-fix-v3", "KEEP_ALIVE received");
        g.F();
        g.V(context);
        boolean zX = g.x(context);
        if (zX) {
            DigitalWellbeingService.h0(context);
        }
        if (!b.f(context) && zX) {
            a.a("KeepAliveReceiver", "onReceive keep alive");
            DigitalWellbeingService.U(context);
        }
        if (zX) {
            com.stepos.digitalwellbeing.appwidget.b.d(context);
        }
        AppWidgetManagerService.y(context.getApplicationContext());
    }
}

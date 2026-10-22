package com.stepos.digitalwellbeing.server.limit;

import R1.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;

/* loaded from: classes.dex */
public class TimeLimitApproachReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i5;
        a.a("TLAR", "onReceive intent = " + intent.toString());
        if ("com.stepos.familyguard.DIGIT_WELLBEING_ALARM_LOCK".equals(intent.getAction())) {
            i5 = 11;
        } else if ("com.stepos.familyguard.DIGIT_WELLBEING_ALARM_UNLOCK".equals(intent.getAction())) {
            i5 = 12;
        } else if ("com.stepos.familyguard.DIGIT_WELLBEING_ALARM_NOTIFY".equals(intent.getAction())) {
            i5 = 13;
        } else if (!"com.stepos.familyguard.DIGIT_WELLBEING_ALARM_NOTIFY_ONLY".equals(intent.getAction())) {
            return;
        } else {
            i5 = 14;
        }
        DigitalWellbeingService.R(context, i5, intent.getExtras());
    }
}

package com.stepos.digitalwellbeing.server.limit;

import R1.a;
import Y1.v;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.appwidget.b;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.transaction.usagstats.alphame.c;
import p2.g;

/* loaded from: classes.dex */
public class UserPresentReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals("android.intent.action.USER_PRESENT", intent.getAction())) {
            g.F();
            g.V(context);
            if (g.x(context)) {
                b.d(context);
                AppWidgetManagerService.y(context.getApplicationContext());
            } else {
                b.u(context);
            }
            if (!T1.b.f(context) && !g.x(context)) {
                new Handler(Looper.getMainLooper()).postDelayed(new v(), 3000L);
                return;
            }
            a.a("UserPresentReceiver", "onReceive UserPresentReceiver");
            Log.e("AIOSBUG-4839-fix-v3", "USER_PRESENT received, granted=" + g.x(context));
            c.M(context);
            DigitalWellbeingService.f0(context);
        }
    }
}

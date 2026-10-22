package com.stepos.familyguard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.appwidget.b;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import p2.g;

/* loaded from: classes.dex */
public class PackageDataClearedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Uri data;
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (("android.intent.action.PACKAGE_DATA_CLEARED".equals(action) || "android.intent.action.PACKAGE_RESTARTED".equals(action)) && (data = intent.getData()) != null) {
            String schemeSpecificPart = data.getSchemeSpecificPart();
            if ("android.intent.action.PACKAGE_RESTARTED".equals(action) && TextUtils.equals("com.stepos.alphame", schemeSpecificPart) && g.x(context)) {
                DigitalWellbeingService.h0(context);
                DigitalWellbeingService.U(context);
            }
            if (TextUtils.equals(context.getPackageName(), schemeSpecificPart)) {
                if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(action)) {
                    g.k(context);
                    b.u(context);
                    return;
                }
                g.V(context);
                if (!g.x(context)) {
                    b.u(context);
                } else {
                    b.d(context);
                    AppWidgetManagerService.y(context.getApplicationContext());
                }
            }
        }
    }
}

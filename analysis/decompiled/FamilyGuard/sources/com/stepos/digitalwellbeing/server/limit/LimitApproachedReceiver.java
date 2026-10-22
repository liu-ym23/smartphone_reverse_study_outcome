package com.stepos.digitalwellbeing.server.limit;

import R1.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.minor.Minor;
import f2.C0702g;

/* loaded from: classes.dex */
public class LimitApproachedReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f14565a = a.f("LimitApproachedReceiver", a.f4966b);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals("com.stepos.digitalwellbeing.action.limit_approached", intent.getAction())) {
            String[] stringArrayExtra = intent.getStringArrayExtra("packages");
            int intExtra = intent.getIntExtra("reason", 0);
            int intExtra2 = intent.getIntExtra("type", 0);
            int intExtra3 = intent.getIntExtra(Minor.COLUMN_ID, 0);
            long longExtra = intent.getLongExtra("limit_time", 0L);
            int intExtra4 = intent.getIntExtra("category_id", 0);
            long longExtra2 = intent.getLongExtra("start_watch_time", 0L);
            DigitalWellbeingService.X(context, stringArrayExtra, intExtra, intExtra2, intExtra3, longExtra, intExtra4);
            if (f14565a) {
                a.a("LimitApproachedReceiver", "onReceive reason = " + intExtra + " type = " + intExtra2 + "observerId = " + intExtra3 + " limitTime = " + longExtra + " startLimitTime = " + longExtra2 + " categoryId = " + intExtra4 + " packages = " + C0702g.h(stringArrayExtra));
            }
        }
    }
}

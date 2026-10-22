package com.bytedance.applog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.d;
import java.util.Collections;

/* loaded from: classes.dex */
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.hasExtra("K_DATA")) {
            String[] stringArrayExtra = intent.getStringArrayExtra("K_DATA");
            if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
                LoggerImpl.global().error(Collections.singletonList("Collector"), "Event is null", new Object[0]);
                return;
            } else {
                b.a(stringArrayExtra);
                return;
            }
        }
        if (intent.hasExtra("K_ADD_CUSTOM_HEADER")) {
            String stringExtra = intent.getStringExtra("K_CUSTOM_HEADER_KEY");
            String stringExtra2 = intent.getStringExtra("K_CUSTOM_HEADER_VALUE");
            String stringExtra3 = intent.getStringExtra("K_APP_ID");
            d dVarA = b.a(stringExtra3);
            if (dVarA != null) {
                dVarA.setHeaderInfo(stringExtra, stringExtra2);
                return;
            } else {
                LoggerImpl.global().error(Collections.singletonList("Collector"), "Add custom failed, because find appLogInstance is null, appId: {}, customKey: {}, customValue: {}.", stringExtra3, stringExtra, stringExtra2);
                return;
            }
        }
        if (intent.hasExtra("K_REMOVE_CUSTOM_HEADER")) {
            String stringExtra4 = intent.getStringExtra("K_CUSTOM_HEADER_KEY");
            String stringExtra5 = intent.getStringExtra("K_APP_ID");
            d dVarA2 = b.a(stringExtra5);
            if (dVarA2 != null) {
                dVarA2.removeHeaderInfo(stringExtra4);
            } else {
                LoggerImpl.global().error(Collections.singletonList("Collector"), "Remove custom failed, because find appLogInstance is null, appId: {}, customKey: {}.", stringExtra5, stringExtra4);
            }
        }
    }
}

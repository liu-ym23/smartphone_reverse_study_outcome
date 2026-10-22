package com.stepos.agentsafetycenter.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p5.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class MidnightSyncBootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        context.getClass();
        if (k.a(intent != null ? intent.getAction() : null, "com.stepos.agentsafetycenter.KEEP_ALIVE")) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            f.H(applicationContext);
        }
    }
}

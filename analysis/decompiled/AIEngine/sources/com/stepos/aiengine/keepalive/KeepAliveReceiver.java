package com.stepos.aiengine.keepalive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KeepAliveReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        g.f(context, "context");
        g.f(intent, "intent");
        if (g.b(intent.getAction(), "com.stepos.aiengine.KEEP_ALIVE")) {
            Log.i("KeepAliveReceiver", "Keep-alive broadcast received; process awake, Application handles init");
        }
    }
}

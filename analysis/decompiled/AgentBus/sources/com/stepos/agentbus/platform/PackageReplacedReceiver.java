package com.stepos.agentbus.platform;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c7.r;
import kotlin.Metadata;
import n7.m;
import q7.k;
import s1.u;
import w7.e0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentbus/platform/PackageReplacedReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PackageReplacedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Object objN;
        k.e(context, "context");
        k.e(intent, "intent");
        if (k.a(intent.getAction(), "android.intent.action.MY_PACKAGE_REPLACED")) {
            Log.i("AgentBusPkgReplaced", "MY_PACKAGE_REPLACED → restarting AgentBusService");
            try {
                u uVar = AgentBusService.f2682m;
                Context applicationContext = context.getApplicationContext();
                k.d(applicationContext, "getApplicationContext(...)");
                m.H(applicationContext);
                objN = r.f1986a;
            } catch (Throwable th) {
                objN = e0.n(th);
            }
            Throwable thA = c7.m.a(objN);
            if (thA != null) {
                Log.e("AgentBusPkgReplaced", "start failed", thA);
            }
        }
    }
}

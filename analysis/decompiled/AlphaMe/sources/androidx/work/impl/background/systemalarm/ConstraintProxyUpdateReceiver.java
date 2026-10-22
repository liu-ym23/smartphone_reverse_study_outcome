package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import k.RunnableC0653g;
import s0.t;
import t0.C0913H;

/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4329a = t.f("ConstrntProxyUpdtRecvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            C0913H.e0(context).f15328e.a(new RunnableC0653g(1, this, intent, context, goAsync()));
        } else {
            t.d().a(f4329a, "Ignoring unknown action " + action);
        }
    }
}

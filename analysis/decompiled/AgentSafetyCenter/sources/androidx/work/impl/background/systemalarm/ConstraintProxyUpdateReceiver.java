package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.material.appbar.h;
import g5.u;
import h5.r;
import java.lang.invoke.VarHandle;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1669a = u.f("ConstrntProxyUpdtRecvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            u.d().a(f1669a, "Ignoring unknown action " + action);
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        i iVar = r.b(context).f5373d;
        h hVar = new h(1);
        hVar.f2367f = intent;
        hVar.f2368g = context;
        hVar.f2369h = pendingResultGoAsync;
        VarHandle.storeStoreFence();
        iVar.q(hVar);
    }
}

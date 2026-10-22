package androidx.work.impl.diagnostics;

import ac.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import g5.u;
import g5.v;
import g5.w;
import h5.n;
import h5.r;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1678a = u.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        u uVarD = u.d();
        String str = f1678a;
        uVarD.a(str, "Requesting diagnostics");
        try {
            context.getClass();
            r rVarB = r.b(context);
            List listE = a.E((w) new v(DiagnosticsWorker.class).a());
            if (listE.isEmpty()) {
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            }
            new n(rVarB, null, 2, listE, 0).a();
        } catch (IllegalStateException e10) {
            u.d().c(str, "WorkManager is not initialized", e10);
        }
    }
}

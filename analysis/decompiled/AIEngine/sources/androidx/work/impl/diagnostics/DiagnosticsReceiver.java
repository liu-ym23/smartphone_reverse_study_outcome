package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.ExistingWorkPolicy;
import androidx.work.impl.b;
import androidx.work.impl.workers.DiagnosticsWorker;
import h2.j;
import h2.l;
import i2.n;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2964a = j.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        j jVarD = j.d();
        String str = f2964a;
        jVarD.a(str, "Requesting diagnostics");
        try {
            g.f(context, "context");
            b bVarA = b.a(context);
            g.e(bVarA, "getInstance(context)");
            List listP = b1.P(new l.a(DiagnosticsWorker.class).a());
            if (listP.isEmpty()) {
                throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
            }
            new n(bVarA, null, ExistingWorkPolicy.f2775b, listP).a();
        } catch (IllegalStateException e10) {
            j.d().c(str, "WorkManager is not initialized", e10);
        }
    }
}

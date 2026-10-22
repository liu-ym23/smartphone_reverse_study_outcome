package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.impl.workers.DiagnosticsWorker;
import e.EnumC0546d;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;
import s0.t;
import s0.w;
import s0.x;
import t0.C0913H;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4339a = t.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        t tVarD = t.d();
        String str = f4339a;
        tVarD.a(str, "Requesting diagnostics");
        try {
            C0913H c0913hE0 = C0913H.e0(context);
            Intrinsics.checkNotNullParameter(DiagnosticsWorker.class, "workerClass");
            Intrinsics.checkNotNullParameter(DiagnosticsWorker.class, "workerClass");
            c0913hE0.d0(Collections.singletonList((x) new w(DiagnosticsWorker.class).a()));
        } catch (IllegalStateException e4) {
            t.d().c(str, "WorkManager is not initialized", e4);
        }
    }
}

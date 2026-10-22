package androidx.work.impl.workers;

import B0.f;
import B0.i;
import B0.m;
import B0.r;
import B0.u;
import B0.w;
import F0.b;
import Z2.I;
import android.content.Context;
import android.database.Cursor;
import androidx.room.A;
import androidx.room.E;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import s0.C;
import s0.C0847e;
import s0.C0850h;
import s0.EnumC0843a;
import s0.G;
import s0.q;
import s0.t;
import t0.C0913H;
import t0.J;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroidx/work/WorkerParameters;", "parameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(@NotNull Context context, @NotNull WorkerParameters parameters) {
        super(context, parameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    @Override // androidx.work.Worker
    public final q a() throws Throwable {
        E e4;
        i iVar;
        m mVar;
        w wVar;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        boolean z6;
        int i7;
        boolean z7;
        int i8;
        boolean z8;
        C0913H c0913hE0 = C0913H.e0(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(c0913hE0, "getInstance(applicationContext)");
        WorkDatabase workDatabase = c0913hE0.f15327d;
        Intrinsics.checkNotNullExpressionValue(workDatabase, "workManager.workDatabase");
        u uVarG = workDatabase.g();
        m mVarE = workDatabase.e();
        w wVarH = workDatabase.h();
        i iVarD = workDatabase.d();
        c0913hE0.f15326c.f14172c.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        uVarG.getClass();
        E eD = E.d(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        eD.bindLong(1, jCurrentTimeMillis);
        A a4 = uVarG.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            int iN = I.n(cursorH, "id");
            int iN2 = I.n(cursorH, "state");
            int iN3 = I.n(cursorH, "worker_class_name");
            int iN4 = I.n(cursorH, "input_merger_class_name");
            int iN5 = I.n(cursorH, "input");
            int iN6 = I.n(cursorH, "output");
            int iN7 = I.n(cursorH, "initial_delay");
            int iN8 = I.n(cursorH, "interval_duration");
            int iN9 = I.n(cursorH, "flex_duration");
            int iN10 = I.n(cursorH, "run_attempt_count");
            int iN11 = I.n(cursorH, "backoff_policy");
            int iN12 = I.n(cursorH, "backoff_delay_duration");
            int iN13 = I.n(cursorH, "last_enqueue_time");
            int iN14 = I.n(cursorH, "minimum_retention_duration");
            e4 = eD;
            try {
                int iN15 = I.n(cursorH, "schedule_requested_at");
                int iN16 = I.n(cursorH, "run_in_foreground");
                int iN17 = I.n(cursorH, "out_of_quota_policy");
                int iN18 = I.n(cursorH, "period_count");
                int iN19 = I.n(cursorH, "generation");
                int iN20 = I.n(cursorH, "next_schedule_time_override");
                int iN21 = I.n(cursorH, "next_schedule_time_override_generation");
                int iN22 = I.n(cursorH, "stop_reason");
                int iN23 = I.n(cursorH, "required_network_type");
                int iN24 = I.n(cursorH, "requires_charging");
                int iN25 = I.n(cursorH, "requires_device_idle");
                int iN26 = I.n(cursorH, "requires_battery_not_low");
                int iN27 = I.n(cursorH, "requires_storage_not_low");
                int iN28 = I.n(cursorH, "trigger_content_update_delay");
                int iN29 = I.n(cursorH, "trigger_max_content_delay");
                int iN30 = I.n(cursorH, "content_uri_triggers");
                int i9 = iN14;
                ArrayList arrayList = new ArrayList(cursorH.getCount());
                while (cursorH.moveToNext()) {
                    byte[] blob = null;
                    String string = cursorH.isNull(iN) ? null : cursorH.getString(iN);
                    G gP = f.P(cursorH.getInt(iN2));
                    String string2 = cursorH.isNull(iN3) ? null : cursorH.getString(iN3);
                    String string3 = cursorH.isNull(iN4) ? null : cursorH.getString(iN4);
                    C0850h c0850hA = C0850h.a(cursorH.isNull(iN5) ? null : cursorH.getBlob(iN5));
                    C0850h c0850hA2 = C0850h.a(cursorH.isNull(iN6) ? null : cursorH.getBlob(iN6));
                    long j4 = cursorH.getLong(iN7);
                    long j5 = cursorH.getLong(iN8);
                    long j6 = cursorH.getLong(iN9);
                    int i10 = cursorH.getInt(iN10);
                    EnumC0843a enumC0843aM = f.M(cursorH.getInt(iN11));
                    long j7 = cursorH.getLong(iN12);
                    long j8 = cursorH.getLong(iN13);
                    int i11 = i9;
                    long j9 = cursorH.getLong(i11);
                    int i12 = iN10;
                    int i13 = iN15;
                    long j10 = cursorH.getLong(i13);
                    iN15 = i13;
                    int i14 = iN16;
                    if (cursorH.getInt(i14) != 0) {
                        iN16 = i14;
                        i4 = iN17;
                        z4 = true;
                    } else {
                        iN16 = i14;
                        i4 = iN17;
                        z4 = false;
                    }
                    C cO = f.O(cursorH.getInt(i4));
                    iN17 = i4;
                    int i15 = iN18;
                    int i16 = cursorH.getInt(i15);
                    iN18 = i15;
                    int i17 = iN19;
                    int i18 = cursorH.getInt(i17);
                    iN19 = i17;
                    int i19 = iN20;
                    long j11 = cursorH.getLong(i19);
                    iN20 = i19;
                    int i20 = iN21;
                    int i21 = cursorH.getInt(i20);
                    iN21 = i20;
                    int i22 = iN22;
                    int i23 = cursorH.getInt(i22);
                    iN22 = i22;
                    int i24 = iN23;
                    s0.u uVarN = f.N(cursorH.getInt(i24));
                    iN23 = i24;
                    int i25 = iN24;
                    if (cursorH.getInt(i25) != 0) {
                        iN24 = i25;
                        i5 = iN25;
                        z5 = true;
                    } else {
                        iN24 = i25;
                        i5 = iN25;
                        z5 = false;
                    }
                    if (cursorH.getInt(i5) != 0) {
                        iN25 = i5;
                        i6 = iN26;
                        z6 = true;
                    } else {
                        iN25 = i5;
                        i6 = iN26;
                        z6 = false;
                    }
                    if (cursorH.getInt(i6) != 0) {
                        iN26 = i6;
                        i7 = iN27;
                        z7 = true;
                    } else {
                        iN26 = i6;
                        i7 = iN27;
                        z7 = false;
                    }
                    if (cursorH.getInt(i7) != 0) {
                        iN27 = i7;
                        i8 = iN28;
                        z8 = true;
                    } else {
                        iN27 = i7;
                        i8 = iN28;
                        z8 = false;
                    }
                    long j12 = cursorH.getLong(i8);
                    iN28 = i8;
                    int i26 = iN29;
                    long j13 = cursorH.getLong(i26);
                    iN29 = i26;
                    int i27 = iN30;
                    if (!cursorH.isNull(i27)) {
                        blob = cursorH.getBlob(i27);
                    }
                    iN30 = i27;
                    arrayList.add(new r(string, gP, string2, string3, c0850hA, c0850hA2, j4, j5, j6, new C0847e(uVarN, z5, z6, z7, z8, j12, j13, f.c(blob)), i10, enumC0843aM, j7, j8, j9, j10, z4, cO, i16, i18, j11, i21, i23));
                    iN10 = i12;
                    i9 = i11;
                }
                cursorH.close();
                e4.e();
                ArrayList arrayListE = uVarG.e();
                ArrayList arrayListB = uVarG.b();
                if (!arrayList.isEmpty()) {
                    t tVarD = t.d();
                    String str = b.f430a;
                    tVarD.e(str, "Recently completed work:\n\n");
                    iVar = iVarD;
                    mVar = mVarE;
                    wVar = wVarH;
                    t.d().e(str, b.a(mVar, wVar, iVar, arrayList));
                } else {
                    iVar = iVarD;
                    mVar = mVarE;
                    wVar = wVarH;
                }
                if (!arrayListE.isEmpty()) {
                    t tVarD2 = t.d();
                    String str2 = b.f430a;
                    tVarD2.e(str2, "Running work:\n\n");
                    t.d().e(str2, b.a(mVar, wVar, iVar, arrayListE));
                }
                if (!arrayListB.isEmpty()) {
                    t tVarD3 = t.d();
                    String str3 = b.f430a;
                    tVarD3.e(str3, "Enqueued work:\n\n");
                    t.d().e(str3, b.a(mVar, wVar, iVar, arrayListB));
                }
                q qVar = new q(C0850h.f14200c);
                Intrinsics.checkNotNullExpressionValue(qVar, "success()");
                return qVar;
            } catch (Throwable th) {
                th = th;
                cursorH.close();
                e4.e();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            e4 = eD;
        }
    }
}

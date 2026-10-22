package androidx.work.impl.workers;

import a.a;
import android.content.Context;
import android.database.Cursor;
import androidx.room.x;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import g5.r;
import java.util.ArrayList;
import p5.f;
import p5.i;
import p5.l;
import p5.p;
import p5.s;
import p5.u;
import q5.d;
import td.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @Override // androidx.work.Worker
    public final r b() throws Throwable {
        x xVar;
        int iZ;
        int iZ2;
        int iZ3;
        int iZ4;
        int iZ5;
        int iZ6;
        int iZ7;
        int iZ8;
        int iZ9;
        int iZ10;
        int iZ11;
        i iVar;
        l lVar;
        u uVar;
        h5.r rVarB = h5.r.b(this.f4338a);
        WorkDatabase workDatabase = rVarB.f5372c;
        workDatabase.getClass();
        s sVarC = workDatabase.C();
        l lVarA = workDatabase.A();
        u uVarD = workDatabase.D();
        i iVarZ = workDatabase.z();
        rVarB.f5371b.f4271d.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis() - 86400000;
        sVarC.getClass();
        x xVarD = x.d(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        xVarD.c(1, jCurrentTimeMillis);
        WorkDatabase_Impl workDatabase_Impl = sVarC.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = h.D(workDatabase_Impl, xVarD, false);
        try {
            iZ = f.z(cursorD, "id");
            iZ2 = f.z(cursorD, "state");
            iZ3 = f.z(cursorD, "worker_class_name");
            iZ4 = f.z(cursorD, "input_merger_class_name");
            iZ5 = f.z(cursorD, "input");
            iZ6 = f.z(cursorD, "output");
            iZ7 = f.z(cursorD, "initial_delay");
            iZ8 = f.z(cursorD, "interval_duration");
            iZ9 = f.z(cursorD, "flex_duration");
            iZ10 = f.z(cursorD, "run_attempt_count");
            iZ11 = f.z(cursorD, "backoff_policy");
            xVar = xVarD;
        } catch (Throwable th) {
            th = th;
            xVar = xVarD;
        }
        try {
            int iZ12 = f.z(cursorD, "backoff_delay_duration");
            int iZ13 = f.z(cursorD, "last_enqueue_time");
            int iZ14 = f.z(cursorD, "minimum_retention_duration");
            int iZ15 = f.z(cursorD, "schedule_requested_at");
            int iZ16 = f.z(cursorD, "run_in_foreground");
            int iZ17 = f.z(cursorD, "out_of_quota_policy");
            int iZ18 = f.z(cursorD, "period_count");
            int iZ19 = f.z(cursorD, "generation");
            int iZ20 = f.z(cursorD, "next_schedule_time_override");
            int iZ21 = f.z(cursorD, "next_schedule_time_override_generation");
            int iZ22 = f.z(cursorD, "stop_reason");
            int iZ23 = f.z(cursorD, "trace_tag");
            int iZ24 = f.z(cursorD, "required_network_type");
            int iZ25 = f.z(cursorD, "required_network_request");
            int iZ26 = f.z(cursorD, "requires_charging");
            int iZ27 = f.z(cursorD, "requires_device_idle");
            int iZ28 = f.z(cursorD, "requires_battery_not_low");
            int iZ29 = f.z(cursorD, "requires_storage_not_low");
            int iZ30 = f.z(cursorD, "trigger_content_update_delay");
            int iZ31 = f.z(cursorD, "trigger_max_content_delay");
            int iZ32 = f.z(cursorD, "content_uri_triggers");
            int i = iZ14;
            ArrayList arrayList = new ArrayList(cursorD.getCount());
            while (cursorD.moveToNext()) {
                String string = cursorD.getString(iZ);
                int iL = a.L(cursorD.getInt(iZ2));
                String string2 = cursorD.getString(iZ3);
                String string3 = cursorD.getString(iZ4);
                g5.h hVarA = g5.h.a(cursorD.getBlob(iZ5));
                g5.h hVarA2 = g5.h.a(cursorD.getBlob(iZ6));
                long j10 = cursorD.getLong(iZ7);
                long j11 = cursorD.getLong(iZ8);
                long j12 = cursorD.getLong(iZ9);
                int i3 = cursorD.getInt(iZ10);
                int I = a.I(cursorD.getInt(iZ11));
                long j13 = cursorD.getLong(iZ12);
                long j14 = cursorD.getLong(iZ13);
                int i10 = i;
                long j15 = cursorD.getLong(i10);
                int i11 = iZ9;
                int i12 = iZ15;
                long j16 = cursorD.getLong(i12);
                iZ15 = i12;
                int i13 = iZ16;
                boolean z10 = cursorD.getInt(i13) != 0;
                iZ16 = i13;
                int i14 = iZ17;
                int iK = a.K(cursorD.getInt(i14));
                iZ17 = i14;
                int i15 = iZ18;
                int i16 = cursorD.getInt(i15);
                iZ18 = i15;
                int i17 = iZ19;
                int i18 = cursorD.getInt(i17);
                iZ19 = i17;
                int i19 = iZ20;
                long j17 = cursorD.getLong(i19);
                iZ20 = i19;
                int i20 = iZ21;
                int i21 = cursorD.getInt(i20);
                iZ21 = i20;
                int i22 = iZ22;
                int i23 = cursorD.getInt(i22);
                iZ22 = i22;
                int i24 = iZ23;
                String string4 = cursorD.isNull(i24) ? null : cursorD.getString(i24);
                iZ23 = i24;
                int i25 = iZ24;
                int iJ = a.J(cursorD.getInt(i25));
                iZ24 = i25;
                int i26 = iZ25;
                d dVarA0 = a.a0(cursorD.getBlob(i26));
                iZ25 = i26;
                int i27 = iZ26;
                boolean z11 = cursorD.getInt(i27) != 0;
                iZ26 = i27;
                int i28 = iZ27;
                boolean z12 = cursorD.getInt(i28) != 0;
                iZ27 = i28;
                int i29 = iZ28;
                boolean z13 = cursorD.getInt(i29) != 0;
                iZ28 = i29;
                int i30 = iZ29;
                boolean z14 = cursorD.getInt(i30) != 0;
                iZ29 = i30;
                int i31 = iZ30;
                long j18 = cursorD.getLong(i31);
                iZ30 = i31;
                int i32 = iZ31;
                long j19 = cursorD.getLong(i32);
                iZ31 = i32;
                int i33 = iZ32;
                iZ32 = i33;
                arrayList.add(new p(string, iL, string2, string3, hVarA, hVarA2, j10, j11, j12, new g5.d(dVarA0, iJ, z11, z12, z13, z14, j18, j19, a.l(cursorD.getBlob(i33))), i3, I, j13, j14, j15, j16, z10, iK, i16, i18, j17, i21, i23, string4));
                iZ9 = i11;
                i = i10;
            }
            cursorD.close();
            xVar.e();
            ArrayList arrayListG = sVarC.g();
            ArrayList arrayListD = sVarC.d();
            if (arrayList.isEmpty()) {
                iVar = iVarZ;
                lVar = lVarA;
                uVar = uVarD;
            } else {
                g5.u uVarD2 = g5.u.d();
                String str = s5.a.f11407a;
                uVarD2.e(str, "Recently completed work:\n\n");
                iVar = iVarZ;
                lVar = lVarA;
                uVar = uVarD;
                g5.u.d().e(str, s5.a.a(lVar, uVar, iVar, arrayList));
            }
            if (!arrayListG.isEmpty()) {
                g5.u uVarD3 = g5.u.d();
                String str2 = s5.a.f11407a;
                uVarD3.e(str2, "Running work:\n\n");
                g5.u.d().e(str2, s5.a.a(lVar, uVar, iVar, arrayListG));
            }
            if (!arrayListD.isEmpty()) {
                g5.u uVarD4 = g5.u.d();
                String str3 = s5.a.f11407a;
                uVarD4.e(str3, "Enqueued work:\n\n");
                g5.u.d().e(str3, s5.a.a(lVar, uVar, iVar, arrayListD));
            }
            return g5.s.a();
        } catch (Throwable th2) {
            th = th2;
            cursorD.close();
            xVar.e();
            throw th;
        }
    }
}

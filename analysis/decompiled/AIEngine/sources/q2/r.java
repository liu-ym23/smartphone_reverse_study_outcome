package q2;

import android.database.Cursor;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase_Impl;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import kotlinx.coroutines.flow.Flow;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r implements q {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f11529a;

    /* renamed from: b, reason: collision with root package name */
    public final c f11530b;

    /* renamed from: c, reason: collision with root package name */
    public final j f11531c;

    /* renamed from: d, reason: collision with root package name */
    public final i f11532d;

    /* renamed from: e, reason: collision with root package name */
    public final j f11533e;

    /* renamed from: f, reason: collision with root package name */
    public final i f11534f;

    /* renamed from: g, reason: collision with root package name */
    public final j f11535g;
    public final i h;

    /* renamed from: i, reason: collision with root package name */
    public final j f11536i;

    /* renamed from: j, reason: collision with root package name */
    public final j f11537j;

    /* renamed from: k, reason: collision with root package name */
    public final j f11538k;

    /* renamed from: l, reason: collision with root package name */
    public final i f11539l;

    /* renamed from: m, reason: collision with root package name */
    public final j f11540m;

    /* renamed from: n, reason: collision with root package name */
    public final i f11541n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.room.l f11542a;

        public a(androidx.room.l lVar) {
            this.f11542a = lVar;
        }

        @Override // java.util.concurrent.Callable
        public final Boolean call() {
            Boolean boolValueOf;
            Cursor cursorM = r.this.f11529a.m(this.f11542a);
            try {
                if (cursorM.moveToFirst()) {
                    boolValueOf = Boolean.valueOf(cursorM.getInt(0) != 0);
                } else {
                    boolValueOf = Boolean.FALSE;
                }
                cursorM.close();
                return boolValueOf;
            } catch (Throwable th) {
                cursorM.close();
                throw th;
            }
        }

        public final void finalize() {
            this.f11542a.C();
        }
    }

    public r(WorkDatabase_Impl workDatabase_Impl) {
        this.f11529a = workDatabase_Impl;
        this.f11530b = new c(workDatabase_Impl, 5);
        new s(workDatabase_Impl);
        this.f11531c = new j(workDatabase_Impl, 6);
        this.f11532d = new i(workDatabase_Impl, 6);
        this.f11533e = new j(workDatabase_Impl, 7);
        this.f11534f = new i(workDatabase_Impl, 7);
        this.f11535g = new j(workDatabase_Impl, 8);
        this.h = new i(workDatabase_Impl, 8);
        this.f11536i = new j(workDatabase_Impl, 9);
        this.f11537j = new j(workDatabase_Impl, 2);
        new i(workDatabase_Impl, 2);
        this.f11538k = new j(workDatabase_Impl, 3);
        this.f11539l = new i(workDatabase_Impl, 3);
        this.f11540m = new j(workDatabase_Impl, 4);
        new i(workDatabase_Impl, 4);
        new j(workDatabase_Impl, 5);
        this.f11541n = new i(workDatabase_Impl, 5);
    }

    @Override // q2.q
    public final void a(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        j jVar = this.f11531c;
        y1.f fVarA = jVar.a();
        fVarA.Y(1, str);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final void b(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        i iVar = this.f11534f;
        y1.f fVarA = iVar.a();
        fVarA.Y(1, str);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            iVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final int c(long j10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        i iVar = this.f11539l;
        y1.f fVarA = iVar.a();
        fVarA.h0(1, j10);
        fVarA.Y(2, str);
        try {
            workDatabase_Impl.c();
            try {
                int iR = fVarA.r();
                workDatabase_Impl.p();
                return iR;
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            iVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final ArrayList d(long j10) throws Throwable {
        androidx.room.l lVar;
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC");
        lVarW.h0(1, j10);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, ModelDownloadNotifier.EXTRA_NOTIF_ID);
            int iA2 = v1.a.a(cursorM, "state");
            int iA3 = v1.a.a(cursorM, "worker_class_name");
            int iA4 = v1.a.a(cursorM, "input_merger_class_name");
            int iA5 = v1.a.a(cursorM, "input");
            int iA6 = v1.a.a(cursorM, "output");
            int iA7 = v1.a.a(cursorM, "initial_delay");
            int iA8 = v1.a.a(cursorM, "interval_duration");
            int iA9 = v1.a.a(cursorM, "flex_duration");
            int iA10 = v1.a.a(cursorM, "run_attempt_count");
            int iA11 = v1.a.a(cursorM, "backoff_policy");
            int iA12 = v1.a.a(cursorM, "backoff_delay_duration");
            int iA13 = v1.a.a(cursorM, "last_enqueue_time");
            int iA14 = v1.a.a(cursorM, "minimum_retention_duration");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "schedule_requested_at");
                int iA16 = v1.a.a(cursorM, "run_in_foreground");
                int iA17 = v1.a.a(cursorM, "out_of_quota_policy");
                int iA18 = v1.a.a(cursorM, "period_count");
                int iA19 = v1.a.a(cursorM, "generation");
                int iA20 = v1.a.a(cursorM, "next_schedule_time_override");
                int iA21 = v1.a.a(cursorM, "next_schedule_time_override_generation");
                int iA22 = v1.a.a(cursorM, "stop_reason");
                int iA23 = v1.a.a(cursorM, "trace_tag");
                int iA24 = v1.a.a(cursorM, "required_network_type");
                int iA25 = v1.a.a(cursorM, "required_network_request");
                int iA26 = v1.a.a(cursorM, "requires_charging");
                int iA27 = v1.a.a(cursorM, "requires_device_idle");
                int iA28 = v1.a.a(cursorM, "requires_battery_not_low");
                int iA29 = v1.a.a(cursorM, "requires_storage_not_low");
                int iA30 = v1.a.a(cursorM, "trigger_content_update_delay");
                int iA31 = v1.a.a(cursorM, "trigger_max_content_delay");
                int iA32 = v1.a.a(cursorM, "content_uri_triggers");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.getString(iA);
                    WorkInfo$State workInfo$StateF = v.f(cursorM.getInt(iA2));
                    String string2 = cursorM.getString(iA3);
                    String string3 = cursorM.getString(iA4);
                    Data dataA = Data.a(cursorM.getBlob(iA5));
                    Data dataA2 = Data.a(cursorM.getBlob(iA6));
                    long j11 = cursorM.getLong(iA7);
                    long j12 = cursorM.getLong(iA8);
                    long j13 = cursorM.getLong(iA9);
                    int i11 = cursorM.getInt(iA10);
                    BackoffPolicy backoffPolicyC = v.c(cursorM.getInt(iA11));
                    long j14 = cursorM.getLong(iA12);
                    long j15 = cursorM.getLong(iA13);
                    int i12 = i10;
                    long j16 = cursorM.getLong(i12);
                    i10 = i12;
                    int i13 = iA15;
                    long j17 = cursorM.getLong(i13);
                    iA15 = i13;
                    int i14 = iA16;
                    boolean z = cursorM.getInt(i14) != 0;
                    iA16 = i14;
                    int i15 = iA17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = v.e(cursorM.getInt(i15));
                    iA17 = i15;
                    int i16 = iA18;
                    int i17 = cursorM.getInt(i16);
                    iA18 = i16;
                    int i18 = iA19;
                    int i19 = cursorM.getInt(i18);
                    iA19 = i18;
                    int i20 = iA20;
                    long j18 = cursorM.getLong(i20);
                    iA20 = i20;
                    int i21 = iA21;
                    int i22 = cursorM.getInt(i21);
                    iA21 = i21;
                    int i23 = iA22;
                    int i24 = cursorM.getInt(i23);
                    iA22 = i23;
                    int i25 = iA23;
                    String string4 = cursorM.isNull(i25) ? null : cursorM.getString(i25);
                    iA23 = i25;
                    int i26 = iA24;
                    NetworkType networkTypeD = v.d(cursorM.getInt(i26));
                    iA24 = i26;
                    int i27 = iA25;
                    r2.g gVarJ = v.j(cursorM.getBlob(i27));
                    iA25 = i27;
                    int i28 = iA26;
                    boolean z3 = cursorM.getInt(i28) != 0;
                    iA26 = i28;
                    int i29 = iA27;
                    boolean z10 = cursorM.getInt(i29) != 0;
                    iA27 = i29;
                    int i30 = iA28;
                    boolean z11 = cursorM.getInt(i30) != 0;
                    iA28 = i30;
                    int i31 = iA29;
                    boolean z12 = cursorM.getInt(i31) != 0;
                    iA29 = i31;
                    int i32 = iA30;
                    long j19 = cursorM.getLong(i32);
                    iA30 = i32;
                    int i33 = iA31;
                    long j20 = cursorM.getLong(i33);
                    iA31 = i33;
                    int i34 = iA32;
                    iA32 = i34;
                    arrayList.add(new p(string, workInfo$StateF, string2, string3, dataA, dataA2, j11, j12, j13, new h2.c(gVarJ, networkTypeD, z3, z10, z11, z12, j19, j20, v.a(cursorM.getBlob(i34))), i11, backoffPolicyC, j14, j15, j16, j17, z, outOfQuotaPolicyE, i17, i19, j18, i22, i24, string4));
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.q
    public final void e(int i10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        j jVar = this.f11538k;
        y1.f fVarA = jVar.a();
        fVarA.Y(1, str);
        fVarA.h0(2, i10);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final ArrayList f() throws Throwable {
        androidx.room.l lVar;
        androidx.room.l lVarW = androidx.room.l.w(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, ModelDownloadNotifier.EXTRA_NOTIF_ID);
            int iA2 = v1.a.a(cursorM, "state");
            int iA3 = v1.a.a(cursorM, "worker_class_name");
            int iA4 = v1.a.a(cursorM, "input_merger_class_name");
            int iA5 = v1.a.a(cursorM, "input");
            int iA6 = v1.a.a(cursorM, "output");
            int iA7 = v1.a.a(cursorM, "initial_delay");
            int iA8 = v1.a.a(cursorM, "interval_duration");
            int iA9 = v1.a.a(cursorM, "flex_duration");
            int iA10 = v1.a.a(cursorM, "run_attempt_count");
            int iA11 = v1.a.a(cursorM, "backoff_policy");
            int iA12 = v1.a.a(cursorM, "backoff_delay_duration");
            int iA13 = v1.a.a(cursorM, "last_enqueue_time");
            int iA14 = v1.a.a(cursorM, "minimum_retention_duration");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "schedule_requested_at");
                int iA16 = v1.a.a(cursorM, "run_in_foreground");
                int iA17 = v1.a.a(cursorM, "out_of_quota_policy");
                int iA18 = v1.a.a(cursorM, "period_count");
                int iA19 = v1.a.a(cursorM, "generation");
                int iA20 = v1.a.a(cursorM, "next_schedule_time_override");
                int iA21 = v1.a.a(cursorM, "next_schedule_time_override_generation");
                int iA22 = v1.a.a(cursorM, "stop_reason");
                int iA23 = v1.a.a(cursorM, "trace_tag");
                int iA24 = v1.a.a(cursorM, "required_network_type");
                int iA25 = v1.a.a(cursorM, "required_network_request");
                int iA26 = v1.a.a(cursorM, "requires_charging");
                int iA27 = v1.a.a(cursorM, "requires_device_idle");
                int iA28 = v1.a.a(cursorM, "requires_battery_not_low");
                int iA29 = v1.a.a(cursorM, "requires_storage_not_low");
                int iA30 = v1.a.a(cursorM, "trigger_content_update_delay");
                int iA31 = v1.a.a(cursorM, "trigger_max_content_delay");
                int iA32 = v1.a.a(cursorM, "content_uri_triggers");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.getString(iA);
                    WorkInfo$State workInfo$StateF = v.f(cursorM.getInt(iA2));
                    String string2 = cursorM.getString(iA3);
                    String string3 = cursorM.getString(iA4);
                    Data dataA = Data.a(cursorM.getBlob(iA5));
                    Data dataA2 = Data.a(cursorM.getBlob(iA6));
                    long j10 = cursorM.getLong(iA7);
                    long j11 = cursorM.getLong(iA8);
                    long j12 = cursorM.getLong(iA9);
                    int i11 = cursorM.getInt(iA10);
                    BackoffPolicy backoffPolicyC = v.c(cursorM.getInt(iA11));
                    long j13 = cursorM.getLong(iA12);
                    long j14 = cursorM.getLong(iA13);
                    int i12 = i10;
                    long j15 = cursorM.getLong(i12);
                    i10 = i12;
                    int i13 = iA15;
                    long j16 = cursorM.getLong(i13);
                    iA15 = i13;
                    int i14 = iA16;
                    boolean z = cursorM.getInt(i14) != 0;
                    iA16 = i14;
                    int i15 = iA17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = v.e(cursorM.getInt(i15));
                    iA17 = i15;
                    int i16 = iA18;
                    int i17 = cursorM.getInt(i16);
                    iA18 = i16;
                    int i18 = iA19;
                    int i19 = cursorM.getInt(i18);
                    iA19 = i18;
                    int i20 = iA20;
                    long j17 = cursorM.getLong(i20);
                    iA20 = i20;
                    int i21 = iA21;
                    int i22 = cursorM.getInt(i21);
                    iA21 = i21;
                    int i23 = iA22;
                    int i24 = cursorM.getInt(i23);
                    iA22 = i23;
                    int i25 = iA23;
                    String string4 = cursorM.isNull(i25) ? null : cursorM.getString(i25);
                    iA23 = i25;
                    int i26 = iA24;
                    NetworkType networkTypeD = v.d(cursorM.getInt(i26));
                    iA24 = i26;
                    int i27 = iA25;
                    r2.g gVarJ = v.j(cursorM.getBlob(i27));
                    iA25 = i27;
                    int i28 = iA26;
                    boolean z3 = cursorM.getInt(i28) != 0;
                    iA26 = i28;
                    int i29 = iA27;
                    boolean z10 = cursorM.getInt(i29) != 0;
                    iA27 = i29;
                    int i30 = iA28;
                    boolean z11 = cursorM.getInt(i30) != 0;
                    iA28 = i30;
                    int i31 = iA29;
                    boolean z12 = cursorM.getInt(i31) != 0;
                    iA29 = i31;
                    int i32 = iA30;
                    long j18 = cursorM.getLong(i32);
                    iA30 = i32;
                    int i33 = iA31;
                    long j19 = cursorM.getLong(i33);
                    iA31 = i33;
                    int i34 = iA32;
                    iA32 = i34;
                    arrayList.add(new p(string, workInfo$StateF, string2, string3, dataA, dataA2, j10, j11, j12, new h2.c(gVarJ, networkTypeD, z3, z10, z11, z12, j18, j19, v.a(cursorM.getBlob(i34))), i11, backoffPolicyC, j13, j14, j15, j16, z, outOfQuotaPolicyE, i17, i19, j17, i22, i24, string4));
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.q
    public final ArrayList g(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(cursorM.getString(0));
            }
            return arrayList;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.q
    public final WorkInfo$State h(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT state FROM workspec WHERE id=?");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            WorkInfo$State workInfo$StateF = null;
            if (cursorM.moveToFirst()) {
                Integer numValueOf = cursorM.isNull(0) ? null : Integer.valueOf(cursorM.getInt(0));
                if (numValueOf != null) {
                    workInfo$StateF = v.f(numValueOf.intValue());
                }
            }
            return workInfo$StateF;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.q
    public final p i(String str) throws Throwable {
        androidx.room.l lVar;
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT * FROM workspec WHERE id=?");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, ModelDownloadNotifier.EXTRA_NOTIF_ID);
            int iA2 = v1.a.a(cursorM, "state");
            int iA3 = v1.a.a(cursorM, "worker_class_name");
            int iA4 = v1.a.a(cursorM, "input_merger_class_name");
            int iA5 = v1.a.a(cursorM, "input");
            int iA6 = v1.a.a(cursorM, "output");
            int iA7 = v1.a.a(cursorM, "initial_delay");
            int iA8 = v1.a.a(cursorM, "interval_duration");
            int iA9 = v1.a.a(cursorM, "flex_duration");
            int iA10 = v1.a.a(cursorM, "run_attempt_count");
            int iA11 = v1.a.a(cursorM, "backoff_policy");
            int iA12 = v1.a.a(cursorM, "backoff_delay_duration");
            int iA13 = v1.a.a(cursorM, "last_enqueue_time");
            int iA14 = v1.a.a(cursorM, "minimum_retention_duration");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "schedule_requested_at");
                int iA16 = v1.a.a(cursorM, "run_in_foreground");
                int iA17 = v1.a.a(cursorM, "out_of_quota_policy");
                int iA18 = v1.a.a(cursorM, "period_count");
                int iA19 = v1.a.a(cursorM, "generation");
                int iA20 = v1.a.a(cursorM, "next_schedule_time_override");
                int iA21 = v1.a.a(cursorM, "next_schedule_time_override_generation");
                int iA22 = v1.a.a(cursorM, "stop_reason");
                int iA23 = v1.a.a(cursorM, "trace_tag");
                int iA24 = v1.a.a(cursorM, "required_network_type");
                int iA25 = v1.a.a(cursorM, "required_network_request");
                int iA26 = v1.a.a(cursorM, "requires_charging");
                int iA27 = v1.a.a(cursorM, "requires_device_idle");
                int iA28 = v1.a.a(cursorM, "requires_battery_not_low");
                int iA29 = v1.a.a(cursorM, "requires_storage_not_low");
                int iA30 = v1.a.a(cursorM, "trigger_content_update_delay");
                int iA31 = v1.a.a(cursorM, "trigger_max_content_delay");
                int iA32 = v1.a.a(cursorM, "content_uri_triggers");
                p pVar = null;
                if (cursorM.moveToFirst()) {
                    pVar = new p(cursorM.getString(iA), v.f(cursorM.getInt(iA2)), cursorM.getString(iA3), cursorM.getString(iA4), Data.a(cursorM.getBlob(iA5)), Data.a(cursorM.getBlob(iA6)), cursorM.getLong(iA7), cursorM.getLong(iA8), cursorM.getLong(iA9), new h2.c(v.j(cursorM.getBlob(iA25)), v.d(cursorM.getInt(iA24)), cursorM.getInt(iA26) != 0, cursorM.getInt(iA27) != 0, cursorM.getInt(iA28) != 0, cursorM.getInt(iA29) != 0, cursorM.getLong(iA30), cursorM.getLong(iA31), v.a(cursorM.getBlob(iA32))), cursorM.getInt(iA10), v.c(cursorM.getInt(iA11)), cursorM.getLong(iA12), cursorM.getLong(iA13), cursorM.getLong(iA14), cursorM.getLong(iA15), cursorM.getInt(iA16) != 0, v.e(cursorM.getInt(iA17)), cursorM.getInt(iA18), cursorM.getInt(iA19), cursorM.getLong(iA20), cursorM.getInt(iA21), cursorM.getInt(iA22), cursorM.isNull(iA23) ? null : cursorM.getString(iA23));
                }
                cursorM.close();
                lVar.C();
                return pVar;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.q
    public final int j(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        j jVar = this.f11533e;
        y1.f fVarA = jVar.a();
        fVarA.Y(1, str);
        try {
            workDatabase_Impl.c();
            try {
                int iR = fVarA.r();
                workDatabase_Impl.p();
                return iR;
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final ArrayList k(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                arrayList.add(Data.a(cursorM.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.q
    public final int l() {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        j jVar = this.f11540m;
        y1.f fVarA = jVar.a();
        try {
            workDatabase_Impl.c();
            try {
                int iR = fVarA.r();
                workDatabase_Impl.p();
                return iR;
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final ArrayList m() throws Throwable {
        androidx.room.l lVar;
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        lVarW.h0(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, ModelDownloadNotifier.EXTRA_NOTIF_ID);
            int iA2 = v1.a.a(cursorM, "state");
            int iA3 = v1.a.a(cursorM, "worker_class_name");
            int iA4 = v1.a.a(cursorM, "input_merger_class_name");
            int iA5 = v1.a.a(cursorM, "input");
            int iA6 = v1.a.a(cursorM, "output");
            int iA7 = v1.a.a(cursorM, "initial_delay");
            int iA8 = v1.a.a(cursorM, "interval_duration");
            int iA9 = v1.a.a(cursorM, "flex_duration");
            int iA10 = v1.a.a(cursorM, "run_attempt_count");
            int iA11 = v1.a.a(cursorM, "backoff_policy");
            int iA12 = v1.a.a(cursorM, "backoff_delay_duration");
            int iA13 = v1.a.a(cursorM, "last_enqueue_time");
            int iA14 = v1.a.a(cursorM, "minimum_retention_duration");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "schedule_requested_at");
                int iA16 = v1.a.a(cursorM, "run_in_foreground");
                int iA17 = v1.a.a(cursorM, "out_of_quota_policy");
                int iA18 = v1.a.a(cursorM, "period_count");
                int iA19 = v1.a.a(cursorM, "generation");
                int iA20 = v1.a.a(cursorM, "next_schedule_time_override");
                int iA21 = v1.a.a(cursorM, "next_schedule_time_override_generation");
                int iA22 = v1.a.a(cursorM, "stop_reason");
                int iA23 = v1.a.a(cursorM, "trace_tag");
                int iA24 = v1.a.a(cursorM, "required_network_type");
                int iA25 = v1.a.a(cursorM, "required_network_request");
                int iA26 = v1.a.a(cursorM, "requires_charging");
                int iA27 = v1.a.a(cursorM, "requires_device_idle");
                int iA28 = v1.a.a(cursorM, "requires_battery_not_low");
                int iA29 = v1.a.a(cursorM, "requires_storage_not_low");
                int iA30 = v1.a.a(cursorM, "trigger_content_update_delay");
                int iA31 = v1.a.a(cursorM, "trigger_max_content_delay");
                int iA32 = v1.a.a(cursorM, "content_uri_triggers");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.getString(iA);
                    WorkInfo$State workInfo$StateF = v.f(cursorM.getInt(iA2));
                    String string2 = cursorM.getString(iA3);
                    String string3 = cursorM.getString(iA4);
                    Data dataA = Data.a(cursorM.getBlob(iA5));
                    Data dataA2 = Data.a(cursorM.getBlob(iA6));
                    long j10 = cursorM.getLong(iA7);
                    long j11 = cursorM.getLong(iA8);
                    long j12 = cursorM.getLong(iA9);
                    int i11 = cursorM.getInt(iA10);
                    BackoffPolicy backoffPolicyC = v.c(cursorM.getInt(iA11));
                    long j13 = cursorM.getLong(iA12);
                    long j14 = cursorM.getLong(iA13);
                    int i12 = i10;
                    long j15 = cursorM.getLong(i12);
                    i10 = i12;
                    int i13 = iA15;
                    long j16 = cursorM.getLong(i13);
                    iA15 = i13;
                    int i14 = iA16;
                    boolean z = cursorM.getInt(i14) != 0;
                    iA16 = i14;
                    int i15 = iA17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = v.e(cursorM.getInt(i15));
                    iA17 = i15;
                    int i16 = iA18;
                    int i17 = cursorM.getInt(i16);
                    iA18 = i16;
                    int i18 = iA19;
                    int i19 = cursorM.getInt(i18);
                    iA19 = i18;
                    int i20 = iA20;
                    long j17 = cursorM.getLong(i20);
                    iA20 = i20;
                    int i21 = iA21;
                    int i22 = cursorM.getInt(i21);
                    iA21 = i21;
                    int i23 = iA22;
                    int i24 = cursorM.getInt(i23);
                    iA22 = i23;
                    int i25 = iA23;
                    String string4 = cursorM.isNull(i25) ? null : cursorM.getString(i25);
                    iA23 = i25;
                    int i26 = iA24;
                    NetworkType networkTypeD = v.d(cursorM.getInt(i26));
                    iA24 = i26;
                    int i27 = iA25;
                    r2.g gVarJ = v.j(cursorM.getBlob(i27));
                    iA25 = i27;
                    int i28 = iA26;
                    boolean z3 = cursorM.getInt(i28) != 0;
                    iA26 = i28;
                    int i29 = iA27;
                    boolean z10 = cursorM.getInt(i29) != 0;
                    iA27 = i29;
                    int i30 = iA28;
                    boolean z11 = cursorM.getInt(i30) != 0;
                    iA28 = i30;
                    int i31 = iA29;
                    boolean z12 = cursorM.getInt(i31) != 0;
                    iA29 = i31;
                    int i32 = iA30;
                    long j18 = cursorM.getLong(i32);
                    iA30 = i32;
                    int i33 = iA31;
                    long j19 = cursorM.getLong(i33);
                    iA31 = i33;
                    int i34 = iA32;
                    iA32 = i34;
                    arrayList.add(new p(string, workInfo$StateF, string2, string3, dataA, dataA2, j10, j11, j12, new h2.c(gVarJ, networkTypeD, z3, z10, z11, z12, j18, j19, v.a(cursorM.getBlob(i34))), i11, backoffPolicyC, j13, j14, j15, j16, z, outOfQuotaPolicyE, i17, i19, j17, i22, i24, string4));
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.q
    public final void n(p pVar) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            this.f11530b.h(pVar);
            workDatabase_Impl.p();
        } finally {
            workDatabase_Impl.k();
        }
    }

    @Override // q2.q
    public final ArrayList o(String str) {
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        lVarW.Y(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            ArrayList arrayList = new ArrayList(cursorM.getCount());
            while (cursorM.moveToNext()) {
                String id2 = cursorM.getString(0);
                WorkInfo$State workInfo$StateF = v.f(cursorM.getInt(1));
                kotlin.jvm.internal.g.f(id2, "id");
                p.a aVar = new p.a();
                aVar.f11527a = id2;
                aVar.f11528b = workInfo$StateF;
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }

    @Override // q2.q
    public final Flow<Boolean> p() {
        a aVar = new a(androidx.room.l.w(0, "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"));
        return androidx.room.b.a(this.f11529a, new String[]{"workspec"}, aVar);
    }

    @Override // q2.q
    public final ArrayList q(int i10) throws Throwable {
        androidx.room.l lVar;
        androidx.room.l lVarW = androidx.room.l.w(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        lVarW.h0(1, i10);
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, ModelDownloadNotifier.EXTRA_NOTIF_ID);
            int iA2 = v1.a.a(cursorM, "state");
            int iA3 = v1.a.a(cursorM, "worker_class_name");
            int iA4 = v1.a.a(cursorM, "input_merger_class_name");
            int iA5 = v1.a.a(cursorM, "input");
            int iA6 = v1.a.a(cursorM, "output");
            int iA7 = v1.a.a(cursorM, "initial_delay");
            int iA8 = v1.a.a(cursorM, "interval_duration");
            int iA9 = v1.a.a(cursorM, "flex_duration");
            int iA10 = v1.a.a(cursorM, "run_attempt_count");
            int iA11 = v1.a.a(cursorM, "backoff_policy");
            int iA12 = v1.a.a(cursorM, "backoff_delay_duration");
            int iA13 = v1.a.a(cursorM, "last_enqueue_time");
            int iA14 = v1.a.a(cursorM, "minimum_retention_duration");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "schedule_requested_at");
                int iA16 = v1.a.a(cursorM, "run_in_foreground");
                int iA17 = v1.a.a(cursorM, "out_of_quota_policy");
                int iA18 = v1.a.a(cursorM, "period_count");
                int iA19 = v1.a.a(cursorM, "generation");
                int iA20 = v1.a.a(cursorM, "next_schedule_time_override");
                int iA21 = v1.a.a(cursorM, "next_schedule_time_override_generation");
                int iA22 = v1.a.a(cursorM, "stop_reason");
                int iA23 = v1.a.a(cursorM, "trace_tag");
                int iA24 = v1.a.a(cursorM, "required_network_type");
                int iA25 = v1.a.a(cursorM, "required_network_request");
                int iA26 = v1.a.a(cursorM, "requires_charging");
                int iA27 = v1.a.a(cursorM, "requires_device_idle");
                int iA28 = v1.a.a(cursorM, "requires_battery_not_low");
                int iA29 = v1.a.a(cursorM, "requires_storage_not_low");
                int iA30 = v1.a.a(cursorM, "trigger_content_update_delay");
                int iA31 = v1.a.a(cursorM, "trigger_max_content_delay");
                int iA32 = v1.a.a(cursorM, "content_uri_triggers");
                int i11 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.getString(iA);
                    WorkInfo$State workInfo$StateF = v.f(cursorM.getInt(iA2));
                    String string2 = cursorM.getString(iA3);
                    String string3 = cursorM.getString(iA4);
                    Data dataA = Data.a(cursorM.getBlob(iA5));
                    Data dataA2 = Data.a(cursorM.getBlob(iA6));
                    long j10 = cursorM.getLong(iA7);
                    long j11 = cursorM.getLong(iA8);
                    long j12 = cursorM.getLong(iA9);
                    int i12 = cursorM.getInt(iA10);
                    BackoffPolicy backoffPolicyC = v.c(cursorM.getInt(iA11));
                    long j13 = cursorM.getLong(iA12);
                    long j14 = cursorM.getLong(iA13);
                    int i13 = i11;
                    long j15 = cursorM.getLong(i13);
                    i11 = i13;
                    int i14 = iA15;
                    long j16 = cursorM.getLong(i14);
                    iA15 = i14;
                    int i15 = iA16;
                    boolean z = cursorM.getInt(i15) != 0;
                    iA16 = i15;
                    int i16 = iA17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = v.e(cursorM.getInt(i16));
                    iA17 = i16;
                    int i17 = iA18;
                    int i18 = cursorM.getInt(i17);
                    iA18 = i17;
                    int i19 = iA19;
                    int i20 = cursorM.getInt(i19);
                    iA19 = i19;
                    int i21 = iA20;
                    long j17 = cursorM.getLong(i21);
                    iA20 = i21;
                    int i22 = iA21;
                    int i23 = cursorM.getInt(i22);
                    iA21 = i22;
                    int i24 = iA22;
                    int i25 = cursorM.getInt(i24);
                    iA22 = i24;
                    int i26 = iA23;
                    String string4 = cursorM.isNull(i26) ? null : cursorM.getString(i26);
                    iA23 = i26;
                    int i27 = iA24;
                    NetworkType networkTypeD = v.d(cursorM.getInt(i27));
                    iA24 = i27;
                    int i28 = iA25;
                    r2.g gVarJ = v.j(cursorM.getBlob(i28));
                    iA25 = i28;
                    int i29 = iA26;
                    boolean z3 = cursorM.getInt(i29) != 0;
                    iA26 = i29;
                    int i30 = iA27;
                    boolean z10 = cursorM.getInt(i30) != 0;
                    iA27 = i30;
                    int i31 = iA28;
                    boolean z11 = cursorM.getInt(i31) != 0;
                    iA28 = i31;
                    int i32 = iA29;
                    boolean z12 = cursorM.getInt(i32) != 0;
                    iA29 = i32;
                    int i33 = iA30;
                    long j18 = cursorM.getLong(i33);
                    iA30 = i33;
                    int i34 = iA31;
                    long j19 = cursorM.getLong(i34);
                    iA31 = i34;
                    int i35 = iA32;
                    iA32 = i35;
                    arrayList.add(new p(string, workInfo$StateF, string2, string3, dataA, dataA2, j10, j11, j12, new h2.c(gVarJ, networkTypeD, z3, z10, z11, z12, j18, j19, v.a(cursorM.getBlob(i35))), i12, backoffPolicyC, j13, j14, j15, j16, z, outOfQuotaPolicyE, i18, i20, j17, i23, i25, string4));
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.q
    public final int r(WorkInfo$State workInfo$State, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        i iVar = this.f11532d;
        y1.f fVarA = iVar.a();
        fVarA.h0(1, v.i(workInfo$State));
        fVarA.Y(2, str);
        try {
            workDatabase_Impl.c();
            try {
                int iR = fVarA.r();
                workDatabase_Impl.p();
                return iR;
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            iVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final void s(long j10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        i iVar = this.h;
        y1.f fVarA = iVar.a();
        fVarA.h0(1, j10);
        fVarA.Y(2, str);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            iVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final void t(String str, Data data) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        j jVar = this.f11535g;
        y1.f fVarA = jVar.a();
        Data data2 = Data.f2768b;
        fVarA.F(Data.b.b(data), 1);
        fVarA.Y(2, str);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final ArrayList u() throws Throwable {
        androidx.room.l lVar;
        androidx.room.l lVarW = androidx.room.l.w(0, "SELECT * FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, ModelDownloadNotifier.EXTRA_NOTIF_ID);
            int iA2 = v1.a.a(cursorM, "state");
            int iA3 = v1.a.a(cursorM, "worker_class_name");
            int iA4 = v1.a.a(cursorM, "input_merger_class_name");
            int iA5 = v1.a.a(cursorM, "input");
            int iA6 = v1.a.a(cursorM, "output");
            int iA7 = v1.a.a(cursorM, "initial_delay");
            int iA8 = v1.a.a(cursorM, "interval_duration");
            int iA9 = v1.a.a(cursorM, "flex_duration");
            int iA10 = v1.a.a(cursorM, "run_attempt_count");
            int iA11 = v1.a.a(cursorM, "backoff_policy");
            int iA12 = v1.a.a(cursorM, "backoff_delay_duration");
            int iA13 = v1.a.a(cursorM, "last_enqueue_time");
            int iA14 = v1.a.a(cursorM, "minimum_retention_duration");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "schedule_requested_at");
                int iA16 = v1.a.a(cursorM, "run_in_foreground");
                int iA17 = v1.a.a(cursorM, "out_of_quota_policy");
                int iA18 = v1.a.a(cursorM, "period_count");
                int iA19 = v1.a.a(cursorM, "generation");
                int iA20 = v1.a.a(cursorM, "next_schedule_time_override");
                int iA21 = v1.a.a(cursorM, "next_schedule_time_override_generation");
                int iA22 = v1.a.a(cursorM, "stop_reason");
                int iA23 = v1.a.a(cursorM, "trace_tag");
                int iA24 = v1.a.a(cursorM, "required_network_type");
                int iA25 = v1.a.a(cursorM, "required_network_request");
                int iA26 = v1.a.a(cursorM, "requires_charging");
                int iA27 = v1.a.a(cursorM, "requires_device_idle");
                int iA28 = v1.a.a(cursorM, "requires_battery_not_low");
                int iA29 = v1.a.a(cursorM, "requires_storage_not_low");
                int iA30 = v1.a.a(cursorM, "trigger_content_update_delay");
                int iA31 = v1.a.a(cursorM, "trigger_max_content_delay");
                int iA32 = v1.a.a(cursorM, "content_uri_triggers");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.getString(iA);
                    WorkInfo$State workInfo$StateF = v.f(cursorM.getInt(iA2));
                    String string2 = cursorM.getString(iA3);
                    String string3 = cursorM.getString(iA4);
                    Data dataA = Data.a(cursorM.getBlob(iA5));
                    Data dataA2 = Data.a(cursorM.getBlob(iA6));
                    long j10 = cursorM.getLong(iA7);
                    long j11 = cursorM.getLong(iA8);
                    long j12 = cursorM.getLong(iA9);
                    int i11 = cursorM.getInt(iA10);
                    BackoffPolicy backoffPolicyC = v.c(cursorM.getInt(iA11));
                    long j13 = cursorM.getLong(iA12);
                    long j14 = cursorM.getLong(iA13);
                    int i12 = i10;
                    long j15 = cursorM.getLong(i12);
                    i10 = i12;
                    int i13 = iA15;
                    long j16 = cursorM.getLong(i13);
                    iA15 = i13;
                    int i14 = iA16;
                    boolean z = cursorM.getInt(i14) != 0;
                    iA16 = i14;
                    int i15 = iA17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = v.e(cursorM.getInt(i15));
                    iA17 = i15;
                    int i16 = iA18;
                    int i17 = cursorM.getInt(i16);
                    iA18 = i16;
                    int i18 = iA19;
                    int i19 = cursorM.getInt(i18);
                    iA19 = i18;
                    int i20 = iA20;
                    long j17 = cursorM.getLong(i20);
                    iA20 = i20;
                    int i21 = iA21;
                    int i22 = cursorM.getInt(i21);
                    iA21 = i21;
                    int i23 = iA22;
                    int i24 = cursorM.getInt(i23);
                    iA22 = i23;
                    int i25 = iA23;
                    String string4 = cursorM.isNull(i25) ? null : cursorM.getString(i25);
                    iA23 = i25;
                    int i26 = iA24;
                    NetworkType networkTypeD = v.d(cursorM.getInt(i26));
                    iA24 = i26;
                    int i27 = iA25;
                    r2.g gVarJ = v.j(cursorM.getBlob(i27));
                    iA25 = i27;
                    int i28 = iA26;
                    boolean z3 = cursorM.getInt(i28) != 0;
                    iA26 = i28;
                    int i29 = iA27;
                    boolean z10 = cursorM.getInt(i29) != 0;
                    iA27 = i29;
                    int i30 = iA28;
                    boolean z11 = cursorM.getInt(i30) != 0;
                    iA28 = i30;
                    int i31 = iA29;
                    boolean z12 = cursorM.getInt(i31) != 0;
                    iA29 = i31;
                    int i32 = iA30;
                    long j18 = cursorM.getLong(i32);
                    iA30 = i32;
                    int i33 = iA31;
                    long j19 = cursorM.getLong(i33);
                    iA31 = i33;
                    int i34 = iA32;
                    iA32 = i34;
                    arrayList.add(new p(string, workInfo$StateF, string2, string3, dataA, dataA2, j10, j11, j12, new h2.c(gVarJ, networkTypeD, z3, z10, z11, z12, j18, j19, v.a(cursorM.getBlob(i34))), i11, backoffPolicyC, j13, j14, j15, j16, z, outOfQuotaPolicyE, i17, i19, j17, i22, i24, string4));
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.q
    public final void v(int i10, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        i iVar = this.f11541n;
        y1.f fVarA = iVar.a();
        fVarA.h0(1, i10);
        fVarA.Y(2, str);
        try {
            workDatabase_Impl.c();
            try {
                fVarA.r();
                workDatabase_Impl.p();
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            iVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final ArrayList w() throws Throwable {
        androidx.room.l lVar;
        androidx.room.l lVarW = androidx.room.l.w(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            int iA = v1.a.a(cursorM, ModelDownloadNotifier.EXTRA_NOTIF_ID);
            int iA2 = v1.a.a(cursorM, "state");
            int iA3 = v1.a.a(cursorM, "worker_class_name");
            int iA4 = v1.a.a(cursorM, "input_merger_class_name");
            int iA5 = v1.a.a(cursorM, "input");
            int iA6 = v1.a.a(cursorM, "output");
            int iA7 = v1.a.a(cursorM, "initial_delay");
            int iA8 = v1.a.a(cursorM, "interval_duration");
            int iA9 = v1.a.a(cursorM, "flex_duration");
            int iA10 = v1.a.a(cursorM, "run_attempt_count");
            int iA11 = v1.a.a(cursorM, "backoff_policy");
            int iA12 = v1.a.a(cursorM, "backoff_delay_duration");
            int iA13 = v1.a.a(cursorM, "last_enqueue_time");
            int iA14 = v1.a.a(cursorM, "minimum_retention_duration");
            lVar = lVarW;
            try {
                int iA15 = v1.a.a(cursorM, "schedule_requested_at");
                int iA16 = v1.a.a(cursorM, "run_in_foreground");
                int iA17 = v1.a.a(cursorM, "out_of_quota_policy");
                int iA18 = v1.a.a(cursorM, "period_count");
                int iA19 = v1.a.a(cursorM, "generation");
                int iA20 = v1.a.a(cursorM, "next_schedule_time_override");
                int iA21 = v1.a.a(cursorM, "next_schedule_time_override_generation");
                int iA22 = v1.a.a(cursorM, "stop_reason");
                int iA23 = v1.a.a(cursorM, "trace_tag");
                int iA24 = v1.a.a(cursorM, "required_network_type");
                int iA25 = v1.a.a(cursorM, "required_network_request");
                int iA26 = v1.a.a(cursorM, "requires_charging");
                int iA27 = v1.a.a(cursorM, "requires_device_idle");
                int iA28 = v1.a.a(cursorM, "requires_battery_not_low");
                int iA29 = v1.a.a(cursorM, "requires_storage_not_low");
                int iA30 = v1.a.a(cursorM, "trigger_content_update_delay");
                int iA31 = v1.a.a(cursorM, "trigger_max_content_delay");
                int iA32 = v1.a.a(cursorM, "content_uri_triggers");
                int i10 = iA14;
                ArrayList arrayList = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    String string = cursorM.getString(iA);
                    WorkInfo$State workInfo$StateF = v.f(cursorM.getInt(iA2));
                    String string2 = cursorM.getString(iA3);
                    String string3 = cursorM.getString(iA4);
                    Data dataA = Data.a(cursorM.getBlob(iA5));
                    Data dataA2 = Data.a(cursorM.getBlob(iA6));
                    long j10 = cursorM.getLong(iA7);
                    long j11 = cursorM.getLong(iA8);
                    long j12 = cursorM.getLong(iA9);
                    int i11 = cursorM.getInt(iA10);
                    BackoffPolicy backoffPolicyC = v.c(cursorM.getInt(iA11));
                    long j13 = cursorM.getLong(iA12);
                    long j14 = cursorM.getLong(iA13);
                    int i12 = i10;
                    long j15 = cursorM.getLong(i12);
                    i10 = i12;
                    int i13 = iA15;
                    long j16 = cursorM.getLong(i13);
                    iA15 = i13;
                    int i14 = iA16;
                    boolean z = cursorM.getInt(i14) != 0;
                    iA16 = i14;
                    int i15 = iA17;
                    OutOfQuotaPolicy outOfQuotaPolicyE = v.e(cursorM.getInt(i15));
                    iA17 = i15;
                    int i16 = iA18;
                    int i17 = cursorM.getInt(i16);
                    iA18 = i16;
                    int i18 = iA19;
                    int i19 = cursorM.getInt(i18);
                    iA19 = i18;
                    int i20 = iA20;
                    long j17 = cursorM.getLong(i20);
                    iA20 = i20;
                    int i21 = iA21;
                    int i22 = cursorM.getInt(i21);
                    iA21 = i21;
                    int i23 = iA22;
                    int i24 = cursorM.getInt(i23);
                    iA22 = i23;
                    int i25 = iA23;
                    String string4 = cursorM.isNull(i25) ? null : cursorM.getString(i25);
                    iA23 = i25;
                    int i26 = iA24;
                    NetworkType networkTypeD = v.d(cursorM.getInt(i26));
                    iA24 = i26;
                    int i27 = iA25;
                    r2.g gVarJ = v.j(cursorM.getBlob(i27));
                    iA25 = i27;
                    int i28 = iA26;
                    boolean z3 = cursorM.getInt(i28) != 0;
                    iA26 = i28;
                    int i29 = iA27;
                    boolean z10 = cursorM.getInt(i29) != 0;
                    iA27 = i29;
                    int i30 = iA28;
                    boolean z11 = cursorM.getInt(i30) != 0;
                    iA28 = i30;
                    int i31 = iA29;
                    boolean z12 = cursorM.getInt(i31) != 0;
                    iA29 = i31;
                    int i32 = iA30;
                    long j18 = cursorM.getLong(i32);
                    iA30 = i32;
                    int i33 = iA31;
                    long j19 = cursorM.getLong(i33);
                    iA31 = i33;
                    int i34 = iA32;
                    iA32 = i34;
                    arrayList.add(new p(string, workInfo$StateF, string2, string3, dataA, dataA2, j10, j11, j12, new h2.c(gVarJ, networkTypeD, z3, z10, z11, z12, j18, j19, v.a(cursorM.getBlob(i34))), i11, backoffPolicyC, j13, j14, j15, j16, z, outOfQuotaPolicyE, i17, i19, j17, i22, i24, string4));
                }
                cursorM.close();
                lVar.C();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorM.close();
                lVar.C();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            lVar = lVarW;
        }
    }

    @Override // q2.q
    public final int x(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        j jVar = this.f11537j;
        y1.f fVarA = jVar.a();
        fVarA.Y(1, str);
        try {
            workDatabase_Impl.c();
            try {
                int iR = fVarA.r();
                workDatabase_Impl.p();
                return iR;
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final int y(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        j jVar = this.f11536i;
        y1.f fVarA = jVar.a();
        fVarA.Y(1, str);
        try {
            workDatabase_Impl.c();
            try {
                int iR = fVarA.r();
                workDatabase_Impl.p();
                return iR;
            } finally {
                workDatabase_Impl.k();
            }
        } finally {
            jVar.d(fVarA);
        }
    }

    @Override // q2.q
    public final int z() {
        androidx.room.l lVarW = androidx.room.l.w(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
        WorkDatabase_Impl workDatabase_Impl = this.f11529a;
        workDatabase_Impl.b();
        Cursor cursorM = workDatabase_Impl.m(lVarW);
        try {
            return cursorM.moveToFirst() ? cursorM.getInt(0) : 0;
        } finally {
            cursorM.close();
            lVarW.C();
        }
    }
}

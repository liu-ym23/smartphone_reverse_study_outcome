package p5;

import android.database.Cursor;
import androidx.room.x;
import androidx.work.impl.WorkDatabase_Impl;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase_Impl f9791a;

    /* renamed from: b, reason: collision with root package name */
    public final b f9792b;

    /* renamed from: c, reason: collision with root package name */
    public final h f9793c;

    /* renamed from: d, reason: collision with root package name */
    public final h f9794d;

    /* renamed from: e, reason: collision with root package name */
    public final h f9795e;

    /* renamed from: f, reason: collision with root package name */
    public final h f9796f;

    /* renamed from: g, reason: collision with root package name */
    public final h f9797g;

    /* renamed from: h, reason: collision with root package name */
    public final h f9798h;
    public final h i;

    /* renamed from: j, reason: collision with root package name */
    public final h f9799j;

    /* renamed from: k, reason: collision with root package name */
    public final h f9800k;

    /* renamed from: l, reason: collision with root package name */
    public final h f9801l;

    /* renamed from: m, reason: collision with root package name */
    public final h f9802m;

    /* renamed from: n, reason: collision with root package name */
    public final h f9803n;

    public s(WorkDatabase_Impl workDatabase_Impl) {
        this.f9791a = workDatabase_Impl;
        this.f9792b = new b(workDatabase_Impl, 5);
        new h(workDatabase_Impl, 12);
        this.f9793c = new h(workDatabase_Impl, 13);
        this.f9794d = new h(workDatabase_Impl, 14);
        this.f9795e = new h(workDatabase_Impl, 15);
        this.f9796f = new h(workDatabase_Impl, 16);
        this.f9797g = new h(workDatabase_Impl, 17);
        this.f9798h = new h(workDatabase_Impl, 18);
        this.i = new h(workDatabase_Impl, 19);
        this.f9799j = new h(workDatabase_Impl, 4);
        new h(workDatabase_Impl, 5);
        this.f9800k = new h(workDatabase_Impl, 6);
        this.f9801l = new h(workDatabase_Impl, 7);
        this.f9802m = new h(workDatabase_Impl, 8);
        new h(workDatabase_Impl, 9);
        new h(workDatabase_Impl, 10);
        this.f9803n = new h(workDatabase_Impl, 11);
    }

    public final void a(HashMap map) {
        Set setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            q qVar = new q(1);
            qVar.f9788f = this;
            VarHandle.storeStoreFence();
            ac.a.O(map, qVar);
            return;
        }
        StringBuilder sb2 = new StringBuilder("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        for (int i = 0; i < size; i++) {
            sb2.append("?");
            if (i < size - 1) {
                sb2.append(",");
            }
        }
        sb2.append(")");
        x xVarD = x.d(size, sb2.toString());
        Iterator it = setKeySet.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            xVarD.h(i3, (String) it.next());
            i3++;
        }
        Cursor cursorD = td.h.D(this.f9791a, xVarD, false);
        try {
            int iY = f.y(cursorD, "work_spec_id");
            if (iY == -1) {
                return;
            }
            while (cursorD.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorD.getString(iY));
                if (arrayList != null) {
                    arrayList.add(g5.h.a(cursorD.getBlob(0)));
                }
            }
        } finally {
            cursorD.close();
        }
    }

    public final void b(HashMap map) {
        Set setKeySet = map.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (map.size() > 999) {
            q qVar = new q(0);
            qVar.f9788f = this;
            VarHandle.storeStoreFence();
            ac.a.O(map, qVar);
            return;
        }
        StringBuilder sb2 = new StringBuilder("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = setKeySet.size();
        for (int i = 0; i < size; i++) {
            sb2.append("?");
            if (i < size - 1) {
                sb2.append(",");
            }
        }
        sb2.append(")");
        x xVarD = x.d(size, sb2.toString());
        Iterator it = setKeySet.iterator();
        int i3 = 1;
        while (it.hasNext()) {
            xVarD.h(i3, (String) it.next());
            i3++;
        }
        Cursor cursorD = td.h.D(this.f9791a, xVarD, false);
        try {
            int iY = f.y(cursorD, "work_spec_id");
            if (iY == -1) {
                return;
            }
            while (cursorD.moveToNext()) {
                ArrayList arrayList = (ArrayList) map.get(cursorD.getString(iY));
                if (arrayList != null) {
                    arrayList.add(cursorD.getString(0));
                }
            }
        } finally {
            cursorD.close();
        }
    }

    public final void c(String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        h hVar = this.f9793c;
        z4.j jVarA = hVar.a();
        jVarA.h(1, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar.c(jVarA);
        }
    }

    public final ArrayList d() throws Throwable {
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
        int iZ12;
        int iZ13;
        int iZ14;
        x xVarD = x.d(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        xVarD.c(1, 200);
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
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
            iZ12 = f.z(cursorD, "backoff_delay_duration");
            iZ13 = f.z(cursorD, "last_enqueue_time");
            iZ14 = f.z(cursorD, "minimum_retention_duration");
            xVar = xVarD;
        } catch (Throwable th) {
            th = th;
            xVar = xVarD;
        }
        try {
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
                int iL = a.a.L(cursorD.getInt(iZ2));
                String string2 = cursorD.getString(iZ3);
                String string3 = cursorD.getString(iZ4);
                g5.h hVarA = g5.h.a(cursorD.getBlob(iZ5));
                g5.h hVarA2 = g5.h.a(cursorD.getBlob(iZ6));
                long j10 = cursorD.getLong(iZ7);
                long j11 = cursorD.getLong(iZ8);
                long j12 = cursorD.getLong(iZ9);
                int i3 = cursorD.getInt(iZ10);
                int I = a.a.I(cursorD.getInt(iZ11));
                long j13 = cursorD.getLong(iZ12);
                long j14 = cursorD.getLong(iZ13);
                int i10 = i;
                long j15 = cursorD.getLong(i10);
                int i11 = iZ13;
                int i12 = iZ15;
                long j16 = cursorD.getLong(i12);
                iZ15 = i12;
                int i13 = iZ16;
                boolean z10 = cursorD.getInt(i13) != 0;
                iZ16 = i13;
                int i14 = iZ17;
                int iK = a.a.K(cursorD.getInt(i14));
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
                int iJ = a.a.J(cursorD.getInt(i25));
                iZ24 = i25;
                int i26 = iZ25;
                q5.d dVarA0 = a.a.a0(cursorD.getBlob(i26));
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
                arrayList.add(new p(string, iL, string2, string3, hVarA, hVarA2, j10, j11, j12, new g5.d(dVarA0, iJ, z11, z12, z13, z14, j18, j19, a.a.l(cursorD.getBlob(i33))), i3, I, j13, j14, j15, j16, z10, iK, i16, i18, j17, i21, i23, string4));
                iZ13 = i11;
                i = i10;
            }
            cursorD.close();
            xVar.e();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorD.close();
            xVar.e();
            throw th;
        }
    }

    public final ArrayList e(int i) throws Throwable {
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
        int iZ12;
        int iZ13;
        int iZ14;
        x xVarD = x.d(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        xVarD.c(1, i);
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
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
            iZ12 = f.z(cursorD, "backoff_delay_duration");
            iZ13 = f.z(cursorD, "last_enqueue_time");
            iZ14 = f.z(cursorD, "minimum_retention_duration");
            xVar = xVarD;
        } catch (Throwable th) {
            th = th;
            xVar = xVarD;
        }
        try {
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
            int i3 = iZ14;
            ArrayList arrayList = new ArrayList(cursorD.getCount());
            while (cursorD.moveToNext()) {
                String string = cursorD.getString(iZ);
                int iL = a.a.L(cursorD.getInt(iZ2));
                String string2 = cursorD.getString(iZ3);
                String string3 = cursorD.getString(iZ4);
                g5.h hVarA = g5.h.a(cursorD.getBlob(iZ5));
                g5.h hVarA2 = g5.h.a(cursorD.getBlob(iZ6));
                long j10 = cursorD.getLong(iZ7);
                long j11 = cursorD.getLong(iZ8);
                long j12 = cursorD.getLong(iZ9);
                int i10 = cursorD.getInt(iZ10);
                int I = a.a.I(cursorD.getInt(iZ11));
                long j13 = cursorD.getLong(iZ12);
                long j14 = cursorD.getLong(iZ13);
                int i11 = i3;
                long j15 = cursorD.getLong(i11);
                int i12 = iZ13;
                int i13 = iZ15;
                long j16 = cursorD.getLong(i13);
                iZ15 = i13;
                int i14 = iZ16;
                boolean z10 = cursorD.getInt(i14) != 0;
                iZ16 = i14;
                int i15 = iZ17;
                int iK = a.a.K(cursorD.getInt(i15));
                iZ17 = i15;
                int i16 = iZ18;
                int i17 = cursorD.getInt(i16);
                iZ18 = i16;
                int i18 = iZ19;
                int i19 = cursorD.getInt(i18);
                iZ19 = i18;
                int i20 = iZ20;
                long j17 = cursorD.getLong(i20);
                iZ20 = i20;
                int i21 = iZ21;
                int i22 = cursorD.getInt(i21);
                iZ21 = i21;
                int i23 = iZ22;
                int i24 = cursorD.getInt(i23);
                iZ22 = i23;
                int i25 = iZ23;
                String string4 = cursorD.isNull(i25) ? null : cursorD.getString(i25);
                iZ23 = i25;
                int i26 = iZ24;
                int iJ = a.a.J(cursorD.getInt(i26));
                iZ24 = i26;
                int i27 = iZ25;
                q5.d dVarA0 = a.a.a0(cursorD.getBlob(i27));
                iZ25 = i27;
                int i28 = iZ26;
                boolean z11 = cursorD.getInt(i28) != 0;
                iZ26 = i28;
                int i29 = iZ27;
                boolean z12 = cursorD.getInt(i29) != 0;
                iZ27 = i29;
                int i30 = iZ28;
                boolean z13 = cursorD.getInt(i30) != 0;
                iZ28 = i30;
                int i31 = iZ29;
                boolean z14 = cursorD.getInt(i31) != 0;
                iZ29 = i31;
                int i32 = iZ30;
                long j18 = cursorD.getLong(i32);
                iZ30 = i32;
                int i33 = iZ31;
                long j19 = cursorD.getLong(i33);
                iZ31 = i33;
                int i34 = iZ32;
                iZ32 = i34;
                arrayList.add(new p(string, iL, string2, string3, hVarA, hVarA2, j10, j11, j12, new g5.d(dVarA0, iJ, z11, z12, z13, z14, j18, j19, a.a.l(cursorD.getBlob(i34))), i10, I, j13, j14, j15, j16, z10, iK, i17, i19, j17, i22, i24, string4));
                iZ13 = i12;
                i3 = i11;
            }
            cursorD.close();
            xVar.e();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorD.close();
            xVar.e();
            throw th;
        }
    }

    public final ArrayList f() throws Throwable {
        x xVar;
        x xVarD = x.d(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            int iZ = f.z(cursorD, "id");
            int iZ2 = f.z(cursorD, "state");
            int iZ3 = f.z(cursorD, "worker_class_name");
            int iZ4 = f.z(cursorD, "input_merger_class_name");
            int iZ5 = f.z(cursorD, "input");
            int iZ6 = f.z(cursorD, "output");
            int iZ7 = f.z(cursorD, "initial_delay");
            int iZ8 = f.z(cursorD, "interval_duration");
            int iZ9 = f.z(cursorD, "flex_duration");
            int iZ10 = f.z(cursorD, "run_attempt_count");
            int iZ11 = f.z(cursorD, "backoff_policy");
            int iZ12 = f.z(cursorD, "backoff_delay_duration");
            int iZ13 = f.z(cursorD, "last_enqueue_time");
            int iZ14 = f.z(cursorD, "minimum_retention_duration");
            xVar = xVarD;
            try {
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
                    int iL = a.a.L(cursorD.getInt(iZ2));
                    String string2 = cursorD.getString(iZ3);
                    String string3 = cursorD.getString(iZ4);
                    g5.h hVarA = g5.h.a(cursorD.getBlob(iZ5));
                    g5.h hVarA2 = g5.h.a(cursorD.getBlob(iZ6));
                    long j10 = cursorD.getLong(iZ7);
                    long j11 = cursorD.getLong(iZ8);
                    long j12 = cursorD.getLong(iZ9);
                    int i3 = cursorD.getInt(iZ10);
                    int I = a.a.I(cursorD.getInt(iZ11));
                    long j13 = cursorD.getLong(iZ12);
                    long j14 = cursorD.getLong(iZ13);
                    int i10 = i;
                    long j15 = cursorD.getLong(i10);
                    i = i10;
                    int i11 = iZ15;
                    long j16 = cursorD.getLong(i11);
                    iZ15 = i11;
                    int i12 = iZ16;
                    boolean z10 = cursorD.getInt(i12) != 0;
                    iZ16 = i12;
                    int i13 = iZ17;
                    int iK = a.a.K(cursorD.getInt(i13));
                    iZ17 = i13;
                    int i14 = iZ18;
                    int i15 = cursorD.getInt(i14);
                    iZ18 = i14;
                    int i16 = iZ19;
                    int i17 = cursorD.getInt(i16);
                    iZ19 = i16;
                    int i18 = iZ20;
                    long j17 = cursorD.getLong(i18);
                    iZ20 = i18;
                    int i19 = iZ21;
                    int i20 = cursorD.getInt(i19);
                    iZ21 = i19;
                    int i21 = iZ22;
                    int i22 = cursorD.getInt(i21);
                    iZ22 = i21;
                    int i23 = iZ23;
                    String string4 = cursorD.isNull(i23) ? null : cursorD.getString(i23);
                    iZ23 = i23;
                    int i24 = iZ24;
                    int iJ = a.a.J(cursorD.getInt(i24));
                    iZ24 = i24;
                    int i25 = iZ25;
                    q5.d dVarA0 = a.a.a0(cursorD.getBlob(i25));
                    iZ25 = i25;
                    int i26 = iZ26;
                    boolean z11 = cursorD.getInt(i26) != 0;
                    iZ26 = i26;
                    int i27 = iZ27;
                    boolean z12 = cursorD.getInt(i27) != 0;
                    iZ27 = i27;
                    int i28 = iZ28;
                    boolean z13 = cursorD.getInt(i28) != 0;
                    iZ28 = i28;
                    int i29 = iZ29;
                    boolean z14 = cursorD.getInt(i29) != 0;
                    iZ29 = i29;
                    int i30 = iZ30;
                    long j18 = cursorD.getLong(i30);
                    iZ30 = i30;
                    int i31 = iZ31;
                    long j19 = cursorD.getLong(i31);
                    iZ31 = i31;
                    int i32 = iZ32;
                    iZ32 = i32;
                    arrayList.add(new p(string, iL, string2, string3, hVarA, hVarA2, j10, j11, j12, new g5.d(dVarA0, iJ, z11, z12, z13, z14, j18, j19, a.a.l(cursorD.getBlob(i32))), i3, I, j13, j14, j15, j16, z10, iK, i15, i17, j17, i20, i22, string4));
                }
                cursorD.close();
                xVar.e();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorD.close();
                xVar.e();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarD;
        }
    }

    public final ArrayList g() throws Throwable {
        x xVar;
        x xVarD = x.d(0, "SELECT * FROM workspec WHERE state=1");
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            int iZ = f.z(cursorD, "id");
            int iZ2 = f.z(cursorD, "state");
            int iZ3 = f.z(cursorD, "worker_class_name");
            int iZ4 = f.z(cursorD, "input_merger_class_name");
            int iZ5 = f.z(cursorD, "input");
            int iZ6 = f.z(cursorD, "output");
            int iZ7 = f.z(cursorD, "initial_delay");
            int iZ8 = f.z(cursorD, "interval_duration");
            int iZ9 = f.z(cursorD, "flex_duration");
            int iZ10 = f.z(cursorD, "run_attempt_count");
            int iZ11 = f.z(cursorD, "backoff_policy");
            int iZ12 = f.z(cursorD, "backoff_delay_duration");
            int iZ13 = f.z(cursorD, "last_enqueue_time");
            int iZ14 = f.z(cursorD, "minimum_retention_duration");
            xVar = xVarD;
            try {
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
                    int iL = a.a.L(cursorD.getInt(iZ2));
                    String string2 = cursorD.getString(iZ3);
                    String string3 = cursorD.getString(iZ4);
                    g5.h hVarA = g5.h.a(cursorD.getBlob(iZ5));
                    g5.h hVarA2 = g5.h.a(cursorD.getBlob(iZ6));
                    long j10 = cursorD.getLong(iZ7);
                    long j11 = cursorD.getLong(iZ8);
                    long j12 = cursorD.getLong(iZ9);
                    int i3 = cursorD.getInt(iZ10);
                    int I = a.a.I(cursorD.getInt(iZ11));
                    long j13 = cursorD.getLong(iZ12);
                    long j14 = cursorD.getLong(iZ13);
                    int i10 = i;
                    long j15 = cursorD.getLong(i10);
                    i = i10;
                    int i11 = iZ15;
                    long j16 = cursorD.getLong(i11);
                    iZ15 = i11;
                    int i12 = iZ16;
                    boolean z10 = cursorD.getInt(i12) != 0;
                    iZ16 = i12;
                    int i13 = iZ17;
                    int iK = a.a.K(cursorD.getInt(i13));
                    iZ17 = i13;
                    int i14 = iZ18;
                    int i15 = cursorD.getInt(i14);
                    iZ18 = i14;
                    int i16 = iZ19;
                    int i17 = cursorD.getInt(i16);
                    iZ19 = i16;
                    int i18 = iZ20;
                    long j17 = cursorD.getLong(i18);
                    iZ20 = i18;
                    int i19 = iZ21;
                    int i20 = cursorD.getInt(i19);
                    iZ21 = i19;
                    int i21 = iZ22;
                    int i22 = cursorD.getInt(i21);
                    iZ22 = i21;
                    int i23 = iZ23;
                    String string4 = cursorD.isNull(i23) ? null : cursorD.getString(i23);
                    iZ23 = i23;
                    int i24 = iZ24;
                    int iJ = a.a.J(cursorD.getInt(i24));
                    iZ24 = i24;
                    int i25 = iZ25;
                    q5.d dVarA0 = a.a.a0(cursorD.getBlob(i25));
                    iZ25 = i25;
                    int i26 = iZ26;
                    boolean z11 = cursorD.getInt(i26) != 0;
                    iZ26 = i26;
                    int i27 = iZ27;
                    boolean z12 = cursorD.getInt(i27) != 0;
                    iZ27 = i27;
                    int i28 = iZ28;
                    boolean z13 = cursorD.getInt(i28) != 0;
                    iZ28 = i28;
                    int i29 = iZ29;
                    boolean z14 = cursorD.getInt(i29) != 0;
                    iZ29 = i29;
                    int i30 = iZ30;
                    long j18 = cursorD.getLong(i30);
                    iZ30 = i30;
                    int i31 = iZ31;
                    long j19 = cursorD.getLong(i31);
                    iZ31 = i31;
                    int i32 = iZ32;
                    iZ32 = i32;
                    arrayList.add(new p(string, iL, string2, string3, hVarA, hVarA2, j10, j11, j12, new g5.d(dVarA0, iJ, z11, z12, z13, z14, j18, j19, a.a.l(cursorD.getBlob(i32))), i3, I, j13, j14, j15, j16, z10, iK, i15, i17, j17, i20, i22, string4));
                }
                cursorD.close();
                xVar.e();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorD.close();
                xVar.e();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarD;
        }
    }

    public final ArrayList h() {
        x xVar;
        x xVarD = x.d(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            int iZ = f.z(cursorD, "id");
            int iZ2 = f.z(cursorD, "state");
            int iZ3 = f.z(cursorD, "worker_class_name");
            int iZ4 = f.z(cursorD, "input_merger_class_name");
            int iZ5 = f.z(cursorD, "input");
            int iZ6 = f.z(cursorD, "output");
            int iZ7 = f.z(cursorD, "initial_delay");
            int iZ8 = f.z(cursorD, "interval_duration");
            int iZ9 = f.z(cursorD, "flex_duration");
            int iZ10 = f.z(cursorD, "run_attempt_count");
            int iZ11 = f.z(cursorD, "backoff_policy");
            int iZ12 = f.z(cursorD, "backoff_delay_duration");
            int iZ13 = f.z(cursorD, "last_enqueue_time");
            int iZ14 = f.z(cursorD, "minimum_retention_duration");
            xVar = xVarD;
            try {
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
                    int iL = a.a.L(cursorD.getInt(iZ2));
                    String string2 = cursorD.getString(iZ3);
                    String string3 = cursorD.getString(iZ4);
                    g5.h hVarA = g5.h.a(cursorD.getBlob(iZ5));
                    g5.h hVarA2 = g5.h.a(cursorD.getBlob(iZ6));
                    long j10 = cursorD.getLong(iZ7);
                    long j11 = cursorD.getLong(iZ8);
                    long j12 = cursorD.getLong(iZ9);
                    int i3 = cursorD.getInt(iZ10);
                    int I = a.a.I(cursorD.getInt(iZ11));
                    long j13 = cursorD.getLong(iZ12);
                    long j14 = cursorD.getLong(iZ13);
                    int i10 = i;
                    long j15 = cursorD.getLong(i10);
                    i = i10;
                    int i11 = iZ15;
                    long j16 = cursorD.getLong(i11);
                    iZ15 = i11;
                    int i12 = iZ16;
                    boolean z10 = cursorD.getInt(i12) != 0;
                    iZ16 = i12;
                    int i13 = iZ17;
                    int iK = a.a.K(cursorD.getInt(i13));
                    iZ17 = i13;
                    int i14 = iZ18;
                    int i15 = cursorD.getInt(i14);
                    iZ18 = i14;
                    int i16 = iZ19;
                    int i17 = cursorD.getInt(i16);
                    iZ19 = i16;
                    int i18 = iZ20;
                    long j17 = cursorD.getLong(i18);
                    iZ20 = i18;
                    int i19 = iZ21;
                    int i20 = cursorD.getInt(i19);
                    iZ21 = i19;
                    int i21 = iZ22;
                    int i22 = cursorD.getInt(i21);
                    iZ22 = i21;
                    int i23 = iZ23;
                    String string4 = cursorD.isNull(i23) ? null : cursorD.getString(i23);
                    iZ23 = i23;
                    int i24 = iZ24;
                    int iJ = a.a.J(cursorD.getInt(i24));
                    iZ24 = i24;
                    int i25 = iZ25;
                    q5.d dVarA0 = a.a.a0(cursorD.getBlob(i25));
                    iZ25 = i25;
                    int i26 = iZ26;
                    boolean z11 = cursorD.getInt(i26) != 0;
                    iZ26 = i26;
                    int i27 = iZ27;
                    boolean z12 = cursorD.getInt(i27) != 0;
                    iZ27 = i27;
                    int i28 = iZ28;
                    boolean z13 = cursorD.getInt(i28) != 0;
                    iZ28 = i28;
                    int i29 = iZ29;
                    boolean z14 = cursorD.getInt(i29) != 0;
                    iZ29 = i29;
                    int i30 = iZ30;
                    long j18 = cursorD.getLong(i30);
                    iZ30 = i30;
                    int i31 = iZ31;
                    long j19 = cursorD.getLong(i31);
                    iZ31 = i31;
                    int i32 = iZ32;
                    iZ32 = i32;
                    arrayList.add(new p(string, iL, string2, string3, hVarA, hVarA2, j10, j11, j12, new g5.d(dVarA0, iJ, z11, z12, z13, z14, j18, j19, a.a.l(cursorD.getBlob(i32))), i3, I, j13, j14, j15, j16, z10, iK, i15, i17, j17, i20, i22, string4));
                }
                cursorD.close();
                xVar.e();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorD.close();
                xVar.e();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarD;
        }
    }

    public final int i(String str) {
        x xVarD = x.d(1, "SELECT state FROM workspec WHERE id=?");
        xVarD.h(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        int iL = 0;
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            if (cursorD.moveToFirst()) {
                Integer numValueOf = cursorD.isNull(0) ? null : Integer.valueOf(cursorD.getInt(0));
                if (numValueOf != null) {
                    iL = a.a.L(numValueOf.intValue());
                }
            }
            return iL;
        } finally {
            cursorD.close();
            xVarD.e();
        }
    }

    public final p j(String str) throws Throwable {
        x xVar;
        x xVarD = x.d(1, "SELECT * FROM workspec WHERE id=?");
        xVarD.h(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            int iZ = f.z(cursorD, "id");
            int iZ2 = f.z(cursorD, "state");
            int iZ3 = f.z(cursorD, "worker_class_name");
            int iZ4 = f.z(cursorD, "input_merger_class_name");
            int iZ5 = f.z(cursorD, "input");
            int iZ6 = f.z(cursorD, "output");
            int iZ7 = f.z(cursorD, "initial_delay");
            int iZ8 = f.z(cursorD, "interval_duration");
            int iZ9 = f.z(cursorD, "flex_duration");
            int iZ10 = f.z(cursorD, "run_attempt_count");
            int iZ11 = f.z(cursorD, "backoff_policy");
            int iZ12 = f.z(cursorD, "backoff_delay_duration");
            int iZ13 = f.z(cursorD, "last_enqueue_time");
            int iZ14 = f.z(cursorD, "minimum_retention_duration");
            xVar = xVarD;
            try {
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
                p pVar = null;
                if (cursorD.moveToFirst()) {
                    pVar = new p(cursorD.getString(iZ), a.a.L(cursorD.getInt(iZ2)), cursorD.getString(iZ3), cursorD.getString(iZ4), g5.h.a(cursorD.getBlob(iZ5)), g5.h.a(cursorD.getBlob(iZ6)), cursorD.getLong(iZ7), cursorD.getLong(iZ8), cursorD.getLong(iZ9), new g5.d(a.a.a0(cursorD.getBlob(iZ25)), a.a.J(cursorD.getInt(iZ24)), cursorD.getInt(iZ26) != 0, cursorD.getInt(iZ27) != 0, cursorD.getInt(iZ28) != 0, cursorD.getInt(iZ29) != 0, cursorD.getLong(iZ30), cursorD.getLong(iZ31), a.a.l(cursorD.getBlob(iZ32))), cursorD.getInt(iZ10), a.a.I(cursorD.getInt(iZ11)), cursorD.getLong(iZ12), cursorD.getLong(iZ13), cursorD.getLong(iZ14), cursorD.getLong(iZ15), cursorD.getInt(iZ16) != 0, a.a.K(cursorD.getInt(iZ17)), cursorD.getInt(iZ18), cursorD.getInt(iZ19), cursorD.getLong(iZ20), cursorD.getInt(iZ21), cursorD.getInt(iZ22), cursorD.isNull(iZ23) ? null : cursorD.getString(iZ23));
                }
                cursorD.close();
                xVar.e();
                return pVar;
            } catch (Throwable th) {
                th = th;
                cursorD.close();
                xVar.e();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            xVar = xVarD;
        }
    }

    public final ArrayList k(String str) {
        x xVarD = x.d(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        xVarD.h(1, str);
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            ArrayList arrayList = new ArrayList(cursorD.getCount());
            while (cursorD.moveToNext()) {
                String string = cursorD.getString(0);
                int iL = a.a.L(cursorD.getInt(1));
                string.getClass();
                n nVar = new n();
                nVar.f9744a = string;
                nVar.f9745b = iL;
                arrayList.add(nVar);
            }
            return arrayList;
        } finally {
            cursorD.close();
            xVarD.e();
        }
    }

    public final void l(String str, long j10) {
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        h hVar = this.f9801l;
        z4.j jVarA = hVar.a();
        jVarA.c(1, j10);
        jVarA.h(2, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar.c(jVarA);
        }
    }

    public final void m(int i, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        h hVar = this.f9800k;
        z4.j jVarA = hVar.a();
        jVarA.h(1, str);
        jVarA.c(2, i);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar.c(jVarA);
        }
    }

    public final void n(String str, long j10) {
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        h hVar = this.f9798h;
        z4.j jVarA = hVar.a();
        jVarA.c(1, j10);
        jVarA.h(2, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar.c(jVarA);
        }
    }

    public final void o(String str, g5.h hVar) {
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        h hVar2 = this.f9797g;
        z4.j jVarA = hVar2.a();
        g5.h hVar3 = g5.h.f4318b;
        jVarA.s(1, ac.a.c0(hVar));
        jVarA.h(2, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar2.c(jVarA);
        }
    }

    public final void p(int i, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        h hVar = this.f9794d;
        z4.j jVarA = hVar.a();
        jVarA.c(1, a.a.W(i));
        jVarA.h(2, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar.c(jVarA);
        }
    }

    public final void q(int i, String str) {
        WorkDatabase_Impl workDatabase_Impl = this.f9791a;
        workDatabase_Impl.b();
        h hVar = this.f9803n;
        z4.j jVarA = hVar.a();
        jVarA.c(1, i);
        jVarA.h(2, str);
        try {
            workDatabase_Impl.c();
            try {
                jVarA.d();
                workDatabase_Impl.v();
            } finally {
                workDatabase_Impl.q();
            }
        } finally {
            hVar.c(jVarA);
        }
    }
}

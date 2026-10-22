package B0;

import Z2.I;
import android.database.Cursor;
import androidx.room.A;
import androidx.room.E;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import s0.C;
import s0.C0847e;
import s0.C0850h;
import s0.EnumC0843a;
import s0.G;
import t0.J;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final A f191a;

    /* renamed from: b, reason: collision with root package name */
    public final b f192b;

    /* renamed from: c, reason: collision with root package name */
    public final t f193c;

    /* renamed from: d, reason: collision with root package name */
    public final s f194d;

    /* renamed from: e, reason: collision with root package name */
    public final s f195e;

    /* renamed from: f, reason: collision with root package name */
    public final s f196f;

    /* renamed from: g, reason: collision with root package name */
    public final s f197g;

    /* renamed from: h, reason: collision with root package name */
    public final s f198h;

    /* renamed from: i, reason: collision with root package name */
    public final s f199i;

    /* renamed from: j, reason: collision with root package name */
    public final s f200j;

    /* renamed from: k, reason: collision with root package name */
    public final s f201k;

    /* renamed from: l, reason: collision with root package name */
    public final s f202l;

    /* renamed from: m, reason: collision with root package name */
    public final s f203m;

    /* renamed from: n, reason: collision with root package name */
    public final s f204n;

    /* renamed from: o, reason: collision with root package name */
    public final s f205o;

    public u(A database) {
        this.f191a = database;
        int i4 = 5;
        this.f192b = new b(this, database, i4);
        Intrinsics.checkNotNullParameter(database, "database");
        this.f193c = new t(database);
        this.f194d = new s(database, 8);
        this.f195e = new s(database, 9);
        this.f196f = new s(database, 10);
        this.f197g = new s(database, 11);
        this.f198h = new s(database, 12);
        this.f199i = new s(database, 13);
        this.f200j = new s(database, 14);
        this.f201k = new s(database, 0);
        new s(database, 1);
        this.f202l = new s(database, 2);
        this.f203m = new s(database, 3);
        this.f204n = new s(database, 4);
        new s(database, i4);
        new s(database, 6);
        this.f205o = new s(database, 7);
    }

    public final void a(String str) {
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        s sVar = this.f194d;
        k0.j jVarAcquire = sVar.acquire();
        if (str == null) {
            jVarAcquire.bindNull(1);
        } else {
            jVarAcquire.bindString(1, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            sVar.release(jVarAcquire);
        }
    }

    public final ArrayList b() throws Throwable {
        E e4;
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
        E eD = E.d(1, "SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?");
        eD.bindLong(1, 200);
        A a4 = this.f191a;
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
                    int i12 = iN;
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
                    iN = i12;
                    i9 = i11;
                }
                cursorH.close();
                e4.e();
                return arrayList;
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

    public final ArrayList c(int i4) throws Throwable {
        E e4;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        int iN8;
        int iN9;
        int iN10;
        int iN11;
        int iN12;
        int iN13;
        int iN14;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        int i7;
        boolean z6;
        int i8;
        boolean z7;
        E eD = E.d(1, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND LENGTH(content_uri_triggers)=0 AND state NOT IN (2, 3, 5))");
        eD.bindLong(1, i4);
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            iN = I.n(cursorH, "id");
            iN2 = I.n(cursorH, "state");
            iN3 = I.n(cursorH, "worker_class_name");
            iN4 = I.n(cursorH, "input_merger_class_name");
            iN5 = I.n(cursorH, "input");
            iN6 = I.n(cursorH, "output");
            iN7 = I.n(cursorH, "initial_delay");
            iN8 = I.n(cursorH, "interval_duration");
            iN9 = I.n(cursorH, "flex_duration");
            iN10 = I.n(cursorH, "run_attempt_count");
            iN11 = I.n(cursorH, "backoff_policy");
            iN12 = I.n(cursorH, "backoff_delay_duration");
            iN13 = I.n(cursorH, "last_enqueue_time");
            iN14 = I.n(cursorH, "minimum_retention_duration");
            e4 = eD;
        } catch (Throwable th) {
            th = th;
            e4 = eD;
        }
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
                int i12 = iN;
                int i13 = iN15;
                long j10 = cursorH.getLong(i13);
                iN15 = i13;
                int i14 = iN16;
                int i15 = cursorH.getInt(i14);
                iN16 = i14;
                int i16 = iN17;
                boolean z8 = i15 != 0;
                C cO = f.O(cursorH.getInt(i16));
                iN17 = i16;
                int i17 = iN18;
                int i18 = cursorH.getInt(i17);
                iN18 = i17;
                int i19 = iN19;
                int i20 = cursorH.getInt(i19);
                iN19 = i19;
                int i21 = iN20;
                long j11 = cursorH.getLong(i21);
                iN20 = i21;
                int i22 = iN21;
                int i23 = cursorH.getInt(i22);
                iN21 = i22;
                int i24 = iN22;
                int i25 = cursorH.getInt(i24);
                iN22 = i24;
                int i26 = iN23;
                s0.u uVarN = f.N(cursorH.getInt(i26));
                iN23 = i26;
                int i27 = iN24;
                if (cursorH.getInt(i27) != 0) {
                    iN24 = i27;
                    i5 = iN25;
                    z4 = true;
                } else {
                    iN24 = i27;
                    i5 = iN25;
                    z4 = false;
                }
                if (cursorH.getInt(i5) != 0) {
                    iN25 = i5;
                    i6 = iN26;
                    z5 = true;
                } else {
                    iN25 = i5;
                    i6 = iN26;
                    z5 = false;
                }
                if (cursorH.getInt(i6) != 0) {
                    iN26 = i6;
                    i7 = iN27;
                    z6 = true;
                } else {
                    iN26 = i6;
                    i7 = iN27;
                    z6 = false;
                }
                if (cursorH.getInt(i7) != 0) {
                    iN27 = i7;
                    i8 = iN28;
                    z7 = true;
                } else {
                    iN27 = i7;
                    i8 = iN28;
                    z7 = false;
                }
                long j12 = cursorH.getLong(i8);
                iN28 = i8;
                int i28 = iN29;
                long j13 = cursorH.getLong(i28);
                iN29 = i28;
                int i29 = iN30;
                if (!cursorH.isNull(i29)) {
                    blob = cursorH.getBlob(i29);
                }
                iN30 = i29;
                arrayList.add(new r(string, gP, string2, string3, c0850hA, c0850hA2, j4, j5, j6, new C0847e(uVarN, z4, z5, z6, z7, j12, j13, f.c(blob)), i10, enumC0843aM, j7, j8, j9, j10, z8, cO, i18, i20, j11, i23, i25));
                iN = i12;
                i9 = i11;
            }
            cursorH.close();
            e4.e();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            e4.e();
            throw th;
        }
    }

    public final ArrayList d() throws Throwable {
        E e4;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        int iN8;
        int iN9;
        int iN10;
        int iN11;
        int iN12;
        int iN13;
        int iN14;
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
        E eD = E.d(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 AND LENGTH(content_uri_triggers)<>0 ORDER BY last_enqueue_time");
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            iN = I.n(cursorH, "id");
            iN2 = I.n(cursorH, "state");
            iN3 = I.n(cursorH, "worker_class_name");
            iN4 = I.n(cursorH, "input_merger_class_name");
            iN5 = I.n(cursorH, "input");
            iN6 = I.n(cursorH, "output");
            iN7 = I.n(cursorH, "initial_delay");
            iN8 = I.n(cursorH, "interval_duration");
            iN9 = I.n(cursorH, "flex_duration");
            iN10 = I.n(cursorH, "run_attempt_count");
            iN11 = I.n(cursorH, "backoff_policy");
            iN12 = I.n(cursorH, "backoff_delay_duration");
            iN13 = I.n(cursorH, "last_enqueue_time");
            iN14 = I.n(cursorH, "minimum_retention_duration");
            e4 = eD;
        } catch (Throwable th) {
            th = th;
            e4 = eD;
        }
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
                int i12 = iN;
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
                iN = i12;
                i9 = i11;
            }
            cursorH.close();
            e4.e();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            e4.e();
            throw th;
        }
    }

    public final ArrayList e() throws Throwable {
        E e4;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        int iN8;
        int iN9;
        int iN10;
        int iN11;
        int iN12;
        int iN13;
        int iN14;
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
        E eD = E.d(0, "SELECT * FROM workspec WHERE state=1");
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            iN = I.n(cursorH, "id");
            iN2 = I.n(cursorH, "state");
            iN3 = I.n(cursorH, "worker_class_name");
            iN4 = I.n(cursorH, "input_merger_class_name");
            iN5 = I.n(cursorH, "input");
            iN6 = I.n(cursorH, "output");
            iN7 = I.n(cursorH, "initial_delay");
            iN8 = I.n(cursorH, "interval_duration");
            iN9 = I.n(cursorH, "flex_duration");
            iN10 = I.n(cursorH, "run_attempt_count");
            iN11 = I.n(cursorH, "backoff_policy");
            iN12 = I.n(cursorH, "backoff_delay_duration");
            iN13 = I.n(cursorH, "last_enqueue_time");
            iN14 = I.n(cursorH, "minimum_retention_duration");
            e4 = eD;
        } catch (Throwable th) {
            th = th;
            e4 = eD;
        }
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
                int i12 = iN;
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
                iN = i12;
                i9 = i11;
            }
            cursorH.close();
            e4.e();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            e4.e();
            throw th;
        }
    }

    public final ArrayList f() {
        E e4;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        int iN8;
        int iN9;
        int iN10;
        int iN11;
        int iN12;
        int iN13;
        int iN14;
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
        E eD = E.d(0, "SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            iN = I.n(cursorH, "id");
            iN2 = I.n(cursorH, "state");
            iN3 = I.n(cursorH, "worker_class_name");
            iN4 = I.n(cursorH, "input_merger_class_name");
            iN5 = I.n(cursorH, "input");
            iN6 = I.n(cursorH, "output");
            iN7 = I.n(cursorH, "initial_delay");
            iN8 = I.n(cursorH, "interval_duration");
            iN9 = I.n(cursorH, "flex_duration");
            iN10 = I.n(cursorH, "run_attempt_count");
            iN11 = I.n(cursorH, "backoff_policy");
            iN12 = I.n(cursorH, "backoff_delay_duration");
            iN13 = I.n(cursorH, "last_enqueue_time");
            iN14 = I.n(cursorH, "minimum_retention_duration");
            e4 = eD;
        } catch (Throwable th) {
            th = th;
            e4 = eD;
        }
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
                int i12 = iN;
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
                iN = i12;
                i9 = i11;
            }
            cursorH.close();
            e4.e();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            e4.e();
            throw th;
        }
    }

    public final G g(String str) {
        E eD = E.d(1, "SELECT state FROM workspec WHERE id=?");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            G gP = null;
            if (cursorH.moveToFirst()) {
                Integer numValueOf = cursorH.isNull(0) ? null : Integer.valueOf(cursorH.getInt(0));
                if (numValueOf != null) {
                    gP = f.P(numValueOf.intValue());
                }
            }
            return gP;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    public final ArrayList h(String str) {
        E eD = E.d(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                arrayList.add(cursorH.isNull(0) ? null : cursorH.getString(0));
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    public final r i(String str) {
        E e4;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        int iN8;
        int iN9;
        int iN10;
        int iN11;
        int iN12;
        int iN13;
        int iN14;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        boolean z6;
        int i6;
        boolean z7;
        int i7;
        boolean z8;
        int i8;
        E eD = E.d(1, "SELECT * FROM workspec WHERE id=?");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            iN = I.n(cursorH, "id");
            iN2 = I.n(cursorH, "state");
            iN3 = I.n(cursorH, "worker_class_name");
            iN4 = I.n(cursorH, "input_merger_class_name");
            iN5 = I.n(cursorH, "input");
            iN6 = I.n(cursorH, "output");
            iN7 = I.n(cursorH, "initial_delay");
            iN8 = I.n(cursorH, "interval_duration");
            iN9 = I.n(cursorH, "flex_duration");
            iN10 = I.n(cursorH, "run_attempt_count");
            iN11 = I.n(cursorH, "backoff_policy");
            iN12 = I.n(cursorH, "backoff_delay_duration");
            iN13 = I.n(cursorH, "last_enqueue_time");
            iN14 = I.n(cursorH, "minimum_retention_duration");
            e4 = eD;
        } catch (Throwable th) {
            th = th;
            e4 = eD;
        }
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
            r rVar = null;
            byte[] blob = null;
            if (cursorH.moveToFirst()) {
                String string = cursorH.isNull(iN) ? null : cursorH.getString(iN);
                G gP = f.P(cursorH.getInt(iN2));
                String string2 = cursorH.isNull(iN3) ? null : cursorH.getString(iN3);
                String string3 = cursorH.isNull(iN4) ? null : cursorH.getString(iN4);
                C0850h c0850hA = C0850h.a(cursorH.isNull(iN5) ? null : cursorH.getBlob(iN5));
                C0850h c0850hA2 = C0850h.a(cursorH.isNull(iN6) ? null : cursorH.getBlob(iN6));
                long j4 = cursorH.getLong(iN7);
                long j5 = cursorH.getLong(iN8);
                long j6 = cursorH.getLong(iN9);
                int i9 = cursorH.getInt(iN10);
                EnumC0843a enumC0843aM = f.M(cursorH.getInt(iN11));
                long j7 = cursorH.getLong(iN12);
                long j8 = cursorH.getLong(iN13);
                long j9 = cursorH.getLong(iN14);
                long j10 = cursorH.getLong(iN15);
                if (cursorH.getInt(iN16) != 0) {
                    i4 = iN17;
                    z4 = true;
                } else {
                    z4 = false;
                    i4 = iN17;
                }
                C cO = f.O(cursorH.getInt(i4));
                int i10 = cursorH.getInt(iN18);
                int i11 = cursorH.getInt(iN19);
                long j11 = cursorH.getLong(iN20);
                int i12 = cursorH.getInt(iN21);
                int i13 = cursorH.getInt(iN22);
                s0.u uVarN = f.N(cursorH.getInt(iN23));
                if (cursorH.getInt(iN24) != 0) {
                    i5 = iN25;
                    z5 = true;
                } else {
                    z5 = false;
                    i5 = iN25;
                }
                if (cursorH.getInt(i5) != 0) {
                    i6 = iN26;
                    z6 = true;
                } else {
                    z6 = false;
                    i6 = iN26;
                }
                if (cursorH.getInt(i6) != 0) {
                    i7 = iN27;
                    z7 = true;
                } else {
                    z7 = false;
                    i7 = iN27;
                }
                if (cursorH.getInt(i7) != 0) {
                    i8 = iN28;
                    z8 = true;
                } else {
                    z8 = false;
                    i8 = iN28;
                }
                long j12 = cursorH.getLong(i8);
                long j13 = cursorH.getLong(iN29);
                if (!cursorH.isNull(iN30)) {
                    blob = cursorH.getBlob(iN30);
                }
                rVar = new r(string, gP, string2, string3, c0850hA, c0850hA2, j4, j5, j6, new C0847e(uVarN, z5, z6, z7, z8, j12, j13, f.c(blob)), i9, enumC0843aM, j7, j8, j9, j10, z4, cO, i10, i11, j11, i12, i13);
            }
            cursorH.close();
            e4.e();
            return rVar;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            e4.e();
            throw th;
        }
    }

    public final ArrayList j(String str) {
        E eD = E.d(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                String id = cursorH.isNull(0) ? null : cursorH.getString(0);
                G state = f.P(cursorH.getInt(1));
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(state, "state");
                q qVar = new q();
                qVar.f164a = id;
                qVar.f165b = state;
                arrayList.add(qVar);
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    public final void k(String str, long j4) {
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        s sVar = this.f203m;
        k0.j jVarAcquire = sVar.acquire();
        jVarAcquire.bindLong(1, j4);
        if (str == null) {
            jVarAcquire.bindNull(2);
        } else {
            jVarAcquire.bindString(2, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            sVar.release(jVarAcquire);
        }
    }

    public final void l(int i4, String str) {
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        s sVar = this.f202l;
        k0.j jVarAcquire = sVar.acquire();
        if (str == null) {
            jVarAcquire.bindNull(1);
        } else {
            jVarAcquire.bindString(1, str);
        }
        jVarAcquire.bindLong(2, i4);
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            sVar.release(jVarAcquire);
        }
    }

    public final void m(String str, long j4) {
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        s sVar = this.f199i;
        k0.j jVarAcquire = sVar.acquire();
        jVarAcquire.bindLong(1, j4);
        if (str == null) {
            jVarAcquire.bindNull(2);
        } else {
            jVarAcquire.bindString(2, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            sVar.release(jVarAcquire);
        }
    }

    public final void n(String str, C0850h c0850h) throws Throwable {
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        s sVar = this.f198h;
        k0.j jVarAcquire = sVar.acquire();
        byte[] bArrB = C0850h.b(c0850h);
        if (bArrB == null) {
            jVarAcquire.bindNull(1);
        } else {
            jVarAcquire.bindBlob(1, bArrB);
        }
        if (str == null) {
            jVarAcquire.bindNull(2);
        } else {
            jVarAcquire.bindString(2, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            sVar.release(jVarAcquire);
        }
    }

    public final void o(G g4, String str) {
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        s sVar = this.f195e;
        k0.j jVarAcquire = sVar.acquire();
        jVarAcquire.bindLong(1, f.B0(g4));
        if (str == null) {
            jVarAcquire.bindNull(2);
        } else {
            jVarAcquire.bindString(2, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            sVar.release(jVarAcquire);
        }
    }

    public final void p(int i4, String str) {
        A a4 = this.f191a;
        a4.assertNotSuspendingTransaction();
        s sVar = this.f205o;
        k0.j jVarAcquire = sVar.acquire();
        jVarAcquire.bindLong(1, i4);
        if (str == null) {
            jVarAcquire.bindNull(2);
        } else {
            jVarAcquire.bindString(2, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            sVar.release(jVarAcquire);
        }
    }
}

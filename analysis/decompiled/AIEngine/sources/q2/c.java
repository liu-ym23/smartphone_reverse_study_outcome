package q2;

import androidx.room.RoomDatabase;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends androidx.room.e {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11490d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(RoomDatabase roomDatabase) {
        super(roomDatabase, 1);
        this.f11490d = 1;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String c() {
        switch (this.f11490d) {
            case 0:
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            case 1:
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            case 2:
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            case 3:
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            case 4:
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            case 5:
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`trace_tag`,`required_network_type`,`required_network_request`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    @Override // androidx.room.e
    public final void e(y1.f fVar, Object obj) {
        int i10;
        int i11 = 1;
        switch (this.f11490d) {
            case 0:
                a aVar = (a) obj;
                fVar.Y(1, aVar.f11488a);
                fVar.Y(2, aVar.f11489b);
                return;
            case 1:
                d dVar = (d) obj;
                fVar.Y(1, dVar.f11491a);
                fVar.h0(2, dVar.f11492b.longValue());
                return;
            case 2:
                fVar.Y(1, ((g) obj).f11493a);
                fVar.h0(2, r7.f11494b);
                fVar.h0(3, r7.f11495c);
                return;
            case 3:
                l lVar = (l) obj;
                fVar.Y(1, lVar.f11500a);
                fVar.Y(2, lVar.f11501b);
                return;
            case 4:
                n nVar = (n) obj;
                fVar.Y(1, nVar.f11502a);
                Data data = nVar.f11503b;
                Data data2 = Data.f2768b;
                fVar.F(Data.b.b(data), 2);
                return;
            case 5:
                p pVar = (p) obj;
                fVar.Y(1, pVar.f11505a);
                fVar.h0(2, v.i(pVar.f11506b));
                fVar.Y(3, pVar.f11507c);
                fVar.Y(4, pVar.f11508d);
                Data data3 = pVar.f11509e;
                Data data4 = Data.f2768b;
                fVar.F(Data.b.b(data3), 5);
                fVar.F(Data.b.b(pVar.f11510f), 6);
                fVar.h0(7, pVar.f11511g);
                fVar.h0(8, pVar.h);
                fVar.h0(9, pVar.f11512i);
                fVar.h0(10, pVar.f11514k);
                BackoffPolicy backoffPolicy = pVar.f11515l;
                kotlin.jvm.internal.g.f(backoffPolicy, "backoffPolicy");
                int iOrdinal = backoffPolicy.ordinal();
                if (iOrdinal == 0) {
                    i10 = 0;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i10 = 1;
                }
                fVar.h0(11, i10);
                fVar.h0(12, pVar.f11516m);
                fVar.h0(13, pVar.f11517n);
                fVar.h0(14, pVar.f11518o);
                fVar.h0(15, pVar.f11519p);
                fVar.h0(16, pVar.f11520q ? 1L : 0L);
                OutOfQuotaPolicy policy = pVar.r;
                kotlin.jvm.internal.g.f(policy, "policy");
                int iOrdinal2 = policy.ordinal();
                if (iOrdinal2 == 0) {
                    i11 = 0;
                } else if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                fVar.h0(17, i11);
                fVar.h0(18, pVar.f11521s);
                fVar.h0(19, pVar.f11522t);
                fVar.h0(20, pVar.f11523u);
                fVar.h0(21, pVar.f11524v);
                fVar.h0(22, pVar.f11525w);
                String str = pVar.f11526x;
                if (str == null) {
                    fVar.v0(23);
                } else {
                    fVar.Y(23, str);
                }
                h2.c cVar = pVar.f11513j;
                fVar.h0(24, v.g(cVar.f9256a));
                fVar.F(v.b(cVar.f9257b), 25);
                fVar.h0(26, cVar.f9258c ? 1L : 0L);
                fVar.h0(27, cVar.f9259d ? 1L : 0L);
                fVar.h0(28, cVar.f9260e ? 1L : 0L);
                fVar.h0(29, cVar.f9261f ? 1L : 0L);
                fVar.h0(30, cVar.f9262g);
                fVar.h0(31, cVar.h);
                fVar.F(v.h(cVar.f9263i), 32);
                return;
            default:
                t tVar = (t) obj;
                fVar.Y(1, tVar.f11545a);
                fVar.Y(2, tVar.f11546b);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(RoomDatabase roomDatabase, int i10) {
        super(roomDatabase);
        this.f11490d = i10;
    }
}

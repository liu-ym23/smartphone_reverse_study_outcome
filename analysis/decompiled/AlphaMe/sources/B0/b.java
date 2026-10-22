package B0;

import androidx.room.A;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import s0.C;
import s0.C0847e;
import s0.C0850h;
import s0.EnumC0843a;

/* loaded from: classes.dex */
public final class b extends androidx.room.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f134a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f135b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, A a4, int i4) {
        super(a4);
        this.f134a = i4;
        this.f135b = obj;
    }

    @Override // androidx.room.k
    public final void bind(k0.j jVar, Object obj) throws Throwable {
        int i4;
        int i5 = 1;
        switch (this.f134a) {
            case 0:
                a aVar = (a) obj;
                String str = aVar.f132a;
                if (str == null) {
                    jVar.bindNull(1);
                } else {
                    jVar.bindString(1, str);
                }
                String str2 = aVar.f133b;
                if (str2 == null) {
                    jVar.bindNull(2);
                    return;
                } else {
                    jVar.bindString(2, str2);
                    return;
                }
            case 1:
                d dVar = (d) obj;
                String str3 = dVar.f138a;
                if (str3 == null) {
                    jVar.bindNull(1);
                } else {
                    jVar.bindString(1, str3);
                }
                Long l4 = dVar.f139b;
                if (l4 == null) {
                    jVar.bindNull(2);
                    return;
                } else {
                    jVar.bindLong(2, l4.longValue());
                    return;
                }
            case 2:
                String str4 = ((h) obj).f145a;
                if (str4 == null) {
                    jVar.bindNull(1);
                } else {
                    jVar.bindString(1, str4);
                }
                jVar.bindLong(2, r11.f146b);
                jVar.bindLong(3, r11.f147c);
                return;
            case 3:
                l lVar = (l) obj;
                String str5 = lVar.f152a;
                if (str5 == null) {
                    jVar.bindNull(1);
                } else {
                    jVar.bindString(1, str5);
                }
                String str6 = lVar.f153b;
                if (str6 == null) {
                    jVar.bindNull(2);
                    return;
                } else {
                    jVar.bindString(2, str6);
                    return;
                }
            case 4:
                n nVar = (n) obj;
                String str7 = nVar.f157a;
                if (str7 == null) {
                    jVar.bindNull(1);
                } else {
                    jVar.bindString(1, str7);
                }
                byte[] bArrB = C0850h.b(nVar.f158b);
                if (bArrB == null) {
                    jVar.bindNull(2);
                    return;
                } else {
                    jVar.bindBlob(2, bArrB);
                    return;
                }
            case 5:
                r rVar = (r) obj;
                String str8 = rVar.f167a;
                if (str8 == null) {
                    jVar.bindNull(1);
                } else {
                    jVar.bindString(1, str8);
                }
                jVar.bindLong(2, f.B0(rVar.f168b));
                String str9 = rVar.f169c;
                if (str9 == null) {
                    jVar.bindNull(3);
                } else {
                    jVar.bindString(3, str9);
                }
                String str10 = rVar.f170d;
                if (str10 == null) {
                    jVar.bindNull(4);
                } else {
                    jVar.bindString(4, str10);
                }
                byte[] bArrB2 = C0850h.b(rVar.f171e);
                if (bArrB2 == null) {
                    jVar.bindNull(5);
                } else {
                    jVar.bindBlob(5, bArrB2);
                }
                byte[] bArrB3 = C0850h.b(rVar.f172f);
                if (bArrB3 == null) {
                    jVar.bindNull(6);
                } else {
                    jVar.bindBlob(6, bArrB3);
                }
                jVar.bindLong(7, rVar.f173g);
                jVar.bindLong(8, rVar.f174h);
                jVar.bindLong(9, rVar.f175i);
                jVar.bindLong(10, rVar.f177k);
                EnumC0843a backoffPolicy = rVar.f178l;
                Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
                int i6 = x.$EnumSwitchMapping$1[backoffPolicy.ordinal()];
                if (i6 == 1) {
                    i4 = 0;
                } else {
                    if (i6 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i4 = 1;
                }
                jVar.bindLong(11, i4);
                jVar.bindLong(12, rVar.f179m);
                jVar.bindLong(13, rVar.f180n);
                jVar.bindLong(14, rVar.f181o);
                jVar.bindLong(15, rVar.f182p);
                jVar.bindLong(16, rVar.f183q ? 1L : 0L);
                C policy = rVar.f184r;
                Intrinsics.checkNotNullParameter(policy, "policy");
                int i7 = x.$EnumSwitchMapping$3[policy.ordinal()];
                if (i7 == 1) {
                    i5 = 0;
                } else if (i7 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                jVar.bindLong(17, i5);
                jVar.bindLong(18, rVar.f185s);
                jVar.bindLong(19, rVar.f186t);
                jVar.bindLong(20, rVar.f187u);
                jVar.bindLong(21, rVar.f188v);
                jVar.bindLong(22, rVar.f189w);
                C0847e c0847e = rVar.f176j;
                if (c0847e == null) {
                    jVar.bindNull(23);
                    jVar.bindNull(24);
                    jVar.bindNull(25);
                    jVar.bindNull(26);
                    jVar.bindNull(27);
                    jVar.bindNull(28);
                    jVar.bindNull(29);
                    jVar.bindNull(30);
                    return;
                }
                jVar.bindLong(23, f.T(c0847e.f14185a));
                jVar.bindLong(24, c0847e.f14186b ? 1L : 0L);
                jVar.bindLong(25, c0847e.f14187c ? 1L : 0L);
                jVar.bindLong(26, c0847e.f14188d ? 1L : 0L);
                jVar.bindLong(27, c0847e.f14189e ? 1L : 0L);
                jVar.bindLong(28, c0847e.f14190f);
                jVar.bindLong(29, c0847e.f14191g);
                byte[] bArrW0 = f.w0(c0847e.f14192h);
                if (bArrW0 == null) {
                    jVar.bindNull(30);
                    return;
                } else {
                    jVar.bindBlob(30, bArrW0);
                    return;
                }
            default:
                v vVar = (v) obj;
                String str11 = vVar.f206a;
                if (str11 == null) {
                    jVar.bindNull(1);
                } else {
                    jVar.bindString(1, str11);
                }
                String str12 = vVar.f207b;
                if (str12 == null) {
                    jVar.bindNull(2);
                    return;
                } else {
                    jVar.bindString(2, str12);
                    return;
                }
        }
    }

    @Override // androidx.room.G
    public final String createQuery() {
        switch (this.f134a) {
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
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`next_schedule_time_override`,`next_schedule_time_override_generation`,`stop_reason`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            default:
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }
}

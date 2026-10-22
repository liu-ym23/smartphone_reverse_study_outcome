package B0;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import s0.C;
import s0.C0847e;
import s0.C0850h;
import s0.EnumC0843a;

/* loaded from: classes.dex */
public final class t extends androidx.room.j {
    @Override // androidx.room.j
    public final void bind(k0.j jVar, Object obj) throws Throwable {
        int i4;
        r rVar = (r) obj;
        String str = rVar.f167a;
        int i5 = 1;
        if (str == null) {
            jVar.bindNull(1);
        } else {
            jVar.bindString(1, str);
        }
        jVar.bindLong(2, f.B0(rVar.f168b));
        String str2 = rVar.f169c;
        if (str2 == null) {
            jVar.bindNull(3);
        } else {
            jVar.bindString(3, str2);
        }
        String str3 = rVar.f170d;
        if (str3 == null) {
            jVar.bindNull(4);
        } else {
            jVar.bindString(4, str3);
        }
        byte[] bArrB = C0850h.b(rVar.f171e);
        if (bArrB == null) {
            jVar.bindNull(5);
        } else {
            jVar.bindBlob(5, bArrB);
        }
        byte[] bArrB2 = C0850h.b(rVar.f172f);
        if (bArrB2 == null) {
            jVar.bindNull(6);
        } else {
            jVar.bindBlob(6, bArrB2);
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
        if (c0847e != null) {
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
            } else {
                jVar.bindBlob(30, bArrW0);
            }
        } else {
            jVar.bindNull(23);
            jVar.bindNull(24);
            jVar.bindNull(25);
            jVar.bindNull(26);
            jVar.bindNull(27);
            jVar.bindNull(28);
            jVar.bindNull(29);
            jVar.bindNull(30);
        }
        String str4 = rVar.f167a;
        if (str4 == null) {
            jVar.bindNull(31);
        } else {
            jVar.bindString(31, str4);
        }
    }

    @Override // androidx.room.G
    public final String createQuery() {
        return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
    }
}

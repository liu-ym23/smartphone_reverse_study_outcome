package h5;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends q4.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5336c;

    /* renamed from: d, reason: collision with root package name */
    public Context f5337d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, int i3, int i10) {
        super(i, i3);
        this.f5336c = i10;
    }

    @Override // q4.a
    public final void a(z4.c cVar) throws SQLException {
        int i = this.f5336c;
        cVar.getClass();
        switch (i) {
            case 0:
                if (this.f10074b >= 10) {
                    cVar.o(new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    this.f5337d.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
            default:
                cVar.n("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                Context context = this.f5337d;
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j10 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j11 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    cVar.d();
                    try {
                        cVar.o(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j10)});
                        cVar.o(new Object[]{"reschedule_needed", Long.valueOf(j11)});
                        sharedPreferences.edit().clear().apply();
                        cVar.F();
                    } finally {
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i3 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i10 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    cVar.d();
                    try {
                        cVar.o(new Object[]{"next_job_scheduler_id", Integer.valueOf(i3)});
                        cVar.o(new Object[]{"next_alarm_manager_id", Integer.valueOf(i10)});
                        sharedPreferences2.edit().clear().apply();
                        cVar.F();
                        return;
                    } finally {
                    }
                }
                return;
        }
    }
}

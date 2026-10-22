package i2;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.SQLException;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t extends u1.a {

    /* renamed from: c, reason: collision with root package name */
    public final Context f9488c;

    public t(Context context) {
        super(9, 10);
        this.f9488c = context;
    }

    @Override // u1.a
    public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
        frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        Context context = this.f9488c;
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j10 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
            long j11 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
            frameworkSQLiteDatabase.l();
            try {
                frameworkSQLiteDatabase.z("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j10)});
                frameworkSQLiteDatabase.z("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j11)});
                sharedPreferences.edit().clear().apply();
                frameworkSQLiteDatabase.y();
            } finally {
            }
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
        if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
            int i10 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
            int i11 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
            frameworkSQLiteDatabase.l();
            try {
                frameworkSQLiteDatabase.z("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i10)});
                frameworkSQLiteDatabase.z("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i11)});
                sharedPreferences2.edit().clear().apply();
                frameworkSQLiteDatabase.y();
            } finally {
            }
        }
    }
}

package t0;

import android.content.Context;
import android.content.SharedPreferences;
import h0.AbstractC0587a;
import k0.InterfaceC0674b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class s extends AbstractC0587a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15414a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f15415b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context) {
        super(9, 10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15415b = context;
    }

    @Override // h0.AbstractC0587a
    public final void migrate(InterfaceC0674b db) {
        int i4 = this.f15414a;
        Object obj = this.f15415b;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(db, "db");
                if (this.endVersion >= 10) {
                    db.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    ((Context) obj).getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
            case 1:
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                Context context = (Context) obj;
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j4 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j5 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    db.beginTransaction();
                    try {
                        db.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j4)});
                        db.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j5)});
                        sharedPreferences.edit().clear().apply();
                        db.setTransactionSuccessful();
                    } finally {
                    }
                }
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(db, "sqLiteDatabase");
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i5 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i6 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    db.beginTransaction();
                    try {
                        db.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i5)});
                        db.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i6)});
                        sharedPreferences2.edit().clear().apply();
                        db.setTransactionSuccessful();
                        return;
                    } finally {
                    }
                }
                return;
            default:
                ((Function1) obj).invoke(db);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context mContext, int i4, int i5) {
        super(i4, i5);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f15415b = mContext;
    }

    public s(Function1 function1) {
        super(1, 2);
        this.f15415b = function1;
    }
}

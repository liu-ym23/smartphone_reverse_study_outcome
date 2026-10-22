package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f5834a;

    public m(WorkDatabase r10) {
        this.f5834a = r10;
    }

    public static void c(Context r10, SupportSQLiteDatabase r11) {
        SharedPreferences r12 = r10.getSharedPreferences("androidx.work.util.preferences", 0);
        if (r12.contains("reschedule_needed") == false) goto L5;
    L6:
        long r13 = 0;
        long r14 = r12.getLong("last_cancel_all_time_ms", 0);
        if (r12.getBoolean("reschedule_needed", false) == false) goto L9;
        r13 = 1;
    L9:
        r11.beginTransaction();
        r11.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(r14)});     // Catch: Throwable -> L13
        r11.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(r13)});     // Catch: Throwable -> L13
        r12.edit().clear().apply();     // Catch: Throwable -> L13
        r11.setTransactionSuccessful();     // Catch: Throwable -> L13
        r11.endTransaction();
        return;
    L13:
        th = move-exception;
        r11.endTransaction();
        throw th;
    L5:
        if (r12.contains("last_cancel_all_time_ms") == true) goto L6;
    }

    public long a() {
        Long r10 = this.f5834a.H().getLongValue("last_force_stop_ms");
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.longValue();
    }

    public boolean b() {
        Long r10 = this.f5834a.H().getLongValue("reschedule_needed");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.longValue() != 1) goto L7;
        return true;
    }

    public void d(long r10) {
        androidx.work.impl.model.c r11 = new androidx.work.impl.model.c("last_force_stop_ms", Long.valueOf(r10));
        this.f5834a.H().insertPreference(r11);
    }

    public void e(boolean r10) {
        androidx.work.impl.model.c r11 = new androidx.work.impl.model.c("reschedule_needed", r10);
        this.f5834a.H().insertPreference(r11);
    }
}

package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static final /* synthetic */ int a(WorkDatabase r10, String r11) {
        return d(r10, r11);
    }

    public static final /* synthetic */ void b(WorkDatabase r10, String r11, int r12) {
        e(r10, r11, r12);
    }

    public static final void c(Context r10, SupportSQLiteDatabase r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "sqLiteDatabase");
        SharedPreferences r12 = r10.getSharedPreferences("androidx.work.util.id", 0);
        if (r12.contains("next_job_scheduler_id") == false) goto L5;
    L6:
        int r13 = r12.getInt("next_job_scheduler_id", 0);
        int r14 = r12.getInt("next_alarm_manager_id", 0);
        r11.beginTransaction();
        r11.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(r13)});     // Catch: Throwable -> L10
        r11.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(r14)});     // Catch: Throwable -> L10
        r12.edit().clear().apply();     // Catch: Throwable -> L10
        r11.setTransactionSuccessful();     // Catch: Throwable -> L10
        r11.endTransaction();
        return;
    L10:
        th = move-exception;
        r11.endTransaction();
        throw th;
    L5:
        if (r12.contains("next_job_scheduler_id") == true) goto L6;
    }

    public static final int d(WorkDatabase r10, String r11) {
        Long r12 = r10.H().getLongValue(r11);
        int r13 = 0;
        if (r12 == null) goto L5;
        int r14 = (int) r12.longValue();
    L7:
        if (r14 == Integer.MAX_VALUE) goto L10;
        r13 = r14 + 1;
    L10:
        e(r10, r11, r13);
        return r14;
    L5:
        r14 = 0;
        goto L7
    }

    public static final void e(WorkDatabase r10, String r11, int r12) {
        r10.H().insertPreference(new androidx.work.impl.model.c(r11, Long.valueOf(r12)));
    }
}

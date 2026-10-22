package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.Preference;

/* JADX INFO: loaded from: classes28.dex */
public class IdGenerator {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";
    private final WorkDatabase mWorkDatabase;

    public int nextAlarmManagerId() {
        monitor-enter(IdGenerator.class);
        int r100 = nextId(NEXT_ALARM_MANAGER_ID_KEY);     // Catch: Throwable -> L7
        monitor-exit(IdGenerator.class);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public IdGenerator(WorkDatabase r100) {
        this.mWorkDatabase = r100;
    }

    private int nextId(String r100) {
        this.mWorkDatabase.beginTransaction();
        Long r101 = this.mWorkDatabase.preferenceDao().getLongValue(r100);     // Catch: Throwable -> L14
        int r102 = 0;
        if (r101 == null) goto L6;
        int r103 = r101.intValue();     // Catch: Throwable -> L14
    L8:
        if (r103 == Integer.MAX_VALUE) goto L11;
        r102 = r103 + 1;     // Catch: Throwable -> L14
    L11:
        update(r100, r102);     // Catch: Throwable -> L14
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.mWorkDatabase.endTransaction();
        return r103;
    L6:
        r103 = 0;
    L14:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    }

    public static void migrateLegacyIdGenerator(Context r100, SupportSQLiteDatabase r101) {
        SharedPreferences r102 = r100.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (r102.contains(NEXT_JOB_SCHEDULER_ID_KEY) == false) goto L5;
    L6:
        int r103 = r102.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
        int r104 = r102.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
        r101.beginTransaction();
        r101.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(r103)});     // Catch: Throwable -> L10
        r101.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(r104)});     // Catch: Throwable -> L10
        r102.edit().clear().apply();     // Catch: Throwable -> L10
        r101.setTransactionSuccessful();     // Catch: Throwable -> L10
        r101.endTransaction();
        return;
    L10:
        th = move-exception;
        r101.endTransaction();
        throw th;
    L5:
        if (r102.contains(NEXT_JOB_SCHEDULER_ID_KEY) == true) goto L6;
    }

    private void update(String r100, int r101) {
        this.mWorkDatabase.preferenceDao().insertPreference(new Preference(r100, r101));
    }

    public int nextJobSchedulerIdWithRange(int r100, int r101) {
        monitor-enter(IdGenerator.class);
        int r102 = nextId(NEXT_JOB_SCHEDULER_ID_KEY);     // Catch: Throwable -> L12
        if (r102 < r100) goto L9;
        if (r102 > r101) goto L9;
        r100 = r102;
    L10:
        monitor-exit(IdGenerator.class);     // Catch: Throwable -> L12
        return r100;
    L9:
        update(NEXT_JOB_SCHEDULER_ID_KEY, r100 + 1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}

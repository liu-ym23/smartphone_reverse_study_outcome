package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.Preference;

/* JADX INFO: loaded from: classes3.dex */
public class PreferenceUtils {
    public static final String KEY_LAST_CANCEL_ALL_TIME_MS = "last_cancel_all_time_ms";
    public static final String KEY_RESCHEDULE_NEEDED = "reschedule_needed";
    public static final String PREFERENCES_FILE_NAME = "androidx.work.util.preferences";
    private final WorkDatabase mWorkDatabase;

    public long getLastCancelAllTimeMillis() {
        Long r100 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_LAST_CANCEL_ALL_TIME_MS);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.longValue();
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return Transformations.map(this.mWorkDatabase.preferenceDao().getObservableLongValue(KEY_LAST_CANCEL_ALL_TIME_MS), new AnonymousClass1(this));
    }

    public boolean getNeedsReschedule() {
        Long r100 = this.mWorkDatabase.preferenceDao().getLongValue(KEY_RESCHEDULE_NEEDED);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.longValue() != 1) goto L7;
        return true;
    }

    public PreferenceUtils(WorkDatabase r100) {
        this.mWorkDatabase = r100;
    }

    public void setLastCancelAllTimeMillis(long r100) {
        Preference r101 = new Preference(KEY_LAST_CANCEL_ALL_TIME_MS, r100);
        this.mWorkDatabase.preferenceDao().insertPreference(r101);
    }

    public void setNeedsReschedule(boolean r100) {
        Preference r101 = new Preference(KEY_RESCHEDULE_NEEDED, r100);
        this.mWorkDatabase.preferenceDao().insertPreference(r101);
    }

    public static void migrateLegacyPreferences(Context r110, SupportSQLiteDatabase r111) {
        SharedPreferences r112 = r110.getSharedPreferences(PREFERENCES_FILE_NAME, 0);
        if (r112.contains(KEY_RESCHEDULE_NEEDED) == false) goto L5;
    L6:
        long r100 = 0;
        long r101 = r112.getLong(KEY_LAST_CANCEL_ALL_TIME_MS, 0);
        if (r112.getBoolean(KEY_RESCHEDULE_NEEDED, false) == false) goto L9;
        r100 = 1;
    L9:
        r111.beginTransaction();
        r111.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{KEY_LAST_CANCEL_ALL_TIME_MS, Long.valueOf(r101)});     // Catch: Throwable -> L13
        r111.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{KEY_RESCHEDULE_NEEDED, Long.valueOf(r100)});     // Catch: Throwable -> L13
        r112.edit().clear().apply();     // Catch: Throwable -> L13
        r111.setTransactionSuccessful();     // Catch: Throwable -> L13
        r111.endTransaction();
        return;
    L13:
        th = move-exception;
        r111.endTransaction();
        throw th;
    L5:
        if (r112.contains(KEY_LAST_CANCEL_ALL_TIME_MS) == true) goto L6;
    }
}

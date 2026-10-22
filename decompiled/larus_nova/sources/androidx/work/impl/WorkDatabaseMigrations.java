package androidx.work.impl;

import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.PreferenceUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WorkDatabaseMigrations {
    private static final String CREATE_INDEX_PERIOD_START_TIME = "CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)";
    private static final String CREATE_OUT_OF_QUOTA_POLICY = "ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0";
    private static final String CREATE_PREFERENCE = "CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))";
    private static final String CREATE_RUN_IN_FOREGROUND = "ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0";
    private static final String CREATE_SYSTEM_ID_INFO = "CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )";
    private static final String CREATE_WORK_PROGRESS = "CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )";
    public static final String INSERT_PREFERENCE = "INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)";
    private static final String MIGRATE_ALARM_INFO_TO_SYSTEM_ID_INFO = "INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo";
    public static Migration MIGRATION_11_12 = null;
    public static Migration MIGRATION_1_2 = null;
    public static Migration MIGRATION_3_4 = null;
    public static Migration MIGRATION_4_5 = null;
    public static Migration MIGRATION_6_7 = null;
    public static Migration MIGRATION_7_8 = null;
    public static Migration MIGRATION_8_9 = null;
    private static final String PERIODIC_WORK_SET_SCHEDULE_REQUESTED_AT = "UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0";
    private static final String REMOVE_ALARM_INFO = "DROP TABLE IF EXISTS alarmInfo";
    public static final int VERSION_1 = 1;
    public static final int VERSION_10 = 10;
    public static final int VERSION_11 = 11;
    public static final int VERSION_12 = 12;
    public static final int VERSION_2 = 2;
    public static final int VERSION_3 = 3;
    public static final int VERSION_4 = 4;
    public static final int VERSION_5 = 5;
    public static final int VERSION_6 = 6;
    public static final int VERSION_7 = 7;
    public static final int VERSION_8 = 8;
    public static final int VERSION_9 = 9;
    private static final String WORKSPEC_ADD_TRIGGER_MAX_CONTENT_DELAY = "ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1";
    private static final String WORKSPEC_ADD_TRIGGER_UPDATE_DELAY = "ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1";

    public static class RescheduleMigration extends Migration {
        final Context mContext;

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase r100) {
            if (this.endVersion < 10) goto L5;
            r100.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{PreferenceUtils.KEY_RESCHEDULE_NEEDED, 1});
            return;
        L5:
            this.mContext.getSharedPreferences(PreferenceUtils.PREFERENCES_FILE_NAME, 0).edit().putBoolean(PreferenceUtils.KEY_RESCHEDULE_NEEDED, true).apply();
        }

        public RescheduleMigration(Context r100, int r101, int r102) {
            super(r101, r102);
            this.mContext = r100;
        }
    }

    public static class WorkMigration9To10 extends Migration {
        final Context mContext;

        public WorkMigration9To10(Context r100) {
            super(9, 10);
            this.mContext = r100;
        }

        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL(WorkDatabaseMigrations.CREATE_PREFERENCE);
            PreferenceUtils.migrateLegacyPreferences(this.mContext, r100);
            IdGenerator.migrateLegacyIdGenerator(this.mContext, r100);
        }
    }

    static {
        final int r100 = 1;
        final int r101 = 2;
        MIGRATION_1_2 = new AnonymousClass1(r100, r101);
        final int r102 = 3;
        final int r103 = 4;
        MIGRATION_3_4 = new AnonymousClass2(r102, r103);
        final int r104 = 5;
        MIGRATION_4_5 = new AnonymousClass3(r103, r104);
        final int r105 = 6;
        final int r106 = 7;
        MIGRATION_6_7 = new AnonymousClass4(r105, r106);
        final int r107 = 8;
        MIGRATION_7_8 = new AnonymousClass5(r106, r107);
        final int r108 = 9;
        MIGRATION_8_9 = new AnonymousClass6(r107, r108);
        final int r109 = 11;
        final int r110 = 12;
        MIGRATION_11_12 = new AnonymousClass7(r109, r110);
    }

    private WorkDatabaseMigrations() {
    }
}

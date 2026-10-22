package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class WorkDatabase extends RoomDatabase {
    private static final String PRUNE_SQL_FORMAT_PREFIX = "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ";
    private static final String PRUNE_SQL_FORMAT_SUFFIX = " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    private static final long PRUNE_THRESHOLD_MILLIS = 0;

    public abstract DependencyDao dependencyDao();

    public abstract PreferenceDao preferenceDao();

    public abstract RawWorkInfoDao rawWorkInfoDao();

    public abstract SystemIdInfoDao systemIdInfoDao();

    public abstract WorkNameDao workNameDao();

    public abstract WorkProgressDao workProgressDao();

    public abstract WorkSpecDao workSpecDao();

    public abstract WorkTagDao workTagDao();

    static {
        PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(1);
    }

    public static RoomDatabase.Callback generateCleanupCallback() {
        return new AnonymousClass2();
    }

    public static String getPruneSQL() {
        return PRUNE_SQL_FORMAT_PREFIX + getPruneDate() + PRUNE_SQL_FORMAT_SUFFIX;
    }

    public static long getPruneDate() {
        return System.currentTimeMillis() - PRUNE_THRESHOLD_MILLIS;
    }

    public WorkDatabase() {
    }

    public static WorkDatabase create(final Context r100, Executor r101, boolean r102) {
        if (r102 == false) goto L4;
        RoomDatabase.Builder r103 = Room.inMemoryDatabaseBuilder(r100, WorkDatabase.class).allowMainThreadQueries();
    L6:
        return (WorkDatabase) r103.setQueryExecutor(r101).addCallback(generateCleanupCallback()).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_1_2}).addMigrations(new Migration[]{new WorkDatabaseMigrations.RescheduleMigration(r100, 2, 3)}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_3_4}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_4_5}).addMigrations(new Migration[]{new WorkDatabaseMigrations.RescheduleMigration(r100, 5, 6)}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_6_7}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_7_8}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_8_9}).addMigrations(new Migration[]{new WorkDatabaseMigrations.WorkMigration9To10(r100)}).addMigrations(new Migration[]{new WorkDatabaseMigrations.RescheduleMigration(r100, 10, 11)}).addMigrations(new Migration[]{WorkDatabaseMigrations.MIGRATION_11_12}).fallbackToDestructiveMigration().build();
    L4:
        r103 = Room.databaseBuilder(r100, WorkDatabase.class, WorkDatabasePathHelper.getWorkDatabaseName());
        r103.openHelperFactory(new AnonymousClass1(r100));
        goto L6
    }
}

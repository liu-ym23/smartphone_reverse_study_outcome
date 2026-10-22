package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    public boolean isMigrationRequiredFrom(int r100) {
        return isMigrationRequired(r100, r100 + 1);
    }

    public boolean isMigrationRequired(int r100, int r101) {
        if (r100 <= r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L11;
        if (this.allowDestructiveMigrationOnDowngrade == false) goto L11;
        return false;
    L11:
        if (this.requireMigration == false) goto L17;
        Set<Integer> r103 = this.mMigrationNotRequiredFrom;
        if (r103 != null) goto L15;
        return true;
    L15:
        if (r103.contains(Integer.valueOf(r100)) == true) goto L17;
        return true;
    L17:
        return false;
    L5:
        r102 = false;
        goto L6
    }

    public DatabaseConfiguration(Context r210, String r211, SupportSQLiteOpenHelper.Factory r212, RoomDatabase.MigrationContainer r213, List<RoomDatabase.Callback> r214, boolean r215, RoomDatabase.JournalMode r216, Executor r217, boolean r218, Set<Integer> r310) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r217, false, r218, false, r310, null, null, null, null, null, null);
    }

    public DatabaseConfiguration(Context r210, String r211, SupportSQLiteOpenHelper.Factory r212, RoomDatabase.MigrationContainer r213, List<RoomDatabase.Callback> r214, boolean r215, RoomDatabase.JournalMode r216, Executor r217, Executor r218, boolean r310, boolean r311, boolean r312, Set<Integer> r313) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, null, null, null, null, null, null);
    }

    public DatabaseConfiguration(Context r210, String r211, SupportSQLiteOpenHelper.Factory r212, RoomDatabase.MigrationContainer r213, List<RoomDatabase.Callback> r214, boolean r215, RoomDatabase.JournalMode r216, Executor r217, Executor r218, boolean r310, boolean r311, boolean r312, Set<Integer> r313, String r314, File r315) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, null, null, null, null);
    }

    public DatabaseConfiguration(Context r210, String r211, SupportSQLiteOpenHelper.Factory r212, RoomDatabase.MigrationContainer r213, List<RoomDatabase.Callback> r214, boolean r215, RoomDatabase.JournalMode r216, Executor r217, Executor r218, boolean r310, boolean r311, boolean r312, Set<Integer> r313, String r314, File r315, Callable<InputStream> r316) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, null, null, null);
    }

    public DatabaseConfiguration(Context r210, String r211, SupportSQLiteOpenHelper.Factory r212, RoomDatabase.MigrationContainer r213, List<RoomDatabase.Callback> r214, boolean r215, RoomDatabase.JournalMode r216, Executor r217, Executor r218, boolean r310, boolean r311, boolean r312, Set<Integer> r313, String r314, File r315, Callable<InputStream> r316, RoomDatabase.PrepackagedDatabaseCallback r317) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, null, null);
    }

    public DatabaseConfiguration(Context r210, String r211, SupportSQLiteOpenHelper.Factory r212, RoomDatabase.MigrationContainer r213, List<RoomDatabase.Callback> r214, boolean r215, RoomDatabase.JournalMode r216, Executor r217, Executor r218, boolean r310, boolean r311, boolean r312, Set<Integer> r313, String r314, File r315, Callable<InputStream> r316, RoomDatabase.PrepackagedDatabaseCallback r317, List<Object> r318) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, null);
    }

    public DatabaseConfiguration(Context r100, String r101, SupportSQLiteOpenHelper.Factory r102, RoomDatabase.MigrationContainer r103, List<RoomDatabase.Callback> r104, boolean r105, RoomDatabase.JournalMode r110, Executor r111, Executor r112, Intent r113, boolean r114, boolean r115, Set<Integer> r116, String r117, File r118, Callable<InputStream> r119, RoomDatabase.PrepackagedDatabaseCallback r210, List<Object> r211, List<AutoMigrationSpec> r212) {
        this.sqliteOpenHelperFactory = r102;
        this.context = r100;
        this.name = r101;
        this.migrationContainer = r103;
        this.callbacks = r104;
        this.allowMainThreadQueries = r105;
        this.journalMode = r110;
        this.queryExecutor = r111;
        this.transactionExecutor = r112;
        this.multiInstanceInvalidationServiceIntent = r113;
        if (r113 == null) goto L5;
        boolean r106 = true;
    L6:
        this.multiInstanceInvalidation = r106;
        this.requireMigration = r114;
        this.allowDestructiveMigrationOnDowngrade = r115;
        this.mMigrationNotRequiredFrom = r116;
        this.copyFromAssetPath = r117;
        this.copyFromFile = r118;
        this.copyFromInputStream = r119;
        this.prepackagedDatabaseCallback = r210;
        if (r211 != null) goto L9;
        List<Object> r107 = Collections.emptyList();
    L10:
        this.typeConverters = r107;
        if (r212 != null) goto L13;
        List<AutoMigrationSpec> r108 = Collections.emptyList();
    L14:
        this.autoMigrationSpecs = r108;
        return;
    L13:
        r108 = r212;
        goto L14
    L9:
        r107 = r211;
        goto L10
    L5:
        r106 = false;
        goto L6
    }

    public DatabaseConfiguration(Context r210, String r211, SupportSQLiteOpenHelper.Factory r212, RoomDatabase.MigrationContainer r213, List<RoomDatabase.Callback> r214, boolean r215, RoomDatabase.JournalMode r216, Executor r310, Executor r311, boolean r312, boolean r313, boolean r314, Set<Integer> r315, String r316, File r317, Callable<InputStream> r318, RoomDatabase.PrepackagedDatabaseCallback r319, List<Object> r410, List<AutoMigrationSpec> r411) {
        if (r312 == false) goto L4;
        Intent r100 = new Intent(r210, MultiInstanceInvalidationService.class);
    L5:
        this(r210, r211, r212, r213, r214, r215, r216, r310, r311, r100, r313, r314, r315, r316, r317, r318, r319, r410, r411);
        return;
    L4:
        r100 = null;
        goto L5
    }
}

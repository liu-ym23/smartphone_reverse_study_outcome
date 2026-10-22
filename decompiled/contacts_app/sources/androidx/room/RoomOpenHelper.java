package androidx.room;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    private DatabaseConfiguration mConfiguration;
    private final Delegate mDelegate;
    private final String mIdentityHash;
    private final String mLegacyHash;

    public static abstract class Delegate {
        public final int version;

        protected abstract void createAllTables(SupportSQLiteDatabase database);

        protected abstract void dropAllTables(SupportSQLiteDatabase database);

        protected abstract void onCreate(SupportSQLiteDatabase database);

        protected abstract void onOpen(SupportSQLiteDatabase database);

        protected void onPostMigrate(SupportSQLiteDatabase database) {
        }

        protected void onPreMigrate(SupportSQLiteDatabase database) {
        }

        public Delegate(int version) {
            this.version = version;
        }

        @Deprecated
        protected void validateMigration(SupportSQLiteDatabase db) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        protected ValidationResult onValidateSchema(SupportSQLiteDatabase db) {
            validateMigration(db);
            return new ValidationResult(true, null);
        }
    }

    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean isValid, String expectedFoundMsg) {
            this.isValid = isValid;
            this.expectedFoundMsg = expectedFoundMsg;
        }
    }

    public RoomOpenHelper(DatabaseConfiguration configuration, Delegate delegate, String identityHash, String legacyHash) {
        super(delegate.version);
        this.mConfiguration = configuration;
        this.mDelegate = delegate;
        this.mIdentityHash = identityHash;
        this.mLegacyHash = legacyHash;
    }

    public RoomOpenHelper(DatabaseConfiguration configuration, Delegate delegate, String legacyHash) {
        this(configuration, delegate, "", legacyHash);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase db) {
        boolean r0 = hasEmptySchema(db);
        this.mDelegate.createAllTables(db);
        if (r0 == true) goto L9;
        ValidationResult r1 = this.mDelegate.onValidateSchema(db);
        if (r1.isValid == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.expectedFoundMsg);
    L9:
        updateIdentity(db);
        this.mDelegate.onCreate(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        DatabaseConfiguration r0 = this.mConfiguration;
        if (r0 == null) goto L15;
        List<Migration> r1 = r0.migrationContainer.findMigrationPath(oldVersion, newVersion);
        if (r1 == null) goto L15;
        this.mDelegate.onPreMigrate(db);
        Iterator<Migration> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r2.next().migrate(db);
        goto L8
    L10:
        ValidationResult r3 = this.mDelegate.onValidateSchema(db);
        if (r3.isValid == false) goto L14;
        this.mDelegate.onPostMigrate(db);
        updateIdentity(db);
        boolean r4 = true;
    L16:
        if (r4 == true) goto L24;
        DatabaseConfiguration r5 = this.mConfiguration;
        if (r5 == null) goto L23;
        if (r5.isMigrationRequired(oldVersion, newVersion) == true) goto L23;
        this.mDelegate.dropAllTables(db);
        this.mDelegate.createAllTables(db);
        return;
    L23:
        throw new IllegalStateException("A migration from " + oldVersion + " to " + newVersion + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    L24:
        return;
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r3.expectedFoundMsg);
    L15:
        r4 = false;
        goto L16
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase db) {
        super.onOpen(db);
        checkIdentity(db);
        this.mDelegate.onOpen(db);
        this.mConfiguration = null;
    }

    private void checkIdentity(SupportSQLiteDatabase db) {
        if (hasRoomMasterTable(db) == false) goto L20;
        Cursor r3 = db.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
    L17:
        th = move-exception;
        r3.close();
        throw th;
    L6:
        if (r3.moveToFirst() == false) goto L9;
        String r0 = r3.getString(0);     // Catch: Throwable -> L17
    L10:
        r3.close();
        if (this.mIdentityHash.equals(r0) == false) goto L13;
        return;
    L13:
        if (this.mLegacyHash.equals(r0) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
    L9:
        r0 = null;
        goto L10
    L20:
        ValidationResult r1 = this.mDelegate.onValidateSchema(db);
        if (r1.isValid == false) goto L25;
        this.mDelegate.onPostMigrate(db);
        updateIdentity(db);
        return;
    L25:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.expectedFoundMsg);
    }

    private void updateIdentity(SupportSQLiteDatabase db) {
        createMasterTableIfNotExists(db);
        db.execSQL(RoomMasterTable.createInsertQuery(this.mIdentityHash));
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase db) {
        db.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private static boolean hasRoomMasterTable(SupportSQLiteDatabase db) {
        Cursor r2 = db.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        boolean r1 = false;
        if (r2.moveToFirst() == false) goto L8;
        if (r2.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r2.close();
        return r1;
    L10:
        th = move-exception;
        r2.close();
        throw th;
    }

    private static boolean hasEmptySchema(SupportSQLiteDatabase db) {
        Cursor r2 = db.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        boolean r1 = false;
        if (r2.moveToFirst() == false) goto L8;
        if (r2.getInt(0) != 0) goto L8;
        r1 = true;
    L8:
        r2.close();
        return r1;
    L10:
        th = move-exception;
        r2.close();
        throw th;
    }
}

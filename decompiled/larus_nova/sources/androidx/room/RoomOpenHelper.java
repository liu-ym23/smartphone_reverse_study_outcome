package androidx.room;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    private DatabaseConfiguration mConfiguration;
    private final Delegate mDelegate;
    private final String mIdentityHash;
    private final String mLegacyHash;

    public static abstract class Delegate {
        public final int version;

        public abstract void createAllTables(SupportSQLiteDatabase r100);

        public abstract void dropAllTables(SupportSQLiteDatabase r100);

        public abstract void onCreate(SupportSQLiteDatabase r100);

        public abstract void onOpen(SupportSQLiteDatabase r100);

        public void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public void onPreMigrate(SupportSQLiteDatabase r100) {
        }

        public Delegate(int r100) {
            this.version = r100;
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase r100) {
            validateMigration(r100);
            return new ValidationResult(true, null);
        }

        public void validateMigration(SupportSQLiteDatabase r100) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean r100, String r101) {
            this.isValid = r100;
            this.expectedFoundMsg = r101;
        }
    }

    private void checkIdentity(SupportSQLiteDatabase r100) {
        if (hasRoomMasterTable(r100) == false) goto L20;
        Cursor r101 = r100.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
    L17:
        th = move-exception;
        r101.close();
        throw th;
    L6:
        if (r101.moveToFirst() == false) goto L9;
        String r102 = r101.getString(0);     // Catch: Throwable -> L17
    L10:
        r101.close();
        if (this.mIdentityHash.equals(r102) == false) goto L13;
        return;
    L13:
        if (this.mLegacyHash.equals(r102) == false) goto L16;
        return;
    L16:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
    L9:
        r102 = null;
        goto L10
    L20:
        ValidationResult r103 = this.mDelegate.onValidateSchema(r100);
        if (r103.isValid == false) goto L25;
        this.mDelegate.onPostMigrate(r100);
        updateIdentity(r100);
        return;
    L25:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r103.expectedFoundMsg);
    }

    private void createMasterTableIfNotExists(SupportSQLiteDatabase r100) {
        r100.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private static boolean hasEmptySchema(SupportSQLiteDatabase r100) {
        Cursor r101 = r100.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        boolean r102 = false;
        if (r101.moveToFirst() == false) goto L8;
        if (r101.getInt(0) != 0) goto L8;
        r102 = true;
    L8:
        r101.close();
        return r102;
    L10:
        th = move-exception;
        r101.close();
        throw th;
    }

    private static boolean hasRoomMasterTable(SupportSQLiteDatabase r100) {
        Cursor r101 = r100.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        boolean r102 = false;
        if (r101.moveToFirst() == false) goto L8;
        if (r101.getInt(0) == 0) goto L8;
        r102 = true;
    L8:
        r101.close();
        return r102;
    L10:
        th = move-exception;
        r101.close();
        throw th;
    }

    private void updateIdentity(SupportSQLiteDatabase r100) {
        createMasterTableIfNotExists(r100);
        r100.execSQL(RoomMasterTable.createInsertQuery(this.mIdentityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(SupportSQLiteDatabase r100) {
        super.onConfigure(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(SupportSQLiteDatabase r100) {
        boolean r101 = hasEmptySchema(r100);
        this.mDelegate.createAllTables(r100);
        if (r101 == true) goto L9;
        ValidationResult r102 = this.mDelegate.onValidateSchema(r100);
        if (r102.isValid == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r102.expectedFoundMsg);
    L9:
        updateIdentity(r100);
        this.mDelegate.onCreate(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(SupportSQLiteDatabase r100) {
        super.onOpen(r100);
        checkIdentity(r100);
        this.mDelegate.onOpen(r100);
        this.mConfiguration = null;
    }

    public RoomOpenHelper(DatabaseConfiguration r100, Delegate r101, String r102) {
        this(r100, r101, "", r102);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(SupportSQLiteDatabase r100, int r101, int r102) {
        onUpgrade(r100, r101, r102);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase r100, int r101, int r102) {
        DatabaseConfiguration r103 = this.mConfiguration;
        if (r103 == null) goto L15;
        List<Migration> r104 = r103.migrationContainer.findMigrationPath(r101, r102);
        if (r104 == null) goto L15;
        this.mDelegate.onPreMigrate(r100);
        Iterator<Migration> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r105.next().migrate(r100);
        goto L8
    L10:
        ValidationResult r106 = this.mDelegate.onValidateSchema(r100);
        if (r106.isValid == false) goto L14;
        this.mDelegate.onPostMigrate(r100);
        updateIdentity(r100);
        boolean r107 = true;
    L16:
        if (r107 == true) goto L24;
        DatabaseConfiguration r108 = this.mConfiguration;
        if (r108 == null) goto L23;
        if (r108.isMigrationRequired(r101, r102) == true) goto L23;
        this.mDelegate.dropAllTables(r100);
        this.mDelegate.createAllTables(r100);
        return;
    L23:
        throw new IllegalStateException("A migration from " + r101 + " to " + r102 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    L24:
        return;
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r106.expectedFoundMsg);
    L15:
        r107 = false;
        goto L16
    }

    public RoomOpenHelper(DatabaseConfiguration r100, Delegate r101, String r102, String r103) {
        super(r101.version);
        this.mConfiguration = r100;
        this.mDelegate = r101;
        this.mIdentityHash = r102;
        this.mLegacyHash = r103;
    }
}

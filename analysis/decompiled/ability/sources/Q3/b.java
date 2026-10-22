package Q3;

import android.database.SQLException;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b extends Migration {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1100a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i, int i6, int i10) {
        super(i, i6);
        this.f1100a = i10;
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase db) throws SQLException {
        switch (this.f1100a) {
            case 0:
                k.f(db, "db");
                db.execSQL("CREATE TABLE IF NOT EXISTS t_atomic_ability (\n    packageName TEXT NOT NULL,\n    toolName TEXT NOT NULL,\n    name TEXT,\n    description TEXT NOT NULL,\n    callType TEXT NOT NULL,\n    callingMethod TEXT NOT NULL,\n    timeout INTEGER,\n    deviceType TEXT NOT NULL,\n    type TEXT,\n    capabilityType TEXT,\n    permission TEXT,\n    inputSchemaJson TEXT,\n    outputSchemaJson TEXT,\n    extraJson TEXT,\n    toolVersion TEXT,\n    appName TEXT NOT NULL,\n    appVersion TEXT,\n    appSource TEXT,\n    authType TEXT,\n    signature TEXT,\n    updateTime INTEGER NOT NULL,\n    PRIMARY KEY(packageName, toolName)\n)");
                db.execSQL("CREATE INDEX IF NOT EXISTS index_t_atomic_ability_toolName ON t_atomic_ability(toolName)");
                break;
            case 1:
                k.f(db, "db");
                db.execSQL("DROP TABLE IF EXISTS t_atomic_ability_new");
                db.execSQL("CREATE TABLE IF NOT EXISTS t_atomic_ability_new (\n    packageName TEXT NOT NULL,\n    toolName TEXT NOT NULL,\n    functionName TEXT NOT NULL,\n    description TEXT NOT NULL,\n    callType TEXT NOT NULL,\n    callingMethod TEXT NOT NULL,\n    timeout INTEGER,\n    deviceType TEXT NOT NULL,\n    type TEXT,\n    capabilityType TEXT,\n    permission TEXT,\n    inputSchemaJson TEXT,\n    outputSchemaJson TEXT,\n    extraJson TEXT,\n    toolVersion TEXT,\n    appName TEXT NOT NULL,\n    appVersion TEXT,\n    appSource TEXT,\n    authType TEXT,\n    signature TEXT,\n    updateTime INTEGER NOT NULL,\n    PRIMARY KEY(packageName, functionName)\n)");
                db.execSQL("INSERT INTO t_atomic_ability_new (\n    packageName, toolName, functionName, description, callType, callingMethod,\n    timeout, deviceType, type, capabilityType, permission,\n    inputSchemaJson, outputSchemaJson, extraJson, toolVersion,\n    appName, appVersion, appSource, authType, signature, updateTime\n)\nSELECT\n    packageName,\n    COALESCE(NULLIF(name, ''), toolName),\n    toolName,\n    description, callType, callingMethod,\n    timeout, deviceType, type, capabilityType, permission,\n    inputSchemaJson, outputSchemaJson, extraJson, toolVersion,\n    appName, appVersion, appSource, authType, signature, updateTime\nFROM t_atomic_ability");
                db.execSQL("DROP TABLE t_atomic_ability");
                db.execSQL("ALTER TABLE t_atomic_ability_new RENAME TO t_atomic_ability");
                db.execSQL("CREATE INDEX IF NOT EXISTS index_t_atomic_ability_toolName ON t_atomic_ability(toolName)");
                break;
            case 2:
                k.f(db, "db");
                db.execSQL("ALTER TABLE t_atomic_ability ADD COLUMN abilityId INTEGER NOT NULL DEFAULT -1");
                db.execSQL("ALTER TABLE t_atomic_ability ADD COLUMN appId INTEGER NOT NULL DEFAULT -1");
                db.execSQL("CREATE INDEX IF NOT EXISTS index_t_atomic_ability_abilityId ON t_atomic_ability(abilityId)");
                break;
            case 3:
                k.f(db, "db");
                db.execSQL("UPDATE t_atomic_ability SET abilityId = -1 WHERE abilityId = 0");
                db.execSQL("UPDATE t_atomic_ability SET appId = -1 WHERE appId = 0");
                break;
            case 4:
                k.f(db, "db");
                db.execSQL("CREATE TABLE IF NOT EXISTS t_sync_cache_meta (\n    id INTEGER NOT NULL PRIMARY KEY,\n    localScanGeneration INTEGER NOT NULL DEFAULT 0,\n    cloudSyncGeneration INTEGER NOT NULL DEFAULT 0,\n    localScanCompletedAt INTEGER NOT NULL DEFAULT 0,\n    cloudSyncCompletedAt INTEGER NOT NULL DEFAULT 0,\n    uploadLastSuccessAt INTEGER NOT NULL DEFAULT 0,\n    deviceId TEXT NOT NULL DEFAULT ''\n)");
                db.execSQL("INSERT OR IGNORE INTO t_sync_cache_meta (id) VALUES (1)");
                break;
            case 5:
                k.f(db, "db");
                db.execSQL("ALTER TABLE t_atomic_ability ADD COLUMN slaScene TEXT");
                break;
            default:
                k.f(db, "database");
                db.execSQL("ALTER TABLE task_step ADD COLUMN screenshotUploadDuration INTEGER NOT NULL DEFAULT 0");
                db.execSQL("ALTER TABLE task_step ADD COLUMN inferenceDuration INTEGER NOT NULL DEFAULT 0");
                db.execSQL("ALTER TABLE task_step ADD COLUMN durationData TEXT");
                break;
        }
    }
}

package Q3;

import H4.o;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.ability.database.AppDatabase_Impl;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

/* loaded from: classes3.dex */
public final class e extends RoomOpenDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppDatabase_Impl f1103a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(AppDatabase_Impl appDatabase_Impl) {
        super(7, "bbf59d6660777c7da407d098190acf1f", "931b05c972f3e306ae3ac0064671321a");
        this.f1103a = appDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void createAllTables(SQLiteConnection connection) {
        k.f(connection, "connection");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `t_ability` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT NOT NULL, `version` TEXT NOT NULL, `status` TEXT NOT NULL, `icon` TEXT NOT NULL, `updateTime` INTEGER NOT NULL, `syncStatus` TEXT NOT NULL, `syncTime` INTEGER NOT NULL, `tools` TEXT NOT NULL)");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_t_ability_packageName` ON `t_ability` (`packageName`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `t_ability_task` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `taskCode` TEXT NOT NULL, `abilityId` INTEGER, `pkgName` TEXT NOT NULL, `method` TEXT NOT NULL, `paramsJson` TEXT, `extra` TEXT, `status` TEXT NOT NULL, `retryCount` INTEGER NOT NULL, `priority` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `is_cloud_ability` INTEGER NOT NULL DEFAULT 0, `trace_id` TEXT NOT NULL DEFAULT '', `tool_call_id` TEXT NOT NULL DEFAULT '', `timeout` INTEGER NOT NULL DEFAULT 0)");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_t_ability_task_taskCode` ON `t_ability_task` (`taskCode`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `t_ability_report_task` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `taskCode` TEXT NOT NULL, `packageName` TEXT NOT NULL, `installType` TEXT NOT NULL, `payload` TEXT NOT NULL, `status` INTEGER NOT NULL, `retryCount` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_t_ability_report_task_taskCode` ON `t_ability_report_task` (`taskCode`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `t_atomic_ability` (`packageName` TEXT NOT NULL, `toolName` TEXT NOT NULL, `functionName` TEXT NOT NULL, `abilityId` INTEGER NOT NULL, `appId` INTEGER NOT NULL, `description` TEXT NOT NULL, `callType` TEXT NOT NULL, `callingMethod` TEXT NOT NULL, `timeout` INTEGER, `deviceType` TEXT NOT NULL, `type` TEXT, `capabilityType` TEXT, `permission` TEXT, `inputSchemaJson` TEXT, `outputSchemaJson` TEXT, `extraJson` TEXT, `toolVersion` TEXT, `appName` TEXT NOT NULL, `appVersion` TEXT, `appSource` TEXT, `authType` TEXT, `signature` TEXT, `updateTime` INTEGER NOT NULL, `slaScene` TEXT, PRIMARY KEY(`packageName`, `functionName`))");
        SQLite.execSQL(connection, "CREATE INDEX IF NOT EXISTS `index_t_atomic_ability_toolName` ON `t_atomic_ability` (`toolName`)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `t_sync_cache_meta` (`id` INTEGER NOT NULL, `localScanGeneration` INTEGER NOT NULL, `cloudSyncGeneration` INTEGER NOT NULL, `localScanCompletedAt` INTEGER NOT NULL, `cloudSyncCompletedAt` INTEGER NOT NULL, `uploadLastSuccessAt` INTEGER NOT NULL, `deviceId` TEXT NOT NULL, PRIMARY KEY(`id`))");
        SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bbf59d6660777c7da407d098190acf1f')");
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void dropAllTables(SQLiteConnection connection) {
        k.f(connection, "connection");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `t_ability`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `t_ability_task`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `t_ability_report_task`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `t_atomic_ability`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `t_sync_cache_meta`");
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void onCreate(SQLiteConnection connection) {
        k.f(connection, "connection");
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void onOpen(SQLiteConnection connection) {
        k.f(connection, "connection");
        this.f1103a.internalInitInvalidationTracker(connection);
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void onPostMigrate(SQLiteConnection connection) {
        k.f(connection, "connection");
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void onPreMigrate(SQLiteConnection connection) {
        k.f(connection, "connection");
        DBUtil.dropFtsSyncTriggers(connection);
    }

    @Override // androidx.room.RoomOpenDelegate
    public final RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
        k.f(connection, "connection");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        linkedHashMap.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, 1));
        linkedHashMap.put("version", new TableInfo.Column("version", "TEXT", true, 0, null, 1));
        linkedHashMap.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, 1));
        linkedHashMap.put("icon", new TableInfo.Column("icon", "TEXT", true, 0, null, 1));
        linkedHashMap.put("updateTime", new TableInfo.Column("updateTime", "INTEGER", true, 0, null, 1));
        linkedHashMap.put("syncStatus", new TableInfo.Column("syncStatus", "TEXT", true, 0, null, 1));
        linkedHashMap.put("syncTime", new TableInfo.Column("syncTime", "INTEGER", true, 0, null, 1));
        linkedHashMap.put("tools", new TableInfo.Column("tools", "TEXT", true, 0, null, 1));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.add(new TableInfo.Index("index_t_ability_packageName", true, o.M("packageName"), o.M("ASC")));
        TableInfo tableInfo = new TableInfo("t_ability", linkedHashMap, linkedHashSet, linkedHashSet2);
        TableInfo.Companion companion = TableInfo.INSTANCE;
        TableInfo tableInfo2 = companion.read(connection, "t_ability");
        if (!tableInfo.equals(tableInfo2)) {
            return new RoomOpenDelegate.ValidationResult(false, "t_ability(com.stepos.ability.database.entity.AbilityEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        linkedHashMap2.put("taskCode", new TableInfo.Column("taskCode", "TEXT", true, 0, null, 1));
        linkedHashMap2.put("abilityId", new TableInfo.Column("abilityId", "INTEGER", false, 0, null, 1));
        linkedHashMap2.put("pkgName", new TableInfo.Column("pkgName", "TEXT", true, 0, null, 1));
        linkedHashMap2.put(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, new TableInfo.Column(GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "TEXT", true, 0, null, 1));
        linkedHashMap2.put("paramsJson", new TableInfo.Column("paramsJson", "TEXT", false, 0, null, 1));
        linkedHashMap2.put("extra", new TableInfo.Column("extra", "TEXT", false, 0, null, 1));
        linkedHashMap2.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, 1));
        linkedHashMap2.put("retryCount", new TableInfo.Column("retryCount", "INTEGER", true, 0, null, 1));
        linkedHashMap2.put("priority", new TableInfo.Column("priority", "INTEGER", true, 0, null, 1));
        linkedHashMap2.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, null, 1));
        linkedHashMap2.put("is_cloud_ability", new TableInfo.Column("is_cloud_ability", "INTEGER", true, 0, "0", 1));
        linkedHashMap2.put(Key.KEY_TRACE_ID, new TableInfo.Column(Key.KEY_TRACE_ID, "TEXT", true, 0, "''", 1));
        linkedHashMap2.put(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, new TableInfo.Column(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, "TEXT", true, 0, "''", 1));
        linkedHashMap2.put(InjectExperienceResult.REASON_TIMEOUT, new TableInfo.Column(InjectExperienceResult.REASON_TIMEOUT, "INTEGER", true, 0, "0", 1));
        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
        LinkedHashSet linkedHashSet4 = new LinkedHashSet();
        linkedHashSet4.add(new TableInfo.Index("index_t_ability_task_taskCode", true, o.M("taskCode"), o.M("ASC")));
        TableInfo tableInfo3 = new TableInfo("t_ability_task", linkedHashMap2, linkedHashSet3, linkedHashSet4);
        TableInfo tableInfo4 = companion.read(connection, "t_ability_task");
        if (!tableInfo3.equals(tableInfo4)) {
            return new RoomOpenDelegate.ValidationResult(false, "t_ability_task(com.stepos.ability.database.entity.AbilityTaskEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        linkedHashMap3.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
        linkedHashMap3.put("taskCode", new TableInfo.Column("taskCode", "TEXT", true, 0, null, 1));
        linkedHashMap3.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 0, null, 1));
        linkedHashMap3.put("installType", new TableInfo.Column("installType", "TEXT", true, 0, null, 1));
        linkedHashMap3.put("payload", new TableInfo.Column("payload", "TEXT", true, 0, null, 1));
        linkedHashMap3.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, 1));
        linkedHashMap3.put("retryCount", new TableInfo.Column("retryCount", "INTEGER", true, 0, null, 1));
        LinkedHashSet linkedHashSet5 = new LinkedHashSet();
        LinkedHashSet linkedHashSet6 = new LinkedHashSet();
        linkedHashSet6.add(new TableInfo.Index("index_t_ability_report_task_taskCode", true, o.M("taskCode"), o.M("ASC")));
        TableInfo tableInfo5 = new TableInfo("t_ability_report_task", linkedHashMap3, linkedHashSet5, linkedHashSet6);
        TableInfo tableInfo6 = companion.read(connection, "t_ability_report_task");
        if (!tableInfo5.equals(tableInfo6)) {
            return new RoomOpenDelegate.ValidationResult(false, "t_ability_report_task(com.stepos.ability.database.entity.AbilityReportTaskEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        linkedHashMap4.put("packageName", new TableInfo.Column("packageName", "TEXT", true, 1, null, 1));
        linkedHashMap4.put("toolName", new TableInfo.Column("toolName", "TEXT", true, 0, null, 1));
        linkedHashMap4.put("functionName", new TableInfo.Column("functionName", "TEXT", true, 2, null, 1));
        linkedHashMap4.put("abilityId", new TableInfo.Column("abilityId", "INTEGER", true, 0, null, 1));
        linkedHashMap4.put("appId", new TableInfo.Column("appId", "INTEGER", true, 0, null, 1));
        linkedHashMap4.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
        linkedHashMap4.put("callType", new TableInfo.Column("callType", "TEXT", true, 0, null, 1));
        linkedHashMap4.put("callingMethod", new TableInfo.Column("callingMethod", "TEXT", true, 0, null, 1));
        linkedHashMap4.put(InjectExperienceResult.REASON_TIMEOUT, new TableInfo.Column(InjectExperienceResult.REASON_TIMEOUT, "INTEGER", false, 0, null, 1));
        linkedHashMap4.put("deviceType", new TableInfo.Column("deviceType", "TEXT", true, 0, null, 1));
        linkedHashMap4.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("capabilityType", new TableInfo.Column("capabilityType", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("permission", new TableInfo.Column("permission", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("inputSchemaJson", new TableInfo.Column("inputSchemaJson", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("outputSchemaJson", new TableInfo.Column("outputSchemaJson", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("extraJson", new TableInfo.Column("extraJson", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("toolVersion", new TableInfo.Column("toolVersion", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("appName", new TableInfo.Column("appName", "TEXT", true, 0, null, 1));
        linkedHashMap4.put("appVersion", new TableInfo.Column("appVersion", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("appSource", new TableInfo.Column("appSource", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("authType", new TableInfo.Column("authType", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("signature", new TableInfo.Column("signature", "TEXT", false, 0, null, 1));
        linkedHashMap4.put("updateTime", new TableInfo.Column("updateTime", "INTEGER", true, 0, null, 1));
        linkedHashMap4.put(SLAScene.SLA_SCENE, new TableInfo.Column(SLAScene.SLA_SCENE, "TEXT", false, 0, null, 1));
        LinkedHashSet linkedHashSet7 = new LinkedHashSet();
        LinkedHashSet linkedHashSet8 = new LinkedHashSet();
        linkedHashSet8.add(new TableInfo.Index("index_t_atomic_ability_toolName", false, o.M("toolName"), o.M("ASC")));
        TableInfo tableInfo7 = new TableInfo("t_atomic_ability", linkedHashMap4, linkedHashSet7, linkedHashSet8);
        TableInfo tableInfo8 = companion.read(connection, "t_atomic_ability");
        if (!tableInfo7.equals(tableInfo8)) {
            return new RoomOpenDelegate.ValidationResult(false, "t_atomic_ability(com.stepos.ability.database.entity.AtomicAbilityEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
        }
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        linkedHashMap5.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        linkedHashMap5.put("localScanGeneration", new TableInfo.Column("localScanGeneration", "INTEGER", true, 0, null, 1));
        linkedHashMap5.put("cloudSyncGeneration", new TableInfo.Column("cloudSyncGeneration", "INTEGER", true, 0, null, 1));
        linkedHashMap5.put("localScanCompletedAt", new TableInfo.Column("localScanCompletedAt", "INTEGER", true, 0, null, 1));
        linkedHashMap5.put("cloudSyncCompletedAt", new TableInfo.Column("cloudSyncCompletedAt", "INTEGER", true, 0, null, 1));
        linkedHashMap5.put("uploadLastSuccessAt", new TableInfo.Column("uploadLastSuccessAt", "INTEGER", true, 0, null, 1));
        linkedHashMap5.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, null, 1));
        TableInfo tableInfo9 = new TableInfo("t_sync_cache_meta", linkedHashMap5, new LinkedHashSet(), new LinkedHashSet());
        TableInfo tableInfo10 = companion.read(connection, "t_sync_cache_meta");
        if (tableInfo9.equals(tableInfo10)) {
            return new RoomOpenDelegate.ValidationResult(true, null);
        }
        return new RoomOpenDelegate.ValidationResult(false, "t_sync_cache_meta(com.stepos.ability.database.entity.SyncCacheMetaEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
    }
}

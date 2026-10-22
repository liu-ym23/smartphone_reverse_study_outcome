package s6;

import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.taskrobot.taskmemory.AppTaskDatabase_Impl;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.k;

/* renamed from: s6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1917d extends RoomOpenDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppTaskDatabase_Impl f5990a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1917d(AppTaskDatabase_Impl appTaskDatabase_Impl) {
        super(2, "2961f91319307e1408d6519d5e813011", "ccb7ca37967c96000c5099b7e879e3d4");
        this.f5990a = appTaskDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void createAllTables(SQLiteConnection connection) {
        k.f(connection, "connection");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `task` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `taskId` TEXT NOT NULL, `deviceInfoId` INTEGER NOT NULL, `taskName` TEXT NOT NULL, `taskDesc` TEXT NOT NULL, `guiTree` TEXT, `result` TEXT, `createTime` INTEGER NOT NULL, `endTime` INTEGER, `durationTime` INTEGER, `coverImage` TEXT)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `task_device_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `brand` TEXT NOT NULL, `userId` TEXT NOT NULL, `deviceId` TEXT NOT NULL, `model` TEXT NOT NULL, `product` TEXT NOT NULL, `osVersion` TEXT NOT NULL, `resolution` TEXT NOT NULL, `density` REAL NOT NULL, `createTime` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `task_step` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `actionId` TEXT NOT NULL, `taskId` TEXT NOT NULL, `actionType` TEXT NOT NULL, `prompt` TEXT, `screenshotPath` TEXT, `actionContent` TEXT, `appName` TEXT, `appVersion` TEXT, `currActivity` TEXT, `orientation` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `endTime` INTEGER, `actionResult` TEXT, `screenshotUploadDuration` INTEGER NOT NULL, `inferenceDuration` INTEGER NOT NULL, `durationData` TEXT)");
        SQLite.execSQL(connection, RoomMasterTable.CREATE_QUERY);
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2961f91319307e1408d6519d5e813011')");
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void dropAllTables(SQLiteConnection connection) {
        k.f(connection, "connection");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `task`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `task_device_info`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `task_step`");
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void onCreate(SQLiteConnection connection) {
        k.f(connection, "connection");
    }

    @Override // androidx.room.RoomOpenDelegate
    public final void onOpen(SQLiteConnection connection) {
        k.f(connection, "connection");
        this.f5990a.internalInitInvalidationTracker(connection);
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
        linkedHashMap.put(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, new TableInfo.Column(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "TEXT", true, 0, null, 1));
        linkedHashMap.put("deviceInfoId", new TableInfo.Column("deviceInfoId", "INTEGER", true, 0, null, 1));
        linkedHashMap.put(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, new TableInfo.Column(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "TEXT", true, 0, null, 1));
        linkedHashMap.put("taskDesc", new TableInfo.Column("taskDesc", "TEXT", true, 0, null, 1));
        linkedHashMap.put("guiTree", new TableInfo.Column("guiTree", "TEXT", false, 0, null, 1));
        linkedHashMap.put("result", new TableInfo.Column("result", "TEXT", false, 0, null, 1));
        linkedHashMap.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, null, 1));
        linkedHashMap.put("endTime", new TableInfo.Column("endTime", "INTEGER", false, 0, null, 1));
        linkedHashMap.put("durationTime", new TableInfo.Column("durationTime", "INTEGER", false, 0, null, 1));
        linkedHashMap.put("coverImage", new TableInfo.Column("coverImage", "TEXT", false, 0, null, 1));
        TableInfo tableInfo = new TableInfo("task", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
        TableInfo.Companion companion = TableInfo.INSTANCE;
        TableInfo tableInfo2 = companion.read(connection, "task");
        if (!tableInfo.equals(tableInfo2)) {
            return new RoomOpenDelegate.ValidationResult(false, "task(com.stepos.taskrobot.taskmemory.entity.TaskEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        linkedHashMap2.put("brand", new TableInfo.Column("brand", "TEXT", true, 0, null, 1));
        linkedHashMap2.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, 1));
        linkedHashMap2.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, null, 1));
        linkedHashMap2.put(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, new TableInfo.Column(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "TEXT", true, 0, null, 1));
        linkedHashMap2.put("product", new TableInfo.Column("product", "TEXT", true, 0, null, 1));
        linkedHashMap2.put("osVersion", new TableInfo.Column("osVersion", "TEXT", true, 0, null, 1));
        linkedHashMap2.put("resolution", new TableInfo.Column("resolution", "TEXT", true, 0, null, 1));
        linkedHashMap2.put("density", new TableInfo.Column("density", "REAL", true, 0, null, 1));
        linkedHashMap2.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, null, 1));
        TableInfo tableInfo3 = new TableInfo("task_device_info", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
        TableInfo tableInfo4 = companion.read(connection, "task_device_info");
        if (!tableInfo3.equals(tableInfo4)) {
            return new RoomOpenDelegate.ValidationResult(false, "task_device_info(com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        linkedHashMap3.put("actionId", new TableInfo.Column("actionId", "TEXT", true, 0, null, 1));
        linkedHashMap3.put(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, new TableInfo.Column(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "TEXT", true, 0, null, 1));
        linkedHashMap3.put("actionType", new TableInfo.Column("actionType", "TEXT", true, 0, null, 1));
        linkedHashMap3.put(HighlightArgsBundle.KEY_PROMPT, new TableInfo.Column(HighlightArgsBundle.KEY_PROMPT, "TEXT", false, 0, null, 1));
        linkedHashMap3.put("screenshotPath", new TableInfo.Column("screenshotPath", "TEXT", false, 0, null, 1));
        linkedHashMap3.put("actionContent", new TableInfo.Column("actionContent", "TEXT", false, 0, null, 1));
        linkedHashMap3.put("appName", new TableInfo.Column("appName", "TEXT", false, 0, null, 1));
        linkedHashMap3.put("appVersion", new TableInfo.Column("appVersion", "TEXT", false, 0, null, 1));
        linkedHashMap3.put("currActivity", new TableInfo.Column("currActivity", "TEXT", false, 0, null, 1));
        linkedHashMap3.put("orientation", new TableInfo.Column("orientation", "INTEGER", true, 0, null, 1));
        linkedHashMap3.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, 1));
        linkedHashMap3.put("endTime", new TableInfo.Column("endTime", "INTEGER", false, 0, null, 1));
        linkedHashMap3.put("actionResult", new TableInfo.Column("actionResult", "TEXT", false, 0, null, 1));
        linkedHashMap3.put("screenshotUploadDuration", new TableInfo.Column("screenshotUploadDuration", "INTEGER", true, 0, null, 1));
        linkedHashMap3.put("inferenceDuration", new TableInfo.Column("inferenceDuration", "INTEGER", true, 0, null, 1));
        linkedHashMap3.put("durationData", new TableInfo.Column("durationData", "TEXT", false, 0, null, 1));
        TableInfo tableInfo5 = new TableInfo("task_step", linkedHashMap3, new LinkedHashSet(), new LinkedHashSet());
        TableInfo tableInfo6 = companion.read(connection, "task_step");
        if (tableInfo5.equals(tableInfo6)) {
            return new RoomOpenDelegate.ValidationResult(true, null);
        }
        return new RoomOpenDelegate.ValidationResult(false, "task_step(com.stepos.taskrobot.taskmemory.entity.TaskStepEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
    }
}

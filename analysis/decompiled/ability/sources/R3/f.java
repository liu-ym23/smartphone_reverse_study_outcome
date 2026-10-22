package R3;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.stepos.ability.database.dao.AbilityReportDao_Impl;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.taskrobot.taskmemory.dao.TaskDao_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import com.uxsense.search.ApexSearchIndexManager;
import com.uxsense.search.SearchableEntity;
import com.uxsense.user.AccountEntry;
import com.uxsense.user.ApexAccountManager;
import java.util.Map;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1146a;
    public final /* synthetic */ long b;

    public /* synthetic */ f(long j5, int i) {
        this.f1146a = i;
        this.b = j5;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1146a) {
            case 0:
                return AbilityReportDao_Impl.increaseRetryCount$lambda$0("UPDATE t_ability_report_task SET retryCount = retryCount + 1 WHERE id = ?", this.b, (SQLiteConnection) obj);
            case 1:
                return Long.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaximumSize$lambda$2(this.b, (SupportSQLiteDatabase) obj));
            case 2:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_pageSize_$lambda$3(this.b, (SupportSQLiteDatabase) obj);
            case 3:
                return Boolean.valueOf(ApexSearchIndexManager.removeCreationIndex$lambda$10$lambda$8(this.b, (SearchableEntity) obj));
            case 4:
                return Boolean.valueOf(ApexAccountManager.invalidateCache$lambda$22(this.b, (AccountEntry) obj));
            case 5:
                return Boolean.valueOf(CallbackCache.removeCallback$lambda$4(this.b, (Map.Entry) obj));
            case 6:
                return Long.valueOf(this.b);
            case 7:
                return TaskDao_Impl.getDeviceById$lambda$0("SELECT * FROM task_device_info WHERE id = ? LIMIT 1", this.b, (SQLiteConnection) obj);
            case 8:
                return TaskDao_Impl.getById$lambda$0("SELECT * FROM task WHERE id = ?", this.b, (SQLiteConnection) obj);
            case 9:
                return TaskDeviceInfoDao_Impl.deleteById$lambda$0("DELETE FROM task_device_info WHERE id = ?", this.b, (SQLiteConnection) obj);
            case 10:
                return TaskDeviceInfoDao_Impl.getById$lambda$0("SELECT * FROM task_device_info WHERE id = ? LIMIT 1", this.b, (SQLiteConnection) obj);
            case 11:
                return TaskStepDao_Impl.getDurationDataById$lambda$0("SELECT durationData FROM task_step WHERE id = ?", this.b, (SQLiteConnection) obj);
            default:
                return TaskStepDao_Impl.getById$lambda$0("SELECT * FROM task_step WHERE id = ?", this.b, (SQLiteConnection) obj);
        }
    }
}

package D6;

import C7.r;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.mdisdk.observer.ForegroundAppFilter;
import com.stepos.ability.database.dao.AbilityReportDao_Impl;
import com.stepos.ability.database.dao.AtomicAbilityDao_Impl;
import com.stepos.ability.database.dao.SyncCacheMetaDao_Impl;
import com.stepos.agentbus.generated.AgentBusBindingBase;
import com.stepos.motionkit.fx.material.capability.BlendParams;
import com.stepos.taskrobot.llmapi.stepfun.FullScreenActivity;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import stepai.aios.accessibility.DefaultAccessibilityService;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f381a;
    public final /* synthetic */ int b;

    public /* synthetic */ d(int i, int i6) {
        this.f381a = i6;
        this.b = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f381a;
        int i6 = this.b;
        switch (i) {
            case 0:
                BlendParams apply = (BlendParams) obj;
                kotlin.jvm.internal.k.f(apply, "$this$apply");
                apply.setStages(H4.o.M(new Pair(1, Integer.valueOf(i6))));
                return r.f317a;
            case 1:
                ((Integer) obj).intValue();
                throw new IndexOutOfBoundsException(androidx.appfunctions.metadata.a.k("Collection doesn't contain element at index ", i6, '.'));
            case 2:
                return AbilityReportDao_Impl.getPendingTasksOrdered$lambda$0("SELECT * FROM t_ability_report_task WHERE status = 0 AND retryCount < ? ORDER BY id ASC", i6, (SQLiteConnection) obj);
            case 3:
                return AbilityReportDao_Impl.clearExpiredTasks$lambda$0("DELETE FROM t_ability_report_task WHERE status != 0 AND retryCount >= ?", i6, (SQLiteConnection) obj);
            case 4:
                return AtomicAbilityDao_Impl.getByAbilityId$lambda$0("SELECT * FROM t_atomic_ability WHERE abilityId = ? LIMIT 1", i6, (SQLiteConnection) obj);
            case 5:
                return SyncCacheMetaDao_Impl.getById$lambda$0("SELECT * FROM t_sync_cache_meta WHERE id = ? LIMIT 1", i6, (SQLiteConnection) obj);
            case 6:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaxSqlCacheSize$lambda$11(i6, (SupportSQLiteDatabase) obj);
            case 7:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_version_$lambda$1(i6, (SupportSQLiteDatabase) obj);
            case 8:
                return Boolean.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.needUpgrade$lambda$9(i6, (SupportSQLiteDatabase) obj));
            case 9:
                return AgentBusBindingBase.connectAndServe$lambda$1(i6, (AgentBusBindingBase.ConnectionStatus) obj);
            case 10:
                return FullScreenActivity.startLauncherWatcher$lambda$0$0(i6, (ForegroundAppFilter.Builder) obj);
            default:
                WeakReference weakReference = DefaultAccessibilityService.d;
                return Boolean.valueOf(((AccessibilityWindowInfo) obj).getDisplayId() == i6);
        }
    }
}

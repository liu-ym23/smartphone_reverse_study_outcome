package R3;

import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.mdisdk.Task;
import com.mdisdk.TaskManager;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.database.dao.AbilityDao_Impl;
import com.stepos.ability.database.dao.AtomicAbilityDao_Impl;
import com.stepos.ability.sdk.client.AgentServiceClient;
import com.stepos.deepbinder.core.cache.CallbackCache;
import com.stepos.taskrobot.llmapi.stepfun.DebugInfoDialogListener;
import com.stepos.taskrobot.llmapi.stepfun.SystemSdkBridge;
import com.stepos.taskrobot.taskmemory.dao.TaskDao_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import com.uxsense.rule.ApexTriggerRuleEditor;
import com.uxsense.ruleTrigger.TriggerRule;
import java.util.Map;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1144a;
    public final /* synthetic */ String b;

    public /* synthetic */ c(String str, int i) {
        this.f1144a = i;
        this.b = str;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1144a) {
            case 0:
                return AbilityDao_Impl.getAbilityByPackageName$lambda$0("SELECT * FROM t_ability WHERE packageName = ? LIMIT 1", this.b, (SQLiteConnection) obj);
            case 1:
                return AtomicAbilityDao_Impl.getByPackageName$lambda$0("SELECT * FROM t_atomic_ability WHERE packageName = ?", this.b, (SQLiteConnection) obj);
            case 2:
                return AtomicAbilityDao_Impl.getByToolName$lambda$0("SELECT * FROM t_atomic_ability WHERE toolName = ? LIMIT 1", this.b, (SQLiteConnection) obj);
            case 3:
                return AtomicAbilityDao_Impl.getByFunctionName$lambda$0("SELECT * FROM t_atomic_ability WHERE functionName = ? LIMIT 1", this.b, (SQLiteConnection) obj);
            case 4:
                return AtomicAbilityDao_Impl.deleteByToolName$lambda$0("DELETE FROM t_atomic_ability WHERE toolName = ?", this.b, (SQLiteConnection) obj);
            case 5:
                return AtomicAbilityDao_Impl.deleteByPackageName$lambda$0("DELETE FROM t_atomic_ability WHERE packageName = ?", this.b, (SQLiteConnection) obj);
            case 6:
                ActivityInfo activityInfo = ((ResolveInfo) obj).activityInfo;
                return Boolean.valueOf(kotlin.jvm.internal.k.b(activityInfo != null ? activityInfo.packageName : null, this.b));
            case 7:
                return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$7(this.b, (SupportSQLiteDatabase) obj);
            case 8:
                return AgentServiceClient.takeOverGui$lambda$0(this.b, (IAgentServiceManager) obj);
            case 9:
                return AgentServiceClient.unRegisterTaskListener$lambda$0(this.b, (IAgentServiceManager) obj);
            case 10:
                return AgentServiceClient.fullScreenGui$lambda$0(this.b, (IAgentServiceManager) obj);
            case 11:
                return AgentServiceClient.unTakeOverGui$lambda$0(this.b, (IAgentServiceManager) obj);
            case 12:
                return AgentServiceClient.cancelFullScreenGui$lambda$0(this.b, (IAgentServiceManager) obj);
            case 13:
                return AgentServiceClient.resumeFullScreenOverlay$lambda$0(this.b, (IAgentServiceManager) obj);
            case 14:
                return AgentServiceClient.cancelTask$lambda$0(this.b, (IAgentServiceManager) obj);
            case 15:
                return AgentServiceClient.dismissFullScreenOverlay$lambda$0(this.b, (IAgentServiceManager) obj);
            case 16:
                return AgentServiceClient.dismissVoiceInput$lambda$0(this.b, (IAgentServiceManager) obj);
            case 17:
                return DebugInfoDialogListener.onUserInputRequested$lambda$0$0(this.b, (String) obj);
            case 18:
                return Boolean.valueOf(SystemSdkBridge.onTaskCompleted$lambda$0(this.b, (Map.Entry) obj));
            case 19:
                return Boolean.valueOf(ApexTriggerRuleEditor.delete$lambda$2(this.b, (TriggerRule) obj));
            case 20:
                String it = (String) obj;
                kotlin.jvm.internal.k.f(it, "it");
                boolean zS0 = j9.m.s0(it);
                String str = this.b;
                return zS0 ? it.length() < str.length() ? str : it : androidx.appfunctions.metadata.a.l(str, it);
            case 21:
                return Boolean.valueOf(CallbackCache.notifyCallbackToRecycle$lambda$1(this.b, (Map.Entry) obj));
            case 22:
                return TaskManager.createForDisplay$lambda$6(this.b, (Task) obj);
            case 23:
                return TaskManager.create$lambda$2(this.b, (Task) obj);
            case 24:
                return TaskDao_Impl.getByTaskId$lambda$0("SELECT * FROM task WHERE taskId = ? LIMIT 1", this.b, (SQLiteConnection) obj);
            case 25:
                return TaskDao_Impl.getTaskByTaskId$lambda$0("SELECT * FROM task WHERE taskId = ? LIMIT 1", this.b, (SQLiteConnection) obj);
            case 26:
                return TaskDao_Impl.deleteByTaskId$lambda$0("DELETE FROM task WHERE taskId = ?", this.b, (SQLiteConnection) obj);
            case 27:
                return TaskStepDao_Impl.getSteps$lambda$0("SELECT * FROM task_step WHERE taskId = ? ORDER BY endTime ASC", this.b, (SQLiteConnection) obj);
            case 28:
                return TaskStepDao_Impl.getStepsByTaskId$lambda$0("SELECT * FROM task_step WHERE taskId = ? ORDER BY startTime ASC", this.b, (SQLiteConnection) obj);
            default:
                return TaskStepDao_Impl.getDurationDataByTaskId$lambda$0("SELECT durationData FROM task_step WHERE taskId = ?", this.b, (SQLiteConnection) obj);
        }
    }
}

package com.stepos.taskrobot.llmapi.stepfun;

import D7.v;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006JG\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u001fJ\r\u0010%\u001a\u00020\u0018¢\u0006\u0004\b%\u0010\u0003R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecordManager;", "", AppAgent.CONSTRUCT, "()V", "", "getCurrentTimeString", "()Ljava/lang/String;", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "appName", "", "taskType", "modelId", "modelCell", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "createRecord", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "getRecord", "(Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskRecord;", "", "getAllRecords", "()Ljava/util/List;", "Lstepai/aios/guiagent/model/SessionState;", "state", "LC7/r;", "updateState", "(Ljava/lang/String;Lstepai/aios/guiagent/model/SessionState;)V", "sjflTraceId", "updateSjflTraceId", "(Ljava/lang/String;Ljava/lang/String;)V", "finishRecord", "(Ljava/lang/String;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;", "actionRecord", "addActionRecord", "(Ljava/lang/String;Lcom/stepos/taskrobot/llmapi/stepfun/GuiActionRecord;)V", "removeRecord", "clearAllRecords", "TAG", "Ljava/lang/String;", "TIME_FORMAT", "Ljava/util/concurrent/ConcurrentHashMap;", "records", "Ljava/util/concurrent/ConcurrentHashMap;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiTaskRecordManager {
    private static final String TAG = "GuiTaskRecordManager";
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final GuiTaskRecordManager INSTANCE = new GuiTaskRecordManager();
    private static final ConcurrentHashMap<String, GuiTaskRecord> records = new ConcurrentHashMap<>();

    private GuiTaskRecordManager() {
    }

    public static /* synthetic */ GuiTaskRecord createRecord$default(GuiTaskRecordManager guiTaskRecordManager, String str, String str2, String str3, int i, String str4, String str5, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            str4 = null;
        }
        if ((i6 & 32) != 0) {
            str5 = null;
        }
        return guiTaskRecordManager.createRecord(str, str2, str3, i, str4, str5);
    }

    private final String getCurrentTimeString() {
        String str = new SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(new Date());
        kotlin.jvm.internal.k.e(str, "format(...)");
        return str;
    }

    public final synchronized void addActionRecord(String taskId, GuiActionRecord actionRecord) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(actionRecord, "actionRecord");
        GuiTaskRecord guiTaskRecord = records.get(taskId);
        if (guiTaskRecord != null) {
            guiTaskRecord.addAction(actionRecord);
        }
    }

    public final synchronized void clearAllRecords() {
        records.clear();
    }

    public final synchronized GuiTaskRecord createRecord(String taskName, String taskId, String appName, int taskType, String modelId, String modelCell) {
        GuiTaskRecord guiTaskRecord;
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        guiTaskRecord = new GuiTaskRecord(taskName, taskId, getCurrentTimeString(), null, appName, taskType, SessionState.f6031a, null, modelId, modelCell, null, null, 3208, null);
        records.put(taskId, guiTaskRecord);
        return guiTaskRecord;
    }

    public final synchronized void finishRecord(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        GuiTaskRecord guiTaskRecord = records.get(taskId);
        if (guiTaskRecord != null && guiTaskRecord.getEndTime() == null) {
            guiTaskRecord.setEndTime(INSTANCE.getCurrentTimeString());
        }
    }

    public final synchronized List<GuiTaskRecord> getAllRecords() {
        Collection<GuiTaskRecord> collectionValues;
        collectionValues = records.values();
        kotlin.jvm.internal.k.e(collectionValues, "<get-values>(...)");
        return v.f1(collectionValues);
    }

    public final synchronized GuiTaskRecord getRecord(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        return records.get(taskId);
    }

    public final synchronized void removeRecord(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        records.remove(taskId);
    }

    public final synchronized void updateSjflTraceId(String taskId, String sjflTraceId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        GuiTaskRecord guiTaskRecord = records.get(taskId);
        if (guiTaskRecord != null) {
            guiTaskRecord.setSjflTraceId(sjflTraceId);
        }
    }

    public final synchronized void updateState(String taskId, SessionState state) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(state, "state");
        GuiTaskRecord guiTaskRecord = records.get(taskId);
        if (guiTaskRecord != null) {
            guiTaskRecord.setTaskState(state);
        }
    }
}

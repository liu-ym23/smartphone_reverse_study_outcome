package com.obric.eventkit;

import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.obric.eventkit.eventstaskmanager.ConditionGroup;
import com.obric.eventkit.eventstaskmanager.ConditionTask;
import com.obric.eventkit.eventstaskmanager.ConditionTaskAction;
import com.obric.eventkit.eventstaskmanager.ConditionTaskRecord;
import com.obric.eventkit.eventstaskmanager.ConditionTaskResult;
import com.obric.eventkit.eventstaskmanager.EventTask;
import com.obric.eventkit.eventstaskmanager.EventTaskExecutionDetailRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskExecutionRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskRecord;
import com.obric.eventkit.eventstaskmanager.EventTaskResult;
import com.obric.eventkit.eventstaskmanager.EventTaskSpec;
import com.obric.eventkit.eventstaskmanager.IAssistantInteractionListener;
import com.obric.eventkit.eventstaskmanager.IAssistantSessionStateListener;
import com.obric.eventkit.eventstaskmanager.IAssistantTtsStateListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskChangeListener;
import com.obric.eventkit.eventstaskmanager.IEventTaskScheduleListener;
import com.obric.eventkit.eventstaskmanager.ITimerTaskChangeListener;
import com.obric.eventkit.eventstaskmanager.PeriodicPolicy;
import com.obric.eventkit.eventstaskmanager.ShortcutTask;
import com.obric.eventkit.eventstaskmanager.StateInfo;
import com.obric.eventkit.eventstaskmanager.TaskKnowledge;
import com.obric.eventkit.eventstaskmanager.TimerTask;
import com.obric.eventkit.eventstaskmanager.TimerTaskRecord;
import com.obric.eventkit.eventstaskmanager.TimerTaskResult;
import com.obric.eventkit.eventstaskmanager.TriggerControlPolicy;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class EmptyEventProxy implements IEventProxy {
    public static final EmptyEventProxy INSTANCE = null;
    private static final String TAG = "EmptyEventProxy";

    static {
        INSTANCE = new EmptyEventProxy();
    }

    private EmptyEventProxy() {
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map<String, String> r6) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "addConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult addEventTask(EventTaskSpec r1) {
        o.e(r1, "spec");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "addEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
        o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "records");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "addEventTaskExecutionDetailRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
        o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "records");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "addEventTaskExecutionRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult addTimerTask(TimerTask r1) {
        o.e(r1, "task");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "addTimerTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void closeAssistantInputPanel() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "closeAssistantInputPanel no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getAllConditionTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getAllEventTaskRecords(long r1, long r3, int r5) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getAllEventTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getAllEventTasks() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getAllEventTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getAllTimerTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTask> getAllTimerTasks() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getAllTimerTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantSessionState() {
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantTtsPlayingState() {
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTask getConditionTask(String r1) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getConditionTaskRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTask getEventTask(String r1) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTaskExecutionDetailRecordById no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTaskExecutionDetailRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsByTaskId(String r1, int r2, int r3) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTaskExecutionDetailRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTaskExecutionRecordById no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTaskExecutionRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTaskExecutionRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5) {
        o.e(r5, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTaskRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getEventTasksByType(int r1, int r2, int r3) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getEventTasksByType no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getKnowledgeSessionIdNotNullEventTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Long getNextScheduleTimeStamp(String r1) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getNextScheduleTimeStamp no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getShortInstructNotNullShortcutTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getTemplateIdNotNullEventTasks() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getTemplateIdNotNullEventTasks no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTask getTimerTaskByTaskId(String r1) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getTimerTaskByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, String r5) {
        o.e(r5, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "getTimerTaskRecordsByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void notifyAssistantState(boolean r1, StateInfo r2) {
        o.e(r2, "stateInfo");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "notifyAssistantState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void openAssistantInputPanel(StateInfo r1, boolean r2) {
        o.e(r1, "stateInfo");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "openAssistantInputPanel no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantSessionState(IAssistantSessionStateListener r2) {
        o.e((IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "registerAssistantSessionState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
        o.e((IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "registerAssistantTtsPlayingState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskChangeListener(IEventTaskChangeListener r2) {
        o.e((IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskChangeListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "registerEventTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskScheduleListener(IEventTaskScheduleListener r2) {
        o.e((IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "registerEventTaskScheduleListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerTimerTaskChangeListener(ITimerTaskChangeListener r2) {
        o.e((ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "registerTimerTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllConditionTaskRecords() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeAllConditionTaskRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllEventTaskRecords(int r1) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeAllEventTaskRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeAllTimeTaskRecords() {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeAllTimeTaskRecords no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult removeConditionTask(String[] r1) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeConditionTaskRecordsById(long[] r1) {
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeConditionTaskRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult removeEventTask(String[] r1) {
        o.e(r1, "taskIds");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsById(long[] r1) {
        o.e(r1, DbHelper.COL_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeEventTaskExecutionDetailRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsByTaskId(String r1) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeEventTaskExecutionDetailRecordsByTaskId no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsById(long[] r1) {
        o.e(r1, DbHelper.COL_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeEventTaskExecutionRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsByTaskId(String r1) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeEventTaskExecutionRecordsByTaskId no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskRecordsById(int r1, long[] r2) {
        o.e(r2, DbHelper.COL_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeEventTaskRecordsById no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTask(Map<String, ? extends Object> r2) {
        o.e((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"), "parameters");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeTimerTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeTimerTaskRecordsById(List<Integer> r2) {
        o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), DbHelper.COL_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeTimerTaskRecordsById no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTasksByTaskId(List<String> r2) {
        o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "removeTimerTasksByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void requestSendMessage(String r2, String r3, Map<String, String> r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "content");
        o.e(r3, DBHelper.BATTERY_COL_SCENE);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "requestSendMessage no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void scheduleShortcutTask(String r1, String r2) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "scheduleShortcutTask no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void setAssistantInteractionListener(IAssistantInteractionListener r2) {
        o.e((IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantInteractionListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "setAssistantInteractionListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void skipConditionTaskSchedule(String r1) {
        o.e(r1, DBDefinition.TASK_ID);
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "scheduleShortcutTask no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult skipTimerTasksByTaskId(String r2, List<Long> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r2, DBDefinition.TASK_ID);
        o.e(r1, "timeStamp");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "skipTimerTasksByTaskId no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryActiveAgent(AppEvent r1) {
        o.e(r1, "event");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryInterruptAssistant(AppEvent r1) {
        o.e(r1, "event");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryOpenMicToRecording(AppEvent r1) {
        o.e(r1, "event");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5) {
        o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "actions");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "tryScheduleConditionTask no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantSessionState(IAssistantSessionStateListener r2) {
        o.e((IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "unRegisterAssistantSessionState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
        o.e((IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "unRegisterAssistantTtsPlayingState no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskChangeListener(IEventTaskChangeListener r2) {
        o.e((IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskChangeListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "unregisterEventTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r2) {
        o.e((IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "unregisterEventTaskScheduleListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r2) {
        o.e((ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin"), "listener");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "unregisterTimerTaskChangeListener no impl");
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map<String, String> r8) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "updateConditionTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult updateEventTask(String r1, EventTaskSpec r2) {
        o.e(r1, DBDefinition.TASK_ID);
        o.e(r2, "spec");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "updateEventTask no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1) {
        o.e(r1, "record");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "updateEventTaskExecutionDetailRecord no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
        o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "records");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "updateEventTaskExecutionDetailRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1) {
        o.e(r1, "record");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "updateEventTaskExecutionRecord no impl");
        return null;
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
        o.e((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), "records");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "updateEventTaskExecutionRecords no impl");
        return 0;
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult updateTimerTask(TimerTask r1) {
        o.e(r1, "task");
        INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "updateTimerTask no impl");
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_eventkit_EmptyEventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }
}

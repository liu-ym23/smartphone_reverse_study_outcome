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
import com.obric.eventkit.eventstaskmanager.ITaskManager;
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
import d.a.p;
import d.h.b.o;
import d.n;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class EventProxy implements IEventProxy {
    public static final a Companion = null;
    private static final String TAG = "EventProxy";
    private final ITaskManager api;
    private final ITaskManager mApi;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public EventProxy(ITaskManager r7) {
        ITaskManager r8 = (ITaskManager) ZeusTransformUtils.wrapperContextForParams(r7, ITaskManager.class, "com.obric.aiagent.plugin");
        o.e(r8, "api");
        this.api = r8;
        BinderExceptionHandlerProxy.Companion r0 = BinderExceptionHandlerProxy.Companion;
        Object r2 = Proxy.newProxyInstance(ITaskManager.class.getClassLoader(), new Class[]{ITaskManager.class}, new BinderExceptionHandlerProxy(r8, TAG, ITaskManager.class));     // Catch: Throwable -> L8
        if (r2 == null) goto L7;
        r8 = (ITaskManager) ZeusTransformUtils.preCheckCast(r2, ITaskManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L12:
        this.mApi = (ITaskManager) ZeusTransformUtils.preCheckCast(r8, ITaskManager.class, "com.obric.aiagent.plugin");
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ITaskManager");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Throwable r3 = n.c(n.f(d.o.a(th)));
        if (r3 == null) goto L12;
        INVOKESTATIC_com_obric_eventkit_EventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "BinderExceptionHandlerProxy createProxyInstance for " + r8.getClass() + " fail", r3);
        goto L12
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r10, String r11, ConditionGroup r12, PeriodicPolicy r13, TriggerControlPolicy r14, Map<String, String> r15) {
        List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        return this.mApi.addConditionTask(r3, r11, r12, r13, r14, r8);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult addEventTask(EventTaskSpec r2) {
        o.e(r2, "spec");
        return this.mApi.addEventTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3) {
        List<EventTaskExecutionDetailRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "records");
        return this.mApi.addEventTaskExecutionDetailRecords(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3) {
        List<EventTaskExecutionRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "records");
        return this.mApi.addEventTaskExecutionRecords(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult addTimerTask(TimerTask r2) {
        o.e(r2, "task");
        return this.mApi.addTimerTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void closeAssistantInputPanel() {
        this.mApi.closeAssistantInputPanel();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3) {
        return this.mApi.getAllConditionTaskRecords(r1, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getAllEventTaskRecords(long r7, long r9, int r11) {
        return this.mApi.getAllEventTaskRecords(r7, r9, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getAllEventTasks() {
        return this.mApi.getAllEventTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3) {
        return this.mApi.getAllTimerTaskRecords(r1, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTask> getAllTimerTasks() {
        return this.mApi.getAllTimerTasks();
    }

    public final ITaskManager getApi() {
        return this.api;
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantSessionState() {
        return Integer.valueOf(this.mApi.getAssistantSessionState());
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer getAssistantTtsPlayingState() {
        return Integer.valueOf(this.mApi.getAssistantTtsPlayingState());
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTask getConditionTask(String r1) {
        return this.mApi.getConditionTask(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r7, long r9, String r11) {
        return this.mApi.getConditionTaskRecordsByTaskId(r7, r9, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTask getEventTask(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        return this.mApi.getEventTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1) {
        return this.mApi.getEventTaskExecutionDetailRecordById(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2) {
        return this.mApi.getEventTaskExecutionDetailRecords(r1, r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsByTaskId(String r2, int r3, int r4) {
        o.e(r2, DBDefinition.TASK_ID);
        return this.mApi.getEventTaskExecutionDetailRecordsBySessionId(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1) {
        return this.mApi.getEventTaskExecutionRecordById(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2) {
        return this.mApi.getEventTaskExecutionRecords(r1, r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r2, int r3, int r4) {
        o.e(r2, DBDefinition.TASK_ID);
        return this.mApi.getEventTaskExecutionRecordsByTaskId(r2, r3, r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r8, long r10, String r12) {
        o.e(r12, DBDefinition.TASK_ID);
        return this.mApi.getEventTaskRecordsByTaskId(r8, r10, r12);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getEventTasksByType(int r1, int r2, int r3) {
        return this.mApi.getEventTasksByType(r1, r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
        return this.mApi.getKnowledgeSessionIdNotNullEventTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public Long getNextScheduleTimeStamp(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        ITaskManager r1 = this.mApi;
        Integer r3 = d.o.o.d(r2);
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return Long.valueOf(r1.getNextScheduleTimeStamp(r4));
    L5:
        r4 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
        return this.mApi.getShortInstructNotNullShortcutTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<EventTask> getTemplateIdNotNullEventTasks() {
        return this.mApi.getTemplateIdNotNullEventTasks();
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTask getTimerTaskByTaskId(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        ITaskManager r1 = this.mApi;
        Integer r3 = d.o.o.d(r2);
        if (r3 == null) goto L5;
        int r4 = r3.intValue();
    L7:
        return r1.getTimerTaskByTaskId(r4);
    L5:
        r4 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r8, long r10, String r12) {
        o.e(r12, DBDefinition.TASK_ID);
        ITaskManager r1 = this.mApi;
        Integer r7 = d.o.o.d(r12);
        if (r7 == null) goto L5;
        int r9 = r7.intValue();
    L7:
        return r1.getTimerTaskRecordsByTaskId(r8, r10, r9);
    L5:
        r9 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public void notifyAssistantState(boolean r2, StateInfo r3) {
        o.e(r3, "stateInfo");
        this.mApi.notifyAssistantState(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void openAssistantInputPanel(StateInfo r2, boolean r3) {
        o.e(r2, "stateInfo");
        this.mApi.openAssistantInputPanel(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantSessionState(IAssistantSessionStateListener r3) {
        IAssistantSessionStateListener r4 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.registerAssistantSessionState(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerAssistantTtsPlayingState(IAssistantTtsStateListener r3) {
        IAssistantTtsStateListener r4 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.registerAssistantTtsPlayingState(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskChangeListener(IEventTaskChangeListener r3) {
        IEventTaskChangeListener r4 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.registerEventTaskChangeListener(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerEventTaskScheduleListener(IEventTaskScheduleListener r3) {
        IEventTaskScheduleListener r4 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.registerEventTaskScheduleListener(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void registerTimerTaskChangeListener(ITimerTaskChangeListener r3) {
        ITimerTaskChangeListener r4 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.registerTimerTaskChangeListener(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllConditionTaskRecords() {
        return this.mApi.removeAllTimeTaskRecords();
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeAllEventTaskRecords(int r1) {
        return this.mApi.removeAllEventTaskRecords(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeAllTimeTaskRecords() {
        return Integer.valueOf(this.mApi.removeAllTimeTaskRecords());
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult removeConditionTask(String[] r1) {
        return this.mApi.removeConditionTask(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeConditionTaskRecordsById(long[] r1) {
        return this.mApi.removeConditionTaskRecordsById(r1);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult removeEventTask(String[] r2) {
        o.e(r2, "taskIds");
        return this.mApi.removeEventTask(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsById(long[] r2) {
        o.e(r2, DbHelper.COL_ID);
        return this.mApi.removeEventTaskExecutionDetailRecordsById(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionDetailRecordsByTaskId(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        return this.mApi.removeEventTaskExecutionDetailRecordsBySessionId(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsById(long[] r2) {
        o.e(r2, DbHelper.COL_ID);
        return this.mApi.removeEventTaskExecutionRecordsById(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskExecutionRecordsByTaskId(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        return this.mApi.removeEventTaskExecutionRecordsByTaskId(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int removeEventTaskRecordsById(int r2, long[] r3) {
        o.e(r3, DbHelper.COL_ID);
        return this.mApi.removeEventTaskRecordsById(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTask(Map<String, ? extends Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "parameters");
        return this.mApi.removeTimerTask(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public Integer removeTimerTaskRecordsById(List<Integer> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, DbHelper.COL_ID);
        return Integer.valueOf(this.mApi.removeTimerTaskRecordsById(p.e(r4)));
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult removeTimerTasksByTaskId(List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r6, DBDefinition.TASK_ID);
        ITaskManager r4 = this.mApi;
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Integer r2 = d.o.o.d((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L9:
        return r4.removeTimerTasksByTaskId(p.e(r0));
    }

    @Override // com.obric.eventkit.IEventProxy
    public void requestSendMessage(String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "content");
        o.e(r4, DBHelper.BATTERY_COL_SCENE);
        this.mApi.requestSendMessage(r3, r4, r6);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void scheduleShortcutTask(String r2, String r3) {
        o.e(r2, DBDefinition.TASK_ID);
        this.mApi.scheduleShortcutTask(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void setAssistantInteractionListener(IAssistantInteractionListener r3) {
        IAssistantInteractionListener r4 = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.setAssistantInteractionListener(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void skipConditionTaskSchedule(String r2) {
        o.e(r2, DBDefinition.TASK_ID);
        this.mApi.skipConditionTaskSchedule(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult skipTimerTasksByTaskId(String r3, List<Long> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, DBDefinition.TASK_ID);
        o.e(r5, "timeStamp");
        ITaskManager r2 = this.mApi;
        Integer r6 = d.o.o.d(r3);
        if (r6 == null) goto L5;
        int r7 = r6.intValue();
    L7:
        return r2.skipTimerTasksByTaskId(r7, p.f(r5));
    L5:
        r7 = 0;
        goto L7
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryActiveAgent(AppEvent r2) {
        o.e(r2, "event");
        return Boolean.valueOf(this.mApi.tryActiveAgent(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryInterruptAssistant(AppEvent r2) {
        o.e(r2, "event");
        return Boolean.valueOf(this.mApi.tryInterruptAssistant(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public Boolean tryOpenMicToRecording(AppEvent r2) {
        o.e(r2, "event");
        return Boolean.valueOf(this.mApi.tryOpenMicToRecording(r2));
    }

    @Override // com.obric.eventkit.IEventProxy
    public void tryScheduleConditionTask(String r7, List<ConditionTaskAction> r8, TaskKnowledge r9, int r10, String r11) {
        List<ConditionTaskAction> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "actions");
        this.mApi.tryScheduleConditionTask(r7, r2, r9, r10, r11);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantSessionState(IAssistantSessionStateListener r3) {
        IAssistantSessionStateListener r4 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.unRegisterAssistantSessionState(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r3) {
        IAssistantTtsStateListener r4 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r3, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.unRegisterAssistantTtsPlayingState(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskChangeListener(IEventTaskChangeListener r3) {
        IEventTaskChangeListener r4 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.unregisterEventTaskChangeListener(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r3) {
        IEventTaskScheduleListener r4 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r3, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.unregisterEventTaskScheduleListener(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r3) {
        ITimerTaskChangeListener r4 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.mApi.unregisterTimerTaskChangeListener(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public ConditionTaskResult updateConditionTask(String r12, List<ConditionTaskAction> r13, String r14, ConditionGroup r15, PeriodicPolicy r16, TriggerControlPolicy r17, int r18, Map<String, String> r19) {
        List<ConditionTaskAction> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        return this.mApi.updateConditionTask(r12, r4, r14, r15, r16, r17, r18, r10);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskResult updateEventTask(String r2, EventTaskSpec r3) {
        o.e(r2, DBDefinition.TASK_ID);
        o.e(r3, "spec");
        return this.mApi.updateEventTask(r2, r3);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r2) {
        o.e(r2, "record");
        return this.mApi.updateEventTaskExecutionDetailRecord(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r3) {
        List<EventTaskExecutionDetailRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "records");
        return this.mApi.updateEventTaskExecutionDetailRecords(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r2) {
        o.e(r2, "record");
        return this.mApi.updateEventTaskExecutionRecord(r2);
    }

    @Override // com.obric.eventkit.IEventProxy
    public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r3) {
        List<EventTaskExecutionRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "records");
        return this.mApi.updateEventTaskExecutionRecords(r4);
    }

    @Override // com.obric.eventkit.IEventProxy
    public TimerTaskResult updateTimerTask(TimerTask r2) {
        o.e(r2, "task");
        return this.mApi.updateTimerTask(r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_eventkit_EventProxy_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}

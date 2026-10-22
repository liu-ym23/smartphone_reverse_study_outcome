package com.obric.eventkit;

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
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface IEventProxy {
    ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map<String, String> r6);

    EventTaskResult addEventTask(EventTaskSpec r1);

    List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1);

    List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1);

    TimerTaskResult addTimerTask(TimerTask r1);

    void closeAssistantInputPanel();

    List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3);

    List<EventTaskRecord> getAllEventTaskRecords(long r1, long r3, int r5);

    List<EventTask> getAllEventTasks();

    List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3);

    List<TimerTask> getAllTimerTasks();

    Integer getAssistantSessionState();

    Integer getAssistantTtsPlayingState();

    ConditionTask getConditionTask(String r1);

    List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5);

    EventTask getEventTask(String r1);

    EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsByTaskId(String r1, int r2, int r3);

    EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3);

    List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5);

    List<EventTask> getEventTasksByType(int r1, int r2, int r3);

    List<EventTask> getKnowledgeSessionIdNotNullEventTasks();

    Long getNextScheduleTimeStamp(String r1);

    List<ShortcutTask> getShortInstructNotNullShortcutTasks();

    List<EventTask> getTemplateIdNotNullEventTasks();

    TimerTask getTimerTaskByTaskId(String r1);

    List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, String r5);

    void notifyAssistantState(boolean r1, StateInfo r2);

    void openAssistantInputPanel(StateInfo r1, boolean r2);

    void registerAssistantSessionState(IAssistantSessionStateListener r1);

    void registerAssistantTtsPlayingState(IAssistantTtsStateListener r1);

    void registerEventTaskChangeListener(IEventTaskChangeListener r1);

    void registerEventTaskScheduleListener(IEventTaskScheduleListener r1);

    void registerTimerTaskChangeListener(ITimerTaskChangeListener r1);

    int removeAllConditionTaskRecords();

    int removeAllEventTaskRecords(int r1);

    Integer removeAllTimeTaskRecords();

    ConditionTaskResult removeConditionTask(String[] r1);

    int removeConditionTaskRecordsById(long[] r1);

    EventTaskResult removeEventTask(String[] r1);

    int removeEventTaskExecutionDetailRecordsById(long[] r1);

    int removeEventTaskExecutionDetailRecordsByTaskId(String r1);

    int removeEventTaskExecutionRecordsById(long[] r1);

    int removeEventTaskExecutionRecordsByTaskId(String r1);

    int removeEventTaskRecordsById(int r1, long[] r2);

    TimerTaskResult removeTimerTask(Map<String, ? extends Object> r1);

    Integer removeTimerTaskRecordsById(List<Integer> r1);

    TimerTaskResult removeTimerTasksByTaskId(List<String> r1);

    void requestSendMessage(String r1, String r2, Map<String, String> r3);

    void scheduleShortcutTask(String r1, String r2);

    void setAssistantInteractionListener(IAssistantInteractionListener r1);

    void skipConditionTaskSchedule(String r1);

    TimerTaskResult skipTimerTasksByTaskId(String r1, List<Long> r2);

    Boolean tryActiveAgent(AppEvent r1);

    Boolean tryInterruptAssistant(AppEvent r1);

    Boolean tryOpenMicToRecording(AppEvent r1);

    void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5);

    void unRegisterAssistantSessionState(IAssistantSessionStateListener r1);

    void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r1);

    void unregisterEventTaskChangeListener(IEventTaskChangeListener r1);

    void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r1);

    void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r1);

    ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map<String, String> r8);

    EventTaskResult updateEventTask(String r1, EventTaskSpec r2);

    EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1);

    int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1);

    EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1);

    int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1);

    TimerTaskResult updateTimerTask(TimerTask r1);
}

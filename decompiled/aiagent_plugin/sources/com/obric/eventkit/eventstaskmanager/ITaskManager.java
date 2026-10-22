package com.obric.eventkit.eventstaskmanager;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface ITaskManager extends IInterface {

    public static class Default implements ITaskManager {
        public Default() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map r6) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.aiagent.plugin");
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTaskResult addEventTask(EventTaskSpec r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public TimerTaskResult addTimerTask(TimerTask r1) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void closeAssistantInputPanel() {
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<ConditionTaskRecord> getAllConditionTaskRecords(long r1, long r3) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskRecord> getAllEventTaskRecords(long r1, long r3, int r5) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTask> getAllEventTasks() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<TimerTaskRecord> getAllTimerTaskRecords(long r1, long r3) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<TimerTask> getAllTimerTasks() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int getAssistantSessionState() {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int getAssistantTtsPlayingState() {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public ConditionTask getConditionTask(String r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTask getEventTask(String r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsBySessionId(String r1, int r2, int r3) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTask> getEventTasksByType(int r1, int r2, int r3) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public long getNextScheduleTimeStamp(int r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<EventTask> getTemplateIdNotNullEventTasks() {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<TimerTask> getTimerTask(Map r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public TimerTask getTimerTaskByTaskId(int r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, int r5) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void notifyAssistantState(boolean r1, StateInfo r2) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void openAssistantInputPanel(StateInfo r1, boolean r2) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void registerAssistantSessionState(IAssistantSessionStateListener r2) {
            IAssistantSessionStateListener r1 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void registerAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
            IAssistantTtsStateListener r1 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void registerEventTaskChangeListener(IEventTaskChangeListener r2) {
            IEventTaskChangeListener r1 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void registerEventTaskScheduleListener(IEventTaskScheduleListener r2) {
            IEventTaskScheduleListener r1 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void registerTimerTaskChangeListener(ITimerTaskChangeListener r2) {
            ITimerTaskChangeListener r1 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeAllConditionTaskRecords() {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeAllEventTaskRecords(int r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeAllTimeTaskRecords() {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public ConditionTaskResult removeConditionTask(String[] r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeConditionTaskRecordsById(long[] r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTaskResult removeEventTask(String[] r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeEventTaskExecutionDetailRecordsById(long[] r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeEventTaskExecutionDetailRecordsBySessionId(String r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeEventTaskExecutionRecordsById(long[] r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeEventTaskExecutionRecordsByTaskId(String r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeEventTaskRecordsById(int r1, long[] r2) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public TimerTaskResult removeTimerTask(Map r2) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int removeTimerTaskRecordsById(int[] r1) {
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public TimerTaskResult removeTimerTasksByTaskId(int[] r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void requestSendMessage(String r1, String r2, Map r3) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void scheduleShortcutTask(String r1, String r2) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void setAssistantInteractionListener(IAssistantInteractionListener r2) {
            IAssistantInteractionListener r1 = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void skipConditionTaskSchedule(String r1) {
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public TimerTaskResult skipTimerTasksByTaskId(int r1, long[] r2) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public boolean tryActiveAgent(AppEvent r1) {
            return false;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public boolean tryInterruptAssistant(AppEvent r1) {
            return false;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public boolean tryOpenMicToRecording(AppEvent r1) {
            return false;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void unRegisterAssistantSessionState(IAssistantSessionStateListener r2) {
            IAssistantSessionStateListener r1 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r2) {
            IAssistantTtsStateListener r1 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r2, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void unregisterEventTaskChangeListener(IEventTaskChangeListener r2) {
            IEventTaskChangeListener r1 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r2) {
            IEventTaskScheduleListener r1 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r2, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r2) {
            ITimerTaskChangeListener r1 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r2, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map r8) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTaskResult updateEventTask(String r1, EventTaskSpec r2) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1) {
            return null;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
            return 0;
        }

        @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
        public TimerTaskResult updateTimerTask(TimerTask r1) {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITaskManager {
        private static final String DESCRIPTOR = "com.obric.eventkit.eventstaskmanager.ITaskManager";
        public static final int TRANSACTION_addConditionTask = 29;
        public static final int TRANSACTION_addEventTask = 43;
        public static final int TRANSACTION_addEventTaskExecutionDetailRecords = 65;
        public static final int TRANSACTION_addEventTaskExecutionRecords = 57;
        public static final int TRANSACTION_addTimerTask = 1;
        public static final int TRANSACTION_closeAssistantInputPanel = 17;
        public static final int TRANSACTION_getAllConditionTaskRecords = 34;
        public static final int TRANSACTION_getAllEventTaskRecords = 54;
        public static final int TRANSACTION_getAllEventTasks = 37;
        public static final int TRANSACTION_getAllTimerTaskRecords = 11;
        public static final int TRANSACTION_getAllTimerTasks = 9;
        public static final int TRANSACTION_getAssistantSessionState = 21;
        public static final int TRANSACTION_getAssistantTtsPlayingState = 22;
        public static final int TRANSACTION_getConditionTask = 31;
        public static final int TRANSACTION_getConditionTaskRecordsByTaskId = 33;
        public static final int TRANSACTION_getEventTask = 38;
        public static final int TRANSACTION_getEventTaskExecutionDetailRecordById = 68;
        public static final int TRANSACTION_getEventTaskExecutionDetailRecords = 66;
        public static final int TRANSACTION_getEventTaskExecutionDetailRecordsBySessionId = 67;
        public static final int TRANSACTION_getEventTaskExecutionRecordById = 60;
        public static final int TRANSACTION_getEventTaskExecutionRecords = 58;
        public static final int TRANSACTION_getEventTaskExecutionRecordsByTaskId = 59;
        public static final int TRANSACTION_getEventTaskRecordsByTaskId = 53;
        public static final int TRANSACTION_getEventTasksByType = 48;
        public static final int TRANSACTION_getKnowledgeSessionIdNotNullEventTasks = 46;
        public static final int TRANSACTION_getNextScheduleTimeStamp = 7;
        public static final int TRANSACTION_getShortInstructNotNullShortcutTasks = 49;
        public static final int TRANSACTION_getTemplateIdNotNullEventTasks = 47;
        public static final int TRANSACTION_getTimerTask = 8;
        public static final int TRANSACTION_getTimerTaskByTaskId = 6;
        public static final int TRANSACTION_getTimerTaskRecordsByTaskId = 10;
        public static final int TRANSACTION_notifyAssistantState = 18;
        public static final int TRANSACTION_openAssistantInputPanel = 16;
        public static final int TRANSACTION_registerAssistantSessionState = 27;
        public static final int TRANSACTION_registerAssistantTtsPlayingState = 25;
        public static final int TRANSACTION_registerEventTaskChangeListener = 39;
        public static final int TRANSACTION_registerEventTaskScheduleListener = 41;
        public static final int TRANSACTION_registerTimerTaskChangeListener = 14;
        public static final int TRANSACTION_removeAllConditionTaskRecords = 36;
        public static final int TRANSACTION_removeAllEventTaskRecords = 56;
        public static final int TRANSACTION_removeAllTimeTaskRecords = 13;
        public static final int TRANSACTION_removeConditionTask = 30;
        public static final int TRANSACTION_removeConditionTaskRecordsById = 35;
        public static final int TRANSACTION_removeEventTask = 44;
        public static final int TRANSACTION_removeEventTaskExecutionDetailRecordsById = 71;
        public static final int TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId = 72;
        public static final int TRANSACTION_removeEventTaskExecutionRecordsById = 63;
        public static final int TRANSACTION_removeEventTaskExecutionRecordsByTaskId = 64;
        public static final int TRANSACTION_removeEventTaskRecordsById = 55;
        public static final int TRANSACTION_removeTimerTask = 3;
        public static final int TRANSACTION_removeTimerTaskRecordsById = 12;
        public static final int TRANSACTION_removeTimerTasksByTaskId = 2;
        public static final int TRANSACTION_requestSendMessage = 20;
        public static final int TRANSACTION_scheduleShortcutTask = 50;
        public static final int TRANSACTION_setAssistantInteractionListener = 19;
        public static final int TRANSACTION_skipConditionTaskSchedule = 51;
        public static final int TRANSACTION_skipTimerTasksByTaskId = 4;
        public static final int TRANSACTION_tryActiveAgent = 73;
        public static final int TRANSACTION_tryInterruptAssistant = 23;
        public static final int TRANSACTION_tryOpenMicToRecording = 24;
        public static final int TRANSACTION_tryScheduleConditionTask = 52;
        public static final int TRANSACTION_unRegisterAssistantSessionState = 28;
        public static final int TRANSACTION_unRegisterAssistantTtsPlayingState = 26;
        public static final int TRANSACTION_unregisterEventTaskChangeListener = 40;
        public static final int TRANSACTION_unregisterEventTaskScheduleListener = 42;
        public static final int TRANSACTION_unregisterTimerTaskChangeListener = 15;
        public static final int TRANSACTION_updateConditionTask = 32;
        public static final int TRANSACTION_updateEventTask = 45;
        public static final int TRANSACTION_updateEventTaskExecutionDetailRecord = 69;
        public static final int TRANSACTION_updateEventTaskExecutionDetailRecords = 70;
        public static final int TRANSACTION_updateEventTaskExecutionRecord = 61;
        public static final int TRANSACTION_updateEventTaskExecutionRecords = 62;
        public static final int TRANSACTION_updateTimerTask = 5;

        public static class Proxy implements ITaskManager {
            public static ITaskManager sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTaskResult addConditionTask(List<ConditionTaskAction> r10, String r11, ConditionGroup r12, PeriodicPolicy r13, TriggerControlPolicy r14, Map r15) {
                List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
                Parcel r16 = Parcel.obtain();
                Parcel r17 = Parcel.obtain();
                r16.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r16.writeTypedList(r3);     // Catch: Throwable -> L25
                r16.writeString(r11);     // Catch: Throwable -> L25
                if (r12 == null) goto L6;
                r16.writeInt(1);     // Catch: Throwable -> L25
                r12.writeToParcel(r16, 0);     // Catch: Throwable -> L25
            L7:
                if (r13 == null) goto L9;
                r16.writeInt(1);     // Catch: Throwable -> L25
                r13.writeToParcel(r16, 0);     // Catch: Throwable -> L25
            L10:
                if (r14 == null) goto L12;
                r16.writeInt(1);     // Catch: Throwable -> L25
                r14.writeToParcel(r16, 0);     // Catch: Throwable -> L25
            L13:
                r16.writeMap(r8);     // Catch: Throwable -> L25
                if (this.mRemote.transact(29, r16, r17, 0) == false) goto L16;
            L20:
                r17.readException();     // Catch: Throwable -> L25
                if (r17.readInt() == 0) goto L24;
                ConditionTaskResult r9 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(ConditionTaskResult.CREATOR.createFromParcel(r17), ConditionTaskResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            L18:
                r17.recycle();
                r16.recycle();
                return r9;
            L24:
                r9 = null;
                goto L18
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                r9 = Stub.getDefaultImpl().addConditionTask(r3, r11, r12, r13, r14, r8);     // Catch: Throwable -> L25
                goto L18
            L12:
                r16.writeInt(0);     // Catch: Throwable -> L25
                goto L13
            L9:
                r16.writeInt(0);     // Catch: Throwable -> L25
                goto L10
            L6:
                r16.writeInt(0);     // Catch: Throwable -> L25
            L25:
                th = move-exception;
                r17.recycle();
                r16.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskResult addEventTask(EventTaskSpec r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(43, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskResult r4 = (EventTaskResult) ZeusTransformUtils.preCheckCast(EventTaskResult.CREATOR.createFromParcel(r1), EventTaskResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r4 = Stub.getDefaultImpl().addEventTask(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionDetailRecord> addEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r5) {
                List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(65, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r4 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().addEventTaskExecutionDetailRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionRecord> addEventTaskExecutionRecords(List<EventTaskExecutionRecord> r5) {
                List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(57, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r4 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().addEventTaskExecutionRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult addTimerTask(TimerTask r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r4 = Stub.getDefaultImpl().addTimerTask(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void closeAssistantInputPanel() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(17, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().closeAssistantInputPanel();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<ConditionTaskRecord> getAllConditionTaskRecords(long r5, long r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeLong(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(34, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ConditionTaskRecord> r4 = r1.createTypedArrayList(ConditionTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getAllConditionTaskRecords(r5, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskRecord> getAllEventTaskRecords(long r9, long r11, int r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeInt(r13);     // Catch: Throwable -> L12
                if (this.mRemote.transact(54, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskRecord> r8 = r1.createTypedArrayList(EventTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().getAllEventTaskRecords(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getAllEventTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(37, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getAllEventTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTaskRecord> getAllTimerTaskRecords(long r5, long r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r5);     // Catch: Throwable -> L12
                r0.writeLong(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTaskRecord> r4 = r1.createTypedArrayList(TimerTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getAllTimerTaskRecords(r5, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTask> getAllTimerTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(9, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTask> r4 = r1.createTypedArrayList(TimerTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getAllTimerTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int getAssistantSessionState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(21, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getAssistantSessionState();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int getAssistantTtsPlayingState() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(22, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getAssistantTtsPlayingState();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTask getConditionTask(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(31, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                ConditionTask r4 = (ConditionTask) ZeusTransformUtils.preCheckCast(ConditionTask.CREATOR.createFromParcel(r1), ConditionTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getConditionTask(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r9, long r11, String r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeString(r13);     // Catch: Throwable -> L12
                if (this.mRemote.transact(33, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ConditionTaskRecord> r8 = r1.createTypedArrayList(ConditionTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().getConditionTaskRecordsByTaskId(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTask getEventTask(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeString(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(38, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTask r4 = (EventTask) ZeusTransformUtils.preCheckCast(EventTask.CREATOR.createFromParcel(r1), EventTask.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTask(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(68, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskExecutionDetailRecord r4 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r1), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTaskExecutionDetailRecordById(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(66, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r4 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTaskExecutionDetailRecords(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsBySessionId(String r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(67, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionDetailRecord> r4 = r1.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTaskExecutionDetailRecordsBySessionId(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionRecord getEventTaskExecutionRecordById(long r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeLong(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(60, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskExecutionRecord r4 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionRecord.CREATOR.createFromParcel(r1), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTaskExecutionRecordById(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(58, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r4 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTaskExecutionRecords(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(59, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskExecutionRecord> r4 = r1.createTypedArrayList(EventTaskExecutionRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTaskExecutionRecordsByTaskId(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTaskRecord> getEventTaskRecordsByTaskId(long r9, long r11, String r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeString(r13);     // Catch: Throwable -> L12
                if (this.mRemote.transact(53, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTaskRecord> r8 = r1.createTypedArrayList(EventTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().getEventTaskRecordsByTaskId(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getEventTasksByType(int r5, int r6, int r7) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeInt(r6);     // Catch: Throwable -> L12
                r0.writeInt(r7);     // Catch: Throwable -> L12
                if (this.mRemote.transact(48, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getEventTasksByType(r5, r6, r7);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getKnowledgeSessionIdNotNullEventTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(46, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getKnowledgeSessionIdNotNullEventTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public long getNextScheduleTimeStamp(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                long r4 = r1.readLong();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getNextScheduleTimeStamp(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<ShortcutTask> getShortInstructNotNullShortcutTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(49, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<ShortcutTask> r4 = r1.createTypedArrayList(ShortcutTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getShortInstructNotNullShortcutTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<EventTask> getTemplateIdNotNullEventTasks() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(47, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<EventTask> r4 = r1.createTypedArrayList(EventTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getTemplateIdNotNullEventTasks();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTask> getTimerTask(Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeMap(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(8, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTask> r4 = r1.createTypedArrayList(TimerTask.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getTimerTask(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTask getTimerTaskByTaskId(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTask r4 = TimerTask.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().getTimerTaskByTaskId(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r9, long r11, int r13) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLong(r9);     // Catch: Throwable -> L12
                r0.writeLong(r11);     // Catch: Throwable -> L12
                r0.writeInt(r13);     // Catch: Throwable -> L12
                if (this.mRemote.transact(10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                List<TimerTaskRecord> r8 = r1.createTypedArrayList(TimerTaskRecord.CREATOR);     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r8 = Stub.getDefaultImpl().getTimerTaskRecordsByTaskId(r9, r11, r13);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void notifyAssistantState(boolean r5, StateInfo r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r0.writeInt(r5 ? 1 : 0);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L8:
                if (this.mRemote.transact(18, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().notifyAssistantState(r5, r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void openAssistantInputPanel(StateInfo r5, boolean r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L16
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L16
            L7:
                r0.writeInt(r6 ? 1 : 0);     // Catch: Throwable -> L16
                if (this.mRemote.transact(16, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().openAssistantInputPanel(r5, r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerAssistantSessionState(IAssistantSessionStateListener r5) {
                IAssistantSessionStateListener r6 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r5, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(27, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerAssistantSessionState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerAssistantTtsPlayingState(IAssistantTtsStateListener r5) {
                IAssistantTtsStateListener r6 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r5, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(25, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerAssistantTtsPlayingState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerEventTaskChangeListener(IEventTaskChangeListener r5) {
                IEventTaskChangeListener r6 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r5, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(39, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerEventTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerEventTaskScheduleListener(IEventTaskScheduleListener r5) {
                IEventTaskScheduleListener r6 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r5, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(41, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerEventTaskScheduleListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void registerTimerTaskChangeListener(ITimerTaskChangeListener r5) {
                ITimerTaskChangeListener r6 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r5, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(14, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().registerTimerTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeAllConditionTaskRecords() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(36, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeAllConditionTaskRecords();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeAllEventTaskRecords(int r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(56, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeAllEventTaskRecords(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeAllTimeTaskRecords() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(13, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeAllTimeTaskRecords();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTaskResult removeConditionTask(String[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeStringArray(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(30, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                ConditionTaskResult r4 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(ConditionTaskResult.CREATOR.createFromParcel(r1), ConditionTaskResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeConditionTask(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeConditionTaskRecordsById(long[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLongArray(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(35, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeConditionTaskRecordsById(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskResult removeEventTask(String[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeStringArray(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(44, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                EventTaskResult r4 = (EventTaskResult) ZeusTransformUtils.preCheckCast(EventTaskResult.CREATOR.createFromParcel(r1), EventTaskResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeEventTask(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionDetailRecordsById(long[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLongArray(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(71, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeEventTaskExecutionDetailRecordsById(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionDetailRecordsBySessionId(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(72, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeEventTaskExecutionDetailRecordsBySessionId(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionRecordsById(long[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeLongArray(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(63, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeEventTaskExecutionRecordsById(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskExecutionRecordsByTaskId(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(64, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeEventTaskExecutionRecordsByTaskId(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeEventTaskRecordsById(int r5, long[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeInt(r5);     // Catch: Throwable -> L12
                r0.writeLongArray(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(55, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeEventTaskRecordsById(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult removeTimerTask(Map r5) {
                Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeMap(r6);     // Catch: Throwable -> L15
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeTimerTask(r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int removeTimerTaskRecordsById(int[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeIntArray(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(12, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeTimerTaskRecordsById(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult removeTimerTasksByTaskId(int[] r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeIntArray(r5);     // Catch: Throwable -> L15
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().removeTimerTasksByTaskId(r5);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void requestSendMessage(String r5, String r6, Map r7) {
                Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                r0.writeMap(r8);     // Catch: Throwable -> L12
                if (this.mRemote.transact(20, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().requestSendMessage(r5, r6, r8);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void scheduleShortcutTask(String r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                r0.writeString(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(50, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().scheduleShortcutTask(r5, r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void setAssistantInteractionListener(IAssistantInteractionListener r5) {
                IAssistantInteractionListener r6 = (IAssistantInteractionListener) ZeusTransformUtils.wrapperContextForParams(r5, IAssistantInteractionListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(19, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L16
            L12:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setAssistantInteractionListener(r6);     // Catch: Throwable -> L16
                goto L12
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void skipConditionTaskSchedule(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(51, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().skipConditionTaskSchedule(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult skipTimerTasksByTaskId(int r5, long[] r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L15
                r0.writeInt(r5);     // Catch: Throwable -> L15
                r0.writeLongArray(r6);     // Catch: Throwable -> L15
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L15
                if (r1.readInt() == 0) goto L14;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L15
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L14:
                r4 = null;
                goto L8
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().skipTimerTasksByTaskId(r5, r6);     // Catch: Throwable -> L15
            L15:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public boolean tryActiveAgent(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(73, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().tryActiveAgent(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public boolean tryInterruptAssistant(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(23, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().tryInterruptAssistant(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public boolean tryOpenMicToRecording(AppEvent r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                boolean r2 = true;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L8:
                if (this.mRemote.transact(24, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L20
                if (r1.readInt() != 0) goto L18;
                r2 = false;
            L18:
                r1.recycle();
                r0.recycle();
                return r2;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                boolean r5 = Stub.getDefaultImpl().tryOpenMicToRecording(r6);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return r5;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void tryScheduleConditionTask(String r8, List<ConditionTaskAction> r9, TaskKnowledge r10, int r11, String r12) {
                List<ConditionTaskAction> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
                Parcel r13 = Parcel.obtain();
                Parcel r6 = Parcel.obtain();
                r13.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                r13.writeString(r8);     // Catch: Throwable -> L16
                r13.writeTypedList(r2);     // Catch: Throwable -> L16
                if (r10 == null) goto L6;
                r13.writeInt(1);     // Catch: Throwable -> L16
                r10.writeToParcel(r13, 0);     // Catch: Throwable -> L16
            L7:
                r13.writeInt(r11);     // Catch: Throwable -> L16
                r13.writeString(r12);     // Catch: Throwable -> L16
                if (this.mRemote.transact(52, r13, r6, 0) == false) goto L10;
            L14:
                r6.readException();     // Catch: Throwable -> L16
            L12:
                r6.recycle();
                r13.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().tryScheduleConditionTask(r8, r2, r10, r11, r12);     // Catch: Throwable -> L16
                goto L12
            L6:
                r13.writeInt(0);     // Catch: Throwable -> L16
            L16:
                th = move-exception;
                r6.recycle();
                r13.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unRegisterAssistantSessionState(IAssistantSessionStateListener r5) {
                IAssistantSessionStateListener r6 = (IAssistantSessionStateListener) ZeusTransformUtils.wrapperContextForParams(r5, IAssistantSessionStateListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(28, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unRegisterAssistantSessionState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r5) {
                IAssistantTtsStateListener r6 = (IAssistantTtsStateListener) ZeusTransformUtils.wrapperContextForParams(r5, IAssistantTtsStateListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(26, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unRegisterAssistantTtsPlayingState(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unregisterEventTaskChangeListener(IEventTaskChangeListener r5) {
                IEventTaskChangeListener r6 = (IEventTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r5, IEventTaskChangeListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(40, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterEventTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r5) {
                IEventTaskScheduleListener r6 = (IEventTaskScheduleListener) ZeusTransformUtils.wrapperContextForParams(r5, IEventTaskScheduleListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(42, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterEventTaskScheduleListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r5) {
                ITimerTaskChangeListener r6 = (ITimerTaskChangeListener) ZeusTransformUtils.wrapperContextForParams(r5, ITimerTaskChangeListener.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L16
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L16
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L16
                if (this.mRemote.transact(15, r0, null, 1) == false) goto L10;
            L14:
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().unregisterTimerTaskChangeListener(r6);     // Catch: Throwable -> L16
                r0.recycle();
                return;
            L6:
                r2 = null;
            L16:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public ConditionTaskResult updateConditionTask(String r15, List<ConditionTaskAction> r16, String r17, ConditionGroup r18, PeriodicPolicy r19, TriggerControlPolicy r20, int r21, Map r22) {
                List<ConditionTaskAction> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
                Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L25
                r10.writeString(r15);     // Catch: Throwable -> L25
                r10.writeTypedList(r3);     // Catch: Throwable -> L25
                r10.writeString(r17);     // Catch: Throwable -> L25
                if (r18 == null) goto L6;
                r10.writeInt(1);     // Catch: Throwable -> L25
                r18.writeToParcel(r10, 0);     // Catch: Throwable -> L25
            L7:
                if (r19 == null) goto L9;
                r10.writeInt(1);     // Catch: Throwable -> L25
                r19.writeToParcel(r10, 0);     // Catch: Throwable -> L25
            L10:
                if (r20 == null) goto L12;
                r10.writeInt(1);     // Catch: Throwable -> L25
                r20.writeToParcel(r10, 0);     // Catch: Throwable -> L25
            L13:
                r10.writeInt(r21);     // Catch: Throwable -> L25
                r10.writeMap(r9);     // Catch: Throwable -> L25
                if (this.mRemote.transact(32, r10, r11, 0) == false) goto L16;
            L20:
                r11.readException();     // Catch: Throwable -> L25
                if (r11.readInt() == 0) goto L24;
                ConditionTaskResult r0 = (ConditionTaskResult) ZeusTransformUtils.preCheckCast(ConditionTaskResult.CREATOR.createFromParcel(r11), ConditionTaskResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            L18:
                r11.recycle();
                r10.recycle();
                return r0;
            L24:
                r0 = null;
                goto L18
            L16:
                if (Stub.getDefaultImpl() == null) goto L20;
                r0 = Stub.getDefaultImpl().updateConditionTask(r15, r3, r17, r18, r19, r20, r21, r9);     // Catch: Throwable -> L25
                goto L18
            L12:
                r10.writeInt(0);     // Catch: Throwable -> L25
                goto L13
            L9:
                r10.writeInt(0);     // Catch: Throwable -> L25
                goto L10
            L6:
                r10.writeInt(0);     // Catch: Throwable -> L25
            L25:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskResult updateEventTask(String r5, EventTaskSpec r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r5);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(45, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskResult r4 = (EventTaskResult) ZeusTransformUtils.preCheckCast(EventTaskResult.CREATOR.createFromParcel(r1), EventTaskResult.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r4 = Stub.getDefaultImpl().updateEventTask(r5, r6);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(69, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskExecutionDetailRecord r4 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r1), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r4 = Stub.getDefaultImpl().updateEventTaskExecutionDetailRecord(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r5) {
                List<EventTaskExecutionDetailRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(70, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().updateEventTaskExecutionDetailRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(61, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                EventTaskExecutionRecord r4 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionRecord.CREATOR.createFromParcel(r1), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r4 = Stub.getDefaultImpl().updateEventTaskExecutionRecord(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r5) {
                List<EventTaskExecutionRecord> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeTypedList(r6);     // Catch: Throwable -> L12
                if (this.mRemote.transact(62, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
                int r4 = r1.readInt();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                r4 = Stub.getDefaultImpl().updateEventTaskExecutionRecords(r6);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.eventkit.eventstaskmanager.ITaskManager
            public TimerTaskResult updateTimerTask(TimerTask r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L18;
                TimerTaskResult r4 = TimerTaskResult.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L19
            L12:
                r1.recycle();
                r0.recycle();
                return r4;
            L18:
                r4 = null;
                goto L12
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                r4 = Stub.getDefaultImpl().updateTimerTask(r5);     // Catch: Throwable -> L19
                goto L12
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITaskManager asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, ITaskManager.class) == false) goto L13;
            return (ITaskManager) ZeusTransformUtils.preCheckCast(r0, ITaskManager.class, "com.obric.aiagent.plugin");
        L13:
            return new Proxy(r4);
        }

        public static ITaskManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ITaskManager r2) {
            ITaskManager r3 = (ITaskManager) ZeusTransformUtils.wrapperContextForParams(r2, ITaskManager.class, "com.obric.aiagent.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r16, Parcel r17, Parcel r18, int r19) {
            if (r16 == 1598968902) goto L274;
            TimerTask r5 = null;
            AppEvent r6 = null;
            EventTaskExecutionDetailRecord r7 = null;
            EventTaskExecutionRecord r8 = null;
            EventTaskSpec r9 = null;
            EventTaskSpec r10 = null;
            TriggerControlPolicy r11 = null;
            AppEvent r12 = null;
            AppEvent r13 = null;
            StateInfo r14 = null;
            StateInfo r15 = null;
            TimerTask r20 = null;
            boolean r110 = false;
            switch(r16) {
                case 1: goto L266;
                case 2: goto L261;
                case 3: goto L256;
                case 4: goto L251;
                case 5: goto L243;
                case 6: goto L238;
                case 7: goto L236;
                case 8: goto L234;
                case 9: goto L232;
                case 10: goto L230;
                case 11: goto L228;
                case 12: goto L226;
                case 13: goto L224;
                case 14: goto L222;
                case 15: goto L220;
                case 16: goto L212;
                case 17: goto L210;
                case 18: goto L202;
                case 19: goto L200;
                case 20: goto L198;
                case 21: goto L196;
                case 22: goto L194;
                case 23: goto L189;
                case 24: goto L184;
                case 25: goto L182;
                case 26: goto L180;
                case 27: goto L178;
                case 28: goto L176;
                case 29: goto L160;
                case 30: goto L155;
                case 31: goto L150;
                case 32: goto L133;
                case 33: goto L131;
                case 34: goto L129;
                case 35: goto L127;
                case 36: goto L125;
                case 37: goto L123;
                case 38: goto L118;
                case 39: goto L116;
                case 40: goto L114;
                case 41: goto L112;
                case 42: goto L110;
                case 43: goto L102;
                case 44: goto L97;
                case 45: goto L89;
                case 46: goto L87;
                case 47: goto L85;
                case 48: goto L83;
                case 49: goto L81;
                case 50: goto L79;
                case 51: goto L77;
                case 52: goto L71;
                case 53: goto L69;
                case 54: goto L67;
                case 55: goto L65;
                case 56: goto L63;
                case 57: goto L61;
                case 58: goto L59;
                case 59: goto L57;
                case 60: goto L52;
                case 61: goto L44;
                case 62: goto L42;
                case 63: goto L40;
                case 64: goto L38;
                case 65: goto L36;
                case 66: goto L34;
                case 67: goto L32;
                case 68: goto L27;
                case 69: goto L19;
                case 70: goto L17;
                case 71: goto L15;
                case 72: goto L13;
                case 73: goto L8;
                default: goto L7;
            };
        L8:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L11;
            r6 = AppEvent.CREATOR.createFromParcel(r17);
        L11:
            boolean r0 = tryActiveAgent(r6);
            r18.writeNoException();
            r18.writeInt(r0 ? 1 : 0);
            return true;
        L13:
            r17.enforceInterface(DESCRIPTOR);
            int r1 = removeEventTaskExecutionDetailRecordsBySessionId(r17.readString());
            r18.writeNoException();
            r18.writeInt(r1);
            return true;
        L15:
            r17.enforceInterface(DESCRIPTOR);
            int r2 = removeEventTaskExecutionDetailRecordsById(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r2);
            return true;
        L17:
            r17.enforceInterface(DESCRIPTOR);
            int r3 = updateEventTaskExecutionDetailRecords(r17.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR));
            r18.writeNoException();
            r18.writeInt(r3);
            return true;
        L19:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L22;
            r7 = (EventTaskExecutionDetailRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionDetailRecord.CREATOR.createFromParcel(r17), EventTaskExecutionDetailRecord.class, "com.obric.aiagent.plugin");
        L22:
            EventTaskExecutionDetailRecord r4 = updateEventTaskExecutionDetailRecord(r7);
            r18.writeNoException();
            if (r4 == null) goto L25;
            r18.writeInt(1);
            r4.writeToParcel(r18, 1);
        L26:
            return true;
        L25:
            r18.writeInt(0);
            goto L26
        L27:
            r17.enforceInterface(DESCRIPTOR);
            EventTaskExecutionDetailRecord r21 = getEventTaskExecutionDetailRecordById(r17.readLong());
            r18.writeNoException();
            if (r21 == null) goto L30;
            r18.writeInt(1);
            r21.writeToParcel(r18, 1);
        L31:
            return true;
        L30:
            r18.writeInt(0);
            goto L31
        L32:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionDetailRecord> r22 = getEventTaskExecutionDetailRecordsBySessionId(r17.readString(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r22);
            return true;
        L34:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionDetailRecord> r23 = getEventTaskExecutionDetailRecords(r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r23);
            return true;
        L36:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionDetailRecord> r24 = addEventTaskExecutionDetailRecords(r17.createTypedArrayList(EventTaskExecutionDetailRecord.CREATOR));
            r18.writeNoException();
            r18.writeTypedList(r24);
            return true;
        L38:
            r17.enforceInterface(DESCRIPTOR);
            int r25 = removeEventTaskExecutionRecordsByTaskId(r17.readString());
            r18.writeNoException();
            r18.writeInt(r25);
            return true;
        L40:
            r17.enforceInterface(DESCRIPTOR);
            int r26 = removeEventTaskExecutionRecordsById(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r26);
            return true;
        L42:
            r17.enforceInterface(DESCRIPTOR);
            int r27 = updateEventTaskExecutionRecords(r17.createTypedArrayList(EventTaskExecutionRecord.CREATOR));
            r18.writeNoException();
            r18.writeInt(r27);
            return true;
        L44:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L47;
            r8 = (EventTaskExecutionRecord) ZeusTransformUtils.preCheckCast(EventTaskExecutionRecord.CREATOR.createFromParcel(r17), EventTaskExecutionRecord.class, "com.obric.aiagent.plugin");
        L47:
            EventTaskExecutionRecord r28 = updateEventTaskExecutionRecord(r8);
            r18.writeNoException();
            if (r28 == null) goto L50;
            r18.writeInt(1);
            r28.writeToParcel(r18, 1);
        L51:
            return true;
        L50:
            r18.writeInt(0);
            goto L51
        L52:
            r17.enforceInterface(DESCRIPTOR);
            EventTaskExecutionRecord r29 = getEventTaskExecutionRecordById(r17.readLong());
            r18.writeNoException();
            if (r29 == null) goto L55;
            r18.writeInt(1);
            r29.writeToParcel(r18, 1);
        L56:
            return true;
        L55:
            r18.writeInt(0);
            goto L56
        L57:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionRecord> r30 = getEventTaskExecutionRecordsByTaskId(r17.readString(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r30);
            return true;
        L59:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionRecord> r31 = getEventTaskExecutionRecords(r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r31);
            return true;
        L61:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskExecutionRecord> r32 = addEventTaskExecutionRecords(r17.createTypedArrayList(EventTaskExecutionRecord.CREATOR));
            r18.writeNoException();
            r18.writeTypedList(r32);
            return true;
        L63:
            r17.enforceInterface(DESCRIPTOR);
            int r33 = removeAllEventTaskRecords(r17.readInt());
            r18.writeNoException();
            r18.writeInt(r33);
            return true;
        L65:
            r17.enforceInterface(DESCRIPTOR);
            int r34 = removeEventTaskRecordsById(r17.readInt(), r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r34);
            return true;
        L67:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskRecord> r35 = getAllEventTaskRecords(r17.readLong(), r17.readLong(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r35);
            return true;
        L69:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTaskRecord> r36 = getEventTaskRecordsByTaskId(r17.readLong(), r17.readLong(), r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r36);
            return true;
        L71:
            r17.enforceInterface(DESCRIPTOR);
            String r37 = r17.readString();
            ArrayList r38 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            if (r17.readInt() == 0) goto L74;
            TaskKnowledge r39 = (TaskKnowledge) ZeusTransformUtils.preCheckCast(TaskKnowledge.CREATOR.createFromParcel(r17), TaskKnowledge.class, "com.obric.aiagent.plugin");
        L75:
            tryScheduleConditionTask(r37, r38, r39, r17.readInt(), r17.readString());
            r18.writeNoException();
            return true;
        L74:
            r39 = null;
            goto L75
        L77:
            r17.enforceInterface(DESCRIPTOR);
            skipConditionTaskSchedule(r17.readString());
            r18.writeNoException();
            return true;
        L79:
            r17.enforceInterface(DESCRIPTOR);
            scheduleShortcutTask(r17.readString(), r17.readString());
            r18.writeNoException();
            return true;
        L81:
            r17.enforceInterface(DESCRIPTOR);
            List<ShortcutTask> r40 = getShortInstructNotNullShortcutTasks();
            r18.writeNoException();
            r18.writeTypedList(r40);
            return true;
        L83:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r41 = getEventTasksByType(r17.readInt(), r17.readInt(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r41);
            return true;
        L85:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r42 = getTemplateIdNotNullEventTasks();
            r18.writeNoException();
            r18.writeTypedList(r42);
            return true;
        L87:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r43 = getKnowledgeSessionIdNotNullEventTasks();
            r18.writeNoException();
            r18.writeTypedList(r43);
            return true;
        L89:
            r17.enforceInterface(DESCRIPTOR);
            String r44 = r17.readString();
            if (r17.readInt() == 0) goto L92;
            r9 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(EventTaskSpec.CREATOR.createFromParcel(r17), EventTaskSpec.class, "com.obric.aiagent.plugin");
        L92:
            EventTaskResult r45 = updateEventTask(r44, r9);
            r18.writeNoException();
            if (r45 == null) goto L95;
            r18.writeInt(1);
            r45.writeToParcel(r18, 1);
        L96:
            return true;
        L95:
            r18.writeInt(0);
            goto L96
        L97:
            r17.enforceInterface(DESCRIPTOR);
            EventTaskResult r46 = removeEventTask(r17.createStringArray());
            r18.writeNoException();
            if (r46 == null) goto L100;
            r18.writeInt(1);
            r46.writeToParcel(r18, 1);
        L101:
            return true;
        L100:
            r18.writeInt(0);
            goto L101
        L102:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L105;
            r10 = (EventTaskSpec) ZeusTransformUtils.preCheckCast(EventTaskSpec.CREATOR.createFromParcel(r17), EventTaskSpec.class, "com.obric.aiagent.plugin");
        L105:
            EventTaskResult r47 = addEventTask(r10);
            r18.writeNoException();
            if (r47 == null) goto L108;
            r18.writeInt(1);
            r47.writeToParcel(r18, 1);
        L109:
            return true;
        L108:
            r18.writeInt(0);
            goto L109
        L110:
            r17.enforceInterface(DESCRIPTOR);
            unregisterEventTaskScheduleListener(IEventTaskScheduleListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L112:
            r17.enforceInterface(DESCRIPTOR);
            registerEventTaskScheduleListener(IEventTaskScheduleListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L114:
            r17.enforceInterface(DESCRIPTOR);
            unregisterEventTaskChangeListener(IEventTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L116:
            r17.enforceInterface(DESCRIPTOR);
            registerEventTaskChangeListener(IEventTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L118:
            r17.enforceInterface(DESCRIPTOR);
            EventTask r48 = getEventTask(r17.readString());
            r18.writeNoException();
            if (r48 == null) goto L121;
            r18.writeInt(1);
            r48.writeToParcel(r18, 1);
        L122:
            return true;
        L121:
            r18.writeInt(0);
            goto L122
        L123:
            r17.enforceInterface(DESCRIPTOR);
            List<EventTask> r49 = getAllEventTasks();
            r18.writeNoException();
            r18.writeTypedList(r49);
            return true;
        L125:
            r17.enforceInterface(DESCRIPTOR);
            int r50 = removeAllConditionTaskRecords();
            r18.writeNoException();
            r18.writeInt(r50);
            return true;
        L127:
            r17.enforceInterface(DESCRIPTOR);
            int r51 = removeConditionTaskRecordsById(r17.createLongArray());
            r18.writeNoException();
            r18.writeInt(r51);
            return true;
        L129:
            r17.enforceInterface(DESCRIPTOR);
            List<ConditionTaskRecord> r52 = getAllConditionTaskRecords(r17.readLong(), r17.readLong());
            r18.writeNoException();
            r18.writeTypedList(r52);
            return true;
        L131:
            r17.enforceInterface(DESCRIPTOR);
            List<ConditionTaskRecord> r53 = getConditionTaskRecordsByTaskId(r17.readLong(), r17.readLong(), r17.readString());
            r18.writeNoException();
            r18.writeTypedList(r53);
            return true;
        L133:
            r17.enforceInterface(DESCRIPTOR);
            String r54 = r17.readString();
            ArrayList r55 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            String r56 = r17.readString();
            if (r17.readInt() == 0) goto L136;
            ConditionGroup r57 = (ConditionGroup) ZeusTransformUtils.preCheckCast(ConditionGroup.CREATOR.createFromParcel(r17), ConditionGroup.class, "com.obric.aiagent.plugin");
        L138:
            if (r17.readInt() == 0) goto L140;
            PeriodicPolicy r58 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(PeriodicPolicy.CREATOR.createFromParcel(r17), PeriodicPolicy.class, "com.obric.aiagent.plugin");
        L142:
            if (r17.readInt() == 0) goto L144;
            TriggerControlPolicy r111 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(TriggerControlPolicy.CREATOR.createFromParcel(r17), TriggerControlPolicy.class, "com.obric.aiagent.plugin");
        L145:
            ConditionTaskResult r59 = updateConditionTask(r54, r55, r56, r57, r58, r111, r17.readInt(), r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r59 == null) goto L148;
            r18.writeInt(1);
            r59.writeToParcel(r18, 1);
        L149:
            return true;
        L148:
            r18.writeInt(0);
            goto L149
        L144:
            r111 = null;
            goto L145
        L140:
            r58 = null;
            goto L142
        L136:
            r57 = null;
            goto L138
        L150:
            r17.enforceInterface(DESCRIPTOR);
            ConditionTask r60 = getConditionTask(r17.readString());
            r18.writeNoException();
            if (r60 == null) goto L153;
            r18.writeInt(1);
            r60.writeToParcel(r18, 1);
        L154:
            return true;
        L153:
            r18.writeInt(0);
            goto L154
        L155:
            r17.enforceInterface(DESCRIPTOR);
            ConditionTaskResult r61 = removeConditionTask(r17.createStringArray());
            r18.writeNoException();
            if (r61 == null) goto L158;
            r18.writeInt(1);
            r61.writeToParcel(r18, 1);
        L159:
            return true;
        L158:
            r18.writeInt(0);
            goto L159
        L160:
            r17.enforceInterface(DESCRIPTOR);
            ArrayList r62 = r17.createTypedArrayList(ConditionTaskAction.CREATOR);
            String r63 = r17.readString();
            if (r17.readInt() == 0) goto L163;
            ConditionGroup r64 = (ConditionGroup) ZeusTransformUtils.preCheckCast(ConditionGroup.CREATOR.createFromParcel(r17), ConditionGroup.class, "com.obric.aiagent.plugin");
        L165:
            if (r17.readInt() == 0) goto L167;
            PeriodicPolicy r65 = (PeriodicPolicy) ZeusTransformUtils.preCheckCast(PeriodicPolicy.CREATOR.createFromParcel(r17), PeriodicPolicy.class, "com.obric.aiagent.plugin");
        L169:
            if (r17.readInt() == 0) goto L171;
            r11 = (TriggerControlPolicy) ZeusTransformUtils.preCheckCast(TriggerControlPolicy.CREATOR.createFromParcel(r17), TriggerControlPolicy.class, "com.obric.aiagent.plugin");
        L171:
            ConditionTaskResult r66 = addConditionTask(r62, r63, r64, r65, r11, r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r66 == null) goto L174;
            r18.writeInt(1);
            r66.writeToParcel(r18, 1);
        L175:
            return true;
        L174:
            r18.writeInt(0);
            goto L175
        L167:
            r65 = null;
            goto L169
        L163:
            r64 = null;
            goto L165
        L176:
            r17.enforceInterface(DESCRIPTOR);
            unRegisterAssistantSessionState(IAssistantSessionStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L178:
            r17.enforceInterface(DESCRIPTOR);
            registerAssistantSessionState(IAssistantSessionStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L180:
            r17.enforceInterface(DESCRIPTOR);
            unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L182:
            r17.enforceInterface(DESCRIPTOR);
            registerAssistantTtsPlayingState(IAssistantTtsStateListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L184:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L187;
            r12 = AppEvent.CREATOR.createFromParcel(r17);
        L187:
            boolean r67 = tryOpenMicToRecording(r12);
            r18.writeNoException();
            r18.writeInt(r67 ? 1 : 0);
            return true;
        L189:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L192;
            r13 = AppEvent.CREATOR.createFromParcel(r17);
        L192:
            boolean r68 = tryInterruptAssistant(r13);
            r18.writeNoException();
            r18.writeInt(r68 ? 1 : 0);
            return true;
        L194:
            r17.enforceInterface(DESCRIPTOR);
            int r69 = getAssistantTtsPlayingState();
            r18.writeNoException();
            r18.writeInt(r69);
            return true;
        L196:
            r17.enforceInterface(DESCRIPTOR);
            int r70 = getAssistantSessionState();
            r18.writeNoException();
            r18.writeInt(r70);
            return true;
        L198:
            r17.enforceInterface(DESCRIPTOR);
            requestSendMessage(r17.readString(), r17.readString(), r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            return true;
        L200:
            r17.enforceInterface(DESCRIPTOR);
            setAssistantInteractionListener(IAssistantInteractionListener.Stub.asInterface(r17.readStrongBinder()));
            r18.writeNoException();
            return true;
        L202:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L206;
            r110 = true;
        L206:
            if (r17.readInt() == 0) goto L208;
            r14 = StateInfo.CREATOR.createFromParcel(r17);
        L208:
            notifyAssistantState(r110, r14);
            r18.writeNoException();
            return true;
        L210:
            r17.enforceInterface(DESCRIPTOR);
            closeAssistantInputPanel();
            r18.writeNoException();
            return true;
        L212:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L216;
            r15 = StateInfo.CREATOR.createFromParcel(r17);
        L216:
            if (r17.readInt() == 0) goto L218;
            r110 = true;
        L218:
            openAssistantInputPanel(r15, r110);
            r18.writeNoException();
            return true;
        L220:
            r17.enforceInterface(DESCRIPTOR);
            unregisterTimerTaskChangeListener(ITimerTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L222:
            r17.enforceInterface(DESCRIPTOR);
            registerTimerTaskChangeListener(ITimerTaskChangeListener.Stub.asInterface(r17.readStrongBinder()));
            return true;
        L224:
            r17.enforceInterface(DESCRIPTOR);
            int r71 = removeAllTimeTaskRecords();
            r18.writeNoException();
            r18.writeInt(r71);
            return true;
        L226:
            r17.enforceInterface(DESCRIPTOR);
            int r72 = removeTimerTaskRecordsById(r17.createIntArray());
            r18.writeNoException();
            r18.writeInt(r72);
            return true;
        L228:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTaskRecord> r73 = getAllTimerTaskRecords(r17.readLong(), r17.readLong());
            r18.writeNoException();
            r18.writeTypedList(r73);
            return true;
        L230:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTaskRecord> r74 = getTimerTaskRecordsByTaskId(r17.readLong(), r17.readLong(), r17.readInt());
            r18.writeNoException();
            r18.writeTypedList(r74);
            return true;
        L232:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTask> r75 = getAllTimerTasks();
            r18.writeNoException();
            r18.writeTypedList(r75);
            return true;
        L234:
            r17.enforceInterface(DESCRIPTOR);
            List<TimerTask> r76 = getTimerTask(r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            r18.writeTypedList(r76);
            return true;
        L236:
            r17.enforceInterface(DESCRIPTOR);
            long r77 = getNextScheduleTimeStamp(r17.readInt());
            r18.writeNoException();
            r18.writeLong(r77);
            return true;
        L238:
            r17.enforceInterface(DESCRIPTOR);
            TimerTask r78 = getTimerTaskByTaskId(r17.readInt());
            r18.writeNoException();
            if (r78 == null) goto L241;
            r18.writeInt(1);
            r78.writeToParcel(r18, 1);
        L242:
            return true;
        L241:
            r18.writeInt(0);
            goto L242
        L243:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L246;
            r20 = TimerTask.CREATOR.createFromParcel(r17);
        L246:
            TimerTaskResult r79 = updateTimerTask(r20);
            r18.writeNoException();
            if (r79 == null) goto L249;
            r18.writeInt(1);
            r79.writeToParcel(r18, 1);
        L250:
            return true;
        L249:
            r18.writeInt(0);
            goto L250
        L251:
            r17.enforceInterface(DESCRIPTOR);
            TimerTaskResult r80 = skipTimerTasksByTaskId(r17.readInt(), r17.createLongArray());
            r18.writeNoException();
            if (r80 == null) goto L254;
            r18.writeInt(1);
            r80.writeToParcel(r18, 1);
        L255:
            return true;
        L254:
            r18.writeInt(0);
            goto L255
        L256:
            r17.enforceInterface(DESCRIPTOR);
            TimerTaskResult r81 = removeTimerTask(r17.readHashMap(getClass().getClassLoader()));
            r18.writeNoException();
            if (r81 == null) goto L259;
            r18.writeInt(1);
            r81.writeToParcel(r18, 1);
        L260:
            return true;
        L259:
            r18.writeInt(0);
            goto L260
        L261:
            r17.enforceInterface(DESCRIPTOR);
            TimerTaskResult r82 = removeTimerTasksByTaskId(r17.createIntArray());
            r18.writeNoException();
            if (r82 == null) goto L264;
            r18.writeInt(1);
            r82.writeToParcel(r18, 1);
        L265:
            return true;
        L264:
            r18.writeInt(0);
            goto L265
        L266:
            r17.enforceInterface(DESCRIPTOR);
            if (r17.readInt() == 0) goto L269;
            r5 = TimerTask.CREATOR.createFromParcel(r17);
        L269:
            TimerTaskResult r83 = addTimerTask(r5);
            r18.writeNoException();
            if (r83 == null) goto L272;
            r18.writeInt(1);
            r83.writeToParcel(r18, 1);
        L273:
            return true;
        L272:
            r18.writeInt(0);
            goto L273
        L7:
            return super.onTransact(r16, r17, r18, r19);
        L274:
            r18.writeString(DESCRIPTOR);
            return true;
        }
    }

    ConditionTaskResult addConditionTask(List<ConditionTaskAction> r1, String r2, ConditionGroup r3, PeriodicPolicy r4, TriggerControlPolicy r5, Map r6);

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

    int getAssistantSessionState();

    int getAssistantTtsPlayingState();

    ConditionTask getConditionTask(String r1);

    List<ConditionTaskRecord> getConditionTaskRecordsByTaskId(long r1, long r3, String r5);

    EventTask getEventTask(String r1);

    EventTaskExecutionDetailRecord getEventTaskExecutionDetailRecordById(long r1);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecords(int r1, int r2);

    List<EventTaskExecutionDetailRecord> getEventTaskExecutionDetailRecordsBySessionId(String r1, int r2, int r3);

    EventTaskExecutionRecord getEventTaskExecutionRecordById(long r1);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecords(int r1, int r2);

    List<EventTaskExecutionRecord> getEventTaskExecutionRecordsByTaskId(String r1, int r2, int r3);

    List<EventTaskRecord> getEventTaskRecordsByTaskId(long r1, long r3, String r5);

    List<EventTask> getEventTasksByType(int r1, int r2, int r3);

    List<EventTask> getKnowledgeSessionIdNotNullEventTasks();

    long getNextScheduleTimeStamp(int r1);

    List<ShortcutTask> getShortInstructNotNullShortcutTasks();

    List<EventTask> getTemplateIdNotNullEventTasks();

    List<TimerTask> getTimerTask(Map r1);

    TimerTask getTimerTaskByTaskId(int r1);

    List<TimerTaskRecord> getTimerTaskRecordsByTaskId(long r1, long r3, int r5);

    void notifyAssistantState(boolean r1, StateInfo r2);

    void openAssistantInputPanel(StateInfo r1, boolean r2);

    void registerAssistantSessionState(IAssistantSessionStateListener r1);

    void registerAssistantTtsPlayingState(IAssistantTtsStateListener r1);

    void registerEventTaskChangeListener(IEventTaskChangeListener r1);

    void registerEventTaskScheduleListener(IEventTaskScheduleListener r1);

    void registerTimerTaskChangeListener(ITimerTaskChangeListener r1);

    int removeAllConditionTaskRecords();

    int removeAllEventTaskRecords(int r1);

    int removeAllTimeTaskRecords();

    ConditionTaskResult removeConditionTask(String[] r1);

    int removeConditionTaskRecordsById(long[] r1);

    EventTaskResult removeEventTask(String[] r1);

    int removeEventTaskExecutionDetailRecordsById(long[] r1);

    int removeEventTaskExecutionDetailRecordsBySessionId(String r1);

    int removeEventTaskExecutionRecordsById(long[] r1);

    int removeEventTaskExecutionRecordsByTaskId(String r1);

    int removeEventTaskRecordsById(int r1, long[] r2);

    TimerTaskResult removeTimerTask(Map r1);

    int removeTimerTaskRecordsById(int[] r1);

    TimerTaskResult removeTimerTasksByTaskId(int[] r1);

    void requestSendMessage(String r1, String r2, Map r3);

    void scheduleShortcutTask(String r1, String r2);

    void setAssistantInteractionListener(IAssistantInteractionListener r1);

    void skipConditionTaskSchedule(String r1);

    TimerTaskResult skipTimerTasksByTaskId(int r1, long[] r2);

    boolean tryActiveAgent(AppEvent r1);

    boolean tryInterruptAssistant(AppEvent r1);

    boolean tryOpenMicToRecording(AppEvent r1);

    void tryScheduleConditionTask(String r1, List<ConditionTaskAction> r2, TaskKnowledge r3, int r4, String r5);

    void unRegisterAssistantSessionState(IAssistantSessionStateListener r1);

    void unRegisterAssistantTtsPlayingState(IAssistantTtsStateListener r1);

    void unregisterEventTaskChangeListener(IEventTaskChangeListener r1);

    void unregisterEventTaskScheduleListener(IEventTaskScheduleListener r1);

    void unregisterTimerTaskChangeListener(ITimerTaskChangeListener r1);

    ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, int r7, Map r8);

    EventTaskResult updateEventTask(String r1, EventTaskSpec r2);

    EventTaskExecutionDetailRecord updateEventTaskExecutionDetailRecord(EventTaskExecutionDetailRecord r1);

    int updateEventTaskExecutionDetailRecords(List<EventTaskExecutionDetailRecord> r1);

    EventTaskExecutionRecord updateEventTaskExecutionRecord(EventTaskExecutionRecord r1);

    int updateEventTaskExecutionRecords(List<EventTaskExecutionRecord> r1);

    TimerTaskResult updateTimerTask(TimerTask r1);
}

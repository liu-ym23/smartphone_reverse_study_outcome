package com.obric.eventkit;

import android.app.Application;
import com.obric.eventkit.task.model.ConditionGroup;
import com.obric.eventkit.task.model.ConditionTaskAction;
import com.obric.eventkit.task.model.ConditionTaskResult;
import com.obric.eventkit.task.model.EventTaskExecutionRecord;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.obric.eventkit.task.model.TriggerControlPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ITaskManagerApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ITaskManagerApi {
    public static final a Companion = null;
    public static final int RESULT_MESSAGE_SEND_FAILED = -4;
    public static final int RESULT_MESSAGE_SEND_INTERRUPT = -5;

    /* JADX INFO: compiled from: ITaskManagerApi.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f33202a = null;

        static {
            f33202a = new a();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ITaskManagerApi.kt */
    public static final class b {
        public static /* synthetic */ Object a(ITaskManagerApi r14, String r15, int r16, String r17, String r18, Integer r19, boolean r20, e r21, String r22, boolean r23, d.c.d r24, int r25, Object r26) {
            ITaskManagerApi r3 = (ITaskManagerApi) ZeusTransformUtils.wrapperContextForParams(r14, ITaskManagerApi.class, "com.obric.aiagent.plugin");
            e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r21, e.class, "com.obric.aiagent.plugin");
            d.c.d<? super g> r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
            if (r26 != null) goto L27;
            if ((r25 & 16) == 0) goto L7;
            Integer r8 = null;
        L9:
            if ((r25 & 32) == 0) goto L11;
            boolean r9 = false;
        L13:
            if ((r25 & 64) == 0) goto L15;
            e r10 = null;
        L17:
            if ((r25 & 128) == 0) goto L19;
            String r11 = null;
        L21:
            if ((r25 & 256) == 0) goto L23;
            boolean r12 = false;
        L25:
            return r3.setKnowledge(r15, r16, r17, r18, r8, r9, r10, r11, r12, r13);
        L23:
            r12 = r23;
            goto L25
        L19:
            r11 = r22;
            goto L21
        L15:
            r10 = r1;
            goto L17
        L11:
            r9 = r20;
            goto L13
        L7:
            r8 = r19;
            goto L9
        L27:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setKnowledge");
        }
    }

    static {
        Companion = a.f33202a;
    }

    String getConditionTaskV2();

    Object getEnableShortInstructShortcutTasks(d.c.d<? super List<ShortcutTask>> r1);

    Object getKnowledge(String r1, d.c.d<? super String> r2);

    Object getKnowledgeForNet(List<String> r1, com.obric.eventkit.b r2, d.c.d<? super f<d>> r3);

    List<String> getSmsConditionTypeList();

    void init(Application r1);

    Object isKnowledgeLearningSwitchOn(String r1, d.c.d<? super Boolean> r2);

    void onLoginStateChange(boolean r1);

    void onOmniTaskEnd(EventTaskExecutionRecord r1, String r2, int r3, String r4);

    void onTaskScheduleFailed(String r1, int r2, String r3);

    void onTaskScheduleMessageSent(String r1);

    void onTaskScheduleStart(String r1, int r2, String r3);

    Object setKnowledge(String r1, int r2, String r3, String r4, Integer r5, boolean r6, e r7, String r8, boolean r9, d.c.d<? super g> r10);

    Object setKnowledgeLearningSwitch(String r1, int r2, boolean r3, d.c.d<? super g> r4);

    Object setLocation(String r1, double r2, double r4, String r6, String r7, d.c.d<? super Boolean> r8);

    void setShortcutsActivityPkgName(String r1);

    Object tryRecoverFromSleepMode(String r1, int r2, d.c.d<? super x> r3);

    ConditionTaskResult updateConditionTask(String r1, List<ConditionTaskAction> r2, String r3, ConditionGroup r4, PeriodicPolicy r5, TriggerControlPolicy r6, Integer r7, Map<String, String> r8, int r9, TaskKnowledge r10, String r11);

    boolean updateEventTaskDisplayOrder(int r1, List<String> r2);
}

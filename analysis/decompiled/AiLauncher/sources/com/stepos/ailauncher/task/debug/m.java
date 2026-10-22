package com.stepos.ailauncher.task.debug;

import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.asr.AsrSseStreamParamKeys;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoOption;
import com.stepos.ailauncher.taskstore.entity.TaskInfoProgress;
import com.stepos.ailauncher.taskstore.entity.TaskInfoQuestion;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.datacenter.vector.EmbedProvider;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0093\u0001\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\r2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0 \"\u00020\rH\u0002¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010(\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010%R\u0014\u0010*\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010%R\u0014\u0010+\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010%R\u0014\u0010,\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010%R\u0014\u0010-\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010%R\u0014\u0010.\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010%¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/task/debug/m;", "", "<init>", "()V", "", "f", "(Le9/c;)Ljava/lang/Object;", "", "now", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", Const.INTENT_KEY_APIKEY, "(J)Ljava/util/List;", "", "taskId", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", "title", c.a.COL_SUMMARY, "createdAt", "updatedAt", "parentTaskId", "subTitle", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "progress", "subTasks", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "pendingQuestions", "endedAt", "c", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "question", "", "labels", "e", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "HOME_TASK_ID", "Ljava/lang/String;", "TASK_CENTER_TASK_ID", "MEDIUM_TASK_ID", "MEDIUM_COMPLETED_TASK_ID", "MEDIUM_FAILED_TASK_ID", "MEDIUM_SINGLE_ACTION_TASK_ID", "MEDIUM_DOUBLE_ACTION_TASK_ID", "MEDIUM_PENDING_QUESTION_TASK_ID", "MEDIUM_OVERFLOW_ACTION_TASK_ID", "TASK_TYPE", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class m {
    public static final String HOME_TASK_ID = "sweep-debug-home-running";
    public static final m INSTANCE = new m();
    public static final String MEDIUM_COMPLETED_TASK_ID = "sweep-debug-medium-completed";
    public static final String MEDIUM_DOUBLE_ACTION_TASK_ID = "sweep-debug-medium-double-action";
    public static final String MEDIUM_FAILED_TASK_ID = "sweep-debug-medium-failed";
    public static final String MEDIUM_OVERFLOW_ACTION_TASK_ID = "sweep-debug-medium-overflow-action";
    public static final String MEDIUM_PENDING_QUESTION_TASK_ID = "sweep-debug-medium-pending-question";
    public static final String MEDIUM_SINGLE_ACTION_TASK_ID = "sweep-debug-medium-single-action";
    public static final String MEDIUM_TASK_ID = "sweep-debug-medium-running";
    public static final String TASK_CENTER_TASK_ID = "sweep-debug-task-center-running";
    private static final String TASK_TYPE = "sweep_text_debug";

    public static /* synthetic */ List b(m mVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = System.currentTimeMillis();
        }
        return mVar.a(j10);
    }

    public static /* synthetic */ TaskInfoCard d(m mVar, String str, TaskInfoStatus taskInfoStatus, String str2, String str3, long j10, long j11, String str4, String str5, TaskInfoProgress taskInfoProgress, List list, List list2, Long l10, int i10, Object obj) {
        return mVar.c(str, taskInfoStatus, str2, str3, j10, j11, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? null : str5, (i10 & 256) != 0 ? null : taskInfoProgress, (i10 & 512) != 0 ? null : list, (i10 & 1024) != 0 ? null : list2, (i10 & 2048) != 0 ? null : l10);
    }

    public final List<TaskInfoCard> a(long now) {
        TaskInfoStatus taskInfoStatus = TaskInfoStatus.RUNNING;
        TaskInfoCard taskInfoCardD = d(this, HOME_TASK_ID, TaskInfoStatus.IN_PROGRESS, "整理一下关于金融领域最近的新新闻", "文本读取", now - 45000, now + 3, null, "整理金融新闻", null, C1173v.p(d(this, "sweep-debug-home-running-step-read", taskInfoStatus, "检索国际权威新闻", "文本读取", now - 42000, now + 1, HOME_TASK_ID, null, null, null, null, null, 3968, null), d(this, "sweep-debug-home-running-step-outline", TaskInfoStatus.PENDING, "整理关键事实与来源", "等待读取完成", now - 40000, now + 2, HOME_TASK_ID, null, null, null, null, null, 3968, null)), null, null, 3392, null);
        TaskInfoCard taskInfoCardD2 = d(this, TASK_CENTER_TASK_ID, taskInfoStatus, "扫光测试-任务中心Item", "正在核查异常数据", now - 35000, now + 4, null, "合同签署确认", new TaskInfoProgress(1, 4, 0, 1, 2, 4, null), null, null, null, 3648, null);
        TaskInfoCard taskInfoCardD3 = d(this, MEDIUM_TASK_ID, taskInfoStatus, "川藏路上", "确定剪辑方向中...", now - 25000, now + 5, null, "做个川藏路上的剪辑", new TaskInfoProgress(1, 4, 0, 1, 2, 4, null), null, null, null, 3648, null);
        TaskInfoCard taskInfoCardD4 = d(this, MEDIUM_COMPLETED_TASK_ID, TaskInfoStatus.COMPLETED, "川藏路上", "报告已生成", now - 1080000, now + 6, null, "做个川藏路上的剪辑", new TaskInfoProgress(4, 4, 0, 0, 0, 28, null), null, null, Long.valueOf(now - 120000), EmbedProvider.DEFAULT_MAX_INPUT_CHARS, null);
        TaskInfoCard taskInfoCardD5 = d(this, MEDIUM_FAILED_TASK_ID, TaskInfoStatus.FAILED, "川藏路上", "原因说明", now - 900000, now + 7, null, "做个川藏路上的剪辑", new TaskInfoProgress(1, 4, 1, 0, 0, 24, null), null, null, Long.valueOf(now - 90000), EmbedProvider.DEFAULT_MAX_INPUT_CHARS, null);
        TaskInfoStatus taskInfoStatus2 = TaskInfoStatus.WAITING;
        return C1173v.p(taskInfoCardD, taskInfoCardD2, taskInfoCardD3, taskInfoCardD4, taskInfoCardD5, d(this, MEDIUM_SINGLE_ACTION_TASK_ID, taskInfoStatus2, "川藏路上", "原因说明", now - 720000, now + 8, null, "做个川藏路上的剪辑", new TaskInfoProgress(2, 4, 0, 0, 2, 12, null), null, C1172u.e(e("请接管后继续处理", "去接管")), null, 2624, null), d(this, MEDIUM_DOUBLE_ACTION_TASK_ID, taskInfoStatus2, "川藏路上", "原因说明", now - 660000, now + 9, null, "做个川藏路上的剪辑", new TaskInfoProgress(2, 4, 0, 0, 2, 12, null), null, C1172u.e(e("请选择下一步操作", "暂停", "继续")), null, 2624, null), d(this, MEDIUM_PENDING_QUESTION_TASK_ID, taskInfoStatus2, "川藏路上", "原因说明", now - 20000, now + 10, null, "做个川藏路上的剪辑", new TaskInfoProgress(0, 3, 0, 0, 3, 12, null), null, C1172u.e(new TaskInfoQuestion("请选择一个选项", "中卡调试", C1173v.p(new TaskInfoOption("选项 A", "选项 A"), new TaskInfoOption("选项 B", "选项 B"), new TaskInfoOption("选项 C", "选项 C")), Boolean.FALSE)), null, 2624, null), d(this, MEDIUM_OVERFLOW_ACTION_TASK_ID, taskInfoStatus2, "川藏路上", "原因说明", now - AsrSseStreamParamKeys.MAX_STREAM_MAX_DURATION_MS, now + 11, null, "做个川藏路上的剪辑", new TaskInfoProgress(2, 4, 0, 0, 2, 12, null), null, C1172u.e(e("选项过多时收敛到详情页", "选项 A", "选项 B", "选项 C", "选项 D")), null, 2624, null));
    }

    public final TaskInfoCard c(String taskId, TaskInfoStatus status, String title, String summary, long createdAt, long updatedAt, String parentTaskId, String subTitle, TaskInfoProgress progress, List<TaskInfoCard> subTasks, List<TaskInfoQuestion> pendingQuestions, Long endedAt) {
        List listM;
        TaskInfoEventType taskInfoEventType = TaskInfoEventType.UPDATED;
        Long lValueOf = Long.valueOf(updatedAt);
        Long lValueOf2 = Long.valueOf(updatedAt);
        if (subTasks != null) {
            List<TaskInfoCard> list = subTasks;
            listM = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                listM.add(((TaskInfoCard) it.next()).getTaskId());
            }
        } else {
            listM = null;
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        return new TaskInfoCard(taskInfoEventType, lValueOf, lValueOf2, "sweep-debug-session", taskId, parentTaskId, listM, TASK_TYPE, 1, null, 0, 0, false, status, title, subTitle, null, progress, summary, "sweep-debug-session", pendingQuestions, title, createdAt, Long.valueOf(createdAt + 1000), endedAt, updatedAt, null, null, subTasks, null, null, null, null, null, -335471104, 3, null);
    }

    public final TaskInfoQuestion e(String question, String... labels) {
        ArrayList arrayList = new ArrayList(labels.length);
        for (String str : labels) {
            arrayList.add(new TaskInfoOption(str, str));
        }
        return new TaskInfoQuestion(question, "中卡调试", arrayList, Boolean.FALSE);
    }

    public final Object f(InterfaceC4014c<? super Integer> interfaceC4014c) {
        return TaskStoreModule.INSTANCE.n().p(b(this, 0L, 1, null), interfaceC4014c);
    }
}

package z6;

import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.database.TaskInfoConverters;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lz6/a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", Const.LBS_FAIL_BD_ENTITY, Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "", "entities", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6363a {
    public static final C6363a INSTANCE = new C6363a();

    public final TaskInfoCard a(TaskInfoCardEntity entity) {
        p.i(entity, "entity");
        TaskInfoConverters taskInfoConverters = TaskInfoConverters.INSTANCE;
        return new TaskInfoCard(taskInfoConverters.k(entity.getEventType()), entity.getSeq(), entity.getTs(), entity.getSessionKey(), entity.getTaskId(), entity.getParentTaskId(), taskInfoConverters.h(entity.getSubTaskIdsJson()), entity.getType(), entity.getVersion(), entity.getVersionId(), entity.getTaskVersion(), entity.getActiveTaskVersion(), entity.getNoTaskDetail(), taskInfoConverters.l(entity.getStatus()), entity.getTitle(), entity.getSubTitle(), entity.getIconUrl(), taskInfoConverters.f(entity.getProgressJson()), entity.getSummary(), entity.getRequestSessionKey(), taskInfoConverters.g(entity.getPendingQuestionsJson()), entity.getIntention(), entity.getCreatedAt(), entity.getStartedAt(), entity.getEndedAt(), entity.getUpdatedAt(), taskInfoConverters.e(entity.getResultJson()), entity.getExtensionsJson(), taskInfoConverters.i(entity.getSubTasksJson()), entity.getNotificationDismissedStatus(), entity.getDurationMs(), taskInfoConverters.h(entity.getAnsweredQuestionTextsJson()), entity.getReadAt(), taskInfoConverters.d(entity.getAnswerJson()));
    }

    public final List<TaskInfoCard> b(List<TaskInfoCardEntity> entities) {
        p.i(entities, "entities");
        List<TaskInfoCardEntity> list = entities;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a((TaskInfoCardEntity) it.next()));
        }
        return arrayList;
    }

    public final TaskInfoCardEntity c(TaskInfoCard card) {
        p.i(card, "card");
        String taskId = card.getTaskId();
        String strName = card.getEventType().name();
        Long seq = card.getSeq();
        Long ts = card.getTs();
        String sessionKey = card.getSessionKey();
        String parentTaskId = card.getParentTaskId();
        TaskInfoConverters taskInfoConverters = TaskInfoConverters.INSTANCE;
        return new TaskInfoCardEntity(taskId, null, strName, seq, ts, sessionKey, parentTaskId, taskInfoConverters.q(card.getSubTaskIds()), card.getType(), card.getVersion(), card.getVersionId(), card.getTaskVersion(), card.getActiveTaskVersion(), card.getNoTaskDetail(), card.getStatus().name(), card.getTitle(), card.getSubTitle(), card.getIconUrl(), taskInfoConverters.n(card.getProgress()), card.getSummary(), card.getRequestSessionKey(), taskInfoConverters.o(card.getPendingQuestions()), card.getIntention(), card.getCreatedAt(), card.getStartedAt(), card.getEndedAt(), card.getUpdatedAt(), taskInfoConverters.m(card.getResult()), card.getExtensionsJson(), taskInfoConverters.r(card.getSubTasks()), taskInfoConverters.a(card.getAnswer()), false, null, null, null, null, -2147483646, 15, null);
    }
}

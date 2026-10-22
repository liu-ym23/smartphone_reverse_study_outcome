package A6;

import La.H;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoQuestion;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Z", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Z", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    public static final boolean a(TaskInfoCard taskInfoCard) {
        p.i(taskInfoCard, "<this>");
        if (taskInfoCard.getStatus().isTerminal()) {
            return false;
        }
        Set setR1 = F.r1(taskInfoCard.getAnsweredQuestionTexts());
        List<TaskInfoQuestion> pendingQuestions = taskInfoCard.getPendingQuestions();
        if (pendingQuestions == null) {
            pendingQuestions = C1173v.m();
        }
        List<TaskInfoQuestion> list = pendingQuestions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (TaskInfoQuestion taskInfoQuestion : list) {
            if (!H.x0(taskInfoQuestion.getQuestion()) && !setR1.contains(taskInfoQuestion.getQuestion())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(TaskInfoStatus taskInfoStatus) {
        p.i(taskInfoStatus, "<this>");
        return taskInfoStatus == TaskInfoStatus.WAITING || taskInfoStatus == TaskInfoStatus.PENDING;
    }
}

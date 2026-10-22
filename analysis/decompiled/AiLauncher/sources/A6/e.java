package A6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LA6/e;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;)Ljava/util/List;", "card", "", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Z", "", "now", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;J)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final e INSTANCE = new e();

    public final TaskInfoCard a(TaskInfoCard card, long now) {
        p.i(card, "card");
        TaskInfoEventType taskInfoEventType = TaskInfoEventType.COMPLETED;
        TaskInfoStatus taskInfoStatus = TaskInfoStatus.COMPLETED;
        Long endedAt = card.getEndedAt();
        return TaskInfoCard.copy$default(card, taskInfoEventType, null, null, null, null, null, null, null, null, null, 0, 0, false, taskInfoStatus, null, null, null, null, null, null, null, null, 0L, null, Long.valueOf(endedAt != null ? endedAt.longValue() : now), Math.max(card.getUpdatedAt(), now), null, null, null, null, null, null, null, null, -50339842, 3, null);
    }

    public final List<TaskInfoCard> b(List<TaskInfoCard> cards) {
        p.i(cards, "cards");
        ArrayList arrayList = new ArrayList();
        for (Object obj : cards) {
            if (INSTANCE.c((TaskInfoCard) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean c(TaskInfoCard card) {
        p.i(card, "card");
        return ((card.getStatus() != TaskInfoStatus.RUNNING && card.getStatus() != TaskInfoStatus.IN_PROGRESS) || d.b(card.getStatus()) || d.a(card)) ? false : true;
    }
}

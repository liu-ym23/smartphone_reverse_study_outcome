package A6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LA6/a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "chatWaiting", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Z)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();

    public final TaskInfoStatus a(TaskInfoCard card, boolean chatWaiting) {
        p.i(card, "card");
        if (card.getStatus().isTerminal()) {
            return null;
        }
        if (chatWaiting && card.getStatus() == TaskInfoStatus.RUNNING) {
            return TaskInfoStatus.WAITING;
        }
        if (chatWaiting || card.getStatus() != TaskInfoStatus.WAITING || d.a(card)) {
            return null;
        }
        return TaskInfoStatus.RUNNING;
    }
}

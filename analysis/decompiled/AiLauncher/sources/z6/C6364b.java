package z6;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.UnfinishedTaskInfo;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\t\u0010\n\"\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "Lcom/stepos/ailauncher/contract/model/UnfinishedTaskInfo;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/ailauncher/contract/model/UnfinishedTaskInfo;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)I", "", "TASK_INFO_TERMINAL_STATUSES", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: z6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C6364b {
    private static final Set<TaskInfoStatus> TASK_INFO_TERMINAL_STATUSES = Y.j(TaskInfoStatus.COMPLETED, TaskInfoStatus.FAILED, TaskInfoStatus.CANCELLED, TaskInfoStatus.SKIPPED);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: z6.b$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskInfoStatus.values().length];
            try {
                iArr[TaskInfoStatus.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskInfoStatus.PLANNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskInfoStatus.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskInfoStatus.RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TaskInfoStatus.IN_PROGRESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TaskInfoStatus.PAUSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TaskInfoStatus.WAITING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TaskInfoStatus.COMPLETED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TaskInfoStatus.FAILED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TaskInfoStatus.CANCELLED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TaskInfoStatus.SKIPPED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Set<TaskInfoStatus> a() {
        return TASK_INFO_TERMINAL_STATUSES;
    }

    public static final int b(TaskInfoStatus taskInfoStatus) {
        p.i(taskInfoStatus, "<this>");
        switch (a.$EnumSwitchMapping$0[taskInfoStatus.ordinal()]) {
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 7;
            case 8:
                return 4;
            case 9:
                return 5;
            case 10:
            case 11:
                return 6;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final UiTask c(TaskInfoCard taskInfoCard) {
        p.i(taskInfoCard, "<this>");
        return new UiTask(taskInfoCard.getTaskId(), null, null, taskInfoCard.getRequestSessionKey(), null, null, null, b(taskInfoCard.getStatus()), 0L, 0L, null, 0, null, null, 16246, null);
    }

    public static final UnfinishedTaskInfo d(TaskInfoCard taskInfoCard) {
        p.i(taskInfoCard, "<this>");
        return new UnfinishedTaskInfo(taskInfoCard.getTaskId(), b(taskInfoCard.getStatus()), taskInfoCard.getRequestSessionKey());
    }
}

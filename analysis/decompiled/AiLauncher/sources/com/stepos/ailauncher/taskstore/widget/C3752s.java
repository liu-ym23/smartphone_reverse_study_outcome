package com.stepos.ailauncher.taskstore.widget;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.taskstore.R$color;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/s;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "e", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/CharSequence;", "c", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)I", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.widget.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3752s {
    public static final C3752s INSTANCE = new C3752s();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.widget.s$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskInfoStatus.values().length];
            try {
                iArr[TaskInfoStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskInfoStatus.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TaskInfoStatus.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TaskInfoStatus.SKIPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TaskInfoStatus.RUNNING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TaskInfoStatus.PLANNING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TaskInfoStatus.PENDING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TaskInfoStatus.WAITING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TaskInfoStatus.PAUSED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TaskInfoStatus.CREATED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TaskInfoStatus.IN_PROGRESS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String a(TaskInfoStatus status) {
        switch (a.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                return AlipayXuiIsland.LABEL_COMPLETED;
            case 2:
                return "执行失败";
            case 3:
                return AlipayXuiIsland.LABEL_CANCELLED;
            case 4:
                return "已跳过";
            case 5:
            case 11:
                return "执行中";
            case 6:
                return "规划中";
            case 7:
                return "待执行";
            case 8:
                return "等待中";
            case 9:
                return "已暂停";
            case 10:
                return "准备中";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final TaskInfoStatus b(TaskInfoStatus status) {
        return status == TaskInfoStatus.IN_PROGRESS ? TaskInfoStatus.RUNNING : status;
    }

    public final CharSequence c(TaskInfoCard card) {
        String error;
        kotlin.jvm.internal.p.i(card, "card");
        switch (a.$EnumSwitchMapping$0[b(card.getStatus()).ordinal()]) {
            case 1:
                String summary = card.getSummary();
                if (summary == null) {
                    return AlipayXuiIsland.LABEL_COMPLETED;
                }
                str = La.H.x0(summary) ? null : summary;
                return str == null ? AlipayXuiIsland.LABEL_COMPLETED : str;
            case 2:
                String summary2 = card.getSummary();
                if (summary2 != null) {
                    if (La.H.x0(summary2)) {
                        summary2 = null;
                    }
                    if (summary2 != null) {
                        return summary2;
                    }
                }
                TaskInfoAnswer answer = card.getAnswer();
                if (answer != null && (error = answer.getError()) != null && !La.H.x0(error)) {
                    str = error;
                }
                return str == null ? "执行失败" : str;
            case 3:
                return AlipayXuiIsland.LABEL_CANCELLED;
            case 4:
                return "已跳过";
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                String summary3 = card.getSummary();
                if (summary3 != null) {
                    if (La.H.x0(summary3)) {
                        summary3 = null;
                    }
                    if (summary3 != null) {
                        return summary3;
                    }
                }
                String subTitle = card.getSubTitle();
                if (subTitle != null && !La.H.x0(subTitle)) {
                    str = subTitle;
                }
                return str == null ? a(card.getStatus()) : str;
            case 11:
                return a(card.getStatus());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int d(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        switch (a.$EnumSwitchMapping$0[b(card.getStatus()).ordinal()]) {
            case 1:
                return R$color.taskstore_card_status_success;
            case 2:
                return R$color.taskstore_card_status_failed;
            case 3:
            case 4:
            case 9:
            case 10:
                return R$color.taskstore_card_status_normal;
            case 5:
            case 6:
            case 7:
            case 8:
                return R$color.taskstore_card_status_running;
            case 11:
                return R$color.taskstore_card_status_running;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final CharSequence e(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        String title = card.getTitle();
        if (title != null) {
            if (La.H.x0(title)) {
                title = null;
            }
            if (title != null) {
                return title;
            }
        }
        String type = card.getType();
        return La.H.x0(type) ? card.getTaskId() : type;
    }
}

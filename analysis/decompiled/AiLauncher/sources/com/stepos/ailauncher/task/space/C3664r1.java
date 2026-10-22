package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/task/space/r1;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.r1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3664r1 {
    public static final C3664r1 INSTANCE = new C3664r1();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.r1$a */
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
                iArr[TaskInfoStatus.CREATED.ordinal()] = 5;
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
                iArr[TaskInfoStatus.RUNNING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TaskInfoStatus.IN_PROGRESS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TaskInfoStatus.PAUSED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TaskInfoStatus.WAITING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String a(TaskInfoCard card) {
        String strB = b(card.getSubTitle());
        return strB == null ? b(card.getSummary()) : strB;
    }

    public final String b(String str) {
        if (str == null || La.H.x0(str)) {
            return null;
        }
        return str;
    }

    public final String c(TaskInfoCard card) {
        String strA;
        kotlin.jvm.internal.p.i(card, "card");
        int i10 = a.$EnumSwitchMapping$0[card.getStatus().ordinal()];
        if (i10 == 1) {
            String strB = b(card.getSummary());
            return strB == null ? "" : strB;
        }
        if (i10 != 2) {
            return (i10 == 3 || i10 == 4 || i10 == 5 || (strA = a(card)) == null) ? "" : strA;
        }
        String strB2 = b(card.getSummary());
        if (strB2 == null) {
            TaskInfoAnswer answer = card.getAnswer();
            strB2 = b(answer != null ? answer.getError() : null);
        }
        return strB2 == null ? "" : strB2;
    }
}

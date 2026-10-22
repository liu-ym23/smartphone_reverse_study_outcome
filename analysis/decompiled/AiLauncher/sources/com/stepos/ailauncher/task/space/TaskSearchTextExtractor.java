package com.stepos.ailauncher.task.space;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.ailauncher.task.space.credential.CredentialApi;
import com.stepos.ailauncher.taskstore.entity.TaskInfoActorSource;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswerPhase;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoContentType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoOption;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPartType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoQuestion;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016JC\u0010\u0019\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ-\u0010!\u001a\u00020\u00142\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\b!\u0010\"J-\u0010%\u001a\u00020\u00142\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\b%\u0010\"J'\u0010(\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010&2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J/\u00104\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0002¢\u0006\u0004\b4\u00105J3\u00109\u001a\u00020\u00142\b\u00106\u001a\u0004\u0018\u00010\u00012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b9\u0010:J+\u0010;\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u00102\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0017H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010@J\u0019\u0010B\u001a\u00020A2\b\u00108\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020A2\b\u00108\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bD\u0010CJ\u0017\u0010E\u001a\u00020A2\u0006\u00106\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010CR\u0014\u0010F\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010GR\u0014\u0010I\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010GR\u0014\u0010K\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020N0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010P¨\u0006R"}, d2 = {"Lcom/stepos/ailauncher/task/space/TaskSearchTextExtractor;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "p", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", "q", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", "v", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Ljava/lang/String;", "", "lines", "", "depth", "", "visited", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/List;ILjava/util/Set;)V", "", "subTasks", "m", "(Ljava/util/List;Ljava/util/List;ILjava/util/Set;)V", "prefix", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/List;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "questions", "l", "(Ljava/util/List;Ljava/util/List;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "parts", "k", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "answer", "f", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;Ljava/util/List;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;", "phase", "e", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;)Ljava/lang/String;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;", "source", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;)Ljava/lang/String;", "label", "json", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", UxipConstants.f30680s, "output", "key", "n", "(Ljava/lang/Object;Ljava/util/List;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "w", "(Ljava/util/List;)Ljava/lang/String;", "t", "(Ljava/lang/String;)Ljava/lang/String;", "", "u", "(Ljava/lang/String;)Z", "r", "s", "MAX_SUB_TASK_DEPTH", "I", "MAX_LINE_LENGTH", "MAX_TEXT_LENGTH", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "indexablePartTypes", "Ljava/util/Set;", "SENSITIVE_JSON_KEY_PARTS", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskSearchTextExtractor {
    private static final int MAX_LINE_LENGTH = 320;
    private static final int MAX_SUB_TASK_DEPTH = 3;
    private static final int MAX_TEXT_LENGTH = 6000;
    public static final TaskSearchTextExtractor INSTANCE = new TaskSearchTextExtractor();
    private static final Gson gson = new Gson();
    private static final Set<TaskInfoPartType> indexablePartTypes = Z8.Y.j(TaskInfoPartType.TEXT, TaskInfoPartType.MARKDOWN, TaskInfoPartType.HTML, TaskInfoPartType.CODE);
    private static final Set<String> SENSITIVE_JSON_KEY_PARTS = Z8.Y.j(M5.b.CREDENTIAL_TOKEN, "secret", "password", CredentialApi.BASE_URL_KEY, "authorization", "cookie", "signature", "apikey", "api_key");

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

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
            int[] iArr2 = new int[TaskInfoAnswerPhase.values().length];
            try {
                iArr2[TaskInfoAnswerPhase.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[TaskInfoAnswerPhase.APPLIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[TaskInfoAnswerPhase.REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[TaskInfoActorSource.values().length];
            try {
                iArr3[TaskInfoActorSource.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[TaskInfoActorSource.MODEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[TaskInfoActorSource.SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static /* synthetic */ void o(TaskSearchTextExtractor taskSearchTextExtractor, Object obj, List list, String str, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            str = null;
        }
        taskSearchTextExtractor.n(obj, list, str);
    }

    public static final boolean x(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !La.H.x0(it);
    }

    public final String c(TaskInfoActorSource source) {
        int i10 = a.$EnumSwitchMapping$2[source.ordinal()];
        if (i10 == 1) {
            return "用户";
        }
        if (i10 == 2) {
            return "模型";
        }
        if (i10 == 3) {
            return "系统";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void d(List<String> list, String str, String str2) {
        String strT;
        if (str2 == null || (strT = t(str2)) == null) {
            return;
        }
        if (La.H.x0(strT)) {
            strT = null;
        }
        if (strT == null) {
            return;
        }
        list.add(str + "：" + strT);
    }

    public final String e(TaskInfoAnswerPhase phase) {
        int i10 = a.$EnumSwitchMapping$1[phase.ordinal()];
        if (i10 == 1) {
            return "已接受";
        }
        if (i10 == 2) {
            return "已应用";
        }
        if (i10 == 3) {
            return "已拒绝";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void f(TaskInfoAnswer answer, List<String> lines) {
        if (answer == null) {
            return;
        }
        d(lines, "答复阶段", e(answer.getPhase()));
        d(lines, "答复来源", c(answer.getActor().getSource()));
        d(lines, "答复人", answer.getActor().getDisplayName());
        d(lines, "答复原因", answer.getReason());
        d(lines, "答复错误", answer.getError());
        Boolean cancel = answer.getCancel();
        if (cancel != null) {
            INSTANCE.d(lines, "答复取消状态", cancel.booleanValue() ? AlipayXuiIsland.LABEL_CANCELLED : "未取消");
        }
        j("答复内容", answer.getAnswersJson(), lines);
    }

    public final void g(TaskInfoCard card, List<String> lines, String prefix) {
        d(lines, prefix + " 副标题", card.getSubTitle());
        d(lines, prefix + " 摘要", card.getSummary());
        d(lines, prefix + " 意图", card.getIntention());
        d(lines, prefix + " 状态", v(card.getStatus()));
    }

    public final void h(TaskInfoCard card, List<String> lines, String prefix) {
        d(lines, prefix + " 标题", card.getTitle());
        g(card, lines, prefix);
    }

    public final void i(TaskInfoCard card, List<String> lines, int depth, Set<String> visited) {
        l(card.getPendingQuestions(), lines);
        k(card.getResult(), lines);
        f(card.getAnswer(), lines);
        m(card.getSubTasks(), lines, depth + 1, visited);
    }

    public final void j(String label, String json, List<String> lines) {
        String string;
        Object objB;
        if (json == null || (string = La.H.D1(json).toString()) == null) {
            return;
        }
        if (La.H.x0(string)) {
            string = null;
        }
        if (string == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            ArrayList arrayList = new ArrayList();
            o(this, gson.fromJson(string, Object.class), arrayList, null, 4, null);
            objB = Result.b(Z8.F.m1(arrayList));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        List list = (List) objB;
        if (list == null) {
            return;
        }
        String strA0 = Z8.F.A0(Z8.F.f1(Z8.F.g0(list), 24), "；", null, null, 0, null, null, 62, null);
        String str = La.H.x0(strA0) ? null : strA0;
        if (str != null) {
            INSTANCE.d(lines, label, str);
        }
    }

    public final void k(List<TaskInfoPart> parts, List<String> lines) {
        if (parts == null) {
            parts = C1173v.m();
        }
        int i10 = 0;
        for (Object obj : parts) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            TaskInfoPart taskInfoPart = (TaskInfoPart) obj;
            String str = "结果" + i11;
            TaskSearchTextExtractor taskSearchTextExtractor = INSTANCE;
            taskSearchTextExtractor.d(lines, str + " 标题", taskInfoPart.getTitle());
            if (taskInfoPart.getContentType() == TaskInfoContentType.INLINE && indexablePartTypes.contains(taskInfoPart.getType())) {
                taskSearchTextExtractor.d(lines, str + " 内容", taskInfoPart.getContent());
            }
            taskSearchTextExtractor.d(lines, str + " 文件名", taskInfoPart.getFileName());
            taskSearchTextExtractor.d(lines, str + " 错误原因", taskInfoPart.getErrorReason());
            taskSearchTextExtractor.d(lines, str + " 错误详情", taskInfoPart.getErrorDetail());
            i10 = i11;
        }
    }

    public final void l(List<TaskInfoQuestion> questions, List<String> lines) {
        if (questions == null) {
            questions = C1173v.m();
        }
        int i10 = 0;
        for (Object obj : questions) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            TaskInfoQuestion taskInfoQuestion = (TaskInfoQuestion) obj;
            String str = "待回答问题" + i11;
            TaskSearchTextExtractor taskSearchTextExtractor = INSTANCE;
            taskSearchTextExtractor.d(lines, str + " 标题", taskInfoQuestion.getHeader());
            taskSearchTextExtractor.d(lines, str, taskInfoQuestion.getQuestion());
            for (TaskInfoOption taskInfoOption : taskInfoQuestion.getOptions()) {
                TaskSearchTextExtractor taskSearchTextExtractor2 = INSTANCE;
                taskSearchTextExtractor2.d(lines, str + " 选项", taskInfoOption.getLabel());
                taskSearchTextExtractor2.d(lines, str + " 选项说明", taskInfoOption.getDescription());
            }
            i10 = i11;
        }
    }

    public final void m(List<TaskInfoCard> subTasks, List<String> lines, int depth, Set<String> visited) {
        List<TaskInfoCard> list = subTasks;
        if (list == null || list.isEmpty() || depth > 3) {
            return;
        }
        int i10 = 0;
        for (Object obj : subTasks) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            TaskInfoCard taskInfoCard = (TaskInfoCard) obj;
            if (visited.add(taskInfoCard.getTaskId())) {
                TaskSearchTextExtractor taskSearchTextExtractor = INSTANCE;
                taskSearchTextExtractor.h(taskInfoCard, lines, "子任务" + i11);
                taskSearchTextExtractor.i(taskInfoCard, lines, depth, visited);
            }
            i10 = i11;
        }
    }

    public final void n(Object value, List<String> output, String key) {
        if (value instanceof Map) {
            for (Map.Entry entry : ((Map) value).entrySet()) {
                Object key2 = entry.getKey();
                Object value2 = entry.getValue();
                String string = key2 != null ? key2.toString() : null;
                TaskSearchTextExtractor taskSearchTextExtractor = INSTANCE;
                if (!taskSearchTextExtractor.u(string)) {
                    taskSearchTextExtractor.n(value2, output, string);
                }
            }
            return;
        }
        if (value instanceof List) {
            Iterator it = ((Iterable) value).iterator();
            while (it.hasNext()) {
                INSTANCE.n(it.next(), output, key);
            }
        } else {
            if (value instanceof String) {
                String strT = t((String) value);
                if (La.H.x0(strT) || s(strT)) {
                    return;
                }
                output.add(strT);
                return;
            }
            if (((value instanceof Number) || (value instanceof Boolean)) && r(key)) {
                output.add(value.toString());
            }
        }
    }

    public final String p(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        ArrayList arrayList = new ArrayList();
        g(card, arrayList, "任务");
        i(card, arrayList, 0, Z8.Y.h(card.getTaskId()));
        return w(arrayList);
    }

    public final String q(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        ArrayList arrayList = new ArrayList();
        i(card, arrayList, 0, Z8.Y.h(card.getTaskId()));
        return w(arrayList);
    }

    public final boolean r(String key) {
        String lowerCase;
        if (key != null) {
            Locale ROOT = Locale.ROOT;
            kotlin.jvm.internal.p.h(ROOT, "ROOT");
            lowerCase = key.toLowerCase(ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        return Z8.Y.j("title", "name", "text", "label", "description", Const.JSON_KEY_DESC, c.a.COL_SUMMARY, SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "status", "button", "actiontext", "hint", "subtitle", "answer", "reason", "error").contains(lowerCase);
    }

    public final boolean s(String value) {
        Locale ROOT = Locale.ROOT;
        kotlin.jvm.internal.p.h(ROOT, "ROOT");
        String lowerCase = value.toLowerCase(ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        if (La.D.X(lowerCase, "http://", false, 2, null) || La.D.X(lowerCase, "https://", false, 2, null) || La.D.X(lowerCase, "content://", false, 2, null) || La.D.X(lowerCase, "file://", false, 2, null)) {
            return true;
        }
        if (value.length() > 120) {
            int i10 = 0;
            for (int i11 = 0; i11 < value.length(); i11++) {
                char cCharAt = value.charAt(i11);
                if (cCharAt == '/' || cCharAt == '_' || cCharAt == '-') {
                    i10++;
                }
            }
            if (i10 > 12) {
                return true;
            }
        }
        return false;
    }

    public final String t(String value) {
        return La.K.R1(La.H.D1(new Regex("\\s+").l(new Regex("[\\r\\n\\t]+").l(value, " "), " ")).toString(), 320);
    }

    public final boolean u(String key) {
        String lowerCase;
        if (key != null) {
            Locale ROOT = Locale.ROOT;
            kotlin.jvm.internal.p.h(ROOT, "ROOT");
            lowerCase = key.toLowerCase(ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        if (La.D.K(lowerCase, "id", false, 2, null)) {
            return true;
        }
        Set<String> set = SENSITIVE_JSON_KEY_PARTS;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (La.H.g0(lowerCase, (CharSequence) it.next(), false, 2, null)) {
                    return true;
                }
            }
        }
        return Z8.Y.j("id", "uuid", "url", "uri", "icon", "image", "img", "cover", "schema", "package", "action", "type", "style", "color", "background", "payload", "taskid", "task_id", "sha256", "mimetype", "mime_type").contains(lowerCase);
    }

    public final String v(TaskInfoStatus status) {
        kotlin.jvm.internal.p.i(status, "status");
        switch (a.$EnumSwitchMapping$0[status.ordinal()]) {
            case 1:
                return "已创建";
            case 2:
                return "规划中";
            case 3:
                return "待执行";
            case 4:
            case 5:
                return "执行中";
            case 6:
                return "已暂停";
            case 7:
                return "等待输入";
            case 8:
                return AlipayXuiIsland.LABEL_COMPLETED;
            case 9:
                return "失败";
            case 10:
                return AlipayXuiIsland.LABEL_CANCELLED;
            case 11:
                return "已跳过";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String w(List<String> list) {
        return La.K.R1(SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(Z8.F.d0(list), new TaskSearchTextExtractor$toSearchText$1(this)), new InterfaceC5074l() { // from class: com.stepos.ailauncher.task.space.s1
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TaskSearchTextExtractor.x((String) obj));
            }
        })), "\n", null, null, 0, null, null, 62, null), MAX_TEXT_LENGTH);
    }
}

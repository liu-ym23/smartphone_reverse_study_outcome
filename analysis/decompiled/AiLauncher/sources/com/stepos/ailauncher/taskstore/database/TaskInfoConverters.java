package com.stepos.ailauncher.taskstore.database;

import La.H;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoProgress;
import com.stepos.ailauncher.taskstore.entity.TaskInfoQuestion;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\bJ\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\bJ\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\bJ\u001f\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001e\u0010\u000bJ\u0017\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0000¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\b\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\b\u0010\"\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b*\u0010+JE\u00103\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010-2\u0006\u00102\u001a\u00020-¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010>\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010=R\u001c\u0010?\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010=R\u001c\u0010@\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010=R\u0014\u0010A\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/TaskInfoConverters;", "", "<init>", "()V", "", "", UxipConstants.f30680s, "q", "(Ljava/util/List;)Ljava/lang/String;", "json", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/util/List;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "n", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;)Ljava/lang/String;", "f", "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "m", "e", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoQuestion;", "o", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswer;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "r", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "card", "p", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "raw", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "k", "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "l", "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "", "c", "(Ljava/lang/String;)Z", "leftVersionId", "", "leftVersion", "leftTaskVersion", "rightVersionId", "rightVersion", "rightTaskVersion", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;I)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "stringListType", "Ljava/lang/reflect/Type;", "partListType", "questionListType", "taskInfoCardListType", "VERSION_ID_PREFIX", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoConverters {
    public static final TaskInfoConverters INSTANCE = new TaskInfoConverters();
    private static final String VERSION_ID_PREFIX = "version_";
    private static final Gson gson;
    private static final Type partListType;
    private static final Type questionListType;
    private static final Type stringListType;
    private static final Type taskInfoCardListType;

    static {
        Gson gsonCreate = new GsonBuilder().disableHtmlEscaping().create();
        kotlin.jvm.internal.p.h(gsonCreate, "create(...)");
        gson = gsonCreate;
        stringListType = new TypeToken<List<? extends String>>() { // from class: com.stepos.ailauncher.taskstore.database.TaskInfoConverters$stringListType$1
        }.getType();
        partListType = new TypeToken<List<? extends TaskInfoPart>>() { // from class: com.stepos.ailauncher.taskstore.database.TaskInfoConverters$partListType$1
        }.getType();
        questionListType = new TypeToken<List<? extends TaskInfoQuestion>>() { // from class: com.stepos.ailauncher.taskstore.database.TaskInfoConverters$questionListType$1
        }.getType();
        taskInfoCardListType = new TypeToken<List<? extends TaskInfoCard>>() { // from class: com.stepos.ailauncher.taskstore.database.TaskInfoConverters$taskInfoCardListType$1
        }.getType();
    }

    public final String a(TaskInfoAnswer value) {
        if (value != null) {
            return gson.toJson(value);
        }
        return null;
    }

    public final boolean b(String leftVersionId, Integer leftVersion, int leftTaskVersion, String rightVersionId, Integer rightVersion, int rightTaskVersion) {
        String strJ = j(leftVersionId);
        String strJ2 = j(rightVersionId);
        if (strJ != null && strJ2 != null && !kotlin.jvm.internal.p.d(strJ, strJ2)) {
            return false;
        }
        if (leftVersion == null || rightVersion == null || kotlin.jvm.internal.p.d(leftVersion, rightVersion)) {
            return (leftTaskVersion <= 0 && rightTaskVersion <= 0) || leftTaskVersion == rightTaskVersion;
        }
        return false;
    }

    public final boolean c(String raw) {
        return l(raw).isTerminal();
    }

    public final TaskInfoAnswer d(String json) {
        Object objB;
        if (json == null || H.x0(json)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((TaskInfoAnswer) gson.fromJson(json, TaskInfoAnswer.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (TaskInfoAnswer) (Result.g(objB) ? null : objB);
    }

    public final List<TaskInfoPart> e(String json) {
        Object objB;
        if (json == null || H.x0(json)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((List) gson.fromJson(json, partListType));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (List) (Result.g(objB) ? null : objB);
    }

    public final TaskInfoProgress f(String json) {
        Object objB;
        if (json == null || H.x0(json)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((TaskInfoProgress) gson.fromJson(json, TaskInfoProgress.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (TaskInfoProgress) (Result.g(objB) ? null : objB);
    }

    public final List<TaskInfoQuestion> g(String json) {
        Object objB;
        if (json == null || H.x0(json)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((List) gson.fromJson(json, questionListType));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (List) (Result.g(objB) ? null : objB);
    }

    public final List<String> h(String json) {
        Object objB;
        if (json == null || H.x0(json)) {
            return C1173v.m();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((List) gson.fromJson(json, stringListType));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        List<String> list = (List) objB;
        return list == null ? C1173v.m() : list;
    }

    public final List<TaskInfoCard> i(String json) {
        Object objB;
        ArrayList arrayList = null;
        if (json != null && !H.x0(json)) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b((List) gson.fromJson(json, taskInfoCardListType));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            List list = (List) objB;
            if (list != null) {
                List list2 = list;
                arrayList = new ArrayList(C1174w.x(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(INSTANCE.p((TaskInfoCard) it.next()));
                }
            }
        }
        return arrayList;
    }

    public final String j(String str) {
        String strR0;
        if (str == null || (strR0 = H.R0(str, VERSION_ID_PREFIX)) == null || H.x0(strR0)) {
            return null;
        }
        return strR0;
    }

    public final TaskInfoEventType k(String raw) {
        String string;
        Object objB;
        if (raw != null && (string = H.D1(raw).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    String upperCase = string.toUpperCase(Locale.ROOT);
                    kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
                    objB = Result.b(TaskInfoEventType.valueOf(upperCase));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                TaskInfoEventType taskInfoEventType = TaskInfoEventType.UPDATED;
                if (Result.g(objB)) {
                    objB = taskInfoEventType;
                }
                return (TaskInfoEventType) objB;
            }
        }
        return TaskInfoEventType.UPDATED;
    }

    public final TaskInfoStatus l(String raw) {
        String string;
        Object objB;
        if (raw != null && (string = H.D1(raw).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(TaskInfoStatus.valueOf(string));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                TaskInfoStatus taskInfoStatus = TaskInfoStatus.CREATED;
                if (Result.g(objB)) {
                    objB = taskInfoStatus;
                }
                return (TaskInfoStatus) objB;
            }
        }
        return TaskInfoStatus.CREATED;
    }

    public final String m(List<TaskInfoPart> value) {
        if (value == null) {
            return null;
        }
        return gson.toJson(value);
    }

    public final String n(TaskInfoProgress value) {
        if (value != null) {
            return gson.toJson(value);
        }
        return null;
    }

    public final String o(List<TaskInfoQuestion> value) {
        List<TaskInfoQuestion> list = value;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return gson.toJson(value);
    }

    public final TaskInfoCard p(TaskInfoCard card) {
        ArrayList arrayList;
        kotlin.jvm.internal.p.i(card, "card");
        TaskInfoEventType eventType = card.getEventType();
        String taskId = card.getTaskId();
        String type = card.getType();
        TaskInfoStatus status = card.getStatus();
        List<String> subTaskIds = card.getSubTaskIds();
        List<String> answeredQuestionTexts = card.getAnsweredQuestionTexts();
        List<TaskInfoCard> subTasks = card.getSubTasks();
        if (subTasks != null) {
            List<TaskInfoCard> list = subTasks;
            arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.p((TaskInfoCard) it.next()));
            }
        } else {
            arrayList = null;
        }
        ArrayList arrayList2 = arrayList;
        if (eventType == null) {
            eventType = TaskInfoEventType.UPDATED;
        }
        TaskInfoEventType taskInfoEventType = eventType;
        Long seq = card.getSeq();
        Long ts = card.getTs();
        String sessionKey = card.getSessionKey();
        String str = taskId == null ? "" : taskId;
        String parentTaskId = card.getParentTaskId();
        if (subTaskIds == null) {
            subTaskIds = C1173v.m();
        }
        List<String> list2 = subTaskIds;
        String str2 = type == null ? "" : type;
        Integer version = card.getVersion();
        if (status == null) {
            status = TaskInfoStatus.CREATED;
        }
        TaskInfoStatus taskInfoStatus = status;
        String title = card.getTitle();
        String subTitle = card.getSubTitle();
        TaskInfoProgress progress = card.getProgress();
        String summary = card.getSummary();
        String requestSessionKey = card.getRequestSessionKey();
        List<TaskInfoQuestion> pendingQuestions = card.getPendingQuestions();
        String intention = card.getIntention();
        long createdAt = card.getCreatedAt();
        Long startedAt = card.getStartedAt();
        Long endedAt = card.getEndedAt();
        long updatedAt = card.getUpdatedAt();
        List<TaskInfoPart> result = card.getResult();
        String extensionsJson = card.getExtensionsJson();
        TaskInfoAnswer answer = card.getAnswer();
        if (answeredQuestionTexts == null) {
            answeredQuestionTexts = C1173v.m();
        }
        return new TaskInfoCard(taskInfoEventType, seq, ts, sessionKey, str, parentTaskId, list2, str2, version, null, 0, 0, false, taskInfoStatus, title, subTitle, null, progress, summary, requestSessionKey, pendingQuestions, intention, createdAt, startedAt, endedAt, updatedAt, result, extensionsJson, arrayList2, null, null, answeredQuestionTexts, null, answer, 1610685952, 1, null);
    }

    public final String q(List<String> value) {
        List<String> list = value;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return gson.toJson(value);
    }

    public final String r(List<TaskInfoCard> value) {
        List<TaskInfoCard> list = value;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return gson.toJson(value);
    }
}

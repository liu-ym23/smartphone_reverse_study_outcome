package com.stepos.agentframework.adapter.agentbus;

import Z8.C1174w;
import a4.C;
import a4.Option;
import a4.Question;
import a4.Task;
import a4.TaskArtifact;
import a4.TaskProgress;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.TaskStatus;
import com.stepos.agentframework.adapter.netcore.BusContentType;
import com.stepos.agentframework.adapter.netcore.BusOption;
import com.stepos.agentframework.adapter.netcore.BusPart;
import com.stepos.agentframework.adapter.netcore.BusPartType;
import com.stepos.agentframework.adapter.netcore.BusQuestion;
import com.stepos.agentframework.adapter.netcore.BusTask;
import com.stepos.agentframework.adapter.netcore.BusTaskProgress;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.adapter.netcore.TaskEventPayload;
import com.stepos.agentframework.adapter.netcore.TaskEventType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0013\u0010\u001e\u001a\u00020\u001d*\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0013\u0010\"\u001a\u00020!*\u00020 H\u0002¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"La4/C;", "Lcom/stepos/agentframework/adapter/netcore/C;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(La4/C;)Lcom/stepos/agentframework/adapter/netcore/C;", "La4/A;", "Lcom/stepos/agentframework/adapter/netcore/e;", "f", "(La4/A;)Lcom/stepos/agentframework/adapter/netcore/e;", "Lcom/stepos/agentbus/generated/TaskStatus;", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentbus/generated/TaskStatus;)Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "La4/D;", "Lcom/stepos/agentframework/adapter/netcore/g;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(La4/D;)Lcom/stepos/agentframework/adapter/netcore/g;", "La4/B;", "Lcom/stepos/agentframework/adapter/netcore/c;", Const.INTENT_KEY_UMID, "(La4/B;)Lcom/stepos/agentframework/adapter/netcore/c;", "", "raw", "Lcom/stepos/agentframework/adapter/netcore/BusPartType;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/agentframework/adapter/netcore/BusPartType;", "Lcom/stepos/agentframework/adapter/netcore/BusContentType;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/agentframework/adapter/netcore/BusContentType;", "La4/y;", "Lcom/stepos/agentframework/adapter/netcore/d;", "e", "(La4/y;)Lcom/stepos/agentframework/adapter/netcore/d;", "La4/x;", "Lcom/stepos/agentframework/adapter/netcore/b;", "c", "(La4/x;)Lcom/stepos/agentframework/adapter/netcore/b;", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class t {
    public static final BusContentType a(String str) {
        String string;
        Object objB;
        if (str != null && (string = La.H.D1(str).toString()) != null) {
            String upperCase = string.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            if (upperCase != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(BusContentType.valueOf(upperCase));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                BusContentType busContentType = BusContentType.INLINE;
                if (Result.g(objB)) {
                    objB = busContentType;
                }
                return (BusContentType) objB;
            }
        }
        return BusContentType.INLINE;
    }

    public static final BusPartType b(String str) {
        String string;
        Object objB;
        if (str != null && (string = La.H.D1(str).toString()) != null) {
            String upperCase = string.toUpperCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
            if (upperCase != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(BusPartType.valueOf(upperCase));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                BusPartType busPartType = BusPartType.TEXT;
                if (Result.g(objB)) {
                    objB = busPartType;
                }
                return (BusPartType) objB;
            }
        }
        return BusPartType.TEXT;
    }

    public static final BusOption c(Option option) {
        return new BusOption(option.getLabel(), option.getDescription());
    }

    public static final BusPart d(TaskArtifact taskArtifact) {
        String artifactId = taskArtifact.getArtifactId();
        String status = taskArtifact.getStatus();
        BusPartType busPartTypeB = b(taskArtifact.getType());
        BusContentType busContentTypeA = a(taskArtifact.getContentType());
        String fileId = taskArtifact.getFileId();
        String fileName = taskArtifact.getFileName();
        String content = taskArtifact.getContent();
        if (content == null) {
            content = "";
        }
        return new BusPart(artifactId, status, busPartTypeB, busContentTypeA, fileId, content, fileName, taskArtifact.getTitle(), taskArtifact.getMimeType(), taskArtifact.getSize(), taskArtifact.getSha256(), taskArtifact.getTaskVersion(), taskArtifact.getErrorReason(), taskArtifact.getErrorDetail());
    }

    public static final BusQuestion e(Question question) {
        String question2 = question.getQuestion();
        String header = question.getHeader();
        List<Option> listC = question.c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            arrayList.add(c((Option) it.next()));
        }
        return new BusQuestion(question2, header, arrayList, question.getMultiSelect());
    }

    public static final BusTask f(Task task) {
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        ArrayList arrayList3;
        kotlin.jvm.internal.p.i(task, "<this>");
        String taskId = task.getTaskId();
        String parentTaskId = task.getParentTaskId();
        List<String> listO = task.o();
        String type = task.getType();
        Integer version = task.getVersion();
        int taskVersion = task.getTaskVersion();
        int activeTaskVersion = task.getActiveTaskVersion();
        boolean noTaskDetail = task.getNoTaskDetail();
        BusTaskStatus busTaskStatusH = h(task.getStatus());
        String title = task.getTitle();
        String subTitle = task.getSubTitle();
        TaskProgress progress = task.getProgress();
        BusTaskProgress busTaskProgressG = progress != null ? g(progress) : null;
        List<Task> listP = task.p();
        if (listP != null) {
            List<Task> list = listP;
            arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(f((Task) it.next()));
            }
        } else {
            arrayList = null;
        }
        String summary = task.getSummary();
        String sessionKey = task.getSessionKey();
        String requestSessionKey = task.getRequestSessionKey();
        List<Question> listI = task.i();
        if (listI != null) {
            List<Question> list2 = listI;
            str = taskId;
            arrayList2 = new ArrayList(C1174w.x(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(e((Question) it2.next()));
            }
        } else {
            str = taskId;
            arrayList2 = null;
        }
        String intention = task.getIntention();
        long createdAt = task.getCreatedAt();
        Long startedAt = task.getStartedAt();
        Long endedAt = task.getEndedAt();
        long updatedAt = task.getUpdatedAt();
        List<TaskArtifact> listB = task.b();
        if (listB != null) {
            List<TaskArtifact> list3 = listB;
            ArrayList arrayList4 = new ArrayList(C1174w.x(list3, 10));
            Iterator<T> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList4.add(d((TaskArtifact) it3.next()));
            }
            arrayList3 = arrayList4;
        } else {
            arrayList3 = null;
        }
        return new BusTask(str, parentTaskId, listO, type, version, null, taskVersion, activeTaskVersion, null, noTaskDetail, busTaskStatusH, title, subTitle, busTaskProgressG, arrayList, summary, sessionKey, requestSessionKey, arrayList2, intention, createdAt, startedAt, endedAt, updatedAt, arrayList3, task.e(), 288, null);
    }

    public static final BusTaskProgress g(TaskProgress taskProgress) {
        return new BusTaskProgress(taskProgress.getCompleted(), taskProgress.getTotal(), taskProgress.getFailed(), taskProgress.getInProgress(), taskProgress.getPending());
    }

    public static final BusTaskStatus h(TaskStatus taskStatus) {
        return BusTaskStatus.valueOf(taskStatus.name());
    }

    public static final TaskEventPayload i(a4.C c10) {
        kotlin.jvm.internal.p.i(c10, "<this>");
        if (c10 instanceof C.Created) {
            TaskEventType taskEventType = TaskEventType.CREATED;
            C.Created created = (C.Created) c10;
            Long seq = created.getSeq();
            Long ts = created.getTs();
            String sessionKey = created.getSessionKey();
            if (sessionKey == null) {
                sessionKey = created.getTask().getSessionKey();
            }
            return new TaskEventPayload(taskEventType, seq, ts, sessionKey, f(created.getTask()), null, 32, null);
        }
        if (c10 instanceof C.Updated) {
            C.Updated updated = (C.Updated) c10;
            return new TaskEventPayload(TaskEventType.UPDATED, updated.getSeq(), updated.getTs(), updated.getSessionKey(), f(updated.getTask()), null, 32, null);
        }
        if (!(c10 instanceof C.Completed)) {
            throw new NoWhenBranchMatchedException();
        }
        TaskEventType taskEventType2 = TaskEventType.COMPLETED;
        C.Completed completed = (C.Completed) c10;
        Long seq2 = completed.getSeq();
        Long ts2 = completed.getTs();
        String sessionKey2 = completed.getSessionKey();
        if (sessionKey2 == null) {
            sessionKey2 = completed.getTask().getSessionKey();
        }
        return new TaskEventPayload(taskEventType2, seq2, ts2, sessionKey2, f(completed.getTask()), null, 32, null);
    }
}

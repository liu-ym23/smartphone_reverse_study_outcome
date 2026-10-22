package com.stepos.ailauncher.taskstore.entity;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.taskstore.provider.c;
import io.requery.android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bn\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010 \u001a\u00020\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0013\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b*\u0010+J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010[\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00109J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u000eHÆ\u0003J\t\u0010c\u001a\u00020\u000eHÆ\u0003J\t\u0010d\u001a\u00020\u0013HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0007HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010p\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\t\u0010q\u001a\u00020\u0007HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0013HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010x\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010z\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00101J¨\u0003\u0010{\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010 \u001a\u00020\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010%\u001a\u00020\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010|J\u0013\u0010}\u001a\u00020\u00132\b\u0010~\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u007f\u001a\u00020\u000eHÖ\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010-R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0016\u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010-R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010-R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010-R\u0016\u0010\u001d\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\bL\u00101R\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\bM\u00101R\u0016\u0010 \u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010KR\u0018\u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010-R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010-R\u0018\u0010#\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010-R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010-R\u0016\u0010%\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010@R\u0018\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010-R\u001a\u0010'\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\bT\u00101R\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010-R\u001a\u0010)\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\bV\u00101¨\u0006\u0081\u0001"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "", "taskId", "", "uid", "eventType", c.a.COL_SEQ, "", "ts", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "parentTaskId", "subTaskIdsJson", "type", "version", "", "versionId", "taskVersion", "activeTaskVersion", "noTaskDetail", "", "status", "title", "subTitle", "iconUrl", "progressJson", c.a.COL_SUMMARY, "requestSessionKey", "pendingQuestionsJson", "intention", "createdAt", "startedAt", "endedAt", "updatedAt", "resultJson", "extensionsJson", "subTasksJson", "answerJson", "isHidden", "notificationDismissedStatus", "durationMs", "answeredQuestionTextsJson", "readAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getTaskId", "()Ljava/lang/String;", "getUid", "getEventType", "getSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTs", "getSessionKey", "getParentTaskId", "getSubTaskIdsJson", "getType", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVersionId", "getTaskVersion", "()I", "getActiveTaskVersion", "getNoTaskDetail", "()Z", "getStatus", "getTitle", "getSubTitle", "getIconUrl", "getProgressJson", "getSummary", "getRequestSessionKey", "getPendingQuestionsJson", "getIntention", "getCreatedAt", "()J", "getStartedAt", "getEndedAt", "getUpdatedAt", "getResultJson", "getExtensionsJson", "getSubTasksJson", "getAnswerJson", "getNotificationDismissedStatus", "getDurationMs", "getAnsweredQuestionTextsJson", "getReadAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;IIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "equals", "other", "hashCode", "toString", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoCardEntity {
    private final int activeTaskVersion;
    private final String answerJson;
    private final String answeredQuestionTextsJson;
    private final long createdAt;
    private final Long durationMs;
    private final Long endedAt;
    private final String eventType;
    private final String extensionsJson;
    private final String iconUrl;
    private final String intention;
    private final boolean isHidden;
    private final boolean noTaskDetail;
    private final String notificationDismissedStatus;
    private final String parentTaskId;
    private final String pendingQuestionsJson;
    private final String progressJson;
    private final Long readAt;
    private final String requestSessionKey;
    private final String resultJson;
    private final Long seq;
    private final String sessionKey;
    private final Long startedAt;
    private final String status;
    private final String subTaskIdsJson;
    private final String subTasksJson;
    private final String subTitle;
    private final String summary;
    private final String taskId;
    private final int taskVersion;
    private final String title;
    private final Long ts;
    private final String type;
    private final String uid;
    private final long updatedAt;
    private final Integer version;
    private final String versionId;

    public TaskInfoCardEntity(String taskId, String uid, String eventType, Long l10, Long l11, String str, String str2, String str3, String type, Integer num, String str4, int i10, int i11, boolean z10, String status, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, long j10, Long l12, Long l13, long j11, String str13, String str14, String str15, String str16, boolean z11, String str17, Long l14, String str18, Long l15) {
        p.i(taskId, "taskId");
        p.i(uid, "uid");
        p.i(eventType, "eventType");
        p.i(type, "type");
        p.i(status, "status");
        this.taskId = taskId;
        this.uid = uid;
        this.eventType = eventType;
        this.seq = l10;
        this.ts = l11;
        this.sessionKey = str;
        this.parentTaskId = str2;
        this.subTaskIdsJson = str3;
        this.type = type;
        this.version = num;
        this.versionId = str4;
        this.taskVersion = i10;
        this.activeTaskVersion = i11;
        this.noTaskDetail = z10;
        this.status = status;
        this.title = str5;
        this.subTitle = str6;
        this.iconUrl = str7;
        this.progressJson = str8;
        this.summary = str9;
        this.requestSessionKey = str10;
        this.pendingQuestionsJson = str11;
        this.intention = str12;
        this.createdAt = j10;
        this.startedAt = l12;
        this.endedAt = l13;
        this.updatedAt = j11;
        this.resultJson = str13;
        this.extensionsJson = str14;
        this.subTasksJson = str15;
        this.answerJson = str16;
        this.isHidden = z11;
        this.notificationDismissedStatus = str17;
        this.durationMs = l14;
        this.answeredQuestionTextsJson = str18;
        this.readAt = l15;
    }

    public static /* synthetic */ TaskInfoCardEntity copy$default(TaskInfoCardEntity taskInfoCardEntity, String str, String str2, String str3, Long l10, Long l11, String str4, String str5, String str6, String str7, Integer num, String str8, int i10, int i11, boolean z10, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, long j10, Long l12, Long l13, long j11, String str18, String str19, String str20, String str21, boolean z11, String str22, Long l14, String str23, Long l15, int i12, int i13, Object obj) {
        Long l16;
        String str24;
        String str25;
        String str26;
        long j12;
        Long l17;
        Long l18;
        long j13;
        String str27;
        String str28;
        String str29;
        boolean z12;
        String str30;
        Long l19;
        String str31;
        String str32;
        String str33;
        Integer num2;
        String str34;
        int i14;
        int i15;
        boolean z13;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        Long l20;
        Long l21;
        String str44;
        String str45 = (i12 & 1) != 0 ? taskInfoCardEntity.taskId : str;
        String str46 = (i12 & 2) != 0 ? taskInfoCardEntity.uid : str2;
        String str47 = (i12 & 4) != 0 ? taskInfoCardEntity.eventType : str3;
        Long l22 = (i12 & 8) != 0 ? taskInfoCardEntity.seq : l10;
        Long l23 = (i12 & 16) != 0 ? taskInfoCardEntity.ts : l11;
        String str48 = (i12 & 32) != 0 ? taskInfoCardEntity.sessionKey : str4;
        String str49 = (i12 & 64) != 0 ? taskInfoCardEntity.parentTaskId : str5;
        String str50 = (i12 & 128) != 0 ? taskInfoCardEntity.subTaskIdsJson : str6;
        String str51 = (i12 & 256) != 0 ? taskInfoCardEntity.type : str7;
        Integer num3 = (i12 & 512) != 0 ? taskInfoCardEntity.version : num;
        String str52 = (i12 & 1024) != 0 ? taskInfoCardEntity.versionId : str8;
        int i16 = (i12 & 2048) != 0 ? taskInfoCardEntity.taskVersion : i10;
        int i17 = (i12 & 4096) != 0 ? taskInfoCardEntity.activeTaskVersion : i11;
        boolean z14 = (i12 & b.THRESHOLD) != 0 ? taskInfoCardEntity.noTaskDetail : z10;
        String str53 = str45;
        String str54 = (i12 & 16384) != 0 ? taskInfoCardEntity.status : str9;
        String str55 = (i12 & 32768) != 0 ? taskInfoCardEntity.title : str10;
        String str56 = (i12 & 65536) != 0 ? taskInfoCardEntity.subTitle : str11;
        String str57 = (i12 & SQLiteDatabase.OPEN_SHAREDCACHE) != 0 ? taskInfoCardEntity.iconUrl : str12;
        String str58 = (i12 & SQLiteDatabase.OPEN_PRIVATECACHE) != 0 ? taskInfoCardEntity.progressJson : str13;
        String str59 = (i12 & 524288) != 0 ? taskInfoCardEntity.summary : str14;
        String str60 = (i12 & 1048576) != 0 ? taskInfoCardEntity.requestSessionKey : str15;
        String str61 = (i12 & 2097152) != 0 ? taskInfoCardEntity.pendingQuestionsJson : str16;
        String str62 = (i12 & 4194304) != 0 ? taskInfoCardEntity.intention : str17;
        String str63 = str54;
        long j14 = (i12 & 8388608) != 0 ? taskInfoCardEntity.createdAt : j10;
        Long l24 = (i12 & 16777216) != 0 ? taskInfoCardEntity.startedAt : l12;
        Long l25 = (i12 & Const.FLAG_MUTABLE) != 0 ? taskInfoCardEntity.endedAt : l13;
        long j15 = (i12 & 67108864) != 0 ? taskInfoCardEntity.updatedAt : j11;
        String str64 = (i12 & 134217728) != 0 ? taskInfoCardEntity.resultJson : str18;
        String str65 = (i12 & net.sqlcipher.database.SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? taskInfoCardEntity.extensionsJson : str19;
        String str66 = str64;
        String str67 = (i12 & SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) != 0 ? taskInfoCardEntity.subTasksJson : str20;
        String str68 = (i12 & 1073741824) != 0 ? taskInfoCardEntity.answerJson : str21;
        boolean z15 = (i12 & Integer.MIN_VALUE) != 0 ? taskInfoCardEntity.isHidden : z11;
        String str69 = (i13 & 1) != 0 ? taskInfoCardEntity.notificationDismissedStatus : str22;
        Long l26 = (i13 & 2) != 0 ? taskInfoCardEntity.durationMs : l14;
        String str70 = (i13 & 4) != 0 ? taskInfoCardEntity.answeredQuestionTextsJson : str23;
        if ((i13 & 8) != 0) {
            str24 = str70;
            l16 = taskInfoCardEntity.readAt;
            str26 = str62;
            j12 = j14;
            l17 = l24;
            l18 = l25;
            j13 = j15;
            str27 = str66;
            str28 = str67;
            str29 = str68;
            z12 = z15;
            str30 = str69;
            l19 = l26;
            str31 = str65;
            str33 = str51;
            num2 = num3;
            str34 = str52;
            i14 = i16;
            i15 = i17;
            z13 = z14;
            str35 = str55;
            str36 = str56;
            str37 = str57;
            str38 = str58;
            str39 = str59;
            str40 = str60;
            str25 = str61;
            str41 = str63;
            str42 = str46;
            str43 = str47;
            l20 = l22;
            l21 = l23;
            str44 = str48;
            str32 = str49;
        } else {
            l16 = l15;
            str24 = str70;
            str25 = str61;
            str26 = str62;
            j12 = j14;
            l17 = l24;
            l18 = l25;
            j13 = j15;
            str27 = str66;
            str28 = str67;
            str29 = str68;
            z12 = z15;
            str30 = str69;
            l19 = l26;
            str31 = str65;
            str32 = str49;
            str33 = str51;
            num2 = num3;
            str34 = str52;
            i14 = i16;
            i15 = i17;
            z13 = z14;
            str35 = str55;
            str36 = str56;
            str37 = str57;
            str38 = str58;
            str39 = str59;
            str40 = str60;
            str41 = str63;
            str42 = str46;
            str43 = str47;
            l20 = l22;
            l21 = l23;
            str44 = str48;
        }
        return taskInfoCardEntity.copy(str53, str42, str43, l20, l21, str44, str32, str50, str33, num2, str34, i14, i15, z13, str41, str35, str36, str37, str38, str39, str40, str25, str26, j12, l17, l18, j13, str27, str31, str28, str29, z12, str30, l19, str24, l16);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    /* renamed from: component11, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    /* renamed from: component12, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    /* renamed from: component13, reason: from getter */
    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    /* renamed from: component15, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component16, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component17, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: component18, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component19, reason: from getter */
    public final String getProgressJson() {
        return this.progressJson;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: component20, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: component21, reason: from getter */
    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    /* renamed from: component22, reason: from getter */
    public final String getPendingQuestionsJson() {
        return this.pendingQuestionsJson;
    }

    /* renamed from: component23, reason: from getter */
    public final String getIntention() {
        return this.intention;
    }

    /* renamed from: component24, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component25, reason: from getter */
    public final Long getStartedAt() {
        return this.startedAt;
    }

    /* renamed from: component26, reason: from getter */
    public final Long getEndedAt() {
        return this.endedAt;
    }

    /* renamed from: component27, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component28, reason: from getter */
    public final String getResultJson() {
        return this.resultJson;
    }

    /* renamed from: component29, reason: from getter */
    public final String getExtensionsJson() {
        return this.extensionsJson;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* renamed from: component30, reason: from getter */
    public final String getSubTasksJson() {
        return this.subTasksJson;
    }

    /* renamed from: component31, reason: from getter */
    public final String getAnswerJson() {
        return this.answerJson;
    }

    /* renamed from: component32, reason: from getter */
    public final boolean getIsHidden() {
        return this.isHidden;
    }

    /* renamed from: component33, reason: from getter */
    public final String getNotificationDismissedStatus() {
        return this.notificationDismissedStatus;
    }

    /* renamed from: component34, reason: from getter */
    public final Long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: component35, reason: from getter */
    public final String getAnsweredQuestionTextsJson() {
        return this.answeredQuestionTextsJson;
    }

    /* renamed from: component36, reason: from getter */
    public final Long getReadAt() {
        return this.readAt;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getSeq() {
        return this.seq;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getTs() {
        return this.ts;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component7, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSubTaskIdsJson() {
        return this.subTaskIdsJson;
    }

    /* renamed from: component9, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final TaskInfoCardEntity copy(String taskId, String uid, String eventType, Long seq, Long ts, String sessionKey, String parentTaskId, String subTaskIdsJson, String type, Integer version, String versionId, int taskVersion, int activeTaskVersion, boolean noTaskDetail, String status, String title, String subTitle, String iconUrl, String progressJson, String summary, String requestSessionKey, String pendingQuestionsJson, String intention, long createdAt, Long startedAt, Long endedAt, long updatedAt, String resultJson, String extensionsJson, String subTasksJson, String answerJson, boolean isHidden, String notificationDismissedStatus, Long durationMs, String answeredQuestionTextsJson, Long readAt) {
        p.i(taskId, "taskId");
        p.i(uid, "uid");
        p.i(eventType, "eventType");
        p.i(type, "type");
        p.i(status, "status");
        return new TaskInfoCardEntity(taskId, uid, eventType, seq, ts, sessionKey, parentTaskId, subTaskIdsJson, type, version, versionId, taskVersion, activeTaskVersion, noTaskDetail, status, title, subTitle, iconUrl, progressJson, summary, requestSessionKey, pendingQuestionsJson, intention, createdAt, startedAt, endedAt, updatedAt, resultJson, extensionsJson, subTasksJson, answerJson, isHidden, notificationDismissedStatus, durationMs, answeredQuestionTextsJson, readAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoCardEntity)) {
            return false;
        }
        TaskInfoCardEntity taskInfoCardEntity = (TaskInfoCardEntity) other;
        return p.d(this.taskId, taskInfoCardEntity.taskId) && p.d(this.uid, taskInfoCardEntity.uid) && p.d(this.eventType, taskInfoCardEntity.eventType) && p.d(this.seq, taskInfoCardEntity.seq) && p.d(this.ts, taskInfoCardEntity.ts) && p.d(this.sessionKey, taskInfoCardEntity.sessionKey) && p.d(this.parentTaskId, taskInfoCardEntity.parentTaskId) && p.d(this.subTaskIdsJson, taskInfoCardEntity.subTaskIdsJson) && p.d(this.type, taskInfoCardEntity.type) && p.d(this.version, taskInfoCardEntity.version) && p.d(this.versionId, taskInfoCardEntity.versionId) && this.taskVersion == taskInfoCardEntity.taskVersion && this.activeTaskVersion == taskInfoCardEntity.activeTaskVersion && this.noTaskDetail == taskInfoCardEntity.noTaskDetail && p.d(this.status, taskInfoCardEntity.status) && p.d(this.title, taskInfoCardEntity.title) && p.d(this.subTitle, taskInfoCardEntity.subTitle) && p.d(this.iconUrl, taskInfoCardEntity.iconUrl) && p.d(this.progressJson, taskInfoCardEntity.progressJson) && p.d(this.summary, taskInfoCardEntity.summary) && p.d(this.requestSessionKey, taskInfoCardEntity.requestSessionKey) && p.d(this.pendingQuestionsJson, taskInfoCardEntity.pendingQuestionsJson) && p.d(this.intention, taskInfoCardEntity.intention) && this.createdAt == taskInfoCardEntity.createdAt && p.d(this.startedAt, taskInfoCardEntity.startedAt) && p.d(this.endedAt, taskInfoCardEntity.endedAt) && this.updatedAt == taskInfoCardEntity.updatedAt && p.d(this.resultJson, taskInfoCardEntity.resultJson) && p.d(this.extensionsJson, taskInfoCardEntity.extensionsJson) && p.d(this.subTasksJson, taskInfoCardEntity.subTasksJson) && p.d(this.answerJson, taskInfoCardEntity.answerJson) && this.isHidden == taskInfoCardEntity.isHidden && p.d(this.notificationDismissedStatus, taskInfoCardEntity.notificationDismissedStatus) && p.d(this.durationMs, taskInfoCardEntity.durationMs) && p.d(this.answeredQuestionTextsJson, taskInfoCardEntity.answeredQuestionTextsJson) && p.d(this.readAt, taskInfoCardEntity.readAt);
    }

    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    public final String getAnswerJson() {
        return this.answerJson;
    }

    public final String getAnsweredQuestionTextsJson() {
        return this.answeredQuestionTextsJson;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final Long getDurationMs() {
        return this.durationMs;
    }

    public final Long getEndedAt() {
        return this.endedAt;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final String getExtensionsJson() {
        return this.extensionsJson;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getIntention() {
        return this.intention;
    }

    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    public final String getNotificationDismissedStatus() {
        return this.notificationDismissedStatus;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final String getPendingQuestionsJson() {
        return this.pendingQuestionsJson;
    }

    public final String getProgressJson() {
        return this.progressJson;
    }

    public final Long getReadAt() {
        return this.readAt;
    }

    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    public final String getResultJson() {
        return this.resultJson;
    }

    public final Long getSeq() {
        return this.seq;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final Long getStartedAt() {
        return this.startedAt;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSubTaskIdsJson() {
        return this.subTaskIdsJson;
    }

    public final String getSubTasksJson() {
        return this.subTasksJson;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskVersion() {
        return this.taskVersion;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getTs() {
        return this.ts;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final String getVersionId() {
        return this.versionId;
    }

    public int hashCode() {
        int iHashCode = ((((this.taskId.hashCode() * 31) + this.uid.hashCode()) * 31) + this.eventType.hashCode()) * 31;
        Long l10 = this.seq;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.ts;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str = this.sessionKey;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.parentTaskId;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subTaskIdsJson;
        int iHashCode6 = (((iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.type.hashCode()) * 31;
        Integer num = this.version;
        int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.versionId;
        int iHashCode8 = (((((((((iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.taskVersion)) * 31) + Integer.hashCode(this.activeTaskVersion)) * 31) + Boolean.hashCode(this.noTaskDetail)) * 31) + this.status.hashCode()) * 31;
        String str5 = this.title;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.subTitle;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.iconUrl;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.progressJson;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.summary;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.requestSessionKey;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.pendingQuestionsJson;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.intention;
        int iHashCode16 = (((iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31;
        Long l12 = this.startedAt;
        int iHashCode17 = (iHashCode16 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.endedAt;
        int iHashCode18 = (((iHashCode17 + (l13 == null ? 0 : l13.hashCode())) * 31) + Long.hashCode(this.updatedAt)) * 31;
        String str13 = this.resultJson;
        int iHashCode19 = (iHashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.extensionsJson;
        int iHashCode20 = (iHashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.subTasksJson;
        int iHashCode21 = (iHashCode20 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.answerJson;
        int iHashCode22 = (((iHashCode21 + (str16 == null ? 0 : str16.hashCode())) * 31) + Boolean.hashCode(this.isHidden)) * 31;
        String str17 = this.notificationDismissedStatus;
        int iHashCode23 = (iHashCode22 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Long l14 = this.durationMs;
        int iHashCode24 = (iHashCode23 + (l14 == null ? 0 : l14.hashCode())) * 31;
        String str18 = this.answeredQuestionTextsJson;
        int iHashCode25 = (iHashCode24 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Long l15 = this.readAt;
        return iHashCode25 + (l15 != null ? l15.hashCode() : 0);
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public String toString() {
        return "TaskInfoCardEntity(taskId=" + this.taskId + ", uid=" + this.uid + ", eventType=" + this.eventType + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ", parentTaskId=" + this.parentTaskId + ", subTaskIdsJson=" + this.subTaskIdsJson + ", type=" + this.type + ", version=" + this.version + ", versionId=" + this.versionId + ", taskVersion=" + this.taskVersion + ", activeTaskVersion=" + this.activeTaskVersion + ", noTaskDetail=" + this.noTaskDetail + ", status=" + this.status + ", title=" + this.title + ", subTitle=" + this.subTitle + ", iconUrl=" + this.iconUrl + ", progressJson=" + this.progressJson + ", summary=" + this.summary + ", requestSessionKey=" + this.requestSessionKey + ", pendingQuestionsJson=" + this.pendingQuestionsJson + ", intention=" + this.intention + ", createdAt=" + this.createdAt + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", updatedAt=" + this.updatedAt + ", resultJson=" + this.resultJson + ", extensionsJson=" + this.extensionsJson + ", subTasksJson=" + this.subTasksJson + ", answerJson=" + this.answerJson + ", isHidden=" + this.isHidden + ", notificationDismissedStatus=" + this.notificationDismissedStatus + ", durationMs=" + this.durationMs + ", answeredQuestionTextsJson=" + this.answeredQuestionTextsJson + ", readAt=" + this.readAt + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ TaskInfoCardEntity(java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.Long r45, java.lang.Long r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.Integer r51, java.lang.String r52, int r53, int r54, boolean r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, java.lang.String r63, java.lang.String r64, long r65, java.lang.Long r67, java.lang.Long r68, long r69, java.lang.String r71, java.lang.String r72, java.lang.String r73, java.lang.String r74, boolean r75, java.lang.String r76, java.lang.Long r77, java.lang.String r78, java.lang.Long r79, int r80, int r81, kotlin.jvm.internal.i r82) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, int, int, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.Long, java.lang.Long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.Long, java.lang.String, java.lang.Long, int, int, kotlin.jvm.internal.i):void");
    }
}

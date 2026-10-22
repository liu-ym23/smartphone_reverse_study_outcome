package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B§\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\u0018\b\u0002\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#¢\u0006\u0004\b$\u0010%J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u000bHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000fHÆ\u0003J\t\u0010Y\u001a\u00020\u0018HÆ\u0003J\t\u0010Z\u001a\u00020\u0018HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010]\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0002\u0010AJ\t\u0010^\u001a\u00020\u001dHÆ\u0003J\t\u0010_\u001a\u00020\u001dHÆ\u0003J\t\u0010`\u001a\u00020!HÆ\u0003J\u0019\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#HÆ\u0003J¼\u0002\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020!2\u0018\b\u0002\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#HÆ\u0001¢\u0006\u0002\u0010cJ\u0013\u0010d\u001a\u00020!2\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\u001dHÖ\u0001J\t\u0010g\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010'R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010:R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010>\u001a\u0004\b?\u0010=R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0011\u0010\u001e\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u001f\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bE\u0010DR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR!\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bH\u0010I¨\u0006h"}, d2 = {"Lcom/stepos/agentbus/generated/Task;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "", "parentTaskId", "sessionKey", "requestSessionKey", "title", "subTitle", "type", "status", "Lcom/stepos/agentbus/generated/TaskStatus;", "progress", "Lcom/stepos/agentbus/generated/TaskProgress;", "artifacts", "", "Lcom/stepos/agentbus/generated/TaskArtifact;", "summary", "pendingQuestions", "Lcom/stepos/agentbus/generated/Question;", "intention", "subTaskIds", "subTasks", "createdAt", "", "updatedAt", "startedAt", "endedAt", "version", "", "taskVersion", "activeTaskVersion", "noTaskDetail", "", "extensions", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentbus/generated/TaskStatus;Lcom/stepos/agentbus/generated/TaskProgress;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;IIZLjava/util/Map;)V", "getTaskId", "()Ljava/lang/String;", "getParentTaskId", "getSessionKey", "getRequestSessionKey", "getTitle", "getSubTitle", "getType", "getStatus", "()Lcom/stepos/agentbus/generated/TaskStatus;", "getProgress", "()Lcom/stepos/agentbus/generated/TaskProgress;", "getArtifacts", "()Ljava/util/List;", "getSummary", "getPendingQuestions", "getIntention", "getSubTaskIds", "getSubTasks", "getCreatedAt", "()J", "getUpdatedAt", "getStartedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndedAt", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTaskVersion", "()I", "getActiveTaskVersion", "getNoTaskDetail", "()Z", "getExtensions", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentbus/generated/TaskStatus;Lcom/stepos/agentbus/generated/TaskProgress;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;IIZLjava/util/Map;)Lcom/stepos/agentbus/generated/Task;", "equals", "other", "hashCode", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Task {
    private final int activeTaskVersion;
    private final List<TaskArtifact> artifacts;
    private final long createdAt;
    private final Long endedAt;
    private final Map<String, Object> extensions;
    private final String intention;
    private final boolean noTaskDetail;
    private final String parentTaskId;
    private final List<Question> pendingQuestions;
    private final TaskProgress progress;
    private final String requestSessionKey;
    private final String sessionKey;
    private final Long startedAt;
    private final TaskStatus status;
    private final List<String> subTaskIds;
    private final List<Task> subTasks;
    private final String subTitle;
    private final String summary;
    private final String taskId;
    private final int taskVersion;
    private final String title;
    private final String type;
    private final long updatedAt;
    private final Integer version;

    public Task(String str, String str2, String str3, String str4, String str5, String str6, String str7, TaskStatus taskStatus, TaskProgress taskProgress, List list, String str8, List list2, String str9, List list3, List list4, long j5, long j6, Long l, Long l5, Integer num, int i, int i6, boolean z10, Map map, int i10, e eVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, str5, str6, str7, taskStatus, (i10 & 256) != 0 ? null : taskProgress, (i10 & 512) != 0 ? EmptyList.f4893a : list, (i10 & 1024) != 0 ? null : str8, (i10 & 2048) != 0 ? null : list2, (i10 & 4096) != 0 ? null : str9, (i10 & 8192) != 0 ? EmptyList.f4893a : list3, (i10 & 16384) != 0 ? null : list4, j5, j6, (131072 & i10) != 0 ? null : l, (262144 & i10) != 0 ? null : l5, (524288 & i10) != 0 ? null : num, (1048576 & i10) != 0 ? 0 : i, (2097152 & i10) != 0 ? 0 : i6, (4194304 & i10) != 0 ? false : z10, (i10 & 8388608) != 0 ? null : map);
    }

    public static /* synthetic */ Task copy$default(Task task, String str, String str2, String str3, String str4, String str5, String str6, String str7, TaskStatus taskStatus, TaskProgress taskProgress, List list, String str8, List list2, String str9, List list3, List list4, long j5, long j6, Long l, Long l5, Integer num, int i, int i6, boolean z10, Map map, int i10, Object obj) {
        Map map2;
        boolean z11;
        String str10 = (i10 & 1) != 0 ? task.taskId : str;
        String str11 = (i10 & 2) != 0 ? task.parentTaskId : str2;
        String str12 = (i10 & 4) != 0 ? task.sessionKey : str3;
        String str13 = (i10 & 8) != 0 ? task.requestSessionKey : str4;
        String str14 = (i10 & 16) != 0 ? task.title : str5;
        String str15 = (i10 & 32) != 0 ? task.subTitle : str6;
        String str16 = (i10 & 64) != 0 ? task.type : str7;
        TaskStatus taskStatus2 = (i10 & 128) != 0 ? task.status : taskStatus;
        TaskProgress taskProgress2 = (i10 & 256) != 0 ? task.progress : taskProgress;
        List list5 = (i10 & 512) != 0 ? task.artifacts : list;
        String str17 = (i10 & 1024) != 0 ? task.summary : str8;
        List list6 = (i10 & 2048) != 0 ? task.pendingQuestions : list2;
        String str18 = (i10 & 4096) != 0 ? task.intention : str9;
        List list7 = (i10 & 8192) != 0 ? task.subTaskIds : list3;
        String str19 = str10;
        List list8 = (i10 & 16384) != 0 ? task.subTasks : list4;
        long j10 = (i10 & 32768) != 0 ? task.createdAt : j5;
        long j11 = (i10 & 65536) != 0 ? task.updatedAt : j6;
        Long l9 = (i10 & 131072) != 0 ? task.startedAt : l;
        Long l10 = (i10 & 262144) != 0 ? task.endedAt : l5;
        Long l11 = l9;
        Integer num2 = (i10 & 524288) != 0 ? task.version : num;
        int i11 = (i10 & 1048576) != 0 ? task.taskVersion : i;
        int i12 = (i10 & 2097152) != 0 ? task.activeTaskVersion : i6;
        boolean z12 = (i10 & 4194304) != 0 ? task.noTaskDetail : z10;
        if ((i10 & 8388608) != 0) {
            z11 = z12;
            map2 = task.extensions;
        } else {
            map2 = map;
            z11 = z12;
        }
        return task.copy(str19, str11, str12, str13, str14, str15, str16, taskStatus2, taskProgress2, list5, str17, list6, str18, list7, list8, j10, j11, l11, l10, num2, i11, i12, z11, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final List<TaskArtifact> component10() {
        return this.artifacts;
    }

    /* renamed from: component11, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    public final List<Question> component12() {
        return this.pendingQuestions;
    }

    /* renamed from: component13, reason: from getter */
    public final String getIntention() {
        return this.intention;
    }

    public final List<String> component14() {
        return this.subTaskIds;
    }

    public final List<Task> component15() {
        return this.subTasks;
    }

    /* renamed from: component16, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component17, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component18, reason: from getter */
    public final Long getStartedAt() {
        return this.startedAt;
    }

    /* renamed from: component19, reason: from getter */
    public final Long getEndedAt() {
        return this.endedAt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    /* renamed from: component20, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    /* renamed from: component21, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    /* renamed from: component22, reason: from getter */
    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    public final Map<String, Object> component24() {
        return this.extensions;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final TaskStatus getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
    public final TaskProgress getProgress() {
        return this.progress;
    }

    public final Task copy(String taskId, String parentTaskId, String sessionKey, String requestSessionKey, String title, String subTitle, String type, TaskStatus status, TaskProgress progress, List<TaskArtifact> artifacts, String summary, List<Question> pendingQuestions, String intention, List<String> subTaskIds, List<Task> subTasks, long createdAt, long updatedAt, Long startedAt, Long endedAt, Integer version, int taskVersion, int activeTaskVersion, boolean noTaskDetail, Map<String, ? extends Object> extensions) {
        k.f(taskId, "taskId");
        k.f(title, "title");
        k.f(subTitle, "subTitle");
        k.f(type, "type");
        k.f(status, "status");
        k.f(artifacts, "artifacts");
        k.f(subTaskIds, "subTaskIds");
        return new Task(taskId, parentTaskId, sessionKey, requestSessionKey, title, subTitle, type, status, progress, artifacts, summary, pendingQuestions, intention, subTaskIds, subTasks, createdAt, updatedAt, startedAt, endedAt, version, taskVersion, activeTaskVersion, noTaskDetail, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Task)) {
            return false;
        }
        Task task = (Task) other;
        return k.b(this.taskId, task.taskId) && k.b(this.parentTaskId, task.parentTaskId) && k.b(this.sessionKey, task.sessionKey) && k.b(this.requestSessionKey, task.requestSessionKey) && k.b(this.title, task.title) && k.b(this.subTitle, task.subTitle) && k.b(this.type, task.type) && this.status == task.status && k.b(this.progress, task.progress) && k.b(this.artifacts, task.artifacts) && k.b(this.summary, task.summary) && k.b(this.pendingQuestions, task.pendingQuestions) && k.b(this.intention, task.intention) && k.b(this.subTaskIds, task.subTaskIds) && k.b(this.subTasks, task.subTasks) && this.createdAt == task.createdAt && this.updatedAt == task.updatedAt && k.b(this.startedAt, task.startedAt) && k.b(this.endedAt, task.endedAt) && k.b(this.version, task.version) && this.taskVersion == task.taskVersion && this.activeTaskVersion == task.activeTaskVersion && this.noTaskDetail == task.noTaskDetail && k.b(this.extensions, task.extensions);
    }

    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    public final List<TaskArtifact> getArtifacts() {
        return this.artifacts;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final Long getEndedAt() {
        return this.endedAt;
    }

    public final Map<String, Object> getExtensions() {
        return this.extensions;
    }

    public final String getIntention() {
        return this.intention;
    }

    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final List<Question> getPendingQuestions() {
        return this.pendingQuestions;
    }

    public final TaskProgress getProgress() {
        return this.progress;
    }

    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final Long getStartedAt() {
        return this.startedAt;
    }

    public final TaskStatus getStatus() {
        return this.status;
    }

    public final List<String> getSubTaskIds() {
        return this.subTaskIds;
    }

    public final List<Task> getSubTasks() {
        return this.subTasks;
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

    public final String getType() {
        return this.type;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.parentTaskId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionKey;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestSessionKey;
        int iHashCode4 = (this.status.hashCode() + B7.a.c(B7.a.c(B7.a.c((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31, 31, this.title), 31, this.subTitle), 31, this.type)) * 31;
        TaskProgress taskProgress = this.progress;
        int iE = androidx.appfunctions.metadata.a.e(this.artifacts, (iHashCode4 + (taskProgress == null ? 0 : taskProgress.hashCode())) * 31, 31);
        String str4 = this.summary;
        int iHashCode5 = (iE + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<Question> list = this.pendingQuestions;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.intention;
        int iE2 = androidx.appfunctions.metadata.a.e(this.subTaskIds, (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31, 31);
        List<Task> list2 = this.subTasks;
        int iC = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((iE2 + (list2 == null ? 0 : list2.hashCode())) * 31, 31, this.createdAt), 31, this.updatedAt);
        Long l = this.startedAt;
        int iHashCode7 = (iC + (l == null ? 0 : l.hashCode())) * 31;
        Long l5 = this.endedAt;
        int iHashCode8 = (iHashCode7 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Integer num = this.version;
        int iD = androidx.appfunctions.metadata.a.d(androidx.constraintlayout.core.dsl.a.a(this.activeTaskVersion, androidx.constraintlayout.core.dsl.a.a(this.taskVersion, (iHashCode8 + (num == null ? 0 : num.hashCode())) * 31, 31), 31), 31, this.noTaskDetail);
        Map<String, Object> map = this.extensions;
        return iD + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.parentTaskId;
        String str3 = this.sessionKey;
        String str4 = this.requestSessionKey;
        String str5 = this.title;
        String str6 = this.subTitle;
        String str7 = this.type;
        TaskStatus taskStatus = this.status;
        TaskProgress taskProgress = this.progress;
        List<TaskArtifact> list = this.artifacts;
        String str8 = this.summary;
        List<Question> list2 = this.pendingQuestions;
        String str9 = this.intention;
        List<String> list3 = this.subTaskIds;
        List<Task> list4 = this.subTasks;
        long j5 = this.createdAt;
        long j6 = this.updatedAt;
        Long l = this.startedAt;
        Long l5 = this.endedAt;
        Integer num = this.version;
        int i = this.taskVersion;
        int i6 = this.activeTaskVersion;
        boolean z10 = this.noTaskDetail;
        Map<String, Object> map = this.extensions;
        StringBuilder sbW = B7.a.w("Task(taskId=", str, ", parentTaskId=", str2, ", sessionKey=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", requestSessionKey=", str4, ", title=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", subTitle=", str6, ", type=");
        sbW.append(str7);
        sbW.append(", status=");
        sbW.append(taskStatus);
        sbW.append(", progress=");
        sbW.append(taskProgress);
        sbW.append(", artifacts=");
        sbW.append(list);
        sbW.append(", summary=");
        sbW.append(str8);
        sbW.append(", pendingQuestions=");
        sbW.append(list2);
        sbW.append(", intention=");
        sbW.append(str9);
        sbW.append(", subTaskIds=");
        sbW.append(list3);
        sbW.append(", subTasks=");
        sbW.append(list4);
        sbW.append(", createdAt=");
        sbW.append(j5);
        androidx.compose.foundation.b.y(j6, ", updatedAt=", ", startedAt=", sbW);
        sbW.append(l);
        sbW.append(", endedAt=");
        sbW.append(l5);
        sbW.append(", version=");
        sbW.append(num);
        sbW.append(", taskVersion=");
        sbW.append(i);
        sbW.append(", activeTaskVersion=");
        sbW.append(i6);
        sbW.append(", noTaskDetail=");
        sbW.append(z10);
        sbW.append(", extensions=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public Task(String taskId, String str, String str2, String str3, String title, String subTitle, String type, TaskStatus status, TaskProgress taskProgress, List<TaskArtifact> artifacts, String str4, List<Question> list, String str5, List<String> subTaskIds, List<Task> list2, long j5, long j6, Long l, Long l5, Integer num, int i, int i6, boolean z10, Map<String, ? extends Object> map) {
        k.f(taskId, "taskId");
        k.f(title, "title");
        k.f(subTitle, "subTitle");
        k.f(type, "type");
        k.f(status, "status");
        k.f(artifacts, "artifacts");
        k.f(subTaskIds, "subTaskIds");
        this.taskId = taskId;
        this.parentTaskId = str;
        this.sessionKey = str2;
        this.requestSessionKey = str3;
        this.title = title;
        this.subTitle = subTitle;
        this.type = type;
        this.status = status;
        this.progress = taskProgress;
        this.artifacts = artifacts;
        this.summary = str4;
        this.pendingQuestions = list;
        this.intention = str5;
        this.subTaskIds = subTaskIds;
        this.subTasks = list2;
        this.createdAt = j5;
        this.updatedAt = j6;
        this.startedAt = l;
        this.endedAt = l5;
        this.version = num;
        this.taskVersion = i;
        this.activeTaskVersion = i6;
        this.noTaskDetail = z10;
        this.extensions = map;
    }
}

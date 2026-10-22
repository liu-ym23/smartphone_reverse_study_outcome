package com.stepos.ailauncher.foundation.task.entity;

import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.zyql.intenttaskmanager.bean.TaskError;
import com.zyql.intenttaskmanager.bean.TaskUIData;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0014HÆ\u0003J§\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u000bHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006@"}, d2 = {"Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "", "taskId", "", "parentTaskId", "conversationId", "requestedSessionKey", "name", "description", "coverUri", "status", "", "createTime", "", "updateTime", "appUI", "Lcom/zyql/intenttaskmanager/bean/TaskUIData;", "version", "toolCallId", "error", "Lcom/zyql/intenttaskmanager/bean/TaskError;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLcom/zyql/intenttaskmanager/bean/TaskUIData;ILjava/lang/String;Lcom/zyql/intenttaskmanager/bean/TaskError;)V", "getTaskId", "()Ljava/lang/String;", "getParentTaskId", "getConversationId", "getRequestedSessionKey", "getName", "getDescription", "getCoverUri", "getStatus", "()I", "setStatus", "(I)V", "getCreateTime", "()J", "getUpdateTime", "getAppUI", "()Lcom/zyql/intenttaskmanager/bean/TaskUIData;", "getVersion", "getToolCallId", "getError", "()Lcom/zyql/intenttaskmanager/bean/TaskError;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UiTask {
    private final TaskUIData appUI;
    private final String conversationId;
    private final String coverUri;
    private final long createTime;
    private final String description;
    private final TaskError error;
    private final String name;
    private final String parentTaskId;
    private final String requestedSessionKey;
    private int status;
    private final String taskId;
    private final String toolCallId;
    private final long updateTime;
    private final int version;

    public UiTask(String taskId, String str, String str2, String str3, String str4, String str5, String str6, int i10, long j10, long j11, TaskUIData taskUIData, int i11, String str7, TaskError taskError) {
        p.i(taskId, "taskId");
        this.taskId = taskId;
        this.parentTaskId = str;
        this.conversationId = str2;
        this.requestedSessionKey = str3;
        this.name = str4;
        this.description = str5;
        this.coverUri = str6;
        this.status = i10;
        this.createTime = j10;
        this.updateTime = j11;
        this.appUI = taskUIData;
        this.version = i11;
        this.toolCallId = str7;
        this.error = taskError;
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: component11, reason: from getter */
    public final TaskUIData getAppUI() {
        return this.appUI;
    }

    /* renamed from: component12, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component13, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component14, reason: from getter */
    public final TaskError getError() {
        return this.error;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRequestedSessionKey() {
        return this.requestedSessionKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCoverUri() {
        return this.coverUri;
    }

    /* renamed from: component8, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    public final UiTask copy(String taskId, String parentTaskId, String conversationId, String requestedSessionKey, String name, String description, String coverUri, int status, long createTime, long updateTime, TaskUIData appUI, int version, String toolCallId, TaskError error) {
        p.i(taskId, "taskId");
        return new UiTask(taskId, parentTaskId, conversationId, requestedSessionKey, name, description, coverUri, status, createTime, updateTime, appUI, version, toolCallId, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiTask)) {
            return false;
        }
        UiTask uiTask = (UiTask) other;
        return p.d(this.taskId, uiTask.taskId) && p.d(this.parentTaskId, uiTask.parentTaskId) && p.d(this.conversationId, uiTask.conversationId) && p.d(this.requestedSessionKey, uiTask.requestedSessionKey) && p.d(this.name, uiTask.name) && p.d(this.description, uiTask.description) && p.d(this.coverUri, uiTask.coverUri) && this.status == uiTask.status && this.createTime == uiTask.createTime && this.updateTime == uiTask.updateTime && p.d(this.appUI, uiTask.appUI) && this.version == uiTask.version && p.d(this.toolCallId, uiTask.toolCallId) && p.d(this.error, uiTask.error);
    }

    public final TaskUIData getAppUI() {
        return this.appUI;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCoverUri() {
        return this.coverUri;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final TaskError getError() {
        return this.error;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public final String getRequestedSessionKey() {
        return this.requestedSessionKey;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.parentTaskId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.conversationId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestedSessionKey;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.description;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.coverUri;
        int iHashCode7 = (((((((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + Integer.hashCode(this.status)) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.updateTime)) * 31;
        TaskUIData taskUIData = this.appUI;
        int iHashCode8 = (((iHashCode7 + (taskUIData == null ? 0 : taskUIData.hashCode())) * 31) + Integer.hashCode(this.version)) * 31;
        String str7 = this.toolCallId;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        TaskError taskError = this.error;
        return iHashCode9 + (taskError != null ? taskError.hashCode() : 0);
    }

    public final void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return "UiTask(taskId=" + this.taskId + ", parentTaskId=" + this.parentTaskId + ", conversationId=" + this.conversationId + ", requestedSessionKey=" + this.requestedSessionKey + ", name=" + this.name + ", description=" + this.description + ", coverUri=" + this.coverUri + ", status=" + this.status + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", appUI=" + this.appUI + ", version=" + this.version + ", toolCallId=" + this.toolCallId + ", error=" + this.error + ")";
    }

    public /* synthetic */ UiTask(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, long j10, long j11, TaskUIData taskUIData, int i11, String str8, TaskError taskError, int i12, i iVar) {
        this(str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? null : str3, (i12 & 8) != 0 ? null : str4, (i12 & 16) != 0 ? null : str5, (i12 & 32) != 0 ? null : str6, (i12 & 64) != 0 ? null : str7, (i12 & 128) != 0 ? 0 : i10, (i12 & 256) != 0 ? 0L : j10, (i12 & 512) == 0 ? j11 : 0L, (i12 & 1024) != 0 ? null : taskUIData, (i12 & 2048) == 0 ? i11 : 0, (i12 & 4096) != 0 ? null : str8, (i12 & b.THRESHOLD) != 0 ? null : taskError);
    }
}

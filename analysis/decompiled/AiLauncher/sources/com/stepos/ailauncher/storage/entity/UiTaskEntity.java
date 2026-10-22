package com.stepos.ailauncher.storage.entity;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\nHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/storage/entity/UiTaskEntity;", "", "taskId", "", "parentTaskId", "conversationId", "name", "description", "coverUri", "status", "", "appUIJson", "createTime", "", "updateTime", "version", "toolCallId", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JJILjava/lang/String;Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getParentTaskId", "getConversationId", "getName", "getDescription", "getCoverUri", "getStatus", "()I", "getAppUIJson", "getCreateTime", "()J", "getUpdateTime", "getVersion", "getToolCallId", "getError", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UiTaskEntity {
    private final String appUIJson;
    private final String conversationId;
    private final String coverUri;
    private final long createTime;
    private final String description;
    private final String error;
    private final String name;
    private final String parentTaskId;
    private final int status;
    private final String taskId;
    private final String toolCallId;
    private final long updateTime;
    private final int version;

    public UiTaskEntity(String taskId, String str, String str2, String str3, String str4, String str5, int i10, String str6, long j10, long j11, int i11, String str7, String str8) {
        p.i(taskId, "taskId");
        this.taskId = taskId;
        this.parentTaskId = str;
        this.conversationId = str2;
        this.name = str3;
        this.description = str4;
        this.coverUri = str5;
        this.status = i10;
        this.appUIJson = str6;
        this.createTime = j10;
        this.updateTime = j11;
        this.version = i11;
        this.toolCallId = str7;
        this.error = str8;
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
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component12, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component13, reason: from getter */
    public final String getError() {
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
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCoverUri() {
        return this.coverUri;
    }

    /* renamed from: component7, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getAppUIJson() {
        return this.appUIJson;
    }

    /* renamed from: component9, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    public final UiTaskEntity copy(String taskId, String parentTaskId, String conversationId, String name, String description, String coverUri, int status, String appUIJson, long createTime, long updateTime, int version, String toolCallId, String error) {
        p.i(taskId, "taskId");
        return new UiTaskEntity(taskId, parentTaskId, conversationId, name, description, coverUri, status, appUIJson, createTime, updateTime, version, toolCallId, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiTaskEntity)) {
            return false;
        }
        UiTaskEntity uiTaskEntity = (UiTaskEntity) other;
        return p.d(this.taskId, uiTaskEntity.taskId) && p.d(this.parentTaskId, uiTaskEntity.parentTaskId) && p.d(this.conversationId, uiTaskEntity.conversationId) && p.d(this.name, uiTaskEntity.name) && p.d(this.description, uiTaskEntity.description) && p.d(this.coverUri, uiTaskEntity.coverUri) && this.status == uiTaskEntity.status && p.d(this.appUIJson, uiTaskEntity.appUIJson) && this.createTime == uiTaskEntity.createTime && this.updateTime == uiTaskEntity.updateTime && this.version == uiTaskEntity.version && p.d(this.toolCallId, uiTaskEntity.toolCallId) && p.d(this.error, uiTaskEntity.error);
    }

    public final String getAppUIJson() {
        return this.appUIJson;
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

    public final String getError() {
        return this.error;
    }

    public final String getName() {
        return this.name;
    }

    public final String getParentTaskId() {
        return this.parentTaskId;
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
        String str3 = this.name;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.coverUri;
        int iHashCode6 = (((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.status)) * 31;
        String str6 = this.appUIJson;
        int iHashCode7 = (((((((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.updateTime)) * 31) + Integer.hashCode(this.version)) * 31;
        String str7 = this.toolCallId;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.error;
        return iHashCode8 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        return "UiTaskEntity(taskId=" + this.taskId + ", parentTaskId=" + this.parentTaskId + ", conversationId=" + this.conversationId + ", name=" + this.name + ", description=" + this.description + ", coverUri=" + this.coverUri + ", status=" + this.status + ", appUIJson=" + this.appUIJson + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", version=" + this.version + ", toolCallId=" + this.toolCallId + ", error=" + this.error + ")";
    }

    public /* synthetic */ UiTaskEntity(String str, String str2, String str3, String str4, String str5, String str6, int i10, String str7, long j10, long j11, int i11, String str8, String str9, int i12, i iVar) {
        this(str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? null : str3, (i12 & 8) != 0 ? null : str4, (i12 & 16) != 0 ? null : str5, (i12 & 32) != 0 ? null : str6, (i12 & 64) != 0 ? 0 : i10, (i12 & 128) != 0 ? null : str7, (i12 & 256) != 0 ? 0L : j10, (i12 & 512) == 0 ? j11 : 0L, (i12 & 1024) == 0 ? i11 : 0, (i12 & 2048) != 0 ? null : str8, (i12 & 4096) != 0 ? null : str9);
    }
}

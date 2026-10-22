package com.stepos.ailauncher.foundation.task.entity;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003Jw\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/foundation/task/entity/SourceTask;", "", "taskId", "", "conversationId", "name", "coverUri", "description", "reason", "sourcePackageName", "taskType", "", "triggerType", "needConfirm", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getTaskId", "()Ljava/lang/String;", "getConversationId", "getName", "getCoverUri", "getDescription", "getReason", "getSourcePackageName", "getTaskType", "()I", "getTriggerType", "getNeedConfirm", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SourceTask {
    private final String conversationId;
    private final String coverUri;
    private final String description;
    private final String name;
    private final boolean needConfirm;
    private final String reason;
    private final String sourcePackageName;
    private final String taskId;
    private final int taskType;
    private final int triggerType;

    public SourceTask(String taskId, String str, String str2, String str3, String str4, String str5, String sourcePackageName, int i10, int i11, boolean z10) {
        p.i(taskId, "taskId");
        p.i(sourcePackageName, "sourcePackageName");
        this.taskId = taskId;
        this.conversationId = str;
        this.name = str2;
        this.coverUri = str3;
        this.description = str4;
        this.reason = str5;
        this.sourcePackageName = sourcePackageName;
        this.taskType = i10;
        this.triggerType = i11;
        this.needConfirm = z10;
    }

    public static /* synthetic */ SourceTask copy$default(SourceTask sourceTask, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = sourceTask.taskId;
        }
        if ((i12 & 2) != 0) {
            str2 = sourceTask.conversationId;
        }
        if ((i12 & 4) != 0) {
            str3 = sourceTask.name;
        }
        if ((i12 & 8) != 0) {
            str4 = sourceTask.coverUri;
        }
        if ((i12 & 16) != 0) {
            str5 = sourceTask.description;
        }
        if ((i12 & 32) != 0) {
            str6 = sourceTask.reason;
        }
        if ((i12 & 64) != 0) {
            str7 = sourceTask.sourcePackageName;
        }
        if ((i12 & 128) != 0) {
            i10 = sourceTask.taskType;
        }
        if ((i12 & 256) != 0) {
            i11 = sourceTask.triggerType;
        }
        if ((i12 & 512) != 0) {
            z10 = sourceTask.needConfirm;
        }
        int i13 = i11;
        boolean z11 = z10;
        String str8 = str7;
        int i14 = i10;
        String str9 = str5;
        String str10 = str6;
        return sourceTask.copy(str, str2, str3, str4, str9, str10, str8, i14, i13, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCoverUri() {
        return this.coverUri;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTaskType() {
        return this.taskType;
    }

    /* renamed from: component9, reason: from getter */
    public final int getTriggerType() {
        return this.triggerType;
    }

    public final SourceTask copy(String taskId, String conversationId, String name, String coverUri, String description, String reason, String sourcePackageName, int taskType, int triggerType, boolean needConfirm) {
        p.i(taskId, "taskId");
        p.i(sourcePackageName, "sourcePackageName");
        return new SourceTask(taskId, conversationId, name, coverUri, description, reason, sourcePackageName, taskType, triggerType, needConfirm);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceTask)) {
            return false;
        }
        SourceTask sourceTask = (SourceTask) other;
        return p.d(this.taskId, sourceTask.taskId) && p.d(this.conversationId, sourceTask.conversationId) && p.d(this.name, sourceTask.name) && p.d(this.coverUri, sourceTask.coverUri) && p.d(this.description, sourceTask.description) && p.d(this.reason, sourceTask.reason) && p.d(this.sourcePackageName, sourceTask.sourcePackageName) && this.taskType == sourceTask.taskType && this.triggerType == sourceTask.triggerType && this.needConfirm == sourceTask.needConfirm;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getCoverUri() {
        return this.coverUri;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final int getTriggerType() {
        return this.triggerType;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.conversationId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.coverUri;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.reason;
        return ((((((((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.sourcePackageName.hashCode()) * 31) + Integer.hashCode(this.taskType)) * 31) + Integer.hashCode(this.triggerType)) * 31) + Boolean.hashCode(this.needConfirm);
    }

    public String toString() {
        return "SourceTask(taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", name=" + this.name + ", coverUri=" + this.coverUri + ", description=" + this.description + ", reason=" + this.reason + ", sourcePackageName=" + this.sourcePackageName + ", taskType=" + this.taskType + ", triggerType=" + this.triggerType + ", needConfirm=" + this.needConfirm + ")";
    }

    public /* synthetic */ SourceTask(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, int i11, boolean z10, int i12, i iVar) {
        this(str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? null : str3, (i12 & 8) != 0 ? null : str4, (i12 & 16) != 0 ? null : str5, (i12 & 32) != 0 ? null : str6, (i12 & 64) != 0 ? "" : str7, i10, (i12 & 256) != 0 ? 0 : i11, (i12 & 512) != 0 ? false : z10);
    }
}

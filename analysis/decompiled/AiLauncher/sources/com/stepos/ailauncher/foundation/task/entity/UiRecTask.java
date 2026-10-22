package com.stepos.ailauncher.foundation.task.entity;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u0081\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rHÆ\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000bHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001d¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/foundation/task/entity/UiRecTask;", "", "taskId", "", "conversationId", "name", "coverUri", "description", "reason", "sourcePackageName", "triggerType", "", "needConfirm", "", "isRead", "isTop", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZ)V", "getTaskId", "()Ljava/lang/String;", "getConversationId", "getName", "getCoverUri", "getDescription", "getReason", "getSourcePackageName", "getTriggerType", "()I", "getNeedConfirm", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UiRecTask {
    private final String conversationId;
    private final String coverUri;
    private final String description;
    private final boolean isRead;
    private final boolean isTop;
    private final String name;
    private final boolean needConfirm;
    private final String reason;
    private final String sourcePackageName;
    private final String taskId;
    private final int triggerType;

    public UiRecTask(String taskId, String str, String str2, String str3, String str4, String str5, String sourcePackageName, int i10, boolean z10, boolean z11, boolean z12) {
        p.i(taskId, "taskId");
        p.i(sourcePackageName, "sourcePackageName");
        this.taskId = taskId;
        this.conversationId = str;
        this.name = str2;
        this.coverUri = str3;
        this.description = str4;
        this.reason = str5;
        this.sourcePackageName = sourcePackageName;
        this.triggerType = i10;
        this.needConfirm = z10;
        this.isRead = z11;
        this.isTop = z12;
    }

    public static /* synthetic */ UiRecTask copy$default(UiRecTask uiRecTask, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, boolean z10, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = uiRecTask.taskId;
        }
        if ((i11 & 2) != 0) {
            str2 = uiRecTask.conversationId;
        }
        if ((i11 & 4) != 0) {
            str3 = uiRecTask.name;
        }
        if ((i11 & 8) != 0) {
            str4 = uiRecTask.coverUri;
        }
        if ((i11 & 16) != 0) {
            str5 = uiRecTask.description;
        }
        if ((i11 & 32) != 0) {
            str6 = uiRecTask.reason;
        }
        if ((i11 & 64) != 0) {
            str7 = uiRecTask.sourcePackageName;
        }
        if ((i11 & 128) != 0) {
            i10 = uiRecTask.triggerType;
        }
        if ((i11 & 256) != 0) {
            z10 = uiRecTask.needConfirm;
        }
        if ((i11 & 512) != 0) {
            z11 = uiRecTask.isRead;
        }
        if ((i11 & 1024) != 0) {
            z12 = uiRecTask.isTop;
        }
        boolean z13 = z11;
        boolean z14 = z12;
        int i12 = i10;
        boolean z15 = z10;
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return uiRecTask.copy(str, str2, str11, str4, str10, str8, str9, i12, z15, z13, z14);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
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
    public final int getTriggerType() {
        return this.triggerType;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final UiRecTask copy(String taskId, String conversationId, String name, String coverUri, String description, String reason, String sourcePackageName, int triggerType, boolean needConfirm, boolean isRead, boolean isTop) {
        p.i(taskId, "taskId");
        p.i(sourcePackageName, "sourcePackageName");
        return new UiRecTask(taskId, conversationId, name, coverUri, description, reason, sourcePackageName, triggerType, needConfirm, isRead, isTop);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiRecTask)) {
            return false;
        }
        UiRecTask uiRecTask = (UiRecTask) other;
        return p.d(this.taskId, uiRecTask.taskId) && p.d(this.conversationId, uiRecTask.conversationId) && p.d(this.name, uiRecTask.name) && p.d(this.coverUri, uiRecTask.coverUri) && p.d(this.description, uiRecTask.description) && p.d(this.reason, uiRecTask.reason) && p.d(this.sourcePackageName, uiRecTask.sourcePackageName) && this.triggerType == uiRecTask.triggerType && this.needConfirm == uiRecTask.needConfirm && this.isRead == uiRecTask.isRead && this.isTop == uiRecTask.isTop;
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
        return ((((((((((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.sourcePackageName.hashCode()) * 31) + Integer.hashCode(this.triggerType)) * 31) + Boolean.hashCode(this.needConfirm)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Boolean.hashCode(this.isTop);
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final boolean isTop() {
        return this.isTop;
    }

    public String toString() {
        return "UiRecTask(taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", name=" + this.name + ", coverUri=" + this.coverUri + ", description=" + this.description + ", reason=" + this.reason + ", sourcePackageName=" + this.sourcePackageName + ", triggerType=" + this.triggerType + ", needConfirm=" + this.needConfirm + ", isRead=" + this.isRead + ", isTop=" + this.isTop + ")";
    }

    public /* synthetic */ UiRecTask(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, boolean z10, boolean z11, boolean z12, int i11, i iVar) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? "" : str7, (i11 & 128) != 0 ? 0 : i10, (i11 & 256) != 0 ? false : z10, (i11 & 512) != 0 ? false : z11, (i11 & 1024) != 0 ? false : z12);
    }
}

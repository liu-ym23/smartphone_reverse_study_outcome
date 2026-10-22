package com.stepos.agentframework.chatcore.intent;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0019R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0019R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0019R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0019R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0019R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0019¨\u0006("}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/x;", "", "", "action", "taskId", "taskName", "fileId", "filePath", "message", "errorMessage", "result", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "setAction", "(Ljava/lang/String;)V", "e", "setTaskId", "f", "setTaskName", "getFileId", "setFileId", "c", "setFilePath", Const.INTENT_KEY_UMID, "setMessage", Const.INTENT_KEY_PKGNAME, "setErrorMessage", "getResult", "setResult", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.intent.x, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskRobotAction {
    private String action;
    private String errorMessage;
    private String fileId;
    private String filePath;
    private String message;
    private String result;
    private String taskId;
    private String taskName;

    public TaskRobotAction(String action, String taskId, String taskName, String str, String filePath, String str2, String str3, String str4) {
        kotlin.jvm.internal.p.i(action, "action");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(taskName, "taskName");
        kotlin.jvm.internal.p.i(filePath, "filePath");
        this.action = action;
        this.taskId = taskId;
        this.taskName = taskName;
        this.fileId = str;
        this.filePath = filePath;
        this.message = str2;
        this.errorMessage = str3;
        this.result = str4;
    }

    /* renamed from: a, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: c, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: d, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskRobotAction)) {
            return false;
        }
        TaskRobotAction taskRobotAction = (TaskRobotAction) other;
        return kotlin.jvm.internal.p.d(this.action, taskRobotAction.action) && kotlin.jvm.internal.p.d(this.taskId, taskRobotAction.taskId) && kotlin.jvm.internal.p.d(this.taskName, taskRobotAction.taskName) && kotlin.jvm.internal.p.d(this.fileId, taskRobotAction.fileId) && kotlin.jvm.internal.p.d(this.filePath, taskRobotAction.filePath) && kotlin.jvm.internal.p.d(this.message, taskRobotAction.message) && kotlin.jvm.internal.p.d(this.errorMessage, taskRobotAction.errorMessage) && kotlin.jvm.internal.p.d(this.result, taskRobotAction.result);
    }

    /* renamed from: f, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    public int hashCode() {
        int iHashCode = ((((this.action.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.taskName.hashCode()) * 31;
        String str = this.fileId;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.filePath.hashCode()) * 31;
        String str2 = this.message;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.errorMessage;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.result;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "TaskRobotAction(action=" + this.action + ", taskId=" + this.taskId + ", taskName=" + this.taskName + ", fileId=" + this.fileId + ", filePath=" + this.filePath + ", message=" + this.message + ", errorMessage=" + this.errorMessage + ", result=" + this.result + ")";
    }

    public /* synthetic */ TaskRobotAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? "" : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8);
    }
}

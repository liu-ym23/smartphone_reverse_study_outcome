package com.stepos.ailauncher.taskstore.chat;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.taskstore.entity.TaskInfoContentType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.widget.TaskMediumCardDecorationResolver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\b\u001a\u00020\u0004*\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\u000b\u001a\u00020\u0004*\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/H;", "", "sessionId", "taskId", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/chat/H;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "Lcom/stepos/ailauncher/taskstore/chat/E;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/chat/E;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final SessionArtifact a(TaskResultCodeItem taskResultCodeItem, String str, String str2) {
        kotlin.jvm.internal.p.i(taskResultCodeItem, "<this>");
        return new SessionArtifact(str2 == null ? "" : str2, u6.j.INSTANCE.b(str2 == null ? "" : str2, taskResultCodeItem.getTitle(), taskResultCodeItem.getFileName(), taskResultCodeItem.getMimeType(), taskResultCodeItem.getCloudPath(), 0L, (64 & 64) != 0 ? null : null), TaskMediumCardDecorationResolver.INSTANCE.n(taskResultCodeItem.getFileName(), taskResultCodeItem.getMimeType()), 0L, taskResultCodeItem.getFileId(), str, taskResultCodeItem.getCloudPath(), taskResultCodeItem.getMimeType(), taskResultCodeItem.getFileName(), taskResultCodeItem.getTitle(), taskResultCodeItem.getSize(), null, 2048, null);
    }

    public static final SessionArtifact b(TaskResultFileItem taskResultFileItem, String str, String str2) {
        kotlin.jvm.internal.p.i(taskResultFileItem, "<this>");
        return new SessionArtifact(str2 == null ? "" : str2, u6.j.INSTANCE.b(str2 == null ? "" : str2, taskResultFileItem.getTitle(), taskResultFileItem.getFileName(), taskResultFileItem.getMimeType(), taskResultFileItem.getCloudPath(), 0L, (64 & 64) != 0 ? null : null), TaskMediumCardDecorationResolver.INSTANCE.n(taskResultFileItem.getFileName(), taskResultFileItem.getMimeType()), 0L, taskResultFileItem.getFileId(), str, taskResultFileItem.getCloudPath(), taskResultFileItem.getMimeType(), taskResultFileItem.getFileName(), taskResultFileItem.getTitle(), taskResultFileItem.getSize(), null, 2048, null);
    }

    public static final SessionArtifact c(TaskInfoPart taskInfoPart, String str, String str2) {
        kotlin.jvm.internal.p.i(taskInfoPart, "<this>");
        String str3 = str2 == null ? "" : str2;
        String strC = u6.j.c(u6.j.INSTANCE, str2 == null ? "" : str2, taskInfoPart, 0L, null, 8, null);
        int iN = TaskMediumCardDecorationResolver.INSTANCE.n(taskInfoPart.getFileName(), taskInfoPart.getMimeType());
        String fileId = taskInfoPart.getFileId();
        String content = taskInfoPart.getContent();
        if (La.H.x0(content) || taskInfoPart.getContentType() == TaskInfoContentType.INLINE) {
            content = null;
        }
        return new SessionArtifact(str3, strC, iN, 0L, fileId, str, content, taskInfoPart.getMimeType(), taskInfoPart.getFileName(), taskInfoPart.getTitle(), taskInfoPart.getSize(), null, 2048, null);
    }
}

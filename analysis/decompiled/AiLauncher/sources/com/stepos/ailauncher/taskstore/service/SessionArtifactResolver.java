package com.stepos.ailauncher.taskstore.service;

import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.taskstore.widget.TaskMediumCardDecorationResolver;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import q4.TaskResultArtifact;
import u6.j;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\u0007*\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/service/SessionArtifactResolver;", "", "<init>", "()V", "", "", "sessionKeys", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "Lq4/b;", "c", "(Lq4/b;)Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "TAG", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionArtifactResolver {
    public static final SessionArtifactResolver INSTANCE = new SessionArtifactResolver();
    private static final String TAG = "SessionArtifactResolver";

    public final Object b(List<String> list, InterfaceC4014c<? super List<SessionArtifact>> interfaceC4014c) {
        return C1056g.j(Y.b(), new SessionArtifactResolver$resolveFromFramework$2(list, null), interfaceC4014c);
    }

    public final SessionArtifact c(TaskResultArtifact taskResultArtifact) {
        String taskId = taskResultArtifact.getTaskId();
        if (taskId == null) {
            taskId = "";
        }
        j jVar = j.INSTANCE;
        String taskId2 = taskResultArtifact.getTaskId();
        if (taskId2 == null) {
            taskId2 = "";
        }
        return new SessionArtifact(taskId, jVar.b(taskId2, taskResultArtifact.getTitle(), taskResultArtifact.getFileName(), taskResultArtifact.getMimeType(), taskResultArtifact.getCloudPath(), taskResultArtifact.getCreatedAt(), (64 & 64) != 0 ? null : null), TaskMediumCardDecorationResolver.INSTANCE.n(taskResultArtifact.getFileName(), taskResultArtifact.getMimeType()), taskResultArtifact.getCreatedAt(), taskResultArtifact.getFileId(), taskResultArtifact.getSessionId(), taskResultArtifact.getCloudPath(), taskResultArtifact.getMimeType(), taskResultArtifact.getFileName(), taskResultArtifact.getTitle(), taskResultArtifact.getSize(), null, 2048, null);
    }
}

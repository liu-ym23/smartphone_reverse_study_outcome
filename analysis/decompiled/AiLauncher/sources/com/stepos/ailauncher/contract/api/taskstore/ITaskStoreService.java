package com.stepos.ailauncher.contract.api.taskstore;

import Y8.t;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.contract.model.UnfinishedTaskInfo;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@¢\u0006\u0004\b\u0007\u0010\u0004J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH¦@¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH¦@¢\u0006\u0004\b\u000e\u0010\fJ\u001e\u0010\u0010\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H¦@¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H¦@¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H&¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H¦@¢\u0006\u0004\b\u0016\u0010\u0011J*\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H¦@¢\u0006\u0004\b\u001a\u0010\u0011¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/taskstore/ITaskStoreService;", "", "LY8/t;", "cleanAll", "(Le9/c;)Ljava/lang/Object;", "", "Lcom/stepos/ailauncher/contract/model/UnfinishedTaskInfo;", "getUnfinishedTasks", "", "taskId", "", "getTaskStatus", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "cancelTask", "sessionKeys", "deleteSessionTasks", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "forgetLocalSession", "releaseSessionDeletionGuard", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "getSessionArtifacts", "fileIds", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "queryArtifactAvailability", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ITaskStoreService {
    Object cancelTask(String str, InterfaceC4014c<? super Boolean> interfaceC4014c);

    Object cleanAll(InterfaceC4014c<? super t> interfaceC4014c);

    Object deleteSessionTasks(List<String> list, InterfaceC4014c<? super Boolean> interfaceC4014c);

    Object forgetLocalSession(List<String> list, InterfaceC4014c<? super t> interfaceC4014c);

    Object getSessionArtifacts(List<String> list, InterfaceC4014c<? super List<SessionArtifact>> interfaceC4014c);

    Object getTaskStatus(String str, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object getUnfinishedTasks(InterfaceC4014c<? super List<UnfinishedTaskInfo>> interfaceC4014c);

    Object queryArtifactAvailability(List<String> list, InterfaceC4014c<? super Map<String, ? extends ArtifactAvailability>> interfaceC4014c);

    void releaseSessionDeletionGuard(List<String> sessionKeys);
}

package com.stepos.agentframework.chatcore.search;

import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b\n\u0010\tJ\u001e\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0086@¢\u0006\u0004\b\r\u0010\tJ\"\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatcore/search/TaskSearchSnapshotStore;", "", "<init>", "()V", "", "Lcom/stepos/agentframework/chatcore/search/o;", "records", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_UMID, "", "taskIds", Const.INTENT_KEY_APIKEY, "query", "limit", "Lcom/stepos/agentframework/chatcore/search/p;", "c", "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "MAX_RESULTS", "I", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskSearchSnapshotStore {
    public static final TaskSearchSnapshotStore INSTANCE = new TaskSearchSnapshotStore();
    private static final int MAX_RESULTS = 50;
    private static final String TAG = "TaskSearch";

    public final Object a(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskSearchSnapshotStore$delete$2(list, null), interfaceC4014c);
    }

    public final Object b(List<TaskSearchRecord> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskSearchSnapshotStore$replaceCurrentAccount$2(list, null), interfaceC4014c);
    }

    public final Object c(String str, int i10, InterfaceC4014c<? super TaskSearchSnapshot> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskSearchSnapshotStore$searchKeyword$2(str, i10, null), interfaceC4014c);
    }

    public final Object d(List<TaskSearchRecord> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskSearchSnapshotStore$upsert$2(list, null), interfaceC4014c);
    }
}

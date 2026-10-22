package com.stepos.agentframework.chatcore.search;

import La.H;
import Ua.M;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.db.Q;
import com.stepos.agentframework.chatcore.session.list.SessionAgentCategory;
import com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import v9.C5685n;
import w4.C5732a;
import w4.TaskSearchDocumentEntity;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatcore/search/p;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatcore/search/p;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.search.TaskSearchSnapshotStore$searchKeyword$2", f = "TaskSearchSnapshotStore.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class TaskSearchSnapshotStore$searchKeyword$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super TaskSearchSnapshot>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ String $query;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskSearchSnapshotStore$searchKeyword$2(String str, int i10, InterfaceC4014c<? super TaskSearchSnapshotStore$searchKeyword$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$query = str;
        this.$limit = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TaskSearchSnapshotStore$searchKeyword$2(this.$query, this.$limit, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super TaskSearchSnapshot> interfaceC4014c) {
        return ((TaskSearchSnapshotStore$searchKeyword$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Map<String, String> mapI;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        String string = H.D1(this.$query).toString();
        if (string.length() == 0) {
            return new TaskSearchSnapshot(null, 1, null);
        }
        int iN = C5685n.n(this.$limit, 1, 50);
        FwkDatabase.Companion companion = FwkDatabase.INSTANCE;
        if (!companion.B()) {
            C4148a.u("TaskSearch", "search skipped: uid not ready", false, 4, null);
            return new TaskSearchSnapshot(null, 1, null);
        }
        try {
            FwkDatabase fwkDatabaseN = companion.n();
            List<TaskSearchDocumentEntity> listH = fwkDatabaseN.q0().h(string, q.e(string), q.d(string), iN);
            if (listH.isEmpty()) {
                return new TaskSearchSnapshot(null, 1, null);
            }
            Q qI0 = fwkDatabaseN.i0();
            List<TaskSearchDocumentEntity> list = listH;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((TaskSearchDocumentEntity) it.next()).getSessionId());
            }
            Map<String, w4.e> mapC = q.c(qI0.u(F.g0(arrayList)));
            Collection<w4.e> collectionValues = mapC.values();
            ArrayList arrayList2 = new ArrayList(C1174w.x(collectionValues, 10));
            Iterator<T> it2 = collectionValues.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((w4.e) it2.next()).getAgentId());
            }
            Set<String> setD = SessionListSnapshotStoreKt.d(arrayList2);
            if (setD.isEmpty()) {
                mapI = kotlin.collections.a.i();
            } else {
                List<C5732a> listB = fwkDatabaseN.h0().b(F.m1(setD));
                LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Z8.Q.e(C1174w.x(listB, 10)), 16));
                for (C5732a c5732a : listB) {
                    Pair pairA = Y8.j.a(c5732a.getAgentId(), c5732a.getAgentName());
                    linkedHashMap.put(pairA.e(), pairA.f());
                }
                mapI = SessionListSnapshotStoreKt.i(linkedHashMap);
            }
            List<TaskSearchDocumentEntity> list2 = listH;
            ArrayList arrayList3 = new ArrayList(C1174w.x(list2, 10));
            for (TaskSearchDocumentEntity taskSearchDocumentEntity : list2) {
                w4.e eVar = mapC.get(taskSearchDocumentEntity.getSessionId());
                String agentId = eVar != null ? eVar.getAgentId() : null;
                String str = "";
                if (agentId == null) {
                    agentId = "";
                }
                String strJ = SessionListSnapshotStoreKt.j(agentId);
                String deviceId = eVar != null ? eVar.getDeviceId() : null;
                if (deviceId != null) {
                    str = deviceId;
                }
                String strK = SessionListSnapshotStoreKt.k(str);
                SessionAgentCategory sessionAgentCategoryO = SessionListSnapshotStoreKt.o(strJ);
                arrayList3.add(q.g(taskSearchDocumentEntity, string, strJ, strK, SessionListSnapshotStoreKt.n(strJ, mapI.get(strJ), sessionAgentCategoryO == SessionAgentCategory.EXTERNAL), sessionAgentCategoryO));
            }
            return new TaskSearchSnapshot(arrayList3);
        } catch (IllegalStateException unused) {
            C4148a.u("TaskSearch", "search skipped: account database is unavailable", false, 4, null);
            return new TaskSearchSnapshot(null, 1, null);
        } catch (Throwable th) {
            C4148a.h("TaskSearch", "search failed: " + th.getClass().getSimpleName(), false, 4, null);
            return new TaskSearchSnapshot(null, 1, null);
        }
    }
}

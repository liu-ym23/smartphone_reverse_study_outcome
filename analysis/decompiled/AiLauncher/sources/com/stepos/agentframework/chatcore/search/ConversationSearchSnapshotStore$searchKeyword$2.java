package com.stepos.agentframework.chatcore.search;

import Ka.t;
import La.H;
import Ua.M;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStoreKt;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5685n;
import w4.C5732a;
import w4.MessageSearchProjectionEntity;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatcore/search/a;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatcore/search/a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore$searchKeyword$2", f = "ConversationSearchSnapshotStore.kt", l = {61}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ConversationSearchSnapshotStore$searchKeyword$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super ConversationSearchSnapshot>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ String $query;
    int I$0;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationSearchSnapshotStore$searchKeyword$2(String str, int i10, InterfaceC4014c<? super ConversationSearchSnapshotStore$searchKeyword$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$query = str;
        this.$limit = i10;
    }

    public static final Ka.j i(MessageSearchProjectionEntity messageSearchProjectionEntity) {
        return t.w(messageSearchProjectionEntity.getSessionId(), SessionListSnapshotStoreKt.l(messageSearchProjectionEntity.getSessionId()));
    }

    public static final boolean n(w4.e eVar) {
        return eVar.getIsTempSession() || eVar.p();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ConversationSearchSnapshotStore$searchKeyword$2(this.$query, this.$limit, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super ConversationSearchSnapshot> interfaceC4014c) {
        return ((ConversationSearchSnapshotStore$searchKeyword$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10;
        String str;
        int i11;
        Map<String, String> mapI;
        Object objG = C4063a.g();
        int i12 = this.label;
        int i13 = 3;
        try {
            try {
                if (i12 == 0) {
                    C4849c.b(obj);
                    String string = H.D1(this.$query).toString();
                    if (string.length() == 0) {
                        return new ConversationSearchSnapshot(null, null, 3, null);
                    }
                    int iN = C5685n.n(this.$limit, 1, 50);
                    if (!FwkDatabase.INSTANCE.B()) {
                        C4148a.u("ConversationSearch", "search skipped: uid not ready", false, 4, null);
                        return new ConversationSearchSnapshot(null, null, 3, null);
                    }
                    ConversationSearchSnapshotStore conversationSearchSnapshotStore = ConversationSearchSnapshotStore.INSTANCE;
                    this.L$0 = string;
                    this.I$0 = iN;
                    this.label = 1;
                    if (conversationSearchSnapshotStore.f(this) == objG) {
                        return objG;
                    }
                    str = string;
                    i11 = iN;
                } else {
                    if (i12 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i11 = this.I$0;
                    str = (String) this.L$0;
                    C4849c.b(obj);
                }
                FwkDatabase fwkDatabaseN = FwkDatabase.INSTANCE.n();
                String strM = MessageSearchProjectionKt.m(str);
                int iJ = C5685n.j(i11 * 4, 200);
                List<w4.e> listE = fwkDatabaseN.i0().e(strM, iJ);
                List<MessageSearchProjectionEntity> listG = fwkDatabaseN.l0().g(strM, iJ);
                LinkedHashSet linkedHashSet = (LinkedHashSet) SequencesKt___SequencesKt.b0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.L(F.d0(listG), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.e
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return ConversationSearchSnapshotStore$searchKeyword$2.i((MessageSearchProjectionEntity) obj2);
                    }
                }), ConversationSearchSnapshotStore$searchKeyword$2$messageSessionIds$2.INSTANCE), new LinkedHashSet());
                Map<String, w4.e> mapC = q.c(SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.G(F.d0(F.S0(listE, linkedHashSet.isEmpty() ? C1173v.m() : fwkDatabaseN.i0().u(F.m1(linkedHashSet)))), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.f
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj2) {
                        return Boolean.valueOf(ConversationSearchSnapshotStore$searchKeyword$2.n((w4.e) obj2));
                    }
                })));
                List listM1 = F.m1(mapC.values());
                List list = listM1;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((w4.e) it.next()).getAgentId());
                }
                Set<String> setD = SessionListSnapshotStoreKt.d(arrayList);
                if (setD.isEmpty()) {
                    mapI = kotlin.collections.a.i();
                } else {
                    List<C5732a> listB = fwkDatabaseN.h0().b(F.m1(setD));
                    LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(listB, 10)), 16));
                    for (C5732a c5732a : listB) {
                        Pair pairA = Y8.j.a(c5732a.getAgentId(), c5732a.getAgentName());
                        linkedHashMap.put(pairA.e(), pairA.f());
                    }
                    mapI = SessionListSnapshotStoreKt.i(linkedHashMap);
                }
                ConversationSearchSnapshotStore conversationSearchSnapshotStore2 = ConversationSearchSnapshotStore.INSTANCE;
                List<w4.e> list2 = listM1;
                ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                for (w4.e eVar : list2) {
                    try {
                        arrayList2.add(ConversationSearchSnapshotStoreKt.h(eVar, mapI.get(SessionListSnapshotStoreKt.j(eVar.getAgentId()))));
                        i13 = 3;
                    } catch (IllegalStateException unused) {
                        i10 = 3;
                        C4148a.u("ConversationSearch", "search skipped: account database is unavailable", false, 4, null);
                        return new ConversationSearchSnapshot(null, null, i10, null);
                    }
                }
                List<MessageSearchProjectionEntity> list3 = listG;
                ArrayList arrayList3 = new ArrayList(C1174w.x(list3, 10));
                Iterator<T> it2 = list3.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(ConversationSearchSnapshotStoreKt.g((MessageSearchProjectionEntity) it2.next()));
                }
                return conversationSearchSnapshotStore2.h(ConversationSearchSnapshotStoreKt.e(str, i11, arrayList2, arrayList3), fwkDatabaseN, mapC);
            } catch (IllegalStateException unused2) {
                i10 = i13;
            }
        } catch (Throwable th) {
            C4148a.h("ConversationSearch", "search failed: " + th.getClass().getSimpleName(), false, 4, null);
            return new ConversationSearchSnapshot(null, null, 3, null);
        }
    }
}

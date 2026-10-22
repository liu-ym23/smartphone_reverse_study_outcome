package com.stepos.agentframework.chatcore.session.list;

import Ua.M;
import Y8.t;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.db.W0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import p9.p;
import v9.C5685n;
import w4.C5732a;
import w4.SessionPendingActionEntity;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatcore/session/list/c;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatcore/session/list/c;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStore$findAll$2", f = "SessionListSnapshotStore.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionListSnapshotStore$findAll$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super SessionListSnapshot>, Object> {
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStore$findAll$2$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<SessionPendingActionEntity, Boolean> {
        public AnonymousClass1(Object obj) {
            super(1, obj, List.class, "contains", "contains(Ljava/lang/Object;)Z", 0);
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(SessionPendingActionEntity p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            return Boolean.valueOf(((List) this.receiver).contains(p02));
        }
    }

    public SessionListSnapshotStore$findAll$2(InterfaceC4014c<? super SessionListSnapshotStore$findAll$2> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionListSnapshotStore$findAll$2(interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super SessionListSnapshot> interfaceC4014c) {
        return ((SessionListSnapshotStore$findAll$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10;
        Map<String, String> mapI;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        FwkDatabase.Companion companion = FwkDatabase.INSTANCE;
        int i11 = 1;
        if (!companion.B()) {
            C4148a.u("SessionList", "findAll skipped: uid not ready", false, 4, null);
            return new SessionListSnapshot(null, 1, null);
        }
        try {
            try {
                FwkDatabase fwkDatabaseN = companion.n();
                List<w4.e> listV = fwkDatabaseN.i0().v();
                List<w4.e> list = listV;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
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
                long jCurrentTimeMillis = System.currentTimeMillis();
                W0 w0O0 = fwkDatabaseN.o0();
                List<SessionPendingActionEntity> all = w0O0.getAll();
                ArrayList<SessionPendingActionEntity> arrayList2 = new ArrayList();
                for (Object obj2 : all) {
                    SessionPendingActionEntity sessionPendingActionEntity = (SessionPendingActionEntity) obj2;
                    try {
                        if (i.a(sessionPendingActionEntity.getExpiresAt(), jCurrentTimeMillis, SessionPendingActionStore.INSTANCE.a(sessionPendingActionEntity.getRequestId()))) {
                            arrayList2.add(obj2);
                        }
                        i11 = 1;
                    } catch (IllegalStateException unused) {
                        i10 = 1;
                        C4148a.u("SessionList", "findAll skipped: account database is unavailable", false, 4, null);
                        return new SessionListSnapshot(null, i10, null);
                    }
                }
                Iterator it2 = SequencesKt___SequencesKt.G(F.d0(all), new AnonymousClass1(arrayList2)).iterator();
                while (it2.hasNext()) {
                    w0O0.e(((SessionPendingActionEntity) it2.next()).getRequestId());
                }
                ArrayList arrayList3 = new ArrayList();
                for (SessionPendingActionEntity sessionPendingActionEntity2 : arrayList2) {
                    SessionPendingActionKind sessionPendingActionKindA = SessionPendingActionKind.INSTANCE.a(sessionPendingActionEntity2.getActionKind());
                    SessionPendingAction sessionPendingAction = sessionPendingActionKindA == null ? null : new SessionPendingAction(sessionPendingActionEntity2.getRequestId(), sessionPendingActionEntity2.getSessionId(), sessionPendingActionEntity2.getAgentId(), sessionPendingActionKindA, sessionPendingActionEntity2.getCreatedAt(), sessionPendingActionEntity2.getExpiresAt());
                    if (sessionPendingAction != null) {
                        arrayList3.add(sessionPendingAction);
                    }
                }
                return SessionListSnapshotStoreKt.f(listV, mapI, arrayList3);
            } catch (Throwable th) {
                C4148a.h("SessionList", "findAll failed: " + th.getClass().getSimpleName(), false, 4, null);
                return new SessionListSnapshot(null, 1, null);
            }
        } catch (IllegalStateException unused2) {
            i10 = i11;
        }
    }
}

package com.stepos.agentframework.chatcore.search;

import Ka.t;
import Ua.C1056g;
import Ua.Y;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.db.FwkDatabase;
import com.stepos.agentframework.chatcore.session.db.SessionOpeningMessageRow;
import com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStoreKt;
import e9.InterfaceC4014c;
import eb.InterfaceC4021a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0013\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/agentframework/chatcore/search/ConversationSearchSnapshotStore;", "", "<init>", "()V", "", "query", "", "limit", "Lcom/stepos/agentframework/chatcore/search/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "LY8/t;", "f", "(Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "db", "", "Lw4/e;", "titlesBySession", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatcore/search/a;Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;Ljava/util/Map;)Lcom/stepos/agentframework/chatcore/search/a;", "TAG", "Ljava/lang/String;", "MAX_RESULTS", "I", "BACKFILL_BATCH_SIZE", "CANDIDATE_MULTIPLIER", "PREVIEW_CANDIDATES_PER_SESSION", "PREVIEW_MAX_TEXT_LENGTH", "Leb/a;", "backfillMutex", "Leb/a;", "fullyIndexedDatabase", "Lcom/stepos/agentframework/chatcore/session/db/FwkDatabase;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConversationSearchSnapshotStore {
    private static final int BACKFILL_BATCH_SIZE = 300;
    private static final int CANDIDATE_MULTIPLIER = 4;
    private static final int MAX_RESULTS = 50;
    private static final int PREVIEW_CANDIDATES_PER_SESSION = 2;
    private static final int PREVIEW_MAX_TEXT_LENGTH = 200;
    private static final String TAG = "ConversationSearch";
    private static volatile FwkDatabase fullyIndexedDatabase;
    public static final ConversationSearchSnapshotStore INSTANCE = new ConversationSearchSnapshotStore();
    private static final InterfaceC4021a backfillMutex = eb.f.b(false, 1, null);

    public static final String i(SessionSearchHit it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId();
    }

    public static final boolean j(HashSet hashSet, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return hashSet.contains(it);
    }

    public static final Ka.j k(Map map, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        w4.e eVar = (w4.e) map.get(it);
        return t.w(it, eVar != null ? eVar.getSessionId() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1 r0 = (com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1 r0 = new com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore$ensureLegacyMessagesIndexed$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r11 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r11 = r0.L$1
            eb.a r11 = (eb.InterfaceC4021a) r11
            java.lang.Object r0 = r0.L$0
            com.stepos.agentframework.chatcore.session.db.FwkDatabase r0 = (com.stepos.agentframework.chatcore.session.db.FwkDatabase) r0
            kotlin.C4849c.b(r10)
            goto L61
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            kotlin.C4849c.b(r10)
            com.stepos.agentframework.chatcore.session.db.FwkDatabase$i r10 = com.stepos.agentframework.chatcore.session.db.FwkDatabase.INSTANCE
            com.stepos.agentframework.chatcore.session.db.FwkDatabase r10 = r10.n()
            com.stepos.agentframework.chatcore.session.db.FwkDatabase r1 = com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore.fullyIndexedDatabase
            if (r1 != r10) goto L4a
            Y8.t r10 = Y8.t.f7040a
            return r10
        L4a:
            eb.a r1 = com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore.backfillMutex
            java.lang.Object r10 = g9.h.a(r10)
            r0.L$0 = r10
            r0.L$1 = r1
            r10 = 0
            r0.I$0 = r10
            r0.label = r2
            java.lang.Object r10 = r1.m(r3, r0)
            if (r10 != r11) goto L60
            return r11
        L60:
            r11 = r1
        L61:
            com.stepos.agentframework.chatcore.session.db.FwkDatabase$i r10 = com.stepos.agentframework.chatcore.session.db.FwkDatabase.INSTANCE     // Catch: java.lang.Throwable -> L88
            com.stepos.agentframework.chatcore.session.db.FwkDatabase r10 = r10.n()     // Catch: java.lang.Throwable -> L88
            com.stepos.agentframework.chatcore.session.db.FwkDatabase r0 = com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore.fullyIndexedDatabase     // Catch: java.lang.Throwable -> L88
            if (r0 == r10) goto L8b
            x4.v r4 = new x4.v     // Catch: java.lang.Throwable -> L88
            r8 = 7
            r9 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L88
        L75:
            r0 = 300(0x12c, float:4.2E-43)
            int r1 = r4.O(r0)     // Catch: java.lang.Throwable -> L88
            if (r1 == r0) goto L75
            com.stepos.agentframework.chatcore.session.db.FwkDatabase$i r0 = com.stepos.agentframework.chatcore.session.db.FwkDatabase.INSTANCE     // Catch: java.lang.Throwable -> L88
            com.stepos.agentframework.chatcore.session.db.FwkDatabase r0 = r0.n()     // Catch: java.lang.Throwable -> L88
            if (r0 != r10) goto L8b
            com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore.fullyIndexedDatabase = r10     // Catch: java.lang.Throwable -> L88
            goto L8b
        L88:
            r0 = move-exception
            r10 = r0
            goto L93
        L8b:
            Y8.t r10 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L88
            r11.l(r3)
            Y8.t r10 = Y8.t.f7040a
            return r10
        L93:
            r11.l(r3)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStore.f(e9.c):java.lang.Object");
    }

    public final Object g(String str, int i10, InterfaceC4014c<? super ConversationSearchSnapshot> interfaceC4014c) {
        return C1056g.j(Y.b(), new ConversationSearchSnapshotStore$searchKeyword$2(str, i10, null), interfaceC4014c);
    }

    public final ConversationSearchSnapshot h(ConversationSearchSnapshot conversationSearchSnapshot, FwkDatabase fwkDatabase, final Map<String, w4.e> map) {
        Object objB;
        List<MessageSearchHit> listC = conversationSearchSnapshot.c();
        final HashSet hashSet = new HashSet();
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            hashSet.add(((MessageSearchHit) it.next()).getSessionId());
        }
        HashSet hashSet2 = (HashSet) SequencesKt___SequencesKt.b0(SequencesKt___SequencesKt.G(SequencesKt___SequencesKt.R(F.d0(conversationSearchSnapshot.d()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ConversationSearchSnapshotStore.i((SessionSearchHit) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ConversationSearchSnapshotStore.j(hashSet, (String) obj));
            }
        }), new HashSet());
        if (!hashSet2.isEmpty()) {
            LinkedHashSet linkedHashSet = (LinkedHashSet) SequencesKt___SequencesKt.b0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.H(SequencesKt___SequencesKt.L(F.d0(hashSet2), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.search.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return ConversationSearchSnapshotStore.k(map, (String) obj);
                }
            })), ConversationSearchSnapshotStore$withSessionPreviews$lookupIds$2.INSTANCE), new LinkedHashSet());
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(fwkDatabase.l0().e(F.m1(linkedHashSet), 2, 200));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "session preview unavailable: " + thE.getClass().getSimpleName(), false, 4, null);
            }
            if (Result.g(objB)) {
                objB = null;
            }
            List<SessionOpeningMessageRow> listM = (List) objB;
            if (listM == null) {
                listM = C1173v.m();
            }
            if (!listM.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (SessionOpeningMessageRow sessionOpeningMessageRow : listM) {
                    String strL = SessionListSnapshotStoreKt.l(sessionOpeningMessageRow.getSessionId());
                    Object arrayList = linkedHashMap.get(strL);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(strL, arrayList);
                    }
                    ((List) arrayList).add(sessionOpeningMessageRow.getText());
                }
                List<SessionSearchHit> listD = conversationSearchSnapshot.d();
                ArrayList arrayList2 = new ArrayList(C1174w.x(listD, 10));
                for (SessionSearchHit sessionSearchHitB : listD) {
                    if (hashSet2.contains(sessionSearchHitB.getSessionId())) {
                        String title = sessionSearchHitB.getTitle();
                        List listM2 = (List) linkedHashMap.get(sessionSearchHitB.getSessionId());
                        if (listM2 == null) {
                            listM2 = C1173v.m();
                        }
                        String strF = ConversationSearchSnapshotStoreKt.f(title, listM2);
                        if (strF.length() != 0) {
                            sessionSearchHitB = SessionSearchHit.b(sessionSearchHitB, null, null, null, null, null, null, 0L, false, false, strF, 511, null);
                        }
                    }
                    arrayList2.add(sessionSearchHitB);
                }
                return ConversationSearchSnapshot.b(conversationSearchSnapshot, arrayList2, null, 2, null);
            }
        }
        return conversationSearchSnapshot;
    }
}

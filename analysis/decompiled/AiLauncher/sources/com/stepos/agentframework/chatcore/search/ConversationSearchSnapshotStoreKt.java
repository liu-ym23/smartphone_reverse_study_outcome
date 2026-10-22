package com.stepos.agentframework.chatcore.search;

import La.D;
import La.H;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.list.SessionAgentCategory;
import com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import v9.C5685n;
import w4.MessageSearchProjectionEntity;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\u00020\u000b*\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a;\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"", "title", "", "candidates", "f", "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", UxipConstants.f30680s, "c", "(Ljava/lang/String;)Ljava/lang/String;", "Lw4/e;", "agentInfoName", "Lcom/stepos/agentframework/chatcore/search/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lw4/e;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/search/m;", "Lw4/g;", "Lcom/stepos/agentframework/chatcore/search/g;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw4/g;)Lcom/stepos/agentframework/chatcore/search/g;", "query", "", "limit", "titles", "messages", "Lcom/stepos/agentframework/chatcore/search/a;", "e", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;)Lcom/stepos/agentframework/chatcore/search/a;", "keyword", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)I", "Lkotlin/text/Regex;", "WHITESPACE_REGEX", "Lkotlin/text/Regex;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConversationSearchSnapshotStoreKt {
    private static final Regex WHITESPACE_REGEX = new Regex("\\s+");

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Integer.valueOf(((Candidate) t11).getScore()), Integer.valueOf(((Candidate) t10).getScore()));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public b(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(((Candidate) t10).getSession().getSessionId(), ((Candidate) t11).getSession().getSessionId());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenByDescending;

        public c(Comparator comparator) {
            this.$this_thenByDescending = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenByDescending.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(Long.valueOf(((Candidate) t11).getUpdatedAt()), Long.valueOf(((Candidate) t10).getUpdatedAt()));
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"com/stepos/agentframework/chatcore/search/ConversationSearchSnapshotStoreKt$d", "", "Lcom/stepos/agentframework/chatcore/search/m;", "session", "", "score", "", "updatedAt", "<init>", "(Lcom/stepos/agentframework/chatcore/search/m;IJ)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatcore/search/m;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/search/m;", "I", Const.INTENT_KEY_APIKEY, "J", "c", "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.search.ConversationSearchSnapshotStoreKt$d, reason: from toString */
    public static final /* data */ class Candidate {
        private final int score;
        private final SessionSearchHit session;
        private final long updatedAt;

        public Candidate(SessionSearchHit session, int i10, long j10) {
            kotlin.jvm.internal.p.i(session, "session");
            this.session = session;
            this.score = i10;
            this.updatedAt = j10;
        }

        /* renamed from: a, reason: from getter */
        public final int getScore() {
            return this.score;
        }

        /* renamed from: b, reason: from getter */
        public final SessionSearchHit getSession() {
            return this.session;
        }

        /* renamed from: c, reason: from getter */
        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Candidate)) {
                return false;
            }
            Candidate candidate = (Candidate) other;
            return kotlin.jvm.internal.p.d(this.session, candidate.session) && this.score == candidate.score && this.updatedAt == candidate.updatedAt;
        }

        public int hashCode() {
            return (((this.session.hashCode() * 31) + Integer.hashCode(this.score)) * 31) + Long.hashCode(this.updatedAt);
        }

        public String toString() {
            return "Candidate(session=" + this.session + ", score=" + this.score + ", updatedAt=" + this.updatedAt + ")";
        }
    }

    public static final String c(String str) {
        return H.D1(WHITESPACE_REGEX.l(str, " ")).toString();
    }

    public static final int d(String str, String str2) {
        if (D.L(str, str2, true)) {
            return 3;
        }
        if (D.V(str, str2, true)) {
            return 2;
        }
        return H.e0(str, str2, true) ? 1 : -1;
    }

    public static final ConversationSearchSnapshot e(String query, int i10, List<SessionSearchHit> titles, List<MessageSearchHit> messages) {
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(titles, "titles");
        kotlin.jvm.internal.p.i(messages, "messages");
        String string = H.D1(query).toString();
        if (string.length() == 0 || i10 <= 0) {
            return new ConversationSearchSnapshot(null, null, 3, null);
        }
        List<MessageSearchHit> list = messages;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((MessageSearchHit) obj).getSessionId(), obj);
        }
        ArrayList arrayList = new ArrayList();
        for (SessionSearchHit sessionSearchHit : titles) {
            int iD = d(sessionSearchHit.getTitle(), string);
            MessageSearchHit messageSearchHit = (MessageSearchHit) linkedHashMap.get(sessionSearchHit.getSessionId());
            Candidate candidate = (iD >= 0 || messageSearchHit != null) ? new Candidate(sessionSearchHit, iD >= 0 ? iD + 100 : 70, Math.max(sessionSearchHit.getUpdatedAt(), messageSearchHit != null ? messageSearchHit.getUpdatedAt() : 0L)) : null;
            if (candidate != null) {
                arrayList.add(candidate);
            }
        }
        List listF1 = F.f1(F.c1(arrayList, new b(new c(new a()))), i10);
        HashSet hashSet = new HashSet();
        Iterator it = listF1.iterator();
        while (it.hasNext()) {
            hashSet.add(((Candidate) it.next()).getSession().getSessionId());
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(listF1, 10));
        Iterator it2 = listF1.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Candidate) it2.next()).getSession());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (hashSet.contains(((MessageSearchHit) obj2).getSessionId())) {
                arrayList3.add(obj2);
            }
        }
        return new ConversationSearchSnapshot(arrayList2, arrayList3);
    }

    public static final String f(String title, List<String> candidates) {
        Object next;
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(candidates, "candidates");
        String strC = c(title);
        Iterator it = SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(F.d0(candidates), ConversationSearchSnapshotStoreKt$selectSessionPreviewText$1.INSTANCE), ConversationSearchSnapshotStoreKt$selectSessionPreviewText$2.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!kotlin.jvm.internal.p.d((String) next, strC)) {
                break;
            }
        }
        String str = (String) next;
        return str == null ? "" : str;
    }

    public static final MessageSearchHit g(MessageSearchProjectionEntity messageSearchProjectionEntity) {
        return new MessageSearchHit(messageSearchProjectionEntity.getMessageId(), SessionListSnapshotStoreKt.l(messageSearchProjectionEntity.getSessionId()), SessionListSnapshotStoreKt.j(messageSearchProjectionEntity.getAgentId()), messageSearchProjectionEntity.getRole(), messageSearchProjectionEntity.getSearchableText(), messageSearchProjectionEntity.getUpdatedAt(), messageSearchProjectionEntity.getStatus());
    }

    public static final SessionSearchHit h(w4.e eVar, String str) {
        kotlin.jvm.internal.p.i(eVar, "<this>");
        String strJ = SessionListSnapshotStoreKt.j(eVar.getAgentId());
        String strK = SessionListSnapshotStoreKt.k(eVar.getDeviceId());
        SessionAgentCategory sessionAgentCategoryO = SessionListSnapshotStoreKt.o(strJ);
        return new SessionSearchHit(SessionListSnapshotStoreKt.l(eVar.getSessionId()), strJ, strK, SessionListSnapshotStoreKt.n(strJ, str, sessionAgentCategoryO == SessionAgentCategory.EXTERNAL), sessionAgentCategoryO, SessionListSnapshotStoreKt.m(eVar.getTitle()), eVar.getLastActiveAt(), eVar.o(), eVar.getSendFailed(), null, 512, null);
    }
}

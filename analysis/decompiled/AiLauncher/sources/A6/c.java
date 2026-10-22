package A6;

import La.H;
import Y8.j;
import Z8.T;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.contract.model.search.UnifiedSearchModelsKt;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000e*\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"LA6/c;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", "", "cards", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)J", "taskState", "", "authorizationRequired", "chatState", "conversationRead", "e", "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;ZLcom/stepos/ailauncher/contract/model/search/SessionActivityState;Z)Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)Ljava/util/Map;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final c INSTANCE = new c();

    public static /* synthetic */ SessionActivityState f(c cVar, SessionActivityState sessionActivityState, boolean z10, SessionActivityState sessionActivityState2, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            sessionActivityState2 = null;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        return cVar.e(sessionActivityState, z10, sessionActivityState2, z11);
    }

    public static final Pair h(Map.Entry entry) {
        SessionActivityState sessionActivityStateD;
        p.i(entry, "<destruct>");
        String str = (String) entry.getKey();
        List<TaskInfoCard> list = (List) entry.getValue();
        if (str == null || (sessionActivityStateD = INSTANCE.d(list)) == null) {
            return null;
        }
        return j.a(str, sessionActivityStateD);
    }

    public final long b(TaskInfoCard taskInfoCard) {
        p.i(taskInfoCard, "<this>");
        Long endedAt = taskInfoCard.getEndedAt();
        if (endedAt != null) {
            if (endedAt.longValue() <= 0) {
                endedAt = null;
            }
            if (endedAt != null) {
                return endedAt.longValue();
            }
        }
        return taskInfoCard.getUpdatedAt();
    }

    public final String c(TaskInfoCard card) {
        p.i(card, "card");
        String requestSessionKey = card.getRequestSessionKey();
        if (requestSessionKey != null) {
            if (H.x0(requestSessionKey)) {
                requestSessionKey = null;
            }
            if (requestSessionKey != null) {
                return requestSessionKey;
            }
        }
        String sessionKey = card.getSessionKey();
        if (sessionKey == null || H.x0(sessionKey)) {
            return null;
        }
        return sessionKey;
    }

    public final SessionActivityState d(List<TaskInfoCard> cards) {
        boolean z10;
        p.i(cards, "cards");
        List<TaskInfoCard> list = cards;
        ArrayList<TaskInfoCard> arrayList = new ArrayList();
        for (Object obj : list) {
            TaskInfoCard taskInfoCard = (TaskInfoCard) obj;
            if (taskInfoCard.getStatus() == TaskInfoStatus.FAILED && taskInfoCard.getReadAt() == null) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty() || ((list instanceof Collection) && list.isEmpty())) {
            z10 = false;
        } else {
            loop1: for (TaskInfoCard taskInfoCard2 : list) {
                if (taskInfoCard2.getStatus() == TaskInfoStatus.COMPLETED && !arrayList.isEmpty()) {
                    for (TaskInfoCard taskInfoCard3 : arrayList) {
                        c cVar = INSTANCE;
                        if (cVar.b(taskInfoCard2) >= cVar.b(taskInfoCard3)) {
                            z10 = true;
                            break loop1;
                        }
                    }
                }
            }
            z10 = false;
        }
        if (!arrayList.isEmpty() && !z10) {
            return SessionActivityState.FAILED;
        }
        boolean z11 = list instanceof Collection;
        if (!z11 || !list.isEmpty()) {
            for (TaskInfoCard taskInfoCard4 : list) {
                if (d.b(taskInfoCard4.getStatus()) || d.a(taskInfoCard4)) {
                    return SessionActivityState.WAITING_FOR_USER;
                }
            }
        }
        if (!z11 || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((TaskInfoCard) it.next()).getStatus().isTerminal()) {
                    return SessionActivityState.RUNNING;
                }
            }
        }
        if (z11 && list.isEmpty()) {
            return null;
        }
        for (TaskInfoCard taskInfoCard5 : list) {
            if (taskInfoCard5.getStatus() == TaskInfoStatus.COMPLETED && taskInfoCard5.getReadAt() == null) {
                return SessionActivityState.COMPLETED_UNREAD;
            }
        }
        return null;
    }

    public final SessionActivityState e(SessionActivityState taskState, boolean authorizationRequired, SessionActivityState chatState, boolean conversationRead) {
        SessionActivityState sessionActivityState = SessionActivityState.FAILED;
        if (taskState == sessionActivityState) {
            return sessionActivityState;
        }
        if (authorizationRequired || taskState == SessionActivityState.WAITING_FOR_USER) {
            return SessionActivityState.WAITING_FOR_USER;
        }
        SessionActivityState sessionActivityState2 = SessionActivityState.RUNNING;
        if (taskState == sessionActivityState2) {
            return UnifiedSearchModelsKt.overlayChatOnRunningTask(sessionActivityState2, chatState, conversationRead);
        }
        SessionActivityState sessionActivityState3 = SessionActivityState.COMPLETED_UNREAD;
        if (taskState == sessionActivityState3) {
            return sessionActivityState3;
        }
        SessionActivityState sessionActivityStateOrInFlightChat = UnifiedSearchModelsKt.orInFlightChat(null, chatState);
        if (sessionActivityStateOrInFlightChat == sessionActivityState2 && conversationRead) {
            return null;
        }
        return sessionActivityStateOrInFlightChat;
    }

    public final Map<String, SessionActivityState> g(List<TaskInfoCard> cards) {
        p.i(cards, "cards");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : cards) {
            String strC = c((TaskInfoCard) obj);
            Object arrayList = linkedHashMap.get(strC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        return kotlin.collections.a.w(SequencesKt___SequencesKt.S(T.D(linkedHashMap), new InterfaceC5074l() { // from class: A6.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return c.h((Map.Entry) obj2);
            }
        }));
    }
}

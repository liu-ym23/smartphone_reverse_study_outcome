package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1173v;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.list.SessionListItem;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoQuestion;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JÁ\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\t2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\t2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u00192\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010%\u001a\u00020$2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010&J?\u0010*\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b*\u0010+JU\u0010.\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010,\u001a\u00020\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020!2\u0006\u00100\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0002¢\u0006\u0004\b1\u00102J'\u00103\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b3\u00104J!\u00105\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\n2\u0006\u00107\u001a\u00020\u0005H\u0002¢\u0006\u0004\b:\u00109J\u0013\u0010<\u001a\u00020;*\u00020\u001fH\u0002¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\u00020!*\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\u00020!*\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b@\u0010?J\u0015\u0010A\u001a\u00020!*\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\bA\u0010?J\u0015\u0010B\u001a\u00020!*\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\bB\u0010CJ\u0013\u0010D\u001a\u00020!*\u00020\u001fH\u0002¢\u0006\u0004\bD\u0010CR\u0014\u0010E\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/u;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", "Lcom/stepos/agentframework/chatcore/session/list/b;", "sessions", "", "", "Lcom/stepos/ailauncher/taskstore/livenotification/q;", "chatActivities", "summaries", "", "chatContentSessionIds", "artifactSessionIds", "Lcom/stepos/ailauncher/taskstore/livenotification/m;", "risks", "Lcom/stepos/ailauncher/taskstore/livenotification/n;", "afterglows", "activeSessionIds", "Lcom/stepos/ailauncher/taskstore/livenotification/r;", "c", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)Ljava/util/Map;", "", "result", "LY8/t;", "t", "(Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "existing", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "phase", "", "hasArtifacts", "newerUserRound", "Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;", "r", "(Lcom/stepos/ailauncher/taskstore/livenotification/r;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;ZZ)Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;", "sessionId", "session", LinkHeader.Parameters.Anchor, "s", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/b;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/Map;)Ljava/lang/String;", "failureReason", "fallbackTitle", "p", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/b;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "title", "k", "(Ljava/lang/String;Ljava/lang/String;)Z", "o", "(Ljava/util/List;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", "card", "e", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "u", "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/taskstore/livenotification/r;)Z", "l", "n", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;)Z", "m", "TAG", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3732u {
    public static final C3732u INSTANCE = new C3732u();
    private static final String TAG = "SessionLiveStateAggregator";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.livenotification.u$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionActivityState.values().length];
            try {
                iArr[SessionActivityState.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionActivityState.WAITING_FOR_USER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SessionActivityState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SessionActivityState.COMPLETED_UNREAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String f(TaskInfoPart part) {
        kotlin.jvm.internal.p.i(part, "part");
        String errorReason = part.getErrorReason();
        if (errorReason != null) {
            if (La.H.x0(errorReason)) {
                errorReason = null;
            }
            if (errorReason != null) {
                return errorReason;
            }
        }
        String errorDetail = part.getErrorDetail();
        if (errorDetail == null || La.H.x0(errorDetail)) {
            return null;
        }
        return errorDetail;
    }

    public static final String h(TaskInfoQuestion it) {
        kotlin.jvm.internal.p.i(it, "it");
        String question = it.getQuestion();
        if (La.H.x0(question)) {
            return null;
        }
        return question;
    }

    public static /* synthetic */ String q(C3732u c3732u, String str, SessionListItem sessionListItem, TaskInfoCard taskInfoCard, Map map, String str2, String str3, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            str2 = "";
        }
        String str4 = str2;
        if ((i10 & 32) != 0) {
            str3 = null;
        }
        return c3732u.p(str, sessionListItem, taskInfoCard, map, str4, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x053d  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x020a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02b7  */
    /* JADX WARN: Type inference failed for: r36v0, types: [com.stepos.ailauncher.taskstore.livenotification.u] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.String, com.stepos.ailauncher.taskstore.livenotification.SessionLiveState> c(java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r37, java.util.List<com.stepos.agentframework.chatcore.session.list.SessionListItem> r38, java.util.Map<java.lang.String, com.stepos.ailauncher.taskstore.livenotification.SessionChatActivity> r39, java.util.Map<java.lang.String, java.lang.String> r40, java.util.Set<java.lang.String> r41, java.util.Set<java.lang.String> r42, java.util.Map<java.lang.String, com.stepos.ailauncher.taskstore.livenotification.PendingRisk> r43, java.util.Map<java.lang.String, com.stepos.ailauncher.taskstore.livenotification.RiskAfterglow> r44, java.util.Set<java.lang.String> r45) {
        /*
            Method dump skipped, instructions count: 1418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.livenotification.C3732u.c(java.util.List, java.util.List, java.util.Map, java.util.Map, java.util.Set, java.util.Set, java.util.Map, java.util.Map, java.util.Set):java.util.Map");
    }

    public final String d(SessionActivityState phase, TaskInfoCard anchor) {
        if (anchor == null) {
            return "";
        }
        int i10 = a.$EnumSwitchMapping$0[phase.ordinal()];
        return i10 != 1 ? i10 != 2 ? "" : g(anchor) : e(anchor);
    }

    public final String e(TaskInfoCard card) {
        List<TaskInfoPart> result = card.getResult();
        if (result == null) {
            result = C1173v.m();
        }
        String reason = (String) SequencesKt___SequencesKt.K(SequencesKt___SequencesKt.S(Z8.F.d0(result), new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.t
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3732u.f((TaskInfoPart) obj);
            }
        }));
        if (reason == null) {
            TaskInfoAnswer answer = card.getAnswer();
            String str = null;
            if (answer == null || (reason = answer.getError()) == null || La.H.x0(reason)) {
                reason = null;
            }
            if (reason == null) {
                TaskInfoAnswer answer2 = card.getAnswer();
                if (answer2 == null || (reason = answer2.getReason()) == null || La.H.x0(reason)) {
                    reason = null;
                }
                if (reason == null) {
                    String summary = card.getSummary();
                    if (summary != null && !La.H.x0(summary)) {
                        str = summary;
                    }
                    return str == null ? "" : str;
                }
            }
        }
        return reason;
    }

    public final String g(TaskInfoCard card) {
        List<TaskInfoQuestion> pendingQuestions = card.getPendingQuestions();
        if (pendingQuestions == null) {
            pendingQuestions = C1173v.m();
        }
        String str = (String) SequencesKt___SequencesKt.K(SequencesKt___SequencesKt.S(Z8.F.d0(pendingQuestions), new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.livenotification.s
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3732u.h((TaskInfoQuestion) obj);
            }
        }));
        return str == null ? "" : str;
    }

    public final boolean i(SessionActivityState sessionActivityState) {
        return sessionActivityState == SessionActivityState.RUNNING || sessionActivityState == SessionActivityState.WAITING_FOR_USER;
    }

    public final boolean j(SessionLiveState sessionLiveState) {
        return (sessionLiveState != null ? sessionLiveState.getCategory() : null) == SessionLiveCategory.TASK && i(sessionLiveState.getPhase());
    }

    public final boolean k(String title, String failureReason) {
        String string = La.H.D1(title).toString();
        if (string.length() == 0) {
            return false;
        }
        String string2 = La.H.D1(failureReason).toString();
        if (string2.length() <= 0 || !La.D.L(string, string2, true)) {
            return C3722j.INSTANCE.b(string);
        }
        return true;
    }

    public final boolean l(SessionLiveState sessionLiveState) {
        return (sessionLiveState != null ? sessionLiveState.getCategory() : null) == SessionLiveCategory.TASK && sessionLiveState.getPhase() == SessionActivityState.RUNNING;
    }

    public final boolean m(SessionActivityState sessionActivityState) {
        return sessionActivityState == SessionActivityState.COMPLETED_UNREAD || sessionActivityState == SessionActivityState.FAILED;
    }

    public final boolean n(SessionLiveState sessionLiveState) {
        return (sessionLiveState != null ? sessionLiveState.getCategory() : null) == SessionLiveCategory.TASK && sessionLiveState.getPhase() == SessionActivityState.WAITING_FOR_USER;
    }

    public final TaskInfoCard o(List<TaskInfoCard> cards, SessionActivityState phase) {
        ArrayList arrayList;
        Object obj;
        int i10 = a.$EnumSwitchMapping$0[phase.ordinal()];
        if (i10 == 1) {
            arrayList = new ArrayList();
            for (Object obj2 : cards) {
                if (((TaskInfoCard) obj2).getStatus() == TaskInfoStatus.FAILED) {
                    arrayList.add(obj2);
                }
            }
        } else if (i10 == 2) {
            arrayList = new ArrayList();
            for (Object obj3 : cards) {
                TaskInfoCard taskInfoCard = (TaskInfoCard) obj3;
                if (A6.d.b(taskInfoCard.getStatus()) || A6.d.a(taskInfoCard)) {
                    arrayList.add(obj3);
                }
            }
        } else if (i10 == 3) {
            arrayList = new ArrayList();
            for (Object obj4 : cards) {
                if (!((TaskInfoCard) obj4).getStatus().isTerminal()) {
                    arrayList.add(obj4);
                }
            }
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            arrayList = new ArrayList();
            for (Object obj5 : cards) {
                if (((TaskInfoCard) obj5).getStatus() == TaskInfoStatus.COMPLETED) {
                    arrayList.add(obj5);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            cards = arrayList;
        }
        Iterator<T> it = cards.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long updatedAt = ((TaskInfoCard) next).getUpdatedAt();
                do {
                    Object next2 = it.next();
                    long updatedAt2 = ((TaskInfoCard) next2).getUpdatedAt();
                    if (updatedAt < updatedAt2) {
                        next = next2;
                        updatedAt = updatedAt2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (TaskInfoCard) obj;
    }

    public final String p(String sessionId, SessionListItem session, TaskInfoCard anchor, Map<String, String> summaries, String failureReason, String fallbackTitle) {
        String strS = s(sessionId, session, anchor, summaries);
        if (La.H.x0(strS)) {
            strS = fallbackTitle == null ? "" : fallbackTitle;
        }
        if (!k(strS, failureReason)) {
            return strS;
        }
        Object obj = null;
        Iterator it = C1173v.p(session != null ? session.getTitle() : null, fallbackTitle, anchor != null ? anchor.getTitle() : null, anchor != null ? C3721i.INSTANCE.c(anchor) : null).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            if (str != null && !La.H.x0(str) && !INSTANCE.k(str, failureReason)) {
                obj = next;
                break;
            }
        }
        String str2 = (String) obj;
        return str2 == null ? "" : str2;
    }

    public final SessionLiveCategory r(SessionLiveState existing, SessionActivityState phase, boolean hasArtifacts, boolean newerUserRound) {
        if (i(phase)) {
            SessionLiveCategory category = existing != null ? existing.getCategory() : null;
            SessionLiveCategory sessionLiveCategory = SessionLiveCategory.TASK;
            if (category != sessionLiveCategory || j(existing)) {
                return (existing != null ? existing.getCategory() : null) == sessionLiveCategory ? sessionLiveCategory : SessionLiveCategory.CHAT;
            }
            return SessionLiveCategory.CHAT;
        }
        if (l(existing) && m(phase)) {
            return (newerUserRound || !hasArtifacts) ? SessionLiveCategory.CHAT : SessionLiveCategory.TASK;
        }
        if (newerUserRound) {
            if ((existing != null ? existing.getCategory() : null) == SessionLiveCategory.TASK && !j(existing)) {
                return SessionLiveCategory.CHAT;
            }
        }
        SessionLiveCategory category2 = existing != null ? existing.getCategory() : null;
        SessionLiveCategory sessionLiveCategory2 = SessionLiveCategory.TASK;
        return (category2 == sessionLiveCategory2 || hasArtifacts) ? sessionLiveCategory2 : SessionLiveCategory.CHAT;
    }

    public final String s(String sessionId, SessionListItem session, TaskInfoCard anchor, Map<String, String> summaries) {
        String title;
        if (session != null && session.getTitleLocallyFixed()) {
            String title2 = session.getTitle();
            if (La.H.x0(title2)) {
                title2 = null;
            }
            if (title2 != null) {
                return title2;
            }
        }
        String str = summaries.get(sessionId);
        if (str != null) {
            if (La.H.x0(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        if (session == null || (title = session.getTitle()) == null || La.H.x0(title)) {
            title = null;
        }
        if (title != null) {
            return title;
        }
        String strC = anchor != null ? C3721i.INSTANCE.c(anchor) : null;
        return strC == null ? "" : strC;
    }

    public final void t(Map<String, SessionLiveState> result, Set<String> activeSessionIds, Set<String> artifactSessionIds) {
        if (activeSessionIds == null) {
            return;
        }
        Set<Map.Entry<String, SessionLiveState>> setEntrySet = result.entrySet();
        ArrayList<String> arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            SessionLiveState sessionLiveState = (SessionLiveState) entry.getValue();
            if (sessionLiveState.getPhase() != SessionActivityState.RUNNING || sessionLiveState.getCategory() != SessionLiveCategory.CHAT || sessionLiveState.getRiskAfterglow() || sessionLiveState.getRiskRequestId() != null || activeSessionIds.contains(str)) {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        for (String str2 : arrayList) {
            SessionLiveState sessionLiveState2 = result.get(str2);
            if (sessionLiveState2 != null) {
                SessionLiveCategory sessionLiveCategory = artifactSessionIds.contains(str2) ? SessionLiveCategory.TASK : SessionLiveCategory.CHAT;
                SessionLiveCategory category = sessionLiveState2.getCategory();
                SessionActivityState phase = sessionLiveState2.getPhase();
                SessionActivityState sessionActivityState = SessionActivityState.COMPLETED_UNREAD;
                Log.i(TAG, "settleIdleInFlight sessionId=" + str2 + " from=" + category + "/" + phase + " to=" + sessionLiveCategory + "/" + sessionActivityState + " activeSessionIds=" + activeSessionIds + " artifact=" + artifactSessionIds.contains(str2));
                result.put(str2, sessionLiveState2.a((8190 & 1) != 0 ? sessionLiveState2.sessionId : null, (8190 & 2) != 0 ? sessionLiveState2.category : sessionLiveCategory, (8190 & 4) != 0 ? sessionLiveState2.title : null, (8190 & 8) != 0 ? sessionLiveState2.phase : sessionActivityState, (8190 & 16) != 0 ? sessionLiveState2.dynamicText : "", (8190 & 32) != 0 ? sessionLiveState2.iconRes : null, (8190 & 64) != 0 ? sessionLiveState2.updatedAt : 0L, (8190 & 128) != 0 ? sessionLiveState2.riskRequestId : null, (8190 & 256) != 0 ? sessionLiveState2.riskButtons : null, (8190 & 512) != 0 ? sessionLiveState2.riskBody : null, (8190 & 1024) != 0 ? sessionLiveState2.riskLevel : null, (8190 & 2048) != 0 ? sessionLiveState2.riskAfterglow : false, (8190 & 4096) != 0 ? sessionLiveState2.continueTaskAfterTakeover : false));
            }
        }
    }

    public final TaskInfoStatus u(SessionActivityState sessionActivityState) {
        int i10 = a.$EnumSwitchMapping$0[sessionActivityState.ordinal()];
        if (i10 == 1) {
            return TaskInfoStatus.FAILED;
        }
        if (i10 == 2) {
            return TaskInfoStatus.WAITING;
        }
        if (i10 == 3) {
            return TaskInfoStatus.RUNNING;
        }
        if (i10 == 4) {
            return TaskInfoStatus.COMPLETED;
        }
        throw new NoWhenBranchMatchedException();
    }
}

package com.stepos.ailauncher.taskstore.livenotification;

import Z8.X;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.M0;
import com.stepos.agentframework.chatcore.session.list.SessionChatActivitySnapshot;
import com.stepos.agentframework.chatcore.session.list.SessionChatPhase;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001aA\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\u001aA\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001aC\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u00102\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0010H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0013\u0010\u001d\u001a\u00020\u0015*\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aM\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0000¢\u0006\u0004\b!\u0010\"\u001a#\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0000¢\u0006\u0004\b&\u0010'\u001a+\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0010*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b(\u0010)\u001a5\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001e\u0010,\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030*j\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003`+H\u0000¢\u0006\u0004\b-\u0010.\u001a\u001b\u00100\u001a\u0004\u0018\u00010\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b0\u00101\u001a%\u00104\u001a\u0004\u0018\u00010\u00032\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002020\u0010H\u0000¢\u0006\u0004\b4\u00105\u001aM\u0010:\u001a\u0004\u0018\u00010\u00032\b\u00106\u001a\u0004\u0018\u00010\u00032\b\u00107\u001a\u0004\u0018\u00010\u00032\b\u00108\u001a\u0004\u0018\u00010\u00032\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002020\u00102\b\u00109\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\b:\u0010;¨\u0006<"}, d2 = {"", "handlerReady", "Lkotlin/Function1;", "", "isActive", "", "candidates", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(ZLp9/l;Ljava/util/Collection;)Ljava/util/Set;", "", "cardSessionIds", "lastStateIds", "activityIds", "c", "(Ljava/lang/Iterable;Ljava/lang/Iterable;Ljava/lang/Iterable;)Ljava/util/Set;", "", "Lcom/stepos/agentframework/chatcore/session/list/a;", "snapshots", "e", "(Ljava/util/Map;)Ljava/util/Collection;", "Lcom/stepos/ailauncher/taskstore/livenotification/q;", "n", "(Lcom/stepos/agentframework/chatcore/session/list/a;)Lcom/stepos/ailauncher/taskstore/livenotification/q;", "chatActivities", "persisted", Const.INTENT_KEY_UMID, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;", "o", "(Lcom/stepos/agentframework/chatcore/session/list/SessionChatPhase;)Lcom/stepos/ailauncher/taskstore/livenotification/q;", "liveStateIds", "runningCardSessionIds", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)Ljava/util/Map;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;)Ljava/util/Set;", "m", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", C3081a.FOCUS_MAP_NAME, "l", "(Ljava/util/HashMap;)Ljava/util/Set;", "raw", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/stepos/ailauncher/taskstore/livenotification/r;", "liveStates", "f", "(Ljava/util/Map;)Ljava/lang/String;", "explicit", "foregroundSessionId", "lastChatSessionId", "latestInFlightChatId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class N {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SessionChatPhase.values().length];
            try {
                iArr[SessionChatPhase.REPLYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SessionChatPhase.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SessionChatPhase.REPLIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SessionChatPhase.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Map<String, SessionChatActivity> b(Map<String, SessionChatActivitySnapshot> snapshots, Set<String> liveStateIds, Set<String> runningCardSessionIds) {
        kotlin.jvm.internal.p.i(snapshots, "snapshots");
        kotlin.jvm.internal.p.i(liveStateIds, "liveStateIds");
        kotlin.jvm.internal.p.i(runningCardSessionIds, "runningCardSessionIds");
        if (snapshots.isEmpty()) {
            return kotlin.collections.a.i();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, SessionChatActivitySnapshot> entry : snapshots.entrySet()) {
            String key = entry.getKey();
            SessionChatActivitySnapshot value = entry.getValue();
            if (!La.H.x0(key)) {
                boolean z10 = true;
                boolean z11 = value.getPhase() == SessionChatPhase.REPLYING || value.getPhase() == SessionChatPhase.WAITING;
                if (!liveStateIds.contains(key)) {
                    Set<String> set = liveStateIds;
                    if ((set instanceof Collection) && set.isEmpty()) {
                        z10 = false;
                    } else {
                        Iterator<T> it = set.iterator();
                        while (it.hasNext()) {
                            if (C3723k.INSTANCE.f((String) it.next(), key)) {
                                break;
                            }
                        }
                        z10 = false;
                    }
                }
                if (z11 || z10 || runningCardSessionIds.contains(key)) {
                    linkedHashMap.put(key, n(value));
                }
            }
        }
        return linkedHashMap;
    }

    public static final Set<String> c(Iterable<String> cardSessionIds, Iterable<String> lastStateIds, Iterable<String> activityIds) {
        kotlin.jvm.internal.p.i(cardSessionIds, "cardSessionIds");
        kotlin.jvm.internal.p.i(lastStateIds, "lastStateIds");
        kotlin.jvm.internal.p.i(activityIds, "activityIds");
        Set setB = X.b();
        for (String str : cardSessionIds) {
            if (str != null && !La.H.x0(str)) {
                setB.add(str);
            }
        }
        for (String str2 : lastStateIds) {
            if (!La.H.x0(str2)) {
                setB.add(str2);
            }
        }
        for (String str3 : activityIds) {
            if (!La.H.x0(str3)) {
                setB.add(str3);
            }
        }
        return X.a(setB);
    }

    public static final Map<String, SessionChatActivity> d(Map<String, SessionChatActivity> chatActivities, Map<String, SessionChatActivity> persisted) {
        kotlin.jvm.internal.p.i(chatActivities, "chatActivities");
        kotlin.jvm.internal.p.i(persisted, "persisted");
        if (persisted.isEmpty()) {
            return chatActivities;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(chatActivities);
        for (Map.Entry<String, SessionChatActivity> entry : persisted.entrySet()) {
            String key = entry.getKey();
            SessionChatActivity value = entry.getValue();
            if (!La.H.x0(key) && !linkedHashMap.containsKey(key)) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }

    public static final Collection<String> e(Map<String, SessionChatActivitySnapshot> snapshots) {
        kotlin.jvm.internal.p.i(snapshots, "snapshots");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, SessionChatActivitySnapshot> entry : snapshots.entrySet()) {
            String key = entry.getKey();
            SessionChatActivitySnapshot value = entry.getValue();
            if (La.H.x0(key) || value.getPhase() != SessionChatPhase.REPLYING) {
                key = null;
            }
            if (key != null) {
                arrayList.add(key);
            }
        }
        return arrayList;
    }

    public static final String f(Map<String, SessionLiveState> liveStates) {
        Object next;
        kotlin.jvm.internal.p.i(liveStates, "liveStates");
        Set<Map.Entry<String, SessionLiveState>> setEntrySet = liveStates.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (((SessionLiveState) ((Map.Entry) obj).getValue()).getPhase() == SessionActivityState.RUNNING) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((SessionLiveState) ((Map.Entry) obj2).getValue()).getCategory() == SessionLiveCategory.CHAT) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long updatedAt = ((SessionLiveState) ((Map.Entry) next).getValue()).getUpdatedAt();
                do {
                    Object next2 = it.next();
                    long updatedAt2 = ((SessionLiveState) ((Map.Entry) next2).getValue()).getUpdatedAt();
                    if (updatedAt < updatedAt2) {
                        next = next2;
                        updatedAt = updatedAt2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (String) entry.getKey();
        }
        return null;
    }

    public static final String g(String str) {
        String string = str != null ? La.H.D1(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0 || La.D.L(string, "null", true)) {
            return null;
        }
        for (int i10 = 0; i10 < string.length(); i10++) {
            if (!Character.isDigit(string.charAt(i10))) {
                if (string.length() < 8) {
                    return null;
                }
                return string;
            }
        }
        return null;
    }

    public static final Set<String> h(List<TaskInfoCard> cards) {
        String strC;
        kotlin.jvm.internal.p.i(cards, "cards");
        if (cards.isEmpty()) {
            return Y.e();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (TaskInfoCard taskInfoCard : cards) {
            if (!taskInfoCard.getStatus().isTerminal() && (strC = A6.c.INSTANCE.c(taskInfoCard)) != null) {
                if (La.H.x0(strC)) {
                    strC = null;
                }
                if (strC != null) {
                    linkedHashSet.add(strC);
                }
            }
        }
        return linkedHashSet;
    }

    public static final Set<String> i(boolean z10, InterfaceC5074l<? super String, Boolean> isActive, Collection<String> candidates) {
        kotlin.jvm.internal.p.i(isActive, "isActive");
        kotlin.jvm.internal.p.i(candidates, "candidates");
        if (!z10) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (Object obj : candidates) {
            String str = (String) obj;
            if (!La.H.x0(str) && isActive.invoke(str).booleanValue()) {
                hashSet.add(obj);
            }
        }
        return hashSet;
    }

    public static final String j(String str, String str2, String str3, Map<String, SessionLiveState> liveStates, String str4) {
        Object next;
        String str5;
        kotlin.jvm.internal.p.i(liveStates, "liveStates");
        String strK = k(str);
        if (strK != null) {
            return strK;
        }
        String strK2 = k(str2);
        if (strK2 != null) {
            return strK2;
        }
        String strK3 = k(str4);
        if (strK3 != null) {
            return strK3;
        }
        String strF = f(liveStates);
        if (strF != null) {
            String strF2 = M0.INSTANCE.f(strF);
            return strF2 == null ? strF : strF2;
        }
        String strK4 = k(str3);
        if (strK4 != null) {
            return strK4;
        }
        Iterator<T> it = liveStates.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long updatedAt = ((SessionLiveState) ((Map.Entry) next).getValue()).getUpdatedAt();
                do {
                    Object next2 = it.next();
                    long updatedAt2 = ((SessionLiveState) ((Map.Entry) next2).getValue()).getUpdatedAt();
                    if (updatedAt < updatedAt2) {
                        next = next2;
                        updatedAt = updatedAt2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null || (str5 = (String) entry.getKey()) == null) {
            return null;
        }
        return k(str5);
    }

    public static final String k(String str) {
        String strG = g(str);
        if (strG == null) {
            return null;
        }
        String strF = M0.INSTANCE.f(strG);
        return strF == null ? strG : strF;
    }

    public static final Set<String> l(HashMap<String, ?> map) {
        kotlin.jvm.internal.p.i(map, "map");
        return new HashSet(map.keySet());
    }

    public static final Map<String, SessionChatActivity> m(Map<String, SessionChatActivitySnapshot> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(Z8.Q.e(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), n((SessionChatActivitySnapshot) entry.getValue()));
        }
        return linkedHashMap;
    }

    public static final SessionChatActivity n(SessionChatActivitySnapshot sessionChatActivitySnapshot) {
        SessionActivityState sessionActivityState;
        int i10 = a.$EnumSwitchMapping$0[sessionChatActivitySnapshot.getPhase().ordinal()];
        if (i10 == 1) {
            sessionActivityState = SessionActivityState.RUNNING;
        } else if (i10 == 2) {
            sessionActivityState = SessionActivityState.WAITING_FOR_USER;
        } else if (i10 == 3) {
            sessionActivityState = SessionActivityState.COMPLETED_UNREAD;
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            sessionActivityState = SessionActivityState.FAILED;
        }
        return new SessionChatActivity(sessionActivityState, sessionChatActivitySnapshot.getAt(), sessionChatActivitySnapshot.getFailureReason(), sessionChatActivitySnapshot.getLastUserMessageAt(), sessionChatActivitySnapshot.getAskUserQuestion());
    }

    public static final SessionChatActivity o(SessionChatPhase sessionChatPhase) {
        SessionActivityState sessionActivityState;
        kotlin.jvm.internal.p.i(sessionChatPhase, "<this>");
        int i10 = a.$EnumSwitchMapping$0[sessionChatPhase.ordinal()];
        if (i10 == 1) {
            sessionActivityState = SessionActivityState.RUNNING;
        } else if (i10 == 2) {
            sessionActivityState = SessionActivityState.WAITING_FOR_USER;
        } else if (i10 == 3) {
            sessionActivityState = SessionActivityState.COMPLETED_UNREAD;
        } else {
            if (i10 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            sessionActivityState = SessionActivityState.FAILED;
        }
        return new SessionChatActivity(sessionActivityState, 0L, null, 0L, null, 28, null);
    }
}

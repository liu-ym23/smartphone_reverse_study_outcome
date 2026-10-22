package com.stepos.agentframework.chatcore.session.list;

import Ka.t;
import La.D;
import La.H;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.agentframework.adapter.agentbus.bff.PrimaryAgent;
import com.stepos.agentframework.chatcore.session.ConversationSessionIds;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000H\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\b\u001aC\u0010\t\u001a\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\r\u001a\u00020\f*\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001b\u0010\u0019\u001a\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001c\u0010\u0019\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0000¢\u0006\u0004\b \u0010!\u001a+\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0000¢\u0006\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%\"\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%¨\u0006'"}, d2 = {"", "Lw4/e;", "titles", "", "", "agentNames", "Lcom/stepos/agentframework/chatcore/session/list/g;", "pendingActions", "Lcom/stepos/agentframework/chatcore/session/list/c;", "f", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;)Lcom/stepos/agentframework/chatcore/session/list/c;", "agentInfoName", "Lcom/stepos/agentframework/chatcore/session/list/b;", "p", "(Lw4/e;Ljava/lang/String;Ljava/util/List;)Lcom/stepos/agentframework/chatcore/session/list/b;", "agentId", "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "o", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "", "isExternal", "n", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", UxipConstants.f30680s, "l", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "m", "", "agentIds", "", Const.INTENT_KEY_UMID, "(Ljava/lang/Iterable;)Ljava/util/Set;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Map;)Ljava/util/Map;", "DEFAULT_SESSION_TITLE", "Ljava/lang/String;", "EXTERNAL_AGENT_FALLBACK_NAME", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionListSnapshotStoreKt {
    private static final String DEFAULT_SESSION_TITLE = "新会话";
    private static final String EXTERNAL_AGENT_FALLBACK_NAME = "External Agent";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((w4.e) t11).getLastActiveAt()), Long.valueOf(((w4.e) t10).getLastActiveAt()));
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
            return iCompare != 0 ? iCompare : b9.b.d(((w4.e) t10).getSessionId(), ((w4.e) t11).getSessionId());
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
            return iCompare != 0 ? iCompare : b9.b.d(Long.valueOf(((w4.e) t11).getCreateTime()), Long.valueOf(((w4.e) t10).getCreateTime()));
        }
    }

    public static final Set<String> d(Iterable<String> agentIds) {
        p.i(agentIds, "agentIds");
        return (Set) SequencesKt___SequencesKt.b0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.L(F.d0(agentIds), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.list.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SessionListSnapshotStoreKt.e((String) obj);
            }
        }), SessionListSnapshotStoreKt$agentInfoLookupIds$2.INSTANCE), new LinkedHashSet());
    }

    public static final Ka.j e(String raw) {
        p.i(raw, "raw");
        return t.w(raw, j(raw));
    }

    public static final SessionListSnapshot f(List<w4.e> titles, Map<String, String> agentNames, List<SessionPendingAction> pendingActions) {
        p.i(titles, "titles");
        p.i(agentNames, "agentNames");
        p.i(pendingActions, "pendingActions");
        final Map<String, String> mapI = i(agentNames);
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : pendingActions) {
            String strL = l(((SessionPendingAction) obj).getSessionId());
            Object arrayList = linkedHashMap.get(strL);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strL, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        return new SessionListSnapshot(SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.D(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.Y(SequencesKt___SequencesKt.F(F.d0(titles), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.list.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(SessionListSnapshotStoreKt.g((w4.e) obj2));
            }
        }), new b(new c(new a()))), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.session.list.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return SessionListSnapshotStoreKt.h(mapI, linkedHashMap, (w4.e) obj2);
            }
        }), new PropertyReference1Impl() { // from class: com.stepos.agentframework.chatcore.session.list.SessionListSnapshotStoreKt$buildSessionListSnapshot$sessions$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, w9.InterfaceC5754m
            public Object get(Object obj2) {
                return ((SessionListItem) obj2).getSessionId();
            }
        })));
    }

    public static final boolean g(w4.e it) {
        p.i(it, "it");
        String strL = l(it.getSessionId());
        return (strL.length() <= 0 || it.m() || ConversationSessionIds.INSTANCE.f(strL)) ? false : true;
    }

    public static final SessionListItem h(Map map, Map map2, w4.e title) {
        p.i(title, "title");
        String str = (String) map.get(j(title.getAgentId()));
        List listM = (List) map2.get(l(title.getSessionId()));
        if (listM == null) {
            listM = C1173v.m();
        }
        return p(title, str, listM);
    }

    public static final Map<String, String> i(Map<String, String> map) {
        p.i(map, "<this>");
        Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            Pair pairA = Y8.j.a(j(str), (String) entry.getValue());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((String) entry2.getKey()).length() > 0) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap2;
    }

    public static final String j(String value) {
        p.i(value, "value");
        return H.D1(value).toString();
    }

    public static final String k(String value) {
        p.i(value, "value");
        return H.D1(value).toString();
    }

    public static final String l(String value) {
        p.i(value, "value");
        return H.D1(value).toString();
    }

    public static final String m(String value) {
        p.i(value, "value");
        String string = H.D1(value).toString();
        return string.length() == 0 ? DEFAULT_SESSION_TITLE : string;
    }

    public static final String n(String agentId, String str, boolean z10) {
        String string;
        p.i(agentId, "agentId");
        String strJ = j(agentId);
        Locale ROOT = Locale.ROOT;
        p.h(ROOT, "ROOT");
        String lowerCase = strJ.toLowerCase(ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        if (lowerCase.length() == 0) {
            return "";
        }
        ExternalAgent externalAgentB = ExternalAgent.INSTANCE.b(lowerCase);
        if (externalAgentB != null) {
            return externalAgentB.getDisplayName();
        }
        if (PrimaryAgent.INSTANCE.a(lowerCase)) {
            return PrimaryAgent.DISPLAY_NAME;
        }
        if (str != null && (string = H.D1(str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                return string;
            }
        }
        return !z10 ? PrimaryAgent.DISPLAY_NAME : EXTERNAL_AGENT_FALLBACK_NAME;
    }

    public static final SessionAgentCategory o(String agentId) {
        p.i(agentId, "agentId");
        String strJ = j(agentId);
        Locale ROOT = Locale.ROOT;
        p.h(ROOT, "ROOT");
        String lowerCase = strJ.toLowerCase(ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return (com.stepos.agentframework.adapter.agentbus.bff.j.b(lowerCase) || D.X(lowerCase, "vendor:", false, 2, null)) ? SessionAgentCategory.EXTERNAL : SessionAgentCategory.PRIMARY;
    }

    public static final SessionListItem p(w4.e eVar, String str, List<SessionPendingAction> list) {
        ConversationSessionKind conversationSessionKind;
        String str2;
        boolean z10;
        String string = H.D1(eVar.getAgentId()).toString();
        String string2 = H.D1(eVar.getDeviceId()).toString();
        SessionAgentCategory sessionAgentCategoryO = o(string);
        String strL = l(eVar.getSessionId());
        String strM = m(eVar.getTitle());
        String strN = n(string, str, sessionAgentCategoryO == SessionAgentCategory.EXTERNAL);
        long createTime = eVar.getCreateTime();
        long lastActiveAt = eVar.getLastActiveAt();
        boolean zO = eVar.o();
        boolean sendFailed = eVar.getSendFailed();
        ConversationSessionKind conversationSessionKindA = ConversationSessionKind.INSTANCE.a(eVar.getSessionKind());
        SessionAuthorizationState sessionAuthorizationStateA = h.a(list);
        if (eVar.getTitleSource() == 2) {
            conversationSessionKind = conversationSessionKindA;
            str2 = strN;
            z10 = true;
        } else {
            conversationSessionKind = conversationSessionKindA;
            str2 = strN;
            z10 = false;
        }
        return new SessionListItem(strL, string, string2, strM, str2, sessionAgentCategoryO, createTime, lastActiveAt, zO, sendFailed, conversationSessionKind, sessionAuthorizationStateA, list, z10);
    }
}

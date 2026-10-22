package com.stepos.ailauncher.chat.view;

import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.search.SessionSearchHit;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.contract.model.search.SidebarSessionKind;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\u001a1\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\n\u001a\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00002\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u000f\u001a\u0004\u0018\u00010\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0000H\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0000*\b\u0012\u0004\u0012\u00020\u00120\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0000H\u0001¢\u0006\u0004\b\u0013\u0010\u0007\u001a%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0014*\b\u0012\u0004\u0012\u00020\u00030\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\f*\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\f*\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001b\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "sessions", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "sidebarAgents", "Lcom/stepos/ailauncher/chat/view/s8;", "o", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "F", "(Ljava/util/List;Lcom/stepos/agentframework/chatcore/SessionHandler;)Lcom/stepos/ailauncher/chat/view/s8;", "", "topDeviceId", "topAgentId", "G", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/chat/view/s8;", "H", "Lcom/stepos/ailauncher/contract/model/search/SessionSearchHit;", "I", "", "B", "(Ljava/util/List;)Ljava/util/Map;", "D", "(Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;)Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "(Ljava/lang/String;)Ljava/lang/String;", "PRIMARY_AGENT_ID", "Ljava/lang/String;", "PRIMARY_AGENT_NAME", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H8 {
    private static final String PRIMARY_AGENT_ID = "agent_bus";
    private static final String PRIMARY_AGENT_NAME = "Amoo";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(Long.valueOf(((SidebarAgentItem) t11).l()), Long.valueOf(((SidebarAgentItem) t10).l()));
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
            return iCompare != 0 ? iCompare : b9.b.d(H8.E(((SidebarAgentItem) t10).getDisplayName()), H8.E(((SidebarAgentItem) t11).getDisplayName()));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public c(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(H8.E(((SidebarAgentItem) t10).getAgentId()), H8.E(((SidebarAgentItem) t11).getAgentId()));
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        final /* synthetic */ Comparator $this_thenBy;

        public d(Comparator comparator) {
            this.$this_thenBy = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.$this_thenBy.compare(t10, t11);
            return iCompare != 0 ? iCompare : b9.b.d(H8.E(((SidebarAgentItem) t10).getDeviceId()), H8.E(((SidebarAgentItem) t11).getDeviceId()));
        }
    }

    public static final Comparable A(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId();
    }

    public static final Map<String, String> B(List<IExternalAgentBindService.SidebarAgent> list) {
        Ka.j<IExternalAgentBindService.SidebarAgent> jVarF = SequencesKt___SequencesKt.F(Z8.F.d0(list), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.x8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(H8.C((IExternalAgentBindService.SidebarAgent) obj));
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (IExternalAgentBindService.SidebarAgent sidebarAgent : jVarF) {
            Pair pairA = Y8.j.a(E(sidebarAgent.getAssetId()), La.H.D1(sidebarAgent.getDisplayName()).toString());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public static final boolean C(IExternalAgentBindService.SidebarAgent it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getInstalled() && !La.H.x0(it.getAssetId());
    }

    public static final String D(IExternalAgentBindService.SidebarAgent sidebarAgent) {
        if (!sidebarAgent.getInstalled()) {
            String string = La.H.D1(sidebarAgent.getAgentType()).toString();
            if (!La.H.x0(string)) {
                return string;
            }
        }
        return La.H.D1(sidebarAgent.getAgentId()).toString();
    }

    public static final String E(String str) {
        String string = La.H.D1(str).toString();
        Locale ROOT = Locale.ROOT;
        kotlin.jvm.internal.p.h(ROOT, "ROOT");
        String lowerCase = string.toLowerCase(ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final SidebarAgentItem F(List<SidebarAgentItem> list, SessionHandler sessionHandler) {
        Object objB;
        Object objB2;
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(sessionHandler, "sessionHandler");
        AgentSession.AgentConversation agentConversationR1 = sessionHandler.R1();
        if (agentConversationR1 == null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SidebarAgentItem) next).getIsPrimary()) {
                    obj = next;
                    break;
                }
            }
            return (SidebarAgentItem) obj;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(agentConversationR1.getDeviceId());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "";
        }
        try {
            objB2 = Result.b(agentConversationR1.getAgentId());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        String str2 = (String) (Result.g(objB2) ? null : objB2);
        return G(list, str, str2 != null ? str2 : "");
    }

    public static final SidebarAgentItem G(List<SidebarAgentItem> list, String topDeviceId, String topAgentId) {
        Object next;
        Object next2;
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(topDeviceId, "topDeviceId");
        kotlin.jvm.internal.p.i(topAgentId, "topAgentId");
        Object obj = null;
        if (La.H.x0(topDeviceId)) {
            List<SidebarAgentItem> list2 = list;
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                SidebarAgentItem sidebarAgentItem = (SidebarAgentItem) next2;
                if (sidebarAgentItem.getInstalled() && !La.H.x0(sidebarAgentItem.getAssetId()) && kotlin.jvm.internal.p.d(E(sidebarAgentItem.getAssetId()), E(topAgentId))) {
                    break;
                }
            }
            SidebarAgentItem sidebarAgentItem2 = (SidebarAgentItem) next2;
            if (sidebarAgentItem2 != null) {
                return sidebarAgentItem2;
            }
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (((SidebarAgentItem) next3).getIsPrimary()) {
                    obj = next3;
                    break;
                }
            }
            return (SidebarAgentItem) obj;
        }
        List<SidebarAgentItem> list3 = list;
        Iterator<T> it3 = list3.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
            SidebarAgentItem sidebarAgentItem3 = (SidebarAgentItem) next;
            if (!sidebarAgentItem3.getIsPrimary() && kotlin.jvm.internal.p.d(sidebarAgentItem3.getDeviceId(), topDeviceId) && kotlin.jvm.internal.p.d(sidebarAgentItem3.getAgentId(), topAgentId)) {
                break;
            }
        }
        SidebarAgentItem sidebarAgentItem4 = (SidebarAgentItem) next;
        if (sidebarAgentItem4 != null) {
            return sidebarAgentItem4;
        }
        Iterator<T> it4 = list3.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            Object next4 = it4.next();
            if (((SidebarAgentItem) next4).getIsPrimary()) {
                obj = next4;
                break;
            }
        }
        return (SidebarAgentItem) obj;
    }

    public static final List<SidebarSession> H(List<SidebarSession> list, List<IExternalAgentBindService.SidebarAgent> sidebarAgents) {
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(sidebarAgents, "sidebarAgents");
        Map<String, String> mapB = B(sidebarAgents);
        com.stepos.ailauncher.chat.wake.L.INSTANCE.d(mapB);
        List<SidebarSession> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (SidebarSession sidebarSessionCopy : list2) {
            if (!sidebarSessionCopy.isExternalAgent()) {
                String strA = mapB.get(E(sidebarSessionCopy.getAgentId()));
                if (strA == null) {
                    strA = com.stepos.ailauncher.chat.wake.L.INSTANCE.a(sidebarSessionCopy.getAgentId());
                }
                if (strA != null) {
                    if (La.H.x0(strA)) {
                        strA = null;
                    }
                    String str = strA;
                    if (str != null) {
                        sidebarSessionCopy = sidebarSessionCopy.copy((1279 & 1) != 0 ? sidebarSessionCopy.sessionId : null, (1279 & 2) != 0 ? sidebarSessionCopy.agentId : null, (1279 & 4) != 0 ? sidebarSessionCopy.deviceId : null, (1279 & 8) != 0 ? sidebarSessionCopy.title : null, (1279 & 16) != 0 ? sidebarSessionCopy.agentLabel : str, (1279 & 32) != 0 ? sidebarSessionCopy.isExternalAgent : true, (1279 & 64) != 0 ? sidebarSessionCopy.createdAt : 0L, (1279 & 128) != 0 ? sidebarSessionCopy.updatedAt : 0L, (1279 & 256) != 0 ? sidebarSessionCopy.isRead : false, (1279 & 512) != 0 ? sidebarSessionCopy.sendFailed : false, (1279 & 1024) != 0 ? sidebarSessionCopy.sessionKind : null, (1279 & 2048) != 0 ? sidebarSessionCopy.activityState : null);
                    }
                }
            }
            arrayList.add(sidebarSessionCopy);
        }
        return arrayList;
    }

    public static final List<SessionSearchHit> I(List<SessionSearchHit> list, List<IExternalAgentBindService.SidebarAgent> sidebarAgents) {
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(sidebarAgents, "sidebarAgents");
        Map<String, String> mapB = B(sidebarAgents);
        com.stepos.ailauncher.chat.wake.L.INSTANCE.d(mapB);
        List<SessionSearchHit> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (SessionSearchHit sessionSearchHitCopy$default : list2) {
            if (La.H.x0(sessionSearchHitCopy$default.getAgentLabel())) {
                String strA = mapB.get(E(sessionSearchHitCopy$default.getAgentId()));
                if (strA == null) {
                    strA = com.stepos.ailauncher.chat.wake.L.INSTANCE.a(sessionSearchHitCopy$default.getAgentId());
                }
                if (strA != null) {
                    if (La.H.x0(strA)) {
                        strA = null;
                    }
                    String str = strA;
                    if (str != null) {
                        sessionSearchHitCopy$default = SessionSearchHit.copy$default(sessionSearchHitCopy$default, null, null, null, null, null, null, 0L, str, 127, null);
                    }
                }
            }
            arrayList.add(sessionSearchHitCopy$default);
        }
        return arrayList;
    }

    public static final List<SidebarAgentItem> o(List<SidebarSession> sessions, List<IExternalAgentBindService.SidebarAgent> sidebarAgents) {
        kotlin.jvm.internal.p.i(sessions, "sessions");
        kotlin.jvm.internal.p.i(sidebarAgents, "sidebarAgents");
        ArrayList arrayList = new ArrayList();
        for (Object obj : sessions) {
            if (((SidebarSession) obj).getSessionKind() != SidebarSessionKind.CHANNEL) {
                arrayList.add(obj);
            }
        }
        List<IExternalAgentBindService.SidebarAgent> list = sidebarAgents;
        final Set setF0 = SequencesKt___SequencesKt.f0(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(Z8.F.d0(list), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.u8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(H8.p((IExternalAgentBindService.SidebarAgent) obj2));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.A8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return H8.t((IExternalAgentBindService.SidebarAgent) obj2);
            }
        }));
        SidebarSession sidebarSession = (SidebarSession) SequencesKt___SequencesKt.T(SequencesKt___SequencesKt.F(Z8.F.d0(arrayList), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.B8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(H8.u(setF0, (SidebarSession) obj2));
            }
        }), b9.b.b(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.C8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return H8.v((SidebarSession) obj2);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.D8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return H8.w((SidebarSession) obj2);
            }
        }));
        Ka.j jVarF = SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.F(Z8.F.d0(arrayList), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.E8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(H8.x((SidebarSession) obj2));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.F8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(H8.y((SidebarSession) obj2));
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : jVarF) {
            SidebarSession sidebarSession2 = (SidebarSession) obj2;
            C2972t8 c2972t8A = C2972t8.Companion.a(sidebarSession2.getDeviceId(), sidebarSession2.getAgentId());
            Object arrayList2 = linkedHashMap.get(c2972t8A);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(c2972t8A, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(Z8.Q.e(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), (SidebarSession) Z8.F.I0((List) entry.getValue(), b9.b.b(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.G8
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return H8.z((SidebarSession) obj3);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.v8
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj3) {
                    return H8.A((SidebarSession) obj3);
                }
            })));
        }
        Ka.j jVarF2 = SequencesKt___SequencesKt.F(Z8.F.d0(arrayList), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.w8
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj3) {
                return Boolean.valueOf(H8.q(setF0, (SidebarSession) obj3));
            }
        });
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Object obj3 : jVarF2) {
            String strE = E(((SidebarSession) obj3).getAgentId());
            Object arrayList3 = linkedHashMap3.get(strE);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                linkedHashMap3.put(strE, arrayList3);
            }
            ((List) arrayList3).add(obj3);
        }
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(Z8.Q.e(linkedHashMap3.size()));
        for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
            linkedHashMap4.put(entry2.getKey(), (SidebarSession) Z8.F.I0((List) entry2.getValue(), b9.b.b(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.y8
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj4) {
                    return H8.r((SidebarSession) obj4);
                }
            }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.z8
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj4) {
                    return H8.s((SidebarSession) obj4);
                }
            })));
        }
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        for (IExternalAgentBindService.SidebarAgent sidebarAgent : list) {
            String strD = D(sidebarAgent);
            if (!La.H.x0(strD) && (sidebarAgent.getInstalled() || (!La.H.x0(sidebarAgent.getDeviceId()) && !La.H.x0(sidebarAgent.getAgentType())))) {
                C2972t8 c2972t8A2 = C2972t8.Companion.a(sidebarAgent.getDeviceId(), strD);
                IExternalAgentBindService.SidebarAgent sidebarAgent2 = (IExternalAgentBindService.SidebarAgent) linkedHashMap5.get(c2972t8A2);
                if (sidebarAgent2 != null && ((!sidebarAgent.getOnline() || sidebarAgent2.getOnline()) && (!La.H.x0(sidebarAgent2.getDisplayName()) || La.H.x0(sidebarAgent.getDisplayName())))) {
                    sidebarAgent = sidebarAgent2;
                }
                linkedHashMap5.put(c2972t8A2, sidebarAgent);
            }
        }
        Collection collectionValues = linkedHashMap5.values();
        kotlin.jvm.internal.p.h(collectionValues, "<get-values>(...)");
        Collection<IExternalAgentBindService.SidebarAgent> collection = collectionValues;
        ArrayList arrayList4 = new ArrayList(C1174w.x(collection, 10));
        for (IExternalAgentBindService.SidebarAgent sidebarAgent3 : collection) {
            kotlin.jvm.internal.p.f(sidebarAgent3);
            String strD2 = D(sidebarAgent3);
            String string = La.H.D1(sidebarAgent3.getDeviceId()).toString();
            String string2 = La.H.D1(sidebarAgent3.getDisplayName()).toString();
            arrayList4.add(new SidebarAgentItem(strD2, string, La.H.x0(string2) ? strD2 : string2, sidebarAgent3.getOnline(), false, sidebarAgent3.getPinned(), sidebarAgent3.getUpdateAt(), sidebarAgent3.getInstalled(), sidebarAgent3.getInstalled() ? (SidebarSession) linkedHashMap4.get(E(sidebarAgent3.getAssetId())) : (SidebarSession) linkedHashMap2.get(C2972t8.Companion.a(sidebarAgent3.getDeviceId(), sidebarAgent3.getAgentType())), sidebarAgent3.getAssetId(), sidebarAgent3.getReversionId(), sidebarAgent3.getSemver(), sidebarAgent3.getIcon()));
        }
        List listC1 = Z8.F.c1(arrayList4, new d(new c(new b(new a()))));
        if (listC1.isEmpty()) {
            return C1173v.m();
        }
        return Z8.F.S0(C1172u.e(new SidebarAgentItem(PRIMARY_AGENT_ID, "", "Amoo", true, true, false, sidebarSession != null ? sidebarSession.getUpdatedAt() : 0L, false, sidebarSession, null, null, null, null, 7680, null)), listC1);
    }

    public static final boolean p(IExternalAgentBindService.SidebarAgent it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getInstalled() && !La.H.x0(it.getAssetId());
    }

    public static final boolean q(Set set, SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return La.H.x0(it.getDeviceId()) && set.contains(E(it.getAgentId()));
    }

    public static final Comparable r(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Long.valueOf(it.getUpdatedAt());
    }

    public static final Comparable s(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId();
    }

    public static final String t(IExternalAgentBindService.SidebarAgent it) {
        kotlin.jvm.internal.p.i(it, "it");
        return E(it.getAssetId());
    }

    public static final boolean u(Set set, SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return (it.isExternalAgent() || !La.H.x0(it.getDeviceId()) || set.contains(E(it.getAgentId()))) ? false : true;
    }

    public static final Comparable v(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Long.valueOf(it.getUpdatedAt());
    }

    public static final Comparable w(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getSessionId();
    }

    public static final boolean x(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.isExternalAgent() || !La.H.x0(it.getDeviceId());
    }

    public static final boolean y(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return (La.H.x0(it.getDeviceId()) || La.H.x0(it.getAgentId())) ? false : true;
    }

    public static final Comparable z(SidebarSession it) {
        kotlin.jvm.internal.p.i(it, "it");
        return Long.valueOf(it.getUpdatedAt());
    }
}

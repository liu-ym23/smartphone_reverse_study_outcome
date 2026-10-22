package com.stepos.agentframework.chatui.util;

import La.H;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.uikit.M;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import u4.m;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u0012*\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001c\u001a\u00020\u0012*\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001f\u001a\u00020\u0012*\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/chatui/util/q;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/N1;", "item", "", "Lcom/stepos/agentframework/chatui/S1;", DidiCardProvider.KEY_ITEMS, "", "v", "(Lcom/stepos/agentframework/chatui/N1;Ljava/lang/Iterable;)Ljava/lang/String;", "z", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/lang/String;", "taskItem", "taskId", "n", "(Lcom/stepos/agentframework/chatui/N1;Ljava/lang/String;Ljava/lang/Iterable;)Lcom/stepos/agentframework/chatui/N1;", "", "t", "(Lcom/stepos/agentframework/chatui/N1;)Z", "u", "", AMapLocationStaticsEntity.FIRST_LOCATE, "second", "D", "(JJ)J", "Lcom/stepos/agentframework/chatui/P1;", "m", "(Lcom/stepos/agentframework/chatui/P1;Ljava/lang/String;)Z", "Lcom/google/gson/JsonElement;", "l", "(Lcom/google/gson/JsonElement;Ljava/lang/String;)Z", "TASK_CREATE_TOOL_NAME", "Ljava/lang/String;", "UNRESOLVED_TASK_CREATE_WINDOW_MS", "J", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class q {
    public static final q INSTANCE = new q();
    private static final String TASK_CREATE_TOOL_NAME = "task_create";
    private static final long UNRESOLVED_TASK_CREATE_WINDOW_MS = 30000;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((Comparable) ((Pair) t10).f(), (Comparable) ((Pair) t11).f());
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<Object, Boolean> {
        public static final b INSTANCE = new b();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.valueOf(obj instanceof DisplayMessage);
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
            return iCompare != 0 ? iCompare : b9.b.d(Long.valueOf(((DisplayMessage) ((Pair) t11).e()).getTime()), Long.valueOf(((DisplayMessage) ((Pair) t10).e()).getTime()));
        }
    }

    public static final boolean A(DisplayChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TEXT;
    }

    public static final String B(DisplayMessage displayMessage, DisplayChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return M.c(com.stepos.agentframework.chatui.util.a.INSTANCE.a(displayMessage.getAgentId(), r.INSTANCE.a(O6.f.INSTANCE.b(it.getContent().h()))));
    }

    public static final boolean C(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.length() > 0;
    }

    public static final boolean o(DisplayMessage displayMessage, DisplayMessage candidate) {
        kotlin.jvm.internal.p.i(candidate, "candidate");
        return !kotlin.jvm.internal.p.d(candidate.getMessageId(), displayMessage.getMessageId()) && kotlin.jvm.internal.p.d(candidate.getSessionId(), displayMessage.getSessionId()) && candidate.getRole() == AgentRole.ASSISTANT && INSTANCE.z(candidate).length() > 0;
    }

    public static final boolean p(DisplayMessage candidate) {
        kotlin.jvm.internal.p.i(candidate, "candidate");
        return INSTANCE.t(candidate);
    }

    public static final boolean q(DisplayMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return INSTANCE.u(it);
    }

    public static final Pair r(DisplayMessage displayMessage, DisplayMessage candidate) {
        kotlin.jvm.internal.p.i(candidate, "candidate");
        return Y8.j.a(candidate, Long.valueOf(INSTANCE.D(candidate.getTime(), displayMessage.getTime())));
    }

    public static final boolean s(Pair pair) {
        kotlin.jvm.internal.p.i(pair, "<destruct>");
        return ((Number) pair.b()).longValue() <= 30000;
    }

    public static final boolean w(DisplayChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getType() == AgentMessageType.TASK;
    }

    public static final String x(DisplayChatMessage it) {
        kotlin.jvm.internal.p.i(it, "it");
        u4.m content = it.getContent();
        m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
        if (taskMessage != null) {
            return taskMessage.getTaskId();
        }
        return null;
    }

    public static final boolean y(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !H.x0(it);
    }

    public final long D(long first, long second) {
        if (first <= 0 || second <= 0) {
            return Long.MAX_VALUE;
        }
        return first >= second ? first - second : second - first;
    }

    public final boolean l(JsonElement jsonElement, String str) {
        boolean zL;
        if (!jsonElement.isJsonObject()) {
            if (jsonElement.isJsonArray()) {
                Iterable<JsonElement> asJsonArray = jsonElement.getAsJsonArray();
                kotlin.jvm.internal.p.h(asJsonArray, "getAsJsonArray(...)");
                if ((asJsonArray instanceof Collection) && ((Collection) asJsonArray).isEmpty()) {
                    return false;
                }
                for (JsonElement jsonElement2 : asJsonArray) {
                    q qVar = INSTANCE;
                    kotlin.jvm.internal.p.f(jsonElement2);
                    if (qVar.l(jsonElement2, str)) {
                        return true;
                    }
                }
            }
            return false;
        }
        Set<Map.Entry<String, JsonElement>> setEntrySet = jsonElement.getAsJsonObject().entrySet();
        kotlin.jvm.internal.p.h(setEntrySet, "entrySet(...)");
        Set<Map.Entry<String, JsonElement>> set = setEntrySet;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.jvm.internal.p.f(entry);
            String str2 = (String) entry.getKey();
            JsonElement jsonElement3 = (JsonElement) entry.getValue();
            if (kotlin.jvm.internal.p.d(str2, "taskId") || kotlin.jvm.internal.p.d(str2, "task_id")) {
                zL = jsonElement3.isJsonPrimitive() && kotlin.jvm.internal.p.d(jsonElement3.getAsString(), str);
            } else {
                q qVar2 = INSTANCE;
                kotlin.jvm.internal.p.f(jsonElement3);
                zL = qVar2.l(jsonElement3, str);
            }
            if (zL) {
                return true;
            }
        }
        return false;
    }

    public final boolean m(DisplayTool displayTool, String str) {
        Object objB;
        if (!kotlin.jvm.internal.p.d(displayTool.getName(), TASK_CREATE_TOOL_NAME) || H.x0(displayTool.getResult())) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(JsonParser.parseString(displayTool.getResult()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JsonElement jsonElement = (JsonElement) objB;
        if (jsonElement == null) {
            return false;
        }
        return l(jsonElement, str);
    }

    public final DisplayMessage n(final DisplayMessage taskItem, String taskId, Iterable<? extends S1> items) {
        Object next;
        Ka.j jVarF = SequencesKt___SequencesKt.F(F.d0(items), b.INSTANCE);
        kotlin.jvm.internal.p.g(jVarF, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        List listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.F(jVarF, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.j
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(q.o(taskItem, (DisplayMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(q.p((DisplayMessage) obj));
            }
        }));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listD0) {
            List<DisplayChatMessage> listM = ((DisplayMessage) obj).m();
            if (!(listM instanceof Collection) || !listM.isEmpty()) {
                Iterator<T> it = listM.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
                    if (listF == null) {
                        listF = C1173v.m();
                    }
                    List<DisplayTool> list = listF;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it2 = list.iterator();
                        while (it2.hasNext()) {
                            if (INSTANCE.m((DisplayTool) it2.next(), taskId)) {
                                arrayList.add(obj);
                                break;
                            }
                        }
                    }
                }
            }
        }
        Iterator it3 = arrayList.iterator();
        if (it3.hasNext()) {
            next = it3.next();
            if (it3.hasNext()) {
                long time = ((DisplayMessage) next).getTime();
                do {
                    Object next2 = it3.next();
                    long time2 = ((DisplayMessage) next2).getTime();
                    if (time < time2) {
                        next = next2;
                        time = time2;
                    }
                } while (it3.hasNext());
            }
        } else {
            next = null;
        }
        DisplayMessage displayMessage = (DisplayMessage) next;
        if (displayMessage != null) {
            return displayMessage;
        }
        Pair pair = (Pair) SequencesKt___SequencesKt.U(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(F.d0(listD0), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(q.q((DisplayMessage) obj2));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return q.r(taskItem, (DisplayMessage) obj2);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(q.s((Pair) obj2));
            }
        }), new c(new a()));
        if (pair != null) {
            return (DisplayMessage) pair.e();
        }
        return null;
    }

    public final boolean t(DisplayMessage displayMessage) {
        List<DisplayChatMessage> listM = displayMessage.m();
        if ((listM instanceof Collection) && listM.isEmpty()) {
            return false;
        }
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF == null) {
                listF = C1173v.m();
            }
            List<DisplayTool> list = listF;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (kotlin.jvm.internal.p.d(((DisplayTool) it2.next()).getName(), TASK_CREATE_TOOL_NAME)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean u(DisplayMessage displayMessage) {
        List<DisplayChatMessage> listM = displayMessage.m();
        if ((listM instanceof Collection) && listM.isEmpty()) {
            return false;
        }
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF == null) {
                listF = C1173v.m();
            }
            List<DisplayTool> list = listF;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (DisplayTool displayTool : list) {
                    if (kotlin.jvm.internal.p.d(displayTool.getName(), TASK_CREATE_TOOL_NAME) && H.x0(displayTool.getResult())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final String v(DisplayMessage item, Iterable<? extends S1> items) {
        kotlin.jvm.internal.p.i(item, "item");
        kotlin.jvm.internal.p.i(items, "items");
        String strZ = z(item);
        if (strZ.length() > 0) {
            return strZ;
        }
        List listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.B(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.S(SequencesKt___SequencesKt.F(F.d0(item.m()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(q.w((DisplayChatMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return q.x((DisplayChatMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(q.y((String) obj));
            }
        })));
        if (listD0.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listD0.iterator();
        while (it.hasNext()) {
            DisplayMessage displayMessageN = INSTANCE.n(item, (String) it.next(), items);
            if (displayMessageN != null) {
                arrayList.add(displayMessageN);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(z((DisplayMessage) it2.next()));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList3.add(obj);
            }
        }
        return F.A0(F.g0(arrayList3), "\n", null, null, 0, null, null, 62, null);
    }

    public final String z(final DisplayMessage item) {
        kotlin.jvm.internal.p.i(item, "item");
        return SequencesKt___SequencesKt.O(SequencesKt___SequencesKt.F(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.F(F.d0(item.m()), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.o
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(q.A((DisplayChatMessage) obj));
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return q.B(item, (DisplayChatMessage) obj);
            }
        }), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.util.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(q.C((String) obj));
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }
}

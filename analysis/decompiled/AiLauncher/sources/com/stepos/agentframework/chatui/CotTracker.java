package com.stepos.agentframework.chatui;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatui.CotTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\b*\u0001'\u0018\u0000 *2\u00020\u0001:\u0003+,-B?\b\u0000\u0012*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00032\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0004H\u0002¢\u0006\u0004\b!\u0010\"J3\u0010#\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0004H\u0002¢\u0006\u0004\b#\u0010$R8\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010%R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/stepos/agentframework/chatui/CotTracker;", "", "Lkotlin/Function3;", "", "", "LY8/t;", "report", "", "capacity", "<init>", "(Lp9/q;I)V", "Lcom/stepos/agentframework/chatui/N1;", "message", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatui/N1;)V", "Lcom/stepos/agentframework/chatui/CotTracker$Section;", "section", "", "expanded", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/CotTracker$Section;Z)V", "Lcom/stepos/agentframework/chatui/P1;", "tool", "k", "(Lcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/P1;)V", "constraintCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatui/N1;Ljava/lang/Integer;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatui/N1;)Z", "event", "item", "attrs", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/N1;Ljava/lang/String;Ljava/util/Map;)V", "c", "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/N1;Ljava/util/Map;)V", "Lp9/q;", "I", "com/stepos/agentframework/chatui/CotTracker$exposures$1", "exposures", "Lcom/stepos/agentframework/chatui/CotTracker$exposures$1;", "Companion", "Section", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CotTracker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final CotTracker shared;
    private final int capacity;
    private final CotTracker$exposures$1 exposures;
    private final p9.q<String, String, Map<String, String>, Y8.t> report;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/chatui/CotTracker$Section;", "", UxipConstants.f30680s, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REASONING", "TOOLCALL", "RESULT", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Section {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Section[] $VALUES;
        private final String value;
        public static final Section REASONING = new Section("REASONING", 0, "reasoning");
        public static final Section TOOLCALL = new Section("TOOLCALL", 1, "toolcall");
        public static final Section RESULT = new Section("RESULT", 2, "result");

        private static final /* synthetic */ Section[] $values() {
            return new Section[]{REASONING, TOOLCALL, RESULT};
        }

        static {
            Section[] sectionArr$values = $values();
            $VALUES = sectionArr$values;
            $ENTRIES = kotlin.enums.a.a(sectionArr$values);
        }

        private Section(String str, int i10, String str2) {
            this.value = str2;
        }

        public static InterfaceC4149a<Section> getEntries() {
            return $ENTRIES;
        }

        public static Section valueOf(String str) {
            return (Section) Enum.valueOf(Section.class, str);
        }

        public static Section[] values() {
            return (Section[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatui/CotTracker$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/N1;", "message", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/N1;)Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/CotTracker;", "shared", "Lcom/stepos/agentframework/chatui/CotTracker;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatui/CotTracker;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.CotTracker$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final CotTracker a() {
            return CotTracker.shared;
        }

        public final String b(DisplayMessage message) {
            String taskId;
            kotlin.jvm.internal.p.i(message, "message");
            List<DisplayChatMessage> listM = message.m();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listM.iterator();
            while (it.hasNext()) {
                u4.m content = ((DisplayChatMessage) it.next()).getContent();
                String str = null;
                m.TaskMessage taskMessage = content instanceof m.TaskMessage ? (m.TaskMessage) content : null;
                if (taskMessage != null && (taskId = taskMessage.getTaskId()) != null && !La.H.x0(taskId)) {
                    str = taskId;
                }
                if (str != null) {
                    arrayList.add(str);
                }
            }
            String str2 = (String) Z8.F.Z0(Z8.F.g0(arrayList));
            return str2 == null ? "" : str2;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatui/CotTracker$b;", "", "", "session", "message", "event", "item", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSession", "getMessage", "getEvent", "getItem", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.CotTracker$b, reason: from toString */
    public static final /* data */ class ExposureKey {
        private final String event;
        private final String item;
        private final String message;
        private final String session;

        public ExposureKey(String session, String message, String event, String item) {
            kotlin.jvm.internal.p.i(session, "session");
            kotlin.jvm.internal.p.i(message, "message");
            kotlin.jvm.internal.p.i(event, "event");
            kotlin.jvm.internal.p.i(item, "item");
            this.session = session;
            this.message = message;
            this.event = event;
            this.item = item;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExposureKey)) {
                return false;
            }
            ExposureKey exposureKey = (ExposureKey) other;
            return kotlin.jvm.internal.p.d(this.session, exposureKey.session) && kotlin.jvm.internal.p.d(this.message, exposureKey.message) && kotlin.jvm.internal.p.d(this.event, exposureKey.event) && kotlin.jvm.internal.p.d(this.item, exposureKey.item);
        }

        public int hashCode() {
            return (((((this.session.hashCode() * 31) + this.message.hashCode()) * 31) + this.event.hashCode()) * 31) + this.item.hashCode();
        }

        public String toString() {
            return "ExposureKey(session=" + this.session + ", message=" + this.message + ", event=" + this.event + ", item=" + this.item + ")";
        }
    }

    static {
        kotlin.jvm.internal.i iVar = null;
        INSTANCE = new Companion(iVar);
        shared = new CotTracker(new CotTracker$Companion$shared$1(kotlin.N.INSTANCE), 0, 2, iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.stepos.agentframework.chatui.CotTracker$exposures$1] */
    public CotTracker(p9.q<? super String, ? super String, ? super Map<String, String>, Y8.t> report, int i10) {
        kotlin.jvm.internal.p.i(report, "report");
        this.report = report;
        this.capacity = i10;
        this.exposures = new LinkedHashMap<ExposureKey, Y8.t>() { // from class: com.stepos.agentframework.chatui.CotTracker$exposures$1
            {
                super(16, 0.75f, true);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof CotTracker.ExposureKey) {
                    return d((CotTracker.ExposureKey) obj);
                }
                return false;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof Y8.t) {
                    return g((Y8.t) obj);
                }
                return false;
            }

            public /* bridge */ boolean d(CotTracker.ExposureKey exposureKey) {
                return super.containsKey(exposureKey);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<CotTracker.ExposureKey, Y8.t>> entrySet() {
                return i();
            }

            public /* bridge */ boolean g(Y8.t tVar) {
                return super.containsValue(tVar);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj instanceof CotTracker.ExposureKey) {
                    return h((CotTracker.ExposureKey) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                if (!(obj instanceof CotTracker.ExposureKey)) {
                    return obj2;
                }
                n((CotTracker.ExposureKey) obj, (Y8.t) obj2);
                return Y8.t.f7040a;
            }

            public /* bridge */ Y8.t h(CotTracker.ExposureKey exposureKey) {
                return (Y8.t) super.get(exposureKey);
            }

            public /* bridge */ Set<Map.Entry<CotTracker.ExposureKey, Y8.t>> i() {
                return super.entrySet();
            }

            public /* bridge */ Set<CotTracker.ExposureKey> j() {
                return super.keySet();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<CotTracker.ExposureKey> keySet() {
                return j();
            }

            public /* bridge */ void n(CotTracker.ExposureKey exposureKey, Y8.t tVar) {
                super.getOrDefault(exposureKey, tVar);
            }

            public /* bridge */ int q() {
                return super.size();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj instanceof CotTracker.ExposureKey) {
                    return t((CotTracker.ExposureKey) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<CotTracker.ExposureKey, Y8.t> eldest) {
                kotlin.jvm.internal.p.i(eldest, "eldest");
                return size() > this.this$0.capacity;
            }

            public /* bridge */ Collection<Y8.t> s() {
                return super.values();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return q();
            }

            public /* bridge */ Y8.t t(CotTracker.ExposureKey exposureKey) {
                return (Y8.t) super.remove(exposureKey);
            }

            public /* bridge */ boolean u(CotTracker.ExposureKey exposureKey, Y8.t tVar) {
                return super.remove(exposureKey, tVar);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<Y8.t> values() {
                return s();
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof CotTracker.ExposureKey) && (obj2 instanceof Y8.t)) {
                    return u((CotTracker.ExposureKey) obj, (Y8.t) obj2);
                }
                return false;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(CotTracker cotTracker, String str, DisplayMessage displayMessage, String str2, Map map, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "";
        }
        if ((i10 & 8) != 0) {
            map = kotlin.collections.a.i();
        }
        cotTracker.e(str, displayMessage, str2, map);
    }

    public static /* synthetic */ void j(CotTracker cotTracker, DisplayMessage displayMessage, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        cotTracker.i(displayMessage, num);
    }

    public final void c(String event, DisplayMessage message, Map<String, String> attrs) {
        this.report.invoke(event, "chatview", kotlin.collections.a.r(Z8.Q.f(Y8.j.a("task_id", INSTANCE.b(message))), attrs));
    }

    public final void d(DisplayMessage message, Section section, boolean expanded) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(section, "section");
        c(expanded ? "cot_expand_click" : "cot_collapse_click", message, Z8.Q.f(Y8.j.a("type", section.getValue())));
    }

    public final void e(String event, DisplayMessage message, String item, Map<String, String> attrs) {
        if (La.H.x0(message.getMessageId())) {
            return;
        }
        if (put(new ExposureKey(message.getSessionId(), message.getMessageId(), event, item), Y8.t.f7040a) != null) {
            return;
        }
        c(event, message, attrs);
    }

    public final boolean g(DisplayMessage message) {
        int iNextIndex;
        kotlin.jvm.internal.p.i(message, "message");
        if (message.getRole() == AgentRole.ASSISTANT && message.getStatus() == EReplyStatus.COMPLETED) {
            List<DisplayChatMessage> listM = message.m();
            ListIterator<DisplayChatMessage> listIterator = listM.listIterator(listM.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    iNextIndex = -1;
                    break;
                }
                if (listIterator.previous().getType() == AgentMessageType.TOOL) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            }
            if (iNextIndex < 0) {
                return false;
            }
            List<DisplayChatMessage> listM2 = message.m();
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (Object obj : listM2) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                Integer numValueOf = Integer.valueOf(i10);
                if (((DisplayChatMessage) obj).getType() != AgentMessageType.TEXT) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    arrayList.add(numValueOf);
                }
                i10 = i11;
            }
            int iA = H1.INSTANCE.a(arrayList, iNextIndex);
            if (iA >= 0 && !La.H.x0(message.m().get(iA).getContent().h())) {
                return true;
            }
        }
        return false;
    }

    public final void h(DisplayMessage message) {
        kotlin.jvm.internal.p.i(message, "message");
        f(this, "cot_intent_show", message, null, null, 12, null);
    }

    public final void i(DisplayMessage message, Integer constraintCount) {
        kotlin.jvm.internal.p.i(message, "message");
        if ((constraintCount == null || constraintCount.intValue() >= 0) && g(message)) {
            Map mapF = constraintCount != null ? Z8.Q.f(Y8.j.a("constraint_count", String.valueOf(constraintCount.intValue()))) : null;
            if (mapF == null) {
                mapF = kotlin.collections.a.i();
            }
            f(this, "cot_summary_show", message, null, mapF, 4, null);
        }
    }

    public final void k(DisplayMessage message, DisplayTool tool) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(tool, "tool");
        if (La.H.x0(tool.getToolCallId()) || La.H.x0(tool.getName())) {
            return;
        }
        String str = tool.getIsFinished() ? "done" : "running";
        e("cot_toolcall_show", message, tool.getToolCallId() + ServerSentEventKt.COLON + str, kotlin.collections.a.m(Y8.j.a("tool_name", tool.getName()), Y8.j.a("status", str)));
    }

    public /* synthetic */ CotTracker(p9.q qVar, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(qVar, (i11 & 2) != 0 ? com.stepos.agentframework.chatui.longtext.b.THRESHOLD : i10);
    }
}

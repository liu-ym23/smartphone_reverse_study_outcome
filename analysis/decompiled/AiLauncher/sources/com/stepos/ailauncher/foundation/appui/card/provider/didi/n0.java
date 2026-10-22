package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import N5.BizChannelIcon;
import N5.CardEnvelope;
import N5.CardLinks;
import N5.CardSearchSource;
import N5.CardSummary;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.n0;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001dJ?\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001f2\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"JO\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001f2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001f2\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001fH\u0002¢\u0006\u0004\b#\u0010$J/\u0010'\u001a\u0004\u0018\u00010\u00012\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\u0006\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010.¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/n0;", "", "<init>", "()V", "", "orderNo", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/n0$a;", "k", "(Ljava/lang/String;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/n0$a;", "LN5/i;", "envelope", "LY8/t;", "l", "(Ljava/lang/String;LN5/i;)V", "", D6.a.KEY_TASK_STATUS, "m", "(Ljava/lang/String;LN5/i;Ljava/lang/Integer;)V", "Lcom/google/gson/JsonObject;", "snapshot", "taskStatusFromResponse", "c", "(Lcom/google/gson/JsonObject;Ljava/lang/Integer;)LN5/i;", "prev", "next", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LN5/i;LN5/i;)LN5/i;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LN5/i;)Z", Const.INTENT_KEY_UMID, "", "businessData", "e", "(Lcom/google/gson/JsonObject;Ljava/util/Map;)Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "data", "key", "f", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)Z", "", "ORDER_INVARIANT_KEYS", "Ljava/util/List;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Ljava/util/concurrent/ConcurrentHashMap;", "envelopes", "Ljava/util/concurrent/ConcurrentHashMap;", "KEY_ITEMS", "Ljava/lang/String;", "KEY_TRIP", "TRIP_ENDPOINT_KEYS", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class n0 {
    private static final String KEY_ITEMS = "items";
    private static final String KEY_TRIP = "trip";
    public static final n0 INSTANCE = new n0();
    private static final List<String> ORDER_INVARIANT_KEYS = C1173v.p("productName", "carTypeName", "phoneNumberSuffix", "accountTail");
    private static final Gson gson = new Gson();
    private static final ConcurrentHashMap<String, Snapshot> envelopes = new ConcurrentHashMap<>();
    private static final List<String> TRIP_ENDPOINT_KEYS = C1173v.p("pickup", "dropoff");

    public static final Snapshot n(Integer num, Snapshot snapshot, String str, Snapshot snapshot2) {
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return (snapshot2 == null || o0.INSTANCE.g(snapshot2.getTaskStatus(), num)) ? snapshot : snapshot2;
    }

    public static final Snapshot o(p9.p pVar, Object obj, Object obj2) {
        return (Snapshot) pVar.invoke(obj, obj2);
    }

    public final CardEnvelope c(JsonObject snapshot, Integer taskStatusFromResponse) {
        Object objB;
        kotlin.jvm.internal.p.i(snapshot, "snapshot");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b((CardEnvelope) gson.fromJson((JsonElement) snapshot, CardEnvelope.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        CardEnvelope cardEnvelope = (CardEnvelope) objB;
        if (cardEnvelope == null) {
            return null;
        }
        return CardEnvelope.b(cardEnvelope, O5.c.DIDI, null, null, null, null, null, taskStatusFromResponse == null ? cardEnvelope.getTaskStatus() : taskStatusFromResponse, null, null, null, null, null, null, e(snapshot, cardEnvelope.e()), null, null, null, 122814, null);
    }

    public final boolean d(CardEnvelope envelope) {
        Object obj;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        Map<String, Object> mapE = envelope.e();
        return mapE != null && (obj = mapE.get("items")) != null && (obj instanceof List) && ((List) obj).isEmpty();
    }

    public final Map<String, Object> e(JsonObject snapshot, Map<String, ? extends Object> businessData) {
        JsonElement jsonElement;
        List<String> list = TRIP_ENDPOINT_KEYS;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Pair pairA = null;
            if ((businessData == null || !businessData.containsKey(str)) && (jsonElement = snapshot.get(str)) != null) {
                if (jsonElement.isJsonPrimitive()) {
                    String asString = jsonElement.getAsString();
                    if (asString != null) {
                        if (La.H.x0(asString)) {
                            asString = null;
                        }
                        if (asString != null) {
                            pairA = Y8.j.a(str, asString);
                        }
                    }
                } else {
                    R5.b.INSTANCE.h("didi.endpoint.hoist.skipped", Y8.j.a("key", str), Y8.j.a("reason", "not_a_string"));
                }
            }
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        if (arrayList.isEmpty()) {
            return businessData;
        }
        Map mapC = Z8.Q.c();
        if (businessData != null) {
            mapC.putAll(businessData);
        }
        kotlin.collections.a.u(mapC, arrayList);
        return Z8.Q.b(mapC);
    }

    public final Object f(Map<String, ? extends Object> data, String key) {
        Object obj;
        Object obj2;
        Object obj3 = data.get(key);
        if (obj3 != null) {
            if (INSTANCE.g(obj3)) {
                obj3 = null;
            }
            if (obj3 != null) {
                return obj3;
            }
        }
        Object obj4 = data.get("items");
        List list = obj4 instanceof List ? (List) obj4 : null;
        Object objS0 = list != null ? Z8.F.s0(list) : null;
        Map map = objS0 instanceof Map ? (Map) objS0 : null;
        if (map != null && (obj2 = map.get(key)) != null) {
            if (INSTANCE.g(obj2)) {
                obj2 = null;
            }
            if (obj2 != null) {
                return obj2;
            }
        }
        Object obj5 = data.get(KEY_TRIP);
        Map map2 = obj5 instanceof Map ? (Map) obj5 : null;
        if (map2 != null && (obj = map2.get(key)) != null) {
            if (INSTANCE.g(obj)) {
                obj = null;
            }
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }

    public final boolean g(Object value) {
        if (value != null) {
            return (value instanceof String) && La.H.x0((CharSequence) value);
        }
        return true;
    }

    public final boolean h(CardEnvelope envelope) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
        Map<String, Object> mapE = envelope.e();
        return mapE == null || mapE.isEmpty();
    }

    public final Map<String, Object> i(Map<String, ? extends Object> prev, Map<String, ? extends Object> next) {
        Object objF;
        if (next == null || prev == null) {
            return next;
        }
        List<String> list = ORDER_INVARIANT_KEYS;
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str : list) {
            n0 n0Var = INSTANCE;
            Pair pairA = null;
            if (n0Var.g(next.get(str)) && (objF = n0Var.f(prev, str)) != null) {
                pairA = Y8.j.a(str, objF);
            }
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        if (arrayList.isEmpty()) {
            return next;
        }
        Map<String, Object> mapC = kotlin.collections.a.C(next);
        for (Pair pair : arrayList) {
            mapC.put((String) pair.a(), pair.b());
        }
        return mapC;
    }

    public final CardEnvelope j(CardEnvelope prev, CardEnvelope next) {
        kotlin.jvm.internal.p.i(next, "next");
        if (prev == null) {
            return next;
        }
        String taskTitle = next.getTaskTitle();
        if (taskTitle == null) {
            taskTitle = prev.getTaskTitle();
        }
        String str = taskTitle;
        String sessionId = next.getSessionId();
        if (sessionId == null) {
            sessionId = prev.getSessionId();
        }
        String str2 = sessionId;
        String displayMode = next.getDisplayMode();
        if (displayMode == null) {
            displayMode = prev.getDisplayMode();
        }
        String str3 = displayMode;
        String bizChannel = next.getBizChannel();
        if (bizChannel == null) {
            bizChannel = prev.getBizChannel();
        }
        String str4 = bizChannel;
        BizChannelIcon bizChannelIcon = next.getBizChannelIcon();
        if (bizChannelIcon == null) {
            bizChannelIcon = prev.getBizChannelIcon();
        }
        BizChannelIcon bizChannelIcon2 = bizChannelIcon;
        CardSummary summary = next.getSummary();
        if (summary == null) {
            summary = prev.getSummary();
        }
        CardSummary cardSummary = summary;
        CardLinks links = next.getLinks();
        if (links == null) {
            links = prev.getLinks();
        }
        CardLinks cardLinks = links;
        CardSearchSource searchSource = next.getSearchSource();
        if (searchSource == null) {
            searchSource = prev.getSearchSource();
        }
        return CardEnvelope.b(next, null, null, str2, null, null, str, null, str3, str4, bizChannelIcon2, cardSummary, cardLinks, searchSource, i(prev.e(), next.e()), null, null, null, 114779, null);
    }

    public final Snapshot k(String orderNo) {
        kotlin.jvm.internal.p.i(orderNo, "orderNo");
        return envelopes.get(orderNo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(String orderNo, CardEnvelope envelope) {
        kotlin.jvm.internal.p.i(orderNo, "orderNo");
        kotlin.jvm.internal.p.i(envelope, "envelope");
        envelopes.put(orderNo, new Snapshot(envelope, null, 2, 0 == true ? 1 : 0));
    }

    public final void m(String orderNo, CardEnvelope envelope, final Integer taskStatus) {
        kotlin.jvm.internal.p.i(orderNo, "orderNo");
        kotlin.jvm.internal.p.i(envelope, "envelope");
        final Snapshot snapshot = new Snapshot(envelope, taskStatus);
        ConcurrentHashMap<String, Snapshot> concurrentHashMap = envelopes;
        final p9.p pVar = new p9.p() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.l0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return n0.n(taskStatus, snapshot, (String) obj, (n0.Snapshot) obj2);
            }
        };
        concurrentHashMap.compute(orderNo, new BiFunction() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.m0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return n0.o(pVar, obj, obj2);
            }
        });
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/n0$a;", "", "LN5/i;", "envelope", "", D6.a.KEY_TASK_STATUS, "<init>", "(LN5/i;Ljava/lang/Integer;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LN5/i;", Const.INTENT_KEY_APIKEY, "()LN5/i;", "Ljava/lang/Integer;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.didi.n0$a, reason: from toString */
    public static final /* data */ class Snapshot {
        private final CardEnvelope envelope;
        private final Integer taskStatus;

        public Snapshot(CardEnvelope envelope, Integer num) {
            kotlin.jvm.internal.p.i(envelope, "envelope");
            this.envelope = envelope;
            this.taskStatus = num;
        }

        /* renamed from: a, reason: from getter */
        public final CardEnvelope getEnvelope() {
            return this.envelope;
        }

        /* renamed from: b, reason: from getter */
        public final Integer getTaskStatus() {
            return this.taskStatus;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return kotlin.jvm.internal.p.d(this.envelope, snapshot.envelope) && kotlin.jvm.internal.p.d(this.taskStatus, snapshot.taskStatus);
        }

        public int hashCode() {
            int iHashCode = this.envelope.hashCode() * 31;
            Integer num = this.taskStatus;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Snapshot(envelope=" + this.envelope + ", taskStatus=" + this.taskStatus + ")";
        }

        public /* synthetic */ Snapshot(CardEnvelope cardEnvelope, Integer num, int i10, kotlin.jvm.internal.i iVar) {
            this(cardEnvelope, (i10 & 2) != 0 ? cardEnvelope.getTaskStatus() : num);
        }
    }
}

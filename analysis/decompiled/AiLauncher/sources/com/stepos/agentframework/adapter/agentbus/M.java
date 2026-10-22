package com.stepos.agentframework.adapter.agentbus;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/M;", "", "<init>", "()V", "", "", "payload", "Lcom/stepos/agentframework/adapter/agentbus/M$a;", Const.INTENT_KEY_UMID, "(Ljava/util/Map;)Lcom/stepos/agentframework/adapter/agentbus/M$a;", "result", "e", "(Ljava/lang/Object;)Ljava/lang/String;", "PHASE_RESULT", "Ljava/lang/String;", "", "EMPTY_PAYLOADS", "Ljava/util/Set;", "Lcom/google/gson/Gson;", "gson$delegate", "LY8/h;", Const.INTENT_KEY_PKGNAME, "()Lcom/google/gson/Gson;", "gson", Const.INTENT_KEY_APIKEY, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class M {
    public static final String PHASE_RESULT = "result";
    public static final M INSTANCE = new M();
    private static final Set<String> EMPTY_PAYLOADS = Y.j("null", "{}", "[]");

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Y8.h gson = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.agentbus.L
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return M.c();
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/M$a;", "", "", "name", "resultJson", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.M$a, reason: from toString */
    public static final /* data */ class CardPayload {
        private final String name;
        private final String resultJson;

        public CardPayload(String name, String resultJson) {
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(resultJson, "resultJson");
            this.name = name;
            this.resultJson = resultJson;
        }

        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: b, reason: from getter */
        public final String getResultJson() {
            return this.resultJson;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CardPayload)) {
                return false;
            }
            CardPayload cardPayload = (CardPayload) other;
            return kotlin.jvm.internal.p.d(this.name, cardPayload.name) && kotlin.jvm.internal.p.d(this.resultJson, cardPayload.resultJson);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.resultJson.hashCode();
        }

        public String toString() {
            return "CardPayload(name=" + this.name + ", resultJson=" + this.resultJson + ")";
        }
    }

    public static final Gson c() {
        return new Gson();
    }

    public final Gson b() {
        return (Gson) gson.getValue();
    }

    public final CardPayload d(Map<String, ? extends Object> payload) {
        String strE;
        kotlin.jvm.internal.p.i(payload, "payload");
        Object obj = payload.get("data");
        Map<String, ? extends Object> map = obj instanceof Map ? (Map) obj : null;
        if (map != null) {
            payload = map;
        }
        Object obj2 = payload.get("phase");
        String str = obj2 instanceof String ? (String) obj2 : null;
        String string = str != null ? La.H.D1(str).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() > 0 && !kotlin.jvm.internal.p.d(string, "result")) {
            return null;
        }
        Object obj3 = payload.get("name");
        String str2 = obj3 instanceof String ? (String) obj3 : null;
        String string2 = str2 != null ? La.H.D1(str2).toString() : null;
        String str3 = string2 != null ? string2 : "";
        if (str3.length() == 0 || (strE = e(payload.get("result"))) == null) {
            return null;
        }
        return new CardPayload(str3, strE);
    }

    public final String e(Object result) {
        Object objB;
        if (result == null) {
            return null;
        }
        if (result instanceof String) {
            String string = La.H.D1((String) result).toString();
            if (string.length() <= 0 || EMPTY_PAYLOADS.contains(string)) {
                return null;
            }
            return string;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(b().toJson(result));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || str.length() <= 0 || EMPTY_PAYLOADS.contains(str)) {
            return null;
        }
        return str;
    }
}

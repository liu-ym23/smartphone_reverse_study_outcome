package com.stepos.agentframework.adapter.agentbus;

import Z8.C1165m;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.agentbus.K;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 #2\u00020\u0001:\u0002$%B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/K;", "", "", "maxEntries", "minMatchLen", "<init>", "(II)V", "", "sessionId", "query", "text", "LY8/t;", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "inbound", "", "isRegenerate", "isFinish", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;", Parameters.SESSION_ID, "q", "inboundTrim", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "prev", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;)Z", "I", "LZ8/m;", "Lcom/stepos/agentframework/adapter/agentbus/K$b;", "recent", "LZ8/m;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class K {
    private static final int PROBE_LEN = 48;
    private final int maxEntries;
    private final int minMatchLen;
    private final C1165m<Entry> recent;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/K$b;", "", "", "sessionId", "query", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.K$b, reason: from toString */
    public static final /* data */ class Entry {
        private final String query;
        private final String sessionId;
        private final String text;

        public Entry(String sessionId, String query, String text) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(query, "query");
            kotlin.jvm.internal.p.i(text, "text");
            this.sessionId = sessionId;
            this.query = query;
            this.text = text;
        }

        /* renamed from: a, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        /* renamed from: b, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        /* renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) other;
            return kotlin.jvm.internal.p.d(this.sessionId, entry.sessionId) && kotlin.jvm.internal.p.d(this.query, entry.query) && kotlin.jvm.internal.p.d(this.text, entry.text);
        }

        public int hashCode() {
            return (((this.sessionId.hashCode() * 31) + this.query.hashCode()) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Entry(sessionId=" + this.sessionId + ", query=" + this.query + ", text=" + this.text + ")";
        }
    }

    public K(int i10, int i11) {
        this.maxEntries = i10;
        this.minMatchLen = i11;
        this.recent = new C1165m<>();
    }

    public static final boolean f(String str, String str2, String str3, Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getSessionId(), str) && kotlin.jvm.internal.p.d(it.getQuery(), str2) && kotlin.jvm.internal.p.d(it.getText(), str3);
    }

    public static final boolean h(String str, String str2, String str3, Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return kotlin.jvm.internal.p.d(it.getSessionId(), str) && kotlin.jvm.internal.p.d(it.getQuery(), str2) && La.D.X(str3, it.getText(), false, 2, null);
    }

    public final synchronized String c(String sessionId, String query, String inbound, boolean isRegenerate, boolean isFinish) {
        Entry next;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(inbound, "inbound");
        String string = La.H.D1(inbound).toString();
        String string2 = La.H.D1(sessionId).toString();
        String string3 = La.H.D1(query).toString();
        if (isRegenerate) {
            return g(string2, string3, inbound, string);
        }
        if (string.length() < this.minMatchLen) {
            if (isFinish || string.length() <= 0 || !d(string2, string3, string)) {
                return inbound;
            }
            return null;
        }
        Iterator<Entry> it = this.recent.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Entry entry = next;
            if (kotlin.jvm.internal.p.d(entry.getSessionId(), string2) && !kotlin.jvm.internal.p.d(entry.getQuery(), string3) && entry.getText().length() >= this.minMatchLen && i(entry.getText(), string)) {
                break;
            }
        }
        Entry entry2 = next;
        if (entry2 == null) {
            return inbound;
        }
        if (!La.H.g0(string, entry2.getText(), false, 2, null)) {
            return null;
        }
        if (kotlin.jvm.internal.p.d(string, entry2.getText())) {
            return inbound;
        }
        String string4 = La.H.D1(La.D.T(string, entry2.getText(), "", false, 4, null)).toString();
        return string4.length() >= 8 ? string4 : null;
    }

    public final boolean d(String sid, String query, String inboundTrim) {
        C1165m<Entry> c1165m = this.recent;
        if (c1165m != null && c1165m.isEmpty()) {
            return false;
        }
        for (Entry entry : c1165m) {
            if (kotlin.jvm.internal.p.d(entry.getSessionId(), sid) && !kotlin.jvm.internal.p.d(entry.getQuery(), query) && entry.getText().length() >= this.minMatchLen && La.H.g0(entry.getText(), inboundTrim, false, 2, null) && !kotlin.jvm.internal.p.d(entry.getText(), inboundTrim)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void e(String sessionId, String query, String text) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(query, "query");
        kotlin.jvm.internal.p.i(text, "text");
        final String string = La.H.D1(sessionId).toString();
        final String string2 = La.H.D1(query).toString();
        final String string3 = La.H.D1(text).toString();
        if (string.length() != 0 && string3.length() != 0) {
            Z8.A.L(this.recent, new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.J
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(K.f(string, string2, string3, (K.Entry) obj));
                }
            });
            this.recent.addLast(new Entry(string, string2, string3));
            while (this.recent.size() > this.maxEntries) {
                this.recent.removeFirst();
            }
        }
    }

    public final String g(final String sid, final String q10, String inbound, final String inboundTrim) {
        Object next;
        Iterator it = SequencesKt___SequencesKt.F(Z8.F.d0(this.recent), new InterfaceC5074l() { // from class: com.stepos.agentframework.adapter.agentbus.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(K.h(sid, q10, inboundTrim, (K.Entry) obj));
            }
        }).iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = ((Entry) next).getText().length();
                do {
                    Object next2 = it.next();
                    int length2 = ((Entry) next2).getText().length();
                    if (length < length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Entry entry = (Entry) next;
        if (entry == null) {
            return inbound;
        }
        String strSubstring = inboundTrim.substring(entry.getText().length());
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        String string = La.H.D1(strSubstring).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }

    public final boolean i(String prev, String inbound) {
        if (La.H.g0(prev, inbound, false, 2, null) || La.H.g0(inbound, prev, false, 2, null)) {
            return true;
        }
        String strR1 = La.K.R1(inbound, 48);
        return strR1.length() >= this.minMatchLen && La.H.g0(prev, strR1, false, 2, null);
    }

    public /* synthetic */ K(int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this((i12 & 1) != 0 ? 6 : i10, (i12 & 2) != 0 ? 24 : i11);
    }
}

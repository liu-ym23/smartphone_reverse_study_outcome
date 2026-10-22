package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003JT\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/stepos/agentbus/generated/Session;", "", "id", "", "title", "createdAtMs", "", "updatedAtMs", "metadata", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getTitle", "getCreatedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUpdatedAtMs", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lcom/stepos/agentbus/generated/Session;", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Session {
    private final Long createdAtMs;
    private final String id;
    private final Map<String, Object> metadata;
    private final String title;
    private final Long updatedAtMs;

    public Session(String id, String str, Long l, Long l5, Map<String, ? extends Object> metadata) {
        k.f(id, "id");
        k.f(metadata, "metadata");
        this.id = id;
        this.title = str;
        this.createdAtMs = l;
        this.updatedAtMs = l5;
        this.metadata = metadata;
    }

    public static /* synthetic */ Session copy$default(Session session, String str, String str2, Long l, Long l5, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = session.id;
        }
        if ((i & 2) != 0) {
            str2 = session.title;
        }
        if ((i & 4) != 0) {
            l = session.createdAtMs;
        }
        if ((i & 8) != 0) {
            l5 = session.updatedAtMs;
        }
        if ((i & 16) != 0) {
            map = session.metadata;
        }
        Map map2 = map;
        Long l9 = l;
        return session.copy(str, str2, l9, l5, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getCreatedAtMs() {
        return this.createdAtMs;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getUpdatedAtMs() {
        return this.updatedAtMs;
    }

    public final Map<String, Object> component5() {
        return this.metadata;
    }

    public final Session copy(String id, String title, Long createdAtMs, Long updatedAtMs, Map<String, ? extends Object> metadata) {
        k.f(id, "id");
        k.f(metadata, "metadata");
        return new Session(id, title, createdAtMs, updatedAtMs, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Session)) {
            return false;
        }
        Session session = (Session) other;
        return k.b(this.id, session.id) && k.b(this.title, session.title) && k.b(this.createdAtMs, session.createdAtMs) && k.b(this.updatedAtMs, session.updatedAtMs) && k.b(this.metadata, session.metadata);
    }

    public final Long getCreatedAtMs() {
        return this.createdAtMs;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getUpdatedAtMs() {
        return this.updatedAtMs;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.createdAtMs;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l5 = this.updatedAtMs;
        return this.metadata.hashCode() + ((iHashCode3 + (l5 != null ? l5.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.title;
        Long l = this.createdAtMs;
        Long l5 = this.updatedAtMs;
        Map<String, Object> map = this.metadata;
        StringBuilder sbW = B7.a.w("Session(id=", str, ", title=", str2, ", createdAtMs=");
        sbW.append(l);
        sbW.append(", updatedAtMs=");
        sbW.append(l5);
        sbW.append(", metadata=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ Session(String str, String str2, Long l, Long l5, Map map, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l5, (i & 16) != 0 ? kotlin.collections.a.M() : map);
    }
}

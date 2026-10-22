package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/adapter/netcore/BusActorSource;", "source", "Lcom/stepos/agentframework/adapter/netcore/BusActorSource;", "c", "()Lcom/stepos/agentframework/adapter/netcore/BusActorSource;", "id", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "displayName", Const.INTENT_KEY_APIKEY, "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class BusActor {
    private final String displayName;
    private final String id;
    private final BusActorSource source;

    /* renamed from: a, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final BusActorSource getSource() {
        return this.source;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusActor)) {
            return false;
        }
        BusActor busActor = (BusActor) other;
        return this.source == busActor.source && kotlin.jvm.internal.p.d(this.id, busActor.id) && kotlin.jvm.internal.p.d(this.displayName, busActor.displayName);
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.id;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BusActor(source=" + this.source + ", id=" + this.id + ", displayName=" + this.displayName + ")";
    }
}

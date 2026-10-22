package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentbus/generated/Actor;", "", AgentBusWakeContract.EXTRA_SOURCE, "Lcom/stepos/agentbus/generated/ActorSource;", "id", "", "displayName", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/ActorSource;Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Lcom/stepos/agentbus/generated/ActorSource;", "getId", "()Ljava/lang/String;", "getDisplayName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Actor {
    private final String displayName;
    private final String id;
    private final ActorSource source;

    public Actor(ActorSource source, String str, String str2) {
        k.f(source, "source");
        this.source = source;
        this.id = str;
        this.displayName = str2;
    }

    public static /* synthetic */ Actor copy$default(Actor actor, ActorSource actorSource, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            actorSource = actor.source;
        }
        if ((i & 2) != 0) {
            str = actor.id;
        }
        if ((i & 4) != 0) {
            str2 = actor.displayName;
        }
        return actor.copy(actorSource, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final ActorSource getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public final Actor copy(ActorSource source, String id, String displayName) {
        k.f(source, "source");
        return new Actor(source, id, displayName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Actor)) {
            return false;
        }
        Actor actor = (Actor) other;
        return this.source == actor.source && k.b(this.id, actor.id) && k.b(this.displayName, actor.displayName);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getId() {
        return this.id;
    }

    public final ActorSource getSource() {
        return this.source;
    }

    public int hashCode() {
        int iHashCode = this.source.hashCode() * 31;
        String str = this.id;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        ActorSource actorSource = this.source;
        String str = this.id;
        String str2 = this.displayName;
        StringBuilder sb = new StringBuilder("Actor(source=");
        sb.append(actorSource);
        sb.append(", id=");
        sb.append(str);
        sb.append(", displayName=");
        return B7.a.q(sb, str2, ")");
    }

    public /* synthetic */ Actor(ActorSource actorSource, String str, String str2, int i, e eVar) {
        this(actorSource, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}

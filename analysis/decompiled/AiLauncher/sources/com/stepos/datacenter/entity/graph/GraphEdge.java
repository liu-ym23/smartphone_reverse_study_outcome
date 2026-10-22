package com.stepos.datacenter.entity.graph;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.datacenter.entity.BaseEntity;
import io.objectbox.relation.ToOne;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006!"}, d2 = {"Lcom/stepos/datacenter/entity/graph/GraphEdge;", "Lcom/stepos/datacenter/entity/BaseEntity;", "type", "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getData", "setData", "source", "Lio/objectbox/relation/ToOne;", "Lcom/stepos/datacenter/entity/graph/GraphNode;", "getSource", "()Lio/objectbox/relation/ToOne;", "setSource", "(Lio/objectbox/relation/ToOne;)V", "target", "getTarget", "setTarget", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "", "toString", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GraphEdge extends BaseEntity {
    private String data;
    public ToOne<GraphNode> source;
    public ToOne<GraphNode> target;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public GraphEdge() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GraphEdge copy$default(GraphEdge graphEdge, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = graphEdge.type;
        }
        if ((i10 & 2) != 0) {
            str2 = graphEdge.data;
        }
        return graphEdge.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getData() {
        return this.data;
    }

    public final GraphEdge copy(String type, String data) {
        p.i(type, "type");
        p.i(data, "data");
        return new GraphEdge(type, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraphEdge)) {
            return false;
        }
        GraphEdge graphEdge = (GraphEdge) other;
        return p.d(this.type, graphEdge.type) && p.d(this.data, graphEdge.data);
    }

    public final String getData() {
        return this.data;
    }

    public final ToOne<GraphNode> getSource() {
        ToOne<GraphNode> toOne = this.source;
        if (toOne != null) {
            return toOne;
        }
        p.A("source");
        return null;
    }

    public final ToOne<GraphNode> getTarget() {
        ToOne<GraphNode> toOne = this.target;
        if (toOne != null) {
            return toOne;
        }
        p.A("target");
        return null;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.data.hashCode();
    }

    public final void setData(String str) {
        p.i(str, "<set-?>");
        this.data = str;
    }

    public final void setSource(ToOne<GraphNode> toOne) {
        p.i(toOne, "<set-?>");
        this.source = toOne;
    }

    public final void setTarget(ToOne<GraphNode> toOne) {
        p.i(toOne, "<set-?>");
        this.target = toOne;
    }

    public final void setType(String str) {
        p.i(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "GraphEdge(type=" + this.type + ", data=" + this.data + ")";
    }

    public /* synthetic */ GraphEdge(String str, String str2, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "{}" : str2);
    }

    public GraphEdge(String type, String data) {
        p.i(type, "type");
        p.i(data, "data");
        this.type = type;
        this.data = data;
    }
}

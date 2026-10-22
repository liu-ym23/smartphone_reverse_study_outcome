package com.stepos.datacenter.entity.graph;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.datacenter.entity.BaseEntity;
import io.objectbox.relation.ToMany;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J'\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u001bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006("}, d2 = {"Lcom/stepos/datacenter/entity/graph/GraphNode;", "Lcom/stepos/datacenter/entity/BaseEntity;", "type", "", "name", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getName", "setName", "getData", "setData", "outEdges", "Lio/objectbox/relation/ToMany;", "Lcom/stepos/datacenter/entity/graph/GraphEdge;", "getOutEdges", "()Lio/objectbox/relation/ToMany;", "setOutEdges", "(Lio/objectbox/relation/ToMany;)V", "inEdges", "getInEdges", "setInEdges", "outDegree", "", "inDegree", "degree", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "", "hashCode", "toString", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GraphNode extends BaseEntity {
    private String data;
    public ToMany<GraphEdge> inEdges;
    private String name;
    public ToMany<GraphEdge> outEdges;
    private String type;

    public GraphNode() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GraphNode copy$default(GraphNode graphNode, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = graphNode.type;
        }
        if ((i10 & 2) != 0) {
            str2 = graphNode.name;
        }
        if ((i10 & 4) != 0) {
            str3 = graphNode.data;
        }
        return graphNode.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getData() {
        return this.data;
    }

    public final GraphNode copy(String type, String name, String data) {
        p.i(type, "type");
        p.i(name, "name");
        p.i(data, "data");
        return new GraphNode(type, name, data);
    }

    public final int degree() {
        return outDegree() + inDegree();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GraphNode)) {
            return false;
        }
        GraphNode graphNode = (GraphNode) other;
        return p.d(this.type, graphNode.type) && p.d(this.name, graphNode.name) && p.d(this.data, graphNode.data);
    }

    public final String getData() {
        return this.data;
    }

    public final ToMany<GraphEdge> getInEdges() {
        ToMany<GraphEdge> toMany = this.inEdges;
        if (toMany != null) {
            return toMany;
        }
        p.A("inEdges");
        return null;
    }

    public final String getName() {
        return this.name;
    }

    public final ToMany<GraphEdge> getOutEdges() {
        ToMany<GraphEdge> toMany = this.outEdges;
        if (toMany != null) {
            return toMany;
        }
        p.A("outEdges");
        return null;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + this.data.hashCode();
    }

    public final int inDegree() {
        return getInEdges().size();
    }

    public final int outDegree() {
        return getOutEdges().size();
    }

    public final void setData(String str) {
        p.i(str, "<set-?>");
        this.data = str;
    }

    public final void setInEdges(ToMany<GraphEdge> toMany) {
        p.i(toMany, "<set-?>");
        this.inEdges = toMany;
    }

    public final void setName(String str) {
        p.i(str, "<set-?>");
        this.name = str;
    }

    public final void setOutEdges(ToMany<GraphEdge> toMany) {
        p.i(toMany, "<set-?>");
        this.outEdges = toMany;
    }

    public final void setType(String str) {
        p.i(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        return "GraphNode(type=" + this.type + ", name=" + this.name + ", data=" + this.data + ")";
    }

    public /* synthetic */ GraphNode(String str, String str2, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "{}" : str3);
    }

    public GraphNode(String type, String name, String data) {
        p.i(type, "type");
        p.i(name, "name");
        p.i(data, "data");
        this.type = type;
        this.name = name;
        this.data = data;
    }
}

package stepai.aios.guiagent.tracer;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0003Jr\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006$"}, d2 = {"Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "", "treeId", "", "totalNodes", "", "nodeIndex", "nodeLabel", "slotMap", "", "pathNode", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getTreeId", "()Ljava/lang/String;", "getTotalNodes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNodeIndex", "getNodeLabel", "getSlotMap", "()Ljava/util/Map;", "getPathNode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lstepai/aios/guiagent/tracer/GuiTaskNodeMetadata;", "equals", "", "other", "hashCode", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiTaskNodeMetadata {
    private final Integer nodeIndex;
    private final String nodeLabel;
    private final Map<String, Object> pathNode;
    private final Map<String, Object> slotMap;
    private final Integer totalNodes;
    private final String treeId;

    public GuiTaskNodeMetadata(String str, Integer num, Integer num2, String str2, Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        this.treeId = str;
        this.totalNodes = num;
        this.nodeIndex = num2;
        this.nodeLabel = str2;
        this.slotMap = map;
        this.pathNode = map2;
    }

    public static /* synthetic */ GuiTaskNodeMetadata copy$default(GuiTaskNodeMetadata guiTaskNodeMetadata, String str, Integer num, Integer num2, String str2, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiTaskNodeMetadata.treeId;
        }
        if ((i & 2) != 0) {
            num = guiTaskNodeMetadata.totalNodes;
        }
        if ((i & 4) != 0) {
            num2 = guiTaskNodeMetadata.nodeIndex;
        }
        if ((i & 8) != 0) {
            str2 = guiTaskNodeMetadata.nodeLabel;
        }
        if ((i & 16) != 0) {
            map = guiTaskNodeMetadata.slotMap;
        }
        if ((i & 32) != 0) {
            map2 = guiTaskNodeMetadata.pathNode;
        }
        Map map3 = map;
        Map map4 = map2;
        return guiTaskNodeMetadata.copy(str, num, num2, str2, map3, map4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTreeId() {
        return this.treeId;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getTotalNodes() {
        return this.totalNodes;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getNodeIndex() {
        return this.nodeIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final String getNodeLabel() {
        return this.nodeLabel;
    }

    public final Map<String, Object> component5() {
        return this.slotMap;
    }

    public final Map<String, Object> component6() {
        return this.pathNode;
    }

    public final GuiTaskNodeMetadata copy(String treeId, Integer totalNodes, Integer nodeIndex, String nodeLabel, Map<String, ? extends Object> slotMap, Map<String, ? extends Object> pathNode) {
        return new GuiTaskNodeMetadata(treeId, totalNodes, nodeIndex, nodeLabel, slotMap, pathNode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTaskNodeMetadata)) {
            return false;
        }
        GuiTaskNodeMetadata guiTaskNodeMetadata = (GuiTaskNodeMetadata) other;
        return k.b(this.treeId, guiTaskNodeMetadata.treeId) && k.b(this.totalNodes, guiTaskNodeMetadata.totalNodes) && k.b(this.nodeIndex, guiTaskNodeMetadata.nodeIndex) && k.b(this.nodeLabel, guiTaskNodeMetadata.nodeLabel) && k.b(this.slotMap, guiTaskNodeMetadata.slotMap) && k.b(this.pathNode, guiTaskNodeMetadata.pathNode);
    }

    public final Integer getNodeIndex() {
        return this.nodeIndex;
    }

    public final String getNodeLabel() {
        return this.nodeLabel;
    }

    public final Map<String, Object> getPathNode() {
        return this.pathNode;
    }

    public final Map<String, Object> getSlotMap() {
        return this.slotMap;
    }

    public final Integer getTotalNodes() {
        return this.totalNodes;
    }

    public final String getTreeId() {
        return this.treeId;
    }

    public int hashCode() {
        String str = this.treeId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.totalNodes;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.nodeIndex;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.nodeLabel;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Object> map = this.slotMap;
        int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.pathNode;
        return iHashCode5 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "GuiTaskNodeMetadata(treeId=" + this.treeId + ", totalNodes=" + this.totalNodes + ", nodeIndex=" + this.nodeIndex + ", nodeLabel=" + this.nodeLabel + ", slotMap=" + this.slotMap + ", pathNode=" + this.pathNode + ")";
    }
}

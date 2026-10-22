package stepai.aios.guiagent.app;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0098\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u0006/"}, d2 = {"Lstepai/aios/guiagent/app/GuiPathNode;", "", "opType", "", "opParams", "", "opDesc", "opDescDisplay", "nodeType", "opDescPath", "", "slotMatch", "repetition", "", "subTaskHistoryName", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/String;)V", "getOpType", "()Ljava/lang/String;", "getOpParams", "()Ljava/util/Map;", "getOpDesc", "getOpDescDisplay", "getNodeType", "getOpDescPath", "()Ljava/util/List;", "getSlotMatch", "getRepetition", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSubTaskHistoryName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/String;)Lstepai/aios/guiagent/app/GuiPathNode;", "equals", "other", "hashCode", "", "toString", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiPathNode {

    @SerializedName("node_type")
    private final String nodeType;

    @SerializedName("op_desc")
    private final String opDesc;

    @SerializedName("op_desc_display")
    private final String opDescDisplay;

    @SerializedName("op_desc_path")
    private final List<String> opDescPath;

    @SerializedName("op_params")
    private final Map<String, Object> opParams;

    @SerializedName("op_type")
    private final String opType;

    @SerializedName("repetition")
    private final Boolean repetition;

    @SerializedName("slot_match")
    private final Map<String, Object> slotMatch;

    @SerializedName("subtask_history_name")
    private final String subTaskHistoryName;

    public GuiPathNode(String str, Map<String, ? extends Object> map, String str2, String str3, String nodeType, List<String> list, Map<String, ? extends Object> map2, Boolean bool, String str4) {
        k.f(nodeType, "nodeType");
        this.opType = str;
        this.opParams = map;
        this.opDesc = str2;
        this.opDescDisplay = str3;
        this.nodeType = nodeType;
        this.opDescPath = list;
        this.slotMatch = map2;
        this.repetition = bool;
        this.subTaskHistoryName = str4;
    }

    public static /* synthetic */ GuiPathNode copy$default(GuiPathNode guiPathNode, String str, Map map, String str2, String str3, String str4, List list, Map map2, Boolean bool, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiPathNode.opType;
        }
        if ((i & 2) != 0) {
            map = guiPathNode.opParams;
        }
        if ((i & 4) != 0) {
            str2 = guiPathNode.opDesc;
        }
        if ((i & 8) != 0) {
            str3 = guiPathNode.opDescDisplay;
        }
        if ((i & 16) != 0) {
            str4 = guiPathNode.nodeType;
        }
        if ((i & 32) != 0) {
            list = guiPathNode.opDescPath;
        }
        if ((i & 64) != 0) {
            map2 = guiPathNode.slotMatch;
        }
        if ((i & 128) != 0) {
            bool = guiPathNode.repetition;
        }
        if ((i & 256) != 0) {
            str5 = guiPathNode.subTaskHistoryName;
        }
        Boolean bool2 = bool;
        String str6 = str5;
        List list2 = list;
        Map map3 = map2;
        String str7 = str4;
        String str8 = str2;
        return guiPathNode.copy(str, map, str8, str3, str7, list2, map3, bool2, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOpType() {
        return this.opType;
    }

    public final Map<String, Object> component2() {
        return this.opParams;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOpDesc() {
        return this.opDesc;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOpDescDisplay() {
        return this.opDescDisplay;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNodeType() {
        return this.nodeType;
    }

    public final List<String> component6() {
        return this.opDescPath;
    }

    public final Map<String, Object> component7() {
        return this.slotMatch;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getRepetition() {
        return this.repetition;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSubTaskHistoryName() {
        return this.subTaskHistoryName;
    }

    public final GuiPathNode copy(String opType, Map<String, ? extends Object> opParams, String opDesc, String opDescDisplay, String nodeType, List<String> opDescPath, Map<String, ? extends Object> slotMatch, Boolean repetition, String subTaskHistoryName) {
        k.f(nodeType, "nodeType");
        return new GuiPathNode(opType, opParams, opDesc, opDescDisplay, nodeType, opDescPath, slotMatch, repetition, subTaskHistoryName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiPathNode)) {
            return false;
        }
        GuiPathNode guiPathNode = (GuiPathNode) other;
        return k.b(this.opType, guiPathNode.opType) && k.b(this.opParams, guiPathNode.opParams) && k.b(this.opDesc, guiPathNode.opDesc) && k.b(this.opDescDisplay, guiPathNode.opDescDisplay) && k.b(this.nodeType, guiPathNode.nodeType) && k.b(this.opDescPath, guiPathNode.opDescPath) && k.b(this.slotMatch, guiPathNode.slotMatch) && k.b(this.repetition, guiPathNode.repetition) && k.b(this.subTaskHistoryName, guiPathNode.subTaskHistoryName);
    }

    public final String getNodeType() {
        return this.nodeType;
    }

    public final String getOpDesc() {
        return this.opDesc;
    }

    public final String getOpDescDisplay() {
        return this.opDescDisplay;
    }

    public final List<String> getOpDescPath() {
        return this.opDescPath;
    }

    public final Map<String, Object> getOpParams() {
        return this.opParams;
    }

    public final String getOpType() {
        return this.opType;
    }

    public final Boolean getRepetition() {
        return this.repetition;
    }

    public final Map<String, Object> getSlotMatch() {
        return this.slotMatch;
    }

    public final String getSubTaskHistoryName() {
        return this.subTaskHistoryName;
    }

    public int hashCode() {
        String str = this.opType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Map<String, Object> map = this.opParams;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.opDesc;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.opDescDisplay;
        int iC = a.c((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31, 31, this.nodeType);
        List<String> list = this.opDescPath;
        int iHashCode4 = (iC + (list == null ? 0 : list.hashCode())) * 31;
        Map<String, Object> map2 = this.slotMatch;
        int iHashCode5 = (iHashCode4 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Boolean bool = this.repetition;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str4 = this.subTaskHistoryName;
        return iHashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.opType;
        Map<String, Object> map = this.opParams;
        String str2 = this.opDesc;
        String str3 = this.opDescDisplay;
        String str4 = this.nodeType;
        List<String> list = this.opDescPath;
        Map<String, Object> map2 = this.slotMatch;
        Boolean bool = this.repetition;
        String str5 = this.subTaskHistoryName;
        StringBuilder sb = new StringBuilder("GuiPathNode(opType=");
        sb.append(str);
        sb.append(", opParams=");
        sb.append(map);
        sb.append(", opDesc=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", opDescDisplay=", str3, ", nodeType=");
        sb.append(str4);
        sb.append(", opDescPath=");
        sb.append(list);
        sb.append(", slotMatch=");
        sb.append(map2);
        sb.append(", repetition=");
        sb.append(bool);
        sb.append(", subTaskHistoryName=");
        return a.q(sb, str5, ")");
    }

    public /* synthetic */ GuiPathNode(String str, Map map, String str2, String str3, String str4, List list, Map map2, Boolean bool, String str5, int i, e eVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, str4, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : map2, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : str5);
    }
}

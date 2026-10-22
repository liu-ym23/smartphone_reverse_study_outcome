package c59;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.larus.dora.impl.dynamic.dsl.DslNodeType;
import com.larus.dora.impl.dynamic.dsl.DslTemplateType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\rHÆ\u0003Js\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\rHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslNode;", "", "dslVersion", "", "nodeType", "Lcom/larus/dora/impl/dynamic/dsl/DslNodeType;", "nodeName", "nodeKey", GXTemplateKey.GAIAX_TEMPLATE_TYPE, "Lcom/larus/dora/impl/dynamic/dsl/DslTemplateType;", "config", "", "nodes", "", "<init>", "(Ljava/lang/String;Lcom/larus/dora/impl/dynamic/dsl/DslNodeType;Ljava/lang/String;Ljava/lang/String;Lcom/larus/dora/impl/dynamic/dsl/DslTemplateType;Ljava/util/Map;Ljava/util/List;)V", "getDslVersion", "()Ljava/lang/String;", "getNodeType", "()Lcom/larus/dora/impl/dynamic/dsl/DslNodeType;", "getNodeName", "getNodeKey", "getTemplateType", "()Lcom/larus/dora/impl/dynamic/dsl/DslTemplateType;", "getConfig", "()Ljava/util/Map;", "getNodes", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class z {

    @SerializedName("config")
    private final Map<String, Object> config;

    @SerializedName("dsl_version")
    private final String dslVersion;

    @SerializedName("node_key")
    private final String nodeKey;

    @SerializedName("node_name")
    private final String nodeName;

    @SerializedName("node_type")
    private final DslNodeType nodeType;

    @SerializedName("nodes")
    private final List<z> nodes;

    @SerializedName("template_type")
    private final DslTemplateType templateType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.dslVersion, r101.dslVersion) == true) goto L12;
        return false;
    L12:
        if (this.nodeType == r101.nodeType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nodeName, r101.nodeName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nodeKey, r101.nodeKey) == true) goto L21;
        return false;
    L21:
        if (this.templateType == r101.templateType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nodes, r101.nodes) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.dslVersion;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        DslNodeType r104 = this.nodeType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.nodeName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.nodeKey;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        DslTemplateType r113 = this.templateType;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, Object> r116 = this.config;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<z> r119 = this.nodes;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DslNode(dslVersion=" + this.dslVersion + ", nodeType=" + this.nodeType + ", nodeName=" + this.nodeName + ", nodeKey=" + this.nodeKey + ", templateType=" + this.templateType + ", config=" + this.config + ", nodes=" + this.nodes + ')';
    }

    public z() {
        this.dslVersion = null;
        this.nodeType = null;
        this.nodeName = null;
        this.nodeKey = null;
        this.templateType = null;
        this.config = null;
        this.nodes = null;
    }

    public final Map<String, Object> a() {
        return this.config;
    }

    public final DslNodeType b() {
        return this.nodeType;
    }

    public final List<z> c() {
        return this.nodes;
    }

    public final DslTemplateType d() {
        return this.templateType;
    }
}

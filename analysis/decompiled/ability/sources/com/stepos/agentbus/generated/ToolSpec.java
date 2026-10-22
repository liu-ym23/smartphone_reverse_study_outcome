package com.stepos.agentbus.generated;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010%J\u0017\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013HÆ\u0003J\u0098\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006;"}, d2 = {"Lcom/stepos/agentbus/generated/ToolSpec;", "Lcom/stepos/agentbus/generated/ResourceSpec;", "id", "", HintConstants.AUTOFILL_HINT_NAME, "description", "version", "tags", "", "isEnabled", "", "type", "Lcom/stepos/agentbus/generated/ToolType;", QueryAlgorithmBundle.KEY_CATEGORY, AgentBusWakeContract.EXTRA_SOURCE, "Lcom/stepos/agentbus/generated/InstallSource;", "modifiedAtMs", "", "metadata", "", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/stepos/agentbus/generated/ToolType;Ljava/lang/String;Lcom/stepos/agentbus/generated/InstallSource;Ljava/lang/Long;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getVersion", "getTags", "()Ljava/util/List;", "()Z", "getType", "()Lcom/stepos/agentbus/generated/ToolType;", "getCategory", "getSource", "()Lcom/stepos/agentbus/generated/InstallSource;", "getModifiedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/stepos/agentbus/generated/ToolType;Ljava/lang/String;Lcom/stepos/agentbus/generated/InstallSource;Ljava/lang/Long;Ljava/util/Map;)Lcom/stepos/agentbus/generated/ToolSpec;", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolSpec implements ResourceSpec {
    private final String category;
    private final String description;
    private final String id;
    private final boolean isEnabled;
    private final Map<String, Object> metadata;
    private final Long modifiedAtMs;
    private final String name;
    private final InstallSource source;
    private final List<String> tags;
    private final ToolType type;
    private final String version;

    public ToolSpec(String id, String name, String str, String str2, List<String> tags, boolean z10, ToolType type, String str3, InstallSource source, Long l, Map<String, ? extends Object> metadata) {
        k.f(id, "id");
        k.f(name, "name");
        k.f(tags, "tags");
        k.f(type, "type");
        k.f(source, "source");
        k.f(metadata, "metadata");
        this.id = id;
        this.name = name;
        this.description = str;
        this.version = str2;
        this.tags = tags;
        this.isEnabled = z10;
        this.type = type;
        this.category = str3;
        this.source = source;
        this.modifiedAtMs = l;
        this.metadata = metadata;
    }

    public static /* synthetic */ ToolSpec copy$default(ToolSpec toolSpec, String str, String str2, String str3, String str4, List list, boolean z10, ToolType toolType, String str5, InstallSource installSource, Long l, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolSpec.id;
        }
        if ((i & 2) != 0) {
            str2 = toolSpec.name;
        }
        if ((i & 4) != 0) {
            str3 = toolSpec.description;
        }
        if ((i & 8) != 0) {
            str4 = toolSpec.version;
        }
        if ((i & 16) != 0) {
            list = toolSpec.tags;
        }
        if ((i & 32) != 0) {
            z10 = toolSpec.isEnabled;
        }
        if ((i & 64) != 0) {
            toolType = toolSpec.type;
        }
        if ((i & 128) != 0) {
            str5 = toolSpec.category;
        }
        if ((i & 256) != 0) {
            installSource = toolSpec.source;
        }
        if ((i & 512) != 0) {
            l = toolSpec.modifiedAtMs;
        }
        if ((i & 1024) != 0) {
            map = toolSpec.metadata;
        }
        Long l5 = l;
        Map map2 = map;
        String str6 = str5;
        InstallSource installSource2 = installSource;
        boolean z11 = z10;
        ToolType toolType2 = toolType;
        List list2 = list;
        String str7 = str3;
        return toolSpec.copy(str, str2, str7, str4, list2, z11, toolType2, str6, installSource2, l5, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getModifiedAtMs() {
        return this.modifiedAtMs;
    }

    public final Map<String, Object> component11() {
        return this.metadata;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<String> component5() {
        return this.tags;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: component7, reason: from getter */
    public final ToolType getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component9, reason: from getter */
    public final InstallSource getSource() {
        return this.source;
    }

    public final ToolSpec copy(String id, String name, String description, String version, List<String> tags, boolean isEnabled, ToolType type, String category, InstallSource source, Long modifiedAtMs, Map<String, ? extends Object> metadata) {
        k.f(id, "id");
        k.f(name, "name");
        k.f(tags, "tags");
        k.f(type, "type");
        k.f(source, "source");
        k.f(metadata, "metadata");
        return new ToolSpec(id, name, description, version, tags, isEnabled, type, category, source, modifiedAtMs, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolSpec)) {
            return false;
        }
        ToolSpec toolSpec = (ToolSpec) other;
        return k.b(this.id, toolSpec.id) && k.b(this.name, toolSpec.name) && k.b(this.description, toolSpec.description) && k.b(this.version, toolSpec.version) && k.b(this.tags, toolSpec.tags) && this.isEnabled == toolSpec.isEnabled && this.type == toolSpec.type && k.b(this.category, toolSpec.category) && this.source == toolSpec.source && k.b(this.modifiedAtMs, toolSpec.modifiedAtMs) && k.b(this.metadata, toolSpec.metadata);
    }

    public final String getCategory() {
        return this.category;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public String getDescription() {
        return this.description;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public String getId() {
        return this.id;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final Long getModifiedAtMs() {
        return this.modifiedAtMs;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public String getName() {
        return this.name;
    }

    public final InstallSource getSource() {
        return this.source;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public List<String> getTags() {
        return this.tags;
    }

    public final ToolType getType() {
        return this.type;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iC = B7.a.c(this.id.hashCode() * 31, 31, this.name);
        String str = this.description;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int iHashCode2 = (this.type.hashCode() + androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.e(this.tags, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31, this.isEnabled)) * 31;
        String str3 = this.category;
        int iHashCode3 = (this.source.hashCode() + ((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31)) * 31;
        Long l = this.modifiedAtMs;
        return this.metadata.hashCode() + ((iHashCode3 + (l != null ? l.hashCode() : 0)) * 31);
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.name;
        String str3 = this.description;
        String str4 = this.version;
        List<String> list = this.tags;
        boolean z10 = this.isEnabled;
        ToolType toolType = this.type;
        String str5 = this.category;
        InstallSource installSource = this.source;
        Long l = this.modifiedAtMs;
        Map<String, Object> map = this.metadata;
        StringBuilder sbW = B7.a.w("ToolSpec(id=", str, ", name=", str2, ", description=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", version=", str4, ", tags=");
        sbW.append(list);
        sbW.append(", isEnabled=");
        sbW.append(z10);
        sbW.append(", type=");
        sbW.append(toolType);
        sbW.append(", category=");
        sbW.append(str5);
        sbW.append(", source=");
        sbW.append(installSource);
        sbW.append(", modifiedAtMs=");
        sbW.append(l);
        sbW.append(", metadata=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public ToolSpec(String str, String str2, String str3, String str4, List list, boolean z10, ToolType toolType, String str5, InstallSource installSource, Long l, Map map, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? EmptyList.f4893a : list, (i & 32) != 0 ? true : z10, (i & 64) != 0 ? ToolType.INSTALLED : toolType, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? InstallSource.LOCAL : installSource, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? kotlin.collections.a.M() : map);
    }
}

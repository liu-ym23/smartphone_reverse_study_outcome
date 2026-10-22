package com.stepos.agentbus.generated;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eHÆ\u0003J}\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\"\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/stepos/agentbus/generated/ChannelSpec;", "Lcom/stepos/agentbus/generated/ResourceSpec;", "id", "", "channelId", HintConstants.AUTOFILL_HINT_NAME, "status", "version", "tags", "", "isEnabled", "", "description", "metadata", "", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getChannelId", "getName", "getStatus", "getVersion", "getTags", "()Ljava/util/List;", "()Z", "getDescription", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChannelSpec implements ResourceSpec {
    private final String channelId;
    private final String description;
    private final String id;
    private final boolean isEnabled;
    private final Map<String, Object> metadata;
    private final String name;
    private final String status;
    private final List<String> tags;
    private final String version;

    public ChannelSpec(String str, String str2, String str3, String str4, String str5, List list, boolean z10, String str6, Map map, int i, e eVar) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? EmptyList.f4893a : list, (i & 64) != 0 ? true : z10, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? kotlin.collections.a.M() : map);
    }

    public static /* synthetic */ ChannelSpec copy$default(ChannelSpec channelSpec, String str, String str2, String str3, String str4, String str5, List list, boolean z10, String str6, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelSpec.id;
        }
        if ((i & 2) != 0) {
            str2 = channelSpec.channelId;
        }
        if ((i & 4) != 0) {
            str3 = channelSpec.name;
        }
        if ((i & 8) != 0) {
            str4 = channelSpec.status;
        }
        if ((i & 16) != 0) {
            str5 = channelSpec.version;
        }
        if ((i & 32) != 0) {
            list = channelSpec.tags;
        }
        if ((i & 64) != 0) {
            z10 = channelSpec.isEnabled;
        }
        if ((i & 128) != 0) {
            str6 = channelSpec.description;
        }
        if ((i & 256) != 0) {
            map = channelSpec.metadata;
        }
        String str7 = str6;
        Map map2 = map;
        List list2 = list;
        boolean z11 = z10;
        String str8 = str5;
        String str9 = str3;
        return channelSpec.copy(str, str2, str9, str4, str8, list2, z11, str7, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<String> component6() {
        return this.tags;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final Map<String, Object> component9() {
        return this.metadata;
    }

    public final ChannelSpec copy(String id, String channelId, String name, String status, String version, List<String> tags, boolean isEnabled, String description, Map<String, ? extends Object> metadata) {
        k.f(id, "id");
        k.f(channelId, "channelId");
        k.f(name, "name");
        k.f(tags, "tags");
        k.f(metadata, "metadata");
        return new ChannelSpec(id, channelId, name, status, version, tags, isEnabled, description, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSpec)) {
            return false;
        }
        ChannelSpec channelSpec = (ChannelSpec) other;
        return k.b(this.id, channelSpec.id) && k.b(this.channelId, channelSpec.channelId) && k.b(this.name, channelSpec.name) && k.b(this.status, channelSpec.status) && k.b(this.version, channelSpec.version) && k.b(this.tags, channelSpec.tags) && this.isEnabled == channelSpec.isEnabled && k.b(this.description, channelSpec.description) && k.b(this.metadata, channelSpec.metadata);
    }

    public final String getChannelId() {
        return this.channelId;
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

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public String getName() {
        return this.name;
    }

    public final String getStatus() {
        return this.status;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public List<String> getTags() {
        return this.tags;
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iC = B7.a.c(B7.a.c(this.id.hashCode() * 31, 31, this.channelId), 31, this.name);
        String str = this.status;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        int iD = androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.e(this.tags, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31), 31, this.isEnabled);
        String str3 = this.description;
        return this.metadata.hashCode() + ((iD + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // com.stepos.agentbus.generated.ResourceSpec
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        String str = this.id;
        String str2 = this.channelId;
        String str3 = this.name;
        String str4 = this.status;
        String str5 = this.version;
        List<String> list = this.tags;
        boolean z10 = this.isEnabled;
        String str6 = this.description;
        Map<String, Object> map = this.metadata;
        StringBuilder sbW = B7.a.w("ChannelSpec(id=", str, ", channelId=", str2, ", name=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", status=", str4, ", version=");
        sbW.append(str5);
        sbW.append(", tags=");
        sbW.append(list);
        sbW.append(", isEnabled=");
        sbW.append(z10);
        sbW.append(", description=");
        sbW.append(str6);
        sbW.append(", metadata=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public ChannelSpec(String id, String channelId, String name, String str, String str2, List<String> tags, boolean z10, String str3, Map<String, ? extends Object> metadata) {
        k.f(id, "id");
        k.f(channelId, "channelId");
        k.f(name, "name");
        k.f(tags, "tags");
        k.f(metadata, "metadata");
        this.id = id;
        this.channelId = channelId;
        this.name = name;
        this.status = str;
        this.version = str2;
        this.tags = tags;
        this.isEnabled = z10;
        this.description = str3;
        this.metadata = metadata;
    }
}

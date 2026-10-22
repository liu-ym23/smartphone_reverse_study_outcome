package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentbus/generated/ToolFilter;", "", "types", "", "Lcom/stepos/agentbus/generated/ToolType;", "tagsAny", "", "enabled", "", AppAgent.CONSTRUCT, "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/Boolean;)V", "getTypes", "()Ljava/util/Set;", "getTagsAny", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/Boolean;)Lcom/stepos/agentbus/generated/ToolFilter;", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolFilter {
    private final Boolean enabled;
    private final Set<String> tagsAny;
    private final Set<ToolType> types;

    public ToolFilter() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolFilter copy$default(ToolFilter toolFilter, Set set, Set set2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            set = toolFilter.types;
        }
        if ((i & 2) != 0) {
            set2 = toolFilter.tagsAny;
        }
        if ((i & 4) != 0) {
            bool = toolFilter.enabled;
        }
        return toolFilter.copy(set, set2, bool);
    }

    public final Set<ToolType> component1() {
        return this.types;
    }

    public final Set<String> component2() {
        return this.tagsAny;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final ToolFilter copy(Set<? extends ToolType> types, Set<String> tagsAny, Boolean enabled) {
        return new ToolFilter(types, tagsAny, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolFilter)) {
            return false;
        }
        ToolFilter toolFilter = (ToolFilter) other;
        return k.b(this.types, toolFilter.types) && k.b(this.tagsAny, toolFilter.tagsAny) && k.b(this.enabled, toolFilter.enabled);
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Set<String> getTagsAny() {
        return this.tagsAny;
    }

    public final Set<ToolType> getTypes() {
        return this.types;
    }

    public int hashCode() {
        Set<ToolType> set = this.types;
        int iHashCode = (set == null ? 0 : set.hashCode()) * 31;
        Set<String> set2 = this.tagsAny;
        int iHashCode2 = (iHashCode + (set2 == null ? 0 : set2.hashCode())) * 31;
        Boolean bool = this.enabled;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "ToolFilter(types=" + this.types + ", tagsAny=" + this.tagsAny + ", enabled=" + this.enabled + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToolFilter(Set<? extends ToolType> set, Set<String> set2, Boolean bool) {
        this.types = set;
        this.tagsAny = set2;
        this.enabled = bool;
    }

    public /* synthetic */ ToolFilter(Set set, Set set2, Boolean bool, int i, e eVar) {
        this((i & 1) != 0 ? null : set, (i & 2) != 0 ? null : set2, (i & 4) != 0 ? null : bool);
    }
}

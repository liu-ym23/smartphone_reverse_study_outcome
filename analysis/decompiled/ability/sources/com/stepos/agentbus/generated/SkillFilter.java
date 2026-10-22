package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018Jh\u0010 \u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/stepos/agentbus/generated/SkillFilter;", "", "sources", "", "Lcom/stepos/agentbus/generated/InstallSource;", "tagsAny", "", "tagsAll", "enabled", "", "hasSkillMd", "modifiedOnOrAfterMs", "", AppAgent.CONSTRUCT, "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getSources", "()Ljava/util/Set;", "getTagsAny", "getTagsAll", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasSkillMd", "getModifiedOnOrAfterMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/stepos/agentbus/generated/SkillFilter;", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SkillFilter {
    private final Boolean enabled;
    private final Boolean hasSkillMd;
    private final Long modifiedOnOrAfterMs;
    private final Set<InstallSource> sources;
    private final Set<String> tagsAll;
    private final Set<String> tagsAny;

    public SkillFilter() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ SkillFilter copy$default(SkillFilter skillFilter, Set set, Set set2, Set set3, Boolean bool, Boolean bool2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            set = skillFilter.sources;
        }
        if ((i & 2) != 0) {
            set2 = skillFilter.tagsAny;
        }
        if ((i & 4) != 0) {
            set3 = skillFilter.tagsAll;
        }
        if ((i & 8) != 0) {
            bool = skillFilter.enabled;
        }
        if ((i & 16) != 0) {
            bool2 = skillFilter.hasSkillMd;
        }
        if ((i & 32) != 0) {
            l = skillFilter.modifiedOnOrAfterMs;
        }
        Boolean bool3 = bool2;
        Long l5 = l;
        return skillFilter.copy(set, set2, set3, bool, bool3, l5);
    }

    public final Set<InstallSource> component1() {
        return this.sources;
    }

    public final Set<String> component2() {
        return this.tagsAny;
    }

    public final Set<String> component3() {
        return this.tagsAll;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getHasSkillMd() {
        return this.hasSkillMd;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getModifiedOnOrAfterMs() {
        return this.modifiedOnOrAfterMs;
    }

    public final SkillFilter copy(Set<? extends InstallSource> sources, Set<String> tagsAny, Set<String> tagsAll, Boolean enabled, Boolean hasSkillMd, Long modifiedOnOrAfterMs) {
        return new SkillFilter(sources, tagsAny, tagsAll, enabled, hasSkillMd, modifiedOnOrAfterMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillFilter)) {
            return false;
        }
        SkillFilter skillFilter = (SkillFilter) other;
        return k.b(this.sources, skillFilter.sources) && k.b(this.tagsAny, skillFilter.tagsAny) && k.b(this.tagsAll, skillFilter.tagsAll) && k.b(this.enabled, skillFilter.enabled) && k.b(this.hasSkillMd, skillFilter.hasSkillMd) && k.b(this.modifiedOnOrAfterMs, skillFilter.modifiedOnOrAfterMs);
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Boolean getHasSkillMd() {
        return this.hasSkillMd;
    }

    public final Long getModifiedOnOrAfterMs() {
        return this.modifiedOnOrAfterMs;
    }

    public final Set<InstallSource> getSources() {
        return this.sources;
    }

    public final Set<String> getTagsAll() {
        return this.tagsAll;
    }

    public final Set<String> getTagsAny() {
        return this.tagsAny;
    }

    public int hashCode() {
        Set<InstallSource> set = this.sources;
        int iHashCode = (set == null ? 0 : set.hashCode()) * 31;
        Set<String> set2 = this.tagsAny;
        int iHashCode2 = (iHashCode + (set2 == null ? 0 : set2.hashCode())) * 31;
        Set<String> set3 = this.tagsAll;
        int iHashCode3 = (iHashCode2 + (set3 == null ? 0 : set3.hashCode())) * 31;
        Boolean bool = this.enabled;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.hasSkillMd;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l = this.modifiedOnOrAfterMs;
        return iHashCode5 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "SkillFilter(sources=" + this.sources + ", tagsAny=" + this.tagsAny + ", tagsAll=" + this.tagsAll + ", enabled=" + this.enabled + ", hasSkillMd=" + this.hasSkillMd + ", modifiedOnOrAfterMs=" + this.modifiedOnOrAfterMs + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkillFilter(Set<? extends InstallSource> set, Set<String> set2, Set<String> set3, Boolean bool, Boolean bool2, Long l) {
        this.sources = set;
        this.tagsAny = set2;
        this.tagsAll = set3;
        this.enabled = bool;
        this.hasSkillMd = bool2;
        this.modifiedOnOrAfterMs = l;
    }

    public /* synthetic */ SkillFilter(Set set, Set set2, Set set3, Boolean bool, Boolean bool2, Long l, int i, e eVar) {
        this((i & 1) != 0 ? null : set, (i & 2) != 0 ? null : set2, (i & 4) != 0 ? null : set3, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? null : l);
    }
}

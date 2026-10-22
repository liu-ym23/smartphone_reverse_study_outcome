package com.uxsense.ruleTrigger;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/uxsense/ruleTrigger/VersionedRules;", "", "version", "", "updatedAt", "", "rules", "", "Lcom/uxsense/ruleTrigger/TriggerRule;", AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/util/List;)V", "getVersion", "()I", "getUpdatedAt", "()Ljava/lang/String;", "getRules", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VersionedRules {
    private final List<TriggerRule> rules;
    private final String updatedAt;
    private final int version;

    public VersionedRules() {
        this(0, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VersionedRules copy$default(VersionedRules versionedRules, int i, String str, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = versionedRules.version;
        }
        if ((i6 & 2) != 0) {
            str = versionedRules.updatedAt;
        }
        if ((i6 & 4) != 0) {
            list = versionedRules.rules;
        }
        return versionedRules.copy(i, str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<TriggerRule> component3() {
        return this.rules;
    }

    public final VersionedRules copy(int version, String updatedAt, List<? extends TriggerRule> rules) {
        k.f(rules, "rules");
        return new VersionedRules(version, updatedAt, rules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VersionedRules)) {
            return false;
        }
        VersionedRules versionedRules = (VersionedRules) other;
        return this.version == versionedRules.version && k.b(this.updatedAt, versionedRules.updatedAt) && k.b(this.rules, versionedRules.rules);
    }

    public final List<TriggerRule> getRules() {
        return this.rules;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.version) * 31;
        String str = this.updatedAt;
        return this.rules.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VersionedRules(version=");
        sb.append(this.version);
        sb.append(", updatedAt=");
        sb.append(this.updatedAt);
        sb.append(", rules=");
        return B7.a.r(sb, this.rules, ')');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VersionedRules(int i, String str, List<? extends TriggerRule> rules) {
        k.f(rules, "rules");
        this.version = i;
        this.updatedAt = str;
        this.rules = rules;
    }

    public VersionedRules(int i, String str, List list, int i6, kotlin.jvm.internal.e eVar) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? null : str, (i6 & 4) != 0 ? EmptyList.f4893a : list);
    }
}

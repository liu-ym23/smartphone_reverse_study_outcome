package com.uxsense.core.pattern;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.core.model.ViewTrigger;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BK\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u001b\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003HÆ\u0003JQ\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00032\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/uxsense/core/pattern/ChildMatchResult;", "", "nodes", "", "", "Lcom/uxsense/core/base/parse/KViewNode;", "valueSources", "Lcom/uxsense/core/pattern/ValueSource;", "triggers", "", "Lcom/uxsense/core/model/ViewTrigger;", AppAgent.CONSTRUCT, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getNodes", "()Ljava/util/Map;", "getValueSources", "getTriggers", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final /* data */ class ChildMatchResult {
    private final Map<String, KViewNode> nodes;
    private final Map<String, List<ViewTrigger>> triggers;
    private final Map<String, ValueSource> valueSources;

    /* JADX WARN: Multi-variable type inference failed */
    public ChildMatchResult(Map<String, KViewNode> nodes, Map<String, ? extends ValueSource> valueSources, Map<String, ? extends List<? extends ViewTrigger>> triggers) {
        k.f(nodes, "nodes");
        k.f(valueSources, "valueSources");
        k.f(triggers, "triggers");
        this.nodes = nodes;
        this.valueSources = valueSources;
        this.triggers = triggers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChildMatchResult copy$default(ChildMatchResult childMatchResult, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = childMatchResult.nodes;
        }
        if ((i & 2) != 0) {
            map2 = childMatchResult.valueSources;
        }
        if ((i & 4) != 0) {
            map3 = childMatchResult.triggers;
        }
        return childMatchResult.copy(map, map2, map3);
    }

    public final Map<String, KViewNode> component1() {
        return this.nodes;
    }

    public final Map<String, ValueSource> component2() {
        return this.valueSources;
    }

    public final Map<String, List<ViewTrigger>> component3() {
        return this.triggers;
    }

    public final ChildMatchResult copy(Map<String, KViewNode> nodes, Map<String, ? extends ValueSource> valueSources, Map<String, ? extends List<? extends ViewTrigger>> triggers) {
        k.f(nodes, "nodes");
        k.f(valueSources, "valueSources");
        k.f(triggers, "triggers");
        return new ChildMatchResult(nodes, valueSources, triggers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChildMatchResult)) {
            return false;
        }
        ChildMatchResult childMatchResult = (ChildMatchResult) other;
        return k.b(this.nodes, childMatchResult.nodes) && k.b(this.valueSources, childMatchResult.valueSources) && k.b(this.triggers, childMatchResult.triggers);
    }

    public final Map<String, KViewNode> getNodes() {
        return this.nodes;
    }

    public final Map<String, List<ViewTrigger>> getTriggers() {
        return this.triggers;
    }

    public final Map<String, ValueSource> getValueSources() {
        return this.valueSources;
    }

    public int hashCode() {
        return this.triggers.hashCode() + androidx.appfunctions.metadata.a.f(this.valueSources, this.nodes.hashCode() * 31, 31);
    }

    public String toString() {
        return "ChildMatchResult(nodes=" + this.nodes + ", valueSources=" + this.valueSources + ", triggers=" + this.triggers + ')';
    }

    public /* synthetic */ ChildMatchResult(Map map, Map map2, Map map3, int i, e eVar) {
        this(map, map2, (i & 4) != 0 ? kotlin.collections.a.M() : map3);
    }
}

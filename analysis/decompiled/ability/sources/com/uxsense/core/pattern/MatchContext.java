package com.uxsense.core.pattern;

import S7.k;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.base.parse.KViewNode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0006J!\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00032\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R)\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/uxsense/core/pattern/MatchContext;", "", "customPredicates", "", "", "Lkotlin/Function1;", "Lcom/uxsense/core/base/parse/KViewNode;", "", "fuzzyMatching", "maxDepth", "", "parentNode", AppAgent.CONSTRUCT, "(Ljava/util/Map;ZILcom/uxsense/core/base/parse/KViewNode;)V", "getCustomPredicates", "()Ljava/util/Map;", "getFuzzyMatching", "()Z", "getMaxDepth", "()I", "getParentNode", "()Lcom/uxsense/core/base/parse/KViewNode;", "withParentNode", "node", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MatchContext {
    private final Map<String, k> customPredicates;
    private final boolean fuzzyMatching;
    private final int maxDepth;
    private final KViewNode parentNode;

    public MatchContext() {
        this(null, false, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MatchContext copy$default(MatchContext matchContext, Map map, boolean z10, int i, KViewNode kViewNode, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            map = matchContext.customPredicates;
        }
        if ((i6 & 2) != 0) {
            z10 = matchContext.fuzzyMatching;
        }
        if ((i6 & 4) != 0) {
            i = matchContext.maxDepth;
        }
        if ((i6 & 8) != 0) {
            kViewNode = matchContext.parentNode;
        }
        return matchContext.copy(map, z10, i, kViewNode);
    }

    public final Map<String, k> component1() {
        return this.customPredicates;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getFuzzyMatching() {
        return this.fuzzyMatching;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxDepth() {
        return this.maxDepth;
    }

    /* renamed from: component4, reason: from getter */
    public final KViewNode getParentNode() {
        return this.parentNode;
    }

    public final MatchContext copy(Map<String, ? extends k> customPredicates, boolean fuzzyMatching, int maxDepth, KViewNode parentNode) {
        kotlin.jvm.internal.k.f(customPredicates, "customPredicates");
        return new MatchContext(customPredicates, fuzzyMatching, maxDepth, parentNode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchContext)) {
            return false;
        }
        MatchContext matchContext = (MatchContext) other;
        return kotlin.jvm.internal.k.b(this.customPredicates, matchContext.customPredicates) && this.fuzzyMatching == matchContext.fuzzyMatching && this.maxDepth == matchContext.maxDepth && kotlin.jvm.internal.k.b(this.parentNode, matchContext.parentNode);
    }

    public final Map<String, k> getCustomPredicates() {
        return this.customPredicates;
    }

    public final boolean getFuzzyMatching() {
        return this.fuzzyMatching;
    }

    public final int getMaxDepth() {
        return this.maxDepth;
    }

    public final KViewNode getParentNode() {
        return this.parentNode;
    }

    public int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.maxDepth, androidx.appfunctions.metadata.a.d(this.customPredicates.hashCode() * 31, 31, this.fuzzyMatching), 31);
        KViewNode kViewNode = this.parentNode;
        return iA + (kViewNode == null ? 0 : kViewNode.hashCode());
    }

    public String toString() {
        return "MatchContext(customPredicates=" + this.customPredicates + ", fuzzyMatching=" + this.fuzzyMatching + ", maxDepth=" + this.maxDepth + ", parentNode=" + this.parentNode + ')';
    }

    public final MatchContext withParentNode(KViewNode node) {
        kotlin.jvm.internal.k.f(node, "node");
        return copy$default(this, null, false, 0, node, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MatchContext(Map<String, ? extends k> customPredicates, boolean z10, int i, KViewNode kViewNode) {
        kotlin.jvm.internal.k.f(customPredicates, "customPredicates");
        this.customPredicates = customPredicates;
        this.fuzzyMatching = z10;
        this.maxDepth = i;
        this.parentNode = kViewNode;
    }

    public /* synthetic */ MatchContext(Map map, boolean z10, int i, KViewNode kViewNode, int i6, e eVar) {
        this((i6 & 1) != 0 ? kotlin.collections.a.M() : map, (i6 & 2) != 0 ? false : z10, (i6 & 4) != 0 ? -1 : i, (i6 & 8) != 0 ? null : kViewNode);
    }
}

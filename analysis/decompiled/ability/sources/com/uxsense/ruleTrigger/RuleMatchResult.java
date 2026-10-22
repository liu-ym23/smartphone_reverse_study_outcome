package com.uxsense.ruleTrigger;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.pattern.PatternMatchResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/uxsense/ruleTrigger/RuleMatchResult;", "", "rule", "Lcom/uxsense/ruleTrigger/TriggerRule;", "matchResults", "", "Lcom/uxsense/core/pattern/PatternMatchResult;", "matchCount", "", AppAgent.CONSTRUCT, "(Lcom/uxsense/ruleTrigger/TriggerRule;Ljava/util/List;I)V", "getRule", "()Lcom/uxsense/ruleTrigger/TriggerRule;", "getMatchResults", "()Ljava/util/List;", "getMatchCount", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RuleMatchResult {
    private final int matchCount;
    private final List<PatternMatchResult> matchResults;
    private final TriggerRule rule;

    public RuleMatchResult(TriggerRule rule, List<PatternMatchResult> matchResults, int i) {
        k.f(rule, "rule");
        k.f(matchResults, "matchResults");
        this.rule = rule;
        this.matchResults = matchResults;
        this.matchCount = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RuleMatchResult copy$default(RuleMatchResult ruleMatchResult, TriggerRule triggerRule, List list, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            triggerRule = ruleMatchResult.rule;
        }
        if ((i6 & 2) != 0) {
            list = ruleMatchResult.matchResults;
        }
        if ((i6 & 4) != 0) {
            i = ruleMatchResult.matchCount;
        }
        return ruleMatchResult.copy(triggerRule, list, i);
    }

    /* renamed from: component1, reason: from getter */
    public final TriggerRule getRule() {
        return this.rule;
    }

    public final List<PatternMatchResult> component2() {
        return this.matchResults;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMatchCount() {
        return this.matchCount;
    }

    public final RuleMatchResult copy(TriggerRule rule, List<PatternMatchResult> matchResults, int matchCount) {
        k.f(rule, "rule");
        k.f(matchResults, "matchResults");
        return new RuleMatchResult(rule, matchResults, matchCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RuleMatchResult)) {
            return false;
        }
        RuleMatchResult ruleMatchResult = (RuleMatchResult) other;
        return k.b(this.rule, ruleMatchResult.rule) && k.b(this.matchResults, ruleMatchResult.matchResults) && this.matchCount == ruleMatchResult.matchCount;
    }

    public final int getMatchCount() {
        return this.matchCount;
    }

    public final List<PatternMatchResult> getMatchResults() {
        return this.matchResults;
    }

    public final TriggerRule getRule() {
        return this.rule;
    }

    public int hashCode() {
        return Integer.hashCode(this.matchCount) + androidx.appfunctions.metadata.a.e(this.matchResults, this.rule.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RuleMatchResult(rule=");
        sb.append(this.rule);
        sb.append(", matchResults=");
        sb.append(this.matchResults);
        sb.append(", matchCount=");
        return B7.a.o(sb, this.matchCount, ')');
    }
}

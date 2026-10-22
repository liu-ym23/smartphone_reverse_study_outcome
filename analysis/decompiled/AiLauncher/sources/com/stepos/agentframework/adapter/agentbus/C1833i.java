package com.stepos.agentframework.adapter.agentbus;

import Z8.C1172u;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/i;", "", "<init>", "()V", "", "streaming", "", "livenessState", "lifecyclePhase", C1833i.FALLBACK_FINISH_REASON, Const.INTENT_KEY_APIKEY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "Lcom/stepos/agentframework/adapter/agentbus/i$a;", "RULES", "Ljava/util/List;", "FALLBACK_FINISH_REASON", "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1833i {
    private static final String FALLBACK_FINISH_REASON = "error";
    public static final C1833i INSTANCE = new C1833i();
    private static final List<Rule> RULES = C1172u.e(new Rule("content_filter", "content_filter"));

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/i$a;", "", "", "keyword", "finishReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.agentbus.i$a, reason: from toString */
    public static final /* data */ class Rule {
        private final String finishReason;
        private final String keyword;

        public Rule(String keyword, String finishReason) {
            kotlin.jvm.internal.p.i(keyword, "keyword");
            kotlin.jvm.internal.p.i(finishReason, "finishReason");
            this.keyword = keyword;
            this.finishReason = finishReason;
        }

        /* renamed from: a, reason: from getter */
        public final String getFinishReason() {
            return this.finishReason;
        }

        /* renamed from: b, reason: from getter */
        public final String getKeyword() {
            return this.keyword;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rule)) {
                return false;
            }
            Rule rule = (Rule) other;
            return kotlin.jvm.internal.p.d(this.keyword, rule.keyword) && kotlin.jvm.internal.p.d(this.finishReason, rule.finishReason);
        }

        public int hashCode() {
            return (this.keyword.hashCode() * 31) + this.finishReason.hashCode();
        }

        public String toString() {
            return "Rule(keyword=" + this.keyword + ", finishReason=" + this.finishReason + ")";
        }
    }

    public final String a(boolean streaming, String livenessState, String lifecyclePhase, String error) {
        String finishReason;
        Object obj = null;
        if (streaming || !kotlin.jvm.internal.p.d(livenessState, "blocked") || !kotlin.jvm.internal.p.d(lifecyclePhase, FALLBACK_FINISH_REASON)) {
            return null;
        }
        Iterator<T> it = RULES.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Rule rule = (Rule) next;
            if (error != null && error.length() != 0 && La.H.e0(error, rule.getKeyword(), true)) {
                obj = next;
                break;
            }
        }
        Rule rule2 = (Rule) obj;
        return (rule2 == null || (finishReason = rule2.getFinishReason()) == null) ? error : finishReason;
    }
}

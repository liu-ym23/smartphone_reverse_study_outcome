package com.stepos.ailauncher.task.search;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SearchMatchedField;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/task/search/a;", "", "", "snippet", "Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;", "matchedField", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/contract/model/search/SearchMatchedField;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.search.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SessionSearchTextProjection {
    private final SearchMatchedField matchedField;
    private final String snippet;

    public SessionSearchTextProjection(String snippet, SearchMatchedField matchedField) {
        p.i(snippet, "snippet");
        p.i(matchedField, "matchedField");
        this.snippet = snippet;
        this.matchedField = matchedField;
    }

    /* renamed from: a, reason: from getter */
    public final SearchMatchedField getMatchedField() {
        return this.matchedField;
    }

    /* renamed from: b, reason: from getter */
    public final String getSnippet() {
        return this.snippet;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionSearchTextProjection)) {
            return false;
        }
        SessionSearchTextProjection sessionSearchTextProjection = (SessionSearchTextProjection) other;
        return p.d(this.snippet, sessionSearchTextProjection.snippet) && this.matchedField == sessionSearchTextProjection.matchedField;
    }

    public int hashCode() {
        return (this.snippet.hashCode() * 31) + this.matchedField.hashCode();
    }

    public String toString() {
        return "SessionSearchTextProjection(snippet=" + this.snippet + ", matchedField=" + this.matchedField + ")";
    }
}

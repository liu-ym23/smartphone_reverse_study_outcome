package com.stepos.ailauncher.agent.skill;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/SearchSkillParams;", "Ljava/io/Serializable;", "", "keyword", "", "type", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKeyword", "I", "getType", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SearchSkillParams implements Serializable {
    private final String keyword;
    private final int type;

    public SearchSkillParams(String str, int i10) {
        this.keyword = str;
        this.type = i10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchSkillParams)) {
            return false;
        }
        SearchSkillParams searchSkillParams = (SearchSkillParams) other;
        return p.d(this.keyword, searchSkillParams.keyword) && this.type == searchSkillParams.type;
    }

    public int hashCode() {
        String str = this.keyword;
        return ((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        return "SearchSkillParams(keyword=" + this.keyword + ", type=" + this.type + ")";
    }
}

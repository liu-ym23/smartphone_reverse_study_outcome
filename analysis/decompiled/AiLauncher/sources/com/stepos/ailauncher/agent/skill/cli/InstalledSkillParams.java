package com.stepos.ailauncher.agent.skill.cli;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/cli/g;", "", "", "keyword", "", "source_type", "page_number", "page_size", "<init>", "(Ljava/lang/String;III)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKeyword", "I", "getSource_type", "getPage_number", "getPage_size", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.skill.cli.g, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class InstalledSkillParams {
    private final String keyword;
    private final int page_number;
    private final int page_size;
    private final int source_type;

    public InstalledSkillParams(String str, int i10, int i11, int i12) {
        this.keyword = str;
        this.source_type = i10;
        this.page_number = i11;
        this.page_size = i12;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstalledSkillParams)) {
            return false;
        }
        InstalledSkillParams installedSkillParams = (InstalledSkillParams) other;
        return p.d(this.keyword, installedSkillParams.keyword) && this.source_type == installedSkillParams.source_type && this.page_number == installedSkillParams.page_number && this.page_size == installedSkillParams.page_size;
    }

    public int hashCode() {
        String str = this.keyword;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.source_type)) * 31) + Integer.hashCode(this.page_number)) * 31) + Integer.hashCode(this.page_size);
    }

    public String toString() {
        return "InstalledSkillParams(keyword=" + this.keyword + ", source_type=" + this.source_type + ", page_number=" + this.page_number + ", page_size=" + this.page_size + ")";
    }
}

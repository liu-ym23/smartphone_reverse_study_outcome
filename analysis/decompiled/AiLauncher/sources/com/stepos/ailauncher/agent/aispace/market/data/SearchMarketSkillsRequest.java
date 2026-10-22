package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/A;", "", "", "keyword", "", "sourceType", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKeyword", "I", "getSourceType", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.A, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SearchMarketSkillsRequest {

    @SerializedName("keyword")
    private final String keyword;

    @SerializedName("source_type")
    private final int sourceType;

    public SearchMarketSkillsRequest(String keyword, int i10) {
        kotlin.jvm.internal.p.i(keyword, "keyword");
        this.keyword = keyword;
        this.sourceType = i10;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchMarketSkillsRequest)) {
            return false;
        }
        SearchMarketSkillsRequest searchMarketSkillsRequest = (SearchMarketSkillsRequest) other;
        return kotlin.jvm.internal.p.d(this.keyword, searchMarketSkillsRequest.keyword) && this.sourceType == searchMarketSkillsRequest.sourceType;
    }

    public int hashCode() {
        return (this.keyword.hashCode() * 31) + Integer.hashCode(this.sourceType);
    }

    public String toString() {
        return "SearchMarketSkillsRequest(keyword=" + this.keyword + ", sourceType=" + this.sourceType + ")";
    }

    public /* synthetic */ SearchMarketSkillsRequest(String str, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(str, (i11 & 2) != 0 ? 1 : i10);
    }
}

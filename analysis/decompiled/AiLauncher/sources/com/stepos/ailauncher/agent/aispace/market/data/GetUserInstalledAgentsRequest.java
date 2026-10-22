package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/u;", "", "", "page", ContentDisposition.Parameters.Size, "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPage", "getSize", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.u, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetUserInstalledAgentsRequest {

    @SerializedName("page")
    private final int page;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final int size;

    /* JADX WARN: Illegal instructions before constructor call */
    public GetUserInstalledAgentsRequest() {
        int i10 = 0;
        this(i10, i10, 3, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetUserInstalledAgentsRequest)) {
            return false;
        }
        GetUserInstalledAgentsRequest getUserInstalledAgentsRequest = (GetUserInstalledAgentsRequest) other;
        return this.page == getUserInstalledAgentsRequest.page && this.size == getUserInstalledAgentsRequest.size;
    }

    public int hashCode() {
        return (Integer.hashCode(this.page) * 31) + Integer.hashCode(this.size);
    }

    public String toString() {
        return "GetUserInstalledAgentsRequest(page=" + this.page + ", size=" + this.size + ")";
    }

    public GetUserInstalledAgentsRequest(int i10, int i11) {
        this.page = i10;
        this.size = i11;
    }

    public /* synthetic */ GetUserInstalledAgentsRequest(int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this((i12 & 1) != 0 ? 1 : i10, (i12 & 2) != 0 ? 20 : i11);
    }
}

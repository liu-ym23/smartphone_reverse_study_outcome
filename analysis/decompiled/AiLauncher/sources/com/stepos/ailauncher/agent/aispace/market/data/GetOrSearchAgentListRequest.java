package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\u000eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001c\u0010\u000eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001d\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/s;", "", "", "keyword", "", "page", ContentDisposition.Parameters.Size, "testing", "scanSource", "scanType", "assetId", "<init>", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKeyword", "I", "getPage", "getSize", "getTesting", "getScanSource", "getScanType", "getAssetId", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.s, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetOrSearchAgentListRequest {

    @SerializedName("asset_id")
    private final String assetId;

    @SerializedName("keyword")
    private final String keyword;

    @SerializedName("page")
    private final int page;

    @SerializedName("scan_source")
    private final String scanSource;

    @SerializedName("scan_type")
    private final String scanType;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final int size;

    @SerializedName("testing")
    private final int testing;

    public GetOrSearchAgentListRequest() {
        this(null, 0, 0, 0, null, null, null, 127, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetOrSearchAgentListRequest)) {
            return false;
        }
        GetOrSearchAgentListRequest getOrSearchAgentListRequest = (GetOrSearchAgentListRequest) other;
        return kotlin.jvm.internal.p.d(this.keyword, getOrSearchAgentListRequest.keyword) && this.page == getOrSearchAgentListRequest.page && this.size == getOrSearchAgentListRequest.size && this.testing == getOrSearchAgentListRequest.testing && kotlin.jvm.internal.p.d(this.scanSource, getOrSearchAgentListRequest.scanSource) && kotlin.jvm.internal.p.d(this.scanType, getOrSearchAgentListRequest.scanType) && kotlin.jvm.internal.p.d(this.assetId, getOrSearchAgentListRequest.assetId);
    }

    public int hashCode() {
        int iHashCode = ((((((this.keyword.hashCode() * 31) + Integer.hashCode(this.page)) * 31) + Integer.hashCode(this.size)) * 31) + Integer.hashCode(this.testing)) * 31;
        String str = this.scanSource;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scanType;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.assetId;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "GetOrSearchAgentListRequest(keyword=" + this.keyword + ", page=" + this.page + ", size=" + this.size + ", testing=" + this.testing + ", scanSource=" + this.scanSource + ", scanType=" + this.scanType + ", assetId=" + this.assetId + ")";
    }

    public GetOrSearchAgentListRequest(String keyword, int i10, int i11, int i12, String str, String str2, String str3) {
        kotlin.jvm.internal.p.i(keyword, "keyword");
        this.keyword = keyword;
        this.page = i10;
        this.size = i11;
        this.testing = i12;
        this.scanSource = str;
        this.scanType = str2;
        this.assetId = str3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GetOrSearchAgentListRequest(java.lang.String r2, int r3, int r4, int r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.i r10) {
        /*
            r1 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r10 = r9 & 2
            if (r10 == 0) goto Lb
            r3 = 1
        Lb:
            r10 = r9 & 4
            if (r10 == 0) goto L11
            r4 = 20
        L11:
            r10 = r9 & 8
            if (r10 == 0) goto L16
            r5 = 0
        L16:
            r10 = r9 & 16
            r0 = 0
            if (r10 == 0) goto L1c
            r6 = r0
        L1c:
            r10 = r9 & 32
            if (r10 == 0) goto L21
            r7 = r0
        L21:
            r9 = r9 & 64
            if (r9 == 0) goto L2e
            r10 = r0
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L36
        L2e:
            r10 = r8
            r9 = r7
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L36:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.GetOrSearchAgentListRequest.<init>(java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}

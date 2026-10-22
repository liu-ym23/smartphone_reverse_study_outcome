package com.stepos.ailauncher.agent.aispace.market.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u001a\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/o;", "", "", "testing", "pageNumber", "pageSize", "", "keyword", "appType", "<init>", "(IIILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTesting", "getPageNumber", "getPageSize", "Ljava/lang/String;", "getKeyword", "getAppType", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.o, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetAppListRequest {

    @SerializedName("app_type")
    private final String appType;

    @SerializedName("keyword")
    private final String keyword;

    @SerializedName("page_number")
    private final int pageNumber;

    @SerializedName("page_size")
    private final int pageSize;

    @SerializedName("testing")
    private final int testing;

    public GetAppListRequest() {
        this(0, 0, 0, null, null, 31, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetAppListRequest)) {
            return false;
        }
        GetAppListRequest getAppListRequest = (GetAppListRequest) other;
        return this.testing == getAppListRequest.testing && this.pageNumber == getAppListRequest.pageNumber && this.pageSize == getAppListRequest.pageSize && kotlin.jvm.internal.p.d(this.keyword, getAppListRequest.keyword) && kotlin.jvm.internal.p.d(this.appType, getAppListRequest.appType);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.testing) * 31) + Integer.hashCode(this.pageNumber)) * 31) + Integer.hashCode(this.pageSize)) * 31) + this.keyword.hashCode()) * 31) + this.appType.hashCode();
    }

    public String toString() {
        return "GetAppListRequest(testing=" + this.testing + ", pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ", keyword=" + this.keyword + ", appType=" + this.appType + ")";
    }

    public GetAppListRequest(int i10, int i11, int i12, String keyword, String appType) {
        kotlin.jvm.internal.p.i(keyword, "keyword");
        kotlin.jvm.internal.p.i(appType, "appType");
        this.testing = i10;
        this.pageNumber = i11;
        this.pageSize = i12;
        this.keyword = keyword;
        this.appType = appType;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ GetAppListRequest(int r2, int r3, int r4, java.lang.String r5, java.lang.String r6, int r7, kotlin.jvm.internal.i r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L5
            r2 = 0
        L5:
            r8 = r7 & 2
            if (r8 == 0) goto La
            r3 = 1
        La:
            r8 = r7 & 4
            if (r8 == 0) goto L10
            r4 = 20
        L10:
            r8 = r7 & 8
            java.lang.String r0 = ""
            if (r8 == 0) goto L17
            r5 = r0
        L17:
            r7 = r7 & 16
            if (r7 == 0) goto L22
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L28
        L22:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L28:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.data.GetAppListRequest.<init>(int, int, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}

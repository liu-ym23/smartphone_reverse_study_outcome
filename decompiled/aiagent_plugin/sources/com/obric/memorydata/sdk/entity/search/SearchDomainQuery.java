package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GlobalIntentSearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SearchDomainQuery implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("domain")
    private final String domain;

    @SerializedName(DownloadConstants.QUERY_KEY)
    private final String query;

    /* JADX INFO: compiled from: GlobalIntentSearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<SearchDomainQuery> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchDomainQuery createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchDomainQuery[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchDomainQuery createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new SearchDomainQuery(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchDomainQuery[] newArray(int r1) {
            return new SearchDomainQuery[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchDomainQuery() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SearchDomainQuery copy$default(SearchDomainQuery r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.domain;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.query;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.domain;
    }

    public final String component2() {
        return this.query;
    }

    public final SearchDomainQuery copy(String r1, String r2) {
        o.e(r1, "domain");
        o.e(r2, DownloadConstants.QUERY_KEY);
        return new SearchDomainQuery(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SearchDomainQuery.class) == true) goto L8;
        return false;
    L8:
        SearchDomainQuery r6 = (SearchDomainQuery) ZeusTransformUtils.preCheckCast(r5, SearchDomainQuery.class, "com.obric.aiagent.plugin");
        if (o.a(this.domain, r6.domain) == true) goto L12;
        return false;
    L12:
        if (o.a(this.query, r6.query) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.domain.hashCode() * 31) + this.query.hashCode();
    }

    public String toString() {
        return "SearchDomainQuery(domain=" + this.domain + ", query=" + this.query + ')';
    }

    public SearchDomainQuery(String r2, String r3) {
        o.e(r2, "domain");
        o.e(r3, DownloadConstants.QUERY_KEY);
        this.domain = r2;
        this.query = r3;
    }

    public /* synthetic */ SearchDomainQuery(String r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getQuery() {
        return this.query;
    }

    public SearchDomainQuery(Parcel r3) {
        o.e(r3, "parcel");
        String r0 = r3.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = r3.readString();
        if (r4 == null) goto L9;
        r1 = r4;
    L9:
        this(r0, r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.domain);
        r1.writeString(this.query);
    }
}

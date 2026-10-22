package com.obric.memorydata.sdk.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: RecommendComplexQuery.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RecommendComplexQuery implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("meta")
    private final String meta;

    @SerializedName(DownloadConstants.QUERY_KEY)
    private final String query;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("sourceData")
    private final String sourceData;

    /* JADX INFO: compiled from: RecommendComplexQuery.kt */
    public static final class CREATOR implements Parcelable.Creator<RecommendComplexQuery> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecommendComplexQuery createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecommendComplexQuery[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecommendComplexQuery createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new RecommendComplexQuery(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecommendComplexQuery[] newArray(int r1) {
            return new RecommendComplexQuery[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ RecommendComplexQuery copy$default(RecommendComplexQuery r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.query;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.reason;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sourceData;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.meta;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.reason;
    }

    public final String component3() {
        return this.sourceData;
    }

    public final String component4() {
        return this.meta;
    }

    public final RecommendComplexQuery copy(String r1, String r2, String r3, String r4) {
        o.e(r1, DownloadConstants.QUERY_KEY);
        o.e(r2, "reason");
        o.e(r3, "sourceData");
        o.e(r4, "meta");
        return new RecommendComplexQuery(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RecommendComplexQuery.class) == true) goto L8;
        return false;
    L8:
        RecommendComplexQuery r6 = (RecommendComplexQuery) ZeusTransformUtils.preCheckCast(r5, RecommendComplexQuery.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.reason, r6.reason) == true) goto L15;
        return false;
    L15:
        if (o.a(this.sourceData, r6.sourceData) == true) goto L18;
        return false;
    L18:
        if (o.a(this.meta, r6.meta) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.query.hashCode() * 31) + this.reason.hashCode()) * 31) + this.sourceData.hashCode()) * 31) + this.meta.hashCode();
    }

    public String toString() {
        return "RecommendComplexQuery(query=" + this.query + ", reason=" + this.reason + ", sourceData=" + this.sourceData + ", meta=" + this.meta + ')';
    }

    public RecommendComplexQuery(String r2, String r3, String r4, String r5) {
        o.e(r2, DownloadConstants.QUERY_KEY);
        o.e(r3, "reason");
        o.e(r4, "sourceData");
        o.e(r5, "meta");
        this.query = r2;
        this.reason = r3;
        this.sourceData = r4;
        this.meta = r5;
    }

    public /* synthetic */ RecommendComplexQuery(String r1, String r2, String r3, String r4, int r5, h r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = "";
    L5:
        this(r1, r2, r3, r4);
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSourceData() {
        return this.sourceData;
    }

    public final String getMeta() {
        return this.meta;
    }

    public RecommendComplexQuery(Parcel r5) {
        o.e(r5, "parcel");
        String r0 = r5.readString();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r5.readString();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r3 = r5.readString();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        String r6 = r5.readString();
        if (r6 == null) goto L15;
        r1 = r6;
    L15:
        this(r0, r2, r3, r1);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.query);
        r1.writeString(this.reason);
        r1.writeString(this.sourceData);
        r1.writeString(this.meta);
    }
}

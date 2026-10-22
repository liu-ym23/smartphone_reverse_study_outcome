package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SearchResponse implements Parcelable {
    public static final CREATOR CREATOR = null;
    private int code;
    private SearchResult data;
    private String message;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<SearchResponse> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchResponse createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchResponse[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResponse createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new SearchResponse(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResponse[] newArray(int r1) {
            return new SearchResponse[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ SearchResponse copy$default(SearchResponse r0, int r1, String r2, SearchResult r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final SearchResult component3() {
        return this.data;
    }

    public final SearchResponse copy(int r1, String r2, SearchResult r3) {
        o.e(r2, "message");
        return new SearchResponse(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SearchResponse.class) == true) goto L8;
        return false;
    L8:
        SearchResponse r6 = (SearchResponse) ZeusTransformUtils.preCheckCast(r5, SearchResponse.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        SearchResult r2 = this.data;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SearchResponse(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public SearchResponse(int r2, String r3, SearchResult r4) {
        o.e(r3, "message");
        this.code = r2;
        this.message = r3;
        this.data = r4;
    }

    public /* synthetic */ SearchResponse(int r1, String r2, SearchResult r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int r1) {
        this.code = r1;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String r2) {
        o.e(r2, "<set-?>");
        this.message = r2;
    }

    public final SearchResult getData() {
        return this.data;
    }

    public final void setData(SearchResult r1) {
        this.data = r1;
    }

    public SearchResponse(Parcel r5) {
        o.e(r5, "parcel");
        int r0 = r5.readInt();
        String r1 = r5.readString();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this(r0, r1, (SearchResult) ZeusTransformUtils.preCheckCast(r5.readParcelable(SearchResult.class.getClassLoader()), SearchResult.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeInt(this.code);
        r3.writeString(this.message);
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.data, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }
}

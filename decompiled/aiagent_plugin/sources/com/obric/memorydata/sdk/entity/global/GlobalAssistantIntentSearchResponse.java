package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: GlobalAssistantIntentSearchResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalAssistantIntentSearchResponse implements Parcelable {
    public static final CREATOR CREATOR = null;
    private int code;
    private GlobalAssistantSearchResponse globalSearchResponse;
    private String message;
    private SearchResponse searchResponse;

    /* JADX INFO: compiled from: GlobalAssistantIntentSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalAssistantIntentSearchResponse> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantIntentSearchResponse createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalAssistantIntentSearchResponse[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantIntentSearchResponse createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalAssistantIntentSearchResponse(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalAssistantIntentSearchResponse[] newArray(int r1) {
            return new GlobalAssistantIntentSearchResponse[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalAssistantIntentSearchResponse copy$default(GlobalAssistantIntentSearchResponse r0, int r1, String r2, SearchResponse r3, GlobalAssistantSearchResponse r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.searchResponse;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.globalSearchResponse;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final SearchResponse component3() {
        return this.searchResponse;
    }

    public final GlobalAssistantSearchResponse component4() {
        return this.globalSearchResponse;
    }

    public final GlobalAssistantIntentSearchResponse copy(int r1, String r2, SearchResponse r3, GlobalAssistantSearchResponse r4) {
        o.e(r2, "message");
        return new GlobalAssistantIntentSearchResponse(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalAssistantIntentSearchResponse.class) == true) goto L8;
        return false;
    L8:
        GlobalAssistantIntentSearchResponse r6 = (GlobalAssistantIntentSearchResponse) ZeusTransformUtils.preCheckCast(r5, GlobalAssistantIntentSearchResponse.class, "com.obric.aiagent.plugin");
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (o.a(this.searchResponse, r6.searchResponse) == true) goto L18;
        return false;
    L18:
        if (o.a(this.globalSearchResponse, r6.globalSearchResponse) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31;
        SearchResponse r1 = this.searchResponse;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        GlobalAssistantSearchResponse r5 = this.globalSearchResponse;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "GlobalAssistantIntentSearchResponse(code=" + this.code + ", message=" + this.message + ", searchResponse=" + this.searchResponse + ", globalSearchResponse=" + this.globalSearchResponse + ')';
    }

    public GlobalAssistantIntentSearchResponse(int r2, String r3, SearchResponse r4, GlobalAssistantSearchResponse r5) {
        o.e(r3, "message");
        this.code = r2;
        this.message = r3;
        this.searchResponse = r4;
        this.globalSearchResponse = r5;
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

    public final SearchResponse getSearchResponse() {
        return this.searchResponse;
    }

    public final void setSearchResponse(SearchResponse r1) {
        this.searchResponse = r1;
    }

    public final GlobalAssistantSearchResponse getGlobalSearchResponse() {
        return this.globalSearchResponse;
    }

    public final void setGlobalSearchResponse(GlobalAssistantSearchResponse r1) {
        this.globalSearchResponse = r1;
    }

    public GlobalAssistantIntentSearchResponse(Parcel r6) {
        o.e(r6, "parcel");
        int r0 = r6.readInt();
        String r1 = r6.readString();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        this(r0, r1, (SearchResponse) ZeusTransformUtils.preCheckCast(r6.readParcelable(SearchResponse.class.getClassLoader()), SearchResponse.class, "com.obric.aiagent.plugin"), (GlobalAssistantSearchResponse) ZeusTransformUtils.preCheckCast(r6.readParcelable(GlobalAssistantSearchResponse.class.getClassLoader()), GlobalAssistantSearchResponse.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "parcel");
        r4.writeInt(this.code);
        r4.writeString(this.message);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.searchResponse, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.globalSearchResponse, Parcelable.class, "com.obric.aiagent.plugin"), r5);
    }
}
